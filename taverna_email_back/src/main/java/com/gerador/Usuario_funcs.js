function salvarUsuario() {var data = {} 
data["cmd"] =''; 
data["id_usuario"] =  $("#id_usuario").autoNumeric('get'); 
data["cod_cidade"] =  $("#cod_cidade").autoNumeric('get'); 
data["desc_nome"] =  $("#desc_nome").val(); 
data["desc_telefone"] =  $("#desc_telefone").val(); 
data["desc_endereco"] =  $("#desc_endereco").val(); 
data["num_enderec"] =  $("#num_enderec").val(); 
data["desc_complemento"] =  $("#desc_complemento").val(); 
data["desc_login"] =  $("#desc_login").val(); 
data["desc_senha"] =  $("#desc_senha").val(); 
data["desc_mail"] =  $("#desc_mail").val(); 
data["flag_ativo"] =  $("#flag_ativo").val(); 
data["date_lastajax"] =  $("#date_lastajax").val(); 
data["num_cpf"] =  $("#num_cpf").val(); 
data["desc_cep"] =  $("#desc_cep").val(); 
data["flag_ativado"] =  $("#flag_ativado").val(); 
data["chave_ativacao"] =  $("#chave_ativacao").val(); 
data["desc_novoemailvalidacao"] =  $("#desc_novoemailvalidacao").val(); 
data["chave_ativacao_novoemail"] =  $("#chave_ativacao_novoemail").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarusuario(); }); $("#id_usuario").autoNumeric('init',inteiro); 
 $("#cod_cidade").autoNumeric('init',inteiro); 
});function listaUsuario() {var data = {} 
data["cmd"] =''; 
data["id_usuario"] =  $("#id_usuario").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_usuario").autoNumeric('set',data.id_usuario); 
 $("#cod_cidade").autoNumeric('set',data.cod_cidade); 
$("#desc_nome").val(data.desc_nome); 
$("#desc_telefone").val(data.desc_telefone); 
$("#desc_endereco").val(data.desc_endereco); 
$("#num_enderec").val(data.num_enderec); 
$("#desc_complemento").val(data.desc_complemento); 
$("#desc_login").val(data.desc_login); 
$("#desc_senha").val(data.desc_senha); 
$("#desc_mail").val(data.desc_mail); 
$("#flag_ativo").val(data.flag_ativo); 
$("#date_lastajax").val(data.date_lastajax); 
$("#num_cpf").val(data.num_cpf); 
$("#desc_cep").val(data.desc_cep); 
$("#flag_ativado").val(data.flag_ativado); 
$("#chave_ativacao").val(data.chave_ativacao); 
$("#desc_novoemailvalidacao").val(data.desc_novoemailvalidacao); 
$("#chave_ativacao_novoemail").val(data.chave_ativacao_novoemail); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}