package org.apache.commons.sudcompress.archivers.zip;

import java.io.InputStream;
import k0.n;
import k0.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class ExplodingInputStream extends InputStream {
    private BitStream bits;
    private final int dictionarySize;
    private BinaryTree distanceTree;
    private final InputStream in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;
    private final CircularBuffer buffer = new CircularBuffer(32768);
    private long uncompressedCount = 0;
    private long treeSizes = 0;

    public ExplodingInputStream(int i, int i2, InputStream inputStream) {
        if (i != 4096 && i != 8192) {
            throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
        }
        if (i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("The number of trees must be 2 or 3");
        }
        this.dictionarySize = i;
        this.numberOfTrees = i2;
        this.minimumMatchLength = i2;
        this.in = inputStream;
    }

    private void fillBuffer() {
        int i;
        int nextByte;
        init();
        int nextBit = this.bits.nextBit();
        if (nextBit != -1) {
            if (nextBit == 1) {
                BinaryTree binaryTree = this.literalTree;
                if (binaryTree != null) {
                    nextByte = binaryTree.read(this.bits);
                } else {
                    nextByte = this.bits.nextByte();
                }
                if (nextByte != -1) {
                    this.buffer.put(nextByte);
                    return;
                }
                return;
            }
            if (this.dictionarySize == 4096) {
                i = 6;
            } else {
                i = 7;
            }
            int nextBits = (int) this.bits.nextBits(i);
            int read = this.distanceTree.read(this.bits);
            if (read != -1 || nextBits > 0) {
                int i2 = (read << i) | nextBits;
                int read2 = this.lengthTree.read(this.bits);
                if (read2 == 63) {
                    long nextBits2 = this.bits.nextBits(8);
                    if (nextBits2 == -1) {
                        return;
                    } else {
                        read2 = (int) (read2 + nextBits2);
                    }
                }
                this.buffer.copy(i2 + 1, read2 + this.minimumMatchLength);
            }
        }
    }

    private void init() {
        if (this.bits == null) {
            o oVar = new o(new n(this.in));
            try {
                if (this.numberOfTrees == 3) {
                    this.literalTree = BinaryTree.decode(oVar, 256);
                }
                this.lengthTree = BinaryTree.decode(oVar, 64);
                this.distanceTree = BinaryTree.decode(oVar, 64);
                this.treeSizes += oVar.getBytesRead();
                oVar.close();
                this.bits = new BitStream(this.in);
            } catch (Throwable th) {
                try {
                    oVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    public long getCompressedCount() {
        return this.bits.getBytesRead() + this.treeSizes;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.io.InputStream
    public int read() {
        if (!this.buffer.available()) {
            fillBuffer();
        }
        int i = this.buffer.get();
        if (i > -1) {
            this.uncompressedCount++;
        }
        return i;
    }
}
