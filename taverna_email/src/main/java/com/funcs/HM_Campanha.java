package com.funcs;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.funcs.Sys_parametros;
import com.funcs.Utilitario;
import com.phpdao.domain.Campanha;
import com.phpdao.domain.CampanhaEmail;
import com.phpdao.domain.CampanhaEmailPremio;
import com.phpdao.domain.CampanhaLandpage;
import com.phpdao.domain.CampanhaLandpageFeatures;
import com.phpdao.domain.CampanhaThankspage;
import com.phpdao.domain.UserImage;
import com.phpdao.domain.UserImagePage;

public class HM_Campanha extends Campanha {

	public HM_Campanha(Connection conn) {
		super(conn);
	}

	public static void LoadCampanha(HttpServletRequest request, HttpServletResponse response, Connection conn, long user) throws Exception {
		// Load camapnha landpage
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);
		ResultSet rs;
		HM_Campanha camp = new HM_Campanha(conn);
		camp.setIdCampanha(Long.parseLong(param.get("id").toString()));
		camp.setIdUsuario(user);
		camp.lista();
		if (camp.next()) {

			JSONObject land = camp.getLandPage();

			objRetorno.put("landpage", land);
			objRetorno.put("landpagefeatures", camp.getLandPageFeatures(Long.parseLong(land.get("id_landpage").toString())));
			objRetorno.put("landpageImage", camp.getLandPageImages(Long.parseLong(land.get("id_landpage").toString())));
		
			JSONObject thanks = camp.getThanksPage();
			
			objRetorno.put("thankspage", thanks);
			objRetorno.put("thankspageImage", camp.getThanksPageImages(Long.parseLong(thanks.get("id_thankspage").toString())));
			objRetorno.put("emails", camp.getEmails());;

			objRetorno.put("msgok", "ok");

		} else {
			throw new Exception("Campanha inexistente.");
		}

		out.print(objRetorno.toJSONString());

	}

	public static void updateCampanha(HttpServletRequest request, HttpServletResponse response, Connection conn, long user) throws Exception {
		Sys_parametros sys = new Sys_parametros(conn);
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();

		JSONObject param = Utilitario.getJsonFromRequest(request, response);

		PreparedStatement st;
		StringBuffer sql;
		ResultSet rs;
		HM_CampanhaLandpageFeatures features;
		HM_CampanhaLandpage landpage;
		HM_UserImage image;
		HM_UserImagePage imagepage;
		HM_CampanhaThankspage thankspage;
		HM_CampanhaEmail cpEmail;
		HM_CampanhaEmailPremio cpEmPr;
		HM_UserPremios up;

		long id_campanha = Long.parseLong(param.get("id_campanha").toString());

		Campanha campanha = new Campanha(conn);
		campanha.setIdCampanha(id_campanha);
		campanha.setIdUsuario(user);
		rs = campanha.lista();
		if (rs.next()) {

			landpage = new HM_CampanhaLandpage(conn);
			landpage.setIdCampanha(id_campanha);
			rs = landpage.lista();
			if (rs.next()) {// Considerando que existe sóh uma landpage pra campanha atualmente
				// deletando land_page features
				features = new HM_CampanhaLandpageFeatures(conn);
				features.setIdLandpage(rs.getLong("id_landpage"));
				features.delete();
			}

			landpage = new HM_CampanhaLandpage(conn);
			landpage.setIdCampanha(id_campanha);
			landpage.delete();

			landpage = new HM_CampanhaLandpage(conn);
			landpage.setIdCampanha(id_campanha);
			landpage.setDescTitulo1(param.get("desc_titulo_1").toString());
			landpage.setDescSubTitulo1(param.get("desc_sub_titulo_1").toString());
			landpage.setUrlVideo(param.get("url_video").toString());
			landpage.setDescCampanha(param.get("desc_campanha").toString());
			landpage.setDescTitulo2(param.get("desc_titulo_2").toString());
			landpage.setSubTitulo2(param.get("sub_titulo_2").toString());
			landpage.insert();

			imagepage = new HM_UserImagePage(conn);
			imagepage.setIdCampanha(id_campanha);
			imagepage.delete();
			// imagem landpage
			if (!param.get("imagens_proj_landpage").toString().equalsIgnoreCase("")) {
				JSONArray imagensid = (JSONArray) new JSONParser().parse(param.get("imagens_proj_landpage").toString());
				long id_image = 0;
				for (int i = 0; i < imagensid.size(); i++) {

					if (!Utilitario.isNumeric(imagensid.get(i).toString())) {
						throw new Exception("Id de imagem inválido.");
					}

					id_image = Long.parseLong(imagensid.get(i).toString());

					image = new HM_UserImage(conn);
					image.setIdImage(id_image);
					image.setIdUsuario(user);
					rs = image.lista();
					if (!rs.next()) {
						throw new Exception("Id de imagem inválido.");
					}

					imagepage = new HM_UserImagePage(conn);
					imagepage.setIdImage(id_image);
					imagepage.setIdPage(landpage.getIdLandpage());
					imagepage.setIdCampanha(id_campanha);
					imagepage.setFlagPagetipe("L");
					imagepage.insert();

				}
			}
			// lande page features
			if (!param.get("landpage_features").toString().equalsIgnoreCase("")) {
				JSONArray featuresarray = (JSONArray) new JSONParser().parse(param.get("landpage_features").toString());
				for (int i = 0; i < featuresarray.size(); i++) {

					objRetorno = (JSONObject) featuresarray.get(i);

					if (objRetorno.get("desc_feature") == null || objRetorno.get("desc_feature").toString().equalsIgnoreCase("")) {
						throw new Exception("Funcionalidade sem descrição.");
					}

					if (objRetorno.get("desc_class_icon") == null || objRetorno.get("desc_class_icon").toString().equalsIgnoreCase("")) {
						throw new Exception("Funcionalidade sem ícone.");
					}

					if (objRetorno.get("desc_name") == null || objRetorno.get("desc_name").toString().equalsIgnoreCase("")) {
						throw new Exception("Funcionalidade sem nome.");
					}

					features = new HM_CampanhaLandpageFeatures(conn);
					features.setIdLandpage(landpage.getIdLandpage());
					features.setDescFeature(objRetorno.get("desc_feature").toString());
					features.setDescClassIcon(objRetorno.get("desc_class_icon").toString());
					features.setDescName(objRetorno.get("desc_name").toString());
					features.insert();

				}
			}
			// thanks page
			thankspage = new HM_CampanhaThankspage(conn);
			thankspage.setIdCampanha(id_campanha);
			thankspage.delete();

			thankspage = new HM_CampanhaThankspage(conn);
			thankspage.setIdCampanha(id_campanha);
			thankspage.setMsgThanks(param.get("t_msg_thanks").toString());
			thankspage.setSubTitulo(param.get("t_sub_titulo").toString());
			thankspage.setUrlVideo(param.get("t_url_video").toString());
			thankspage.setDescFrase(param.get("t_desc_frase").toString());
			thankspage.setDescFrase2(param.get("t_desc_frase2").toString());
			thankspage.setDescTexto(param.get("t_desc_texto").toString());
			thankspage.insert();

			// imagem thankspage
			if (!param.get("imagens_proj_thanks").toString().equalsIgnoreCase("")) {
				JSONArray imagensid = (JSONArray) new JSONParser().parse(param.get("imagens_proj_thanks").toString());
				long id_image = 0;
				for (int i = 0; i < imagensid.size(); i++) {

					if (!Utilitario.isNumeric(imagensid.get(i).toString())) {
						throw new Exception("Id de imagem inválido.");
					}

					id_image = Long.parseLong(imagensid.get(i).toString());

					image = new HM_UserImage(conn);
					image.setIdImage(id_image);
					image.setIdUsuario(user);
					rs = image.lista();
					if (!rs.next()) {
						throw new Exception("Id de imagem inválido.");
					}

					imagepage = new HM_UserImagePage(conn);
					imagepage.setIdImage(id_image);
					imagepage.setIdPage(landpage.getIdLandpage());
					imagepage.setIdCampanha(id_campanha);
					imagepage.setFlagPagetipe("T");
					imagepage.insert();

				}
			}

			// deletar relação de premios e emails da campanha atual
			cpEmail = new HM_CampanhaEmail(conn);
			cpEmail.setIdCampanha(id_campanha);
			rs = cpEmail.lista();
			while (rs.next()) {
				cpEmPr = new HM_CampanhaEmailPremio(conn);
				cpEmPr.setIdEmail(rs.getLong("id_email"));
				cpEmPr.delete();
			}
			// deletar emails da campanha atual
			cpEmail = new HM_CampanhaEmail(conn);
			cpEmail.setIdCampanha(id_campanha);
			cpEmail.delete();

			// insert email
			if (!param.get("campanha_emails").toString().equalsIgnoreCase("")) {

				JSONArray campanha_emails = (JSONArray) new JSONParser().parse(param.get("campanha_emails").toString());
				JSONArray campanha_emails_premio;
				for (int i = 0; i < campanha_emails.size(); i++) {

					objRetorno = (JSONObject) campanha_emails.get(i);

					if (!Utilitario.isNumeric(objRetorno.get("qtd_referencia").toString())) {
						throw new Exception("Quantidade de refêrencias inválida.");
					}

					if (objRetorno.get("desc_email") == null || objRetorno.get("desc_email").toString().equalsIgnoreCase("")) {
						throw new Exception("Email sem texto!.");
					}

					if (objRetorno.get("desc_titulo") == null || objRetorno.get("desc_titulo").toString().equalsIgnoreCase("")) {
						throw new Exception("Email sem título.");
					}

					cpEmail = new HM_CampanhaEmail(conn);
					cpEmail.setIdCampanha(id_campanha);
					cpEmail.setDescEmail(objRetorno.get("desc_email").toString());
					cpEmail.setDescTitulo(objRetorno.get("desc_titulo").toString());
					cpEmail.setQtdReferencia(Integer.parseInt(objRetorno.get("qtd_referencia").toString()));
					cpEmail.insert();

					if (!objRetorno.get("premio_ids").toString().equalsIgnoreCase("")) {
						long idpremio = 0;
						campanha_emails_premio = (JSONArray) new JSONParser().parse(objRetorno.get("premio_ids").toString());
						for (int j = 0; j < campanha_emails_premio.size(); j++) {

							if (!Utilitario.isNumeric(campanha_emails_premio.get(j).toString())) {
								throw new Exception("Id de prêmio inválido.");
							}

							idpremio = Long.parseLong(campanha_emails_premio.get(j).toString());

							up = new HM_UserPremios(conn);
							up.setIdPremio(idpremio);
							up.setIdUsuario(user);
							rs = up.lista();
							if (!rs.next()) {
								throw new Exception("Id de prêmio inválido.");
							}

							cpEmPr = new HM_CampanhaEmailPremio(conn);
							cpEmPr.setIdEmail(cpEmail.getIdEmail());
							cpEmPr.setIdPremio(idpremio);
							cpEmPr.insert();

						}

					}

				}
			}

		} else {
			throw new Exception("Campanha não encontrada.");
		}

	}

	public static void InsertCampanha(HttpServletRequest request, HttpServletResponse response, Connection conn, long user) throws Exception {
		Sys_parametros sys = new Sys_parametros(conn);
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);
		PreparedStatement st;
		StringBuffer sql;
		ResultSet rs;

		if (param.get("desc_nome").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir o nome da sua camapanha.");
		}

		int id_camapanha = Utilitario.retornaIdinsert("campanha", "id_campanha", conn);

		// String ref = Utilitario.StringGen(1000, 32).substring(0, 10) + "_"+id_camapanha;
		/*
		 * Campanha camp = new Campanha(conn); camp.setLinkinicial(ref); rs = camp.lista(); while (rs.next()) { ref = Utilitario.StringGen(1000, 32).substring(0, 10); camp = new Campanha(conn); camp.setLinkinicial(ref); rs.close(); rs = camp.lista(); }
		 */

		sql = new StringBuffer();
		sql.append("INSERT INTO campanha (id_campanha,id_usuario, data_criacao, link_inicial, desc_nome, desc_obs) ");
		sql.append("values (?,?,now(),?,?,?)");
		st = conn.prepareStatement(sql.toString());

		int contparam = 1;

		st.setInt(contparam, id_camapanha);
		contparam++;

		st.setLong(contparam, user);
		contparam++;

		st.setString(contparam, id_camapanha + "");// ver se botar o link de fato //TODO
		contparam++;

		st.setString(contparam, param.get("desc_nome").toString());
		contparam++;

		st.setString(contparam, param.get("desc_observacao").toString());
		contparam++;

		st.executeUpdate();

		objRetorno.put("id_campanha", id_camapanha);
		objRetorno.put("msgok", "ok");
		objRetorno.put("msg", "Campanha criada!");

		out.print(objRetorno.toJSONString());

	}

	public JSONObject getLandPage() throws Exception { // TODO considerando que tem uma landpage só
		JSONObject objRetorno = new JSONObject();
		ResultSet rs;

		if (getIdCampanha() == 0 || getIdCampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		CampanhaLandpage landpage = new CampanhaLandpage(super.getConn());
		landpage.setIdCampanha(getIdCampanha());
		rs = landpage.lista();
		if (rs.next()) {

			objRetorno.put("id_landpage", rs.getString("id_landpage") == null ? "" : rs.getString("id_landpage"));
			objRetorno.put("desc_titulo_1", rs.getString("desc_titulo_1") == null ? "" : rs.getString("desc_titulo_1"));
			objRetorno.put("desc_sub_titulo_1", rs.getString("desc_sub_titulo_1") == null ? "" : rs.getString("desc_sub_titulo_1"));
			objRetorno.put("url_video", rs.getString("url_video") == null ? "" : rs.getString("url_video"));
			objRetorno.put("desc_campanha", rs.getString("desc_campanha") == null ? "" : rs.getString("desc_campanha"));
			objRetorno.put("sub_titulo_2", rs.getString("sub_titulo_2") == null ? "" : rs.getString("sub_titulo_2"));
			objRetorno.put("desc_titulo_2", rs.getString("desc_titulo_2") == null ? "" : rs.getString("desc_titulo_2"));

		} else {
			throw new Exception("Erro. Campanha inválida");
		}

		return objRetorno;
	}

	public JSONArray getLandPageImages(long landpage) throws Exception { // TODO considerando que tem uma landpage só
		JSONArray objRetorno = new JSONArray();
		JSONObject obj = new JSONObject();

		ResultSet rs;
		ResultSet rs2;

		if (getIdCampanha() == 0 || getIdCampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		UserImage image = new UserImage(super.getConn());

		UserImagePage imagePage = new UserImagePage(super.getConn());
		imagePage.setIdCampanha(getIdCampanha());
		imagePage.setIdPage(landpage);
		imagePage.setFlagPagetipe("L");

		rs = imagePage.lista();
		while (rs.next()) {

			image = new UserImage(super.getConn());
			image.setIdImage(rs.getLong("id_image"));
			rs2 = image.lista();
			if (rs2.next()) {
				obj = new JSONObject();
				// obj.put("desc_image", rs.getString("desc_image") == null ? "" : rs.getString("desc_image"));
				// obj.put("desc_path_system", rs.getString("desc_path_system") == null ? "" : rs.getString("desc_path_system"));
				obj.put("img64", Utilitario.encodeFileToBase64Binary(rs2.getString("desc_path_system")));
				objRetorno.add(obj);
			}

		}

		return objRetorno;
	}
	
	
	
	
	
	public JSONArray getThanksPageImages(long thankspage) throws Exception { // TODO considerando que tem uma thanks só
		JSONArray objRetorno = new JSONArray();
		JSONObject obj = new JSONObject();

		ResultSet rs;
		ResultSet rs2;

		if (getIdCampanha() == 0 || getIdCampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		UserImage image = new UserImage(super.getConn());

		UserImagePage imagePage = new UserImagePage(super.getConn());
		imagePage.setIdCampanha(getIdCampanha());
		imagePage.setIdPage(thankspage);
		imagePage.setFlagPagetipe("T");

		rs = imagePage.lista();
		while (rs.next()) {

			image = new UserImage(super.getConn());
			image.setIdImage(rs.getLong("id_image"));
			rs2 = image.lista();
			if (rs2.next()) {
				obj = new JSONObject();
				// obj.put("desc_image", rs.getString("desc_image") == null ? "" : rs.getString("desc_image"));
				// obj.put("desc_path_system", rs.getString("desc_path_system") == null ? "" : rs.getString("desc_path_system"));
				obj.put("img64", Utilitario.encodeFileToBase64Binary(rs2.getString("desc_path_system")));
				objRetorno.add(obj);
			}

		}

		return objRetorno;
	}
	

	public JSONArray getLandPageFeatures(long landpage) throws Exception { // TODO considerando que tem uma landpage só
		JSONArray objRetorno = new JSONArray();
		JSONObject obj = new JSONObject();
		ResultSet rs;

		if (getIdCampanha() == 0 || getIdCampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		CampanhaLandpageFeatures lpfeat = new CampanhaLandpageFeatures(super.getConn());
		lpfeat.setIdLandpage(landpage);
		rs = lpfeat.lista();
		while (rs.next()) {
			obj = new JSONObject();

			obj.put("id_feature", rs.getString("id_feature") == null ? "" : rs.getString("id_feature"));
			obj.put("desc_feature", rs.getString("desc_feature") == null ? "" : rs.getString("desc_feature"));
			obj.put("desc_class_icon", rs.getString("desc_class_icon") == null ? "" : rs.getString("desc_class_icon"));
			obj.put("desc_name", rs.getString("desc_name") == null ? "" : rs.getString("desc_name"));
			objRetorno.add(obj);

		}

		return objRetorno;
	}

	public JSONObject getThanksPage() throws Exception { // TODO considerando que tem uma thankspage só
		JSONObject retorno = new JSONObject();

		if (getIdCampanha() == 0 || getIdCampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		HM_CampanhaThankspage obj = new HM_CampanhaThankspage(super.getConn());
		obj.setIdCampanha(getIdCampanha());
		obj.lista();
		if (obj.next()) {
			retorno.put("id_thankspage", obj.getRsIdThankspage() == null ? 0 : obj.getRsIdThankspage());
			retorno.put("msg_thanks", obj.getRsMsgThanks() == null ? "" : obj.getRsMsgThanks());
			retorno.put("sub_titulo", obj.getRsSubTitulo() == null ? "" : obj.getRsSubTitulo());
			retorno.put("url_video", obj.getRsUrlVideo() == null ? "" : obj.getRsUrlVideo());
			retorno.put("desc_frase", obj.getRsDescFrase() == null ? "" : obj.getRsDescFrase());
			retorno.put("desc_frase2", obj.getRsDescFrase2() == null ? "" : obj.getRsDescFrase2());
			retorno.put("desc_texto", obj.getRsDescTexto() == null ? "" : obj.getRsDescTexto());

		}

		return retorno;
	}
	

	public JSONArray getEmails() throws Exception { // TODO considerando que tem uma landpage só
		JSONObject objjson = new JSONObject();
		JSONArray array = new JSONArray();

		if (getIdCampanha() == 0 || getIdCampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		HM_CampanhaEmail obj = new HM_CampanhaEmail(super.getConn());
		obj.setIdCampanha(getIdCampanha());
		obj.lista();
		while (obj.next()) {
			objjson = new JSONObject();
//			objjson.put("id_email", obj.getRsIdEmail() == null ? 0 : obj.getRsIdEmail());
//			objjson.put("id_campanha", obj.getRsIdCampanha() == null ? 0 : obj.getRsIdCampanha());
			objjson.put("desc_email", obj.getRsDescEmail() == null ? "" : obj.getRsDescEmail());
			objjson.put("desc_titulo", obj.getRsDescTitulo() == null ? "" : obj.getRsDescTitulo());
			objjson.put("qtd_referencia", obj.getRsQtdReferencia() == null ? "" : obj.getRsQtdReferencia());
			array.add(objjson);
		}

		return array;
	}

	

}