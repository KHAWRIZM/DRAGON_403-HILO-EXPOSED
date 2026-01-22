package com.tencent.qgame.animplayer.mix;

import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/FrameSet;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/qgame/animplayer/mix/Frame;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class FrameSet {
    private int index;

    @NotNull
    private final ArrayList<Frame> list = new ArrayList<>();

    public FrameSet(@NotNull JSONObject jSONObject) {
        int i;
        JSONObject jSONObject2;
        this.index = jSONObject.getInt("i");
        JSONArray jSONArray = jSONObject.getJSONArray("obj");
        if (jSONArray != null) {
            i = jSONArray.length();
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (jSONArray != null && (jSONObject2 = jSONArray.getJSONObject(i2)) != null) {
                this.list.add(new Frame(this.index, jSONObject2));
            }
        }
        ArrayList<Frame> arrayList = this.list;
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new Comparator<T>() { // from class: com.tencent.qgame.animplayer.mix.FrameSet$$special$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((Frame) t).getZ()), Integer.valueOf(((Frame) t2).getZ()));
                }
            });
        }
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final ArrayList<Frame> getList() {
        return this.list;
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
