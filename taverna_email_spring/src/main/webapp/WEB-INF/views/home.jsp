<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>HelloWorld page</title>
</head>
<body>
	<div align="center">
		<div class="loginBox">
			<form action="" method="post">
				<br> <br> <br>
				<div class="container">
					<input type="hidden" name="acao" id="acao" value="log">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
							align="center">
							<div class="panel panel-default" style="width: 400px">

								<div class="panel-heading">
									<img src="images/logo.png"
										style="max-width: 350px; padding-left: 10px;">
								</div>
								<div class="panel-body">

									<label for="" class="">Usu�rio</label> <input id="username"
										class="form-control" placeholder="Usu�rio" name="username"
										required autofocus> <br> <label for="" class="">Senha</label>
									<label for="inputPassword" class="sr-only">Password</label> <input
										type="password" name="password" id="password"
										class="form-control" placeholder="Senha" required> <br>
									<button class="btn btn-lg btn-primary btn-block" type="submit" 
										name="submit">Entrar</button>
										<button class="btn btn-lg btn-primary btn-block"  type="button" id="cadastro">Cadastrar-se</button>
									<br>
						

									<br> <label for="" class="">Esqueceu sua senha \
										usu�rio? Clique abaixo.</label>
									<button class="btn btn-lg btn-primary btn-block" type="button"
										onclick="showTrocaEmail();">Recuperar Senha \
										Usu�rio</button>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /container -->
			</form>
		</div>
	</div>


	<div class="modal fade bs-example-modal-lg" tabindex="-50"
		role="dialog" id="modal_ajuda" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header" align="center">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">�</span>
					</button>
					<h4 class="modal-title" id="">
						<label style="font-size: 20px; color: black">Recuperar
							Senha \ Usu�rio. </label>
					</h4>
				</div>
				<div class="modal-body" style="max-height: 800px; overflow: auto;">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ">

							<div class="form-group">
								<label for="desc_mail">Preencha o seu e-mail cadastrado
									abaixo:</label> <input type="text" class="form-control warn-change"
									id="r_desc_mail" />
							</div>

						</div>
					</div>
					<div class="modal-footer">
						<div class="row">
							<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 " align="left">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">Fechar</button>
							</div>

							<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 "></div>
							<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 " align="right">
								<button type="button" id="btn_envia_email"
									class="btn btn-primary">Enviar</button>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade bs-example-modal-lg" tabindex="-5" role="dialog"
		id="modal_erros" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<div class="modal-header" align="center">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">�</span>
					</button>
					<h4 class="modal-title" id="msg_erro_aviso">
						<label style="font-size: 20px; color: red" id="">ERRO!</label>
					</h4>
				</div>
				<div class="modal-body" style="max-height: 800px; overflow: auto;">

					<div class="row">

						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
							<strong>Mensagem:</strong>&nbsp;<label id="msg_erro"></label>
						</div>


					</div>

				</div>
				<div class="modal-footer">

					<div class="row">

						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10 "></div>


						<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 " align="right">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Fechar</button>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>