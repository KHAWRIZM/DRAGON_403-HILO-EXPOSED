package t4;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class s implements n {

    /* renamed from: a, reason: collision with root package name */
    private final n f١٨١٠٩a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f١٨١١٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f١٨١١١a;

        public a(Resources resources) {
            this.f١٨١١١a = resources;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new s(this.f١٨١١١a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f١٨١١٢a;

        public b(Resources resources) {
            this.f١٨١١٢a = resources;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new s(this.f١٨١١٢a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c implements o {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f١٨١١٣a;

        public c(Resources resources) {
            this.f١٨١١٣a = resources;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new s(this.f١٨١١٣a, w.a());
        }
    }

    public s(Resources resources, n nVar) {
        this.f١٨١١٠b = resources;
        this.f١٨١٠٩a = nVar;
    }

    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f١٨١١٠b.getResourcePackageName(num.intValue()) + '/' + this.f١٨١١٠b.getResourceTypeName(num.intValue()) + '/' + this.f١٨١١٠b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e10) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e10);
                return null;
            }
            return null;
        }
    }

    @Override // t4.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Integer num, int i10, int i11, m4.i iVar) {
        Uri b10 = b(num);
        if (b10 == null) {
            return null;
        }
        return this.f١٨١٠٩a.buildLoadData(b10, i10, i11, iVar);
    }

    @Override // t4.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(Integer num) {
        return true;
    }
}
