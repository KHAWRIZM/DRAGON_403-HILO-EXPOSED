package com.tencent.imsdk.manager;

import com.tencent.imsdk.common.SystemUtil;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SDKConfig {
    public long sdkAppId = 0;
    public String sdkInitPath = "";
    public long sdkInstanceType = 0;
    public boolean isTestEnvironment = false;
    public boolean enableQuic = false;
    public boolean isIPv6Prior = false;
    public String stringUIPlatform = "";
    public int numberUIPlatform = 0;
    public DeviceInfo deviceInfo = new DeviceInfo();
    public NetworkInfo networkInfo = new NetworkInfo();
    public ProxyInfo proxyInfo = new ProxyInfo();
    public DatabaseEncryptInfo databaseEncryptInfo = new DatabaseEncryptInfo();
    public PacketRetryInfo packetRetryInfo = new PacketRetryInfo();
    public LogSetting logSetting = new LogSetting();
    public String packageName = "";
    public String appName = "";
    public int applicationID = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class DatabaseEncryptInfo {
        public int encryptType = 0;
        public String encryptKey = "";

        public void clean() {
            this.encryptType = 0;
            this.encryptKey = "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class DeviceInfo {
        public String deviceType = "";
        public long deviceBrand = 0;
        public String systemVersion = "";
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class LogSetting {
        public boolean enableConsoleLog = true;
        public int logLevel = 0;
        public String logFilePath = "";
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class NetworkInfo {
        public int networkType = 0;
        public int ipType = 1;
        public String networkId = "";
        public long wifiNetworkHandle = 0;
        public long xgNetworkHandle = 0;
        public long initializeCostTime = 0;
        public boolean networkConnected = false;

        public void clean() {
            this.networkType = 0;
            this.ipType = 1;
            this.networkId = "";
            this.wifiNetworkHandle = 0L;
            this.xgNetworkHandle = 0L;
            this.initializeCostTime = 0L;
            this.networkConnected = false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class PacketRetryInfo {
        public int maxRetryCount = 0;
        public int packetRequestTimeout = 0;

        public void clean() {
            this.maxRetryCount = 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ProxyInfo {
        public int proxyType = 0;
        public String proxyHost = "";
        public int proxyPort = 0;
        public String proxyUsername = "";
        public String proxyPassword = "";

        public void clean() {
            this.proxyType = 0;
            this.proxyHost = "";
            this.proxyPort = 0;
            this.proxyUsername = "";
            this.proxyPassword = "";
        }
    }

    public static float getAppCpuUsage() {
        return SystemUtil.getAppCpuUsage();
    }

    public static float getAppMemoryUsage() {
        return SystemUtil.getAppMemory();
    }

    public static String getDeviceID() {
        return SystemUtil.getDeviceID();
    }

    public static float getSysCpuUsage() {
        return SystemUtil.getSysCpuUsage();
    }
}
