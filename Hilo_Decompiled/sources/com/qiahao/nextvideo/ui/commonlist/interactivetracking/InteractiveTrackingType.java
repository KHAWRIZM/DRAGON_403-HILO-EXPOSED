package com.qiahao.nextvideo.ui.commonlist.interactivetracking;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "", "<init>", "(Ljava/lang/String;I)V", "ILike", "Follow", "Visitor", "Praise", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class InteractiveTrackingType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InteractiveTrackingType[] $VALUES;
    public static final InteractiveTrackingType ILike = new InteractiveTrackingType("ILike", 0);
    public static final InteractiveTrackingType Follow = new InteractiveTrackingType("Follow", 1);
    public static final InteractiveTrackingType Visitor = new InteractiveTrackingType("Visitor", 2);
    public static final InteractiveTrackingType Praise = new InteractiveTrackingType("Praise", 3);

    private static final /* synthetic */ InteractiveTrackingType[] $values() {
        return new InteractiveTrackingType[]{ILike, Follow, Visitor, Praise};
    }

    static {
        InteractiveTrackingType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private InteractiveTrackingType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<InteractiveTrackingType> getEntries() {
        return $ENTRIES;
    }

    public static InteractiveTrackingType valueOf(String str) {
        return (InteractiveTrackingType) Enum.valueOf(InteractiveTrackingType.class, str);
    }

    public static InteractiveTrackingType[] values() {
        return (InteractiveTrackingType[]) $VALUES.clone();
    }
}
