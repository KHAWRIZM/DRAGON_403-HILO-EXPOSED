package io.agora.rtc.gl;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.liulishuo.okdownload.DownloadTask;
import io.agora.rtc.utils.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class TextureTransformer {
    public static final float[] IDENTITY_MATRIX;
    private static final String TAG = "TextureTransformer";
    private final GlRectDrawer drawer;
    private final ConcurrentLinkedQueue<Integer> freeSlots;
    private final int maxBufferSlot;
    private final GlTextureFrameBuffer[] textureFrameBuffer;
    private final Map<Integer, Integer> textureId2SlotMap;
    private final ThreadUtils.ThreadChecker threadChecker;

    static {
        float[] fArr = new float[16];
        IDENTITY_MATRIX = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public TextureTransformer(int i10) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.textureId2SlotMap = new HashMap();
        this.freeSlots = new ConcurrentLinkedQueue<>();
        threadChecker.checkIsOnValidThread();
        this.maxBufferSlot = Math.max(i10, 1);
        this.textureFrameBuffer = new GlTextureFrameBuffer[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.textureFrameBuffer[i11] = new GlTextureFrameBuffer(6408);
            this.textureId2SlotMap.put(Integer.valueOf(this.textureFrameBuffer[i11].getTextureId()), Integer.valueOf(i11));
            this.freeSlots.offer(Integer.valueOf(i11));
        }
        this.drawer = new GlRectDrawer();
    }

    public int copy(int i10, int i11, int i12, int i13) {
        this.threadChecker.checkIsOnValidThread();
        Integer poll = this.freeSlots.poll();
        if (poll == null) {
            return -1;
        }
        this.textureFrameBuffer[poll.intValue()].setSize(i12, i13);
        GLES20.glBindFramebuffer(36160, this.textureFrameBuffer[poll.intValue()].getFrameBufferId());
        GlUtil.checkNoGLES2Error("TextureHelper.glBindFramebuffer");
        GLES20.glClear(DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
        if (i11 != 10) {
            if (i11 == 11) {
                this.drawer.drawOes(i10, IDENTITY_MATRIX, i12, i13, 0, 0, i12, i13);
            } else {
                throw new RuntimeException("Unknown texture type.");
            }
        } else {
            this.drawer.drawRgb(i10, IDENTITY_MATRIX, i12, i13, 0, 0, i12, i13);
        }
        GlUtil.checkNoGLES2Error("TextureHelper.draw");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glFlush();
        int textureId = this.textureFrameBuffer[poll.intValue()].getTextureId();
        this.freeSlots.offer(this.textureId2SlotMap.get(Integer.valueOf(textureId)));
        return textureId;
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        for (int i10 = 0; i10 < this.maxBufferSlot; i10++) {
            this.textureFrameBuffer[i10].release();
        }
        this.drawer.release();
    }
}
