function salvarUserImagePage() {var data = {} 
data["cmd"] =''; 
data["id_associacao"] =  $("#id_associacao").autoNumeric('get'); 
data["id_image"] =  $("#id_image").autoNumeric('get'); 
data["id_page"] =  $("#id_page").val(); 
data["flag_pagetipe"] =  $("#flag_pagetipe").val(); 
data["id_campanha"] =  $("#id_campanha").autoNumeric('get'); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvaruser_image_page(); }); $("#id_associacao").autoNumeric('init',inteiro); 
 $("#id_image").autoNumeric('init',inteiro); 
 $("#id_campanha").autoNumeric('init',inteiro); 
});function listaUserImagePage() {var data = {} 
data["cmd"] =''; 
data["id_associacao"] =  $("#id_associacao").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_associacao").autoNumeric('set',data.id_associacao); 
 $("#id_image").autoNumeric('set',data.id_image); 
$("#id_page").val(data.id_page); 
$("#flag_pagetipe").val(data.flag_pagetipe); 
 $("#id_campanha").autoNumeric('set',data.id_campanha); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}