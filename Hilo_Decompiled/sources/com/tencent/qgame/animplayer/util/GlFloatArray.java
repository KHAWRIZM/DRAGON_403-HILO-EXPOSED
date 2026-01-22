package com.tencent.qgame.animplayer.util;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tencent/qgame/animplayer/util/GlFloatArray;", "", "()V", "array", "", "getArray", "()[F", "floatBuffer", "Ljava/nio/FloatBuffer;", "setArray", "", "setVertexAttribPointer", "attributeLocation", "", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class GlFloatArray {

    @NotNull
    private final float[] array;
    private FloatBuffer floatBuffer;

    public GlFloatArray() {
        float[] fArr = new float[8];
        this.array = fArr;
        FloatBuffer put = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        Intrinsics.checkExpressionValueIsNotNull(put, "ByteBuffer\n            .…)\n            .put(array)");
        this.floatBuffer = put;
    }

    @NotNull
    public final float[] getArray() {
        return this.array;
    }

    public final void setArray(@NotNull float[] array) {
        this.floatBuffer.position(0);
        this.floatBuffer.put(array);
    }

    public final void setVertexAttribPointer(int attributeLocation) {
        this.floatBuffer.position(0);
        GLES20.glVertexAttribPointer(attributeLocation, 2, 5126, false, 0, (Buffer) this.floatBuffer);
        GLES20.glEnableVertexAttribArray(attributeLocation);
    }
}
