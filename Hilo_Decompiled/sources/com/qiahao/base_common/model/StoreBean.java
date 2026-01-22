package com.qiahao.base_common.model;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJn\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\nHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001e\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006;"}, d2 = {"Lcom/qiahao/base_common/model/StoreBean;", "", "days", "", "diamondNum", "", "effectUrl", "id", "picUrl", "second", "", "name", "relationType", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getDays", "()Ljava/lang/String;", "setDays", "(Ljava/lang/String;)V", "getDiamondNum", "()Ljava/lang/Long;", "setDiamondNum", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEffectUrl", "setEffectUrl", "getId", "setId", "getPicUrl", "setPicUrl", "getSecond", "()Ljava/lang/Integer;", "setSecond", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "setName", "getRelationType", "setRelationType", "type", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/base_common/model/StoreBean;", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class StoreBean {

    @Nullable
    private String days;

    @Nullable
    private Long diamondNum;

    @Nullable
    private String effectUrl;

    @Nullable
    private Long id;

    @Nullable
    private String name;

    @Nullable
    private String picUrl;

    @Nullable
    private Integer relationType;

    @Nullable
    private Integer second;
    private int type;

    public StoreBean() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getDays() {
        return this.days;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getSecond() {
        return this.second;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getRelationType() {
        return this.relationType;
    }

    @NotNull
    public final StoreBean copy(@Nullable String days, @Nullable Long diamondNum, @Nullable String effectUrl, @Nullable Long id, @Nullable String picUrl, @Nullable Integer second, @Nullable String name, @Nullable Integer relationType) {
        return new StoreBean(days, diamondNum, effectUrl, id, picUrl, second, name, relationType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreBean)) {
            return false;
        }
        StoreBean storeBean = (StoreBean) other;
        return Intrinsics.areEqual(this.days, storeBean.days) && Intrinsics.areEqual(this.diamondNum, storeBean.diamondNum) && Intrinsics.areEqual(this.effectUrl, storeBean.effectUrl) && Intrinsics.areEqual(this.id, storeBean.id) && Intrinsics.areEqual(this.picUrl, storeBean.picUrl) && Intrinsics.areEqual(this.second, storeBean.second) && Intrinsics.areEqual(this.name, storeBean.name) && Intrinsics.areEqual(this.relationType, storeBean.relationType);
    }

    @Nullable
    public final String getDays() {
        return this.days;
    }

    @Nullable
    public final Long getDiamondNum() {
        return this.diamondNum;
    }

    @Nullable
    public final String getEffectUrl() {
        return this.effectUrl;
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
    public final Integer getRelationType() {
        return this.relationType;
    }

    @Nullable
    public final Integer getSecond() {
        return this.second;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.days;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l10 = this.diamondNum;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.effectUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l11 = this.id;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str3 = this.picUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.second;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.name;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.relationType;
        return hashCode7 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setDays(@Nullable String str) {
        this.days = str;
    }

    public final void setDiamondNum(@Nullable Long l10) {
        this.diamondNum = l10;
    }

    public final void setEffectUrl(@Nullable String str) {
        this.effectUrl = str;
    }

    public final void setId(@Nullable Long l10) {
        this.id = l10;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setRelationType(@Nullable Integer num) {
        this.relationType = num;
    }

    public final void setSecond(@Nullable Integer num) {
        this.second = num;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    @NotNull
    public String toString() {
        return "StoreBean(days=" + this.days + ", diamondNum=" + this.diamondNum + ", effectUrl=" + this.effectUrl + ", id=" + this.id + ", picUrl=" + this.picUrl + ", second=" + this.second + ", name=" + this.name + ", relationType=" + this.relationType + ")";
    }

    public StoreBean(@Nullable String str, @Nullable Long l10, @Nullable String str2, @Nullable Long l11, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable Integer num2) {
        this.days = str;
        this.diamondNum = l10;
        this.effectUrl = str2;
        this.id = l11;
        this.picUrl = str3;
        this.second = num;
        this.name = str4;
        this.relationType = num2;
    }

    public /* synthetic */ StoreBean(String str, Long l10, String str2, Long l11, String str3, Integer num, String str4, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : l11, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : num, (i10 & 64) != 0 ? null : str4, (i10 & 128) == 0 ? num2 : null);
    }
}
