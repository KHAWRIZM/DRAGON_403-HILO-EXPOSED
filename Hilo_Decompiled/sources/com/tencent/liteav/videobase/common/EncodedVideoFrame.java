package com.tencent.liteav.videobase.common;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class EncodedVideoFrame {
    private static final String TAG = "EncodedVideoFrame";
    public ByteBuffer data;
    public long dts;
    public int height;
    public long pts;
    public int rotation;
    public MediaFormat videoFormat;
    public int width;
    public final ProducerChainTimestamp producerChainTimestamp = new ProducerChainTimestamp();
    public final ConsumerChainTimestamp consumerChainTimestamp = new ConsumerChainTimestamp();
    public long nativePtr = 0;
    public c nalType = c.UNKNOWN;
    public d profileType = d.UNKNOWN;
    public CodecType codecType = CodecType.H264;
    public long gopIndex = 0;
    public long gopFrameIndex = 0;
    public long frameIndex = 0;
    public long refFrameIndex = 0;
    public Integer svcInfo = null;
    public boolean isEosFrame = false;
    public b hdrType = b.UNKNOWN;
    public MediaCodec.BufferInfo info = null;

    public static EncodedVideoFrame createEncodedVideoFrame(ByteBuffer byteBuffer, int i, int i2, int i3, long j, long j2, long j3, long j4, long j5, long j6, int i4, long j7, int i5, int i6, boolean z, int i7, int i8) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.data = byteBuffer;
        encodedVideoFrame.nativePtr = j7;
        encodedVideoFrame.nalType = c.a(i);
        encodedVideoFrame.profileType = d.a(i2);
        encodedVideoFrame.codecType = CodecType.a(i4);
        encodedVideoFrame.rotation = i3;
        encodedVideoFrame.dts = j;
        encodedVideoFrame.pts = j2;
        encodedVideoFrame.gopIndex = j3;
        encodedVideoFrame.gopFrameIndex = j4;
        encodedVideoFrame.frameIndex = j5;
        encodedVideoFrame.refFrameIndex = j6;
        encodedVideoFrame.info = null;
        encodedVideoFrame.width = i5;
        encodedVideoFrame.height = i6;
        if (z) {
            encodedVideoFrame.svcInfo = Integer.valueOf(i7);
        } else {
            encodedVideoFrame.svcInfo = null;
        }
        encodedVideoFrame.hdrType = b.a(i8);
        return encodedVideoFrame;
    }

    private c getNalTypeFromH264NALHeader(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.get(i) & 31;
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    if (i2 != 8) {
                        return c.UNKNOWN;
                    }
                    return c.PPS;
                }
                return c.SPS;
            }
            return c.SEI;
        }
        return c.IDR;
    }

    private c getNalTypeFromH265NALHeader(ByteBuffer byteBuffer, int i) {
        int i2 = (byteBuffer.get(i) & 126) >> 1;
        if (i2 != 39) {
            switch (i2) {
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    return c.IDR;
                default:
                    switch (i2) {
                        case 32:
                            return c.VPS;
                        case 33:
                            return c.SPS;
                        case 34:
                            return c.PPS;
                        default:
                            return c.UNKNOWN;
                    }
            }
        }
        return c.SEI;
    }

    public static int getNextNALHeaderPos(int i, ByteBuffer byteBuffer) {
        while (true) {
            int i2 = i + 3;
            if (i2 < byteBuffer.remaining()) {
                if (byteBuffer.get(i) == 0 && byteBuffer.get(i + 1) == 0 && byteBuffer.get(i + 2) == 0 && byteBuffer.get(i2) == 1) {
                    return i + 4;
                }
                if (byteBuffer.get(i) == 0 && byteBuffer.get(i + 1) == 0 && byteBuffer.get(i + 2) == 1) {
                    return i2;
                }
                i++;
            } else {
                return -1;
            }
        }
    }

    private native void nativeRelease(long j);

    public static long resetEncodedVideoFrame(EncodedVideoFrame encodedVideoFrame) {
        long j = encodedVideoFrame.nativePtr;
        if (j == 0 || encodedVideoFrame.data == null) {
            return 0L;
        }
        encodedVideoFrame.data = null;
        encodedVideoFrame.nativePtr = 0L;
        return j;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativePtr != 0) {
            LiteavLog.w(TAG, "nativePtr != 0, must call release before finalize ");
            release();
        }
    }

    public boolean isH265() {
        if (this.codecType == CodecType.H265) {
            return true;
        }
        return false;
    }

    public boolean isHDRFrame() {
        b bVar = this.hdrType;
        if (bVar != null && bVar != b.UNKNOWN) {
            return true;
        }
        return false;
    }

    public boolean isIDRFrame() {
        c cVar = this.nalType;
        if (cVar != null && cVar == c.IDR) {
            return true;
        }
        return false;
    }

    public boolean isRPSEnable() {
        d dVar = this.profileType;
        if (dVar != d.BASELINE_RPS && dVar != d.MAIN_RPS && dVar != d.HIGH_RPS) {
            return false;
        }
        return true;
    }

    public boolean isSVCEnable() {
        if (this.svcInfo != null) {
            return true;
        }
        return false;
    }

    public boolean isValidFrame() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null && byteBuffer.remaining() > 0 && this.nalType != null && this.codecType != null && this.width > 0 && this.height > 0) {
            return true;
        }
        return false;
    }

    public void release() {
        long j = this.nativePtr;
        if (j != 0) {
            nativeRelease(j);
            this.nativePtr = 0L;
        }
    }

    public String toString() {
        return "nalType = " + this.nalType + ", profiletype=" + this.profileType + ", rotation=" + this.rotation + ", codecType=" + this.codecType + ", dts=" + this.dts + ", pts=" + this.pts + ", gopIndex=" + this.gopIndex + ", gopFrameIndex=" + this.gopFrameIndex + ", frameIndex=" + this.frameIndex;
    }

    public void updateNALTypeAccordingNALHeader() {
        c nalTypeFromH264NALHeader;
        if (this.data != null) {
            c cVar = this.nalType;
            if (cVar == null || cVar == c.UNKNOWN) {
                int i = 0;
                while (true) {
                    i = getNextNALHeaderPos(i, this.data);
                    if (i != -1 && i < this.data.remaining()) {
                        c cVar2 = c.UNKNOWN;
                        if (isH265()) {
                            nalTypeFromH264NALHeader = getNalTypeFromH265NALHeader(this.data, i);
                        } else {
                            nalTypeFromH264NALHeader = getNalTypeFromH264NALHeader(this.data, i);
                        }
                        c cVar3 = this.nalType;
                        if (cVar3 == null || cVar3 == c.UNKNOWN || nalTypeFromH264NALHeader == c.IDR) {
                            this.nalType = nalTypeFromH264NALHeader;
                        }
                        c cVar4 = this.nalType;
                        if (cVar4 != c.SPS && cVar4 != c.PPS && cVar4 != c.VPS && cVar4 != c.SEI) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
