/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2014 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.jnj.b2b.mddstore.setup;

import de.hybris.platform.catalog.model.synchronization.CatalogVersionSyncCronJobModel;
import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;
import de.hybris.platform.commerceservices.dataimport.impl.SampleDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.commerceservices.setup.events.CoreDataImportedEvent;
import de.hybris.platform.commerceservices.setup.events.SampleDataImportedEvent;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.CronJobService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.jnj.b2b.mddstore.constants.MddstoreConstants;


@SystemSetup(extension = MddstoreConstants.EXTENSIONNAME)
public class JnjMddStoreSystemSetup extends AbstractSystemSetup
{
	public static final String MDD = "mdd";
	public static final String MDD_DE = "mdd-de";
	public static final String MDD_FR = "mdd-fr";
	public static final String MDD_ES = "mdd-es";

	private static final String IMPORT_CORE_DATA = "importCoreData";
	private static final String IMPORT_SAMPLE_DATA = "importSampleData";
	private static final String ACTIVATE_SOLR_CRON_JOBS = "activateSolrCronJobs";

	private static final String SYNC_CONTENT_CATALOGS = "syncContentCatalogs";
	private static final String COUNTRIES_TO_SYNC = "countriesToSync";
	private static final String SYNC_MSTR_CONT_STG_TO_MDD_CONT_STG = "Sync-MasterContentStaged->MDDContentCatalog";

	private CoreDataImportService coreDataImportService;
	private SampleDataImportService sampleDataImportService;

	@Autowired
	private CronJobService cronJobService;
	@Autowired
	private ModelService modelService;

	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		System.out.println("JnjMddStoreSystemSetup --> getInitializationOptions is invoked");
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();

		params.add(createBooleanSystemSetupParameter(IMPORT_CORE_DATA, "Import Core Data", true));
		params.add(createBooleanSystemSetupParameter(IMPORT_SAMPLE_DATA, "Import Sample Data", true));
		params.add(createBooleanSystemSetupParameter(ACTIVATE_SOLR_CRON_JOBS, "Activate Solr Cron Jobs", false));
		params.add(createBooleanSystemSetupParameter(SYNC_CONTENT_CATALOGS,
				"Synchronize Master to Country Specific Content Catalogs", true));

		final SystemSetupParameter syncContentCatalogs = new SystemSetupParameter(COUNTRIES_TO_SYNC);

		syncContentCatalogs.setLabel("Select Countries to Sync");
		syncContentCatalogs.setMultiSelect(true);
		syncContentCatalogs.addValues(new String[]
		{ MDD_DE, MDD_FR, MDD_ES });
		syncContentCatalogs.setSelected(MDD_DE);

		params.add(syncContentCatalogs);

		return params;
	}

	/**
	 * This method will be called during the system initialization.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = SystemSetup.Type.PROJECT, process = SystemSetup.Process.ALL)
	public void createProjectData(final SystemSetupContext context)
	{
		System.out.println("JnjMddStoreSystemSetup --> createProjectData is invoked");
		final List<String> countryNames = Arrays.asList(MDD_DE);
		final List<ImportData> importData = new ArrayList<ImportData>();

		final ImportData mddImportData = new ImportData();
		mddImportData.setProductCatalogName(MDD);
		mddImportData.setContentCatalogNames(countryNames);
		mddImportData.setStoreNames(countryNames);
		importData.add(mddImportData);

		getCoreDataImportService().execute(this, context, importData);
		getEventService().publishEvent(new CoreDataImportedEvent(context, importData));

		executeMasterCatalogSyncJob(context);

		getSampleDataImportService().execute(this, context, importData);
		getEventService().publishEvent(new SampleDataImportedEvent(context, importData));
	}

	private void executeMasterCatalogSyncJob(final SystemSetupContext context)
	{
		System.out.println("JnjMddStoreSystemSetup --> executeMasterCatalogSyncJob is invoked");
		final boolean syncContCatalogs = getBooleanSystemSetupParameter(context, SYNC_CONTENT_CATALOGS);

		final String[] selectedCountries = context.getParameters(MddstoreConstants.EXTENSIONNAME + "_" + COUNTRIES_TO_SYNC);


		if (syncContCatalogs)
		{

			for (final String countryName : selectedCountries)
			{

				importImpexFile(context, "/import/sampledata/contentCatalogs/" + countryName
						+ "ContentCatalog/contentCatalogSyncJob.impex", false);


				/** MasterContent to Local Country Sync */
				logInfo(context, "Executing catalogs sync job  [Sync-masterContentCatalog->" + countryName + "ContentCatalog]");
				final CronJobModel syncMasterToConsContentCronJob = cronJobService.getCronJob("Sync-masterContentCatalog->"
						+ countryName + "ContentCatalog");
				((CatalogVersionSyncCronJobModel) syncMasterToConsContentCronJob).setScheduleMedias(null);
				modelService.save(syncMasterToConsContentCronJob);
				cronJobService.performCronJob(syncMasterToConsContentCronJob, true);
				syncMasterToConsContentCronJob.getResult();
				logInfo(context, "Executed catalogs sync job  [Sync-masterContentCatalog->" + countryName
						+ "ContentCatalog] Status:- " + syncMasterToConsContentCronJob.getResult());

			}
		}

	}

	@Override
	public void importImpexFile(final SystemSetupContext context, String file, final boolean errorIfMissing)
	{

		file = "/" + context.getExtensionName() + file;

		super.importImpexFile(context, file, errorIfMissing);
	}

	public CoreDataImportService getCoreDataImportService()
	{
		return coreDataImportService;
	}

	@Required
	public void setCoreDataImportService(final CoreDataImportService coreDataImportService)
	{
		this.coreDataImportService = coreDataImportService;
	}

	public SampleDataImportService getSampleDataImportService()
	{
		return sampleDataImportService;
	}

	@Required
	public void setSampleDataImportService(final SampleDataImportService sampleDataImportService)
	{
		this.sampleDataImportService = sampleDataImportService;
	}
}
