package com.upem.jdbc;

public class MySQLDataSource extends DataSource{
	
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";
	
	public MySQLDataSource() {
			
	}

	public MySQLDataSource(String host, String source, String user, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, password);
	}

	public MySQLDataSource(String host, String source, String user) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, user, "");
	}
	
	public MySQLDataSource(String host, String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, "root", "toor");
	}
	
	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, "root", "toor");
	}

	public String getUrl()
	{
		return MYSQL_BRIDGE + "//" + getHost() + "/" + getSource();
	}

	public char startDelimiter() {
		return '`';
	}

	public char endDelimiter() {
		return '`';
	}

}
