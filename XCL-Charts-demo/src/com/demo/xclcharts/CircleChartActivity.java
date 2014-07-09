package com.demo.xclcharts;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class CircleChartActivity extends Activity {
	
	com.demo.xclcharts.view.CircleChart03View chart = null;
	TextView  mDesc = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circle_chart);
		
	
		
		chart = (com.demo.xclcharts.view.CircleChart03View)findViewById(R.id.chartview); 

		/*
		RelativeLayout.LayoutParams layoutParams= 
	         //   new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT); 		
				new RelativeLayout.LayoutParams(400, 400);
	            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT); 
	            
	           // layoutParams.setMargins(280, 0, 0, 0); 
	            layoutParams.setMargins(0, 0, 200, 0);	            
	            chart.setLayoutParams(layoutParams); 
	            */
	            
		
		SeekBar seekBar = (SeekBar) this.findViewById(R.id.seekBar1);	
		mDesc=(TextView)findViewById(R.id.tv_process);
		
		 seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
	         
	            @Override
	            public void onStopTrackingTouch(SeekBar seekBar) {	               
	            }
	          
	            @Override
	            public void onStartTrackingTouch(SeekBar seekBar) {	                
	            }
	        
	            @Override
	            public void onProgressChanged(SeekBar seekBar, int progress,
	                    boolean fromUser) {
	            	
	            	mDesc.setText(Integer.toString(progress));	            
	            	chart.setPercentage(progress);
	       			chart.chartRender();
	       			chart.invalidate();
	               
	            }
	        });
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.circle_chart, menu);
		return true;
	}

}