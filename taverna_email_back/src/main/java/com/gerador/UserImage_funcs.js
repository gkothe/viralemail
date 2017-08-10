function salvarUserImage() {var data = {} 
data["cmd"] =''; 
data["id_image"] =  $("#id_image").autoNumeric('get'); 
data["id_usuario"] =  $("#id_usuario").autoNumeric('get'); 
data["desc_image"] =  $("#desc_image").val(); 
data["desc_path_system"] =  $("#desc_path_system").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvaruser_image(); }); $("#id_image").autoNumeric('init',inteiro); 
 $("#id_usuario").autoNumeric('init',inteiro); 
});function listaUserImage() {var data = {} 
data["cmd"] =''; 
data["id_image"] =  $("#id_image").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_image").autoNumeric('set',data.id_image); 
 $("#id_usuario").autoNumeric('set',data.id_usuario); 
$("#desc_image").val(data.desc_image); 
$("#desc_path_system").val(data.desc_path_system); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}