package com.gerador;

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
import com.phpdao.domain.CampanhaLandpageFeature;
import com.phpdao.domain.CampanhaThankspage;
import com.phpdao.domain.UserImage;
import com.phpdao.domain.UserImagePage;
import com.phpdao.domain.UserPremio;

public class HM_Campanha extends Campanha {

	public HM_Campanha(Connection conn) {
		super(conn);
	}

	public static void updateCampanha(HttpServletRequest request, HttpServletResponse response, Connection conn, long user) throws Exception {
		Sys_parametros sys = new Sys_parametros(conn);
		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();

		JSONObject param = Utilitario.getJsonFromRequest(request, response);

		PreparedStatement st;
		StringBuffer sql;
		ResultSet rs;
		CampanhaLandpageFeature features;
		CampanhaLandpage landpage;
		UserImage image;
		UserImagePage imagepage;
		CampanhaThankspage thankspage;
		CampanhaEmail cpEmail;
		CampanhaEmailPremio cpEmPr;
		UserPremio up;

		long id_campanha = Long.parseLong(param.get("id_campanha").toString());

		Campanha campanha = new Campanha(conn);
		campanha.setIdcampanha(id_campanha);
		campanha.setIdusuario(user);
		rs = campanha.lista();
		if (rs.next()) {

			landpage = new CampanhaLandpage(conn);
			landpage.setIdcampanha(id_campanha);
			rs = landpage.lista();
			if (rs.next()) {// Considerando que existe sóh uma landpage pra campanha atualmente
				// deletando land_page features
				features = new CampanhaLandpageFeature(conn);
				features.setIdlandpage(rs.getLong("id_landpage"));
				features.delete();
			}

			landpage = new CampanhaLandpage(conn);
			landpage.setIdcampanha(id_campanha);
			landpage.delete();

			landpage = new CampanhaLandpage(conn);
			landpage.setIdcampanha(id_campanha);
			landpage.setDesctitulo1(param.get("desc_titulo_1").toString());
			landpage.setDescsubtitulo1(param.get("desc_sub_titulo_1").toString());
			landpage.setUrlvideo(param.get("url_video").toString());
			landpage.setDesccampanha(param.get("desc_campanha").toString());
			landpage.setDesctitulo2(param.get("desc_titulo_2").toString());
			landpage.setSubtitulo2(param.get("sub_titulo_2").toString());
			landpage.Insert();

			imagepage = new UserImagePage(conn);
			imagepage.setId_campanha(id_campanha);
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

					image = new UserImage(conn);
					image.setId_image(id_image);
					image.setId_usuario(user);
					rs = image.lista();
					if (!rs.next()) {
						throw new Exception("Id de imagem inválido.");
					}

					imagepage = new UserImagePage(conn);
					imagepage.setId_image(id_image);
					imagepage.setId_page(landpage.getIdlandpage());
					imagepage.setId_campanha(id_campanha);
					imagepage.setFlag_pagetipe("L");
					imagepage.Insert();

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

					features = new CampanhaLandpageFeature(conn);
					features.setIdlandpage(landpage.getIdlandpage());
					features.setDescfeature(objRetorno.get("desc_feature").toString());
					features.setDescclassicon(objRetorno.get("desc_class_icon").toString());
					features.setDescname(objRetorno.get("desc_name").toString());
					features.Insert();

				}
			}
			// thanks page
			thankspage = new CampanhaThankspage(conn);
			thankspage.setIdcampanha(id_campanha);
			thankspage.delete();

			thankspage = new CampanhaThankspage(conn);
			thankspage.setIdcampanha(id_campanha);
			thankspage.setMsgthanks(param.get("t_msg_thanks").toString());
			thankspage.setSubtitulo(param.get("t_sub_titulo").toString());
			thankspage.setUrlvideo(param.get("t_url_video").toString());
			thankspage.setDescfrase(param.get("t_desc_frase").toString());
			thankspage.setDescfrase2(param.get("t_desc_frase2").toString());
			thankspage.setDesctexto(param.get("t_desc_texto").toString());
			thankspage.Insert();

			// imagem thankspage
			if (!param.get("imagens_proj_thanks").toString().equalsIgnoreCase("")) {
				JSONArray imagensid = (JSONArray) new JSONParser().parse(param.get("imagens_proj_thanks").toString());
				long id_image = 0;
				for (int i = 0; i < imagensid.size(); i++) {

					if (!Utilitario.isNumeric(imagensid.get(i).toString())) {
						throw new Exception("Id de imagem inválido.");
					}

					id_image = Long.parseLong(imagensid.get(i).toString());

					image = new UserImage(conn);
					image.setId_image(id_image);
					image.setId_usuario(user);
					rs = image.lista();
					if (!rs.next()) {
						throw new Exception("Id de imagem inválido.");
					}

					imagepage = new UserImagePage(conn);
					imagepage.setId_image(id_image);
					imagepage.setId_page(landpage.getIdlandpage());
					imagepage.setId_campanha(id_campanha);
					imagepage.setFlag_pagetipe("T");
					imagepage.Insert();

				}
			}

			// deletar relação de premios e emails da campanha atual
			cpEmail = new CampanhaEmail(conn);
			cpEmail.setIdcampanha(id_campanha);
			rs = cpEmail.lista();
			while (rs.next()) {
				cpEmPr = new CampanhaEmailPremio(conn);
				cpEmPr.setIdemail(rs.getLong("id_email"));
				cpEmPr.delete();
			}
			// deletar emails da campanha atual
			cpEmail = new CampanhaEmail(conn);
			cpEmail.setIdcampanha(id_campanha);
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

					cpEmail = new CampanhaEmail(conn);
					cpEmail.setIdcampanha(id_campanha);
					cpEmail.setDescemail(objRetorno.get("desc_email").toString());
					cpEmail.setDesctitulo(objRetorno.get("desc_titulo").toString());
					cpEmail.setQtd_referencia(Integer.parseInt(objRetorno.get("qtd_referencia").toString()));
					cpEmail.Insert();

					if (!objRetorno.get("premio_ids").toString().equalsIgnoreCase("")) {
						long idpremio = 0;
						campanha_emails_premio = (JSONArray) new JSONParser().parse(objRetorno.get("premio_ids").toString());
						for (int j = 0; j < campanha_emails_premio.size(); j++) {

							if (!Utilitario.isNumeric(campanha_emails_premio.get(j).toString())) {
								throw new Exception("Id de prêmio inválido.");
							}

							idpremio = Long.parseLong(campanha_emails_premio.get(j).toString());

							up = new UserPremio(conn);
							up.setIdpremio(idpremio);
							up.setIdusuario(user);
							rs = up.lista();
							if (!rs.next()) {
								throw new Exception("Id de prêmio inválido.");
							}

							cpEmPr = new CampanhaEmailPremio(conn);
							cpEmPr.setIdemail(cpEmail.getIdemail());
							cpEmPr.setIdpremio(idpremio);
							cpEmPr.Insert();

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

		if (getIdcampanha() == 0 || getIdcampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		CampanhaLandpage landpage = new CampanhaLandpage(super.getConn());
		landpage.setIdcampanha(getIdcampanha());
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

		if (getIdcampanha() == 0 || getIdcampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		UserImage image = new UserImage(super.getConn());

		UserImagePage imagePage = new UserImagePage(super.getConn());
		imagePage.setId_campanha(getIdcampanha());
		imagePage.setId_page(landpage);
		imagePage.setFlag_pagetipe("L");

		rs = imagePage.lista();
		while (rs.next()) {

			image = new UserImage(super.getConn());
			image.setId_image(rs.getLong("id_image"));
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

		if (getIdcampanha() == 0 || getIdcampanha() == null) {
			throw new Exception("Erro. Campanha inválida");
		}

		CampanhaLandpageFeature lpfeat = new CampanhaLandpageFeature(super.getConn());
		lpfeat.setIdlandpage(landpage);
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

}