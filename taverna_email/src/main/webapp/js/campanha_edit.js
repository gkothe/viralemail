//@ sourceURL=campanha_insert.js

$(document).ready(function() {

	var id_campanha = getParameterByName('id');
	$("#id_campanha").val(id_campanha);

	$("#btn_salvar").click(function() {
		salvarCampanha($("#id_campanha").val());
	});

});

function salvarCampanha(id) {

	var data = {}
	data["cmd"] = "updateCamapanha";
	data["id_campanha"] = id;
	data["desc_titulo_1"] = $("#desc_titulo_1").val();
	data["desc_sub_titulo_1"] = $("#desc_sub_titulo_1").val();
	data["url_video"] = $("#url_video").val();
	data["desc_campanha"] = $("#desc_campanha").val();
	data["desc_titulo_2"] = $("#desc_titulo_2").val();
	data["sub_titulo_2"] = $("#sub_titulo_2").val();

	$.blockUI({
		message : 'Salvando...'
	});

	$.ajax({
		type : "POST",
		url : "home?ac=ajax",
		data : data,
		// url : "home?ac=ajax",
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
			if (data.msgok == 'ok') {

				sysMsg(data.msg, 'M')

			} else {
				$.unblockUI();
				sysMsg(data.erro, 'E')
			}

			$.unblockUI();

		},
		error : function(msg) {
			$.unblockUI();
		}
	});

}

function loadCamapnha(id) {

	var data = {}
	data["cmd"] = "insertCamapanha";
	data["desc_nome"] = $("#desc_nome").val();
	data["desc_observacao"] = $("#desc_observacao").val();

	$.blockUI({
		message : 'Salvando...'
	});

	$.ajax({
		type : "POST",
		url : "home?ac=ajax",
		data : data,
		// url : "home?ac=ajax",
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
			if (data.msgok == 'ok') {

				console.log(data.id_campanha)
				sysMsg(data.msg, 'M')

			} else {
				$.unblockUI();
				sysMsg(data.erro, 'E')
			}

			$.unblockUI();

		},
		error : function(msg) {
			$.unblockUI();
		}
	});
}