package x;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f١٨٨٣٢c = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");

    /* renamed from: a, reason: collision with root package name */
    public Boolean f١٨٨٣٣a = null;

    /* renamed from: b, reason: collision with root package name */
    public ConnectivityManager f١٨٨٣٤b = null;

    public static int a(int i10, boolean z10, r0.g gVar, String str) {
        String str2 = gVar.f١٧٢٨٤c;
        if (i10 == 412) {
            return 5;
        }
        if (!l0.d.d(str2) && !l0.d.d(str) && !str.equals(str2)) {
            return 4;
        }
        if (i10 == 201 && z10) {
            return 6;
        }
        if (i10 == 205 && z10) {
            return 7;
        }
        return 0;
    }

    public final void b() {
        boolean z10;
        if (this.f١٨٨٣٣a == null) {
            if (n0.f.a().f١٦١٤٤h.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f١٨٨٣٣a = Boolean.valueOf(z10);
        }
        if (this.f١٨٨٣٣a.booleanValue()) {
            if (this.f١٨٨٣٤b == null) {
                this.f١٨٨٣٤b = (ConnectivityManager) n0.f.a().f١٦١٤٤h.getApplicationContext().getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = this.f١٨٨٣٤b;
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                } else {
                    throw new UnknownHostException("network is not available!");
                }
            }
        }
    }

    public final void c(n0.e eVar) {
        boolean z10;
        if (this.f١٨٨٣٣a == null) {
            if (n0.f.a().f١٦١٤٤h.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f١٨٨٣٣a = Boolean.valueOf(z10);
        }
        eVar.getClass();
    }
}
