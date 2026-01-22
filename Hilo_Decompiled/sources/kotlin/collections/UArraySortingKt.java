package kotlin.collections;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u000b\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0010\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0015\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UArraySortingKt {
    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m٩٩٩partitionnroSd4(long[] jArr, int i10, int i11) {
        int compare;
        int compare2;
        long j10 = ULongArray.m٧٧٨getsVKNKU(jArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (compare < 0) {
                i10++;
            }
            while (compare2 > 0) {
                i11--;
            }
            if (i10 <= i11) {
                long j11 = ULongArray.m٧٧٨getsVKNKU(jArr, i10);
                ULongArray.m٧٨٣setk8EXiF4(jArr, i10, ULongArray.m٧٧٨getsVKNKU(jArr, i11));
                ULongArray.m٧٨٣setk8EXiF4(jArr, i11, j11);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m١٠٠٠partition4UcCI2c(byte[] bArr, int i10, int i11) {
        int i12;
        byte b10 = UByteArray.m٦٢٠getw2LRezQ(bArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (true) {
                int i13 = UByteArray.m٦٢٠getw2LRezQ(bArr, i10) & UByte.MAX_VALUE;
                i12 = b10 & UByte.MAX_VALUE;
                if (Intrinsics.compare(i13, i12) >= 0) {
                    break;
                }
                i10++;
            }
            while (Intrinsics.compare(UByteArray.m٦٢٠getw2LRezQ(bArr, i11) & UByte.MAX_VALUE, i12) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                byte b11 = UByteArray.m٦٢٠getw2LRezQ(bArr, i10);
                UByteArray.m٦٢٥setVurrAj0(bArr, i10, UByteArray.m٦٢٠getw2LRezQ(bArr, i11));
                UByteArray.m٦٢٥setVurrAj0(bArr, i11, b11);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m١٠٠١partitionAa5vz7o(short[] sArr, int i10, int i11) {
        int i12;
        short s10 = UShortArray.m٨٨٣getMh2AYeg(sArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (true) {
                int i13 = UShortArray.m٨٨٣getMh2AYeg(sArr, i10) & UShort.MAX_VALUE;
                i12 = s10 & UShort.MAX_VALUE;
                if (Intrinsics.compare(i13, i12) >= 0) {
                    break;
                }
                i10++;
            }
            while (Intrinsics.compare(UShortArray.m٨٨٣getMh2AYeg(sArr, i11) & UShort.MAX_VALUE, i12) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                short s11 = UShortArray.m٨٨٣getMh2AYeg(sArr, i10);
                UShortArray.m٨٨٨set01HTLdE(sArr, i10, UShortArray.m٨٨٣getMh2AYeg(sArr, i11));
                UShortArray.m٨٨٨set01HTLdE(sArr, i11, s11);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int m١٠٠٢partitionoBK06Vg(int[] iArr, int i10, int i11) {
        int compare;
        int compare2;
        int i12 = UIntArray.m٦٩٩getpVg5ArA(iArr, (i10 + i11) / 2);
        while (i10 <= i11) {
            while (compare < 0) {
                i10++;
            }
            while (compare2 > 0) {
                i11--;
            }
            if (i10 <= i11) {
                int i13 = UIntArray.m٦٩٩getpVg5ArA(iArr, i10);
                UIntArray.m٧٠٤setVXSXFK8(iArr, i10, UIntArray.m٦٩٩getpVg5ArA(iArr, i11));
                UIntArray.m٧٠٤setVXSXFK8(iArr, i11, i13);
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m١٠٠٣quickSortnroSd4(long[] jArr, int i10, int i11) {
        int i12 = m٩٩٩partitionnroSd4(jArr, i10, i11);
        int i13 = i12 - 1;
        if (i10 < i13) {
            m١٠٠٣quickSortnroSd4(jArr, i10, i13);
        }
        if (i12 < i11) {
            m١٠٠٣quickSortnroSd4(jArr, i12, i11);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m١٠٠٤quickSort4UcCI2c(byte[] bArr, int i10, int i11) {
        int i12 = m١٠٠٠partition4UcCI2c(bArr, i10, i11);
        int i13 = i12 - 1;
        if (i10 < i13) {
            m١٠٠٤quickSort4UcCI2c(bArr, i10, i13);
        }
        if (i12 < i11) {
            m١٠٠٤quickSort4UcCI2c(bArr, i12, i11);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m١٠٠٥quickSortAa5vz7o(short[] sArr, int i10, int i11) {
        int i12 = m١٠٠١partitionAa5vz7o(sArr, i10, i11);
        int i13 = i12 - 1;
        if (i10 < i13) {
            m١٠٠٥quickSortAa5vz7o(sArr, i10, i13);
        }
        if (i12 < i11) {
            m١٠٠٥quickSortAa5vz7o(sArr, i12, i11);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m١٠٠٦quickSortoBK06Vg(int[] iArr, int i10, int i11) {
        int i12 = m١٠٠٢partitionoBK06Vg(iArr, i10, i11);
        int i13 = i12 - 1;
        if (i10 < i13) {
            m١٠٠٦quickSortoBK06Vg(iArr, i10, i13);
        }
        if (i12 < i11) {
            m١٠٠٦quickSortoBK06Vg(iArr, i12, i11);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m١٠٠٧sortArraynroSd4(@NotNull long[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(array, "array");
        m١٠٠٣quickSortnroSd4(array, i10, i11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m١٠٠٨sortArray4UcCI2c(@NotNull byte[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(array, "array");
        m١٠٠٤quickSort4UcCI2c(array, i10, i11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m١٠٠٩sortArrayAa5vz7o(@NotNull short[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(array, "array");
        m١٠٠٥quickSortAa5vz7o(array, i10, i11 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m١٠١٠sortArrayoBK06Vg(@NotNull int[] array, int i10, int i11) {
        Intrinsics.checkNotNullParameter(array, "array");
        m١٠٠٦quickSortoBK06Vg(array, i10, i11 - 1);
    }
}
