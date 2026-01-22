package com.opensource.svgaplayer.glideplugin;

import com.bumptech.glide.g;
import com.bumptech.glide.load.data.e;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
/* synthetic */ class SVGAModule$registerComponents$resourceFactory$1 extends FunctionReferenceImpl implements Function1<InputStream, e> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SVGAModule$registerComponents$resourceFactory$1(Object obj) {
        super(1, obj, g.class, "getRewinder", "getRewinder(Ljava/lang/Object;)Lcom/bumptech/glide/load/data/DataRewinder;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final e invoke(@NotNull InputStream p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        return ((g) this.receiver).l(p02);
    }
}
