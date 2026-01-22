package tech.sud.runtime.component.f;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tech.sud.gip.core.view.round.RoundedDrawable;
import tech.sud.runtime.component.h.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class a extends FrameLayout {
    private TextView a;
    private WebView b;
    private boolean c;
    private List<String> d;
    private boolean e;
    private int f;
    private int g;

    /* renamed from: tech.sud.runtime.component.f.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public final class C٠٠٥٩a extends Button {
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;

        public C٠٠٥٩a(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                int i = 0;
                if (action != 1) {
                    if (action == 2) {
                        int i2 = (this.d + rawX) - this.b;
                        int i3 = (this.e + rawY) - this.c;
                        int width = getWidth();
                        int height = getHeight();
                        int width2 = a.this.getWidth() - width;
                        int height2 = a.this.getHeight() - height;
                        if (i2 < 0) {
                            i2 = 0;
                        } else if (i2 > width2) {
                            i2 = width2;
                        }
                        if (i3 >= 0) {
                            if (i3 > height2) {
                                i = height2;
                            } else {
                                i = i3;
                            }
                        }
                        if (Math.pow(rawY - this.c, 2.0d) + Math.pow(rawX - this.b, 2.0d) > Math.pow(40.0d, 2.0d)) {
                            this.f = true;
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                            layoutParams.leftMargin = i2;
                            layoutParams.topMargin = i;
                            setLayoutParams(layoutParams);
                        }
                    }
                } else if (this.f) {
                    this.f = false;
                } else {
                    callOnClick();
                }
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
                this.d = layoutParams2.leftMargin;
                this.e = layoutParams2.topMargin;
                this.b = rawX;
                this.c = rawY;
            }
            return true;
        }
    }

    public a(Context context, FrameLayout frameLayout) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = new ArrayList();
        this.e = false;
        this.f = 0;
        this.g = 0;
        this.c = true;
        if (!tech.sud.runtime.component.h.a.a(context, "file:////android_asset/JSConsole/index.html")) {
            this.e = true;
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WebView webView = new WebView(context);
        this.b = webView;
        addView(webView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this, new FrameLayout.LayoutParams(-1, -1));
        WebSettings settings = this.b.getSettings();
        settings.setAppCacheEnabled(false);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        this.b.setWebChromeClient(new WebChromeClient());
        this.b.setWebViewClient(new WebViewClient() { // from class: tech.sud.runtime.component.f.a.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                a.this.e();
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                boolean didCrash;
                if (Build.VERSION.SDK_INT >= 26) {
                    StringBuilder sb2 = new StringBuilder("RenderProcessGone: ");
                    didCrash = renderProcessGoneDetail.didCrash();
                    sb2.append(didCrash);
                    Log.e("WebView", sb2.toString());
                    return true;
                }
                Log.e("WebView", "RenderProcessGone: ");
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                return true;
            }
        });
        this.a = new C٠٠٥٩a(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16749902);
        gradientDrawable.setCornerRadius(displayMetrics.density * 15.0f);
        gradientDrawable.setStroke(1, RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.a.setPadding(30, 7, 30, 7);
        this.a.setText("JSConsole");
        this.a.setTextSize(15.0f);
        this.a.setBackground(gradientDrawable);
        this.a.setTextColor(-1);
        addView(this.a, new FrameLayout.LayoutParams(-2, -2));
        post(new Runnable() { // from class: tech.sud.runtime.component.f.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.d();
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: tech.sud.runtime.component.f.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.c) {
                    a.this.b();
                } else {
                    a.this.a();
                }
            }
        });
        this.b.loadUrl("file:////android_asset/JSConsole/index.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
        this.g = this.a.getWidth();
        this.f = this.a.getHeight();
        layoutParams.leftMargin = (getWidth() - r1) - 50;
        layoutParams.topMargin = (getHeight() - r2) - 30;
        this.a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.e = true;
        if (!this.d.isEmpty()) {
            Iterator<String> it = this.d.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
            this.d = new ArrayList();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        f.b("JSConsole", String.format("%d, %d", Integer.valueOf(i5), Integer.valueOf(i6)));
        post(new Runnable() { // from class: tech.sud.runtime.component.f.a.4
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(i5, i6);
            }
        });
    }

    public void b() {
        this.c = false;
        WebView webView = this.b;
        if (webView != null) {
            webView.setVisibility(4);
        }
    }

    public void c() {
        removeAllViews();
        WebView webView = this.b;
        if (webView != null) {
            webView.setVisibility(8);
            this.b.removeAllViews();
            this.b.destroy();
            this.b = null;
        }
    }

    public void a() {
        this.c = true;
        WebView webView = this.b;
        if (webView != null) {
            webView.setVisibility(0);
        }
    }

    private static String b(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        boolean z;
        TextView textView = this.a;
        if (textView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        boolean z2 = true;
        if (layoutParams.leftMargin + this.g > i) {
            layoutParams.leftMargin = (i - r1) - 50;
            z = true;
        } else {
            z = false;
        }
        if (layoutParams.topMargin + this.f > i2) {
            layoutParams.topMargin = (i2 - r1) - 30;
        } else {
            z2 = z;
        }
        if (z2) {
            this.a.setLayoutParams(layoutParams);
        }
    }

    private void c(String str) {
        WebView webView = this.b;
        if (webView != null) {
            webView.loadUrl("javascript:addLog('" + b(str) + "')");
        }
    }

    public void a(String str) {
        if (this.b == null) {
            return;
        }
        if (!this.e) {
            this.d.add(str);
        } else {
            c(str);
        }
    }
}
