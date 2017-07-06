<%--
  Created by IntelliJ IDEA.
  User: Alper AKBULAK
  Date: 20.10.2016
  Time: 15:34
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
            <fmt:message key="fieldsdataprop.title.edit"/>
        </h2>
        <ol class="breadcrumb">
            <li>
                <a href="${pageContext.request.contextPath}/">
                    <fmt:message key="home.title"/>
                </a>
            </li>
            <li><fmt:message key="definitions.title"/></li>
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
                        <fmt:message key="fieldsdataprop.title.edit"/>
                    </h5>
                </div>
                <div class="ibox-content">
                    <form:form id="form" method="post" commandName="form" class="form-horizontal" autocomplete="off"
                               role="form">

                        <ind:form-group labelKey="fieldsdataprop.tableId" required="true">
                            <form:input id="inputTableId" name="tableId" path="tableId" class="form-control"/>
                        </ind:form-group>

                        <ind:form-group labelKey="fieldsdataprop.locationFieldsPropertiess" required="true">
                            <form:input id="inputfieldsPropertiess" path="locationFieldsPropertiess.id" name="locationFieldsPropertiess"
                                        class="form-control"/>
                        </ind:form-group>

                        <ind:form-group labelKey="fieldsdataprop.fieldValue" required="true">
                            <form:input id="inputValue" path="fieldValue" name="fieldValue" class="form-control"/>
                        </ind:form-group>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">

                                <button type="submit" class="btn btn-primary blockUI">
                                    <fmt:message key="button.save"/>
                                </button>

                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>