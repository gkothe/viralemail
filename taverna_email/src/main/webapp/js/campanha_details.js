//@ sourceURL=campanha_details.js
$(document).ready(function() {

	var id = getParameterByName('extra');
	

	$("[linkmenu=campanha_lista]").parent().addClass("current-page");
	$("[linkmenu=campanha_lista]").parent().parent().css("display", "block");
	$("[linkmenu=campanha_lista]").parent().parent().parent().addClass("active");

	if (menu == "s") {
		$('#menu_toggle').click();
	}
	
	
	campanhasDetail(id);
	$("#id_camp").text(id);
});

function campanhasDetail(id) {
	var data = {}
	data["cmd"] = 'loadCampanhaDetail';
	data["id"] = id;
	
	$.blockUI({
		message : 'Carregando...'
	});
	$.ajax({
		type : "POST",
		url : "?ac=ajax",
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
				
			var html  = "";
			$("#emails").html("");
			
			if(data.lista.length==0){
				html  = "Nenhum lead."
			}
			
			for (t = 0; t < data.lista.length; t++) {
				html = html + " " + data.lista[t].email +"<br>";
			}
			
			$("#emails").html(html);
			
			console.log(data);
		
			$.unblockUI();
		},
		error : function(msg) {
			$.unblockUI();
		}
	});
}
