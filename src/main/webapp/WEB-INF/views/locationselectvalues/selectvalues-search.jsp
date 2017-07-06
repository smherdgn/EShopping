<%--
  Created by IntelliJ IDEA.
  User: aakbulak
  Date: 24.10.2016
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="selectvalues.title.search"/></title>
</head>
<body>
<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-8">
        <h2>
            <fmt:message key="selectvalues.title.search"/>
        </h2>
        <ol class="breadcrumb">
            <li>
                <a href="${pageContext.request.contextPath}/">
                    <fmt:message key="home.title"/>
                </a>
            </li>
            <li><fmt:message key="definitions.title"/></li>
            <li class="active">
                <strong><fmt:message key="selectvalues.title"/></strong>
            </li>
        </ol>
    </div>
    <div class="col-sm-4">
        <div class="title-action">
            <a href="${pageContext.request.contextPath}/locationselectvalues/add" class="btn btn-primary blockUI">
                <i class="fa fa-plus"></i>
                <fmt:message key="button.new"/>
            </a>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <ind:alerts/>
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5><fmt:message key="selectvalues.title.search"/></h5>
                </div>
                <div class="ibox-content">
                    <c:choose>
                        <c:when test="${not empty items}">
                            <div class="table-repsonsive">
                                <table class="table">
                                    <thead>
                                    <th><fmt:message key="common.id"/></th>
                                    <th><fmt:message key="selectvalues.locationFieldsProperties"/></th>
                                    <th><fmt:message key="selectvalues.selectValue"/></th>
                                    <th style="text-align: right"><fmt:message
                                            key="common.actions"/></th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${items}">
                                        <tr>
                                            <td><c:out value="${item.id}"/></td>
                                            <td><c:out
                                                    value="${item.locationFieldsProperties.tableName}.${item.locationFieldsProperties.fieldName}"/></td>
                                            <td><c:out value="${item.selectValue}"/></td>
                                            <td align="right">
                                                <ind:table-actions baseURL="locationselectvalues" item="${item}"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="alert alert-info">
                                <fmt:message key="page.nodata"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>