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
package com.jnj.b2b.store.setup;

import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetup.Process;
import de.hybris.platform.core.initialization.SystemSetup.Type;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import de.hybris.platform.core.initialization.SystemSetupParameterMethod;

import java.util.ArrayList;
import java.util.List;

import com.jnj.b2b.store.constants.Jnjb2bstoreConstants;


@SystemSetup(extension = Jnjb2bstoreConstants.EXTENSIONNAME)
public class JnjB2BStoreSystemSetup extends AbstractSystemSetup
{
	public static final String IMPORT_ACCESS_RIGHTS = "accessRights";

	@Override
	@SystemSetupParameterMethod
	public List<SystemSetupParameter> getInitializationOptions()
	{
		System.out.println("JnjB2BStoreSystemSetup --> getInitializationOptions is invoked");
		final List<SystemSetupParameter> params = new ArrayList<SystemSetupParameter>();
		params.add(createBooleanSystemSetupParameter(IMPORT_ACCESS_RIGHTS, "Import Users & Groups", true));


		return params;
	}

	/**
	 * This method will be called by system creator during initialization and system update. Be sure that this method can
	 * be called repeatedly.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.ESSENTIAL, process = Process.ALL)
	public void createEssentialData(final SystemSetupContext context)
	{
		System.out.println("JnjB2BStoreSystemSetup -- createEssentialData is invoked");
		importImpexFile(context, "/jnjb2bstore/import/coredata/common/essential-data.impex");
		importImpexFile(context, "/jnjb2bstore/import/themes.impex");
		importImpexFile(context, "/jnjb2bstore/import/common/user-groups.impex");
	}


	/**
	 * This method will be called during the system initialization.
	 *
	 * @param context
	 *           the context provides the selected parameters and values
	 */
	@SystemSetup(type = Type.PROJECT, process = Process.ALL)
	public void createProjectData(final SystemSetupContext context)
	{
		System.out.println("JnjB2BStoreSystemSetup -- createProjectData is invoked");

		final boolean importAccessRights = getBooleanSystemSetupParameter(context, IMPORT_ACCESS_RIGHTS);

		final List<String> extensionNames = getExtensionNames();

		if (importAccessRights && extensionNames.contains("cmscockpit"))
		{
			importImpexFile(context, "/jnjb2bstore/import/cockpits/cmscockpit/cmscockpit-users.impex");
			importImpexFile(context, "/jnjb2bstore/import/cockpits/cmscockpit/cmscockpit-access-rights.impex");
		}

		if (importAccessRights && extensionNames.contains("btgcockpit"))
		{
			importImpexFile(context, "/jnjb2bstore/import/cockpits/cmscockpit/btgcockpit-users.impex");
			importImpexFile(context, "/jnjb2bstore/import/cockpits/cmscockpit/btgcockpit-access-rights.impex");
		}

		if (importAccessRights && extensionNames.contains("productcockpit"))
		{
			importImpexFile(context, "/jnjb2bstore/import/cockpits/productcockpit/productcockpit-users.impex");
			importImpexFile(context, "/jnjb2bstore/import/cockpits/productcockpit/productcockpit-access-rights.impex");
			importImpexFile(context, "/jnjb2bstore/import/cockpits/productcockpit/productcockpit-constraints.impex");
		}

		if (importAccessRights && extensionNames.contains("cscockpit"))
		{
			importImpexFile(context, "/jnjb2bstore/import/cockpits/cscockpit/cscockpit-users.impex");
			importImpexFile(context, "/jnjb2bstore/import/cockpits/cscockpit/cscockpit-access-rights.impex");
		}

		if (importAccessRights && extensionNames.contains("reportcockpit"))
		{
			importImpexFile(context, "/jnjb2bstore/import/cockpits/reportcockpit/reportcockpit-users.impex");
			importImpexFile(context, "/jnjb2bstore/import/cockpits/reportcockpit/reportcockpit-access-rights.impex");
		}

		if (extensionNames.contains("mcc"))
		{
			importImpexFile(context, "/jnjb2bstore/import/common/mcc-sites-links.impex");
		}
	}


	protected List<String> getExtensionNames()
	{
		return Registry.getCurrentTenant().getTenantSpecificExtensionNames();
	}


}
