package es.dmoral.toasty;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class a {
    private static final Typeface a;
    private static Typeface b;
    private static int c;
    private static boolean d;
    private static boolean e;
    private static Toast f;

    /* renamed from: es.dmoral.toasty.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class C٠٠٤٩a {
        private Typeface a = a.b;
        private int b = a.c;
        private boolean c = a.d;
        private boolean d = true;

        private C٠٠٤٩a() {
        }

        public static C٠٠٤٩a c() {
            return new C٠٠٤٩a();
        }

        public C٠٠٤٩a a(boolean z) {
            this.d = z;
            return this;
        }

        public void b() {
            Typeface unused = a.b = this.a;
            int unused2 = a.c = this.b;
            boolean unused3 = a.d = this.c;
            boolean unused4 = a.e = this.d;
        }

        public C٠٠٤٩a d(int i) {
            this.b = i;
            return this;
        }

        public C٠٠٤٩a e(boolean z) {
            this.c = z;
            return this;
        }
    }

    static {
        Typeface create = Typeface.create("sans-serif-condensed", 0);
        a = create;
        b = create;
        c = 16;
        d = true;
        e = true;
        f = null;
    }

    public static Toast h(Context context, CharSequence charSequence, Drawable drawable, int i, int i2, int i3, boolean z, boolean z2) {
        Drawable b2;
        Toast makeText = Toast.makeText(context, "", i3);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.toast_text);
        if (z2) {
            b2 = b.d(context, i);
        } else {
            b2 = b.b(context, R.drawable.toast_frame);
        }
        b.c(inflate, b2);
        if (z) {
            if (drawable != null) {
                if (d) {
                    drawable = b.e(drawable, i2);
                }
                b.c(imageView, drawable);
            } else {
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            }
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(charSequence);
        textView.setTextColor(i2);
        textView.setTypeface(b);
        textView.setTextSize(2, c);
        makeText.setView(inflate);
        if (!e) {
            Toast toast = f;
            if (toast != null) {
                toast.cancel();
            }
            f = makeText;
        }
        return makeText;
    }

    public static Toast i(Context context, CharSequence charSequence) {
        return j(context, charSequence, 0, null, false);
    }

    public static Toast j(Context context, CharSequence charSequence, int i, Drawable drawable, boolean z) {
        return h(context, charSequence, drawable, b.a(context, R.color.normalColor), b.a(context, R.color.defaultTextColor), i, z, true);
    }
}
