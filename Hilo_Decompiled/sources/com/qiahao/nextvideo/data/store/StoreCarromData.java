package com.qiahao.nextvideo.data.store;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/store/StoreCarromData;", "", AgooConstants.MESSAGE_ID, "", "name", "", "picUrl", "svipLevel", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPicUrl", "setPicUrl", "getSvipLevel", "setSvipLevel", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/qiahao/nextvideo/data/store/StoreCarromData;", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class StoreCarromData {

    @Nullable
    private Long id;

    @Nullable
    private String name;

    @Nullable
    private String picUrl;

    @Nullable
    private Long svipLevel;

    public StoreCarromData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ StoreCarromData copy$default(StoreCarromData storeCarromData, Long l, String str, String str2, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = storeCarromData.id;
        }
        if ((i & 2) != 0) {
            str = storeCarromData.name;
        }
        if ((i & 4) != 0) {
            str2 = storeCarromData.picUrl;
        }
        if ((i & 8) != 0) {
            l2 = storeCarromData.svipLevel;
        }
        return storeCarromData.copy(l, str, str2, l2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getSvipLevel() {
        return this.svipLevel;
    }

    @NotNull
    public final StoreCarromData copy(@Nullable Long id2, @Nullable String name, @Nullable String picUrl, @Nullable Long svipLevel) {
        return new StoreCarromData(id2, name, picUrl, svipLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreCarromData)) {
            return false;
        }
        StoreCarromData storeCarromData = (StoreCarromData) other;
        return Intrinsics.areEqual(this.id, storeCarromData.id) && Intrinsics.areEqual(this.name, storeCarromData.name) && Intrinsics.areEqual(this.picUrl, storeCarromData.picUrl) && Intrinsics.areEqual(this.svipLevel, storeCarromData.svipLevel);
    }

    @Nullable
    public final Long getId() {
        return this.id;
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
    public final Long getSvipLevel() {
        return this.svipLevel;
    }

    public int hashCode() {
        Long l = this.id;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.picUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.svipLevel;
        return hashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public final void setId(@Nullable Long l) {
        this.id = l;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setSvipLevel(@Nullable Long l) {
        this.svipLevel = l;
    }

    @NotNull
    public String toString() {
        return "StoreCarromData(id=" + this.id + ", name=" + this.name + ", picUrl=" + this.picUrl + ", svipLevel=" + this.svipLevel + ")";
    }

    public StoreCarromData(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable Long l2) {
        this.id = l;
        this.name = str;
        this.picUrl = str2;
        this.svipLevel = l2;
    }

    public /* synthetic */ StoreCarromData(Long l, String str, String str2, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l2);
    }
}
