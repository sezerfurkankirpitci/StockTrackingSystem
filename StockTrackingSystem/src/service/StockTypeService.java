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
import model.StockType;

public class StockTypeService extends CoreHelpers {
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
        
	public void insertStockType(StockType stock_type){
		String query = "INSERT INTO stock_type (stock_type) VALUES ('" + stock_type.getStockType() + "')";
		runSQLCode(query);
	}
	
	public void updateStockType(StockType stock_type,int key) {
		String query = "UPDATE stock_type SET id="+stock_type.getId()+", stock_type = '" + stock_type.getStockType() + "' WHERE id = " + key;
		runSQLCode(query);
	}
	
	public void deleteStockType(StockType stock_type) {
		String query = "DELETE FROM stock_type WHERE id = " + stock_type.getId();
		runSQLCode(query);
	}
	
        public int getIdWhere(String data){
            String query = "SELECT * FROM stock_type WHERE stock_type ='" + data + "'";
            Connection conn = getConnection();
            StockType stocktype = new StockType();
            try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				stocktype = new StockType();
				stocktype.setId(result.getInt("id"));
				stocktype.setStockType(result.getString("stock_type"));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return stocktype.getId();
        }
        public String getStockTypeWhere(int id){
            String query = "SELECT * FROM stock_type WHERE id = " + id;
            Connection conn = getConnection();
            StockType stocktype = new StockType();
            try {
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				stocktype = new StockType();
				stocktype.setId(result.getInt("id"));
				stocktype.setStockType(result.getString("stock_type"));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return stocktype.getStockType();
        }
	public List<StockType> getAllStockType () {
		List<StockType> stockTypeList = new ArrayList<StockType>();
		StockType stocktype;
		Connection conn = getConnection();
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM stock_type";
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				stocktype = new StockType();
				stocktype.setId(result.getInt("id"));
				stocktype.setStockType(result.getString("stock_type"));
				stockTypeList.add(stocktype);
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return stockTypeList;
		
	}
}
