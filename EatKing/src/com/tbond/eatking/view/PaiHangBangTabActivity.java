package com.tbond.eatking.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost.OnTabChangeListener;

import com.tbond.eatking.R;

import greendroid.app.GDTabActivity;

public class PaiHangBangTabActivity extends GDTabActivity {
	private static final String TAB1 = "tab_one";
    private static final String TAB2 = "tab_two";
    private static final String COR_TYPE = "correct_type";

    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setTitle("Screen 2");
        getContentView().setBackgroundColor(Color.WHITE);
        getGDActionBar().setFirstDrawable(this, R.drawable.gd_action_bar_back);
        getGDActionBar().getFirstButton().setOnClickListener(new BackBarListener());

        addTab(TAB1, getResources().getString(R.string.chi_duo_shi_guang), Color.BLACK, "Content of tab #1");
        addTab(TAB2, getResources().getString(R.string.kai_tuo_zhe), Color.rgb(20, 0, 20), "Content of tab #2");
        
        for(int i = 0;i < getTabHost().getTabWidget().getChildCount();i++)
		{
			// 设置为选择的tag颜色
			getTabHost().getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#8A4117"));
		}
        // 设置当前tag颜色
		getTabHost().getTabWidget().getChildAt(getTabHost().getCurrentTab()).setBackgroundColor(Color.parseColor("#C35817"));
        
		// 设置tag点击事件
        getTabHost().setOnTabChangedListener(new OnTabChangeListener(){
        	@Override
        	public void onTabChanged(String tabId) {
        		for(int i = 0;i < getTabHost().getTabWidget().getChildCount();i++)
        		{
        			
        			getTabHost().getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#8A4117"));
        		}

        		getTabHost().getTabWidget().getChildAt(getTabHost().getCurrentTab()).setBackgroundColor(Color.parseColor("#C35817"));
    		}
    	});
    }
    
    private void addTab(String tag, CharSequence label, int color, String text) {
    	if(tag.equals(TAB1)){
    		final Intent intent = new Intent(this, CDSGActivity.class);
    		addTab(tag, label, intent);
    	} else if (tag.equals(TAB2)){
    		final Intent intent = new Intent(this, CDSGActivity.class);
    		addTab(tag, label, intent);
    	} else {
    		Log.i("wrong", "wrong input");
    	}
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
    };
}
