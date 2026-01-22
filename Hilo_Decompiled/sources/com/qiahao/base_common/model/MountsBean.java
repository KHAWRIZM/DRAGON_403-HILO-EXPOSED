package com.qiahao.base_common.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/qiahao/base_common/model/MountsBean;", "", "id", "", "picUrl", "", "effectUrl", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getPicUrl", "()Ljava/lang/String;", "getEffectUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MountsBean {

    @NotNull
    private final String effectUrl;
    private final long id;

    @NotNull
    private final String picUrl;

    public MountsBean(long j10, @NotNull String picUrl, @NotNull String effectUrl) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(effectUrl, "effectUrl");
        this.id = j10;
        this.picUrl = picUrl;
        this.effectUrl = effectUrl;
    }

    public static /* synthetic */ MountsBean copy$default(MountsBean mountsBean, long j10, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = mountsBean.id;
        }
        if ((i10 & 2) != 0) {
            str = mountsBean.picUrl;
        }
        if ((i10 & 4) != 0) {
            str2 = mountsBean.effectUrl;
        }
        return mountsBean.copy(j10, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @NotNull
    public final MountsBean copy(long id, @NotNull String picUrl, @NotNull String effectUrl) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(effectUrl, "effectUrl");
        return new MountsBean(id, picUrl, effectUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MountsBean)) {
            return false;
        }
        MountsBean mountsBean = (MountsBean) other;
        return this.id == mountsBean.id && Intrinsics.areEqual(this.picUrl, mountsBean.picUrl) && Intrinsics.areEqual(this.effectUrl, mountsBean.effectUrl);
    }

    @NotNull
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    public int hashCode() {
        return (((c.a(this.id) * 31) + this.picUrl.hashCode()) * 31) + this.effectUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "MountsBean(id=" + this.id + ", picUrl=" + this.picUrl + ", effectUrl=" + this.effectUrl + ")";
    }
}
