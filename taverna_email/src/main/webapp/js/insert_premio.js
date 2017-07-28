//@ sourceURL=campanha_insert.js

$(document).ready(function() {
	$("#btn_inserir").click(function() {
		insertCamapnha();
	});

});

function insertCamapnha() {

	var data = {}
	data["cmd"] = "insertPremio";
	data["desc_name"] = $("#desc_name").val();
	data["desc_path"] = $("#desc_path").val();

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