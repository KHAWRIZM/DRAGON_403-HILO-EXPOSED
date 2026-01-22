package org.apache.commons.sudcompress.archivers.zip;

import e0.m;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.sudcompress.compressors.lzw.Suddo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class UnshrinkingInputStream extends Suddo {
    private static final int MAX_CODE_SIZE = 13;
    private static final int MAX_TABLE_SIZE = 8192;
    private final boolean[] isUsed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnshrinkingInputStream(InputStream inputStream) {
        super(inputStream);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        setClearCode(9);
        initializeTables(13);
        this.isUsed = new boolean[getPrefixesLength()];
        for (int i = 0; i < 256; i++) {
            this.isUsed[i] = true;
        }
        setTableSize(getClearCode() + 1);
    }

    private void partialClear() {
        boolean[] zArr = new boolean[8192];
        int i = 0;
        while (true) {
            boolean[] zArr2 = this.isUsed;
            if (i >= zArr2.length) {
                break;
            }
            if (zArr2[i] && getPrefix(i) != -1) {
                zArr[getPrefix(i)] = true;
            }
            i++;
        }
        for (int clearCode = getClearCode() + 1; clearCode < 8192; clearCode++) {
            if (!zArr[clearCode]) {
                this.isUsed[clearCode] = false;
                setPrefix(clearCode, -1);
            }
        }
    }

    @Override // org.apache.commons.sudcompress.compressors.lzw.Suddo
    public int addEntry(int i, byte b) {
        int tableSize = getTableSize();
        while (tableSize < 8192 && this.isUsed[tableSize]) {
            tableSize++;
        }
        setTableSize(tableSize);
        int addEntry = addEntry(i, b, 8192);
        if (addEntry >= 0) {
            this.isUsed[addEntry] = true;
        }
        return addEntry;
    }

    @Override // org.apache.commons.sudcompress.compressors.lzw.Suddo
    public int decompressNextSymbol() {
        int readNextCode = readNextCode();
        if (readNextCode < 0) {
            return -1;
        }
        boolean z = false;
        if (readNextCode == getClearCode()) {
            int readNextCode2 = readNextCode();
            if (readNextCode2 >= 0) {
                if (readNextCode2 == 1) {
                    if (getCodeSize() < 13) {
                        incrementCodeSize();
                    } else {
                        throw new IOException("Attempt to increase code size beyond maximum");
                    }
                } else if (readNextCode2 == 2) {
                    partialClear();
                    setTableSize(getClearCode() + 1);
                } else {
                    throw new IOException(m.a(readNextCode2, "Invalid clear code subcode "));
                }
                return 0;
            }
            throw new IOException("Unexpected EOF;");
        }
        if (!this.isUsed[readNextCode]) {
            readNextCode = addRepeatOfPreviousCode();
            z = true;
        }
        return expandCodeToOutputStack(readNextCode, z);
    }
}
