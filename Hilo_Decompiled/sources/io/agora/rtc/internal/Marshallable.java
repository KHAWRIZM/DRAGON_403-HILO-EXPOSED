package io.agora.rtc.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
class Marshallable {
    private static final int BUFFER_LEN_SIZE = 2;
    private static final int BYTE_SIZE = 1;
    private static final int CHAR_SIZE = 2;
    private static final int DOUBLE_SIZE = 8;
    private static final int FLOAT_SIZE = 4;
    private static final int INT_SIZE = 4;
    private static final int LONG_SIZE = 8;
    private static final int MAX_PROTO_PACKET_SIZE = 8192;
    private static final int MIN_PROTO_PACKET_SIZE = 512;
    private static final int SHORT_SIZE = 2;
    private ByteBuffer mBuffer;

    public Marshallable() {
        this.mBuffer = null;
    }

    private ByteBuffer allocateByteBuffer(int i10) {
        ByteBuffer allocate = ByteBuffer.allocate(i10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private boolean checkSize(int i10) {
        ByteBuffer byteBuffer = this.mBuffer;
        int i11 = 8192;
        if (byteBuffer == null) {
            int i12 = i10 + 2;
            if (512 >= i12) {
                i12 = 512;
            }
            if (i12 > 8192) {
                Logging.e("Marshallable", "checkSize failed! newSize: " + i12);
                return false;
            }
            ByteBuffer allocateByteBuffer = allocateByteBuffer(i12);
            this.mBuffer = allocateByteBuffer;
            allocateByteBuffer.position(2);
            return true;
        }
        int capacity = byteBuffer.capacity();
        if (this.mBuffer.remaining() >= i10) {
            return true;
        }
        int i13 = capacity * 2;
        if (i13 - this.mBuffer.position() < i10) {
            i13 = this.mBuffer.position() + i10;
        }
        if (i13 > 8192) {
            if (this.mBuffer.position() + i10 >= 8192) {
                Logging.e("Marshallable", "checkSize failed! newSize: " + i13 + " size: " + i10 + " position: " + this.mBuffer.position());
                return false;
            }
        } else {
            i11 = i13;
        }
        ByteBuffer allocateByteBuffer2 = allocateByteBuffer(i11);
        System.arraycopy(this.mBuffer.array(), 0, allocateByteBuffer2.array(), 0, this.mBuffer.position());
        allocateByteBuffer2.position(this.mBuffer.position());
        this.mBuffer = allocateByteBuffer2;
        return true;
    }

    public void clear() {
        this.mBuffer.position(10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public byte[] marshall() {
        ByteBuffer byteBuffer = this.mBuffer;
        int position = byteBuffer != null ? (short) byteBuffer.position() : 0;
        this.mBuffer.position(0);
        pushShort(position);
        byte[] bArr = new byte[position];
        this.mBuffer.position(0);
        this.mBuffer.get(bArr);
        return bArr;
    }

    public byte[] popAll() {
        byte[] bArr = new byte[this.mBuffer.remaining()];
        this.mBuffer.get(bArr);
        return bArr;
    }

    public Boolean popBool() {
        boolean z10 = true;
        if (this.mBuffer.get() != 1) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    public byte popByte() {
        return this.mBuffer.get();
    }

    public byte[] popBytes() {
        int i10 = this.mBuffer.getShort();
        byte[] bArr = new byte[0];
        if (i10 > 0) {
            byte[] bArr2 = new byte[i10];
            this.mBuffer.get(bArr2);
            return bArr2;
        }
        return bArr;
    }

    public byte[] popBytes32() {
        int i10 = this.mBuffer.getInt();
        if (i10 > 0) {
            byte[] bArr = new byte[i10];
            this.mBuffer.get(bArr);
            return bArr;
        }
        return null;
    }

    public double popDouble() {
        return this.mBuffer.getDouble();
    }

    public float popFloat() {
        return this.mBuffer.getFloat();
    }

    public int popInt() {
        return this.mBuffer.getInt();
    }

    public long popInt64() {
        return this.mBuffer.getLong();
    }

    public int[] popIntArray() {
        int popInt = popInt();
        int[] iArr = new int[popInt];
        for (int i10 = 0; i10 < popInt; i10++) {
            iArr[i10] = popInt();
        }
        return iArr;
    }

    public short popShort() {
        return this.mBuffer.getShort();
    }

    public short[] popShortArray() {
        int popInt = popInt();
        short[] sArr = new short[popInt];
        for (int i10 = 0; i10 < popInt; i10++) {
            sArr[i10] = popShort();
        }
        return sArr;
    }

    public String popString16() {
        int i10 = this.mBuffer.getShort();
        if (i10 > 0) {
            byte[] bArr = new byte[i10];
            this.mBuffer.get(bArr);
            try {
                return new String(bArr, "ISO-8859-1");
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public String popString16UTF8() {
        int i10 = this.mBuffer.getShort();
        if (i10 > 0) {
            byte[] bArr = new byte[i10];
            this.mBuffer.get(bArr);
            try {
                return new String(bArr, "utf-8");
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public void pushBool(Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        if (!checkSize(1)) {
            return;
        }
        this.mBuffer.put(booleanValue ? (byte) 1 : (byte) 0);
    }

    public void pushByte(byte b10) {
        if (!checkSize(1)) {
            return;
        }
        this.mBuffer.put(b10);
    }

    public void pushBytes(byte[] bArr) {
        if (!checkSize(bArr.length + 2)) {
            return;
        }
        this.mBuffer.putShort((short) bArr.length);
        this.mBuffer.put(bArr);
    }

    public void pushBytes32(byte[] bArr) {
        if (!checkSize(bArr.length + 4)) {
            return;
        }
        this.mBuffer.putInt(bArr.length);
        this.mBuffer.put(bArr);
    }

    public void pushDouble(double d10) {
        if (!checkSize(8)) {
            return;
        }
        this.mBuffer.putDouble(d10);
    }

    public void pushFloat(float f10) {
        this.mBuffer.putFloat(f10);
    }

    public void pushInt(int i10) {
        if (!checkSize(4)) {
            return;
        }
        this.mBuffer.putInt(i10);
    }

    public void pushInt64(long j10) {
        if (!checkSize(8)) {
            return;
        }
        this.mBuffer.putLong(j10);
    }

    public void pushIntArray(int[] iArr) {
        if (iArr == null) {
            pushInt(0);
            return;
        }
        pushInt(iArr.length);
        for (int i10 : iArr) {
            pushInt(i10);
        }
    }

    public void pushShort(short s10) {
        if (!checkSize(2)) {
            return;
        }
        this.mBuffer.putShort(s10);
    }

    public void pushShortArray(short[] sArr) {
        if (sArr == null) {
            pushInt(0);
            return;
        }
        pushInt(sArr.length);
        for (short s10 : sArr) {
            pushShort(s10);
        }
    }

    public void pushString16(String str) {
        if (str == null) {
            pushShort((short) 0);
        } else {
            pushBytes(str.getBytes());
        }
    }

    public void pushStringArray(ArrayList<String> arrayList) {
        if (arrayList == null) {
            pushInt(0);
            return;
        }
        int size = arrayList.size();
        pushShort((short) size);
        for (int i10 = 0; i10 < size; i10++) {
            pushBytes(arrayList.get(i10).getBytes());
        }
    }

    public void unmarshall(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.mBuffer = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        popShort();
    }

    public Marshallable(int i10) {
        this.mBuffer = null;
        this.mBuffer = allocateByteBuffer(i10 < 2 ? 2 : i10);
    }

    public void unmarshall(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public void pushIntArray(Integer[] numArr) {
        if (numArr == null) {
            pushInt(0);
            return;
        }
        pushInt(numArr.length);
        for (Integer num : numArr) {
            pushInt(num.intValue());
        }
    }

    public void marshall(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }
}
