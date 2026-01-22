package y4;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import m4.i;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f١٩١٤٤a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٩١٤٥b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // y4.e
    public v transcode(v vVar, i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) vVar.get()).compress(this.f١٩١٤٤a, this.f١٩١٤٥b, byteArrayOutputStream);
        vVar.recycle();
        return new w4.b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i10) {
        this.f١٩١٤٤a = compressFormat;
        this.f١٩١٤٥b = i10;
    }
}
