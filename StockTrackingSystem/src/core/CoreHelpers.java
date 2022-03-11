/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author sezer
 */
public class CoreHelpers extends Core {
	
	public Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(getUrl(),getUsername(),getPassword());
		} catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.out.println(e);
		}
		
		return connection;
	}
	
}
