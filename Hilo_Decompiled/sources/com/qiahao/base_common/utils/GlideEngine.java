package com.qiahao.base_common.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.engine.ImageEngine;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0014"}, d2 = {"Lcom/qiahao/base_common/utils/GlideEngine;", "Lcom/luck/picture/lib/engine/ImageEngine;", "<init>", "()V", "loadImage", "", "context", "Landroid/content/Context;", "url", "", "imageView", "Landroid/widget/ImageView;", "maxWidth", "", "maxHeight", "loadAlbumCover", "loadGridImage", "pauseRequests", "resumeRequests", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GlideEngine implements ImageEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static GlideEngine instance;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/qiahao/base_common/utils/GlideEngine$Companion;", "", "<init>", "()V", "instance", "Lcom/qiahao/base_common/utils/GlideEngine;", "createGlideEngine", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final GlideEngine createGlideEngine() {
            if (GlideEngine.instance == null) {
                synchronized (GlideEngine.class) {
                    try {
                        if (GlideEngine.instance == null) {
                            GlideEngine.instance = new GlideEngine(null);
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return GlideEngine.instance;
        }

        private Companion() {
        }
    }

    public /* synthetic */ GlideEngine(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadAlbumCover(@NotNull Context context, @NotNull String url, @NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (PictureMimeType.isContent(url)) {
            ImageKtxKt.loadImage$default(imageView, null, Uri.parse(url), null, null, null, null, false, 0, false, null, null, null, null, null, null, null, Utf8.REPLACEMENT_CODE_POINT, null);
        } else {
            ImageKtxKt.loadImage$default(imageView, url, null, null, null, null, null, false, 0, false, null, null, null, null, null, null, null, 65534, null);
        }
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadGridImage(@NotNull Context context, @NotNull String url, @NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (PictureMimeType.isContent(url)) {
            ImageKtxKt.loadImage$default(imageView, null, Uri.parse(url), null, null, null, null, false, 0, false, null, null, null, null, null, null, null, Utf8.REPLACEMENT_CODE_POINT, null);
        } else {
            ImageKtxKt.loadImage$default(imageView, url, null, null, null, null, null, false, 0, false, null, null, null, null, null, null, null, 65534, null);
        }
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NotNull Context context, @NotNull String url, @NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (PictureMimeType.isContent(url)) {
            ImageKtxKt.loadImage$default(imageView, null, Uri.parse(url), null, null, null, null, false, 0, false, null, null, null, null, null, null, null, Utf8.REPLACEMENT_CODE_POINT, null);
        } else {
            ImageKtxKt.loadImage$default(imageView, url, null, null, null, null, null, false, 0, false, null, null, null, null, null, null, null, 65534, null);
        }
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void pauseRequests(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void resumeRequests(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private GlideEngine() {
    }

    @Override // com.luck.picture.lib.engine.ImageEngine
    public void loadImage(@NotNull Context context, @NotNull ImageView imageView, @NotNull String url, int maxWidth, int maxHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(url, "url");
        if (PictureMimeType.isContent(url)) {
            ImageKtxKt.loadImage$default(imageView, null, Uri.parse(url), null, null, null, null, false, 0, false, null, Integer.valueOf(maxWidth), Integer.valueOf(maxHeight), null, null, null, null, 62461, null);
        } else {
            ImageKtxKt.loadImage$default(imageView, url, null, null, null, null, null, false, 0, false, null, Integer.valueOf(maxWidth), Integer.valueOf(maxHeight), null, null, null, null, 62462, null);
        }
    }
}
