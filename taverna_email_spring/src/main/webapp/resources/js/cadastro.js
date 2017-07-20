//@ sourceURL=cadastro.js

$(document).ready(function() {


	$("#btn_cadastrar").click(function(){
		
		salvarCadastro();
		
	});
	
});


function salvarCadastro(){
	
		//
	
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
	data["desc_user"] = $("#desc_user").val();
	data["desc_senha"] = $("#desc_senha").val();
	data["desc_senha_repita"] = $("#desc_senha_repita").val();
		
		$.blockUI({
			message : 'Salvando...'
		});

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}cadastro/doCadastro",
			//url : "home?ac=ajax",
			dataType : "json",
			async : true,
			data : JSON.stringify(data),
			success : function(data) {
				
			},
			error : function(msg) {
				$.unblockUI();
			}
		});
		
	
};