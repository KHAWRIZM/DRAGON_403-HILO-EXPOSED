package com.opensource.svgaplayer.glideplugin;

import com.bumptech.glide.load.data.e;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.opensource.svgaplayer.glideplugin.SVGAEntityUrlLoader;
import com.qiahao.base_common.utils.PathHelper;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t4.h;
import t4.n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B=\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityUrlLoader;", "Lcom/opensource/svgaplayer/glideplugin/SVGAEntityLoader;", "Lt4/h;", "Lt4/n;", "Ljava/io/InputStream;", "actual", "", "cachePath", "Lkotlin/Function1;", "Lcom/bumptech/glide/load/data/e;", "obtainRewind", "<init>", "(Lt4/n;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "handles", "(Lt4/h;)Z", "toStringKey", "(Lt4/h;)Ljava/lang/String;", "Lm4/f;", "toGlideKey", "(Lt4/h;)Lm4/f;", "WrapGlideUrl", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAEntityUrlLoader extends SVGAEntityLoader<h> {

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityUrlLoader$WrapGlideUrl;", "Lm4/f;", "Lt4/h;", "actual", "<init>", "(Lt4/h;)V", "Ljava/security/MessageDigest;", "messageDigest", "", "updateDiskCacheKey", "(Ljava/security/MessageDigest;)V", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lt4/h;", "", "cacheByte$delegate", "Lkotlin/Lazy;", "getCacheByte", "()[B", "cacheByte", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class WrapGlideUrl implements f {

        @NotNull
        private final h actual;

        /* renamed from: cacheByte$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy cacheByte;

        public WrapGlideUrl(@NotNull h actual) {
            Intrinsics.checkNotNullParameter(actual, "actual");
            this.actual = actual;
            this.cacheByte = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<byte[]>() { // from class: com.opensource.svgaplayer.glideplugin.SVGAEntityUrlLoader$WrapGlideUrl$cacheByte$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final byte[] invoke() {
                    h hVar;
                    hVar = SVGAEntityUrlLoader.WrapGlideUrl.this.actual;
                    String stringPlus = Intrinsics.stringPlus("fileWrapper:", hVar.a());
                    Charset CHARSET = f.f١٥٩٧٢a;
                    Intrinsics.checkNotNullExpressionValue(CHARSET, "CHARSET");
                    byte[] bytes = stringPlus.getBytes(CHARSET);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    return bytes;
                }
            });
        }

        private final byte[] getCacheByte() {
            return (byte[]) this.cacheByte.getValue();
        }

        @Override // m4.f
        public boolean equals(@Nullable Object other) {
            if (other instanceof WrapGlideUrl) {
                return Intrinsics.areEqual(this.actual, ((WrapGlideUrl) other).actual);
            }
            return false;
        }

        @Override // m4.f
        public int hashCode() {
            return this.actual.hashCode();
        }

        @Override // m4.f
        public void updateDiskCacheKey(@NotNull MessageDigest messageDigest) {
            Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
            messageDigest.update(getCacheByte());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAEntityUrlLoader(@NotNull n actual, @NotNull String cachePath, @NotNull Function1<? super InputStream, ? extends e> obtainRewind) {
        super(actual, cachePath, obtainRewind);
        Intrinsics.checkNotNullParameter(actual, "actual");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(obtainRewind, "obtainRewind");
    }

    @Override // com.opensource.svgaplayer.glideplugin.SVGAEntityLoader, t4.n
    public boolean handles(@NotNull h model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String f10 = model.f();
        Intrinsics.checkNotNullExpressionValue(f10, "model.toStringUrl()");
        return StringsKt.endsWith$default(StringsKt.substringBefore$default(f10, '?', (String) null, 2, (Object) null), PathHelper.SUFFIX_TYPE_SVGA, false, 2, (Object) null) && super.handles((SVGAEntityUrlLoader) model);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opensource.svgaplayer.glideplugin.SVGAEntityLoader
    @NotNull
    public f toGlideKey(@NotNull h model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return new WrapGlideUrl(model);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opensource.svgaplayer.glideplugin.SVGAEntityLoader
    @NotNull
    public String toStringKey(@NotNull h model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String f10 = model.f();
        Intrinsics.checkNotNullExpressionValue(f10, "model.toStringUrl()");
        return f10;
    }
}
