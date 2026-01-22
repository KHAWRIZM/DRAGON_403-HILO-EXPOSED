package com.qiahao.nextvideo.ui.conversation;

import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/conversation/ForeverHeartPercentType;", "", "limit", "", "drawableRes", "svgaUrl", "", "<init>", "(Ljava/lang/String;IIILjava/lang/String;)V", "getLimit", "()I", "setLimit", "(I)V", "getDrawableRes", "getSvgaUrl", "()Ljava/lang/String;", "Percent0", "Percent25", "Percent50", "Percent75", "Percent100", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ForeverHeartPercentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ForeverHeartPercentType[] $VALUES;
    private final int drawableRes;
    private int limit;

    @NotNull
    private final String svgaUrl;
    public static final ForeverHeartPercentType Percent0 = new ForeverHeartPercentType("Percent0", 0, 0, R.drawable.icon_heart_percent_0, "svga/forever_heart_percent_0.svga");
    public static final ForeverHeartPercentType Percent25 = new ForeverHeartPercentType("Percent25", 1, 25, R.drawable.icon_heart_percent_25, "svga/forever_heart_percent_25.svga");
    public static final ForeverHeartPercentType Percent50 = new ForeverHeartPercentType("Percent50", 2, 50, R.drawable.icon_heart_percent_50, "svga/forever_heart_percent_50.svga");
    public static final ForeverHeartPercentType Percent75 = new ForeverHeartPercentType("Percent75", 3, 75, R.drawable.icon_heart_percent_75, "svga/forever_heart_percent_75.svga");
    public static final ForeverHeartPercentType Percent100 = new ForeverHeartPercentType("Percent100", 4, 100, R.drawable.icon_heart_percent_100, "svga/forever_heart_percent_100.svga");

    private static final /* synthetic */ ForeverHeartPercentType[] $values() {
        return new ForeverHeartPercentType[]{Percent0, Percent25, Percent50, Percent75, Percent100};
    }

    static {
        ForeverHeartPercentType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ForeverHeartPercentType(String str, int i, int i2, int i3, String str2) {
        this.limit = i2;
        this.drawableRes = i3;
        this.svgaUrl = str2;
    }

    @NotNull
    public static EnumEntries<ForeverHeartPercentType> getEntries() {
        return $ENTRIES;
    }

    public static ForeverHeartPercentType valueOf(String str) {
        return (ForeverHeartPercentType) Enum.valueOf(ForeverHeartPercentType.class, str);
    }

    public static ForeverHeartPercentType[] values() {
        return (ForeverHeartPercentType[]) $VALUES.clone();
    }

    public final int getDrawableRes() {
        return this.drawableRes;
    }

    public final int getLimit() {
        return this.limit;
    }

    @NotNull
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }
}
