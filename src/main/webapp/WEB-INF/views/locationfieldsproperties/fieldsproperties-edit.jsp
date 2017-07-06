<%--
  Created by IntelliJ IDEA.
  User: aakbulak
  Date: 24.10.2016
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head><fmt:message key="Locationfieldsproperties.title.edit"/></head>
<body>
<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-12">
        <h2>
            <fmt:message key="Locationfieldsproperties.title.edit"/>
        </h2>
        <ol class="breadcrumb">
            <li>
                <a href="${pageContext.request.contextPath}/">
                    <fmt:message key="home.title"/>
                </a>
            </li>
            <li><fmt:message key="definitions.title"/></li>
            <li class="active">
                <strong><fmt:message key="Locationfieldsproperties.title"/></strong>
            </li>
        </ol>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5><fmt:message key="Locationfieldsproperties.title.edit"/></h5>
                </div>
                <div class="ibox-content">
                    <form:form id="form" method="post" commandName="form" class="form-horizontal" autocomplete="off"
                               role="form">
                        <ind:form-group labelKey="Locationfieldsproperties.tableName" required="true">
                            <form:select path="tableName" id="tableName" class="form-control">
                                <c:forEach items="${locationFieldsTableNames}" var="Item">
                                    <form:option value="${Item}">${Item.displayName}</form:option>
                                </c:forEach>
                            </form:select>
                        </ind:form-group>

                        <ind:form-group labelKey="Locationfieldsproperties.fieldName" required="true">
                            <form:input id="inputFieldName" path="fieldName"
                                        name="fieldName" class="form-control"/>
                        </ind:form-group>


                        <ind:form-group labelKey="Locationfieldsproperties.fieldType" required="true">
                            <form:select path="fieldType" id="fieldType" class="form-control">
                                <c:forEach items="${fieldsPropertiesTypes}" var="Item">
                                    <form:option value="${Item}">${Item.displayName}</form:option>
                                </c:forEach>
                            </form:select>
                        </ind:form-group>

                        <ind:form-group labelKey="Locationfieldsproperties.isNullable" required="true">
                            <form:select path="isNullable" id="isNullable" class="form-control">
                                <form:option value="${true}"><fmt:message
                                        key="Locationfieldsproperties.isnull.yes"/></form:option>
                                <form:option value="${false}"><fmt:message
                                        key="Locationfieldsproperties.isnull.no"/></form:option>
                            </form:select>
                        </ind:form-group>

                        <ind:form-group labelKey="Locationfieldsproperties.regExp" required="false">
                            <form:textarea path="regExp" id="inputRegExp" name="regExp" class="form-control"/>
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
