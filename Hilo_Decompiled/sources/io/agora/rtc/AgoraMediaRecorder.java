package io.agora.rtc;

import io.agora.rtc.internal.Logging;
import io.agora.rtc.internal.RtcEngineImpl;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AgoraMediaRecorder {
    public static final int CONTAINER_MP4 = 1;
    public static final int RECORDER_ERROR_CONFIG_CHANGED = 4;
    public static final int RECORDER_ERROR_CUSTOM_STREAM_DETECTED = 5;
    public static final int RECORDER_ERROR_NONE = 0;
    public static final int RECORDER_ERROR_NO_STREAM = 2;
    public static final int RECORDER_ERROR_OVER_MAX_DURATION = 3;
    public static final int RECORDER_ERROR_WRITE_FAILED = 1;
    public static final int RECORDER_STATE_ERROR = -1;
    public static final int RECORDER_STATE_START = 2;
    public static final int RECORDER_STATE_STOP = 3;
    public static final int STREAM_TYPE_AUDIO = 1;
    public static final int STREAM_TYPE_BOTH = 3;
    public static final int STREAM_TYPE_VIDEO = 2;
    private static volatile AgoraMediaRecorder mRecorder;
    WeakReference<RtcEngineImpl> mEngineReference;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface IMediaRecorderCallback {
        void onRecorderInfoUpdated(RecorderInfo recorderInfo);

        void onRecorderStateChanged(int i10, int i11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class MediaRecorderConfiguration {
        public int containerFormat;
        public int maxDurationMs;
        public int recorderInfoUpdateInterval;
        public String storagePath;
        public int streamType;

        public MediaRecorderConfiguration(String str, int i10, int i11, int i12, int i13) {
            this.storagePath = str;
            this.containerFormat = i10;
            this.streamType = i11;
            this.maxDurationMs = i12;
            this.recorderInfoUpdateInterval = i13;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class RecorderInfo {
        public int durationMs;
        public String fileName;
        public int fileSize;

        public RecorderInfo(String str, int i10, int i11) {
            this.fileName = str;
            this.durationMs = i10;
            this.fileSize = i11;
        }
    }

    private AgoraMediaRecorder(RtcEngineImpl rtcEngineImpl) {
        this.mEngineReference = new WeakReference<>(rtcEngineImpl);
    }

    public static AgoraMediaRecorder getMediaRecorder(RtcEngine rtcEngine, IMediaRecorderCallback iMediaRecorderCallback) {
        RtcEngineImpl rtcEngineImpl = (RtcEngineImpl) rtcEngine;
        if (rtcEngineImpl.getMediaRecorder(iMediaRecorderCallback) != 0) {
            Logging.e("getMediaRecorder failed, please ensure the RtcEngine has been initialized and already join the channel");
            return null;
        }
        if (mRecorder == null) {
            synchronized (AgoraMediaRecorder.class) {
                try {
                    if (mRecorder == null) {
                        mRecorder = new AgoraMediaRecorder(rtcEngineImpl);
                    }
                } finally {
                }
            }
        } else {
            mRecorder.setEngine(rtcEngineImpl);
        }
        return mRecorder;
    }

    private void setEngine(RtcEngineImpl rtcEngineImpl) {
        this.mEngineReference = new WeakReference<>(rtcEngineImpl);
    }

    public void release() {
        RtcEngineImpl rtcEngineImpl;
        WeakReference<RtcEngineImpl> weakReference = this.mEngineReference;
        if (weakReference != null && (rtcEngineImpl = weakReference.get()) != null) {
            rtcEngineImpl.releaseRecorder();
        }
        this.mEngineReference = null;
    }

    public int startRecording(MediaRecorderConfiguration mediaRecorderConfiguration) {
        RtcEngineImpl rtcEngineImpl;
        WeakReference<RtcEngineImpl> weakReference = this.mEngineReference;
        if (weakReference != null && (rtcEngineImpl = weakReference.get()) != null) {
            return rtcEngineImpl.startRecording(mediaRecorderConfiguration.storagePath, mediaRecorderConfiguration.containerFormat, mediaRecorderConfiguration.streamType, mediaRecorderConfiguration.maxDurationMs, mediaRecorderConfiguration.recorderInfoUpdateInterval);
        }
        this.mEngineReference = null;
        return -7;
    }

    public int stopRecording() {
        RtcEngineImpl rtcEngineImpl;
        WeakReference<RtcEngineImpl> weakReference = this.mEngineReference;
        if (weakReference != null && (rtcEngineImpl = weakReference.get()) != null) {
            return rtcEngineImpl.stopRecording();
        }
        this.mEngineReference = null;
        return -7;
    }
}
