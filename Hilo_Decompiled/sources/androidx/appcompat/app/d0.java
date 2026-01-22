package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.network.interceptors.LoggingInterceptor;
import java.util.Calendar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class d0 {

    /* renamed from: d, reason: collision with root package name */
    private static d0 f٧٤٠d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f٧٤١a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f٧٤٢b;

    /* renamed from: c, reason: collision with root package name */
    private final a f٧٤٣c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f٧٤٤a;

        /* renamed from: b, reason: collision with root package name */
        long f٧٤٥b;

        a() {
        }
    }

    d0(Context context, LocationManager locationManager) {
        this.f٧٤١a = context;
        this.f٧٤٢b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d0 a(Context context) {
        if (f٧٤٠d == null) {
            Context applicationContext = context.getApplicationContext();
            f٧٤٠d = new d0(applicationContext, (LocationManager) applicationContext.getSystemService(FirebaseAnalytics.Param.LOCATION));
        }
        return f٧٤٠d;
    }

    private Location b() {
        Location location;
        Location location2 = null;
        if (androidx.core.content.b.b(this.f٧٤١a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = c(LoggingInterceptor.TAG);
        } else {
            location = null;
        }
        if (androidx.core.content.b.b(this.f٧٤١a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = c("gps");
        }
        if (location2 != null && location != null) {
            if (location2.getTime() > location.getTime()) {
                return location2;
            }
            return location;
        }
        if (location2 != null) {
            return location2;
        }
        return location;
    }

    private Location c(String str) {
        try {
            if (this.f٧٤٢b.isProviderEnabled(str)) {
                return this.f٧٤٢b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e10) {
            Log.d("TwilightManager", "Failed to get last known location", e10);
            return null;
        }
    }

    private boolean e() {
        if (this.f٧٤٣c.f٧٤٥b > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    private void f(Location location) {
        boolean z10;
        long j10;
        a aVar = this.f٧٤٣c;
        long currentTimeMillis = System.currentTimeMillis();
        c0 b10 = c0.b();
        b10.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        b10.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        if (b10.f٧٣٨c == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        long j11 = b10.f٧٣٧b;
        long j12 = b10.f٧٣٦a;
        b10.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j13 = b10.f٧٣٧b;
        if (j11 != -1 && j12 != -1) {
            if (currentTimeMillis <= j12) {
                if (currentTimeMillis > j11) {
                    j13 = j12;
                } else {
                    j13 = j11;
                }
            }
            j10 = j13 + 60000;
        } else {
            j10 = currentTimeMillis + 43200000;
        }
        aVar.f٧٤٤a = z10;
        aVar.f٧٤٥b = j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f٧٤٣c;
        if (e()) {
            return aVar.f٧٤٤a;
        }
        Location b10 = b();
        if (b10 != null) {
            f(b10);
            return aVar.f٧٤٤a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i10 = Calendar.getInstance().get(11);
        if (i10 >= 6 && i10 < 22) {
            return false;
        }
        return true;
    }
}
