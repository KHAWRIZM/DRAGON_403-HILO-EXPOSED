package com.qiahao.nextvideo.share;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/share/ShareManager;", "", "<init>", "()V", "mShareRoomGroup", "", "currentHasGet", "", "getCurrentHasGet", "()Z", "setCurrentHasGet", "(Z)V", "saveShareRoomGroup", "", "groupId", "hasShareRoomGroup", "clearShareRoomGroup", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ShareManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String IS_OPEN_ROOM_MIC = "isOpenRoomMic";

    @NotNull
    private static final String TAG = "MeetingRoomManager";

    @Nullable
    private static ShareManager instance;
    private boolean currentHasGet;

    @NotNull
    private String mShareRoomGroup = "";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/share/ShareManager$Companion;", "", "<init>", "()V", "TAG", "", "IS_OPEN_ROOM_MIC", "instance", "Lcom/qiahao/nextvideo/share/ShareManager;", "getInstance", "()Lcom/qiahao/nextvideo/share/ShareManager;", "get", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ShareManager getInstance() {
            if (ShareManager.instance == null) {
                ShareManager.instance = new ShareManager();
            }
            return ShareManager.instance;
        }

        @NotNull
        public final synchronized ShareManager get() {
            ShareManager companion;
            companion = getInstance();
            Intrinsics.checkNotNull(companion);
            return companion;
        }

        private Companion() {
        }
    }

    public final void clearShareRoomGroup() {
        this.mShareRoomGroup = "";
    }

    public final boolean getCurrentHasGet() {
        return this.currentHasGet;
    }

    @NotNull
    /* renamed from: hasShareRoomGroup, reason: from getter */
    public final String getMShareRoomGroup() {
        return this.mShareRoomGroup;
    }

    public final void saveShareRoomGroup(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.currentHasGet = true;
        this.mShareRoomGroup = groupId;
    }

    public final void setCurrentHasGet(boolean z) {
        this.currentHasGet = z;
    }
}
