function salvarCampanhaLeads() {var data = {} 
data["cmd"] =''; 
data["id_lead"] =  $("#id_lead").autoNumeric('get'); 
data["id_campanha"] =  $("#id_campanha").autoNumeric('get'); 
data["id_lead_referencia"] =  $("#id_lead_referencia").autoNumeric('get'); 
data["desc_email"] =  $("#desc_email").val(); 
data["desc_link_referal"] =  $("#desc_link_referal").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarcampanha_leads(); }); $("#id_lead").autoNumeric('init',inteiro); 
 $("#id_campanha").autoNumeric('init',inteiro); 
 $("#id_lead_referencia").autoNumeric('init',inteiro); 
});function listaCampanhaLeads() {var data = {} 
data["cmd"] =''; 
data["id_lead"] =  $("#id_lead").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_lead").autoNumeric('set',data.id_lead); 
 $("#id_campanha").autoNumeric('set',data.id_campanha); 
 $("#id_lead_referencia").autoNumeric('set',data.id_lead_referencia); 
$("#desc_email").val(data.desc_email); 
$("#desc_link_referal").val(data.desc_link_referal); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}