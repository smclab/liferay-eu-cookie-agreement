/**
 * Copyright (c) 2013-present SMC Treviso Srl. All rights reserved.
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

package it.smc.liferay.privacy.web.portlet;

import java.util.Map;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.util.PropsValues;

import it.smc.liferay.privacy.web.util.PrivacyPortletKeys;

/**
 * @author SMC Treviso
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=smc-privacy-portlet",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.preferences-unique-per-layout=false",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.use-default-template=false",
		"javax.portlet.display-name=EU Privacy Disclaimer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/display/view.jsp",
		"javax.portlet.name=" + PrivacyPortletKeys.PRIVACY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PrivacyPortlet extends MVCPortlet {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		if (!hasPortletId()) {
			addPortletIdLayoutStaticPortletsAll();
		}
	}

	protected void addPortletIdLayoutStaticPortletsAll() {
		String[] layoutStaticPortletsAll =
			PropsValues.LAYOUT_STATIC_PORTLETS_ALL;

		layoutStaticPortletsAll = ArrayUtil.append(
			layoutStaticPortletsAll, PrivacyPortletKeys.PRIVACY);

		PropsUtil.set(
			PropsKeys.LAYOUT_STATIC_PORTLETS_ALL,
			StringUtil.merge(layoutStaticPortletsAll));

		PropsValues.LAYOUT_STATIC_PORTLETS_ALL = layoutStaticPortletsAll;
	}

	@Deactivate
	@Modified
	protected void deactivate(Map<String, Object> properties) {
		if (hasPortletId()) {
			removePortletIdLayoutStaticPortletsAll();
		}
	}

	protected boolean hasPortletId() {
		return ArrayUtil.contains(
			PropsValues.LAYOUT_STATIC_PORTLETS_ALL, PrivacyPortletKeys.PRIVACY,
			false);
	}

	protected void removePortletIdLayoutStaticPortletsAll() {
		String[] layoutStaticPortletsAll =
			PropsValues.LAYOUT_STATIC_PORTLETS_ALL;

		layoutStaticPortletsAll = ArrayUtil.remove(
			layoutStaticPortletsAll, PrivacyPortletKeys.PRIVACY);

		PropsUtil.set(
			PropsKeys.LAYOUT_STATIC_PORTLETS_ALL,
			StringUtil.merge(layoutStaticPortletsAll));

		PropsValues.LAYOUT_STATIC_PORTLETS_ALL = layoutStaticPortletsAll;
	}

}