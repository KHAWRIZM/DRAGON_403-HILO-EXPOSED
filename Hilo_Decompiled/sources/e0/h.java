package e0;

import android.graphics.drawable.Animatable;
import android.widget.ImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h extends u {
    public h(b bVar, ImageView imageView, e0 e0Var, int i10, String str) {
        super(bVar, imageView, e0Var, i10, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e0.u
    public final void a() {
        ImageView imageView = (ImageView) this.f١٣٨٢٩c.get();
        if (imageView == null) {
            return;
        }
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
    }
}
