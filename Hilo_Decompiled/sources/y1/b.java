package y1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final ICustomTabsService f١٩٠٧٨a;

    /* renamed from: b, reason: collision with root package name */
    private final ComponentName f١٩٠٧٩b;

    /* renamed from: y1.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class BinderC٠٢٤٤b extends ICustomTabsCallback.Stub {

        /* renamed from: a, reason: collision with root package name */
        private Handler f١٩٠٨١a = new Handler(Looper.getMainLooper());

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y1.a f١٩٠٨٢b;

        /* renamed from: y1.b$b$a */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f١٩٠٨٤a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f١٩٠٨٥b;

            a(int i10, Bundle bundle) {
                this.f١٩٠٨٤a = i10;
                this.f١٩٠٨٥b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC٠٢٤٤b.this.f١٩٠٨٢b.onNavigationEvent(this.f١٩٠٨٤a, this.f١٩٠٨٥b);
            }
        }

        /* renamed from: y1.b$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class RunnableC٠٢٤٥b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f١٩٠٨٧a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f١٩٠٨٨b;

            RunnableC٠٢٤٥b(String str, Bundle bundle) {
                this.f١٩٠٨٧a = str;
                this.f١٩٠٨٨b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC٠٢٤٤b.this.f١٩٠٨٢b.extraCallback(this.f١٩٠٨٧a, this.f١٩٠٨٨b);
            }
        }

        /* renamed from: y1.b$b$c */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f١٩٠٩٠a;

            c(Bundle bundle) {
                this.f١٩٠٩٠a = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC٠٢٤٤b.this.f١٩٠٨٢b.onMessageChannelReady(this.f١٩٠٩٠a);
            }
        }

        /* renamed from: y1.b$b$d */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f١٩٠٩٢a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f١٩٠٩٣b;

            d(String str, Bundle bundle) {
                this.f١٩٠٩٢a = str;
                this.f١٩٠٩٣b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC٠٢٤٤b.this.f١٩٠٨٢b.onPostMessage(this.f١٩٠٩٢a, this.f١٩٠٩٣b);
            }
        }

        /* renamed from: y1.b$b$e */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f١٩٠٩٥a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Uri f١٩٠٩٦b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f١٩٠٩٧c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f١٩٠٩٨d;

            e(int i10, Uri uri, boolean z10, Bundle bundle) {
                this.f١٩٠٩٥a = i10;
                this.f١٩٠٩٦b = uri;
                this.f١٩٠٩٧c = z10;
                this.f١٩٠٩٨d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC٠٢٤٤b.this.f١٩٠٨٢b.onRelationshipValidationResult(this.f١٩٠٩٥a, this.f١٩٠٩٦b, this.f١٩٠٩٧c, this.f١٩٠٩٨d);
            }
        }

        BinderC٠٢٤٤b(y1.a aVar) {
            this.f١٩٠٨٢b = aVar;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String str, Bundle bundle) {
            if (this.f١٩٠٨٢b == null) {
                return;
            }
            this.f١٩٠٨١a.post(new RunnableC٠٢٤٥b(str, bundle));
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle bundle) {
            if (this.f١٩٠٨٢b == null) {
                return;
            }
            this.f١٩٠٨١a.post(new c(bundle));
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int i10, Bundle bundle) {
            if (this.f١٩٠٨٢b == null) {
                return;
            }
            this.f١٩٠٨١a.post(new a(i10, bundle));
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String str, Bundle bundle) {
            if (this.f١٩٠٨٢b == null) {
                return;
            }
            this.f١٩٠٨١a.post(new d(str, bundle));
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int i10, Uri uri, boolean z10, Bundle bundle) {
            if (this.f١٩٠٨٢b == null) {
                return;
            }
            this.f١٩٠٨١a.post(new e(i10, uri, z10, bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ICustomTabsService iCustomTabsService, ComponentName componentName) {
        this.f١٩٠٧٨a = iCustomTabsService;
        this.f١٩٠٧٩b = componentName;
    }

    public static boolean a(Context context, String str, d dVar) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, dVar, 33);
    }

    public static boolean b(Context context, String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return a(applicationContext, str, new a(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    public e c(y1.a aVar) {
        BinderC٠٢٤٤b r02 = new BinderC٠٢٤٤b(aVar);
        try {
            if (!this.f١٩٠٧٨a.newSession(r02)) {
                return null;
            }
            return new e(this.f١٩٠٧٨a, r02, this.f١٩٠٧٩b);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public boolean d(long j10) {
        try {
            return this.f١٩٠٧٨a.warmup(j10);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f١٩٠٨٠a;

        a(Context context) {
            this.f١٩٠٨٠a = context;
        }

        @Override // y1.d
        public final void onCustomTabsServiceConnected(ComponentName componentName, b bVar) {
            bVar.d(0L);
            this.f١٩٠٨٠a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
