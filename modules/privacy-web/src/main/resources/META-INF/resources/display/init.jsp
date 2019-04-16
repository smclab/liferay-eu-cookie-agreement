<%--
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
--%>
<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<%
JournalArticle privacyPolicy = PrivacyUtil.getPrivacyJournalArticle(scopeGroupId, privacyPolicyArticleId);

boolean showPrivacyInfoMessage = PrivacyUtil.showPrivacyInfoMessage(themeDisplay.isSignedIn(), privacyEnabled, privacyPolicy, request, nameExtend);
%>