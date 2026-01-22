package e0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k extends BitmapDrawable {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f١٣٧٩٥a;

    /* renamed from: b, reason: collision with root package name */
    public final long f١٣٧٩٦b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f١٣٧٩٧c;

    /* renamed from: d, reason: collision with root package name */
    public int f١٣٧٩٨d;

    static {
        new Paint();
    }

    public k(Context context, Bitmap bitmap, Drawable drawable, int i10) {
        super(context.getResources(), bitmap);
        this.f١٣٧٩٨d = KotlinVersion.MAX_COMPONENT_VALUE;
        float f10 = context.getResources().getDisplayMetrics().density;
        if (i10 != 1) {
            this.f١٣٧٩٥a = drawable;
            this.f١٣٧٩٧c = true;
            this.f١٣٧٩٦b = SystemClock.uptimeMillis();
        }
    }

    public static void a(ImageView imageView) {
        imageView.setImageDrawable(null);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(ImageView imageView, Context context, Bitmap bitmap, int i10) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new k(context, bitmap, drawable, i10));
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (!this.f١٣٧٩٧c) {
            super.draw(canvas);
            return;
        }
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f١٣٧٩٦b)) / 200.0f;
        if (uptimeMillis >= 1.0f) {
            this.f١٣٧٩٧c = false;
            this.f١٣٧٩٥a = null;
            super.draw(canvas);
        } else {
            Drawable drawable = this.f١٣٧٩٥a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            super.setAlpha((int) (this.f١٣٧٩٨d * uptimeMillis));
            super.draw(canvas);
            super.setAlpha(this.f١٣٧٩٨d);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f١٣٧٩٥a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.f١٣٧٩٨d = i10;
        Drawable drawable = this.f١٣٧٩٥a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        }
        super.setAlpha(i10);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f١٣٧٩٥a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
