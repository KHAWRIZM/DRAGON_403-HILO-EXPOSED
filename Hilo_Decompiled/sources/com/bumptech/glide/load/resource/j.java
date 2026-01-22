package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$OnPartialImageListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import v4.o;
import v4.u;
import v4.z;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class j implements ImageDecoder$OnHeaderDecodedListener {

    /* renamed from: a, reason: collision with root package name */
    private final z f٧٥١٨a = z.b();

    /* renamed from: b, reason: collision with root package name */
    private final int f٧٥١٩b;

    /* renamed from: c, reason: collision with root package name */
    private final int f٧٥٢٠c;

    /* renamed from: d, reason: collision with root package name */
    private final m4.b f٧٥٢١d;

    /* renamed from: e, reason: collision with root package name */
    private final o f٧٥٢٢e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f٧٥٢٣f;

    /* renamed from: g, reason: collision with root package name */
    private final m4.j f٧٥٢٤g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements ImageDecoder$OnPartialImageListener {
        a() {
        }

        public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public j(int i10, int i11, m4.i iVar) {
        boolean z10;
        this.f٧٥١٩b = i10;
        this.f٧٥٢٠c = i11;
        this.f٧٥٢١d = (m4.b) iVar.a(u.f١٨٥٤٦f);
        this.f٧٥٢٢e = (o) iVar.a(o.f١٨٥٤١h);
        m4.h hVar = u.f١٨٥٥٠j;
        if (iVar.a(hVar) != null && ((Boolean) iVar.a(hVar)).booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٧٥٢٣f = z10;
        this.f٧٥٢٤g = (m4.j) iVar.a(u.f١٨٥٤٧g);
    }

    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Size size;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        ColorSpace.Named named2;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        if (this.f٧٥١٨a.f(this.f٧٥١٩b, this.f٧٥٢٠c, this.f٧٥٢٣f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f٧٥٢١d == m4.b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        size = imageInfo.getSize();
        int i10 = this.f٧٥١٩b;
        if (i10 == Integer.MIN_VALUE) {
            i10 = size.getWidth();
        }
        int i11 = this.f٧٥٢٠c;
        if (i11 == Integer.MIN_VALUE) {
            i11 = size.getHeight();
        }
        float b10 = this.f٧٥٢٢e.b(size.getWidth(), size.getHeight(), i10, i11);
        int round = Math.round(size.getWidth() * b10);
        int round2 = Math.round(size.getHeight() * b10);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b10);
        }
        imageDecoder.setTargetSize(round, round2);
        m4.j jVar = this.f٧٥٢٤g;
        if (jVar != null) {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 28) {
                if (jVar == m4.j.DISPLAY_P3) {
                    colorSpace3 = imageInfo.getColorSpace();
                    if (colorSpace3 != null) {
                        colorSpace4 = imageInfo.getColorSpace();
                        isWideGamut = colorSpace4.isWideGamut();
                        if (isWideGamut) {
                            named2 = ColorSpace.Named.DISPLAY_P3;
                            colorSpace2 = ColorSpace.get(named2);
                            imageDecoder.setTargetColorSpace(colorSpace2);
                            return;
                        }
                    }
                }
                named2 = ColorSpace.Named.SRGB;
                colorSpace2 = ColorSpace.get(named2);
                imageDecoder.setTargetColorSpace(colorSpace2);
                return;
            }
            if (i12 >= 26) {
                named = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(named);
                imageDecoder.setTargetColorSpace(colorSpace);
            }
        }
    }
}
