/**
 * Copyright (c) 2013 SMC Treviso Srl. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.smc.liferay.privacy.web.application.list;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import it.smc.liferay.privacy.web.util.PrivacyPortletKeys;

/**
 * @author SMC Treviso
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=300",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONFIGURATION
	},
	service = PanelApp.class
)
public class PrivacyPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return PrivacyPortletKeys.PRIVACY_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + PrivacyPortletKeys.PRIVACY_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}