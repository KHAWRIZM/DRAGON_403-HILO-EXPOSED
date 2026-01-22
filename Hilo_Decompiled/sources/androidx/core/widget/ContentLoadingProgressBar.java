package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    long f٣٠٦٢a;

    /* renamed from: b, reason: collision with root package name */
    boolean f٣٠٦٣b;

    /* renamed from: c, reason: collision with root package name */
    boolean f٣٠٦٤c;

    /* renamed from: d, reason: collision with root package name */
    boolean f٣٠٦٥d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f٣٠٦٦e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f٣٠٦٧f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f٣٠٦٣b = false;
        this.f٣٠٦٢a = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f٣٠٦٤c = false;
        if (!this.f٣٠٦٥d) {
            this.f٣٠٦٢a = System.currentTimeMillis();
            setVisibility(0);
        }
    }

    private void e() {
        removeCallbacks(this.f٣٠٦٦e);
        removeCallbacks(this.f٣٠٦٧f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f٣٠٦٢a = -1L;
        this.f٣٠٦٣b = false;
        this.f٣٠٦٤c = false;
        this.f٣٠٦٥d = false;
        this.f٣٠٦٦e = new Runnable() { // from class: androidx.core.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.c();
            }
        };
        this.f٣٠٦٧f = new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.d();
            }
        };
    }
}
