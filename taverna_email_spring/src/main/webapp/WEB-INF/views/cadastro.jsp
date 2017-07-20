<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ">
<head>
<link href=" <c:url value="/resources/js/bootstrap-3.3.7-dist/css/bootstrap.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-3.3.7-dist/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/index.js" />"></script>
</head>
<title>Cadastro</title>
</head>
<body>
	<div class="x_title">
		<div class="row">
			<div class="col-xs-12 col-md-12 col-lg-12">
				<div class="form-group">
					<label style="font-size: 30px" for="">Cadastro de usuário</label>&nbsp;&nbsp;
				</div>
			</div>
		</div>
	</div>
	<div class="x_content">
		<div style="width: 95%; height: 100%" class="container bs-docs-container">
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>Nome</label> <input type="text" class="form-control warn-change" maxlength="100" id="desc_nome" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>Telefone</label> <input type="text" class="form-control warn-change" maxlength="50" id="desc_telefone" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-4 col-md-4 col-lg-4">
					<div class="form-group">
						<label>Município</label>
						<div style="width: 100%" class="input-group">
							<select id="cod_cidade">
								<option value="1">Santa Cruz do Sul</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>Endereço</label> <input type="text" class="form-control warn-change" id="desc_endereco" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>Número</label> <input type="number" class="form-control warn-change" id="num_endereco" maxlength="10" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>Complemento</label> <input type="text" class="form-control warn-change" id="desc_complemento" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>CEP</label> <input type="text" class="form-control warn-change" id="desc_cep" maxlength="8" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>e-Mail</label> <input type="text" class="form-control warn-change" id="desc_email" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>Usuario</label> <input type="text" class="form-control warn-change" id="desc_user" maxlength="45" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>Senha</label> <input type="password" class="form-control warn-change" id="desc_senha" maxlength="45" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class=" col-xs-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label>Repita Senha</label> <input type="password" class="form-control warn-change" id="desc_senha_repita"
							maxlength="45" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-12 col-lg-12 ">
				<button class="btn btn-primary  " type="button" id="btn_cadastrar" id="">Cadastrar</button>
			</div>
		</div>
	</div>
	<input id="sys_formatador" type="hidden">
</body>
</html>
