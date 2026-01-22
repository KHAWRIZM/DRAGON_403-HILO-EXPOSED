package com.qiahao.nextvideo.data.mainActivity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/mainActivity/HomeRoomBannerData;", "", "type", "", "data", "<init>", "(Ljava/lang/Integer;Ljava/lang/Object;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Object;)Lcom/qiahao/nextvideo/data/mainActivity/HomeRoomBannerData;", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HomeRoomBannerData {
    public static final int TYPE_FAMILY = 1;
    public static final int TYPE_MAIN_ACTIVITY = 2;

    @Nullable
    private Object data;

    @Nullable
    private Integer type;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HomeRoomBannerData() {
        this(r0, r0, 3, r0);
        Integer num = null;
    }

    public static /* synthetic */ HomeRoomBannerData copy$default(HomeRoomBannerData homeRoomBannerData, Integer num, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            num = homeRoomBannerData.type;
        }
        if ((i & 2) != 0) {
            obj = homeRoomBannerData.data;
        }
        return homeRoomBannerData.copy(num, obj);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    @NotNull
    public final HomeRoomBannerData copy(@Nullable Integer type, @Nullable Object data) {
        return new HomeRoomBannerData(type, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeRoomBannerData)) {
            return false;
        }
        HomeRoomBannerData homeRoomBannerData = (HomeRoomBannerData) other;
        return Intrinsics.areEqual(this.type, homeRoomBannerData.type) && Intrinsics.areEqual(this.data, homeRoomBannerData.data);
    }

    @Nullable
    public final Object getData() {
        return this.data;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer num = this.type;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Object obj = this.data;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public final void setData(@Nullable Object obj) {
        this.data = obj;
    }

    public final void setType(@Nullable Integer num) {
        this.type = num;
    }

    @NotNull
    public String toString() {
        return "HomeRoomBannerData(type=" + this.type + ", data=" + this.data + ")";
    }

    public HomeRoomBannerData(@Nullable Integer num, @Nullable Object obj) {
        this.type = num;
        this.data = obj;
    }

    public /* synthetic */ HomeRoomBannerData(Integer num, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : obj);
    }
}
