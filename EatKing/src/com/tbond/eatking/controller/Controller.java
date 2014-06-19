package com.tbond.eatking.controller;

public class Controller {
	static Controller controller = new Controller();
	boolean isLogin = false;
	
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public static Controller getInstance(){
		return controller;
	}
	
	public boolean isLogin(){
		return isLogin;
	}
	
	public void setLogin(boolean isLogin){
		this.isLogin = isLogin;
	}
}
