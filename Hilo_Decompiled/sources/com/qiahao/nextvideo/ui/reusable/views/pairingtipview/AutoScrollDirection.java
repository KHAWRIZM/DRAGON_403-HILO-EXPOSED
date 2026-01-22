package com.qiahao.nextvideo.ui.reusable.views.pairingtipview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/AutoScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AutoScrollDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AutoScrollDirection[] $VALUES;
    public static final AutoScrollDirection LEFT = new AutoScrollDirection("LEFT", 0);
    public static final AutoScrollDirection RIGHT = new AutoScrollDirection("RIGHT", 1);

    private static final /* synthetic */ AutoScrollDirection[] $values() {
        return new AutoScrollDirection[]{LEFT, RIGHT};
    }

    static {
        AutoScrollDirection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AutoScrollDirection(String str, int i) {
    }

    @NotNull
    public static EnumEntries<AutoScrollDirection> getEntries() {
        return $ENTRIES;
    }

    public static AutoScrollDirection valueOf(String str) {
        return (AutoScrollDirection) Enum.valueOf(AutoScrollDirection.class, str);
    }

    public static AutoScrollDirection[] values() {
        return (AutoScrollDirection[]) $VALUES.clone();
    }
}
