package com.qiahao.nextvideo.data.model;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ActivityIngResponseBeanItem;", "", AgooConstants.MESSAGE_ID, "", "url", "", "iconUrl", "title", "status", "createdTime", "updatedTime", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getUrl", "()Ljava/lang/String;", "getIconUrl", "getTitle", "getStatus", "getCreatedTime", "getUpdatedTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ActivityIngResponseBeanItem {

    @NotNull
    @c("CreatedTime")
    private final String createdTime;

    @NotNull
    @c(TUIConstants.TUIChat.INPUT_MORE_ICON)
    private final String iconUrl;

    @c("ID")
    private final int id;

    @c("status")
    private final int status;

    @NotNull
    @c("title")
    private final String title;

    @NotNull
    @c("UpdatedTime")
    private final String updatedTime;

    @NotNull
    @c("url")
    private final String url;

    public ActivityIngResponseBeanItem(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "iconUrl");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "createdTime");
        Intrinsics.checkNotNullParameter(str5, "updatedTime");
        this.id = i;
        this.url = str;
        this.iconUrl = str2;
        this.title = str3;
        this.status = i2;
        this.createdTime = str4;
        this.updatedTime = str5;
    }

    public static /* synthetic */ ActivityIngResponseBeanItem copy$default(ActivityIngResponseBeanItem activityIngResponseBeanItem, int i, String str, String str2, String str3, int i2, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = activityIngResponseBeanItem.id;
        }
        if ((i3 & 2) != 0) {
            str = activityIngResponseBeanItem.url;
        }
        String str6 = str;
        if ((i3 & 4) != 0) {
            str2 = activityIngResponseBeanItem.iconUrl;
        }
        String str7 = str2;
        if ((i3 & 8) != 0) {
            str3 = activityIngResponseBeanItem.title;
        }
        String str8 = str3;
        if ((i3 & 16) != 0) {
            i2 = activityIngResponseBeanItem.status;
        }
        int i4 = i2;
        if ((i3 & 32) != 0) {
            str4 = activityIngResponseBeanItem.createdTime;
        }
        String str9 = str4;
        if ((i3 & 64) != 0) {
            str5 = activityIngResponseBeanItem.updatedTime;
        }
        return activityIngResponseBeanItem.copy(i, str6, str7, str8, i4, str9, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getUpdatedTime() {
        return this.updatedTime;
    }

    @NotNull
    public final ActivityIngResponseBeanItem copy(int id2, @NotNull String url, @NotNull String iconUrl, @NotNull String title, int status, @NotNull String createdTime, @NotNull String updatedTime) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(createdTime, "createdTime");
        Intrinsics.checkNotNullParameter(updatedTime, "updatedTime");
        return new ActivityIngResponseBeanItem(id2, url, iconUrl, title, status, createdTime, updatedTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityIngResponseBeanItem)) {
            return false;
        }
        ActivityIngResponseBeanItem activityIngResponseBeanItem = (ActivityIngResponseBeanItem) other;
        return this.id == activityIngResponseBeanItem.id && Intrinsics.areEqual(this.url, activityIngResponseBeanItem.url) && Intrinsics.areEqual(this.iconUrl, activityIngResponseBeanItem.iconUrl) && Intrinsics.areEqual(this.title, activityIngResponseBeanItem.title) && this.status == activityIngResponseBeanItem.status && Intrinsics.areEqual(this.createdTime, activityIngResponseBeanItem.createdTime) && Intrinsics.areEqual(this.updatedTime, activityIngResponseBeanItem.updatedTime);
    }

    @NotNull
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUpdatedTime() {
        return this.updatedTime;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((((((this.id * 31) + this.url.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.status) * 31) + this.createdTime.hashCode()) * 31) + this.updatedTime.hashCode();
    }

    @NotNull
    public String toString() {
        return "ActivityIngResponseBeanItem(id=" + this.id + ", url=" + this.url + ", iconUrl=" + this.iconUrl + ", title=" + this.title + ", status=" + this.status + ", createdTime=" + this.createdTime + ", updatedTime=" + this.updatedTime + ")";
    }
}
