package com.tencent.qgame.animplayer.mix;

import com.tencent.qgame.animplayer.mix.Src;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/SrcMap;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "map", "Ljava/util/HashMap;", "", "Lcom/tencent/qgame/animplayer/mix/Src;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class SrcMap {

    @NotNull
    private final HashMap<String, Src> map = new HashMap<>();

    public SrcMap(@NotNull JSONObject jSONObject) {
        int i;
        JSONObject jSONObject2;
        JSONArray jSONArray = jSONObject.getJSONArray("src");
        if (jSONArray != null) {
            i = jSONArray.length();
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (jSONArray != null && (jSONObject2 = jSONArray.getJSONObject(i2)) != null) {
                Src src = new Src(jSONObject2);
                if (src.getSrcType() != Src.SrcType.UNKNOWN) {
                    this.map.put(src.getSrcId(), src);
                }
            }
        }
    }

    @NotNull
    public final HashMap<String, Src> getMap() {
        return this.map;
    }
}
