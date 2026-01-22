package q4;

import android.content.Context;
import java.io.File;
import q4.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f extends d {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f١٧١٣٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f١٧١٣٨b;

        a(Context context, String str) {
            this.f١٧١٣٧a = context;
            this.f١٧١٣٨b = str;
        }

        @Override // q4.d.a
        public File a() {
            File cacheDir = this.f١٧١٣٧a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            if (this.f١٧١٣٨b != null) {
                return new File(cacheDir, this.f١٧١٣٨b);
            }
            return cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
