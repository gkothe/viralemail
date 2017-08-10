function salvarCampanhaEmailPremio() {var data = {} 
data["cmd"] =''; 
data["id_email"] =  $("#id_email").autoNumeric('get'); 
data["id_premio"] =  $("#id_premio").autoNumeric('get'); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarcampanha_email_premio(); }); $("#id_email").autoNumeric('init',inteiro); 
 $("#id_premio").autoNumeric('init',inteiro); 
});function listaCampanhaEmailPremio() {var data = {} 
data["cmd"] =''; 
data["id_email"] =  $("#id_email").autoNumeric('get'); 
data["id_premio"] =  $("#id_premio").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_email").autoNumeric('set',data.id_email); 
 $("#id_premio").autoNumeric('set',data.id_premio); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}