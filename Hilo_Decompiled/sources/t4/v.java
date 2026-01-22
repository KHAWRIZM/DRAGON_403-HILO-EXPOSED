package t4;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class v implements n {

    /* renamed from: a, reason: collision with root package name */
    private final n f١٨١١٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements o {
        @Override // t4.o
        public n build(r rVar) {
            return new v(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements o {
        @Override // t4.o
        public n build(r rVar) {
            return new v(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c implements o {
        @Override // t4.o
        public n build(r rVar) {
            return new v(rVar.d(Uri.class, InputStream.class));
        }
    }

    public v(n nVar) {
        this.f١٨١١٩a = nVar;
    }

    private static Uri c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return d(str);
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            return d(str);
        }
        return parse;
    }

    private static Uri d(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(String str, int i10, int i11, m4.i iVar) {
        Uri c10 = c(str);
        if (c10 != null && this.f١٨١١٩a.handles(c10)) {
            return this.f١٨١١٩a.buildLoadData(c10, i10, i11, iVar);
        }
        return null;
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(String str) {
        return true;
    }
}
