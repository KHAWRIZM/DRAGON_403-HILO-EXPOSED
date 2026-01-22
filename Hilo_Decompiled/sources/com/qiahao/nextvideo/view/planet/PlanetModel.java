package com.qiahao.nextvideo.view.planet;

import android.graphics.Color;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B;\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010-\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b.\u0010\u0015¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetModel;", "", "locX", "", "locY", "locZ", "scale", "popularity", "", "<init>", "(FFFFI)V", "(I)V", "getLocX", "()F", "setLocX", "(F)V", "getLocY", "setLocY", "getLocZ", "setLocZ", "getPopularity", "()I", "setPopularity", "loc2DX", "getLoc2DX", "setLoc2DX", "loc2DY", "getLoc2DY", "setLoc2DY", "getScale", "setScale", "alpha", "getAlpha", "setAlpha", "argb", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "setColorByArray", "", "rgb", "color", "getColor", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PlanetModel {
    private static final int DEFAULT_POPULARITY = 5;
    private float alpha;

    @NotNull
    private final float[] argb;
    private float loc2DX;
    private float loc2DY;
    private float locX;
    private float locY;
    private float locZ;
    private int popularity;
    private float scale;

    @Nullable
    private View view;

    @JvmOverloads
    public PlanetModel() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0, 31, null);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getColor() {
        int[] iArr = new int[4];
        for (int i = 0; i < 4; i++) {
            iArr[i] = (int) (this.argb[i] * 255);
        }
        return Color.argb(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public final float getLoc2DX() {
        return this.loc2DX;
    }

    public final float getLoc2DY() {
        return this.loc2DY;
    }

    public final float getLocX() {
        return this.locX;
    }

    public final float getLocY() {
        return this.locY;
    }

    public final float getLocZ() {
        return this.locZ;
    }

    public final int getPopularity() {
        return this.popularity;
    }

    public final float getScale() {
        return this.scale;
    }

    @Nullable
    public final View getView() {
        return this.view;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
        this.argb[0] = f;
    }

    public final void setColorByArray(@Nullable float[] rgb) {
        if (rgb != null) {
            float[] fArr = this.argb;
            System.arraycopy(rgb, 0, fArr, fArr.length - rgb.length, rgb.length);
        }
    }

    public final void setLoc2DX(float f) {
        this.loc2DX = f;
    }

    public final void setLoc2DY(float f) {
        this.loc2DY = f;
    }

    public final void setLocX(float f) {
        this.locX = f;
    }

    public final void setLocY(float f) {
        this.locY = f;
    }

    public final void setLocZ(float f) {
        this.locZ = f;
    }

    public final void setPopularity(int i) {
        this.popularity = i;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    public final void setView(@Nullable View view) {
        this.view = view;
    }

    @JvmOverloads
    public PlanetModel(float f) {
        this(f, 0.0f, 0.0f, 0.0f, 0, 30, null);
    }

    @JvmOverloads
    public PlanetModel(float f, float f2) {
        this(f, f2, 0.0f, 0.0f, 0, 28, null);
    }

    @JvmOverloads
    public PlanetModel(float f, float f2, float f3) {
        this(f, f2, f3, 0.0f, 0, 24, null);
    }

    @JvmOverloads
    public PlanetModel(float f, float f2, float f3, float f4) {
        this(f, f2, f3, f4, 0, 16, null);
    }

    @JvmOverloads
    public PlanetModel(float f, float f2, float f3, float f4, int i) {
        this.locX = f;
        this.locY = f2;
        this.locZ = f3;
        this.argb = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        this.scale = f4;
        this.popularity = i;
    }

    public /* synthetic */ PlanetModel(float f, float f2, float f3, float f4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0.0f : f2, (i2 & 4) == 0 ? f3 : 0.0f, (i2 & 8) != 0 ? 1.0f : f4, (i2 & 16) != 0 ? 0 : i);
    }

    public PlanetModel(int i) {
        this(0.0f, 0.0f, 0.0f, 1.0f, i);
    }
}
