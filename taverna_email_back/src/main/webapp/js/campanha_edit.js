//@ sourceURL=campanha_insert.js

$(document).ready(function() {

	var id_campanha = getParameterByName('id');
	$("#id_campanha").val(id_campanha);

	$("#btn_salvar").click(function() {
		salvarCampanha($("#id_campanha").val());
	});

});

function salvarCampanha(id) {

	var data = {};
	data["cmd"] = "updateCamapanha";
	data["id_campanha"] = id;

	// landpage
	data["desc_titulo_1"] = $("#lp_desc_titulo_1").val();
	data["desc_sub_titulo_1"] = $("#lp_desc_sub_titulo_1").val();
	data["url_video"] = $("#lp_url_video").val();
	data["desc_campanha"] = $("#lp_desc_campanha").val();
	data["desc_titulo_2"] = $("#lp_desc_titulo_2").val();
	data["sub_titulo_2"] = $("#lp_sub_titulo_2").val();

	// imagem land
	if ($("#array_imagens").val() == "") {
		data["imagens_proj_landpage"] = "";
	} else {
		data["imagens_proj_landpage"] = JSON.stringify($("#lp_array_imagens").val().split(","));
	}

	// fetaures
	var features = [];
	$('.features').each(function() {
		var cont = $(this).attr("contador");
		var obj = {};
		obj["desc_name"] = $("#ft_desc_name_" + cont).val();
		obj["desc_feature"] = $("#ft_desc_feature_" + cont).val();
		obj["desc_class_icon"] = $("#ft_desc_class_icon_" + cont).val();

		features.push(obj);
	});
	data["landpage_features"] = JSON.stringify(features);

	// thankspage
	data["t_msg_thanks"] = $("#t_msg_thanks").val();
	data["t_sub_titulo"] = $("#t_sub_titulo").val();
	data["t_url_video"] = $("#t_url_video").val();
	data["t_desc_frase"] = $("#t_desc_frase").val();
	data["t_desc_frase2"] = $("#t_desc_frase2").val();
	data["t_desc_texto"] = $("#t_desc_texto").val();

	// imagem thanks
	if ($("#t_array_imagens").val() == "") {
		data["imagens_proj_thanks"] = "";
	} else {
		data["imagens_proj_thanks"] = JSON.stringify($("#t_array_imagens").val().split(","));
	}

	// emails
	var emails = [];
	$('.emails').each(function() {
		var cont = $(this).attr("contador");
		var obj = {};
		obj["desc_email"] = $("#em_desc_email_" + cont).val();
		obj["desc_titulo"] = $("#em_desc_titulo_" + cont).val();
		obj["qtd_referencia"] = $("#em_qtd_referencia_" + cont).val();

		if ($("#em_premio_ids").val() == "") {
			obj["premio_ids"] = "";
		} else {
			obj["premio_ids"] = JSON.stringify($("#em_premio_ids_"+cont).val().split(","));
		}

		emails.push(obj);
	});
	data["campanha_emails"] = JSON.stringify(emails);

	$.blockUI({
		message : 'Salvando...'
	});

	$.ajax({
		type : "POST",
		url : "home?ac=ajax",
		data : data,
		// url : "home?ac=ajax",
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
			if (data.msgok == 'ok') {

				sysMsg(data.msg, 'M')

			} else {
				$.unblockUI();
				sysMsg(data.erro, 'E')
			}

			$.unblockUI();

		},
		error : function(msg) {
			$.unblockUI();
		}
	});

}

function loadCamapnha(id) {

	var data = {}
	data["cmd"] = "insertCamapanha";
	data["desc_nome"] = $("#desc_nome").val();
	data["desc_observacao"] = $("#desc_observacao").val();

	$.blockUI({
		message : 'Salvando...'
	});

	$.ajax({
		type : "POST",
		url : "home?ac=ajax",
		data : data,
		// url : "home?ac=ajax",
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
			if (data.msgok == 'ok') {

				console.log(data.id_campanha)
				sysMsg(data.msg, 'M')

			} else {
				$.unblockUI();
				sysMsg(data.erro, 'E')
			}

			$.unblockUI();

		},
		error : function(msg) {
			$.unblockUI();
		}
	});
}