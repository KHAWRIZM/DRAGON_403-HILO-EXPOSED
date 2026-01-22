package androidx.datastore.core;

import com.google.android.gms.appinvite.PreviewActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0004J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0011\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Landroidx/datastore/core/FileReadScope;", "T", "Landroidx/datastore/core/ReadScope;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "(Ljava/io/File;Landroidx/datastore/core/Serializer;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFile", "()Ljava/io/File;", "getSerializer", "()Landroidx/datastore/core/Serializer;", "checkNotClosed", "", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileStorage.kt\nandroidx/datastore/core/FileReadScope\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1#2:209\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class FileReadScope<T> implements ReadScope<T> {

    @NotNull
    private final java.util.concurrent.atomic.AtomicBoolean closed;

    @NotNull
    private final File file;

    @NotNull
    private final Serializer<T> serializer;

    public FileReadScope(@NotNull File file, @NotNull Serializer<T> serializer) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.file = file;
        this.serializer = serializer;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(6:5|6|7|(1:(1:(5:11|12|13|14|15)(2:25|26))(3:27|28|29))(6:40|41|42|43|44|(1:46)(1:47))|30|31))|67|6|7|(0)(0)|30|31|(3:(1:36)|(1:21)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x006f, code lost:
    
        r7 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [androidx.datastore.core.FileReadScope] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <T> Object readData$suspendImpl(FileReadScope<T> fileReadScope, Continuation<? super T> continuation) {
        FileReadScope$readData$1 fileReadScope$readData$1;
        ?? r22;
        Throwable th;
        java.io.Closeable closeable;
        Throwable th2;
        java.io.Closeable closeable2;
        if (continuation instanceof FileReadScope$readData$1) {
            fileReadScope$readData$1 = (FileReadScope$readData$1) continuation;
            int i10 = fileReadScope$readData$1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fileReadScope$readData$1.label = i10 - Integer.MIN_VALUE;
                Object obj = fileReadScope$readData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                r22 = fileReadScope$readData$1.label;
                if (r22 == 0) {
                    if (r22 != 1) {
                        if (r22 == 2) {
                            closeable = (java.io.Closeable) fileReadScope$readData$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                kotlin.io.CloseableKt.closeFinally(closeable, null);
                                return obj;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    throw th2;
                                } finally {
                                }
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable2 = (java.io.Closeable) fileReadScope$readData$1.L$1;
                    r22 = (FileReadScope) fileReadScope$readData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th2 = th4;
                        try {
                            throw th2;
                        } finally {
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    fileReadScope.checkNotClosed();
                    try {
                        FileInputStream fileInputStream = new FileInputStream(((FileReadScope) fileReadScope).file);
                        try {
                            Serializer<T> serializer = ((FileReadScope) fileReadScope).serializer;
                            fileReadScope$readData$1.L$0 = fileReadScope;
                            fileReadScope$readData$1.L$1 = fileInputStream;
                            fileReadScope$readData$1.label = 1;
                            Object readFrom = serializer.readFrom(fileInputStream, fileReadScope$readData$1);
                            if (readFrom == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            closeable2 = fileInputStream;
                            obj = readFrom;
                        } catch (Throwable th5) {
                            r22 = fileReadScope;
                            closeable2 = fileInputStream;
                            th2 = th5;
                            throw th2;
                        }
                    } catch (FileNotFoundException unused) {
                        if (((FileReadScope) fileReadScope).file.exists()) {
                            FileInputStream fileInputStream2 = new FileInputStream(((FileReadScope) fileReadScope).file);
                            try {
                                Serializer<T> serializer2 = ((FileReadScope) fileReadScope).serializer;
                                fileReadScope$readData$1.L$0 = fileInputStream2;
                                fileReadScope$readData$1.L$1 = null;
                                fileReadScope$readData$1.label = 2;
                                Object readFrom2 = serializer2.readFrom(fileInputStream2, fileReadScope$readData$1);
                                if (readFrom2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = readFrom2;
                                closeable = fileInputStream2;
                                kotlin.io.CloseableKt.closeFinally(closeable, null);
                                return obj;
                            } catch (Throwable th6) {
                                th = th6;
                                closeable = fileInputStream2;
                                throw th2;
                            }
                        }
                        return ((FileReadScope) fileReadScope).serializer.getDefaultValue();
                    }
                }
                kotlin.io.CloseableKt.closeFinally(closeable2, null);
                return obj;
            }
        }
        fileReadScope$readData$1 = new FileReadScope$readData$1(fileReadScope, continuation);
        Object obj2 = fileReadScope$readData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r22 = fileReadScope$readData$1.label;
        if (r22 == 0) {
        }
        kotlin.io.CloseableKt.closeFinally(closeable2, null);
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkNotClosed() {
        if (!this.closed.get()) {
        } else {
            throw new IllegalStateException("This scope has already been closed.");
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final File getFile() {
        return this.file;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Serializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    @Nullable
    public Object readData(@NotNull Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }
}
