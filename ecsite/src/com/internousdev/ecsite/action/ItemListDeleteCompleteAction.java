package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListDeleteCompleteAction extends ActionSupport {

	public Map<String,Object>session;
	private ArrayList<ItemInfoDTO> itemInfoDTO=new ArrayList<ItemInfoDTO>();
	private String deleteFlg;
	private String message;


	public String execute() throws SQLException{

		String result=ERROR;
		ItemListDeleteCompleteDAO deleteDAO = new ItemListDeleteCompleteDAO();

		int res =deleteDAO.itemListDelete();

		if(res > 0) {
			itemInfoDTO=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。"); //1件以上削除されたかどうかで正常に削除処理がされたか判断している。
		}result=SUCCESS;
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemInfoDTO> getItemInfoDTO() {
		return itemInfoDTO;
	}

	public void setItemInfoDTO(ArrayList<ItemInfoDTO> itemInfoDTO) {
		this.itemInfoDTO = itemInfoDTO;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	}