package com.qiahao.base_common.player.vap;

import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.player.IPlayer;
import com.qiahao.base_common.player.PlayerEventListener;
import com.qiahao.base_common.player.PlayerState;
import com.tencent.qgame.animplayer.inter.IFetchResource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\u0006\u001a\u00020\u0005H\u0017J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/qiahao/base_common/player/vap/IVapPlayer;", "Lcom/qiahao/base_common/player/IPlayer;", "setPlayWhenReady", "", "playWhenReady", "", "getPlayWhenReady", "setFetchResource", "resource", "Lcom/tencent/qgame/animplayer/inter/IFetchResource;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IVapPlayer extends IPlayer {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void bindingLifeCycle(@NotNull IVapPlayer iVapPlayer, @NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            IPlayer.DefaultImpls.bindingLifeCycle(iVapPlayer, lifecycleOwner);
        }

        @NotNull
        public static PlayerState getCurrentState(@NotNull IVapPlayer iVapPlayer) {
            return IPlayer.DefaultImpls.getCurrentState(iVapPlayer);
        }

        @Deprecated(message = "VAP暂不支持暂停控制")
        public static boolean getPlayWhenReady(@NotNull IVapPlayer iVapPlayer) {
            return true;
        }

        public static void onCleared(@NotNull IVapPlayer iVapPlayer) {
            IPlayer.DefaultImpls.onCleared(iVapPlayer);
        }

        public static void restart(@NotNull IVapPlayer iVapPlayer) {
            IPlayer.DefaultImpls.restart(iVapPlayer);
        }

        @Deprecated(message = "VAP暂不支持暂停控制")
        public static void setPlayWhenReady(@NotNull IVapPlayer iVapPlayer, boolean z10) {
            IPlayer.DefaultImpls.setPlayWhenReady(iVapPlayer, z10);
        }

        public static void setPlayerEventListener(@NotNull IVapPlayer iVapPlayer, @Nullable PlayerEventListener playerEventListener) {
            IPlayer.DefaultImpls.setPlayerEventListener(iVapPlayer, playerEventListener);
        }
    }

    @Override // com.qiahao.base_common.player.IPlayer
    @Deprecated(message = "VAP暂不支持暂停控制")
    boolean getPlayWhenReady();

    void setFetchResource(@Nullable IFetchResource resource);

    @Override // com.qiahao.base_common.player.IPlayer
    @Deprecated(message = "VAP暂不支持暂停控制")
    void setPlayWhenReady(boolean playWhenReady);
}
