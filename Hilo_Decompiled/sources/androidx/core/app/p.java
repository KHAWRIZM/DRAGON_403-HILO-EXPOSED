package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.appcompat.app.a0;
import androidx.collection.ArraySet;
import androidx.core.app.o;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class p implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f٢٦٩٣a;

    /* renamed from: b, reason: collision with root package name */
    private final Notification.Builder f٢٦٩٤b;

    /* renamed from: c, reason: collision with root package name */
    private final o.e f٢٦٩٥c;

    /* renamed from: d, reason: collision with root package name */
    private RemoteViews f٢٦٩٦d;

    /* renamed from: e, reason: collision with root package name */
    private RemoteViews f٢٦٩٧e;

    /* renamed from: f, reason: collision with root package name */
    private final List f٢٦٩٨f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f٢٦٩٩g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    private int f٢٧٠٠h;

    /* renamed from: i, reason: collision with root package name */
    private RemoteViews f٢٧٠١i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Action.Builder e(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i10, charSequence, pendingIntent);
        }

        static String f(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        static Notification.Builder i(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i10) {
            return builder.setColor(i10);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i10) {
            return builder.setVisibility(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setBadgeIconType(i10);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        static Notification.Builder d(Notification.Builder builder, int i10) {
            return builder.setGroupAlertBehavior(i10);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j10) {
            return builder.setTimeoutAfter(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f {
        static Notification.Action.Builder a(Notification.Action.Builder builder, int i10) {
            return builder.setSemanticAction(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g {
        static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class h {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setForegroundServiceBehavior(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o.e eVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Icon m10;
        List list;
        int i10;
        Object obj;
        Bitmap d10;
        this.f٢٦٩٥c = eVar;
        Context context = eVar.f٢٦٦٣a;
        this.f٢٦٩٣a = context;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            this.f٢٦٩٤b = e.a(context, eVar.K);
        } else {
            this.f٢٦٩٤b = new Notification.Builder(eVar.f٢٦٦٣a);
        }
        Notification notification = eVar.R;
        Notification.Builder lights = this.f٢٦٩٤b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f٢٦٧١i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z10);
        if ((notification.flags & 8) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z11);
        if ((notification.flags & 16) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z12).setDefaults(notification.defaults).setContentTitle(eVar.f٢٦٦٧e).setContentText(eVar.f٢٦٦٨f).setContentInfo(eVar.f٢٦٧٣k).setContentIntent(eVar.f٢٦٦٩g).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = eVar.f٢٦٧٠h;
        if ((notification.flags & 128) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z13).setNumber(eVar.f٢٦٧٤l).setProgress(eVar.f٢٦٨٢t, eVar.f٢٦٨٣u, eVar.f٢٦٨٤v);
        if (i11 < 23) {
            Notification.Builder builder = this.f٢٦٩٤b;
            IconCompat iconCompat = eVar.f٢٦٧٢j;
            if (iconCompat == null) {
                d10 = null;
            } else {
                d10 = iconCompat.d();
            }
            builder.setLargeIcon(d10);
        } else {
            Notification.Builder builder2 = this.f٢٦٩٤b;
            IconCompat iconCompat2 = eVar.f٢٦٧٢j;
            if (iconCompat2 == null) {
                m10 = null;
            } else {
                m10 = iconCompat2.m(context);
            }
            c.b(builder2, m10);
        }
        this.f٢٦٩٤b.setSubText(eVar.f٢٦٧٩q).setUsesChronometer(eVar.f٢٦٧٧o).setPriority(eVar.f٢٦٧٥m);
        Iterator it = eVar.f٢٦٦٤b.iterator();
        while (it.hasNext()) {
            b((o.a) it.next());
        }
        Bundle bundle = eVar.D;
        if (bundle != null) {
            this.f٢٦٩٩g.putAll(bundle);
        }
        int i12 = Build.VERSION.SDK_INT;
        this.f٢٦٩٦d = eVar.H;
        this.f٢٦٩٧e = eVar.I;
        this.f٢٦٩٤b.setShowWhen(eVar.f٢٦٧٦n);
        a.i(this.f٢٦٩٤b, eVar.f٢٦٨٨z);
        a.g(this.f٢٦٩٤b, eVar.f٢٦٨٥w);
        a.j(this.f٢٦٩٤b, eVar.f٢٦٨٧y);
        a.h(this.f٢٦٩٤b, eVar.f٢٦٨٦x);
        this.f٢٧٠٠h = eVar.O;
        b.b(this.f٢٦٩٤b, eVar.C);
        b.c(this.f٢٦٩٤b, eVar.E);
        b.f(this.f٢٦٩٤b, eVar.F);
        b.d(this.f٢٦٩٤b, eVar.G);
        b.e(this.f٢٦٩٤b, notification.sound, notification.audioAttributes);
        if (i12 < 28) {
            list = e(g(eVar.f٢٦٦٥c), eVar.U);
        } else {
            list = eVar.U;
        }
        if (list != null && !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                b.a(this.f٢٦٩٤b, (String) it2.next());
            }
        }
        this.f٢٧٠١i = eVar.J;
        if (eVar.f٢٦٦٦d.size() > 0) {
            Bundle bundle2 = eVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i13 = 0; i13 < eVar.f٢٦٦٦d.size(); i13++) {
                bundle4.putBundle(Integer.toString(i13), q.a((o.a) eVar.f٢٦٦٦d.get(i13)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            eVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f٢٦٩٩g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 23 && (obj = eVar.T) != null) {
            c.c(this.f٢٦٩٤b, obj);
        }
        if (i14 >= 24) {
            this.f٢٦٩٤b.setExtras(eVar.D);
            d.e(this.f٢٦٩٤b, eVar.f٢٦٨١s);
            RemoteViews remoteViews = eVar.H;
            if (remoteViews != null) {
                d.c(this.f٢٦٩٤b, remoteViews);
            }
            RemoteViews remoteViews2 = eVar.I;
            if (remoteViews2 != null) {
                d.b(this.f٢٦٩٤b, remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.J;
            if (remoteViews3 != null) {
                d.d(this.f٢٦٩٤b, remoteViews3);
            }
        }
        if (i14 >= 26) {
            e.b(this.f٢٦٩٤b, eVar.L);
            e.e(this.f٢٦٩٤b, eVar.f٢٦٨٠r);
            e.f(this.f٢٦٩٤b, eVar.M);
            e.g(this.f٢٦٩٤b, eVar.N);
            e.d(this.f٢٦٩٤b, eVar.O);
            if (eVar.f٢٦٦٢B) {
                e.c(this.f٢٦٩٤b, eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.f٢٦٩٤b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i14 >= 28) {
            Iterator it3 = eVar.f٢٦٦٥c.iterator();
            if (it3.hasNext()) {
                a0.a(it3.next());
                throw null;
            }
        }
        if (i14 >= 29) {
            g.a(this.f٢٦٩٤b, eVar.Q);
            g.b(this.f٢٦٩٤b, o.d.a(null));
        }
        if (i14 >= 31 && (i10 = eVar.P) != 0) {
            h.b(this.f٢٦٩٤b, i10);
        }
        if (eVar.S) {
            if (this.f٢٦٩٥c.f٢٦٨٦x) {
                this.f٢٧٠٠h = 2;
            } else {
                this.f٢٧٠٠h = 1;
            }
            this.f٢٦٩٤b.setVibrate(null);
            this.f٢٦٩٤b.setSound(null);
            int i15 = notification.defaults & (-4);
            notification.defaults = i15;
            this.f٢٦٩٤b.setDefaults(i15);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.f٢٦٩٥c.f٢٦٨٥w)) {
                    a.g(this.f٢٦٩٤b, "silent");
                }
                e.d(this.f٢٦٩٤b, this.f٢٧٠٠h);
            }
        }
    }

    private void b(o.a aVar) {
        int i10;
        Notification.Action.Builder e10;
        Bundle bundle;
        Icon icon;
        int i11 = Build.VERSION.SDK_INT;
        IconCompat d10 = aVar.d();
        if (i11 >= 23) {
            if (d10 != null) {
                icon = d10.l();
            } else {
                icon = null;
            }
            e10 = c.a(icon, aVar.h(), aVar.a());
        } else {
            if (d10 != null) {
                i10 = d10.e();
            } else {
                i10 = 0;
            }
            e10 = a.e(i10, aVar.h(), aVar.a());
        }
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : t.b(aVar.e())) {
                a.c(e10, remoteInput);
            }
        }
        if (aVar.c() != null) {
            bundle = new Bundle(aVar.c());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 24) {
            d.a(e10, aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i12 >= 28) {
            f.a(e10, aVar.f());
        }
        if (i12 >= 29) {
            g.c(e10, aVar.j());
        }
        if (i12 >= 31) {
            h.a(e10, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(e10, bundle);
        a.a(this.f٢٦٩٤b, a.d(e10));
    }

    private static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    private static List g(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        a0.a(it.next());
        throw null;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    @Override // androidx.core.app.n
    public Notification.Builder a() {
        return this.f٢٦٩٤b;
    }

    public Notification c() {
        RemoteViews remoteViews;
        Bundle a10;
        RemoteViews f10;
        RemoteViews d10;
        o.f fVar = this.f٢٦٩٥c.f٢٦٧٨p;
        if (fVar != null) {
            fVar.b(this);
        }
        if (fVar != null) {
            remoteViews = fVar.e(this);
        } else {
            remoteViews = null;
        }
        Notification d11 = d();
        if (remoteViews != null) {
            d11.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.f٢٦٩٥c.H;
            if (remoteViews2 != null) {
                d11.contentView = remoteViews2;
            }
        }
        if (fVar != null && (d10 = fVar.d(this)) != null) {
            d11.bigContentView = d10;
        }
        if (fVar != null && (f10 = this.f٢٦٩٥c.f٢٦٧٨p.f(this)) != null) {
            d11.headsUpContentView = f10;
        }
        if (fVar != null && (a10 = o.a(d11)) != null) {
            fVar.a(a10);
        }
        return d11;
    }

    protected Notification d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return this.f٢٦٩٤b.build();
        }
        if (i10 >= 24) {
            Notification build = this.f٢٦٩٤b.build();
            if (this.f٢٧٠٠h != 0) {
                if (a.f(build) != null && (build.flags & 512) != 0 && this.f٢٧٠٠h == 2) {
                    h(build);
                }
                if (a.f(build) != null && (build.flags & 512) == 0 && this.f٢٧٠٠h == 1) {
                    h(build);
                }
            }
            return build;
        }
        this.f٢٦٩٤b.setExtras(this.f٢٦٩٩g);
        Notification build2 = this.f٢٦٩٤b.build();
        RemoteViews remoteViews = this.f٢٦٩٦d;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f٢٦٩٧e;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f٢٧٠١i;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.f٢٧٠٠h != 0) {
            if (a.f(build2) != null && (build2.flags & 512) != 0 && this.f٢٧٠٠h == 2) {
                h(build2);
            }
            if (a.f(build2) != null && (build2.flags & 512) == 0 && this.f٢٧٠٠h == 1) {
                h(build2);
            }
        }
        return build2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f٢٦٩٣a;
    }
}
