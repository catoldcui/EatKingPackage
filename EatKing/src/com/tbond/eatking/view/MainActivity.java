package com.tbond.eatking.view;


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

import com.tbond.eatking.R;
import com.tbond.eatking.controller.Controller;
import com.tbond.eatking.model.Shop;
import com.tbond.eatking.model.UserComment;
import com.tbond.eatking.net.JsonAnalysis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends GDActivity {

    private PeopleSegmentedAdapter mAdapter;
    SegmentedHost segmentedHost;
    private QuickActionBar mBar;
    private Intent intent;
    
    public MainActivity(){
    	super(ActionBar.Type.Normal);
    }
    
    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setActionBarContentView(R.layout.activity_main);

        segmentedHost = (SegmentedHost) findViewById(R.id.segmented_host);
        segmentedHost.getSegmentedBar().setOnSegmentChangeListener(new SegmentSwitcher());
        
        mAdapter = new PeopleSegmentedAdapter();
//        mHandler.postDelayed(new Runnable() {
//            public void run() {
//                mAdapter.mReverse = true;
//                mAdapter.notifyDataSetChanged();
//            }
//        }, 4000);
        getGDActionBar().setFirstDrawable(this, R.drawable.gd_action_bar_list);
        getGDActionBar().getFirstButton().setOnClickListener(new ListBarListener());;
        addActionBarItem(Type.Search, R.id.action_bar_search);
//        TitleActionBarItem titleActionBarItem = new TitleActionBarItem(getString(R.string.gd_mail));
//        addActionBarItem(titleActionBarItem, R.id.action_bar_title);
//        addActionBarItem(getGDActionBar()
//                .newActionBarItem(NormalActionBarItem.class)
//                .setDrawable(R.drawable.ic_title_export)
//                .setContentDescription(R.string.gd_export), R.id.action_bar_export);
//        addActionBarItem(Type.Locate, R.id.action_bar_locate);
        segmentedHost.setAdapter(mAdapter);
        getGDActionBar().setBackgroundColor(getResources().getColor(R.color.color1));
        
        prepareQuickActionBar();
    }
    
    /**
     * ׼��actionbar�е�listbar����listListener����ʾ
     */
    private void prepareQuickActionBar() {
        mBar = new QuickActionBar(this);
        mBar.addQuickAction(new MyQuickAction(this, R.drawable.gd_action_bar_all_friends, R.string.personalInfo));
        mBar.addQuickAction(new MyQuickAction(this, R.drawable.gd_action_bar_star, R.string.mark));
        mBar.addQuickAction(new MyQuickAction(this, R.drawable.gd_action_bar_compose, R.string.setting));

        mBar.setOnQuickActionClickListener(mActionListener);
    }

    /**
     * ���listbar�е����¼�
     */
    private OnQuickActionClickListener mActionListener = new OnQuickActionClickListener() {
        public void onQuickActionClicked(QuickActionWidget widget, int position) {
            //Toast.makeText(MainActivity.this, "Item " + position + " clicked", Toast.LENGTH_SHORT).show();
            switch (position) {
			case 0:
				if(Controller.getInstance().isLogin()){
					intent = new Intent(MainActivity.this, PersonalHomepage.class);
					startActivity(intent);
				} else {
					intent = new Intent(MainActivity.this, UserLogin.class);
					Toast.makeText(MainActivity.this, "���¼", Toast.LENGTH_SHORT).show();
					startActivity(intent);
				}
				break;
			
			case 1:
				Toast.makeText(MainActivity.this, "�ղ�", Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
        }
    };
    
    private class SegmentSwitcher implements OnSegmentChangeListener {
        public void onSegmentChange(int index, boolean clicked) {
            changeActivity(index);
        }
    }
    
    public void changeActivity(int index){
    	Log.i("index", "���˵���" + index);
    	segmentedHost.getSegmentedBar().setEnabled(false);
    	switch (index) {
		case 0:
			intent = new Intent();
            intent.setClass(MainActivity.this, CreateShopActivity.class);
            startActivity(intent);
            break;
		case 1:
			JsonAnalysis.getInstance().login(MainActivity.this, "tbond", "tbond");
		
			break;
		case 2:
	        intent = new Intent();
	        intent.setClass(MainActivity.this, PersonalHomepage.class);
	        startActivity(intent);
//			intent = new Intent();
//	        intent.setClass(MainActivity.this, PaiHangBangTabActivity.class);
//	        startActivity(intent);
			break;
		case 3:
			
	        intent = new Intent();
	        intent.setClass(MainActivity.this, ShopInfoActivity.class);
	        startActivity(intent);
			break;

		default:
			break;
		}
    }
    
    /**
     * segmentbar�ĸ�С����¼������Լ�����
     * @author Administrator
     *
     */
    private class PeopleSegmentedAdapter extends SegmentedAdapter {
        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public String getSegmentTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.newOne);
                case 1:
                    return getString(R.string.recommand);
                case 2:
                    return getString(R.string.list);
                case 3:
                    return getString(R.string.more);
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
     * ����actionbar�ϵĳ���homelist�������¼�
     */
    @Override
    public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
    	
        int itemId = item.getItemId();
        if (itemId == R.id.action_bar_search) {
        	Intent intent = new Intent();
            intent.setClass(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        } else {
			return super.onHandleActionBarItemClick(item, position);
		}

        return true;
    }
    
    /**
     * ����listbar�¼�
     * @author Administrator
     *
     */
    private class ListBarListener implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			mBar.show(arg0);
		}
    };
    
    /**
     * �Լ�quickActionBar
     * @author Administrator
     *
     */
    private static class MyQuickAction extends QuickAction {
        /**
         * ����ͼƬ��ɫ
         */
        private static final ColorFilter BLACK_CF = new LightingColorFilter(Color.BLACK, Color.BLACK);

        public MyQuickAction(Context ctx, int drawableId, int titleId) {
            super(ctx, buildDrawable(ctx, drawableId), titleId);
        }
        
        private static Drawable buildDrawable(Context ctx, int drawableId) {
            Drawable d = ctx.getResources().getDrawable(drawableId);
            d.setColorFilter(BLACK_CF);
            return d;
        }
        
    }
}
