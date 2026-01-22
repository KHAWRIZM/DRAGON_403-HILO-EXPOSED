package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.util.f;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.facebook.internal.security.CertificateUtil;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f٢٨٠٢k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f٢٨٠٣a;

    /* renamed from: b, reason: collision with root package name */
    Object f٢٨٠٤b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f٢٨٠٥c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f٢٨٠٦d;

    /* renamed from: e, reason: collision with root package name */
    public int f٢٨٠٧e;

    /* renamed from: f, reason: collision with root package name */
    public int f٢٨٠٨f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f٢٨٠٩g;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f٢٨١٠h;

    /* renamed from: i, reason: collision with root package name */
    public String f٢٨١١i;

    /* renamed from: j, reason: collision with root package name */
    public String f٢٨١٢j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        static int a(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon resource", e10);
                return 0;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon resource", e11);
                return 0;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon resource", e12);
                return 0;
            }
        }

        static String b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon package", e10);
                return null;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon package", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon package", e12);
                return null;
            }
        }

        static int c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e10);
                return -1;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e11);
                return -1;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e12);
                return -1;
            }
        }

        static Uri d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e10) {
                Log.e("IconCompat", "Unable to get icon uri", e10);
                return null;
            } catch (NoSuchMethodException e11) {
                Log.e("IconCompat", "Unable to get icon uri", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.e("IconCompat", "Unable to get icon uri", e12);
                return null;
            }
        }

        static Icon e(IconCompat iconCompat, Context context) {
            Icon createWithBitmap;
            switch (iconCompat.f٢٨٠٣a) {
                case -1:
                    return (Icon) iconCompat.f٢٨٠٤b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f٢٨٠٤b);
                    break;
                case 2:
                    createWithBitmap = Icon.createWithResource(iconCompat.f(), iconCompat.f٢٨٠٧e);
                    break;
                case 3:
                    createWithBitmap = Icon.createWithData((byte[]) iconCompat.f٢٨٠٤b, iconCompat.f٢٨٠٧e, iconCompat.f٢٨٠٨f);
                    break;
                case 4:
                    createWithBitmap = Icon.createWithContentUri((String) iconCompat.f٢٨٠٤b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT >= 26) {
                        createWithBitmap = b.a((Bitmap) iconCompat.f٢٨٠٤b);
                        break;
                    } else {
                        createWithBitmap = Icon.createWithBitmap(IconCompat.a((Bitmap) iconCompat.f٢٨٠٤b, false));
                        break;
                    }
                case 6:
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30) {
                        createWithBitmap = d.a(iconCompat.h());
                        break;
                    } else if (context != null) {
                        InputStream i11 = iconCompat.i(context);
                        if (i11 != null) {
                            if (i10 >= 26) {
                                createWithBitmap = b.a(BitmapFactory.decodeStream(i11));
                                break;
                            } else {
                                createWithBitmap = Icon.createWithBitmap(IconCompat.a(BitmapFactory.decodeStream(i11), false));
                                break;
                            }
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.h());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.h());
                    }
            }
            ColorStateList colorStateList = iconCompat.f٢٨٠٩g;
            if (colorStateList != null) {
                createWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f٢٨١٠h;
            if (mode != IconCompat.f٢٨٠٢k) {
                createWithBitmap.setTintMode(mode);
            }
            return createWithBitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {
        static Icon a(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.f٢٨٠٣a = -1;
        this.f٢٨٠٥c = null;
        this.f٢٨٠٦d = null;
        this.f٢٨٠٧e = 0;
        this.f٢٨٠٨f = 0;
        this.f٢٨٠٩g = null;
        this.f٢٨١٠h = f٢٨٠٢k;
        this.f٢٨١١i = null;
    }

    static Bitmap a(Bitmap bitmap, boolean z10) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f10 = min;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, DownloadProgress.UNKNOWN_PROGRESS, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat b(Bitmap bitmap) {
        f.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f٢٨٠٤b = bitmap;
        return iconCompat;
    }

    public static IconCompat c(Resources resources, String str, int i10) {
        f.c(str);
        if (i10 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f٢٨٠٧e = i10;
            if (resources != null) {
                try {
                    iconCompat.f٢٨٠٤b = resources.getResourceName(i10);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f٢٨٠٤b = str;
            }
            iconCompat.f٢٨١٢j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    private static String n(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap d() {
        int i10 = this.f٢٨٠٣a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f٢٨٠٤b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i10 == 1) {
            return (Bitmap) this.f٢٨٠٤b;
        }
        if (i10 == 5) {
            return a((Bitmap) this.f٢٨٠٤b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int e() {
        int i10 = this.f٢٨٠٣a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.a(this.f٢٨٠٤b);
        }
        if (i10 == 2) {
            return this.f٢٨٠٧e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String f() {
        int i10 = this.f٢٨٠٣a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.b(this.f٢٨٠٤b);
        }
        if (i10 == 2) {
            String str = this.f٢٨١٢j;
            if (str != null && !TextUtils.isEmpty(str)) {
                return this.f٢٨١٢j;
            }
            return ((String) this.f٢٨٠٤b).split(CertificateUtil.DELIMITER, -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int g() {
        int i10 = this.f٢٨٠٣a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f٢٨٠٤b);
        }
        return i10;
    }

    public Uri h() {
        int i10 = this.f٢٨٠٣a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.d(this.f٢٨٠٤b);
        }
        if (i10 != 4 && i10 != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse((String) this.f٢٨٠٤b);
    }

    public InputStream i(Context context) {
        Uri h10 = h();
        String scheme = h10.getScheme();
        if (!"content".equals(scheme) && !"file".equals(scheme)) {
            try {
                return new FileInputStream(new File((String) this.f٢٨٠٤b));
            } catch (FileNotFoundException e10) {
                Log.w("IconCompat", "Unable to load image from path: " + h10, e10);
                return null;
            }
        }
        try {
            return context.getContentResolver().openInputStream(h10);
        } catch (Exception e11) {
            Log.w("IconCompat", "Unable to load image from URI: " + h10, e11);
            return null;
        }
    }

    public void j() {
        this.f٢٨١٠h = PorterDuff.Mode.valueOf(this.f٢٨١١i);
        switch (this.f٢٨٠٣a) {
            case -1:
                Parcelable parcelable = this.f٢٨٠٦d;
                if (parcelable != null) {
                    this.f٢٨٠٤b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f٢٨٠٦d;
                if (parcelable2 != null) {
                    this.f٢٨٠٤b = parcelable2;
                    return;
                }
                byte[] bArr = this.f٢٨٠٥c;
                this.f٢٨٠٤b = bArr;
                this.f٢٨٠٣a = 3;
                this.f٢٨٠٧e = 0;
                this.f٢٨٠٨f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f٢٨٠٥c, Charset.forName("UTF-16"));
                this.f٢٨٠٤b = str;
                if (this.f٢٨٠٣a == 2 && this.f٢٨١٢j == null) {
                    this.f٢٨١٢j = str.split(CertificateUtil.DELIMITER, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f٢٨٠٤b = this.f٢٨٠٥c;
                return;
        }
    }

    public void k(boolean z10) {
        this.f٢٨١١i = this.f٢٨١٠h.name();
        switch (this.f٢٨٠٣a) {
            case -1:
                if (!z10) {
                    this.f٢٨٠٦d = (Parcelable) this.f٢٨٠٤b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z10) {
                    Bitmap bitmap = (Bitmap) this.f٢٨٠٤b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f٢٨٠٥c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f٢٨٠٦d = (Parcelable) this.f٢٨٠٤b;
                return;
            case 2:
                this.f٢٨٠٥c = ((String) this.f٢٨٠٤b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f٢٨٠٥c = (byte[]) this.f٢٨٠٤b;
                return;
            case 4:
            case 6:
                this.f٢٨٠٥c = this.f٢٨٠٤b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public Icon l() {
        return m(null);
    }

    public Icon m(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.e(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        if (this.f٢٨٠٣a == -1) {
            return String.valueOf(this.f٢٨٠٤b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(n(this.f٢٨٠٣a));
        switch (this.f٢٨٠٣a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f٢٨٠٤b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f٢٨٠٤b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f٢٨١٢j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(e())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f٢٨٠٧e);
                if (this.f٢٨٠٨f != 0) {
                    sb.append(" off=");
                    sb.append(this.f٢٨٠٨f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f٢٨٠٤b);
                break;
        }
        if (this.f٢٨٠٩g != null) {
            sb.append(" tint=");
            sb.append(this.f٢٨٠٩g);
        }
        if (this.f٢٨١٠h != f٢٨٠٢k) {
            sb.append(" mode=");
            sb.append(this.f٢٨١٠h);
        }
        sb.append(")");
        return sb.toString();
    }

    IconCompat(int i10) {
        this.f٢٨٠٥c = null;
        this.f٢٨٠٦d = null;
        this.f٢٨٠٧e = 0;
        this.f٢٨٠٨f = 0;
        this.f٢٨٠٩g = null;
        this.f٢٨١٠h = f٢٨٠٢k;
        this.f٢٨١١i = null;
        this.f٢٨٠٣a = i10;
    }
}
