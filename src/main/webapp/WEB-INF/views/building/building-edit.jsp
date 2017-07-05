<%--
  User: semih
  Date: 29/06/2016
  Time: 14:22
--%>
<%@ include file="/WEB-INF/templates/include-pageheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="building.title.edit"/></title>
    <link href="${pageContext.request.contextPath}/resources/map/Content/css/openlayers.css" rel="stylesheet"/>
    <link href="${contextPath}/resources/css/plugins/select2/select2.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/plugins/select2/select2-bootstrap.min.css" rel="stylesheet">


</head>
<body>

<div class="row wrapper border-bottom white-bg page-heading hidden-xs">
    <div class="col-sm-12">
        <h2>
            <fmt:message key="building.title.edit"/>
        </h2>
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/"> <fmt:message
                    key="home.title"/>
            </a></li>
            <li><fmt:message key="definitions.title"/></li>
            <li class="active"><strong><fmt:message
                    key="building.title"/></strong></li>
        </ol>
    </div>
</div>

<div class="wrapper wrapper-content">
    <ind:alerts/>
    <div class="row">
        <div class="col-sm-12">

            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>
                        <fmt:message key="building.title.edit"/>
                    </h5>
                </div>


                <div class="ibox-content">
                    <form:form id="form" method="post" commandName="form"
                               class="form-horizontal" autocomplete="off" role="form">





                        <ind:form-group labelKey="building.buildingName" required="false">
                            <form:input id="buildingName" name="buildingName" path="buildingName"
                                        class="form-control"/>
                        </ind:form-group>

                        <c:forEach var="other" items="${form.getLocationOtherFieldsList()}">

                            <c:choose>
                                <c:when test="${other.locationFieldsProperties.fieldType=='STRING'}">


                                    <ind:form-group-label
                                            labelKey="${other.locationFieldsProperties.fieldName}"
                                            required="${!other.locationFieldsProperties.isNullable}">
                                        <input id="${other.locationFieldsProperties.fieldName}"
                                               name="${other.locationFieldsProperties.fieldName}"
                                               value="${other.locationFieldsDataProp.fieldValue}"
                                               class="form-control"/>
                                    </ind:form-group-label>


                                </c:when>

                                <c:when test="${other.locationFieldsProperties.fieldType=='NUMBER'}">
                                    <ind:form-group-label
                                            labelKey="${other.locationFieldsProperties.fieldName}"
                                            required="${!other.locationFieldsProperties.isNullable}">
                                        <input type="number"
                                               id="input${other.locationFieldsProperties.fieldName}"
                                               name="${other.locationFieldsProperties.fieldName}"
                                               value="${other.locationFieldsDataProp.fieldValue}"
                                               class="form-control">

                                    </ind:form-group-label>

                                </c:when>

                                <c:when test="${other.locationFieldsProperties.fieldType=='DATE'}">

                                    <ind:form-group-label
                                            labelKey="${other.locationFieldsProperties.fieldName}"
                                            required="${!other.locationFieldsProperties.isNullable}">

                                        <input type="date" id="${other.locationFieldsProperties.fieldName}"
                                               name="${other.locationFieldsProperties.fieldName}"
                                               value="${other.locationFieldsDataProp.fieldValue}"
                                               class="form-control datepicker"/>

                                    </ind:form-group-label>


                                </c:when>
                                <c:when test="${other.locationFieldsProperties.fieldType=='SELECT'}">

                                    <ind:form-group-label
                                            labelKey="${other.locationFieldsProperties.fieldName}"
                                            required="${!other.locationFieldsProperties.isNullable}">

                                        <select style="width: 100%;" name="${other.locationFieldsProperties.fieldName}" id="${other.locationFieldsProperties.fieldName}" class="form-control">
                                            <c:forEach items="${other.locationSelectValues}"
                                                       var="locationSelectValues">

                                                <c:choose>
                                                    <c:when test="${other.locationFieldsDataProp.fieldValue==locationSelectValues.selectValue }">
                                                        <option selected
                                                                value="${locationSelectValues.selectValue}">${locationSelectValues.selectValue}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option
                                                                value="${locationSelectValues.selectValue}">${locationSelectValues.selectValue}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>

                                    </ind:form-group-label>

                                </c:when>

                                <c:otherwise>

                                    <ind:form-group-label
                                            labelKey=" ${other.locationFieldsProperties.fieldName}"
                                            required="${!other.locationFieldsProperties.isNullable}">

                                        <input id="input${other.locationFieldsProperties.fieldName}"
                                               name="${other.locationFieldsProperties.fieldName}"
                                               value="${other.locationFieldsDataProp.fieldValue}"
                                               class="form-control"/>

                                    </ind:form-group-label>

                                </c:otherwise>
                            </c:choose>
                        </c:forEach>


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
<script src="${pageContext.request.contextPath}/resources/map/Scripts/openlayers.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/map/Scripts/standaloneMap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/map/Scripts/openlayersconfig.js"></script>

<script src="${contextPath}/resources/js/plugins/select2/select2.min.js"></script>
<script src="${contextPath}/resources/js/plugins/select2/i18n/tr.js" charset="UTF-8"></script>
<script src="${contextPath}/resources/js/plugins/select2/select2.defaults.js"></script>
<script type="text/javascript">
    var userId = "${userId}";
    var taskId = "${taskId}";
    var userName = "${userName}";
    if (kurum == "SIRKETESENLER") {

        $("#drawingDiv").hide();
    }
    /*Harita Görseli Oluşturuluyor*/
    document.mapView = new MapView({
        MapContainer: 'map',
        BaseMapLayer: {source: "Bing", type: "Road", active: true, overViewMap: true},
        Layers: __layers,
        SearchOptions: {
            BingSearchOptions: {
                active: true,
                location: __location1,
                location2: false,
                proxy:  "${contextPath}/proxy/get?q=",
                selectionCallBack: function (response) {
                    console.log(response);
                }
            }
        },
        ViewOptions: {
            ExtentBuffer: __ExtentBuffer,
            DefaultZoom: __DefaultZoom,
            MinZoom: __MinZoom,
            MaxZoom: __MaxZoom,
            ShowLayerManager: true
        },
        Projection: __projection,
        GeoServer: {
            IpAdress: __ipadress,
            Port: __port,
            Username: __username,
            Password: __password,
            DefaultWorkspace: __defaultWorkspace,
            Protocol: __protokol
        }, TrackLocation: {
            EnableTracking: true,
            UpdateTime: 0,
            UserId: userId,
            UserName: userName
        },
        SelectionOptions: {
            active: true,
            Urls: [{
                Type: "ruhsat",
                SelectionInfoPopupUrl: "popup?uavt=@ #popup"
            }],
            TeamLocation: {
                SelectionInfoPopupUrl: "http://www.xx.com.tr?yyy=@"
            }
        }
        ,
        AfterInitializeCallBack: function () {
            initilizeDatas();
        }
    });

    var addressQuery = new AddressQuery({
        GeoServer: {
            IpAdress: __ipadress,
            Port: __port,
            Username: __username,
            Password: __password,
            DefaultWorkspace: __defaultWorkspace,
            Protocol: __protokol
        }
    });

    function initilizeDatas() {

        var ilce = document.getElementById("tonwId");
        addressQuery.getIlces(function (s) {
            if (s) {

                var option = document.createElement("option");
                option.text = "ILCE SECINIZ !";
                option.value = "0";
                option.selected = true;
                ilce.add(option);
                for (var i in s) {
                    var option = document.createElement("option");
                    option.text = s[i].value;
                    option.value = s[i].key;

                    ilce.add(option);
                }
            }

        });

    }

    /*Harita Çizim başlat*/
    function startDraw() {
        var kapi = document.getElementById("building");

        if (kapi.selectedIndex != -1) {
            var uavt = kapi.options[kapi.selectedIndex].value;
            document.mapView.drawing.draw("RUHSAT_POINT",
                    [
                        {fieldname: "featuretype", fieldvalue: "ruhsat"},
                        {fieldname: "featurekey", fieldvalue: uavt}
                    ]
                    , function (x) {


                        showPoint(uavt);
                    });
        } else
            alert("kapi Seciniz!");
    }
    /*Harita Çizim sil*/
    function removeDraw() {
        var kapi = document.getElementById("building");

        if (kapi.selectedIndex != -1) {
            var uavt = kapi.options[kapi.selectedIndex].value;
            if (confirm(uavt + " Uavt Nolu kapi Silinsimi?") == true) {


                var query = new QueryFilter("RUHSAT_POINT");
                query.and(query.equals("featuretype", "ruhsat")).and(query.equals("featurekey", uavt));

                document.mapView.filtering.deleteFeatures(query, function (x) {

                    document.mapView.filtering.clearFeatures();
                    document.mapView.selection.clearFeatures();
                    document.mapView.drawing.clearFeatures();
                });
            }
        }
    }


    function calculateRoute(uavt) {
        var query = new QueryFilter("RUHSAT_POINT");
        query.and(query.equals("featuretype", "ruhsat")).and(query.equals("featurekey", uavt));

        document.mapView.route.calculateRoute(query);
    }


    /*Harita Çizim biitir*/
    function finishDraw() {
        document.mapView.drawing.finishDrawing();
    }


    function mahalleSetle() {
        var mahalle = document.getElementById("district");
        addressQuery.getMahalles(function (response) {
            if (response) {

                var option = document.createElement("option");
                option.text = "MAHALLE SECINIZ !";
                option.value = "0";
                option.selected = true;
                mahalle.add(option);
                for (var i in response) {


                    var option = document.createElement("option");
                    option.text = response[i].value;
                    option.value = response[i].key;

                    mahalle.add(option);
                }
            }
        });
    }

    function YolSetle() {
        var e = document.getElementById("district");
        var mahalleId = e.options[e.selectedIndex].value;
        var yol = document.getElementById("street");
        var length = yol.options.length;
        for (i = 0; i < length; i++) {
            yol.remove(i);
        }
        addressQuery.getYols(mahalleId, function (response) {
            if (response) {
                var x = document.getElementById("street");
                var option = document.createElement("option");
                option.text = "YOL SECINIZ !";
                option.value = "0";
                x.add(option);
                for (var i in response) {


                    var option = document.createElement("option");
                    option.text = response[i].value;
                    option.value = response[i].key;
                    x.add(option);
                }
                document.mapView.selection.clearFeatures();
                document.mapView.getFeaturesWithLayerNameAndKey("MAHALLE", mahalleId, function (result) {
                    if (result) {
                        document.mapView.zoomToFeature(result[0]);
                    }
                });
            }
        })
    }

    function kapiSetle() {
        var e = document.getElementById("street");
        var yolId = e.options[e.selectedIndex].value;
        var kapi = document.getElementById("building");
        var length = kapi.options.length;
        for (i = 0; i < length; i++) {
            kapi.remove(i);
        }
        addressQuery.getKapis(yolId, function (response) {
            if (response) {
                var x = document.getElementById("building");
                var option = document.createElement("option");
                option.text = "KAPI SECINIZ !";
                option.value = "0";
                x.add(option);
                for (var i in response) {
// console.log(response[i]);

                    var option = document.createElement("option");
                    option.text = response[i].value;
                    option.value = response[i].key;
                    x.add(option);
                }
                document.mapView.selection.clearFeatures();

                document.mapView.getFeaturesWithLayerNameAndKey("YOL", yolId, function (result) {
                    if (result) {
                        document.mapView.zoomToFeature(result[0]);
                    }
                });
            }
        })
    }

    function konumSetle() {
        var e = document.getElementById("building");
        var kapiId = e.options[e.selectedIndex].value;


        var tonwId = document.getElementById('tonwId').options[document.getElementById('tonwId').selectedIndex].text;
        var district = document.getElementById('district').options[document.getElementById('district').selectedIndex].text;
        var street = document.getElementById('street').options[document.getElementById('street').selectedIndex].text;
        var streetValue = document.getElementById('street').options[document.getElementById('street').selectedIndex].value;
        var building = document.getElementById('building').options[document.getElementById('building').selectedIndex].text;
        var caddeSokak = "Yol";
        addressQuery.getFeaturesWithLayerNameAndKey("YOL", streetValue, function (response) {
            caddeSokak = response[0].YolTuru;
            document.getElementById('inputDescription').value = ( district + " Mah. " + street + " " + caddeSokak + " No : " + building + " / " + tonwId).toUpperCase();
            showPoint(kapiId);
        });


    }

    function showPoint(uavt) {

        document.mapView.selection.clearFeatures();
        document.mapView.filtering.clearFeatures();
        document.mapView.drawing.clearFeatures();


        var query = new QueryFilter("RUHSAT_POINT");
        query.and(query.equals("featuretype", "ruhsat")).and(query.equals("featurekey", uavt));
        document.mapView.filtering.filter(query, {color: 'green'});

    }
</script>

</body>
</html>