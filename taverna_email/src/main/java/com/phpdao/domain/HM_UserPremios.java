package com.phpdao.domain;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.funcs.Utilitario;

public class HM_UserPremios extends UserPremios {

	public HM_UserPremios(Connection conn) {
		super(conn);
	}

	public static void insertPremio(HttpServletRequest request, HttpServletResponse response, Connection conn, long user) throws Exception {

		PrintWriter out = response.getWriter();
		JSONObject objRetorno = new JSONObject();
		JSONObject param = Utilitario.getJsonFromRequest(request, response);

		if (param.get("desc_name").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir o nome da sua camapanha.");
		}

		if (param.get("desc_path").toString().equalsIgnoreCase("")) {
			throw new Exception("Você deve inserir a url do seu premio.");
		}

		UserPremios up = new UserPremios(conn);
		up.setIdUsuario(user);
		up.setDescName(param.get("desc_name").toString());
		up.setDescPath(param.get("desc_path").toString());
		up.insert();

		objRetorno.put("msgok", "ok");
		objRetorno.put("msg", "Prêmio salvo!");

		out.print(objRetorno.toJSONString());

	}

}