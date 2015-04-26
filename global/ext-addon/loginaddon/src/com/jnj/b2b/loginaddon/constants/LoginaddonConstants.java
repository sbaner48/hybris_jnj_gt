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
package com.jnj.b2b.loginaddon.constants;

import de.hybris.platform.util.Config;


/**
 * Global class for all Loginaddon constants. You can add global constants for your extension into this class.
 */
public final class LoginaddonConstants extends GeneratedLoginaddonConstants
{
	public static final String EXTENSIONNAME = "loginaddon";
	public static final String CONS = "CONS";
	public static final String MDD_SITE_ID_KEY = "jnj.site.mddSite.id.key";
	public static final String MDD = "MDD";
	public static final String MDD_SITE_ID = Config.getParameter(MDD_SITE_ID_KEY);
	public static final String SITE_NAME = "JNJ_SITE_NAME";

	private LoginaddonConstants()
	{
		//empty to avoid instantiating this constant class
		super();
		assert false;
	}

	public interface Login
	{
		public static final String LOGIN_ERROR_LIMIT = "jnj.login.warn.limit";
		public static final String USER_NOT_AUTHORIZED_KEY = "unauthorized";
		public static final String USER_NOT_AUTHORIZED_VALUE = "login.error.unauthorized";

		public static final String USER_GROUP_PLACE_ORDER = "user.groups.ordering.placeOrderGroup";
		public static final String USER_GROUP_VIEW_ONLY = "user.groups.ordering.viewOnlyGroup";

		public static final String USER_GROUP_VIEW_ONLY_SALES_REP = "user.groups.ordering.viewOnlySalesGroup";
		public static final String USER_GROUP_PLACED_ORDER_SALES_REP = "user.groups.ordering.viewAndPlaceOrderSalesGroup";

		public static final String USER_GROUP_ADMIN = "user.groups.adminGroup";
		public static final String USER_GROUP_CSR = "user.groups.csrGroup";
		public static final String ACCOUNT_IN_PROCESS = "login.error.account.inprocess";
		public static final String ORDERING_RIGHTS = "orderingRights";
		public static final String USER_TYPE = "userType";
		public static final String SALESREP_ORDERING_RIGHTS = "salesRepOrderingRights";
		public static final String FIRST_TIME_LOGIN = "firstTimeLogin";
		public static final String ACCOUNT_LIST = "accountList";
		public static final String DAYS_BEFORE_PASSWORD_EXPIRES_KEY = "storefront.password.expiry.days";
		public static final String DAYS_BEFORE_PASSWORD_EXPIRES_DATE_FORMAT = "MM/dd/yyyy";
		public static final String SHOW_CHANGE_ACCOUNT = "showChangeAccount";
		public static final String EXPIRED_PASSWORD_LOGIN_URL = "/login?passwordExpired=";
		public static final String EXPIRED_PASSWORD_PARAM = "passwordExpired";
		public static final String EMAIL = "email";
		public static final String PASSWORD_EXPIRY_UNAUTHORIZED_KEY = "login.password.expiry.unauthorized";
		public static final String PASSWORD_EXPIRY_ERROR = "passwordExpiryError";
		public static final String LOGOUT_URL = "?signout=true";
		public static final String LOGOUT_PARAM = "signout";
		public static final String SURVEY = "survey";
		public static final String SURVEY_COMPONENT_UID_KEY = "login.survey.component.uid";
		public static final String ACCOUNT_UID = "accountUID";
		public static final String ACCOUNT_NAME = "accountName";
		public static final String ACCOUNT_GLN = "accountGLN";
		public static final String PASSWORD_EXPIRE_TOKEN = "passwordExpireToken";
		public static final String CUSTOMER_lOGIN_DISABLE_DAYS = "jnj.na.disableLogin.days";
		public static final String DAYS_BEFORE_SEND_WARNING_MAIL = "jnj.na.daysBeforeSEndingWarningMail.days";
		public static final String DATE = "DATE";
		public static final String SALES_REP_USER = "salesRepUser";
		public static final String HASH_CONSUMER_ID = "#####|Consumer";
		public static final String SESSION_EXPIRED_PARAM = "sessionExpired";

		public static final String LOGIN_ERROR_ACCOUNT_DISABLED = "login.error.account.disbaled";
		public static final String LOGIN_ERROR_NEW_ACCOUNT_DISABLED = "login.error.new.user.account.disbaled";
		public static final String LOGIN_WARNING_ACCOUNT_DISABLED = "login.warn.account.disabled";
		public static final String LOGIN_ERROR_NOT_FOUND = "login.error.account.not.found.title";
		public static final String LOGIN_ERROR_INVALID_COUNTRY = "login.error.invalid.country";
		public static final String HEADER_LINK = "header.link.login";
		public static final String LOGIN_ERROR = "loginError";
		public static final String USER_INVALID_COUNTRY_VARIABLE = "invalidCountry";
		public static final String USER_INVALID_COUNTRY_VALUE = "true";
		public static final String NEW_USER_DISABLED = "newUserDisabled";
		public static final String LEGAL_NOTICE_COMPONENT_UID_KEY = "login.legalNotice.component.uid";
		public static final String PRIVACY_POLICY_COMPONENT_UID_KEY = "login.privacyPolicy.component.uid";
	}

	public interface Logging
	{
		public static final String BEGIN_OF_METHOD = "Begin of method";
		public static final String END_OF_METHOD = "End of method";
		public static final String HYPHEN = "-";
		public static final String START_TIME = "startTime:";
		public static final String END_TIME = "endTime:";
		public static final String CUSTOMER_MASTER_FEED = "Customer Master Feed";
		public static final String HOME_PAGE = "Home Page";
		public static final String LOGIN = "Login";
		public static final String PRIVACY_POLICY_CHECK = "Privacy Policy Check.";
		public static final String ACCOUNTS = "Accounts";
		public static final String PASSWORD_EXPIRY_NAME = "Password Expiry";
		public static final String VALIDATE_CART = "Validate Cart";
		public static final String SURVEY = "Survey";
		public static final String CHANGE_PASSWORD = "Changepassword";
		public static final String REGISTRATION_EMAIL = "Registration Email";
		public static final String PERSONAL_INFORMATION = "Edit Personal Inforation";
		public static final String UPDATE_EMAIL_PREFRENCES = "Update Email Prefrences";
		public static final String ADD_ACCOUNT_EMAIL = "Add Account Email";
		public static final String CHANGE_SECURITY_Question = "Change Security Questions";
		public static final String Get_SECURITY_Question = "Get Security Questions";
		public static final String VERIFY_SECURITY_QUESTION = "Verify Security Questions";
		public static final String SECRET_QUESTION = "Verify Security Questions";
		public static final String UPDATE_PASSWORD = "Updatepassword";
		public static final String EMAIL_PREFERENCES = "EmailPreferences";
		public static final String ADD_ACCOUNT = "Addaccount";
		public static final String ADD_NEW_ACCOUNT = "Addnewaccount";
		public static final String ADD_EXISTING_ACCOUNT = "Addexistingaccount";
		public static final String CREATE_BREADCRUMB = "Createbreadcrumb";
		public static final String ADD_EXISTING_ACCOUNT_EMAIL = "Add Account Email";
		public static final String REPORTS_NAME = "Reports";
		public static final String DATE_UTIL = "Date Util";
		public static final String ORDER_HISTORY_UPDATE_PO = "Update Purchase Order Number";
		public static final String USER_MAMANGEMENT_SEARCH_FACADE = "searchCustomers()";
		public static final String USER_MAMANGEMENT_SEARCH_SERVICE = "searchCustomers()";
		public static final String APPROVED_USER_EMAIL = "ApprovedUserEmail";
		public static final String REJECT_USER_EMAIL = "rejectUserEmail()";
		public static final String PASSWORD_EXPIRY_EMAIL = "password expiry";
		public static final String WARNING_EMAIL = "Warning Email";
		public static final String METHOD_SEND_EMAIL_NOTIFICATION = "Method Send Email Notification";
		public static final String HOME_ORDER_STATUS = "homeOrderStatus";
		public static final String HOME_QUICK_CART = "homeAddQucikToCart";
		public static final String HOME_MULTIPLE_CART = "homeMultipleCart";
		public static final String HOME_START_RETURN = "homeStartReturn";
		public static final String HOME_START_RETURN_POST = "homeStartReturnPost";
		public static final String HOME_START_NEW_ORDER = "homeNewOrder";
		public static final String HOME_START_NEW_ORDER_POST = "homeNewOrderPost";
		public static final String HOME_START_NEW_QUOTE_POST = "homeNewQuote";
		public static final String HOME_START_NEW_QUOTE = "homeNewQuotePost";
		public static final String SAVE_CREDIT_CARD_INFO = "Save Credit Card Info";
		public static final String INITIATE_REPLENISH_ORDER = "Initiate Replenish Order";
		public static final String ORDER_CONFIRMATION_EMAIL = "CartOrderConfirmation";
		public static final String HOME_VIEW_TEMPLATE_DETAIL = "Home Template Details";
		public static final String HOME_GET_BROADCAST_CONTENT = "Home BroadCast Content";
		public static final String GET_CONTRACT_PRICE = "Get Contract Price";
		public static final String USER_PASSWORD_EXPIRY_EMAIL = "Password expiry email / Reset Password Link email.";
		public static final String RENAME_SURGEON_INBOUND_FILES = "Rename Surgeon Inbound Files";
		public static final String PROCESS_SURGEON_INT_RECORDS = "Process Surgeon Intermediate Records";
		public static final String RENAME_ORDER_STATUS_INBOUND_FILES = "Rename Order Status Inbound Files";
		public static final String PROCESS_ORDER_STATUS_INT_RECORDS = "Process Order status Intermediate Records";
		public static final String RENAME_SHIP_TRACK_INBOUND_FILES = "Rename Ship & Tracking Inbound Files";
		public static final String PROCESS_SHIP_TRACK_INT_RECORDS = "Process Ship & Tracking  Intermediate Records";
		public static final String PRODUCT_DETAILS_EMAIL = "Product Details Email";
		public static final String CA_PCM_PROD_EXCLUSION = "Canada Pcm Product Exclusion";
		public static final String US_PCM_PROD_EXCLUSION = "US Pcm Product Exclusion";
		public static final String CUSTOMER_ALIGNMENT = "Customer Alignment";
		public static final String CMOD_RGA_CALL = "Cmod Rga Call";
		public static final String RESET_PASSWORD_CRONJOB = "Reset Password Details Job";
		public static final String RESET_PASSWORD_DETAILS = "Reset Password Toke and Url";
		public static final String EXPORT_CATALOG_EMAIL = "Export Catalog Email";
		public static final String ORDER_SHIPMENT_EMAIL_NOTIFICATION = "Order Shipment Email Notification Job";
		public static final String BACKORDER_EMAIL_NOTIFICATION = "Backorder Email Notification Job";
	}


	// implement here constants used by this extension
}
