//@ sourceURL=lista_campanhas.js
var rstimer = false;
$(window).resize(function() {
	if (rstimer) {
		clearTimeout(rstimer);
	}

	rstimer = setTimeout(function() {
		$('#table_campanhas').bootstrapTable('resetView');
	}, 500);
});

$(document).ready(function() {

	configuraTabela("table_campanhas");

	$('.data').datepicker({
		format : 'dd/mm/yyyy',
		language : 'pt-BR',
		todayHighlight : true,
		daysOfWeekHighlighted : "0,6",
	});

	$('.hora').timepicker({
		minuteStep : 1,
		showSeconds : false,
		showMeridian : false,
		defaultTime : false
	});



	listaCampanhas();
	
});

function listaCampanhas() {
	var data = {}
	data["cmd"] = 'listaCampanhas';
	
	$.blockUI({
		message : 'Salvando...'
	});
	$.ajax({
		type : "POST",
		url : "?ac=ajax",
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
				
				$('#table_campanhas').bootstrapTable('load', data.rows);
				$('#table_campanhas').bootstrapTable('resetView');
				$('[data-toggle="tooltip"]').tooltip();

		
			$.unblockUI();
		},
		error : function(msg) {
			$.unblockUI();
		}
	});
}

function visualizarCampanha(id){
	
	trocaPagbyRef("campanha_detail","N",undefined,id);
	
}

function configuraTabela(table){
	
	var tabela = $("#"+table);

	$('.keep-open', $('.fixed-table-toolbar')).prependTo($('#colunas'));
	$('.fixed-table-toolbar').remove();
	$('#colunas').addClass("fixed-table-toolbar");
	$('label', $('#colunas')).css('padding', '3px 20px').css('font-weight', 'normal');
	$('.dropdown-menu', $('#colunas')).css('min-width', '180px');
	
	
	$(tabela).bootstrapTable().on('dbl-click-cell.bs.table', function(field, value, row, element) {

	});

	$(tabela).on('sort.bs.table reset-view.bs.table post-body.bs.table', function() {
		$('th', $('#'+table)).css('background-color', 'rgb(248, 248, 248)');
	});

	$(tabela).on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function() {
		$('#'+table).bootstrapTable('updateFooter');
	});

	$(tabela).on('click-cell.bs.table', function(field, value, row, $element) {
		visualizarCampanha($element.id_campanha);
		
	});

	$(tabela).on('page-change.bs.table', function(e, pag, size) {


	});

	$(tabela).on('sort.bs.table', function(e, name, order) {
		$("#sys_order").val(order);
		$("#sys_name").val(name);

	});

	$("#sys_name").val("data_criacao");
	$("#sys_order").val("asc");
	$(tabela).bootstrapTable('resetView');
	

	
	
	
}