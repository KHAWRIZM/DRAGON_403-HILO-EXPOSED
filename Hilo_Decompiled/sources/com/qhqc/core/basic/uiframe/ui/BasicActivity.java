package com.qhqc.core.basic.uiframe.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.d3;
import androidx.core.view.p1;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0003J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\tH\u0014J\b\u0010\u0015\u001a\u00020\tH\u0014J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/BasicActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "isPaused", "", "()Z", "setPaused", "(Z)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "callUpActivity", "hideSystemBar", "isHide", "isDarkTheme", "isFullScreen", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "setDarkThemeBar", "isDark", "setWindowDarkTheme", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicActivity extends AppCompatActivity {
    private boolean isPaused = true;

    @SuppressLint({"DiscouragedPrivateApi"})
    private final void callUpActivity() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mCalled");
            declaredField.setAccessible(true);
            declaredField.setBoolean(this, true);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
        }
    }

    private final void hideSystemBar(boolean isHide) {
        d3 a10 = p1.a(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(a10, "getInsetsController(...)");
        if (isHide) {
            a10.a(d2.m.g());
            a10.e(2);
        } else {
            a10.f(d2.m.g());
        }
    }

    private final void setWindowDarkTheme(boolean isDark) {
        d3 a10 = p1.a(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(a10, "getInsetsController(...)");
        a10.d(isDark);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(@NotNull Context newBase) {
        Intrinsics.checkNotNullParameter(newBase, "newBase");
        Configuration configuration = newBase.getResources().getConfiguration();
        configuration.fontScale = 1.0f;
        Unit unit = Unit.INSTANCE;
        super.attachBaseContext(newBase.createConfigurationContext(configuration));
    }

    protected boolean isDarkTheme() {
        return false;
    }

    protected boolean isFullScreen() {
        return false;
    }

    /* renamed from: isPaused, reason: from getter */
    protected final boolean getIsPaused() {
        return this.isPaused;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        EdgeToEdge.enable$default(this, null, null, 3, null);
        super.onCreate(savedInstanceState);
        if (isFullScreen()) {
            hideSystemBar(true);
        } else {
            d1.E0(getWindow().getDecorView(), new RootViewDeferringInsetsCallback(d2.m.g(), d2.m.b()));
        }
        setWindowDarkTheme(isDarkTheme());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.isPaused = true;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.isPaused = false;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 28 && i10 >= 24) {
            try {
                super.onResume();
                return;
            } catch (Exception e10) {
                callUpActivity();
                e10.printStackTrace();
                return;
            }
        }
        super.onResume();
    }

    public void setDarkThemeBar(boolean isDark) {
        if (isFullScreen()) {
            return;
        }
        setWindowDarkTheme(isDark);
    }

    protected final void setPaused(boolean z10) {
        this.isPaused = z10;
    }
}
