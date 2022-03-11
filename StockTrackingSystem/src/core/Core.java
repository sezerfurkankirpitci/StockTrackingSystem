/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author sezer
 */
public class Core {
	private final String username = "root";
	private final String password = "";
	private final String url = "jdbc:mysql://localhost:3306/stockdb?useSSL=false";
	
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUrl() {
		return url;
	}
}
