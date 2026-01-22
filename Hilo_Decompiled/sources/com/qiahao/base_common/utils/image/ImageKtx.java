package com.qiahao.base_common.utils.image;

import android.content.Context;
import android.widget.ImageView;
import c5.h;
import com.bumptech.glide.Glide;
import com.bumptech.glide.i;
import com.bumptech.glide.request.target.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/qiahao/base_common/utils/image/ImageKtx;", "", "<init>", "()V", "Landroid/widget/ImageView;", ViewHierarchyConstants.VIEW_KEY, "", "resId", "", "loadImage", "(Landroid/widget/ImageView;Ljava/lang/Integer;)V", "", "url", "splicingAvatarUrl", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", "", "skipMemory", "Lcom/bumptech/glide/request/target/c;", "Landroid/graphics/Bitmap;", "target", "downloadBitmap", "(Landroid/content/Context;Ljava/lang/String;ZLcom/bumptech/glide/request/target/c;)V", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ImageKtx {

    @NotNull
    public static final ImageKtx INSTANCE = new ImageKtx();

    private ImageKtx() {
    }

    public static /* synthetic */ void downloadBitmap$default(ImageKtx imageKtx, Context context, String str, boolean z10, c cVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        imageKtx.downloadBitmap(context, str, z10, cVar);
    }

    public final void downloadBitmap(@NotNull Context context, @NotNull String url, boolean skipMemory, @NotNull c target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Intrinsics.checkNotNull(((i) Glide.with(context).b().K0(url).h0(skipMemory)).a(new h().g(j.f١٦٦٤٠e)).A0(target));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void loadImage(@NotNull ImageView view, @Nullable Integer resId) {
        Intrinsics.checkNotNullParameter(view, "view");
        ImageKtxKt.loadImage$default(view, null, null, null, resId, null, null, false, 0, false, null, null, null, null, null, null, null, 65527, null);
    }

    @NotNull
    public final String splicingAvatarUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return ImageKtxKt.splicingAvatarUrl(url);
    }
}
