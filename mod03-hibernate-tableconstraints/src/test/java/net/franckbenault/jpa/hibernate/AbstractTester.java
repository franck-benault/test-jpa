package net.franckbenault.jpa.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AbstractTester {

	
	private Connection getConnection(String databaseName) throws ClassNotFoundException, SQLException {
		Connection conn =null;
		if(databaseName.equals("hsqldb")) {
			Class.forName("org.hsqldb.jdbcDriver");
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:testdb",
				"sa", "");
		}
		if(databaseName.equals("derby")) {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.
			    getConnection("jdbc:derby:memory:testDB;create=true");
		}
		if(databaseName.equals("h2")) {
	        Class.forName("org.h2.Driver");
	        conn = DriverManager.
	            getConnection("jdbc:h2:mem:test;MODE=MYSQL", "sa", "");
		}
		return conn;
	}

	
	private String getConstraintRequest(String databaseName)  {
		String request = "";
		if(databaseName.equals("hsqldb")) {
			request = 
					"SELECT CONSTRAINT_NAME, TABLE_NAME, TABLE_SCHEMA, TABLE_CATALOG FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS where CONSTRAINT_SCHEMA='PUBLIC'";
		}
		if(databaseName.equals("derby")) {
			request ="SELECT c.constraintname, t.tablename FROM sys.sysconstraints c, sys.systables t WHERE c.tableid = t.tableid";
			
		}
		if(databaseName.equals("h2")) {
			request ="SELECT CONSTRAINT_NAME, TABLE_NAME FROM INFORMATION_SCHEMA.CONSTRAINTS";
		}
		return request;
	}
	
	protected int countStudentsJDBC(String databaseName) throws ClassNotFoundException, SQLException {
		int counter = 0;
		Connection conn = getConnection(databaseName);
		Statement st = conn.createStatement();
		ResultSet mrs = conn.getMetaData().getTables(null, null, null,
				new String[] { "TABLE" });
		while (mrs.next()) {
			String tableName = mrs.getString(3);
			//System.out.println("\n\n\n\nTable Name: " + tableName);

			ResultSet rs = st.executeQuery("select * from " + tableName);
			//ResultSetMetaData metadata = rs.getMetaData();
			while (rs.next()) {
				counter++;
			}
		}

		return counter;
	}
	
	public List<String> countConstraints(String databaseName) throws SQLException,
			ClassNotFoundException {

		List<String> constraints = new ArrayList<String>();
		
		String query = getConstraintRequest(databaseName);
		Connection connection = getConnection(databaseName);
		PreparedStatement ps2 = connection.prepareStatement(query);
		ResultSet rs = ps2.executeQuery();

		while (rs.next()) {
			System.out.println("..." + rs.getString(1) + "..."
					+ rs.getString(2));
			constraints.add(rs.getString(1));
		}
		return constraints;
	}

}
