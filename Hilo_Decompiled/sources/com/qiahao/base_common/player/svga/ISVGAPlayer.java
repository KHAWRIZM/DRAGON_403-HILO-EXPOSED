package com.qiahao.base_common.player.svga;

import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.player.IPlayer;
import com.qiahao.base_common.player.PlayerEventListener;
import com.qiahao.base_common.player.PlayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/qiahao/base_common/player/svga/ISVGAPlayer;", "Lcom/qiahao/base_common/player/IPlayer;", "setResourceParse", "", "parser", "Lcom/qiahao/base_common/player/svga/SVGAResourceParser;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface ISVGAPlayer extends IPlayer {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void bindingLifeCycle(@NotNull ISVGAPlayer iSVGAPlayer, @NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            IPlayer.DefaultImpls.bindingLifeCycle(iSVGAPlayer, lifecycleOwner);
        }

        @NotNull
        public static PlayerState getCurrentState(@NotNull ISVGAPlayer iSVGAPlayer) {
            return IPlayer.DefaultImpls.getCurrentState(iSVGAPlayer);
        }

        public static boolean getPlayWhenReady(@NotNull ISVGAPlayer iSVGAPlayer) {
            return IPlayer.DefaultImpls.getPlayWhenReady(iSVGAPlayer);
        }

        public static void onCleared(@NotNull ISVGAPlayer iSVGAPlayer) {
            IPlayer.DefaultImpls.onCleared(iSVGAPlayer);
        }

        public static void restart(@NotNull ISVGAPlayer iSVGAPlayer) {
            IPlayer.DefaultImpls.restart(iSVGAPlayer);
        }

        public static void setPlayWhenReady(@NotNull ISVGAPlayer iSVGAPlayer, boolean z10) {
            IPlayer.DefaultImpls.setPlayWhenReady(iSVGAPlayer, z10);
        }

        public static void setPlayerEventListener(@NotNull ISVGAPlayer iSVGAPlayer, @Nullable PlayerEventListener playerEventListener) {
            IPlayer.DefaultImpls.setPlayerEventListener(iSVGAPlayer, playerEventListener);
        }
    }

    void setResourceParse(@Nullable SVGAResourceParser parser);
}
