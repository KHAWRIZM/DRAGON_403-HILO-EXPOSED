package ic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f١٤٨٧٦a = "f";

    /* renamed from: b, reason: collision with root package name */
    private static final Canvas f١٤٨٧٧b = new Canvas();

    public static Drawable a(Context context, int i10) {
        try {
            return r1.a.b(context, i10);
        } catch (Exception e10) {
            yb.b.a(f١٤٨٧٦a, "Error in getVectorDrawable. resVector=" + i10 + ", resName=" + context.getResources().getResourceName(i10) + e10.getMessage(), new Object[0]);
            return null;
        }
    }

    public static ColorFilter b(Drawable drawable, int i10) {
        LightingColorFilter lightingColorFilter = new LightingColorFilter(Color.argb(KotlinVersion.MAX_COMPONENT_VALUE, 0, 0, 0), i10);
        if (drawable != null) {
            drawable.setColorFilter(lightingColorFilter);
        }
        return lightingColorFilter;
    }
}
