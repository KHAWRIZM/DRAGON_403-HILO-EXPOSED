package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.graphics.f;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f٢٧٩٧a = new ThreadLocal();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {
        static void a(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    public static boolean a(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("\udfffd");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        if (measureText3 == DownloadProgress.UNKNOWN_PROGRESS) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i10 = 0;
            while (i10 < length) {
                int charCount = Character.charCount(str.codePointAt(i10)) + i10;
                f10 += paint.measureText(str, i10, charCount);
                i10 = charCount;
            }
            if (measureText3 >= f10) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        androidx.core.util.g b10 = b();
        paint.getTextBounds("\udfffd", 0, 2, (Rect) b10.f٢٨٨٨a);
        paint.getTextBounds(str, 0, length, (Rect) b10.f٢٨٨٩b);
        return !((Rect) b10.f٢٨٨٨a).equals(b10.f٢٨٨٩b);
    }

    private static androidx.core.util.g b() {
        ThreadLocal threadLocal = f٢٧٩٧a;
        androidx.core.util.g gVar = (androidx.core.util.g) threadLocal.get();
        if (gVar == null) {
            androidx.core.util.g gVar2 = new androidx.core.util.g(new Rect(), new Rect());
            threadLocal.set(gVar2);
            return gVar2;
        }
        ((Rect) gVar.f٢٨٨٨a).setEmpty();
        ((Rect) gVar.f٢٨٨٩b).setEmpty();
        return gVar;
    }

    public static boolean c(Paint paint, e eVar) {
        PorterDuffXfermode porterDuffXfermode = null;
        Object obj = null;
        if (Build.VERSION.SDK_INT >= 29) {
            if (eVar != null) {
                obj = f.b.a(eVar);
            }
            b.a(paint, obj);
            return true;
        }
        if (eVar != null) {
            PorterDuff.Mode a10 = f.a(eVar);
            if (a10 != null) {
                porterDuffXfermode = new PorterDuffXfermode(a10);
            }
            paint.setXfermode(porterDuffXfermode);
            if (a10 != null) {
                return true;
            }
            return false;
        }
        paint.setXfermode(null);
        return true;
    }
}
