package com.tbond.eatking.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;




import com.tbond.eatking.R;
import com.tbond.eatking.controller.Controller;
import com.tbond.eatking.net.JsonAnalysis;


//import com.example.wenandroid.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends Activity implements OnClickListener {
private EditText login_username;
private EditText login_password;
private Button user_login_button;
private Button user_register_button;

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//    StrictMode.setThreadPolicy(policy);
    setContentView(R.layout.activity_user_login);
    initWidget();
}
    private void initWidget()
    {
        login_username=(EditText)findViewById(R.id.login_username);
        login_password=(EditText)findViewById(R.id.login_password);
        user_login_button=(Button)findViewById(R.id.user_login_button);
        user_register_button=(Button)findViewById(R.id.user_register_button);
        user_login_button.setOnClickListener(this);
        user_register_button.setOnClickListener(this);
        login_username.setOnFocusChangeListener(new OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if(!hasFocus){
                    String username=login_username.getText().toString().trim();
                    if(username.length()<4){
                        Toast.makeText(UserLogin.this, "用户名不能小于4个字符", Toast.LENGTH_SHORT);
                    }
                }
            }
            
        });
        login_password.setOnFocusChangeListener(new OnFocusChangeListener()
        {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if(!hasFocus){
                    String password=login_password.getText().toString().trim();
                    if(password.length()<4){
                        Toast.makeText(UserLogin.this, "密码不能小于4个字符", Toast.LENGTH_SHORT);
                    }
                }
            }
            
        });
    }
    

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
	        case R.id.user_login_button:
	            if(checkEdit())
	            {
	                login();
	            }
	             
	            break;
	        case R.id.user_register_button:
	            Intent intent2=new Intent(UserLogin.this,UserRegister.class);
	            startActivity(intent2);
	            break;
        }
    }
    
    private boolean checkEdit(){
        if(login_username.getText().toString().trim().equals("")){
            Toast.makeText(UserLogin.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        }else if(login_password.getText().toString().trim().equals("")){
            Toast.makeText(UserLogin.this, "密码不能为空", Toast.LENGTH_SHORT).show();
        }else{
            return true;
        }
        return false;
    }
    
    public void setToast(String messageString){
    	Toast.makeText(UserLogin.this, messageString, Toast.LENGTH_SHORT).show();
    	
    	if(Controller.getInstance().isLogin()){
    		finish();
    	}
    }
    
    private void login(){
        JsonAnalysis.getInstance().login(this, login_username.getText().toString().trim(), login_password.getText().toString().trim());
    }
}