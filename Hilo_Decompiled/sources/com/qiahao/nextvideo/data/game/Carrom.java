package com.qiahao.nextvideo.data.game;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0003J3\u0010\r\u001a\u00020\u00002(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R:\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/game/Carrom;", "", "players", "Ljava/util/HashMap;", "", "Lcom/qiahao/nextvideo/data/game/CarromConfiguration;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getPlayers", "()Ljava/util/HashMap;", "setPlayers", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Carrom {

    @Nullable
    private HashMap<String, CarromConfiguration> players;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Carrom() {
        this(r0, 1, r0);
        HashMap hashMap = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Carrom copy$default(Carrom carrom, HashMap hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            hashMap = carrom.players;
        }
        return carrom.copy(hashMap);
    }

    @Nullable
    public final HashMap<String, CarromConfiguration> component1() {
        return this.players;
    }

    @NotNull
    public final Carrom copy(@Nullable HashMap<String, CarromConfiguration> players) {
        return new Carrom(players);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Carrom) && Intrinsics.areEqual(this.players, ((Carrom) other).players);
    }

    @Nullable
    public final HashMap<String, CarromConfiguration> getPlayers() {
        return this.players;
    }

    public int hashCode() {
        HashMap<String, CarromConfiguration> hashMap = this.players;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.hashCode();
    }

    public final void setPlayers(@Nullable HashMap<String, CarromConfiguration> hashMap) {
        this.players = hashMap;
    }

    @NotNull
    public String toString() {
        return "Carrom(players=" + this.players + ")";
    }

    public Carrom(@Nullable HashMap<String, CarromConfiguration> hashMap) {
        this.players = hashMap;
    }

    public /* synthetic */ Carrom(HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : hashMap);
    }
}
