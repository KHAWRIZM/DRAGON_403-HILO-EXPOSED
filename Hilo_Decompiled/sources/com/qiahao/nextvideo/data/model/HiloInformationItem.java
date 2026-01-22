package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJx\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\tHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001e\u0010\r\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 ¨\u0006<"}, d2 = {"Lcom/qiahao/nextvideo/data/model/HiloInformationItem;", "", "content", "", "createTime", "", "picUrl", "title", "type", "", "actionUrl", "actionType", "picWidth", "picHeight", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPicUrl", "setPicUrl", "getTitle", "setTitle", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getActionUrl", "setActionUrl", "getActionType", "()I", "setActionType", "(I)V", "getPicWidth", "setPicWidth", "getPicHeight", "setPicHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/HiloInformationItem;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HiloInformationItem {

    @c("actionType")
    private int actionType;

    @Nullable
    @c("actionUrl")
    private String actionUrl;

    @Nullable
    @c("content")
    private String content;

    @Nullable
    @c("createTime")
    private Long createTime;

    @Nullable
    private Integer picHeight;

    @Nullable
    @c("pic_url")
    private String picUrl;

    @Nullable
    private Integer picWidth;

    @Nullable
    @c("title")
    private String title;

    @Nullable
    @c("type")
    private Integer type;

    public HiloInformationItem(@Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, int i, @Nullable Integer num2, @Nullable Integer num3) {
        this.content = str;
        this.createTime = l;
        this.picUrl = str2;
        this.title = str3;
        this.type = num;
        this.actionUrl = str4;
        this.actionType = i;
        this.picWidth = num2;
        this.picHeight = num3;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getActionUrl() {
        return this.actionUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getPicWidth() {
        return this.picWidth;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getPicHeight() {
        return this.picHeight;
    }

    @NotNull
    public final HiloInformationItem copy(@Nullable String content, @Nullable Long createTime, @Nullable String picUrl, @Nullable String title, @Nullable Integer type, @Nullable String actionUrl, int actionType, @Nullable Integer picWidth, @Nullable Integer picHeight) {
        return new HiloInformationItem(content, createTime, picUrl, title, type, actionUrl, actionType, picWidth, picHeight);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiloInformationItem)) {
            return false;
        }
        HiloInformationItem hiloInformationItem = (HiloInformationItem) other;
        return Intrinsics.areEqual(this.content, hiloInformationItem.content) && Intrinsics.areEqual(this.createTime, hiloInformationItem.createTime) && Intrinsics.areEqual(this.picUrl, hiloInformationItem.picUrl) && Intrinsics.areEqual(this.title, hiloInformationItem.title) && Intrinsics.areEqual(this.type, hiloInformationItem.type) && Intrinsics.areEqual(this.actionUrl, hiloInformationItem.actionUrl) && this.actionType == hiloInformationItem.actionType && Intrinsics.areEqual(this.picWidth, hiloInformationItem.picWidth) && Intrinsics.areEqual(this.picHeight, hiloInformationItem.picHeight);
    }

    public final int getActionType() {
        return this.actionType;
    }

    @Nullable
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final Integer getPicHeight() {
        return this.picHeight;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final Integer getPicWidth() {
        return this.picWidth;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.content;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.createTime;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.picUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.type;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.actionUrl;
        int hashCode6 = (((hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.actionType) * 31;
        Integer num2 = this.picWidth;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.picHeight;
        return hashCode7 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setActionType(int i) {
        this.actionType = i;
    }

    public final void setActionUrl(@Nullable String str) {
        this.actionUrl = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setCreateTime(@Nullable Long l) {
        this.createTime = l;
    }

    public final void setPicHeight(@Nullable Integer num) {
        this.picHeight = num;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setPicWidth(@Nullable Integer num) {
        this.picWidth = num;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "HiloInformationItem(content=" + this.content + ", createTime=" + this.createTime + ", picUrl=" + this.picUrl + ", title=" + this.title + ", type=" + this.type + ", actionUrl=" + this.actionUrl + ", actionType=" + this.actionType + ", picWidth=" + this.picWidth + ", picHeight=" + this.picHeight + ")";
    }

    public /* synthetic */ HiloInformationItem(String str, Long l, String str2, String str3, Integer num, String str4, int i, Integer num2, Integer num3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, str2, str3, num, str4, i, (i2 & 128) != 0 ? null : num2, (i2 & 256) != 0 ? null : num3);
    }
}
