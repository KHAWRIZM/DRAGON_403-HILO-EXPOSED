package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.b;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import f5.f;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import t4.a;
import t4.b;
import t4.d;
import t4.e;
import t4.g;
import t4.l;
import t4.o;
import t4.s;
import t4.t;
import t4.v;
import t4.w;
import t4.x;
import t4.y;
import u4.a;
import u4.b;
import u4.c;
import u4.d;
import u4.g;
import v4.b0;
import v4.d0;
import v4.f0;
import v4.h0;
import v4.j0;
import v4.l0;
import v4.n;
import v4.u;
import v4.x;
import w4.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements f.b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f٧٢٧٥a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Glide f٧٢٧٦b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f٧٢٧٧c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a5.a f٧٢٧٨d;

        a(Glide glide, List list, a5.a aVar) {
            this.f٧٢٧٦b = glide;
            this.f٧٢٧٧c = list;
            this.f٧٢٧٨d = aVar;
        }

        @Override // f5.f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g get() {
            if (!this.f٧٢٧٥a) {
                h3.a.a("Glide registry");
                this.f٧٢٧٥a = true;
                try {
                    return h.a(this.f٧٢٧٦b, this.f٧٢٧٧c, this.f٧٢٧٨d);
                } finally {
                    this.f٧٢٧٥a = false;
                    h3.a.b();
                }
            }
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
    }

    static g a(Glide glide, List list, a5.a aVar) {
        p4.d bitmapPool = glide.getBitmapPool();
        p4.b arrayPool = glide.getArrayPool();
        Context applicationContext = glide.getGlideContext().getApplicationContext();
        d g10 = glide.getGlideContext().g();
        g gVar = new g();
        b(applicationContext, gVar, bitmapPool, arrayPool, g10);
        c(applicationContext, glide, gVar, list, aVar);
        return gVar;
    }

    private static void b(Context context, g gVar, p4.d dVar, p4.b bVar, d dVar2) {
        m4.k hVar;
        m4.k h0Var;
        Class cls;
        g gVar2;
        gVar.r(new n());
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 27) {
            gVar.r(new x());
        }
        Resources resources = context.getResources();
        List g10 = gVar.g();
        com.bumptech.glide.load.resource.gif.a aVar = new com.bumptech.glide.load.resource.gif.a(context, g10, dVar, bVar);
        m4.k k10 = l0.k(dVar);
        u uVar = new u(gVar.g(), resources.getDisplayMetrics(), dVar, bVar);
        if (i10 >= 28 && dVar2.a(b.C٠١٠٣b.class)) {
            h0Var = new b0();
            hVar = new v4.j();
        } else {
            hVar = new v4.h(uVar);
            h0Var = new h0(uVar, bVar);
        }
        if (i10 >= 28) {
            gVar.e("Animation", InputStream.class, Drawable.class, com.bumptech.glide.load.resource.drawable.g.f(g10, bVar));
            gVar.e("Animation", ByteBuffer.class, Drawable.class, com.bumptech.glide.load.resource.drawable.g.a(g10, bVar));
        }
        com.bumptech.glide.load.resource.drawable.k kVar = new com.bumptech.glide.load.resource.drawable.k(context);
        v4.c cVar = new v4.c(bVar);
        y4.a aVar2 = new y4.a();
        y4.d dVar3 = new y4.d();
        ContentResolver contentResolver = context.getContentResolver();
        gVar.c(ByteBuffer.class, new t4.c()).c(InputStream.class, new t4.u(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, hVar).e("Bitmap", InputStream.class, Bitmap.class, h0Var);
        if (ParcelFileDescriptorRewinder.b()) {
            gVar.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new d0(uVar));
        }
        gVar.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, l0.a(dVar));
        gVar.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, k10).b(Bitmap.class, Bitmap.class, w.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new j0()).d(Bitmap.class, cVar).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new v4.a(resources, hVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new v4.a(resources, h0Var)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new v4.a(resources, k10)).d(BitmapDrawable.class, new v4.b(dVar, cVar)).e("Animation", InputStream.class, com.bumptech.glide.load.resource.gif.c.class, new com.bumptech.glide.load.resource.gif.j(g10, aVar, bVar)).e("Animation", ByteBuffer.class, com.bumptech.glide.load.resource.gif.c.class, aVar).d(com.bumptech.glide.load.resource.gif.c.class, new com.bumptech.glide.load.resource.gif.d()).b(l4.a.class, l4.a.class, w.a.a()).e("Bitmap", l4.a.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.h(dVar)).a(Uri.class, Drawable.class, kVar).a(Uri.class, Bitmap.class, new f0(kVar, dVar)).s(new a.C٠٢٤١a()).b(File.class, ByteBuffer.class, new d.b()).b(File.class, InputStream.class, new g.e()).a(File.class, File.class, new x4.a()).b(File.class, ParcelFileDescriptor.class, new g.b()).b(File.class, File.class, w.a.a()).s(new k.a(bVar));
        if (ParcelFileDescriptorRewinder.b()) {
            cls = BitmapDrawable.class;
            gVar2 = gVar;
            gVar2.s(new ParcelFileDescriptorRewinder.a());
        } else {
            cls = BitmapDrawable.class;
            gVar2 = gVar;
        }
        o e10 = t4.f.e(context);
        o a10 = t4.f.a(context);
        o c10 = t4.f.c(context);
        Class cls2 = Integer.TYPE;
        gVar2.b(cls2, InputStream.class, e10).b(Integer.class, InputStream.class, e10).b(cls2, AssetFileDescriptor.class, a10).b(Integer.class, AssetFileDescriptor.class, a10).b(cls2, Drawable.class, c10).b(Integer.class, Drawable.class, c10).b(Uri.class, InputStream.class, t.d(context)).b(Uri.class, AssetFileDescriptor.class, t.c(context));
        s.c cVar2 = new s.c(resources);
        s.a aVar3 = new s.a(resources);
        s.b bVar2 = new s.b(resources);
        Class cls3 = cls;
        gVar2.b(Integer.class, Uri.class, cVar2).b(cls2, Uri.class, cVar2).b(Integer.class, AssetFileDescriptor.class, aVar3).b(cls2, AssetFileDescriptor.class, aVar3).b(Integer.class, InputStream.class, bVar2).b(cls2, InputStream.class, bVar2);
        gVar2.b(String.class, InputStream.class, new e.c()).b(Uri.class, InputStream.class, new e.c()).b(String.class, InputStream.class, new v.c()).b(String.class, ParcelFileDescriptor.class, new v.b()).b(String.class, AssetFileDescriptor.class, new v.a()).b(Uri.class, InputStream.class, new a.c(context.getAssets())).b(Uri.class, AssetFileDescriptor.class, new a.b(context.getAssets())).b(Uri.class, InputStream.class, new b.a(context)).b(Uri.class, InputStream.class, new c.a(context));
        if (i10 >= 29) {
            gVar2.b(Uri.class, InputStream.class, new d.c(context));
            gVar2.b(Uri.class, ParcelFileDescriptor.class, new d.b(context));
        }
        gVar2.b(Uri.class, InputStream.class, new x.d(contentResolver)).b(Uri.class, ParcelFileDescriptor.class, new x.b(contentResolver)).b(Uri.class, AssetFileDescriptor.class, new x.a(contentResolver)).b(Uri.class, InputStream.class, new y.a()).b(URL.class, InputStream.class, new g.a()).b(Uri.class, File.class, new l.a(context)).b(t4.h.class, InputStream.class, new a.C٠٢٣٤a()).b(byte[].class, ByteBuffer.class, new b.a()).b(byte[].class, InputStream.class, new b.d()).b(Uri.class, Uri.class, w.a.a()).b(Drawable.class, Drawable.class, w.a.a()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.resource.drawable.l()).t(Bitmap.class, cls3, new y4.b(resources)).t(Bitmap.class, byte[].class, aVar2).t(Drawable.class, byte[].class, new y4.c(dVar, aVar2, dVar3)).t(com.bumptech.glide.load.resource.gif.c.class, byte[].class, dVar3);
        if (i10 >= 23) {
            m4.k b10 = l0.b(dVar);
            gVar2.a(ByteBuffer.class, Bitmap.class, b10);
            gVar2.a(ByteBuffer.class, cls3, new v4.a(resources, b10));
        }
    }

    private static void c(Context context, Glide glide, g gVar, List list, a5.a aVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a5.b bVar = (a5.b) it.next();
            try {
                bVar.registerComponents(context, glide, gVar);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + bVar.getClass().getName(), e10);
            }
        }
        if (aVar != null) {
            aVar.registerComponents(context, glide, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f.b d(Glide glide, List list, a5.a aVar) {
        return new a(glide, list, aVar);
    }
}
