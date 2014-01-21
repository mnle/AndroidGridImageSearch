package com.yahoo.gridimagesearch;

import com.loopj.android.image.SmartImageView;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class ImageDisplayActivity extends Activity {
//Displays image in full screen mode
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_display);
		//The calling intent must pass ImageResult
		 ImageResult result = (ImageResult) getIntent().getSerializableExtra(
                 "result");
		 if (result.getClass() == ImageResult.class) {
			 SmartImageView ivImage = (SmartImageView) findViewById(R.id.ivResult);
			 //THIS LINE WAS --> 			 ivImage.setImageUrl(result.getFullUrl());
			 ivImage.setImageUrl(result.getFullURL());
		 } else {
			 Log.d("DEBUG", "ImageDisplayActivity::onCreate did not see ImageResult in getIntent() getExtra for 'result'");
 }
	}

	//@see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image_display, menu);
		return true;
	}

}
