package com.lashouinc.library.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Assert;

public class HttpClient {

	@SuppressWarnings("deprecation")
	public static String getStr(String url) {
		Assert.notNull(url, "url cannot be null");
		
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HttpEntity entity = response.getEntity(); 
		byte[] bytes = null;
		String jsonStr = null;
		
		if (entity != null) {
			try {
				bytes = EntityUtils.toByteArray(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String charSet = ""; 
			charSet = EntityUtils.getContentCharSet(entity); 
			charSet = (charSet!=null)?charSet:"utf-8";
            try {
				jsonStr = new String(bytes, charSet);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return jsonStr;
	}
}
