package d0;

import android.content.SharedPreferences;
import java.util.HashMap;
import tech.sud.base.utils.Utils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f١٣٥٣٨b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f١٣٥٣٩a;

    public a(String str) {
        this.f١٣٥٣٩a = Utils.getApp().getSharedPreferences(str, 0);
    }

    public static a a(String str) {
        a aVar;
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                if (!Character.isWhitespace(str.charAt(i10))) {
                    break;
                }
                i10++;
            } else {
                str = "spUtils";
                break;
            }
        }
        HashMap hashMap = f١٣٥٣٨b;
        a aVar2 = (a) hashMap.get(str);
        if (aVar2 == null) {
            synchronized (a.class) {
                try {
                    aVar = (a) hashMap.get(str);
                    if (aVar == null) {
                        aVar = new a(str);
                        hashMap.put(str, aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
        return aVar2;
    }

    public final void b() {
        this.f١٣٥٣٩a.edit().clear().apply();
    }

    public final void c(String str, String str2, boolean z10) {
        if (z10) {
            this.f١٣٥٣٩a.edit().putString(str, str2).commit();
        } else {
            this.f١٣٥٣٩a.edit().putString(str, str2).apply();
        }
    }

    public final void d(String str) {
        this.f١٣٥٣٩a.edit().remove(str).apply();
    }

    public final void e(String str) {
        this.f١٣٥٣٩a.edit().putBoolean(str, true).apply();
    }
}
