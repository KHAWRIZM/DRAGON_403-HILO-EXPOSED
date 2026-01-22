package com.tencent.qgame.animplayer.mix;

import com.tencent.qgame.animplayer.PointRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/Frame;", "", "index", "", "json", "Lorg/json/JSONObject;", "(ILorg/json/JSONObject;)V", "frame", "Lcom/tencent/qgame/animplayer/PointRect;", "getFrame", "()Lcom/tencent/qgame/animplayer/PointRect;", "setFrame", "(Lcom/tencent/qgame/animplayer/PointRect;)V", "getIndex", "()I", "mFrame", "getMFrame", "setMFrame", "mt", "getMt", "setMt", "(I)V", "srcId", "", "getSrcId", "()Ljava/lang/String;", "setSrcId", "(Ljava/lang/String;)V", "z", "getZ", "setZ", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Frame {

    @NotNull
    private PointRect frame;
    private final int index;

    @NotNull
    private PointRect mFrame;
    private int mt;

    @NotNull
    private String srcId;
    private int z;

    public Frame(int i, @NotNull JSONObject jSONObject) {
        this.index = i;
        this.srcId = "";
        String string = jSONObject.getString("srcId");
        Intrinsics.checkExpressionValueIsNotNull(string, "json.getString(\"srcId\")");
        this.srcId = string;
        this.z = jSONObject.getInt("z");
        JSONArray jSONArray = jSONObject.getJSONArray("frame");
        this.frame = new PointRect(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
        JSONArray jSONArray2 = jSONObject.getJSONArray("mFrame");
        this.mFrame = new PointRect(jSONArray2.getInt(0), jSONArray2.getInt(1), jSONArray2.getInt(2), jSONArray2.getInt(3));
        this.mt = jSONObject.getInt("mt");
    }

    @NotNull
    public final PointRect getFrame() {
        return this.frame;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final PointRect getMFrame() {
        return this.mFrame;
    }

    public final int getMt() {
        return this.mt;
    }

    @NotNull
    public final String getSrcId() {
        return this.srcId;
    }

    public final int getZ() {
        return this.z;
    }

    public final void setFrame(@NotNull PointRect pointRect) {
        this.frame = pointRect;
    }

    public final void setMFrame(@NotNull PointRect pointRect) {
        this.mFrame = pointRect;
    }

    public final void setMt(int i) {
        this.mt = i;
    }

    public final void setSrcId(@NotNull String str) {
        this.srcId = str;
    }

    public final void setZ(int i) {
        this.z = i;
    }
}
