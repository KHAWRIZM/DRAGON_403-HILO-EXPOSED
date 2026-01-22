package com.amazonaws.services.s3.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.OnFileDelete;
import com.amazonaws.services.s3.UploadObjectObserver;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MultiFileOutputStream extends OutputStream implements OnFileDelete {
    private static final int DEFAULT_PART_SIZE = 5242880;
    private static final int PART_BYTE = 5;
    private static final int SHIFT_VALUE = 20;
    private boolean closed;
    private int currFileBytesWritten;
    private long diskLimit;
    private Semaphore diskPermits;
    private int filesCreated;
    private final String namePrefix;
    private UploadObjectObserver observer;
    private FileOutputStream os;
    private long partSize;
    private final File root;
    private long totalBytesWritten;

    public MultiFileOutputStream() {
        this.partSize = 5242880L;
        this.diskLimit = LongCompanionObject.MAX_VALUE;
        this.root = new File(System.getProperty("java.io.tmpdir"));
        this.namePrefix = yyMMdd_hhmmss() + InstructionFileId.DOT + UUID.randomUUID();
    }

    private void blockIfNecessary() {
        Semaphore semaphore = this.diskPermits;
        if (semaphore != null && this.diskLimit != LongCompanionObject.MAX_VALUE) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e10) {
                throw new AbortedException(e10);
            }
        }
    }

    private FileOutputStream fos() throws IOException {
        if (!this.closed) {
            FileOutputStream fileOutputStream = this.os;
            if (fileOutputStream == null || this.currFileBytesWritten >= this.partSize) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    this.observer.onPartCreate(new PartCreationEvent(getFile(this.filesCreated), this.filesCreated, false, this));
                }
                this.currFileBytesWritten = 0;
                this.filesCreated++;
                blockIfNecessary();
                File file = getFile(this.filesCreated);
                file.deleteOnExit();
                this.os = new FileOutputStream(file);
            }
            return this.os;
        }
        throw new IOException("Output stream is already closed");
    }

    static String yyMMdd_hhmmss() {
        return new SimpleDateFormat("yyMMdd-hhmmss").format(new Date());
    }

    public void cleanup() {
        for (int i10 = 0; i10 < getNumFilesWritten(); i10++) {
            File file = getFile(i10);
            if (file.exists() && !file.delete()) {
                LogFactory.getLog(getClass()).debug("Ignoring failure to delete file " + file);
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        FileOutputStream fileOutputStream = this.os;
        if (fileOutputStream != null) {
            fileOutputStream.close();
            File file = getFile(this.filesCreated);
            if (file.length() == 0) {
                if (!file.delete()) {
                    LogFactory.getLog(getClass()).debug("Ignoring failure to delete empty file " + file);
                    return;
                }
                return;
            }
            this.observer.onPartCreate(new PartCreationEvent(getFile(this.filesCreated), this.filesCreated, true, this));
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        FileOutputStream fileOutputStream = this.os;
        if (fileOutputStream != null) {
            fileOutputStream.flush();
        }
    }

    public long getDiskLimit() {
        return this.diskLimit;
    }

    public File getFile(int i10) {
        return new File(this.root, this.namePrefix + InstructionFileId.DOT + i10);
    }

    public String getNamePrefix() {
        return this.namePrefix;
    }

    public int getNumFilesWritten() {
        return this.filesCreated;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public File getRoot() {
        return this.root;
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public MultiFileOutputStream init(UploadObjectObserver uploadObjectObserver, long j10, long j11) {
        Semaphore semaphore;
        if (uploadObjectObserver != null) {
            this.observer = uploadObjectObserver;
            if (j11 >= (j10 << 1)) {
                this.partSize = j10;
                this.diskLimit = j11;
                int i10 = (int) (j11 / j10);
                if (i10 < 0) {
                    semaphore = null;
                } else {
                    semaphore = new Semaphore(i10);
                }
                this.diskPermits = semaphore;
                return this;
            }
            throw new IllegalArgumentException("Maximum temporary disk space must be at least twice as large as the part size: partSize=" + j10 + ", diskSize=" + j11);
        }
        throw new IllegalArgumentException("Observer must be specified");
    }

    public boolean isClosed() {
        return this.closed;
    }

    @Override // com.amazonaws.services.s3.OnFileDelete
    public void onFileDelete(FileDeletionEvent fileDeletionEvent) {
        Semaphore semaphore = this.diskPermits;
        if (semaphore != null) {
            semaphore.release();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        fos().write(i10);
        this.currFileBytesWritten++;
        this.totalBytesWritten++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        if (bArr.length == 0) {
            return;
        }
        fos().write(bArr);
        this.currFileBytesWritten += bArr.length;
        this.totalBytesWritten += bArr.length;
    }

    public MultiFileOutputStream(File file, String str) {
        this.partSize = 5242880L;
        this.diskLimit = LongCompanionObject.MAX_VALUE;
        if (file != null && file.isDirectory() && file.canWrite()) {
            if (str != null && str.trim().length() != 0) {
                this.root = file;
                this.namePrefix = str;
                return;
            }
            throw new IllegalArgumentException("Please specify a non-empty name prefix");
        }
        throw new IllegalArgumentException(file + " must be a writable directory");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        if (bArr.length == 0) {
            return;
        }
        fos().write(bArr, i10, i11);
        this.currFileBytesWritten += i11;
        this.totalBytesWritten += i11;
    }
}
