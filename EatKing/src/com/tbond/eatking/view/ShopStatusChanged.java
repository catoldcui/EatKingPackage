package com.tbond.eatking.view;

import com.tbond.eatking.R;
import com.tbond.eatking.net.JsonAnalysis;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ShopStatusChanged extends Activity {
	ShopStatusChanged shopStatusChanged;
	RadioGroup radioGroup;
	Button submitButton;
	EditText tagEditText;
	String shopId = "1";
	public ShopStatusChanged() {
		// TODO Auto-generated constructor stub
		shopStatusChanged = this;
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_status_changed);
        
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        submitButton = (Button)findViewById(R.id.submit);
        tagEditText = (EditText)findViewById(R.id.tag_edit);
        
        submitButton.setOnClickListener(new SubmitButtonListener());
    }
	
	public void toastMessage(String message){
    	Toast.makeText(ShopStatusChanged.this, message, Toast.LENGTH_SHORT).show();
    	finish();
    }
	
	public class SubmitButtonListener implements OnClickListener{
		@Override
		public void onClick(View view) {
			// 营业（0）/停业（1）/迁移（2）/重复（3）/错误（4）
			int statusNum = radioGroup.getCheckedRadioButtonId();
			String statusString =  "0";
			switch (statusNum) {
			case 0:
				statusString = "0";
				break;
			case 1:
				statusString = "1";
				break;
			case 2:
				statusString = "1";
				break;

			default:
				break;
			}
			JsonAnalysis.getInstance()
				.addShopReport(shopStatusChanged, shopId, "", 0, 0, "", statusString, 
					"", tagEditText.getText().toString());
		}
    }
}
