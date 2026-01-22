package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class o0 extends i0 {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference f١٦٢٣b;

    public o0(Context context, Resources resources) {
        super(resources);
        this.f١٦٢٣b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) {
        Drawable a10 = a(i10);
        Context context = (Context) this.f١٦٢٣b.get();
        if (a10 != null && context != null) {
            h0.h().x(context, i10, a10);
        }
        return a10;
    }
}
