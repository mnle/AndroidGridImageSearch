package com.yahoo.gridimagesearch;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//Data model for results from G Image Search API
public class ImageResult implements Serializable {
	private static final long serialVersionUID = 111111111;
	private String fullUrl;
	private String thumbUrl;
	
	public ImageResult(JSONObject json){
		try {
			this.fullUrl = json.getString("url");
			this.thumbUrl = json.getString("tbUrl");
		} catch (JSONException e) {
			this.fullUrl = null;
			this.thumbUrl = null;
		}
	}
	//Getting full size image
	public String getFullURL() {
		return fullUrl;	
	}
	public void setFullURL(String fullUrl) {
		this.fullUrl = fullUrl;
	}
	
	//Getting thumb nail image size
	public String getThumbURL() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	
	public String toString() {
		return this.thumbUrl;
	}

	//Converting JSON to ArrayList
	public static ArrayList<ImageResult> fromJSONArray(
			JSONArray array) {
		ArrayList<ImageResult> results = new ArrayList<ImageResult>(); 
		for (int x = 0;  x < array.length(); x++) {	
			try {
				results.add(new ImageResult(array.getJSONObject(x)));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return results;
	}
}
