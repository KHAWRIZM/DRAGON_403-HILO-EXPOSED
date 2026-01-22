package okio.internal;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import okio.C٠٢٧٧SegmentedByteString;
import okio.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\u0080\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0080\bø\u0001\u0000\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0082\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", "offset", "target", "", "targetOffset", "byteCount", "commonEquals", "", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "-SegmentedByteString")
@SourceDebugExtension({"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,250:1\n63#1,12:252\n85#1,14:264\n85#1,14:278\n85#1,14:292\n85#1,14:306\n63#1,12:320\n1#2:251\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n*L\n147#1:252,12\n160#1:264,14\n182#1:278,14\n202#1:292,14\n219#1:306,14\n239#1:320,12\n*E\n"})
/* renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SegmentedByteString {
    public static final int binarySearch(@NotNull int[] iArr, int i10, int i11, int i12) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else if (i15 > i10) {
                i13 = i14 - 1;
            } else {
                return i14;
            }
        }
        return (-i11) - 1;
    }

    public static final void commonCopyInto(@NotNull C٠٢٧٧SegmentedByteString r11, int i10, @NotNull byte[] target, int i11, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        long j10 = i12;
        okio.SegmentedByteString.checkOffsetAndCount(r11.size(), i10, j10);
        okio.SegmentedByteString.checkOffsetAndCount(target.length, i11, j10);
        int i14 = i12 + i10;
        int segment = segment(r11, i10);
        while (i10 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = r11.getDirectory()[segment - 1];
            }
            int i15 = r11.getDirectory()[segment] - i13;
            int i16 = r11.getDirectory()[r11.getSegments().length + segment];
            int min = Math.min(i14, i15 + i13) - i10;
            int i17 = i16 + (i10 - i13);
            ArraysKt.copyInto(r11.getSegments()[segment], target, i11, i17, i17 + min);
            i11 += min;
            i10 += min;
            segment++;
        }
    }

    public static final boolean commonEquals(@NotNull C٠٢٧٧SegmentedByteString r42, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(r42, "<this>");
        if (obj == r42) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == r42.size() && r42.rangeEquals(0, byteString, 0, r42.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull C٠٢٧٧SegmentedByteString r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return r12.getDirectory()[r12.getSegments().length - 1];
    }

    public static final int commonHashCode(@NotNull C٠٢٧٧SegmentedByteString r82) {
        Intrinsics.checkNotNullParameter(r82, "<this>");
        int hashCode = r82.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = r82.getSegments().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (i10 < length) {
            int i13 = r82.getDirectory()[length + i10];
            int i14 = r82.getDirectory()[i10];
            byte[] bArr = r82.getSegments()[i10];
            int i15 = (i14 - i11) + i13;
            while (i13 < i15) {
                i12 = (i12 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i11 = i14;
        }
        r82.setHashCode$okio(i12);
        return i12;
    }

    public static final byte commonInternalGet(@NotNull C٠٢٧٧SegmentedByteString r72, int i10) {
        int i11;
        Intrinsics.checkNotNullParameter(r72, "<this>");
        okio.SegmentedByteString.checkOffsetAndCount(r72.getDirectory()[r72.getSegments().length - 1], i10, 1L);
        int segment = segment(r72, i10);
        if (segment == 0) {
            i11 = 0;
        } else {
            i11 = r72.getDirectory()[segment - 1];
        }
        return r72.getSegments()[segment][(i10 - i11) + r72.getDirectory()[r72.getSegments().length + segment]];
    }

    public static final boolean commonRangeEquals(@NotNull C٠٢٧٧SegmentedByteString r62, int i10, @NotNull ByteString other, int i11, int i12) {
        Intrinsics.checkNotNullParameter(r62, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i10 < 0 || i10 > r62.size() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int segment = segment(r62, i10);
        while (i10 < i13) {
            int i14 = segment == 0 ? 0 : r62.getDirectory()[segment - 1];
            int i15 = r62.getDirectory()[segment] - i14;
            int i16 = r62.getDirectory()[r62.getSegments().length + segment];
            int min = Math.min(i13, i15 + i14) - i10;
            if (!other.rangeEquals(i11, r62.getSegments()[segment], i16 + (i10 - i14), min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull C٠٢٧٧SegmentedByteString r10, int i10, int i11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int resolveDefaultParameter = okio.SegmentedByteString.resolveDefaultParameter(r10, i11);
        if (i10 >= 0) {
            if (resolveDefaultParameter <= r10.size()) {
                int i12 = resolveDefaultParameter - i10;
                if (i12 >= 0) {
                    if (i10 == 0 && resolveDefaultParameter == r10.size()) {
                        return r10;
                    }
                    if (i10 == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = segment(r10, i10);
                    int segment2 = segment(r10, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(r10.getSegments(), segment, segment2 + 1);
                    int[] iArr = new int[bArr.length * 2];
                    int i13 = 0;
                    if (segment <= segment2) {
                        int i14 = segment;
                        int i15 = 0;
                        while (true) {
                            iArr[i15] = Math.min(r10.getDirectory()[i14] - i10, i12);
                            int i16 = i15 + 1;
                            iArr[i15 + bArr.length] = r10.getDirectory()[r10.getSegments().length + i14];
                            if (i14 == segment2) {
                                break;
                            }
                            i14++;
                            i15 = i16;
                        }
                    }
                    if (segment != 0) {
                        i13 = r10.getDirectory()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i10 - i13);
                    return new C٠٢٧٧SegmentedByteString(bArr, iArr);
                }
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i10).toString());
            }
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + r10.size() + ')').toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull C٠٢٧٧SegmentedByteString r92) {
        Intrinsics.checkNotNullParameter(r92, "<this>");
        byte[] bArr = new byte[r92.size()];
        int length = r92.getSegments().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = r92.getDirectory()[length + i10];
            int i14 = r92.getDirectory()[i10];
            int i15 = i14 - i11;
            ArraysKt.copyInto(r92.getSegments()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull C٠٢٧٧SegmentedByteString r11, @NotNull Buffer buffer, int i10, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i13 = i10 + i11;
        int segment = segment(r11, i10);
        while (i10 < i13) {
            if (segment == 0) {
                i12 = 0;
            } else {
                i12 = r11.getDirectory()[segment - 1];
            }
            int i14 = r11.getDirectory()[segment] - i12;
            int i15 = r11.getDirectory()[r11.getSegments().length + segment];
            int min = Math.min(i13, i14 + i12) - i10;
            int i16 = i15 + (i10 - i12);
            Segment segment2 = new Segment(r11.getSegments()[segment], i16, i16 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            i10 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i11);
    }

    public static final void forEachSegment(@NotNull C٠٢٧٧SegmentedByteString r62, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(r62, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = r62.getSegments().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = r62.getDirectory()[length + i10];
            int i13 = r62.getDirectory()[i10];
            action.invoke(r62.getSegments()[i10], Integer.valueOf(i12), Integer.valueOf(i13 - i11));
            i10++;
            i11 = i13;
        }
    }

    public static final int segment(@NotNull C٠٢٧٧SegmentedByteString r22, int i10) {
        Intrinsics.checkNotNullParameter(r22, "<this>");
        int binarySearch = binarySearch(r22.getDirectory(), i10 + 1, 0, r22.getSegments().length);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        return binarySearch;
    }

    private static final void forEachSegment(C٠٢٧٧SegmentedByteString r52, int i10, int i11, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int segment = segment(r52, i10);
        while (i10 < i11) {
            int i12 = segment == 0 ? 0 : r52.getDirectory()[segment - 1];
            int i13 = r52.getDirectory()[segment] - i12;
            int i14 = r52.getDirectory()[r52.getSegments().length + segment];
            int min = Math.min(i11, i13 + i12) - i10;
            function3.invoke(r52.getSegments()[segment], Integer.valueOf(i14 + (i10 - i12)), Integer.valueOf(min));
            i10 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull C٠٢٧٧SegmentedByteString r62, int i10, @NotNull byte[] other, int i11, int i12) {
        Intrinsics.checkNotNullParameter(r62, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i10 < 0 || i10 > r62.size() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int segment = segment(r62, i10);
        while (i10 < i13) {
            int i14 = segment == 0 ? 0 : r62.getDirectory()[segment - 1];
            int i15 = r62.getDirectory()[segment] - i14;
            int i16 = r62.getDirectory()[r62.getSegments().length + segment];
            int min = Math.min(i13, i15 + i14) - i10;
            if (!okio.SegmentedByteString.arrayRangeEquals(r62.getSegments()[segment], i16 + (i10 - i14), other, i11, min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }
}
