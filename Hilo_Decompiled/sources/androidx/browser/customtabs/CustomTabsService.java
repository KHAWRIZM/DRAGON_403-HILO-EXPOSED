package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class CustomTabsService extends Service {

    /* renamed from: a, reason: collision with root package name */
    final Map f١٧١٦a = new androidx.collection.a();

    /* renamed from: b, reason: collision with root package name */
    private ICustomTabsService.Stub f١٧١٧b = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends ICustomTabsService.Stub {

        /* renamed from: androidx.browser.customtabs.CustomTabsService$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class C٠٠١٠a implements IBinder.DeathRecipient {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ androidx.browser.customtabs.a f١٧١٩a;

            C٠٠١٠a(androidx.browser.customtabs.a aVar) {
                this.f١٧١٩a = aVar;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                CustomTabsService.this.a(this.f١٧١٩a);
            }
        }

        a() {
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List list) {
            return CustomTabsService.this.c(new androidx.browser.customtabs.a(iCustomTabsCallback), uri, bundle, list);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            androidx.browser.customtabs.a aVar = new androidx.browser.customtabs.a(iCustomTabsCallback);
            try {
                C٠٠١٠a r22 = new C٠٠١٠a(aVar);
                synchronized (CustomTabsService.this.f١٧١٦a) {
                    iCustomTabsCallback.asBinder().linkToDeath(r22, 0);
                    CustomTabsService.this.f١٧١٦a.put(iCustomTabsCallback.asBinder(), r22);
                }
                return CustomTabsService.this.d(aVar);
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            return CustomTabsService.this.e(new androidx.browser.customtabs.a(iCustomTabsCallback), str, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            return CustomTabsService.this.f(new androidx.browser.customtabs.a(iCustomTabsCallback), uri);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return CustomTabsService.this.g(new androidx.browser.customtabs.a(iCustomTabsCallback), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i10, Uri uri, Bundle bundle) {
            return CustomTabsService.this.h(new androidx.browser.customtabs.a(iCustomTabsCallback), i10, uri, bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long j10) {
            return CustomTabsService.this.i(j10);
        }
    }

    protected boolean a(androidx.browser.customtabs.a aVar) {
        try {
            synchronized (this.f١٧١٦a) {
                IBinder a10 = aVar.a();
                a10.unlinkToDeath((IBinder.DeathRecipient) this.f١٧١٦a.get(a10), 0);
                this.f١٧١٦a.remove(a10);
            }
            return true;
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    protected abstract Bundle b(String str, Bundle bundle);

    protected abstract boolean c(androidx.browser.customtabs.a aVar, Uri uri, Bundle bundle, List list);

    protected abstract boolean d(androidx.browser.customtabs.a aVar);

    protected abstract int e(androidx.browser.customtabs.a aVar, String str, Bundle bundle);

    protected abstract boolean f(androidx.browser.customtabs.a aVar, Uri uri);

    protected abstract boolean g(androidx.browser.customtabs.a aVar, Bundle bundle);

    protected abstract boolean h(androidx.browser.customtabs.a aVar, int i10, Uri uri, Bundle bundle);

    protected abstract boolean i(long j10);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f١٧١٧b;
    }
}
