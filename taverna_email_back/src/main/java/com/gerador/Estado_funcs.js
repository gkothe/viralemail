function salvarEstado() {var data = {} 
data["cmd"] =''; 
data["id_estado"] =  $("#id_estado").autoNumeric('get'); 
data["desc_uf"] =  $("#desc_uf").val(); 
data["desc_estado"] =  $("#desc_estado").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarestado(); }); $("#id_estado").autoNumeric('init',inteiro); 
});function listaEstado() {var data = {} 
data["cmd"] =''; 
data["id_estado"] =  $("#id_estado").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_estado").autoNumeric('set',data.id_estado); 
$("#desc_uf").val(data.desc_uf); 
$("#desc_estado").val(data.desc_estado); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}