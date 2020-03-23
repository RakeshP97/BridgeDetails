<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
<title>Bridge Details</title>
<meta charset="UTF-8">
<script>
var baseUrl = "http://localhost:8082/BridgeDetails/bridge-module/addNew/";
function loadBridgeDetails(){
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", baseUrl + "bridge", true);
	xmlhttp.onreadystatechange = function(){
		if(xmlhttp.readyState ==4 && xmlhttp.status == 200)
			{
			var bridge = JSON.parse(xmlhttp.responseText);
			var tbltop = '<table><tr style="font-family:Calbari"><th>Name</th><th>Lenght</th><th>Heigth</th> <th>Width</th> <th>Gps Loaction</th> </tr>';
			//main 
			//var bridge = bridgeDetails.employees;
			var main = "";
			for (i =0; i< bridge.length;i++)
				{
				main+="<tr><td>"+bridge[i].name+"</td><td>"+bridge[i].length+"</td><td>"+bridge[i].heigth+"</td><td>"+bridge[i].width+"</td><td>"+bridge[i].gpsLocation+"</td></tr>";
				
				}
			var tblbottom = "</table>";
			var tbl = tbltop + main + tblbottom;
			document.getElementById("bridgeInfo").innerHTML = tbl;
			
			}
	};
	xmlhttp.send();
}
window.onload = function(){
	loadBridgeDetails();
	clearForm();
	document.bridge.reset();
}

var form = document.getElementById("bridge");
form.onsubmit = function(){
  form.reset();
}

function clearForm()
{
    document.getElementById("formData.name").value=""; 
    document.getElementById("formData.length").value=""; 
    document.getElementById("formData.heigth").value="";
    document.getElementById("formData.width").value="";
    document.getElementById("formData.gpsLocation").value="";
}
</script>
</head>
<body>
<form:form name="bridge" id="bridge" method="post" modelAttribute="formData">
        <table>
            <tr>
                <td><spring:message code="formData.name" text="Bridge Name:" /></td>
                <td><form:input path="name" value="" /></td>
            </tr>
            <tr>
                <td><spring:message code="formData.length" text="Bridge Length:" /></td>
                <td><form:input path="length" value="" /></td>
            </tr>
              <tr>
                <td><spring:message code="formData.heigth" text="Bridge Height:" /></td>
                <td><form:input path="height" value="" /></td>
            </tr>
              <tr>
                <td><spring:message code="formData.width" text="Bridge Width:" /></td>
                <td><form:input path="width" value="" /></td>
            </tr>
              <tr>
                <td><spring:message code="formData.gpsLocation" text="Bridge GpsLocation:" /></td>
                <td><form:input path="gpsLocation" value="" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" onclick="clearForm()" value="Add Bridge"/></td>
            </tr>
        </table>
    </form:form>
    
<div id="bridgeInfo"></div>
</body>
</html>
