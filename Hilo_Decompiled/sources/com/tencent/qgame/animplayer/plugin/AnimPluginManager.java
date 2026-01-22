package com.tencent.qgame.animplayer.plugin;

import android.view.MotionEvent;
import com.tencent.qgame.animplayer.AnimConfig;
import com.tencent.qgame.animplayer.AnimPlayer;
import com.tencent.qgame.animplayer.mask.MaskAnimPlugin;
import com.tencent.qgame.animplayer.mix.MixAnimPlugin;
import com.tencent.qgame.animplayer.util.ALog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u0004\u0018\u00010\nJ\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/tencent/qgame/animplayer/plugin/AnimPluginManager;", "", "player", "Lcom/tencent/qgame/animplayer/AnimPlayer;", "(Lcom/tencent/qgame/animplayer/AnimPlayer;)V", "decodeIndex", "", "frameDiffTimes", "frameIndex", "maskAnimPlugin", "Lcom/tencent/qgame/animplayer/mask/MaskAnimPlugin;", "mixAnimPlugin", "Lcom/tencent/qgame/animplayer/mix/MixAnimPlugin;", "getPlayer", "()Lcom/tencent/qgame/animplayer/AnimPlayer;", "plugins", "", "Lcom/tencent/qgame/animplayer/plugin/IAnimPlugin;", "getMaskAnimPlugin", "getMixAnimPlugin", "onConfigCreate", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "onDecoding", "", "onDestroy", "onDispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onLoopStart", "onRelease", "onRenderCreate", "onRendering", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AnimPluginManager {
    private static final int DIFF_TIMES = 4;
    private static final String TAG = "AnimPlayer.AnimPluginManager";
    private int decodeIndex;
    private int frameDiffTimes;
    private int frameIndex;
    private final MaskAnimPlugin maskAnimPlugin;
    private final MixAnimPlugin mixAnimPlugin;

    @NotNull
    private final AnimPlayer player;
    private final List<IAnimPlugin> plugins;

    public AnimPluginManager(@NotNull AnimPlayer animPlayer) {
        this.player = animPlayer;
        MixAnimPlugin mixAnimPlugin = new MixAnimPlugin(animPlayer);
        this.mixAnimPlugin = mixAnimPlugin;
        MaskAnimPlugin maskAnimPlugin = new MaskAnimPlugin(animPlayer);
        this.maskAnimPlugin = maskAnimPlugin;
        this.plugins = CollectionsKt.listOf(new IAnimPlugin[]{mixAnimPlugin, maskAnimPlugin});
    }

    @Nullable
    public final MaskAnimPlugin getMaskAnimPlugin() {
        return this.maskAnimPlugin;
    }

    @Nullable
    public final MixAnimPlugin getMixAnimPlugin() {
        return this.mixAnimPlugin;
    }

    @NotNull
    public final AnimPlayer getPlayer() {
        return this.player;
    }

    public final int onConfigCreate(@NotNull AnimConfig config) {
        ALog.INSTANCE.i(TAG, "onConfigCreate");
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            int onConfigCreate = ((IAnimPlugin) it.next()).onConfigCreate(config);
            if (onConfigCreate != 0) {
                return onConfigCreate;
            }
        }
        return 0;
    }

    public final void onDecoding(int decodeIndex) {
        ALog.INSTANCE.d(TAG, "onDecoding decodeIndex=" + decodeIndex);
        this.decodeIndex = decodeIndex;
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            ((IAnimPlugin) it.next()).onDecoding(decodeIndex);
        }
    }

    public final void onDestroy() {
        ALog.INSTANCE.i(TAG, "onDestroy");
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            ((IAnimPlugin) it.next()).onDestroy();
        }
    }

    public final boolean onDispatchTouchEvent(@NotNull MotionEvent ev) {
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            if (((IAnimPlugin) it.next()).onDispatchTouchEvent(ev)) {
                return true;
            }
        }
        return false;
    }

    public final void onLoopStart() {
        ALog.INSTANCE.i(TAG, "onLoopStart");
        this.frameIndex = 0;
        this.decodeIndex = 0;
    }

    public final void onRelease() {
        ALog.INSTANCE.i(TAG, "onRelease");
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            ((IAnimPlugin) it.next()).onRelease();
        }
    }

    public final void onRenderCreate() {
        ALog.INSTANCE.i(TAG, "onRenderCreate");
        this.frameIndex = 0;
        this.decodeIndex = 0;
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            ((IAnimPlugin) it.next()).onRenderCreate();
        }
    }

    public final void onRendering() {
        if (this.decodeIndex > this.frameIndex + 1 || this.frameDiffTimes >= 4) {
            ALog.INSTANCE.i(TAG, "jump frameIndex= " + this.frameIndex + ",decodeIndex=" + this.decodeIndex + ",frameDiffTimes=" + this.frameDiffTimes);
            this.frameIndex = this.decodeIndex;
        }
        if (this.decodeIndex != this.frameIndex) {
            this.frameDiffTimes++;
        } else {
            this.frameDiffTimes = 0;
        }
        ALog.INSTANCE.d(TAG, "onRendering frameIndex=" + this.frameIndex);
        Iterator<T> it = this.plugins.iterator();
        while (it.hasNext()) {
            ((IAnimPlugin) it.next()).onRendering(this.frameIndex);
        }
        this.frameIndex++;
    }
}
