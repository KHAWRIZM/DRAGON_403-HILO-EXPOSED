package a8;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.activity.BackEventCompat;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final TimeInterpolator f٤٢٣a = new PathInterpolator(0.1f, 0.1f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    protected final View f٤٢٤b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f٤٢٥c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f٤٢٦d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f٤٢٧e;

    /* renamed from: f, reason: collision with root package name */
    private BackEventCompat f٤٢٨f;

    public a(View view) {
        this.f٤٢٤b = view;
        Context context = view.getContext();
        this.f٤٢٥c = k.f(context, R.attr.motionDurationMedium2, 300);
        this.f٤٢٦d = k.f(context, R.attr.motionDurationShort3, 150);
        this.f٤٢٧e = k.f(context, R.attr.motionDurationShort2, 100);
    }

    public float a(float f10) {
        return this.f٤٢٣a.getInterpolation(f10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BackEventCompat b() {
        if (this.f٤٢٨f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        BackEventCompat backEventCompat = this.f٤٢٨f;
        this.f٤٢٨f = null;
        return backEventCompat;
    }

    public BackEventCompat c() {
        BackEventCompat backEventCompat = this.f٤٢٨f;
        this.f٤٢٨f = null;
        return backEventCompat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(BackEventCompat backEventCompat) {
        this.f٤٢٨f = backEventCompat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BackEventCompat e(BackEventCompat backEventCompat) {
        if (this.f٤٢٨f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = this.f٤٢٨f;
        this.f٤٢٨f = backEventCompat;
        return backEventCompat2;
    }
}
