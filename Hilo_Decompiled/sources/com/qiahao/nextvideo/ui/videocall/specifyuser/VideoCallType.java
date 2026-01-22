package com.qiahao.nextvideo.ui.videocall.specifyuser;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/VideoCallType;", "", "<init>", "(Ljava/lang/String;I)V", "DIALED", "ANSWERED", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoCallType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoCallType[] $VALUES;
    public static final VideoCallType DIALED = new VideoCallType("DIALED", 0);
    public static final VideoCallType ANSWERED = new VideoCallType("ANSWERED", 1);

    private static final /* synthetic */ VideoCallType[] $values() {
        return new VideoCallType[]{DIALED, ANSWERED};
    }

    static {
        VideoCallType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private VideoCallType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<VideoCallType> getEntries() {
        return $ENTRIES;
    }

    public static VideoCallType valueOf(String str) {
        return (VideoCallType) Enum.valueOf(VideoCallType.class, str);
    }

    public static VideoCallType[] values() {
        return (VideoCallType[]) $VALUES.clone();
    }
}
