package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import o4.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final List f٧٤٥٨a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.b f٧٤٥٩b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements v {

        /* renamed from: a, reason: collision with root package name */
        private final AnimatedImageDrawable f٧٤٦٠a;

        a(AnimatedImageDrawable animatedImageDrawable) {
            this.f٧٤٦٠a = animatedImageDrawable;
        }

        @Override // o4.v
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable getEntity() {
            return this.f٧٤٦٠a;
        }

        @Override // o4.v
        public Class getResourceClass() {
            return Drawable.class;
        }

        @Override // o4.v
        public int getSize() {
            int intrinsicWidth;
            int intrinsicHeight;
            intrinsicWidth = this.f٧٤٦٠a.getIntrinsicWidth();
            intrinsicHeight = this.f٧٤٦٠a.getIntrinsicHeight();
            return intrinsicWidth * intrinsicHeight * f5.l.j(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // o4.v
        public void recycle() {
            this.f٧٤٦٠a.stop();
            this.f٧٤٦٠a.clearAnimationCallbacks();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b implements m4.k {

        /* renamed from: a, reason: collision with root package name */
        private final g f٧٤٦١a;

        b(g gVar) {
            this.f٧٤٦١a = gVar;
        }

        @Override // m4.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public v decode(ByteBuffer byteBuffer, int i10, int i11, m4.i iVar) {
            ImageDecoder.Source createSource;
            createSource = ImageDecoder.createSource(byteBuffer);
            return this.f٧٤٦١a.b(createSource, i10, i11, iVar);
        }

        @Override // m4.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean handles(ByteBuffer byteBuffer, m4.i iVar) {
            return this.f٧٤٦١a.d(byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c implements m4.k {

        /* renamed from: a, reason: collision with root package name */
        private final g f٧٤٦٢a;

        c(g gVar) {
            this.f٧٤٦٢a = gVar;
        }

        @Override // m4.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public v decode(InputStream inputStream, int i10, int i11, m4.i iVar) {
            ImageDecoder.Source createSource;
            createSource = ImageDecoder.createSource(f5.a.b(inputStream));
            return this.f٧٤٦٢a.b(createSource, i10, i11, iVar);
        }

        @Override // m4.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean handles(InputStream inputStream, m4.i iVar) {
            return this.f٧٤٦٢a.c(inputStream);
        }
    }

    private g(List list, p4.b bVar) {
        this.f٧٤٥٨a = list;
        this.f٧٤٥٩b = bVar;
    }

    public static m4.k a(List list, p4.b bVar) {
        return new b(new g(list, bVar));
    }

    private boolean e(ImageHeaderParser.ImageType imageType) {
        if (imageType != ImageHeaderParser.ImageType.ANIMATED_WEBP && (Build.VERSION.SDK_INT < 31 || imageType != ImageHeaderParser.ImageType.ANIMATED_AVIF)) {
            return false;
        }
        return true;
    }

    public static m4.k f(List list, p4.b bVar) {
        return new c(new g(list, bVar));
    }

    v b(ImageDecoder.Source source, int i10, int i11, m4.i iVar) {
        Drawable decodeDrawable;
        decodeDrawable = ImageDecoder.decodeDrawable(source, new com.bumptech.glide.load.resource.j(i10, i11, iVar));
        if (com.bumptech.glide.load.resource.drawable.a.a(decodeDrawable)) {
            return new a(com.bumptech.glide.load.resource.drawable.b.a(decodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + decodeDrawable);
    }

    boolean c(InputStream inputStream) {
        return e(com.bumptech.glide.load.a.f(this.f٧٤٥٨a, inputStream, this.f٧٤٥٩b));
    }

    boolean d(ByteBuffer byteBuffer) {
        return e(com.bumptech.glide.load.a.g(this.f٧٤٥٨a, byteBuffer));
    }
}
