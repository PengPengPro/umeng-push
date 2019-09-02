package tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class TagClient {

	protected final String USER_AGENT = "Mozilla/5.0";

	protected HttpClient client = HttpClientBuilder.create().build();

	protected static final String host = "http://msg.umeng.com/api/tag/";

	public String invoke(TagNotification msg, String method) throws Exception {

		String url = host + method;
		String postBody = msg.getPostBody();
		System.out.println("postBody=" + postBody);
		String sign = DigestUtils.md5Hex(("POST" + url + postBody + msg.getAppMasterSecret()).getBytes("utf8"));
		url = url + "?sign=" + sign;
		System.out.println("url=" + url);
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		StringEntity se = new StringEntity(postBody, "UTF-8");
		post.setEntity(se);
		HttpResponse response = client.execute(post);
		int status = response.getStatusLine().getStatusCode();
		System.out.println("Response Code : " + status);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result.toString());
		if (status == 200) {
			System.out.println("Tag Notification " + method + " successfully.");
		} else {
			System.out.println("Failed to " + method + " the tag notification!");
		}
		return result.toString();
	}

	public String add(TagNotification msg) throws Exception {

		return invoke(msg, "add");
	}
	
	public String list(TagNotification msg) throws Exception {

		return invoke(msg, "list");
	}
	
	public String set(TagNotification msg) throws Exception {

		return invoke(msg, "set");
	}
	
	public String delete(TagNotification msg) throws Exception {

		return invoke(msg, "delete");
	}
	
	public String clear(TagNotification msg) throws Exception {

		return invoke(msg, "clear");
	}

}