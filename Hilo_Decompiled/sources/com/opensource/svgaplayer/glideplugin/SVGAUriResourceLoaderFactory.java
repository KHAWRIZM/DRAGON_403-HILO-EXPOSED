package com.opensource.svgaplayer.glideplugin;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t4.n;
import t4.o;
import t4.r;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0005¨\u0006\r"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAUriResourceLoaderFactory;", "Lt4/o;", "Landroid/net/Uri;", "Ljava/io/InputStream;", "<init>", "()V", "Lt4/r;", "multiFactory", "Lt4/n;", "build", "(Lt4/r;)Lt4/n;", "", "teardown", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAUriResourceLoaderFactory implements o {
    @Override // t4.o
    @NotNull
    public n build(@NotNull r multiFactory) {
        Intrinsics.checkNotNullParameter(multiFactory, "multiFactory");
        n d10 = multiFactory.d(Uri.class, AssetFileDescriptor.class);
        Intrinsics.checkNotNullExpressionValue(d10, "multiFactory.build(Uri::…leDescriptor::class.java)");
        return new SVGAEntityUriResourceLoader(d10);
    }

    public void teardown() {
    }
}
