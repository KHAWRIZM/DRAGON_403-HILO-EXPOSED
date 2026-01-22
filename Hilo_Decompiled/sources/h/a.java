package h;

import android.content.SharedPreferences;
import tech.sud.base.utils.Utils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static a f١٤٤٨١b;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f١٤٤٨٢a = Utils.getApp().getSharedPreferences("sudmgp_local_file_encrypt_key", 0);

    public static a a() {
        if (f١٤٤٨١b == null) {
            synchronized (a.class) {
                try {
                    if (f١٤٤٨١b == null) {
                        f١٤٤٨١b = new a();
                    }
                } finally {
                }
            }
        }
        return f١٤٤٨١b;
    }
}
