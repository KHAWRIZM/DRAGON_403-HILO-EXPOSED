package y1;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f١٩١٠٨a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ICustomTabsService f١٩١٠٩b;

    /* renamed from: c, reason: collision with root package name */
    private final ICustomTabsCallback f١٩١١٠c;

    /* renamed from: d, reason: collision with root package name */
    private final ComponentName f١٩١١١d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName) {
        this.f١٩١٠٩b = iCustomTabsService;
        this.f١٩١١٠c = iCustomTabsCallback;
        this.f١٩١١١d = componentName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.f١٩١١٠c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComponentName b() {
        return this.f١٩١١١d;
    }

    public boolean c(Uri uri, Bundle bundle, List list) {
        try {
            return this.f١٩١٠٩b.mayLaunchUrl(this.f١٩١١٠c, uri, bundle, list);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
