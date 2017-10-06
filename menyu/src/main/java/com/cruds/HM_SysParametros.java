package com.cruds;

import java.sql.Connection;

public class HM_SysParametros extends SysParametros {

//	public HM_SysParametros(Connection conn) {
//		super(conn);
//	}

	public HM_SysParametros(Connection conn,int a) throws Exception {
		super(conn);
		this.lista();
		this.setIdParametro(a);
		this.next();
		
	}
	
}