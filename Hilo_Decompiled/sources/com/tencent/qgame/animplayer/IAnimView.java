package com.tencent.qgame.animplayer;

import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import com.tencent.qgame.animplayer.file.IFileContainer;
import com.tencent.qgame.animplayer.inter.IAnimListener;
import com.tencent.qgame.animplayer.inter.IFetchResource;
import com.tencent.qgame.animplayer.inter.OnResourceClickListener;
import com.tencent.qgame.animplayer.mask.MaskConfig;
import com.tencent.qgame.animplayer.util.IScaleType;
import com.tencent.qgame.animplayer.util.ScaleType;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H&J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bH&J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H&J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020\nH&J\u0018\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH&J\u0012\u0010,\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010.H&¨\u0006/"}, d2 = {"Lcom/tencent/qgame/animplayer/IAnimView;", "", "getRealSize", "Lkotlin/Pair;", "", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "isRunning", "", "prepareTextureView", "", "setAnimListener", "animListener", "Lcom/tencent/qgame/animplayer/inter/IAnimListener;", "setFetchResource", "fetchResource", "Lcom/tencent/qgame/animplayer/inter/IFetchResource;", "setFps", "fps", "setLoop", "playLoop", "setMute", "isMute", "setOnResourceClickListener", "resourceClickListener", "Lcom/tencent/qgame/animplayer/inter/OnResourceClickListener;", "setScaleType", "scaleType", "Lcom/tencent/qgame/animplayer/util/IScaleType;", "type", "Lcom/tencent/qgame/animplayer/util/ScaleType;", "startPlay", "assetManager", "Landroid/content/res/AssetManager;", "assetsPath", "", "fileContainer", "Lcom/tencent/qgame/animplayer/file/IFileContainer;", "file", "Ljava/io/File;", "stopPlay", "supportMask", "isSupport", "isEdgeBlur", "updateMaskConfig", "maskConfig", "Lcom/tencent/qgame/animplayer/mask/MaskConfig;", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IAnimView {
    @NotNull
    Pair<Integer, Integer> getRealSize();

    @Nullable
    SurfaceTexture getSurfaceTexture();

    boolean isRunning();

    void prepareTextureView();

    void setAnimListener(@Nullable IAnimListener animListener);

    void setFetchResource(@Nullable IFetchResource fetchResource);

    void setFps(int fps);

    void setLoop(int playLoop);

    void setMute(boolean isMute);

    void setOnResourceClickListener(@Nullable OnResourceClickListener resourceClickListener);

    void setScaleType(@NotNull IScaleType scaleType);

    void setScaleType(@NotNull ScaleType type);

    void startPlay(@NotNull AssetManager assetManager, @NotNull String assetsPath);

    void startPlay(@NotNull IFileContainer fileContainer);

    void startPlay(@NotNull File file);

    void stopPlay();

    void supportMask(boolean isSupport, boolean isEdgeBlur);

    void updateMaskConfig(@Nullable MaskConfig maskConfig);
}
