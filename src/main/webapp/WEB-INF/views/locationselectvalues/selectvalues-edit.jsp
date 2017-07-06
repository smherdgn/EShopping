<%--
  Created by IntelliJ IDEA.
  User: aakbulak
  Date: 24.10.2016
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <fmt:message key="selectvalues.title.edit"/>
    <link href="${contextPath}/resources/css/plugins/select2/select2.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/plugins/select2/select2-bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-12">
        <h2><fmt:message key="selectvalues.title.edit"/></h2>
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
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5><fmt:message key="selectvalues.title.edit"/></h5>
                </div>
            </div>
            <div class="ibox-content">
                <form:form id="form" method="post" commandName="form" class="form-horizontal" autocomplete="false"
                           role="form">
                    <ind:form-group labelKey="selectvalues.locationFieldsProperties" required="true">
                        <form:select id="inputFieldsProperties" style="width: 100%"
                                     data-provide="select2" path="locationFieldsProperties.Id" class="form-control"
                                     data-ajax--url="findbyTableNameAndFieldName">
                            <form:option
                                    value="${form.locationFieldsProperties.id}">${form.locationFieldsProperties.tableName}.${form.locationFieldsProperties.fieldName}
                            </form:option>
                        </form:select>
                    </ind:form-group>

                    <ind:form-group labelKey="selectvalues.selectValue" required="true">
                        <form:input id="inputselectValue" path="selectValue" name="selectValue" class="form-control"/>
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
<script src="${contextPath}/resources/js/plugins/select2/select2.min.js"></script>
<script src="${contextPath}/resources/js/plugins/select2/i18n/tr.js" charset="UTF-8"></script>
<script>// Select2 custimized
$.fn.select2.defaults.set("theme", "bootstrap");
$.fn.select2.defaults.set("language", "tr");
$.fn.select2.defaults.set("placeholder", "Seciniz...");
$.fn.select2.defaults.set("allowClear", true);
$.fn.select2.defaults.set("minimumResultsForSearch", 10);

// Select2 construction
$("[data-provide='select2']").each(function () {
    var element = $(this);

    // if it is ajax enabled
    if (element.data("ajax--url")) {
        element.select2({
            minimumInputLength: 3,
            ajax: {
                contentType: "application/json; charset=utf-8",
                dataType: 'json',
                delay: 600,
                cache: true,

                data: function (params) {
                    return {
                        q: params.term, // search term
                        page: params.page
                    };
                },

                processResults: function (data) {
                    var newData = [];
                    $.each(data, function (key, value) {
                        newData.push({
                            id: value.id,
                            text: value.text
                        });
                        $.each(value.children, function (key, value) {
                            newData.push({
                                id: value.id,
                                text: value.text
                            });
                        });
                    });

                    return {
                        results: newData
                    };
                }
            }

        });
    } else {
        element.select2();
    }
});

$("select").on("select2:select", function (evt) {
    var element = evt.params.data.element;
    var $element = $(element);
    $element.detach();
    $(this).append($element);
    $(this).trigger("change");
});</script>
</body>
</html>