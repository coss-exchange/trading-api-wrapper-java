package coss.api.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;

public class RequestHandler {
	
	/**
	 * 
	 * @param isPublic - false for signed methods. true for public methods.
	 * @param apiURL - Specific api end point.
	 * @param params - query string
	 * @return server JSON response string.
	 */


	public static String makeRequestGET(boolean isPublic, String apiURL, String params) {

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", "application/json");
		System.out.println("params = " + params);
		System.out.println("apiURL = " + apiURL);
		StringBuffer output = new StringBuffer();
		String current = null;
		String urlEncodedParams = params;
		StringBuffer urlQuery = new StringBuffer(apiURL);
		if (null != urlEncodedParams && !params.trim().equals("")) {
			urlQuery.append("?").append(urlEncodedParams);
		}
		System.out.println("urlQuery = " + urlQuery);

		try {

			URL url = new URL(urlQuery.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(Constants.GET);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

			if (!isPublic) {
				try {
					String signature = URLEncoder.encode(getSignedData(Constants.PRIVATE_API_KEY, params), "UTF-8");
					System.out.println("params = " + params);
					requestHeaders.put("Signature", signature);
					requestHeaders.put("Authorization", Constants.PUBLIC_API_KEY);
					conn.setRequestProperty("Signature", signature);
					conn.setRequestProperty("Authorization", Constants.PUBLIC_API_KEY);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			System.out.println("Output from Server .... \n");
			while ((current = br.readLine()) != null) {
				output.append(current);
				System.out.println(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return output.toString();

	}
	
	/**
	 * 
	 * @param isPublic - false for signed methods. true for public methods.
	 * @param httpMethod - POST OR DELETE
	 * @param apiURL - Specific api end point.
	 * @param json - JSONObject
	 * @return server JSON response string.
	 */

	public static String makeRequestPOSTDELETE(boolean isPublic, String httpMethod, String apiURL, 
			JSONObject json) {

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Content-Type", "application/json");
		System.out.println("apiURL = " + apiURL);
		StringBuffer output = new StringBuffer();
		String current = null;

		try {

			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (Constants.POST.equals(httpMethod)) {
				conn.setRequestMethod(Constants.POST);
			} else if (Constants.DELETE.equals(httpMethod)) {
				conn.setRequestMethod(Constants.DELETE);
			} else {
				return "Only POST and DELETE methods are supported";
			}
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			if (!isPublic) {

				try {
					conn.setDoOutput(true);
					conn.setDoInput(true);
					
					System.out.println("order json " + json.toString());
					
					String signature = getSignedData(Constants.PRIVATE_API_KEY, json.toString());
					conn.setRequestProperty("Signature", signature);
					conn.setRequestProperty("Authorization", Constants.PUBLIC_API_KEY);
					OutputStream outputStream = conn.getOutputStream();
					outputStream.write(json.toString().getBytes("UTF-8"));
					outputStream.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			System.out.println("Output from Server .... \n");
			while ((current = br.readLine()) != null) {
				output.append(current);
				System.out.println(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return output.toString();

	}
	
	
	/**
	 * The method gets the signed data based on private key.
	 * @param key
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private static String getSignedData(String key, String data) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		String encoded = new String(bytesToHex(sha256_HMAC.doFinal(data.getBytes("UTF-8"))));

		System.out.println("encoded = " + encoded);
		return encoded;
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (byte byt : bytes)
			result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
		return result.toString();
	}


}
