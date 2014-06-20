package com.tbond.eatking.view;

import java.util.List;

import android.R.integer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.tbond.eatking.R;
import com.tbond.eatking.model.Dish;
import com.tbond.eatking.model.Shop;
import com.tbond.eatking.model.UserComment;
import com.tbond.eatking.net.JsonAnalysis;

import greendroid.app.GDActivity;
import greendroid.widget.ActionBar;
import greendroid.widget.ActionBarItem;
import greendroid.widget.QuickAction;
import greendroid.widget.QuickActionBar;
import greendroid.widget.QuickActionWidget;
import greendroid.widget.SegmentedAdapter;
import greendroid.widget.SegmentedHost;
import greendroid.widget.ActionBarItem.Type;
import greendroid.widget.QuickActionWidget.OnQuickActionClickListener;
import greendroid.widget.SegmentedBar.OnSegmentChangeListener;

public class ShopInfoActivity extends GDActivity {
	ShopInfoActivity shopInfoActivity;
	public static int MAXLENGTH = 20;
	private PeopleSegmentedAdapter mAdapter;
    SegmentedHost segmentedHost;
    private Intent intent;
    RatingBar tasteBar;
    RatingBar serviceBar;
    RatingBar envBar;
    TextView locView;
    TextView evaView;
    TextView dishView;
    TextView shopName;
    TextView phoneView;
    
    int tasteNum;
    int serNum;
    int envNum;
    
    public ShopInfoActivity(){
    	super(ActionBar.Type.Normal);
    	shopInfoActivity = this;
    }
    
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setActionBarContentView(R.layout.shop_info_activity);

        segmentedHost = (SegmentedHost) findViewById(R.id.segmented_host);
        segmentedHost.getSegmentedBar().setOnSegmentChangeListener(new SegmentSwitcher());
        
        mAdapter = new PeopleSegmentedAdapter();
        
        getGDActionBar().setFirstDrawable(this, R.drawable.gd_action_bar_back);
        getGDActionBar().getFirstButton().setOnClickListener(new BackBarListener());;
        addActionBarItem(Type.Star, R.id.action_bar_star);
        
        segmentedHost.setAdapter(mAdapter);
        getGDActionBar().setBackgroundColor(Color.parseColor("#f8a062"));
        segmentedHost.getSegmentedBar().setBackgroundColor(Color.parseColor("#f8a062"));
        
        tasteBar = (RatingBar)findViewById(R.id.taste_rating);
        tasteBar.setIsIndicator(true);
        serviceBar =  (RatingBar)findViewById(R.id.ser_rating);
        serviceBar.setIsIndicator(true);
        envBar =  (RatingBar)findViewById(R.id.env_rating);
        envBar.setIsIndicator(true);
        
        locView =  (TextView)findViewById(R.id.shop_info);
        evaView =  (TextView)findViewById(R.id.comment);
        dishView =  (TextView)findViewById(R.id.trends_view);
        shopName = (TextView)findViewById(R.id.username);
        phoneView = (TextView)findViewById(R.id.level_view);
        
        loadData();
        //createPieChart();
    }
    
    public void loadData(){
    	JsonAnalysis.getInstance().searchShopById(this, "1");
    }
    
    public void createPieChart(){
    	PieChartView pieChartView = new PieChartView(ShopInfoActivity.this);
    	pieChartView.addSlice(30, com.googlecode.charts4j.Color.WHEAT, "11111", "test1");
    	pieChartView.addSlice(30, com.googlecode.charts4j.Color.RED, "22222", "test2");
    	pieChartView.addSlice(40, com.googlecode.charts4j.Color.BLUE, "33333", "test3");
    	pieChartView.setUp();
    	
    	((LinearLayout) getContentView().findViewById(R.id.linearLayout1)).addView(pieChartView);
    }
    
    private class SegmentSwitcher implements OnSegmentChangeListener {
        public void onSegmentChange(int index, boolean clicked) {
            changeActivity(index);
        }
    }
    
    public void setMessage(String message){
		Toast.makeText(ShopInfoActivity.this, message, Toast.LENGTH_SHORT).show();
    }
    
    public void changeActivity(int index){
    	Log.i("index", "点了点了" + index);
    	segmentedHost.getSegmentedBar().setEnabled(false);
    	switch (index) {
		case 0:
			// 签到
			JsonAnalysis.getInstance().signin(this, "1");
            break;
		case 1:
			
			break;
		case 2:
	        Intent intent = new Intent();
	        intent.setClass(ShopInfoActivity.this, CorrectActivity.class);
	        startActivity(intent);
			break;

		default:
			break;
		}
    }
    
    /**
     * segmentbar3个小项的事件处理以及名称
     * @author Administrator
     *
     */
    private class PeopleSegmentedAdapter extends SegmentedAdapter {
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public String getSegmentTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.loc_mark);
                case 1:
                    return getString(R.string.evaluate);
                case 2:
                    return getString(R.string.correct);
            }

            return null;
        }

		@Override
		public View getView(int position, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}
    }
    
    /**
     * 处理actionbar上的除了homelist的所有事件
     */
    @Override
    public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
    	
        int itemId = item.getItemId();
        if (itemId == R.id.action_bar_star) {
        	JsonAnalysis.getInstance().collectionShop(shopInfoActivity, "1");
        } else {
			return super.onHandleActionBarItemClick(item, position);
		}

        return true;
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

	public void setDish(List<Dish> dishes) {
		// TODO Auto-generated method stub
		String dishName = "";
		for(int i = 0; dishName.length() < MAXLENGTH && i < dishes.size(); i++){
			dishName += dishes.get(i).getDishName() + " ";
		}
		if(dishes.size() == 0){
			dishName = "无推荐，点击进入推荐";
		}
		dishView.setText(dishName);
	};
	
	public void setComment(UserComment comment) {
		// TODO Auto-generated method stub
		String comString = comment.GetComment();
		String timeString = comment.GetTime();
		evaView.setText(comString + "\n" + timeString);
	}

	public void setShop(Shop shop) {
		// TODO Auto-generated method stub
		shopName.setText(shop.getShopName());
		phoneView.setText(shop.getphoneNumber());
		locView.setText(shop.getAddress());
		
		tasteBar.setRating(Float.valueOf(shop.GetTastGrade()));
		serviceBar.setRating(Float.valueOf(shop.GetServiceGrade()));
		envBar.setRating(Float.valueOf(shop.GetEnvironmentGrade()));
	}
}
