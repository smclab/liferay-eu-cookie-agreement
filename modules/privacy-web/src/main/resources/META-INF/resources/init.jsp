<%--
/**
 * Copyright (c) SMC Treviso Srl. All rights reserved.
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/asset" prefix="liferay-asset" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="javax.portlet.PortletPreferences" %>

<%@ page import="it.smc.liferay.privacy.web.constants.PrivacyAdminPortletKeys" %>
<%@ page import="it.smc.liferay.privacy.web.util.PrivacyUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletPreferences adminSettings = PrivacyUtil.getPrivacyAdminSettings(themeDisplay.getCompanyId(), scopeGroupId);

boolean privacyEnabled = GetterUtil.getBoolean(adminSettings.getValue("privacyEnabled", ""), false);

String privacyInfoMessageArticleId = adminSettings.getValue("privacyInfoMessageArticleId", "");

String privacyPolicyArticleId = adminSettings.getValue("privacyPolicyArticleId", "");

int cookieExpiration = GetterUtil.getInteger(adminSettings.getValue("cookieExpiration", ""),30);

String nameExtend = String.valueOf(scopeGroupId) + adminSettings.getValue("nameExtend", "");
%>