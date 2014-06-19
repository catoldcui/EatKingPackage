package com.tbond.eatking.view;

import greendroid.widget.SegmentedAdapter;
import greendroid.widget.SegmentedHost;
import greendroid.widget.ActionBarItem.Type;
import greendroid.widget.SegmentedBar.OnSegmentChangeListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.tbond.eatking.R;
import com.tbond.eatking.net.JsonAnalysis;

public class KTZActivity extends Activity {
	private PeopleSegmentedAdapter mAdapter;
    SegmentedHost segmentedHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.chi_duo_shi_guang);
        segmentedHost = (SegmentedHost) findViewById(R.id.segmented_host);
        segmentedHost.getSegmentedBar().setOnSegmentChangeListener(new SegmentSwitcher());
        
        mAdapter = new PeopleSegmentedAdapter();
        segmentedHost.setAdapter(mAdapter);
    }
    
    private class SegmentSwitcher implements OnSegmentChangeListener {
        public void onSegmentChange(int index, boolean clicked) {
            changeActivity(index);
        }
    }
    
    public void changeActivity(int index){
    	Log.i("index", "点了点了" + index);
    	segmentedHost.getSegmentedBar().setEnabled(false);
    	switch (index) {
		case 0:
			Intent intent = new Intent();
            intent.setClass(KTZActivity.this, CreateShopActivity.class);
            startActivity(intent);
            break;
		default:
			break;
		}
    }
    
    /**
     * segmentbar四个小项的事件处理以及名称
     * @author Administrator
     *
     */
    private class PeopleSegmentedAdapter extends SegmentedAdapter {
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public String getSegmentTitle(int position) {
            switch (position) {
                case 0:
                    //return getString(R.string.newOne);
                	return "您距离上一名还差*分";
            }

            return null;
        }

		@Override
		public View getView(int position, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}
    }
}