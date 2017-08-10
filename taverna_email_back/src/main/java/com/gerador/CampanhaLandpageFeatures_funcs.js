function salvarCampanhaLandpageFeatures() {var data = {} 
data["cmd"] =''; 
data["id_landpage"] =  $("#id_landpage").autoNumeric('get'); 
data["id_feature"] =  $("#id_feature").autoNumeric('get'); 
data["desc_feature"] =  $("#desc_feature").val(); 
data["desc_class_icon"] =  $("#desc_class_icon").val(); 
data["desc_name"] =  $("#desc_name").val(); 
$.blockUI({message : 'Salvando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { sysMsg(data.msg,'M'); setTimeout(function() { $.unblockUI();}, 3000);} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}	$(document).ready(function() {	$("#btn_salvar").click(function() { salvarcampanha_landpage_features(); }); $("#id_landpage").autoNumeric('init',inteiro); 
 $("#id_feature").autoNumeric('init',inteiro); 
});function listaCampanhaLandpageFeatures() {var data = {} 
data["cmd"] =''; 
data["id_landpage"] =  $("#id_landpage").autoNumeric('get'); 
data["id_feature"] =  $("#id_feature").autoNumeric('get'); 
$.blockUI({message : 'Carregando...'});$.ajax({type : "POST",	url : "?acao=ajax",	dataType : "json",async : true,	data : data,	success : function(data) {if (data.msgok == 'ok') { $("#id_landpage").autoNumeric('set',data.id_landpage); 
 $("#id_feature").autoNumeric('set',data.id_feature); 
$("#desc_feature").val(data.desc_feature); 
$("#desc_class_icon").val(data.desc_class_icon); 
$("#desc_name").val(data.desc_name); 
} else {$.unblockUI();sysMsg(data.erro, 'E');}	$.unblockUI();}, error : function(msg) {$.unblockUI();}});}