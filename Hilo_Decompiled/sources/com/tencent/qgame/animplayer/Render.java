package com.tencent.qgame.animplayer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.qgame.animplayer.IRenderListener;
import com.tencent.qgame.animplayer.util.GlFloatArray;
import com.tencent.qgame.animplayer.util.ShaderUtil;
import com.tencent.qgame.animplayer.util.TexCoordsUtil;
import com.tencent.qgame.animplayer.util.VertexUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0018H\u0016J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/tencent/qgame/animplayer/Render;", "Lcom/tencent/qgame/animplayer/IRenderListener;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;)V", "aPositionLocation", "", "aTextureAlphaLocation", "aTextureRgbLocation", "alphaArray", "Lcom/tencent/qgame/animplayer/util/GlFloatArray;", "eglUtil", "Lcom/tencent/qgame/animplayer/EGLUtil;", "genTexture", "", "rgbArray", "shaderProgram", "surfaceHeight", "surfaceSizeChanged", "", "surfaceWidth", "uTextureLocation", "vertexArray", "clearFrame", "", "destroyRender", "draw", "getExternalTexture", "initRender", "releaseTexture", "renderFrame", "setAnimConfig", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "setTexCoords", "setVertexBuf", "swapBuffers", "updateViewPort", "width", "height", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Render implements IRenderListener {
    private static final String TAG = "AnimPlayer.Render";
    private int aPositionLocation;
    private int aTextureAlphaLocation;
    private int aTextureRgbLocation;
    private final EGLUtil eglUtil;
    private int[] genTexture;
    private int shaderProgram;
    private int surfaceHeight;
    private boolean surfaceSizeChanged;
    private int surfaceWidth;
    private int uTextureLocation;
    private final GlFloatArray vertexArray = new GlFloatArray();
    private final GlFloatArray alphaArray = new GlFloatArray();
    private final GlFloatArray rgbArray = new GlFloatArray();

    public Render(@NotNull SurfaceTexture surfaceTexture) {
        EGLUtil eGLUtil = new EGLUtil();
        this.eglUtil = eGLUtil;
        this.genTexture = new int[1];
        eGLUtil.start(surfaceTexture);
        initRender();
    }

    private final void draw() {
        GLES20.glUseProgram(this.shaderProgram);
        this.vertexArray.setVertexAttribPointer(this.aPositionLocation);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.genTexture[0]);
        GLES20.glUniform1i(this.uTextureLocation, 0);
        this.alphaArray.setVertexAttribPointer(this.aTextureAlphaLocation);
        this.rgbArray.setVertexAttribPointer(this.aTextureRgbLocation);
        GLES20.glDrawArrays(5, 0, 4);
    }

    private final void setTexCoords(AnimConfig config) {
        TexCoordsUtil texCoordsUtil = TexCoordsUtil.INSTANCE;
        float[] create = texCoordsUtil.create(config.getVideoWidth(), config.getVideoHeight(), config.getAlphaPointRect(), this.alphaArray.getArray());
        float[] create2 = texCoordsUtil.create(config.getVideoWidth(), config.getVideoHeight(), config.getRgbPointRect(), this.rgbArray.getArray());
        this.alphaArray.setArray(create);
        this.rgbArray.setArray(create2);
    }

    private final void setVertexBuf(AnimConfig config) {
        this.vertexArray.setArray(VertexUtil.INSTANCE.create(config.getWidth(), config.getHeight(), new PointRect(0, 0, config.getWidth(), config.getHeight()), this.vertexArray.getArray()));
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void clearFrame() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.eglUtil.swapBuffers();
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void destroyRender() {
        releaseTexture();
        this.eglUtil.release();
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public int getExternalTexture() {
        return this.genTexture[0];
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void initRender() {
        int createProgram = ShaderUtil.INSTANCE.createProgram(RenderConstant.VERTEX_SHADER, RenderConstant.FRAGMENT_SHADER);
        this.shaderProgram = createProgram;
        this.uTextureLocation = GLES20.glGetUniformLocation(createProgram, "texture");
        this.aPositionLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vPosition");
        this.aTextureAlphaLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinateAlpha");
        this.aTextureRgbLocation = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinateRgb");
        int[] iArr = this.genTexture;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        GLES20.glBindTexture(36197, this.genTexture[0]);
        GLES20.glTexParameterf(36197, 10241, 9728);
        GLES20.glTexParameterf(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void releaseTexture() {
        int[] iArr = this.genTexture;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void renderFrame() {
        int i;
        int i2;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (this.surfaceSizeChanged && (i = this.surfaceWidth) > 0 && (i2 = this.surfaceHeight) > 0) {
            this.surfaceSizeChanged = false;
            GLES20.glViewport(0, 0, i, i2);
        }
        draw();
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void setAnimConfig(@NotNull AnimConfig config) {
        setVertexBuf(config);
        setTexCoords(config);
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void setYUVData(int i, int i2, @Nullable byte[] bArr, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        IRenderListener.DefaultImpls.setYUVData(this, i, i2, bArr, bArr2, bArr3);
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void swapBuffers() {
        this.eglUtil.swapBuffers();
    }

    @Override // com.tencent.qgame.animplayer.IRenderListener
    public void updateViewPort(int width, int height) {
        if (width > 0 && height > 0) {
            this.surfaceSizeChanged = true;
            this.surfaceWidth = width;
            this.surfaceHeight = height;
        }
    }
}
