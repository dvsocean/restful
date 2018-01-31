package com.demo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpReqDemo {
	//URL Encode the data
	private static String params = "name=Jennifer&email=jenn2@yahoo.com&password=flyAway123";
	private static String php_endpoint = "http://www.nerdschool.net/api_make_user";
	
	public static void main(String[] args) throws Exception {
		String res = dummyHttpReqRes2(php_endpoint, params);
		System.out.println(res);
    } 
	
	public static String dummyHttpReqRes2(String targetURL, String dataParams) throws IOException {
		URL url = new URL(targetURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            //Create connection
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            //set to true to allow setting method parameters
            conn.setDoOutput(true);

            //Request
            DataOutputStream writer = new DataOutputStream (conn.getOutputStream());
            writer.writeBytes(dataParams);
            writer.close();

            //Response
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder(); 
            String chunk;
            while ((chunk = reader.readLine()) != null) {
                response.append(chunk);
            }
            reader.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
