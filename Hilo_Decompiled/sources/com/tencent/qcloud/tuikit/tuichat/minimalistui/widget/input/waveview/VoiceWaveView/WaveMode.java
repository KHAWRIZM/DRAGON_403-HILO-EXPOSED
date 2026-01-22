package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.waveview.VoiceWaveView;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/WaveMode;", "", "<init>", "(Ljava/lang/String;I)V", "UP_DOWN", "LEFT_RIGHT", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class WaveMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WaveMode[] $VALUES;
    public static final WaveMode UP_DOWN = new WaveMode("UP_DOWN", 0);
    public static final WaveMode LEFT_RIGHT = new WaveMode("LEFT_RIGHT", 1);

    private static final /* synthetic */ WaveMode[] $values() {
        return new WaveMode[]{UP_DOWN, LEFT_RIGHT};
    }

    static {
        WaveMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private WaveMode(String str, int i) {
    }

    @NotNull
    public static EnumEntries<WaveMode> getEntries() {
        return $ENTRIES;
    }

    public static WaveMode valueOf(String str) {
        return (WaveMode) Enum.valueOf(WaveMode.class, str);
    }

    public static WaveMode[] values() {
        return (WaveMode[]) $VALUES.clone();
    }
}
