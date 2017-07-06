<%--
  Created by IntelliJ IDEA.
  User: aakbulak
  Date: 24.10.2016
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="Locationfieldsproperties.title.search"/></title>
</head>
<body>
<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-8">
        <h2>
            <fmt:message key="Locationfieldsproperties.title.search"/>
        </h2>
        <ol class="breadcrumb">
            <li>
                <a href="${pageContext.request.contextPath}/">
                    <fmt:message key="home.title"/>
                </a>
            </li>
            <li><fmt:message key="definitions.title"/></li>
            <li class="active">
                <strong>
                    <fmt:message key="Locationfieldsproperties.title"/>
                </strong>
            </li>
        </ol>
    </div>
    <div class="col-sm-4">
        <div class="title-action">
            <a href="${pageContext.request.contextPath}/locationfieldsproperties/add" class="btn btn-primary blockUI">
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
                    <h5><fmt:message key="Locationfieldsproperties.title.search"/></h5>
                </div>
                <div class="ibox-content">


                    <div class="table-responsive">
                        <table data-toggle="table" data-unique-id="id" data-locale="tr-TR"
                               id="table"
                               data-pagination="true"
                               data-page-size="5"
                               data-page-list="[5,10,25]"
                               data-pagination-first-text="Ilk"
                               data-pagination-pre-text="Onceki"
                               data-pagination-next-text="Sonraki"
                               data-pagination-last-text="Son"
                               data-ajax="ajaxRequest"
                               data-show-refresh="true"
                               data-show-toggle="true"
                               data-side-pagination="server"
                               data-show-footer="false"
                               data-url="${contextPath}/locationfieldsproperties/pageable">

                            <thead>
                            <th data-field="id"><fmt:message key="common.id"/></th>
                            <th data-field="tableName" data-sortable="true"><fmt:message key="Locationfieldsproperties.tableName"/></th>
                            <th data-field="fieldName" data-sortable="true"><fmt:message key="Locationfieldsproperties.fieldName"/></th>
                            <th data-field="fieldType" data-sortable="true"><fmt:message key="Locationfieldsproperties.fieldType"/></th>
                            <th data-field="isNullable" data-sortable="true"><fmt:message key="Locationfieldsproperties.isNullable"/></th>
                            <th data-field="regExp" data-sortable="true"><fmt:message key="Locationfieldsproperties.regExp"/></th>
                            <th data-align="right" data-field="actions" style="text-align: right"><fmt:message key="common.actions"/></th>
                            </thead>

                        </table>
                    </div>


                </div>
            </div>
        </div>
    </div>
    <script src="${contextPath}/resources/js/plugins/bootstraptable/bootstrap-table.min.js"></script>
    <script src="${contextPath}/resources/js/plugins/bootstraptable/locale/bootstrap-table-tr-TR.min.js"></script>
    <script>

        function ajaxRequest(params) {

            //  console.log(params);
            $.ajax({
                url: params.url,
                dataType: params.dataType,
                contentType: params.contentType,
                method: params.method,
                timeout: 30000,
                cache: params.cache,
                "data": params.data,
                async: false,
                success: function (data) {
                    columns = [], datas = [];
                    if (data) {
                        var newData = [];
                        data.rows.forEach(function (element) {
                            element.actions =
                                    "  <a href='" + element.id + "' class='btn btn-white btn-sm blockUI'> <i class='fa fa-search'></i></a>" +
                                    "  <a href='edit/" + element.id + "' class='btn btn-white btn-sm blockUI'> <i class='fa fa-pencil'></i></a>" +
                                    "  <a href='delete/" + element.id + "' onclick=\"return confirm_form('Bu Kayit Silinecek. Emin misiniz?')\" class='btn btn-white btn-sm blockUI'> <i class='fa fa-trash'></i></a>";

                            newData.push(element);
                        });
                        //  console.log(newData);
                        params.success({
                            total: data.total,
                            rows: newData
                        });
                        //          console.log(data);
                    }
                }
            });


        }


    </script>
</div>
</body>
</html>