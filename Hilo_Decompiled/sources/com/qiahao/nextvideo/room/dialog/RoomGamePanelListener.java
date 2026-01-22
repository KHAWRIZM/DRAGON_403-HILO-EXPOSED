package com.qiahao.nextvideo.room.dialog;

import com.qiahao.nextvideo.data.model.GameConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomGamePanelListener;", "", "roomMemberMass", "", "music", "inviteUser", "globalBroadcast", "animationEffect", "clearMessage", "clickGame", "gameConfiguration", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "noiseReduction", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface RoomGamePanelListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static void animationEffect(@NotNull RoomGamePanelListener roomGamePanelListener) {
        }

        public static void clearMessage(@NotNull RoomGamePanelListener roomGamePanelListener) {
        }

        public static void clickGame(@NotNull RoomGamePanelListener roomGamePanelListener, @NotNull GameConfiguration gameConfiguration) {
            Intrinsics.checkNotNullParameter(gameConfiguration, "gameConfiguration");
        }

        public static void globalBroadcast(@NotNull RoomGamePanelListener roomGamePanelListener) {
        }

        public static void inviteUser(@NotNull RoomGamePanelListener roomGamePanelListener) {
        }

        public static void music(@NotNull RoomGamePanelListener roomGamePanelListener) {
        }

        public static void noiseReduction(@NotNull RoomGamePanelListener roomGamePanelListener, boolean z) {
        }

        public static void roomMemberMass(@NotNull RoomGamePanelListener roomGamePanelListener) {
        }
    }

    void animationEffect();

    void clearMessage();

    void clickGame(@NotNull GameConfiguration gameConfiguration);

    void globalBroadcast();

    void inviteUser();

    void music();

    void noiseReduction(boolean noiseReduction);

    void roomMemberMass();
}
