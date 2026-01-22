package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    private static Configuration f٨٢٢f;

    /* renamed from: a, reason: collision with root package name */
    private int f٨٢٣a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f٨٢٤b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f٨٢٥c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f٨٢٦d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f٨٢٧e;

    public d(Context context, int i10) {
        super(context);
        this.f٨٢٣a = i10;
    }

    private Resources b() {
        if (this.f٨٢٧e == null) {
            Configuration configuration = this.f٨٢٦d;
            if (configuration != null && (Build.VERSION.SDK_INT < 26 || !e(configuration))) {
                this.f٨٢٧e = createConfigurationContext(this.f٨٢٦d).getResources();
            } else {
                this.f٨٢٧e = super.getResources();
            }
        }
        return this.f٨٢٧e;
    }

    private void d() {
        boolean z10;
        if (this.f٨٢٤b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f٨٢٤b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f٨٢٤b.setTo(theme);
            }
        }
        f(this.f٨٢٤b, this.f٨٢٣a, z10);
    }

    private static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f٨٢٢f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = DownloadProgress.UNKNOWN_PROGRESS;
            f٨٢٢f = configuration2;
        }
        return configuration.equals(f٨٢٢f);
    }

    public void a(Configuration configuration) {
        if (this.f٨٢٧e == null) {
            if (this.f٨٢٦d == null) {
                this.f٨٢٦d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int c() {
        return this.f٨٢٣a;
    }

    protected void f(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f٨٢٥c == null) {
                this.f٨٢٥c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f٨٢٥c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f٨٢٤b;
        if (theme != null) {
            return theme;
        }
        if (this.f٨٢٣a == 0) {
            this.f٨٢٣a = R.style.Theme_AppCompat_Light;
        }
        d();
        return this.f٨٢٤b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f٨٢٣a != i10) {
            this.f٨٢٣a = i10;
            d();
        }
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f٨٢٤b = theme;
    }
}
