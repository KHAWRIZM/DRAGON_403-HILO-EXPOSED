package e0;

import android.graphics.Bitmap;
import okio.Source;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f١٣٧٩١a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap f١٣٧٩٢b;

    /* renamed from: c, reason: collision with root package name */
    public final Source f١٣٧٩٣c;

    /* renamed from: d, reason: collision with root package name */
    public final int f١٣٧٩٤d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Source source, int i10) {
        this(null, source, i10, 0);
        StringBuilder sb = u0.f١٣٨٣٥a;
        if (source == null) {
            throw new NullPointerException("source == null");
        }
    }

    public j(Bitmap bitmap, Source source, int i10, int i11) {
        if ((bitmap != null) != (source != null)) {
            this.f١٣٧٩٢b = bitmap;
            this.f١٣٧٩٣c = source;
            StringBuilder sb = u0.f١٣٨٣٥a;
            if (i10 != 0) {
                this.f١٣٧٩١a = i10;
                this.f١٣٧٩٤d = i11;
                return;
            }
            throw new NullPointerException("loadedFrom == null");
        }
        throw new AssertionError();
    }
}
