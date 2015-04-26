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
package com.jnj.b2b.loginaddon.controllers;

/**
 */
public interface LoginaddonControllerConstants
{
	// implement here controller constants used by this extension
	String ADDON_PREFIX = "addon:/loginaddon/";

	/**
	 * Class with view name constants
	 */
	interface Views
	{

		interface Pages
		{
			interface Account
			{
				String AccountLoginPage = ADDON_PREFIX + "pages/account/accountLoginPage";
			}
		}

	}
}
