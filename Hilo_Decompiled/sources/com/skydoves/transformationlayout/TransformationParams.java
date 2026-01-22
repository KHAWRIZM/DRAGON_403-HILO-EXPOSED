package com.skydoves.transformationlayout;

import com.skydoves.transformationlayout.TransformationLayout;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b`\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0017\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u0018\u0010\u001a\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u0018\u0010\u001d\u001a\u00020\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010#\u001a\u00020$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010)\u001a\u00020*X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u0010/\u001a\u000200X¦\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00105\u001a\u000200X¦\u000e¢\u0006\f\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u0018\u00108\u001a\u000209X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010>\u001a\u000209X¦\u000e¢\u0006\f\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=¨\u0006AÀ\u0006\u0003"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationParams;", "Ljava/io/Serializable;", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "pathMotion", "Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "getPathMotion", "()Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "setPathMotion", "(Lcom/skydoves/transformationlayout/TransformationLayout$Motion;)V", "zOrder", "", "getZOrder", "()I", "setZOrder", "(I)V", "containerColor", "getContainerColor", "setContainerColor", "allContainerColors", "getAllContainerColors", "setAllContainerColors", "scrimColor", "getScrimColor", "setScrimColor", "direction", "Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "getDirection", "()Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "setDirection", "(Lcom/skydoves/transformationlayout/TransformationLayout$Direction;)V", "fadeMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "getFadeMode", "()Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "setFadeMode", "(Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;)V", "fitMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "getFitMode", "()Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "setFitMode", "(Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;)V", "startElevation", "", "getStartElevation", "()F", "setStartElevation", "(F)V", "endElevation", "getEndElevation", "setEndElevation", "elevationShadowEnabled", "", "getElevationShadowEnabled", "()Z", "setElevationShadowEnabled", "(Z)V", "holdAtEndEnabled", "getHoldAtEndEnabled", "setHoldAtEndEnabled", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface TransformationParams extends Serializable {
    int getAllContainerColors();

    int getContainerColor();

    @NotNull
    TransformationLayout.Direction getDirection();

    long getDuration();

    boolean getElevationShadowEnabled();

    float getEndElevation();

    @NotNull
    TransformationLayout.FadeMode getFadeMode();

    @NotNull
    TransformationLayout.FitMode getFitMode();

    boolean getHoldAtEndEnabled();

    @NotNull
    TransformationLayout.Motion getPathMotion();

    int getScrimColor();

    float getStartElevation();

    int getZOrder();

    void setAllContainerColors(int i);

    void setContainerColor(int i);

    void setDirection(@NotNull TransformationLayout.Direction direction);

    void setDuration(long j);

    void setElevationShadowEnabled(boolean z);

    void setEndElevation(float f);

    void setFadeMode(@NotNull TransformationLayout.FadeMode fadeMode);

    void setFitMode(@NotNull TransformationLayout.FitMode fitMode);

    void setHoldAtEndEnabled(boolean z);

    void setPathMotion(@NotNull TransformationLayout.Motion motion);

    void setScrimColor(int i);

    void setStartElevation(float f);

    void setZOrder(int i);
}
