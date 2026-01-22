package org.apache.commons.sudcompress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ParallelScatterZipCreator {
    private final i0.g backingStoreSupplier;
    private long compressionDoneAt;

    /* renamed from: es, reason: collision with root package name */
    private final ExecutorService f٩٣es;
    private final Deque<Future<? extends ScatterZipOutputStream>> futures;
    private long scatterDoneAt;
    private final long startedAt;
    private final Deque<ScatterZipOutputStream> streams;
    private final ThreadLocal<ScatterZipOutputStream> tlScatterStreams;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class DefaultBackingStoreSupplier implements i0.g {
        final AtomicInteger storeNum;

        public i0.e get() {
            return new i0.d(File.createTempFile("parallelscatter", "n" + this.storeNum.incrementAndGet()));
        }

        private DefaultBackingStoreSupplier() {
            this.storeNum = new AtomicInteger(0);
        }
    }

    public ParallelScatterZipCreator() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    }

    private void closeAll() {
        Iterator<ScatterZipOutputStream> it = this.streams.iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ScatterZipOutputStream createDeferred(i0.g gVar) {
        i0.e eVar = gVar.get();
        return new ScatterZipOutputStream(eVar, StreamCompressor.create(-1, eVar));
    }

    public void addArchiveEntry(ZipArchiveEntry zipArchiveEntry, i0.f fVar) {
        submitStreamAwareCallable(createCallable(zipArchiveEntry, fVar));
    }

    public final Callable<ScatterZipOutputStream> createCallable(ZipArchiveEntry zipArchiveEntry, i0.f fVar) {
        if (zipArchiveEntry.getMethod() != -1) {
            final ZipArchiveEntryRequest createZipArchiveEntryRequest = ZipArchiveEntryRequest.createZipArchiveEntryRequest(zipArchiveEntry, fVar);
            return new Callable<ScatterZipOutputStream>() { // from class: org.apache.commons.sudcompress.archivers.zip.ParallelScatterZipCreator.3
                @Override // java.util.concurrent.Callable
                public ScatterZipOutputStream call() {
                    ScatterZipOutputStream scatterZipOutputStream = (ScatterZipOutputStream) ParallelScatterZipCreator.this.tlScatterStreams.get();
                    scatterZipOutputStream.addArchiveEntry(createZipArchiveEntryRequest);
                    return scatterZipOutputStream;
                }
            };
        }
        throw new IllegalArgumentException("Method must be set on zipArchiveEntry: " + zipArchiveEntry);
    }

    public ScatterStatistics getStatisticsMessage() {
        long j = this.compressionDoneAt;
        return new ScatterStatistics(j - this.startedAt, this.scatterDoneAt - j);
    }

    public final void submit(final Callable<? extends Object> callable) {
        submitStreamAwareCallable(new Callable<ScatterZipOutputStream>() { // from class: org.apache.commons.sudcompress.archivers.zip.ParallelScatterZipCreator.2
            @Override // java.util.concurrent.Callable
            public ScatterZipOutputStream call() {
                callable.call();
                return (ScatterZipOutputStream) ParallelScatterZipCreator.this.tlScatterStreams.get();
            }
        });
    }

    public final void submitStreamAwareCallable(Callable<? extends ScatterZipOutputStream> callable) {
        this.futures.add(this.f٩٣es.submit(callable));
    }

    public void writeTo(ZipArchiveOutputStream zipArchiveOutputStream) {
        try {
            try {
                Iterator<Future<? extends ScatterZipOutputStream>> it = this.futures.iterator();
                while (it.hasNext()) {
                    it.next().get();
                }
                this.f٩٣es.shutdown();
                this.f٩٣es.awaitTermination(60000L, TimeUnit.SECONDS);
                this.compressionDoneAt = System.currentTimeMillis();
                Iterator<Future<? extends ScatterZipOutputStream>> it2 = this.futures.iterator();
                while (it2.hasNext()) {
                    it2.next().get().zipEntryWriter().writeNextZipEntry(zipArchiveOutputStream);
                }
                Iterator<ScatterZipOutputStream> it3 = this.streams.iterator();
                while (it3.hasNext()) {
                    it3.next().close();
                }
                this.scatterDoneAt = System.currentTimeMillis();
                closeAll();
            } catch (Throwable th) {
                this.f٩٣es.shutdown();
                throw th;
            }
        } catch (Throwable th2) {
            closeAll();
            throw th2;
        }
    }

    public ParallelScatterZipCreator(ExecutorService executorService) {
        this(executorService, new DefaultBackingStoreSupplier());
    }

    public void addArchiveEntry(ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        submitStreamAwareCallable(createCallable(zipArchiveEntryRequestSupplier));
    }

    public ParallelScatterZipCreator(ExecutorService executorService, i0.g gVar) {
        this.streams = new ConcurrentLinkedDeque();
        this.futures = new ConcurrentLinkedDeque();
        this.startedAt = System.currentTimeMillis();
        this.compressionDoneAt = 0L;
        this.tlScatterStreams = new ThreadLocal<ScatterZipOutputStream>() { // from class: org.apache.commons.sudcompress.archivers.zip.ParallelScatterZipCreator.1
            @Override // java.lang.ThreadLocal
            public ScatterZipOutputStream initialValue() {
                try {
                    ParallelScatterZipCreator parallelScatterZipCreator = ParallelScatterZipCreator.this;
                    ScatterZipOutputStream createDeferred = parallelScatterZipCreator.createDeferred(parallelScatterZipCreator.backingStoreSupplier);
                    ParallelScatterZipCreator.this.streams.add(createDeferred);
                    return createDeferred;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        this.backingStoreSupplier = gVar;
        this.f٩٣es = executorService;
    }

    public final Callable<ScatterZipOutputStream> createCallable(final ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        return new Callable<ScatterZipOutputStream>() { // from class: org.apache.commons.sudcompress.archivers.zip.ParallelScatterZipCreator.4
            @Override // java.util.concurrent.Callable
            public ScatterZipOutputStream call() {
                ScatterZipOutputStream scatterZipOutputStream = (ScatterZipOutputStream) ParallelScatterZipCreator.this.tlScatterStreams.get();
                scatterZipOutputStream.addArchiveEntry(zipArchiveEntryRequestSupplier.get());
                return scatterZipOutputStream;
            }
        };
    }
}
