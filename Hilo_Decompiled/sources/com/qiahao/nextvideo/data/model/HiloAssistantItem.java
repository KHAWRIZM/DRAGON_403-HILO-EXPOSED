package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.User;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u001d\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010'J\u0094\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR2\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b-\u0010'\"\u0004\b.\u0010)R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b/\u0010'\"\u0004\b0\u0010)¨\u0006B"}, d2 = {"Lcom/qiahao/nextvideo/data/model/HiloAssistantItem;", "", "content", "", "createTime", "", "type", "", "user", "Lcom/qiahao/base_common/model/common/User;", "contentIcons", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "actionUrl", "actionType", "picUrl", "picWidth", "picHeight", "<init>", "(Ljava/lang/String;JILcom/qiahao/base_common/model/common/User;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getType", "()I", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "getContentIcons", "()Ljava/util/ArrayList;", "setContentIcons", "(Ljava/util/ArrayList;)V", "getActionUrl", "setActionUrl", "getActionType", "()Ljava/lang/Integer;", "setActionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPicUrl", "setPicUrl", "getPicWidth", "setPicWidth", "getPicHeight", "setPicHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;JILcom/qiahao/base_common/model/common/User;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/model/HiloAssistantItem;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HiloAssistantItem {

    @Nullable
    @c("actionType")
    private Integer actionType;

    @Nullable
    @c("actionUrl")
    private String actionUrl;

    @Nullable
    @c("content")
    private String content;

    @Nullable
    @c("contentIcons")
    private ArrayList<String> contentIcons;

    @c("createTime")
    private long createTime;

    @Nullable
    private Integer picHeight;

    @Nullable
    @c("pic_url")
    private String picUrl;

    @Nullable
    private Integer picWidth;

    @c("type")
    private final int type;

    @Nullable
    @c("nickUserBase")
    private final User user;

    public HiloAssistantItem(@Nullable String str, long j, int i, @Nullable User user, @Nullable ArrayList<String> arrayList, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable Integer num2, @Nullable Integer num3) {
        this.content = str;
        this.createTime = j;
        this.type = i;
        this.user = user;
        this.contentIcons = arrayList;
        this.actionUrl = str2;
        this.actionType = num;
        this.picUrl = str3;
        this.picWidth = num2;
        this.picHeight = num3;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getPicHeight() {
        return this.picHeight;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final ArrayList<String> component5() {
        return this.contentIcons;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getActionType() {
        return this.actionType;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Integer getPicWidth() {
        return this.picWidth;
    }

    @NotNull
    public final HiloAssistantItem copy(@Nullable String content, long createTime, int type, @Nullable User user, @Nullable ArrayList<String> contentIcons, @Nullable String actionUrl, @Nullable Integer actionType, @Nullable String picUrl, @Nullable Integer picWidth, @Nullable Integer picHeight) {
        return new HiloAssistantItem(content, createTime, type, user, contentIcons, actionUrl, actionType, picUrl, picWidth, picHeight);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiloAssistantItem)) {
            return false;
        }
        HiloAssistantItem hiloAssistantItem = (HiloAssistantItem) other;
        return Intrinsics.areEqual(this.content, hiloAssistantItem.content) && this.createTime == hiloAssistantItem.createTime && this.type == hiloAssistantItem.type && Intrinsics.areEqual(this.user, hiloAssistantItem.user) && Intrinsics.areEqual(this.contentIcons, hiloAssistantItem.contentIcons) && Intrinsics.areEqual(this.actionUrl, hiloAssistantItem.actionUrl) && Intrinsics.areEqual(this.actionType, hiloAssistantItem.actionType) && Intrinsics.areEqual(this.picUrl, hiloAssistantItem.picUrl) && Intrinsics.areEqual(this.picWidth, hiloAssistantItem.picWidth) && Intrinsics.areEqual(this.picHeight, hiloAssistantItem.picHeight);
    }

    @Nullable
    public final Integer getActionType() {
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
    public final ArrayList<String> getContentIcons() {
        return this.contentIcons;
    }

    public final long getCreateTime() {
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

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.content;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + androidx.collection.c.a(this.createTime)) * 31) + this.type) * 31;
        User user = this.user;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        ArrayList<String> arrayList = this.contentIcons;
        int hashCode3 = (hashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str2 = this.actionUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.actionType;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.picUrl;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.picWidth;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.picHeight;
        return hashCode7 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setActionType(@Nullable Integer num) {
        this.actionType = num;
    }

    public final void setActionUrl(@Nullable String str) {
        this.actionUrl = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setContentIcons(@Nullable ArrayList<String> arrayList) {
        this.contentIcons = arrayList;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
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

    @NotNull
    public String toString() {
        return "HiloAssistantItem(content=" + this.content + ", createTime=" + this.createTime + ", type=" + this.type + ", user=" + this.user + ", contentIcons=" + this.contentIcons + ", actionUrl=" + this.actionUrl + ", actionType=" + this.actionType + ", picUrl=" + this.picUrl + ", picWidth=" + this.picWidth + ", picHeight=" + this.picHeight + ")";
    }

    public /* synthetic */ HiloAssistantItem(String str, long j, int i, User user, ArrayList arrayList, String str2, Integer num, String str3, Integer num2, Integer num3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, i, user, arrayList, str2, num, str3, (i2 & 256) != 0 ? null : num2, (i2 & 512) != 0 ? null : num3);
    }
}
