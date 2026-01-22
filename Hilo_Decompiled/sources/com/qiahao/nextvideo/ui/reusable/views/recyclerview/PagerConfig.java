package com.qiahao.nextvideo.ui.reusable.views.recyclerview;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerConfig;", "", "<init>", "()V", "flingThreshold", "", "getFlingThreshold", "()I", "setFlingThreshold", "(I)V", "millisecondsPreInch", "", "getMillisecondsPreInch", "()F", "setMillisecondsPreInch", "(F)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PagerConfig {

    @NotNull
    public static final PagerConfig INSTANCE = new PagerConfig();
    private static int flingThreshold = 1000;
    private static float millisecondsPreInch = 60.0f;

    private PagerConfig() {
    }

    public final int getFlingThreshold() {
        return flingThreshold;
    }

    public final float getMillisecondsPreInch() {
        return millisecondsPreInch;
    }

    public final void setFlingThreshold(int i) {
        flingThreshold = i;
    }

    public final void setMillisecondsPreInch(float f) {
        millisecondsPreInch = f;
    }
}
