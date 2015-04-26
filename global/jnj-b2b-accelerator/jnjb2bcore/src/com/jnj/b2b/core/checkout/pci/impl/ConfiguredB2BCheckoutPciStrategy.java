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

import de.hybris.platform.acceleratorservices.config.SiteConfigService;
import de.hybris.platform.acceleratorservices.payment.constants.PaymentConstants;

import de.hybris.platform.b2bacceleratorservices.enums.B2BCheckoutPciOptionEnum;
import org.springframework.beans.factory.annotation.Required;


/**
 * @deprecated see {@link de.hybris.platform.b2bacceleratorservices.order.checkout.pci.impl.ConfiguredB2BCheckoutPciStrategy}
 */
@Deprecated
public class ConfiguredB2BCheckoutPciStrategy extends AbstractB2BCheckoutPciStrategy
{
    private SiteConfigService siteConfigService;

    protected SiteConfigService getSiteConfigService()
    {
        return siteConfigService;
    }

    @Required
    public void setSiteConfigService(final SiteConfigService siteConfigService)
    {
        this.siteConfigService = siteConfigService;
    }

    @Override
    public B2BCheckoutPciOptionEnum getSubscriptionPciOption()
    {
        final B2BCheckoutPciOptionEnum checkoutPciOption = getSiteConfiguredSubscriptionPciOption();
        if (checkoutPciOption != null)
        {
            return checkoutPciOption;
        }

        return getDefaultCheckoutPciStrategy().getSubscriptionPciOption();
    }

    protected B2BCheckoutPciOptionEnum getSiteConfiguredSubscriptionPciOption()
    {
        // Check if there is any HOP configuration
        final boolean enabled = getSiteConfigService().getBoolean(PaymentConstants.PaymentProperties.HOP_PCI_STRATEGY_ENABLED,
                false);
        if (enabled)
        {
            return B2BCheckoutPciOptionEnum.HOP;
        }
        return null;
    }
}
