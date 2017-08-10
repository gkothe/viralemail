function salvarCidade() {var data = {} 
data["cmd"] =''; 
data["cod_cidade"] =  $("#cod_cidade").autoNumeric('get'); 
data["desc_cidade"] =  $("#desc_cidade").val(); 
data["id_estado"] =  $("#id_estado").autoNumeric('get'); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarcidade(); }); $("#cod_cidade").autoNumeric('init',inteiro); 
 $("#id_estado").autoNumeric('init',inteiro); 
});function listaCidade() {var data = {} 
data["cmd"] =''; 
data["cod_cidade"] =  $("#cod_cidade").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#cod_cidade").autoNumeric('set',data.cod_cidade); 
$("#desc_cidade").val(data.desc_cidade); 
 $("#id_estado").autoNumeric('set',data.id_estado); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}