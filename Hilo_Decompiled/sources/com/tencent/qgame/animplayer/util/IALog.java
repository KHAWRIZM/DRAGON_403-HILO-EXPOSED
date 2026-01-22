package com.tencent.qgame.animplayer.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/tencent/qgame/animplayer/util/IALog;", "", "d", "", "tag", "", "msg", "e", "tr", "", "i", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IALog {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class DefaultImpls {
        public static void d(IALog iALog, @NotNull String str, @NotNull String str2) {
        }

        public static void e(IALog iALog, @NotNull String str, @NotNull String str2) {
        }

        public static void i(IALog iALog, @NotNull String str, @NotNull String str2) {
        }

        public static void e(IALog iALog, @NotNull String str, @NotNull String str2, @NotNull Throwable th) {
        }
    }

    void d(@NotNull String tag, @NotNull String msg);

    void e(@NotNull String tag, @NotNull String msg);

    void e(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr);

    void i(@NotNull String tag, @NotNull String msg);
}
