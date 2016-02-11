package com.util;

import org.springframework.beans.factory.annotation.Value;

public abstract class Constants {

	@Value("${db.driver}")
	public String driver;

	@Value("${db.url}")
	public String url;

	@Value("${db.username}")
	public String username;

	@Value("${db.password}")
	public String password;

	@Value("${hibernate.show-sql}")
	public String showSql;

	@Value("${hibernate.hbm2ddl-auto}")
	public String hbm2ddl_auto;

	@Value("${hibernate.dialect}")
	public String dialect;

	@Value("${hibernate.packagesToScan}")
	public String packagesToScan;
}
