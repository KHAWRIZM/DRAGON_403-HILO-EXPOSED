package com.tencent.qgame.animplayer.mix;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qgame.animplayer.util.ALog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0005HIJKLB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010E\u001a\u00020F2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010G\u001a\u00020(H\u0016R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u00100\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010*\"\u0004\bA\u0010,R\u001a\u0010B\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010\u0011¨\u0006M"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/Src;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "drawHeight", "getDrawHeight", "setDrawHeight", "drawWidth", "getDrawWidth", "setDrawWidth", "fitType", "Lcom/tencent/qgame/animplayer/mix/Src$FitType;", "getFitType", "()Lcom/tencent/qgame/animplayer/mix/Src$FitType;", "setFitType", "(Lcom/tencent/qgame/animplayer/mix/Src$FitType;)V", "h", "getH", "setH", "loadType", "Lcom/tencent/qgame/animplayer/mix/Src$LoadType;", "getLoadType", "()Lcom/tencent/qgame/animplayer/mix/Src$LoadType;", "setLoadType", "(Lcom/tencent/qgame/animplayer/mix/Src$LoadType;)V", "srcId", "", "getSrcId", "()Ljava/lang/String;", "setSrcId", "(Ljava/lang/String;)V", "srcTag", "getSrcTag", "setSrcTag", TUIConstants.TUIBeauty.PARAM_NAME_SRC_TEXTURE_ID, "getSrcTextureId", "setSrcTextureId", "srcType", "Lcom/tencent/qgame/animplayer/mix/Src$SrcType;", "getSrcType", "()Lcom/tencent/qgame/animplayer/mix/Src$SrcType;", "setSrcType", "(Lcom/tencent/qgame/animplayer/mix/Src$SrcType;)V", AgooConstants.MESSAGE_BODY_STYLE, "Lcom/tencent/qgame/animplayer/mix/Src$Style;", "getStyle", "()Lcom/tencent/qgame/animplayer/mix/Src$Style;", "setStyle", "(Lcom/tencent/qgame/animplayer/mix/Src$Style;)V", "txt", "getTxt", "setTxt", "w", "getW", "setW", "genDrawSize", "", "toString", "Companion", "FitType", "LoadType", "SrcType", "Style", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Src {
    private static final String TAG = "AnimPlayer.Src";

    @Nullable
    private Bitmap bitmap;
    private int color;
    private int drawHeight;
    private int drawWidth;

    @NotNull
    private FitType fitType;
    private int h;

    @NotNull
    private LoadType loadType;

    @NotNull
    private String srcId;

    @NotNull
    private String srcTag;
    private int srcTextureId;

    @NotNull
    private SrcType srcType;

    @NotNull
    private Style style;

    @NotNull
    private String txt;
    private int w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/Src$FitType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "FIT_XY", "CENTER_FULL", "animplayer_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum FitType {
        FIT_XY("fitXY"),
        CENTER_FULL("centerFull");


        @NotNull
        private final String type;

        FitType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/Src$LoadType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "UNKNOWN", "NET", "LOCAL", "animplayer_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum LoadType {
        UNKNOWN(UtilityImpl.NET_TYPE_UNKNOWN),
        NET("net"),
        LOCAL(AgooConstants.MESSAGE_LOCAL);


        @NotNull
        private final String type;

        LoadType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/Src$SrcType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "UNKNOWN", "IMG", "TXT", "animplayer_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum SrcType {
        UNKNOWN(UtilityImpl.NET_TYPE_UNKNOWN),
        IMG("img"),
        TXT("txt");


        @NotNull
        private final String type;

        SrcType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tencent/qgame/animplayer/mix/Src$Style;", "", AgooConstants.MESSAGE_BODY_STYLE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStyle", "()Ljava/lang/String;", "DEFAULT", "BOLD", "animplayer_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum Style {
        DEFAULT("default"),
        BOLD("b");


        @NotNull
        private final String style;

        Style(String str) {
            this.style = str;
        }

        @NotNull
        public final String getStyle() {
            return this.style;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a3, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r5.getType()) != false) goto L١٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, r7.getType()) != false) goto L٨;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Src(@NotNull JSONObject jSONObject) {
        this.srcId = "";
        SrcType srcType = SrcType.UNKNOWN;
        this.srcType = srcType;
        LoadType loadType = LoadType.UNKNOWN;
        this.loadType = loadType;
        this.srcTag = "";
        this.txt = "";
        Style style = Style.DEFAULT;
        this.style = style;
        FitType fitType = FitType.FIT_XY;
        this.fitType = fitType;
        String string = jSONObject.getString("srcId");
        Intrinsics.checkExpressionValueIsNotNull(string, "json.getString(\"srcId\")");
        this.srcId = string;
        this.w = jSONObject.getInt("w");
        this.h = jSONObject.getInt("h");
        String optString = jSONObject.optString("color", "#000000");
        Intrinsics.checkExpressionValueIsNotNull(optString, "colorStr");
        String str = optString.length() != 0 ? optString : "#000000";
        this.color = Color.parseColor(str);
        String string2 = jSONObject.getString("srcTag");
        Intrinsics.checkExpressionValueIsNotNull(string2, "json.getString(\"srcTag\")");
        this.srcTag = string2;
        this.txt = string2;
        String string3 = jSONObject.getString("srcType");
        SrcType srcType2 = SrcType.IMG;
        if (!Intrinsics.areEqual(string3, srcType2.getType())) {
            srcType2 = SrcType.TXT;
        }
        srcType = srcType2;
        this.srcType = srcType;
        String string4 = jSONObject.getString("loadType");
        LoadType loadType2 = LoadType.NET;
        if (!Intrinsics.areEqual(string4, loadType2.getType())) {
            loadType2 = LoadType.LOCAL;
        }
        loadType = loadType2;
        this.loadType = loadType;
        String string5 = jSONObject.getString("fitType");
        FitType fitType2 = FitType.CENTER_FULL;
        this.fitType = Intrinsics.areEqual(string5, fitType2.getType()) ? fitType2 : fitType;
        String optString2 = jSONObject.optString(AgooConstants.MESSAGE_BODY_STYLE, "");
        Style style2 = Style.BOLD;
        this.style = Intrinsics.areEqual(optString2, style2.getStyle()) ? style2 : style;
        ALog.INSTANCE.i(TAG, toString() + " color=" + str);
    }

    private final void genDrawSize(Bitmap bitmap) {
        int i;
        int i2;
        int i3;
        int i4;
        if (bitmap != null) {
            i = bitmap.getWidth();
        } else {
            i = this.w;
        }
        if (bitmap != null) {
            i2 = bitmap.getHeight();
        } else {
            i2 = this.h;
        }
        this.drawWidth = i;
        this.drawHeight = i2;
        if (this.fitType == FitType.CENTER_FULL && (i3 = this.w) != 0 && (i4 = this.h) != 0) {
            float f = i / i2;
            if (f >= i3 / i4) {
                this.drawHeight = i4;
                this.drawWidth = (int) (i4 * f);
            } else {
                this.drawWidth = i3;
                this.drawHeight = (int) (i3 / f);
            }
        }
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getDrawHeight() {
        return this.drawHeight;
    }

    public final int getDrawWidth() {
        return this.drawWidth;
    }

    @NotNull
    public final FitType getFitType() {
        return this.fitType;
    }

    public final int getH() {
        return this.h;
    }

    @NotNull
    public final LoadType getLoadType() {
        return this.loadType;
    }

    @NotNull
    public final String getSrcId() {
        return this.srcId;
    }

    @NotNull
    public final String getSrcTag() {
        return this.srcTag;
    }

    public final int getSrcTextureId() {
        return this.srcTextureId;
    }

    @NotNull
    public final SrcType getSrcType() {
        return this.srcType;
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    @NotNull
    public final String getTxt() {
        return this.txt;
    }

    public final int getW() {
        return this.w;
    }

    public final void setBitmap(@Nullable Bitmap bitmap) {
        this.bitmap = bitmap;
        genDrawSize(bitmap);
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final void setDrawHeight(int i) {
        this.drawHeight = i;
    }

    public final void setDrawWidth(int i) {
        this.drawWidth = i;
    }

    public final void setFitType(@NotNull FitType fitType) {
        this.fitType = fitType;
    }

    public final void setH(int i) {
        this.h = i;
    }

    public final void setLoadType(@NotNull LoadType loadType) {
        this.loadType = loadType;
    }

    public final void setSrcId(@NotNull String str) {
        this.srcId = str;
    }

    public final void setSrcTag(@NotNull String str) {
        this.srcTag = str;
    }

    public final void setSrcTextureId(int i) {
        this.srcTextureId = i;
    }

    public final void setSrcType(@NotNull SrcType srcType) {
        this.srcType = srcType;
    }

    public final void setStyle(@NotNull Style style) {
        this.style = style;
    }

    public final void setTxt(@NotNull String str) {
        this.txt = str;
    }

    public final void setW(int i) {
        this.w = i;
    }

    @NotNull
    public String toString() {
        return "Src(srcId='" + this.srcId + "', srcType=" + this.srcType + ", loadType=" + this.loadType + ", srcTag='" + this.srcTag + "', bitmap=" + this.bitmap + ", txt='" + this.txt + "')";
    }
}
