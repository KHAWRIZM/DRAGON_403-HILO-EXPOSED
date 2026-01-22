package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final ActionBarContainer f١٤٦٢a;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class C٠٠٠٩a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public a(ActionBarContainer actionBarContainer) {
        this.f١٤٦٢a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f١٤٦٢a;
        if (actionBarContainer.f١١٣١h) {
            Drawable drawable = actionBarContainer.f١١٣٠g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f١١٢٨e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f١٤٦٢a;
        Drawable drawable3 = actionBarContainer2.f١١٢٩f;
        if (drawable3 != null && actionBarContainer2.f١١٣٢i) {
            drawable3.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f١٤٦٢a;
        if (actionBarContainer.f١١٣١h) {
            if (actionBarContainer.f١١٣٠g != null) {
                C٠٠٠٩a.a(actionBarContainer.f١١٢٨e, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f١١٢٨e;
            if (drawable != null) {
                C٠٠٠٩a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
