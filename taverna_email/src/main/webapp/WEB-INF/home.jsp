<%@page import="com.configs.Conexao"%>
<%@page import="com.funcs.Sys_parametros"%>
<%@page import="java.sql.Connection"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<link rel="shortcut icon" href="favicon.ico" />
<title>Taverna do E-mail</title>
<script type="text/javascript" src="js/httpsredirect.js"></script>
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<!-- Bootstrap -->

<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="js/bootstrap-3.3.7-dist/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css" href="js/bootstrap-3.3.7-dist/css/bootstrap-timepicker.css">
<link rel="stylesheet" type="text/css" href="css/autocomplete.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap_date1.4.0/css/bootstrap-datepicker.css" />
<link rel="stylesheet" type="text/css" href="js/bootstrap-calendar-master/css/calendar.css" />
<link rel="stylesheet" type="text/css" href="js/boostrap_multiselect/bootstrap-multiselect.css"></link>
<link href="gentelella-master/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="gentelella-master/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<link href="gentelella-master/vendors/select2/dist/css/select2.min.css" rel="stylesheet">
<link href="gentelella-master/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
<link href="gentelella-master/production/css/custom.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/taverna.css" />
<%
	Connection conn = null;
	Sys_parametros sys = null;
	int id = 0;
	try {
		conn = Conexao.getConexao();
		sys = new Sys_parametros(conn);
		id = Integer.parseInt(request.getSession(false).getAttribute("id_user").toString());

		conn.close();
	} catch (Exception e) {

		try {
			conn.close();
		} catch (Exception e2) {
		}

	}
%>

</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container" id="main_cont" style="">
			<div class="col-md-3 left_col menucustom">
				<div class="left_col scroll-view menucustom">
					<div class="navbar nav_title" style="border: 0;">
						<a style="height: 75px;" class="site_title">
							<image style="width: 200px" src="images/teste.jpg"></image>
						</a>
					</div>
					<div class="clearfix"></div>
					<!-- menu profile quick info -->
					<div class="profile">
						<div class="profile_pic" style="padding-left: 15px; padding-top: 15px;">
							<img id="lbl_logomenu" src="images/teste.jpg" style="width: 65px" alt="...">
						</div>
						<div class="profile_info">
							<span>Loja,</span>
							<h2>
								<label id="lbl_descfanta"></label>
							</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->
					<br />
					<br>
					<br>
					<!-- sidebar menu -->
					<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>Menu</h3>
							<ul class="nav side-menu">
								<!-- 								//aqui é a seçãao -->
								<li>
									<a class="clickmenu2">
										<i class="fa fa-home clickmenu2"></i>
										Pedidos
										<span class="fa fa-chevron-down clickmenu"></span>
									</a>
									<ul class="nav child_menu">
										<li>
											<a linkmenu="campanha_lista" onMouseup="trocaPag(this,'N',event);" class="clickmenu">Campanhas</a>
										</li>
										<li>
											<a linkmenu="listapedfechado" onMouseup="trocaPag(this,'N',event);" class="clickmenu">Histórico</a>
										</li>
										<li>
											<a linkmenu="inserirpedido" onMouseup="trocaPag(this,'N',event);" class="clickmenu">Inserir pedido</a>
										</li>
										<li>
											<a linkmenu="cancelpedido" onMouseup="trocaPag(this,'N',event);" class="clickmenu">Cancelar Pedido</a>
										</li>
									</ul>
								</li>

							</ul>
						</div>
					</div>
					<!-- /sidebar menu -->
				</div>
			</div>
			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav class="" role="navigation">
						<ul class="nav navbar-nav navbar-right" style="width: 100%";>
							<li class="">
								<div style="width: 10px"></div>
							</li>
							<li class="">
								<a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<label style="font-weight: 900">Opções</label>
									<span class=" fa fa-angle-down"></span>
								</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li>
										<a href="javascript:showHelp();">
											<i class="fa fa-question pull-right"></i>
											Ajuda/Informações gerais
										</a>
									</li>

									<%
										if (id == 1) {
									%>
									<li>
										<a href="admin?ac=prod">
											<i class="fa fa-pause-circle pull-right"></i>
											Admin Area
										</a>
									</li>
									<%
										}
									%>

									<li>
										<a href="home?ac=logout">
											<i class="fa fa-sign-out pull-right"></i>
											Sair
										</a>
									</li>
								</ul>
							</li>
							<li role="presentation" class="dropdown">
								<a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
									<i class="fa fa-envelope-o"></i>
									<span class="badge bg-red" id="h_qtd_pedz"></span>
								</a>
								<ul id="menu_notification" class="dropdown-menu list-unstyled msg_list" role="menu">
								</ul>
							</li>
							<li role="presentation" data-toggle="tooltip" class="dropdown">
								<a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
									<i class="fa fa-clock-o"></i>
									<span class="badge bg-red" id="h_qtd_pedz_agend"></span>
								</a>
								<ul id="menu_notification_agend" style="overflow: auto; max-height: 300px" class="dropdown-menu list-unstyled msg_list" role="menu">
								</ul>
							</li>
							<li class="">
								<div style="width: 10px">&nbsp;&nbsp;</div>
							<li style="margin-top: 15px; width: 70%"></li>
							<div class="nav toggle clickmenu2">
								<a id="menu_toggle">
									<i class="fa fa-bars"></i>
								</a>
							</div>
						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->
			<!-- page content -->
			<div class="right_col" style="max-height: 100% !important; padding-left: 10px; padding-right: 10px;" role="main">
				<div class="x_panel" id="mainpage" style="overflow: auto; padding-left: 5px; padding-right: 5px;"></div>
			</div>
			<!-- /page content -->
			<!-- footer content -->
			<footer style="padding-bottom: 0px !important">
				<br>
			</footer>
			<!-- /footer content -->

		</div>
	</div>

	<input type="hidden" id="extra_paramfield">

	<script src="js/jquery-3.2.1.min.js"></script>


	<script type="text/javascript" src="js/inputmask/inputmask.js"></script>
	<script type="text/javascript" src="js/inputmask/inputmask.date.extensions.js"></script>
	<script type="text/javascript" src="js/inputmask/jquery.inputmask.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.4.custom/js/jquery.mask.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.4.custom/js/autoNumeric.1.9.22.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.4.custom/js/jquery.blockUI.js"></script>
	<script type="text/javascript" src="js/copyclip.js"></script>	
	<script type="text/javascript" src="gentelella-master/build/js/custom.js"></script>
	<script type="text/javascript" src="js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-3.3.7-dist/js/jquery.bootstrap-growl.js"></script>
	<script type="text/javascript" src="js/bootstrap-3.3.7-dist/js/bootstrap-timepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap_date1.4.0/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap_date1.4.0/locales/bootstrap-datepicker.pt-BR.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-calendar-master/components/underscore/underscore-min.js"></script>
	<script type="text/javascript" src="js/bootstrap-calendar-master/js/calendar.js"></script>
	<script type="text/javascript" src="js/bootstrap-calendar-master/js/language/pt-BR.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-master/dist/bootstrap-table.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-master/dist/locale/bootstrap-table-pt-BR.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-master/dist/extensions/cookie/bootstrap-table-cookie.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-master/export/tableExport.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-master/export/libs/FileSaver/FileSaver.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-master/export/libs/html2canvas/html2canvas.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-master/export/libs/jsPDF/jspdf.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-table-master/export/libs/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>
	<script type="text/javascript" src="js/boostrap_multiselect/bootstrap-multiselect.js"></script>
	<script type="text/javascript" src="js/bootstrap3-dialog-master/dist/js/bootstrap-dialog.js"></script>
</body>
<script>
	var url = "";
	var php = "";
	var menu = "";
	var extraparam= "";
	$(document).ready(function() {
<%boolean link = false;
			if (request.getParameter("link") != null && !(request.getParameter("link").equalsIgnoreCase(""))) {%>
	url = '<%=request.getParameter("link")%>';
	jsp = '<%=request.getParameter("jsp")%>';
	menu ='<%=request.getParameter("m")%>';
	extraparam ='<%=request.getParameter("extra")%>';
<%} else {%>
	url = "campanha_lista"
		jsp = "N"
		menu = "m"
		extraparam = "";
<%}%>
	$("#extra_paramfield").val(extraparam);

	});
</script>
<script type="text/javascript" src="js/menu_index.js"></script>
</html>