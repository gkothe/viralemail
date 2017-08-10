package com.gerador;

import java.sql.Connection;
import java.sql.ResultSet;

import org.json.simple.JSONArray;

import com.funcs.Utilitario;
import com.phpdao.domain.CampanhaEmailPremio;
import com.phpdao.domain.UserPremio;

public class HM_CampanhaEmail extends CampanhaEmail {

	public HM_CampanhaEmail(Connection conn) {
		super(conn);
	}

	public boolean sendEmail(String email) throws Exception {

		ResultSet rs2;
		UserPremio up;
		JSONArray path_premio = new JSONArray();
		String corpo = "";
		CampanhaEmailPremio cep;

		if (getQtdReferencia() == null) {
			throw new Exception("Parâmetro inválido. Campanha send email.");
		}

		lista();
		while (next()) {
			path_premio = new JSONArray();
			setDescEmail(getRsDescEmail());
			setDescTitulo(getRsDescTitulo());
			corpo = getRsDescEmail();

			cep = new CampanhaEmailPremio(getConn());

			cep.setIdemail(getRsIdEmail());
			rs2 = cep.lista();
			while (rs2.next()) {
				up = new UserPremio(getConn());
				up.setIdpremio(rs2.getLong("id_premio"));
				up.lista();
				while (up.getRs().next()) {
					path_premio.add(up.getRs().getString("desc_path"));
					corpo = corpo + " <br>Prêmio :" + up.getRs().getString("desc_path") + " ";
				}

			}

			setDescEmail(corpo);

			Utilitario.sendEmail(email, getDescEmail(), getDescTitulo(), getConn());
		}

		return true;
	}

}