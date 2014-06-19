package com.tbond.eatking.view;

import com.tbond.eatking.R;
import com.tbond.eatking.net.JsonAnalysis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShopInfoChanged extends Activity {
	ShopInfoChanged shopInfoChanged;
    EditText shopNameEditText;
    EditText locEditText;
    EditText phoneEditText;
    EditText moneyEditText;
    EditText timeEditText;
    EditText tagEditText;
    
    Button submitButton;
    
    String shopId = "1";
    public ShopInfoChanged() {
		// TODO Auto-generated constructor stub
    	shopInfoChanged = this;
	}
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.shop_info_changed);
        
        shopNameEditText = (EditText)findViewById(R.id.shop_name);
        locEditText = (EditText)findViewById(R.id.location);
        phoneEditText = (EditText)findViewById(R.id.phone_num);
        moneyEditText = (EditText)findViewById(R.id.per_money);
        timeEditText = (EditText)findViewById(R.id.open_time);
        tagEditText = (EditText)findViewById(R.id.tag_edit);
        
        submitButton = (Button)findViewById(R.id.submit);
        submitButton.setOnClickListener(new SubmitButtonListener());
    }
    
    public void toastMessage(String message){
    	Toast.makeText(ShopInfoChanged.this, message, Toast.LENGTH_SHORT).show();
    	finish();
    }
    
    public class SubmitButtonListener implements OnClickListener{

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			if(shopNameEditText.getText().toString().isEmpty()){
				Toast.makeText(ShopInfoChanged.this, "店名不能为空", Toast.LENGTH_SHORT).show(); 
				return;
			}
			JsonAnalysis.getInstance().addShopReport(shopInfoChanged, shopId, shopNameEditText.getText().toString(), 0, 0, phoneEditText.getText().toString(), "4", timeEditText.getText().toString(), tagEditText.getText().toString());
		}
    }
}
