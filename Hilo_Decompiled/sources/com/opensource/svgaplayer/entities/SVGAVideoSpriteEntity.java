package com.opensource.svgaplayer.entities;

import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteEntity;", "", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "Lcom/opensource/svgaplayer/proto/SpriteEntity;", "(Lcom/opensource/svgaplayer/proto/SpriteEntity;)V", "frames", "", "Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteFrameEntity;", "getFrames", "()Ljava/util/List;", "imageKey", "", "getImageKey", "()Ljava/lang/String;", "matteKey", "getMatteKey", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGAVideoSpriteEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGAVideoSpriteEntity.kt\ncom/opensource/svgaplayer/entities/SVGAVideoSpriteEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n1549#2:62\n1620#2,3:63\n*S KotlinDebug\n*F\n+ 1 SVGAVideoSpriteEntity.kt\ncom/opensource/svgaplayer/entities/SVGAVideoSpriteEntity\n*L\n43#1:62\n43#1:63,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAVideoSpriteEntity {

    @NotNull
    private final List<SVGAVideoSpriteFrameEntity> frames;

    @Nullable
    private final String imageKey;

    @Nullable
    private final String matteKey;

    public SVGAVideoSpriteEntity(@NotNull JSONObject obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.imageKey = obj.optString("imageKey");
        this.matteKey = obj.optString("matteKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = obj.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    Intrinsics.checkNotNull(optJSONObject);
                    SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity = new SVGAVideoSpriteFrameEntity(optJSONObject);
                    if (!sVGAVideoSpriteFrameEntity.getShapes().isEmpty() && ((SVGAVideoShapeEntity) CollectionsKt.first((List) sVGAVideoSpriteFrameEntity.getShapes())).isKeep() && arrayList.size() > 0) {
                        sVGAVideoSpriteFrameEntity.setShapes(((SVGAVideoSpriteFrameEntity) CollectionsKt.last((List) arrayList)).getShapes());
                    }
                    arrayList.add(sVGAVideoSpriteFrameEntity);
                }
            }
        }
        this.frames = CollectionsKt.toList(arrayList);
    }

    @NotNull
    public final List<SVGAVideoSpriteFrameEntity> getFrames() {
        return this.frames;
    }

    @Nullable
    public final String getImageKey() {
        return this.imageKey;
    }

    @Nullable
    public final String getMatteKey() {
        return this.matteKey;
    }

    public SVGAVideoSpriteEntity(@NotNull SpriteEntity obj) {
        List<SVGAVideoSpriteFrameEntity> emptyList;
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.imageKey = obj.imageKey;
        this.matteKey = obj.matteKey;
        List<FrameEntity> list = obj.frames;
        if (list != null) {
            emptyList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list, 10));
            SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity = null;
            for (FrameEntity frameEntity : list) {
                Intrinsics.checkNotNull(frameEntity);
                SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity2 = new SVGAVideoSpriteFrameEntity(frameEntity);
                if (!sVGAVideoSpriteFrameEntity2.getShapes().isEmpty() && ((SVGAVideoShapeEntity) CollectionsKt.first((List) sVGAVideoSpriteFrameEntity2.getShapes())).isKeep() && sVGAVideoSpriteFrameEntity != null) {
                    sVGAVideoSpriteFrameEntity2.setShapes(sVGAVideoSpriteFrameEntity.getShapes());
                }
                emptyList.add(sVGAVideoSpriteFrameEntity2);
                sVGAVideoSpriteFrameEntity = sVGAVideoSpriteFrameEntity2;
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        this.frames = emptyList;
    }
}
