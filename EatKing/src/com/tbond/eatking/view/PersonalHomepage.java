package com.tbond.eatking.view;

import greendroid.app.GDActivity;
import greendroid.widget.ActionBar;
import greendroid.widget.ActionBarItem.Type;

import com.tbond.eatking.R;
import com.tbond.eatking.model.ErrorMessage;
import com.tbond.eatking.model.Shop;
import com.tbond.eatking.model.User;
import com.tbond.eatking.model.UserComment;
import com.tbond.eatking.net.JsonAnalysis;

import android.R.string;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class PersonalHomepage extends GDActivity {
	TextView usernameView;
	TextView personalWordView;
	Button levelView;
	Button commentView;
	Button trendView;
	Button shopView;
	
	public PersonalHomepage(){
    	super(ActionBar.Type.Normal);
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setActionBarContentView(R.layout.personal_page);
		
		setTitle("个人信息");
		getGDActionBar().setBackgroundColor(Color.parseColor("#f8a062"));
		getGDActionBar().setFirstDrawable(this, R.drawable.gd_action_bar_back);
        getGDActionBar().getFirstButton().setOnClickListener(new BackBarListener());
        
        usernameView = (TextView)findViewById(R.id.username);
        personalWordView = (TextView)findViewById(R.id.personal_word);
        levelView = (Button)findViewById(R.id.level_view);
        commentView = (Button)findViewById(R.id.comment);
        trendView = (Button)findViewById(R.id.trends_view);
        shopView = (Button)findViewById(R.id.shop_info);
        
        getData();
	}
	
	public void getData(){
		JsonAnalysis.getInstance().getPersonPage(this);
	}
	
	public void setUser(User user){
		usernameView.setText(user.getUserName());
		if(!user.getUserIntro().equals("null")){
			personalWordView.setText("    " + user.getUserIntro());
		}
		
		String levelViewString = "吃多识广得分： " + user.getMyChowhoundPoint() + 
				"\n开拓者得分： " + user.getMypioneerpoint();
		
		levelView.setText(levelViewString);
	}
	
	public void setComment(UserComment comment){
		String comString = "";
		comString = comment.GetShopName() + " " + comment.GetTime() +
				"\n" + comment.GetComment() + "\n评分" + comment.getPerPoint();
		commentView.setText(comString);
	}
	
	public void setContribute(String contribute){
		shopView.setText(contribute);
	}
	
	/**
     * 处理listbar事件
     * @author Administrator
     *
     */
    private class BackBarListener implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			finish();
		}
    }

	public void setMessage(String mess) {
		// TODO Auto-generated method stub
		Toast.makeText(PersonalHomepage.this, mess, Toast.LENGTH_SHORT).show();
	}

}
