package com.opensource.svgaplayer.glideplugin;

import com.bumptech.glide.i;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0007¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGATypeExtension;", "", "<init>", "()V", "Lcom/bumptech/glide/i;", "Lcom/opensource/svgaplayer/SVGADrawable;", "requestBuilder", "asSVGADrawable", "(Lcom/bumptech/glide/i;)Lcom/bumptech/glide/i;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "asSVGA", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGATypeExtension {

    @NotNull
    public static final SVGATypeExtension INSTANCE = new SVGATypeExtension();

    private SVGATypeExtension() {
    }

    @JvmStatic
    @NotNull
    public static final i asSVGA(@NotNull i requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        return requestBuilder;
    }

    @JvmStatic
    @NotNull
    public static final i asSVGADrawable(@NotNull i requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        return requestBuilder;
    }
}
