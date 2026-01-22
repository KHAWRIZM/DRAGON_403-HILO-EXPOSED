package androidx.graphics.shapes;

import androidx.collection.FloatList;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0000¨\u0006\u000e"}, d2 = {"linearMap", "", "xValues", "Landroidx/collection/FloatList;", "yValues", "x", "progressInRange", "", "progress", "progressFrom", "progressTo", "validateProgress", "", "p", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFloatMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatMapping.kt\nandroidx/graphics/shapes/FloatMappingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 FloatList.kt\nandroidx/collection/FloatList\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1#2:100\n75#3:101\n190#3,3:104\n253#3,4:107\n193#3,2:111\n258#3:113\n195#3:114\n223#4,2:102\n1774#4,4:115\n*S KotlinDebug\n*F\n+ 1 FloatMapping.kt\nandroidx/graphics/shapes/FloatMappingKt\n*L\n42#1:101\n93#1:104,3\n93#1:107,4\n93#1:111,2\n93#1:113\n93#1:114\n42#1:102,2\n96#1:115,4\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class FloatMappingKt {
    public static final float linearMap(@NotNull FloatList xValues, @NotNull FloatList yValues, float f10) {
        float positiveModulo;
        Intrinsics.checkNotNullParameter(xValues, "xValues");
        Intrinsics.checkNotNullParameter(yValues, "yValues");
        if (DownloadProgress.UNKNOWN_PROGRESS <= f10 && f10 <= 1.0f) {
            Iterator<Integer> it = RangesKt.until(0, xValues._size).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                int i10 = nextInt + 1;
                if (progressInRange(f10, xValues.get(nextInt), xValues.get(i10 % xValues.getSize()))) {
                    int size = i10 % xValues.getSize();
                    float positiveModulo2 = Utils.positiveModulo(xValues.get(size) - xValues.get(nextInt), 1.0f);
                    float positiveModulo3 = Utils.positiveModulo(yValues.get(size) - yValues.get(nextInt), 1.0f);
                    if (positiveModulo2 < 0.001f) {
                        positiveModulo = 0.5f;
                    } else {
                        positiveModulo = Utils.positiveModulo(f10 - xValues.get(nextInt), 1.0f) / positiveModulo2;
                    }
                    return Utils.positiveModulo(yValues.get(nextInt) + (positiveModulo3 * positiveModulo), 1.0f);
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        throw new IllegalArgumentException(("Invalid progress: " + f10).toString());
    }

    public static final boolean progressInRange(float f10, float f11, float f12) {
        if (f12 >= f11) {
            if (f11 <= f10 && f10 <= f12) {
                return true;
            }
        } else if (f10 >= f11 || f10 <= f12) {
            return true;
        }
        return false;
    }

    public static final void validateProgress(@NotNull FloatList p10) {
        int i10;
        Intrinsics.checkNotNullParameter(p10, "p");
        Boolean bool = Boolean.TRUE;
        float[] fArr = p10.content;
        int i11 = p10._size;
        boolean z10 = false;
        int i12 = 0;
        while (true) {
            boolean z11 = true;
            if (i12 >= i11) {
                break;
            }
            float f10 = fArr[i12];
            if (!bool.booleanValue() || DownloadProgress.UNKNOWN_PROGRESS > f10 || f10 > 1.0f) {
                z11 = false;
            }
            bool = Boolean.valueOf(z11);
            i12++;
        }
        if (bool.booleanValue()) {
            Iterable until = RangesKt.until(1, p10.getSize());
            if ((until instanceof Collection) && ((Collection) until).isEmpty()) {
                i10 = 0;
            } else {
                Iterator it = until.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    if (p10.get(nextInt) < p10.get(nextInt - 1) && (i10 = i10 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i10 <= 1) {
                z10 = true;
            }
            if (z10) {
                return;
            }
            throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(p10, null, null, null, 0, null, 31, null)).toString());
        }
        throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(p10, null, null, null, 0, null, 31, null)).toString());
    }
}
