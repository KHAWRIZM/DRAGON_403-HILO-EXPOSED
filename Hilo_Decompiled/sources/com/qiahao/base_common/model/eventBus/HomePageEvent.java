package com.qiahao.base_common.model.eventBus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/qiahao/base_common/model/eventBus/HomePageEvent;", "", "onePosition", "", "twoPosition", "<init>", "(II)V", "getOnePosition", "()I", "setOnePosition", "(I)V", "getTwoPosition", "setTwoPosition", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class HomePageEvent {
    public static final int HOME_GAME = 2;
    public static final int HOME_GROUP = 1;
    public static final int HOME_MATCH = 0;
    public static final int HOME_MESSAGE = 4;
    public static final int HOME_PLAZA = 3;
    private int onePosition;
    private int twoPosition;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HomePageEvent() {
        this(r2, r2, 3, null);
        int i10 = 0;
    }

    public static /* synthetic */ HomePageEvent copy$default(HomePageEvent homePageEvent, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = homePageEvent.onePosition;
        }
        if ((i12 & 2) != 0) {
            i11 = homePageEvent.twoPosition;
        }
        return homePageEvent.copy(i10, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getOnePosition() {
        return this.onePosition;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTwoPosition() {
        return this.twoPosition;
    }

    @NotNull
    public final HomePageEvent copy(int onePosition, int twoPosition) {
        return new HomePageEvent(onePosition, twoPosition);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomePageEvent)) {
            return false;
        }
        HomePageEvent homePageEvent = (HomePageEvent) other;
        return this.onePosition == homePageEvent.onePosition && this.twoPosition == homePageEvent.twoPosition;
    }

    public final int getOnePosition() {
        return this.onePosition;
    }

    public final int getTwoPosition() {
        return this.twoPosition;
    }

    public int hashCode() {
        return (this.onePosition * 31) + this.twoPosition;
    }

    public final void setOnePosition(int i10) {
        this.onePosition = i10;
    }

    public final void setTwoPosition(int i10) {
        this.twoPosition = i10;
    }

    @NotNull
    public String toString() {
        return "HomePageEvent(onePosition=" + this.onePosition + ", twoPosition=" + this.twoPosition + ")";
    }

    public HomePageEvent(int i10, int i11) {
        this.onePosition = i10;
        this.twoPosition = i11;
    }

    public /* synthetic */ HomePageEvent(int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? -1 : i10, (i12 & 2) != 0 ? -1 : i11);
    }
}
