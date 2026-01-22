package com.qmuiteam.qmui.widget.webview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.a0;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import ic.e;
import ic.n;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIWebView extends WebView {

    /* renamed from: g, reason: collision with root package name */
    private static boolean f١٣٤٤٩g;

    /* renamed from: a, reason: collision with root package name */
    private Object f١٣٤٥٠a;

    /* renamed from: b, reason: collision with root package name */
    private Object f١٣٤٥١b;

    /* renamed from: c, reason: collision with root package name */
    private Method f١٣٤٥٢c;

    /* renamed from: d, reason: collision with root package name */
    private Rect f١٣٤٥٣d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٣٤٥٤e;

    /* renamed from: f, reason: collision with root package name */
    private List f١٣٤٥٥f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a implements n.i {
        a() {
        }

        @Override // ic.n.i
        public void a(View view, b0 b0Var) {
            if (QMUIWebView.this.f١٣٤٥٤e) {
                float c10 = e.c(QMUIWebView.this.getContext());
                QMUIWebView.this.setStyleDisplayCutoutSafeArea(new Rect((int) ((b0Var.f٢٧٩٣a / c10) + QMUIWebView.this.h(c10)), (int) ((b0Var.f٢٧٩٤b / c10) + QMUIWebView.this.j(c10)), (int) ((b0Var.f٢٧٩٥c / c10) + QMUIWebView.this.i(c10)), (int) ((b0Var.f٢٧٩٦d / c10) + QMUIWebView.this.g(c10))));
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
    }

    public QMUIWebView(Context context) {
        super(context);
        this.f١٣٤٥٤e = false;
        this.f١٣٤٥٥f = new ArrayList();
        m();
    }

    private void e() {
        f١٣٤٤٩g = true;
    }

    private Object f(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mAwContents");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            }
        } catch (NoSuchFieldException unused) {
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object obj2 = field.get(obj);
            if (obj2 != null && obj2.getClass().getSimpleName().equals("AwContents")) {
                return obj2;
            }
        }
        return null;
    }

    private Method k(Object obj) {
        try {
            return obj.getClass().getDeclaredMethod("setDisplayCutoutSafeArea", Rect.class);
        } catch (NoSuchMethodException unused) {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.getReturnType() == Void.TYPE && method.getParameterTypes().length == 1 && method.getParameterTypes()[0] == Rect.class) {
                    return method;
                }
            }
            return null;
        }
    }

    private Object l(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mWebContents");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            }
        } catch (NoSuchFieldException unused) {
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object obj2 = field.get(obj);
            if (obj2 != null && obj2.getClass().getSimpleName().equals("WebContentsImpl")) {
                return obj2;
            }
        }
        return null;
    }

    private void m() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        n.e(this, d2.m.f() | d2.m.a(), new a(), true, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyleDisplayCutoutSafeArea(Rect rect) {
        Rect rect2;
        if (f١٣٤٤٩g || Build.VERSION.SDK_INT <= 24 || rect == (rect2 = this.f١٣٤٥٣d)) {
            return;
        }
        if (rect2 == null) {
            this.f١٣٤٥٣d = new Rect(rect);
        } else {
            rect2.set(rect);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f١٣٤٥٠a == null || this.f١٣٤٥١b == null || this.f١٣٤٥٢c == null) {
            try {
                Field declaredField = WebView.class.getDeclaredField("mProvider");
                declaredField.setAccessible(true);
                Object f10 = f(declaredField.get(this));
                this.f١٣٤٥٠a = f10;
                if (f10 == null) {
                    return;
                }
                Object l10 = l(f10);
                this.f١٣٤٥١b = l10;
                if (l10 == null) {
                    return;
                }
                Method k10 = k(l10);
                this.f١٣٤٥٢c = k10;
                if (k10 == null) {
                    e();
                    return;
                }
            } catch (Exception e10) {
                e();
                Log.i("QMUIWebView", "setStyleDisplayCutoutSafeArea error: " + e10);
            }
        }
        try {
            this.f١٣٤٥٢c.setAccessible(true);
            this.f١٣٤٥٢c.invoke(this.f١٣٤٥١b, rect);
        } catch (Exception e11) {
            f١٣٤٤٩g = true;
            Log.i("QMUIWebView", "setStyleDisplayCutoutSafeArea error: " + e11);
        }
        Log.i("QMUIWebView", "setDisplayCutoutSafeArea speed time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void addCustomOnScrollChangeListener(c cVar) {
        if (!this.f١٣٤٥٥f.contains(cVar)) {
            this.f١٣٤٥٥f.add(cVar);
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f١٣٤٥٠a = null;
        this.f١٣٤٥١b = null;
        this.f١٣٤٥٢c = null;
        stopLoading();
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    protected int g(float f10) {
        return 0;
    }

    protected int h(float f10) {
        return 0;
    }

    protected int i(float f10) {
        return 0;
    }

    protected int j(float f10) {
        return 0;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d1.n0(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        Iterator it = this.f١٣٤٥٥f.iterator();
        if (!it.hasNext()) {
            return;
        }
        a0.a(it.next());
        throw null;
    }

    public void removeOnScrollChangeListener(c cVar) {
        this.f١٣٤٥٥f.remove(cVar);
    }

    public void setCallback(b bVar) {
    }

    @Deprecated
    public void setCustomOnScrollChangeListener(c cVar) {
        addCustomOnScrollChangeListener(cVar);
    }

    public void setNeedDispatchSafeAreaInset(boolean z10) {
        if (this.f١٣٤٥٤e != z10) {
            this.f١٣٤٥٤e = z10;
            if (d1.U(this)) {
                if (z10) {
                    d1.n0(this);
                } else {
                    setStyleDisplayCutoutSafeArea(new Rect());
                }
            }
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient == null) {
            super.setWebViewClient(webViewClient);
            return;
        }
        throw new IllegalArgumentException("must use the instance of QMUIWebViewClient");
    }

    public QMUIWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣٤٥٤e = false;
        this.f١٣٤٥٥f = new ArrayList();
        m();
    }

    public QMUIWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٤٥٤e = false;
        this.f١٣٤٥٥f = new ArrayList();
        m();
    }
}
