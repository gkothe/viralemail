//@ sourceURL=open_campanha_lucy.js

$(document).ready(function() {

	var leadid = getParameterByName('l') == undefined ? '' : getParameterByName('l');
	$("#leadid").val(leadid);
	
	

	$("#btn_sendmails").click(function() {
		
		enviarEmails();
	});
});
 

function enviarEmails() {

	var data = {}
	data["cmd"] = "sendEmailsTemplate2";
	data["email_adress_1"] = $("#email_adress_1").val();
	data["email_adress_2"] = $("#email_adress_2").val();
	data["email_adress_3"] = $("#email_adress_3").val();
	data["leadid"] = $("#leadid").val();

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
				sysMsg(data.msg, 'M');
				
			} else {
				$.unblockUI();
				sysMsg(data.erro, 'E');
			}

			$.unblockUI();

		},
		error : function(msg) {
			$.unblockUI();
		}
	});

};