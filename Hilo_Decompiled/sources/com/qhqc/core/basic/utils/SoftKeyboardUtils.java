package com.qhqc.core.basic.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\f¨\u0006\u0013"}, d2 = {"Lcom/qhqc/core/basic/utils/SoftKeyboardUtils;", "", "()V", "fixLeak", "", "context", "Landroid/content/Context;", "hideSoftKeyboard", "activity", "Landroid/app/Activity;", "viewList", "", "Landroid/view/View;", "(Landroid/content/Context;[Landroid/view/View;)V", "showSoftInput", "editText", "Landroid/widget/EditText;", "showSoftKeyboard", ViewHierarchyConstants.VIEW_KEY, "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SoftKeyboardUtils {

    @NotNull
    public static final SoftKeyboardUtils INSTANCE = new SoftKeyboardUtils();

    private SoftKeyboardUtils() {
    }

    public final void fixLeak(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            String[] strArr = {"mNextServedView", "mLastSrvView"};
            for (int i10 = 0; i10 < 2; i10++) {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i10]);
                Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                    declaredField.set(inputMethodManager, null);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void hideSoftKeyboard(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public final void showSoftInput(@Nullable EditText editText) {
        if (editText == null) {
            return;
        }
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        Object systemService = editText.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 0);
    }

    public final void showSoftKeyboard(@NotNull Context context, @Nullable View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view, 0);
    }

    public final void hideSoftKeyboard(@NotNull Context context, @NotNull View... viewList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewList, "viewList");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        for (View view : viewList) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }
}
