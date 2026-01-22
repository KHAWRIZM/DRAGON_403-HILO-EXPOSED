package com.qiahao.base_common.player;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/qiahao/base_common/player/PlayerEventListener;", "", "onPlayerStateChanged", "", "playWhenReady", "", "state", "Lcom/qiahao/base_common/player/PlayerState;", "onPlayerError", "error", "Lcom/qiahao/base_common/player/PlayerException;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface PlayerEventListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onPlayerError(@NotNull PlayerEventListener playerEventListener, @NotNull PlayerException error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        public static void onPlayerStateChanged(@NotNull PlayerEventListener playerEventListener, boolean z10, @NotNull PlayerState state) {
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }

    void onPlayerError(@NotNull PlayerException error);

    void onPlayerStateChanged(boolean playWhenReady, @NotNull PlayerState state);
}
