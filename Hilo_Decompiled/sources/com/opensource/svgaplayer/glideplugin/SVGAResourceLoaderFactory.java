package com.opensource.svgaplayer.glideplugin;

import android.content.res.Resources;
import com.bumptech.glide.load.data.e;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t4.n;
import t4.o;
import t4.r;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAResourceLoaderFactory;", "Lt4/o;", "", "Ljava/io/File;", "Landroid/content/res/Resources;", "resource", "", "cachePath", "Lkotlin/Function1;", "Ljava/io/InputStream;", "Lcom/bumptech/glide/load/data/e;", "obtainRewinder", "<init>", "(Landroid/content/res/Resources;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lt4/r;", "multiFactory", "Lt4/n;", "build", "(Lt4/r;)Lt4/n;", "", "teardown", "()V", "Landroid/content/res/Resources;", "Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "Companion", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAResourceLoaderFactory implements o {
    private static final boolean RePluginMode = true;

    @NotNull
    private final String cachePath;

    @NotNull
    private final Function1<InputStream, e> obtainRewinder;

    @NotNull
    private final Resources resource;

    /* JADX WARN: Multi-variable type inference failed */
    public SVGAResourceLoaderFactory(@NotNull Resources resource, @NotNull String cachePath, @NotNull Function1<? super InputStream, ? extends e> obtainRewinder) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(obtainRewinder, "obtainRewinder");
        this.resource = resource;
        this.cachePath = cachePath;
        this.obtainRewinder = obtainRewinder;
    }

    @Override // t4.o
    @NotNull
    public n build(@NotNull r multiFactory) {
        Intrinsics.checkNotNullParameter(multiFactory, "multiFactory");
        return new SVGAEntityIntResourceLoader(this.resource, this.cachePath, this.obtainRewinder);
    }

    public void teardown() {
    }
}
