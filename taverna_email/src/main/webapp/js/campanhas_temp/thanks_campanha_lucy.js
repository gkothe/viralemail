//@ sourceURL=open_campanha_lucy.js

$(document).ready(function() {

	var lref = getParameterByName('l') == undefined ? '' : getParameterByName('l');

	LoadLeadRefById(lref);

	new Clipboard('.clip');
});
 

function LoadLeadRefById(lref) {

	var data = {}
	data["cmd"] = "LoadLeadRefById";
	data["l"] = lref;

	$.blockUI({
		message : 'Carregando...'
	});

	$.ajax({
		type : "POST",
		url : "?acao=ajax_w",
		data : data,
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
			if (data.msgok == 'ok') {
				
				$("#ipt_link_1").val(data.link);
				$("#ipt_link_2").val(data.link);
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

};