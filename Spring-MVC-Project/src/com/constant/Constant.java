package com.constant;

import org.springframework.beans.factory.annotation.Value;

public class Constant {

	@Value("${db.driver}")
	public String driver;
	
	@Value("${db.url}")
	public String url;
	
	@Value("${db.username}")
	public String username;
	
	@Value("${db.password}")
	public String password;
	
	@Value("${hb.packageToScan}")
	public String packageToScan;
	
	@Value("${hb.dialect}")
	public String dialect;
	
	@Value("${hb.show_sql}")
	public String show_sql;
	
	@Value("${hb.hbm2ddl}")
	public String hbm2ddl;
	
	
}
