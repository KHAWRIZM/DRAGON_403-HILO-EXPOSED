package com.qhqc.core.feature.community.widget;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.f;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\"\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00030\u00030\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/qhqc/core/feature/community/widget/SvgaImageVideoTarget;", "Lcom/bumptech/glide/request/target/f;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "Lcom/opensource/svgaplayer/SVGAImageView;", ViewHierarchyConstants.VIEW_KEY, "", "forcePlay", "<init>", "(Lcom/opensource/svgaplayer/SVGAImageView;Z)V", "resource", "", "setResource", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;)V", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "onLoadFailed", "(Landroid/graphics/drawable/Drawable;)V", "placeholder", "onLoadCleared", "onLoadStarted", "Z", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "svgaImageViewWRF", "Ljava/lang/ref/WeakReference;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SvgaImageVideoTarget extends f {
    private final boolean forcePlay;

    @NotNull
    private final WeakReference<SVGAImageView> svgaImageViewWRF;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SvgaImageVideoTarget(@NotNull SVGAImageView view, boolean z10) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.forcePlay = z10;
        this.svgaImageViewWRF = new WeakReference<>(view);
        if (view.getClearsAfterDetached()) {
            view.setClearsAfterDetached(false);
        }
    }

    @Override // com.bumptech.glide.request.target.f, com.bumptech.glide.request.target.k, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.j
    public void onLoadCleared(@Nullable Drawable placeholder) {
        super.onLoadCleared(placeholder);
    }

    @Override // com.bumptech.glide.request.target.f, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.j
    public void onLoadFailed(@Nullable Drawable errorDrawable) {
        super.onLoadFailed(errorDrawable);
    }

    @Override // com.bumptech.glide.request.target.f, com.bumptech.glide.request.target.k, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.j
    public void onLoadStarted(@Nullable Drawable placeholder) {
        super.onLoadStarted(placeholder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.f
    public void setResource(@Nullable SVGAVideoEntity resource) {
        SVGAImageView sVGAImageView;
        if (!this.forcePlay || resource == null || (sVGAImageView = this.svgaImageViewWRF.get()) == null) {
            return;
        }
        sVGAImageView.setImageDrawable(new SVGADrawable(resource));
        sVGAImageView.startAnimation();
    }
}
