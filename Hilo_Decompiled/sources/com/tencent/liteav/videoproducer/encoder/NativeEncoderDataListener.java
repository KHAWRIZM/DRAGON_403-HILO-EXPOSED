package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NativeEncoderDataListener extends VideoEncoderDef.b {
    public static final String TAG = "NativeEncoderDataListener";
    private long mNativeVideoEncodeDataListener;
    private int mStreamType;

    public NativeEncoderDataListener(long j, int i) {
        this.mNativeVideoEncodeDataListener = j;
        this.mStreamType = i;
    }

    private native void nativeOnEncodedFail(long j, int i, int i2);

    private native void nativeOnEncodedNAL(long j, int i, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, ProducerChainTimestamp producerChainTimestamp, int i2, int i3, int i4, int i5, long j2, long j3, long j4, long j5, long j6, long j7, int i6, int i7, boolean z, int i8);

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
    public synchronized void onEncodedFail(e.a aVar) {
        long j = this.mNativeVideoEncodeDataListener;
        if (j != 0) {
            nativeOnEncodedFail(j, this.mStreamType, com.tencent.liteav.videobase.videobase.e.a(aVar));
        } else {
            LiteavLog.i(TAG, "onEncodedFail nativeclient is zero.");
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
    public synchronized void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z) {
        boolean z2;
        int intValue;
        long j = this.mNativeVideoEncodeDataListener;
        if (j != 0 && !z) {
            int i = this.mStreamType;
            ByteBuffer byteBuffer = encodedVideoFrame.data;
            ProducerChainTimestamp producerChainTimestamp = encodedVideoFrame.producerChainTimestamp;
            int i2 = encodedVideoFrame.nalType.mValue;
            int i3 = encodedVideoFrame.profileType.mValue;
            int i4 = encodedVideoFrame.codecType.mValue;
            int i5 = encodedVideoFrame.rotation;
            long j2 = encodedVideoFrame.dts;
            long j3 = encodedVideoFrame.pts;
            long j4 = encodedVideoFrame.gopIndex;
            long j5 = encodedVideoFrame.gopFrameIndex;
            long j6 = encodedVideoFrame.frameIndex;
            long j7 = encodedVideoFrame.refFrameIndex;
            int i6 = encodedVideoFrame.width;
            int i7 = encodedVideoFrame.height;
            Integer num = encodedVideoFrame.svcInfo;
            if (num != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            nativeOnEncodedNAL(j, i, encodedVideoFrame, byteBuffer, producerChainTimestamp, i2, i3, i4, i5, j2, j3, j4, j5, j6, j7, i6, i7, z2, intValue);
            return;
        }
        LiteavLog.d(TAG, "onEncodedNAL mNativeVideoEncodeDataListener=%d,isEos=%b", Long.valueOf(j), Boolean.valueOf(z));
    }

    public synchronized void reset() {
        this.mNativeVideoEncodeDataListener = 0L;
    }
}
