package com.qiahao.nextvideo.ui.paired;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/paired/DoneType;", "", "<init>", "(Ljava/lang/String;I)V", "N_A", "PENDING_COUNTDOWN_DONE", "REMOTE_USER_REJECTED", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DoneType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DoneType[] $VALUES;
    public static final DoneType N_A = new DoneType("N_A", 0);
    public static final DoneType PENDING_COUNTDOWN_DONE = new DoneType("PENDING_COUNTDOWN_DONE", 1);
    public static final DoneType REMOTE_USER_REJECTED = new DoneType("REMOTE_USER_REJECTED", 2);

    private static final /* synthetic */ DoneType[] $values() {
        return new DoneType[]{N_A, PENDING_COUNTDOWN_DONE, REMOTE_USER_REJECTED};
    }

    static {
        DoneType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DoneType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<DoneType> getEntries() {
        return $ENTRIES;
    }

    public static DoneType valueOf(String str) {
        return (DoneType) Enum.valueOf(DoneType.class, str);
    }

    public static DoneType[] values() {
        return (DoneType[]) $VALUES.clone();
    }
}
