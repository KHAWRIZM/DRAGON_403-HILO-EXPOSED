package androidx.graphics.shapes;

import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001aL\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007\u001a\u0019\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u0014"}, d2 = {"RoundedPolygon", "Landroidx/graphics/shapes/RoundedPolygon;", "source", "vertices", "", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "perVertexRounding", "", "centerX", "", "centerY", "numVertices", "", "radius", "calculateCenter", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "([F)J", "verticesFromNumVerts", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoundedPolygon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoundedPolygon.kt\nandroidx/graphics/shapes/RoundedPolygonKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 FloatFloatPair.kt\nandroidx/collection/FloatFloatPair\n+ 4 PackingHelpers.jvm.kt\nandroidx/collection/internal/PackingHelpers_jvmKt\n*L\n1#1,686:1\n1549#2:687\n1620#2,3:688\n67#3:691\n81#3:693\n22#4:692\n22#4:694\n*S KotlinDebug\n*F\n+ 1 RoundedPolygon.kt\nandroidx/graphics/shapes/RoundedPolygonKt\n*L\n356#1:687\n356#1:688,3\n426#1:691\n425#1:693\n426#1:692\n425#1:694\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class RoundedPolygonKt {
    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10) {
        return RoundedPolygon$default(i10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, null, null, 62, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i10, float f10, float f11, float f12, CornerRounding cornerRounding, List list, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f10 = 1.0f;
        }
        int i12 = i11 & 4;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        float f14 = i12 != 0 ? DownloadProgress.UNKNOWN_PROGRESS : f11;
        if ((i11 & 8) == 0) {
            f13 = f12;
        }
        if ((i11 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        CornerRounding cornerRounding2 = cornerRounding;
        if ((i11 & 32) != 0) {
            list = null;
        }
        return RoundedPolygon(i10, f10, f14, f13, cornerRounding2, list);
    }

    private static final long calculateCenter(float[] fArr) {
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        int i10 = 0;
        while (i10 < fArr.length) {
            int i11 = i10 + 1;
            f10 += fArr[i10];
            i10 += 2;
            f11 += fArr[i11];
        }
        float f12 = 2;
        return FloatFloatPair.m٣constructorimpl((f10 / fArr.length) / f12, (f11 / fArr.length) / f12);
    }

    private static final float[] verticesFromNumVerts(int i10, float f10, float f11, float f12) {
        float[] fArr = new float[i10 * 2];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            long j10 = PointKt.m٤٩plusybeJwSQ(Utils.m٦٧radialToCartesianL6JJ3z0$default(f10, (Utils.getFloatPi() / i10) * 2 * i12, 0L, 4, null), FloatFloatPair.m٣constructorimpl(f11, f12));
            int i13 = i11 + 1;
            fArr[i11] = PointKt.m٤٥getXDnnuFBc(j10);
            i11 += 2;
            fArr[i13] = PointKt.m٤٦getYDnnuFBc(j10);
        }
        return fArr;
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10) {
        return RoundedPolygon$default(i10, f10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, null, null, 60, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10, float f11) {
        return RoundedPolygon$default(i10, f10, f11, DownloadProgress.UNKNOWN_PROGRESS, null, null, 56, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i10 & 4) != 0) {
            list = null;
        }
        if ((i10 & 8) != 0) {
            f10 = Float.MIN_VALUE;
        }
        if ((i10 & 16) != 0) {
            f11 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f10, f11);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10, float f11, float f12) {
        return RoundedPolygon$default(i10, f10, f11, f12, null, null, 48, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10, float f11, float f12, @NotNull CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(i10, f10, f11, f12, rounding, null, 32, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@NotNull float[] vertices) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        return RoundedPolygon$default(vertices, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 30, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@NotNull float[] vertices, @NotNull CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 28, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@NotNull float[] vertices, @NotNull CornerRounding rounding, @Nullable List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 24, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@NotNull float[] vertices, @NotNull CornerRounding rounding, @Nullable List<CornerRounding> list, float f10) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, f10, DownloadProgress.UNKNOWN_PROGRESS, 16, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i10, float f10, float f11, float f12, @NotNull CornerRounding rounding, @Nullable List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i10, f10, f11, f12), rounding, list, f11, f12);
    }

    @NotNull
    public static final RoundedPolygon RoundedPolygon(@NotNull RoundedPolygon source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new RoundedPolygon(source.getFeatures$graphics_shapes_release(), source.getCenterX(), source.getCenterY());
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon RoundedPolygon(@NotNull float[] vertices, @NotNull CornerRounding rounding, @Nullable List<CornerRounding> list, float f10, float f11) {
        long calculateCenter;
        Pair pair;
        CornerRounding cornerRounding;
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        if (vertices.length >= 6) {
            int i10 = 1;
            if (vertices.length % 2 != 1) {
                if (list != null && list.size() * 2 != vertices.length) {
                    throw new IllegalArgumentException("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
                }
                ArrayList arrayList = new ArrayList();
                int length = vertices.length / 2;
                ArrayList arrayList2 = new ArrayList();
                int i11 = 0;
                int i12 = 0;
                while (i12 < length) {
                    CornerRounding cornerRounding2 = (list == null || (cornerRounding = list.get(i12)) == null) ? rounding : cornerRounding;
                    int i13 = (((i12 + length) - i10) % length) * 2;
                    int i14 = i12 + 1;
                    int i15 = (i14 % length) * 2;
                    int i16 = i12 * 2;
                    arrayList2.add(new RoundedCorner(FloatFloatPair.m٣constructorimpl(vertices[i13], vertices[i13 + i10]), FloatFloatPair.m٣constructorimpl(vertices[i16], vertices[i16 + i10]), FloatFloatPair.m٣constructorimpl(vertices[i15], vertices[i15 + i10]), cornerRounding2, null));
                    i12 = i14;
                    i10 = 1;
                }
                kotlin.ranges.IntRange until = RangesKt.until(0, length);
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    int i17 = (nextInt + 1) % length;
                    float expectedRoundCut = ((RoundedCorner) arrayList2.get(nextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i17)).getExpectedRoundCut();
                    float expectedCut = ((RoundedCorner) arrayList2.get(nextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i17)).getExpectedCut();
                    int i18 = nextInt * 2;
                    int i19 = i17 * 2;
                    float distance = Utils.distance(vertices[i18] - vertices[i19], vertices[i18 + 1] - vertices[i19 + 1]);
                    if (expectedRoundCut > distance) {
                        pair = TuplesKt.to(Float.valueOf(distance / expectedRoundCut), Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
                    } else if (expectedCut > distance) {
                        pair = TuplesKt.to(Float.valueOf(1.0f), Float.valueOf((distance - expectedRoundCut) / (expectedCut - expectedRoundCut)));
                    } else {
                        pair = TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(1.0f));
                    }
                    arrayList3.add(pair);
                }
                for (int i20 = 0; i20 < length; i20++) {
                    MutableFloatList mutableFloatList = new MutableFloatList(2);
                    for (int i21 = 0; i21 < 2; i21++) {
                        Pair pair2 = (Pair) arrayList3.get((((i20 + length) - 1) + i21) % length);
                        mutableFloatList.add((((RoundedCorner) arrayList2.get(i20)).getExpectedRoundCut() * ((Number) pair2.component1()).floatValue()) + ((((RoundedCorner) arrayList2.get(i20)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i20)).getExpectedRoundCut()) * ((Number) pair2.component2()).floatValue()));
                    }
                    arrayList.add(((RoundedCorner) arrayList2.get(i20)).getCubics(mutableFloatList.get(0), mutableFloatList.get(1)));
                }
                ArrayList arrayList4 = new ArrayList();
                while (i11 < length) {
                    int i22 = i11 + 1;
                    int i23 = i22 % length;
                    int i24 = i11 * 2;
                    long j10 = FloatFloatPair.m٣constructorimpl(vertices[i24], vertices[i24 + 1]);
                    int i25 = (((i11 + length) - 1) % length) * 2;
                    long j11 = FloatFloatPair.m٣constructorimpl(vertices[i25], vertices[i25 + 1]);
                    int i26 = i23 * 2;
                    arrayList4.add(new Feature.Corner((List) arrayList.get(i11), j10, ((RoundedCorner) arrayList2.get(i11)).getCenter(), PointKt.m٣٦clockwiseybeJwSQ(PointKt.m٤٨minusybeJwSQ(j10, j11), PointKt.m٤٨minusybeJwSQ(FloatFloatPair.m٣constructorimpl(vertices[i26], vertices[i26 + 1]), j10)), null));
                    arrayList4.add(new Feature.Edge(CollectionsKt.listOf(Cubic.INSTANCE.straightLine(((Cubic) CollectionsKt.last((List) arrayList.get(i11))).getAnchor1X(), ((Cubic) CollectionsKt.last((List) arrayList.get(i11))).getAnchor1Y(), ((Cubic) CollectionsKt.first((List) arrayList.get(i23))).getAnchor0X(), ((Cubic) CollectionsKt.first((List) arrayList.get(i23))).getAnchor0Y()))));
                    i11 = i22;
                }
                if (f10 == Float.MIN_VALUE || f11 == Float.MIN_VALUE) {
                    calculateCenter = calculateCenter(vertices);
                } else {
                    calculateCenter = FloatFloatPair.m٣constructorimpl(f10, f11);
                }
                return new RoundedPolygon(arrayList4, Float.intBitsToFloat((int) (calculateCenter >> 32)), Float.intBitsToFloat((int) (calculateCenter & 4294967295L)));
            }
            throw new IllegalArgumentException("The vertices array should have even size");
        }
        throw new IllegalArgumentException("Polygons must have at least 3 vertices");
    }
}
