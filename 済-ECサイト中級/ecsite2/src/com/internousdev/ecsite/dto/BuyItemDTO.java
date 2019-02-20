package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	private int id;
	private String itemName;
	private int ItemPrice;
	private int ItemStock;

	public int getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return ItemPrice;
	}

	public int getItemStock() {
		return ItemStock;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;

	}

	public void setItemPrice(int itemPrice) {
		this.ItemPrice = itemPrice;

	}

	public void setItemStock(int itemStock) {

		this.ItemStock = itemStock;
	}

}
