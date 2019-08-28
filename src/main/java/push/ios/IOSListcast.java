package push.ios;

import push.IOSNotification;

public class IOSListcast extends IOSNotification {
	
	public IOSListcast(String appkey, String appMasterSecret) throws Exception {
		
		setAppMasterSecret(appMasterSecret);
		setPredefinedKeyValue("appkey", appkey);
		setPredefinedKeyValue("type", "listcast");
		this.setPredefinedKeyValue("timestamp", System.currentTimeMillis());
	}

	public void setDeviceToken(String token) throws Exception {
		
		setPredefinedKeyValue("device_tokens", token);
	}
}
