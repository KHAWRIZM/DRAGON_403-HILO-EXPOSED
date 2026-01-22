package com.oudi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.lang.reflect.Field;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class KeyboardUtils {
    private static ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private static OnSoftInputChangedListener onSoftInputChangedListener;
    private static int sContentViewInvisibleHeightPre5497;
    private static int sDecorViewDelta;
    private static int sDecorViewInvisibleHeightPre;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnSoftInputChangedListener {
        void onSoftInputChanged(int i10);
    }

    private KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void clickBlankArea2HideSoftInput() {
        Log.i("KeyboardUtils", "Please refer to the following code.");
    }

    public static void fixAndroidBug5497(final Activity activity) {
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(android.R.id.content);
        final View childAt = frameLayout.getChildAt(0);
        final int paddingBottom = childAt.getPaddingBottom();
        sContentViewInvisibleHeightPre5497 = getContentViewInvisibleHeight(activity);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oudi.utils.KeyboardUtils.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int contentViewInvisibleHeight = KeyboardUtils.getContentViewInvisibleHeight(activity);
                if (KeyboardUtils.sContentViewInvisibleHeightPre5497 != contentViewInvisibleHeight) {
                    View view = childAt;
                    view.setPadding(view.getPaddingStart(), childAt.getPaddingTop(), childAt.getPaddingEnd(), paddingBottom + KeyboardUtils.getDecorViewInvisibleHeight(activity));
                    KeyboardUtils.sContentViewInvisibleHeightPre5497 = contentViewInvisibleHeight;
                }
            }
        });
    }

    public static void fixSoftInputLeaks(Context context) {
        if (context == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) AppUtils.getApp().getSystemService("input_method");
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView", "mLastSrvView"};
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i10]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj instanceof View) {
                    if (((View) obj).getContext() == context) {
                        declaredField.set(inputMethodManager, null);
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getContentViewInvisibleHeight(Activity activity) {
        View findViewById = activity.findViewById(android.R.id.content);
        if (findViewById == null) {
            return sContentViewInvisibleHeightPre5497;
        }
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getContentViewInvisibleHeight: " + (findViewById.getBottom() - rect.bottom));
        int abs = Math.abs(findViewById.getBottom() - rect.bottom);
        if (abs <= getStatusBarHeight() + getNavBarHeight()) {
            return 0;
        }
        return abs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getDecorViewInvisibleHeight(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            return sDecorViewInvisibleHeightPre;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getDecorViewInvisibleHeight: " + (decorView.getBottom() - rect.bottom));
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= getNavBarHeight()) {
            sDecorViewDelta = abs;
            return 0;
        }
        return abs - sDecorViewDelta;
    }

    private static int getNavBarHeight() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static int getStatusBarHeight() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static void hideSoftInput(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity == null || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static void hideSoftInputUsingToggle(Activity activity) {
        if (activity == null || !isSoftInputVisible(activity)) {
            return;
        }
        toggleSoftInput();
    }

    public static boolean isShouldHideKeyboard(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        int height = view.getHeight() + i11;
        int width = view.getWidth() + i10;
        if (motionEvent.getX() > i10 && motionEvent.getX() < width && motionEvent.getY() > i11 && motionEvent.getY() < height) {
            return false;
        }
        return true;
    }

    public static boolean isSoftInputVisible(Activity activity) {
        if (getDecorViewInvisibleHeight(activity) > 0) {
            return true;
        }
        return false;
    }

    public static void registerSoftInputChangedListener(final Activity activity, OnSoftInputChangedListener onSoftInputChangedListener2) {
        if ((activity.getWindow().getAttributes().flags & 512) != 0) {
            activity.getWindow().clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(android.R.id.content);
        sDecorViewInvisibleHeightPre = getDecorViewInvisibleHeight(activity);
        onSoftInputChangedListener = onSoftInputChangedListener2;
        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.oudi.utils.KeyboardUtils.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int decorViewInvisibleHeight;
                if (KeyboardUtils.onSoftInputChangedListener != null && KeyboardUtils.sDecorViewInvisibleHeightPre != (decorViewInvisibleHeight = KeyboardUtils.getDecorViewInvisibleHeight(activity))) {
                    KeyboardUtils.onSoftInputChangedListener.onSoftInputChanged(decorViewInvisibleHeight);
                    KeyboardUtils.sDecorViewInvisibleHeightPre = decorViewInvisibleHeight;
                }
            }
        };
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void showSoftInput(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager == null) {
            return;
        }
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
            currentFocus.setFocusable(true);
            currentFocus.setFocusableInTouchMode(true);
            currentFocus.requestFocus();
        }
        inputMethodManager.showSoftInput(currentFocus, 2);
    }

    public static void showSoftInputDelay(final View view) {
        view.postDelayed(new Runnable() { // from class: com.oudi.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardUtils.showSoftInput(view);
            }
        }, 300L);
    }

    public static void showSoftInputUsingToggle(Activity activity) {
        if (activity == null || isSoftInputVisible(activity)) {
            return;
        }
        toggleSoftInput();
    }

    public static void toggleSoftInput() {
        ((InputMethodManager) AppUtils.getApp().getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public static void unregisterSoftInputChangedListener(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.findViewById(android.R.id.content).getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        onSoftInputChangedListener = null;
        onGlobalLayoutListener = null;
    }

    public static void hideSoftInput(View view) {
        ((InputMethodManager) AppUtils.getApp().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showSoftInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) AppUtils.getApp().getSystemService("input_method");
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 2);
    }
}
