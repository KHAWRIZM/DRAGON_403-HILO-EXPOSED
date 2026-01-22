package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.collection.FloatList;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00182\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B3\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0010H\u0096\u0002R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon;", "Lkotlin/collections/AbstractList;", "Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "measurer", "Landroidx/graphics/shapes/Measurer;", "features", "", "Landroidx/graphics/shapes/ProgressableFeature;", "cubics", "Landroidx/graphics/shapes/Cubic;", "outlineProgress", "Landroidx/collection/FloatList;", "(Landroidx/graphics/shapes/Measurer;Ljava/util/List;Ljava/util/List;Landroidx/collection/FloatList;)V", "getFeatures", "()Ljava/util/List;", "size", "", "getSize", "()I", "cutAndShift", "cuttingPoint", "", "get", FirebaseAnalytics.Param.INDEX, "Companion", "MeasuredCubic", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPolygonMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolygonMeasure.kt\nandroidx/graphics/shapes/MeasuredPolygon\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Utils.kt\nandroidx/graphics/shapes/Utils\n*L\n1#1,353:1\n1#2:354\n350#3,7:355\n108#4,4:362\n*S KotlinDebug\n*F\n+ 1 PolygonMeasure.kt\nandroidx/graphics/shapes/MeasuredPolygon\n*L\n169#1:355,7\n182#1:362,4\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class MeasuredPolygon extends AbstractList<MeasuredCubic> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final List<MeasuredCubic> cubics;

    @NotNull
    private final List<ProgressableFeature> features;

    @NotNull
    private final Measurer measurer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon$Companion;", "", "()V", "measurePolygon", "Landroidx/graphics/shapes/MeasuredPolygon;", "measurer", "Landroidx/graphics/shapes/Measurer;", "polygon", "Landroidx/graphics/shapes/RoundedPolygon;", "measurePolygon$graphics_shapes_release", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPolygonMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolygonMeasure.kt\nandroidx/graphics/shapes/MeasuredPolygon$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utils.kt\nandroidx/graphics/shapes/Utils\n*L\n1#1,353:1\n2949#2:354\n2847#2,3:355\n2850#2,6:359\n1#3:358\n108#4,4:365\n*S KotlinDebug\n*F\n+ 1 PolygonMeasure.kt\nandroidx/graphics/shapes/MeasuredPolygon$Companion\n*L\n259#1:354\n259#1:355,3\n259#1:359,6\n259#1:358\n275#1:365,4\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MeasuredPolygon measurePolygon$graphics_shapes_release(@NotNull Measurer measurer, @NotNull RoundedPolygon polygon) {
            List list;
            String unused;
            Intrinsics.checkNotNullParameter(measurer, "measurer");
            Intrinsics.checkNotNullParameter(polygon, "polygon");
            ArrayList<Cubic> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = polygon.getFeatures$graphics_shapes_release().size();
            for (int i10 = 0; i10 < size; i10++) {
                Feature feature = polygon.getFeatures$graphics_shapes_release().get(i10);
                int size2 = feature.getCubics().size();
                for (int i11 = 0; i11 < size2; i11++) {
                    if ((feature instanceof Feature.Corner) && i11 == feature.getCubics().size() / 2) {
                        arrayList2.add(TuplesKt.to(feature, Integer.valueOf(arrayList.size())));
                    }
                    arrayList.add(feature.getCubics().get(i11));
                }
            }
            Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
            int collectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault(arrayList, 9);
            if (collectionSizeOrDefault == 0) {
                list = CollectionsKt.listOf(valueOf);
            } else {
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault + 1);
                arrayList3.add(valueOf);
                for (Cubic cubic : arrayList) {
                    float floatValue = valueOf.floatValue();
                    float measureCubic = measurer.measureCubic(cubic);
                    if (measureCubic >= DownloadProgress.UNKNOWN_PROGRESS) {
                        Unit unit = Unit.INSTANCE;
                        valueOf = Float.valueOf(floatValue + measureCubic);
                        arrayList3.add(valueOf);
                    } else {
                        throw new IllegalArgumentException("Measured cubic is expected to be greater or equal to zero");
                    }
                }
                list = arrayList3;
            }
            float floatValue2 = ((Number) CollectionsKt.last(list)).floatValue();
            MutableFloatList mutableFloatList = new MutableFloatList(list.size());
            int size3 = list.size();
            for (int i12 = 0; i12 < size3; i12++) {
                mutableFloatList.add(((Number) list.get(i12)).floatValue() / floatValue2);
            }
            unused = PolygonMeasureKt.LOG_TAG;
            List createListBuilder = CollectionsKt.createListBuilder();
            int size4 = arrayList2.size();
            for (int i13 = 0; i13 < size4; i13++) {
                int intValue = ((Number) ((Pair) arrayList2.get(i13)).getSecond()).intValue();
                createListBuilder.add(new ProgressableFeature((mutableFloatList.get(intValue) + mutableFloatList.get(intValue + 1)) / 2, (Feature) ((Pair) arrayList2.get(i13)).getFirst()));
            }
            return new MeasuredPolygon(measurer, CollectionsKt.build(createListBuilder), arrayList, mutableFloatList, null);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\"\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0000R\u00020\u0012\u0012\b\u0012\u00060\u0000R\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic;", "", "cubic", "Landroidx/graphics/shapes/Cubic;", "startOutlineProgress", "", "endOutlineProgress", "(Landroidx/graphics/shapes/MeasuredPolygon;Landroidx/graphics/shapes/Cubic;FF)V", "getCubic", "()Landroidx/graphics/shapes/Cubic;", "<set-?>", "getEndOutlineProgress", "()F", "measuredSize", "getMeasuredSize", "getStartOutlineProgress", "cutAtProgress", "Lkotlin/Pair;", "Landroidx/graphics/shapes/MeasuredPolygon;", "cutOutlineProgress", "toString", "", "updateProgressRange", "", "updateProgressRange$graphics_shapes_release", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPolygonMeasure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolygonMeasure.kt\nandroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Utils.kt\nandroidx/graphics/shapes/Utils\n*L\n1#1,353:1\n1#2:354\n108#3,4:355\n*S KotlinDebug\n*F\n+ 1 PolygonMeasure.kt\nandroidx/graphics/shapes/MeasuredPolygon$MeasuredCubic\n*L\n128#1:355,4\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class MeasuredCubic {

        @NotNull
        private final Cubic cubic;
        private float endOutlineProgress;

        /* renamed from: measuredSize, reason: from kotlin metadata and from toString */
        private final float size;

        /* renamed from: startOutlineProgress, reason: from kotlin metadata and from toString */
        private float outlineProgress;
        final /* synthetic */ MeasuredPolygon this$0;

        public MeasuredCubic(@NotNull MeasuredPolygon measuredPolygon, @FloatRange(from = 0.0d, to = 1.0d) Cubic cubic, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11) {
            Intrinsics.checkNotNullParameter(cubic, "cubic");
            this.this$0 = measuredPolygon;
            this.cubic = cubic;
            if (f11 >= f10) {
                this.size = measuredPolygon.measurer.measureCubic(cubic);
                this.outlineProgress = f10;
                this.endOutlineProgress = f11;
                return;
            }
            throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
        }

        public static /* synthetic */ void updateProgressRange$graphics_shapes_release$default(MeasuredCubic measuredCubic, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = measuredCubic.outlineProgress;
            }
            if ((i10 & 2) != 0) {
                f11 = measuredCubic.endOutlineProgress;
            }
            measuredCubic.updateProgressRange$graphics_shapes_release(f10, f11);
        }

        @NotNull
        public final Pair<MeasuredCubic, MeasuredCubic> cutAtProgress(float cutOutlineProgress) {
            String unused;
            float coerceIn = RangesKt.coerceIn(cutOutlineProgress, this.outlineProgress, this.endOutlineProgress);
            float f10 = this.endOutlineProgress;
            float f11 = this.outlineProgress;
            float findCubicCutPoint = this.this$0.measurer.findCubicCutPoint(this.cubic, ((coerceIn - f11) / (f10 - f11)) * this.size);
            if (DownloadProgress.UNKNOWN_PROGRESS <= findCubicCutPoint && findCubicCutPoint <= 1.0f) {
                unused = PolygonMeasureKt.LOG_TAG;
                Pair<Cubic, Cubic> split = this.cubic.split(findCubicCutPoint);
                return TuplesKt.to(new MeasuredCubic(this.this$0, split.component1(), this.outlineProgress, coerceIn), new MeasuredCubic(this.this$0, split.component2(), coerceIn, this.endOutlineProgress));
            }
            throw new IllegalArgumentException("Cubic cut point is expected to be between 0 and 1");
        }

        @NotNull
        public final Cubic getCubic() {
            return this.cubic;
        }

        public final float getEndOutlineProgress() {
            return this.endOutlineProgress;
        }

        /* renamed from: getMeasuredSize, reason: from getter */
        public final float getSize() {
            return this.size;
        }

        /* renamed from: getStartOutlineProgress, reason: from getter */
        public final float getOutlineProgress() {
            return this.outlineProgress;
        }

        @NotNull
        public String toString() {
            return "MeasuredCubic(outlineProgress=[" + this.outlineProgress + " .. " + this.endOutlineProgress + "], size=" + this.size + ", cubic=" + this.cubic + ')';
        }

        public final void updateProgressRange$graphics_shapes_release(float startOutlineProgress, float endOutlineProgress) {
            if (endOutlineProgress >= startOutlineProgress) {
                this.outlineProgress = startOutlineProgress;
                this.endOutlineProgress = endOutlineProgress;
                return;
            }
            throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
        }
    }

    public /* synthetic */ MeasuredPolygon(Measurer measurer, List list, List list2, FloatList floatList, DefaultConstructorMarker defaultConstructorMarker) {
        this(measurer, list, list2, floatList);
    }

    public /* bridge */ boolean contains(MeasuredCubic measuredCubic) {
        return super.contains((Object) measuredCubic);
    }

    @NotNull
    public final MeasuredPolygon cutAndShift(float cuttingPoint) {
        float positiveModulo;
        String unused;
        if (DownloadProgress.UNKNOWN_PROGRESS <= cuttingPoint && cuttingPoint <= 1.0f) {
            if (cuttingPoint < 1.0E-4f) {
                return this;
            }
            Iterator<MeasuredCubic> it = this.cubics.iterator();
            int i10 = 0;
            while (true) {
                if (it.hasNext()) {
                    MeasuredCubic next = it.next();
                    float outlineProgress = next.getOutlineProgress();
                    if (cuttingPoint <= next.getEndOutlineProgress() && outlineProgress <= cuttingPoint) {
                        break;
                    }
                    i10++;
                } else {
                    i10 = -1;
                    break;
                }
            }
            Pair<MeasuredCubic, MeasuredCubic> cutAtProgress = this.cubics.get(i10).cutAtProgress(cuttingPoint);
            MeasuredCubic component1 = cutAtProgress.component1();
            MeasuredCubic component2 = cutAtProgress.component2();
            unused = PolygonMeasureKt.LOG_TAG;
            List mutableListOf = CollectionsKt.mutableListOf(component2.getCubic());
            int size = this.cubics.size();
            for (int i11 = 1; i11 < size; i11++) {
                List<MeasuredCubic> list = this.cubics;
                mutableListOf.add(list.get((i11 + i10) % list.size()).getCubic());
            }
            mutableListOf.add(component1.getCubic());
            MutableFloatList mutableFloatList = new MutableFloatList(this.cubics.size() + 2);
            int size2 = this.cubics.size() + 2;
            for (int i12 = 0; i12 < size2; i12++) {
                if (i12 == 0) {
                    positiveModulo = DownloadProgress.UNKNOWN_PROGRESS;
                } else if (i12 == this.cubics.size() + 1) {
                    positiveModulo = 1.0f;
                } else {
                    positiveModulo = Utils.positiveModulo(this.cubics.get(((i10 + i12) - 1) % this.cubics.size()).getEndOutlineProgress() - cuttingPoint, 1.0f);
                }
                mutableFloatList.add(positiveModulo);
            }
            List createListBuilder = CollectionsKt.createListBuilder();
            int size3 = this.features.size();
            for (int i13 = 0; i13 < size3; i13++) {
                createListBuilder.add(new ProgressableFeature(Utils.positiveModulo(this.features.get(i13).getProgress() - cuttingPoint, 1.0f), this.features.get(i13).getFeature()));
            }
            return new MeasuredPolygon(this.measurer, CollectionsKt.build(createListBuilder), mutableListOf, mutableFloatList);
        }
        throw new IllegalArgumentException("Cutting point is expected to be between 0 and 1");
    }

    @NotNull
    public final List<ProgressableFeature> getFeatures() {
        return this.features;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.cubics.size();
    }

    public /* bridge */ int indexOf(MeasuredCubic measuredCubic) {
        return super.indexOf((Object) measuredCubic);
    }

    public /* bridge */ int lastIndexOf(MeasuredCubic measuredCubic) {
        return super.lastIndexOf((Object) measuredCubic);
    }

    private MeasuredPolygon(Measurer measurer, List<ProgressableFeature> list, List<? extends Cubic> list2, FloatList floatList) {
        if (floatList.getSize() != list2.size() + 1) {
            throw new IllegalArgumentException("Outline progress size is expected to be the cubics size + 1");
        }
        if (floatList.first() != DownloadProgress.UNKNOWN_PROGRESS) {
            throw new IllegalArgumentException("First outline progress value is expected to be zero");
        }
        if (floatList.last() == 1.0f) {
            this.measurer = measurer;
            this.features = list;
            ArrayList arrayList = new ArrayList();
            int size = list2.size();
            int i10 = 0;
            float f10 = DownloadProgress.UNKNOWN_PROGRESS;
            while (i10 < size) {
                int i11 = i10 + 1;
                if (floatList.get(i11) - floatList.get(i10) > 1.0E-4f) {
                    arrayList.add(new MeasuredCubic(this, list2.get(i10), f10, floatList.get(i11)));
                    f10 = floatList.get(i11);
                }
                i10 = i11;
            }
            MeasuredCubic.updateProgressRange$graphics_shapes_release$default((MeasuredCubic) arrayList.get(CollectionsKt.getLastIndex(arrayList)), DownloadProgress.UNKNOWN_PROGRESS, 1.0f, 1, null);
            this.cubics = arrayList;
            return;
        }
        throw new IllegalArgumentException("Last outline progress value is expected to be one");
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return contains((MeasuredCubic) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public MeasuredCubic get(int index) {
        return this.cubics.get(index);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return indexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return lastIndexOf((MeasuredCubic) obj);
        }
        return -1;
    }
}
