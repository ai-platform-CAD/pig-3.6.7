package com.pig4cloud.pig.operator.client;

import com.google.gson.JsonObject;
import com.pig4cloud.pig.operator.api.entity.Workflow;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Deprecated
@Slf4j
public class WorkflowPythonClient {

	private static final WorkflowPythonClient workflowPythonClient = new WorkflowPythonClient();

	private static final String url = "http://localhost:5000";

	private static final CloseableHttpClient httpclient = HttpClients.createDefault();


	private WorkflowPythonClient() {
	}

	public static WorkflowPythonClient getInstance() {
		return workflowPythonClient;
	}

	/**
	 * 发送HttpGet请求
	 *
	 * @param url
	 * @return
	 */
	public static String sendGet(String url) {

		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String result = null;
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity);
			}
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 发送HttpPost请求，参数为map
	 *
	 * @param url
	 * @param map
	 * @return
	 */
	public static String sendPost(String url, Map<String, String> map) {

		JsonObject jsonObject = new JsonObject();
		for (Map.Entry entry : map.entrySet()) {
			jsonObject.addProperty(entry.getKey().toString(), entry.getValue().toString());
		}   // 以上循环操作是将 Map对象转化成 JsonObject对象
		System.out.println(jsonObject);
		StringEntity entity = new StringEntity(jsonObject.toString(), Consts.UTF_8);
		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(entity);     //设置请求体
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity entity1 = response.getEntity();
		String result = null;
		try {
			result = EntityUtils.toString(entity1);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean sendWorkflow(Workflow workflow) throws UnsupportedEncodingException {
		Map<String, String> map = new HashMap<>();

		System.out.println(sendGet(url));

		return true;
	}


}
