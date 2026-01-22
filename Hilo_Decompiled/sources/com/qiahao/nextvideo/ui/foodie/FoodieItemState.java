package com.qiahao.nextvideo.ui.foodie;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieItemState;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "PICKED", "DRAWING_HIGHLIGHT", "DRAWING_SHADOW", "RESULT", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieItemState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FoodieItemState[] $VALUES;
    public static final FoodieItemState NORMAL = new FoodieItemState("NORMAL", 0);
    public static final FoodieItemState PICKED = new FoodieItemState("PICKED", 1);
    public static final FoodieItemState DRAWING_HIGHLIGHT = new FoodieItemState("DRAWING_HIGHLIGHT", 2);
    public static final FoodieItemState DRAWING_SHADOW = new FoodieItemState("DRAWING_SHADOW", 3);
    public static final FoodieItemState RESULT = new FoodieItemState("RESULT", 4);

    private static final /* synthetic */ FoodieItemState[] $values() {
        return new FoodieItemState[]{NORMAL, PICKED, DRAWING_HIGHLIGHT, DRAWING_SHADOW, RESULT};
    }

    static {
        FoodieItemState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FoodieItemState(String str, int i) {
    }

    @NotNull
    public static EnumEntries<FoodieItemState> getEntries() {
        return $ENTRIES;
    }

    public static FoodieItemState valueOf(String str) {
        return (FoodieItemState) Enum.valueOf(FoodieItemState.class, str);
    }

    public static FoodieItemState[] values() {
        return (FoodieItemState[]) $VALUES.clone();
    }
}
