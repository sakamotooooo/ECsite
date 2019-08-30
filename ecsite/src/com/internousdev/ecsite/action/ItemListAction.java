package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListAction extends ActionSupport implements SessionAware{
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();
	public Map<String,Object>session;
	private String errorMessage;

	public String execute() throws SQLException{
		String result=ERROR;

		itemInfoDTO = itemListDAO.getItemList();

		if(itemInfoDTO != null) {
			result=SUCCESS;
		}
		else {
			errorMessage="商品情報がありません。";
		}

		return result;
	}

	public ItemListDAO getItemListDAO() {
		return itemListDAO;
	}

	public void setItemListDAO(ItemListDAO itemListDAO) {
		this.itemListDAO = itemListDAO;
	}

	public ArrayList<ItemInfoDTO> getItemInfoDTO() {
		return itemInfoDTO;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemInfoDTO) {
		this.itemInfoDTO = itemInfoDTO;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}