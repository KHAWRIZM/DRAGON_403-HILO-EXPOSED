package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.ui.hiloassistant.HiloAssistantCellUIModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JH\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserMsg;", "", "content", "", "createTime", "", "picUrl", "title", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPicUrl", "setPicUrl", "getTitle", "setTitle", "getType", "()I", "setType", "(I)V", "replacedInContent", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;I)Lcom/qiahao/nextvideo/data/model/UserMsg;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserMsg {

    @Nullable
    @c("content")
    private String content;

    @Nullable
    @c("createTime")
    private Long createTime;

    @Nullable
    @c("pic_url")
    private String picUrl;

    @Nullable
    @c("title")
    private String title;

    @c("type")
    private int type;

    public UserMsg(@Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable String str3, int i) {
        this.content = str;
        this.createTime = l;
        this.picUrl = str2;
        this.title = str3;
        this.type = i;
    }

    public static /* synthetic */ UserMsg copy$default(UserMsg userMsg, String str, Long l, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userMsg.content;
        }
        if ((i2 & 2) != 0) {
            l = userMsg.createTime;
        }
        Long l2 = l;
        if ((i2 & 4) != 0) {
            str2 = userMsg.picUrl;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            str3 = userMsg.title;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            i = userMsg.type;
        }
        return userMsg.copy(str, l2, str4, str5, i);
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

    /* renamed from: component5, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final UserMsg copy(@Nullable String content, @Nullable Long createTime, @Nullable String picUrl, @Nullable String title, int type) {
        return new UserMsg(content, createTime, picUrl, title, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserMsg)) {
            return false;
        }
        UserMsg userMsg = (UserMsg) other;
        return Intrinsics.areEqual(this.content, userMsg.content) && Intrinsics.areEqual(this.createTime, userMsg.createTime) && Intrinsics.areEqual(this.picUrl, userMsg.picUrl) && Intrinsics.areEqual(this.title, userMsg.title) && this.type == userMsg.type;
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
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
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
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.type;
    }

    @NotNull
    public final String replacedInContent() {
        long j;
        Long l = this.createTime;
        if (l != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        String dateInSecs$default = DateTimeUtilityKt.getDateInSecs$default(j, (Locale) null, "yyyy-MM-dd HH:mm:ss", 2, (Object) null);
        String str = this.content;
        if (str == null) {
            str = "";
        }
        return StringsKt.replace$default(str, HiloAssistantCellUIModel.regexTimestamp, dateInSecs$default, false, 4, (Object) null);
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setCreateTime(@Nullable Long l) {
        this.createTime = l;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "UserMsg(content=" + this.content + ", createTime=" + this.createTime + ", picUrl=" + this.picUrl + ", title=" + this.title + ", type=" + this.type + ")";
    }
}
