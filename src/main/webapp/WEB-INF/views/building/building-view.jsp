<%--
  Created by IntelliJ IDEA.
  User: semih
  Date: 28/09/2016
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/templates/include-pageheader.jsp" %>
<!DOCTYPE html>
<html>
<head>

    <title><fmt:message key="building.title.view"/></title>
    <link href="${pageContext.request.contextPath}/resources/map/Content/css/openlayers.css" rel="stylesheet"/>

</head>
<body>
<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-12">
        <h2>
            <fmt:message key="building.title.view"/>
        </h2>
        <ol class="breadcrumb">
            <li>
                <a href="${pageContext.request.contextPath}/">
                    <fmt:message key="home.title"/>
                </a>
            </li>
            <li>
                <fmt:message key="definitions.title"/>
            </li>
            <li class="active">
                <strong><fmt:message key="building.title"/></strong>
            </li>


        </ol>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>
                        <fmt:message key="building.title.view"/>
                    </h5>
                </div>
                <div class="ibox-content">
                    <dl class="dl-horizontal">
                        <dt>
                            <fmt:message key="building.description"/>
                        </dt>
                        <dd>
                            <c:out value="${form.description}"/>
                        </dd>
                        <c:forEach var="other" items="${form.getLocationOtherFieldsList()}">

                            <dt>
                                    ${other.locationFieldsProperties.fieldName}
                            </dt>
                            <dd>
                                <c:out value="${other.locationFieldsDataProp.fieldValue}"/>
                            </dd>

                        </c:forEach>
                    </dl>
                    <a href="${pageContext.request.contextPath}/building/search" class="btn btn-white blockUI">
                        <fmt:message key="button.back"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/map/Scripts/openlayers.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/map/Scripts/openlayersconfig.js"></script>
<script src="${pageContext.request.contextPath}/resources/map/Scripts/standaloneMap.min.js"></script>


</body>


</html>

