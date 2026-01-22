package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.base_common.model.common.User;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u001d\u00106\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J\u001d\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\rHÆ\u0003J\t\u0010<\u001a\u00020\u000bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010?\u001a\u0004\u0018\u00010\u0014HÆ\u0003J´\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\rHÖ\u0001J\t\u0010E\u001a\u00020FHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R%\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR%\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010%R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/data/model/DealerDetailBean;", "", "availDiamond", "", "availDiamondPink", "config", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "Lkotlin/collections/ArrayList;", "configPink", "isdl", "", "tfCount", "", "tfDiamond", "tfMoney", "hasPt", "level", "hasSecond", "plr", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(JJLjava/util/ArrayList;Ljava/util/ArrayList;ZIJIZLjava/lang/Integer;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/User;)V", "getAvailDiamond", "()J", "getAvailDiamondPink", "getConfig", "()Ljava/util/ArrayList;", "getConfigPink", "getIsdl", "()Z", "getTfCount", "()I", "getTfDiamond", "getTfMoney", "getHasPt", "setHasPt", "(Z)V", "getLevel", "()Ljava/lang/Integer;", "setLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasSecond", "()Ljava/lang/Boolean;", "setHasSecond", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPlr", "()Lcom/qiahao/base_common/model/common/User;", "setPlr", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(JJLjava/util/ArrayList;Ljava/util/ArrayList;ZIJIZLjava/lang/Integer;Ljava/lang/Boolean;Lcom/qiahao/base_common/model/common/User;)Lcom/qiahao/nextvideo/data/model/DealerDetailBean;", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class DealerDetailBean {
    private final long availDiamond;
    private final long availDiamondPink;

    @Nullable
    private final ArrayList<DealerDiamondConfig> config;

    @Nullable
    private final ArrayList<DealerDiamondConfig> configPink;
    private boolean hasPt;

    @Nullable
    private Boolean hasSecond;
    private final boolean isdl;

    @Nullable
    private Integer level;

    @Nullable
    private User plr;
    private final int tfCount;
    private final long tfDiamond;
    private final int tfMoney;

    public DealerDetailBean(long j, long j2, @Nullable ArrayList<DealerDiamondConfig> arrayList, @Nullable ArrayList<DealerDiamondConfig> arrayList2, boolean z, int i, long j3, int i2, boolean z2, @Nullable Integer num, @Nullable Boolean bool, @Nullable User user) {
        this.availDiamond = j;
        this.availDiamondPink = j2;
        this.config = arrayList;
        this.configPink = arrayList2;
        this.isdl = z;
        this.tfCount = i;
        this.tfDiamond = j3;
        this.tfMoney = i2;
        this.hasPt = z2;
        this.level = num;
        this.hasSecond = bool;
        this.plr = user;
    }

    /* renamed from: component1, reason: from getter */
    public final long getAvailDiamond() {
        return this.availDiamond;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Boolean getHasSecond() {
        return this.hasSecond;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final User getPlr() {
        return this.plr;
    }

    /* renamed from: component2, reason: from getter */
    public final long getAvailDiamondPink() {
        return this.availDiamondPink;
    }

    @Nullable
    public final ArrayList<DealerDiamondConfig> component3() {
        return this.config;
    }

    @Nullable
    public final ArrayList<DealerDiamondConfig> component4() {
        return this.configPink;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsdl() {
        return this.isdl;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTfCount() {
        return this.tfCount;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTfDiamond() {
        return this.tfDiamond;
    }

    /* renamed from: component8, reason: from getter */
    public final int getTfMoney() {
        return this.tfMoney;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getHasPt() {
        return this.hasPt;
    }

    @NotNull
    public final DealerDetailBean copy(long availDiamond, long availDiamondPink, @Nullable ArrayList<DealerDiamondConfig> config, @Nullable ArrayList<DealerDiamondConfig> configPink, boolean isdl, int tfCount, long tfDiamond, int tfMoney, boolean hasPt, @Nullable Integer level, @Nullable Boolean hasSecond, @Nullable User plr) {
        return new DealerDetailBean(availDiamond, availDiamondPink, config, configPink, isdl, tfCount, tfDiamond, tfMoney, hasPt, level, hasSecond, plr);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DealerDetailBean)) {
            return false;
        }
        DealerDetailBean dealerDetailBean = (DealerDetailBean) other;
        return this.availDiamond == dealerDetailBean.availDiamond && this.availDiamondPink == dealerDetailBean.availDiamondPink && Intrinsics.areEqual(this.config, dealerDetailBean.config) && Intrinsics.areEqual(this.configPink, dealerDetailBean.configPink) && this.isdl == dealerDetailBean.isdl && this.tfCount == dealerDetailBean.tfCount && this.tfDiamond == dealerDetailBean.tfDiamond && this.tfMoney == dealerDetailBean.tfMoney && this.hasPt == dealerDetailBean.hasPt && Intrinsics.areEqual(this.level, dealerDetailBean.level) && Intrinsics.areEqual(this.hasSecond, dealerDetailBean.hasSecond) && Intrinsics.areEqual(this.plr, dealerDetailBean.plr);
    }

    public final long getAvailDiamond() {
        return this.availDiamond;
    }

    public final long getAvailDiamondPink() {
        return this.availDiamondPink;
    }

    @Nullable
    public final ArrayList<DealerDiamondConfig> getConfig() {
        return this.config;
    }

    @Nullable
    public final ArrayList<DealerDiamondConfig> getConfigPink() {
        return this.configPink;
    }

    public final boolean getHasPt() {
        return this.hasPt;
    }

    @Nullable
    public final Boolean getHasSecond() {
        return this.hasSecond;
    }

    public final boolean getIsdl() {
        return this.isdl;
    }

    @Nullable
    public final Integer getLevel() {
        return this.level;
    }

    @Nullable
    public final User getPlr() {
        return this.plr;
    }

    public final int getTfCount() {
        return this.tfCount;
    }

    public final long getTfDiamond() {
        return this.tfDiamond;
    }

    public final int getTfMoney() {
        return this.tfMoney;
    }

    public int hashCode() {
        int a = ((c.a(this.availDiamond) * 31) + c.a(this.availDiamondPink)) * 31;
        ArrayList<DealerDiamondConfig> arrayList = this.config;
        int hashCode = (a + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<DealerDiamondConfig> arrayList2 = this.configPink;
        int hashCode2 = (((((((((((hashCode + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31) + a.a(this.isdl)) * 31) + this.tfCount) * 31) + c.a(this.tfDiamond)) * 31) + this.tfMoney) * 31) + a.a(this.hasPt)) * 31;
        Integer num = this.level;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.hasSecond;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        User user = this.plr;
        return hashCode4 + (user != null ? user.hashCode() : 0);
    }

    public final void setHasPt(boolean z) {
        this.hasPt = z;
    }

    public final void setHasSecond(@Nullable Boolean bool) {
        this.hasSecond = bool;
    }

    public final void setLevel(@Nullable Integer num) {
        this.level = num;
    }

    public final void setPlr(@Nullable User user) {
        this.plr = user;
    }

    @NotNull
    public String toString() {
        return "DealerDetailBean(availDiamond=" + this.availDiamond + ", availDiamondPink=" + this.availDiamondPink + ", config=" + this.config + ", configPink=" + this.configPink + ", isdl=" + this.isdl + ", tfCount=" + this.tfCount + ", tfDiamond=" + this.tfDiamond + ", tfMoney=" + this.tfMoney + ", hasPt=" + this.hasPt + ", level=" + this.level + ", hasSecond=" + this.hasSecond + ", plr=" + this.plr + ")";
    }

    public /* synthetic */ DealerDetailBean(long j, long j2, ArrayList arrayList, ArrayList arrayList2, boolean z, int i, long j3, int i2, boolean z2, Integer num, Boolean bool, User user, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, arrayList, arrayList2, z, i, j3, i2, z2, (i3 & 512) != 0 ? 0 : num, (i3 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? Boolean.FALSE : bool, (i3 & 2048) != 0 ? null : user);
    }
}
