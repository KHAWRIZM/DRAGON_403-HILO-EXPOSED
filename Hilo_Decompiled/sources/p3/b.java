package p3;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.c;
import com.airbnb.lottie.k0;
import io.agora.rtc.Constants;
import java.io.IOException;
import java.util.Map;
import x3.f;
import x3.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f١٦٨٥١d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٦٨٥٢a;

    /* renamed from: b, reason: collision with root package name */
    private final String f١٦٨٥٣b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f١٦٨٥٤c;

    public b(Drawable.Callback callback, String str, c cVar, Map map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f١٦٨٥٣b = str + '/';
        } else {
            this.f١٦٨٥٣b = str;
        }
        this.f١٦٨٥٤c = map;
        d(cVar);
        if (!(callback instanceof View)) {
            this.f١٦٨٥٢a = null;
        } else {
            this.f١٦٨٥٢a = ((View) callback).getContext().getApplicationContext();
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f١٦٨٥١d) {
            ((k0) this.f١٦٨٥٤c.get(str)).g(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        k0 k0Var = (k0) this.f١٦٨٥٤c.get(str);
        if (k0Var == null) {
            return null;
        }
        Bitmap b10 = k0Var.b();
        if (b10 != null) {
            return b10;
        }
        Context context = this.f١٦٨٥٢a;
        if (context == null) {
            return null;
        }
        String c10 = k0Var.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = Constants.ERR_ALREADY_IN_RECORDING;
        if (c10.startsWith("data:") && c10.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(c10.substring(c10.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e10) {
                f.d("data URL did not have correct base64 format.", e10);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f١٦٨٥٣b)) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.f١٦٨٥٣b + c10), null, options);
                    if (decodeStream == null) {
                        f.c("Decoded image `" + str + "` is null.");
                        return null;
                    }
                    return c(str, l.l(decodeStream, k0Var.f(), k0Var.d()));
                } catch (IllegalArgumentException e11) {
                    f.d("Unable to decode image `" + str + "`.", e11);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e12) {
            f.d("Unable to open asset.", e12);
            return null;
        }
    }

    public boolean b(Context context) {
        if (this.f١٦٨٥٢a instanceof Application) {
            context = context.getApplicationContext();
        }
        if (context == this.f١٦٨٥٢a) {
            return true;
        }
        return false;
    }

    public void d(c cVar) {
    }
}
