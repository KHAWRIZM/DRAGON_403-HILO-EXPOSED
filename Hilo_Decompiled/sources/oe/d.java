package oe;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import oe.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f١٦٨٢٤a = "d";

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٦٨٢٥a;

        /* renamed from: b, reason: collision with root package name */
        private final Bitmap f١٦٨٢٦b;

        /* renamed from: c, reason: collision with root package name */
        private final oe.b f١٦٨٢٧c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f١٦٨٢٨d;

        /* renamed from: oe.d$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        class C٠٢٠٨a implements c.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ImageView f١٦٨٢٩a;

            C٠٢٠٨a(ImageView imageView) {
                this.f١٦٨٢٩a = imageView;
            }

            @Override // oe.c.b
            public void a(Bitmap bitmap) {
                this.f١٦٨٢٩a.setImageDrawable(new BitmapDrawable(a.this.f١٦٨٢٥a.getResources(), bitmap));
            }
        }

        public a(Context context, Bitmap bitmap, oe.b bVar, boolean z10) {
            this.f١٦٨٢٥a = context;
            this.f١٦٨٢٦b = bitmap;
            this.f١٦٨٢٧c = bVar;
            this.f١٦٨٢٨d = z10;
        }

        public void b(ImageView imageView) {
            this.f١٦٨٢٧c.f١٦٨١١a = this.f١٦٨٢٦b.getWidth();
            this.f١٦٨٢٧c.f١٦٨١٢b = this.f١٦٨٢٦b.getHeight();
            if (this.f١٦٨٢٨d) {
                new c(imageView.getContext(), this.f١٦٨٢٦b, this.f١٦٨٢٧c, new C٠٢٠٨a(imageView)).e();
            } else {
                imageView.setImageDrawable(new BitmapDrawable(this.f١٦٨٢٥a.getResources(), oe.a.a(imageView.getContext(), this.f١٦٨٢٦b, this.f١٦٨٢٧c)));
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final View f١٦٨٣١a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f١٦٨٣٢b;

        /* renamed from: c, reason: collision with root package name */
        private final oe.b f١٦٨٣٣c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٦٨٣٤d;

        /* renamed from: e, reason: collision with root package name */
        private int f١٦٨٣٥e = 300;

        public b(Context context) {
            this.f١٦٨٣٢b = context;
            View view = new View(context);
            this.f١٦٨٣١a = view;
            view.setTag(d.f١٦٨٢٤a);
            this.f١٦٨٣٣c = new oe.b();
        }

        public a a(Bitmap bitmap) {
            return new a(this.f١٦٨٣٢b, bitmap, this.f١٦٨٣٣c, this.f١٦٨٣٤d);
        }

        public b b(int i10) {
            this.f١٦٨٣٣c.f١٦٨١٤d = i10;
            return this;
        }
    }

    public static b b(Context context) {
        return new b(context);
    }
}
