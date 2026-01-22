package com.tencent.qgame.animplayer;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J6\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0003H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0016"}, d2 = {"Lcom/tencent/qgame/animplayer/IRenderListener;", "", "clearFrame", "", "destroyRender", "getExternalTexture", "", "initRender", "releaseTexture", "renderFrame", "setAnimConfig", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "setYUVData", "width", "height", "y", "", "u", "v", "swapBuffers", "updateViewPort", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IRenderListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class DefaultImpls {
        public static void setYUVData(IRenderListener iRenderListener, int i, int i2, @Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        }

        public static void updateViewPort(IRenderListener iRenderListener, int i, int i2) {
        }
    }

    void clearFrame();

    void destroyRender();

    int getExternalTexture();

    void initRender();

    void releaseTexture();

    void renderFrame();

    void setAnimConfig(@NotNull AnimConfig config);

    void setYUVData(int width, int height, @Nullable byte[] y, @Nullable byte[] u, @Nullable byte[] v);

    void swapBuffers();

    void updateViewPort(int width, int height);
}
