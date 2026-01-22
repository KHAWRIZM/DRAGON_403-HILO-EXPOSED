package com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentingAnimation;", "", "<init>", "(Ljava/lang/String;I)V", "RIGHT", "RIGHT_REVEAL", "RIGHT_TRANSLATION", "BOTTOM", "FADE", "BOTTOM_FADE", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PresentingAnimation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PresentingAnimation[] $VALUES;
    public static final PresentingAnimation RIGHT = new PresentingAnimation("RIGHT", 0);
    public static final PresentingAnimation RIGHT_REVEAL = new PresentingAnimation("RIGHT_REVEAL", 1);
    public static final PresentingAnimation RIGHT_TRANSLATION = new PresentingAnimation("RIGHT_TRANSLATION", 2);
    public static final PresentingAnimation BOTTOM = new PresentingAnimation("BOTTOM", 3);
    public static final PresentingAnimation FADE = new PresentingAnimation("FADE", 4);
    public static final PresentingAnimation BOTTOM_FADE = new PresentingAnimation("BOTTOM_FADE", 5);

    private static final /* synthetic */ PresentingAnimation[] $values() {
        return new PresentingAnimation[]{RIGHT, RIGHT_REVEAL, RIGHT_TRANSLATION, BOTTOM, FADE, BOTTOM_FADE};
    }

    static {
        PresentingAnimation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private PresentingAnimation(String str, int i) {
    }

    @NotNull
    public static EnumEntries<PresentingAnimation> getEntries() {
        return $ENTRIES;
    }

    public static PresentingAnimation valueOf(String str) {
        return (PresentingAnimation) Enum.valueOf(PresentingAnimation.class, str);
    }

    public static PresentingAnimation[] values() {
        return (PresentingAnimation[]) $VALUES.clone();
    }
}
