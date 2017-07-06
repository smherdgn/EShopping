<%--
  Created by IntelliJ IDEA.
  User: aakbulak
  Date: 24.10.2016
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="selectvalues.title.view"/></title>
</head>
<body>
<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-12">
        <h2>
            <fmt:message key="selectvalues.title.view"/>
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
                <strong><fmt:message key="selectvalues.title"/></strong>
            </li>
        </ol>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5><fmt:message key="selectvalues.title.view"/></h5>
                </div>
            </div>
            <div class="ibox-content">
                <dl class="dl-horizontal">
                    <dt><fmt:message key="common.id"/></dt>
                    <dd><c:out value="${form.id}"/></dd>

                    <dt><fmt:message key="selectvalues.fieldPropId"/></dt>
                    <dd><c:out value="${form.fieldPropId}"/></dd>

                    <dt><fmt:message key="selectvalues.selectValue"/></dt>
                    <dd><c:out value="${form.selectValue}"/></dd>

                </dl>
                <a href="${pageContext.request.contextPath}/selectvalues/search" class="btn btn-white blockUI">
                    <fmt:message key="button.back"/>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>