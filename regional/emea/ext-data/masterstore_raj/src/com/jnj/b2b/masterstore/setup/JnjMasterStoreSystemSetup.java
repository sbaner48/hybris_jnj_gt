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
package com.jnj.b2b.masterstore.setup;

import de.hybris.platform.commerceservices.dataimport.impl.CoreDataImportService;
import de.hybris.platform.commerceservices.dataimport.impl.SampleDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.commerceservices.setup.events.CoreDataImportedEvent;
import de.hybris.platform.commerceservices.setup.events.SampleDataImportedEvent;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import com.jnj.b2b.masterstore.constants.MasterstoreConstants;


@SystemSetup(extension = MasterstoreConstants.EXTENSIONNAME)
public class JnjMasterStoreSystemSetup extends AbstractSystemSetup implements MasterstoreConstants
{

	private CoreDataImportService coreDataImportService;
	private SampleDataImportService sampleDataImportService;

	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();

		params.add(createBooleanSystemSetupParameter(IMPORT_CORE_DATA, "Import Core Data", true));
		params.add(createBooleanSystemSetupParameter(IMPORT_SAMPLE_DATA, "Import Sample Data", true));
		params.add(createBooleanSystemSetupParameter(ACTIVATE_SOLR_CRON_JOBS, "Activate Solr Cron Jobs", false));
		params.add(createBooleanSystemSetupParameter(IMPORT_ACCESS_RIGHTS, "Import Users & Groups", false));
		params.add(createBooleanSystemSetupParameter(ACTIVATE_INTERFACE_CRON_JOBS, "Active interface Cron Jobs", false));


		return params;
	}

	@SystemSetup(type = SystemSetup.Type.ESSENTIAL, process = SystemSetup.Process.ALL)
	public void createEssentialData(final SystemSetupContext context)
	{
		importImpexFile(context, "/import/coredata/common/countries.impex");
		importImpexFile(context, "/import/coredata/common/essential-data.impex");
		//importImpexFile(context, "/import/coredata/delivery-modes.impex");
		importImpexFile(context, "/import/coredata/common/themes.impex");
		importImpexFile(context, "/import/coredata/common/unit.impex");
		//importImpexFile(context, "/import/coredata/common/configurations.impex");

		final boolean importAccessRights = getBooleanSystemSetupParameter(context, IMPORT_ACCESS_RIGHTS);
		final List<String> extensionNames = Registry.getCurrentTenant().getTenantSpecificExtensionNames();

		if (importAccessRights && extensionNames.contains("masterstore"))
		{
			importImpexFile(context, "/import/coredata/common/users.impex");
		}
		if (extensionNames.contains("mcc"))
		{
			//importImpexFile(context, "/import/coredata/common/mcc-sites-links.impex");
		}

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
		final List<ImportData> importData = new ArrayList<ImportData>();

		final ImportData masterImportData = new ImportData();
		masterImportData.setProductCatalogName(EPIC_MASTER);
		masterImportData.setContentCatalogNames(Arrays.asList(EPIC_MASTER));
		masterImportData.setStoreNames(Arrays.asList(EPIC_MASTER));
		importData.add(masterImportData);

		getCoreDataImportService().execute(this, context, importData);
		getEventService().publishEvent(new CoreDataImportedEvent(context, importData));

		getSampleDataImportService().execute(this, context, importData);
		getEventService().publishEvent(new SampleDataImportedEvent(context, importData));

	}

	@Override
	public void importImpexFile(final SystemSetupContext context, String file, final boolean errorIfMissing)
	{

		file = "/" + context.getExtensionName() + file;

		super.importImpexFile(context, file, errorIfMissing);
	}

	@Override
	public void importImpexFile(final SystemSetupContext context, String file)
	{

		file = "/" + context.getExtensionName() + file;

		super.importImpexFile(context, file);
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
