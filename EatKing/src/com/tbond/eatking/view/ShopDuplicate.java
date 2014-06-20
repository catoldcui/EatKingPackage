package com.tbond.eatking.view;

import com.tbond.eatking.R;
import com.tbond.eatking.net.JsonAnalysis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShopDuplicate extends Activity {
	ShopDuplicate shopDuplicate;
	EditText shopNameEditText;
	Button submitButton;
	String shopId;
	public ShopDuplicate(){
		shopDuplicate = this;
	}
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.shop_duplilcate);
        
        shopNameEditText = (EditText)findViewById(R.id.username);
        
        submitButton = (Button)findViewById(R.id.submit);
        submitButton.setOnClickListener(new SubmitButtonListener());
    }
    
    public void toastMessage(String message){
    	Toast.makeText(ShopDuplicate.this, message, Toast.LENGTH_SHORT).show();
    	finish();
    }
	
	public class SubmitButtonListener implements OnClickListener{
		@Override
		public void onClick(View view) {
			if(shopNameEditText.getText().toString().isEmpty()){
				Toast.makeText(ShopDuplicate.this, "店名不能为空", Toast.LENGTH_SHORT).show(); 
				return;
			}
			// 营业（0）/停业（1）/迁移（2）/重复（3）/错误（4）
			JsonAnalysis.getInstance()
				.addShopReport(shopDuplicate, shopId, shopNameEditText.getText().toString(), 0, 0, "", "3", "", "");
		}
    }
}
