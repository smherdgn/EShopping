<%--
  Created by IntelliJ IDEA.
  User: semih
  Date: 02.12.2016
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/templates/include-pageheader.jsp" %>

<!DOCTYPE html>
<html>
<head>


</head>
<body>
<form:form id="taskForm" class="form-horizontal" autocomplete="off" role="form">


    <div id="popup" align="center" class="col-sm-12 col-xs-12">


        <div align="center" class="form-group">


            <button onclick="calculateRoute(${uavt});" id="gotonavigation" type="button" class="btn btn-primary">
                <fmt:message key="building.navigation"/> <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
            </button>
        </div>

    </div>
</form:form>
<script> function calculateRoute(uavt) {
    var query = new QueryFilter("RUHSAT_POINT");
    query.and(query.equals("featuretype", "ruhsat")).and(query.equals("featurekey", uavt));

    document.mapView.route.calculateRoute(query);
}</script>
</body>
</html>
