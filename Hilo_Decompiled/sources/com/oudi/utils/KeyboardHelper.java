package com.oudi.utils;

import android.app.Application;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001)B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u0018JR\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0016\u0010$\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0018J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lcom/oudi/utils/KeyboardHelper;", "Landroid/view/View$OnLayoutChangeListener;", "anyView", "Landroid/view/View;", "hasNavigationBar", "", "navigationBarHeight", "", "<init>", "(Landroid/view/View;ZI)V", "softInputHeight", "softInputHeightChanged", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/oudi/utils/KeyboardHelper$OnKeyboardChangedListener;", "isSoftInputShowing", "rootView", "getRootView", "()Landroid/view/View;", "minOffset", "getMinOffset", "()I", "minOffset$delegate", "Lkotlin/Lazy;", "registerKeyboardChangedListener", "", "unRegisterKeyboardChangedListener", "onLayoutChange", "v", ViewHierarchyConstants.DIMENSION_LEFT_KEY, ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "updateNavigationBarState", "onCleared", "log", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "OnKeyboardChangedListener", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class KeyboardHelper implements View.OnLayoutChangeListener {
    private final View anyView;
    private boolean hasNavigationBar;
    private boolean isSoftInputShowing;
    private OnKeyboardChangedListener listener;

    /* renamed from: minOffset$delegate, reason: from kotlin metadata */
    private final Lazy minOffset;
    private int navigationBarHeight;
    private int softInputHeight;
    private boolean softInputHeightChanged;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/oudi/utils/KeyboardHelper$OnKeyboardChangedListener;", "", "onChanged", "", "isPopup", "", "keyboardHeight", "", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnKeyboardChangedListener {
        void onChanged(boolean isPopup, int keyboardHeight);
    }

    public KeyboardHelper(View anyView, boolean z10, int i10) {
        Intrinsics.checkNotNullParameter(anyView, "anyView");
        this.anyView = anyView;
        this.hasNavigationBar = z10;
        this.navigationBarHeight = i10;
        this.minOffset = LazyKt.lazy(new Function0() { // from class: com.oudi.utils.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int minOffset_delegate$lambda$0;
                minOffset_delegate$lambda$0 = KeyboardHelper.minOffset_delegate$lambda$0();
                return Integer.valueOf(minOffset_delegate$lambda$0);
            }
        });
    }

    private final int getMinOffset() {
        return ((Number) this.minOffset.getValue()).intValue();
    }

    private final View getRootView() {
        return this.anyView.getRootView();
    }

    private final void log(String message) {
        Log.e("ChatLayout -Keyboard", message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int minOffset_delegate$lambda$0() {
        UiUtils uiUtils = UiUtils.INSTANCE;
        Application app = AppUtils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "getApp(...)");
        int screenWidth = uiUtils.getScreenWidth(app);
        if (screenWidth == 0) {
            return 200;
        }
        return screenWidth / 3;
    }

    public final void onCleared() {
        unRegisterKeyboardChangedListener();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View v10, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        int i10;
        int i11;
        if (getRootView() == null) {
            return;
        }
        View rootView = getRootView();
        Intrinsics.checkNotNull(rootView);
        int height = rootView.getHeight();
        Rect rect = new Rect();
        View rootView2 = getRootView();
        Intrinsics.checkNotNull(rootView2);
        rootView2.getWindowVisibleDisplayFrame(rect);
        boolean z10 = false;
        if (this.hasNavigationBar) {
            i10 = this.navigationBarHeight;
        } else {
            i10 = 0;
        }
        int i12 = height - i10;
        if (i12 - rect.bottom > getMinOffset()) {
            i11 = i12 - rect.bottom;
            if (this.softInputHeight != i11) {
                this.softInputHeightChanged = true;
                this.softInputHeight = i11;
            } else {
                this.softInputHeightChanged = false;
            }
            z10 = true;
        } else {
            i11 = 0;
        }
        this.anyView.getLocationOnScreen(new int[2]);
        if (this.isSoftInputShowing != z10 || (z10 && this.softInputHeightChanged)) {
            OnKeyboardChangedListener onKeyboardChangedListener = this.listener;
            if (onKeyboardChangedListener != null) {
                onKeyboardChangedListener.onChanged(z10, i11);
            }
            this.isSoftInputShowing = z10;
        }
    }

    public final void registerKeyboardChangedListener(OnKeyboardChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        unRegisterKeyboardChangedListener();
        this.listener = listener;
        View rootView = getRootView();
        if (rootView != null) {
            rootView.addOnLayoutChangeListener(this);
        }
    }

    public final void unRegisterKeyboardChangedListener() {
        View rootView = getRootView();
        if (rootView != null) {
            rootView.removeOnLayoutChangeListener(this);
        }
    }

    public final void updateNavigationBarState(boolean hasNavigationBar, int navigationBarHeight) {
        this.hasNavigationBar = hasNavigationBar;
        this.navigationBarHeight = navigationBarHeight;
    }
}
