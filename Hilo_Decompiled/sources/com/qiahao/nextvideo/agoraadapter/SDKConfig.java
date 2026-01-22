package com.qiahao.nextvideo.agoraadapter;

import android.annotation.SuppressLint;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.ServerInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import md.b;
import org.jetbrains.annotations.NotNull;
import pd.g;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/agoraadapter/SDKConfig;", "", "<init>", "()V", "AGORA_APPID", "", "TX_SDKAPPID", "", "TX_BIZID", "TX_APPID", "TX_CHANNELNAME_INT", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"CheckResult"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SDKConfig {

    @JvmField
    @NotNull
    public static String AGORA_APPID;

    @NotNull
    public static final SDKConfig INSTANCE = new SDKConfig();

    @JvmField
    public static int TX_APPID;

    @JvmField
    public static int TX_BIZID;

    @JvmField
    public static int TX_CHANNELNAME_INT;

    @JvmField
    public static int TX_SDKAPPID;

    static {
        String str;
        int i;
        BaseServer baseServer = BaseServer.INSTANCE;
        ServerInfo selectedServerInfo = baseServer.getSelectedServerInfo();
        if (selectedServerInfo == null || (str = selectedServerInfo.getAgoraAppID()) == null) {
            str = "";
        }
        AGORA_APPID = str;
        ServerInfo selectedServerInfo2 = baseServer.getSelectedServerInfo();
        if (selectedServerInfo2 != null) {
            i = selectedServerInfo2.getTencentImAppKey();
        } else {
            i = 0;
        }
        TX_SDKAPPID = i;
        baseServer.getSelectedServerChange().observeOn(b.c()).subscribe(new g() { // from class: com.qiahao.nextvideo.agoraadapter.SDKConfig.1
            public final void accept(String str2) {
                String str3;
                SDKConfig sDKConfig = SDKConfig.INSTANCE;
                BaseServer baseServer2 = BaseServer.INSTANCE;
                ServerInfo selectedServerInfo3 = baseServer2.getSelectedServerInfo();
                if (selectedServerInfo3 == null || (str3 = selectedServerInfo3.getAgoraAppID()) == null) {
                    str3 = "";
                }
                SDKConfig.AGORA_APPID = str3;
                ServerInfo selectedServerInfo4 = baseServer2.getSelectedServerInfo();
                SDKConfig.TX_SDKAPPID = selectedServerInfo4 != null ? selectedServerInfo4.getTencentImAppKey() : 0;
            }
        });
    }

    private SDKConfig() {
    }
}
