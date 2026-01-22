package com.qiahao.base_common.utils;

import com.google.android.gms.stats.CodePackage;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/base_common/utils/MMKVID;", "", "<init>", "(Ljava/lang/String;I)V", CodePackage.COMMON, "USER", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MMKVID {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MMKVID[] $VALUES;
    public static final MMKVID COMMON = new MMKVID(CodePackage.COMMON, 0);
    public static final MMKVID USER = new MMKVID("USER", 1);

    private static final /* synthetic */ MMKVID[] $values() {
        return new MMKVID[]{COMMON, USER};
    }

    static {
        MMKVID[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private MMKVID(String str, int i10) {
    }

    @NotNull
    public static EnumEntries<MMKVID> getEntries() {
        return $ENTRIES;
    }

    public static MMKVID valueOf(String str) {
        return (MMKVID) Enum.valueOf(MMKVID.class, str);
    }

    public static MMKVID[] values() {
        return (MMKVID[]) $VALUES.clone();
    }
}
