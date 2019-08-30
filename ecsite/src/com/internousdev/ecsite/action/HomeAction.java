package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	public String execute() {
		String result="login";
		if(session.containsKey("login_user_id")) {//containsKeyメソッドは、指定したキーが存在するか確認を行い、キーが存在する場合はtrueを返します。この場合はログイン済み判定を行う。一度ログインしている場合はログイン認証画面に繊維させるpことなく、商品画面へ遷移させる・
			BuyItemDAO buyItemDAO=new BuyItemDAO();
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			result=SUCCESS; //exexuteメソッドの戻り値としてログイン状態のときはSUCCESS、ログインいていないときは"login"を返す。

		}
		return result;
	}
	@Override
	public void setSession(Map<String,Object>session) {
		this.session=session;
	}
	public Map<String,Object>getSession(){
		return this.session;
	}

}
