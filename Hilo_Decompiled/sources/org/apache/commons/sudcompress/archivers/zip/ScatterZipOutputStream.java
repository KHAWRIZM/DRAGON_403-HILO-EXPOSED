package org.apache.commons.sudcompress.archivers.zip;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ScatterZipOutputStream implements Closeable {
    private final i0.e backingStore;
    private final StreamCompressor streamCompressor;
    private final Queue<CompressedEntry> items = new ConcurrentLinkedQueue();
    private AtomicBoolean isClosed = new AtomicBoolean();
    private ZipEntryWriter zipEntryWriter = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class CompressedEntry {
        final long compressedSize;
        final long crc;
        final long size;
        final ZipArchiveEntryRequest zipArchiveEntryRequest;

        public CompressedEntry(ZipArchiveEntryRequest zipArchiveEntryRequest, long j, long j2, long j3) {
            this.zipArchiveEntryRequest = zipArchiveEntryRequest;
            this.crc = j;
            this.compressedSize = j2;
            this.size = j3;
        }

        public ZipArchiveEntry transferToArchiveEntry() {
            ZipArchiveEntry zipArchiveEntry = this.zipArchiveEntryRequest.getZipArchiveEntry();
            zipArchiveEntry.setCompressedSize(this.compressedSize);
            zipArchiveEntry.setSize(this.size);
            zipArchiveEntry.setCrc(this.crc);
            zipArchiveEntry.setMethod(this.zipArchiveEntryRequest.getMethod());
            return zipArchiveEntry;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class ZipEntryWriter implements Closeable {
        private final Iterator<CompressedEntry> itemsIterator;
        private final InputStream itemsIteratorData;

        public ZipEntryWriter(ScatterZipOutputStream scatterZipOutputStream) {
            i0.d dVar = scatterZipOutputStream.backingStore;
            if (!dVar.c) {
                dVar.b.close();
                dVar.c = true;
            }
            this.itemsIterator = scatterZipOutputStream.items.iterator();
            this.itemsIteratorData = scatterZipOutputStream.backingStore.a();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            InputStream inputStream = this.itemsIteratorData;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public void writeNextZipEntry(ZipArchiveOutputStream zipArchiveOutputStream) {
            CompressedEntry next = this.itemsIterator.next();
            zipArchiveOutputStream.addRawArchiveEntry(next.transferToArchiveEntry(), new k(this.itemsIteratorData, next.compressedSize));
        }
    }

    public ScatterZipOutputStream(i0.e eVar, StreamCompressor streamCompressor) {
        this.backingStore = eVar;
        this.streamCompressor = streamCompressor;
    }

    public static ScatterZipOutputStream fileBased(File file) {
        return fileBased(file, -1);
    }

    public void addArchiveEntry(ZipArchiveEntryRequest zipArchiveEntryRequest) {
        InputStream payloadStream = zipArchiveEntryRequest.getPayloadStream();
        try {
            this.streamCompressor.deflate(payloadStream, zipArchiveEntryRequest.getMethod());
            if (payloadStream != null) {
                payloadStream.close();
            }
            this.items.add(new CompressedEntry(zipArchiveEntryRequest, this.streamCompressor.getCrc32(), this.streamCompressor.getBytesWrittenForLastEntry(), this.streamCompressor.getBytesRead()));
        } catch (Throwable th) {
            if (payloadStream != null) {
                try {
                    payloadStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.isClosed.compareAndSet(false, true)) {
            return;
        }
        try {
            ZipEntryWriter zipEntryWriter = this.zipEntryWriter;
            if (zipEntryWriter != null) {
                zipEntryWriter.close();
            }
            this.backingStore.close();
            this.streamCompressor.close();
        } catch (Throwable th) {
            this.streamCompressor.close();
            throw th;
        }
    }

    public void writeTo(ZipArchiveOutputStream zipArchiveOutputStream) {
        i0.d dVar = this.backingStore;
        if (!dVar.c) {
            dVar.b.close();
            dVar.c = true;
        }
        InputStream a = this.backingStore.a();
        try {
            for (CompressedEntry compressedEntry : this.items) {
                zipArchiveOutputStream.addRawArchiveEntry(compressedEntry.transferToArchiveEntry(), new k(a, compressedEntry.compressedSize));
            }
            if (a != null) {
                a.close();
            }
        } catch (Throwable th) {
            if (a != null) {
                try {
                    a.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public ZipEntryWriter zipEntryWriter() {
        if (this.zipEntryWriter == null) {
            this.zipEntryWriter = new ZipEntryWriter(this);
        }
        return this.zipEntryWriter;
    }

    public static ScatterZipOutputStream fileBased(File file, int i) {
        i0.d dVar = new i0.d(file);
        return new ScatterZipOutputStream(dVar, StreamCompressor.create(i, (i0.e) dVar));
    }
}
