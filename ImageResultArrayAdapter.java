package com.yahoo.gridimagesearch;

import java.util.List;

import com.loopj.android.image.SmartImageView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

//When the data changes in our model, then change the view
public class ImageResultArrayAdapter extends ArrayAdapter<ImageResult> {
	public ImageResultArrayAdapter(Context context, List<ImageResult> images) {
		super(context, R.layout.item_image_result, images);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageResult imageInfo = this.getItem(position);
		SmartImageView ivImage;
		//If we don't have a view to reuse, inflate it from the layout
		if (convertView == null) {
			LayoutInflater inflator = LayoutInflater.from(getContext());
			ivImage = (SmartImageView) inflator.inflate(R.layout.item_image_result, parent, false); 
		} else {
			//We reuse the previous views to save resources, should be much better for memory
			ivImage = (SmartImageView) convertView;
			ivImage.setImageResource(android.R.color.transparent);
			}
		//THIS LINE WAS --> 		ivImage.setImageUrl(imageInfo.getThumbUrl());
		ivImage.setImageUrl(imageInfo.getThumbURL());
		return ivImage;
			
	}
}

