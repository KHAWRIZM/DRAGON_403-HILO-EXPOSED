package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final ICustomTabsCallback f١٧٢٣a;

    /* renamed from: b, reason: collision with root package name */
    private final y1.a f١٧٢٤b = new C٠٠١١a();

    /* renamed from: androidx.browser.customtabs.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class C٠٠١١a extends y1.a {
        C٠٠١١a() {
        }

        @Override // y1.a
        public void extraCallback(String str, Bundle bundle) {
            try {
                a.this.f١٧٢٣a.extraCallback(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // y1.a
        public void onMessageChannelReady(Bundle bundle) {
            try {
                a.this.f١٧٢٣a.onMessageChannelReady(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // y1.a
        public void onNavigationEvent(int i10, Bundle bundle) {
            try {
                a.this.f١٧٢٣a.onNavigationEvent(i10, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // y1.a
        public void onPostMessage(String str, Bundle bundle) {
            try {
                a.this.f١٧٢٣a.onPostMessage(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // y1.a
        public void onRelationshipValidationResult(int i10, Uri uri, boolean z10, Bundle bundle) {
            try {
                a.this.f١٧٢٣a.onRelationshipValidationResult(i10, uri, z10, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ICustomTabsCallback iCustomTabsCallback) {
        this.f١٧٢٣a = iCustomTabsCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.f١٧٢٣a.asBinder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return ((a) obj).a().equals(this.f١٧٢٣a.asBinder());
    }

    public int hashCode() {
        return a().hashCode();
    }
}
