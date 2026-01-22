package com.opensource.svgaplayer.glideplugin;

import com.opensource.svgaplayer.SVGAVideoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o4.v;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityResource;", "Lo4/v;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "entity", "", "size", "<init>", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;I)V", "Ljava/lang/Class;", "getResourceClass", "()Ljava/lang/Class;", "get", "()Lcom/opensource/svgaplayer/SVGAVideoEntity;", "getSize", "()I", "", "recycle", "()V", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "I", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAEntityResource implements v {

    @NotNull
    private final SVGAVideoEntity entity;
    private final int size;

    public SVGAEntityResource(@NotNull SVGAVideoEntity entity, int i10) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        this.entity = entity;
        this.size = i10;
    }

    @Override // o4.v
    @NotNull
    public Class<SVGAVideoEntity> getResourceClass() {
        return SVGAVideoEntity.class;
    }

    @Override // o4.v
    public int getSize() {
        return this.size;
    }

    @Override // o4.v
    public void recycle() {
    }

    @Override // o4.v
    @NotNull
    /* renamed from: get, reason: from getter */
    public SVGAVideoEntity getEntity() {
        return this.entity;
    }
}
