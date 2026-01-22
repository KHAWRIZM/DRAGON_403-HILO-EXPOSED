package com.qiahao.nextvideo.data.mainActivity;

import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/data/mainActivity/MainAwardData;", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "duration", "name", "", "picUrl", "type", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDiamond", "()Ljava/lang/Long;", "setDiamond", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDuration", "setDuration", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPicUrl", "setPicUrl", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/mainActivity/MainAwardData;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MainAwardData {

    @Nullable
    private Long diamond;

    @Nullable
    private Long duration;

    @Nullable
    private String name;

    @Nullable
    private String picUrl;

    @Nullable
    private Integer type;

    public MainAwardData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MainAwardData copy$default(MainAwardData mainAwardData, Long l, Long l2, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            l = mainAwardData.diamond;
        }
        if ((i & 2) != 0) {
            l2 = mainAwardData.duration;
        }
        Long l3 = l2;
        if ((i & 4) != 0) {
            str = mainAwardData.name;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = mainAwardData.picUrl;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            num = mainAwardData.type;
        }
        return mainAwardData.copy(l, l3, str3, str4, num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @NotNull
    public final MainAwardData copy(@Nullable Long diamond, @Nullable Long duration, @Nullable String name, @Nullable String picUrl, @Nullable Integer type) {
        return new MainAwardData(diamond, duration, name, picUrl, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainAwardData)) {
            return false;
        }
        MainAwardData mainAwardData = (MainAwardData) other;
        return Intrinsics.areEqual(this.diamond, mainAwardData.diamond) && Intrinsics.areEqual(this.duration, mainAwardData.duration) && Intrinsics.areEqual(this.name, mainAwardData.name) && Intrinsics.areEqual(this.picUrl, mainAwardData.picUrl) && Intrinsics.areEqual(this.type, mainAwardData.type);
    }

    @Nullable
    public final Long getDiamond() {
        return this.diamond;
    }

    @Nullable
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Long l = this.diamond;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.duration;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.picUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.type;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final void setDiamond(@Nullable Long l) {
        this.diamond = l;
    }

    public final void setDuration(@Nullable Long l) {
        this.duration = l;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "MainAwardData(diamond=" + this.diamond + ", duration=" + this.duration + ", name=" + this.name + ", picUrl=" + this.picUrl + ", type=" + this.type + ")";
    }

    public MainAwardData(@Nullable Long l, @Nullable Long l2, @Nullable String str, @Nullable String str2, @Nullable Integer num) {
        this.diamond = l;
        this.duration = l2;
        this.name = str;
        this.picUrl = str2;
        this.type = num;
    }

    public /* synthetic */ MainAwardData(Long l, Long l2, String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num);
    }
}
