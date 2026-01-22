package io.agora.rtc.gl;

import io.agora.rtc.gl.VideoFrame;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class JavaI420Buffer implements VideoFrame.I420Buffer {
    private final ByteBuffer dataU;
    private final ByteBuffer dataV;
    private final ByteBuffer dataY;
    private final int height;
    private final Runnable releaseCallback;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;
    private final Object refCountLock = new Object();
    private int refCount = 1;

    private JavaI420Buffer(int i10, int i11, ByteBuffer byteBuffer, int i12, ByteBuffer byteBuffer2, int i13, ByteBuffer byteBuffer3, int i14, Runnable runnable) {
        this.width = i10;
        this.height = i11;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i12;
        this.strideU = i13;
        this.strideV = i14;
        this.releaseCallback = runnable;
    }

    public static JavaI420Buffer allocate(int i10, int i11) {
        int i12 = (i11 + 1) / 2;
        int i13 = (i10 + 1) / 2;
        int i14 = i10 * i11;
        int i15 = i13 * i12;
        int i16 = i14 + i15;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((i13 * 2 * i12) + i14);
        allocateDirect.position(0);
        allocateDirect.limit(i14);
        ByteBuffer slice = allocateDirect.slice();
        allocateDirect.position(i14);
        allocateDirect.limit(i16);
        ByteBuffer slice2 = allocateDirect.slice();
        allocateDirect.position(i16);
        allocateDirect.limit(i16 + i15);
        return new JavaI420Buffer(i10, i11, slice, i10, slice2, i13, allocateDirect.slice(), i13, null);
    }

    public static JavaI420Buffer createYUV(byte[] bArr, int i10, int i11) {
        if (bArr != null && bArr.length != 0) {
            JavaI420Buffer allocate = allocate(i10, i11);
            ByteBuffer dataY = allocate.getDataY();
            ByteBuffer dataU = allocate.getDataU();
            ByteBuffer dataV = allocate.getDataV();
            int i12 = (i11 + 1) / 2;
            int strideY = i11 * allocate.getStrideY();
            int strideU = allocate.getStrideU() * i12;
            int strideV = i12 * allocate.getStrideV();
            dataY.put(bArr, 0, strideY);
            dataU.put(bArr, strideY, strideU);
            dataV.put(bArr, strideY + strideU, strideV);
            return allocate;
        }
        return null;
    }

    public static JavaI420Buffer wrap(int i10, int i11, ByteBuffer byteBuffer, int i12, ByteBuffer byteBuffer2, int i13, ByteBuffer byteBuffer3, int i14, Runnable runnable) {
        if (byteBuffer != null && byteBuffer2 != null && byteBuffer3 != null) {
            if (byteBuffer.isDirect() && byteBuffer2.isDirect() && byteBuffer3.isDirect()) {
                ByteBuffer slice = byteBuffer.slice();
                ByteBuffer slice2 = byteBuffer2.slice();
                ByteBuffer slice3 = byteBuffer3.slice();
                int i15 = (i11 + 1) / 2;
                int i16 = i12 * i11;
                int i17 = i13 * i15;
                int i18 = i15 * i14;
                if (slice.capacity() >= i16) {
                    if (slice2.capacity() >= i17) {
                        if (slice3.capacity() >= i18) {
                            return new JavaI420Buffer(i10, i11, slice, i12, slice2, i13, slice3, i14, runnable);
                        }
                        throw new IllegalArgumentException("V-buffer must be at least " + i18 + " bytes.");
                    }
                    throw new IllegalArgumentException("U-buffer must be at least " + i17 + " bytes.");
                }
                throw new IllegalArgumentException("Y-buffer must be at least " + i16 + " bytes.");
            }
            throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
        }
        throw new IllegalArgumentException("Data buffers cannot be null.");
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i10, int i11, int i12, int i13, int i14, int i15) {
        return VideoFrame.cropAndScaleI420(this, i10, i11, i12, i13, i14, i15);
    }

    @Override // io.agora.rtc.gl.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // io.agora.rtc.gl.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // io.agora.rtc.gl.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // io.agora.rtc.gl.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // io.agora.rtc.gl.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // io.agora.rtc.gl.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public void release() {
        Runnable runnable;
        synchronized (this.refCountLock) {
            try {
                int i10 = this.refCount - 1;
                this.refCount = i10;
                if (i10 == 0 && (runnable = this.releaseCallback) != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public void retain() {
        synchronized (this.refCountLock) {
            this.refCount++;
        }
    }

    @Override // io.agora.rtc.gl.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
    }
}
