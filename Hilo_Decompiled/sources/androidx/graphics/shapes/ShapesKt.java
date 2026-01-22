package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.RoundedPolygon;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a0\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a4\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001a>\u0010\u0012\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001a\u0084\u0001\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007\u001aN\u0010\u001b\u001a\u00020\u000f*\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u001ad\u0010\u001c\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007¨\u0006\u001d"}, d2 = {"pillStarVerticesFromNumVerts", "", "numVerticesPerRadius", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "innerRadius", "vertexSpacing", "startLocation", "centerX", "centerY", "starVerticesFromNumVerts", "radius", "circle", "Landroidx/graphics/shapes/RoundedPolygon;", "Landroidx/graphics/shapes/RoundedPolygon$Companion;", "numVertices", "pill", "smoothing", "pillStar", "innerRadiusRatio", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "innerRounding", "perVertexRounding", "", "rectangle", "star", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShapes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Shapes.kt\nandroidx/graphics/shapes/ShapesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,459:1\n1360#2:460\n1446#2,5:461\n1360#2:466\n1446#2,5:467\n*S KotlinDebug\n*F\n+ 1 Shapes.kt\nandroidx/graphics/shapes/ShapesKt\n*L\n155#1:460\n155#1:461,5\n294#1:466\n294#1:467,5\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class ShapesKt {
    @JvmOverloads
    @NotNull
    public static final RoundedPolygon circle(@NotNull RoundedPolygon.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return circle$default(companion, 0, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 15, null);
    }

    public static /* synthetic */ RoundedPolygon circle$default(RoundedPolygon.Companion companion, int i10, float f10, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 8;
        }
        if ((i11 & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i11 & 4) != 0) {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if ((i11 & 8) != 0) {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        return circle(companion, i10, f10, f11, f12);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pill(@NotNull RoundedPolygon.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pill$default(companion, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 31, null);
    }

    public static /* synthetic */ RoundedPolygon pill$default(RoundedPolygon.Companion companion, float f10, float f11, float f12, float f13, float f14, int i10, Object obj) {
        float f15;
        float f16;
        float f17;
        if ((i10 & 1) != 0) {
            f10 = 2.0f;
        }
        if ((i10 & 2) != 0) {
            f15 = 1.0f;
        } else {
            f15 = f11;
        }
        int i11 = i10 & 4;
        float f18 = DownloadProgress.UNKNOWN_PROGRESS;
        if (i11 != 0) {
            f16 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f16 = f12;
        }
        if ((i10 & 8) != 0) {
            f17 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f17 = f13;
        }
        if ((i10 & 16) == 0) {
            f18 = f14;
        }
        return pill(companion, f10, f15, f16, f17, f18);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pillStar$default(companion, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0, DownloadProgress.UNKNOWN_PROGRESS, null, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 2047, null);
    }

    public static /* synthetic */ RoundedPolygon pillStar$default(RoundedPolygon.Companion companion, float f10, float f11, int i10, float f12, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f13, float f14, float f15, float f16, int i11, Object obj) {
        float f17 = (i11 & 1) != 0 ? 2.0f : f10;
        float f18 = (i11 & 2) != 0 ? 1.0f : f11;
        int i12 = (i11 & 4) != 0 ? 8 : i10;
        float f19 = (i11 & 8) != 0 ? 0.5f : f12;
        CornerRounding cornerRounding3 = (i11 & 16) != 0 ? CornerRounding.Unrounded : cornerRounding;
        CornerRounding cornerRounding4 = (i11 & 32) != 0 ? null : cornerRounding2;
        List list2 = (i11 & 64) == 0 ? list : null;
        float f20 = (i11 & 128) == 0 ? f13 : 0.5f;
        int i13 = i11 & 256;
        float f21 = DownloadProgress.UNKNOWN_PROGRESS;
        float f22 = i13 != 0 ? DownloadProgress.UNKNOWN_PROGRESS : f14;
        float f23 = (i11 & 512) != 0 ? DownloadProgress.UNKNOWN_PROGRESS : f15;
        if ((i11 & 1024) == 0) {
            f21 = f16;
        }
        return pillStar(companion, f17, f18, i12, f19, cornerRounding3, cornerRounding4, list2, f20, f22, f23, f21);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x00c6. Please report as an issue. */
    private static final float[] pillStarVerticesFromNumVerts(int i10, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        float f17;
        float f18;
        float f19;
        float f20;
        long j10;
        long j11;
        float f21 = f12;
        float min = Math.min(f10, f11);
        float coerceAtLeast = RangesKt.coerceAtLeast(f11 - f10, DownloadProgress.UNKNOWN_PROGRESS);
        float coerceAtLeast2 = RangesKt.coerceAtLeast(f10 - f11, DownloadProgress.UNKNOWN_PROGRESS);
        float f22 = 2;
        float f23 = coerceAtLeast / f22;
        float f24 = coerceAtLeast2 / f22;
        float twoPi = Utils.getTwoPi() * min * Utils.interpolate(f21, 1.0f, f13);
        float f25 = (f22 * coerceAtLeast2) + (f22 * coerceAtLeast) + twoPi;
        float f26 = twoPi / 4;
        float f27 = f23 + f26;
        float f28 = f27 + coerceAtLeast2;
        float f29 = f28 + f26;
        float f30 = f29 + coerceAtLeast;
        float f31 = f30 + f26;
        float f32 = f31 + coerceAtLeast2;
        float f33 = f32 + f26;
        float[] fArr = {DownloadProgress.UNKNOWN_PROGRESS, f23, f27, f28, f29, f30, f31, f32, f33, f33 + f23, f25};
        int i11 = i10 * 2;
        float f34 = f25 / i11;
        float f35 = f14 * f25;
        float[] fArr2 = new float[i10 * 4];
        long j12 = FloatFloatPair.m٣constructorimpl(f24, f23);
        float f36 = -f24;
        long j13 = FloatFloatPair.m٣constructorimpl(f36, f23);
        float f37 = -f23;
        long j14 = j12;
        long j15 = FloatFloatPair.m٣constructorimpl(f36, f37);
        long j16 = FloatFloatPair.m٣constructorimpl(f24, f37);
        float f38 = f23;
        int i12 = 0;
        float f39 = DownloadProgress.UNKNOWN_PROGRESS;
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i11) {
            float f40 = f35 % f25;
            if (f40 < f39) {
                i13 = 0;
            }
            while (true) {
                int i15 = (i13 + 1) % 11;
                float f41 = fArr[i15];
                if (f40 >= f41) {
                    f38 = fArr[(i15 + 1) % 11];
                    i13 = i15;
                    f39 = f41;
                } else {
                    float f42 = (f40 - f39) / (f38 - f39);
                    if (z10) {
                        f17 = min * f21;
                    } else {
                        f17 = min;
                    }
                    switch (i13) {
                        case 0:
                            f18 = min;
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j10 = j14;
                            j11 = FloatFloatPair.m٣constructorimpl(f17, f42 * f23);
                            break;
                        case 1:
                            f18 = min;
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j10 = j14;
                            j11 = PointKt.m٤٩plusybeJwSQ(Utils.m٦٧radialToCartesianL6JJ3z0$default(f17, (f42 * Utils.getFloatPi()) / f22, 0L, 4, null), j10);
                            break;
                        case 2:
                            f18 = min;
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j11 = FloatFloatPair.m٣constructorimpl(f24 - (f42 * coerceAtLeast2), f17);
                            j10 = j14;
                            break;
                        case 3:
                            f18 = min;
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j11 = PointKt.m٤٩plusybeJwSQ(Utils.m٦٧radialToCartesianL6JJ3z0$default(f17, (Utils.getFloatPi() / f22) + ((f42 * Utils.getFloatPi()) / f22), 0L, 4, null), j13);
                            j10 = j14;
                            break;
                        case 4:
                            f18 = min;
                            j11 = FloatFloatPair.m٣constructorimpl(-f17, f23 - (f42 * coerceAtLeast));
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j10 = j14;
                            break;
                        case 5:
                            f18 = min;
                            j11 = PointKt.m٤٩plusybeJwSQ(Utils.m٦٧radialToCartesianL6JJ3z0$default(f17, Utils.getFloatPi() + ((f42 * Utils.getFloatPi()) / f22), 0L, 4, null), j15);
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j10 = j14;
                            break;
                        case 6:
                            f18 = min;
                            j11 = FloatFloatPair.m٣constructorimpl(f36 + (f42 * coerceAtLeast2), -f17);
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j10 = j14;
                            break;
                        case 7:
                            f18 = min;
                            j11 = PointKt.m٤٩plusybeJwSQ(Utils.m٦٧radialToCartesianL6JJ3z0$default(f17, (Utils.getFloatPi() * 1.5f) + ((f42 * Utils.getFloatPi()) / f22), 0L, 4, null), j16);
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j10 = j14;
                            break;
                        default:
                            f18 = min;
                            j11 = FloatFloatPair.m٣constructorimpl(f17, f37 + (f42 * f23));
                            f19 = coerceAtLeast;
                            f20 = f36;
                            j10 = j14;
                            break;
                    }
                    int i16 = i14 + 1;
                    fArr2[i14] = PointKt.m٤٥getXDnnuFBc(j11) + f15;
                    i14 += 2;
                    fArr2[i16] = PointKt.m٤٦getYDnnuFBc(j11) + f16;
                    f35 += f34;
                    z10 = !z10;
                    i12++;
                    f21 = f12;
                    j14 = j10;
                    min = f18;
                    coerceAtLeast = f19;
                    f36 = f20;
                }
            }
        }
        return fArr2;
    }

    @NotNull
    public static final RoundedPolygon rectangle(@NotNull RoundedPolygon.Companion companion, float f10, float f11, @NotNull CornerRounding rounding, @Nullable List<CornerRounding> list, float f12, float f13) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        float f14 = 2;
        float f15 = f10 / f14;
        float f16 = f12 - f15;
        float f17 = f11 / f14;
        float f18 = f13 - f17;
        float f19 = f15 + f12;
        float f20 = f17 + f13;
        return RoundedPolygonKt.RoundedPolygon(new float[]{f19, f20, f16, f20, f16, f18, f19, f18}, rounding, list, f12, f13);
    }

    public static /* synthetic */ RoundedPolygon rectangle$default(RoundedPolygon.Companion companion, float f10, float f11, CornerRounding cornerRounding, List list, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 2.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 2.0f;
        }
        if ((i10 & 4) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i10 & 8) != 0) {
            list = null;
        }
        if ((i10 & 16) != 0) {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if ((i10 & 32) != 0) {
            f13 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        return rectangle(companion, f10, f11, cornerRounding, list, f12, f13);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon star(@NotNull RoundedPolygon.Companion companion, int i10) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return star$default(companion, i10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, null, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 254, null);
    }

    public static /* synthetic */ RoundedPolygon star$default(RoundedPolygon.Companion companion, int i10, float f10, float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f12, float f13, int i11, Object obj) {
        float f14 = (i11 & 2) != 0 ? 1.0f : f10;
        float f15 = (i11 & 4) != 0 ? 0.5f : f11;
        CornerRounding cornerRounding3 = (i11 & 8) != 0 ? CornerRounding.Unrounded : cornerRounding;
        CornerRounding cornerRounding4 = (i11 & 16) != 0 ? null : cornerRounding2;
        List list2 = (i11 & 32) == 0 ? list : null;
        int i12 = i11 & 64;
        float f16 = DownloadProgress.UNKNOWN_PROGRESS;
        float f17 = i12 != 0 ? DownloadProgress.UNKNOWN_PROGRESS : f12;
        if ((i11 & 128) == 0) {
            f16 = f13;
        }
        return star(companion, i10, f14, f15, cornerRounding3, cornerRounding4, list2, f17, f16);
    }

    private static final float[] starVerticesFromNumVerts(int i10, float f10, float f11, float f12, float f13) {
        float[] fArr = new float[i10 * 4];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f14 = i10;
            long j10 = Utils.m٦٧radialToCartesianL6JJ3z0$default(f10, (Utils.getFloatPi() / f14) * 2 * i12, 0L, 4, null);
            fArr[i11] = PointKt.m٤٥getXDnnuFBc(j10) + f12;
            fArr[i11 + 1] = PointKt.m٤٦getYDnnuFBc(j10) + f13;
            long j11 = Utils.m٦٧radialToCartesianL6JJ3z0$default(f11, (Utils.getFloatPi() / f14) * ((i12 * 2) + 1), 0L, 4, null);
            int i13 = i11 + 3;
            fArr[i11 + 2] = PointKt.m٤٥getXDnnuFBc(j11) + f12;
            i11 += 4;
            fArr[i13] = PointKt.m٤٦getYDnnuFBc(j11) + f13;
        }
        return fArr;
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon circle(@NotNull RoundedPolygon.Companion companion, @IntRange(from = 3) int i10) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return circle$default(companion, i10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 14, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pill(@NotNull RoundedPolygon.Companion companion, float f10) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pill$default(companion, f10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 30, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pillStar$default(companion, f10, DownloadProgress.UNKNOWN_PROGRESS, 0, DownloadProgress.UNKNOWN_PROGRESS, null, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 2046, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon star(@NotNull RoundedPolygon.Companion companion, int i10, float f10) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return star$default(companion, i10, f10, DownloadProgress.UNKNOWN_PROGRESS, null, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 252, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon circle(@NotNull RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f10) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return circle$default(companion, i10, f10, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 12, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pill(@NotNull RoundedPolygon.Companion companion, float f10, float f11) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pill$default(companion, f10, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 28, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pillStar$default(companion, f10, f11, 0, DownloadProgress.UNKNOWN_PROGRESS, null, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 2044, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon star(@NotNull RoundedPolygon.Companion companion, int i10, float f10, float f11) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return star$default(companion, i10, f10, f11, null, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 248, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon circle(@NotNull RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f10, float f11) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return circle$default(companion, i10, f10, f11, DownloadProgress.UNKNOWN_PROGRESS, 8, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pill(@NotNull RoundedPolygon.Companion companion, float f10, float f11, float f12) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pill$default(companion, f10, f11, f12, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 24, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pillStar$default(companion, f10, f11, i10, DownloadProgress.UNKNOWN_PROGRESS, null, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 2040, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon star(@NotNull RoundedPolygon.Companion companion, int i10, float f10, float f11, @NotNull CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return star$default(companion, i10, f10, f11, rounding, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 240, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon circle(@NotNull RoundedPolygon.Companion companion, @IntRange(from = 3) int i10, float f10, float f11, float f12) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        if (i10 >= 3) {
            return RoundedPolygonKt.RoundedPolygon$default(i10, f10 / ((float) Math.cos(Utils.getFloatPi() / i10)), f11, f12, new CornerRounding(f10, DownloadProgress.UNKNOWN_PROGRESS, 2, null), null, 32, null);
        }
        throw new IllegalArgumentException("Circle must have at least three vertices");
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pill(@NotNull RoundedPolygon.Companion companion, float f10, float f11, float f12, float f13) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pill$default(companion, f10, f11, f12, f13, DownloadProgress.UNKNOWN_PROGRESS, 16, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f12) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return pillStar$default(companion, f10, f11, i10, f12, null, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 2032, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon star(@NotNull RoundedPolygon.Companion companion, int i10, float f10, float f11, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return star$default(companion, i10, f10, f11, rounding, cornerRounding, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 224, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pill(@NotNull RoundedPolygon.Companion companion, float f10, float f11, float f12, float f13, float f14) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS && f11 > DownloadProgress.UNKNOWN_PROGRESS) {
            float f15 = 2;
            float f16 = f10 / f15;
            float f17 = f11 / f15;
            float f18 = f16 + f13;
            float f19 = f17 + f14;
            float f20 = (-f16) + f13;
            float f21 = (-f17) + f14;
            return RoundedPolygonKt.RoundedPolygon$default(new float[]{f18, f19, f20, f19, f20, f21, f18, f21}, new CornerRounding(Math.min(f16, f17), f12), null, f13, f14, 4, null);
        }
        throw new IllegalArgumentException("Pill shapes must have positive width and height");
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f12, @NotNull CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, null, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 2016, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon star(@NotNull RoundedPolygon.Companion companion, int i10, float f10, float f11, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding, @Nullable List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return star$default(companion, i10, f10, f11, rounding, cornerRounding, list, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 192, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f12, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1984, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon star(@NotNull RoundedPolygon.Companion companion, int i10, float f10, float f11, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding, @Nullable List<CornerRounding> list, float f12) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return star$default(companion, i10, f10, f11, rounding, cornerRounding, list, f12, DownloadProgress.UNKNOWN_PROGRESS, 128, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f12, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding, @Nullable List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, list, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1920, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon star(@NotNull RoundedPolygon.Companion companion, int i10, float f10, float f11, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding, @Nullable List<CornerRounding> list, float f12, float f13) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS || f11 <= DownloadProgress.UNKNOWN_PROGRESS) {
            throw new IllegalArgumentException("Star radii must both be greater than 0");
        }
        if (f11 < f10) {
            if (list == null && cornerRounding != null) {
                kotlin.ranges.IntRange until = RangesKt.until(0, i10);
                list = new ArrayList<>();
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    CollectionsKt.addAll(list, CollectionsKt.listOf((Object[]) new CornerRounding[]{rounding, cornerRounding}));
                }
            }
            return RoundedPolygonKt.RoundedPolygon(starVerticesFromNumVerts(i10, f10, f11, f12, f13), rounding, list, f12, f13);
        }
        throw new IllegalArgumentException("innerRadius must be less than radius");
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f12, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding, @Nullable List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f13) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, list, f13, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1792, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f12, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding, @Nullable List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f13, @FloatRange(from = 0.0d, to = 1.0d) float f14) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, list, f13, f14, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1536, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f12, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding, @Nullable List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f13, @FloatRange(from = 0.0d, to = 1.0d) float f14, float f15) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return pillStar$default(companion, f10, f11, i10, f12, rounding, cornerRounding, list, f13, f14, f15, DownloadProgress.UNKNOWN_PROGRESS, 1024, null);
    }

    @JvmOverloads
    @NotNull
    public static final RoundedPolygon pillStar(@NotNull RoundedPolygon.Companion companion, float f10, float f11, int i10, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f12, @NotNull CornerRounding rounding, @Nullable CornerRounding cornerRounding, @Nullable List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f13, @FloatRange(from = 0.0d, to = 1.0d) float f14, float f15, float f16) {
        List<CornerRounding> list2;
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS || f11 <= DownloadProgress.UNKNOWN_PROGRESS) {
            throw new IllegalArgumentException("Pill shapes must have positive width and height");
        }
        if (f12 > DownloadProgress.UNKNOWN_PROGRESS && f12 <= 1.0f) {
            if (list != null || cornerRounding == null) {
                list2 = list;
            } else {
                kotlin.ranges.IntRange until = RangesKt.until(0, i10);
                ArrayList arrayList = new ArrayList();
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    CollectionsKt.addAll(arrayList, CollectionsKt.listOf((Object[]) new CornerRounding[]{rounding, cornerRounding}));
                }
                list2 = arrayList;
            }
            return RoundedPolygonKt.RoundedPolygon(pillStarVerticesFromNumVerts(i10, f10, f11, f12, f13, f14, f15, f16), rounding, list2, f15, f16);
        }
        throw new IllegalArgumentException("innerRadius must be between 0 and 1");
    }
}
