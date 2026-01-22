package com.opensource.svgaplayer.glideplugin;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.e;
import com.bumptech.glide.request.target.g;
import com.bumptech.glide.request.target.k;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAImageViewTargetFactory;", "Lcom/bumptech/glide/request/target/g;", "<init>", "()V", "", "Z", "Landroid/widget/ImageView;", ViewHierarchyConstants.VIEW_KEY, "Ljava/lang/Class;", "clazz", "Lcom/bumptech/glide/request/target/k;", "buildTarget", "(Landroid/widget/ImageView;Ljava/lang/Class;)Lcom/bumptech/glide/request/target/k;", "SVGADrawableImageViewTarget", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAImageViewTargetFactory extends g {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAImageViewTargetFactory$SVGADrawableImageViewTarget;", "Lcom/bumptech/glide/request/target/e;", "Lcom/opensource/svgaplayer/SVGAImageView;", "imageView", "<init>", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "Landroid/graphics/drawable/Drawable;", "resource", "", "setResource", "(Landroid/graphics/drawable/Drawable;)V", "Lcom/opensource/svgaplayer/SVGAImageView;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class SVGADrawableImageViewTarget extends e {

        @NotNull
        private final SVGAImageView imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SVGADrawableImageViewTarget(@NotNull SVGAImageView imageView) {
            super(imageView);
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            this.imageView = imageView;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.request.target.e, com.bumptech.glide.request.target.f
        public void setResource(@Nullable Drawable resource) {
            if (resource instanceof SVGADrawable) {
                SVGADrawable sVGADrawable = (SVGADrawable) resource;
                this.imageView.setVideoItem(sVGADrawable.getVideoItem(), sVGADrawable.getDynamicItem());
                this.imageView.startAnimation();
            } else if (resource != null) {
                this.imageView.setImageDrawable(resource);
                this.imageView.startAnimation();
            }
        }
    }

    @Override // com.bumptech.glide.request.target.g
    @NotNull
    public <Z> k buildTarget(@NotNull ImageView view, @NotNull Class<Z> clazz) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if ((view instanceof SVGAImageView) && Drawable.class.isAssignableFrom(clazz)) {
            return new SVGADrawableImageViewTarget((SVGAImageView) view);
        }
        k buildTarget = super.buildTarget(view, clazz);
        Intrinsics.checkNotNullExpressionValue(buildTarget, "super.buildTarget(view, clazz)");
        return buildTarget;
    }
}
