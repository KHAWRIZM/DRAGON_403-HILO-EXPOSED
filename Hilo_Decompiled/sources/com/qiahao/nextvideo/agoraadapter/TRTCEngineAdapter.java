package com.qiahao.nextvideo.agoraadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import com.oudi.utils.log.LogUtil;
import com.qiahao.nextvideo.agoraadapter.RtmpMessageBean;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import io.agora.rtc.IAudioEffectManager;
import io.agora.rtc.IAudioFrameObserver;
import io.agora.rtc.IMetadataObserver;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.mediaio.IVideoFrameConsumer;
import io.agora.rtc.mediaio.IVideoSink;
import io.agora.rtc.mediaio.IVideoSource;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.models.ClientRoleOptions;
import io.agora.rtc.video.AgoraImage;
import io.agora.rtc.video.AgoraVideoFrame;
import io.agora.rtc.video.BeautyOptions;
import io.agora.rtc.video.CameraCapturerConfiguration;
import io.agora.rtc.video.ChannelMediaInfo;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;
import io.agora.rtc.video.VideoCanvas;
import io.agora.rtc.video.VideoEncoderConfiguration;
import io.agora.rtc.video.WatermarkOptions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class TRTCEngineAdapter extends BaseAdapterImpl {
    private static final int BGM_ID = 0;
    public static final int ERR_CAMERA_NOT_AUTHORIZED = -1314;
    public static final int ERR_CAMERA_START_FAIL = -1301;
    public static final int ERR_MIC_START_FAIL = -1302;
    public static final int ERR_MIC_STOP_FAIL = -1320;
    public static final int ERR_NULL = 0;
    public static final int ERR_PLAY_LIVE_STREAM_NET_DISCONNECT = -2301;
    public static final int ERR_ROOM_ENTER_FAIL = -3301;
    public static final int ERR_ROOM_ID_INVALID = -3318;
    public static final int ERR_SDK_APPID_INVALID = -3317;
    public static final int ERR_SPEAKER_START_FAIL = -1321;
    public static final int ERR_SPEAKER_STOP_FAIL = -1323;
    private static final String TAG = "TRTCEngineAdapter";
    private static TRTCEngineAdapter mInstance;
    private String mPublishCdnUrl;
    private Map<String, String> mPublishCdnUrlMap;
    private Deque<String> mPublishCdnUrlStartQueue;
    private Deque<String> mPublishCdnUrlStopQueue;
    private int mTRTCAppId;
    private TRTCCloud mTRTCCloud;
    private TRTCEffectManager mTRTCEffectManager;
    private IRTCEngineHandler mTRTCEngineAdapterListener;
    private final TRTCCloudListener mTRTCEventHandler;
    private TRTCCloudDef.TRTCParams mTRTCParams;
    private String mUid;
    private TRTCVideoFrameListenerImpl mVideoFrameListener;
    private IVideoSource mVideoSource;
    private int mAppScene = 0;
    private boolean mEnableAudioFlag = true;
    private boolean mEnableVideoFlag = true;
    private boolean mDefaultMuteAllRemoteVideoStreams = false;
    private boolean mDefaultMuteAllRemoteAudioStreams = false;
    private TXCloudVideoView mLocalVideoView = null;
    private boolean mIsStartPreview = false;
    private VideoEncoderConfiguration mVideoEncoderConfiguration = new VideoEncoderConfiguration();
    private boolean mBigVideoParamSet = false;
    private boolean mShouldSetSmallVideo = false;
    private boolean mEnableDualMode = false;
    private boolean mUseFontCamera = true;
    private boolean mSpeakerphoneEnableFlag = true;
    private int mLastVideoBitrate = 0;
    private String mBgmFilePath = "";
    private int mMusicPlayoutVolume = 100;
    private int mMusicPublishVolume = 100;
    private final Object mPublishCdnLock = new Object();
    private LiveTranscoding mLiveTranscoding = null;
    private final int MAX_SEND_STREAM_CNT = 5;
    private boolean mDataStreamReliable = false;
    private boolean mDataStreamOrdered = false;
    private int mCurSendStreamCnt = 0;
    private long mLastSecondSendStreamTime = 0;
    private long mSendStreamSizeInSecond = 0;
    private boolean mEnableExternalAudio = false;
    private boolean mEnableExternalVideo = false;
    private boolean mPushMode = false;
    private boolean mExternalVideoUseTexture = false;
    private int mExternalAudioSampleRate = 0;
    private int mExternalAudioChannels = 0;
    private long mJoinRoomTime = 0;
    private long mRejoinStartTime = 0;
    private IRtcEngineEventHandler.RtcStats mLastStats = new IRtcEngineEventHandler.RtcStats();
    private Map<String, Boolean> mRemoteVideoAvailableMap = new HashMap();
    private Map<String, Boolean> mRemoteAudioAvailableMap = new HashMap();
    private Map<String, Integer> mUserVolumeMap = new ConcurrentHashMap();
    private int mCurUserRole = 21;
    private int mTargetUserRole = 21;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class TRTCVideoFrameConsumer implements IVideoFrameConsumer {
        public TRTCVideoFrameConsumer() {
        }

        public void consumeByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, long j) {
            if (i4 == 90 || i4 == 270) {
                TRTCEngineAdapter.this.checkEncoderConfiguration(i3, i2);
            } else {
                TRTCEngineAdapter.this.checkEncoderConfiguration(i2, i3);
            }
            TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
            tRTCVideoFrame.pixelFormat = TRTCEngineAdapter.this.convertFrameFormat(i);
            tRTCVideoFrame.bufferType = 2;
            tRTCVideoFrame.data = bArr;
            tRTCVideoFrame.width = i2;
            tRTCVideoFrame.height = i3;
            tRTCVideoFrame.timestamp = j;
            TRTCEngineAdapter.this.convertFrameRotation(i4, tRTCVideoFrame);
            TRTCEngineAdapter.this.mTRTCCloud.sendCustomVideoData(tRTCVideoFrame);
        }

        public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
            if (i4 == 90 || i4 == 270) {
                TRTCEngineAdapter.this.checkEncoderConfiguration(i3, i2);
            } else {
                TRTCEngineAdapter.this.checkEncoderConfiguration(i2, i3);
            }
            TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
            tRTCVideoFrame.pixelFormat = TRTCEngineAdapter.this.convertFrameFormat(i);
            tRTCVideoFrame.bufferType = 1;
            tRTCVideoFrame.buffer = byteBuffer;
            tRTCVideoFrame.width = i2;
            tRTCVideoFrame.height = i3;
            tRTCVideoFrame.timestamp = j;
            TRTCEngineAdapter.this.convertFrameRotation(i4, tRTCVideoFrame);
            TRTCEngineAdapter.this.mTRTCCloud.sendCustomVideoData(tRTCVideoFrame);
        }

        public void consumeTextureFrame(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
            if (i5 == 90 || i5 == 270) {
                TRTCEngineAdapter.this.checkEncoderConfiguration(i4, i3);
            } else {
                TRTCEngineAdapter.this.checkEncoderConfiguration(i3, i4);
            }
            TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
            tRTCVideoFrame.pixelFormat = TRTCEngineAdapter.this.convertFrameFormat(i2);
            tRTCVideoFrame.bufferType = 3;
            tRTCVideoFrame.width = i3;
            tRTCVideoFrame.height = i4;
            tRTCVideoFrame.timestamp = j;
            TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
            tRTCVideoFrame.texture = tRTCTexture;
            tRTCTexture.textureId = i;
            tRTCTexture.eglContext14 = EGL14.eglGetCurrentContext();
            TRTCEngineAdapter.this.convertFrameRotation(i5, tRTCVideoFrame);
            TRTCEngineAdapter.this.mTRTCCloud.sendCustomVideoData(tRTCVideoFrame);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class TRTCVideoFrameListenerImpl implements TRTCCloudListener.TRTCVideoFrameListener {
        public TRTCVideoFrameListenerImpl() {
        }

        @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener
        public void onGLContextCreated() {
        }

        @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener
        public void onGLContextDestory() {
        }

        @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener
        public int onProcessVideoFrame(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2) {
            tRTCVideoFrame2.data = tRTCVideoFrame.data;
            tRTCVideoFrame2.buffer = tRTCVideoFrame.buffer;
            tRTCVideoFrame2.width = tRTCVideoFrame.width;
            tRTCVideoFrame2.height = tRTCVideoFrame.height;
            tRTCVideoFrame2.rotation = tRTCVideoFrame.rotation;
            TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame2.texture;
            if (tRTCTexture != null) {
                tRTCTexture.textureId = tRTCVideoFrame.texture.textureId;
            }
            LiveTranscoding liveTranscoding = TRTCEngineAdapter.this.mLiveTranscoding;
            if (liveTranscoding != null) {
                TRTCEngineAdapter.this.mTRTCCloud.sendSEIMsg(TRTCEngineAdapter.this.createRtmpMessage(liveTranscoding).getBytes(), 1);
                return 0;
            }
            return 0;
        }
    }

    public TRTCEngineAdapter(Context context, String str, IRTCEngineHandler iRTCEngineHandler) {
        TRTCCloudListener tRTCCloudListener = new TRTCCloudListener() { // from class: com.qiahao.nextvideo.agoraadapter.TRTCEngineAdapter.1
            private int convertPublishErrorCode(int i) {
                if (i == -3323) {
                    return 5;
                }
                return i == -3321 ? 3 : 100;
            }

            private int getNetworkQuality(int i, int i2) {
                if (i2 > 50 || i > 500) {
                    return 5;
                }
                if (i2 > 30 || i > 350) {
                    return 4;
                }
                if (i2 > 20 || i > 200) {
                    return 3;
                }
                if (i2 > 10 || i > 100) {
                    return 2;
                }
                return (i2 >= 0 || i >= 0) ? 1 : 0;
            }

            private boolean isValidNumericString(String str2) {
                if (str2 != null && !str2.isEmpty()) {
                    try {
                        Integer.parseInt(str2);
                        return true;
                    } catch (NumberFormatException unused) {
                    }
                }
                return false;
            }

            public void onApiCallExecuted(int i, String str2, String str3) {
                TRTCEngineAdapter.this.apiLog("onApiCallExecuted " + i + " api: " + str2 + " result: " + str3);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onApiCallExecuted(i, str2, str3);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onAudioEffectFinished(int i, int i2) {
                TRTCEngineAdapter.this.apiLog("onAudioEffectFinished effectId: " + i + " code: " + i2);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onAudioEffectFinished(i);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onAudioRouteChanged(int i, int i2) {
                int i3;
                TRTCEngineAdapter.this.apiLog("onAudioRouteChanged newRoute: " + i + " oldRoute: " + i2);
                if (i == 0) {
                    i3 = 3;
                } else if (i == 1) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onAudioRouteChanged(i3);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onCameraDidReady() {
                TRTCEngineAdapter.this.apiLog("onCameraDidReady");
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onCameraReady();
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onConnectOtherRoom(String str2, int i, String str3) {
                TRTCEngineAdapter.this.apiLog("onConnectOtherRoom userID: " + str2 + " err: " + i + " errMsg: " + str3);
                try {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onConnectOtherRoom(Integer.parseInt(str2), i, str3);
                    if (i == 0) {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onChannelMediaRelayStateChanged(2, 0);
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onChannelMediaRelayEvent(4);
                    } else {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onChannelMediaRelayStateChanged(3, 5);
                    }
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onConnectionLost() {
                TRTCEngineAdapter.this.apiLog("onConnectionLost");
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onError(112);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onConnectionInterrupted();
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onConnectionLost();
                TRTCEngineAdapter.this.mRejoinStartTime = System.currentTimeMillis();
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onConnectionRecovery() {
                TRTCEngineAdapter.this.apiLog("onConnectionRecovery");
                try {
                    try {
                        String str2 = "";
                        if (-1 == TRTCEngineAdapter.this.mTRTCParams.roomId && !TextUtils.isEmpty(TRTCEngineAdapter.this.mTRTCParams.businessInfo)) {
                            try {
                                str2 = new JSONObject(TRTCEngineAdapter.this.mTRTCParams.businessInfo).getString("strGroupId");
                            } catch (JSONException e) {
                                TRTCEngineAdapter.this.apiLogError("onConnectionRecovery parse json error: " + TRTCEngineAdapter.this.mTRTCParams.businessInfo);
                                e.printStackTrace();
                            }
                        }
                        if (TextUtils.isEmpty(str2)) {
                            str2 = String.valueOf(TRTCEngineAdapter.this.mTRTCParams.roomId);
                        }
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRejoinChannelSuccess(str2, Integer.parseInt(TRTCEngineAdapter.this.mUid), (int) (System.currentTimeMillis() - TRTCEngineAdapter.this.mRejoinStartTime));
                    } catch (NumberFormatException unused) {
                        TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + TRTCEngineAdapter.this.mTRTCParams.userId);
                    }
                } finally {
                    TRTCEngineAdapter.this.mRejoinStartTime = 0L;
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onDisConnectOtherRoom(int i, String str2) {
                TRTCEngineAdapter.this.apiLog("onDisConnectOtherRoom " + i + ", " + str2);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onDisConnectOtherRoom(i, str2);
                if (i == 0) {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onChannelMediaRelayStateChanged(0, 0);
                } else {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onChannelMediaRelayStateChanged(3, 5);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onEnterRoom(long j) {
                TRTCEngineAdapter.this.apiLog("onEnterRoom " + j);
                TRTCEngineAdapter.this.mJoinRoomTime = System.currentTimeMillis();
                try {
                    String str2 = "";
                    if (-1 == TRTCEngineAdapter.this.mTRTCParams.roomId && !TextUtils.isEmpty(TRTCEngineAdapter.this.mTRTCParams.businessInfo)) {
                        try {
                            str2 = new JSONObject(TRTCEngineAdapter.this.mTRTCParams.businessInfo).getString("strGroupId");
                        } catch (JSONException e) {
                            TRTCEngineAdapter.this.apiLogError("onEnterRoom parse json error: " + TRTCEngineAdapter.this.mTRTCParams.businessInfo);
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = String.valueOf(TRTCEngineAdapter.this.mTRTCParams.roomId);
                    }
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onJoinChannelSuccess(str2, Integer.parseInt(TRTCEngineAdapter.this.mTRTCParams.userId), (int) j);
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + TRTCEngineAdapter.this.mTRTCParams.userId);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onError(int i, String str2, Bundle bundle) {
                int i2;
                TRTCEngineAdapter.this.apiLogError("onError errCode: " + i + " errMsg: " + str2);
                if (i != -3318) {
                    if (i != -3317) {
                        if (i != -3301) {
                            i2 = 111;
                            if (i != -2301) {
                                if (i != -1323) {
                                    if (i != -1314) {
                                        if (i != 0) {
                                            if (i != -1321) {
                                                if (i != -1320) {
                                                    if (i != -1302) {
                                                        i2 = i != -1301 ? 1 : 1003;
                                                    }
                                                }
                                            }
                                        } else {
                                            i2 = 0;
                                        }
                                    } else {
                                        i2 = 1501;
                                    }
                                }
                                i2 = 1010;
                            }
                        } else {
                            i2 = 17;
                        }
                    } else {
                        i2 = 101;
                    }
                } else {
                    i2 = 102;
                }
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onError(i2);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onExitRoom(int i) {
                TRTCEngineAdapter.this.apiLog("onExitRoom " + i);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onLeaveChannel(TRTCEngineAdapter.this.mLastStats);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onFirstAudioFrame(String str2) {
                int currentTimeMillis = (int) (System.currentTimeMillis() - TRTCEngineAdapter.this.mJoinRoomTime);
                if (str2 != null) {
                    try {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onFirstRemoteAudioFrame(Integer.parseInt(str2), currentTimeMillis);
                    } catch (NumberFormatException unused) {
                        TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                    }
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onFirstVideoFrame(String str2, int i, int i2, int i3) {
                TRTCEngineAdapter.this.apiLog("onFirstVideoFrame userId: " + str2 + " streamType: " + i + " width: " + i2 + " height: " + i3);
                int currentTimeMillis = (int) (System.currentTimeMillis() - TRTCEngineAdapter.this.mJoinRoomTime);
                try {
                    if (str2 != null) {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onFirstRemoteVideoFrame(Integer.parseInt(str2), i2, i3, currentTimeMillis);
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRemoteVideoStateChanged(Integer.parseInt(str2), 1, 0, currentTimeMillis);
                    } else {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onFirstLocalVideoFrame(i2, i3, currentTimeMillis);
                    }
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onMicDidReady() {
                super.onMicDidReady();
                LogUtil.INSTANCE.e("eTag", "onMicDidReady", false);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onMissCustomCmdMsg(String str2, int i, int i2, int i3) {
                TRTCEngineAdapter.this.apiLog("onMissCustomCmdMsg userId: " + str2 + " cmdID: " + i + " errCode: " + i2 + " missed: " + i3);
                try {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onStreamMessageError(Integer.parseInt(str2), i, i2, i3, 0);
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
                Iterator<TRTCCloudDef.TRTCQuality> it = arrayList.iterator();
                while (it.hasNext()) {
                    TRTCCloudDef.TRTCQuality next = it.next();
                    try {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onNetworkQuality(Integer.parseInt(next.userId), tRTCQuality.quality, next.quality);
                    } catch (NumberFormatException unused) {
                        TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + next.userId);
                        return;
                    }
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onRecvCustomCmdMsg(String str2, int i, int i2, byte[] bArr) {
                TRTCEngineAdapter.this.apiLog("onRecvCustomCmdMsg userId: " + str2 + " cmdID: " + i + " seq: " + i2 + " messageSize: " + bArr.length);
                try {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onStreamMessage(Integer.parseInt(str2), i, bArr);
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onSendFirstLocalVideoFrame(int i) {
                TRTCEngineAdapter.this.apiLog("onSendFirstLocalVideoFrame  streamType:" + i);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onFirstLocalVideoFramePublished((int) (System.currentTimeMillis() - TRTCEngineAdapter.this.mJoinRoomTime));
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onStartPublishCDNStream(int i, String str2) {
                TRTCEngineAdapter.this.apiLog("onStartPublishCDNStream " + i + ", " + str2);
                if (i == 0) {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(TRTCEngineAdapter.this.mPublishCdnUrl, 2, i);
                } else {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(TRTCEngineAdapter.this.mPublishCdnUrl, 4, convertPublishErrorCode(i));
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0097 A[Catch: all -> 0x007f, TryCatch #0 {all -> 0x007f, blocks: (B:4:0x002d, B:15:0x0086, B:17:0x0097, B:18:0x00b0, B:22:0x0050, B:23:0x0063, B:25:0x0069, B:28:0x0075), top: B:3:0x002d }] */
            @Override // com.tencent.trtc.TRTCCloudListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onStartPublishMediaStream(String str2, int i, String str3, Bundle bundle) {
                int i2;
                TRTCEngineAdapter.this.apiLog("onStartPublishMediaStream taskId: " + str2 + ", code: " + i + ", message: " + str3);
                synchronized (TRTCEngineAdapter.this.mPublishCdnLock) {
                    try {
                        String str4 = (String) TRTCEngineAdapter.this.mPublishCdnUrlStartQueue.pop();
                        int i3 = 4;
                        if (i != -3334) {
                            if (i != -3333) {
                                if (i != -3323) {
                                    if (i != -3321) {
                                        i2 = 0;
                                        if (i == 0) {
                                            TRTCEngineAdapter.this.mPublishCdnUrlMap.put(str4, str2);
                                            Iterator it = TRTCEngineAdapter.this.mPublishCdnUrlStopQueue.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                } else if (str4.equals((String) it.next())) {
                                                    TRTCEngineAdapter.this.mTRTCCloud.stopPublishMediaStream(str2);
                                                    break;
                                                }
                                            }
                                            i3 = 2;
                                        }
                                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, i3, i2);
                                        if (TRTCEngineAdapter.this.mVideoFrameListener == null) {
                                            TRTCEngineAdapter tRTCEngineAdapter = TRTCEngineAdapter.this;
                                            tRTCEngineAdapter.mVideoFrameListener = new TRTCVideoFrameListenerImpl();
                                            TRTCEngineAdapter.this.mTRTCCloud.setLocalVideoProcessListener(2, 3, TRTCEngineAdapter.this.mVideoFrameListener);
                                        }
                                    }
                                }
                            }
                            i2 = 3;
                            TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, i3, i2);
                            if (TRTCEngineAdapter.this.mVideoFrameListener == null) {
                            }
                        }
                        i2 = 5;
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, i3, i2);
                        if (TRTCEngineAdapter.this.mVideoFrameListener == null) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onStatistics(TRTCStatistics tRTCStatistics) {
                int size = tRTCStatistics.localArray.size();
                int size2 = tRTCStatistics.remoteArray.size();
                IRtcEngineEventHandler.RtcStats rtcStats = new IRtcEngineEventHandler.RtcStats();
                IRtcEngineEventHandler.LocalVideoStats localVideoStats = new IRtcEngineEventHandler.LocalVideoStats();
                IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats = new IRtcEngineEventHandler.RemoteVideoStats();
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i += tRTCStatistics.localArray.get(i3).audioBitrate;
                    i2 += tRTCStatistics.localArray.get(i3).videoBitrate;
                }
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < size2; i6++) {
                    i4 += tRTCStatistics.remoteArray.get(i6).audioBitrate;
                    i5 += tRTCStatistics.remoteArray.get(i6).videoBitrate;
                }
                rtcStats.cpuAppUsage = tRTCStatistics.appCpu;
                rtcStats.cpuTotalUsage = tRTCStatistics.systemCpu;
                rtcStats.lastmileDelay = tRTCStatistics.rtt;
                rtcStats.rxAudioKBitRate = i4;
                rtcStats.txAudioKBitRate = i;
                rtcStats.rxVideoKBitRate = i5;
                rtcStats.txVideoKBitRate = i2;
                rtcStats.txKBitRate = i + i2;
                rtcStats.rxKBitRate = i4 + i5;
                rtcStats.rxBytes = (int) tRTCStatistics.receiveBytes;
                rtcStats.txBytes = (int) tRTCStatistics.sendBytes;
                rtcStats.totalDuration = ((int) (System.currentTimeMillis() - TRTCEngineAdapter.this.mJoinRoomTime)) / 1000;
                rtcStats.users = size2 + 1;
                if (tRTCStatistics.localArray.size() > 0) {
                    localVideoStats.encodedFrameWidth = tRTCStatistics.localArray.get(0).width;
                    localVideoStats.encodedFrameHeight = tRTCStatistics.localArray.get(0).height;
                    localVideoStats.sentBitrate = i2;
                    localVideoStats.sentFrameRate = tRTCStatistics.localArray.get(0).frameRate;
                }
                TRTCEngineAdapter.this.mLastStats = rtcStats;
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtcStats(rtcStats);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onLocalVideoStats(localVideoStats);
                for (int i7 = 0; i7 < size2; i7++) {
                    try {
                        remoteVideoStats.uid = Integer.parseInt(tRTCStatistics.remoteArray.get(i7).userId);
                        remoteVideoStats.width = tRTCStatistics.remoteArray.get(i7).width;
                        remoteVideoStats.height = tRTCStatistics.remoteArray.get(i7).height;
                        remoteVideoStats.receivedBitrate = tRTCStatistics.remoteArray.get(i7).videoBitrate;
                        remoteVideoStats.rendererOutputFrameRate = tRTCStatistics.remoteArray.get(i7).frameRate;
                        int i8 = tRTCStatistics.remoteArray.get(i7).streamType;
                        if (i8 != 0) {
                            if (i8 != 1) {
                                remoteVideoStats.rxStreamType = 0;
                            } else {
                                remoteVideoStats.rxStreamType = 1;
                            }
                        } else {
                            remoteVideoStats.rxStreamType = 0;
                        }
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRemoteVideoStats(remoteVideoStats);
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onAudioQuality(Integer.parseInt(TRTCEngineAdapter.this.mUid), getNetworkQuality(tRTCStatistics.rtt, tRTCStatistics.downLoss), (short) tRTCStatistics.rtt, (short) tRTCStatistics.downLoss);
                    } catch (NumberFormatException unused) {
                        TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:");
                        return;
                    }
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onStopPublishCDNStream(int i, String str2) {
                TRTCEngineAdapter.this.apiLog("onStopPublishCDNStream " + i + ", " + str2);
                if (i == 0) {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(TRTCEngineAdapter.this.mPublishCdnUrl, 5, 100);
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(TRTCEngineAdapter.this.mPublishCdnUrl, 0, 100);
                } else {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(TRTCEngineAdapter.this.mPublishCdnUrl, 4, convertPublishErrorCode(i));
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onStopPublishMediaStream(String str2, int i, String str3, Bundle bundle) {
                int i2;
                TRTCEngineAdapter.this.apiLog("onStopPublishMediaStream taskId: " + str2 + ", code: " + i + ", message: " + str3);
                synchronized (TRTCEngineAdapter.this.mPublishCdnLock) {
                    try {
                        if (TRTCEngineAdapter.this.mPublishCdnUrlStopQueue.isEmpty()) {
                            return;
                        }
                        String str4 = (String) TRTCEngineAdapter.this.mPublishCdnUrlStopQueue.pop();
                        int i3 = 4;
                        if (i != -3336) {
                            if (i != -3335) {
                                if (i != -3323) {
                                    if (i != -3321) {
                                        i2 = 0;
                                        if (i == 0) {
                                            TRTCEngineAdapter.this.mPublishCdnUrlMap.remove(str4);
                                            if (TRTCEngineAdapter.this.mPublishCdnUrlMap.isEmpty()) {
                                                TRTCEngineAdapter.this.mLiveTranscoding = null;
                                            }
                                            i3 = 0;
                                        }
                                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, 5, 100);
                                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, i3, i2);
                                    }
                                }
                            }
                            i2 = 3;
                            TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, 5, 100);
                            TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, i3, i2);
                        }
                        i2 = 5;
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, 5, 100);
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRtmpStreamingStateChanged(str4, i3, i2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onSwitchRole(int i, String str2) {
                int i2;
                TRTCEngineAdapter.this.apiLog("onSwitchRole " + i + ", " + str2);
                if (i == 0) {
                    IRTCEngineHandler iRTCEngineHandler2 = TRTCEngineAdapter.this.mTRTCEngineAdapterListener;
                    int i3 = 2;
                    if (TRTCEngineAdapter.this.mCurUserRole == 20) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    if (TRTCEngineAdapter.this.mTargetUserRole == 20) {
                        i3 = 1;
                    }
                    iRTCEngineHandler2.onClientRoleChanged(i2, i3);
                    TRTCEngineAdapter tRTCEngineAdapter = TRTCEngineAdapter.this;
                    tRTCEngineAdapter.mCurUserRole = tRTCEngineAdapter.mTargetUserRole;
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onTryToReconnect() {
                TRTCEngineAdapter.this.apiLog("onTryToReconnect");
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUpdatePublishMediaStream(String str2, int i, String str3, Bundle bundle) {
                TRTCEngineAdapter.this.apiLog("onUpdatePublishMediaStream taskId: " + str2 + ", code: " + i + ", message: " + str3);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onTranscodingUpdated();
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserAudioAvailable(String str2, boolean z) {
                TRTCEngineAdapter.this.apiLog("onUserAudioAvailable " + str2 + ", " + z);
                try {
                    Boolean bool = (Boolean) TRTCEngineAdapter.this.mRemoteAudioAvailableMap.get(str2);
                    if (bool == null) {
                        bool = Boolean.TRUE;
                        TRTCEngineAdapter.this.mRemoteAudioAvailableMap.put(str2, bool);
                    }
                    if (bool.booleanValue() && z) {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onFirstRemoteAudioDecoded(Integer.parseInt(str2), (int) (System.currentTimeMillis() - TRTCEngineAdapter.this.mJoinRoomTime));
                        TRTCEngineAdapter.this.mRemoteAudioAvailableMap.put(str2, Boolean.FALSE);
                        return;
                    }
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onUserMuteAudio(Integer.parseInt(str2), z);
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserEnter(String str2) {
                TRTCEngineAdapter.this.apiLog("onUserEnter userId: " + str2);
                try {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onUserJoined(Integer.parseInt(str2), (int) (System.currentTimeMillis() - TRTCEngineAdapter.this.mJoinRoomTime));
                    TRTCEngineAdapter.this.mTRTCCloud.muteRemoteVideoStream(str2, TRTCEngineAdapter.this.mDefaultMuteAllRemoteVideoStreams);
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserExit(String str2, int i) {
                TRTCEngineAdapter.this.apiLog("onUserExit userId: " + str2 + " reason: " + i);
                try {
                    TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onUserOffline(Integer.parseInt(str2), i);
                    TRTCEngineAdapter.this.mRemoteVideoAvailableMap.remove(str2);
                    TRTCEngineAdapter.this.mRemoteAudioAvailableMap.remove(str2);
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserVideoAvailable(String str2, boolean z) {
                TRTCEngineAdapter.this.apiLog("onUserVideoAvailable uid: " + str2 + " available: " + z);
                try {
                    Boolean bool = (Boolean) TRTCEngineAdapter.this.mRemoteVideoAvailableMap.get(str2);
                    if (bool == null) {
                        bool = Boolean.TRUE;
                        TRTCEngineAdapter.this.mRemoteVideoAvailableMap.put(str2, bool);
                    }
                    if (bool.booleanValue() && z) {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onFirstRemoteVideoDecoded(Integer.parseInt(str2), 0, 0, 0);
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRemoteVideoStateChanged(Integer.parseInt(str2), 1, 6, 0);
                        TRTCEngineAdapter.this.mRemoteVideoAvailableMap.put(str2, Boolean.FALSE);
                    } else {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onRemoteVideoStateChanged(Integer.parseInt(str2), 0, 5, 0);
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onUserMuteVideo(Integer.parseInt(str2), !z);
                    }
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str2);
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i) {
                int size = arrayList.size();
                if (size > 0) {
                    IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr = new IRtcEngineEventHandler.AudioVolumeInfo[size];
                    IRtcEngineEventHandler.AudioVolumeInfo audioVolumeInfo = new IRtcEngineEventHandler.AudioVolumeInfo();
                    TRTCEngineAdapter.this.mUserVolumeMap.clear();
                    int i2 = 0;
                    for (int i3 = 0; i3 < size; i3++) {
                        String str2 = arrayList.get(i3).userId;
                        if (!TextUtils.isEmpty(str2)) {
                            i2++;
                            audioVolumeInfoArr[i3] = new IRtcEngineEventHandler.AudioVolumeInfo();
                            if (!str2.isEmpty() && isValidNumericString(str2)) {
                                try {
                                    audioVolumeInfoArr[i3].uid = Integer.parseInt(str2);
                                } catch (NumberFormatException unused) {
                                    audioVolumeInfoArr[i3].uid = 0;
                                }
                            } else {
                                audioVolumeInfoArr[i3].uid = 0;
                            }
                            audioVolumeInfoArr[i3].volume = (int) ((arrayList.get(i3).volume / 100.0f) * 255.0f);
                            IRtcEngineEventHandler.AudioVolumeInfo audioVolumeInfo2 = audioVolumeInfoArr[i3];
                            if (audioVolumeInfo2.volume > audioVolumeInfo.volume) {
                                audioVolumeInfo = audioVolumeInfo2;
                            }
                            TRTCEngineAdapter.this.mUserVolumeMap.put(str2, Integer.valueOf(audioVolumeInfoArr[i3].volume));
                        }
                    }
                    if (i2 > 0) {
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onAudioVolumeIndication(audioVolumeInfoArr, i);
                        TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onActiveSpeaker(audioVolumeInfo.uid);
                    }
                }
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onWarning(int i, String str2, Bundle bundle) {
                TRTCEngineAdapter.this.apiLog("onWarning warningCode: " + i + " warningMsg: " + str2);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onWarning(i);
            }
        };
        this.mTRTCEventHandler = tRTCCloudListener;
        TRTCCloud sharedInstance = TRTCCloud.sharedInstance(context);
        this.mTRTCCloud = sharedInstance;
        this.mTRTCEngineAdapterListener = iRTCEngineHandler;
        sharedInstance.setListener(tRTCCloudListener);
        TRTCEffectManager tRTCEffectManager = new TRTCEffectManager(this.mTRTCCloud);
        this.mTRTCEffectManager = tRTCEffectManager;
        tRTCEffectManager.setMusicObserver(new TXAudioEffectManager.TXMusicPlayObserver() { // from class: com.qiahao.nextvideo.agoraadapter.TRTCEngineAdapter.2
            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public void onComplete(int i, int i2) {
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onAudioEffectFinished(i);
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public void onPlayProgress(int i, long j, long j2) {
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public void onStart(int i, int i2) {
            }
        });
        this.mTRTCAppId = Integer.parseInt(str);
    }

    public static SurfaceView CreateRendererView(Context context) {
        return new SurfaceView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apiLog(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apiLogError(String str) {
    }

    private boolean checkAudioEnable() {
        if (!this.mEnableAudioFlag) {
            apiLogError("audio is not enable!");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int checkEncoderConfiguration(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        VideoEncoderConfiguration videoEncoderConfiguration = this.mVideoEncoderConfiguration;
        VideoEncoderConfiguration.VideoDimensions videoDimensions = videoEncoderConfiguration.dimensions;
        int i5 = videoDimensions.width;
        int i6 = videoDimensions.height;
        VideoEncoderConfiguration.ORIENTATION_MODE orientation_mode = videoEncoderConfiguration.orientationMode;
        boolean z2 = true;
        if (orientation_mode == VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_ADAPTIVE && i5 > i6 && i < i2) {
            i4 = i6;
            i3 = i5;
            z = true;
        } else {
            i3 = i6;
            i4 = i5;
            z = false;
        }
        if (orientation_mode == VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_FIXED_PORTRAIT && i5 > i6) {
            i4 = i6;
            i3 = i5;
            z = true;
        }
        if (orientation_mode != VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_FIXED_LANDSCAPE || i5 >= i6) {
            z2 = z;
            i6 = i4;
            i5 = i3;
        }
        if (z2) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("videoWidth", i6);
                jSONObject2.put("videoHeight", i5);
                jSONObject2.put("videoFps", this.mVideoEncoderConfiguration.frameRate);
                jSONObject2.put("videoBitrate", this.mVideoEncoderConfiguration.bitrate);
                jSONObject2.put("streamType", 0);
                jSONObject.put("api", "setVideoEncodeParamEx");
                jSONObject.put("params", jSONObject2);
                VideoEncoderConfiguration.VideoDimensions videoDimensions2 = this.mVideoEncoderConfiguration.dimensions;
                videoDimensions2.width = i6;
                videoDimensions2.height = i5;
                this.mTRTCCloud.callExperimentalAPI(jSONObject.toString());
            } catch (JSONException unused) {
                apiLogError("setVideoEncodeParamEx err :JSONException");
                return -1;
            }
        }
        return 0;
    }

    private boolean checkVideoEnable() {
        if (!this.mEnableVideoFlag) {
            apiLogError("video is not enable!");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int convertFrameFormat(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 3) {
            return 4;
        }
        if (i != 4) {
            if (i == 10) {
                return 2;
            }
            if (i == 11) {
                return 3;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void convertFrameRotation(int i, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        int i2 = 0;
        if (i != 0) {
            if (i != 90) {
                if (i != 180) {
                    if (i == 270) {
                        i2 = 3;
                    }
                } else {
                    i2 = 2;
                }
            } else {
                i2 = 1;
            }
        }
        tRTCVideoFrame.rotation = i2;
    }

    private TRTCCloudDef.TRTCPublishTarget convertTRTCPublishTarget(String str) {
        TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget = new TRTCCloudDef.TRTCPublishTarget();
        tRTCPublishTarget.mode = 3;
        tRTCPublishTarget.cdnUrlList.add(new TRTCCloudDef.TRTCPublishCdnUrl(str, false));
        return tRTCPublishTarget;
    }

    private TRTCCloudDef.TRTCStreamEncoderParam convertTRTCStreamEncoderParam(LiveTranscoding liveTranscoding) {
        TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam = new TRTCCloudDef.TRTCStreamEncoderParam();
        tRTCStreamEncoderParam.videoEncodedWidth = liveTranscoding.width;
        tRTCStreamEncoderParam.videoEncodedHeight = liveTranscoding.height;
        tRTCStreamEncoderParam.videoEncodedFPS = liveTranscoding.videoFramerate;
        int floor = (int) Math.floor(liveTranscoding.videoGop / r1);
        tRTCStreamEncoderParam.videoEncodedGOP = floor;
        if (floor < 1) {
            tRTCStreamEncoderParam.videoEncodedGOP = 1;
        }
        if (tRTCStreamEncoderParam.videoEncodedGOP > 10) {
            tRTCStreamEncoderParam.videoEncodedGOP = 10;
        }
        tRTCStreamEncoderParam.videoEncodedKbps = liveTranscoding.videoBitrate;
        tRTCStreamEncoderParam.audioEncodedSampleRate = LiveTranscoding.AudioSampleRateType.getValue(liveTranscoding.audioSampleRate);
        tRTCStreamEncoderParam.audioEncodedChannelNum = liveTranscoding.audioChannels;
        tRTCStreamEncoderParam.audioEncodedKbps = liveTranscoding.audioBitrate;
        tRTCStreamEncoderParam.audioEncodedCodecType = LiveTranscoding.AudioCodecProfileType.getValue(liveTranscoding.audioCodecProfile);
        return tRTCStreamEncoderParam;
    }

    private TRTCCloudDef.TRTCStreamMixingConfig convertTRTCStreamMixingConfig(LiveTranscoding liveTranscoding) {
        TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig = new TRTCCloudDef.TRTCStreamMixingConfig();
        tRTCStreamMixingConfig.backgroundColor = liveTranscoding.getBackgroundColor();
        ArrayList backgroundImageList = liveTranscoding.getBackgroundImageList();
        if (backgroundImageList != null && !backgroundImageList.isEmpty()) {
            tRTCStreamMixingConfig.backgroundImage = ((AgoraImage) backgroundImageList.get(0)).url;
        }
        Iterator it = liveTranscoding.getUsers().iterator();
        while (it.hasNext()) {
            LiveTranscoding.TranscodingUser transcodingUser = (LiveTranscoding.TranscodingUser) it.next();
            TRTCCloudDef.TRTCVideoLayout tRTCVideoLayout = new TRTCCloudDef.TRTCVideoLayout();
            tRTCVideoLayout.x = transcodingUser.x;
            tRTCVideoLayout.y = transcodingUser.y;
            tRTCVideoLayout.width = transcodingUser.width;
            tRTCVideoLayout.height = transcodingUser.height;
            tRTCVideoLayout.zOrder = transcodingUser.zOrder;
            tRTCVideoLayout.fixedVideoUser.userId = String.valueOf(transcodingUser.uid);
            tRTCVideoLayout.fixedVideoStreamType = 0;
            tRTCStreamMixingConfig.videoLayoutList.add(tRTCVideoLayout);
        }
        return tRTCStreamMixingConfig;
    }

    public static TRTCEngineAdapter create(Context context, String str, IRTCEngineHandler iRTCEngineHandler) {
        if (mInstance == null) {
            mInstance = new TRTCEngineAdapter(context, str, iRTCEngineHandler);
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String createRtmpMessage(LiveTranscoding liveTranscoding) {
        RtmpMessageBean rtmpMessageBean = new RtmpMessageBean();
        RtmpMessageBean.CanvasDTO canvasDTO = new RtmpMessageBean.CanvasDTO();
        canvasDTO.setW(Integer.valueOf(liveTranscoding.width));
        canvasDTO.setH(Integer.valueOf(liveTranscoding.height));
        canvasDTO.setBgnd(String.format("#%02X%02X%02X", Integer.valueOf(liveTranscoding.getRed()), Integer.valueOf(liveTranscoding.getGreen()), Integer.valueOf(liveTranscoding.getBlue())));
        rtmpMessageBean.setCanvas(canvasDTO);
        rtmpMessageBean.setVer("20190611");
        if (!TextUtils.isEmpty(liveTranscoding.userConfigExtraInfo)) {
            rtmpMessageBean.setAppData(liveTranscoding.userConfigExtraInfo);
        }
        ArrayList users = liveTranscoding.getUsers();
        if (!users.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = users.iterator();
            while (it.hasNext()) {
                LiveTranscoding.TranscodingUser transcodingUser = (LiveTranscoding.TranscodingUser) it.next();
                RtmpMessageBean.RegionsDTO regionsDTO = new RtmpMessageBean.RegionsDTO();
                regionsDTO.setX(Integer.valueOf(transcodingUser.x));
                regionsDTO.setY(Integer.valueOf(transcodingUser.y));
                regionsDTO.setW(Integer.valueOf(transcodingUser.width));
                regionsDTO.setH(Integer.valueOf(transcodingUser.height));
                regionsDTO.setUid(Integer.valueOf(transcodingUser.uid));
                regionsDTO.setZOrder(Integer.valueOf(transcodingUser.zOrder));
                regionsDTO.setAlpha(Float.valueOf(transcodingUser.alpha));
                if (this.mUserVolumeMap.get(String.valueOf(transcodingUser.uid)) != null) {
                    regionsDTO.setVolume(this.mUserVolumeMap.get(String.valueOf(transcodingUser.uid)));
                }
                arrayList.add(regionsDTO);
            }
            rtmpMessageBean.setRegions(arrayList);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", rtmpMessageBean.getVer());
            jSONObject.put("ts", rtmpMessageBean.getTs());
            jSONObject.put("app_data", rtmpMessageBean.getAppData());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("w", rtmpMessageBean.getCanvas().getW());
            jSONObject2.put("h", rtmpMessageBean.getCanvas().getH());
            jSONObject2.put("bgnd", rtmpMessageBean.getCanvas().getBgnd());
            jSONObject.put("canvas", jSONObject2);
            List<RtmpMessageBean.RegionsDTO> regions = rtmpMessageBean.getRegions();
            if (!regions.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("regions", jSONArray);
                for (RtmpMessageBean.RegionsDTO regionsDTO2 : regions) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONArray.put(jSONObject3);
                    jSONObject3.put("uid", regionsDTO2.getUid());
                    jSONObject3.put("alpha", regionsDTO2.getAlpha().floatValue());
                    jSONObject3.put("zorder", regionsDTO2.getZorder());
                    jSONObject3.put("volume", regionsDTO2.getVolume());
                    jSONObject3.put("x", regionsDTO2.getX());
                    jSONObject3.put("y", regionsDTO2.getY());
                    jSONObject3.put("w", regionsDTO2.getW());
                    jSONObject3.put("h", regionsDTO2.getH());
                }
            }
            apiLog("createRtmpMsg: " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void destroy() {
        TRTCEngineAdapter tRTCEngineAdapter = mInstance;
        if (tRTCEngineAdapter != null) {
            tRTCEngineAdapter.unInit();
        }
        mInstance = null;
    }

    private int getBufferType(IVideoSink iVideoSink) {
        int bufferType = iVideoSink.getBufferType();
        if (bufferType == 1) {
            return 1;
        }
        if (bufferType == 2) {
            return 2;
        }
        if (bufferType == 3) {
            return 3;
        }
        return 0;
    }

    public static String getErrorDescription(int i) {
        if (i != -100013) {
            if (i != -3330) {
                if (i != -3308) {
                    if (i != -3301) {
                        if (i == 0) {
                            return "no error";
                        }
                        if (i != -1328) {
                            if (i != -1327) {
                                if (i != -1309) {
                                    if (i != -1308) {
                                        switch (i) {
                                            case -102016:
                                                return "其他用户正在上行辅路";
                                            case -102015:
                                                return "没有权限上行辅路";
                                            default:
                                                switch (i) {
                                                    case -3336:
                                                        return "停止向腾讯云的直播 CDN 推流信令异常";
                                                    case -3335:
                                                        return "停止向腾讯云的直播 CDN 推流信令超时";
                                                    case -3334:
                                                        return "开始向腾讯云的直播 CDN 推流信令异常";
                                                    case -3333:
                                                        return "开始向腾讯云的直播 CDN 推流信令超时";
                                                    default:
                                                        switch (i) {
                                                            case -3328:
                                                                return "无效参数";
                                                            case -3327:
                                                                return "请求退出连麦超时";
                                                            case -3326:
                                                                return "请求连麦超时";
                                                            default:
                                                                switch (i) {
                                                                    case -3324:
                                                                        return "旁路转推回包异常";
                                                                    case -3323:
                                                                        return "云端混流回包异常";
                                                                    case -3322:
                                                                        return "云端混流请求超时";
                                                                    case -3321:
                                                                        return "旁路转推请求超时";
                                                                    case -3320:
                                                                        return "进房参数 userSig 不正确";
                                                                    case -3319:
                                                                        return "进房参数 userID 不正确";
                                                                    case -3318:
                                                                        return "进房参数 roomId 错误";
                                                                    case -3317:
                                                                        return "进房参数 sdkAppId 错误";
                                                                    case -3316:
                                                                        return "进房参数为空，请检查 enterRoom:appScene: 接口调用是否传入有效的 param";
                                                                    default:
                                                                        switch (i) {
                                                                            case -1323:
                                                                                return "停止扬声器失败";
                                                                            case TXLiteAVCode.ERR_SPEAKER_SET_PARAM_FAIL /* -1322 */:
                                                                                return "扬声器设置参数失败";
                                                                            case -1321:
                                                                                return "打开扬声器失败";
                                                                            case -1320:
                                                                                return "停止麦克风失败";
                                                                            case -1319:
                                                                                return "麦克风正在被占用中";
                                                                            default:
                                                                                switch (i) {
                                                                                    case -1317:
                                                                                        return "麦克风设备未授权";
                                                                                    case -1316:
                                                                                        return "摄像头正在被占用中";
                                                                                    case TXLiteAVCode.ERR_CAMERA_SET_PARAM_FAIL /* -1315 */:
                                                                                        return "摄像头参数设置出错";
                                                                                    case -1314:
                                                                                        return "摄像头设备未授权";
                                                                                    default:
                                                                                        switch (i) {
                                                                                            case -1306:
                                                                                                return "不支持的音频采样率";
                                                                                            case -1305:
                                                                                                return "不支持的视频分辨率";
                                                                                            case -1304:
                                                                                                return "音频帧编码失败";
                                                                                            case -1303:
                                                                                                return "视频帧编码失败";
                                                                                            case -1302:
                                                                                                return "打开麦克风失败";
                                                                                            case -1301:
                                                                                                return "打开摄像头失败";
                                                                                            default:
                                                                                                return "no error";
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                    }
                                    return "开始录屏失败";
                                }
                                return "录屏失败";
                            }
                            return "设置的 pixel format 不支持";
                        }
                        return "设置的 buffer type 不支持";
                    }
                    return "进入房间失败";
                }
                return "请求进房超时，请检查网络";
            }
            return "当前是观众角色，不能请求或断开跨房连麦，需要先 switchRole() 到主播";
        }
        return "服务不可用。请检查：套餐包剩余分钟数是否大于0，腾讯云账号是否欠费";
    }

    public static String getSDKVersion() {
        return TRTCCloud.getSDKVersion();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void ConnectOtherRoom(String str) {
        this.mTRTCCloud.ConnectOtherRoom(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void DisconnectOtherRoom() {
        this.mTRTCCloud.DisconnectOtherRoom();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    @Unsupport
    public void addHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addPublishStreamUrl(String str, boolean z) {
        apiLog("addPublishStreamUrl url: " + str + " transcodingEnabled: " + z);
        TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam = new TRTCCloudDef.TRTCPublishCDNParam();
        tRTCPublishCDNParam.appId = SDKConfig.TX_APPID;
        tRTCPublishCDNParam.bizId = SDKConfig.TX_BIZID;
        tRTCPublishCDNParam.url = str;
        this.mTRTCCloud.stopPublishCDNStream();
        this.mTRTCCloud.startPublishCDNStream(tRTCPublishCDNParam);
        this.mPublishCdnUrl = str;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addVideoWatermark(AgoraImage agoraImage) {
        if (agoraImage == null) {
            apiLogError("addVideoWatermark error watermark is null");
            return -1;
        }
        apiLog("addVideoWatermark url: " + agoraImage.url + " x: " + agoraImage.x + " y: " + agoraImage.y + " width: " + agoraImage.width + " height: " + agoraImage.height);
        if (!checkVideoEnable()) {
            return -1;
        }
        VideoEncoderConfiguration.VideoDimensions videoDimensions = this.mVideoEncoderConfiguration.dimensions;
        int i = videoDimensions.width;
        int i2 = videoDimensions.height;
        Bitmap bitmap = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(agoraImage.url).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            if (httpURLConnection.getResponseCode() == 200) {
                bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
        } catch (IOException e) {
            apiLogError("addVideoWatermark get bitmap error! url: " + agoraImage.url);
            e.printStackTrace();
        }
        float f = i;
        this.mTRTCCloud.setWatermark(bitmap, 0, agoraImage.x / f, agoraImage.y / i2, agoraImage.width / f);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingPlayoutVolume(int i) {
        apiLog("adjustAudioMixingPlayoutVolume " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().setMusicPlayoutVolume(0, i);
        this.mMusicPlayoutVolume = i;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingPublishVolume(int i) {
        apiLog("adjustAudioMixingPublishVolume " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().setMusicPublishVolume(0, i);
        this.mMusicPublishVolume = i;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustAudioMixingVolume(int i) {
        apiLog("adjustAudioMixingVolume " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().setAllMusicVolume(i);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustPlaybackSignalVolume(int i) {
        apiLog("adjustPlaybackSignalVolume " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.setAudioPlayoutVolume(i);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int adjustRecordingSignalVolume(int i) {
        apiLog("adjustRecordingSignalVolume " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().setVoiceCaptureVolume(i);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int clearVideoWatermarks() {
        apiLog("clearVideoWatermarks");
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.setWatermark(null, 0, 0.0f, 0.0f, 0.0f);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int createDataStream(boolean z, boolean z2) {
        this.mDataStreamReliable = z;
        this.mDataStreamOrdered = z2;
        int i = this.mCurSendStreamCnt + 1;
        this.mCurSendStreamCnt = i;
        if (i > 5) {
            this.mTRTCEngineAdapterListener.onError(116);
        }
        return this.mCurSendStreamCnt;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int disableAudio() {
        apiLog("disableAudio");
        this.mEnableAudioFlag = false;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int disableVideo() {
        apiLog("disableVideo");
        this.mEnableVideoFlag = false;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableAudio() {
        apiLog("enableAudio");
        this.mEnableAudioFlag = true;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableAudioVolumeIndication(int i, int i2, boolean z) {
        apiLog("enableAudioVolumeIndication " + i + ", " + i2 + ", " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.enableAudioVolumeEvaluation(i);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableDualStreamMode(boolean z) {
        apiLog("enableDualStreamMode " + z);
        TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
        tRTCVideoEncParam.videoResolution = 56;
        tRTCVideoEncParam.videoResolutionMode = 0;
        tRTCVideoEncParam.videoFps = 20;
        tRTCVideoEncParam.videoBitrate = RoomEvent.ROOM_CURRENT_USER_ONLINE;
        this.mTRTCCloud.enableEncSmallVideoStream(z, tRTCVideoEncParam);
        this.mEnableDualMode = z;
        if (z) {
            if (this.mBigVideoParamSet) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("videoWidth", this.mVideoEncoderConfiguration.dimensions.width / 2);
                    jSONObject2.put("videoHeight", this.mVideoEncoderConfiguration.dimensions.height / 2);
                    jSONObject2.put("videoFps", this.mVideoEncoderConfiguration.frameRate);
                    jSONObject2.put("videoBitrate", this.mVideoEncoderConfiguration.bitrate / 2);
                    jSONObject2.put("streamType", 1);
                    jSONObject.put("api", "setVideoEncodeParamEx");
                    jSONObject.put("params", jSONObject2);
                    this.mTRTCCloud.callExperimentalAPI(jSONObject.toString());
                } catch (JSONException unused) {
                    apiLogError("enableDualStreamMode err :JSONException");
                    return -1;
                }
            } else {
                this.mShouldSetSmallVideo = true;
            }
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableInEarMonitoring(boolean z) {
        apiLog("enableInEarMonitoring " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().enableVoiceEarMonitor(z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableLocalAudio(boolean z) {
        apiLog("enableLocalAudio " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        if (z) {
            this.mTRTCCloud.startLocalAudio(3);
            return 0;
        }
        this.mTRTCCloud.stopLocalAudio();
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableLocalVideo(boolean z) {
        apiLog("enableLocalVideo " + z);
        if (!checkVideoEnable()) {
            return -1;
        }
        if (z) {
            this.mTRTCCloud.startLocalPreview(true, this.mLocalVideoView);
            return 0;
        }
        this.mTRTCCloud.stopLocalPreview();
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableSoundPositionIndication(boolean z) {
        apiLog("enableSoundPositionIndication " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableVideo() {
        apiLog("enableVideo");
        this.mEnableVideoFlag = true;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int enableWebSdkInteroperability(boolean z) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public IAudioEffectManager getAudioEffectManager() {
        return this.mTRTCEffectManager;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingCurrentPosition() {
        if (!checkAudioEnable()) {
            return -1;
        }
        return (int) this.mTRTCCloud.getAudioEffectManager().getMusicCurrentPosInMS(0);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingDuration() {
        if (!checkAudioEnable()) {
            return -1;
        }
        return (int) this.mTRTCCloud.getAudioEffectManager().getMusicDurationInMS(this.mBgmFilePath);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingPlayoutVolume() {
        if (!checkAudioEnable()) {
            return -1;
        }
        return this.mMusicPlayoutVolume;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int getAudioMixingPublishVolume() {
        if (!checkAudioEnable()) {
            return -1;
        }
        return this.mMusicPublishVolume;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public String getCallId() {
        return null;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public float getCameraMaxZoomFactor() {
        return 5.0f;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.mTRTCCloud.isCameraAutoFocusFaceModeSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraExposurePositionSupported() {
        return false;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraFocusSupported() {
        return this.mTRTCCloud.isCameraFocusPositionInPreviewSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraTorchSupported() {
        return this.mTRTCCloud.isCameraTorchSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isCameraZoomSupported() {
        return this.mTRTCCloud.isCameraZoomSupported();
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isSpeakerphoneEnabled() {
        apiLog("isSpeakerphoneEnabled " + this.mSpeakerphoneEnableFlag);
        return this.mSpeakerphoneEnableFlag;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean isTextureEncodeSupported() {
        return true;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannel(String str, String str2, String str3, int i) {
        apiLog("joinChannel " + str + ", " + str2 + ", " + str3 + ", " + i);
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        this.mTRTCParams = tRTCParams;
        tRTCParams.userSig = str;
        tRTCParams.userId = String.valueOf(i);
        TRTCCloudDef.TRTCParams tRTCParams2 = this.mTRTCParams;
        tRTCParams2.sdkAppId = this.mTRTCAppId;
        int i2 = this.mTargetUserRole;
        tRTCParams2.role = i2;
        this.mCurUserRole = i2;
        if (SDKConfig.TX_CHANNELNAME_INT == 0) {
            tRTCParams2.roomId = -1;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("strGroupId", str2);
            } catch (JSONException unused) {
                apiLogError("put channelName error! channelName: " + str2);
            }
            this.mTRTCParams.businessInfo = jSONObject.toString();
        } else {
            tRTCParams2.roomId = Integer.parseInt(str2);
        }
        this.mUid = String.valueOf(i);
        this.mTRTCCloud.enterRoom(this.mTRTCParams, this.mAppScene);
        this.mPublishCdnUrlStartQueue = new LinkedList();
        this.mPublishCdnUrlStopQueue = new LinkedList();
        this.mPublishCdnUrlMap = new HashMap();
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int leaveChannel() {
        apiLog("leaveChannel");
        this.mTRTCCloud.exitRoom();
        this.mUid = "";
        this.mSpeakerphoneEnableFlag = true;
        this.mDataStreamReliable = false;
        this.mDataStreamOrdered = false;
        this.mLocalVideoView = null;
        this.mPushMode = false;
        this.mCurSendStreamCnt = 0;
        this.mEnableAudioFlag = true;
        this.mEnableVideoFlag = true;
        this.mLastSecondSendStreamTime = 0L;
        this.mSendStreamSizeInSecond = 0L;
        this.mEnableExternalVideo = false;
        this.mExternalVideoUseTexture = false;
        this.mRemoteVideoAvailableMap.clear();
        this.mRemoteAudioAvailableMap.clear();
        IVideoSource iVideoSource = this.mVideoSource;
        if (iVideoSource != null) {
            iVideoSource.onStop();
            this.mVideoSource.onDispose();
        }
        this.mIsStartPreview = false;
        this.mEnableExternalAudio = false;
        this.mDefaultMuteAllRemoteVideoStreams = false;
        this.mDefaultMuteAllRemoteAudioStreams = false;
        this.mBigVideoParamSet = false;
        this.mShouldSetSmallVideo = false;
        this.mEnableDualMode = false;
        Deque<String> deque = this.mPublishCdnUrlStartQueue;
        if (deque != null) {
            deque.clear();
        }
        Deque<String> deque2 = this.mPublishCdnUrlStopQueue;
        if (deque2 != null) {
            deque2.clear();
        }
        Map<String, String> map = this.mPublishCdnUrlMap;
        if (map != null) {
            map.clear();
        }
        this.mLiveTranscoding = null;
        this.mUserVolumeMap.clear();
        this.mVideoFrameListener = null;
        this.mTRTCCloud.setLocalVideoProcessListener(2, 3, null);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteAllRemoteAudioStreams(boolean z) {
        apiLog("muteAllRemoteAudioStreams " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.muteAllRemoteAudio(z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteAllRemoteVideoStreams(boolean z) {
        apiLog("muteAllRemoteVideoStreams " + z);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.muteAllRemoteVideoStreams(z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteLocalAudioStream(boolean z) {
        apiLog("muteLocalAudioStream " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.muteLocalAudio(z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteLocalVideoStream(boolean z) {
        apiLog("muteLocalVideoStream " + z);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.muteLocalVideo(z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteRemoteAudioStream(int i, boolean z) {
        apiLog("muteRemoteAudioStream " + i + ", " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.muteRemoteAudio(String.valueOf(i), z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int muteRemoteVideoStream(int i, boolean z) {
        apiLog("muteRemoteVideoStream " + i + ", " + z);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.muteRemoteVideoStream(String.valueOf(i), z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int pauseAudioMixing() {
        apiLog("pauseAudioMixing");
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().pausePlayMusic(0);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    @Unsupport
    public int pullPlaybackAudioFrame(byte[] bArr, int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public boolean pushExternalVideoFrame(AgoraVideoFrame agoraVideoFrame) {
        if (!this.mEnableVideoFlag || !this.mEnableExternalVideo || !this.mPushMode) {
            return false;
        }
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
        tRTCVideoFrame.pixelFormat = convertFrameFormat(agoraVideoFrame.format);
        if (this.mExternalVideoUseTexture) {
            tRTCVideoFrame.bufferType = 3;
        } else {
            tRTCVideoFrame.bufferType = 2;
        }
        tRTCVideoFrame.data = agoraVideoFrame.buf;
        tRTCVideoFrame.width = agoraVideoFrame.stride;
        tRTCVideoFrame.height = agoraVideoFrame.height;
        tRTCVideoFrame.timestamp = agoraVideoFrame.timeStamp;
        tRTCVideoFrame.rotation = agoraVideoFrame.rotation;
        TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
        tRTCVideoFrame.texture = tRTCTexture;
        tRTCTexture.textureId = agoraVideoFrame.textureID;
        tRTCTexture.eglContext10 = agoraVideoFrame.eglContext11;
        tRTCTexture.eglContext14 = agoraVideoFrame.eglContext14;
        this.mTRTCCloud.sendCustomVideoData(tRTCVideoFrame);
        return true;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int registerAudioFrameObserver(IAudioFrameObserver iAudioFrameObserver) {
        apiLog("registerAudioFrameObserver " + iAudioFrameObserver);
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    @Unsupport
    public void removeHandler(IRtcEngineEventHandler iRtcEngineEventHandler) {
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int removePublishStreamUrl(String str) {
        apiLog("removePublishStreamUrl url: " + str);
        this.mTRTCCloud.stopPublishCDNStream();
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int resumeAudioMixing() {
        apiLog("resumeAudioMixing");
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().resumePlayMusic(0);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void selectMotionTmpl(String str) {
        this.mTRTCCloud.selectMotionTmpl(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int sendStreamMessage(int i, byte[] bArr) {
        apiLog("sendStreamMessage cmdID: " + i + " dataSize: " + bArr.length);
        this.mSendStreamSizeInSecond = this.mSendStreamSizeInSecond + ((long) bArr.length);
        if (0 == this.mLastSecondSendStreamTime) {
            this.mLastSecondSendStreamTime = System.currentTimeMillis();
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.mLastSecondSendStreamTime;
            if (currentTimeMillis > 1000 && (this.mSendStreamSizeInSecond * 1000) / currentTimeMillis > 8) {
                this.mTRTCEngineAdapterListener.onError(115);
                this.mLastSecondSendStreamTime = System.currentTimeMillis();
                this.mSendStreamSizeInSecond = 0L;
            }
        }
        if (bArr.length > 1024) {
            this.mTRTCEngineAdapterListener.onError(114);
            return -1;
        }
        this.mTRTCCloud.sendCustomCmdMsg(i, bArr, this.mDataStreamReliable, this.mDataStreamOrdered);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioMixingPitch(int i) {
        apiLog("setAudioMixingPitch " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().setMusicPitch(0, i / 12.0f);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioMixingPosition(int i) {
        apiLog("setAudioMixingPosition " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().seekMusicToPosInMS(0, i);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setAudioProfile(int i, int i2) {
        apiLog("setAudioProfile " + i + ", " + i2);
        if (!checkAudioEnable()) {
            return -1;
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 || i == 4 || i == 5) {
                        this.mTRTCCloud.setAudioQuality(3);
                        return 0;
                    }
                    return 0;
                }
            } else {
                this.mTRTCCloud.setAudioQuality(1);
                return 0;
            }
        }
        this.mTRTCCloud.setAudioQuality(2);
        this.mTRTCCloud.getDeviceManager().setSystemVolumeType(TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setBeautyEffectOptions(boolean z, BeautyOptions beautyOptions) {
        int i;
        if (beautyOptions == null) {
            apiLogError("setBeautyEffectOptions error options is null");
            return -1;
        }
        apiLog("setBeautyEffectOptions " + z + " lighteningContrastLevel: " + beautyOptions.lighteningContrastLevel + " lighteningLevel: " + beautyOptions.lighteningLevel + " rednessLevel: " + beautyOptions.rednessLevel + " smoothnessLevel: " + beautyOptions.smoothnessLevel);
        if (!checkVideoEnable()) {
            return -1;
        }
        if (beautyOptions.lighteningContrastLevel == 1) {
            i = 1;
        } else {
            i = 0;
        }
        if (z) {
            int round = (int) Math.round(beautyOptions.smoothnessLevel * 0.9d);
            int round2 = (int) Math.round(beautyOptions.lighteningLevel * 0.9d);
            int round3 = (int) Math.round(beautyOptions.rednessLevel * 0.9d);
            if (round > 9) {
                round = 9;
            }
            if (round2 > 9) {
                round2 = 9;
            }
            if (round3 > 9) {
                round3 = 9;
            }
            this.mTRTCCloud.setBeautyStyle(i, round, round2, round3);
        } else {
            this.mTRTCCloud.setBeautyStyle(1, 0, 0, 0);
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraAutoFocusFaceModeEnabled(boolean z) {
        apiLog("setCameraAutoFocusFaceModeEnabled " + z);
        if (!checkVideoEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraCapturerConfiguration(CameraCapturerConfiguration cameraCapturerConfiguration) {
        boolean z;
        if (cameraCapturerConfiguration == null) {
            apiLogError("setCameraCapturerConfiguration error config is null");
            return -1;
        }
        apiLog("setCameraCapturerConfiguration cameraDirection=" + cameraCapturerConfiguration.cameraDirection);
        if (cameraCapturerConfiguration.cameraDirection == CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_FRONT) {
            z = true;
        } else {
            z = false;
        }
        this.mUseFontCamera = z;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraExposurePosition(float f, float f2) {
        apiLog("setCameraExposurePosition " + f + ", " + f2);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.setFocusPosition((int) f, (int) f2);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraFocusPositionInPreview(float f, float f2) {
        apiLog("setCameraFocusPositionInPreview " + f + ", " + f2);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.setFocusPosition((int) f, (int) f2);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraTorchOn(boolean z) {
        apiLog("setCameraTorchOn " + z);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.enableTorch(z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setCameraZoomFactor(float f) {
        apiLog("setCameraZoomFactor " + f);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.setZoom((int) f);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setChannelProfile(int i) {
        apiLog("setChannelProfile " + i);
        if (i == 0) {
            this.mAppScene = 0;
        } else if (i == 1) {
            this.mAppScene = 1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setChinLevel(int i) {
        this.mTRTCCloud.setChinLevel(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setClientRole(int i) {
        apiLog("setClientRole " + i);
        if (i == 1) {
            this.mTargetUserRole = 20;
        } else if (i == 2) {
            this.mTargetUserRole = 21;
        }
        this.mTRTCCloud.switchRole(this.mTargetUserRole);
        if (i != 1) {
            return 0;
        }
        this.mTRTCCloud.startLocalAudio(2);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setDebugViewMargin(int i, TRTCCloud.TRTCViewMargin tRTCViewMargin) {
        this.mTRTCCloud.setDebugViewMargin(String.valueOf(i), tRTCViewMargin);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultAudioRoutetoSpeakerphone(boolean z) {
        apiLog("setDefaultAudioRoutetoSpeakerphone " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        if (z) {
            this.mTRTCCloud.setAudioRoute(0);
        } else {
            this.mTRTCCloud.setAudioRoute(1);
        }
        this.mSpeakerphoneEnableFlag = z;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        apiLog("setDefaultMuteAllRemoteAudioStreams " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mDefaultMuteAllRemoteAudioStreams = z;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        apiLog("setDefaultMuteAllRemoteVideoStreams " + z);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mDefaultMuteAllRemoteVideoStreams = z;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void setEnableAiNoiseReduction(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (z) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("key", "Liteav.Audio.common.smart.3a.strategy.flag");
                jSONObject3.put("default", MessageService.MSG_DB_READY_REPORT);
                jSONObject3.put("value", AgooConstants.REPORT_ENCRYPT_FAIL);
                jSONArray.put(jSONObject3);
                jSONObject2.put("configs", jSONArray);
                jSONObject.put("api", "setPrivateConfig");
                jSONObject.put("params", jSONObject2);
                this.mTRTCCloud.callExperimentalAPI(jSONObject.toString());
            } else {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("key", "Liteav.Audio.common.smart.3a.strategy.flag");
                jSONObject4.put("default", MessageService.MSG_DB_READY_REPORT);
                jSONObject4.put("value", "18");
                jSONArray.put(jSONObject4);
                jSONObject2.put("configs", jSONArray);
                jSONObject.put("api", "setPrivateConfig");
                jSONObject.put("params", jSONObject2);
                this.mTRTCCloud.callExperimentalAPI(jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setEnableSpeakerphone(boolean z) {
        apiLog("setEnableSpeakerphone " + z);
        if (!checkAudioEnable()) {
            return -1;
        }
        if (z) {
            this.mTRTCCloud.setAudioRoute(0);
        } else {
            this.mTRTCCloud.setAudioRoute(1);
        }
        this.mSpeakerphoneEnableFlag = z;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    @Unsupport
    public int setExternalAudioSink(boolean z, int i, int i2) {
        apiLog("setExternalAudioSink " + z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setExternalAudioSource(boolean z, int i, int i2) {
        apiLog("setExternalAudioSource " + z + " sampleRate: " + i + " channels: " + i2);
        if (!checkAudioEnable()) {
            return -1;
        }
        if (i != 48000) {
            apiLogError("setExternalAudioSource unsupport sampleRate: " + i);
            return -1;
        }
        this.mExternalAudioSampleRate = i;
        this.mExternalAudioChannels = i2;
        this.mTRTCCloud.enableCustomAudioCapture(z);
        this.mEnableExternalAudio = z;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public void setExternalVideoSource(boolean z, boolean z2, boolean z3) {
        apiLog(String.format("setExternalVideoSource enable=%b, useTexture=%b, pushMode=%b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
        this.mEnableExternalVideo = z;
        this.mExternalVideoUseTexture = z2;
        this.mPushMode = z3;
        this.mTRTCCloud.enableCustomVideoCapture(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setEyeScaleLevel(int i) {
        this.mTRTCCloud.setEyeScaleLevel(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFaceShortLevel(int i) {
        this.mTRTCCloud.setFaceShortLevel(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFaceSlimLevel(int i) {
        this.mTRTCCloud.setFaceSlimLevel(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFaceVLevel(int i) {
        this.mTRTCCloud.setFaceVLevel(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFilter(Bitmap bitmap) {
        this.mTRTCCloud.setFilter(bitmap);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setFilterConcentration(float f) {
        this.mTRTCCloud.setFilterConcentration(f);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setGSensorMode(int i) {
        this.mTRTCCloud.setGSensorMode(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public boolean setGreenScreenFile(String str) {
        return this.mTRTCCloud.setGreenScreenFile(str);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setHighQualityAudioParameters(boolean z, boolean z2, boolean z3) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setInEarMonitoringVolume(int i) {
        apiLog("setInEarMonitoringVolume " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.getAudioEffectManager().setVoiceEarMonitorVolume(i);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLiveTranscoding(LiveTranscoding liveTranscoding) {
        apiLog("setLiveTranscoding " + liveTranscoding);
        this.mLiveTranscoding = liveTranscoding;
        if (liveTranscoding == null) {
            this.mTRTCCloud.setMixTranscodingConfig(null);
            return 0;
        }
        TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig = new TRTCCloudDef.TRTCTranscodingConfig();
        ArrayList<TRTCCloudDef.TRTCMixUser> arrayList = new ArrayList<>();
        tRTCTranscodingConfig.mixUsers = new ArrayList<>();
        tRTCTranscodingConfig.appId = SDKConfig.TX_APPID;
        tRTCTranscodingConfig.bizId = SDKConfig.TX_BIZID;
        tRTCTranscodingConfig.videoWidth = liveTranscoding.width;
        tRTCTranscodingConfig.videoHeight = liveTranscoding.height;
        tRTCTranscodingConfig.videoBitrate = liveTranscoding.videoBitrate;
        tRTCTranscodingConfig.videoFramerate = liveTranscoding.videoFramerate;
        int floor = (int) Math.floor(liveTranscoding.videoGop / r3);
        tRTCTranscodingConfig.videoGOP = floor;
        if (floor < 1) {
            tRTCTranscodingConfig.videoGOP = 1;
        }
        if (tRTCTranscodingConfig.videoGOP > 10) {
            tRTCTranscodingConfig.videoGOP = 10;
        }
        arrayList.clear();
        Iterator it = liveTranscoding.getUsers().iterator();
        while (it.hasNext()) {
            LiveTranscoding.TranscodingUser transcodingUser = (LiveTranscoding.TranscodingUser) it.next();
            TRTCCloudDef.TRTCMixUser tRTCMixUser = new TRTCCloudDef.TRTCMixUser();
            tRTCMixUser.userId = String.valueOf(transcodingUser.uid);
            tRTCMixUser.zOrder = transcodingUser.zOrder;
            tRTCMixUser.x = transcodingUser.x;
            tRTCMixUser.y = transcodingUser.y;
            tRTCMixUser.width = transcodingUser.width;
            tRTCMixUser.height = transcodingUser.height;
            arrayList.add(tRTCMixUser);
        }
        tRTCTranscodingConfig.mixUsers = arrayList;
        tRTCTranscodingConfig.audioSampleRate = LiveTranscoding.AudioSampleRateType.getValue(liveTranscoding.audioSampleRate);
        tRTCTranscodingConfig.audioBitrate = liveTranscoding.audioBitrate;
        tRTCTranscodingConfig.audioChannels = liveTranscoding.audioChannels;
        this.mTRTCCloud.setMixTranscodingConfig(tRTCTranscodingConfig);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalRenderMode(int i) {
        setLocalRenderMode(i, 0);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVideoMirrorMode(int i) {
        apiLog("setLocalVideoMirrorMode " + i);
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.setLocalViewMirror(i);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVideoRenderer(final IVideoSink iVideoSink) {
        apiLog("setLocalVideoRenderer " + iVideoSink);
        if (!checkVideoEnable()) {
            return -1;
        }
        if (iVideoSink == null) {
            this.mTRTCCloud.setLocalVideoRenderListener(1, 1, null);
            return 0;
        }
        apiLog("setLocalVideoRenderer pixelFormat: " + iVideoSink.getPixelFormat() + " bufferType: " + iVideoSink.getBufferType());
        this.mTRTCCloud.setLocalVideoRenderListener(convertFrameFormat(iVideoSink.getPixelFormat()), getBufferType(iVideoSink), new TRTCCloudListener.TRTCVideoRenderListener() { // from class: com.qiahao.nextvideo.agoraadapter.TRTCEngineAdapter.4
            @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener
            public void onRenderVideoFrame(String str, int i, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
                int i2 = tRTCVideoFrame.bufferType;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            iVideoSink.consumeTextureFrame(tRTCVideoFrame.texture.textureId, tRTCVideoFrame.pixelFormat, tRTCVideoFrame.width, tRTCVideoFrame.height, tRTCVideoFrame.rotation, tRTCVideoFrame.timestamp, (float[]) null);
                            return;
                        }
                        return;
                    }
                    iVideoSink.consumeByteArrayFrame(tRTCVideoFrame.data, tRTCVideoFrame.pixelFormat, tRTCVideoFrame.width, tRTCVideoFrame.height, tRTCVideoFrame.rotation, tRTCVideoFrame.timestamp);
                    return;
                }
                iVideoSink.consumeByteBufferFrame(tRTCVideoFrame.buffer, tRTCVideoFrame.pixelFormat, tRTCVideoFrame.width, tRTCVideoFrame.height, tRTCVideoFrame.rotation, tRTCVideoFrame.timestamp);
            }
        });
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setLocalViewRotation(int i) {
        this.mTRTCCloud.setLocalViewRotation(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceChanger(int i) {
        apiLog("setLocalVoiceChanger " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        TXAudioEffectManager.TXVoiceChangerType tXVoiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0;
        switch (i) {
            case 1:
                tXVoiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1;
                break;
            case 2:
                tXVoiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2;
                break;
            case 3:
                tXVoiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3;
                break;
            case 4:
                tXVoiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4;
                break;
            case 5:
                tXVoiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5;
                break;
            case 6:
                tXVoiceChangerType = TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6;
                break;
        }
        this.mTRTCCloud.getAudioEffectManager().setVoiceChangerType(tXVoiceChangerType);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceEqualization(int i, int i2) {
        apiLog("setLocalVoiceEqualization " + i + ", " + i2);
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoicePitch(double d) {
        apiLog("setLocalVoicePitch " + d);
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceReverb(int i, int i2) {
        apiLog("setLocalVoiceReverb " + i + ", " + i2);
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalVoiceReverbPreset(int i) {
        apiLog("setLocalVoiceReverbPreset " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        TXAudioEffectManager.TXVoiceReverbType tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
        switch (i) {
            case 1:
                tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1;
                break;
            case 2:
                tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2;
                break;
            case 3:
                tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3;
                break;
            case 4:
                tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4;
                break;
            case 5:
                tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5;
                break;
            case 6:
                tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6;
                break;
            case 7:
                tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7;
                break;
        }
        this.mTRTCCloud.getAudioEffectManager().setVoiceReverbType(tXVoiceReverbType);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFile(String str) {
        apiLog("setLogFile " + str);
        TRTCCloud.setLogDirPath(str);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFileSize(int i) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLogFilter(int i) {
        int i2;
        apiLog("setLogFilter " + i);
        if (i != 0) {
            if (i != 8) {
                if (i != 12) {
                    i2 = 1;
                    if (i != 2063) {
                        if (i != 14) {
                            if (i == 15) {
                                i2 = 2;
                            }
                        } else {
                            i2 = 3;
                        }
                    }
                } else {
                    i2 = 4;
                }
            } else {
                i2 = 5;
            }
        } else {
            i2 = 6;
        }
        TRTCCloud.setLogLevel(i2);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        this.mTRTCCloud.setMixTranscodingConfig(tRTCTranscodingConfig);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setMixedAudioFrameParameters(int i, int i2) {
        apiLog("setMixedAudioFrameParameters");
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setMotionMute(boolean z) {
        this.mTRTCCloud.setMotionMute(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.mTRTCCloud.setNetworkQosParam(tRTCNetworkQosParam);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setNoseSlimLevel(int i) {
        this.mTRTCCloud.setNoseSlimLevel(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setPlaybackAudioFrameParameters(int i, int i2, int i3, int i4) {
        apiLog("setPlaybackAudioFrameParameters");
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4) {
        apiLog("setRecordingAudioFrameParameters");
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteDefaultVideoStreamType(int i) {
        apiLog("setRemoteDefaultVideoStreamType streamType: " + i);
        this.mTRTCCloud.setPriorRemoteVideoStreamType(i);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteRenderMode(int i, int i2) {
        setRemoteRenderMode(i, i2, 0);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setRemoteSubStreamViewFillMode(int i, int i2) {
        this.mTRTCCloud.setRemoteSubStreamViewFillMode(String.valueOf(i), i2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVideoRenderer(int i, final IVideoSink iVideoSink) {
        apiLog("setRemoteVideoRenderer " + i + ", " + iVideoSink);
        if (!checkVideoEnable()) {
            return -1;
        }
        if (iVideoSink == null) {
            this.mTRTCCloud.setRemoteVideoRenderListener(String.valueOf(i), 1, 1, null);
            return 0;
        }
        apiLog("setRemoteVideoRenderer uid: " + i + " pixelFormat: " + iVideoSink.getPixelFormat() + " bufferType: " + iVideoSink.getBufferType());
        this.mTRTCCloud.setRemoteVideoRenderListener(String.valueOf(i), convertFrameFormat(iVideoSink.getPixelFormat()), getBufferType(iVideoSink), new TRTCCloudListener.TRTCVideoRenderListener() { // from class: com.qiahao.nextvideo.agoraadapter.TRTCEngineAdapter.5
            @Override // com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener
            public void onRenderVideoFrame(String str, int i2, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
                try {
                    int bufferType = iVideoSink.getBufferType();
                    if (bufferType != 1) {
                        if (bufferType != 2) {
                            if (bufferType == 3) {
                                iVideoSink.consumeTextureFrame(tRTCVideoFrame.texture.textureId, tRTCVideoFrame.pixelFormat, tRTCVideoFrame.width, tRTCVideoFrame.height, tRTCVideoFrame.rotation, tRTCVideoFrame.timestamp, (float[]) null);
                                return;
                            }
                            return;
                        }
                        iVideoSink.consumeByteArrayFrame(tRTCVideoFrame.data, tRTCVideoFrame.pixelFormat, tRTCVideoFrame.width, tRTCVideoFrame.height, tRTCVideoFrame.rotation, tRTCVideoFrame.timestamp);
                        return;
                    }
                    iVideoSink.consumeByteBufferFrame(tRTCVideoFrame.buffer, tRTCVideoFrame.pixelFormat, tRTCVideoFrame.width, tRTCVideoFrame.height, tRTCVideoFrame.rotation, tRTCVideoFrame.timestamp);
                } catch (NumberFormatException unused) {
                    TRTCEngineAdapter.this.apiLogError("uid is not Integer type uid:" + str);
                }
            }
        });
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVideoStreamType(int i, int i2) {
        apiLog("setRemoteVideoStreamType uid: " + i + " streamType: " + i2);
        this.mTRTCCloud.setRemoteVideoStreamType(String.valueOf(i), i2);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteVoicePosition(int i, double d, double d2) {
        apiLog("setRemoteVoicePosition " + i + ", " + d + ", " + d2);
        if (!checkAudioEnable()) {
            return -1;
        }
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoEncoderConfiguration(VideoEncoderConfiguration videoEncoderConfiguration) {
        VideoEncoderConfiguration.VideoDimensions videoDimensions;
        int i;
        int i2;
        VideoEncoderConfiguration.VideoDimensions videoDimensions2;
        int i3;
        int i4;
        if (videoEncoderConfiguration == null) {
            apiLogError("setVideoEncoderConfiguration error config is null");
            return -1;
        }
        apiLog("setVideoEncoderConfiguration width: " + videoEncoderConfiguration.dimensions.width + " height: " + videoEncoderConfiguration.dimensions.height + " bitrate: " + videoEncoderConfiguration.bitrate + " frameRate: " + videoEncoderConfiguration.frameRate + " orientationMode: " + videoEncoderConfiguration.orientationMode);
        if (!checkVideoEnable()) {
            return -1;
        }
        VideoEncoderConfiguration.VideoDimensions videoDimensions3 = videoEncoderConfiguration.dimensions;
        int i5 = videoDimensions3.width;
        int i6 = videoDimensions3.height;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        int i7 = videoEncoderConfiguration.bitrate;
        if (i7 == 0) {
            i7 = this.mLastVideoBitrate;
        }
        if (i7 != 0) {
            this.mLastVideoBitrate = i7;
        }
        VideoEncoderConfiguration.ORIENTATION_MODE orientation_mode = videoEncoderConfiguration.orientationMode;
        if (orientation_mode == VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_FIXED_PORTRAIT && (i3 = (videoDimensions2 = videoEncoderConfiguration.dimensions).width) > (i4 = videoDimensions2.height)) {
            i5 = i4;
            i6 = i3;
        }
        if (orientation_mode == VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_FIXED_LANDSCAPE && (i = (videoDimensions = videoEncoderConfiguration.dimensions).width) < (i2 = videoDimensions.height)) {
            i5 = i2;
            i6 = i;
        }
        try {
            jSONObject2.put("videoWidth", i5);
            jSONObject2.put("videoHeight", i6);
            jSONObject2.put("videoFps", videoEncoderConfiguration.frameRate);
            jSONObject2.put("videoBitrate", i7);
            jSONObject2.put("streamType", 0);
            jSONObject.put("api", "setVideoEncodeParamEx");
            jSONObject.put("params", jSONObject2);
            VideoEncoderConfiguration videoEncoderConfiguration2 = this.mVideoEncoderConfiguration;
            videoEncoderConfiguration2.orientationMode = videoEncoderConfiguration.orientationMode;
            VideoEncoderConfiguration.VideoDimensions videoDimensions4 = videoEncoderConfiguration2.dimensions;
            videoDimensions4.width = i5;
            videoDimensions4.height = i6;
            videoEncoderConfiguration2.frameRate = videoEncoderConfiguration.frameRate;
            videoEncoderConfiguration2.bitrate = videoEncoderConfiguration.bitrate;
            this.mTRTCCloud.callExperimentalAPI(jSONObject.toString());
            this.mBigVideoParamSet = true;
            if (this.mShouldSetSmallVideo) {
                enableDualStreamMode(this.mEnableDualMode);
            }
            return 0;
        } catch (JSONException unused) {
            apiLogError("setVideoEncoderConfiguration err :JSONException");
            return -1;
        }
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void setVideoEncoderMirror(boolean z) {
        this.mTRTCCloud.setVideoEncoderMirror(z);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoProfile(int i, boolean z) {
        apiLog("setVideoProfile " + i + ", " + z);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoQualityParameters(boolean z) {
        apiLog("setVideoQualityParameters " + z);
        if (!checkVideoEnable()) {
            return -1;
        }
        TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
        if (z) {
            tRTCNetworkQosParam.preference = 1;
        } else {
            tRTCNetworkQosParam.preference = 2;
        }
        tRTCNetworkQosParam.controlMode = 1;
        this.mTRTCCloud.setNetworkQosParam(tRTCNetworkQosParam);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoSource(IVideoSource iVideoSource) {
        apiLog("setVideoSource " + iVideoSource);
        this.mVideoSource = iVideoSource;
        if (iVideoSource != null) {
            this.mTRTCCloud.enableCustomVideoCapture(true);
            this.mVideoSource.onInitialize(new TRTCVideoFrameConsumer());
            this.mVideoSource.onStart();
            return 0;
        }
        return -1;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setupLocalVideo(VideoCanvas videoCanvas) {
        apiLog("setupLocalVideo " + videoCanvas);
        if (!checkVideoEnable()) {
            return -1;
        }
        if (videoCanvas == null) {
            return 0;
        }
        View view = videoCanvas.view;
        if (view == null) {
            apiLogError("setupLocalVideo local view is null!");
            this.mTRTCEngineAdapterListener.onError(8);
            return -1;
        }
        if (!(view instanceof SurfaceView)) {
            apiLogError("setupLocalVideo local view is not SurfaceView!");
            return -1;
        }
        this.mLocalVideoView = new TXCloudVideoView((SurfaceView) videoCanvas.view);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setupRemoteVideo(VideoCanvas videoCanvas) {
        apiLog("setupRemoteVideo " + videoCanvas);
        if (!checkVideoEnable()) {
            return -1;
        }
        if (videoCanvas == null) {
            this.mTRTCCloud.stopAllRemoteView();
            return 0;
        }
        View view = videoCanvas.view;
        if (view == null) {
            apiLogError("setupRemoteVideo remote view is null!");
            return -1;
        }
        if (!(view instanceof SurfaceView)) {
            apiLogError("setupRemoteVideo remote view is not SurfaceView!");
            return -1;
        }
        this.mTRTCCloud.startRemoteView(String.valueOf(videoCanvas.uid), new TXCloudVideoView((SurfaceView) videoCanvas.view));
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void showDebugView(int i) {
        this.mTRTCCloud.showDebugView(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioMixing(String str, boolean z, boolean z2, int i) {
        startAudioMixing(str, z, z2, i, 0);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioRecording(String str, int i) {
        apiLog("startAudioRecording " + str + ", " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams = new TRTCCloudDef.TRTCAudioRecordingParams();
        tRTCAudioRecordingParams.filePath = str;
        this.mTRTCCloud.startAudioRecording(tRTCAudioRecordingParams);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void startCdnPlayerWithUrl(String str, TXCloudVideoView tXCloudVideoView) {
        apiLog("startCdnPlayerWithUrl url: " + str + " view: " + tXCloudVideoView);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        apiLog("startChannelMediaRelay configuration: " + channelMediaRelayConfiguration);
        if (channelMediaRelayConfiguration == null) {
            apiLogError("startChannelMediaRelay configuration is null.");
            return -1;
        }
        Map destChannelMediaInfos = channelMediaRelayConfiguration.getDestChannelMediaInfos();
        if (destChannelMediaInfos != null && !destChannelMediaInfos.isEmpty()) {
            if (this.mCurUserRole == 21) {
                apiLogError("startChannelMediaRelay role must be broadcaster.");
                return -1;
            }
            Set entrySet = destChannelMediaInfos.entrySet();
            try {
                JSONObject jSONObject = new JSONObject();
                Iterator it = entrySet.iterator();
                while (it.hasNext()) {
                    ChannelMediaInfo channelMediaInfo = (ChannelMediaInfo) ((Map.Entry) it.next()).getValue();
                    if (SDKConfig.TX_CHANNELNAME_INT == 0) {
                        jSONObject.put("strRoomId", channelMediaInfo.channelName);
                    } else {
                        jSONObject.put(TUIConstants.TUILive.ROOM_ID, Long.parseLong(channelMediaInfo.channelName));
                    }
                    jSONObject.put(TUIConstants.TUILive.USER_ID, String.valueOf(channelMediaInfo.uid));
                    this.mTRTCCloud.ConnectOtherRoom(jSONObject.toString());
                }
                return 0;
            } catch (Exception e) {
                apiLogError("startChannelMediaRelay error: " + e);
                e.printStackTrace();
                return 0;
            }
        }
        apiLogError("startChannelMediaRelay getDestChannelMediaInfos is null or empty.");
        return -1;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startDumpVideoReceiveTrack(int i, String str) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startPreview() {
        apiLog("startPreview");
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.startLocalPreview(this.mUseFontCamera, this.mLocalVideoView);
        this.mIsStartPreview = true;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void startRemoteSubStreamView(int i, TXCloudVideoView tXCloudVideoView) {
        this.mTRTCCloud.startRemoteSubStreamView(String.valueOf(i), tXCloudVideoView);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startRtmpStreamWithTranscoding(String str, LiveTranscoding liveTranscoding) {
        if (TextUtils.isEmpty(str)) {
            apiLog("startRtmpStreamWithTranscoding url is empty.");
            return -2;
        }
        if (liveTranscoding == null) {
            apiLog("startRtmpStreamWithTranscoding transcoding is null.");
            return -1;
        }
        apiLog("startRtmpStreamWithTranscoding url: " + str + ", transcoding: " + liveTranscoding);
        if (this.mPublishCdnUrlStartQueue == null) {
            apiLog("startRtmpStreamWithTranscoding mPublishCdnUrlStartQueue is null.");
            return -1;
        }
        synchronized (this.mPublishCdnLock) {
            this.mPublishCdnUrlStartQueue.push(str);
        }
        this.mLiveTranscoding = liveTranscoding;
        this.mTRTCCloud.startPublishMediaStream(convertTRTCPublishTarget(str), convertTRTCStreamEncoderParam(liveTranscoding), convertTRTCStreamMixingConfig(liveTranscoding));
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopAudioMixing() {
        apiLog("stopAudioMixing");
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mBgmFilePath = "";
        this.mTRTCCloud.getAudioEffectManager().stopPlayMusic(0);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopAudioRecording() {
        apiLog("stopAudioRecording");
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mTRTCCloud.stopAudioRecording();
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void stopCdnPlayer() {
        apiLog("stopCdnPlayer");
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopChannelMediaRelay() {
        apiLog("stopChannelMediaRelay");
        this.mTRTCCloud.DisconnectOtherRoom();
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopDumpVideoReceiveTrack() {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopPreview() {
        apiLog("stopPreview");
        if (!checkVideoEnable()) {
            return -1;
        }
        this.mTRTCCloud.stopLocalPreview();
        this.mIsStartPreview = false;
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.IRTCEngine
    public void stopRemoteSubStreamView(int i) {
        this.mTRTCCloud.stopRemoteSubStreamView(String.valueOf(i));
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int stopRtmpStream(String str) {
        if (TextUtils.isEmpty(str)) {
            apiLog("stopRtmpStream url is empty.");
            return -2;
        }
        apiLog("stopRtmpStream url: " + str);
        if (this.mPublishCdnUrlStopQueue == null) {
            apiLog("startRtmpStreamWithTranscoding mPublishCdnUrlStopQueue is null.");
            return -1;
        }
        synchronized (this.mPublishCdnLock) {
            try {
                String str2 = this.mPublishCdnUrlMap.get(str);
                if (str2 == null) {
                    apiLog("stopRtmpStream not found: " + str);
                    return -1;
                }
                this.mPublishCdnUrlStopQueue.push(str);
                if (!str2.isEmpty()) {
                    this.mTRTCCloud.stopPublishMediaStream(str2);
                }
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchCamera() {
        apiLog("switchCamera");
        if (!checkVideoEnable() && !this.mIsStartPreview) {
            apiLogError("switchCamera error enableVideoFlag:" + this.mEnableVideoFlag + " isStartPreview:" + this.mIsStartPreview);
        }
        this.mTRTCCloud.switchCamera();
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchChannel(String str, String str2) {
        apiLog("switchChannel " + str + ", " + str2);
        String str3 = this.mUid;
        leaveChannel();
        joinChannel(str, str2, null, Integer.valueOf(str3).intValue());
        return 0;
    }

    public void unInit() {
        this.mTRTCEffectManager.destroy();
        this.mTRTCCloud.setListener(null);
        TRTCCloud.destroySharedInstance();
        this.mTRTCEffectManager = null;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int updateRtmpTranscoding(LiveTranscoding liveTranscoding) {
        if (liveTranscoding == null) {
            apiLog("updateRtmpTranscoding transcoding is null.");
            return -1;
        }
        apiLog("updateRtmpTranscoding transcoding: " + liveTranscoding);
        Map<String, String> map = this.mPublishCdnUrlMap;
        if (map != null && !map.isEmpty()) {
            this.mLiveTranscoding = liveTranscoding;
            synchronized (this.mPublishCdnLock) {
                try {
                    for (Map.Entry<String, String> entry : this.mPublishCdnUrlMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(value)) {
                            this.mTRTCCloud.updatePublishMediaStream(value, convertTRTCPublishTarget(key), convertTRTCStreamEncoderParam(liveTranscoding), convertTRTCStreamMixingConfig(liveTranscoding));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return 0;
        }
        apiLog("startRtmpStreamWithTranscoding mPublishCdnUrlMap is null or empty.");
        return -1;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setLocalRenderMode(int i, int i2) {
        apiLog("setLocalRenderMode, renderMode= " + i + ", mirrorMode= " + i2);
        if (!checkVideoEnable()) {
            return -1;
        }
        TRTCCloudDef.TRTCRenderParams tRTCRenderParams = new TRTCCloudDef.TRTCRenderParams();
        if (i == 2) {
            tRTCRenderParams.fillMode = 1;
        } else {
            tRTCRenderParams.fillMode = 0;
        }
        if (i2 == 0) {
            tRTCRenderParams.mirrorType = 0;
        } else if (i2 != 1) {
            tRTCRenderParams.mirrorType = 2;
        } else {
            tRTCRenderParams.mirrorType = 1;
        }
        this.mTRTCCloud.setLocalRenderParams(tRTCRenderParams);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setRemoteRenderMode(int i, int i2, int i3) {
        apiLog("setRemoteRenderMode " + i + ", renderMode=" + i2 + ", mirrorMode=" + i3);
        if (!checkVideoEnable()) {
            return -1;
        }
        TRTCCloudDef.TRTCRenderParams tRTCRenderParams = new TRTCCloudDef.TRTCRenderParams();
        if (i2 == 2) {
            tRTCRenderParams.fillMode = 1;
        } else {
            tRTCRenderParams.fillMode = 0;
        }
        if (i3 == 0) {
            tRTCRenderParams.mirrorType = 0;
        } else if (i3 != 1) {
            tRTCRenderParams.mirrorType = 2;
        } else {
            tRTCRenderParams.mirrorType = 1;
        }
        this.mTRTCCloud.setRemoteRenderParams(String.valueOf(i), 0, tRTCRenderParams);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setVideoProfile(int i, int i2, int i3, int i4) {
        apiLog("setVideoProfile width: " + i + " height: " + i2 + " frameRate: " + i3 + " bitrate: " + i4);
        if (!checkVideoEnable()) {
            return -1;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("videoWidth", i);
            jSONObject2.put("videoHeight", i2);
            jSONObject2.put("videoFps", i3);
            jSONObject2.put("videoBitrate", i4);
            jSONObject2.put("streamType", 0);
            jSONObject.put("api", "setVideoEncodeParamEx");
            jSONObject.put("params", jSONObject2);
            VideoEncoderConfiguration videoEncoderConfiguration = this.mVideoEncoderConfiguration;
            videoEncoderConfiguration.orientationMode = VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_ADAPTIVE;
            VideoEncoderConfiguration.VideoDimensions videoDimensions = videoEncoderConfiguration.dimensions;
            videoDimensions.width = i;
            videoDimensions.height = i2;
            videoEncoderConfiguration.frameRate = i3;
            videoEncoderConfiguration.bitrate = i4;
            this.mTRTCCloud.callExperimentalAPI(jSONObject.toString());
            this.mBigVideoParamSet = true;
            return 0;
        } catch (JSONException unused) {
            apiLogError("setVideoProfile err :JSONException");
            return -1;
        }
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioMixing(String str, boolean z, boolean z2, int i, int i2) {
        apiLog("startAudioMixing " + str + ", " + z + ", " + z2 + ", " + i);
        if (!checkAudioEnable()) {
            return -1;
        }
        this.mBgmFilePath = str;
        this.mTRTCCloud.getAudioEffectManager().stopPlayMusic(0);
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(0, str);
        audioMusicParam.publish = !z;
        audioMusicParam.loopCount = i;
        audioMusicParam.startTimeMS = i2;
        this.mTRTCCloud.getAudioEffectManager().startPlayMusic(audioMusicParam);
        this.mTRTCCloud.getAudioEffectManager().setMusicObserver(0, new TXAudioEffectManager.TXMusicPlayObserver() { // from class: com.qiahao.nextvideo.agoraadapter.TRTCEngineAdapter.3
            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public void onComplete(int i3, int i4) {
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onAudioMixingStateChanged(713, 723);
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public void onPlayProgress(int i3, long j, long j2) {
            }

            @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
            public void onStart(int i3, int i4) {
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onLocalAudioStateChanged(710, i4);
                TRTCEngineAdapter.this.mTRTCEngineAdapterListener.onAudioMixingStateChanged(710, SuperAdminReportActivity.THIRTY_DAY);
            }
        });
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int switchChannel(String str, String str2, ChannelMediaOptions channelMediaOptions) {
        return switchChannel(str, str2);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int setClientRole(int i, ClientRoleOptions clientRoleOptions) {
        return setClientRole(i);
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int startAudioRecording(String str, int i, int i2) {
        startAudioRecording(str, i2);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int addVideoWatermark(String str, WatermarkOptions watermarkOptions) {
        int i;
        int i2;
        float f;
        float f2;
        int i3;
        if (watermarkOptions == null) {
            apiLogError("addVideoWatermark error options is null");
            return -1;
        }
        apiLog("addVideoWatermark " + str);
        VideoEncoderConfiguration videoEncoderConfiguration = this.mVideoEncoderConfiguration;
        VideoEncoderConfiguration.VideoDimensions videoDimensions = videoEncoderConfiguration.dimensions;
        int i4 = videoDimensions.width;
        int i5 = videoDimensions.height;
        if (videoEncoderConfiguration.orientationMode == VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_FIXED_PORTRAIT) {
            WatermarkOptions.Rectangle rectangle = watermarkOptions.positionInPortraitMode;
            i = rectangle.width;
            i2 = rectangle.height;
            float f3 = i4;
            f = i / f3;
            f2 = rectangle.x / f3;
            i3 = rectangle.y;
        } else {
            WatermarkOptions.Rectangle rectangle2 = watermarkOptions.positionInLandscapeMode;
            i = rectangle2.width;
            i2 = rectangle2.height;
            float f4 = i4;
            f = i / f4;
            f2 = rectangle2.x / f4;
            i3 = rectangle2.y;
        }
        this.mTRTCCloud.setWatermark(Utils.getBitmap(str, i, i2), 0, f2, i3 / i5, f);
        return 0;
    }

    @Override // com.qiahao.nextvideo.agoraadapter.BaseAdapterImpl, com.qiahao.nextvideo.agoraadapter.BaseAgoraInterface
    public int joinChannel(String str, String str2, String str3, int i, ChannelMediaOptions channelMediaOptions) {
        return joinChannel(str, str2, str3, i);
    }
}
