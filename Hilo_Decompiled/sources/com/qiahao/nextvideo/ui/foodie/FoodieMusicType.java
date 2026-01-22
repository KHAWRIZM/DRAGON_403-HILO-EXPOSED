package com.qiahao.nextvideo.ui.foodie;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieMusicType;", "", "<init>", "(Ljava/lang/String;I)V", "BACKGROUND", "BIG_REWARD", "SMALL_REWARD", "WHEELING", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieMusicType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FoodieMusicType[] $VALUES;
    public static final FoodieMusicType BACKGROUND = new FoodieMusicType("BACKGROUND", 0);
    public static final FoodieMusicType BIG_REWARD = new FoodieMusicType("BIG_REWARD", 1);
    public static final FoodieMusicType SMALL_REWARD = new FoodieMusicType("SMALL_REWARD", 2);
    public static final FoodieMusicType WHEELING = new FoodieMusicType("WHEELING", 3);

    private static final /* synthetic */ FoodieMusicType[] $values() {
        return new FoodieMusicType[]{BACKGROUND, BIG_REWARD, SMALL_REWARD, WHEELING};
    }

    static {
        FoodieMusicType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FoodieMusicType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<FoodieMusicType> getEntries() {
        return $ENTRIES;
    }

    public static FoodieMusicType valueOf(String str) {
        return (FoodieMusicType) Enum.valueOf(FoodieMusicType.class, str);
    }

    public static FoodieMusicType[] values() {
        return (FoodieMusicType[]) $VALUES.clone();
    }
}
