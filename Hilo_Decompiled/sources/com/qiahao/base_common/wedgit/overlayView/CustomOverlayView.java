package com.qiahao.base_common.wedgit.overlayView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.model.overlay.OverlayViewData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001aJ\u001e\u0010\u001f\u001a\u00020\u00002\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0014J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0015R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/CustomOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maskPaint", "Landroid/graphics/Paint;", "clearPaint", "mTargetList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/overlay/OverlayViewData;", "Lkotlin/collections/ArrayList;", "maskColor", "init", "", "setTargetRect", "rect", "Landroid/graphics/RectF;", "filletRadius", "", "setTargetCircle", "centerX", "centerY", "radius", "setTargetCircleList", "list", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setClickHide", "isClickHide", "", "clearTargetList", "refreshView", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomOverlayView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomOverlayView.kt\ncom/qiahao/base_common/wedgit/overlayView/CustomOverlayView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,141:1\n1#2:142\n1869#3,2:143\n*S KotlinDebug\n*F\n+ 1 CustomOverlayView.kt\ncom/qiahao/base_common/wedgit/overlayView/CustomOverlayView\n*L\n103#1:143,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CustomOverlayView extends View {

    @Nullable
    private Paint clearPaint;

    @NotNull
    private ArrayList<OverlayViewData> mTargetList;
    private final int maskColor;

    @Nullable
    private Paint maskPaint;

    public CustomOverlayView(@Nullable Context context) {
        super(context);
        this.mTargetList = new ArrayList<>();
        this.maskColor = -1728053248;
        init();
    }

    private final void init() {
        Paint paint = new Paint();
        this.maskPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.maskPaint;
        if (paint2 != null) {
            paint2.setStyle(Paint.Style.FILL);
        }
        Paint paint3 = this.maskPaint;
        if (paint3 != null) {
            paint3.setColor(this.maskColor);
        }
        Paint paint4 = new Paint();
        this.clearPaint = paint4;
        paint4.setAntiAlias(true);
        Paint paint5 = this.clearPaint;
        if (paint5 != null) {
            paint5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        this.mTargetList.clear();
        setLayerType(1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClickHide$lambda$4(boolean z10, CustomOverlayView customOverlayView, View view) {
        if (z10) {
            customOverlayView.setVisibility(8);
        }
    }

    public final void clearTargetList() {
        this.mTargetList.clear();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        float f10;
        float f11;
        float f12;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight(), null);
        Paint paint = this.maskPaint;
        if (paint != null) {
            canvas.drawRect(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight(), paint);
        }
        Paint paint2 = this.clearPaint;
        if (paint2 != null) {
            for (OverlayViewData overlayViewData : this.mTargetList) {
                boolean isCircle = overlayViewData.isCircle();
                float f13 = DownloadProgress.UNKNOWN_PROGRESS;
                if (isCircle) {
                    Float centerX = overlayViewData.getCenterX();
                    if (centerX != null) {
                        f10 = centerX.floatValue();
                    } else {
                        f10 = DownloadProgress.UNKNOWN_PROGRESS;
                    }
                    Float centerY = overlayViewData.getCenterY();
                    if (centerY != null) {
                        f11 = centerY.floatValue();
                    } else {
                        f11 = DownloadProgress.UNKNOWN_PROGRESS;
                    }
                    Float radius = overlayViewData.getRadius();
                    if (radius != null) {
                        f13 = radius.floatValue();
                    }
                    canvas.drawCircle(f10, f11, f13, paint2);
                } else {
                    RectF targetRect = overlayViewData.getTargetRect();
                    if (targetRect != null) {
                        Float filletRadius = overlayViewData.getFilletRadius();
                        if (filletRadius != null) {
                            f12 = filletRadius.floatValue();
                        } else {
                            f12 = DownloadProgress.UNKNOWN_PROGRESS;
                        }
                        Float filletRadius2 = overlayViewData.getFilletRadius();
                        if (filletRadius2 != null) {
                            f13 = filletRadius2.floatValue();
                        }
                        canvas.drawRoundRect(targetRect, f12, f13, paint2);
                    }
                }
            }
        }
        canvas.restoreToCount(saveLayer);
    }

    public final void refreshView() {
        setVisibility(0);
        invalidate();
    }

    @NotNull
    public final CustomOverlayView setClickHide(final boolean isClickHide) {
        setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.wedgit.overlayView.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomOverlayView.setClickHide$lambda$4(isClickHide, this, view);
            }
        });
        return this;
    }

    @NotNull
    public final CustomOverlayView setTargetCircle(float centerX, float centerY, float radius) {
        this.mTargetList.add(new OverlayViewData(true, Float.valueOf(centerX), Float.valueOf(centerY), Float.valueOf(radius), null, null, 48, null));
        return this;
    }

    @NotNull
    public final CustomOverlayView setTargetCircleList(@NotNull ArrayList<OverlayViewData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mTargetList.addAll(list);
        return this;
    }

    @NotNull
    public final CustomOverlayView setTargetRect(@Nullable RectF rect, float filletRadius) {
        this.mTargetList.add(new OverlayViewData(false, null, null, null, rect, Float.valueOf(filletRadius), 14, null));
        return this;
    }

    public CustomOverlayView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTargetList = new ArrayList<>();
        this.maskColor = -1728053248;
        init();
    }

    public /* synthetic */ CustomOverlayView(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    public CustomOverlayView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mTargetList = new ArrayList<>();
        this.maskColor = -1728053248;
        init();
    }
}
