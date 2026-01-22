package p3;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import q3.c;
import q3.i;
import x3.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private final AssetManager f١٦٨٤٩d;

    /* renamed from: a, reason: collision with root package name */
    private final i f١٦٨٤٦a = new i();

    /* renamed from: b, reason: collision with root package name */
    private final Map f١٦٨٤٧b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map f١٦٨٤٨c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private String f١٦٨٥٠e = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.b bVar) {
        if (!(callback instanceof View)) {
            f.c("LottieDrawable must be inside of a view for images to work.");
            this.f١٦٨٤٩d = null;
        } else {
            this.f١٦٨٤٩d = ((View) callback).getContext().getAssets();
        }
    }

    private Typeface a(c cVar) {
        String a10 = cVar.a();
        Typeface typeface = (Typeface) this.f١٦٨٤٨c.get(a10);
        if (typeface != null) {
            return typeface;
        }
        cVar.c();
        cVar.b();
        if (cVar.d() != null) {
            return cVar.d();
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f١٦٨٤٩d, "fonts/" + a10 + this.f١٦٨٥٠e);
        this.f١٦٨٤٨c.put(a10, createFromAsset);
        return createFromAsset;
    }

    private Typeface e(Typeface typeface, String str) {
        int i10;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i10 = 3;
        } else if (contains) {
            i10 = 2;
        } else if (contains2) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (typeface.getStyle() == i10) {
            return typeface;
        }
        return Typeface.create(typeface, i10);
    }

    public Typeface b(c cVar) {
        this.f١٦٨٤٦a.b(cVar.a(), cVar.c());
        Typeface typeface = (Typeface) this.f١٦٨٤٧b.get(this.f١٦٨٤٦a);
        if (typeface != null) {
            return typeface;
        }
        Typeface e10 = e(a(cVar), cVar.c());
        this.f١٦٨٤٧b.put(this.f١٦٨٤٦a, e10);
        return e10;
    }

    public void c(String str) {
        this.f١٦٨٥٠e = str;
    }

    public void d(com.airbnb.lottie.b bVar) {
    }
}
