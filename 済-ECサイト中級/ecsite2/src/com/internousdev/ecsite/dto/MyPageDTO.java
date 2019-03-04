package com.internousdev.ecsite.dto;

public class MyPageDTO {

	private String id;
	private String itemName;
	private String totalPrice;
	private String totalCount;
	private String payment;
	private String insertDate;

	public String getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public String getPayment() {
		return payment;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

}
