<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="import" href="resources.html">
<script type="text/javascript" src="js/campanha_edit.js"></script>
</head>
<body>
	<div class="x_title">
		<div class="row">
			<div class="col-xs-12 col-md-12 col-lg-12">
				<div class="form-group">
					<label style="font-size: 30px" for="">Editando/Inserido sua campanha id x</label>
				</div>
			</div>
		</div>
	</div>
	<div class="x_content">
		<!-- Nav tabs -->
		<ul class="nav nav-pills" id="tab_campanha" role="tablist">
			<li role="presentation" class="active"><a href="#campanha_insert" aria-controls="home" role="tab"
				data-toggle="tab">Início</a></li>
			<li role="presentation"><a href="#landpage" aria-controls="home" role="tab" data-toggle="tab">Início</a></li>
			<li role="presentation"><a href="#emails" role="tab" data-toggle="tab">Bairros</a></li>
			<li role="presentation"><a href="#thankspage" role="tab" data-toggle="tab">Dias e horários</a></li>
		</ul>
		<!-- Tab panes -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="landpage">
				<div class="row">
					<div class="col-xs-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label>Desc_titulo 1</label> <input type="text" class="form-control warn-change" id="desc_titulo_1" />
						</div>
					</div>
					<div class="col-xs-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label>Desc_sub_titulo 1</label> <input type="text" class="form-control warn-change" id="desc_sub_titulo_1" />
						</div>
					</div>
					<div class="col-xs-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label>url_video </label> <input type="text" class="form-control warn-change" id="url_video" />
						</div>
					</div>
					<div class="col-xs-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label>desc_campanha </label> <input type="text" class="form-control warn-change" id="desc_campanha" />
						</div>
					</div>
					<div class="col-xs-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label>DESC_TITULO_2 </label> <input type="text" class="form-control warn-change" id="desc_titulo_2" />
						</div>
					</div>
					<div class="col-xs-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label>sub_titulo_2 </label> <input type="text" class="form-control warn-change" id="sub_titulo_2" />
						</div>
					</div>
					<div class="col-xs-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label>Upload de imagens *** Pensar 
						</div>
					</div>
					<div class="row">
						<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
							<table>
								<tr>
									<td style="width: 300px" align="right">
										<div class="form-group">
											<button type="button" id="btn_salvar" class="btn btn-primary">Salvar</button>
										</div>
									<td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane " id="emails">
				<div style="width: 98%; height: 100%" class="container bs-docs-container">
					<Br>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 " align="left">
							<label for=""> Escolha os bairros que dejesa sobrescrever ou adicionar novos horários.</label>&nbsp;&nbsp; <span
								data-toggle="tooltip"
								title="Esta tela lhe ajudará a configurar seus bairros de entrega. Primeiramento você deverá escolher os bairros que deseja estar disponível para realizar entregas. Ex: Se você estiver apto a entregar em todos os bairros, clique em 'Marcar todos'. Se você deseja entregar em todos, com exceção do bairro Senai e Linha Santa Cruz, clique em 'Marcar todos' e desrmarque Senai e Linha Santa Cruz manualmente."><label>
									Ajuda:</label> <span class="glyphicon glyphicon-question-sign" style="color: blue"></span></span>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 " align="left">
							<table>
								<tbody id="tab_wizard_bairros"></tbody>
								<tfoot>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="2"><button type="button" class="btn btn-primary" id="marca_bairros">Marcar Todos</button>
											<button type="button" class="btn btn-primary" id="desmarca_bairros">Desmarcar Todos</button></td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
							<table>
								<tr>
									<td style="width: 300px" align="right">
										<div class="form-group">
											<button type="button" id="btn_prox_1" class="btn btn-primary">Continuar</button>
										</div>
									<td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane" id="thankspage"></div>
		</div>
	</div>
	<input id="sys_formatador" type="hidden">
	<input id="id_campanha" type="hidden">
	<div id="resources_html"></div>
</body>
</html>