package com.tencent.qgame.animplayer.mix;

import android.util.SparseArray;
import android.view.MotionEvent;
import com.tencent.qgame.animplayer.AnimConfig;
import com.tencent.qgame.animplayer.PointRect;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/MixTouch;", "", "mixAnimPlugin", "Lcom/tencent/qgame/animplayer/mix/MixAnimPlugin;", "(Lcom/tencent/qgame/animplayer/mix/MixAnimPlugin;)V", "calClick", "", "x", "", "y", "frame", "Lcom/tencent/qgame/animplayer/PointRect;", "onTouchEvent", "Lcom/tencent/qgame/animplayer/mix/Resource;", "ev", "Landroid/view/MotionEvent;", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class MixTouch {
    private final MixAnimPlugin mixAnimPlugin;

    public MixTouch(@NotNull MixAnimPlugin mixAnimPlugin) {
        this.mixAnimPlugin = mixAnimPlugin;
    }

    private final boolean calClick(int x, int y, PointRect frame) {
        if (x >= frame.getX() && x <= frame.getX() + frame.getW() && y >= frame.getY() && y <= frame.getY() + frame.getH()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Resource onTouchEvent(@NotNull MotionEvent ev) {
        ArrayList<Frame> arrayList;
        HashMap<String, Src> map;
        Src src;
        SparseArray<FrameSet> map2;
        FrameSet frameSet;
        Pair<Integer, Integer> realSize = this.mixAnimPlugin.getPlayer().getAnimView().getRealSize();
        int intValue = ((Number) realSize.component1()).intValue();
        int intValue2 = ((Number) realSize.component2()).intValue();
        AnimConfig config = this.mixAnimPlugin.getPlayer().getConfigManager().getConfig();
        if (config != null) {
            int width = config.getWidth();
            AnimConfig config2 = this.mixAnimPlugin.getPlayer().getConfigManager().getConfig();
            if (config2 != null) {
                int height = config2.getHeight();
                if (intValue != 0 && intValue2 != 0 && ev.getAction() == 1) {
                    float x = (ev.getX() * width) / intValue;
                    float y = (ev.getY() * height) / intValue2;
                    FrameAll frameAll = this.mixAnimPlugin.getFrameAll();
                    if (frameAll != null && (map2 = frameAll.getMap()) != null && (frameSet = map2.get(this.mixAnimPlugin.getCurFrameIndex())) != null) {
                        arrayList = frameSet.getList();
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        for (Frame frame : arrayList) {
                            SrcMap srcMap = this.mixAnimPlugin.getSrcMap();
                            if (srcMap != null && (map = srcMap.getMap()) != null && (src = map.get(frame.getSrcId())) != null) {
                                Intrinsics.checkExpressionValueIsNotNull(src, "mixAnimPlugin.srcMap?.ma….srcId) ?: return@forEach");
                                if (calClick((int) x, (int) y, frame.getFrame())) {
                                    Resource resource = new Resource(src);
                                    resource.setCurPoint(frame.getFrame());
                                    return resource;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
