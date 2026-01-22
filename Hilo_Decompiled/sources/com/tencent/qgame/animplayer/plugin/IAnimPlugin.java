package com.tencent.qgame.animplayer.plugin;

import android.view.MotionEvent;
import com.tencent.qgame.animplayer.AnimConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0003H\u0016¨\u0006\u0012"}, d2 = {"Lcom/tencent/qgame/animplayer/plugin/IAnimPlugin;", "", "onConfigCreate", "", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "onDecoding", "", "decodeIndex", "onDestroy", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onRelease", "onRenderCreate", "onRendering", "frameIndex", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IAnimPlugin {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class DefaultImpls {
        public static int onConfigCreate(IAnimPlugin iAnimPlugin, @NotNull AnimConfig animConfig) {
            return 0;
        }

        public static void onDecoding(IAnimPlugin iAnimPlugin, int i) {
        }

        public static void onDestroy(IAnimPlugin iAnimPlugin) {
        }

        public static boolean onDispatchTouchEvent(IAnimPlugin iAnimPlugin, @NotNull MotionEvent motionEvent) {
            return false;
        }

        public static void onRelease(IAnimPlugin iAnimPlugin) {
        }

        public static void onRenderCreate(IAnimPlugin iAnimPlugin) {
        }

        public static void onRendering(IAnimPlugin iAnimPlugin, int i) {
        }
    }

    int onConfigCreate(@NotNull AnimConfig config);

    void onDecoding(int decodeIndex);

    void onDestroy();

    boolean onDispatchTouchEvent(@NotNull MotionEvent ev);

    void onRelease();

    void onRenderCreate();

    void onRendering(int frameIndex);
}
