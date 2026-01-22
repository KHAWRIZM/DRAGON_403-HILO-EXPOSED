package com.tencent.liteav.trtc;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SoLoader;
import com.tencent.liteav.base.util.f;
import com.tencent.liteav.base.util.k;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("liteav::trtc")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TrtcCloudJni {
    private static final Object INIT_LOCK = new Object();
    private static final String TAG = "TrtcCloudJni";
    private static boolean mHasInited;
    private TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener;
    private TRTCCloudListener.TRTCVideoFrameListener mCalledGLCreatedFrameListener;
    private final HashSet<View> mFloatingWindowSet;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private TRTCCloudListener mListener;
    private Handler mListenerHandler;
    private List<TRTCCloudListener> mListenerList;
    private String mLocalUserId;
    private final a<TRTCCloudListener.TRTCVideoRenderListener> mLocalVideoRenderListenerWrapper;
    private long mNativeTrtcCloudJni;
    private final ReentrantReadWriteLock mReadWriteLock;
    private final Map<String, a<TRTCCloudListener.TRTCVideoRenderListener>> mRemoteVideoRenderListenerMap;
    private final a<TRTCCloudListener.TRTCVideoFrameListener> mVideoFrameListenerWrapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.trtc.TrtcCloudJni$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k.values().length];
            a = iArr;
            try {
                iArr[k.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class AudioFrame {
        private TRTCCloudDef.TRTCAudioFrame a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.a = tRTCAudioFrame;
        }

        public int getChannel() {
            return this.a.channel;
        }

        public byte[] getData() {
            return this.a.data;
        }

        public int getSampleRate() {
            return this.a.sampleRate;
        }

        public long getTimestamp() {
            return this.a.timestamp;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class AudioParallelParams {
        private TRTCCloudDef.TRTCAudioParallelParams a;

        public AudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
            this.a = tRTCAudioParallelParams;
        }

        public String[] getIncludeUsers() {
            ArrayList<String> arrayList = this.a.includeUsers;
            if (arrayList != null) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return new String[0];
        }

        public int getMaxCount() {
            return this.a.maxCount;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class AudioRecordingParams {
        private final TRTCCloudDef.TRTCAudioRecordingParams a;

        public AudioRecordingParams(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
            this.a = tRTCAudioRecordingParams;
        }

        public int getContent() {
            return this.a.recordingContent;
        }

        public String getFilePath() {
            return this.a.filePath;
        }

        public int getMaxDurationPerFile() {
            return this.a.maxDurationPerFile;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class EnterRoomParams {
        private TRTCCloudDef.TRTCParams a;

        public EnterRoomParams(TRTCCloudDef.TRTCParams tRTCParams) {
            this.a = tRTCParams;
        }

        public String getBusinessInfo() {
            return this.a.businessInfo;
        }

        public String getPrivateMapKey() {
            return this.a.privateMapKey;
        }

        public String getRecordId() {
            return this.a.userDefineRecordId;
        }

        public int getRole() {
            return this.a.role;
        }

        public int getRoomId() {
            return this.a.roomId;
        }

        public int getSdkAppId() {
            return this.a.sdkAppId;
        }

        public String getStrRoomId() {
            return this.a.strRoomId;
        }

        public String getStreamId() {
            return this.a.streamId;
        }

        public String getUserId() {
            return this.a.userId;
        }

        public String getUserSig() {
            return this.a.userSig;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class LocalRecordingParams {
        private final TRTCCloudDef.TRTCLocalRecordingParams a;

        public LocalRecordingParams(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
            this.a = tRTCLocalRecordingParams;
        }

        public String getFilePath() {
            return this.a.filePath;
        }

        public int getInterval() {
            return this.a.interval;
        }

        public int getMaxDurationPerFile() {
            return this.a.maxDurationPerFile;
        }

        public int getRecordType() {
            return this.a.recordType;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class LocalStatistics {
        private TRTCStatistics.TRTCLocalStatistics a = new TRTCStatistics.TRTCLocalStatistics();

        LocalStatistics() {
        }

        public static void addLocalStatistics(LocalStatistics localStatistics, ArrayList<LocalStatistics> arrayList) {
            arrayList.add(localStatistics);
        }

        public static LocalStatistics createLocalStatistics(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LocalStatistics localStatistics = new LocalStatistics();
            TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics = localStatistics.a;
            tRTCLocalStatistics.streamType = i;
            tRTCLocalStatistics.width = i2;
            tRTCLocalStatistics.height = i3;
            tRTCLocalStatistics.frameRate = i4;
            tRTCLocalStatistics.videoBitrate = i5;
            tRTCLocalStatistics.audioBitrate = i7;
            tRTCLocalStatistics.audioSampleRate = i6;
            tRTCLocalStatistics.audioCaptureState = i8;
            return localStatistics;
        }

        public static ArrayList<LocalStatistics> createLocalStatisticsArray() {
            return new ArrayList<>();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class MixUser {
        private TRTCCloudDef.TRTCMixUser a;

        /* synthetic */ MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser, byte b) {
            this(tRTCMixUser);
        }

        public int getHeight() {
            return this.a.height;
        }

        public String getImage() {
            if (TextUtils.isEmpty(this.a.image)) {
                return "";
            }
            return this.a.image;
        }

        public int getInputType() {
            return this.a.inputType;
        }

        public boolean getPureAudio() {
            return this.a.pureAudio;
        }

        public int getRenderMode() {
            return this.a.renderMode;
        }

        public String getRoomId() {
            if (TextUtils.isEmpty(this.a.roomId)) {
                return "";
            }
            return this.a.roomId;
        }

        public int getSoundLevel() {
            return this.a.soundLevel;
        }

        public int getStreamType() {
            return this.a.streamType;
        }

        public String getUserId() {
            if (TextUtils.isEmpty(this.a.userId)) {
                return "";
            }
            return this.a.userId;
        }

        public int getWidth() {
            return this.a.width;
        }

        public int getX() {
            return this.a.x;
        }

        public int getY() {
            return this.a.y;
        }

        public int getZOrder() {
            return this.a.zOrder;
        }

        private MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser) {
            this.a = tRTCMixUser;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class PayloadPrivateEncryptionConfig {
        private TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig a;

        public PayloadPrivateEncryptionConfig(TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
            this.a = tRTCPayloadPrivateEncryptionConfig;
        }

        public int getEncryptionAlgorithm() {
            return this.a.encryptionAlgorithm;
        }

        public String getEncryptionKey() {
            String str = this.a.encryptionKey;
            if (str != null) {
                return str;
            }
            return "";
        }

        public byte[] getEncryptionSalt() {
            return this.a.encryptionSalt;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class PublishCDNParams {
        private TRTCCloudDef.TRTCPublishCDNParam a;

        public PublishCDNParams(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
            this.a = tRTCPublishCDNParam;
        }

        public int getAppId() {
            return this.a.appId;
        }

        public int getBizId() {
            return this.a.bizId;
        }

        public String getStreamId() {
            if (TextUtils.isEmpty(this.a.streamId)) {
                return "";
            }
            return this.a.streamId;
        }

        public String getUrl() {
            if (TextUtils.isEmpty(this.a.url)) {
                return "";
            }
            return this.a.url;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class PublishCdnUrl {
        private TRTCCloudDef.TRTCPublishCdnUrl a;

        public PublishCdnUrl(TRTCCloudDef.TRTCPublishCdnUrl tRTCPublishCdnUrl) {
            this.a = tRTCPublishCdnUrl;
        }

        public boolean getIsInternalLine() {
            return this.a.isInternalLine;
        }

        public String getRtmpUrl() {
            String str = this.a.rtmpUrl;
            if (str != null) {
                return str;
            }
            return "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class PublishTarget {
        private TRTCCloudDef.TRTCPublishTarget a;

        public PublishTarget(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget) {
            this.a = tRTCPublishTarget;
        }

        public int getMode() {
            return this.a.mode;
        }

        public PublishCdnUrl[] getPublishCdnUrls() {
            ArrayList<TRTCCloudDef.TRTCPublishCdnUrl> arrayList = this.a.cdnUrlList;
            if (arrayList == null) {
                return null;
            }
            PublishCdnUrl[] publishCdnUrlArr = new PublishCdnUrl[arrayList.size()];
            for (int i = 0; i < this.a.cdnUrlList.size(); i++) {
                publishCdnUrlArr[i] = new PublishCdnUrl(this.a.cdnUrlList.get(i));
            }
            return publishCdnUrlArr;
        }

        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.a.mixStreamIdentity);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class RemoteStatistics {
        public TRTCStatistics.TRTCRemoteStatistics a = new TRTCStatistics.TRTCRemoteStatistics();

        RemoteStatistics() {
        }

        public static void addRemoteStatistics(RemoteStatistics remoteStatistics, ArrayList<RemoteStatistics> arrayList) {
            arrayList.add(remoteStatistics);
        }

        public static RemoteStatistics createRemoteStatistics(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            RemoteStatistics remoteStatistics = new RemoteStatistics();
            TRTCStatistics.TRTCRemoteStatistics tRTCRemoteStatistics = remoteStatistics.a;
            tRTCRemoteStatistics.userId = str;
            tRTCRemoteStatistics.streamType = i;
            tRTCRemoteStatistics.width = i2;
            tRTCRemoteStatistics.height = i3;
            tRTCRemoteStatistics.frameRate = i4;
            tRTCRemoteStatistics.audioPacketLoss = i11;
            tRTCRemoteStatistics.videoPacketLoss = i5;
            tRTCRemoteStatistics.videoBlockRate = i8;
            tRTCRemoteStatistics.videoTotalBlockTime = i7;
            tRTCRemoteStatistics.videoBitrate = i6;
            tRTCRemoteStatistics.audioBitrate = i10;
            tRTCRemoteStatistics.audioSampleRate = i9;
            tRTCRemoteStatistics.audioTotalBlockTime = i12;
            tRTCRemoteStatistics.audioBlockRate = i13;
            tRTCRemoteStatistics.jitterBufferDelay = i14;
            tRTCRemoteStatistics.point2PointDelay = i15;
            tRTCRemoteStatistics.finalLoss = i16;
            tRTCRemoteStatistics.remoteNetworkUplinkLoss = i17;
            tRTCRemoteStatistics.remoteNetworkRTT = i18;
            return remoteStatistics;
        }

        public static ArrayList<RemoteStatistics> createRemoteStatisticsArray() {
            return new ArrayList<>();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class ScreenShareParams {
        private final TRTCCloudDef.TRTCScreenShareParams a;

        public ScreenShareParams(TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
            this.a = tRTCScreenShareParams;
        }

        public Object getMediaProjection() {
            return this.a.mediaProjection;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class SpeedTestResult {
        private TRTCCloudDef.TRTCSpeedTestResult a = new TRTCCloudDef.TRTCSpeedTestResult();

        SpeedTestResult() {
        }

        public static SpeedTestResult createSpeedTestResult(boolean z, String str, String str2, int i, float f, float f2, int i2, int i3, int i4, int i5, int i6) {
            SpeedTestResult speedTestResult = new SpeedTestResult();
            TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult = speedTestResult.a;
            tRTCSpeedTestResult.success = z;
            tRTCSpeedTestResult.errMsg = str;
            tRTCSpeedTestResult.ip = str2;
            tRTCSpeedTestResult.quality = i;
            tRTCSpeedTestResult.upLostRate = f;
            tRTCSpeedTestResult.downLostRate = f2;
            tRTCSpeedTestResult.rtt = i2;
            tRTCSpeedTestResult.availableUpBandwidth = i3;
            tRTCSpeedTestResult.availableDownBandwidth = i4;
            tRTCSpeedTestResult.upJitter = i5;
            tRTCSpeedTestResult.downJitter = i6;
            return speedTestResult;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class Statistics {
        private TRTCStatistics a = new TRTCStatistics();

        Statistics() {
        }

        public static Statistics createStatistics(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2, ArrayList<LocalStatistics> arrayList, ArrayList<RemoteStatistics> arrayList2) {
            Statistics statistics = new Statistics();
            TRTCStatistics tRTCStatistics = statistics.a;
            tRTCStatistics.appCpu = i;
            tRTCStatistics.systemCpu = i2;
            tRTCStatistics.upLoss = i3;
            tRTCStatistics.downLoss = i4;
            tRTCStatistics.rtt = i5;
            tRTCStatistics.gatewayRtt = i6;
            tRTCStatistics.sendBytes = j;
            tRTCStatistics.receiveBytes = j2;
            tRTCStatistics.localArray = new ArrayList<>();
            statistics.a.remoteArray = new ArrayList<>();
            if (arrayList != null) {
                Iterator<LocalStatistics> it = arrayList.iterator();
                while (it.hasNext()) {
                    statistics.a.localArray.add(it.next().a);
                }
            }
            if (arrayList2 != null) {
                Iterator<RemoteStatistics> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    statistics.a.remoteArray.add(it2.next().a);
                }
            }
            return statistics;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class StreamEncoderParam {
        private TRTCCloudDef.TRTCStreamEncoderParam a;

        public StreamEncoderParam(TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam) {
            this.a = tRTCStreamEncoderParam;
        }

        public int getAudioEncodedChannelNum() {
            return this.a.audioEncodedChannelNum;
        }

        public int getAudioEncodedCodecType() {
            return this.a.audioEncodedCodecType;
        }

        public int getAudioEncodedKbps() {
            return this.a.audioEncodedKbps;
        }

        public int getAudioEncodedSampleRate() {
            return this.a.audioEncodedSampleRate;
        }

        public int getVideoEncodedCodecType() {
            return this.a.videoEncodedCodecType;
        }

        public int getVideoEncodedFPS() {
            return this.a.videoEncodedFPS;
        }

        public int getVideoEncodedGOP() {
            return this.a.videoEncodedGOP;
        }

        public int getVideoEncodedHeight() {
            return this.a.videoEncodedHeight;
        }

        public int getVideoEncodedKbps() {
            return this.a.videoEncodedKbps;
        }

        public int getVideoEncodedWidth() {
            return this.a.videoEncodedWidth;
        }

        public String getVideoSeiParams() {
            if (TextUtils.isEmpty(this.a.videoSeiParams)) {
                return "";
            }
            return this.a.videoSeiParams;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class StreamMixingConfig {
        private TRTCCloudDef.TRTCStreamMixingConfig a;

        public StreamMixingConfig(TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
            this.a = tRTCStreamMixingConfig;
        }

        public TRTCUser[] getAudioMixUserList() {
            ArrayList<TRTCCloudDef.TRTCUser> arrayList = this.a.audioMixUserList;
            if (arrayList == null) {
                return null;
            }
            TRTCUser[] tRTCUserArr = new TRTCUser[arrayList.size()];
            for (int i = 0; i < this.a.audioMixUserList.size(); i++) {
                tRTCUserArr[i] = new TRTCUser(this.a.audioMixUserList.get(i));
            }
            return tRTCUserArr;
        }

        public int getBackgroundColor() {
            return this.a.backgroundColor;
        }

        public String getBackgroundImage() {
            String str = this.a.backgroundImage;
            if (str != null) {
                return str;
            }
            return "";
        }

        public VideoLayout[] getVideoLayoutList() {
            ArrayList<TRTCCloudDef.TRTCVideoLayout> arrayList = this.a.videoLayoutList;
            if (arrayList == null) {
                return null;
            }
            VideoLayout[] videoLayoutArr = new VideoLayout[arrayList.size()];
            for (int i = 0; i < this.a.videoLayoutList.size(); i++) {
                videoLayoutArr[i] = new VideoLayout(this.a.videoLayoutList.get(i));
            }
            return videoLayoutArr;
        }

        public Watermark[] getWatermarkList() {
            ArrayList<TRTCCloudDef.TRTCWatermark> arrayList = this.a.watermarkList;
            if (arrayList == null) {
                return null;
            }
            Watermark[] watermarkArr = new Watermark[arrayList.size()];
            for (int i = 0; i < this.a.watermarkList.size(); i++) {
                watermarkArr[i] = new Watermark(this.a.watermarkList.get(i));
            }
            return watermarkArr;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class SwitchRoomConfig {
        private TRTCCloudDef.TRTCSwitchRoomConfig a;

        public SwitchRoomConfig(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
            this.a = tRTCSwitchRoomConfig;
        }

        public String getPrivateMapKey() {
            String str = this.a.privateMapKey;
            if (str != null) {
                return str;
            }
            return "";
        }

        public int getRoomId() {
            return this.a.roomId;
        }

        public String getStringRoomId() {
            String str = this.a.strRoomId;
            if (str != null) {
                return str;
            }
            return "";
        }

        public String getUserSig() {
            String str = this.a.userSig;
            if (str != null) {
                return str;
            }
            return "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class TRTCUser {
        private TRTCCloudDef.TRTCUser a;

        public TRTCUser(TRTCCloudDef.TRTCUser tRTCUser) {
            this.a = tRTCUser;
        }

        public int getIntRoomId() {
            return this.a.intRoomId;
        }

        public String getStrRoomId() {
            String str = this.a.strRoomId;
            if (str != null) {
                return str;
            }
            return "";
        }

        public String getUserId() {
            String str = this.a.userId;
            if (str != null) {
                return str;
            }
            return "";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class TranscodingConfig {
        private TRTCCloudDef.TRTCTranscodingConfig a;

        public TranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
            this.a = tRTCTranscodingConfig;
        }

        public int getAppId() {
            return this.a.appId;
        }

        public int getAudioBitrate() {
            return this.a.audioBitrate;
        }

        public int getAudioChannels() {
            return this.a.audioChannels;
        }

        public int getAudioSampleRate() {
            return this.a.audioSampleRate;
        }

        public int getBackgroundColor() {
            return this.a.backgroundColor;
        }

        public String getBackgroundImage() {
            if (TextUtils.isEmpty(this.a.backgroundImage)) {
                return "";
            }
            return this.a.backgroundImage;
        }

        public int getBizId() {
            return this.a.bizId;
        }

        public MixUser[] getMixUsers() {
            ArrayList<TRTCCloudDef.TRTCMixUser> arrayList = this.a.mixUsers;
            if (arrayList == null) {
                return null;
            }
            MixUser[] mixUserArr = new MixUser[arrayList.size()];
            byte b = 0;
            for (int i = 0; i < this.a.mixUsers.size(); i++) {
                mixUserArr[i] = new MixUser(this.a.mixUsers.get(i), b);
            }
            return mixUserArr;
        }

        public int getMode() {
            return this.a.mode;
        }

        public String getStreamId() {
            if (TextUtils.isEmpty(this.a.streamId)) {
                return "";
            }
            return this.a.streamId;
        }

        public int getVideoBitrate() {
            return this.a.videoBitrate;
        }

        public int getVideoFramerate() {
            return this.a.videoFramerate;
        }

        public int getVideoGOP() {
            return this.a.videoGOP;
        }

        public int getVideoHeight() {
            return this.a.videoHeight;
        }

        public String getVideoSeiParams() {
            if (TextUtils.isEmpty(this.a.videoSeiParams)) {
                return "";
            }
            return this.a.videoSeiParams;
        }

        public int getVideoWidth() {
            return this.a.videoWidth;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class VideoEncParams {
        private TRTCCloudDef.TRTCVideoEncParam a;

        public VideoEncParams(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
            this.a = tRTCVideoEncParam;
        }

        public int getMinVideoBitrate() {
            return this.a.minVideoBitrate;
        }

        public int getVideoBitrate() {
            return this.a.videoBitrate;
        }

        public int getVideoFps() {
            return this.a.videoFps;
        }

        public int getVideoResolution() {
            return this.a.videoResolution;
        }

        public int getVideoResolutionMode() {
            return this.a.videoResolutionMode;
        }

        public boolean isEnableAdjustRes() {
            return this.a.enableAdjustRes;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class VideoLayout {
        private TRTCCloudDef.TRTCVideoLayout a;

        public VideoLayout(TRTCCloudDef.TRTCVideoLayout tRTCVideoLayout) {
            this.a = tRTCVideoLayout;
        }

        public int getBackgroundColor() {
            return this.a.backgroundColor;
        }

        public int getFillMode() {
            return this.a.fillMode;
        }

        public int getHeight() {
            return this.a.height;
        }

        public String getPlaceHolderImage() {
            String str = this.a.placeHolderImage;
            if (str != null) {
                return str;
            }
            return "";
        }

        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.a.fixedVideoUser);
        }

        public int getVideoStreamType() {
            return this.a.fixedVideoStreamType;
        }

        public int getWidth() {
            return this.a.width;
        }

        public int getX() {
            return this.a.x;
        }

        public int getY() {
            return this.a.y;
        }

        public int getZOrder() {
            return this.a.zOrder;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class Watermark {
        private TRTCCloudDef.TRTCWatermark a;

        public Watermark(TRTCCloudDef.TRTCWatermark tRTCWatermark) {
            this.a = tRTCWatermark;
        }

        public int getHeight() {
            return this.a.height;
        }

        public String getWatermarkUrl() {
            String str = this.a.watermarkUrl;
            if (str != null) {
                return str;
            }
            return "";
        }

        public int getWidth() {
            return this.a.width;
        }

        public int getX() {
            return this.a.x;
        }

        public int getY() {
            return this.a.y;
        }

        public int getZOrder() {
            return this.a.zOrder;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class a<T> {
        public int a;
        public int b;
        public int c;
        public T d;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        SoLoader.loadAllLibraries();
    }

    public TrtcCloudJni(boolean z) {
        this(0L, z);
    }

    private List<TRTCCloudListener> CopyOnReadListeners() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.mListenerList);
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null && !copyOnWriteArrayList.contains(tRTCCloudListener)) {
            copyOnWriteArrayList.add(tRTCCloudListener);
        }
        return copyOnWriteArrayList;
    }

    private static int convertPixelFrameRotationToTRTCVideoRotation(k kVar) {
        int i = AnonymousClass1.a[kVar.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    private static k covertTRTCVideoRotationToPixelFrameRotation(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return k.NORMAL;
                }
                return k.ROTATION_270;
            }
            return k.ROTATION_180;
        }
        return k.ROTATION_90;
    }

    public static Bundle createExtraInfoBundle(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i);
        return bundle;
    }

    private Bundle extraToBundle(String str) {
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    String[] strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                    bundle.putStringArray(next, strArr);
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof String) {
                    bundle.putString(next, (String) obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bundle;
    }

    public static long getGLContextNativeHandle(Object obj) {
        return TRTCDefConverter.getGLContextNativeHandle(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingWindow() {
        WindowManager windowManager;
        if (this.mFloatingWindowSet.isEmpty()) {
            return;
        }
        Iterator<View> it = this.mFloatingWindowSet.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (next != null && (windowManager = (WindowManager) next.getContext().getSystemService("window")) != null) {
                windowManager.removeViewImmediate(next);
            }
        }
        this.mFloatingWindowSet.clear();
    }

    public static void init(int i) {
        synchronized (INIT_LOCK) {
            try {
                if (!mHasInited) {
                    mHasInited = true;
                    nativeGlobalInit(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean isCustomPreprocessSupportedBufferType(int i) {
        return i == 1 || i == 2 || i == 3;
    }

    private static boolean isCustomPreprocessSupportedFormatType(int i) {
        return i == 1 || i == 4 || i == 5 || i == 2;
    }

    private static boolean isCustomRenderSupportedBufferType(int i) {
        return i == 1 || i == 2 || i == 3;
    }

    private static boolean isCustomRenderSupportedFormatType(int i) {
        return i == 1 || i == 4 || i == 5 || i == 2;
    }

    public static boolean isInUIThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$enterRoom$0(TrtcCloudJni trtcCloudJni) {
        trtcCloudJni.onEnterRoom(-3316);
        trtcCloudJni.onError(-3316, "enter room param null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onSnapshotComplete$2(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        if (tRTCSnapshotListener != null) {
            tRTCSnapshotListener.onSnapshotComplete(bitmap);
        }
    }

    private static native String nativeCallExperimentalAPI(long j, String str);

    private static native void nativeConnectOtherRoom(long j, String str);

    private static native long nativeCreateAudioEffectManager(long j);

    private static native long nativeCreateBeautyManager(long j);

    private static native long nativeCreateDeviceManager(long j);

    private static native long nativeCreatePipeline(TrtcCloudJni trtcCloudJni, boolean z);

    private static native long nativeCreateSubCloud(TrtcCloudJni trtcCloudJni, long j);

    private static native void nativeDestroyPipeline(long j);

    private static native void nativeDisconnectOtherRoom(long j);

    private static native void nativeEnable3DSpatialAudioEffect(long j, boolean z);

    private static native void nativeEnableAudioFrameNotification(long j, boolean z);

    private static native void nativeEnableAudioVolumeEvaluation(long j, boolean z, int i, boolean z2, boolean z3, boolean z4);

    private static native void nativeEnableCustomAudioCapture(long j, boolean z);

    private static native void nativeEnableCustomAudioRendering(long j, boolean z);

    private static native void nativeEnableCustomVideoCapture(long j, int i, boolean z);

    private static native void nativeEnableEncSmallVideoStream(long j, boolean z, VideoEncParams videoEncParams);

    private static native void nativeEnableMixExternalAudioFrame(long j, boolean z, boolean z2);

    private static native int nativeEnablePayloadPrivateEncryption(long j, boolean z, PayloadPrivateEncryptionConfig payloadPrivateEncryptionConfig);

    private static native void nativeEnableVideoCustomPreprocess(long j, boolean z, int i, int i2);

    private static native void nativeEnableVideoCustomRender(long j, boolean z, String str, int i, int i2, int i3);

    private static native void nativeEnterRoom(long j, EnterRoomParams enterRoomParams, int i);

    private static native void nativeExitRoom(long j);

    private static native int nativeGetAudioCaptureVolume(long j);

    private static native int nativeGetAudioPlayoutVolume(long j);

    private static native void nativeGetCustomAudioRenderingFrame(long j, byte[] bArr, int i, int i2);

    private static native void nativeGlobalInit(int i);

    private static native void nativeGlobalUninit();

    private static native int nativeMixExternalAudioFrame(long j, AudioFrame audioFrame);

    private static native void nativeMuteAllRemoteAudio(long j, boolean z);

    private static native void nativeMuteAllRemoteVideoStreams(long j, boolean z);

    private static native void nativeMuteLocalAudio(long j, boolean z);

    private static native void nativeMuteLocalVideo(long j, int i, boolean z);

    private static native void nativeMuteRemoteAudio(long j, String str, boolean z);

    private static native void nativeMuteRemoteVideoStream(long j, String str, int i, boolean z);

    private static native void nativePauseScreenCapture(long j, int i);

    private static native void nativeResumeScreenCapture(long j, int i);

    private static native void nativeSendCustomAudioData(long j, AudioFrame audioFrame);

    private static native boolean nativeSendCustomCmdMsg(long j, int i, byte[] bArr, boolean z, boolean z2);

    private static native void nativeSendCustomVideoData(long j, int i, int i2, int i3, Object obj, int i4, int i5, int i6, int i7, long j2, byte[] bArr, ByteBuffer byteBuffer);

    private static native boolean nativeSendSEIMsg(long j, byte[] bArr, int i);

    private static native void nativeSet3DSpatialReceivingRange(long j, String str, int i);

    private static native void nativeSetAudioCaptureVolume(long j, int i);

    private static native void nativeSetAudioPlayoutVolume(long j, int i);

    private static native void nativeSetAudioQuality(long j, int i);

    private static native int nativeSetCapturedAudioFrameCallbackFormat(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetConsoleEnabled(boolean z);

    private static native void nativeSetDefaultStreamRecvMode(long j, boolean z, boolean z2);

    private static native void nativeSetGSensorMode(long j, int i, int i2);

    private static native void nativeSetGravitySensorAdaptiveMode(long j, int i);

    private static native void nativeSetListenerHandler(long j, Handler handler);

    private static native int nativeSetLocalProcessedAudioFrameCallbackFormat(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetLocalViewFillMode(long j, int i);

    private static native void nativeSetLocalViewMirror(long j, int i);

    private static native void nativeSetLocalViewRotation(long j, int i);

    private static native void nativeSetLogCompressEnabled(boolean z);

    private static native void nativeSetLogLevel(int i);

    private static native void nativeSetLogPath(String str);

    private static native void nativeSetMixExternalAudioVolume(long j, int i, int i2);

    private static native void nativeSetMixTranscodingConfig(long j, TranscodingConfig transcodingConfig);

    private static native int nativeSetMixedPlayAudioFrameCallbackFormat(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetNetworkQosParam(long j, int i, int i2);

    private static native void nativeSetPerspectiveCorrectionPoints(long j, String str, float[] fArr, float[] fArr2);

    private static native void nativeSetPriorRemoteVideoStreamType(long j, int i);

    private static native void nativeSetRemoteAudioParallelParams(long j, AudioParallelParams audioParallelParams);

    private static native void nativeSetRemoteAudioVolume(long j, String str, int i);

    private static native void nativeSetRemoteVideoStreamType(long j, String str, int i);

    private static native void nativeSetRemoteViewFillMode(long j, String str, int i, int i2);

    private static native void nativeSetRemoteViewMirror(long j, String str, int i, int i2);

    private static native void nativeSetRemoteViewRotation(long j, String str, int i, int i2);

    private static native void nativeSetVideoEncoderMirror(long j, boolean z);

    private static native void nativeSetVideoEncoderParams(long j, int i, VideoEncParams videoEncParams);

    private static native void nativeSetVideoEncoderRotation(long j, int i);

    private static native void nativeSetVideoMuteImage(long j, Bitmap bitmap, int i);

    private static native void nativeSetWatermark(long j, Bitmap bitmap, int i, float f, float f2, float f3);

    private static native void nativeShowDashboardManager(long j, int i);

    private static native void nativeSnapshotVideo(long j, String str, int i, int i2, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    private static native int nativeStartAudioRecording(long j, AudioRecordingParams audioRecordingParams);

    private static native void nativeStartLocalAudio(long j);

    private static native void nativeStartLocalAudioWithQuality(long j, int i);

    private static native void nativeStartLocalPreview(long j, boolean z, TXCloudVideoView tXCloudVideoView);

    private static native void nativeStartLocalRecording(long j, LocalRecordingParams localRecordingParams);

    private static native void nativeStartPublishCDNStream(long j, PublishCDNParams publishCDNParams);

    private static native void nativeStartPublishMediaStream(long j, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeStartPublishing(long j, String str, int i);

    private static native void nativeStartRemoteView(long j, String str, int i, TXCloudVideoView tXCloudVideoView);

    private static native void nativeStartRemoteViewWithoutStreamType(long j, String str, TXCloudVideoView tXCloudVideoView);

    private static native void nativeStartScreenCapture(long j, int i, VideoEncParams videoEncParams, ScreenShareParams screenShareParams);

    private static native void nativeStartSpeedTest(long j, SpeedTestParams speedTestParams);

    private static native void nativeStartSystemAudioLoopback(long j);

    private static native void nativeStopAllRemoteView(long j);

    private static native void nativeStopAudioRecording(long j);

    private static native void nativeStopLocalAudio(long j);

    private static native void nativeStopLocalPreview(long j);

    private static native void nativeStopLocalRecording(long j);

    private static native void nativeStopPublishCDNStream(long j);

    private static native void nativeStopPublishMediaStream(long j, String str);

    private static native void nativeStopPublishing(long j);

    private static native void nativeStopRemoteView(long j, String str, int i);

    private static native void nativeStopRemoteViewWithoutStreamType(long j, String str);

    private static native void nativeStopScreenCapture(long j, int i);

    private static native void nativeStopSpeedTest(long j);

    private static native void nativeStopSystemAudioLoopback(long j);

    private static native void nativeSwitchRole(long j, int i);

    private static native void nativeSwitchRoleWithPrivateMapKey(long j, int i, String str);

    private static native void nativeSwitchRoom(long j, SwitchRoomConfig switchRoomConfig);

    private static native void nativeUpdateLocalView(long j, TXCloudVideoView tXCloudVideoView);

    private static native void nativeUpdateOtherRoomForwardMode(long j, String str);

    private static native void nativeUpdatePublishMediaStream(long j, String str, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeUpdateRemote3DSpatialPosition(long j, String str, int[] iArr);

    private static native void nativeUpdateRemoteView(long j, String str, int i, TXCloudVideoView tXCloudVideoView);

    private static native void nativeUpdateSelf3DSpatialPosition(long j, int[] iArr, float[] fArr, float[] fArr2, float[] fArr3);

    private void runOnListenerThread(Runnable runnable) {
        Handler handler = this.mListenerHandler;
        if (Looper.myLooper() != handler.getLooper()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void setConsoleEnabled(boolean z) {
        nativeSetConsoleEnabled(z);
    }

    public static void setLogCompressEnabled(boolean z) {
        nativeSetLogCompressEnabled(z);
    }

    public static void setLogDirPath(String str) {
        nativeSetLogPath(str);
    }

    public static void setLogLevel(int i) {
        nativeSetLogLevel(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatingWindow(View view) {
        int i;
        if (view == null) {
            return;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && !ia.k.a(view.getContext())) {
            LiteavLog.e(TAG, "can't show floating window for no drawing overlay permission");
            return;
        }
        if (this.mFloatingWindowSet.contains(view)) {
            LiteavLog.i(TAG, "the window has been added");
            return;
        }
        WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
        if (windowManager == null) {
            LiteavLog.e(TAG, "get windowManager error");
            return;
        }
        this.mFloatingWindowSet.add(view);
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
            i = 2038;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() > 24) {
            i = 2002;
        } else {
            i = TXLiveConstants.PLAY_EVT_PLAY_PROGRESS;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i);
        layoutParams.flags = 8 | 262144;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        windowManager.addView(view, layoutParams);
    }

    public static void uninit() {
        synchronized (INIT_LOCK) {
            try {
                if (mHasInited) {
                    mHasInited = false;
                    nativeGlobalUninit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addListener(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener != null && !this.mListenerList.contains(tRTCCloudListener)) {
            this.mListenerList.add(tRTCCloudListener);
        }
    }

    public String callExperimentalAPI(String str) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                return nativeCallExperimentalAPI(j, str);
            }
            this.mJniReadLock.unlock();
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void connectOtherRoom(String str) {
        long j = this.mNativeTrtcCloudJni;
        if (j != 0) {
            nativeConnectOtherRoom(j, str);
        }
    }

    public long createAudioEffectManager() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            long j2 = 0;
            if (j != 0) {
                j2 = nativeCreateAudioEffectManager(j);
            }
            return j2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public long createBeautyManager() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            long j2 = 0;
            if (j != 0) {
                j2 = nativeCreateBeautyManager(j);
            }
            return j2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public ByteBuffer createByteBuffer(int i) {
        return ByteBuffer.allocateDirect(i);
    }

    public long createDeviceManager() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            long j2 = 0;
            if (j != 0) {
                j2 = nativeCreateDeviceManager(j);
            }
            return j2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public TRTCCloudDef.TRTCVideoFrame createTRTCVideoFrame(int i, int i2, Object obj, int i3, int i4, int i5, int i6, long j, byte[] bArr, ByteBuffer byteBuffer) {
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
        tRTCVideoFrame.pixelFormat = i;
        tRTCVideoFrame.bufferType = i2;
        TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
        tRTCVideoFrame.texture = tRTCTexture;
        tRTCTexture.textureId = i3;
        if (obj instanceof EGLContext) {
            tRTCTexture.eglContext10 = (EGLContext) obj;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (obj instanceof android.opengl.EGLContext)) {
            tRTCVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) obj;
        }
        tRTCVideoFrame.data = bArr;
        tRTCVideoFrame.buffer = byteBuffer;
        tRTCVideoFrame.width = i4;
        tRTCVideoFrame.height = i5;
        tRTCVideoFrame.timestamp = j;
        tRTCVideoFrame.rotation = convertPixelFrameRotationToTRTCVideoRotation(k.a(i6));
        return tRTCVideoFrame;
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeDestroyPipeline(j);
                this.mNativeTrtcCloudJni = 0L;
            }
            this.mListenerList.clear();
            this.mJniWriteLock.unlock();
        } catch (Throwable th) {
            this.mJniWriteLock.unlock();
            throw th;
        }
    }

    public void disconnectOtherRoom() {
        long j = this.mNativeTrtcCloudJni;
        if (j != 0) {
            nativeDisconnectOtherRoom(j);
        }
    }

    public void enable3DSpatialAudioEffect(boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeEnable3DSpatialAudioEffect(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableAudioVolumeEvaluation(boolean z, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCAudioVolumeEvaluateParams != null) {
                nativeEnableAudioVolumeEvaluation(j, z, tRTCAudioVolumeEvaluateParams.interval, tRTCAudioVolumeEvaluateParams.enableVadDetection, tRTCAudioVolumeEvaluateParams.enablePitchCalculation, tRTCAudioVolumeEvaluateParams.enableSpectrumCalculation);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioCapture(boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeEnableCustomAudioCapture(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioRendering(boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeEnableCustomAudioRendering(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomVideoCapture(int i, boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeEnableCustomVideoCapture(j, i, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int enableEncSmallVideoStream(boolean z, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        VideoEncParams videoEncParams;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                if (tRTCVideoEncParam == null) {
                    videoEncParams = null;
                } else {
                    videoEncParams = new VideoEncParams(tRTCVideoEncParam);
                }
                nativeEnableEncSmallVideoStream(j, z, videoEncParams);
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void enableMixExternalAudioFrame(boolean z, boolean z2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeEnableMixExternalAudioFrame(j, z, z2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int enablePayloadPrivateEncryption(boolean z, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
        int i;
        PayloadPrivateEncryptionConfig payloadPrivateEncryptionConfig;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                if (tRTCPayloadPrivateEncryptionConfig == null) {
                    payloadPrivateEncryptionConfig = null;
                } else {
                    payloadPrivateEncryptionConfig = new PayloadPrivateEncryptionConfig(tRTCPayloadPrivateEncryptionConfig);
                }
                i = nativeEnablePayloadPrivateEncryption(j, z, payloadPrivateEncryptionConfig);
            } else {
                i = -1;
            }
            return i;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i) {
        if (tRTCParams == null) {
            LiteavLog.e(TAG, "enterRoom param is null");
            runOnListenerThread(com.tencent.liteav.trtc.a.a(this));
            return;
        }
        this.mJniReadLock.lock();
        try {
            this.mLocalUserId = tRTCParams.userId;
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeEnterRoom(j, new EnterRoomParams(tRTCParams), i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void exitRoom() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeExitRoom(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioCaptureVolume() {
        int i;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                i = nativeGetAudioCaptureVolume(j);
            } else {
                i = 0;
            }
            return i;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioPlayoutVolume() {
        int i;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                i = nativeGetAudioPlayoutVolume(j);
            } else {
                i = 0;
            }
            return i;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeGetCustomAudioRenderingFrame(j, tRTCAudioFrame.data, tRTCAudioFrame.sampleRate, tRTCAudioFrame.channel);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getFrameBufferType(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.bufferType;
    }

    public byte[] getFrameByteArray(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.data;
    }

    public ByteBuffer getFrameByteBuffer(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.buffer;
    }

    public Object getFrameEglContext(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
            return tRTCVideoFrame.texture.eglContext14;
        }
        return tRTCVideoFrame.texture.eglContext10;
    }

    public int getFrameHeight(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.height;
    }

    public int getFramePixelFormat(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.pixelFormat;
    }

    public long getFramePts(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.timestamp;
    }

    public int getFrameRotation(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation).mValue;
    }

    public int getFrameTextureId(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.texture.textureId;
    }

    public int getFrameWidth(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.width;
    }

    public long getTrtcCloudJni() {
        this.mJniReadLock.lock();
        try {
            return this.mNativeTrtcCloudJni;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                return nativeMixExternalAudioFrame(j, new AudioFrame(tRTCAudioFrame));
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteAudio(boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeMuteAllRemoteAudio(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteVideoStreams(boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeMuteAllRemoteVideoStreams(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalAudio(boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeMuteLocalAudio(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalVideo(int i, boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeMuteLocalVideo(j, i, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteAudio(String str, boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeMuteRemoteAudio(j, str, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteVideoStream(String str, int i, boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeMuteRemoteVideoStream(j, str, i, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void onAudioCaptureProcessedData(byte[] bArr, long j, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onCapturedAudioFrame(tRTCAudioFrame);
    }

    public void onAudioMixedAllData(byte[] bArr, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = 0L;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onMixedAllAudioFrame(tRTCAudioFrame);
    }

    public void onAudioPlayoutData(byte[] bArr, long j, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onMixedPlayAudioFrame(tRTCAudioFrame);
    }

    public void onAudioRemoteStreamData(String str, byte[] bArr, long j, int i, int i2, byte[] bArr2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrame.extraData = bArr2;
        tRTCAudioFrameListener.onRemoteUserAudioFrame(tRTCAudioFrame, str);
    }

    public void onAudioRouteChanged(int i, int i2) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onAudioRouteChanged(i, i2);
        }
    }

    void onCameraDidReady() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onCameraDidReady();
        }
    }

    public void onCdnStreamStateChanged(String str, int i, int i2, String str2, String str3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onCdnStreamStateChanged(str, i, i2, str2, null);
        }
    }

    public void onConnectOtherRoom(String str, int i, String str2) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onConnectOtherRoom(str, i, str2);
        }
    }

    void onConnectionLost() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onConnectionLost();
        }
    }

    void onConnectionRecovery() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onConnectionRecovery();
        }
    }

    public void onDisConnectOtherRoom(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onDisConnectOtherRoom(i, str);
        }
    }

    public void onEarMonitoringData(byte[] bArr, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = 0L;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onVoiceEarMonitorAudioFrame(tRTCAudioFrame);
    }

    public void onEnterRoom(int i) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onEnterRoom(i);
        }
    }

    public void onError(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onError(i, str, null);
        }
    }

    public void onExitRoom(int i) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onExitRoom(i);
        }
        synchronized (this.mLocalVideoRenderListenerWrapper) {
            this.mLocalVideoRenderListenerWrapper.d = null;
        }
        synchronized (this.mRemoteVideoRenderListenerMap) {
            this.mRemoteVideoRenderListenerMap.clear();
        }
    }

    void onFirstAudioFrame(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onFirstAudioFrame(str);
        }
    }

    void onFirstVideoFrame(String str, int i, int i2, int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onFirstVideoFrame(str, i, i2, i3);
        }
    }

    public void onGLContextCreated() {
        synchronized (this.mVideoFrameListenerWrapper) {
            this.mCalledGLCreatedFrameListener = this.mVideoFrameListenerWrapper.d;
        }
        LiteavLog.i(TAG, "onGLContextCreated " + this.mCalledGLCreatedFrameListener);
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextCreated();
        }
    }

    public void onGLContextDestroy() {
        LiteavLog.i(TAG, "onGLContextDestroy " + this.mCalledGLCreatedFrameListener);
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextDestory();
            this.mCalledGLCreatedFrameListener = null;
        }
    }

    public byte[] onLocalAudioStreamData(byte[] bArr, long j, int i, int i2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return null;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j;
        tRTCAudioFrame.sampleRate = i;
        tRTCAudioFrame.channel = i2;
        tRTCAudioFrameListener.onLocalProcessedAudioFrame(tRTCAudioFrame);
        byte[] bArr2 = tRTCAudioFrame.extraData;
        if (bArr2 == null) {
            return null;
        }
        if (bArr2.length > 100) {
            LiteavLog.w(TAG, "Audioframe.extraData length need to be under 100!");
            return null;
        }
        return bArr2;
    }

    public void onLocalRecordBegin(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onLocalRecordBegin(i, str);
        }
    }

    public void onLocalRecordComplete(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onLocalRecordComplete(i, str);
        }
    }

    public void onLocalRecordFragment(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onLocalRecordFragment(str);
        }
    }

    public void onLocalRecording(long j, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onLocalRecording(j, str);
        }
    }

    void onMicDidReady() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onMicDidReady();
        }
    }

    public void onMissCustomCmdMsg(String str, int i, int i2, int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onMissCustomCmdMsg(str, i, i2, i3);
        }
    }

    public void onNetworkQuality(int i, String[] strArr, int[] iArr) {
        if (CopyOnReadListeners().size() == 0) {
            return;
        }
        TRTCCloudDef.TRTCQuality tRTCQuality = new TRTCCloudDef.TRTCQuality();
        tRTCQuality.userId = "";
        tRTCQuality.quality = i;
        ArrayList<TRTCCloudDef.TRTCQuality> arrayList = new ArrayList<>();
        if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0 && iArr.length == strArr.length) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                TRTCCloudDef.TRTCQuality tRTCQuality2 = new TRTCCloudDef.TRTCQuality();
                tRTCQuality2.userId = strArr[i2];
                tRTCQuality2.quality = iArr[i2];
                arrayList.add(tRTCQuality2);
            }
        }
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onNetworkQuality(tRTCQuality, arrayList);
        }
    }

    public void onPreprocessVideoFrame(int i, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2) {
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null && tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onProcessVideoFrame(tRTCVideoFrame, tRTCVideoFrame2);
        }
    }

    public void onRecvCustomCmdMsg(String str, int i, int i2, byte[] bArr) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRecvCustomCmdMsg(str, i, i2, bArr);
        }
    }

    public void onRemoteAudioStatusUpdated(String str, int i, int i2) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRemoteAudioStatusUpdated(str, i, i2, null);
        }
    }

    public void onRemoteVideoStatusUpdated(String str, int i, int i2, int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRemoteVideoStatusUpdated(str, i, i2, i3, null);
        }
    }

    public void onRenderVideoFrame(String str, int i, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener;
        if (TextUtils.isEmpty(str)) {
            str = this.mLocalUserId;
            tRTCVideoRenderListener = this.mLocalVideoRenderListenerWrapper.d;
        } else {
            a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mRemoteVideoRenderListenerMap.get(str);
            if (aVar == null) {
                tRTCVideoRenderListener = null;
            } else {
                tRTCVideoRenderListener = aVar.d;
            }
        }
        if (tRTCVideoRenderListener != null) {
            tRTCVideoRenderListener.onRenderVideoFrame(str, i, tRTCVideoFrame);
        }
    }

    public void onSEIMessageReceived(byte[] bArr, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRecvSEIMsg(str, bArr);
        }
    }

    void onScreenCapturePaused() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onScreenCapturePaused();
        }
    }

    void onScreenCaptureResumed() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onScreenCaptureResumed();
        }
    }

    void onScreenCaptureStarted() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onScreenCaptureStarted();
        }
    }

    void onScreenCaptureStopped(int i) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onScreenCaptureStopped(i);
        }
    }

    void onSendFirstLocalAudioFrame() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSendFirstLocalAudioFrame();
        }
    }

    void onSendFirstLocalVideoFrame(int i) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSendFirstLocalVideoFrame(i);
        }
    }

    void onSetMixTranscodingConfig(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSetMixTranscodingConfig(i, str);
        }
    }

    public void onSnapshotComplete(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        runOnListenerThread(d.a(tRTCSnapshotListener, bitmap));
    }

    public void onSpeedTest(SpeedTestResult speedTestResult, int i, int i2) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSpeedTest(speedTestResult.a, i, i2);
        }
    }

    public void onSpeedTestResult(SpeedTestResult speedTestResult) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSpeedTestResult(speedTestResult.a);
        }
    }

    void onStartPublishCDNStream(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStartPublishCDNStream(i, str);
        }
    }

    public void onStartPublishMediaStream(String str, int i, String str2, String str3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStartPublishMediaStream(str, i, str2, extraToBundle(str3));
        }
    }

    void onStartPublishing(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStartPublishing(i, str);
        }
    }

    public void onStatistics(Statistics statistics) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStatistics(statistics.a);
        }
    }

    void onStopPublishCDNStream(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStopPublishCDNStream(i, str);
        }
    }

    public void onStopPublishMediaStream(String str, int i, String str2, String str3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStopPublishMediaStream(str, i, str2, extraToBundle(str3));
        }
    }

    void onStopPublishing(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onStopPublishing(i, str);
        }
    }

    public void onSwitchRole(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSwitchRole(i, str);
        }
    }

    public void onSwitchRoom(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onSwitchRoom(i, str);
        }
    }

    void onTryToReconnect() {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onTryToReconnect();
        }
    }

    public void onUpdateOtherRoomForwardMode(int i, String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUpdateOtherRoomForwardMode(i, str);
        }
    }

    public void onUpdatePublishMediaStream(String str, int i, String str2, String str3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUpdatePublishMediaStream(str, i, str2, extraToBundle(str3));
        }
    }

    void onUserAudioAvailable(String str, boolean z) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserAudioAvailable(str, z);
        }
    }

    public void onUserEnter(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserEnter(str);
        }
    }

    public void onUserExit(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserExit(str, 0);
        }
    }

    public void onUserOffline(String str, int i) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRemoteUserLeaveRoom(str, i);
        }
    }

    public void onUserOnline(String str) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onRemoteUserEnterRoom(str);
        }
    }

    void onUserSubStreamAvailable(String str, boolean z) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserSubStreamAvailable(str, z);
        }
    }

    void onUserVideoAvailable(String str, boolean z) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserVideoAvailable(str, z);
        }
    }

    public void onUserVideoSizeChanged(String str, int i, int i2, int i3) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onUserVideoSizeChanged(str, i, i2, i3);
        }
    }

    public void onUserVoiceVolume(String[] strArr, int[] iArr, int[] iArr2, float[] fArr, float[][] fArr2, int i) {
        String str;
        if (strArr != null && iArr != null) {
            if (strArr.length == iArr.length) {
                ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
                    if (strArr[i2].isEmpty() && (str = this.mLocalUserId) != null && !str.isEmpty()) {
                        tRTCVolumeInfo.userId = this.mLocalUserId;
                    } else {
                        tRTCVolumeInfo.userId = strArr[i2];
                    }
                    tRTCVolumeInfo.volume = iArr[i2];
                    tRTCVolumeInfo.vad = iArr2[i2];
                    tRTCVolumeInfo.pitch = fArr[i2];
                    tRTCVolumeInfo.spectrumData = fArr2[i2];
                    arrayList.add(tRTCVolumeInfo);
                }
                Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
                while (it.hasNext()) {
                    it.next().onUserVoiceVolume(arrayList, i);
                }
                return;
            }
            throw new IllegalArgumentException("Invalid parameter, userIds and volumes do not match.");
        }
    }

    public void onWarning(int i, String str, Bundle bundle) {
        Iterator<TRTCCloudListener> it = CopyOnReadListeners().iterator();
        while (it.hasNext()) {
            it.next().onWarning(i, str, bundle);
        }
    }

    public void pauseScreenCapture(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativePauseScreenCapture(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void removeListener(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener != null && this.mListenerList.contains(tRTCCloudListener)) {
            this.mListenerList.remove(tRTCCloudListener);
        }
    }

    public void resumeScreenCapture(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeResumeScreenCapture(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSendCustomAudioData(j, new AudioFrame(tRTCAudioFrame));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendCustomCmdMsg(int i, byte[] bArr, boolean z, boolean z2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                return nativeSendCustomCmdMsg(j, i, bArr, z, z2);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomVideoData(int i, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        Object obj;
        int i2;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame.texture;
                if (tRTCTexture != null) {
                    int i3 = tRTCTexture.textureId;
                    Object obj2 = tRTCTexture.eglContext10;
                    if (obj2 == null) {
                        obj2 = tRTCTexture.eglContext14;
                    }
                    i2 = i3;
                    obj = obj2;
                } else {
                    obj = null;
                    i2 = -1;
                }
                nativeSendCustomVideoData(j, i, tRTCVideoFrame.pixelFormat, tRTCVideoFrame.bufferType, obj, i2, tRTCVideoFrame.width, tRTCVideoFrame.height, covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation).mValue, tRTCVideoFrame.timestamp, tRTCVideoFrame.data, tRTCVideoFrame.buffer);
            }
            this.mJniReadLock.unlock();
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public boolean sendSEIMsg(byte[] bArr, int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                return nativeSendSEIMsg(j, bArr, i);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void set3DSpatialReceivingRange(String str, int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSet3DSpatialReceivingRange(j, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioCaptureVolume(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetAudioCaptureVolume(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        boolean z;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                this.mAudioFrameListener = tRTCAudioFrameListener;
                if (tRTCAudioFrameListener != null) {
                    z = true;
                } else {
                    z = false;
                }
                nativeEnableAudioFrameNotification(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioPlayoutVolume(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetAudioPlayoutVolume(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioQuality(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetAudioQuality(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setCapturedAudioFrameCallbackFormat(int i, int i2, int i3, int i4) {
        int i5;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                i5 = nativeSetCapturedAudioFrameCallbackFormat(j, i, i2, i3, i4);
            } else {
                i5 = 0;
            }
            return i5;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setDefaultStreamRecvMode(boolean z, boolean z2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetDefaultStreamRecvMode(j, z, z2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setGSensorMode(int i, int i2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetGSensorMode(j, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setGravitySensorAdaptiveMode(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetGravitySensorAdaptiveMode(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setListener(TRTCCloudListener tRTCCloudListener) {
        this.mListener = tRTCCloudListener;
    }

    public void setListenerHandler(Handler handler) {
        this.mJniReadLock.lock();
        if (handler == null) {
            this.mListenerHandler = new Handler(Looper.getMainLooper());
        } else {
            this.mListenerHandler = handler;
        }
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetListenerHandler(j, handler);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setLocalProcessedAudioFrameCallbackFormat(int i, int i2, int i3, int i4) {
        int i5;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                i5 = nativeSetLocalProcessedAudioFrameCallbackFormat(j, i, i2, i3, i4);
            } else {
                i5 = 0;
            }
            return i5;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setLocalVideoProcessListener(int i, int i2, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                if (!isCustomPreprocessSupportedFormatType(i)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                }
                if (!isCustomPreprocessSupportedBufferType(i2)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                }
                synchronized (this.mVideoFrameListenerWrapper) {
                    try {
                        a<TRTCCloudListener.TRTCVideoFrameListener> aVar = this.mVideoFrameListenerWrapper;
                        if (aVar.d != null) {
                            nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, false, aVar.b, aVar.c);
                        }
                        a<TRTCCloudListener.TRTCVideoFrameListener> aVar2 = this.mVideoFrameListenerWrapper;
                        aVar2.d = tRTCVideoFrameListener;
                        aVar2.a = 0;
                        aVar2.b = i;
                        aVar2.c = i2;
                        if (tRTCVideoFrameListener != 0) {
                            nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, true, i, i2);
                        }
                    } finally {
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setLocalVideoRenderListener(int i, int i2, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                if (!isCustomRenderSupportedFormatType(i)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                }
                if (!isCustomRenderSupportedBufferType(i2)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                }
                synchronized (this.mLocalVideoRenderListenerWrapper) {
                    try {
                        a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mLocalVideoRenderListenerWrapper;
                        if (aVar.d != null) {
                            int i3 = aVar.b;
                            if (i3 == i && aVar.c == i2 && tRTCVideoRenderListener != 0) {
                                aVar.d = tRTCVideoRenderListener;
                            }
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, "", 0, i3, aVar.c);
                            long j = this.mNativeTrtcCloudJni;
                            a<TRTCCloudListener.TRTCVideoRenderListener> aVar2 = this.mLocalVideoRenderListenerWrapper;
                            nativeEnableVideoCustomRender(j, false, "", 2, aVar2.b, aVar2.c);
                        }
                        a<TRTCCloudListener.TRTCVideoRenderListener> aVar3 = this.mLocalVideoRenderListenerWrapper;
                        aVar3.d = tRTCVideoRenderListener;
                        aVar3.b = i;
                        aVar3.c = i2;
                        if (tRTCVideoRenderListener != 0) {
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, "", 0, i, i2);
                            long j2 = this.mNativeTrtcCloudJni;
                            a<TRTCCloudListener.TRTCVideoRenderListener> aVar4 = this.mLocalVideoRenderListenerWrapper;
                            nativeEnableVideoCustomRender(j2, true, "", 2, aVar4.b, aVar4.c);
                        }
                    } finally {
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewFillMode(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetLocalViewFillMode(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewMirror(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetLocalViewMirror(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewRotation(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetLocalViewRotation(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixExternalAudioVolume(int i, int i2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetMixExternalAudioVolume(j, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        TranscodingConfig transcodingConfig;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                if (tRTCTranscodingConfig == null) {
                    transcodingConfig = null;
                } else {
                    transcodingConfig = new TranscodingConfig(tRTCTranscodingConfig);
                }
                nativeSetMixTranscodingConfig(j, transcodingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setMixedPlayAudioFrameCallbackFormat(int i, int i2, int i3, int i4) {
        int i5;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                i5 = nativeSetMixedPlayAudioFrameCallbackFormat(j, i, i2, i3, i4);
            } else {
                i5 = 0;
            }
            return i5;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCNetworkQosParam != null) {
                nativeSetNetworkQosParam(j, tRTCNetworkQosParam.preference, tRTCNetworkQosParam.controlMode);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2) {
        List asList;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                List list = null;
                if (pointFArr == null) {
                    asList = null;
                } else {
                    asList = Arrays.asList(pointFArr);
                }
                float[] a2 = f.a(asList);
                if (pointFArr2 != null) {
                    list = Arrays.asList(pointFArr2);
                }
                nativeSetPerspectiveCorrectionPoints(j, str, a2, f.a(list));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setPriorRemoteVideoStreamType(int i) {
        long j = this.mNativeTrtcCloudJni;
        if (j != 0) {
            nativeSetPriorRemoteVideoStreamType(j, i);
            return 0;
        }
        return 0;
    }

    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCAudioParallelParams != null) {
                nativeSetRemoteAudioParallelParams(j, new AudioParallelParams(tRTCAudioParallelParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteAudioVolume(String str, int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetRemoteAudioVolume(j, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setRemoteVideoRenderListener(String str, int i, int i2, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        this.mJniReadLock.lock();
        try {
            byte b = 0;
            if (this.mNativeTrtcCloudJni != 0) {
                if (TextUtils.isEmpty(str)) {
                    this.mJniReadLock.unlock();
                    return -3319;
                }
                if (!isCustomRenderSupportedFormatType(i)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                }
                if (!isCustomRenderSupportedBufferType(i2)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                }
                synchronized (this.mRemoteVideoRenderListenerMap) {
                    try {
                        a<TRTCCloudListener.TRTCVideoRenderListener> aVar = this.mRemoteVideoRenderListenerMap.get(str);
                        if (aVar != null) {
                            int i3 = aVar.b;
                            if (i3 == i && aVar.c == i2 && tRTCVideoRenderListener != 0) {
                                aVar.d = tRTCVideoRenderListener;
                                this.mRemoteVideoRenderListenerMap.put(str, aVar);
                            }
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 0, i3, aVar.c);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, false, str, 2, aVar.b, aVar.c);
                        }
                        if (tRTCVideoRenderListener != 0) {
                            a<TRTCCloudListener.TRTCVideoRenderListener> aVar2 = new a<>(b);
                            aVar2.d = tRTCVideoRenderListener;
                            aVar2.b = i;
                            aVar2.c = i2;
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, str, 0, i, i2);
                            nativeEnableVideoCustomRender(this.mNativeTrtcCloudJni, true, str, 2, aVar2.b, aVar2.c);
                            this.mRemoteVideoRenderListenerMap.put(str, aVar2);
                        } else {
                            this.mRemoteVideoRenderListenerMap.remove(str);
                        }
                    } finally {
                    }
                }
            }
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setRemoteVideoStreamType(String str, int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetRemoteVideoStreamType(j, str, i);
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void setRemoteViewFillMode(String str, int i, int i2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetRemoteViewFillMode(j, str, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewMirror(String str, int i, int i2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetRemoteViewMirror(j, str, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewRotation(String str, int i, int i2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetRemoteViewRotation(j, str, i, i2);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderMirror(boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetVideoEncoderMirror(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderParams(int i, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCVideoEncParam != null) {
                nativeSetVideoEncoderParams(j, i, new VideoEncParams(tRTCVideoEncParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderRotation(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetVideoEncoderRotation(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoMuteImage(Bitmap bitmap, int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetVideoMuteImage(j, bitmap, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setWatermark(Bitmap bitmap, int i, float f, float f2, float f3) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSetWatermark(j, bitmap, i, f, f2, f3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void showDashboardManager(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeShowDashboardManager(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void snapshotVideo(String str, int i, int i2, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSnapshotVideo(j, str, i, i2, tRTCSnapshotListener);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCAudioRecordingParams != null) {
                return nativeStartAudioRecording(j, new AudioRecordingParams(tRTCAudioRecordingParams));
            }
            this.mJniReadLock.unlock();
            return 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalAudio(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStartLocalAudioWithQuality(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalPreview(boolean z, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStartLocalPreview(j, z, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCLocalRecordingParams != null) {
                nativeStartLocalRecording(j, new LocalRecordingParams(tRTCLocalRecordingParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCPublishCDNParam != null) {
                nativeStartPublishCDNStream(j, new PublishCDNParams(tRTCPublishCDNParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        PublishTarget publishTarget;
        StreamEncoderParam streamEncoderParam;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                StreamMixingConfig streamMixingConfig = null;
                if (tRTCPublishTarget == null) {
                    publishTarget = null;
                } else {
                    publishTarget = new PublishTarget(tRTCPublishTarget);
                }
                if (tRTCStreamEncoderParam == null) {
                    streamEncoderParam = null;
                } else {
                    streamEncoderParam = new StreamEncoderParam(tRTCStreamEncoderParam);
                }
                if (tRTCStreamMixingConfig != null) {
                    streamMixingConfig = new StreamMixingConfig(tRTCStreamMixingConfig);
                }
                nativeStartPublishMediaStream(j, publishTarget, streamEncoderParam, streamMixingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishing(String str, int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStartPublishing(j, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, int i, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStartRemoteView(j, str, i, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startScreenCapture(int i, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        ScreenShareParams screenShareParams;
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                if (tRTCScreenShareParams != null) {
                    screenShareParams = new ScreenShareParams(tRTCScreenShareParams);
                } else {
                    screenShareParams = null;
                }
                if (tRTCVideoEncParam == null) {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i, null, screenShareParams);
                    LiteavLog.w(TAG, "startScreenCapture encParams is null");
                } else {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i, new VideoEncParams(tRTCVideoEncParam), screenShareParams);
                }
            }
            this.mJniReadLock.unlock();
            if (tRTCScreenShareParams != null) {
                ThreadUtils.runOnUiThread(b.a(this, tRTCScreenShareParams));
            }
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCSpeedTestParams != null) {
                nativeStartSpeedTest(j, new SpeedTestParams(tRTCSpeedTestParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStartSystemAudioLoopback(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAllRemoteView() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopAllRemoteView(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAudioRecording() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopAudioRecording(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalAudio() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopLocalAudio(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalPreview() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopLocalPreview(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalRecording() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopLocalRecording(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishCDNStream() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopPublishCDNStream(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishMediaStream(String str) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopPublishMediaStream(j, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishing() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopPublishing(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str, int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopRemoteView(j, str, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopScreenCapture(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopScreenCapture(j, i);
            }
            this.mJniReadLock.unlock();
            ThreadUtils.runOnUiThread(c.a(this));
        } catch (Throwable th) {
            this.mJniReadLock.unlock();
            throw th;
        }
    }

    public void stopSpeedTest() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopSpeedTest(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopSystemAudioLoopback(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSwitchRole(j, i);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && tRTCSwitchRoomConfig != null) {
                nativeSwitchRoom(j, new SwitchRoomConfig(tRTCSwitchRoomConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeUpdateLocalView(j, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateOtherRoomForwardMode(String str) {
        long j = this.mNativeTrtcCloudJni;
        if (j != 0) {
            nativeUpdateOtherRoomForwardMode(j, str);
        }
    }

    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        PublishTarget publishTarget;
        StreamEncoderParam streamEncoderParam;
        StreamMixingConfig streamMixingConfig;
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                if (tRTCPublishTarget == null) {
                    publishTarget = null;
                } else {
                    publishTarget = new PublishTarget(tRTCPublishTarget);
                }
                if (tRTCStreamEncoderParam == null) {
                    streamEncoderParam = null;
                } else {
                    streamEncoderParam = new StreamEncoderParam(tRTCStreamEncoderParam);
                }
                if (tRTCStreamMixingConfig == null) {
                    streamMixingConfig = null;
                } else {
                    streamMixingConfig = new StreamMixingConfig(tRTCStreamMixingConfig);
                }
                nativeUpdatePublishMediaStream(j, str, publishTarget, streamEncoderParam, streamMixingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && iArr != null) {
                nativeUpdateRemote3DSpatialPosition(j, str, iArr);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemoteView(String str, int i, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeUpdateRemoteView(j, str, i, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0 && iArr != null && fArr != null && fArr2 != null && fArr3 != null) {
                nativeUpdateSelf3DSpatialPosition(j, iArr, fArr, fArr2, fArr3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public TrtcCloudJni(long j, boolean z) {
        this.mNativeTrtcCloudJni = 0L;
        this.mLocalUserId = "";
        this.mListenerList = new CopyOnWriteArrayList();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mFloatingWindowSet = new HashSet<>();
        if (j == 0) {
            this.mNativeTrtcCloudJni = nativeCreatePipeline(this, z);
        } else {
            this.mNativeTrtcCloudJni = nativeCreateSubCloud(this, j);
        }
        byte b = 0;
        this.mVideoFrameListenerWrapper = new a<>(b);
        this.mLocalVideoRenderListenerWrapper = new a<>(b);
        this.mRemoteVideoRenderListenerMap = new HashMap();
        this.mListenerHandler = new Handler(Looper.getMainLooper());
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class SpeedTestParams {
        private final TRTCCloudDef.TRTCSpeedTestParams a;
        private final boolean b;

        public SpeedTestParams(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
            this.a = tRTCSpeedTestParams;
            this.b = false;
        }

        public int getExpectedDownBandwidth() {
            return this.a.expectedDownBandwidth;
        }

        public int getExpectedUpBandwidth() {
            return this.a.expectedUpBandwidth;
        }

        public boolean getIsCalledFromDeprecatedApi() {
            return this.b;
        }

        public int getSDKAppId() {
            return this.a.sdkAppId;
        }

        public int getScene() {
            return this.a.scene;
        }

        public String getUserId() {
            return this.a.userId;
        }

        public String getUserSig() {
            return this.a.userSig;
        }

        public SpeedTestParams(int i, String str, String str2) {
            TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams = new TRTCCloudDef.TRTCSpeedTestParams();
            this.a = tRTCSpeedTestParams;
            tRTCSpeedTestParams.sdkAppId = i;
            tRTCSpeedTestParams.userId = str;
            tRTCSpeedTestParams.userSig = str2;
            tRTCSpeedTestParams.scene = 1;
            this.b = true;
        }
    }

    public void startLocalAudio() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStartLocalAudio(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStartRemoteViewWithoutStreamType(j, str, tXCloudVideoView);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSpeedTest(int i, String str, String str2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStartSpeedTest(j, new SpeedTestParams(i, str, str2));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeStopRemoteViewWithoutStreamType(j, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i, String str) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeTrtcCloudJni;
            if (j != 0) {
                nativeSwitchRoleWithPrivateMapKey(j, i, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}
