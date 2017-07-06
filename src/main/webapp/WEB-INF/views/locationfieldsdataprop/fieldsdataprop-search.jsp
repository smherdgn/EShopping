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
    <title><fmt:message key="fieldsdataprop.title.search"/></title>
</head>
<body>
<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-8">
        <h2>
            <fmt:message key="fieldsdataprop.title.search"/>
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
                    <fmt:message key="fieldsdataprop.title"/>
                </strong>
            </li>
        </ol>
    </div>
    <div class="col-sm-4">
        <div class="title-action">
            <a href="${pageContext.request.contextPath}/locationfieldsdataprop/add"
               class="btn btn-primary blockUI">
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
                    <h5>
                        <fmt:message key="fieldsdataprop.title.search"/>
                    </h5>
                </div>

                <div class="ibox-content">

                    <div class="table-responsive">


                        <div class=" col-sm-12 col-xs-12">

                            <table data-toggle="table" data-unique-id="id" data-locale="tr-TR"
                                   data-pagination="true"
                                   data-page-size="5"
                                   data-page-list="[5,10,50]"
                                   data-ajax="ajaxRequest"
                                   data-detail-view="true"
                                   data-detail-formatter="detailFormatter"
                                   data-side-pagination="server"
                                   data-url="${contextPath}/locationfieldsdataprop/pageable">
                                <thead>
                                <th data-align="left" data-field="id"><fmt:message key="common.id"/></th>
                                <th data-align="left" data-field="locationFieldsPropertiess.tableName" data-sortable="true"><fmt:message key="fieldsdataprop.tableName"/></th>
                                <th data-align="left" data-field="locationFieldsPropertiess.fieldName" data-sortable="true"><fmt:message key="fieldsdataprop.fieldName"/></th>
                                <th data-align="left" data-field="tableId" data-sortable="true"><fmt:message key="fieldsdataprop.tableId"/></th>
                                <th data-align="left" data-field="fieldValue" data-sortable="true"><fmt:message key="fieldsdataprop.fieldValue"/></th>


                                <th data-align="right" data-field="actions" data-sortable="true"><fmt:message key="common.actions"/></th>

                                </thead>

                            </table>
                        </div>


                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="${contextPath}/resources/js/plugins/bootstraptable/bootstrap-table.min.js"></script>
<script src="${contextPath}/resources/js/plugins/bootstraptable/locale/bootstrap-table-tr-TR.min.js"></script>

<script type="text/javascript">

    function detailFormatter(index, row) {
        var html = [];
        $.ajax({
            url: '${contextPath}/space/findByBuilding',
            dataType: "JSON",
            contentType: "application/json; charset=UTF-8",
            method: "GET",
            timeout: 30000,
            cache: false,
            data: {"buildingId": row.id},
            async: false,
            success: function (data) {

                if (data.length > 0) {
                    var tableString = '<table class="table">' +
                            '<thead>' +
                            '<th><fmt:message key="space.singleSpaceNo"/></th>' +
                            '<th  ><fmt:message key="space.address"/></th>' +
                            '</thead>' +
                            '<tbody>';

                    data.forEach(function (element) {

                        tableString = tableString +
                                '<tr>' +
                                '<td>  ' + element.singleSpaceNo + '</td>' +
                                '<td>';
                        if (element.addressMisList.length > 0) {
                            element.addressMisList.forEach(function (address) {
                                //console.log(address);
                                tableString = tableString + '<li>' + address.description + '</li>'
                            });
                        }
                        else {
                            tableString = tableString + '<li>Adres Kaydi Bulunamadi</li>'
                        }
                        tableString = tableString + '</td> </tr>';

                    });
                    tableString = tableString + '</tbody>';
                    html.push(tableString);
                } else {
                    html.push("<li>Bagimsiz Bolum Kaydi Bulunamadi</li>");
                }


            }
        });
        return html.join('');

    }

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
</body>
</html>