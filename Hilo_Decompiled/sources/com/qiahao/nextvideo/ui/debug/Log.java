package com.qiahao.nextvideo.ui.debug;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/Log;", "", "<init>", "(Ljava/lang/String;I)V", "I", "W", "E", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Log {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Log[] $VALUES;
    public static final Log I = new Log("I", 0);
    public static final Log W = new Log("W", 1);
    public static final Log E = new Log("E", 2);

    private static final /* synthetic */ Log[] $values() {
        return new Log[]{I, W, E};
    }

    static {
        Log[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Log(String str, int i) {
    }

    @NotNull
    public static EnumEntries<Log> getEntries() {
        return $ENTRIES;
    }

    public static Log valueOf(String str) {
        return (Log) Enum.valueOf(Log.class, str);
    }

    public static Log[] values() {
        return (Log[]) $VALUES.clone();
    }
}
