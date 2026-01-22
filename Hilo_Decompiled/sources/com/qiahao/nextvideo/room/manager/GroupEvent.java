package com.qiahao.nextvideo.room.manager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/room/manager/GroupEvent;", "", "<init>", "()V", "mEventId", "", "getMEventId", "()I", "setMEventId", "(I)V", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "leaveGroup", "groupId", "enterRoom", "blockRoomToLocal", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupEvent {
    public static final int GROUP_BLOCK_ROOM = 14;
    public static final int GROUP_ENTER_ROOM = 13;
    public static final int GROUP_LEAVE_GROUP = 3;
    private int mEventId;

    @Nullable
    private String mGroupId;

    @NotNull
    public final GroupEvent blockRoomToLocal(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.mEventId = 14;
        this.mGroupId = groupId;
        return this;
    }

    @NotNull
    public final GroupEvent enterRoom(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.mEventId = 13;
        this.mGroupId = groupId;
        return this;
    }

    public final int getMEventId() {
        return this.mEventId;
    }

    @Nullable
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @NotNull
    public final GroupEvent leaveGroup(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.mEventId = 3;
        this.mGroupId = groupId;
        return this;
    }

    public final void setMEventId(int i) {
        this.mEventId = i;
    }

    public final void setMGroupId(@Nullable String str) {
        this.mGroupId = str;
    }
}
