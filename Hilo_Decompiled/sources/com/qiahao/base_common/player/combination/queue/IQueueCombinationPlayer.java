package com.qiahao.base_common.player.combination.queue;

import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.player.PlayerEventListener;
import com.qiahao.base_common.player.PlayerMediaSource;
import com.qiahao.base_common.player.PlayerState;
import com.qiahao.base_common.player.combination.ICombinationPlayer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u0003H'¨\u0006\u000e"}, d2 = {"Lcom/qiahao/base_common/player/combination/queue/IQueueCombinationPlayer;", "Lcom/qiahao/base_common/player/combination/ICombinationPlayer;", "addQueue", "", "source", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "isIdleState", "", "getFirstOrNullFromQueue", "predicate", "Lkotlin/Function1;", "stop", "reset", "restart", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IQueueCombinationPlayer extends ICombinationPlayer {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void bindingLifeCycle(@NotNull IQueueCombinationPlayer iQueueCombinationPlayer, @NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            ICombinationPlayer.DefaultImpls.bindingLifeCycle(iQueueCombinationPlayer, lifecycleOwner);
        }

        @NotNull
        public static PlayerState getCurrentState(@NotNull IQueueCombinationPlayer iQueueCombinationPlayer) {
            return ICombinationPlayer.DefaultImpls.getCurrentState(iQueueCombinationPlayer);
        }

        public static void onCleared(@NotNull IQueueCombinationPlayer iQueueCombinationPlayer) {
            ICombinationPlayer.DefaultImpls.onCleared(iQueueCombinationPlayer);
        }

        public static void setPlayerEventListener(@NotNull IQueueCombinationPlayer iQueueCombinationPlayer, @Nullable PlayerEventListener playerEventListener) {
            ICombinationPlayer.DefaultImpls.setPlayerEventListener(iQueueCombinationPlayer, playerEventListener);
        }
    }

    void addQueue(@NotNull PlayerMediaSource source);

    @Nullable
    PlayerMediaSource getFirstOrNullFromQueue(@NotNull Function1<? super PlayerMediaSource, Boolean> predicate);

    boolean isIdleState();

    @Override // com.qiahao.base_common.player.combination.ICombinationPlayer, com.qiahao.base_common.player.IPlayer
    @Deprecated(message = "队列播放器时，暂不支持该方法。")
    void restart();

    @Override // com.qiahao.base_common.player.combination.ICombinationPlayer, com.qiahao.base_common.player.IPlayer
    void stop(boolean reset);
}
