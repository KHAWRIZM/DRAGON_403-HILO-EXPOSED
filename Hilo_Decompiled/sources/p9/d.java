package p9;

import android.util.Log;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f١٦٩٧١a = "MCS";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f١٦٩٧٢b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f١٦٩٧٣c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f١٦٩٧٤d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f١٦٩٧٥e = true;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f١٦٩٧٦f = true;

    /* renamed from: g, reason: collision with root package name */
    private static String f١٦٩٧٧g = "-->";

    /* renamed from: h, reason: collision with root package name */
    private static boolean f١٦٩٧٨h = true;

    public static void a(String str) {
        if (f١٦٩٧٤d && f١٦٩٧٨h) {
            Log.d("mcssdk---", f١٦٩٧١a + f١٦٩٧٧g + str);
        }
    }

    public static void b(String str) {
        if (f١٦٩٧٦f && f١٦٩٧٨h) {
            Log.e("mcssdk---", f١٦٩٧١a + f١٦٩٧٧g + str);
        }
    }

    public static void c(boolean z10) {
        f١٦٩٧٨h = z10;
        if (z10) {
            f١٦٩٧٢b = true;
            f١٦٩٧٤d = true;
            f١٦٩٧٣c = true;
            f١٦٩٧٥e = true;
            f١٦٩٧٦f = true;
            return;
        }
        f١٦٩٧٢b = false;
        f١٦٩٧٤d = false;
        f١٦٩٧٣c = false;
        f١٦٩٧٥e = false;
        f١٦٩٧٦f = false;
    }
}
