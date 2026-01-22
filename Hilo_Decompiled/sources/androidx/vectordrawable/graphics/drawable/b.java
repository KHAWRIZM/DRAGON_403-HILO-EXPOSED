package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2$AnimationCallback;
import android.graphics.drawable.Drawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    Animatable2$AnimationCallback f٤٣٨٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends Animatable2$AnimationCallback {
        a() {
        }

        public void onAnimationEnd(Drawable drawable) {
            b.this.b(drawable);
        }

        public void onAnimationStart(Drawable drawable) {
            b.this.c(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animatable2$AnimationCallback a() {
        if (this.f٤٣٨٩a == null) {
            this.f٤٣٨٩a = new a();
        }
        return this.f٤٣٨٩a;
    }

    public void b(Drawable drawable) {
    }

    public void c(Drawable drawable) {
    }
}
