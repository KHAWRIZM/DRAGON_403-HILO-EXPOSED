package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003JK\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001a¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/data/model/LuckyWheelConfig;", "", "GroupId", "", "UserId", "", "autoRestart", "", "config", "", "Lcom/qiahao/nextvideo/data/model/LuckyWheelDiamondConfig;", "lastId", "selfJoin", "<init>", "(Ljava/lang/String;IZLjava/util/List;IZ)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getUserId", "()I", "setUserId", "(I)V", "getAutoRestart", "()Z", "setAutoRestart", "(Z)V", "getConfig", "()Ljava/util/List;", "setConfig", "(Ljava/util/List;)V", "getLastId", "setLastId", "getSelfJoin", "setSelfJoin", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LuckyWheelConfig {

    @NotNull
    private String GroupId;
    private int UserId;
    private boolean autoRestart;

    @NotNull
    private List<LuckyWheelDiamondConfig> config;
    private int lastId;
    private boolean selfJoin;

    public LuckyWheelConfig(@NotNull String str, int i, boolean z, @NotNull List<LuckyWheelDiamondConfig> list, int i2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "GroupId");
        Intrinsics.checkNotNullParameter(list, "config");
        this.GroupId = str;
        this.UserId = i;
        this.autoRestart = z;
        this.config = list;
        this.lastId = i2;
        this.selfJoin = z2;
    }

    public static /* synthetic */ LuckyWheelConfig copy$default(LuckyWheelConfig luckyWheelConfig, String str, int i, boolean z, List list, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = luckyWheelConfig.GroupId;
        }
        if ((i3 & 2) != 0) {
            i = luckyWheelConfig.UserId;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            z = luckyWheelConfig.autoRestart;
        }
        boolean z3 = z;
        if ((i3 & 8) != 0) {
            list = luckyWheelConfig.config;
        }
        List list2 = list;
        if ((i3 & 16) != 0) {
            i2 = luckyWheelConfig.lastId;
        }
        int i5 = i2;
        if ((i3 & 32) != 0) {
            z2 = luckyWheelConfig.selfJoin;
        }
        return luckyWheelConfig.copy(str, i4, z3, list2, i5, z2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.GroupId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUserId() {
        return this.UserId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAutoRestart() {
        return this.autoRestart;
    }

    @NotNull
    public final List<LuckyWheelDiamondConfig> component4() {
        return this.config;
    }

    /* renamed from: component5, reason: from getter */
    public final int getLastId() {
        return this.lastId;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getSelfJoin() {
        return this.selfJoin;
    }

    @NotNull
    public final LuckyWheelConfig copy(@NotNull String GroupId, int UserId, boolean autoRestart, @NotNull List<LuckyWheelDiamondConfig> config, int lastId, boolean selfJoin) {
        Intrinsics.checkNotNullParameter(GroupId, "GroupId");
        Intrinsics.checkNotNullParameter(config, "config");
        return new LuckyWheelConfig(GroupId, UserId, autoRestart, config, lastId, selfJoin);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LuckyWheelConfig)) {
            return false;
        }
        LuckyWheelConfig luckyWheelConfig = (LuckyWheelConfig) other;
        return Intrinsics.areEqual(this.GroupId, luckyWheelConfig.GroupId) && this.UserId == luckyWheelConfig.UserId && this.autoRestart == luckyWheelConfig.autoRestart && Intrinsics.areEqual(this.config, luckyWheelConfig.config) && this.lastId == luckyWheelConfig.lastId && this.selfJoin == luckyWheelConfig.selfJoin;
    }

    public final boolean getAutoRestart() {
        return this.autoRestart;
    }

    @NotNull
    public final List<LuckyWheelDiamondConfig> getConfig() {
        return this.config;
    }

    @NotNull
    public final String getGroupId() {
        return this.GroupId;
    }

    public final int getLastId() {
        return this.lastId;
    }

    public final boolean getSelfJoin() {
        return this.selfJoin;
    }

    public final int getUserId() {
        return this.UserId;
    }

    public int hashCode() {
        return (((((((((this.GroupId.hashCode() * 31) + this.UserId) * 31) + a.a(this.autoRestart)) * 31) + this.config.hashCode()) * 31) + this.lastId) * 31) + a.a(this.selfJoin);
    }

    public final void setAutoRestart(boolean z) {
        this.autoRestart = z;
    }

    public final void setConfig(@NotNull List<LuckyWheelDiamondConfig> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.config = list;
    }

    public final void setGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.GroupId = str;
    }

    public final void setLastId(int i) {
        this.lastId = i;
    }

    public final void setSelfJoin(boolean z) {
        this.selfJoin = z;
    }

    public final void setUserId(int i) {
        this.UserId = i;
    }

    @NotNull
    public String toString() {
        return "LuckyWheelConfig(GroupId=" + this.GroupId + ", UserId=" + this.UserId + ", autoRestart=" + this.autoRestart + ", config=" + this.config + ", lastId=" + this.lastId + ", selfJoin=" + this.selfJoin + ")";
    }
}
