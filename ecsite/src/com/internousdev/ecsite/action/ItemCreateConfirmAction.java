package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class ItemCreateConfirmAction extends ActionSupport implements SessionAware {
	private String newItemName;
	private String newItemPrice;
	private String newItemStock;
	public Map<String,Object> session;
	private String errorMessage;


	public String execute(){
		String result = SUCCESS;

		if(!(newItemName.equals(""))&&!(newItemPrice.equals(""))&&!(newItemStock.equals(""))){
			session.put("newItemName", newItemName);
			session.put("newItemPrice", newItemPrice);
			session.put("newItemStock", newItemStock);
		}
		else {
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;

		}

	public String getNewItemName() {
		return newItemName;
	}

	public void setNewItemName(String newItemName) {
		this.newItemName = newItemName;
	}

	public String getNewItemPrice() {
		return newItemPrice;
	}

	public void setNewItemPrice(String newItemPrice) {
		this.newItemPrice = newItemPrice;
	}

	public String getNewItemStock() {
		return newItemStock;
	}

	public void setNewItemStock(String newItemStock) {
		this.newItemStock = newItemStock;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	}

