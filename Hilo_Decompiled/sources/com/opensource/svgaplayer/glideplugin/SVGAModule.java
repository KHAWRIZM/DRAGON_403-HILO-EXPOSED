package com.opensource.svgaplayer.glideplugin;

import a5.c;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.g;
import com.opensource.svgaplayer.SVGACache;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p4.b;
import t4.h;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAModule;", "La5/c;", "<init>", "()V", "Lcom/bumptech/glide/Glide;", "glide", "", "hookTheImageViewFactory", "(Lcom/bumptech/glide/Glide;)V", "Landroid/content/Context;", "context", "Lcom/bumptech/glide/g;", "registry", "registerComponents", "(Landroid/content/Context;Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/g;)V", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAModule extends c {
    private final void hookTheImageViewFactory(Glide glide) {
        Field declaredField;
        try {
            Field declaredField2 = com.bumptech.glide.c.class.getDeclaredField("c");
            if (declaredField2 == null || (declaredField = Glide.class.getDeclaredField("glideContext")) == null) {
                return;
            }
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField2.set(declaredField.get(glide), new SVGAImageViewTargetFactory());
        } catch (Exception e10) {
            Log.e("SVGAPlayer", e10.getMessage(), e10);
        }
    }

    @Override // a5.c
    public void registerComponents(@NotNull Context context, @NotNull Glide glide, @NotNull g registry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glide, "glide");
        Intrinsics.checkNotNullParameter(registry, "registry");
        hookTheImageViewFactory(glide);
        Resources resources = context.getResources();
        SVGACache.INSTANCE.onCreate(context);
        String str = context.getCacheDir().getAbsolutePath() + File.separatorChar + "svga";
        b arrayPool = glide.getArrayPool();
        Intrinsics.checkNotNullExpressionValue(arrayPool, "glide.arrayPool");
        SVGAEntityStreamDecoder sVGAEntityStreamDecoder = new SVGAEntityStreamDecoder(str, arrayPool);
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        SVGAResourceLoaderFactory sVGAResourceLoaderFactory = new SVGAResourceLoaderFactory(resources, str, new SVGAModule$registerComponents$resourceFactory$1(registry));
        g e10 = registry.t(SVGAVideoEntity.class, SVGADrawable.class, new SVGADrawableTranscoder()).e("Animation", InputStream.class, SVGAVideoEntity.class, sVGAEntityStreamDecoder);
        b arrayPool2 = glide.getArrayPool();
        Intrinsics.checkNotNullExpressionValue(arrayPool2, "glide.arrayPool");
        e10.e("Animation", File.class, SVGAVideoEntity.class, new SVGAEntityFileDecoder(arrayPool2)).b(Integer.TYPE, File.class, sVGAResourceLoaderFactory).b(Integer.class, File.class, sVGAResourceLoaderFactory).b(Uri.class, InputStream.class, new SVGAUriResourceLoaderFactory()).b(Uri.class, File.class, new SVGAAssetLoaderFactory(str, new SVGAModule$registerComponents$1(registry))).b(String.class, File.class, new SVGAStringLoaderFactory()).b(Uri.class, File.class, new SVGAUriLoaderFactory()).b(h.class, File.class, new SVGAUrlLoaderFactory(str, new SVGAModule$registerComponents$2(registry))).c(File.class, new SVGAFileEncoder());
    }
}
