package com.qiahao.base_common.wedgit.overlayView;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/HighlightGuideManager;", "Lcom/qiahao/base_common/wedgit/overlayView/ILayerController;", "parentView", "Landroid/widget/FrameLayout;", "<init>", "(Landroid/widget/FrameLayout;)V", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getParentView", "()Landroid/widget/FrameLayout;", "layerQueue", "Ljava/util/Queue;", "Lcom/qiahao/base_common/wedgit/overlayView/BaseLayer;", "currentLayer", "dismissCurrent", "", "showNext", "show", "addLayer", "layer", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HighlightGuideManager implements ILayerController {

    @Nullable
    private BaseLayer currentLayer;

    @NotNull
    private final Queue<BaseLayer> layerQueue;

    @NotNull
    private final FrameLayout parentView;

    public HighlightGuideManager(@NotNull FrameLayout parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        this.parentView = parentView;
        this.layerQueue = new LinkedList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(HighlightGuideManager highlightGuideManager) {
        View view;
        FrameLayout frameLayout = highlightGuideManager.parentView;
        BaseLayer baseLayer = highlightGuideManager.currentLayer;
        if (baseLayer != null) {
            view = baseLayer.getView();
        } else {
            view = null;
        }
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        BaseLayer baseLayer2 = highlightGuideManager.currentLayer;
        if (baseLayer2 != null) {
            baseLayer2.onShow();
        }
    }

    @NotNull
    public final HighlightGuideManager addLayer(@NotNull BaseLayer layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        layer.setController$base_common_release(this);
        this.layerQueue.add(layer);
        return this;
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.ILayerController
    public void dismissCurrent() {
        View view;
        BaseLayer baseLayer = this.currentLayer;
        if (baseLayer != null) {
            baseLayer.onDismiss();
            FrameLayout frameLayout = this.parentView;
            BaseLayer baseLayer2 = this.currentLayer;
            if (baseLayer2 != null) {
                view = baseLayer2.getView();
            } else {
                view = null;
            }
            frameLayout.removeView(view);
            this.layerQueue.poll();
        }
    }

    @NotNull
    public final FrameLayout getParentView() {
        return this.parentView;
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.ILayerController
    public void show() {
        if (!this.layerQueue.isEmpty()) {
            this.currentLayer = this.layerQueue.peek();
            this.parentView.post(new Runnable() { // from class: com.qiahao.base_common.wedgit.overlayView.e
                @Override // java.lang.Runnable
                public final void run() {
                    HighlightGuideManager.show$lambda$0(HighlightGuideManager.this);
                }
            });
        }
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.ILayerController
    public void showNext() {
        dismissCurrent();
        show();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HighlightGuideManager(@NotNull Activity activity) {
        this((FrameLayout) r2);
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
    }
}
