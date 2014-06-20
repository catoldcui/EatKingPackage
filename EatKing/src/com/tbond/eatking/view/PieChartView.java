package com.tbond.eatking.view;

import static com.googlecode.charts4j.Color.*;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.ListView;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;

/**
*
* @author Julien Chastang (julien.c.chastang at gmail dot com)
*/
public class PieChartView extends WebView {
	LinkedList<Slice> sliceList = new LinkedList<Slice>();	
	public PieChartView(Context context) {
		super(context);
	}
   
   public void addSlice(int percent, Color color, String sliceLabel, String sliceLegend){
	   sliceList.add(Slice.newSlice(percent, color, sliceLabel, sliceLegend));
   }
   
   @SuppressLint("SetJavaScriptEnabled")
   public void setUp(){
	   
//       WebSettings webSettings = getSettings();
//       webSettings.setJavaScriptEnabled(true);
//	   webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//	   webSettings.setAllowContentAccess(true);
//	   webSettings.setAllowFileAccess(true);
//       webSettings.setPluginState(PluginState.ON);
//	   webSettings.setDomStorageEnabled(true);
//	   webSettings.setLoadWithOverviewMode(true);
//	   webSettings.setUseWideViewPort(true);
//	   setHorizontalScrollBarEnabled(false);
//	   setVerticalScrollBarEnabled(false);
//	   webSettings.setRenderPriority(RenderPriority.HIGH);  
//	   webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
	   getSettings().setJavaScriptEnabled(true);     
       getSettings().setLoadWithOverviewMode(true);
       getSettings().setUseWideViewPort(true); 
       setWebChromeClient(new WebChromeClient());
	   loadUrl(example1());
   }

   public String example1() {
       // EXAMPLE CODE START
       PieChart chart = GCharts.newPieChart(sliceList);
       chart.setTitle("A Better Web", BLACK, 16);
       chart.setSize(400, 200);
       chart.setThreeD(true);
       
       String url = chart.toURLString();
       return normalize( url );
   }
}
