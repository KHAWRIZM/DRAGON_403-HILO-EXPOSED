package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    private final PointerIcon f٢٩٩٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static PointerIcon a(Context context, int i10) {
            return PointerIcon.getSystemIcon(context, i10);
        }
    }

    private n0(PointerIcon pointerIcon) {
        this.f٢٩٩٧a = pointerIcon;
    }

    public static n0 b(Context context, int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new n0(a.a(context, i10));
        }
        return new n0(null);
    }

    public Object a() {
        return this.f٢٩٩٧a;
    }
}
