/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Stock {
	private String stock_code;
	private String stock_name;
	private int stock_type;
	private String unit;
	private String barcode;
	private double kdv_type;
	private String description;
	private String create_time;
	
	public String getStockCode() {
		return stock_code;
	}
	public void setStockCode(String stock_code) {
		this.stock_code = stock_code;
	}
	public String getStockName() {
		return stock_name;
	}
	public void setStockName(String stock_name) {
		this.stock_name = stock_name;
	}
	public int getStockType() {
		return stock_type;
	}
	public void setStockType(int stock_type) {
		this.stock_type = stock_type;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateTime() {
		return create_time;
	}
	public void setCreateTime(String create_time) {
		this.create_time = create_time;
	}
	public double getKdvType() {
		return kdv_type;
	}
	public void setKdvType(double kdv_type) {
		this.kdv_type = kdv_type;
	}
	
}
