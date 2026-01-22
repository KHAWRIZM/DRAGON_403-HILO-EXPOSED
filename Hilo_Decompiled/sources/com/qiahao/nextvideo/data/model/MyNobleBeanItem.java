package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MyNobleBeanItem;", "", "endTime", "", "level", "", "remainTime", "price", "<init>", "(JIJI)V", "getEndTime", "()J", "getLevel", "()I", "getRemainTime", "getPrice", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MyNobleBeanItem {
    private final long endTime;
    private final int level;
    private final int price;
    private final long remainTime;

    public MyNobleBeanItem(long j, int i, long j2, int i2) {
        this.endTime = j;
        this.level = i;
        this.remainTime = j2;
        this.price = i2;
    }

    public static /* synthetic */ MyNobleBeanItem copy$default(MyNobleBeanItem myNobleBeanItem, long j, int i, long j2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = myNobleBeanItem.endTime;
        }
        long j3 = j;
        if ((i3 & 2) != 0) {
            i = myNobleBeanItem.level;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            j2 = myNobleBeanItem.remainTime;
        }
        long j4 = j2;
        if ((i3 & 8) != 0) {
            i2 = myNobleBeanItem.price;
        }
        return myNobleBeanItem.copy(j3, i4, j4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* renamed from: component3, reason: from getter */
    public final long getRemainTime() {
        return this.remainTime;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    @NotNull
    public final MyNobleBeanItem copy(long endTime, int level, long remainTime, int price) {
        return new MyNobleBeanItem(endTime, level, remainTime, price);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyNobleBeanItem)) {
            return false;
        }
        MyNobleBeanItem myNobleBeanItem = (MyNobleBeanItem) other;
        return this.endTime == myNobleBeanItem.endTime && this.level == myNobleBeanItem.level && this.remainTime == myNobleBeanItem.remainTime && this.price == myNobleBeanItem.price;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getPrice() {
        return this.price;
    }

    public final long getRemainTime() {
        return this.remainTime;
    }

    public int hashCode() {
        return (((((c.a(this.endTime) * 31) + this.level) * 31) + c.a(this.remainTime)) * 31) + this.price;
    }

    @NotNull
    public String toString() {
        return "MyNobleBeanItem(endTime=" + this.endTime + ", level=" + this.level + ", remainTime=" + this.remainTime + ", price=" + this.price + ")";
    }
}
