package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/utilities/AnimatorType;", "", "<init>", "(Ljava/lang/String;I)V", "ALPHA", "TranslationX", "TranslationY", "ScaleX", "ScaleY", "Rotation", "RotationY", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AnimatorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AnimatorType[] $VALUES;
    public static final AnimatorType ALPHA = new AnimatorType("ALPHA", 0);
    public static final AnimatorType TranslationX = new AnimatorType("TranslationX", 1);
    public static final AnimatorType TranslationY = new AnimatorType("TranslationY", 2);
    public static final AnimatorType ScaleX = new AnimatorType("ScaleX", 3);
    public static final AnimatorType ScaleY = new AnimatorType("ScaleY", 4);
    public static final AnimatorType Rotation = new AnimatorType("Rotation", 5);
    public static final AnimatorType RotationY = new AnimatorType("RotationY", 6);

    private static final /* synthetic */ AnimatorType[] $values() {
        return new AnimatorType[]{ALPHA, TranslationX, TranslationY, ScaleX, ScaleY, Rotation, RotationY};
    }

    static {
        AnimatorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AnimatorType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<AnimatorType> getEntries() {
        return $ENTRIES;
    }

    public static AnimatorType valueOf(String str) {
        return (AnimatorType) Enum.valueOf(AnimatorType.class, str);
    }

    public static AnimatorType[] values() {
        return (AnimatorType[]) $VALUES.clone();
    }
}
