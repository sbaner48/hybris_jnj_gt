/**
 *
 */
package com.jnj.b2b.masterstore.dataimport;

import de.hybris.platform.commerceservices.dataimport.impl.SampleDataImportService;
import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.commerceservices.setup.data.ImportData;
import de.hybris.platform.core.initialization.SystemSetupContext;

import com.jnj.b2b.masterstore.constants.MasterstoreConstants;



/**
 * @author rbalasu4
 *
 */
public class JnjB2BDataImportService extends SampleDataImportService implements MasterstoreConstants
{

	@Override
	protected void importAllData(final AbstractSystemSetup systemSetup, final SystemSetupContext context,
			final ImportData importData, final boolean syncCatalogs)
	{

		super.importAllData(systemSetup, context, importData, syncCatalogs);

		/*
		 * importPrivacyPolicy(systemSetup, context); importOrderStatus(systemSetup, context);
		 * importShippingMethods(systemSetup, context); importShipmentTrackingURLs(systemSetup, context);
		 * importCronJobs(systemSetup, context);
		 */
	}

	@Override
	protected void importContentCatalog(final String extensionName, final String contentCatalogName)
	{

		super.importContentCatalog(extensionName, contentCatalogName);
		//	importMessages(extensionName, contentCatalogName);

	}

	private void importMessages(final String extensionName, final String contentCatalogName)
	{

		getSetupImpexService().importImpexFile(
				String.format("/%s/import/sampledata/contentCatalogs/%sContentCatalog/messages.impex", new Object[]
				{ extensionName, contentCatalogName }), false);
	}


	private void importPrivacyPolicy(final AbstractSystemSetup systemSetup, final SystemSetupContext context)
	{
		final boolean updatePrivacyPolicy = systemSetup.getBooleanSystemSetupParameter(context, IMPORT_PRIVACY_POLICY);

		if (updatePrivacyPolicy)
		{
			systemSetup.importImpexFile(context, "/import/sampledata/contentCatalogs/" + EPIC_MASTER
					+ "/ContentCatalog/privacy-policy.impex", false);
		}

	}

	private void importOrderStatus(final AbstractSystemSetup systemSetup, final SystemSetupContext context)
	{
		systemSetup.logInfo(context, "Begin importing impex of orderStatusMapping & orderEntryStatusMapping");

		systemSetup.importImpexFile(context, "/import/sampledata/order/orderStatusMapping.impex");
		systemSetup.importImpexFile(context, "/import/sampledata/order/orderEntryStatusMapping.impex");

		systemSetup.logInfo(context, "Done importing impex of orderStatusMapping & orderEntryStatusMapping");
	}


	private void importShippingMethods(final AbstractSystemSetup systemSetup, final SystemSetupContext context)
	{
		systemSetup.logInfo(context, "Begin importing impex of Shipping methods");
		systemSetup.importImpexFile(context, "/import/sampledata/order/shippingMethods.impex");
		systemSetup.logInfo(context, "Done importing impex of Shipping methods");
	}

	private void importShipmentTrackingURLs(final AbstractSystemSetup systemSetup, final SystemSetupContext context)
	{
		systemSetup.logInfo(context, "Begin importing impex of Shipment Tracking URLs");
		systemSetup.importImpexFile(context, "/import/sampledata/externaldata/shipmenttracking/shipmenttracking.impex");
		systemSetup.logInfo(context, "Done importing impex of Shipment Tracking URLs");
	}

	private void importCronJobs(final AbstractSystemSetup systemSetup, final SystemSetupContext context)
	{
		final boolean active = systemSetup.getBooleanSystemSetupParameter(context, ACTIVATE_INTERFACE_CRON_JOBS);
		systemSetup.logInfo(context, "Begin importing CronJobs [" + "Jnjb2bnastore" + "]");
		systemSetup.importImpexFile(context, "/import/coredata/common/JnjCronJobs.impex");
		if (active)
		{
			systemSetup.importImpexFile(context, "/import/coredata/common/JnjCronJobsATriger.impex", true);
		}
		else
		{
			systemSetup.importImpexFile(context, "/import/coredata/common/JnjCronJobsDTriger.impex", true);
		}

	}

}
