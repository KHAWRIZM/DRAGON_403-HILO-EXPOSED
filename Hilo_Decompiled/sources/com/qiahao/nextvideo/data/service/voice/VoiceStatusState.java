package com.qiahao.nextvideo.data.service.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceStatusState;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "LOADING", "PLAYING", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VoiceStatusState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VoiceStatusState[] $VALUES;
    public static final VoiceStatusState NONE = new VoiceStatusState("NONE", 0);
    public static final VoiceStatusState LOADING = new VoiceStatusState("LOADING", 1);
    public static final VoiceStatusState PLAYING = new VoiceStatusState("PLAYING", 2);

    private static final /* synthetic */ VoiceStatusState[] $values() {
        return new VoiceStatusState[]{NONE, LOADING, PLAYING};
    }

    static {
        VoiceStatusState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private VoiceStatusState(String str, int i) {
    }

    @NotNull
    public static EnumEntries<VoiceStatusState> getEntries() {
        return $ENTRIES;
    }

    public static VoiceStatusState valueOf(String str) {
        return (VoiceStatusState) Enum.valueOf(VoiceStatusState.class, str);
    }

    public static VoiceStatusState[] values() {
        return (VoiceStatusState[]) $VALUES.clone();
    }
}
