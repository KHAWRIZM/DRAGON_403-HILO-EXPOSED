package x2;

import android.text.Editable;
import androidx.emoji2.text.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f١٨٨٧٢a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f١٨٨٧٣b;

    /* renamed from: c, reason: collision with root package name */
    private static Class f١٨٨٧٤c;

    private b() {
        try {
            f١٨٨٧٤c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f١٨٨٧٣b == null) {
            synchronized (f١٨٨٧٢a) {
                try {
                    if (f١٨٨٧٣b == null) {
                        f١٨٨٧٣b = new b();
                    }
                } finally {
                }
            }
        }
        return f١٨٨٧٣b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f١٨٨٧٤c;
        if (cls != null) {
            return o.c(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
