<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<head>
<link rel="import" href="resources.html">
<script type="text/javascript" src="js/cadastro.js"></script>
</head></head>
<style type="text/css">
body {
	background: url(images/back3.png) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
<%
	String msg = "";
	if (request.getAttribute("msg") != null) {
		msg = request.getAttribute("msg").toString();
	}
	boolean erro = false;
	if (request.getAttribute("erro") != null) {
		erro = Boolean.parseBoolean(request.getAttribute("erro").toString());
	}
%>
<body>
	<div align="center">
		<br> <br> <br>
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" align="center">
				<div class="panel panel-default" style="width: 70%; left: 5%; right: 5%">
					<div class="panel-heading">
						<img src="images/logo.png" style="max-width: 350px; padding-left: 10px;">
					</div>
					<div class="panel-body">
						<%
							if (!erro) {
						%>
						<div class="alert alert-success  fade in" role="alert">
							<%=msg%>
						</div>
						<%
							} else {
						%>
						<div class="alert alert-danger  fade in" role="alert">
							<%=msg%>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>