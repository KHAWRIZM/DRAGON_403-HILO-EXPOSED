package com.tencent.qcloud.tuicore.component.activities;

import android.os.Bundle;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BaseMinimalistLightActivity extends AppCompatActivity {
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        hideSoftInput();
        super/*android.app.Activity*/.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        Window window = getWindow();
        if (window != null) {
            inputMethodManager.hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        getWindow().clearFlags(134217728);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(-1);
        getWindow().setNavigationBarColor(-1);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8208);
    }
}
