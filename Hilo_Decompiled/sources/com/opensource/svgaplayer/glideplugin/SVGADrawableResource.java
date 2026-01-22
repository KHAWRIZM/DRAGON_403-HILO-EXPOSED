package com.opensource.svgaplayer.glideplugin;

import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import com.bumptech.glide.load.resource.drawable.i;
import com.opensource.svgaplayer.SVGADrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o4.v;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGADrawableResource;", "Lcom/bumptech/glide/load/resource/drawable/i;", "Lcom/opensource/svgaplayer/SVGADrawable;", CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, "Lo4/v;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "entityRes", "<init>", "(Lcom/opensource/svgaplayer/SVGADrawable;Lo4/v;)V", "Ljava/lang/Class;", "getResourceClass", "()Ljava/lang/Class;", "", "getSize", "()I", "", "recycle", "()V", "Lo4/v;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGADrawableResource extends i {

    @NotNull
    private final v entityRes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGADrawableResource(@NotNull SVGADrawable drawable, @NotNull v entityRes) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(entityRes, "entityRes");
        this.entityRes = entityRes;
    }

    @Override // o4.v
    @NotNull
    public Class<SVGADrawable> getResourceClass() {
        return SVGADrawable.class;
    }

    @Override // o4.v
    public int getSize() {
        return this.entityRes.getSize();
    }

    @Override // o4.v
    public void recycle() {
        this.entityRes.recycle();
    }
}
