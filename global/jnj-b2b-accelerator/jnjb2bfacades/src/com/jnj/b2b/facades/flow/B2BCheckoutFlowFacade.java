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
package com.jnj.b2b.facades.flow;

import de.hybris.platform.b2bacceleratorfacades.order.B2BCheckoutFacade;
import de.hybris.platform.b2bacceleratorservices.enums.B2BCheckoutFlowEnum;
import de.hybris.platform.b2bacceleratorservices.enums.B2BCheckoutPciOptionEnum;
import de.hybris.platform.commercefacades.order.CheckoutFacade;


/**
 * CheckoutFlowFacade interface extends the {@link CheckoutFacade}. The CheckoutFlowFacade supports resolving the
 * {@link B2BCheckoutFlowEnum} for the current request.
 *
 * @since 4.6
 * @spring.bean checkoutFacade
 */
@Deprecated
public interface B2BCheckoutFlowFacade extends B2BCheckoutFacade
{
	B2BCheckoutFlowEnum getCheckoutFlow();

	B2BCheckoutPciOptionEnum getSubscriptionPciOption();
}
