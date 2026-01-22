package kotlin.reflect.jvm.internal.impl.protobuf;

import io.agora.rtc.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int totalBytesWritten = 0;
    private int position = 0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.limit = bArr.length;
    }

    public static int computeBoolSize(int i10, boolean z10) {
        return computeTagSize(i10) + computeBoolSizeNoTag(z10);
    }

    public static int computeBoolSizeNoTag(boolean z10) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeBytesSize(int i10, ByteString byteString) {
        return computeTagSize(i10) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeRawVarint32Size(byteString.size()) + byteString.size();
    }

    public static int computeDoubleSize(int i10, double d10) {
        return computeTagSize(i10) + computeDoubleSizeNoTag(d10);
    }

    public static int computeDoubleSizeNoTag(double d10) {
        return 8;
    }

    public static int computeEnumSize(int i10, int i11) {
        return computeTagSize(i10) + computeEnumSizeNoTag(i11);
    }

    public static int computeEnumSizeNoTag(int i10) {
        return computeInt32SizeNoTag(i10);
    }

    public static int computeFixed32SizeNoTag(int i10) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long j10) {
        return 8;
    }

    public static int computeFloatSize(int i10, float f10) {
        return computeTagSize(i10) + computeFloatSizeNoTag(f10);
    }

    public static int computeFloatSizeNoTag(float f10) {
        return 4;
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i10, int i11) {
        return computeTagSize(i10) + computeInt32SizeNoTag(i11);
    }

    public static int computeInt32SizeNoTag(int i10) {
        if (i10 >= 0) {
            return computeRawVarint32Size(i10);
        }
        return 10;
    }

    public static int computeInt64SizeNoTag(long j10) {
        return computeRawVarint64Size(j10);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        int serializedSize = lazyFieldLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeMessageSize(int i10, MessageLite messageLite) {
        return computeTagSize(i10) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computePreferredBufferSize(int i10) {
        if (i10 > 4096) {
            return 4096;
        }
        return i10;
    }

    public static int computeRawVarint32Size(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeRawVarint64Size(long j10) {
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (((-16384) & j10) == 0) {
            return 2;
        }
        if (((-2097152) & j10) == 0) {
            return 3;
        }
        if (((-268435456) & j10) == 0) {
            return 4;
        }
        if (((-34359738368L) & j10) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j10) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j10) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j10) == 0) {
            return 8;
        }
        return (j10 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32SizeNoTag(int i10) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j10) {
        return 8;
    }

    public static int computeSInt32SizeNoTag(int i10) {
        return computeRawVarint32Size(encodeZigZag32(i10));
    }

    public static int computeSInt64Size(int i10, long j10) {
        return computeTagSize(i10) + computeSInt64SizeNoTag(j10);
    }

    public static int computeSInt64SizeNoTag(long j10) {
        return computeRawVarint64Size(encodeZigZag64(j10));
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported.", e10);
        }
    }

    public static int computeTagSize(int i10) {
        return computeRawVarint32Size(WireFormat.makeTag(i10, 0));
    }

    public static int computeUInt32SizeNoTag(int i10) {
        return computeRawVarint32Size(i10);
    }

    public static int computeUInt64SizeNoTag(long j10) {
        return computeRawVarint64Size(j10);
    }

    public static int encodeZigZag32(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long encodeZigZag64(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i10) {
        return new CodedOutputStream(outputStream, new byte[i10]);
    }

    private void refreshBuffer() throws IOException {
        OutputStream outputStream = this.output;
        if (outputStream != null) {
            outputStream.write(this.buffer, 0, this.position);
            this.position = 0;
            return;
        }
        throw new OutOfSpaceException();
    }

    public void flush() throws IOException {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public void writeBool(int i10, boolean z10) throws IOException {
        writeTag(i10, 0);
        writeBoolNoTag(z10);
    }

    public void writeBoolNoTag(boolean z10) throws IOException {
        writeRawByte(z10 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeBytes(int i10, ByteString byteString) throws IOException {
        writeTag(i10, 2);
        writeBytesNoTag(byteString);
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeDouble(int i10, double d10) throws IOException {
        writeTag(i10, 1);
        writeDoubleNoTag(d10);
    }

    public void writeDoubleNoTag(double d10) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d10));
    }

    public void writeEnum(int i10, int i11) throws IOException {
        writeTag(i10, 0);
        writeEnumNoTag(i11);
    }

    public void writeEnumNoTag(int i10) throws IOException {
        writeInt32NoTag(i10);
    }

    public void writeFixed32NoTag(int i10) throws IOException {
        writeRawLittleEndian32(i10);
    }

    public void writeFixed64NoTag(long j10) throws IOException {
        writeRawLittleEndian64(j10);
    }

    public void writeFloat(int i10, float f10) throws IOException {
        writeTag(i10, 5);
        writeFloatNoTag(f10);
    }

    public void writeFloatNoTag(float f10) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(f10));
    }

    public void writeGroup(int i10, MessageLite messageLite) throws IOException {
        writeTag(i10, 3);
        writeGroupNoTag(messageLite);
        writeTag(i10, 4);
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public void writeInt32(int i10, int i11) throws IOException {
        writeTag(i10, 0);
        writeInt32NoTag(i11);
    }

    public void writeInt32NoTag(int i10) throws IOException {
        if (i10 >= 0) {
            writeRawVarint32(i10);
        } else {
            writeRawVarint64(i10);
        }
    }

    public void writeInt64NoTag(long j10) throws IOException {
        writeRawVarint64(j10);
    }

    public void writeMessage(int i10, MessageLite messageLite) throws IOException {
        writeTag(i10, 2);
        writeMessageNoTag(messageLite);
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeMessageSetExtension(int i10, MessageLite messageLite) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i10);
        writeMessage(3, messageLite);
        writeTag(1, 4);
    }

    public void writeRawByte(byte b10) throws IOException {
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i10 = this.position;
        this.position = i10 + 1;
        bArr[i10] = b10;
        this.totalBytesWritten++;
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        writeRawBytes(byteString, 0, byteString.size());
    }

    public void writeRawLittleEndian32(int i10) throws IOException {
        writeRawByte(i10 & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte((i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte((i10 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
    }

    public void writeRawLittleEndian64(long j10) throws IOException {
        writeRawByte(((int) j10) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte(((int) (j10 >> 8)) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte(((int) (j10 >> 16)) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte(((int) (j10 >> 24)) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte(((int) (j10 >> 32)) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte(((int) (j10 >> 40)) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte(((int) (j10 >> 48)) & KotlinVersion.MAX_COMPONENT_VALUE);
        writeRawByte(((int) (j10 >> 56)) & KotlinVersion.MAX_COMPONENT_VALUE);
    }

    public void writeRawVarint32(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            writeRawByte((i10 & Constants.ERR_WATERMARKR_INFO) | 128);
            i10 >>>= 7;
        }
        writeRawByte(i10);
    }

    public void writeRawVarint64(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            writeRawByte((((int) j10) & Constants.ERR_WATERMARKR_INFO) | 128);
            j10 >>>= 7;
        }
        writeRawByte((int) j10);
    }

    public void writeSFixed32NoTag(int i10) throws IOException {
        writeRawLittleEndian32(i10);
    }

    public void writeSFixed64NoTag(long j10) throws IOException {
        writeRawLittleEndian64(j10);
    }

    public void writeSInt32NoTag(int i10) throws IOException {
        writeRawVarint32(encodeZigZag32(i10));
    }

    public void writeSInt64(int i10, long j10) throws IOException {
        writeTag(i10, 0);
        writeSInt64NoTag(j10);
    }

    public void writeSInt64NoTag(long j10) throws IOException {
        writeRawVarint64(encodeZigZag64(j10));
    }

    public void writeStringNoTag(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i10, int i11) throws IOException {
        writeRawVarint32(WireFormat.makeTag(i10, i11));
    }

    public void writeUInt32(int i10, int i11) throws IOException {
        writeTag(i10, 0);
        writeUInt32NoTag(i11);
    }

    public void writeUInt32NoTag(int i10) throws IOException {
        writeRawVarint32(i10);
    }

    public void writeUInt64NoTag(long j10) throws IOException {
        writeRawVarint64(j10);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.limit;
        int i13 = this.position;
        if (i12 - i13 >= i11) {
            System.arraycopy(bArr, i10, this.buffer, i13, i11);
            this.position += i11;
            this.totalBytesWritten += i11;
            return;
        }
        int i14 = i12 - i13;
        System.arraycopy(bArr, i10, this.buffer, i13, i14);
        int i15 = i10 + i14;
        int i16 = i11 - i14;
        this.position = this.limit;
        this.totalBytesWritten += i14;
        refreshBuffer();
        if (i16 <= this.limit) {
            System.arraycopy(bArr, i15, this.buffer, 0, i16);
            this.position = i16;
        } else {
            this.output.write(bArr, i15, i16);
        }
        this.totalBytesWritten += i16;
    }

    public void writeRawByte(int i10) throws IOException {
        writeRawByte((byte) i10);
    }

    public void writeRawBytes(ByteString byteString, int i10, int i11) throws IOException {
        int i12 = this.limit;
        int i13 = this.position;
        if (i12 - i13 >= i11) {
            byteString.copyTo(this.buffer, i10, i13, i11);
            this.position += i11;
            this.totalBytesWritten += i11;
            return;
        }
        int i14 = i12 - i13;
        byteString.copyTo(this.buffer, i10, i13, i14);
        int i15 = i10 + i14;
        int i16 = i11 - i14;
        this.position = this.limit;
        this.totalBytesWritten += i14;
        refreshBuffer();
        if (i16 <= this.limit) {
            byteString.copyTo(this.buffer, i15, 0, i16);
            this.position = i16;
        } else {
            byteString.writeTo(this.output, i15, i16);
        }
        this.totalBytesWritten += i16;
    }
}
