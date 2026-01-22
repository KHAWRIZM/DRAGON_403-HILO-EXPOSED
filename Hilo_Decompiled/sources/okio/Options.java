package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", FirebaseAnalytics.Param.INDEX, "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final ByteString[] byteStrings;

    @NotNull
    private final int[] trie;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Options.kt\nokio/Options$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,236:1\n11065#2:237\n11400#2,3:238\n13374#2,3:243\n37#3,2:241\n1#4:246\n74#5:247\n74#5:248\n*S KotlinDebug\n*F\n+ 1 Options.kt\nokio/Options$Companion\n*L\n43#1:237\n43#1:238,3\n44#1:243,3\n43#1:241,2\n151#1:247\n208#1:248\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i10;
            int i11;
            int i12;
            int i13;
            Buffer buffer;
            int i14 = byteStringOffset;
            if (fromIndex < toIndex) {
                for (int i15 = fromIndex; i15 < toIndex; i15++) {
                    if (byteStrings.get(i15).size() < i14) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                }
                ByteString byteString = byteStrings.get(fromIndex);
                ByteString byteString2 = byteStrings.get(toIndex - 1);
                if (i14 == byteString.size()) {
                    int intValue = indexes.get(fromIndex).intValue();
                    int i16 = fromIndex + 1;
                    ByteString byteString3 = byteStrings.get(i16);
                    i10 = i16;
                    i11 = intValue;
                    byteString = byteString3;
                } else {
                    i10 = fromIndex;
                    i11 = -1;
                }
                if (byteString.getByte(i14) != byteString2.getByte(i14)) {
                    int i17 = 1;
                    for (int i18 = i10 + 1; i18 < toIndex; i18++) {
                        if (byteStrings.get(i18 - 1).getByte(i14) != byteStrings.get(i18).getByte(i14)) {
                            i17++;
                        }
                    }
                    long intCount = nodeOffset + getIntCount(node) + 2 + (i17 * 2);
                    node.writeInt(i17);
                    node.writeInt(i11);
                    for (int i19 = i10; i19 < toIndex; i19++) {
                        byte b10 = byteStrings.get(i19).getByte(i14);
                        if (i19 == i10 || b10 != byteStrings.get(i19 - 1).getByte(i14)) {
                            node.writeInt(b10 & UByte.MAX_VALUE);
                        }
                    }
                    Buffer buffer2 = new Buffer();
                    while (i10 < toIndex) {
                        byte b11 = byteStrings.get(i10).getByte(i14);
                        int i20 = i10 + 1;
                        int i21 = i20;
                        while (true) {
                            if (i21 < toIndex) {
                                if (b11 != byteStrings.get(i21).getByte(i14)) {
                                    i12 = i21;
                                    break;
                                }
                                i21++;
                            } else {
                                i12 = toIndex;
                                break;
                            }
                        }
                        if (i20 == i12 && i14 + 1 == byteStrings.get(i10).size()) {
                            node.writeInt(indexes.get(i10).intValue());
                            i13 = i12;
                            buffer = buffer2;
                        } else {
                            node.writeInt(((int) (intCount + getIntCount(buffer2))) * (-1));
                            i13 = i12;
                            buffer = buffer2;
                            buildTrieRecursive(intCount, buffer2, i14 + 1, byteStrings, i10, i12, indexes);
                        }
                        buffer2 = buffer;
                        i10 = i13;
                    }
                    node.writeAll(buffer2);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i22 = 0;
                for (int i23 = i14; i23 < min && byteString.getByte(i23) == byteString2.getByte(i23); i23++) {
                    i22++;
                }
                long intCount2 = nodeOffset + getIntCount(node) + 2 + i22 + 1;
                node.writeInt(-i22);
                node.writeInt(i11);
                int i24 = i22 + i14;
                while (i14 < i24) {
                    node.writeInt(byteString.getByte(i14) & UByte.MAX_VALUE);
                    i14++;
                }
                if (i10 + 1 == toIndex) {
                    if (i24 == byteStrings.get(i10).size()) {
                        node.writeInt(indexes.get(i10).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.");
                }
                Buffer buffer3 = new Buffer();
                node.writeInt(((int) (getIntCount(buffer3) + intCount2)) * (-1));
                buildTrieRecursive(intCount2, buffer3, i24, byteStrings, i10, toIndex, indexes);
                node.writeAll(buffer3);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j10, Buffer buffer, int i10, List list, int i11, int i12, List list2, int i13, Object obj) {
            long j11;
            int i14;
            int i15;
            int i16;
            if ((i13 & 1) != 0) {
                j11 = 0;
            } else {
                j11 = j10;
            }
            if ((i13 & 4) != 0) {
                i14 = 0;
            } else {
                i14 = i10;
            }
            if ((i13 & 16) != 0) {
                i15 = 0;
            } else {
                i15 = i11;
            }
            if ((i13 & 32) != 0) {
                i16 = list.size();
            } else {
                i16 = i12;
            }
            companion.buildTrieRecursive(j11, buffer, i14, list, i15, i16, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
        
            continue;
         */
        @JvmStatic
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options of(@NotNull ByteString... byteStrings) {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i10 = 0;
            if (byteStrings.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, defaultConstructorMarker);
            }
            List mutableList = ArraysKt.toMutableList(byteStrings);
            CollectionsKt.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            for (ByteString byteString : byteStrings) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
            List mutableListOf = CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
            int length = byteStrings.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                mutableListOf.set(CollectionsKt.binarySearch$default(mutableList, byteStrings[i11], 0, 0, 6, (Object) null), Integer.valueOf(i12));
                i11++;
                i12++;
            }
            if (((ByteString) mutableList.get(0)).size() > 0) {
                int i13 = 0;
                while (i13 < mutableList.size()) {
                    ByteString byteString2 = (ByteString) mutableList.get(i13);
                    int i14 = i13 + 1;
                    int i15 = i14;
                    while (i15 < mutableList.size()) {
                        ByteString byteString3 = (ByteString) mutableList.get(i15);
                        if (byteString3.startsWith(byteString2)) {
                            if (byteString3.size() != byteString2.size()) {
                                if (((Number) mutableListOf.get(i15)).intValue() > ((Number) mutableListOf.get(i13)).intValue()) {
                                    mutableList.remove(i15);
                                    mutableListOf.remove(i15);
                                } else {
                                    i15++;
                                }
                            } else {
                                throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                            }
                        }
                    }
                    i13 = i14;
                }
                Buffer buffer = new Buffer();
                buildTrieRecursive$default(this, 0L, buffer, 0, mutableList, 0, 0, mutableListOf, 53, null);
                int[] iArr = new int[(int) getIntCount(buffer)];
                while (!buffer.exhausted()) {
                    iArr[i10] = buffer.readInt();
                    i10++;
                }
                Object[] copyOf = Arrays.copyOf(byteStrings, byteStrings.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                return new Options((ByteString[]) copyOf, iArr, defaultConstructorMarker);
            }
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }

        private Companion() {
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    @NotNull
    public static final Options of(@NotNull ByteString... byteStringArr) {
        return INSTANCE.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @NotNull
    /* renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.byteStrings.length;
    }

    @NotNull
    /* renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
