package com.qiahao.base_common.wedgit.overlayView;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.model.overlay.Location;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J9\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$\"\u00020%H\u0016¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00002\b\b\u0001\u0010(\u001a\u00020\u0019H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0019H\u0016J\b\u0010,\u001a\u00020\u0011H&J\b\u0010-\u001a\u00020*H&J\b\u0010.\u001a\u00020*H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/BaseLayer;", "Lcom/qiahao/base_common/wedgit/overlayView/ILayer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "controller", "Lcom/qiahao/base_common/wedgit/overlayView/ILayerController;", "getController$base_common_release", "()Lcom/qiahao/base_common/wedgit/overlayView/ILayerController;", "setController$base_common_release", "(Lcom/qiahao/base_common/wedgit/overlayView/ILayerController;)V", "layerView", "Lcom/qiahao/base_common/wedgit/overlayView/LayerView;", "painter", "Lcom/qiahao/base_common/wedgit/overlayView/IPainter;", "getPainter", "()Lcom/qiahao/base_common/wedgit/overlayView/IPainter;", "painter$delegate", "Lkotlin/Lazy;", "layerInit", "", "targetCounts", "", "getView", "Landroid/view/View;", "addHighlight", ViewHierarchyConstants.VIEW_KEY, "rect", "Landroid/graphics/Rect;", "withView", "verticalOffset", "horizontalOffset", "locations", "", "Lcom/qiahao/base_common/model/overlay/Location;", "(Landroid/view/View;II[Lcom/qiahao/base_common/model/overlay/Location;)Lcom/qiahao/base_common/wedgit/overlayView/BaseLayer;", "withImage", "imgSrc", "onClick", "", FirebaseAnalytics.Param.INDEX, "providePainter", "onShow", "onDismiss", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BaseLayer implements ILayer {

    @NotNull
    private final Context context;
    public ILayerController controller;
    private boolean layerInit;

    @NotNull
    private LayerView layerView;

    /* renamed from: painter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy painter;
    private int targetCounts;

    public BaseLayer(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.painter = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.wedgit.overlayView.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IPainter providePainter;
                providePainter = BaseLayer.this.providePainter();
                return providePainter;
            }
        });
        LayerView layerView = new LayerView(context);
        layerView.setBackColor(androidx.core.content.a.getColor(layerView.getContext(), getPainter().getBackgroundColor()));
        layerView.setDrawCallBack(new BaseLayer$1$1(getPainter()));
        layerView.setTargetClickListener(new BaseLayer$1$2(this));
        this.layerView = layerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addHighlight$lambda$3(BaseLayer baseLayer, View view) {
        baseLayer.addHighlight(HighLightUtils.INSTANCE.getViewAbsRect(view));
    }

    private final IPainter getPainter() {
        return (IPainter) this.painter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getView$lambda$2(BaseLayer baseLayer) {
        baseLayer.layerView.requestLayout();
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.ILayer
    @NotNull
    public BaseLayer addHighlight(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.targetCounts++;
        view.post(new Runnable() { // from class: com.qiahao.base_common.wedgit.overlayView.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseLayer.addHighlight$lambda$3(BaseLayer.this, view);
            }
        });
        return this;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final ILayerController getController$base_common_release() {
        ILayerController iLayerController = this.controller;
        if (iLayerController != null) {
            return iLayerController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("controller");
        return null;
    }

    @NotNull
    public final View getView() {
        if (!this.layerInit) {
            this.layerView.post(new Runnable() { // from class: com.qiahao.base_common.wedgit.overlayView.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseLayer.getView$lambda$2(BaseLayer.this);
                }
            });
            this.layerInit = true;
        }
        return this.layerView;
    }

    public void onClick(int index) {
        getController$base_common_release().showNext();
    }

    public abstract void onDismiss();

    public abstract void onShow();

    @NotNull
    public abstract IPainter providePainter();

    public final void setController$base_common_release(@NotNull ILayerController iLayerController) {
        Intrinsics.checkNotNullParameter(iLayerController, "<set-?>");
        this.controller = iLayerController;
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.ILayer
    @NotNull
    public BaseLayer withImage(int imgSrc) {
        ImageView imageView = new ImageView(this.context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(this.context, imgSrc));
        withView(imageView, 0, 0, Location.TO_BOTTOM);
        return this;
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.ILayer
    @NotNull
    public BaseLayer withView(@NotNull View view, int verticalOffset, int horizontalOffset, @NotNull Location... locations) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(locations, "locations");
        this.layerView.addExtraView(view, this.targetCounts - 1, verticalOffset, horizontalOffset, ArraysKt.toList(locations));
        return this;
    }

    private final BaseLayer addHighlight(Rect rect) {
        this.targetCounts++;
        this.layerView.addTargetsRect(rect);
        return this;
    }
}
