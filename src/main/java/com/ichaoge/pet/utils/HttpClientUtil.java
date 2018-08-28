package com.ichaoge.pet.utils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Created by chaoge on 2018/8/28.
 */
public class HttpClientUtil {

	private static HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

	public static String doGet(String httpurl) {
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;// 返回结果字符串
		try {
			// 创建远程url连接对象
			URL url = new URL(httpurl);
			// 通过远程url连接对象打开一个连接，强转成httpURLConnection类
			connection = (HttpURLConnection) url.openConnection();
			// 设置连接方式：get
			connection.setRequestMethod("GET");
			// 设置连接主机服务器的超时时间：15000毫秒
			connection.setConnectTimeout(15000);
			// 设置读取远程返回的数据时间：60000毫秒
			connection.setReadTimeout(60000);
			// 发送请求
			connection.connect();
			// 通过connection连接，获取输入流
			if (connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				// 封装输入流is，并指定字符集
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				// 存放数据
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			connection.disconnect();// 关闭远程连接
		}

		return result;
	}

	public static String postJson(String url, String json) {
		CloseableHttpResponse response = null;
		String content = null;
		CloseableHttpClient client = null;
		HttpPost post = new HttpPost(url);

		try {
			client = httpClientBuilder.build();

			StringEntity requestEntity = new StringEntity(json);
			requestEntity.setContentEncoding("UTF-8");
			requestEntity.setContentType("application/json");
			post.setEntity(requestEntity);

			response = client.execute(post);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity responseEntity = response.getEntity();
				content = EntityUtils.toString(responseEntity, "UTF-8");
				EntityUtils.consume(responseEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (client != null) {
					client.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return content;
	}

	public static String sendJsonPost(String url, String json) {
		CloseableHttpResponse response = null;
		String content = null;
		CloseableHttpClient client = null;
		HttpPost post = new HttpPost(url);

		try {
			client = httpClientBuilder.build();

			StringEntity requestEntity = new StringEntity(json);
			requestEntity.setContentEncoding("GB2312");
			requestEntity.setContentType("application/json");
			post.setEntity(requestEntity);

			response = client.execute(post);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity responseEntity = response.getEntity();
				content = EntityUtils.toString(responseEntity);
				EntityUtils.consume(responseEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (client != null) {
					client.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return content;
	}

	public static String sendHttpPost(String url, String param) {
		return sendHttpPost(url, param, null);
	}

	public static String sendHttpPost(String url, String param, String charset) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			if (StringUtils.isEmpty(charset)) {
				in = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(
						conn.getInputStream(), charset));
			}
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
