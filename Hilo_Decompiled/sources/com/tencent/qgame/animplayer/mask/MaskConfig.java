package com.tencent.qgame.animplayer.mask;

import android.graphics.Bitmap;
import com.tencent.qgame.animplayer.PointRect;
import com.tencent.qgame.animplayer.RefVec2;
import com.tencent.qgame.animplayer.util.TextureLoadUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u0005¢\u0006\u0002\u0010\nJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010\u001e\u001a\u00020\u0017J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020!2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0006\u0010#\u001a\u00020\u0017R(\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015¨\u0006$"}, d2 = {"Lcom/tencent/qgame/animplayer/mask/MaskConfig;", "", "bitmap", "Landroid/graphics/Bitmap;", "positionPair", "Lkotlin/Pair;", "Lcom/tencent/qgame/animplayer/PointRect;", "Lcom/tencent/qgame/animplayer/RefVec2;", "texPair", "(Landroid/graphics/Bitmap;Lkotlin/Pair;Lkotlin/Pair;)V", "()V", "value", "alphaMaskBitmap", "getAlphaMaskBitmap", "()Landroid/graphics/Bitmap;", "setAlphaMaskBitmap", "(Landroid/graphics/Bitmap;)V", "maskPositionPair", "getMaskPositionPair", "()Lkotlin/Pair;", "setMaskPositionPair", "(Lkotlin/Pair;)V", "maskTexId", "", "maskTexPair", "getMaskTexPair", "setMaskTexPair", "equals", "", "other", "getMaskTexId", "hashCode", "release", "", "safeSetMaskBitmapAndReleasePre", "updateMaskTex", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class MaskConfig {

    @Nullable
    private Bitmap alphaMaskBitmap;

    @Nullable
    private Pair<PointRect, RefVec2> maskPositionPair;
    private int maskTexId;

    @Nullable
    private Pair<PointRect, RefVec2> maskTexPair;

    public MaskConfig() {
    }

    private final void setAlphaMaskBitmap(Bitmap bitmap) {
        this.alphaMaskBitmap = bitmap;
    }

    public boolean equals(@Nullable Object other) {
        PointRect pointRect;
        PointRect pointRect2;
        RefVec2 refVec2;
        RefVec2 refVec22;
        PointRect pointRect3;
        PointRect pointRect4;
        RefVec2 refVec23;
        if (other instanceof MaskConfig) {
            MaskConfig maskConfig = (MaskConfig) other;
            if (!Intrinsics.areEqual(this.alphaMaskBitmap, maskConfig.alphaMaskBitmap)) {
                Pair<PointRect, RefVec2> pair = this.maskTexPair;
                RefVec2 refVec24 = null;
                if (pair != null) {
                    pointRect = (PointRect) pair.getFirst();
                } else {
                    pointRect = null;
                }
                Pair<PointRect, RefVec2> pair2 = maskConfig.maskTexPair;
                if (pair2 != null) {
                    pointRect2 = (PointRect) pair2.getFirst();
                } else {
                    pointRect2 = null;
                }
                if (!Intrinsics.areEqual(pointRect, pointRect2)) {
                    Pair<PointRect, RefVec2> pair3 = this.maskTexPair;
                    if (pair3 != null) {
                        refVec2 = (RefVec2) pair3.getSecond();
                    } else {
                        refVec2 = null;
                    }
                    Pair<PointRect, RefVec2> pair4 = maskConfig.maskTexPair;
                    if (pair4 != null) {
                        refVec22 = (RefVec2) pair4.getSecond();
                    } else {
                        refVec22 = null;
                    }
                    if (!Intrinsics.areEqual(refVec2, refVec22)) {
                        Pair<PointRect, RefVec2> pair5 = this.maskPositionPair;
                        if (pair5 != null) {
                            pointRect3 = (PointRect) pair5.getFirst();
                        } else {
                            pointRect3 = null;
                        }
                        Pair<PointRect, RefVec2> pair6 = maskConfig.maskPositionPair;
                        if (pair6 != null) {
                            pointRect4 = (PointRect) pair6.getFirst();
                        } else {
                            pointRect4 = null;
                        }
                        if (!Intrinsics.areEqual(pointRect3, pointRect4)) {
                            Pair<PointRect, RefVec2> pair7 = this.maskPositionPair;
                            if (pair7 != null) {
                                refVec23 = (RefVec2) pair7.getSecond();
                            } else {
                                refVec23 = null;
                            }
                            Pair<PointRect, RefVec2> pair8 = maskConfig.maskPositionPair;
                            if (pair8 != null) {
                                refVec24 = (RefVec2) pair8.getSecond();
                            }
                            if (!Intrinsics.areEqual(refVec23, refVec24)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public final Bitmap getAlphaMaskBitmap() {
        return this.alphaMaskBitmap;
    }

    @Nullable
    public final Pair<PointRect, RefVec2> getMaskPositionPair() {
        return this.maskPositionPair;
    }

    public final int getMaskTexId() {
        return this.maskTexId;
    }

    @Nullable
    public final Pair<PointRect, RefVec2> getMaskTexPair() {
        return this.maskTexPair;
    }

    public int hashCode() {
        int i;
        int i2;
        Bitmap bitmap = this.alphaMaskBitmap;
        int i3 = 0;
        if (bitmap != null) {
            i = bitmap.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        Pair<PointRect, RefVec2> pair = this.maskTexPair;
        if (pair != null) {
            i2 = pair.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (i4 + i2) * 31;
        Pair<PointRect, RefVec2> pair2 = this.maskPositionPair;
        if (pair2 != null) {
            i3 = pair2.hashCode();
        }
        return i5 + i3;
    }

    public final void release() {
        setAlphaMaskBitmap(null);
        this.maskTexPair = null;
        this.maskPositionPair = null;
    }

    public final void safeSetMaskBitmapAndReleasePre(@Nullable Bitmap bitmap) {
        int i = this.maskTexId;
        if (i > 0) {
            TextureLoadUtil.INSTANCE.releaseTexure(i);
            this.maskTexId = 0;
        }
        setAlphaMaskBitmap(bitmap);
    }

    public final void setMaskPositionPair(@Nullable Pair<PointRect, RefVec2> pair) {
        this.maskPositionPair = pair;
    }

    public final void setMaskTexPair(@Nullable Pair<PointRect, RefVec2> pair) {
        this.maskTexPair = pair;
    }

    public final int updateMaskTex() {
        int loadTexture = TextureLoadUtil.INSTANCE.loadTexture(this.alphaMaskBitmap);
        this.maskTexId = loadTexture;
        return loadTexture;
    }

    public MaskConfig(@Nullable Bitmap bitmap, @Nullable Pair<PointRect, RefVec2> pair, @Nullable Pair<PointRect, RefVec2> pair2) {
        this();
        this.maskPositionPair = pair;
        this.maskTexPair = pair2;
        setAlphaMaskBitmap(bitmap);
    }
}
