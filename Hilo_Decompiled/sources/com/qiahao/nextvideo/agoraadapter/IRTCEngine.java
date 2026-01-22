package com.qiahao.nextvideo.agoraadapter;

import android.graphics.Bitmap;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface IRTCEngine extends BaseAgoraInterface {
    void ConnectOtherRoom(String str);

    void DisconnectOtherRoom();

    void selectMotionTmpl(String str);

    void setChinLevel(int i);

    void setDebugViewMargin(int i, TRTCCloud.TRTCViewMargin tRTCViewMargin);

    void setEyeScaleLevel(int i);

    void setFaceShortLevel(int i);

    void setFaceSlimLevel(int i);

    void setFaceVLevel(int i);

    void setFilter(Bitmap bitmap);

    void setFilterConcentration(float f);

    void setGSensorMode(int i);

    boolean setGreenScreenFile(String str);

    void setLocalViewRotation(int i);

    void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig);

    void setMotionMute(boolean z);

    void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam);

    void setNoseSlimLevel(int i);

    void setRemoteSubStreamViewFillMode(int i, int i2);

    void setVideoEncoderMirror(boolean z);

    void showDebugView(int i);

    void startCdnPlayerWithUrl(String str, TXCloudVideoView tXCloudVideoView);

    void startRemoteSubStreamView(int i, TXCloudVideoView tXCloudVideoView);

    void stopCdnPlayer();

    void stopRemoteSubStreamView(int i);
}
