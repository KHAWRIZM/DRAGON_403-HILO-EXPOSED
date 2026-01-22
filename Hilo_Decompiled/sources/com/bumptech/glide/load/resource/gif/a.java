package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import f5.l;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import l4.a;
import m4.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements k {

    /* renamed from: f, reason: collision with root package name */
    private static final C٠١٠٦a f٧٤٦٦f = new C٠١٠٦a();

    /* renamed from: g, reason: collision with root package name */
    private static final b f٧٤٦٧g = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Context f٧٤٦٨a;

    /* renamed from: b, reason: collision with root package name */
    private final List f٧٤٦٩b;

    /* renamed from: c, reason: collision with root package name */
    private final b f٧٤٧٠c;

    /* renamed from: d, reason: collision with root package name */
    private final C٠١٠٦a f٧٤٧١d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gif.b f٧٤٧٢e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.load.resource.gif.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠١٠٦a {
        C٠١٠٦a() {
        }

        l4.a a(a.InterfaceC٠١٨٦a r22, l4.c cVar, ByteBuffer byteBuffer, int i10) {
            return new l4.e(r22, cVar, byteBuffer, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue f٧٤٧٣a = l.g(0);

        b() {
        }

        synchronized l4.d a(ByteBuffer byteBuffer) {
            l4.d dVar;
            try {
                dVar = (l4.d) this.f٧٤٧٣a.poll();
                if (dVar == null) {
                    dVar = new l4.d();
                }
            } catch (Throwable th) {
                throw th;
            }
            return dVar.p(byteBuffer);
        }

        synchronized void b(l4.d dVar) {
            dVar.a();
            this.f٧٤٧٣a.offer(dVar);
        }
    }

    public a(Context context, List list, p4.d dVar, p4.b bVar) {
        this(context, list, dVar, bVar, f٧٤٦٧g, f٧٤٦٦f);
    }

    private e a(ByteBuffer byteBuffer, int i10, int i11, l4.d dVar, m4.i iVar) {
        Bitmap.Config config;
        long b10 = f5.g.b();
        try {
            l4.c c10 = dVar.c();
            if (c10.b() > 0 && c10.c() == 0) {
                if (iVar.a(i.f٧٥١٣a) == m4.b.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                l4.a a10 = this.f٧٤٧١d.a(this.f٧٤٧٢e, c10, byteBuffer, c(c10, i10, i11));
                a10.d(config);
                a10.b();
                Bitmap a11 = a10.a();
                if (a11 == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f5.g.a(b10));
                    }
                    return null;
                }
                e eVar = new e(new c(this.f٧٤٦٨a, a10, com.bumptech.glide.load.resource.l.a(), i10, i11, a11));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f5.g.a(b10));
                }
                return eVar;
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + f5.g.a(b10));
            }
        }
    }

    private static int c(l4.c cVar, int i10, int i11) {
        int highestOneBit;
        int min = Math.min(cVar.a() / i11, cVar.d() / i10);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i10 + "x" + i11 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return max;
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e decode(ByteBuffer byteBuffer, int i10, int i11, m4.i iVar) {
        l4.d a10 = this.f٧٤٧٠c.a(byteBuffer);
        try {
            return a(byteBuffer, i10, i11, a10, iVar);
        } finally {
            this.f٧٤٧٠c.b(a10);
        }
    }

    @Override // m4.k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean handles(ByteBuffer byteBuffer, m4.i iVar) {
        if (!((Boolean) iVar.a(i.f٧٥١٤b)).booleanValue() && com.bumptech.glide.load.a.g(this.f٧٤٦٩b, byteBuffer) == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        return false;
    }

    a(Context context, List list, p4.d dVar, p4.b bVar, b bVar2, C٠١٠٦a r62) {
        this.f٧٤٦٨a = context.getApplicationContext();
        this.f٧٤٦٩b = list;
        this.f٧٤٧١d = r62;
        this.f٧٤٧٢e = new com.bumptech.glide.load.resource.gif.b(dVar, bVar);
        this.f٧٤٧٠c = bVar2;
    }
}
