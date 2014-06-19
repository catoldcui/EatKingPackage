package com.tbond.eatking.view;

import com.tbond.eatking.R;

import android.R.string;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.os.Build;

public class PersonalHomepage extends Activity {

	private Button homepage_tab1_button;
	private Button homepage_tab2_button;
	private Button homepage_tab3_button;
	private Button homepage_tab4_button;
	private Button retnButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_homepage);
		initWidget();

	}

	private void initWidget() {
		homepage_tab1_button = (Button) findViewById(R.id.button1);
		homepage_tab2_button = (Button) findViewById(R.id.Button01);
		homepage_tab3_button = (Button) findViewById(R.id.Button02);
		homepage_tab4_button = (Button) findViewById(R.id.Button03);

		homepage_tab2_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(PersonalHomepage.this, HomepageTab2.class);
				startActivity(intent);
			}
		});

		homepage_tab3_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(PersonalHomepage.this, HomepageTab3.class);
				startActivity(intent);
			}
		});

		homepage_tab4_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(PersonalHomepage.this, HomepageTab4.class);
				startActivity(intent);
			}
		});

	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	//
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// // Handle action bar item clicks here. The action bar will
	// // automatically handle clicks on the Home/Up button, so long
	// // as you specify a parent activity in AndroidManifest.xml.
	// int id = item.getItemId();
	// if (id == R.id.action_settings) {
	// return true;
	// }
	// return super.onOptionsItemSelected(item);
	// }
	//
	// /**
	// * A placeholder fragment containing a simple view.
	// */
	// public static class PlaceholderFragment extends Fragment {
	//
	// public PlaceholderFragment() {
	// }
	//
	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	// View rootView = inflater.inflate(R.layout.personal_homepage, container,
	// false);
	// return rootView;
	// }
	// }

	// public class ButtonClick implements OnClickListener{
	//
	// @Override
	// public void onClick(View arg0) {
	// // TODO Auto-generated method stub
	// setTitle("sdgsdfhdfgdfgd");
	//
	// }
	//
	// }
}
