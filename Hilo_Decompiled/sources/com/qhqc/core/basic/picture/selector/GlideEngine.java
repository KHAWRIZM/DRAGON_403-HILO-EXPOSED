package com.qhqc.core.basic.picture.selector;

import android.content.Context;
import android.widget.ImageView;
import c5.h;
import com.bumptech.glide.Glide;
import com.bumptech.glide.i;
import com.luck.picture.lib.engine.ImageEngine;
import com.qhqc.core.basic.picture.glide.GlideConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000e\u0010\u0013J-\u0010\u0014\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ-\u0010\u0015\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0019\u0010\u0016\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/GlideEngine;", "Lcom/luck/picture/lib/engine/ImageEngine;", "<init>", "()V", "Lc5/h;", "getRequestOptions", "()Lc5/h;", "Landroid/content/Context;", "context", "", "url", "Landroid/widget/ImageView;", "imageView", "", "loadImage", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;)V", "", "maxWidth", "maxHeight", "(Landroid/content/Context;Landroid/widget/ImageView;Ljava/lang/String;II)V", "loadAlbumCover", "loadGridImage", "pauseRequests", "(Landroid/content/Context;)V", "resumeRequests", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GlideEngine implements ImageEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static GlideEngine INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/GlideEngine$Companion;", "", "()V", "INSTANCE", "Lcom/qhqc/core/basic/picture/selector/GlideEngine;", "getInstance", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nGlideEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlideEngine.kt\ncom/qhqc/core/basic/picture/selector/GlideEngine$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GlideEngine getInstance() {
            GlideEngine glideEngine = GlideEngine.INSTANCE;
            if (glideEngine == null) {
                synchronized (this) {
                    glideEngine = GlideEngine.INSTANCE;
                    if (glideEngine == null) {
                        glideEngine = new GlideEngine();
                        GlideEngine.INSTANCE = glideEngine;
                    }
                }
            }
            return glideEngine;
        }

        private Companion() {
        }
    }

    private final h getRequestOptions() {
        h hVar = (h) new h().h0(true);
        GlideConstant glideConstant = GlideConstant.INSTANCE;
        c5.a j10 = ((h) hVar.X(glideConstant.getPRELOAD())).j(glideConstant.getPRELOAD());
        Intrinsics.checkNotNullExpressionValue(j10, "error(...)");
        return (h) j10;
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadAlbumCover(@Nullable Context context, @Nullable String url, @Nullable ImageView imageView) {
        if (context != null) {
            i a10 = Glide.with(context).q(url).a(getRequestOptions());
            if (imageView == null) {
                return;
            }
            a10.D0(imageView);
        }
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadGridImage(@Nullable Context context, @Nullable String url, @Nullable ImageView imageView) {
        if (context != null) {
            i a10 = Glide.with(context).q(url).a(getRequestOptions());
            if (imageView == null) {
                return;
            }
            a10.D0(imageView);
        }
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@Nullable Context context, @Nullable String url, @Nullable ImageView imageView) {
        if (context != null) {
            i a10 = Glide.with(context).q(url).a(getRequestOptions());
            if (imageView == null) {
                return;
            }
            a10.D0(imageView);
        }
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void pauseRequests(@Nullable Context context) {
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void resumeRequests(@Nullable Context context) {
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@Nullable Context context, @Nullable ImageView imageView, @Nullable String url, int maxWidth, int maxHeight) {
        if (context != null) {
            i a10 = Glide.with(context).q(url).a(getRequestOptions());
            if (imageView == null) {
                return;
            }
            a10.D0(imageView);
        }
    }
}
