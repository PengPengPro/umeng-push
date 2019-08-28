package push.ios;

import push.IOSNotification;

public class IOSUnicast extends IOSNotification {
	
	public IOSUnicast(String appkey, String appMasterSecret) throws Exception {
		
		setAppMasterSecret(appMasterSecret);
		setPredefinedKeyValue("appkey", appkey);
		this.setPredefinedKeyValue("type", "unicast");
		this.setPredefinedKeyValue("timestamp", System.currentTimeMillis());
	}

	public void setDeviceToken(String token) throws Exception {
		
		setPredefinedKeyValue("device_tokens", token);
	}
}
