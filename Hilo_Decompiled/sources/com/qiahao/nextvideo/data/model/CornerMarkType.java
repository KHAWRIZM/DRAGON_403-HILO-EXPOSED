package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CornerMarkType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "NONE", "HOT", "NEW", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CornerMarkType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CornerMarkType[] $VALUES;
    private final int type;
    public static final CornerMarkType NONE = new CornerMarkType("NONE", 0, 0);
    public static final CornerMarkType HOT = new CornerMarkType("HOT", 1, 1);
    public static final CornerMarkType NEW = new CornerMarkType("NEW", 2, 2);

    private static final /* synthetic */ CornerMarkType[] $values() {
        return new CornerMarkType[]{NONE, HOT, NEW};
    }

    static {
        CornerMarkType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private CornerMarkType(String str, int i, int i2) {
        this.type = i2;
    }

    @NotNull
    public static EnumEntries<CornerMarkType> getEntries() {
        return $ENTRIES;
    }

    public static CornerMarkType valueOf(String str) {
        return (CornerMarkType) Enum.valueOf(CornerMarkType.class, str);
    }

    public static CornerMarkType[] values() {
        return (CornerMarkType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }
}
