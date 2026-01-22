package com.qiahao.nextvideo.agoraadapter;

import com.tencent.trtc.TRTCCloudDef;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface IRTCEngineHandler extends BaseAgoraHandlerInterface {
    void onConnectOtherRoom(int i, int i2, String str);

    void onDisConnectOtherRoom(int i, String str);

    void onRecvSEIMsg(int i, byte[] bArr);

    void onSetMixTranscodingConfig(int i, String str);

    void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i, int i2);

    void onUserSubStreamAvailable(int i, boolean z);
}
