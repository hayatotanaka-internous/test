package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	private String id;
	private String itemName;
	private String ItemPrice;
	private String ItemStock;

	public String getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public String getItemPrice() {
		return ItemPrice;
	}

	public String getItemStock() {
		return ItemStock;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;

	}

	public void setItemPrice(String itemPrice) {
		this.ItemPrice = itemPrice;

	}

	public void setItemStock(String itemStock) {
		this.ItemStock = itemStock;
	}

}
