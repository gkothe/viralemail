function salvarCampanhaEmail() {var data = {} 
data["cmd"] =''; 
data["id_email"] =  $("#id_email").autoNumeric('get'); 
data["id_campanha"] =  $("#id_campanha").autoNumeric('get'); 
data["desc_email"] =  $("#desc_email").val(); 
data["desc_titulo"] =  $("#desc_titulo").val(); 
data["qtd_referencia"] =  $("#qtd_referencia").autoNumeric('get'); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarcampanha_email(); }); $("#id_email").autoNumeric('init',inteiro); 
 $("#id_campanha").autoNumeric('init',inteiro); 
 $("#qtd_referencia").autoNumeric('init',inteiro); 
});function listaCampanhaEmail() {var data = {} 
data["cmd"] =''; 
data["id_email"] =  $("#id_email").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_email").autoNumeric('set',data.id_email); 
 $("#id_campanha").autoNumeric('set',data.id_campanha); 
$("#desc_email").val(data.desc_email); 
$("#desc_titulo").val(data.desc_titulo); 
 $("#qtd_referencia").autoNumeric('set',data.qtd_referencia); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}