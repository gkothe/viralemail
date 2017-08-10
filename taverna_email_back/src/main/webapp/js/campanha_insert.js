//@ sourceURL=campanha_insert.js

$(document).ready(function() {
	$("#btn_inserir").click(function() {
		insertCamapnha();
	});

});

function insertCamapnha() {

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