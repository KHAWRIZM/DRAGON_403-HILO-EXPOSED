package com.qiahao.nextvideo.data.model;

import android.text.TextUtils;
import androidx.collection.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\bJ\u0006\u0010(\u001a\u00020)J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00103\u001a\u00020)2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\bHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u00068"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CreateActivityData;", "Ljava/io/Serializable;", "banner", "", "theme", "desc", "groupId", "acType", "", "startAt", "", "duration", "md5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJILjava/lang/String;)V", "getBanner", "()Ljava/lang/String;", "setBanner", "(Ljava/lang/String;)V", "getTheme", "setTheme", "getDesc", "setDesc", "getGroupId", "setGroupId", "getAcType", "()I", "setAcType", "(I)V", "getStartAt", "()J", "setStartAt", "(J)V", "getDuration", "setDuration", "getMd5", "setMd5", "setActivityType", "", "index", "checkInfo", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CreateActivityData implements Serializable {
    private int acType;

    @NotNull
    private String banner;

    @NotNull
    private String desc;
    private int duration;

    @NotNull
    private String groupId;

    @Nullable
    private String md5;
    private long startAt;

    @NotNull
    private String theme;

    public CreateActivityData() {
        this(null, null, null, null, 0, 0L, 0, null, 255, null);
    }

    public final boolean checkInfo() {
        if (!TextUtils.isEmpty(this.theme) && !TextUtils.isEmpty(this.desc) && !TextUtils.isEmpty(this.groupId) && this.acType != 0 && this.startAt != 0 && this.duration != 0) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTheme() {
        return this.theme;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getAcType() {
        return this.acType;
    }

    /* renamed from: component6, reason: from getter */
    public final long getStartAt() {
        return this.startAt;
    }

    /* renamed from: component7, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final CreateActivityData copy(@NotNull String banner, @NotNull String theme, @NotNull String desc, @NotNull String groupId, int acType, long startAt, int duration, @Nullable String md5) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return new CreateActivityData(banner, theme, desc, groupId, acType, startAt, duration, md5);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateActivityData)) {
            return false;
        }
        CreateActivityData createActivityData = (CreateActivityData) other;
        return Intrinsics.areEqual(this.banner, createActivityData.banner) && Intrinsics.areEqual(this.theme, createActivityData.theme) && Intrinsics.areEqual(this.desc, createActivityData.desc) && Intrinsics.areEqual(this.groupId, createActivityData.groupId) && this.acType == createActivityData.acType && this.startAt == createActivityData.startAt && this.duration == createActivityData.duration && Intrinsics.areEqual(this.md5, createActivityData.md5);
    }

    public final int getAcType() {
        return this.acType;
    }

    @NotNull
    public final String getBanner() {
        return this.banner;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    public final long getStartAt() {
        return this.startAt;
    }

    @NotNull
    public final String getTheme() {
        return this.theme;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.banner.hashCode() * 31) + this.theme.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.acType) * 31) + c.a(this.startAt)) * 31) + this.duration) * 31;
        String str = this.md5;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setAcType(int i) {
        this.acType = i;
    }

    public final void setActivityType(int index) {
        if (index != 0) {
            if (index != 1) {
                if (index != 2) {
                    if (index == 3) {
                        this.acType = 4;
                        return;
                    }
                    return;
                }
                this.acType = 3;
                return;
            }
            this.acType = 2;
            return;
        }
        this.acType = 1;
    }

    public final void setBanner(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.banner = str;
    }

    public final void setDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final void setGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final void setMd5(@Nullable String str) {
        this.md5 = str;
    }

    public final void setStartAt(long j) {
        this.startAt = j;
    }

    public final void setTheme(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.theme = str;
    }

    @NotNull
    public String toString() {
        return "CreateActivityData(banner=" + this.banner + ", theme=" + this.theme + ", desc=" + this.desc + ", groupId=" + this.groupId + ", acType=" + this.acType + ", startAt=" + this.startAt + ", duration=" + this.duration + ", md5=" + this.md5 + ")";
    }

    public CreateActivityData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, long j, int i2, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "banner");
        Intrinsics.checkNotNullParameter(str2, "theme");
        Intrinsics.checkNotNullParameter(str3, "desc");
        Intrinsics.checkNotNullParameter(str4, "groupId");
        this.banner = str;
        this.theme = str2;
        this.desc = str3;
        this.groupId = str4;
        this.acType = i;
        this.startAt = j;
        this.duration = i2;
        this.md5 = str5;
    }

    public /* synthetic */ CreateActivityData(String str, String str2, String str3, String str4, int i, long j, int i2, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) == 0 ? str4 : "", (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 0L : j, (i3 & 64) == 0 ? i2 : 0, (i3 & 128) != 0 ? null : str5);
    }
}
