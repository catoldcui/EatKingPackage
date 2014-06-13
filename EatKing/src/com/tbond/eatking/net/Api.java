package com.tbond.eatking.net;

import java.io.File;
import java.io.FileNotFoundException;

import android.os.Environment;
import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class Api {
	private static Api instance = new Api();
	
	//api
    private static final String API_LOGIN = "login";
    private static final String API_LOGOUT = "logout";
    private static final String API_REGIS = "regis";
    
    public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAILED = 1;
	
    private Api(){
		
	}
	
	public static Api getInstance(){
		return instance;
	}
	
	public void login(String userName, String userPwd, JsonHttpResponseHandler reponseHandler){
		RequestParams params = new RequestParams();
		params.put("userName", userName);
		params.put("userPwd", userPwd);
		WebRestClient.post(API_LOGIN, params, reponseHandler);
	}
	
	public void regis(String userName, String userPwd, JsonHttpResponseHandler reponseHandler){
		RequestParams params = new RequestParams();
		params.put("userName", userName);
		params.put("userPwd", userPwd);
		String pathString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/infosearch_share.jpg";
		File im = new File(pathString);
		Log.i("image",String.valueOf(im.length()));
		try {
			params.put("image", im);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebRestClient.post(API_REGIS, params, reponseHandler);
	}
	
	public void logout(JsonHttpResponseHandler reponseHandler){
		WebRestClient.post(API_LOGOUT, null, reponseHandler);
		WebRestClient.getCookieStore().clear();
	}
	
	/**
	 * ͨ������λ�û��radius�뾶�������̵���Ϣ
	 * @param locX
	 * @param locY
	 * @param radius
	 * @param reponseHandler
	 */
	public void searchShopByLoc(double locX, double locY, double radius, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * ͨ��uid��ѯ�û���Ϣ
	*/
	public void getPersonPage(JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * ��ø��˹���
	 * @param reponseHandler
	 */
	public void getPersonContribute(JsonHttpResponseHandler reponseHandler){
		
	}

	/**
	 * ͨ��uid��ѯ�û��ղص�����Ϣ�������뵱ǰλ�õľ���
	 * @param reponseHandler
	 */
	public void getCollection(JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * �ղص���
	 * @param shopId
	 * @param reponseHandler
	 */
	public void collectionShop(String shopId, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * ȡ���ղص���
	 * @param shopId
	 * @param reponseHandler
	 */
	public void cancelCollectionShop(String shopId, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * id�����̻�������Ϣ
	 * @param shopId
	 * @param reponseHandler
	 */
	public void searchShopEvaluationById(String shopId, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * ����������Ϣ
	 * @param shopName
	 * @param locationX
	 * @param locationY
	 * @param address
	 * @param phoneNumber
	 * @param businessTime
	 * @param tips
	 * @param state
	 * @param reponseHandler
	 */
	public void addShop(String shopName, double locationX, double locationY, String address, String phoneNumber, 
			String businessTime, String tips, String state, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * ��������Ϣ
	 * @param shopId
	 * @param dishName
	 * @param dishPrice
	 * @param reponseHandler
	 */
	public void addDish(String shopId, String dishName, String dishPrice, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * ͨ����Ϣ��������
	 * @param key
	 * @param reponseHandler
	 */
	public void searchShopByKey(String key, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * �ٱ�������Ϣ
	 * @param shopId
	 * @param shopName
	 * @param locationX
	 * @param locationY
	 * @param phoneNumber
	 * @param state
	 * @param businessTime
	 * @param comment
	 * @param reponseHandler
	 */
	public void addShopReport(String shopId, String shopName, double locationX, double locationY, String phoneNumber, 
			String state, String businessTime, String comment, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * �ٱ�����Ϣ
	 * @param dishId
	 * @param comment
	 * @param reponseHandler
	 */
	public void addDishReport(String dishId, String comment, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * �����������
	 * @param shopId
	 * @param tasteGrade
	 * @param environmentGrade
	 * @param serviceGrade
	 * @param pricePerPerson
	 * @param comment
	 * @param reponseHandler
	 */
	public void addShopEvaluation(String shopId, String tasteGrade, String environmentGrade, String serviceGrade, String pricePerPerson,
			String comment, JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * �Ե������۵��޻���ȡ����
	 * @param seId
	 * @param isPrase true:����   false��ȡ����
	 * @param reponseHandler
	 */
	public void praseShopComment(String seId, boolean isPrase, JsonHttpResponseHandler reponseHandler){
		//addShopEvaluation deleteShopEvaluation
		
	}
	
	/**
	 * �Բ˵��޻���ȡ����
	 * @param dishId
	 * @param isPrase true:����   false��ȡ����
	 * @param reponseHandler
	 */
	public void praseDish(String dishId, boolean isPrase, JsonHttpResponseHandler reponseHandler){
		//addDishEvaluation deleteDishEvaluation
	
	}
	
	/**
	 * ����û����������Ϣ
	 * @param reponseHandler
	 */
	public void getPersonPoint(JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * ��ѯ�ҵ�����
	 * @param reponseHandler
	 */
	public void getPersonComment(JsonHttpResponseHandler reponseHandler){
		
	}
	
	/**
	 * ����������а����ΰ�ǰ10��
	 * @param reponseHandler
	 */
	public void getLevelList(JsonHttpResponseHandler reponseHandler){
		
	}
}
