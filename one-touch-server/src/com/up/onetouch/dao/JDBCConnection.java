package com.up.onetouch.dao;
/*package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private static JDBCConnection instance;
    
	private JDBCConnection() {}

	public static JDBCConnection getInstance() {		
		if (instance == null) {
			instance = new JDBCConnection();
		}		
		return instance;
	}

//	private static final String URLCON = "jdbc:firebirdsql:localhost/3050:c:/Empresas/Citogene/citotab.gdb?lc_ctype=ISO8859_1&defaultResultSetHoldable=True";
//	private static final String URLCON = "jdbc:firebirdsql:192.168.1.52/3050:d:/bd/citotab.gdb?lc_ctype=ISO8859_1&defaultResultSetHoldable=True";
	private static final String URLCON = "jdbc:firebirdsql:localhost/3050:d:/bd/citotab.gdb?lc_ctype=ISO8859_1&defaultResultSetHoldable=True";
    private static final String USRCON = "SYSDBA";
    private static final String PWDCON = "csp";

    public Connection getConnection(){
        Connection con = null;
		try {
		    try {
				Class.forName("org.firebirdsql.jdbc.FBDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}  
            con  = DriverManager.getConnection(URLCON,USRCON,PWDCON);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }

}
*/