package com.squareup.wire;

import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.qiahao.nextvideo.ui.store.MyBagViewModel;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\"J0\u0010#\u001a\u00020\u001a2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u001a0%H\u0000¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0006H\u0000¢\u0006\u0002\b*J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020,J\u0016\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/squareup/wire/ReverseProtoWriter;", "", "()V", "array", "", "arrayLimit", "", "byteCount", "getByteCount", "()I", "cursor", "Lokio/Buffer$UnsafeCursor;", "forwardBuffer", "Lokio/Buffer;", "getForwardBuffer", "()Lokio/Buffer;", "forwardBuffer$delegate", "Lkotlin/Lazy;", "forwardWriter", "Lcom/squareup/wire/ProtoWriter;", "getForwardWriter", "()Lcom/squareup/wire/ProtoWriter;", "forwardWriter$delegate", MyBagViewModel.BAG_HEAD, "tail", "emitCurrentSegment", "", "require", "minByteCount", "writeBytes", "value", "Lokio/ByteString;", "writeFixed32", "writeFixed64", "", "writeForward", MessageMenuDialog.BLOCK, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "writeForward$wire_runtime", "writeSignedVarint32", "writeSignedVarint32$wire_runtime", "writeString", "", "writeTag", "fieldNumber", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "writeTo", "sink", "Lokio/BufferedSink;", "writeVarint32", "writeVarint64", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ReverseProtoWriter {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private int arrayLimit;

    /* renamed from: forwardBuffer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy forwardBuffer;

    /* renamed from: forwardWriter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy forwardWriter;

    @NotNull
    private Buffer tail = new Buffer();

    @NotNull
    private Buffer head = new Buffer();

    @NotNull
    private final Buffer.UnsafeCursor cursor = new Buffer.UnsafeCursor();

    @NotNull
    private byte[] array = EMPTY_ARRAY;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/squareup/wire/ReverseProtoWriter$Companion;", "", "()V", "EMPTY_ARRAY", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ReverseProtoWriter() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.forwardBuffer = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Buffer>() { // from class: com.squareup.wire.ReverseProtoWriter$forwardBuffer$2
            @NotNull
            public final Buffer invoke() {
                return new Buffer();
            }
        });
        this.forwardWriter = LazyKt.lazy(lazyThreadSafetyMode, new Function0<ProtoWriter>() { // from class: com.squareup.wire.ReverseProtoWriter$forwardWriter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ProtoWriter m١١٥invoke() {
                Buffer forwardBuffer;
                forwardBuffer = ReverseProtoWriter.this.getForwardBuffer();
                return new ProtoWriter(forwardBuffer);
            }
        });
    }

    private final void emitCurrentSegment() {
        byte[] bArr = this.array;
        byte[] bArr2 = EMPTY_ARRAY;
        if (bArr == bArr2) {
            return;
        }
        this.cursor.close();
        this.head.skip(this.arrayLimit);
        this.head.writeAll(this.tail);
        Buffer buffer = this.tail;
        this.tail = this.head;
        this.head = buffer;
        this.array = bArr2;
        this.arrayLimit = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Buffer getForwardBuffer() {
        return (Buffer) this.forwardBuffer.getValue();
    }

    private final ProtoWriter getForwardWriter() {
        return (ProtoWriter) this.forwardWriter.getValue();
    }

    private final void require(int minByteCount) {
        if (this.arrayLimit >= minByteCount) {
            return;
        }
        emitCurrentSegment();
        this.head.readAndWriteUnsafe(this.cursor);
        this.cursor.expandBuffer(minByteCount);
        Buffer.UnsafeCursor unsafeCursor = this.cursor;
        if (unsafeCursor.offset == 0) {
            int i = unsafeCursor.end;
            byte[] bArr = unsafeCursor.data;
            Intrinsics.checkNotNull(bArr);
            if (i == bArr.length) {
                byte[] bArr2 = this.cursor.data;
                Intrinsics.checkNotNull(bArr2);
                this.array = bArr2;
                this.arrayLimit = this.cursor.end;
                return;
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int getByteCount() {
        return ((int) this.tail.size()) + (this.array.length - this.arrayLimit);
    }

    public final void writeBytes(@NotNull ByteString value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size();
        while (size != 0) {
            require(1);
            int min = Math.min(this.arrayLimit, size);
            int i = this.arrayLimit - min;
            this.arrayLimit = i;
            size -= min;
            value.copyInto(size, this.array, i, min);
        }
    }

    public final void writeFixed32(int value) {
        require(4);
        int i = this.arrayLimit;
        int i2 = i - 4;
        this.arrayLimit = i2;
        byte[] bArr = this.array;
        bArr[i2] = (byte) (value & 255);
        bArr[i - 3] = (byte) ((value >>> 8) & 255);
        bArr[i - 2] = (byte) ((value >>> 16) & 255);
        bArr[i - 1] = (byte) ((value >>> 24) & 255);
    }

    public final void writeFixed64(long value) {
        require(8);
        int i = this.arrayLimit;
        int i2 = i - 8;
        this.arrayLimit = i2;
        byte[] bArr = this.array;
        bArr[i2] = (byte) (value & 255);
        bArr[i - 7] = (byte) ((value >>> 8) & 255);
        bArr[i - 6] = (byte) ((value >>> 16) & 255);
        bArr[i - 5] = (byte) ((value >>> 24) & 255);
        bArr[i - 4] = (byte) ((value >>> 32) & 255);
        bArr[i - 3] = (byte) ((value >>> 40) & 255);
        bArr[i - 2] = (byte) ((value >>> 48) & 255);
        bArr[i - 1] = (byte) ((value >>> 56) & 255);
    }

    public final void writeForward$wire_runtime(@NotNull Function1<? super ProtoWriter, Unit> block) throws IOException {
        Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
        block.invoke(getForwardWriter());
        writeBytes(getForwardBuffer().readByteString());
    }

    public final void writeSignedVarint32$wire_runtime(int value) {
        if (value >= 0) {
            writeVarint32(value);
        } else {
            writeVarint64(value);
        }
    }

    public final void writeString(@NotNull String value) {
        char c;
        Intrinsics.checkNotNullParameter(value, "value");
        int length = value.length() - 1;
        while (length >= 0) {
            int i = length - 1;
            char charAt = value.charAt(length);
            if (charAt < 128) {
                require(1);
                int i2 = this.arrayLimit;
                byte[] bArr = this.array;
                int i3 = i2 - 1;
                bArr[i3] = (byte) charAt;
                int max = Math.max(-1, i - i3);
                int i4 = i3;
                length = i;
                while (length > max) {
                    char charAt2 = value.charAt(length);
                    if (charAt2 >= 128) {
                        break;
                    }
                    length--;
                    i4--;
                    bArr[i4] = (byte) charAt2;
                }
                this.arrayLimit = i4;
            } else {
                if (charAt < 2048) {
                    require(2);
                    byte[] bArr2 = this.array;
                    int i5 = this.arrayLimit;
                    int i6 = i5 - 1;
                    this.arrayLimit = i6;
                    bArr2[i6] = (byte) (128 | (charAt & '?'));
                    int i7 = i5 - 2;
                    this.arrayLimit = i7;
                    bArr2[i7] = (byte) ((charAt >> 6) | UserProxyUtility.roomAllGift);
                } else if (charAt >= 55296 && charAt <= 57343) {
                    if (i >= 0) {
                        c = value.charAt(i);
                    } else {
                        c = 65535;
                    }
                    if (c <= 56319 && 56320 <= charAt && charAt < 57344) {
                        length -= 2;
                        int i8 = (((c & 1023) << 10) | (charAt & 1023)) + 65536;
                        require(4);
                        byte[] bArr3 = this.array;
                        int i9 = this.arrayLimit;
                        int i10 = i9 - 1;
                        this.arrayLimit = i10;
                        bArr3[i10] = (byte) ((i8 & 63) | 128);
                        int i11 = i9 - 2;
                        this.arrayLimit = i11;
                        bArr3[i11] = (byte) (((i8 >> 6) & 63) | 128);
                        int i12 = i9 - 3;
                        this.arrayLimit = i12;
                        bArr3[i12] = (byte) (128 | (63 & (i8 >> 12)));
                        int i13 = i9 - 4;
                        this.arrayLimit = i13;
                        bArr3[i13] = (byte) ((i8 >> 18) | 240);
                    } else {
                        require(1);
                        byte[] bArr4 = this.array;
                        int i14 = this.arrayLimit - 1;
                        this.arrayLimit = i14;
                        bArr4[i14] = 63;
                    }
                } else {
                    require(3);
                    byte[] bArr5 = this.array;
                    int i15 = this.arrayLimit;
                    int i16 = i15 - 1;
                    this.arrayLimit = i16;
                    bArr5[i16] = (byte) ((charAt & '?') | 128);
                    int i17 = i15 - 2;
                    this.arrayLimit = i17;
                    bArr5[i17] = (byte) (128 | (63 & (charAt >> 6)));
                    int i18 = i15 - 3;
                    this.arrayLimit = i18;
                    bArr5[i18] = (byte) ((charAt >> '\f') | 224);
                }
                length = i;
            }
        }
    }

    public final void writeTag(int fieldNumber, @NotNull FieldEncoding fieldEncoding) {
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        writeVarint32(ProtoWriter.INSTANCE.makeTag$wire_runtime(fieldNumber, fieldEncoding));
    }

    public final void writeTo(@NotNull BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        emitCurrentSegment();
        sink.writeAll(this.tail);
    }

    public final void writeVarint32(int value) {
        int varint32Size$wire_runtime = ProtoWriter.INSTANCE.varint32Size$wire_runtime(value);
        require(varint32Size$wire_runtime);
        int i = this.arrayLimit - varint32Size$wire_runtime;
        this.arrayLimit = i;
        while ((value & (-128)) != 0) {
            this.array[i] = (byte) ((value & 127) | 128);
            value >>>= 7;
            i++;
        }
        this.array[i] = (byte) value;
    }

    public final void writeVarint64(long value) {
        int varint64Size$wire_runtime = ProtoWriter.INSTANCE.varint64Size$wire_runtime(value);
        require(varint64Size$wire_runtime);
        int i = this.arrayLimit - varint64Size$wire_runtime;
        this.arrayLimit = i;
        while (((-128) & value) != 0) {
            this.array[i] = (byte) ((127 & value) | 128);
            value >>>= 7;
            i++;
        }
        this.array[i] = (byte) value;
    }
}
