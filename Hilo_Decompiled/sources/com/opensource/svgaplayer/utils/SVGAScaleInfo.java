package com.opensource.svgaplayer.utils;

import android.widget.ImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001cH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006$"}, d2 = {"Lcom/opensource/svgaplayer/utils/SVGAScaleInfo;", "", "()V", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "ratioX", "", "getRatioX", "()Z", "setRatioX", "(Z)V", "scaleFx", "getScaleFx", "setScaleFx", "scaleFy", "getScaleFy", "setScaleFy", "tranFx", "getTranFx", "setTranFx", "tranFy", "getTranFy", "setTranFy", "performScaleType", "", "canvasWidth", "canvasHeight", "videoWidth", "videoHeight", "scaleType", "Landroid/widget/ImageView$ScaleType;", "resetVar", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAScaleInfo {
    private boolean ratioX;
    private float tranFx;
    private float tranFy;
    private float scaleFx = 1.0f;
    private float scaleFy = 1.0f;
    private float ratio = 1.0f;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void resetVar() {
        this.tranFx = DownloadProgress.UNKNOWN_PROGRESS;
        this.tranFy = DownloadProgress.UNKNOWN_PROGRESS;
        this.scaleFx = 1.0f;
        this.scaleFy = 1.0f;
        this.ratio = 1.0f;
        this.ratioX = false;
    }

    public final float getRatio() {
        return this.ratio;
    }

    public final boolean getRatioX() {
        return this.ratioX;
    }

    public final float getScaleFx() {
        return this.scaleFx;
    }

    public final float getScaleFy() {
        return this.scaleFy;
    }

    public final float getTranFx() {
        return this.tranFx;
    }

    public final float getTranFy() {
        return this.tranFy;
    }

    public final void performScaleType(float canvasWidth, float canvasHeight, float videoWidth, float videoHeight, @NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (canvasWidth == DownloadProgress.UNKNOWN_PROGRESS || canvasHeight == DownloadProgress.UNKNOWN_PROGRESS || videoWidth == DownloadProgress.UNKNOWN_PROGRESS || videoHeight == DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        resetVar();
        float f10 = (canvasWidth - videoWidth) / 2.0f;
        float f11 = (canvasHeight - videoHeight) / 2.0f;
        float f12 = videoWidth / videoHeight;
        float f13 = canvasWidth / canvasHeight;
        float f14 = canvasHeight / videoHeight;
        float f15 = canvasWidth / videoWidth;
        boolean z10 = false;
        switch (WhenMappings.$EnumSwitchMapping$0[scaleType.ordinal()]) {
            case 1:
                this.tranFx = f10;
                this.tranFy = f11;
                return;
            case 2:
                if (f12 > f13) {
                    this.ratio = f14;
                    this.ratioX = false;
                    this.scaleFx = f14;
                    this.scaleFy = f14;
                    this.tranFx = (canvasWidth - (videoWidth * f14)) / 2.0f;
                    return;
                }
                this.ratio = f15;
                this.ratioX = true;
                this.scaleFx = f15;
                this.scaleFy = f15;
                this.tranFy = (canvasHeight - (videoHeight * f15)) / 2.0f;
                return;
            case 3:
                if (videoWidth < canvasWidth && videoHeight < canvasHeight) {
                    this.tranFx = f10;
                    this.tranFy = f11;
                    return;
                }
                if (f12 > f13) {
                    this.ratio = f15;
                    this.ratioX = true;
                    this.scaleFx = f15;
                    this.scaleFy = f15;
                    this.tranFy = (canvasHeight - (videoHeight * f15)) / 2.0f;
                    return;
                }
                this.ratio = f14;
                this.ratioX = false;
                this.scaleFx = f14;
                this.scaleFy = f14;
                this.tranFx = (canvasWidth - (videoWidth * f14)) / 2.0f;
                return;
            case 4:
                if (f12 > f13) {
                    this.ratio = f15;
                    this.ratioX = true;
                    this.scaleFx = f15;
                    this.scaleFy = f15;
                    this.tranFy = (canvasHeight - (videoHeight * f15)) / 2.0f;
                    return;
                }
                this.ratio = f14;
                this.ratioX = false;
                this.scaleFx = f14;
                this.scaleFy = f14;
                this.tranFx = (canvasWidth - (videoWidth * f14)) / 2.0f;
                return;
            case 5:
                if (f12 > f13) {
                    this.ratio = f15;
                    this.ratioX = true;
                    this.scaleFx = f15;
                    this.scaleFy = f15;
                    return;
                }
                this.ratio = f14;
                this.ratioX = false;
                this.scaleFx = f14;
                this.scaleFy = f14;
                return;
            case 6:
                if (f12 > f13) {
                    this.ratio = f15;
                    this.ratioX = true;
                    this.scaleFx = f15;
                    this.scaleFy = f15;
                    this.tranFy = canvasHeight - (videoHeight * f15);
                    return;
                }
                this.ratio = f14;
                this.ratioX = false;
                this.scaleFx = f14;
                this.scaleFy = f14;
                this.tranFx = canvasWidth - (videoWidth * f14);
                return;
            case 7:
                this.ratio = Math.max(f15, f14);
                if (f15 > f14) {
                    z10 = true;
                }
                this.ratioX = z10;
                this.scaleFx = f15;
                this.scaleFy = f14;
                return;
            default:
                this.ratio = f15;
                this.ratioX = true;
                this.scaleFx = f15;
                this.scaleFy = f15;
                return;
        }
    }

    public final void setRatio(float f10) {
        this.ratio = f10;
    }

    public final void setRatioX(boolean z10) {
        this.ratioX = z10;
    }

    public final void setScaleFx(float f10) {
        this.scaleFx = f10;
    }

    public final void setScaleFy(float f10) {
        this.scaleFy = f10;
    }

    public final void setTranFx(float f10) {
        this.tranFx = f10;
    }

    public final void setTranFy(float f10) {
        this.tranFy = f10;
    }
}
