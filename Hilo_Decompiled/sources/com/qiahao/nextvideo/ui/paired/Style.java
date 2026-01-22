package com.qiahao.nextvideo.ui.paired;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/ui/paired/Style;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "CONNECTING", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Style {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Style[] $VALUES;
    public static final Style LOADING = new Style("LOADING", 0);
    public static final Style CONNECTING = new Style("CONNECTING", 1);

    private static final /* synthetic */ Style[] $values() {
        return new Style[]{LOADING, CONNECTING};
    }

    static {
        Style[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Style(String str, int i) {
    }

    @NotNull
    public static EnumEntries<Style> getEntries() {
        return $ENTRIES;
    }

    public static Style valueOf(String str) {
        return (Style) Enum.valueOf(Style.class, str);
    }

    public static Style[] values() {
        return (Style[]) $VALUES.clone();
    }
}
