package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RandomPairChatroomConfig;", "", "name", "", "hasJoined", "", "<init>", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getHasJoined", "()Z", "setHasJoined", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RandomPairChatroomConfig {

    @c("has_joined")
    private boolean hasJoined;

    @NotNull
    @c("room_name")
    private final String name;

    public RandomPairChatroomConfig(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.hasJoined = z;
    }

    public static /* synthetic */ RandomPairChatroomConfig copy$default(RandomPairChatroomConfig randomPairChatroomConfig, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = randomPairChatroomConfig.name;
        }
        if ((i & 2) != 0) {
            z = randomPairChatroomConfig.hasJoined;
        }
        return randomPairChatroomConfig.copy(str, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasJoined() {
        return this.hasJoined;
    }

    @NotNull
    public final RandomPairChatroomConfig copy(@NotNull String name, boolean hasJoined) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new RandomPairChatroomConfig(name, hasJoined);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RandomPairChatroomConfig)) {
            return false;
        }
        RandomPairChatroomConfig randomPairChatroomConfig = (RandomPairChatroomConfig) other;
        return Intrinsics.areEqual(this.name, randomPairChatroomConfig.name) && this.hasJoined == randomPairChatroomConfig.hasJoined;
    }

    public final boolean getHasJoined() {
        return this.hasJoined;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + a.a(this.hasJoined);
    }

    public final void setHasJoined(boolean z) {
        this.hasJoined = z;
    }

    @NotNull
    public String toString() {
        return "RandomPairChatroomConfig(name=" + this.name + ", hasJoined=" + this.hasJoined + ")";
    }

    public /* synthetic */ RandomPairChatroomConfig(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }
}
