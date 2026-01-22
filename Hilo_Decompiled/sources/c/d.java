package c;

import B.Sudif;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static final d f٥٦٢٧f = new d();

    /* renamed from: b, reason: collision with root package name */
    public Context f٥٦٢٩b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f٥٦٢٨a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final a f٥٦٣٠c = new a(this);

    /* renamed from: d, reason: collision with root package name */
    public boolean f٥٦٣١d = false;

    /* renamed from: e, reason: collision with root package name */
    public final Sudif f٥٦٣٢e = new Sudif(this);

    public static int a(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 23) {
                activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                    if (networkCapabilities.hasTransport(1)) {
                        return 1;
                    }
                    if (networkCapabilities.hasTransport(0)) {
                        return 2;
                    }
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.getType() == 0) {
                        return 2;
                    }
                    if (activeNetworkInfo.getType() == 1) {
                        return 1;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public final void b(Context context) {
        if (!this.f٥٦٣١d) {
            this.f٥٦٢٩b = context;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (Build.VERSION.SDK_INT >= 24) {
                    connectivityManager.registerDefaultNetworkCallback(this.f٥٦٣٠c);
                } else {
                    connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.f٥٦٣٠c);
                }
                this.f٥٦٣١d = true;
            } catch (Exception unused) {
            }
        }
    }
}
