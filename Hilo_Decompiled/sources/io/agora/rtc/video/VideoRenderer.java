package io.agora.rtc.video;

import com.facebook.internal.security.CertificateUtil;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoRenderer {
    long nativeVideoRenderer;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface Callbacks {
        void renderFrame(I420Frame i420Frame);
    }

    public VideoRenderer(Callbacks callbacks) {
        this.nativeVideoRenderer = nativeWrapVideoRenderer(callbacks);
    }

    private static native void freeWrappedVideoRenderer(long j10);

    public static native void nativeCopyPlane(ByteBuffer byteBuffer, int i10, int i11, int i12, ByteBuffer byteBuffer2, int i13);

    private static native long nativeWrapVideoRenderer(Callbacks callbacks);

    private static native void releaseNativeFrame(long j10);

    public static void renderFrameDone(I420Frame i420Frame) {
        i420Frame.yuvPlanes = null;
        i420Frame.textureId = 0;
        if (i420Frame.nativeFramePointer != 0) {
            releaseNativeFrame(i420Frame.nativeFramePointer);
            i420Frame.nativeFramePointer = 0L;
        }
    }

    public void dispose() {
        long j10 = this.nativeVideoRenderer;
        if (j10 == 0) {
            return;
        }
        freeWrappedVideoRenderer(j10);
        this.nativeVideoRenderer = 0L;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class I420Frame {
        public final int height;
        private long nativeFramePointer;
        public int rotationDegree;
        public final float[] samplingMatrix;
        public int textureId;
        public final int width;
        public final boolean yuvFrame;
        public ByteBuffer[] yuvPlanes;
        public final int[] yuvStrides;

        I420Frame(int i10, int i11, int i12, int[] iArr, ByteBuffer[] byteBufferArr, long j10) {
            this.width = i10;
            this.height = i11;
            this.yuvStrides = iArr;
            this.yuvPlanes = byteBufferArr;
            this.yuvFrame = true;
            this.rotationDegree = i12;
            this.nativeFramePointer = j10;
            if (i12 % 90 == 0) {
                this.samplingMatrix = new float[]{1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, -1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f};
                return;
            }
            throw new IllegalArgumentException("Rotation degree not multiple of 90: " + i12);
        }

        public int rotatedHeight() {
            if (this.rotationDegree % 180 == 0) {
                return this.height;
            }
            return this.width;
        }

        public int rotatedWidth() {
            if (this.rotationDegree % 180 == 0) {
                return this.width;
            }
            return this.height;
        }

        public String toString() {
            return this.width + "x" + this.height + CertificateUtil.DELIMITER + this.yuvStrides[0] + CertificateUtil.DELIMITER + this.yuvStrides[1] + CertificateUtil.DELIMITER + this.yuvStrides[2];
        }

        I420Frame(int i10, int i11, int i12, int i13, float[] fArr, long j10) {
            this.width = i10;
            this.height = i11;
            this.yuvStrides = null;
            this.yuvPlanes = null;
            this.samplingMatrix = fArr;
            this.textureId = i13;
            this.yuvFrame = false;
            this.rotationDegree = i12;
            this.nativeFramePointer = j10;
            if (i12 % 90 == 0) {
                return;
            }
            throw new IllegalArgumentException("Rotation degree not multiple of 90: " + i12);
        }
    }
}
