/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import core.CoreHelpers;
import model.Unit;

public class UnitService extends CoreHelpers {
	public void runSQLCode(String query) {
		Connection conn = getConnection();
		try {
			Statement state = conn.createStatement();
			state.executeUpdate(query);
			state.close();
			conn.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	public void insertUnit(Unit unit){
		String query = "INSERT INTO unit (unit) VALUES ('" + unit.getUnit() + "')";
		runSQLCode(query);
	}
	
	public void updateUnit(Unit unit,int key) {
                
		String query = "UPDATE unit SET id ="+unit.getId()+",unit = '" + unit.getUnit() + "' WHERE id = " + key;
		runSQLCode(query);
	}
	
	public void deleteUnit(Unit unit) {
		String query = "DELETE FROM unit WHERE id = " + unit.getId();
		runSQLCode(query);
	}
	
	public List<Unit> getAllUnit () {
		List<Unit> unitList = new ArrayList<Unit>();
		Unit unit;
		Connection conn = getConnection();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM unit";
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				unit = new Unit();
				unit.setId(result.getInt("id"));
				unit.setUnit(result.getString("unit"));
				unitList.add(unit);
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return unitList;
		
	}
	
}
