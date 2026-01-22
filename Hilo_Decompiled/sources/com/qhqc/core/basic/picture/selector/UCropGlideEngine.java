package com.qhqc.core.basic.picture.selector;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import c5.h;
import com.bumptech.glide.Glide;
import com.qhqc.core.basic.picture.glide.GlideConstant;
import com.yalantis.ucrop.UCropImageEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJC\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u000e\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/UCropGlideEngine;", "Lcom/yalantis/ucrop/UCropImageEngine;", "<init>", "()V", "Lc5/h;", "getRequestOptions", "()Lc5/h;", "Landroid/content/Context;", "context", "", "url", "Landroid/widget/ImageView;", "imageView", "", "loadImage", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/ImageView;)V", "Landroid/net/Uri;", "", "maxWidth", "maxHeight", "Lcom/yalantis/ucrop/UCropImageEngine$OnCallbackListener;", "Landroid/graphics/Bitmap;", "call", "(Landroid/content/Context;Landroid/net/Uri;IILcom/yalantis/ucrop/UCropImageEngine$OnCallbackListener;)V", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UCropGlideEngine implements UCropImageEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static UCropGlideEngine INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/UCropGlideEngine$Companion;", "", "()V", "INSTANCE", "Lcom/qhqc/core/basic/picture/selector/UCropGlideEngine;", "getInstance", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nUCropGlideEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UCropGlideEngine.kt\ncom/qhqc/core/basic/picture/selector/UCropGlideEngine$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,45:1\n1#2:46\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UCropGlideEngine getInstance() {
            UCropGlideEngine uCropGlideEngine = UCropGlideEngine.INSTANCE;
            if (uCropGlideEngine == null) {
                synchronized (this) {
                    uCropGlideEngine = UCropGlideEngine.INSTANCE;
                    if (uCropGlideEngine == null) {
                        uCropGlideEngine = new UCropGlideEngine();
                        UCropGlideEngine.INSTANCE = uCropGlideEngine;
                    }
                }
            }
            return uCropGlideEngine;
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

    public void loadImage(@Nullable Context context, @Nullable Uri url, int maxWidth, int maxHeight, @Nullable UCropImageEngine.OnCallbackListener<Bitmap> call) {
    }

    public void loadImage(@Nullable Context context, @Nullable String url, @Nullable ImageView imageView) {
        if (context == null || imageView == null) {
            return;
        }
        Glide.with(context).q(url).a(getRequestOptions()).D0(imageView);
    }
}
