package com.tencent.qgame.animplayer.util;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J0\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tencent/qgame/animplayer/util/ScaleTypeCenterCrop;", "Lcom/tencent/qgame/animplayer/util/IScaleType;", "()V", "realHeight", "", "realWidth", "getCenterCropSize", "Lkotlin/Pair;", "layoutWidth", "layoutHeight", "videoWidth", "videoHeight", "getLayoutParam", "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", "getRealSize", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ScaleTypeCenterCrop implements IScaleType {
    private int realHeight;
    private int realWidth;

    private final Pair<Integer, Integer> getCenterCropSize(int layoutWidth, int layoutHeight, int videoWidth, int videoHeight) {
        float f = layoutWidth;
        float f2 = layoutHeight;
        float f3 = videoWidth / videoHeight;
        if (f / f2 > f3) {
            layoutHeight = (int) (f / f3);
        } else {
            layoutWidth = (int) (f3 * f2);
        }
        return new Pair<>(Integer.valueOf(layoutWidth), Integer.valueOf(layoutHeight));
    }

    @Override // com.tencent.qgame.animplayer.util.IScaleType
    @NotNull
    public FrameLayout.LayoutParams getLayoutParam(int layoutWidth, int layoutHeight, int videoWidth, int videoHeight, @NotNull FrameLayout.LayoutParams layoutParams) {
        Pair<Integer, Integer> centerCropSize = getCenterCropSize(layoutWidth, layoutHeight, videoWidth, videoHeight);
        int intValue = ((Number) centerCropSize.component1()).intValue();
        int intValue2 = ((Number) centerCropSize.component2()).intValue();
        if (intValue <= 0 && intValue2 <= 0) {
            return layoutParams;
        }
        this.realWidth = intValue;
        this.realHeight = intValue2;
        layoutParams.width = intValue;
        layoutParams.height = intValue2;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    @Override // com.tencent.qgame.animplayer.util.IScaleType
    @NotNull
    public Pair<Integer, Integer> getRealSize() {
        return new Pair<>(Integer.valueOf(this.realWidth), Integer.valueOf(this.realHeight));
    }
}
