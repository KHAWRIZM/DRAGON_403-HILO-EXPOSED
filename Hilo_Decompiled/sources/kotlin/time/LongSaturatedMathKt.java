package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\b\u001a\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"saturatingAdd", "", "value", "unit", "Lkotlin/time/DurationUnit;", "duration", "Lkotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LongSaturatedMathKt {
    /* renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m٢٠٩٦checkInfiniteSumDefinedPjuGub4(long j10, long j11, long j12) {
        if (Duration.m٢٠٢٠isInfiniteimpl(j11) && (j10 ^ j12) < 0) {
            throw new IllegalArgumentException("Summing infinities of different signs");
        }
        return j10;
    }

    private static final long infinityOfSign(long j10) {
        Duration.Companion companion = Duration.INSTANCE;
        if (j10 < 0) {
            return companion.m٢٠٨٥getNEG_INFINITEUwyO8pc$kotlin_stdlib();
        }
        return companion.m٢٠٨٤getINFINITEUwyO8pc();
    }

    public static final boolean isSaturated(long j10) {
        return ((j10 - 1) | 1) == LongCompanionObject.MAX_VALUE;
    }

    /* renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m٢٠٩٧saturatingAddNuflL3o(long j10, @NotNull DurationUnit unit, long j11) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long j12 = Duration.m٢٠٣٤toLongimpl(j11, unit);
        if (((j10 - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            return m٢٠٩٦checkInfiniteSumDefinedPjuGub4(j10, j11, j12);
        }
        if ((1 | (j12 - 1)) == LongCompanionObject.MAX_VALUE) {
            return m٢٠٩٨saturatingAddInHalvesNuflL3o(j10, unit, j11);
        }
        long j13 = j10 + j12;
        if (((j10 ^ j13) & (j12 ^ j13)) < 0) {
            if (j10 >= 0) {
                return LongCompanionObject.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
        return j13;
    }

    /* renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m٢٠٩٨saturatingAddInHalvesNuflL3o(long j10, DurationUnit durationUnit, long j11) {
        long j12 = Duration.m١٩٩٨divUwyO8pc(j11, 2);
        long j13 = Duration.m٢٠٣٤toLongimpl(j12, durationUnit);
        if ((1 | (j13 - 1)) == LongCompanionObject.MAX_VALUE) {
            return j13;
        }
        return m٢٠٩٧saturatingAddNuflL3o(m٢٠٩٧saturatingAddNuflL3o(j10, durationUnit, j12), durationUnit, Duration.m٢٠٢٣minusLRDsOJo(j11, j12));
    }

    public static final long saturatingDiff(long j10, long j11, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ((1 | (j11 - 1)) == LongCompanionObject.MAX_VALUE) {
            return Duration.m٢٠٣٩unaryMinusUwyO8pc(infinityOfSign(j11));
        }
        return saturatingFiniteDiff(j10, j11, unit);
    }

    private static final long saturatingFiniteDiff(long j10, long j11, DurationUnit durationUnit) {
        long j12 = j10 - j11;
        if (((j12 ^ j10) & (~(j12 ^ j11))) < 0) {
            DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
            if (durationUnit.compareTo(durationUnit2) < 0) {
                long convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, durationUnit2, durationUnit);
                long j13 = (j10 / convertDurationUnit) - (j11 / convertDurationUnit);
                long j14 = (j10 % convertDurationUnit) - (j11 % convertDurationUnit);
                Duration.Companion companion = Duration.INSTANCE;
                return Duration.m٢٠٢٤plusLRDsOJo(DurationKt.toDuration(j13, durationUnit2), DurationKt.toDuration(j14, durationUnit));
            }
            return Duration.m٢٠٣٩unaryMinusUwyO8pc(infinityOfSign(j12));
        }
        return DurationKt.toDuration(j12, durationUnit);
    }

    public static final long saturatingOriginsDiff(long j10, long j11, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (((j11 - 1) | 1) == LongCompanionObject.MAX_VALUE) {
            if (j10 == j11) {
                return Duration.INSTANCE.m٢٠٨٦getZEROUwyO8pc();
            }
            return Duration.m٢٠٣٩unaryMinusUwyO8pc(infinityOfSign(j11));
        }
        if ((1 | (j10 - 1)) == LongCompanionObject.MAX_VALUE) {
            return infinityOfSign(j10);
        }
        return saturatingFiniteDiff(j10, j11, unit);
    }
}
