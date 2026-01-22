package org.apache.commons.sudcompress.compressors.lzw;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import k0.l;
import y.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class Suddo extends a {
    protected static final int DEFAULT_CODE_SIZE = 9;
    protected static final int UNUSED_PREFIX = -1;
    private byte[] characters;
    private int clearCode;
    private int codeSize;
    protected final l in;
    private final byte[] oneByte;
    private byte[] outputStack;
    private int outputStackLocation;
    private int[] prefixes;
    private int previousCode;
    private byte previousCodeFirstChar;
    private int tableSize;

    public Suddo(InputStream inputStream) {
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        this.oneByte = new byte[1];
        this.clearCode = -1;
        this.codeSize = 9;
        this.previousCode = -1;
        this.in = new l(inputStream, byteOrder);
    }

    public abstract int addEntry(int i, byte b);

    public int addEntry(int i, byte b, int i2) {
        int i3 = this.tableSize;
        if (i3 >= i2) {
            return -1;
        }
        this.prefixes[i3] = i;
        this.characters[i3] = b;
        this.tableSize = i3 + 1;
        return i3;
    }

    public int addRepeatOfPreviousCode() {
        int i = this.previousCode;
        if (i != -1) {
            return addEntry(i, this.previousCodeFirstChar);
        }
        throw new IOException("The first code can't be a reference to its preceding code");
    }

    public void close() {
        this.in.close();
    }

    public abstract int decompressNextSymbol();

    public int expandCodeToOutputStack(int i, boolean z) {
        int i2 = i;
        while (i2 >= 0) {
            byte[] bArr = this.outputStack;
            int i3 = this.outputStackLocation - 1;
            this.outputStackLocation = i3;
            bArr[i3] = this.characters[i2];
            i2 = this.prefixes[i2];
        }
        int i4 = this.previousCode;
        if (i4 != -1 && !z) {
            addEntry(i4, this.outputStack[this.outputStackLocation]);
        }
        this.previousCode = i;
        byte[] bArr2 = this.outputStack;
        int i5 = this.outputStackLocation;
        this.previousCodeFirstChar = bArr2[i5];
        return i5;
    }

    public int getClearCode() {
        return this.clearCode;
    }

    public int getCodeSize() {
        return this.codeSize;
    }

    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    public int getPrefix(int i) {
        return this.prefixes[i];
    }

    public int getPrefixesLength() {
        return this.prefixes.length;
    }

    public int getTableSize() {
        return this.tableSize;
    }

    public void incrementCodeSize() {
        this.codeSize++;
    }

    public void initializeTables(int i, int i2) {
        if (i > 0) {
            if (i2 > -1) {
                long j = ((1 << i) * 6) >> 10;
                if (j > i2) {
                    throw new v.a(i2, j);
                }
            }
            initializeTables(i);
            return;
        }
        throw new IllegalArgumentException("maxCodeSize is " + i + ", must be bigger than 0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int read() {
        int read = read(this.oneByte);
        return read < 0 ? read : this.oneByte[0] & 255;
    }

    public int readNextCode() {
        int i = this.codeSize;
        if (i <= 31) {
            return (int) this.in.readBits(i);
        }
        throw new IllegalArgumentException("Code size must not be bigger than 31");
    }

    public void resetCodeSize() {
        setCodeSize(9);
    }

    public void resetPreviousCode() {
        this.previousCode = -1;
    }

    public void setClearCode(int i) {
        this.clearCode = 1 << (i - 1);
    }

    public void setCodeSize(int i) {
        this.codeSize = i;
    }

    public void setPrefix(int i, int i2) {
        this.prefixes[i] = i2;
    }

    public void setTableSize(int i) {
        this.tableSize = i;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        if (i2 == 0) {
            return 0;
        }
        int length = this.outputStack.length - this.outputStackLocation;
        if (length > 0) {
            i3 = Math.min(length, i2);
            System.arraycopy(this.outputStack, this.outputStackLocation, bArr, i, i3);
            this.outputStackLocation += i3;
        } else {
            i3 = 0;
        }
        while (true) {
            int i5 = i2 - i3;
            if (i5 > 0) {
                int decompressNextSymbol = decompressNextSymbol();
                if (decompressNextSymbol < 0) {
                    if (i3 <= 0) {
                        return decompressNextSymbol;
                    }
                    count(i3);
                    return i3;
                }
                int i6 = i + i3;
                int length2 = this.outputStack.length - this.outputStackLocation;
                if (length2 > 0) {
                    i4 = Math.min(length2, i5);
                    System.arraycopy(this.outputStack, this.outputStackLocation, bArr, i6, i4);
                    this.outputStackLocation += i4;
                } else {
                    i4 = 0;
                }
                i3 += i4;
            } else {
                count(i3);
                return i3;
            }
        }
    }

    public void initializeTables(int i) {
        if (i > 0) {
            int i2 = 1 << i;
            this.prefixes = new int[i2];
            this.characters = new byte[i2];
            this.outputStack = new byte[i2];
            this.outputStackLocation = i2;
            for (int i3 = 0; i3 < 256; i3++) {
                this.prefixes[i3] = -1;
                this.characters[i3] = (byte) i3;
            }
            return;
        }
        throw new IllegalArgumentException("maxCodeSize is " + i + ", must be bigger than 0");
    }
}
