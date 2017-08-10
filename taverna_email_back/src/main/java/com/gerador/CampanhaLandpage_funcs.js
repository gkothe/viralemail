function salvarCampanhaLandpage() {var data = {} 
data["cmd"] =''; 
data["id_landpage"] =  $("#id_landpage").autoNumeric('get'); 
data["id_campanha"] =  $("#id_campanha").autoNumeric('get'); 
data["desc_titulo_1"] =  $("#desc_titulo_1").val(); 
data["desc_sub_titulo_1"] =  $("#desc_sub_titulo_1").val(); 
data["url_video"] =  $("#url_video").val(); 
data["desc_campanha"] =  $("#desc_campanha").val(); 
data["desc_titulo_2"] =  $("#desc_titulo_2").val(); 
data["sub_titulo_2"] =  $("#sub_titulo_2").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarcampanha_landpage(); }); $("#id_landpage").autoNumeric('init',inteiro); 
 $("#id_campanha").autoNumeric('init',inteiro); 
});function listaCampanhaLandpage() {var data = {} 
data["cmd"] =''; 
data["id_landpage"] =  $("#id_landpage").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_landpage").autoNumeric('set',data.id_landpage); 
 $("#id_campanha").autoNumeric('set',data.id_campanha); 
$("#desc_titulo_1").val(data.desc_titulo_1); 
$("#desc_sub_titulo_1").val(data.desc_sub_titulo_1); 
$("#url_video").val(data.url_video); 
$("#desc_campanha").val(data.desc_campanha); 
$("#desc_titulo_2").val(data.desc_titulo_2); 
$("#sub_titulo_2").val(data.sub_titulo_2); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}