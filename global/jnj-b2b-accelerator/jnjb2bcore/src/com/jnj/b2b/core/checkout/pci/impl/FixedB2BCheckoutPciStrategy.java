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
package com.jnj.b2b.core.checkout.pci.impl;

import de.hybris.platform.b2bacceleratorservices.enums.B2BCheckoutPciOptionEnum;
import com.jnj.b2b.core.checkout.pci.B2BCheckoutPciStrategy;

import org.springframework.beans.factory.annotation.Required;


/**
 * Uses fixed {@link B2BCheckoutPciOptionEnum} as result. Used most likely on the end of checkout PCI option strategy
 * chain.
 * @Deprecated see {@link de.hybris.platform.b2bacceleratorservices.order.checkout.pci.impl.FixedB2BCheckoutPciStrategy}
 */
@Deprecated
public class FixedB2BCheckoutPciStrategy implements B2BCheckoutPciStrategy
{
    private B2BCheckoutPciOptionEnum subscriptionPciOption;

    @Override
    public B2BCheckoutPciOptionEnum getSubscriptionPciOption()
    {
        return this.subscriptionPciOption;
    }

    @Required
    public void setSubscriptionPciOption(final B2BCheckoutPciOptionEnum subscriptionPciOption)
    {
        this.subscriptionPciOption = subscriptionPciOption;
    }
}
