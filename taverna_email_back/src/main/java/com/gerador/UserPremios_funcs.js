function salvarUserPremios() {var data = {} 
data["cmd"] =''; 
data["id_premio"] =  $("#id_premio").autoNumeric('get'); 
data["id_usuario"] =  $("#id_usuario").autoNumeric('get'); 
data["desc_name"] =  $("#desc_name").val(); 
data["desc_extensao"] =  $("#desc_extensao").val(); 
data["desc_path"] =  $("#desc_path").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvaruser_premios(); }); $("#id_premio").autoNumeric('init',inteiro); 
 $("#id_usuario").autoNumeric('init',inteiro); 
});function listaUserPremios() {var data = {} 
data["cmd"] =''; 
data["id_premio"] =  $("#id_premio").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_premio").autoNumeric('set',data.id_premio); 
 $("#id_usuario").autoNumeric('set',data.id_usuario); 
$("#desc_name").val(data.desc_name); 
$("#desc_extensao").val(data.desc_extensao); 
$("#desc_path").val(data.desc_path); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}