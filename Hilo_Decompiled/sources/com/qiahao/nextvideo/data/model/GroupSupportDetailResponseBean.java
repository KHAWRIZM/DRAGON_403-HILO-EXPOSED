package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003J\u008b\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0001J\u0013\u00105\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0005HÖ\u0001J\t\u00108\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupSupportDetailResponseBean;", "", "currentConsume", "", "currentCount", "", "groupId", "", "isDispatched", "", "lastConsume", "lastCount", "profitAllocator", "Lcom/qiahao/nextvideo/data/model/ProfitAllocator;", "supportLevel", "supporterLimit", "currentSupportLevel", "remainSecond", "supporters", "", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "<init>", "(JILjava/lang/String;ZJILcom/qiahao/nextvideo/data/model/ProfitAllocator;Ljava/lang/String;ILjava/lang/String;JLjava/util/List;)V", "getCurrentConsume", "()J", "getCurrentCount", "()I", "getGroupId", "()Ljava/lang/String;", "()Z", "getLastConsume", "getLastCount", "getProfitAllocator", "()Lcom/qiahao/nextvideo/data/model/ProfitAllocator;", "getSupportLevel", "getSupporterLimit", "getCurrentSupportLevel", "getRemainSecond", "getSupporters", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupSupportDetailResponseBean {
    private final long currentConsume;
    private final int currentCount;

    @NotNull
    private final String currentSupportLevel;

    @Nullable
    private final String groupId;
    private final boolean isDispatched;
    private final long lastConsume;
    private final int lastCount;

    @NotNull
    private final ProfitAllocator profitAllocator;
    private final long remainSecond;

    @NotNull
    private final String supportLevel;
    private final int supporterLimit;

    @Nullable
    private final List<MemberBean> supporters;

    public GroupSupportDetailResponseBean(long j, int i, @Nullable String str, boolean z, long j2, int i2, @NotNull ProfitAllocator profitAllocator, @NotNull String str2, int i3, @NotNull String str3, long j3, @Nullable List<MemberBean> list) {
        Intrinsics.checkNotNullParameter(profitAllocator, "profitAllocator");
        Intrinsics.checkNotNullParameter(str2, "supportLevel");
        Intrinsics.checkNotNullParameter(str3, "currentSupportLevel");
        this.currentConsume = j;
        this.currentCount = i;
        this.groupId = str;
        this.isDispatched = z;
        this.lastConsume = j2;
        this.lastCount = i2;
        this.profitAllocator = profitAllocator;
        this.supportLevel = str2;
        this.supporterLimit = i3;
        this.currentSupportLevel = str3;
        this.remainSecond = j3;
        this.supporters = list;
    }

    /* renamed from: component1, reason: from getter */
    public final long getCurrentConsume() {
        return this.currentConsume;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getCurrentSupportLevel() {
        return this.currentSupportLevel;
    }

    /* renamed from: component11, reason: from getter */
    public final long getRemainSecond() {
        return this.remainSecond;
    }

    @Nullable
    public final List<MemberBean> component12() {
        return this.supporters;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCurrentCount() {
        return this.currentCount;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsDispatched() {
        return this.isDispatched;
    }

    /* renamed from: component5, reason: from getter */
    public final long getLastConsume() {
        return this.lastConsume;
    }

    /* renamed from: component6, reason: from getter */
    public final int getLastCount() {
        return this.lastCount;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final ProfitAllocator getProfitAllocator() {
        return this.profitAllocator;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getSupportLevel() {
        return this.supportLevel;
    }

    /* renamed from: component9, reason: from getter */
    public final int getSupporterLimit() {
        return this.supporterLimit;
    }

    @NotNull
    public final GroupSupportDetailResponseBean copy(long currentConsume, int currentCount, @Nullable String groupId, boolean isDispatched, long lastConsume, int lastCount, @NotNull ProfitAllocator profitAllocator, @NotNull String supportLevel, int supporterLimit, @NotNull String currentSupportLevel, long remainSecond, @Nullable List<MemberBean> supporters) {
        Intrinsics.checkNotNullParameter(profitAllocator, "profitAllocator");
        Intrinsics.checkNotNullParameter(supportLevel, "supportLevel");
        Intrinsics.checkNotNullParameter(currentSupportLevel, "currentSupportLevel");
        return new GroupSupportDetailResponseBean(currentConsume, currentCount, groupId, isDispatched, lastConsume, lastCount, profitAllocator, supportLevel, supporterLimit, currentSupportLevel, remainSecond, supporters);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupSupportDetailResponseBean)) {
            return false;
        }
        GroupSupportDetailResponseBean groupSupportDetailResponseBean = (GroupSupportDetailResponseBean) other;
        return this.currentConsume == groupSupportDetailResponseBean.currentConsume && this.currentCount == groupSupportDetailResponseBean.currentCount && Intrinsics.areEqual(this.groupId, groupSupportDetailResponseBean.groupId) && this.isDispatched == groupSupportDetailResponseBean.isDispatched && this.lastConsume == groupSupportDetailResponseBean.lastConsume && this.lastCount == groupSupportDetailResponseBean.lastCount && Intrinsics.areEqual(this.profitAllocator, groupSupportDetailResponseBean.profitAllocator) && Intrinsics.areEqual(this.supportLevel, groupSupportDetailResponseBean.supportLevel) && this.supporterLimit == groupSupportDetailResponseBean.supporterLimit && Intrinsics.areEqual(this.currentSupportLevel, groupSupportDetailResponseBean.currentSupportLevel) && this.remainSecond == groupSupportDetailResponseBean.remainSecond && Intrinsics.areEqual(this.supporters, groupSupportDetailResponseBean.supporters);
    }

    public final long getCurrentConsume() {
        return this.currentConsume;
    }

    public final int getCurrentCount() {
        return this.currentCount;
    }

    @NotNull
    public final String getCurrentSupportLevel() {
        return this.currentSupportLevel;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    public final long getLastConsume() {
        return this.lastConsume;
    }

    public final int getLastCount() {
        return this.lastCount;
    }

    @NotNull
    public final ProfitAllocator getProfitAllocator() {
        return this.profitAllocator;
    }

    public final long getRemainSecond() {
        return this.remainSecond;
    }

    @NotNull
    public final String getSupportLevel() {
        return this.supportLevel;
    }

    public final int getSupporterLimit() {
        return this.supporterLimit;
    }

    @Nullable
    public final List<MemberBean> getSupporters() {
        return this.supporters;
    }

    public int hashCode() {
        int a = ((c.a(this.currentConsume) * 31) + this.currentCount) * 31;
        String str = this.groupId;
        int hashCode = (((((((((((((((((a + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.isDispatched)) * 31) + c.a(this.lastConsume)) * 31) + this.lastCount) * 31) + this.profitAllocator.hashCode()) * 31) + this.supportLevel.hashCode()) * 31) + this.supporterLimit) * 31) + this.currentSupportLevel.hashCode()) * 31) + c.a(this.remainSecond)) * 31;
        List<MemberBean> list = this.supporters;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean isDispatched() {
        return this.isDispatched;
    }

    @NotNull
    public String toString() {
        return "GroupSupportDetailResponseBean(currentConsume=" + this.currentConsume + ", currentCount=" + this.currentCount + ", groupId=" + this.groupId + ", isDispatched=" + this.isDispatched + ", lastConsume=" + this.lastConsume + ", lastCount=" + this.lastCount + ", profitAllocator=" + this.profitAllocator + ", supportLevel=" + this.supportLevel + ", supporterLimit=" + this.supporterLimit + ", currentSupportLevel=" + this.currentSupportLevel + ", remainSecond=" + this.remainSecond + ", supporters=" + this.supporters + ")";
    }
}
