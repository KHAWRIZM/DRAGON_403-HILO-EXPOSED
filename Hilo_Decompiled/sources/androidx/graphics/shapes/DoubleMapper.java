package androidx.graphics.shapes;

import androidx.collection.MutableFloatList;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB1\u0012*\u0010\u0002\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0003\"\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/graphics/shapes/DoubleMapper;", "", "mappings", "", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)V", "sourceValues", "Landroidx/collection/MutableFloatList;", "targetValues", "map", "x", "mapBack", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class DoubleMapper {

    @JvmField
    @NotNull
    public static final DoubleMapper Identity;

    @NotNull
    private final MutableFloatList sourceValues;

    @NotNull
    private final MutableFloatList targetValues;

    static {
        Float valueOf = Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS);
        Pair pair = TuplesKt.to(valueOf, valueOf);
        Float valueOf2 = Float.valueOf(0.5f);
        Identity = new DoubleMapper(pair, TuplesKt.to(valueOf2, valueOf2));
    }

    public DoubleMapper(@NotNull Pair<Float, Float>... mappings) {
        Intrinsics.checkNotNullParameter(mappings, "mappings");
        this.sourceValues = new MutableFloatList(mappings.length);
        this.targetValues = new MutableFloatList(mappings.length);
        int length = mappings.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.sourceValues.add(mappings[i10].getFirst().floatValue());
            this.targetValues.add(mappings[i10].getSecond().floatValue());
        }
        FloatMappingKt.validateProgress(this.sourceValues);
        FloatMappingKt.validateProgress(this.targetValues);
    }

    public final float map(float x10) {
        return FloatMappingKt.linearMap(this.sourceValues, this.targetValues, x10);
    }

    public final float mapBack(float x10) {
        return FloatMappingKt.linearMap(this.targetValues, this.sourceValues, x10);
    }
}
