package com.opensource.svgaplayer.glideplugin;

import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAVideoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m4.i;
import o4.v;
import org.jetbrains.annotations.NotNull;
import y4.e;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGADrawableTranscoder;", "Ly4/e;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "Lcom/opensource/svgaplayer/SVGADrawable;", "<init>", "()V", "Lo4/v;", "toTranscode", "Lm4/i;", "options", "Lcom/opensource/svgaplayer/glideplugin/SVGADrawableResource;", "transcode", "(Lo4/v;Lm4/i;)Lcom/opensource/svgaplayer/glideplugin/SVGADrawableResource;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGADrawableTranscoder implements e {
    @Override // y4.e
    @NotNull
    public SVGADrawableResource transcode(@NotNull v toTranscode, @NotNull i options) {
        Intrinsics.checkNotNullParameter(toTranscode, "toTranscode");
        Intrinsics.checkNotNullParameter(options, "options");
        Object entity = toTranscode.getEntity();
        Intrinsics.checkNotNullExpressionValue(entity, "toTranscode.get()");
        return new SVGADrawableResource(new SVGADrawable((SVGAVideoEntity) entity, new SVGADynamicEntity()), toTranscode);
    }
}
