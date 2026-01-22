package com.qiahao.base_common.model.overlay;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/qiahao/base_common/model/overlay/Location;", "", "<init>", "(Ljava/lang/String;I)V", "COVER", "TO_LEFT", "TO_RIGHT", "TO_TOP", "TO_BOTTOM", "ALIGN_TOP", "ALIGN_BOTTOM", "ALIGN_LEFT", "ALIGN_RIGHT", "ALIGN_PARENT_RIGHT", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class Location {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Location[] $VALUES;
    public static final Location COVER = new Location("COVER", 0);
    public static final Location TO_LEFT = new Location("TO_LEFT", 1);
    public static final Location TO_RIGHT = new Location("TO_RIGHT", 2);
    public static final Location TO_TOP = new Location("TO_TOP", 3);
    public static final Location TO_BOTTOM = new Location("TO_BOTTOM", 4);
    public static final Location ALIGN_TOP = new Location("ALIGN_TOP", 5);
    public static final Location ALIGN_BOTTOM = new Location("ALIGN_BOTTOM", 6);
    public static final Location ALIGN_LEFT = new Location("ALIGN_LEFT", 7);
    public static final Location ALIGN_RIGHT = new Location("ALIGN_RIGHT", 8);
    public static final Location ALIGN_PARENT_RIGHT = new Location("ALIGN_PARENT_RIGHT", 9);

    private static final /* synthetic */ Location[] $values() {
        return new Location[]{COVER, TO_LEFT, TO_RIGHT, TO_TOP, TO_BOTTOM, ALIGN_TOP, ALIGN_BOTTOM, ALIGN_LEFT, ALIGN_RIGHT, ALIGN_PARENT_RIGHT};
    }

    static {
        Location[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Location(String str, int i10) {
    }

    @NotNull
    public static EnumEntries<Location> getEntries() {
        return $ENTRIES;
    }

    public static Location valueOf(String str) {
        return (Location) Enum.valueOf(Location.class, str);
    }

    public static Location[] values() {
        return (Location[]) $VALUES.clone();
    }
}
