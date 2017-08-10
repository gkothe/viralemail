function salvarCampanhaThankspage() {var data = {} 
data["cmd"] =''; 
data["id_thankspage"] =  $("#id_thankspage").autoNumeric('get'); 
data["id_campanha"] =  $("#id_campanha").autoNumeric('get'); 
data["msg_thanks"] =  $("#msg_thanks").val(); 
data["sub_titulo"] =  $("#sub_titulo").val(); 
data["url_video"] =  $("#url_video").val(); 
data["desc_frase"] =  $("#desc_frase").val(); 
data["desc_frase2"] =  $("#desc_frase2").val(); 
data["desc_texto"] =  $("#desc_texto").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarcampanha_thankspage(); }); $("#id_thankspage").autoNumeric('init',inteiro); 
 $("#id_campanha").autoNumeric('init',inteiro); 
});function listaCampanhaThankspage() {var data = {} 
data["cmd"] =''; 
data["id_thankspage"] =  $("#id_thankspage").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_thankspage").autoNumeric('set',data.id_thankspage); 
 $("#id_campanha").autoNumeric('set',data.id_campanha); 
$("#msg_thanks").val(data.msg_thanks); 
$("#sub_titulo").val(data.sub_titulo); 
$("#url_video").val(data.url_video); 
$("#desc_frase").val(data.desc_frase); 
$("#desc_frase2").val(data.desc_frase2); 
$("#desc_texto").val(data.desc_texto); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}