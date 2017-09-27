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


	setAutocomplete("id_produto", "desc_produto");

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


	configuraTabela("table_campanhas");
	
	
});



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
		$('th', $('#table_campanhas')).css('background-color', 'rgb(248, 248, 248)');
	});

	$(tabela).on('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function() {
		$('#table_campanhas').bootstrapTable('updateFooter');
	});

	$(tabela).on('click-cell.bs.table', function(field, value, row, $element) {
		//visualizarPedidoHistorico($element.ID_PEDIDO);
	});

	$(tabela).on('page-change.bs.table', function(e, pag, size) {
		$(".openpedido").click(function() {
			//visualizarPedidoHistorico($(this).attr("data-valor"));
		});

		loadCampanhas(pag, size);
	});

	$(tabela).on('sort.bs.table', function(e, name, order) {
		$("#sys_order").val(order);
		$("#sys_name").val(name);

		//loadCampanhas(1, 10);

	});

	$("#sys_name").val("NUM_PED");
	$("#sys_order").val("asc");
	$(tabela).bootstrapTable('resetView');
	
}