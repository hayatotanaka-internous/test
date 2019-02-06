package com.internousdev.ecsite.dto;

public class ItemListDTO {

	public String item_Name;

	public String item_Price;

	public String item_Stock;

	public String id;

	public String insert_date;

	public String update_date;

	public String getItem_Name(){
		return item_Name;
	}
	public void setItem_Name(String item_Name){
		this.item_Name =item_Name;
	}

	public String getItem_Price(){
		return item_Price;
	}
	public void setItem_Price(String item_Price){
		this.item_Price =item_Price;
	}

	public String getItem_Stock(){
		return item_Stock;
	}
	public void setItem_Stock(String item_Stock){
		this.item_Stock =item_Stock;
	}

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id =id;
	}

	public String getInsert_date(){
		return insert_date;
	}
	public void setInsert_date(String insert_date){
		this.insert_date =insert_date;
	}

	public String getUpdate_date(){
		return update_date;
	}
	public void setUpdate_date(String update_date){
		this.update_date =update_date;
	}
}
