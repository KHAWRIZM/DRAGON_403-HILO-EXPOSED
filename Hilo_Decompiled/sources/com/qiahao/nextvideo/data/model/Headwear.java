package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/data/model/Headwear;", "", "effectUrl", "", "picUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEffectUrl", "()Ljava/lang/String;", "getPicUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Headwear {

    @NotNull
    private final String effectUrl;

    @NotNull
    private final String picUrl;

    public Headwear(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "effectUrl");
        Intrinsics.checkNotNullParameter(str2, "picUrl");
        this.effectUrl = str;
        this.picUrl = str2;
    }

    public static /* synthetic */ Headwear copy$default(Headwear headwear, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headwear.effectUrl;
        }
        if ((i & 2) != 0) {
            str2 = headwear.picUrl;
        }
        return headwear.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public final Headwear copy(@NotNull String effectUrl, @NotNull String picUrl) {
        Intrinsics.checkNotNullParameter(effectUrl, "effectUrl");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        return new Headwear(effectUrl, picUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Headwear)) {
            return false;
        }
        Headwear headwear = (Headwear) other;
        return Intrinsics.areEqual(this.effectUrl, headwear.effectUrl) && Intrinsics.areEqual(this.picUrl, headwear.picUrl);
    }

    @NotNull
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    public int hashCode() {
        return (this.effectUrl.hashCode() * 31) + this.picUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "Headwear(effectUrl=" + this.effectUrl + ", picUrl=" + this.picUrl + ")";
    }
}
