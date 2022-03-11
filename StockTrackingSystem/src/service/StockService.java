/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import core.CoreHelpers;
import model.Stock;

public class StockService extends CoreHelpers {
	
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
	
	public void insertStockCard(Stock stock){
		String query = "INSERT INTO stockcard (stock_code,stock_name,stock_type,unit,barcode,kdv_type,description,create_time) VALUES ('"+stock.getStockCode() + "','" + stock.getStockName() + "'," + stock.getStockType() + ",'" + stock.getUnit() + "','" + stock.getBarcode() + "'," + stock.getKdvType() + ",'" + stock.getDescription() + "','" + stock.getCreateTime()+"')";
		runSQLCode(query);
	}
	
	public String currentTime() {
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dft.format(now);
	}
	
	public void updateStockCard(Stock stock,String key) {
		String query = "UPDATE stockcard SET stock_code = '" + stock.getStockCode() + "', stock_name = '" + stock.getStockName() + "', stock_type = " + stock.getStockType() + ", unit = '" + stock.getUnit() + "',barcode = '" + stock.getBarcode() + "', kdv_type = " + stock.getKdvType() + ", description = '" + stock.getDescription() + "', create_time = '" + stock.getCreateTime()+"' WHERE stock_code = '" + key + "'";
		runSQLCode(query);
	}
	
        public void copyStockCard(String key){
                int i=0;
                List<Stock> stockList = new ArrayList();
                stockList =  getWithSearchParametre(key + "copy(" + i + ")");
                while(!stockList.isEmpty()){
                    i++;
                    System.out.println("Buraya girdi");
                    String search = key + "copy(" + i + ")";
                    stockList =  getWithSearchParametre(search);
                    System.out.println(stockList.size());
                    System.out.println(i);
                }
                String query = "INSERT INTO stockcard (stock_code,stock_name,stock_type,unit,barcode,kdv_type,description,create_time) SELECT '" + key +"copy(" + i + ")',stock_name,stock_type,unit,barcode,kdv_type,description,'"+ currentTime() +"' FROM stockcard WHERE stock_code = '" + key + "'";
                runSQLCode(query);

        }
	public void deleteStockCard(Stock stock) {
		String query = "DELETE FROM stockcard WHERE stock_code = '" + stock.getStockCode() + "'";
		runSQLCode(query);
	}
	
	public List<Stock> getAllStock(){
		List<Stock> stockList = new ArrayList<Stock>();
		Connection conn = getConnection();
		Stock stock;
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM stockcard";
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				stock = new Stock();
				stock.setStockCode(result.getString("stock_code"));
				stock.setStockName(result.getString("stock_name"));
				stock.setStockType(result.getInt("stock_type"));
				stock.setUnit(result.getString("unit"));
				stock.setBarcode(result.getString("barcode"));
				stock.setKdvType(result.getDouble("kdv_type"));
				stock.setDescription(result.getString("description"));
				stock.setCreateTime(result.getString("create_time"));
				stockList.add(stock);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return stockList;
	}
	
	public List<Stock> getWithSearchParametre(String data){
		List<Stock> stockList = new ArrayList<Stock>();
		Connection conn = getConnection();
		Stock stock;
		try {
			Statement state = conn.createStatement();
			String query = "SELECT * FROM stockcard WHERE stock_code = '" + data + "'";
			ResultSet result = state.executeQuery(query);
			while(result.next()) {
				stock = new Stock();
				stock.setStockCode(result.getString("stock_code"));
				stock.setStockName(result.getString("stock_name"));
				stock.setStockType(result.getInt("stock_type"));
				stock.setUnit(result.getString("unit"));
				stock.setBarcode(result.getString("barcode"));
				stock.setKdvType(result.getDouble("kdv_type"));
				stock.setDescription(result.getString("description"));
				stock.setDescription(result.getString("create_time"));
				stockList.add(stock);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return stockList;
	}
}

