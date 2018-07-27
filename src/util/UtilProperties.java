package util;

import java.util.Properties;

public class UtilProperties {

	private static Properties sql;
	private static Properties config;
	private static Properties exception;
	
	
	public static String getSql(String strSql) {
		return sql.get(strSql).toString();
	}
	public static void setSql(Properties p) {
		UtilProperties.sql = p;
	}
	
	public static String getConfig(String strConfig) {
		return config.get(strConfig).toString();
	}
	public static void setConfig(Properties p) {
		UtilProperties.config = p;
	}
	
	public static String getException(String strException) {
		return exception.get(strException).toString();
	}
	public static void setException(Properties p) {
		UtilProperties.exception = p;
	}
	
	
	
}
