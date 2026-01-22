package com.qiahao.base_common.player;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.core.component.ICleared;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\bH&J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016¨\u0006\u0019"}, d2 = {"Lcom/qiahao/base_common/player/IPlayer;", "Lcom/oudi/core/component/ICleared;", "bindingLifeCycle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "prepare", "source", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "stop", "reset", "", "setPlayWhenReady", "playWhenReady", "getPlayWhenReady", "restart", "getView", "Landroid/view/View;", "getCurrentSource", "getCurrentState", "Lcom/qiahao/base_common/player/PlayerState;", "setPlayerEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/player/PlayerEventListener;", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IPlayer extends ICleared {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void bindingLifeCycle(@NotNull IPlayer iPlayer, @NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        }

        @NotNull
        public static PlayerState getCurrentState(@NotNull IPlayer iPlayer) {
            return PlayerState.IDLE;
        }

        public static boolean getPlayWhenReady(@NotNull IPlayer iPlayer) {
            return true;
        }

        public static void onCleared(@NotNull IPlayer iPlayer) {
            ICleared.DefaultImpls.onCleared(iPlayer);
        }

        public static void restart(@NotNull IPlayer iPlayer) {
        }

        public static void setPlayWhenReady(@NotNull IPlayer iPlayer, boolean z10) {
        }

        public static void setPlayerEventListener(@NotNull IPlayer iPlayer, @Nullable PlayerEventListener playerEventListener) {
        }
    }

    void bindingLifeCycle(@NotNull LifecycleOwner lifecycleOwner);

    @Nullable
    PlayerMediaSource getCurrentSource();

    @NotNull
    PlayerState getCurrentState();

    boolean getPlayWhenReady();

    @NotNull
    View getView();

    @Override // com.oudi.utils.ICleared
    void onCleared();

    void prepare(@NotNull PlayerMediaSource source);

    void restart();

    void setPlayWhenReady(boolean playWhenReady);

    void setPlayerEventListener(@Nullable PlayerEventListener listener);

    void stop(boolean reset);
}
