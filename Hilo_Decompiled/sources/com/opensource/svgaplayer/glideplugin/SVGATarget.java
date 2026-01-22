package com.opensource.svgaplayer.glideplugin;

import com.bumptech.glide.request.target.f;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGATarget;", "Lcom/bumptech/glide/request/target/f;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "Lcom/opensource/svgaplayer/SVGAImageView;", "imageView", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "dynamicEntity", "<init>", "(Lcom/opensource/svgaplayer/SVGAImageView;Lcom/opensource/svgaplayer/SVGADynamicEntity;)V", "resource", "", "setResource", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;)V", "Lcom/opensource/svgaplayer/SVGAImageView;", "getImageView", "()Lcom/opensource/svgaplayer/SVGAImageView;", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "getDynamicEntity", "()Lcom/opensource/svgaplayer/SVGADynamicEntity;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SVGATarget extends f {

    @NotNull
    private final SVGADynamicEntity dynamicEntity;

    @NotNull
    private final SVGAImageView imageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGATarget(@NotNull SVGAImageView imageView, @NotNull SVGADynamicEntity dynamicEntity) {
        super(imageView);
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(dynamicEntity, "dynamicEntity");
        this.imageView = imageView;
        this.dynamicEntity = dynamicEntity;
    }

    @NotNull
    protected final SVGADynamicEntity getDynamicEntity() {
        return this.dynamicEntity;
    }

    @NotNull
    protected final SVGAImageView getImageView() {
        return this.imageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.f
    public void setResource(@Nullable SVGAVideoEntity resource) {
        if (resource == null) {
            return;
        }
        this.imageView.setImageDrawable(new SVGADrawable(resource, this.dynamicEntity));
        this.imageView.startAnimation();
    }
}
