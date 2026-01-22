package com.qiahao.nextvideo.data.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupMedalDetailBean;", "Ljava/io/Serializable;", AgooConstants.MESSAGE_ID, "", "effectUrl", "", "picUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getEffectUrl", "()Ljava/lang/String;", "setEffectUrl", "(Ljava/lang/String;)V", "getPicUrl", "setPicUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupMedalDetailBean implements Serializable {

    @NotNull
    private String effectUrl;
    private int id;

    @NotNull
    private String picUrl;

    public GroupMedalDetailBean(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "effectUrl");
        Intrinsics.checkNotNullParameter(str2, "picUrl");
        this.id = i;
        this.effectUrl = str;
        this.picUrl = str2;
    }

    public static /* synthetic */ GroupMedalDetailBean copy$default(GroupMedalDetailBean groupMedalDetailBean, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = groupMedalDetailBean.id;
        }
        if ((i2 & 2) != 0) {
            str = groupMedalDetailBean.effectUrl;
        }
        if ((i2 & 4) != 0) {
            str2 = groupMedalDetailBean.picUrl;
        }
        return groupMedalDetailBean.copy(i, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @NotNull
    public final GroupMedalDetailBean copy(int id2, @NotNull String effectUrl, @NotNull String picUrl) {
        Intrinsics.checkNotNullParameter(effectUrl, "effectUrl");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        return new GroupMedalDetailBean(id2, effectUrl, picUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMedalDetailBean)) {
            return false;
        }
        GroupMedalDetailBean groupMedalDetailBean = (GroupMedalDetailBean) other;
        return this.id == groupMedalDetailBean.id && Intrinsics.areEqual(this.effectUrl, groupMedalDetailBean.effectUrl) && Intrinsics.areEqual(this.picUrl, groupMedalDetailBean.picUrl);
    }

    @NotNull
    public final String getEffectUrl() {
        return this.effectUrl;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getPicUrl() {
        return this.picUrl;
    }

    public int hashCode() {
        return (((this.id * 31) + this.effectUrl.hashCode()) * 31) + this.picUrl.hashCode();
    }

    public final void setEffectUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.effectUrl = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPicUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.picUrl = str;
    }

    @NotNull
    public String toString() {
        return "GroupMedalDetailBean(id=" + this.id + ", effectUrl=" + this.effectUrl + ", picUrl=" + this.picUrl + ")";
    }
}
