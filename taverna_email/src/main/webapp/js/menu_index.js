//@ sourceURL=menu_index.js
var inteiro = {
	aSep : '',
	aDec : ',',
	mDec : 0,
	vMin : 0
};

var inteiro2 = {
	aSep : '',
	aDec : ',',
	mDec : 0,
	vMax : 60,
	vMin : 0
};

var inteiro4 = {
	aSep : '',
	aDec : '',
	mDec : 0,
	vMin : 0
};

var inteiro3 = {
	aSep : '.',
	aDec : ',',
	mDec : 0,
	vMin : 0
};

var numerico = {
	aSep : '.',
	aDec : ',',
	mDec : 2,
	vMin : 0,
	aSign : 'R$ '
};

var numerico2 = {
	aSep : '.',
	aDec : ',',
	mDec : 2,
	vMin : 0,

};
var random = 0;
var active_menu;

var preventclean = false;

var delay = (function() {
	var timer = 0;
	return function(callback, ms) {
		clearTimeout(timer);
		timer = setTimeout(callback, ms);
	};
})();

function resizedivs() {
	$("#main_cont").css("height", $(window).height() - 60)
	$("#mainpage").css("height", $(window).height() - 130)
}
$(window).resize(function() {
	resizedivs();

});

function showHelp() {

	window.open("manual.pdf", '_blank');
}

function sysMsg(text, tipo) {

	if (tipo == 'E') {
		$("#msg_erro_aviso").html("<label style=\"font-size: 20px; color: red\" > ERRO!</label>");
	} else if (tipo == 'A') {
		$("#msg_erro_aviso").html("<label style=\"font-size: 20px; color:#ff9900\" > Aviso!</label>");
	} else if (tipo == 'M') {
		$("#msg_erro_aviso").html("<label style=\"font-size: 20px; color:green\" > Mensagem</label>");
	}

	$("#modal_erros").modal('show');
	$("#msg_erro").html(text);

}

function trocaPag(pag, jsp, e, extraparam) {

	var link = $(pag).attr('linkmenu');
	var men = "";
	if ($BODY.hasClass('nav-md')) {
		men = "m"
	} else {
		men = "s"
	}

	if (extraparam == undefined) {
		extraparam = "";
	}

	if (e && (e.which == 2 || e.button == 4)) {
		window.open("home?link=" + link + "&jsp=" + jsp + "&m=" + men + "&extra=" + extraparam, '_blank');
	} else {
		document.location.href = "home?link=" + link + "&jsp=" + jsp + "&m=" + men + "&extra=" + extraparam;
	}

}

$(document).ready(function() {

	$('#mainpage').load('home?ac=' + url);

	$("[linkmenu=" + url + "]").parent().addClass("current-page");
	$("[linkmenu=" + url + "]").parent().parent().css("display", "block");
	$("[linkmenu=" + url + "]").parent().parent().parent().addClass("active");

	if (menu == "s") {
		$('#menu_toggle').click();
	}

	

	$(".clickmenu").click(function() {
		if (active_menu != undefined) {
			active_menu.removeClass("active").removeClass("active-sm");
		}
		if ($BODY.hasClass('nav-sm')) {
			$('#sidebar-menu').find('ul.child_menu').hide();
			$('#sidebar-menu').find('ul.child_menu').parent().removeClass("active")
		}

		active_menu = $(this).parent();
		setTimeout(function() {
			$('.table_boots').bootstrapTable('resetView');
		}, 500);

	});

	$(".clickmenu2").click(function() {

		setTimeout(function() {
			$('.table_boots').bootstrapTable('resetView');
		}, 500);

	});

	$('.keep-open', $('.fixed-table-toolbar')).prependTo($('#colunas'));
	$('.fixed-table-toolbar').remove();
	$('#colunas').addClass("fixed-table-toolbar");
	$('label', $('#colunas')).css('padding', '3px 20px').css('font-weight', 'normal');
	$('.dropdown-menu', $('#colunas')).css('min-width', '180px');
	$('th', $('#m_table_produtos')).css('background-color', 'rgb(248, 248, 248)');

	/*
	 * $('.hora').timepicker({ minuteStep : 1, showSeconds : false, showMeridian :
	 * false, defaultTime : false });
	 */

	$(".hora").inputmask("h:s", {
		"placeholder" : "00:00"
	});
	/*
	 * $("#m_hora_entrega").autoNumeric('init', inteiro);
	 * $("#m_minutos_entrega").autoNumeric('init', inteiro2);
	 */

	$('[data-toggle="tooltip"]').tooltip();

	resizedivs();

});

function changeTitle(tem, qtd) {
	var newTitle = "";
	if (tem) {
		newTitle = '(' + qtd + ') ' + " TragoAqui";
		document.title = newTitle;
	} else {
		newTitle = "TragoAqui";

	}

	document.title = newTitle;

}

function valorFormater(value, row, index) {
	if (!$("#sys_formatador").hasClass("autonumeric")) {
		$("#sys_formatador").autoNumeric('init', numerico);
		$("#sys_formatador").addClass("autonumeric");
	}

	$("#sys_formatador").autoNumeric('set', value);
	return $("#sys_formatador").val();
}

function setAutocomplete(cod, descr) {

	$('#lblerro_' + cod).hide();

	$('#' + descr).autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "home?ac=ajax",
				dataType : "json",
				type : 'POST',
				data : {
					cmd : 'autocomplete',
					q : request.term,
					campo : descr

				},
				success : function(data) {

					if (data.length > 0) {
						$("#" + descr).attr("idcd", data[0].id);
						$("#" + descr).attr("descrcd", data[0].descr);
					}
					if (data.length == 0) {
						$("#" + descr).attr("idcd", "");
						$("#" + descr).attr("descrcd", "");
					}

					response($.map(data, function(value, key) {
						return {
							label : value.descr,
							value : value.id

						};
					}));
				}
			});
		},
		minLength : 0,
		focus : function() {
			// prevent value inserted on focus
			return false;
		},
		select : function(event, ui) {

			$("#" + cod).val(ui.item.value);
			$("#" + cod).attr("descr", ui.item.label);
			$("#" + descr).val(ui.item.label);

			ui.item.value = ui.item.label;
		},
		open : function() {
			$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
		},
		close : function() {
			$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
		}
	});

	$('#' + descr).keypress(function(event) {
		if (event.keyCode == 13) {
			// if($(this).val()==""){
			$(this).autocomplete("search", $("#" + descr).val())
			$('#' + cod).val($(this).attr("idcd"));
			$(this).val($(this).attr("descrcd"));
			// }
		}
	});

	$('#' + cod).blur(function() {
		var param = [ {
			name : 'cmd',
			value : 'autocomplete'
		}, {
			name : 'campo',
			value : cod
		}, {
			name : 'q',
			value : $("#" + cod).val()
		} ];

		if ($("#" + cod).val()) {
			$.ajax({
				type : 'POST',
				url : "home?ac=ajax",
				data : param,
				async : true,
				dataType : 'json',
				success : function(data) {
					if (data.descr) {
						$("#" + descr).val(data.descr);
					} else {
						$("#" + descr).val("");
					}

				},
				error : function(data) {

				}
			});
		}
	});

	$('#' + descr).blur(function(event) {

		$("#" + descr).removeClass("erro");
		$("#" + descr).removeClass("sucesso");

		var param = [ {
			name : 'cmd',
			value : 'autocomplete'
		}, {
			name : 'campo',
			value : descr
		}, {
			name : 'q',
			value : $("#" + descr).val()
		},

		];

		$.ajax({
			url : "home?ac=ajax",
			type : 'POST',
			dataType : "json",
			data : param,
			async : false,
			success : function(data) {

				if (data.length == 0 || $("#" + descr).val() == "") {
					$('#' + cod).val("");
					$("#" + descr).attr("idcd", "");
					$("#" + descr).attr("descrcd", "");
					$('#lblerro_' + cod).hide();

				}
				var t = 0;
				if (data.length == 0 && $("#" + descr).val() != "") {
					$("#" + descr).addClass("erro");
					$("#" + cod).val("");
					$('#lblerro_' + cod).show();
				} else if (data.length > 0 && $("#" + descr).val() != "" && $("#" + descr).val() != data[0].descr) {
					var achou = false;
					for (t = 1; t < data.length; t++) {
						if ($("#" + descr).val() == data[t].descr) {
							achou = true;
							break;
						}
					}
					if (!achou) {
						$("#" + descr).addClass("erro");
						$("#" + cod).val("");
						$('#lblerro_' + cod).hide().show();
					}
				}

				if (data.length > 0 && $("#" + descr).val() != "" && $("#" + descr).val() == data[t].descr) {

					$('#lblerro_' + cod).hide();
					$("#" + descr).addClass("sucesso");
					$("#" + cod).val(data[t].id);
					$("#" + descr).attr("idcd", data[t].id);
					$("#" + descr).attr("descrcd", data[t].descr);

				}

			}
		});
	});
}
