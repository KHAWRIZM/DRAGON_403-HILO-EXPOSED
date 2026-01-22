package com.opensource.svgaplayer.glideplugin;

import android.net.Uri;
import com.bumptech.glide.load.data.e;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t4.n;
import t4.o;
import t4.r;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAAssetLoaderFactory;", "Lt4/o;", "Landroid/net/Uri;", "Ljava/io/File;", "", "cachePath", "Lkotlin/Function1;", "Ljava/io/InputStream;", "Lcom/bumptech/glide/load/data/e;", "obtainRewind", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lt4/r;", "multiFactory", "Lt4/n;", "build", "(Lt4/r;)Lt4/n;", "", "teardown", "()V", "Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAAssetLoaderFactory implements o {

    @NotNull
    private final String cachePath;

    @NotNull
    private final Function1<InputStream, e> obtainRewind;

    /* JADX WARN: Multi-variable type inference failed */
    public SVGAAssetLoaderFactory(@NotNull String cachePath, @NotNull Function1<? super InputStream, ? extends e> obtainRewind) {
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(obtainRewind, "obtainRewind");
        this.cachePath = cachePath;
        this.obtainRewind = obtainRewind;
    }

    @Override // t4.o
    @NotNull
    public n build(@NotNull r multiFactory) {
        Intrinsics.checkNotNullParameter(multiFactory, "multiFactory");
        n d10 = multiFactory.d(Uri.class, InputStream.class);
        Intrinsics.checkNotNullExpressionValue(d10, "multiFactory.build(Uri::… InputStream::class.java)");
        return new SVGAEntityAssetLoader(d10, this.cachePath, this.obtainRewind);
    }

    public void teardown() {
    }
}
