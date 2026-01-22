package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class o {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Bundle f٢٦٤٤a;

        /* renamed from: b, reason: collision with root package name */
        private IconCompat f٢٦٤٥b;

        /* renamed from: c, reason: collision with root package name */
        private final t[] f٢٦٤٦c;

        /* renamed from: d, reason: collision with root package name */
        private final t[] f٢٦٤٧d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f٢٦٤٨e;

        /* renamed from: f, reason: collision with root package name */
        boolean f٢٦٤٩f;

        /* renamed from: g, reason: collision with root package name */
        private final int f٢٦٥٠g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f٢٦٥١h;

        /* renamed from: i, reason: collision with root package name */
        public int f٢٦٥٢i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f٢٦٥٣j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f٢٦٥٤k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f٢٦٥٥l;

        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.c(null, "", i10) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f٢٦٥٤k;
        }

        public boolean b() {
            return this.f٢٦٤٨e;
        }

        public Bundle c() {
            return this.f٢٦٤٤a;
        }

        public IconCompat d() {
            int i10;
            if (this.f٢٦٤٥b == null && (i10 = this.f٢٦٥٢i) != 0) {
                this.f٢٦٤٥b = IconCompat.c(null, "", i10);
            }
            return this.f٢٦٤٥b;
        }

        public t[] e() {
            return this.f٢٦٤٦c;
        }

        public int f() {
            return this.f٢٦٥٠g;
        }

        public boolean g() {
            return this.f٢٦٤٩f;
        }

        public CharSequence h() {
            return this.f٢٦٥٣j;
        }

        public boolean i() {
            return this.f٢٦٥٥l;
        }

        public boolean j() {
            return this.f٢٦٥١h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, t[] tVarArr, t[] tVarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f٢٦٤٩f = true;
            this.f٢٦٤٥b = iconCompat;
            if (iconCompat != null && iconCompat.g() == 2) {
                this.f٢٦٥٢i = iconCompat.e();
            }
            this.f٢٦٥٣j = e.d(charSequence);
            this.f٢٦٥٤k = pendingIntent;
            this.f٢٦٤٤a = bundle == null ? new Bundle() : bundle;
            this.f٢٦٤٦c = tVarArr;
            this.f٢٦٤٧d = tVarArr2;
            this.f٢٦٤٨e = z10;
            this.f٢٦٥٠g = i10;
            this.f٢٦٤٩f = z11;
            this.f٢٦٥١h = z12;
            this.f٢٦٥٥l = z13;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends f {

        /* renamed from: e, reason: collision with root package name */
        private IconCompat f٢٦٥٦e;

        /* renamed from: f, reason: collision with root package name */
        private IconCompat f٢٦٥٧f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f٢٦٥٨g;

        /* renamed from: h, reason: collision with root package name */
        private CharSequence f٢٦٥٩h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f٢٦٦٠i;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        private static class a {
            @RequiresApi(23)
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* renamed from: androidx.core.app.o$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        private static class C٠٠٢٢b {
            @RequiresApi(31)
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            @RequiresApi(31)
            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            @RequiresApi(31)
            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z10) {
                bigPictureStyle.showBigPictureWhenCollapsed(z10);
            }
        }

        @Override // androidx.core.app.o.f
        public void b(n nVar) {
            Context context;
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(nVar.a()).setBigContentTitle(this.f٢٦٩٠b);
            IconCompat iconCompat = this.f٢٦٥٦e;
            Context context2 = null;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    if (nVar instanceof p) {
                        context = ((p) nVar).f();
                    } else {
                        context = null;
                    }
                    C٠٠٢٢b.a(bigContentTitle, this.f٢٦٥٦e.m(context));
                } else if (iconCompat.g() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f٢٦٥٦e.d());
                }
            }
            if (this.f٢٦٥٨g) {
                IconCompat iconCompat2 = this.f٢٦٥٧f;
                if (iconCompat2 == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    if (nVar instanceof p) {
                        context2 = ((p) nVar).f();
                    }
                    a.a(bigContentTitle, this.f٢٦٥٧f.m(context2));
                } else if (iconCompat2.g() == 1) {
                    bigContentTitle.bigLargeIcon(this.f٢٦٥٧f.d());
                } else {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                }
            }
            if (this.f٢٦٩٢d) {
                bigContentTitle.setSummaryText(this.f٢٦٩١c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                C٠٠٢٢b.c(bigContentTitle, this.f٢٦٦٠i);
                C٠٠٢٢b.b(bigContentTitle, this.f٢٦٥٩h);
            }
        }

        @Override // androidx.core.app.o.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public b h(Bitmap bitmap) {
            IconCompat b10;
            if (bitmap == null) {
                b10 = null;
            } else {
                b10 = IconCompat.b(bitmap);
            }
            this.f٢٦٥٧f = b10;
            this.f٢٦٥٨g = true;
            return this;
        }

        public b i(Bitmap bitmap) {
            IconCompat b10;
            if (bitmap == null) {
                b10 = null;
            } else {
                b10 = IconCompat.b(bitmap);
            }
            this.f٢٦٥٦e = b10;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private CharSequence f٢٦٦١e;

        @Override // androidx.core.app.o.f
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.o.f
        public void b(n nVar) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(nVar.a()).setBigContentTitle(this.f٢٦٩٠b).bigText(this.f٢٦٦١e);
            if (this.f٢٦٩٢d) {
                bigText.setSummaryText(this.f٢٦٩١c);
            }
        }

        @Override // androidx.core.app.o.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public c h(CharSequence charSequence) {
            this.f٢٦٦١e = e.d(charSequence);
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected e f٢٦٨٩a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f٢٦٩٠b;

        /* renamed from: c, reason: collision with root package name */
        CharSequence f٢٦٩١c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٦٩٢d = false;

        public void a(Bundle bundle) {
            if (this.f٢٦٩٢d) {
                bundle.putCharSequence("android.summaryText", this.f٢٦٩١c);
            }
            CharSequence charSequence = this.f٢٦٩٠b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c10 = c();
            if (c10 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c10);
            }
        }

        public abstract void b(n nVar);

        protected abstract String c();

        public RemoteViews d(n nVar) {
            return null;
        }

        public RemoteViews e(n nVar) {
            return null;
        }

        public RemoteViews f(n nVar) {
            return null;
        }

        public void g(e eVar) {
            if (this.f٢٦٨٩a != eVar) {
                this.f٢٦٨٩a = eVar;
                if (eVar != null) {
                    eVar.x(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 27) {
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
        }
        return bitmap;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {
        boolean A;

        /* renamed from: B, reason: collision with root package name */
        boolean f٢٦٦٢B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Object T;
        public ArrayList U;

        /* renamed from: a, reason: collision with root package name */
        public Context f٢٦٦٣a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f٢٦٦٤b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f٢٦٦٥c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList f٢٦٦٦d;

        /* renamed from: e, reason: collision with root package name */
        CharSequence f٢٦٦٧e;

        /* renamed from: f, reason: collision with root package name */
        CharSequence f٢٦٦٨f;

        /* renamed from: g, reason: collision with root package name */
        PendingIntent f٢٦٦٩g;

        /* renamed from: h, reason: collision with root package name */
        PendingIntent f٢٦٧٠h;

        /* renamed from: i, reason: collision with root package name */
        RemoteViews f٢٦٧١i;

        /* renamed from: j, reason: collision with root package name */
        IconCompat f٢٦٧٢j;

        /* renamed from: k, reason: collision with root package name */
        CharSequence f٢٦٧٣k;

        /* renamed from: l, reason: collision with root package name */
        int f٢٦٧٤l;

        /* renamed from: m, reason: collision with root package name */
        int f٢٦٧٥m;

        /* renamed from: n, reason: collision with root package name */
        boolean f٢٦٧٦n;

        /* renamed from: o, reason: collision with root package name */
        boolean f٢٦٧٧o;

        /* renamed from: p, reason: collision with root package name */
        f f٢٦٧٨p;

        /* renamed from: q, reason: collision with root package name */
        CharSequence f٢٦٧٩q;

        /* renamed from: r, reason: collision with root package name */
        CharSequence f٢٦٨٠r;

        /* renamed from: s, reason: collision with root package name */
        CharSequence[] f٢٦٨١s;

        /* renamed from: t, reason: collision with root package name */
        int f٢٦٨٢t;

        /* renamed from: u, reason: collision with root package name */
        int f٢٦٨٣u;

        /* renamed from: v, reason: collision with root package name */
        boolean f٢٦٨٤v;

        /* renamed from: w, reason: collision with root package name */
        String f٢٦٨٥w;

        /* renamed from: x, reason: collision with root package name */
        boolean f٢٦٨٦x;

        /* renamed from: y, reason: collision with root package name */
        String f٢٦٨٧y;

        /* renamed from: z, reason: collision with root package name */
        boolean f٢٦٨٨z;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        static class a {
            static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i10) {
                return builder.setContentType(i10);
            }

            static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i10) {
                return builder.setUsage(i10);
            }
        }

        public e(Context context, String str) {
            this.f٢٦٦٤b = new ArrayList();
            this.f٢٦٦٥c = new ArrayList();
            this.f٢٦٦٦d = new ArrayList();
            this.f٢٦٧٦n = true;
            this.f٢٦٨٨z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f٢٦٦٣a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f٢٦٧٥m = 0;
            this.U = new ArrayList();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        private void m(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.R;
                notification.flags = i10 | notification.flags;
            } else {
                Notification notification2 = this.R;
                notification2.flags = (~i10) & notification2.flags;
            }
        }

        public e A(int i10) {
            this.F = i10;
            return this;
        }

        public e B(long j10) {
            this.R.when = j10;
            return this;
        }

        public e a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f٢٦٦٤b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new p(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public e e(boolean z10) {
            m(16, z10);
            return this;
        }

        public e f(String str) {
            this.K = str;
            return this;
        }

        public e g(int i10) {
            this.E = i10;
            return this;
        }

        public e h(PendingIntent pendingIntent) {
            this.f٢٦٦٩g = pendingIntent;
            return this;
        }

        public e i(CharSequence charSequence) {
            this.f٢٦٦٨f = d(charSequence);
            return this;
        }

        public e j(CharSequence charSequence) {
            this.f٢٦٦٧e = d(charSequence);
            return this;
        }

        public e k(int i10) {
            Notification notification = this.R;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e l(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        public e n(Bitmap bitmap) {
            IconCompat b10;
            if (bitmap == null) {
                b10 = null;
            } else {
                b10 = IconCompat.b(o.b(this.f٢٦٦٣a, bitmap));
            }
            this.f٢٦٧٢j = b10;
            return this;
        }

        public e o(int i10, int i11, int i12) {
            int i13;
            Notification notification = this.R;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            if (i11 != 0 && i12 != 0) {
                i13 = 1;
            } else {
                i13 = 0;
            }
            notification.flags = i13 | (notification.flags & (-2));
            return this;
        }

        public e p(boolean z10) {
            this.f٢٦٨٨z = z10;
            return this;
        }

        public e q() {
            this.S = true;
            return this;
        }

        public e r(int i10) {
            this.f٢٦٧٤l = i10;
            return this;
        }

        public e s(boolean z10) {
            m(2, z10);
            return this;
        }

        public e t(int i10) {
            this.f٢٦٧٥m = i10;
            return this;
        }

        public e u(boolean z10) {
            this.f٢٦٧٦n = z10;
            return this;
        }

        public e v(int i10) {
            this.R.icon = i10;
            return this;
        }

        public e w(Uri uri) {
            Notification notification = this.R;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder d10 = a.d(a.c(a.b(), 4), 5);
            this.R.audioAttributes = a.a(d10);
            return this;
        }

        public e x(f fVar) {
            if (this.f٢٦٧٨p != fVar) {
                this.f٢٦٧٨p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public e y(CharSequence charSequence) {
            this.R.tickerText = d(charSequence);
            return this;
        }

        public e z(long[] jArr) {
            this.R.vibrate = jArr;
            return this;
        }

        public e(Context context) {
            this(context, null);
        }
    }
}
