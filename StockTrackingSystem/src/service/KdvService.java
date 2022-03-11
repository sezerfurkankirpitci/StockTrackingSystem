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
import model.Kdv;

public class KdvService extends CoreHelpers{
	public void runSQLCode(String query) {
		Connection conn = getConnection();
		try {
			Statement state;
                        state = conn.createStatement();
			state.executeUpdate(query);
			state.close();
			conn.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	public void insertKdvType(Kdv kdv){
		String query = "INSERT INTO kdv (kdv_type) VALUES (" + kdv.getKdv() + ")";
		runSQLCode(query);
	}
	
	public void updateKdvType(Kdv kdv,int id) {
		String query = "UPDATE kdv SET id = "+ kdv.getId() +",kdv_type = " + kdv.getKdv() + " WHERE id = " + id;
		runSQLCode(query);
	}
	
	public void deleteKdvType(Kdv kdv) {
		String query = "DELETE FROM kdv WHERE id = " + kdv.getId();
		runSQLCode(query);
	}
	public List<Kdv> getAllKdvType () {
		List<Kdv> kdvTypeList = new ArrayList<Kdv>();
		Kdv kdvType;
		Connection conn = getConnection();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM kdv";
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				kdvType = new Kdv();
				kdvType.setId(result.getInt("id"));
				kdvType.setKdv(result.getDouble("kdv_type"));
				kdvTypeList.add(kdvType);
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return kdvTypeList;
		
	}
}
