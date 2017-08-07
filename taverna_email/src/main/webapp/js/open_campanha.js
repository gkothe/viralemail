//@ sourceURL=open_campanha.js

$(document).ready(function() {

	var ref = getParameterByName('ref');
	$("#ref_campanha").val(ref);

	loadCamapanha(ref);

	$("#btn_sendlead").click(function() {
		sendLead($("#ref_campanha").val());
	});
	
});

function sendLead(ref) {

	var data = {}
	data["cmd"] = "sendLead";
	data["lead"] = $("#mail_lead").val();
	data["ref"] = ref
	
	$.blockUI({
		message : 'Carregando...'
	});

	$.ajax({
		type : "POST",
		url : "?acao=ajax_w",
		data : data,
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
			if (data.msgok == 'ok') {
				sysMsg(data.msg,'M')
			} else {
				sysMsg(data.erro, 'E')
			}

			$.unblockUI();

		},
		error : function(msg) {
			$.unblockUI();
		}
	});

}

function loadCamapanha(ref) {

	var data = {}
	data["cmd"] = "loadCampanhabyRef";
	data["ref"] = ref;

	$.blockUI({
		message : 'Carregando...'
	});

	$.ajax({
		type : "POST",
		url : "?acao=ajax_w",
		data : data,
		dataType : "json",
		async : true,
		data : data,
		success : function(data) {
			if (data.msgok == 'ok') {

				var land = data.landpage;

				$("#lp_desc_titulo_1").val(land.desc_titulo_1);
				$("#lp_desc_sub_titulo_1").val(land.desc_sub_titulo_1);
				$("#lp_url_video").val(land.url_video);
				$("#lp_desc_campanha").val(land.desc_campanha);
				$("#lp_desc_titulo_2").val(land.desc_titulo_2);
				$("#lp_sub_titulo_2").val(land.sub_titulo_2);

				var ft = data.landpagefeatures;

				for (t = 0; t < ft.length; t++) {

					$("#ft_desc_name_" + t).val(ft[t].desc_name);
					$("#ft_desc_feature_" + t).val(ft[t].desc_feature);
					$("#ft_desc_class_icon_" + t).val(ft[t].desc_class_icon);

				}

				var lp_img = data.landpageImage

				$("#lp_image_1").attr("src", "data:image/gif;base64," + lp_img[0].img64);
				$("#lp_image_2").attr("src", "data:image/gif;base64," + lp_img[1].img64);

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

};