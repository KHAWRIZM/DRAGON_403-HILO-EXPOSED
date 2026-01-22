package com.qiahao.base_common.player;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/qiahao/base_common/player/PlayerState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "BUFFERING", "READY", "ENDED", "STARTED", "PAUSED", "COMPLETED", "ERROR", "END", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PlayerState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlayerState[] $VALUES;
    public static final PlayerState IDLE = new PlayerState("IDLE", 0);
    public static final PlayerState BUFFERING = new PlayerState("BUFFERING", 1);
    public static final PlayerState READY = new PlayerState("READY", 2);
    public static final PlayerState ENDED = new PlayerState("ENDED", 3);

    @Deprecated(message = "新版本播放器已经移除此状态，还有旧代码在使用。")
    public static final PlayerState STARTED = new PlayerState("STARTED", 4);

    @Deprecated(message = "新版本播放器已经移除此状态，还有旧代码在使用。")
    public static final PlayerState PAUSED = new PlayerState("PAUSED", 5);

    @Deprecated(message = "新版本播放器已经移除此状态，还有旧代码在使用。")
    public static final PlayerState COMPLETED = new PlayerState("COMPLETED", 6);

    @Deprecated(message = "新版本播放器已经移除此状态，还有旧代码在使用。")
    public static final PlayerState ERROR = new PlayerState("ERROR", 7);

    @Deprecated(message = "新版本播放器已经移除此状态，还有旧代码在使用。")
    public static final PlayerState END = new PlayerState("END", 8);

    private static final /* synthetic */ PlayerState[] $values() {
        return new PlayerState[]{IDLE, BUFFERING, READY, ENDED, STARTED, PAUSED, COMPLETED, ERROR, END};
    }

    static {
        PlayerState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private PlayerState(String str, int i10) {
    }

    @NotNull
    public static EnumEntries<PlayerState> getEntries() {
        return $ENTRIES;
    }

    public static PlayerState valueOf(String str) {
        return (PlayerState) Enum.valueOf(PlayerState.class, str);
    }

    public static PlayerState[] values() {
        return (PlayerState[]) $VALUES.clone();
    }
}
