package com.skydoves.transformationlayout;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import com.skydoves.transformationlayout.TransformationLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001e\u0010:\u001a\u00020;8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020;X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?¨\u0006C"}, d2 = {"Lcom/skydoves/transformationlayout/DefaultParamValues;", "Lcom/skydoves/transformationlayout/TransformationParams;", "<init>", "()V", "pathMotion", "Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "getPathMotion", "()Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "setPathMotion", "(Lcom/skydoves/transformationlayout/TransformationLayout$Motion;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "zOrder", "", "getZOrder", "()I", "setZOrder", "(I)V", "containerColor", "getContainerColor", "setContainerColor", "allContainerColors", "getAllContainerColors", "setAllContainerColors", "scrimColor", "getScrimColor", "setScrimColor", "direction", "Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "getDirection", "()Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "setDirection", "(Lcom/skydoves/transformationlayout/TransformationLayout$Direction;)V", "fadeMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "getFadeMode", "()Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "setFadeMode", "(Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;)V", "fitMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "getFitMode", "()Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "setFitMode", "(Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;)V", "startElevation", "", "getStartElevation", "()F", "setStartElevation", "(F)V", "endElevation", "getEndElevation", "setEndElevation", "elevationShadowEnabled", "", "getElevationShadowEnabled", "()Z", "setElevationShadowEnabled", "(Z)V", "holdAtEndEnabled", "getHoldAtEndEnabled", "setHoldAtEndEnabled", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DefaultParamValues implements TransformationParams {
    private static int allContainerColors;
    private static int containerColor;

    @ChecksSdkIntAtLeast(api = 28)
    private static boolean elevationShadowEnabled;
    private static boolean holdAtEndEnabled;
    private static int scrimColor;

    @NotNull
    public static final DefaultParamValues INSTANCE = new DefaultParamValues();

    @NotNull
    private static TransformationLayout.Motion pathMotion = TransformationLayout.Motion.ARC;
    private static long duration = 450;
    private static int zOrder = android.R.id.content;

    @NotNull
    private static TransformationLayout.Direction direction = TransformationLayout.Direction.AUTO;

    @NotNull
    private static TransformationLayout.FadeMode fadeMode = TransformationLayout.FadeMode.IN;

    @NotNull
    private static TransformationLayout.FitMode fitMode = TransformationLayout.FitMode.AUTO;
    private static float startElevation = -1.0f;
    private static float endElevation = -1.0f;

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 28) {
            z = true;
        } else {
            z = false;
        }
        elevationShadowEnabled = z;
    }

    private DefaultParamValues() {
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public int getAllContainerColors() {
        return allContainerColors;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public int getContainerColor() {
        return containerColor;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    @NotNull
    public TransformationLayout.Direction getDirection() {
        return direction;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public long getDuration() {
        return duration;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public boolean getElevationShadowEnabled() {
        return elevationShadowEnabled;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public float getEndElevation() {
        return endElevation;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    @NotNull
    public TransformationLayout.FadeMode getFadeMode() {
        return fadeMode;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    @NotNull
    public TransformationLayout.FitMode getFitMode() {
        return fitMode;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public boolean getHoldAtEndEnabled() {
        return holdAtEndEnabled;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    @NotNull
    public TransformationLayout.Motion getPathMotion() {
        return pathMotion;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public int getScrimColor() {
        return scrimColor;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public float getStartElevation() {
        return startElevation;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public int getZOrder() {
        return zOrder;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setAllContainerColors(int i) {
        allContainerColors = i;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setContainerColor(int i) {
        containerColor = i;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setDirection(@NotNull TransformationLayout.Direction direction2) {
        Intrinsics.checkNotNullParameter(direction2, "<set-?>");
        direction = direction2;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setDuration(long j) {
        duration = j;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setElevationShadowEnabled(boolean z) {
        elevationShadowEnabled = z;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setEndElevation(float f) {
        endElevation = f;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setFadeMode(@NotNull TransformationLayout.FadeMode fadeMode2) {
        Intrinsics.checkNotNullParameter(fadeMode2, "<set-?>");
        fadeMode = fadeMode2;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setFitMode(@NotNull TransformationLayout.FitMode fitMode2) {
        Intrinsics.checkNotNullParameter(fitMode2, "<set-?>");
        fitMode = fitMode2;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setHoldAtEndEnabled(boolean z) {
        holdAtEndEnabled = z;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setPathMotion(@NotNull TransformationLayout.Motion motion) {
        Intrinsics.checkNotNullParameter(motion, "<set-?>");
        pathMotion = motion;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setScrimColor(int i) {
        scrimColor = i;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setStartElevation(float f) {
        startElevation = f;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setZOrder(int i) {
        zOrder = i;
    }
}
