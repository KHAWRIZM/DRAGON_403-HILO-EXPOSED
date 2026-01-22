package com.opensource.svgaplayer.glideplugin;

import android.net.Uri;
import com.bumptech.glide.load.data.e;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t4.n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B=\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityAssetLoader;", "Lcom/opensource/svgaplayer/glideplugin/SVGAEntityLoader;", "Landroid/net/Uri;", "Lt4/n;", "Ljava/io/InputStream;", "actual", "", "cachePath", "Lkotlin/Function1;", "Lcom/bumptech/glide/load/data/e;", "obtainRewind", "<init>", "(Lt4/n;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", DeviceRequestsHelper.DEVICE_INFO_MODEL, "toStringKey", "(Landroid/net/Uri;)Ljava/lang/String;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAEntityAssetLoader extends SVGAEntityLoader<Uri> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAEntityAssetLoader(@NotNull n actual, @NotNull String cachePath, @NotNull Function1<? super InputStream, ? extends e> obtainRewind) {
        super(actual, cachePath, obtainRewind);
        Intrinsics.checkNotNullParameter(actual, "actual");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(obtainRewind, "obtainRewind");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opensource.svgaplayer.glideplugin.SVGAEntityLoader
    @NotNull
    public String toStringKey(@NotNull Uri model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String uri = model.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "model.toString()");
        return uri;
    }
}
