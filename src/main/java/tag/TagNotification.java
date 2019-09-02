package tag;

import java.util.Arrays;
import java.util.HashSet;

import org.json.JSONObject;

public class TagNotification {
	
	private final JSONObject rootJson = new JSONObject();
	private String appkey;
	private String appMasterSecret;
	
	protected static final HashSet<String> ROOT_KEYS = new HashSet<String>(Arrays.asList(new String[]{
			"appkey", "timestamp", "device_tokens", "tag"}));
	
	public TagNotification() {
	}

	public TagNotification(String appkey, String appMasterSecret) throws Exception {
		this.appkey = appkey;
		this.appMasterSecret = appMasterSecret;
		buildParams();
	}
	
	public void buildParams() throws Exception {
		setPredefinedKeyValue("appkey", this.appkey);
		String timestamp = Integer.toString((int)(System.currentTimeMillis() / 1000));
		setPredefinedKeyValue("timestamp", timestamp);
	}
	
	public void setDeviceToken(String token) throws Exception {
		
		setPredefinedKeyValue("device_tokens", token);
	}
	
	public void setTag(String tag) throws Exception {
		
		setPredefinedKeyValue("tag", tag);
	}

	public boolean setPredefinedKeyValue(String key, Object value) throws Exception {
		
		if (!ROOT_KEYS.contains(key)) {
			return false;
		} 
		rootJson.put(key, value);
		return true;
		
	}
	
	public String getPostBody(){
		return rootJson.toString();
	}

	public String getAppMasterSecret() {
		return appMasterSecret;
	}

	public void setAppMasterSecret(String appMasterSecret) {
		this.appMasterSecret = appMasterSecret;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	
}