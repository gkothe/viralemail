//@ sourceURL=cadastro.js

$(document).ready(function() {
	
	$("#btn_cadastrar").click(function() {
		salvarCadastro();
	});

});

function salvarCadastro() {

	var data = {}
	data["cmd"] = "doCadastro";
	data["desc_nome"] = $("#desc_nome").val();
	data["desc_telefone"] = $("#desc_telefone").val();
	data["cod_cidade"] = $("#cod_cidade").val();
	data["desc_endereco"] = $("#desc_endereco").val();
	data["num_endereco"] = $("#num_endereco").val();
	data["desc_complemento"] = $("#desc_complemento").val();
	data["desc_cep"] = $("#desc_cep").val();
	data["desc_email"] = $("#desc_email").val();
	data["desc_login"] = $("#desc_login").val();
	data["desc_senha"] = $("#desc_senha").val();
	data["desc_senha_repita"] = $("#desc_senha_repita").val();
	data["num_cpf"] = $("#num_cpf").val();

	$.blockUI({
		message : 'Salvando...'
	});

	$.ajax({
		type : "POST",
		url : "home?ac=ajax_w",
		data : data,
		// url : "home?ac=ajax",
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
			if (data.msgok == 'ok') {
				sysMsg(data.msg,'M')
				setTimeout(function() {
					$.unblockUI();
					window.location = "?";
				}, 3000);

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