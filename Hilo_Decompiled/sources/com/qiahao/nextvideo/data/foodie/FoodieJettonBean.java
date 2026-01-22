package com.qiahao.nextvideo.data.foodie;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieJettonBean;", "", "index", "", "gold", "isSelect", "", "<init>", "(IIZ)V", "getIndex", "()I", "setIndex", "(I)V", "getGold", "setGold", "()Z", "setSelect", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class FoodieJettonBean {
    private int gold;
    private int index;
    private boolean isSelect;

    public FoodieJettonBean(int i, int i2, boolean z) {
        this.index = i;
        this.gold = i2;
        this.isSelect = z;
    }

    public static /* synthetic */ FoodieJettonBean copy$default(FoodieJettonBean foodieJettonBean, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = foodieJettonBean.index;
        }
        if ((i3 & 2) != 0) {
            i2 = foodieJettonBean.gold;
        }
        if ((i3 & 4) != 0) {
            z = foodieJettonBean.isSelect;
        }
        return foodieJettonBean.copy(i, i2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final int getGold() {
        return this.gold;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    @NotNull
    public final FoodieJettonBean copy(int index, int gold, boolean isSelect) {
        return new FoodieJettonBean(index, gold, isSelect);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FoodieJettonBean)) {
            return false;
        }
        FoodieJettonBean foodieJettonBean = (FoodieJettonBean) other;
        return this.index == foodieJettonBean.index && this.gold == foodieJettonBean.gold && this.isSelect == foodieJettonBean.isSelect;
    }

    public final int getGold() {
        return this.gold;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return (((this.index * 31) + this.gold) * 31) + a.a(this.isSelect);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setGold(int i) {
        this.gold = i;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    @NotNull
    public String toString() {
        return "FoodieJettonBean(index=" + this.index + ", gold=" + this.gold + ", isSelect=" + this.isSelect + ")";
    }

    public /* synthetic */ FoodieJettonBean(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
    }
}
