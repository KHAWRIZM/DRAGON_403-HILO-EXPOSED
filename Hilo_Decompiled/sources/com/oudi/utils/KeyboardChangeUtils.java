package com.oudi.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/oudi/utils/KeyboardChangeUtils;", "", "activity", "Landroid/app/Activity;", "isAdjustSize", "", "<init>", "(Landroid/app/Activity;Z)V", "()Z", "mChildOfContent", "Landroid/view/View;", "usableHeightPrevious", "", "frameLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/oudi/utils/KeyboardChangeUtils$OnKeyboardChangedListener;", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "possiblyResizeChildOfContent", "", "computeUsableHeight", "registerKeyboardChangedListener", "unRegisterKeyboard", "OnKeyboardChangedListener", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class KeyboardChangeUtils {
    private final FrameLayout.LayoutParams frameLayoutParams;
    private final boolean isAdjustSize;
    private final ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private OnKeyboardChangedListener listener;
    private final View mChildOfContent;
    private int usableHeightPrevious;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/oudi/utils/KeyboardChangeUtils$OnKeyboardChangedListener;", "", "onChanged", "", "isPopup", "", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnKeyboardChangedListener {
        void onChanged(boolean isPopup);
    }

    public KeyboardChangeUtils(Activity activity, boolean z10) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.isAdjustSize = z10;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oudi.utils.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                KeyboardChangeUtils.this.possiblyResizeChildOfContent();
            }
        };
        this.layoutListener = onGlobalLayoutListener;
        View findViewById = activity.findViewById(android.R.id.content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        View childAt = ((FrameLayout) findViewById).getChildAt(0);
        this.mChildOfContent = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        this.frameLayoutParams = (FrameLayout.LayoutParams) layoutParams;
    }

    private final int computeUsableHeight() {
        Rect rect = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void possiblyResizeChildOfContent() {
        int computeUsableHeight = computeUsableHeight();
        if (computeUsableHeight != this.usableHeightPrevious) {
            int height = this.mChildOfContent.getRootView().getHeight();
            int i10 = height - computeUsableHeight;
            if (i10 > height / 4) {
                OnKeyboardChangedListener onKeyboardChangedListener = this.listener;
                if (onKeyboardChangedListener != null) {
                    onKeyboardChangedListener.onChanged(true);
                }
            } else {
                OnKeyboardChangedListener onKeyboardChangedListener2 = this.listener;
                if (onKeyboardChangedListener2 != null) {
                    onKeyboardChangedListener2.onChanged(false);
                }
            }
            if (this.isAdjustSize) {
                this.frameLayoutParams.height = height - i10;
                this.mChildOfContent.requestLayout();
            }
            this.usableHeightPrevious = computeUsableHeight;
        }
    }

    /* renamed from: isAdjustSize, reason: from getter */
    public final boolean getIsAdjustSize() {
        return this.isAdjustSize;
    }

    public final void registerKeyboardChangedListener(OnKeyboardChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void unRegisterKeyboard() {
        this.mChildOfContent.getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
    }

    public /* synthetic */ KeyboardChangeUtils(Activity activity, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i10 & 2) != 0 ? true : z10);
    }
}
