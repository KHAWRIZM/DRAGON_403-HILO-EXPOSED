package com.tencent.qgame.animplayer.util;

import com.tencent.qgame.animplayer.PointRect;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lcom/tencent/qgame/animplayer/util/TexCoordsUtil;", "", "()V", "create", "", "width", "", "height", "rect", "Lcom/tencent/qgame/animplayer/PointRect;", "array", "rotate90", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TexCoordsUtil {
    public static final TexCoordsUtil INSTANCE = new TexCoordsUtil();

    private TexCoordsUtil() {
    }

    @NotNull
    public final float[] create(int width, int height, @NotNull PointRect rect, @NotNull float[] array) {
        float f = width;
        array[0] = rect.getX() / f;
        float f2 = height;
        array[1] = rect.getY() / f2;
        array[2] = rect.getX() / f;
        array[3] = (rect.getY() + rect.getH()) / f2;
        array[4] = (rect.getX() + rect.getW()) / f;
        array[5] = rect.getY() / f2;
        array[6] = (rect.getX() + rect.getW()) / f;
        array[7] = (rect.getY() + rect.getH()) / f2;
        return array;
    }

    @NotNull
    public final float[] rotate90(@NotNull float[] array) {
        float f = array[0];
        float f2 = array[1];
        array[0] = array[2];
        array[1] = array[3];
        array[2] = array[6];
        array[3] = array[7];
        array[6] = array[4];
        array[7] = array[5];
        array[4] = f;
        array[5] = f2;
        return array;
    }
}
