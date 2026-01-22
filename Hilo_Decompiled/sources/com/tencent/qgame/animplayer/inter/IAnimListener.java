package com.tencent.qgame.animplayer.inter;

import com.tencent.qgame.animplayer.AnimConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/tencent/qgame/animplayer/inter/IAnimListener;", "", "onFailed", "", "errorType", "", "errorMsg", "", "onVideoComplete", "onVideoConfigReady", "", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "onVideoDestroy", "onVideoRender", "frameIndex", "onVideoStart", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IAnimListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class DefaultImpls {
        public static boolean onVideoConfigReady(IAnimListener iAnimListener, @NotNull AnimConfig animConfig) {
            return true;
        }
    }

    void onFailed(int errorType, @Nullable String errorMsg);

    void onVideoComplete();

    boolean onVideoConfigReady(@NotNull AnimConfig config);

    void onVideoDestroy();

    void onVideoRender(int frameIndex, @Nullable AnimConfig config);

    void onVideoStart();
}
