package com.opensource.svgaplayer.entities;

import android.graphics.Matrix;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import com.opensource.svgaplayer.utils.SVGARect;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteFrameEntity;", "", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "Lcom/opensource/svgaplayer/proto/FrameEntity;", "(Lcom/opensource/svgaplayer/proto/FrameEntity;)V", "alpha", "", "getAlpha", "()D", "setAlpha", "(D)V", "layout", "Lcom/opensource/svgaplayer/utils/SVGARect;", "getLayout", "()Lcom/opensource/svgaplayer/utils/SVGARect;", "setLayout", "(Lcom/opensource/svgaplayer/utils/SVGARect;)V", "maskPath", "Lcom/opensource/svgaplayer/entities/SVGAPathEntity;", "getMaskPath", "()Lcom/opensource/svgaplayer/entities/SVGAPathEntity;", "setMaskPath", "(Lcom/opensource/svgaplayer/entities/SVGAPathEntity;)V", "shapes", "", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "getShapes", "()Ljava/util/List;", "setShapes", "(Ljava/util/List;)V", "transform", "Landroid/graphics/Matrix;", "getTransform", "()Landroid/graphics/Matrix;", "setTransform", "(Landroid/graphics/Matrix;)V", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGAVideoSpriteFrameEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGAVideoSpriteFrameEntity.kt\ncom/opensource/svgaplayer/entities/SVGAVideoSpriteFrameEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1#2:96\n1549#3:97\n1620#3,3:98\n*S KotlinDebug\n*F\n+ 1 SVGAVideoSpriteFrameEntity.kt\ncom/opensource/svgaplayer/entities/SVGAVideoSpriteFrameEntity\n*L\n89#1:97\n89#1:98,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAVideoSpriteFrameEntity {
    private double alpha;

    @NotNull
    private SVGARect layout;

    @Nullable
    private SVGAPathEntity maskPath;

    @NotNull
    private List<SVGAVideoShapeEntity> shapes;

    @NotNull
    private Matrix transform;

    public SVGAVideoSpriteFrameEntity(@NotNull JSONObject obj) {
        SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity = this;
        Intrinsics.checkNotNullParameter(obj, "obj");
        sVGAVideoSpriteFrameEntity.layout = new SVGARect(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        sVGAVideoSpriteFrameEntity.transform = new Matrix();
        sVGAVideoSpriteFrameEntity.shapes = CollectionsKt.emptyList();
        sVGAVideoSpriteFrameEntity.alpha = obj.optDouble("alpha", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        JSONObject optJSONObject = obj.optJSONObject("layout");
        if (optJSONObject != null) {
            sVGAVideoSpriteFrameEntity.layout = new SVGARect(optJSONObject.optDouble("x", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), optJSONObject.optDouble("y", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        }
        JSONObject optJSONObject2 = obj.optJSONObject("transform");
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double optDouble3 = optJSONObject2.optDouble("c", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double optDouble4 = optJSONObject2.optDouble("d", 1.0d);
            float[] fArr = {(float) optDouble, (float) optDouble3, (float) optJSONObject2.optDouble("tx", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (float) optDouble2, (float) optDouble4, (float) optJSONObject2.optDouble("ty", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f};
            sVGAVideoSpriteFrameEntity = this;
            sVGAVideoSpriteFrameEntity.transform.setValues(fArr);
        }
        String optString = obj.optString("clipPath");
        if (optString != null && optString.length() > 0) {
            sVGAVideoSpriteFrameEntity.maskPath = new SVGAPathEntity(optString);
        }
        JSONArray optJSONArray = obj.optJSONArray("shapes");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i10);
                if (optJSONObject3 != null) {
                    Intrinsics.checkNotNull(optJSONObject3);
                    arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
                }
            }
            sVGAVideoSpriteFrameEntity.shapes = CollectionsKt.toList(arrayList);
        }
    }

    public final double getAlpha() {
        return this.alpha;
    }

    @NotNull
    public final SVGARect getLayout() {
        return this.layout;
    }

    @Nullable
    public final SVGAPathEntity getMaskPath() {
        return this.maskPath;
    }

    @NotNull
    public final List<SVGAVideoShapeEntity> getShapes() {
        return this.shapes;
    }

    @NotNull
    public final Matrix getTransform() {
        return this.transform;
    }

    public final void setAlpha(double d10) {
        this.alpha = d10;
    }

    public final void setLayout(@NotNull SVGARect sVGARect) {
        Intrinsics.checkNotNullParameter(sVGARect, "<set-?>");
        this.layout = sVGARect;
    }

    public final void setMaskPath(@Nullable SVGAPathEntity sVGAPathEntity) {
        this.maskPath = sVGAPathEntity;
    }

    public final void setShapes(@NotNull List<SVGAVideoShapeEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.shapes = list;
    }

    public final void setTransform(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "<set-?>");
        this.transform = matrix;
    }

    public SVGAVideoSpriteFrameEntity(@NotNull FrameEntity obj) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        float floatValue5;
        float floatValue6;
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.layout = new SVGARect(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.transform = new Matrix();
        this.shapes = CollectionsKt.emptyList();
        this.alpha = obj.alpha != null ? r1.floatValue() : DownloadProgress.UNKNOWN_PROGRESS;
        Layout layout = obj.layout;
        if (layout != null) {
            Float f10 = layout.f١٢٠٨٢x;
            double floatValue7 = f10 != null ? f10.floatValue() : DownloadProgress.UNKNOWN_PROGRESS;
            Float f11 = layout.f١٢٠٨٣y;
            double floatValue8 = f11 != null ? f11.floatValue() : DownloadProgress.UNKNOWN_PROGRESS;
            Float f12 = layout.width;
            this.layout = new SVGARect(floatValue7, floatValue8, f12 != null ? f12.floatValue() : DownloadProgress.UNKNOWN_PROGRESS, layout.height != null ? r1.floatValue() : DownloadProgress.UNKNOWN_PROGRESS);
        }
        Transform transform = obj.transform;
        if (transform != null) {
            Float f13 = transform.f١٢١٠٤a;
            if (f13 == null) {
                floatValue = 1.0f;
            } else {
                Intrinsics.checkNotNull(f13);
                floatValue = f13.floatValue();
            }
            Float f14 = transform.f١٢١٠٥b;
            if (f14 == null) {
                floatValue2 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f14);
                floatValue2 = f14.floatValue();
            }
            Float f15 = transform.f١٢١٠٦c;
            if (f15 == null) {
                floatValue3 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f15);
                floatValue3 = f15.floatValue();
            }
            Float f16 = transform.f١٢١٠٧d;
            if (f16 == null) {
                floatValue4 = 1.0f;
            } else {
                Intrinsics.checkNotNull(f16);
                floatValue4 = f16.floatValue();
            }
            Float f17 = transform.tx;
            if (f17 == null) {
                floatValue5 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f17);
                floatValue5 = f17.floatValue();
            }
            Float f18 = transform.ty;
            if (f18 == null) {
                floatValue6 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                Intrinsics.checkNotNull(f18);
                floatValue6 = f18.floatValue();
            }
            this.transform.setValues(new float[]{floatValue, floatValue3, floatValue5, floatValue2, floatValue4, floatValue6, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f});
        }
        String str = obj.clipPath;
        if (str != null) {
            str = str.length() <= 0 ? null : str;
            if (str != null) {
                this.maskPath = new SVGAPathEntity(str);
            }
        }
        List<ShapeEntity> shapes = obj.shapes;
        Intrinsics.checkNotNullExpressionValue(shapes, "shapes");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(shapes, 10));
        for (ShapeEntity shapeEntity : shapes) {
            Intrinsics.checkNotNull(shapeEntity);
            arrayList.add(new SVGAVideoShapeEntity(shapeEntity));
        }
        this.shapes = arrayList;
    }
}
