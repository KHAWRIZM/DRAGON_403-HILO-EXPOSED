package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MyStake;", "", "fruitId", "", "stake", "", "<init>", "(IJ)V", "getFruitId", "()I", "setFruitId", "(I)V", "getStake", "()J", "setStake", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MyStake {
    private int fruitId;
    private long stake;

    public MyStake(int i, long j) {
        this.fruitId = i;
        this.stake = j;
    }

    public static /* synthetic */ MyStake copy$default(MyStake myStake, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = myStake.fruitId;
        }
        if ((i2 & 2) != 0) {
            j = myStake.stake;
        }
        return myStake.copy(i, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFruitId() {
        return this.fruitId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStake() {
        return this.stake;
    }

    @NotNull
    public final MyStake copy(int fruitId, long stake) {
        return new MyStake(fruitId, stake);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyStake)) {
            return false;
        }
        MyStake myStake = (MyStake) other;
        return this.fruitId == myStake.fruitId && this.stake == myStake.stake;
    }

    public final int getFruitId() {
        return this.fruitId;
    }

    public final long getStake() {
        return this.stake;
    }

    public int hashCode() {
        return (this.fruitId * 31) + c.a(this.stake);
    }

    public final void setFruitId(int i) {
        this.fruitId = i;
    }

    public final void setStake(long j) {
        this.stake = j;
    }

    @NotNull
    public String toString() {
        return "MyStake(fruitId=" + this.fruitId + ", stake=" + this.stake + ")";
    }
}
