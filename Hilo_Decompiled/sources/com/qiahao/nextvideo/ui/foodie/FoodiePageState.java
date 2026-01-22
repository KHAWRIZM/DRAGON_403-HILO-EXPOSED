package com.qiahao.nextvideo.ui.foodie;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodiePageState;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "OPENING", "RESULT", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodiePageState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FoodiePageState[] $VALUES;
    public static final FoodiePageState NORMAL = new FoodiePageState("NORMAL", 0);
    public static final FoodiePageState OPENING = new FoodiePageState("OPENING", 1);
    public static final FoodiePageState RESULT = new FoodiePageState("RESULT", 2);

    private static final /* synthetic */ FoodiePageState[] $values() {
        return new FoodiePageState[]{NORMAL, OPENING, RESULT};
    }

    static {
        FoodiePageState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FoodiePageState(String str, int i) {
    }

    @NotNull
    public static EnumEntries<FoodiePageState> getEntries() {
        return $ENTRIES;
    }

    public static FoodiePageState valueOf(String str) {
        return (FoodiePageState) Enum.valueOf(FoodiePageState.class, str);
    }

    public static FoodiePageState[] values() {
        return (FoodiePageState[]) $VALUES.clone();
    }
}
