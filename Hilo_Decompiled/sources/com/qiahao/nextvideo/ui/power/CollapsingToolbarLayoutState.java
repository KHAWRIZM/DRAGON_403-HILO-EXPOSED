package com.qiahao.nextvideo.ui.power;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/CollapsingToolbarLayoutState;", "", "<init>", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "INTERNEDIATE", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CollapsingToolbarLayoutState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CollapsingToolbarLayoutState[] $VALUES;
    public static final CollapsingToolbarLayoutState EXPANDED = new CollapsingToolbarLayoutState("EXPANDED", 0);
    public static final CollapsingToolbarLayoutState COLLAPSED = new CollapsingToolbarLayoutState("COLLAPSED", 1);
    public static final CollapsingToolbarLayoutState INTERNEDIATE = new CollapsingToolbarLayoutState("INTERNEDIATE", 2);

    private static final /* synthetic */ CollapsingToolbarLayoutState[] $values() {
        return new CollapsingToolbarLayoutState[]{EXPANDED, COLLAPSED, INTERNEDIATE};
    }

    static {
        CollapsingToolbarLayoutState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private CollapsingToolbarLayoutState(String str, int i) {
    }

    @NotNull
    public static EnumEntries<CollapsingToolbarLayoutState> getEntries() {
        return $ENTRIES;
    }

    public static CollapsingToolbarLayoutState valueOf(String str) {
        return (CollapsingToolbarLayoutState) Enum.valueOf(CollapsingToolbarLayoutState.class, str);
    }

    public static CollapsingToolbarLayoutState[] values() {
        return (CollapsingToolbarLayoutState[]) $VALUES.clone();
    }
}
