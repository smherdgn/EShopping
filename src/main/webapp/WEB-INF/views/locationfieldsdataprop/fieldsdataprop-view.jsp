<%--
  Created by IntelliJ IDEA.
  User: aakbulak
  Date: 20.10.2016
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="fieldsdataprop.title.edit"/></title>
</head>
<body>
<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-12">
        <h2>
            <fmt:message key="fieldsdataprop.title.view"/>
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
                <strong><fmt:message key="fieldsdataprop.title"/></strong>
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
                        <fmt:message key="fieldsdataprop.title.view"/>
                    </h5>
                </div>
                <div class="ibox-content">
                    <dl class="dl-horizantal">
                        <dt>
                            <fmt:message key="common.id"/>
                        </dt>
                        <dd>
                            <c:out value="${form.id}"/>
                        </dd>
                        <dt>
                            <fmt:message key="fieldsdataprop.tableId"/>
                        </dt>
                        <dd>
                            <c:out value="${form.tableId}"/>
                        </dd>
                        <dt>
                            <fmt:message key="fieldsdataprop.fieldPropId"/>
                        </dt>
                        <dd>
                            <c:out value="${form.fieldPropId}"/>
                        </dd>
                        <dt>
                            <fmt:message key="fieldsdataprop.fieldValue"/>
                        </dt>
                        <dd>
                            <c:out value="${form.fieldValue}"/>
                        </dd>

                    </dl>
                    <a href="${pageContext.request.contextPath}/fieldsdataprop/search" class="btn btn-white blockUI">
                        <fmt:message key="button.back"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
