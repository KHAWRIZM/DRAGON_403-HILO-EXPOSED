package com.opensource.svgaplayer.glideplugin;

import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.load.data.e;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityIntResourceLoader;", "Lcom/opensource/svgaplayer/glideplugin/SVGAEntityLoader;", "", "Landroid/content/res/Resources;", "resources", "", "cachePath", "Lkotlin/Function1;", "Ljava/io/InputStream;", "Lcom/bumptech/glide/load/data/e;", "obtainRewind", "<init>", "(Landroid/content/res/Resources;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Landroid/net/Uri;", "getResourceUri", "(Landroid/content/res/Resources;I)Landroid/net/Uri;", "toStringKey", "(I)Ljava/lang/String;", "Landroid/content/res/Resources;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAEntityIntResourceLoader extends SVGAEntityLoader<Integer> {

    @NotNull
    private final Resources resources;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAEntityIntResourceLoader(@NotNull Resources resources, @NotNull String cachePath, @NotNull Function1<? super InputStream, ? extends e> obtainRewind) {
        super(new SimpleResourceLoader(resources), cachePath, obtainRewind);
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(obtainRewind, "obtainRewind");
        this.resources = resources;
    }

    private final Uri getResourceUri(Resources resources, int model) {
        try {
            return Uri.parse("android.resource://" + ((Object) resources.getResourcePackageName(model)) + '/' + ((Object) resources.getResourceTypeName(model)) + '/' + ((Object) resources.getResourceEntryName(model)));
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    @Override // com.opensource.svgaplayer.glideplugin.SVGAEntityLoader
    public /* bridge */ /* synthetic */ String toStringKey(Integer num) {
        return toStringKey(num.intValue());
    }

    @NotNull
    protected String toStringKey(int model) {
        Uri resourceUri = getResourceUri(this.resources, model);
        String uri = resourceUri == null ? null : resourceUri.toString();
        return uri == null ? Intrinsics.stringPlus("UnknownKey", Integer.valueOf(model)) : uri;
    }
}
