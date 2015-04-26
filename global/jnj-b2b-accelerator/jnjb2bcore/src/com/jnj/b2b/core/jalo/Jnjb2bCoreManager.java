/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *  
 */
package com.jnj.b2b.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.jnj.b2b.core.constants.Jnjb2bCoreConstants;
import com.jnj.b2b.core.setup.CoreSystemSetup;

import org.apache.log4j.Logger;


/**
 * Don't use. User {@link CoreSystemSetup} instead.
 */
@SuppressWarnings("PMD")
public class Jnjb2bCoreManager extends GeneratedJnjb2bCoreManager
{
	@SuppressWarnings("unused")
	private static Logger LOG = Logger.getLogger(Jnjb2bCoreManager.class.getName());

	public static final Jnjb2bCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (Jnjb2bCoreManager) em.getExtension(Jnjb2bCoreConstants.EXTENSIONNAME);
	}
}
