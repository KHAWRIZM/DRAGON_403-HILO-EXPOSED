package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0002./B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010-\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R:\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00060"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "Lcom/opensource/svgaplayer/proto/ShapeEntity;", "(Lcom/opensource/svgaplayer/proto/ShapeEntity;)V", "<set-?>", "", "", "args", "getArgs", "()Ljava/util/Map;", "isKeep", "", "()Z", "shapePath", "Landroid/graphics/Path;", "getShapePath", "()Landroid/graphics/Path;", "setShapePath", "(Landroid/graphics/Path;)V", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "styles", "getStyles", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "Landroid/graphics/Matrix;", "transform", "getTransform", "()Landroid/graphics/Matrix;", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "type", "getType", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "buildPath", "", "checkAlphaValueRange", "", "color", "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$RGBAColor;", "Lorg/json/JSONArray;", "checkValueRange", "parseArgs", "parseStyles", "parseTransform", "parseType", "Styles", "Type", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGAVideoShapeEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGAVideoShapeEntity.kt\ncom/opensource/svgaplayer/entities/SVGAVideoShapeEntity\n+ 2 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,357:1\n32#2,2:358\n1#3:360\n*S KotlinDebug\n*F\n+ 1 SVGAVideoShapeEntity.kt\ncom/opensource/svgaplayer/entities/SVGAVideoShapeEntity\n*L\n108#1:358,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAVideoShapeEntity {

    @Nullable
    private Map<String, ? extends Object> args;

    @Nullable
    private Path shapePath;

    @Nullable
    private Styles styles;

    @Nullable
    private Matrix transform;

    @NotNull
    private Type type;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "", "()V", "<set-?>", "", "fill", "getFill", "()I", "setFill$lib_svga_release", "(I)V", "", "lineCap", "getLineCap", "()Ljava/lang/String;", "setLineCap$lib_svga_release", "(Ljava/lang/String;)V", "", "lineDash", "getLineDash", "()[F", "setLineDash$lib_svga_release", "([F)V", "lineJoin", "getLineJoin", "setLineJoin$lib_svga_release", "miterLimit", "getMiterLimit", "setMiterLimit$lib_svga_release", "stroke", "getStroke", "setStroke$lib_svga_release", "", "strokeWidth", "getStrokeWidth", "()F", "setStrokeWidth$lib_svga_release", "(F)V", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Styles {
        private int fill;
        private int miterLimit;
        private int stroke;
        private float strokeWidth;

        @NotNull
        private String lineCap = "butt";

        @NotNull
        private String lineJoin = "miter";

        @NotNull
        private float[] lineDash = new float[0];

        public final int getFill() {
            return this.fill;
        }

        @NotNull
        public final String getLineCap() {
            return this.lineCap;
        }

        @NotNull
        public final float[] getLineDash() {
            return this.lineDash;
        }

        @NotNull
        public final String getLineJoin() {
            return this.lineJoin;
        }

        public final int getMiterLimit() {
            return this.miterLimit;
        }

        public final int getStroke() {
            return this.stroke;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final void setFill$lib_svga_release(int i10) {
            this.fill = i10;
        }

        public final void setLineCap$lib_svga_release(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lineCap = str;
        }

        public final void setLineDash$lib_svga_release(@NotNull float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.lineDash = fArr;
        }

        public final void setLineJoin$lib_svga_release(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lineJoin = str;
        }

        public final void setMiterLimit$lib_svga_release(int i10) {
            this.miterLimit = i10;
        }

        public final void setStroke$lib_svga_release(int i10) {
            this.stroke = i10;
        }

        public final void setStrokeWidth$lib_svga_release(float f10) {
            this.strokeWidth = f10;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "", "(Ljava/lang/String;I)V", "shape", "rect", "ellipse", "keep", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type shape = new Type("shape", 0);
        public static final Type rect = new Type("rect", 1);
        public static final Type ellipse = new Type("ellipse", 2);
        public static final Type keep = new Type("keep", 3);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{shape, rect, ellipse, keep};
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Type(String str, int i10) {
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ShapeEntity.ShapeType.values().length];
            try {
                iArr[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
            try {
                iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
            try {
                iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public SVGAVideoShapeEntity(@NotNull JSONObject obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.type = Type.shape;
        parseType(obj);
        parseArgs(obj);
        parseStyles(obj);
        parseTransform(obj);
    }

    private final float checkAlphaValueRange(JSONArray obj) {
        return obj.optDouble(3) <= 1.0d ? 255.0f : 1.0f;
    }

    private final float checkValueRange(JSONArray obj) {
        return (obj.optDouble(0) > 1.0d || obj.optDouble(1) > 1.0d || obj.optDouble(2) > 1.0d) ? 1.0f : 255.0f;
    }

    private final void parseArgs(JSONObject obj) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = obj.optJSONObject("args");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj2 = optJSONObject.get(next);
                if (obj2 != null) {
                    Intrinsics.checkNotNull(obj2);
                    hashMap.put(next, obj2);
                }
            }
            this.args = hashMap;
        }
    }

    private final void parseStyles(JSONObject obj) {
        JSONObject optJSONObject = obj.optJSONObject("styles");
        if (optJSONObject != null) {
            Styles styles = new Styles();
            JSONArray optJSONArray = optJSONObject.optJSONArray("fill");
            if (optJSONArray != null) {
                Intrinsics.checkNotNull(optJSONArray);
                if (optJSONArray.length() == 4) {
                    double checkValueRange = checkValueRange(optJSONArray);
                    styles.setFill$lib_svga_release(Color.argb((int) (optJSONArray.optDouble(3) * checkAlphaValueRange(optJSONArray)), (int) (optJSONArray.optDouble(0) * checkValueRange), (int) (optJSONArray.optDouble(1) * checkValueRange), (int) (optJSONArray.optDouble(2) * checkValueRange)));
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null) {
                Intrinsics.checkNotNull(optJSONArray2);
                if (optJSONArray2.length() == 4) {
                    double checkValueRange2 = checkValueRange(optJSONArray2);
                    styles.setStroke$lib_svga_release(Color.argb((int) (optJSONArray2.optDouble(3) * checkAlphaValueRange(optJSONArray2)), (int) (optJSONArray2.optDouble(0) * checkValueRange2), (int) (optJSONArray2.optDouble(1) * checkValueRange2), (int) (optJSONArray2.optDouble(2) * checkValueRange2)));
                }
            }
            styles.setStrokeWidth$lib_svga_release((float) optJSONObject.optDouble("strokeWidth", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
            String optString = optJSONObject.optString("lineCap", "butt");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
            styles.setLineCap$lib_svga_release(optString);
            String optString2 = optJSONObject.optString("lineJoin", "miter");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
            styles.setLineJoin$lib_svga_release(optString2);
            styles.setMiterLimit$lib_svga_release(optJSONObject.optInt("miterLimit", 0));
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("lineDash");
            if (optJSONArray3 != null) {
                Intrinsics.checkNotNull(optJSONArray3);
                styles.setLineDash$lib_svga_release(new float[optJSONArray3.length()]);
                int length = optJSONArray3.length();
                for (int i10 = 0; i10 < length; i10++) {
                    styles.getLineDash()[i10] = (float) optJSONArray3.optDouble(i10, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                }
            }
            this.styles = styles;
        }
    }

    private final void parseTransform(JSONObject obj) {
        JSONObject optJSONObject = obj.optJSONObject("transform");
        if (optJSONObject != null) {
            Matrix matrix = new Matrix();
            double optDouble = optJSONObject.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject.optDouble("b", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double optDouble3 = optJSONObject.optDouble("c", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double optDouble4 = optJSONObject.optDouble("d", 1.0d);
            matrix.setValues(new float[]{(float) optDouble, (float) optDouble3, (float) optJSONObject.optDouble("tx", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (float) optDouble2, (float) optDouble4, (float) optJSONObject.optDouble("ty", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f});
            this.transform = matrix;
        }
    }

    private final void parseType(JSONObject obj) {
        String optString = obj.optString("type");
        if (optString != null) {
            if (StringsKt.equals(optString, "shape", true)) {
                this.type = Type.shape;
                return;
            }
            if (StringsKt.equals(optString, "rect", true)) {
                this.type = Type.rect;
            } else if (StringsKt.equals(optString, "ellipse", true)) {
                this.type = Type.ellipse;
            } else if (StringsKt.equals(optString, "keep", true)) {
                this.type = Type.keep;
            }
        }
    }

    public final void buildPath() {
        Object obj;
        Number number;
        Object obj2;
        Number number2;
        Object obj3;
        Number number3;
        Object obj4;
        Number number4;
        Object obj5;
        Object obj6;
        Number number5;
        Object obj7;
        Number number6;
        Object obj8;
        Number number7;
        Object obj9;
        Object obj10;
        if (this.shapePath != null) {
            return;
        }
        SVGAVideoShapeEntityKt.getSharedPath().reset();
        Type type = this.type;
        Number number8 = null;
        String str = null;
        Number number9 = null;
        if (type == Type.shape) {
            Map<String, ? extends Object> map = this.args;
            if (map != null) {
                obj10 = map.get("d");
            } else {
                obj10 = null;
            }
            if (obj10 instanceof String) {
                str = (String) obj10;
            }
            if (str != null) {
                new SVGAPathEntity(str).buildPath(SVGAVideoShapeEntityKt.getSharedPath());
            }
        } else if (type == Type.ellipse) {
            Map<String, ? extends Object> map2 = this.args;
            if (map2 != null) {
                obj6 = map2.get("x");
            } else {
                obj6 = null;
            }
            if (obj6 instanceof Number) {
                number5 = (Number) obj6;
            } else {
                number5 = null;
            }
            if (number5 == null) {
                return;
            }
            Map<String, ? extends Object> map3 = this.args;
            if (map3 != null) {
                obj7 = map3.get("y");
            } else {
                obj7 = null;
            }
            if (obj7 instanceof Number) {
                number6 = (Number) obj7;
            } else {
                number6 = null;
            }
            if (number6 == null) {
                return;
            }
            Map<String, ? extends Object> map4 = this.args;
            if (map4 != null) {
                obj8 = map4.get("radiusX");
            } else {
                obj8 = null;
            }
            if (obj8 instanceof Number) {
                number7 = (Number) obj8;
            } else {
                number7 = null;
            }
            if (number7 == null) {
                return;
            }
            Map<String, ? extends Object> map5 = this.args;
            if (map5 != null) {
                obj9 = map5.get("radiusY");
            } else {
                obj9 = null;
            }
            if (obj9 instanceof Number) {
                number9 = (Number) obj9;
            }
            if (number9 == null) {
                return;
            }
            float floatValue = number5.floatValue();
            float floatValue2 = number6.floatValue();
            float floatValue3 = number7.floatValue();
            float floatValue4 = number9.floatValue();
            SVGAVideoShapeEntityKt.getSharedPath().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
        } else if (type == Type.rect) {
            Map<String, ? extends Object> map6 = this.args;
            if (map6 != null) {
                obj = map6.get("x");
            } else {
                obj = null;
            }
            if (obj instanceof Number) {
                number = (Number) obj;
            } else {
                number = null;
            }
            if (number == null) {
                return;
            }
            Map<String, ? extends Object> map7 = this.args;
            if (map7 != null) {
                obj2 = map7.get("y");
            } else {
                obj2 = null;
            }
            if (obj2 instanceof Number) {
                number2 = (Number) obj2;
            } else {
                number2 = null;
            }
            if (number2 == null) {
                return;
            }
            Map<String, ? extends Object> map8 = this.args;
            if (map8 != null) {
                obj3 = map8.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            } else {
                obj3 = null;
            }
            if (obj3 instanceof Number) {
                number3 = (Number) obj3;
            } else {
                number3 = null;
            }
            if (number3 == null) {
                return;
            }
            Map<String, ? extends Object> map9 = this.args;
            if (map9 != null) {
                obj4 = map9.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            } else {
                obj4 = null;
            }
            if (obj4 instanceof Number) {
                number4 = (Number) obj4;
            } else {
                number4 = null;
            }
            if (number4 == null) {
                return;
            }
            Map<String, ? extends Object> map10 = this.args;
            if (map10 != null) {
                obj5 = map10.get("cornerRadius");
            } else {
                obj5 = null;
            }
            if (obj5 instanceof Number) {
                number8 = (Number) obj5;
            }
            if (number8 == null) {
                return;
            }
            float floatValue5 = number.floatValue();
            float floatValue6 = number2.floatValue();
            float floatValue7 = number3.floatValue();
            float floatValue8 = number4.floatValue();
            float floatValue9 = number8.floatValue();
            SVGAVideoShapeEntityKt.getSharedPath().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
        }
        Path path = new Path();
        this.shapePath = path;
        path.set(SVGAVideoShapeEntityKt.getSharedPath());
    }

    @Nullable
    public final Map<String, Object> getArgs() {
        return this.args;
    }

    @Nullable
    public final Path getShapePath() {
        return this.shapePath;
    }

    @Nullable
    public final Styles getStyles() {
        return this.styles;
    }

    @Nullable
    public final Matrix getTransform() {
        return this.transform;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    public final boolean isKeep() {
        if (this.type == Type.keep) {
            return true;
        }
        return false;
    }

    public final void setShapePath(@Nullable Path path) {
        this.shapePath = path;
    }

    private final float checkAlphaValueRange(ShapeEntity.ShapeStyle.RGBAColor color) {
        Float a10 = color.f١٢٠٩٦a;
        Intrinsics.checkNotNullExpressionValue(a10, "a");
        return a10.floatValue() <= 1.0f ? 255.0f : 1.0f;
    }

    private final float checkValueRange(ShapeEntity.ShapeStyle.RGBAColor color) {
        Float f10 = color.f١٢٠٩٩r;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        if ((f10 == null ? DownloadProgress.UNKNOWN_PROGRESS : f10.floatValue()) > 1.0f) {
            return 1.0f;
        }
        Float f12 = color.f١٢٠٩٨g;
        if ((f12 == null ? DownloadProgress.UNKNOWN_PROGRESS : f12.floatValue()) > 1.0f) {
            return 1.0f;
        }
        Float f13 = color.f١٢٠٩٧b;
        if (f13 != null) {
            f11 = f13.floatValue();
        }
        return f11 <= 1.0f ? 255.0f : 1.0f;
    }

    private final void parseType(ShapeEntity obj) {
        Type type;
        ShapeEntity.ShapeType shapeType = obj.type;
        if (shapeType != null) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[shapeType.ordinal()];
            if (i10 == 1) {
                type = Type.shape;
            } else if (i10 == 2) {
                type = Type.rect;
            } else if (i10 == 3) {
                type = Type.ellipse;
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                type = Type.keep;
            }
            this.type = type;
        }
    }

    public SVGAVideoShapeEntity(@NotNull ShapeEntity obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.type = Type.shape;
        parseType(obj);
        parseArgs(obj);
        parseStyles(obj);
        parseTransform(obj);
    }

    private final void parseArgs(ShapeEntity obj) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        float floatValue5;
        float floatValue6;
        float floatValue7;
        float floatValue8;
        String str;
        HashMap hashMap = new HashMap();
        ShapeEntity.ShapeArgs shapeArgs = obj.shape;
        if (shapeArgs != null && (str = shapeArgs.f١٢٠٩٤d) != null) {
            Intrinsics.checkNotNull(str);
            hashMap.put("d", str);
        }
        ShapeEntity.EllipseArgs ellipseArgs = obj.ellipse;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        if (ellipseArgs != null) {
            Float f11 = ellipseArgs.f١٢٠٨٦x;
            if (f11 == null) {
                floatValue5 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f11);
                floatValue5 = f11.floatValue();
            }
            hashMap.put("x", Float.valueOf(floatValue5));
            Float f12 = ellipseArgs.f١٢٠٨٧y;
            if (f12 == null) {
                floatValue6 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f12);
                floatValue6 = f12.floatValue();
            }
            hashMap.put("y", Float.valueOf(floatValue6));
            Float f13 = ellipseArgs.radiusX;
            if (f13 == null) {
                floatValue7 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f13);
                floatValue7 = f13.floatValue();
            }
            hashMap.put("radiusX", Float.valueOf(floatValue7));
            Float f14 = ellipseArgs.radiusY;
            if (f14 == null) {
                floatValue8 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f14);
                floatValue8 = f14.floatValue();
            }
            hashMap.put("radiusY", Float.valueOf(floatValue8));
        }
        ShapeEntity.RectArgs rectArgs = obj.rect;
        if (rectArgs != null) {
            Float f15 = rectArgs.f١٢٠٩٠x;
            if (f15 == null) {
                floatValue = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f15);
                floatValue = f15.floatValue();
            }
            hashMap.put("x", Float.valueOf(floatValue));
            Float f16 = rectArgs.f١٢٠٩١y;
            if (f16 == null) {
                floatValue2 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f16);
                floatValue2 = f16.floatValue();
            }
            hashMap.put("y", Float.valueOf(floatValue2));
            Float f17 = rectArgs.width;
            if (f17 == null) {
                floatValue3 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f17);
                floatValue3 = f17.floatValue();
            }
            hashMap.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Float.valueOf(floatValue3));
            Float f18 = rectArgs.height;
            if (f18 == null) {
                floatValue4 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f18);
                floatValue4 = f18.floatValue();
            }
            hashMap.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, Float.valueOf(floatValue4));
            Float f19 = rectArgs.cornerRadius;
            if (f19 != null) {
                Intrinsics.checkNotNull(f19);
                f10 = f19.floatValue();
            }
            hashMap.put("cornerRadius", Float.valueOf(f10));
        }
        this.args = hashMap;
    }

    private final void parseTransform(ShapeEntity obj) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        float floatValue5;
        float floatValue6;
        Transform transform = obj.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            Float f10 = transform.f١٢١٠٤a;
            if (f10 == null) {
                floatValue = 1.0f;
            } else {
                Intrinsics.checkNotNull(f10);
                floatValue = f10.floatValue();
            }
            Float f11 = transform.f١٢١٠٥b;
            if (f11 == null) {
                floatValue2 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f11);
                floatValue2 = f11.floatValue();
            }
            Float f12 = transform.f١٢١٠٦c;
            if (f12 == null) {
                floatValue3 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f12);
                floatValue3 = f12.floatValue();
            }
            Float f13 = transform.f١٢١٠٧d;
            if (f13 == null) {
                floatValue4 = 1.0f;
            } else {
                Intrinsics.checkNotNull(f13);
                floatValue4 = f13.floatValue();
            }
            Float f14 = transform.tx;
            if (f14 == null) {
                floatValue5 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f14);
                floatValue5 = f14.floatValue();
            }
            Float f15 = transform.ty;
            if (f15 == null) {
                floatValue6 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f15);
                floatValue6 = f15.floatValue();
            }
            matrix.setValues(new float[]{floatValue, floatValue3, floatValue5, floatValue2, floatValue4, floatValue6, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f});
            this.transform = matrix;
        }
    }

    private final void parseStyles(ShapeEntity obj) {
        float floatValue;
        ShapeEntity.ShapeStyle shapeStyle = obj.styles;
        if (shapeStyle != null) {
            Styles styles = new Styles();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            float f10 = DownloadProgress.UNKNOWN_PROGRESS;
            if (rGBAColor != null) {
                Intrinsics.checkNotNull(rGBAColor);
                float checkValueRange = checkValueRange(rGBAColor);
                float checkAlphaValueRange = checkAlphaValueRange(rGBAColor);
                Float f11 = rGBAColor.f١٢٠٩٦a;
                int floatValue2 = (int) ((f11 != null ? f11.floatValue() : DownloadProgress.UNKNOWN_PROGRESS) * checkAlphaValueRange);
                Float f12 = rGBAColor.f١٢٠٩٩r;
                int floatValue3 = (int) ((f12 != null ? f12.floatValue() : DownloadProgress.UNKNOWN_PROGRESS) * checkValueRange);
                Float f13 = rGBAColor.f١٢٠٩٨g;
                int floatValue4 = (int) ((f13 != null ? f13.floatValue() : DownloadProgress.UNKNOWN_PROGRESS) * checkValueRange);
                Float f14 = rGBAColor.f١٢٠٩٧b;
                styles.setFill$lib_svga_release(Color.argb(floatValue2, floatValue3, floatValue4, (int) ((f14 != null ? f14.floatValue() : DownloadProgress.UNKNOWN_PROGRESS) * checkValueRange)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                Intrinsics.checkNotNull(rGBAColor2);
                float checkValueRange2 = checkValueRange(rGBAColor2);
                float checkAlphaValueRange2 = checkAlphaValueRange(rGBAColor2);
                Float f15 = rGBAColor2.f١٢٠٩٦a;
                int floatValue5 = (int) ((f15 != null ? f15.floatValue() : DownloadProgress.UNKNOWN_PROGRESS) * checkAlphaValueRange2);
                Float f16 = rGBAColor2.f١٢٠٩٩r;
                int floatValue6 = (int) ((f16 != null ? f16.floatValue() : DownloadProgress.UNKNOWN_PROGRESS) * checkValueRange2);
                Float f17 = rGBAColor2.f١٢٠٩٨g;
                int floatValue7 = (int) ((f17 != null ? f17.floatValue() : DownloadProgress.UNKNOWN_PROGRESS) * checkValueRange2);
                Float f18 = rGBAColor2.f١٢٠٩٧b;
                styles.setStroke$lib_svga_release(Color.argb(floatValue5, floatValue6, floatValue7, (int) ((f18 != null ? f18.floatValue() : DownloadProgress.UNKNOWN_PROGRESS) * checkValueRange2)));
            }
            Float f19 = shapeStyle.strokeWidth;
            if (f19 == null) {
                floatValue = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f19);
                floatValue = f19.floatValue();
            }
            styles.setStrokeWidth$lib_svga_release(floatValue);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                Intrinsics.checkNotNull(lineCap);
                int i10 = WhenMappings.$EnumSwitchMapping$1[lineCap.ordinal()];
                if (i10 == 1) {
                    styles.setLineCap$lib_svga_release("butt");
                } else if (i10 == 2) {
                    styles.setLineCap$lib_svga_release("round");
                } else if (i10 == 3) {
                    styles.setLineCap$lib_svga_release("square");
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                Intrinsics.checkNotNull(lineJoin);
                int i11 = WhenMappings.$EnumSwitchMapping$2[lineJoin.ordinal()];
                if (i11 == 1) {
                    styles.setLineJoin$lib_svga_release("bevel");
                } else if (i11 == 2) {
                    styles.setLineJoin$lib_svga_release("miter");
                } else if (i11 == 3) {
                    styles.setLineJoin$lib_svga_release("round");
                }
            }
            Float f20 = shapeStyle.miterLimit;
            if (f20 != null) {
                f10 = f20.floatValue();
            }
            styles.setMiterLimit$lib_svga_release((int) f10);
            styles.setLineDash$lib_svga_release(new float[3]);
            Float f21 = shapeStyle.lineDashI;
            if (f21 != null) {
                Intrinsics.checkNotNull(f21);
                styles.getLineDash()[0] = f21.floatValue();
            }
            Float f22 = shapeStyle.lineDashII;
            if (f22 != null) {
                Intrinsics.checkNotNull(f22);
                styles.getLineDash()[1] = f22.floatValue();
            }
            Float f23 = shapeStyle.lineDashIII;
            if (f23 != null) {
                Intrinsics.checkNotNull(f23);
                styles.getLineDash()[2] = f23.floatValue();
            }
            this.styles = styles;
        }
    }
}
