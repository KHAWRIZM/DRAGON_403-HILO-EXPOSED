package es.dmoral.toasty;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
abstract class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, int i) {
        return androidx.core.content.a.getColor(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable b(Context context, int i) {
        return r1.a.b(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable d(Context context, int i) {
        return e((NinePatchDrawable) b(context, R.drawable.toast_frame), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable e(Drawable drawable, int i) {
        drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        return drawable;
    }
}
