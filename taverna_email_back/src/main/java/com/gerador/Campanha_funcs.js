function salvarCampanha() {var data = {} 
data["cmd"] =''; 
data["id_campanha"] =  $("#id_campanha").autoNumeric('get'); 
data["id_usuario"] =  $("#id_usuario").autoNumeric('get'); 
data["data_criacao"] =  $("#data_criacao").val(); 
data["link_inicial"] =  $("#link_inicial").val(); 
data["desc_nome"] =  $("#desc_nome").val(); 
data["desc_obs"] =  $("#desc_obs").val(); 
data["flag_ativo"] =  $("#flag_ativo").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarcampanha(); }); $("#id_campanha").autoNumeric('init',inteiro); 
 $("#id_usuario").autoNumeric('init',inteiro); 
});function listaCampanha() {var data = {} 
data["cmd"] =''; 
data["id_campanha"] =  $("#id_campanha").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_campanha").autoNumeric('set',data.id_campanha); 
 $("#id_usuario").autoNumeric('set',data.id_usuario); 
$("#data_criacao").val(data.data_criacao); 
$("#link_inicial").val(data.link_inicial); 
$("#desc_nome").val(data.desc_nome); 
$("#desc_obs").val(data.desc_obs); 
$("#flag_ativo").val(data.flag_ativo); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}