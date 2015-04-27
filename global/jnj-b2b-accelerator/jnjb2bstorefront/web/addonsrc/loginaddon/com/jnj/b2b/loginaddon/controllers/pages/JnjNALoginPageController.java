/**
 * This code contains copyright information which is the proprietary property
 * of JNJ Companies Ltd. No part of this code may be reproduced, stored or
 * transmitted in any form without the prior written permission of JNJ Companies Ltd.
 * Copyright (C) JNJ Companies Ltd 2013
 * All rights reserved.
 */
package com.jnj.b2b.loginaddon.controllers.pages;

import de.hybris.platform.b2bacceleratorservices.company.B2BCommerceB2BUserGroupService;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.servicelayer.services.CMSSiteService;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.Config;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jnj.b2b.loginaddon.constants.LoginaddonConstants;
import com.jnj.b2b.loginaddon.constants.LoginaddonConstants.Logging;
import com.jnj.b2b.loginaddon.controllers.LoginaddonControllerConstants;
import com.jnj.b2b.storefront.controllers.pages.LoginPageController;



/**
 * Login Controller. Handles login account flow.
 * 
 * @author Accenture
 * @version 1.0
 */

public class JnjNALoginPageController extends LoginPageController
{
	/**  */
	private static final String LOGOUT = "Logout";
	private static final String ATTEMPTS_EXCEEDED = "attemptsExceeded";
	@Resource(name = "httpSessionRequestCache")
	private HttpSessionRequestCache httpSessionRequestCache;

	/** The session service **/
	@Autowired
	private SessionService sessionService;

	@Autowired
	private B2BCommerceB2BUserGroupService b2BCommerceB2BUserGroupService;
	/** The user service **/
	@Autowired
	private UserService userService;

	@Autowired
	private CMSSiteService cmsSiteService;

	/** The Constant LOGIN. */
	private static final String LOGIN = "Login";

	/** Getting the LOGGER. */
	private static final Logger LOG = Logger.getLogger(JnjNALoginPageController.class);

	/** Login warning limit **/
	protected static final String LOGIN_WARN_LIMIT = Config.getParameter(LoginaddonConstants.Login.LOGIN_ERROR_LIMIT);

	@Override
	public void setHttpSessionRequestCache(final HttpSessionRequestCache accHttpSessionRequestCache)
	{
		this.httpSessionRequestCache = accHttpSessionRequestCache;
	}

	/**
	 * 
	 * This method is used for fetching the login page by setting essential data in the model
	 * 
	 * @param referer
	 * @param loginError
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return view
	 * @throws CMSItemNotFoundException
	 */

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public String doLogin(@RequestHeader(value = "referer", required = false) final String referer,
			@RequestParam(value = "error", defaultValue = "false") final boolean loginError, final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final HttpSession session)
			throws CMSItemNotFoundException
	{
		System.out.println("My Login controler");
		logMethodStartOrEnd(LOGIN, "doLogin()", Logging.BEGIN_OF_METHOD);

		/** Checking if the attempts exceeded and the account is locked, then setting the message key for the error **/
		if (null != sessionService.getAttribute(ATTEMPTS_EXCEEDED))
		{
			model.addAttribute(ATTEMPTS_EXCEEDED, Boolean.TRUE);
			sessionService.removeAttribute(ATTEMPTS_EXCEEDED);
		}

		if (!loginError)
		{
			storeReferer(referer, request, response);
		}
		/** Checking for sign-out parameter in the request **/
		if (null != request.getParameter(LoginaddonConstants.Login.LOGOUT_PARAM))
		{
			logDebugMessage(LOGIN, "doLogin()", "Logout Successful!");
			/** Setting the sign-out parameter in the model **/
			model.addAttribute(LoginaddonConstants.Login.LOGOUT_PARAM, Boolean.TRUE);
		}

		/** Checking for session-availability parameter in the request (this is required only in case of PCM) **/
		if (null != request.getParameter(LoginaddonConstants.Login.SESSION_EXPIRED_PARAM))
		{
			logDebugMessage(LOGIN, "doLogin()", "User's session expired");
			/** Setting the sign-out parameter in the model **/
			model.addAttribute(LoginaddonConstants.Login.SESSION_EXPIRED_PARAM, Boolean.TRUE);
		}

		/** Checking for expired password parameter in the request **/
		if (null != request.getParameter(LoginaddonConstants.Login.EXPIRED_PASSWORD_PARAM))
		{
			logDebugMessage(LOGIN, "doLogin()", "User's Password is expired!");
			/** Setting the expired password parameter in the model **/
			model.addAttribute(LoginaddonConstants.Login.EXPIRED_PASSWORD_PARAM,
					request.getParameter(LoginaddonConstants.Login.EXPIRED_PASSWORD_PARAM));
		}

		if (null != request.getParameter(LoginaddonConstants.Login.PASSWORD_EXPIRE_TOKEN))
		{
			model.addAttribute(LoginaddonConstants.Login.PASSWORD_EXPIRE_TOKEN,
					request.getParameter(LoginaddonConstants.Login.PASSWORD_EXPIRE_TOKEN));
			model.addAttribute(LoginaddonConstants.Login.EMAIL, request.getParameter(LoginaddonConstants.Login.EMAIL));
		}
		/*
		 * if (null != helpFlag) { model.addAttribute("helpFlag", helpFlag); }
		 */
		/** Check to see which CMSsite is in use, and setting the corresponding value in session **/
		final String currentSite = cmsSiteService.getCurrentSite().getUid();
		final String siteName = currentSite.equalsIgnoreCase(LoginaddonConstants.MDD_SITE_ID) ? LoginaddonConstants.MDD
				: LoginaddonConstants.CONS;
		sessionService.setAttribute(LoginaddonConstants.SITE_NAME, siteName);
		logMethodStartOrEnd(LOGIN, "doLogin()", Logging.END_OF_METHOD);
		return getDefaultLoginPage(loginError, session, model);
	}

	@Override
	protected String getDefaultLoginPage(final boolean loginError, final HttpSession session, final Model model)
			throws CMSItemNotFoundException
	{
		logMethodStartOrEnd(LOGIN, "getDefaultLoginPage()", Logging.BEGIN_OF_METHOD);
		String errorMessage = null;
		/** login error found use case **/
		if (loginError)
		{
			/** Fetching session attribute for user-name **/
			final String username = (String) session.getAttribute(SPRING_SECURITY_LAST_USERNAME);
			logDebugMessage(LOGIN, "getDefaultLoginPage()", "User Name :: " + username);
			Integer userFailedLogins = null;
			if (null != session.getAttribute("JNJ_USER_FAILED_LOGINS"))
			{
				/** Fetching session attribute for user failed login attempts **/
				userFailedLogins = (Integer) session.getAttribute("JNJ_USER_FAILED_LOGINS");
				logDebugMessage(LOGIN, "getDefaultLoginPage()", "User Failed logins :: " + userFailedLogins);
			}
			if (username != null && userService.isUserExisting(StringUtils.lowerCase(username)))
			{
				/** Fetching usermodel **/
				final UserModel userModel = userService.getUserForUID(StringUtils.lowerCase(username));
				//				final JnJNAB2bCustomerModel jnjNACustomer = (JnJNAB2bCustomerModel) userModel;
				/** Disabled account use case **/
				if (userModel != null)
				{

					if (userModel.isLoginDisabled())
					{
						errorMessage = LoginaddonConstants.Login.LOGIN_ERROR_ACCOUNT_DISABLED;
					}

				}
			}
			if (errorMessage == null)
			{
				/** Failed logins limit use case **/
				if (null != userFailedLogins && null != LOGIN_WARN_LIMIT
						&& userFailedLogins.intValue() == Integer.valueOf(LOGIN_WARN_LIMIT).intValue())
				{
					errorMessage = LoginaddonConstants.Login.LOGIN_WARNING_ACCOUNT_DISABLED;
				}
				/** Invalid credentials use case **/
				else
				{
					if (((Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")) instanceof BadCredentialsException)
					{
						errorMessage = LoginaddonConstants.Login.LOGIN_ERROR_NOT_FOUND;
					}
					else if ((Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null)
					{
						errorMessage = ((Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")).getMessage();
					}
				}
			}
			logDebugMessage(LOGIN, "getDefaultLoginPage()", "LOGIN ERROR :: message key :: " + errorMessage);
			model.addAttribute(LoginaddonConstants.Login.LOGIN_ERROR, errorMessage);
		}
		logMethodStartOrEnd(LOGIN, "getDefaultLoginPage()", Logging.END_OF_METHOD);
		return super.getDefaultLoginPage(loginError, session, model);
	}

	@Override
	public String getLoginView()
	{
		System.out.println("addon getlogin view methode");
		return LoginaddonControllerConstants.Views.Pages.Account.AccountLoginPage;
	}

	@Override
	protected String getSuccessRedirect(final HttpServletRequest request, final HttpServletResponse response)
	{
		logMethodStartOrEnd(LOGIN, "getSuccessRedirect()", Logging.BEGIN_OF_METHOD);
		if (httpSessionRequestCache.getRequest(request, response) != null)
		{
			return httpSessionRequestCache.getRequest(request, response).getRedirectUrl();
		}
		logMethodStartOrEnd(LOGIN, "getSuccessRedirect()", Logging.END_OF_METHOD);
		return "/my-account";
	}

	@Override
	protected AbstractPageModel getLoginCmsPage() throws CMSItemNotFoundException
	{
		return getContentPageForLabelOrId("login");
	}

	@Override
	protected void storeReferer(final String referer, final HttpServletRequest request, final HttpServletResponse response)
	{
		logMethodStartOrEnd(LOGIN, "storeReferer()", Logging.BEGIN_OF_METHOD);
		if (StringUtils.isNotBlank(referer))
		{
			httpSessionRequestCache.saveRequest(request, response);
		}
		logMethodStartOrEnd(LOGIN, "storeReferer()", Logging.END_OF_METHOD);
	}


	/**
	 * Utility method used for logging entry into / exit from any method.
	 * 
	 * @param functionalityName
	 *           the functionality name
	 * @param methodName
	 *           the method name
	 * @param entryOrExit
	 *           the entry or exit
	 */
	private void logMethodStartOrEnd(final String functionalityName, final String methodName, final String entryOrExit)
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug(functionalityName + Logging.HYPHEN + methodName + Logging.HYPHEN + entryOrExit + Logging.HYPHEN
					+ System.currentTimeMillis());
		}
	}

	/**
	 * Utility method used for logging custom messages.
	 * 
	 * @param functionalityName
	 *           the functionality name
	 * @param methodName
	 *           the method name
	 * @param message
	 *           the message
	 */
	private void logDebugMessage(final String functionalityName, final String methodName, final String message)
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug(functionalityName + Logging.HYPHEN + methodName + Logging.HYPHEN + message);
		}
	}

}
