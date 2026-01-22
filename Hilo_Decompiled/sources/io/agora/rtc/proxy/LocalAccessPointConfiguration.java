package io.agora.rtc.proxy;

import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class LocalAccessPointConfiguration {
    public ArrayList<String> ipList = null;
    public ArrayList<String> domainList = null;
    public String verifyDomainName = null;
    public int mode = 0;
    public AdvancedConfigInfo advancedConfig = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class AdvancedConfigInfo {
        public LogUploadServerInfo logUploadServer;

        public AdvancedConfigInfo() {
            this.logUploadServer = null;
            this.logUploadServer = new LogUploadServerInfo();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class LogUploadServerInfo {
        public String serverDomain;
        public boolean serverHttps;
        public String serverPath;
        public int serverPort;

        public LogUploadServerInfo() {
            this.serverDomain = null;
            this.serverPath = null;
            this.serverPort = 0;
            this.serverHttps = true;
        }

        public LogUploadServerInfo(String str, String str2, int i10, boolean z10) {
            this.serverDomain = str;
            this.serverPath = str2;
            this.serverPort = i10;
            this.serverHttps = z10;
        }
    }
}
