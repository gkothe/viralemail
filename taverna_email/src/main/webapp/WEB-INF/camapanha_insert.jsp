<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="import" href="resources.html">
<script type="text/javascript" src="js/campanha_insert.js"></script>
</head>
<body>
	<div class="x_title">
		<div class="row">
			<div class="col-xs-12 col-md-12 col-lg-12">
				<div class="form-group">
					<label style="font-size: 30px" for="">Criando uma campanha</label>
				</div>
			</div>
		</div>
	</div>
	<div class="x_content">
		<div class="row">
			<div class="col-xs-6 col-md-6 col-lg-6">
				<div class="form-group">
					<label>Nome da Camapanha</label> <input type="text" class="form-control warn-change" id="desc_nome" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6 col-md-6 col-lg-6">
				<div class="form-group">
					<label>Obvservação</label> <input type="text" class="form-control warn-change" id="desc_observacao" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class=" col-xs-6 col-md-6 col-lg-6">
				<button class="btn btn-lg btn-primary btn-block" type="button" id="btn_inserir">Criar</button>
			</div>
		</div>
	</div>
	<input id="sys_formatador" type="hidden">
	<div id="resources_html"></div>
</body>
</html>