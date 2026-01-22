package com.qiahao.nextvideo.data.medal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/data/medal/MedalSort;", "", "medalId", "", "medalUrl", "", "pos", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getMedalId", "()Ljava/lang/Integer;", "setMedalId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMedalUrl", "()Ljava/lang/String;", "setMedalUrl", "(Ljava/lang/String;)V", "getPos", "setPos", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/medal/MedalSort;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MedalSort {

    @Nullable
    private Integer medalId;

    @Nullable
    private String medalUrl;

    @Nullable
    private Integer pos;

    public MedalSort() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MedalSort copy$default(MedalSort medalSort, Integer num, String str, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = medalSort.medalId;
        }
        if ((i & 2) != 0) {
            str = medalSort.medalUrl;
        }
        if ((i & 4) != 0) {
            num2 = medalSort.pos;
        }
        return medalSort.copy(num, str, num2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getMedalId() {
        return this.medalId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getPos() {
        return this.pos;
    }

    @NotNull
    public final MedalSort copy(@Nullable Integer medalId, @Nullable String medalUrl, @Nullable Integer pos) {
        return new MedalSort(medalId, medalUrl, pos);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalSort)) {
            return false;
        }
        MedalSort medalSort = (MedalSort) other;
        return Intrinsics.areEqual(this.medalId, medalSort.medalId) && Intrinsics.areEqual(this.medalUrl, medalSort.medalUrl) && Intrinsics.areEqual(this.pos, medalSort.pos);
    }

    @Nullable
    public final Integer getMedalId() {
        return this.medalId;
    }

    @Nullable
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    @Nullable
    public final Integer getPos() {
        return this.pos;
    }

    public int hashCode() {
        Integer num = this.medalId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.medalUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.pos;
        return hashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setMedalId(@Nullable Integer num) {
        this.medalId = num;
    }

    public final void setMedalUrl(@Nullable String str) {
        this.medalUrl = str;
    }

    public final void setPos(@Nullable Integer num) {
        this.pos = num;
    }

    @NotNull
    public String toString() {
        return "MedalSort(medalId=" + this.medalId + ", medalUrl=" + this.medalUrl + ", pos=" + this.pos + ")";
    }

    public MedalSort(@Nullable Integer num, @Nullable String str, @Nullable Integer num2) {
        this.medalId = num;
        this.medalUrl = str;
        this.pos = num2;
    }

    public /* synthetic */ MedalSort(Integer num, String str, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2);
    }
}
