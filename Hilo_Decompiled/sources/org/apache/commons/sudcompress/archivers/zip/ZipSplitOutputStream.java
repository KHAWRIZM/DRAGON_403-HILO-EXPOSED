package org.apache.commons.sudcompress.archivers.zip;

import e0.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class ZipSplitOutputStream extends OutputStream {
    private static final long ZIP_SEGMENT_MAX_SIZE = 4294967295L;
    private static final long ZIP_SEGMENT_MIN_SIZE = 65536;
    private OutputStream outputStream;
    private final long splitSize;
    private File zipFile;
    private int currentSplitSegmentIndex = 0;
    private long currentSplitSegmentBytesWritten = 0;
    private boolean finished = false;
    private final byte[] singleByte = new byte[1];

    public ZipSplitOutputStream(File file, long j) {
        if (j >= ZIP_SEGMENT_MIN_SIZE && j <= ZIP_SEGMENT_MAX_SIZE) {
            this.zipFile = file;
            this.splitSize = j;
            this.outputStream = new FileOutputStream(file);
            writeZipSplitSignature();
            return;
        }
        throw new IllegalArgumentException("zip split segment size should between 64K and 4,294,967,295");
    }

    private File createNewSplitSegmentFile(Integer num) {
        int intValue;
        String name;
        String a;
        if (num == null) {
            intValue = this.currentSplitSegmentIndex + 2;
        } else {
            intValue = num.intValue();
        }
        String name2 = this.zipFile.getName();
        if (name2 == null) {
            name = null;
        } else {
            name = new File(name2).getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                name = name.substring(0, lastIndexOf);
            }
        }
        if (intValue <= 9) {
            a = m.a(intValue, ".z0");
        } else {
            a = m.a(intValue, ".z");
        }
        File file = new File(this.zipFile.getParent(), name + a);
        if (!file.exists()) {
            return file;
        }
        throw new IOException("split zip segment " + name + a + " already exists");
    }

    private void finish() {
        String name;
        if (!this.finished) {
            String name2 = this.zipFile.getName();
            if (name2 == null) {
                name = null;
            } else {
                name = new File(name2).getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf >= 0) {
                    name = name.substring(0, lastIndexOf);
                }
            }
            File file = new File(this.zipFile.getParentFile(), name + ".zip");
            this.outputStream.close();
            if (this.zipFile.renameTo(file)) {
                this.finished = true;
                return;
            }
            throw new IOException("Failed to rename " + this.zipFile + " to " + file);
        }
        throw new IOException("This archive has already been finished");
    }

    private OutputStream openNewSplitSegment() {
        if (this.currentSplitSegmentIndex == 0) {
            this.outputStream.close();
            File createNewSplitSegmentFile = createNewSplitSegmentFile(1);
            if (!this.zipFile.renameTo(createNewSplitSegmentFile)) {
                throw new IOException("Failed to rename " + this.zipFile + " to " + createNewSplitSegmentFile);
            }
        }
        File createNewSplitSegmentFile2 = createNewSplitSegmentFile(null);
        this.outputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(createNewSplitSegmentFile2);
        this.outputStream = fileOutputStream;
        this.currentSplitSegmentBytesWritten = 0L;
        this.zipFile = createNewSplitSegmentFile2;
        this.currentSplitSegmentIndex++;
        return fileOutputStream;
    }

    private void writeZipSplitSignature() {
        this.outputStream.write(ZipArchiveOutputStream.DD_SIG);
        this.currentSplitSegmentBytesWritten += r1.length;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.finished) {
            finish();
        }
    }

    public long getCurrentSplitSegmentBytesWritten() {
        return this.currentSplitSegmentBytesWritten;
    }

    public int getCurrentSplitSegmentIndex() {
        return this.currentSplitSegmentIndex;
    }

    public void prepareToWriteUnsplittableContent(long j) {
        long j2 = this.splitSize;
        if (j <= j2) {
            if (j2 - this.currentSplitSegmentBytesWritten < j) {
                openNewSplitSegment();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The unsplittable content size is bigger than the split segment size");
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) (i & 255);
        write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        long j = this.currentSplitSegmentBytesWritten;
        long j2 = this.splitSize;
        if (j >= j2) {
            openNewSplitSegment();
            write(bArr, i, i2);
            return;
        }
        long j3 = i2;
        if (j + j3 > j2) {
            int i3 = ((int) j2) - ((int) j);
            write(bArr, i, i3);
            openNewSplitSegment();
            write(bArr, i + i3, i2 - i3);
            return;
        }
        this.outputStream.write(bArr, i, i2);
        this.currentSplitSegmentBytesWritten += j3;
    }
}
