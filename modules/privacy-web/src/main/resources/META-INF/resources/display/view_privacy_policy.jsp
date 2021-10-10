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
 */ */
--%>
<%@ include file="/display/init.jsp" %>

<div class="privacy-policy-container" id="<portlet:namespace />privacy-policy">
	<c:if test="<%= privacyPolicy != null %>">
		<liferay-asset:asset-display
			className="<%= JournalArticle.class.getName() %>"
			classPK="<%= privacyPolicy.getResourcePrimKey() %>"
			showHeader="<%= !themeDisplay.isStatePopUp() %>"
		/>
	</c:if>
</div>