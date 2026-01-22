package com.qiahao.nextvideo.data.room;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/data/room/BoxData;", "", TUIConstants.TUIChat.INPUT_MORE_ICON, "", "name", "num", "", "hasAward", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getName", "setName", "getNum", "()Ljava/lang/Long;", "setNum", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getHasAward", "()Ljava/lang/Boolean;", "setHasAward", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/room/BoxData;", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class BoxData {

    @Nullable
    private Boolean hasAward;

    @Nullable
    private String icon;

    @Nullable
    private String name;

    @Nullable
    private Long num;

    public BoxData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ BoxData copy$default(BoxData boxData, String str, String str2, Long l, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = boxData.icon;
        }
        if ((i & 2) != 0) {
            str2 = boxData.name;
        }
        if ((i & 4) != 0) {
            l = boxData.num;
        }
        if ((i & 8) != 0) {
            bool = boxData.hasAward;
        }
        return boxData.copy(str, str2, l, bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getNum() {
        return this.num;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getHasAward() {
        return this.hasAward;
    }

    @NotNull
    public final BoxData copy(@Nullable String icon, @Nullable String name, @Nullable Long num, @Nullable Boolean hasAward) {
        return new BoxData(icon, name, num, hasAward);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxData)) {
            return false;
        }
        BoxData boxData = (BoxData) other;
        return Intrinsics.areEqual(this.icon, boxData.icon) && Intrinsics.areEqual(this.name, boxData.name) && Intrinsics.areEqual(this.num, boxData.num) && Intrinsics.areEqual(this.hasAward, boxData.hasAward);
    }

    @Nullable
    public final Boolean getHasAward() {
        return this.hasAward;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Long getNum() {
        return this.num;
    }

    public int hashCode() {
        String str = this.icon;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.num;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.hasAward;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public final void setHasAward(@Nullable Boolean bool) {
        this.hasAward = bool;
    }

    public final void setIcon(@Nullable String str) {
        this.icon = str;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setNum(@Nullable Long l) {
        this.num = l;
    }

    @NotNull
    public String toString() {
        return "BoxData(icon=" + this.icon + ", name=" + this.name + ", num=" + this.num + ", hasAward=" + this.hasAward + ")";
    }

    public BoxData(@Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable Boolean bool) {
        this.icon = str;
        this.name = str2;
        this.num = l;
        this.hasAward = bool;
    }

    public /* synthetic */ BoxData(String str, String str2, Long l, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : bool);
    }
}
