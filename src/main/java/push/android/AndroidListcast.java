package push.android;

import push.AndroidNotification;

public class AndroidListcast extends AndroidNotification {
	
	public AndroidListcast(String appkey, String appMasterSecret) throws Exception {
		
		setAppMasterSecret(appMasterSecret);
		setPredefinedKeyValue("appkey", appkey);
		setPredefinedKeyValue("type", "listcast");
	}

	public void setDeviceToken(String token) throws Exception {
		
		setPredefinedKeyValue("device_tokens", token);
	}
}
