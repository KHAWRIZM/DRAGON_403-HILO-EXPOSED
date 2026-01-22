package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.a1;
import androidx.appcompat.widget.p0;
import androidx.appcompat.widget.z0;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.h;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import androidx.core.view.l1;
import androidx.core.view.n1;
import androidx.core.view.u;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.luck.picture.lib.config.PictureMimeType;
import com.qhqc.core.feature.community.events.CommentEvent;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AppCompatDelegateImpl extends androidx.appcompat.app.e implements g.a, LayoutInflater.Factory2 {

    /* renamed from: j0, reason: collision with root package name */
    private static final SimpleArrayMap f٦٤١j0 = new SimpleArrayMap();

    /* renamed from: k0, reason: collision with root package name */
    private static final boolean f٦٤٢k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private static final int[] f٦٤٣l0 = {R.attr.windowBackground};

    /* renamed from: m0, reason: collision with root package name */
    private static final boolean f٦٤٤m0 = !"robolectric".equals(Build.FINGERPRINT);
    private boolean A;

    /* renamed from: B, reason: collision with root package name */
    ViewGroup f٦٤٥B;
    private TextView C;
    private View D;
    private boolean E;
    private boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    private boolean L;
    private PanelFeatureState[] M;
    private PanelFeatureState N;
    private boolean O;
    private boolean P;
    private boolean Q;
    boolean R;
    private Configuration S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private p X;
    private p Y;
    boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    int f٦٤٦a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Runnable f٦٤٧b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f٦٤٨c0;

    /* renamed from: d0, reason: collision with root package name */
    private Rect f٦٤٩d0;

    /* renamed from: e0, reason: collision with root package name */
    private Rect f٦٥٠e0;

    /* renamed from: f0, reason: collision with root package name */
    private w f٦٥١f0;

    /* renamed from: g0, reason: collision with root package name */
    private x f٦٥٢g0;

    /* renamed from: h0, reason: collision with root package name */
    private OnBackInvokedDispatcher f٦٥٣h0;

    /* renamed from: i0, reason: collision with root package name */
    private OnBackInvokedCallback f٦٥٤i0;

    /* renamed from: j, reason: collision with root package name */
    final Object f٦٥٥j;

    /* renamed from: k, reason: collision with root package name */
    final Context f٦٥٦k;

    /* renamed from: l, reason: collision with root package name */
    Window f٦٥٧l;

    /* renamed from: m, reason: collision with root package name */
    private n f٦٥٨m;

    /* renamed from: n, reason: collision with root package name */
    final androidx.appcompat.app.c f٦٥٩n;

    /* renamed from: o, reason: collision with root package name */
    androidx.appcompat.app.a f٦٦٠o;

    /* renamed from: p, reason: collision with root package name */
    MenuInflater f٦٦١p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f٦٦٢q;

    /* renamed from: r, reason: collision with root package name */
    private androidx.appcompat.widget.w f٦٦٣r;

    /* renamed from: s, reason: collision with root package name */
    private h f٦٦٤s;

    /* renamed from: t, reason: collision with root package name */
    private r f٦٦٥t;

    /* renamed from: u, reason: collision with root package name */
    androidx.appcompat.view.b f٦٦٦u;

    /* renamed from: v, reason: collision with root package name */
    ActionBarContextView f٦٦٧v;

    /* renamed from: w, reason: collision with root package name */
    PopupWindow f٦٦٨w;

    /* renamed from: x, reason: collision with root package name */
    Runnable f٦٦٩x;

    /* renamed from: y, reason: collision with root package name */
    l1 f٦٧٠y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f٦٧١z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context);
        }

        private boolean b(int i10, int i11) {
            if (i10 >= -5 && i11 >= -5 && i10 <= getWidth() + 5 && i11 <= getHeight() + 5) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!AppCompatDelegateImpl.this.j0(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.d0(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(r1.a.b(getContext(), i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        int f٦٧٣a;

        /* renamed from: b, reason: collision with root package name */
        int f٦٧٤b;

        /* renamed from: c, reason: collision with root package name */
        int f٦٧٥c;

        /* renamed from: d, reason: collision with root package name */
        int f٦٧٦d;

        /* renamed from: e, reason: collision with root package name */
        int f٦٧٧e;

        /* renamed from: f, reason: collision with root package name */
        int f٦٧٨f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f٦٧٩g;

        /* renamed from: h, reason: collision with root package name */
        View f٦٨٠h;

        /* renamed from: i, reason: collision with root package name */
        View f٦٨١i;

        /* renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.g f٦٨٢j;

        /* renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.e f٦٨٣k;

        /* renamed from: l, reason: collision with root package name */
        Context f٦٨٤l;

        /* renamed from: m, reason: collision with root package name */
        boolean f٦٨٥m;

        /* renamed from: n, reason: collision with root package name */
        boolean f٦٨٦n;

        /* renamed from: o, reason: collision with root package name */
        boolean f٦٨٧o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f٦٨٨p;

        /* renamed from: q, reason: collision with root package name */
        boolean f٦٨٩q = false;

        /* renamed from: r, reason: collision with root package name */
        boolean f٦٩٠r;

        /* renamed from: s, reason: collision with root package name */
        Bundle f٦٩١s;

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            int f٦٩٢a;

            /* renamed from: b, reason: collision with root package name */
            boolean f٦٩٣b;

            /* renamed from: c, reason: collision with root package name */
            Bundle f٦٩٤c;

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
            class a implements Parcelable.ClassLoaderCreator {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f٦٩٢a = parcel.readInt();
                boolean z10 = true;
                if (parcel.readInt() != 1) {
                    z10 = false;
                }
                savedState.f٦٩٣b = z10;
                if (z10) {
                    savedState.f٦٩٤c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f٦٩٢a);
                parcel.writeInt(this.f٦٩٣b ? 1 : 0);
                if (this.f٦٩٣b) {
                    parcel.writeBundle(this.f٦٩٤c);
                }
            }
        }

        PanelFeatureState(int i10) {
            this.f٦٧٣a = i10;
        }

        androidx.appcompat.view.menu.m a(l.a aVar) {
            if (this.f٦٨٢j == null) {
                return null;
            }
            if (this.f٦٨٣k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f٦٨٤l, androidx.appcompat.R.layout.abc_list_menu_item_layout);
                this.f٦٨٣k = eVar;
                eVar.c(aVar);
                this.f٦٨٢j.b(this.f٦٨٣k);
            }
            return this.f٦٨٣k.l(this.f٦٧٩g);
        }

        public boolean b() {
            if (this.f٦٨٠h == null) {
                return false;
            }
            if (this.f٦٨١i == null && this.f٦٨٣k.f().getCount() <= 0) {
                return false;
            }
            return true;
        }

        void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f٦٨٢j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.R(this.f٦٨٣k);
            }
            this.f٦٨٢j = gVar;
            if (gVar != null && (eVar = this.f٦٨٣k) != null) {
                gVar.b(eVar);
            }
        }

        void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(androidx.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            } else {
                newTheme.applyStyle(androidx.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f٦٨٤l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            this.f٦٧٤b = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.f٦٧٨f = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f٦٤٦a0 & 1) != 0) {
                appCompatDelegateImpl.k0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f٦٤٦a0 & 4096) != 0) {
                appCompatDelegateImpl2.k0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.Z = false;
            appCompatDelegateImpl3.f٦٤٦a0 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements j0 {
        b() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            int m10 = d2Var.m();
            int g12 = AppCompatDelegateImpl.this.g1(d2Var, null);
            if (m10 != g12) {
                d2Var = d2Var.r(d2Var.k(), g12, d2Var.l(), d2Var.j());
            }
            return d1.c0(view, d2Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements ContentFrameLayout.a {
        c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements Runnable {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a extends n1 {
            a() {
            }

            @Override // androidx.core.view.m1
            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.f٦٦٧v.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f٦٧٠y.h(null);
                AppCompatDelegateImpl.this.f٦٧٠y = null;
            }

            @Override // androidx.core.view.n1, androidx.core.view.m1
            public void onAnimationStart(View view) {
                AppCompatDelegateImpl.this.f٦٦٧v.setVisibility(0);
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f٦٦٨w.showAtLocation(appCompatDelegateImpl.f٦٦٧v, 55, 0, 0);
            AppCompatDelegateImpl.this.l0();
            if (AppCompatDelegateImpl.this.W0()) {
                AppCompatDelegateImpl.this.f٦٦٧v.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f٦٧٠y = d1.e(appCompatDelegateImpl2.f٦٦٧v).b(1.0f);
                AppCompatDelegateImpl.this.f٦٧٠y.h(new a());
                return;
            }
            AppCompatDelegateImpl.this.f٦٦٧v.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f٦٦٧v.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class e extends n1 {
        e() {
        }

        @Override // androidx.core.view.m1
        public void onAnimationEnd(View view) {
            AppCompatDelegateImpl.this.f٦٦٧v.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f٦٧٠y.h(null);
            AppCompatDelegateImpl.this.f٦٧٠y = null;
        }

        @Override // androidx.core.view.n1, androidx.core.view.m1
        public void onAnimationStart(View view) {
            AppCompatDelegateImpl.this.f٦٦٧v.setVisibility(0);
            if (AppCompatDelegateImpl.this.f٦٦٧v.getParent() instanceof View) {
                d1.n0((View) AppCompatDelegateImpl.this.f٦٦٧v.getParent());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class f implements androidx.appcompat.app.b {
        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface g {
        boolean a(int i10);

        View onCreatePanelView(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class h implements l.a {
        h() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z10) {
            AppCompatDelegateImpl.this.b0(gVar);
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            Window.Callback x02 = AppCompatDelegateImpl.this.x0();
            if (x02 != null) {
                x02.onMenuOpened(108, gVar);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class i implements b.a {

        /* renamed from: a, reason: collision with root package name */
        private b.a f٧٠٣a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a extends n1 {
            a() {
            }

            @Override // androidx.core.view.m1
            public void onAnimationEnd(View view) {
                AppCompatDelegateImpl.this.f٦٦٧v.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f٦٦٨w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f٦٦٧v.getParent() instanceof View) {
                    d1.n0((View) AppCompatDelegateImpl.this.f٦٦٧v.getParent());
                }
                AppCompatDelegateImpl.this.f٦٦٧v.k();
                AppCompatDelegateImpl.this.f٦٧٠y.h(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f٦٧٠y = null;
                d1.n0(appCompatDelegateImpl2.f٦٤٥B);
            }
        }

        public i(b.a aVar) {
            this.f٧٠٣a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b bVar) {
            this.f٧٠٣a.a(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f٦٦٨w != null) {
                appCompatDelegateImpl.f٦٥٧l.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f٦٦٩x);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f٦٦٧v != null) {
                appCompatDelegateImpl2.l0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f٦٧٠y = d1.e(appCompatDelegateImpl3.f٦٦٧v).b(DownloadProgress.UNKNOWN_PROGRESS);
                AppCompatDelegateImpl.this.f٦٧٠y.h(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            androidx.appcompat.app.c cVar = appCompatDelegateImpl4.f٦٥٩n;
            if (cVar != null) {
                cVar.onSupportActionModeFinished(appCompatDelegateImpl4.f٦٦٦u);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f٦٦٦u = null;
            d1.n0(appCompatDelegateImpl5.f٦٤٥B);
            AppCompatDelegateImpl.this.e1();
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f٧٠٣a.b(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f٧٠٣a.c(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(androidx.appcompat.view.b bVar, Menu menu) {
            d1.n0(AppCompatDelegateImpl.this.f٦٤٥B);
            return this.f٧٠٣a.d(bVar, menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class j {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class k {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales;
            LocaleList locales2;
            boolean equals;
            locales = configuration.getLocales();
            locales2 = configuration2.getLocales();
            equals = locales.equals(locales2);
            if (!equals) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }

        static androidx.core.os.f b(Configuration configuration) {
            LocaleList locales;
            String languageTags;
            locales = configuration.getLocales();
            languageTags = locales.toLanguageTags();
            return androidx.core.os.f.c(languageTags);
        }

        public static void c(androidx.core.os.f fVar) {
            LocaleList forLanguageTags;
            forLanguageTags = LocaleList.forLanguageTags(fVar.h());
            LocaleList.setDefault(forLanguageTags);
        }

        static void d(Configuration configuration, androidx.core.os.f fVar) {
            LocaleList forLanguageTags;
            forLanguageTags = LocaleList.forLanguageTags(fVar.h());
            configuration.setLocales(forLanguageTags);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class l {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            i10 = configuration.colorMode;
            int i18 = i10 & 3;
            i11 = configuration2.colorMode;
            if (i18 != (i11 & 3)) {
                i16 = configuration3.colorMode;
                i17 = configuration2.colorMode;
                configuration3.colorMode = i16 | (i17 & 3);
            }
            i12 = configuration.colorMode;
            int i19 = i12 & 12;
            i13 = configuration2.colorMode;
            if (i19 != (i13 & 12)) {
                i14 = configuration3.colorMode;
                i15 = configuration2.colorMode;
                configuration3.colorMode = i14 | (i15 & 12);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class m {
        static OnBackInvokedDispatcher a(Activity activity) {
            OnBackInvokedDispatcher onBackInvokedDispatcher;
            onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            return onBackInvokedDispatcher;
        }

        static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.t
                public final void onBackInvoked() {
                    AppCompatDelegateImpl.this.F0();
                }
            };
            androidx.appcompat.app.p.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        static void c(Object obj, Object obj2) {
            androidx.appcompat.app.p.a(obj).unregisterOnBackInvokedCallback(androidx.appcompat.app.o.a(obj2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class o extends p {

        /* renamed from: c, reason: collision with root package name */
        private final PowerManager f٧١١c;

        o(Context context) {
            super();
            this.f٧١١c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            if (j.a(this.f٧١١c)) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            AppCompatDelegateImpl.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public abstract class p {

        /* renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f٧١٣a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        p() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f٧١٣a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f٦٥٦k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f٧١٣a = null;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            a();
            IntentFilter b10 = b();
            if (b10 != null && b10.countActions() != 0) {
                if (this.f٧١٣a == null) {
                    this.f٧١٣a = new a();
                }
                AppCompatDelegateImpl.this.f٦٥٦k.registerReceiver(this.f٧١٣a, b10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class q extends p {

        /* renamed from: c, reason: collision with root package name */
        private final d0 f٧١٦c;

        q(d0 d0Var) {
            super();
            this.f٧١٦c = d0Var;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            if (this.f٧١٦c.d()) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            AppCompatDelegateImpl.this.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class r implements l.a {
        r() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z10) {
            boolean z11;
            androidx.appcompat.view.menu.g F = gVar.F();
            if (F != gVar) {
                z11 = true;
            } else {
                z11 = false;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                gVar = F;
            }
            PanelFeatureState o02 = appCompatDelegateImpl.o0(gVar);
            if (o02 != null) {
                if (z11) {
                    AppCompatDelegateImpl.this.a0(o02.f٦٧٣a, o02, F);
                    AppCompatDelegateImpl.this.e0(o02, true);
                } else {
                    AppCompatDelegateImpl.this.e0(o02, z10);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            Window.Callback x02;
            if (gVar == gVar.F()) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if (appCompatDelegateImpl.G && (x02 = appCompatDelegateImpl.x0()) != null && !AppCompatDelegateImpl.this.R) {
                    x02.onMenuOpened(108, gVar);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.c cVar) {
        this(activity, null, cVar, activity);
    }

    private boolean A0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(q0());
        panelFeatureState.f٦٧٩g = new ListMenuDecorView(panelFeatureState.f٦٨٤l);
        panelFeatureState.f٦٧٥c = 81;
        return true;
    }

    private boolean B0(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.f٦٥٦k;
        int i10 = panelFeatureState.f٦٧٣a;
        if ((i10 == 0 || i10 == 108) && this.f٦٦٣r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.W(this);
        panelFeatureState.c(gVar);
        return true;
    }

    private void C0(int i10) {
        this.f٦٤٦a0 = (1 << i10) | this.f٦٤٦a0;
        if (!this.Z) {
            d1.i0(this.f٦٥٧l.getDecorView(), this.f٦٤٧b0);
            this.Z = true;
        }
    }

    private boolean H0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState v02 = v0(i10, true);
            if (!v02.f٦٨٧o) {
                return R0(v02, keyEvent);
            }
            return false;
        }
        return false;
    }

    private boolean K0(int i10, KeyEvent keyEvent) {
        boolean z10;
        androidx.appcompat.widget.w wVar;
        if (this.f٦٦٦u != null) {
            return false;
        }
        boolean z11 = true;
        PanelFeatureState v02 = v0(i10, true);
        if (i10 == 0 && (wVar = this.f٦٦٣r) != null && wVar.a() && !ViewConfiguration.get(this.f٦٥٦k).hasPermanentMenuKey()) {
            if (!this.f٦٦٣r.e()) {
                if (!this.R && R0(v02, keyEvent)) {
                    z11 = this.f٦٦٣r.c();
                }
                z11 = false;
            } else {
                z11 = this.f٦٦٣r.b();
            }
        } else {
            boolean z12 = v02.f٦٨٧o;
            if (!z12 && !v02.f٦٨٦n) {
                if (v02.f٦٨٥m) {
                    if (v02.f٦٩٠r) {
                        v02.f٦٨٥m = false;
                        z10 = R0(v02, keyEvent);
                    } else {
                        z10 = true;
                    }
                    if (z10) {
                        O0(v02, keyEvent);
                    }
                }
                z11 = false;
            } else {
                e0(v02, true);
                z11 = z12;
            }
        }
        if (z11) {
            AudioManager audioManager = (AudioManager) this.f٦٥٦k.getApplicationContext().getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z11;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i10;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.f٦٨٧o && !this.R) {
            if (panelFeatureState.f٦٧٣a == 0 && (this.f٦٥٦k.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
            Window.Callback x02 = x0();
            if (x02 != null && !x02.onMenuOpened(panelFeatureState.f٦٧٣a, panelFeatureState.f٦٨٢j)) {
                e0(panelFeatureState, true);
                return;
            }
            WindowManager windowManager = (WindowManager) this.f٦٥٦k.getSystemService("window");
            if (windowManager == null || !R0(panelFeatureState, keyEvent)) {
                return;
            }
            ViewGroup viewGroup = panelFeatureState.f٦٧٩g;
            if (viewGroup != null && !panelFeatureState.f٦٨٩q) {
                View view = panelFeatureState.f٦٨١i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i10 = -1;
                    panelFeatureState.f٦٨٦n = false;
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i10, -2, panelFeatureState.f٦٧٦d, panelFeatureState.f٦٧٧e, 1002, 8519680, -3);
                    layoutParams2.gravity = panelFeatureState.f٦٧٥c;
                    layoutParams2.windowAnimations = panelFeatureState.f٦٧٨f;
                    windowManager.addView(panelFeatureState.f٦٧٩g, layoutParams2);
                    panelFeatureState.f٦٨٧o = true;
                    if (panelFeatureState.f٦٧٣a != 0) {
                        e1();
                        return;
                    }
                    return;
                }
            } else {
                if (viewGroup == null) {
                    if (!A0(panelFeatureState) || panelFeatureState.f٦٧٩g == null) {
                        return;
                    }
                } else if (panelFeatureState.f٦٨٩q && viewGroup.getChildCount() > 0) {
                    panelFeatureState.f٦٧٩g.removeAllViews();
                }
                if (z0(panelFeatureState) && panelFeatureState.b()) {
                    ViewGroup.LayoutParams layoutParams3 = panelFeatureState.f٦٨٠h.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                    }
                    panelFeatureState.f٦٧٩g.setBackgroundResource(panelFeatureState.f٦٧٤b);
                    ViewParent parent = panelFeatureState.f٦٨٠h.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(panelFeatureState.f٦٨٠h);
                    }
                    panelFeatureState.f٦٧٩g.addView(panelFeatureState.f٦٨٠h, layoutParams3);
                    if (!panelFeatureState.f٦٨٠h.hasFocus()) {
                        panelFeatureState.f٦٨٠h.requestFocus();
                    }
                } else {
                    panelFeatureState.f٦٨٩q = true;
                    return;
                }
            }
            i10 = -2;
            panelFeatureState.f٦٨٦n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i10, -2, panelFeatureState.f٦٧٦d, panelFeatureState.f٦٧٧e, 1002, 8519680, -3);
            layoutParams22.gravity = panelFeatureState.f٦٧٥c;
            layoutParams22.windowAnimations = panelFeatureState.f٦٧٨f;
            windowManager.addView(panelFeatureState.f٦٧٩g, layoutParams22);
            panelFeatureState.f٦٨٧o = true;
            if (panelFeatureState.f٦٧٣a != 0) {
            }
        }
    }

    private boolean Q0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.g gVar;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f٦٨٥m || R0(panelFeatureState, keyEvent)) && (gVar = panelFeatureState.f٦٨٢j) != null) {
            z10 = gVar.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f٦٦٣r == null) {
            e0(panelFeatureState, true);
        }
        return z10;
    }

    private boolean R0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z10;
        androidx.appcompat.widget.w wVar;
        int i10;
        boolean z11;
        androidx.appcompat.widget.w wVar2;
        androidx.appcompat.widget.w wVar3;
        if (this.R) {
            return false;
        }
        if (panelFeatureState.f٦٨٥m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.N;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            e0(panelFeatureState2, false);
        }
        Window.Callback x02 = x0();
        if (x02 != null) {
            panelFeatureState.f٦٨١i = x02.onCreatePanelView(panelFeatureState.f٦٧٣a);
        }
        int i11 = panelFeatureState.f٦٧٣a;
        if (i11 != 0 && i11 != 108) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 && (wVar3 = this.f٦٦٣r) != null) {
            wVar3.f();
        }
        if (panelFeatureState.f٦٨١i == null && (!z10 || !(P0() instanceof b0))) {
            androidx.appcompat.view.menu.g gVar = panelFeatureState.f٦٨٢j;
            if (gVar == null || panelFeatureState.f٦٩٠r) {
                if (gVar == null && (!B0(panelFeatureState) || panelFeatureState.f٦٨٢j == null)) {
                    return false;
                }
                if (z10 && this.f٦٦٣r != null) {
                    if (this.f٦٦٤s == null) {
                        this.f٦٦٤s = new h();
                    }
                    this.f٦٦٣r.d(panelFeatureState.f٦٨٢j, this.f٦٦٤s);
                }
                panelFeatureState.f٦٨٢j.i0();
                if (!x02.onCreatePanelMenu(panelFeatureState.f٦٧٣a, panelFeatureState.f٦٨٢j)) {
                    panelFeatureState.c(null);
                    if (z10 && (wVar = this.f٦٦٣r) != null) {
                        wVar.d(null, this.f٦٦٤s);
                    }
                    return false;
                }
                panelFeatureState.f٦٩٠r = false;
            }
            panelFeatureState.f٦٨٢j.i0();
            Bundle bundle = panelFeatureState.f٦٩١s;
            if (bundle != null) {
                panelFeatureState.f٦٨٢j.S(bundle);
                panelFeatureState.f٦٩١s = null;
            }
            if (!x02.onPreparePanel(0, panelFeatureState.f٦٨١i, panelFeatureState.f٦٨٢j)) {
                if (z10 && (wVar2 = this.f٦٦٣r) != null) {
                    wVar2.d(null, this.f٦٦٤s);
                }
                panelFeatureState.f٦٨٢j.h0();
                return false;
            }
            if (keyEvent != null) {
                i10 = keyEvent.getDeviceId();
            } else {
                i10 = -1;
            }
            if (KeyCharacterMap.load(i10).getKeyboardType() != 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            panelFeatureState.f٦٨٨p = z11;
            panelFeatureState.f٦٨٢j.setQwertyMode(z11);
            panelFeatureState.f٦٨٢j.h0();
        }
        panelFeatureState.f٦٨٥m = true;
        panelFeatureState.f٦٨٦n = false;
        this.N = panelFeatureState;
        return true;
    }

    private void S0(boolean z10) {
        androidx.appcompat.widget.w wVar = this.f٦٦٣r;
        if (wVar != null && wVar.a() && (!ViewConfiguration.get(this.f٦٥٦k).hasPermanentMenuKey() || this.f٦٦٣r.g())) {
            Window.Callback x02 = x0();
            if (this.f٦٦٣r.e() && z10) {
                this.f٦٦٣r.b();
                if (!this.R) {
                    x02.onPanelClosed(108, v0(0, true).f٦٨٢j);
                    return;
                }
                return;
            }
            if (x02 != null && !this.R) {
                if (this.Z && (this.f٦٤٦a0 & 1) != 0) {
                    this.f٦٥٧l.getDecorView().removeCallbacks(this.f٦٤٧b0);
                    this.f٦٤٧b0.run();
                }
                PanelFeatureState v02 = v0(0, true);
                androidx.appcompat.view.menu.g gVar = v02.f٦٨٢j;
                if (gVar != null && !v02.f٦٩٠r && x02.onPreparePanel(0, v02.f٦٨١i, gVar)) {
                    x02.onMenuOpened(108, v02.f٦٨٢j);
                    this.f٦٦٣r.c();
                    return;
                }
                return;
            }
            return;
        }
        PanelFeatureState v03 = v0(0, true);
        v03.f٦٨٩q = true;
        e0(v03, false);
        O0(v03, null);
    }

    private boolean T(boolean z10) {
        return U(z10, true);
    }

    private int T0(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i10 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return i10;
    }

    private boolean U(boolean z10, boolean z11) {
        androidx.core.os.f fVar;
        if (this.R) {
            return false;
        }
        int Z = Z();
        int E0 = E0(this.f٦٥٦k, Z);
        if (Build.VERSION.SDK_INT < 33) {
            fVar = Y(this.f٦٥٦k);
        } else {
            fVar = null;
        }
        if (!z11 && fVar != null) {
            fVar = u0(this.f٦٥٦k.getResources().getConfiguration());
        }
        boolean d12 = d1(E0, fVar, z10);
        if (Z == 0) {
            t0(this.f٦٥٦k).e();
        } else {
            p pVar = this.X;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (Z == 3) {
            s0(this.f٦٥٦k).e();
        } else {
            p pVar2 = this.Y;
            if (pVar2 != null) {
                pVar2.a();
            }
        }
        return d12;
    }

    private void W() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f٦٤٥B.findViewById(R.id.content);
        View decorView = this.f٦٥٧l.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f٦٥٦k.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void X(Window window) {
        if (this.f٦٥٧l == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof n)) {
                n nVar = new n(callback);
                this.f٦٥٨m = nVar;
                window.setCallback(nVar);
                p0 u10 = p0.u(this.f٦٥٦k, null, f٦٤٣l0);
                Drawable h10 = u10.h(0);
                if (h10 != null) {
                    window.setBackgroundDrawable(h10);
                }
                u10.x();
                this.f٦٥٧l = window;
                if (Build.VERSION.SDK_INT >= 33 && this.f٦٥٣h0 == null) {
                    M(null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private boolean X0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f٦٥٧l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private int Z() {
        int i10 = this.T;
        if (i10 == -100) {
            return androidx.appcompat.app.e.m();
        }
        return i10;
    }

    private void a1() {
        if (!this.A) {
        } else {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private AppCompatActivity b1() {
        for (Context context = this.f٦٥٦k; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void c0() {
        p pVar = this.X;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.Y;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c1(Configuration configuration) {
        Activity activity = (Activity) this.f٦٥٥j;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner) activity).getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.Q && !this.R) {
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean d1(int i10, androidx.core.os.f fVar, boolean z10) {
        androidx.core.os.f u02;
        int i11;
        boolean z11;
        Configuration f02 = f0(this.f٦٥٦k, i10, fVar, null, false);
        int r02 = r0(this.f٦٥٦k);
        Configuration configuration = this.S;
        if (configuration == null) {
            configuration = this.f٦٥٦k.getResources().getConfiguration();
        }
        int i12 = configuration.uiMode & 48;
        int i13 = f02.uiMode & 48;
        androidx.core.os.f u03 = u0(configuration);
        if (fVar == null) {
            u02 = null;
        } else {
            u02 = u0(f02);
        }
        boolean z12 = false;
        if (i12 != i13) {
            i11 = 512;
        } else {
            i11 = 0;
        }
        if (u02 != null && !u03.equals(u02)) {
            i11 |= CommentEvent.EVENT_REPLY_FLOOR;
        }
        boolean z13 = true;
        if (((~r02) & i11) != 0 && z10 && this.P && (f٦٤٤m0 || this.Q)) {
            Object obj = this.f٦٥٥j;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                if (Build.VERSION.SDK_INT >= 31 && (i11 & 8192) != 0) {
                    ((Activity) this.f٦٥٥j).getWindow().getDecorView().setLayoutDirection(f02.getLayoutDirection());
                }
                androidx.core.app.b.f((Activity) this.f٦٥٥j);
                z11 = true;
                if (z11 && i11 != 0) {
                    if ((i11 & r02) == i11) {
                        z12 = true;
                    }
                    f1(i13, u02, z12, null);
                } else {
                    z13 = z11;
                }
                if (z13) {
                    Object obj2 = this.f٦٥٥j;
                    if (obj2 instanceof AppCompatActivity) {
                        if ((i11 & 512) != 0) {
                            ((AppCompatActivity) obj2).onNightModeChanged(i10);
                        }
                        if ((i11 & 4) != 0) {
                            ((AppCompatActivity) this.f٦٥٥j).onLocalesChanged(fVar);
                        }
                    }
                }
                if (u02 != null) {
                    V0(u0(this.f٦٥٦k.getResources().getConfiguration()));
                }
                return z13;
            }
        }
        z11 = false;
        if (z11) {
        }
        z13 = z11;
        if (z13) {
        }
        if (u02 != null) {
        }
        return z13;
    }

    private Configuration f0(Context context, int i10, androidx.core.os.f fVar, Configuration configuration, boolean z10) {
        int i11;
        if (i10 != 1) {
            if (i10 != 2) {
                if (z10) {
                    i11 = 0;
                } else {
                    i11 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                }
            } else {
                i11 = 32;
            }
        } else {
            i11 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = DownloadProgress.UNKNOWN_PROGRESS;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        if (fVar != null) {
            U0(configuration2, fVar);
        }
        return configuration2;
    }

    private void f1(int i10, androidx.core.os.f fVar, boolean z10, Configuration configuration) {
        Resources resources = this.f٦٥٦k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        if (fVar != null) {
            U0(configuration2, fVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            z.a(resources);
        }
        int i12 = this.U;
        if (i12 != 0) {
            this.f٦٥٦k.setTheme(i12);
            if (i11 >= 23) {
                this.f٦٥٦k.getTheme().applyStyle(this.U, true);
            }
        }
        if (z10 && (this.f٦٥٥j instanceof Activity)) {
            c1(configuration2);
        }
    }

    private ViewGroup g0() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f٦٥٦k.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        int i10 = androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar;
        if (obtainStyledAttributes.hasValue(i10)) {
            if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
                H(1);
            } else if (obtainStyledAttributes.getBoolean(i10, false)) {
                H(108);
            }
            if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                H(109);
            }
            if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                H(10);
            }
            this.J = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            n0();
            this.f٦٥٧l.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f٦٥٦k);
            if (!this.K) {
                if (this.J) {
                    viewGroup = (ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
                    this.H = false;
                    this.G = false;
                } else if (this.G) {
                    TypedValue typedValue = new TypedValue();
                    this.f٦٥٦k.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new androidx.appcompat.view.d(this.f٦٥٦k, typedValue.resourceId);
                    } else {
                        context = this.f٦٥٦k;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
                    androidx.appcompat.widget.w wVar = (androidx.appcompat.widget.w) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
                    this.f٦٦٣r = wVar;
                    wVar.setWindowCallback(x0());
                    if (this.H) {
                        this.f٦٦٣r.h(109);
                    }
                    if (this.E) {
                        this.f٦٦٣r.h(2);
                    }
                    if (this.F) {
                        this.f٦٦٣r.h(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                viewGroup = this.I ? (ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(androidx.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
            }
            if (viewGroup != null) {
                d1.E0(viewGroup, new b());
                if (this.f٦٦٣r == null) {
                    this.C = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
                }
                a1.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f٦٥٧l.findViewById(R.id.content);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(R.id.content);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f٦٥٧l.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new c());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.G + ", windowActionBarOverlay: " + this.H + ", android:windowIsFloating: " + this.J + ", windowActionModeOverlay: " + this.I + ", windowNoTitle: " + this.K + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void h1(View view) {
        int color;
        if ((d1.P(view) & 8192) != 0) {
            color = androidx.core.content.a.getColor(this.f٦٥٦k, androidx.appcompat.R.color.abc_decor_view_status_guard_light);
        } else {
            color = androidx.core.content.a.getColor(this.f٦٥٦k, androidx.appcompat.R.color.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(color);
    }

    private void m0() {
        if (!this.A) {
            this.f٦٤٥B = g0();
            CharSequence w02 = w0();
            if (!TextUtils.isEmpty(w02)) {
                androidx.appcompat.widget.w wVar = this.f٦٦٣r;
                if (wVar != null) {
                    wVar.setWindowTitle(w02);
                } else if (P0() != null) {
                    P0().v(w02);
                } else {
                    TextView textView = this.C;
                    if (textView != null) {
                        textView.setText(w02);
                    }
                }
            }
            W();
            N0(this.f٦٤٥B);
            this.A = true;
            PanelFeatureState v02 = v0(0, false);
            if (!this.R) {
                if (v02 == null || v02.f٦٨٢j == null) {
                    C0(108);
                }
            }
        }
    }

    private void n0() {
        if (this.f٦٥٧l == null) {
            Object obj = this.f٦٥٥j;
            if (obj instanceof Activity) {
                X(((Activity) obj).getWindow());
            }
        }
        if (this.f٦٥٧l != null) {
        } else {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private static Configuration p0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = DownloadProgress.UNKNOWN_PROGRESS;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            int i14 = Build.VERSION.SDK_INT;
            if (i14 >= 24) {
                k.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.f.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i15 = configuration.touchscreen;
            int i16 = configuration2.touchscreen;
            if (i15 != i16) {
                configuration3.touchscreen = i16;
            }
            int i17 = configuration.keyboard;
            int i18 = configuration2.keyboard;
            if (i17 != i18) {
                configuration3.keyboard = i18;
            }
            int i19 = configuration.keyboardHidden;
            int i20 = configuration2.keyboardHidden;
            if (i19 != i20) {
                configuration3.keyboardHidden = i20;
            }
            int i21 = configuration.navigation;
            int i22 = configuration2.navigation;
            if (i21 != i22) {
                configuration3.navigation = i22;
            }
            int i23 = configuration.navigationHidden;
            int i24 = configuration2.navigationHidden;
            if (i23 != i24) {
                configuration3.navigationHidden = i24;
            }
            int i25 = configuration.orientation;
            int i26 = configuration2.orientation;
            if (i25 != i26) {
                configuration3.orientation = i26;
            }
            int i27 = configuration.screenLayout & 15;
            int i28 = configuration2.screenLayout;
            if (i27 != (i28 & 15)) {
                configuration3.screenLayout |= i28 & 15;
            }
            int i29 = configuration.screenLayout & 192;
            int i30 = configuration2.screenLayout;
            if (i29 != (i30 & 192)) {
                configuration3.screenLayout |= i30 & 192;
            }
            int i31 = configuration.screenLayout & 48;
            int i32 = configuration2.screenLayout;
            if (i31 != (i32 & 48)) {
                configuration3.screenLayout |= i32 & 48;
            }
            int i33 = configuration.screenLayout & 768;
            int i34 = configuration2.screenLayout;
            if (i33 != (i34 & 768)) {
                configuration3.screenLayout |= i34 & 768;
            }
            if (i14 >= 26) {
                l.a(configuration, configuration2, configuration3);
            }
            int i35 = configuration.uiMode & 15;
            int i36 = configuration2.uiMode;
            if (i35 != (i36 & 15)) {
                configuration3.uiMode |= i36 & 15;
            }
            int i37 = configuration.uiMode & 48;
            int i38 = configuration2.uiMode;
            if (i37 != (i38 & 48)) {
                configuration3.uiMode |= i38 & 48;
            }
            int i39 = configuration.screenWidthDp;
            int i40 = configuration2.screenWidthDp;
            if (i39 != i40) {
                configuration3.screenWidthDp = i40;
            }
            int i41 = configuration.screenHeightDp;
            int i42 = configuration2.screenHeightDp;
            if (i41 != i42) {
                configuration3.screenHeightDp = i42;
            }
            int i43 = configuration.smallestScreenWidthDp;
            int i44 = configuration2.smallestScreenWidthDp;
            if (i43 != i44) {
                configuration3.smallestScreenWidthDp = i44;
            }
            int i45 = configuration.densityDpi;
            int i46 = configuration2.densityDpi;
            if (i45 != i46) {
                configuration3.densityDpi = i46;
            }
        }
        return configuration3;
    }

    private int r0(Context context) {
        int i10;
        if (!this.W && (this.f٦٥٥j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 29) {
                    i10 = 269221888;
                } else if (i11 >= 24) {
                    i10 = 786432;
                } else {
                    i10 = 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f٦٥٥j.getClass()), i10);
                if (activityInfo != null) {
                    this.V = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e10);
                this.V = 0;
            }
        }
        this.W = true;
        return this.V;
    }

    private p s0(Context context) {
        if (this.Y == null) {
            this.Y = new o(context);
        }
        return this.Y;
    }

    private p t0(Context context) {
        if (this.X == null) {
            this.X = new q(d0.a(context));
        }
        return this.X;
    }

    private void y0() {
        m0();
        if (this.G && this.f٦٦٠o == null) {
            Object obj = this.f٦٥٥j;
            if (obj instanceof Activity) {
                this.f٦٦٠o = new e0((Activity) this.f٦٥٥j, this.H);
            } else if (obj instanceof Dialog) {
                this.f٦٦٠o = new e0((Dialog) this.f٦٥٥j);
            }
            androidx.appcompat.app.a aVar = this.f٦٦٠o;
            if (aVar != null) {
                aVar.r(this.f٦٤٨c0);
            }
        }
    }

    private boolean z0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f٦٨١i;
        if (view != null) {
            panelFeatureState.f٦٨٠h = view;
            return true;
        }
        if (panelFeatureState.f٦٨٢j == null) {
            return false;
        }
        if (this.f٦٦٥t == null) {
            this.f٦٦٥t = new r();
        }
        View view2 = (View) panelFeatureState.a(this.f٦٦٥t);
        panelFeatureState.f٦٨٠h = view2;
        if (view2 != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void A(Bundle bundle) {
        m0();
    }

    @Override // androidx.appcompat.app.e
    public void B() {
        androidx.appcompat.app.a s10 = s();
        if (s10 != null) {
            s10.u(true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void C(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.e
    public void D() {
        U(true, false);
    }

    public boolean D0() {
        return this.f٦٧١z;
    }

    @Override // androidx.appcompat.app.e
    public void E() {
        androidx.appcompat.app.a s10 = s();
        if (s10 != null) {
            s10.u(false);
        }
    }

    int E0(Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 != 1 && i10 != 2) {
                    if (i10 == 3) {
                        return s0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return t0(context).c();
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean F0() {
        boolean z10 = this.O;
        this.O = false;
        PanelFeatureState v02 = v0(0, false);
        if (v02 != null && v02.f٦٨٧o) {
            if (!z10) {
                e0(v02, true);
            }
            return true;
        }
        androidx.appcompat.view.b bVar = this.f٦٦٦u;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a s10 = s();
        if (s10 == null || !s10.h()) {
            return false;
        }
        return true;
    }

    boolean G0(int i10, KeyEvent keyEvent) {
        boolean z10 = true;
        if (i10 != 4) {
            if (i10 == 82) {
                H0(0, keyEvent);
                return true;
            }
        } else {
            if ((keyEvent.getFlags() & 128) == 0) {
                z10 = false;
            }
            this.O = z10;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public boolean H(int i10) {
        int T0 = T0(i10);
        if (this.K && T0 == 108) {
            return false;
        }
        if (this.G && T0 == 1) {
            this.G = false;
        }
        if (T0 != 1) {
            if (T0 != 2) {
                if (T0 != 5) {
                    if (T0 != 10) {
                        if (T0 != 108) {
                            if (T0 != 109) {
                                return this.f٦٥٧l.requestFeature(T0);
                            }
                            a1();
                            this.H = true;
                            return true;
                        }
                        a1();
                        this.G = true;
                        return true;
                    }
                    a1();
                    this.I = true;
                    return true;
                }
                a1();
                this.F = true;
                return true;
            }
            a1();
            this.E = true;
            return true;
        }
        a1();
        this.K = true;
        return true;
    }

    boolean I0(int i10, KeyEvent keyEvent) {
        androidx.appcompat.app.a s10 = s();
        if (s10 != null && s10.o(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.N;
        if (panelFeatureState != null && Q0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.N;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f٦٨٦n = true;
            }
            return true;
        }
        if (this.N == null) {
            PanelFeatureState v02 = v0(0, true);
            R0(v02, keyEvent);
            boolean Q0 = Q0(v02, keyEvent.getKeyCode(), keyEvent, 1);
            v02.f٦٨٥m = false;
            if (Q0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void J(int i10) {
        m0();
        ViewGroup viewGroup = (ViewGroup) this.f٦٤٥B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f٦٥٦k).inflate(i10, viewGroup);
        this.f٦٥٨m.c(this.f٦٥٧l.getCallback());
    }

    boolean J0(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            if (i10 == 82) {
                K0(0, keyEvent);
                return true;
            }
        } else if (F0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void K(View view) {
        m0();
        ViewGroup viewGroup = (ViewGroup) this.f٦٤٥B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f٦٥٨m.c(this.f٦٥٧l.getCallback());
    }

    @Override // androidx.appcompat.app.e
    public void L(View view, ViewGroup.LayoutParams layoutParams) {
        m0();
        ViewGroup viewGroup = (ViewGroup) this.f٦٤٥B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f٦٥٨m.c(this.f٦٥٧l.getCallback());
    }

    void L0(int i10) {
        androidx.appcompat.app.a s10;
        if (i10 == 108 && (s10 = s()) != null) {
            s10.i(true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void M(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.M(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f٦٥٣h0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f٦٥٤i0) != null) {
            m.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f٦٥٤i0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f٦٥٥j;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f٦٥٣h0 = m.a((Activity) this.f٦٥٥j);
                e1();
            }
        }
        this.f٦٥٣h0 = onBackInvokedDispatcher;
        e1();
    }

    void M0(int i10) {
        if (i10 == 108) {
            androidx.appcompat.app.a s10 = s();
            if (s10 != null) {
                s10.i(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            PanelFeatureState v02 = v0(i10, true);
            if (v02.f٦٨٧o) {
                e0(v02, false);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void N(Toolbar toolbar) {
        if (!(this.f٦٥٥j instanceof Activity)) {
            return;
        }
        androidx.appcompat.app.a s10 = s();
        if (!(s10 instanceof e0)) {
            this.f٦٦١p = null;
            if (s10 != null) {
                s10.n();
            }
            this.f٦٦٠o = null;
            if (toolbar != null) {
                b0 b0Var = new b0(toolbar, w0(), this.f٦٥٨m);
                this.f٦٦٠o = b0Var;
                this.f٦٥٨m.e(b0Var.f٧٢٢c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f٦٥٨m.e(null);
            }
            u();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    void N0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.e
    public void O(int i10) {
        this.U = i10;
    }

    @Override // androidx.appcompat.app.e
    public final void P(CharSequence charSequence) {
        this.f٦٦٢q = charSequence;
        androidx.appcompat.widget.w wVar = this.f٦٦٣r;
        if (wVar != null) {
            wVar.setWindowTitle(charSequence);
            return;
        }
        if (P0() != null) {
            P0().v(charSequence);
            return;
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    final androidx.appcompat.app.a P0() {
        return this.f٦٦٠o;
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.view.b Q(b.a aVar) {
        androidx.appcompat.app.c cVar;
        if (aVar != null) {
            androidx.appcompat.view.b bVar = this.f٦٦٦u;
            if (bVar != null) {
                bVar.c();
            }
            i iVar = new i(aVar);
            androidx.appcompat.app.a s10 = s();
            if (s10 != null) {
                androidx.appcompat.view.b w10 = s10.w(iVar);
                this.f٦٦٦u = w10;
                if (w10 != null && (cVar = this.f٦٥٩n) != null) {
                    cVar.onSupportActionModeStarted(w10);
                }
            }
            if (this.f٦٦٦u == null) {
                this.f٦٦٦u = Z0(iVar);
            }
            e1();
            return this.f٦٦٦u;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    void U0(Configuration configuration, androidx.core.os.f fVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            k.d(configuration, fVar);
        } else {
            configuration.setLocale(fVar.d(0));
            configuration.setLayoutDirection(fVar.d(0));
        }
    }

    public boolean V() {
        return T(true);
    }

    void V0(androidx.core.os.f fVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            k.c(fVar);
        } else {
            Locale.setDefault(fVar.d(0));
        }
    }

    final boolean W0() {
        ViewGroup viewGroup;
        if (this.A && (viewGroup = this.f٦٤٥B) != null && viewGroup.isLaidOut()) {
            return true;
        }
        return false;
    }

    androidx.core.os.f Y(Context context) {
        androidx.core.os.f r10;
        androidx.core.os.f c10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33 || (r10 = androidx.appcompat.app.e.r()) == null) {
            return null;
        }
        androidx.core.os.f u02 = u0(context.getApplicationContext().getResources().getConfiguration());
        if (i10 >= 24) {
            c10 = y.b(r10, u02);
        } else if (r10.f()) {
            c10 = androidx.core.os.f.e();
        } else {
            c10 = androidx.core.os.f.c(j.b(r10.d(0)));
        }
        if (!c10.f()) {
            return c10;
        }
        return u02;
    }

    boolean Y0() {
        if (this.f٦٥٣h0 == null) {
            return false;
        }
        PanelFeatureState v02 = v0(0, false);
        if ((v02 == null || !v02.f٦٨٧o) && this.f٦٦٦u == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    androidx.appcompat.view.b Z0(b.a aVar) {
        androidx.appcompat.view.b bVar;
        Context context;
        androidx.appcompat.view.b bVar2;
        androidx.appcompat.app.c cVar;
        l0();
        androidx.appcompat.view.b bVar3 = this.f٦٦٦u;
        if (bVar3 != null) {
            bVar3.c();
        }
        if (!(aVar instanceof i)) {
            aVar = new i(aVar);
        }
        androidx.appcompat.app.c cVar2 = this.f٦٥٩n;
        if (cVar2 != null && !this.R) {
            try {
                bVar = cVar2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
            }
            if (bVar == null) {
                this.f٦٦٦u = bVar;
            } else {
                boolean z10 = true;
                if (this.f٦٦٧v == null) {
                    if (this.J) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = this.f٦٥٦k.getTheme();
                        theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme newTheme = this.f٦٥٦k.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            context = new androidx.appcompat.view.d(this.f٦٥٦k, 0);
                            context.getTheme().setTo(newTheme);
                        } else {
                            context = this.f٦٥٦k;
                        }
                        this.f٦٦٧v = new ActionBarContextView(context);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, androidx.appcompat.R.attr.actionModePopupWindowStyle);
                        this.f٦٦٨w = popupWindow;
                        androidx.core.widget.j.b(popupWindow, 2);
                        this.f٦٦٨w.setContentView(this.f٦٦٧v);
                        this.f٦٦٨w.setWidth(-1);
                        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarSize, typedValue, true);
                        this.f٦٦٧v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.f٦٦٨w.setHeight(-2);
                        this.f٦٦٩x = new d();
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.f٦٤٥B.findViewById(androidx.appcompat.R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(q0()));
                            this.f٦٦٧v = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.f٦٦٧v != null) {
                    l0();
                    this.f٦٦٧v.k();
                    Context context2 = this.f٦٦٧v.getContext();
                    ActionBarContextView actionBarContextView = this.f٦٦٧v;
                    if (this.f٦٦٨w != null) {
                        z10 = false;
                    }
                    androidx.appcompat.view.e eVar = new androidx.appcompat.view.e(context2, actionBarContextView, aVar, z10);
                    if (aVar.b(eVar, eVar.e())) {
                        eVar.k();
                        this.f٦٦٧v.h(eVar);
                        this.f٦٦٦u = eVar;
                        if (W0()) {
                            this.f٦٦٧v.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
                            l1 b10 = d1.e(this.f٦٦٧v).b(1.0f);
                            this.f٦٧٠y = b10;
                            b10.h(new e());
                        } else {
                            this.f٦٦٧v.setAlpha(1.0f);
                            this.f٦٦٧v.setVisibility(0);
                            if (this.f٦٦٧v.getParent() instanceof View) {
                                d1.n0((View) this.f٦٦٧v.getParent());
                            }
                        }
                        if (this.f٦٦٨w != null) {
                            this.f٦٥٧l.getDecorView().post(this.f٦٦٩x);
                        }
                    } else {
                        this.f٦٦٦u = null;
                    }
                }
            }
            bVar2 = this.f٦٦٦u;
            if (bVar2 != null && (cVar = this.f٦٥٩n) != null) {
                cVar.onSupportActionModeStarted(bVar2);
            }
            e1();
            return this.f٦٦٦u;
        }
        bVar = null;
        if (bVar == null) {
        }
        bVar2 = this.f٦٦٦u;
        if (bVar2 != null) {
            cVar.onSupportActionModeStarted(bVar2);
        }
        e1();
        return this.f٦٦٦u;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        PanelFeatureState o02;
        Window.Callback x02 = x0();
        if (x02 != null && !this.R && (o02 = o0(gVar.F())) != null) {
            return x02.onMenuItemSelected(o02.f٦٧٣a, menuItem);
        }
        return false;
    }

    void a0(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.M;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f٦٨٢j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f٦٨٧o) && !this.R) {
            this.f٦٥٨m.d(this.f٦٥٧l.getCallback(), i10, menu);
        }
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        S0(true);
    }

    void b0(androidx.appcompat.view.menu.g gVar) {
        if (this.L) {
            return;
        }
        this.L = true;
        this.f٦٦٣r.i();
        Window.Callback x02 = x0();
        if (x02 != null && !this.R) {
            x02.onPanelClosed(108, gVar);
        }
        this.L = false;
    }

    void d0(int i10) {
        e0(v0(i10, true), true);
    }

    @Override // androidx.appcompat.app.e
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        m0();
        ((ViewGroup) this.f٦٤٥B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f٦٥٨m.c(this.f٦٥٧l.getCallback());
    }

    void e0(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        androidx.appcompat.widget.w wVar;
        if (z10 && panelFeatureState.f٦٧٣a == 0 && (wVar = this.f٦٦٣r) != null && wVar.e()) {
            b0(panelFeatureState.f٦٨٢j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f٦٥٦k.getSystemService("window");
        if (windowManager != null && panelFeatureState.f٦٨٧o && (viewGroup = panelFeatureState.f٦٧٩g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                a0(panelFeatureState.f٦٧٣a, panelFeatureState, null);
            }
        }
        panelFeatureState.f٦٨٥m = false;
        panelFeatureState.f٦٨٦n = false;
        panelFeatureState.f٦٨٧o = false;
        panelFeatureState.f٦٨٠h = null;
        panelFeatureState.f٦٨٩q = true;
        if (this.N == panelFeatureState) {
            this.N = null;
        }
        if (panelFeatureState.f٦٧٣a == 0) {
            e1();
        }
    }

    void e1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean Y0 = Y0();
            if (Y0 && this.f٦٥٤i0 == null) {
                this.f٦٥٤i0 = m.b(this.f٦٥٣h0, this);
            } else if (!Y0 && (onBackInvokedCallback = this.f٦٥٤i0) != null) {
                m.c(this.f٦٥٣h0, onBackInvokedCallback);
                this.f٦٥٤i0 = null;
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public Context g(Context context) {
        Configuration configuration;
        this.P = true;
        int E0 = E0(context, Z());
        if (androidx.appcompat.app.e.v(context)) {
            androidx.appcompat.app.e.S(context);
        }
        androidx.core.os.f Y = Y(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(f0(context, E0, Y, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(f0(context, E0, Y, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f٦٤٤m0) {
            return super.g(context);
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = DownloadProgress.UNKNOWN_PROGRESS;
        Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = p0(configuration3, configuration4);
        } else {
            configuration = null;
        }
        Configuration f02 = f0(context, E0, Y, configuration, true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, androidx.appcompat.R.style.Theme_AppCompat_Empty);
        dVar.a(f02);
        try {
            if (context.getTheme() != null) {
                h.f.a(dVar.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.g(dVar);
    }

    final int g1(d2 d2Var, Rect rect) {
        int i10;
        boolean z10;
        int k10;
        int l10;
        boolean z11;
        int i11 = 0;
        if (d2Var != null) {
            i10 = d2Var.m();
        } else if (rect != null) {
            i10 = rect.top;
        } else {
            i10 = 0;
        }
        ActionBarContextView actionBarContextView = this.f٦٦٧v;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f٦٦٧v.getLayoutParams();
            boolean z12 = true;
            if (this.f٦٦٧v.isShown()) {
                if (this.f٦٤٩d0 == null) {
                    this.f٦٤٩d0 = new Rect();
                    this.f٦٥٠e0 = new Rect();
                }
                Rect rect2 = this.f٦٤٩d0;
                Rect rect3 = this.f٦٥٠e0;
                if (d2Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(d2Var.k(), d2Var.m(), d2Var.l(), d2Var.j());
                }
                a1.a(this.f٦٤٥B, rect2, rect3);
                int i12 = rect2.top;
                int i13 = rect2.left;
                int i14 = rect2.right;
                d2 K = d1.K(this.f٦٤٥B);
                if (K == null) {
                    k10 = 0;
                } else {
                    k10 = K.k();
                }
                if (K == null) {
                    l10 = 0;
                } else {
                    l10 = K.l();
                }
                if (marginLayoutParams.topMargin == i12 && marginLayoutParams.leftMargin == i13 && marginLayoutParams.rightMargin == i14) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i12;
                    marginLayoutParams.leftMargin = i13;
                    marginLayoutParams.rightMargin = i14;
                    z11 = true;
                }
                if (i12 > 0 && this.D == null) {
                    View view = new View(this.f٦٥٦k);
                    this.D = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = k10;
                    layoutParams.rightMargin = l10;
                    this.f٦٤٥B.addView(this.D, -1, layoutParams);
                } else {
                    View view2 = this.D;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i15 = marginLayoutParams2.height;
                        int i16 = marginLayoutParams.topMargin;
                        if (i15 != i16 || marginLayoutParams2.leftMargin != k10 || marginLayoutParams2.rightMargin != l10) {
                            marginLayoutParams2.height = i16;
                            marginLayoutParams2.leftMargin = k10;
                            marginLayoutParams2.rightMargin = l10;
                            this.D.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view3 = this.D;
                if (view3 == null) {
                    z12 = false;
                }
                if (z12 && view3.getVisibility() != 0) {
                    h1(this.D);
                }
                if (!this.I && z12) {
                    i10 = 0;
                }
                z10 = z12;
                z12 = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z12 = false;
            }
            if (z12) {
                this.f٦٦٧v.setLayoutParams(marginLayoutParams);
            }
        } else {
            z10 = false;
        }
        View view4 = this.D;
        if (view4 != null) {
            if (!z10) {
                i11 = 8;
            }
            view4.setVisibility(i11);
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View h0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        if (this.f٦٥١f0 == null) {
            TypedArray obtainStyledAttributes = this.f٦٥٦k.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            String string = obtainStyledAttributes.getString(androidx.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            obtainStyledAttributes.recycle();
            if (string == null) {
                this.f٦٥١f0 = new w();
            } else {
                try {
                    this.f٦٥١f0 = (w) this.f٦٥٦k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f٦٥١f0 = new w();
                }
            }
        }
        boolean z11 = f٦٤٢k0;
        boolean z12 = false;
        if (z11) {
            if (this.f٦٥٢g0 == null) {
                this.f٦٥٢g0 = new x();
            }
            if (this.f٦٥٢g0.a(attributeSet)) {
                z10 = true;
            } else {
                if (attributeSet instanceof XmlPullParser) {
                    if (((XmlPullParser) attributeSet).getDepth() > 1) {
                        z12 = true;
                    }
                } else {
                    z12 = X0((ViewParent) view);
                }
                z10 = z12;
            }
        } else {
            z10 = false;
        }
        return this.f٦٥١f0.r(view, str, context, attributeSet, z10, z11, true, z0.d());
    }

    void i0() {
        androidx.appcompat.view.menu.g gVar;
        androidx.appcompat.widget.w wVar = this.f٦٦٣r;
        if (wVar != null) {
            wVar.i();
        }
        if (this.f٦٦٨w != null) {
            this.f٦٥٧l.getDecorView().removeCallbacks(this.f٦٦٩x);
            if (this.f٦٦٨w.isShowing()) {
                try {
                    this.f٦٦٨w.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f٦٦٨w = null;
        }
        l0();
        PanelFeatureState v02 = v0(0, false);
        if (v02 != null && (gVar = v02.f٦٨٢j) != null) {
            gVar.close();
        }
    }

    @Override // androidx.appcompat.app.e
    public View j(int i10) {
        m0();
        return this.f٦٥٧l.findViewById(i10);
    }

    boolean j0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f٦٥٥j;
        if (((obj instanceof u.a) || (obj instanceof AppCompatDialog)) && (decorView = this.f٦٥٧l.getDecorView()) != null && androidx.core.view.u.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f٦٥٨m.b(this.f٦٥٧l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            return G0(keyCode, keyEvent);
        }
        return J0(keyCode, keyEvent);
    }

    void k0(int i10) {
        PanelFeatureState v02;
        PanelFeatureState v03 = v0(i10, true);
        if (v03.f٦٨٢j != null) {
            Bundle bundle = new Bundle();
            v03.f٦٨٢j.U(bundle);
            if (bundle.size() > 0) {
                v03.f٦٩١s = bundle;
            }
            v03.f٦٨٢j.i0();
            v03.f٦٨٢j.clear();
        }
        v03.f٦٩٠r = true;
        v03.f٦٨٩q = true;
        if ((i10 == 108 || i10 == 0) && this.f٦٦٣r != null && (v02 = v0(0, false)) != null) {
            v02.f٦٨٥m = false;
            R0(v02, null);
        }
    }

    @Override // androidx.appcompat.app.e
    public Context l() {
        return this.f٦٥٦k;
    }

    void l0() {
        l1 l1Var = this.f٦٧٠y;
        if (l1Var != null) {
            l1Var.c();
        }
    }

    @Override // androidx.appcompat.app.e
    public final androidx.appcompat.app.b n() {
        return new f();
    }

    @Override // androidx.appcompat.app.e
    public int o() {
        return this.T;
    }

    PanelFeatureState o0(Menu menu) {
        int i10;
        PanelFeatureState[] panelFeatureStateArr = this.M;
        if (panelFeatureStateArr != null) {
            i10 = panelFeatureStateArr.length;
        } else {
            i10 = 0;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
            if (panelFeatureState != null && panelFeatureState.f٦٨٢j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return h0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater q() {
        Context context;
        if (this.f٦٦١p == null) {
            y0();
            androidx.appcompat.app.a aVar = this.f٦٦٠o;
            if (aVar != null) {
                context = aVar.k();
            } else {
                context = this.f٦٥٦k;
            }
            this.f٦٦١p = new androidx.appcompat.view.g(context);
        }
        return this.f٦٦١p;
    }

    final Context q0() {
        Context context;
        androidx.appcompat.app.a s10 = s();
        if (s10 != null) {
            context = s10.k();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f٦٥٦k;
        }
        return context;
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.app.a s() {
        y0();
        return this.f٦٦٠o;
    }

    @Override // androidx.appcompat.app.e
    public void t() {
        LayoutInflater from = LayoutInflater.from(this.f٦٥٦k);
        if (from.getFactory() == null) {
            androidx.core.view.v.a(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.e
    public void u() {
        if (P0() != null && !s().l()) {
            C0(0);
        }
    }

    androidx.core.os.f u0(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return k.b(configuration);
        }
        return androidx.core.os.f.c(j.b(configuration.locale));
    }

    protected PanelFeatureState v0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState == null) {
            PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
            panelFeatureStateArr[i10] = panelFeatureState2;
            return panelFeatureState2;
        }
        return panelFeatureState;
    }

    final CharSequence w0() {
        Object obj = this.f٦٥٥j;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f٦٦٢q;
    }

    @Override // androidx.appcompat.app.e
    public void x(Configuration configuration) {
        androidx.appcompat.app.a s10;
        if (this.G && this.A && (s10 = s()) != null) {
            s10.m(configuration);
        }
        androidx.appcompat.widget.f.b().g(this.f٦٥٦k);
        this.S = new Configuration(this.f٦٥٦k.getResources().getConfiguration());
        U(false, false);
    }

    final Window.Callback x0() {
        return this.f٦٥٧l.getCallback();
    }

    @Override // androidx.appcompat.app.e
    public void y(Bundle bundle) {
        String str;
        this.P = true;
        T(false);
        n0();
        Object obj = this.f٦٥٥j;
        if (obj instanceof Activity) {
            try {
                str = androidx.core.app.m.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                androidx.appcompat.app.a P0 = P0();
                if (P0 == null) {
                    this.f٦٤٨c0 = true;
                } else {
                    P0.r(true);
                }
            }
            androidx.appcompat.app.e.d(this);
        }
        this.S = new Configuration(this.f٦٥٦k.getResources().getConfiguration());
        this.Q = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    @Override // androidx.appcompat.app.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z() {
        androidx.appcompat.app.a aVar;
        if (this.f٦٥٥j instanceof Activity) {
            androidx.appcompat.app.e.F(this);
        }
        if (this.Z) {
            this.f٦٥٧l.getDecorView().removeCallbacks(this.f٦٤٧b0);
        }
        this.R = true;
        if (this.T != -100) {
            Object obj = this.f٦٥٥j;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                f٦٤١j0.put(this.f٦٥٥j.getClass().getName(), Integer.valueOf(this.T));
                aVar = this.f٦٦٠o;
                if (aVar != null) {
                    aVar.n();
                }
                c0();
            }
        }
        f٦٤١j0.remove(this.f٦٥٥j.getClass().getName());
        aVar = this.f٦٦٠o;
        if (aVar != null) {
        }
        c0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.c cVar) {
        this(dialog.getContext(), dialog.getWindow(), cVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.c cVar, Object obj) {
        AppCompatActivity b12;
        this.f٦٧٠y = null;
        this.f٦٧١z = true;
        this.T = -100;
        this.f٦٤٧b0 = new a();
        this.f٦٥٦k = context;
        this.f٦٥٩n = cVar;
        this.f٦٥٥j = obj;
        if (this.T == -100 && (obj instanceof Dialog) && (b12 = b1()) != null) {
            this.T = b12.getDelegate().o();
        }
        if (this.T == -100) {
            SimpleArrayMap simpleArrayMap = f٦٤١j0;
            Integer num = (Integer) simpleArrayMap.get(obj.getClass().getName());
            if (num != null) {
                this.T = num.intValue();
                simpleArrayMap.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            X(window);
        }
        androidx.appcompat.widget.f.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class n extends androidx.appcompat.view.i {

        /* renamed from: b, reason: collision with root package name */
        private g f٧٠٦b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f٧٠٧c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f٧٠٨d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f٧٠٩e;

        n(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f٧٠٨d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f٧٠٨d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f٧٠٧c = true;
                callback.onContentChanged();
            } finally {
                this.f٧٠٧c = false;
            }
        }

        public void d(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f٧٠٩e = true;
                callback.onPanelClosed(i10, menu);
            } finally {
                this.f٧٠٩e = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f٧٠٨d) {
                return a().dispatchKeyEvent(keyEvent);
            }
            if (!AppCompatDelegateImpl.this.j0(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!super.dispatchKeyShortcutEvent(keyEvent) && !AppCompatDelegateImpl.this.I0(keyEvent.getKeyCode(), keyEvent)) {
                return false;
            }
            return true;
        }

        void e(g gVar) {
            this.f٧٠٦b = gVar;
        }

        final ActionMode f(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f٦٥٦k, callback);
            androidx.appcompat.view.b Q = AppCompatDelegateImpl.this.Q(aVar);
            if (Q != null) {
                return aVar.e(Q);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f٧٠٧c) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 == 0 && !(menu instanceof androidx.appcompat.view.menu.g)) {
                return false;
            }
            return super.onCreatePanelMenu(i10, menu);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            View onCreatePanelView;
            g gVar = this.f٧٠٦b;
            if (gVar != null && (onCreatePanelView = gVar.onCreatePanelView(i10)) != null) {
                return onCreatePanelView;
            }
            return super.onCreatePanelView(i10);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.L0(i10);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            if (this.f٧٠٩e) {
                a().onPanelClosed(i10, menu);
            } else {
                super.onPanelClosed(i10, menu);
                AppCompatDelegateImpl.this.M0(i10);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar;
            if (menu instanceof androidx.appcompat.view.menu.g) {
                gVar = (androidx.appcompat.view.menu.g) menu;
            } else {
                gVar = null;
            }
            if (i10 == 0 && gVar == null) {
                return false;
            }
            boolean z10 = true;
            if (gVar != null) {
                gVar.f0(true);
            }
            g gVar2 = this.f٧٠٦b;
            if (gVar2 == null || !gVar2.a(i10)) {
                z10 = false;
            }
            if (!z10) {
                z10 = super.onPreparePanel(i10, view, menu);
            }
            if (gVar != null) {
                gVar.f0(false);
            }
            return z10;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i10) {
            androidx.appcompat.view.menu.g gVar;
            PanelFeatureState v02 = AppCompatDelegateImpl.this.v0(0, true);
            if (v02 != null && (gVar = v02.f٦٨٢j) != null) {
                super.onProvideKeyboardShortcuts(list, gVar, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.D0()) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            if (AppCompatDelegateImpl.this.D0() && i10 == 0) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback, i10);
        }
    }
}
