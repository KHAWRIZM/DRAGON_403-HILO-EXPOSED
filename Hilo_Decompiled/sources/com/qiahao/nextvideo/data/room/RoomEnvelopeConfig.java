package com.qiahao.nextvideo.data.room;

import com.qiahao.nextvideo.ui.home.medal.MedalActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/room/RoomEnvelopeConfig;", "", MedalActivity.TYPE_ROOM, "Lcom/qiahao/nextvideo/data/room/RoomEnvelopeData;", "world", "<init>", "(Lcom/qiahao/nextvideo/data/room/RoomEnvelopeData;Lcom/qiahao/nextvideo/data/room/RoomEnvelopeData;)V", "getRoom", "()Lcom/qiahao/nextvideo/data/room/RoomEnvelopeData;", "setRoom", "(Lcom/qiahao/nextvideo/data/room/RoomEnvelopeData;)V", "getWorld", "setWorld", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RoomEnvelopeConfig {

    @Nullable
    private RoomEnvelopeData room;

    @Nullable
    private RoomEnvelopeData world;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoomEnvelopeConfig() {
        this(r0, r0, 3, r0);
        RoomEnvelopeData roomEnvelopeData = null;
    }

    public static /* synthetic */ RoomEnvelopeConfig copy$default(RoomEnvelopeConfig roomEnvelopeConfig, RoomEnvelopeData roomEnvelopeData, RoomEnvelopeData roomEnvelopeData2, int i, Object obj) {
        if ((i & 1) != 0) {
            roomEnvelopeData = roomEnvelopeConfig.room;
        }
        if ((i & 2) != 0) {
            roomEnvelopeData2 = roomEnvelopeConfig.world;
        }
        return roomEnvelopeConfig.copy(roomEnvelopeData, roomEnvelopeData2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final RoomEnvelopeData getRoom() {
        return this.room;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final RoomEnvelopeData getWorld() {
        return this.world;
    }

    @NotNull
    public final RoomEnvelopeConfig copy(@Nullable RoomEnvelopeData room, @Nullable RoomEnvelopeData world) {
        return new RoomEnvelopeConfig(room, world);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomEnvelopeConfig)) {
            return false;
        }
        RoomEnvelopeConfig roomEnvelopeConfig = (RoomEnvelopeConfig) other;
        return Intrinsics.areEqual(this.room, roomEnvelopeConfig.room) && Intrinsics.areEqual(this.world, roomEnvelopeConfig.world);
    }

    @Nullable
    public final RoomEnvelopeData getRoom() {
        return this.room;
    }

    @Nullable
    public final RoomEnvelopeData getWorld() {
        return this.world;
    }

    public int hashCode() {
        RoomEnvelopeData roomEnvelopeData = this.room;
        int hashCode = (roomEnvelopeData == null ? 0 : roomEnvelopeData.hashCode()) * 31;
        RoomEnvelopeData roomEnvelopeData2 = this.world;
        return hashCode + (roomEnvelopeData2 != null ? roomEnvelopeData2.hashCode() : 0);
    }

    public final void setRoom(@Nullable RoomEnvelopeData roomEnvelopeData) {
        this.room = roomEnvelopeData;
    }

    public final void setWorld(@Nullable RoomEnvelopeData roomEnvelopeData) {
        this.world = roomEnvelopeData;
    }

    @NotNull
    public String toString() {
        return "RoomEnvelopeConfig(room=" + this.room + ", world=" + this.world + ")";
    }

    public RoomEnvelopeConfig(@Nullable RoomEnvelopeData roomEnvelopeData, @Nullable RoomEnvelopeData roomEnvelopeData2) {
        this.room = roomEnvelopeData;
        this.world = roomEnvelopeData2;
    }

    public /* synthetic */ RoomEnvelopeConfig(RoomEnvelopeData roomEnvelopeData, RoomEnvelopeData roomEnvelopeData2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : roomEnvelopeData, (i & 2) != 0 ? null : roomEnvelopeData2);
    }
}
