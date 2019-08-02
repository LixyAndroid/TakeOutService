package gdut.tackout.utils;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DataSourceManager {
	private static DataSource ds;
	static{
		try{
			InputStream in = DataSourceManager.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			//使用DBCP实现的数据源
			Properties props = new Properties();
			props.load(in);
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			ds = factory.createDataSource(props);
		}catch(Exception e){
			throw new ExceptionInInitializerError();
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
}
