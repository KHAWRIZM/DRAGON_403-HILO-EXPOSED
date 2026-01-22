package com.tencent.qgame.animplayer.mix;

import android.util.SparseArray;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/FrameAll;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/qgame/animplayer/mix/FrameSet;", "getMap", "()Landroid/util/SparseArray;", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class FrameAll {

    @NotNull
    private final SparseArray<FrameSet> map = new SparseArray<>();

    public FrameAll(@NotNull JSONObject jSONObject) {
        int i;
        JSONObject jSONObject2;
        JSONArray jSONArray = jSONObject.getJSONArray("frame");
        if (jSONArray != null) {
            i = jSONArray.length();
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (jSONArray != null && (jSONObject2 = jSONArray.getJSONObject(i2)) != null) {
                FrameSet frameSet = new FrameSet(jSONObject2);
                this.map.put(frameSet.getIndex(), frameSet);
            }
        }
    }

    @NotNull
    public final SparseArray<FrameSet> getMap() {
        return this.map;
    }
}
