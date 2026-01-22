package io.agora.rtc.video;

import android.R;
import android.app.Activity;
import android.view.ViewGroup;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.mediaio.AgoraSurfaceView;
import io.agora.rtc.mediaio.MediaIO;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class AgoraVideoDebugger {
    public static final boolean DIRECT_OES = false;
    public static final boolean ENABLE_DEBUG = false;
    public static final String TAG = "AgoraVideoDebugger";
    public static final boolean VERBOSE = false;
    public static final boolean VERBOSE_DETAIL = false;
    static DebugViewHolder capturePreviewHolder;
    static int droppedTextureFrameCnt;
    static DebugViewHolder i420BufferPreviewHolder;
    static DebugViewHolder observerPreviewHolder;
    static DebugViewHolder textureBufferPreviewHolder;
    static int textureFrameCnt;
    static boolean yuvRender;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static class DebugViewHolder {
        AgoraSurfaceView agoraSurfaceView;
        boolean applyRotation;
        boolean followSourceDimension;
        boolean mirror;
        boolean isInitialized = false;
        int lastSourceWidth = 0;
        int lastSourceHeight = 0;

        public DebugViewHolder(AgoraSurfaceView agoraSurfaceView, boolean z10, boolean z11, boolean z12) {
            this.agoraSurfaceView = agoraSurfaceView;
            this.followSourceDimension = z10;
            this.mirror = z11;
            this.applyRotation = z12;
        }

        void init(EglBase.Context context, MediaIO.BufferType bufferType, MediaIO.PixelFormat pixelFormat) {
            if (this.isInitialized) {
                return;
            }
            this.agoraSurfaceView.init(context);
            this.agoraSurfaceView.setBufferType(bufferType);
            this.agoraSurfaceView.setPixelFormat(pixelFormat);
            this.agoraSurfaceView.setMirror(this.mirror);
            this.agoraSurfaceView.onInitialize();
            this.agoraSurfaceView.onStart();
            this.isInitialized = true;
        }

        void reset() {
            AgoraSurfaceView agoraSurfaceView = this.agoraSurfaceView;
            if (agoraSurfaceView != null) {
                if (this.isInitialized) {
                    agoraSurfaceView.onStop();
                    this.agoraSurfaceView.onDispose();
                }
                this.agoraSurfaceView = null;
            }
            this.followSourceDimension = false;
            this.mirror = false;
            this.applyRotation = false;
            this.lastSourceWidth = 0;
            this.lastSourceHeight = 0;
            this.isInitialized = false;
        }

        void setupViewUI(final int i10, final int i11, final int i12) {
            if (this.followSourceDimension) {
                if (this.lastSourceWidth != i11 || this.lastSourceHeight != i12) {
                    this.agoraSurfaceView.post(new Runnable() { // from class: io.agora.rtc.video.AgoraVideoDebugger.DebugViewHolder.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z10;
                            int i13;
                            int i14;
                            int i15;
                            DebugViewHolder debugViewHolder = DebugViewHolder.this;
                            if (debugViewHolder.applyRotation && ((i15 = i10) == 90 || i15 == 270)) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            ViewGroup.LayoutParams layoutParams = debugViewHolder.agoraSurfaceView.getLayoutParams();
                            if (z10) {
                                i13 = i12;
                            } else {
                                i13 = i11;
                            }
                            layoutParams.width = i13;
                            ViewGroup.LayoutParams layoutParams2 = DebugViewHolder.this.agoraSurfaceView.getLayoutParams();
                            if (z10) {
                                i14 = i11;
                            } else {
                                i14 = i12;
                            }
                            layoutParams2.height = i14;
                        }
                    });
                    this.lastSourceWidth = i11;
                    this.lastSourceHeight = i12;
                }
            }
        }
    }

    public static ByteBuffer convertI420ToCompactByteBuffer(VideoFrame.I420Buffer i420Buffer) {
        int width = i420Buffer.getWidth();
        int height = i420Buffer.getHeight();
        int i10 = (height + 1) / 2;
        int i11 = (width + 1) / 2;
        int i12 = width * height;
        int i13 = i11 * i10;
        int i14 = i12 + i13;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((i11 * 2 * i10) + i12);
        allocateDirect.position(0);
        allocateDirect.limit(i12);
        ByteBuffer slice = allocateDirect.slice();
        allocateDirect.position(i12);
        allocateDirect.limit(i14);
        ByteBuffer slice2 = allocateDirect.slice();
        allocateDirect.position(i14);
        allocateDirect.limit(i14 + i13);
        ByteBuffer slice3 = allocateDirect.slice();
        ByteBuffer dataY = i420Buffer.getDataY();
        for (int i15 = 0; i15 < height; i15++) {
            int strideY = i420Buffer.getStrideY() * i15;
            dataY.limit(strideY + width);
            dataY.position(strideY);
            slice.put(dataY.slice());
        }
        ByteBuffer dataU = i420Buffer.getDataU();
        for (int i16 = 0; i16 < i10; i16++) {
            int strideU = i420Buffer.getStrideU() * i16;
            dataU.limit(strideU + i11);
            dataU.position(strideU);
            slice2.put(dataU.slice());
        }
        ByteBuffer dataV = i420Buffer.getDataV();
        for (int i17 = 0; i17 < i10; i17++) {
            int strideV = i420Buffer.getStrideV() * i17;
            dataV.limit(strideV + i11);
            dataV.position(strideV);
            slice3.put(dataV.slice());
        }
        allocateDirect.position(0);
        return allocateDirect;
    }

    public static byte[] convertNv21ToCompactI420(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        int i13 = i12 + 1;
        int i14 = i10 / 2;
        int i15 = i11 / 2;
        int i16 = (i12 * 5) / 4;
        byte[] bArr2 = new byte[(i12 * 3) / 2];
        for (int i17 = 0; i17 < i11; i17++) {
            int i18 = i10 * i17;
            System.arraycopy(bArr, i18, bArr2, i18, i10);
        }
        for (int i19 = 0; i19 < i15; i19++) {
            for (int i20 = 0; i20 < i14; i20++) {
                bArr2[(i14 * i19) + i12 + i20] = bArr[(i10 * i19) + i13 + (2 * i20)];
            }
        }
        for (int i21 = 0; i21 < i15; i21++) {
            for (int i22 = 0; i22 < i14; i22++) {
                bArr2[(i14 * i21) + i16 + i22] = bArr[(i10 * i21) + i12 + (2 * i22)];
            }
        }
        return bArr2;
    }

    public static byte[] convertYv12ToCompactI420(byte[] bArr, int i10, int i11) {
        int i12 = ((i10 + 15) >> 4) << 4;
        int i13 = i12 * i11;
        int i14 = (i12 >> 5) << 4;
        int i15 = ((i14 * i11) >> 1) + i13;
        int i16 = i10 * i11;
        int i17 = i10 / 2;
        int i18 = i11 / 2;
        int i19 = (i16 * 5) / 4;
        byte[] bArr2 = new byte[(i16 * 3) / 2];
        for (int i20 = 0; i20 < i11; i20++) {
            System.arraycopy(bArr, i12 * i20, bArr2, i10 * i20, i10);
        }
        for (int i21 = 0; i21 < i18; i21++) {
            System.arraycopy(bArr, (i14 * i21) + i15, bArr2, (i17 * i21) + i16, i17);
        }
        for (int i22 = 0; i22 < i18; i22++) {
            System.arraycopy(bArr, (i14 * i22) + i13, bArr2, (i17 * i22) + i19, i17);
        }
        return bArr2;
    }

    public static AgoraSurfaceView exampleUsage(Activity activity) {
        AgoraSurfaceView agoraSurfaceView = new AgoraSurfaceView(activity);
        ((ViewGroup) activity.findViewById(R.id.content)).addView(agoraSurfaceView, 360, 640);
        agoraSurfaceView.setZOrderOnTop(true);
        setCapturePreview(agoraSurfaceView, false, true, true, false);
        return agoraSurfaceView;
    }

    public static int getAgoraVideoFrameFormat(VideoFrame.TextureBuffer textureBuffer) {
        if (textureBuffer.getType() == VideoFrame.TextureBuffer.Type.OES) {
            return 11;
        }
        return 10;
    }

    public static MediaIO.PixelFormat getMediaIOPixelFormat(VideoFrame.TextureBuffer textureBuffer) {
        if (textureBuffer.getType() == VideoFrame.TextureBuffer.Type.OES) {
            return MediaIO.PixelFormat.TEXTURE_OES;
        }
        return MediaIO.PixelFormat.TEXTURE_2D;
    }

    public static void onCaptureVideoFrame(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onDropTextureBuffer(long j10) {
    }

    public static void onI420Buffer(VideoFrame.I420Buffer i420Buffer, int i10, long j10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onRawBufferAvailable(VideoCapture videoCapture, byte[] bArr, int i10, int i11, int i12, int i13) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onTextureAndRawBufferAvailable(VideoCapture videoCapture, VideoFrame.TextureBuffer textureBuffer, int i10, long j10, byte[] bArr, int i11) {
    }

    public static void onTextureBuffer(VideoFrame.TextureBuffer textureBuffer, int i10, long j10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onTextureBufferAvailable(VideoCapture videoCapture, EglBase.Context context, VideoFrame.TextureBuffer textureBuffer, int i10, long j10) {
    }

    public static void rawDataDump(byte[] bArr, FileOutputStream fileOutputStream) {
        if (bArr != null && bArr.length != 0) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reset() {
    }

    public static void setCapturePreview(AgoraSurfaceView agoraSurfaceView, boolean z10, boolean z11, boolean z12, boolean z13) {
    }

    public static void setI420BufferPreview(AgoraSurfaceView agoraSurfaceView) {
    }

    public static void setObserverPreview(AgoraSurfaceView agoraSurfaceView) {
    }

    public static void setTextureBufferPreview(AgoraSurfaceView agoraSurfaceView) {
    }

    public static void textureDump(VideoFrame.TextureBuffer textureBuffer, FileOutputStream fileOutputStream) {
        VideoFrame.I420Buffer i420;
        if (textureBuffer == null || fileOutputStream == null || (i420 = textureBuffer.toI420()) == null) {
            return;
        }
        try {
            ByteBuffer convertI420ToCompactByteBuffer = convertI420ToCompactByteBuffer(i420);
            FileChannel channel = fileOutputStream.getChannel();
            channel.write(convertI420ToCompactByteBuffer);
            channel.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static void setCapturePreview(AgoraSurfaceView agoraSurfaceView) {
        setCapturePreview(agoraSurfaceView, true, true, true, false);
    }
}
