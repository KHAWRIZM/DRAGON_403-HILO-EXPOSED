package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static ColorFilter a(int i10, Object obj) {
            return new BlendModeColorFilter(i10, (BlendMode) obj);
        }
    }

    public static ColorFilter a(int i10, e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object a10 = f.b.a(eVar);
            if (a10 == null) {
                return null;
            }
            return a.a(i10, a10);
        }
        PorterDuff.Mode a11 = f.a(eVar);
        if (a11 == null) {
            return null;
        }
        return new PorterDuffColorFilter(i10, a11);
    }
}
