package p7;

import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e extends Property {

    /* renamed from: a, reason: collision with root package name */
    public static final Property f١٦٩٥٤a = new e();

    private e() {
        super(Integer.class, "drawableAlphaCompat");
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
