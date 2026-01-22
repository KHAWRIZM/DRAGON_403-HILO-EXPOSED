package v4;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final p4.d f١٨٤٨٦a = new p4.e();

    public o4.v a(ImageDecoder.Source source, int i10, int i11, m4.i iVar) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, new com.bumptech.glide.load.resource.j(i10, i11, iVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i10 + "x" + i11 + "]");
        }
        return new f(decodeBitmap, this.f١٨٤٨٦a);
    }

    public boolean b(ImageDecoder.Source source, m4.i iVar) {
        return true;
    }

    @Override // m4.k
    public /* bridge */ /* synthetic */ o4.v decode(Object obj, int i10, int i11, m4.i iVar) {
        return a(d.a(obj), i10, i11, iVar);
    }

    @Override // m4.k
    public /* bridge */ /* synthetic */ boolean handles(Object obj, m4.i iVar) {
        return b(d.a(obj), iVar);
    }
}
