package androidx.datastore.core;

import com.google.android.gms.appinvite.PreviewActivity;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.io.File;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016JX\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0001\u0010\u00162B\u0010\u0017\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010!J=\u0010\"\u001a\u00020\u000b2-\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0#¢\u0006\u0002\b H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020\u000b*\u00020\u0004H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/datastore/core/FileStorageConnection;", "T", "Landroidx/datastore/core/StorageConnection;", "file", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Ljava/io/File;Landroidx/datastore/core/Serializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "readScope", "R", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFileStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileStorage.kt\nandroidx/datastore/core/FileStorageConnection\n+ 2 Closeable.kt\nandroidx/datastore/core/CloseableKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n38#2,23:209\n38#2,23:240\n120#3,8:232\n129#3:263\n1#4:264\n*S KotlinDebug\n*F\n+ 1 FileStorage.kt\nandroidx/datastore/core/FileStorageConnection\n*L\n100#1:209,23\n117#1:240,23\n114#1:232,8\n114#1:263\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class FileStorageConnection<T> implements StorageConnection<T> {

    @NotNull
    private final java.util.concurrent.atomic.AtomicBoolean closed;

    @NotNull
    private final InterProcessCoordinator coordinator;

    @NotNull
    private final File file;

    @NotNull
    private final Function0<Unit> onClose;

    @NotNull
    private final Serializer<T> serializer;

    @NotNull
    private final Mutex transactionMutex;

    public FileStorageConnection(@NotNull File file, @NotNull Serializer<T> serializer, @NotNull InterProcessCoordinator coordinator, @NotNull Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.file = file;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    private final void checkNotClosed() {
        if (!this.closed.get()) {
        } else {
            throw new IllegalStateException("StorageConnection has already been disposed.");
        }
    }

    private final void createParentDirectories(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file);
            }
        }
    }

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    @Override // androidx.datastore.core.StorageConnection
    @NotNull
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:3|(8:5|6|7|(1:(3:10|11|12)(2:32|33))(6:34|35|36|38|39|(1:41)(1:42))|13|14|15|(2:(1:18)|19)(1:21)))|7|(0)(0)|13|14|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b A[Catch: all -> 0x007c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x007c, blocks: (B:21:0x007b, B:31:0x0089, B:28:0x008c, B:27:0x0084), top: B:7:0x0022, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.FileStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r9v15, types: [boolean] */
    @Override // androidx.datastore.core.StorageConnection
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <R> Object readScope(@NotNull Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object> function3, @NotNull Continuation<? super R> continuation) {
        ?? r02;
        int i10;
        Closeable closeable;
        Throwable th;
        FileStorageConnection<T> fileStorageConnection;
        try {
            if (continuation instanceof FileStorageConnection$readScope$1) {
                FileStorageConnection$readScope$1 fileStorageConnection$readScope$1 = (FileStorageConnection$readScope$1) continuation;
                int i11 = fileStorageConnection$readScope$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    fileStorageConnection$readScope$1.label = i11 - Integer.MIN_VALUE;
                    r02 = fileStorageConnection$readScope$1;
                    Object obj = r02.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = r02.label;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            function3 = (Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object>) r02.Z$0;
                            closeable = (Closeable) r02.L$1;
                            r02 = (FileStorageConnection) r02.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                fileStorageConnection = r02;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    closeable.close();
                                } catch (Throwable th3) {
                                    ExceptionsKt.addSuppressed(th, th3);
                                }
                                throw th;
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        checkNotClosed();
                        boolean tryLock$default = Mutex.DefaultImpls.tryLock$default(this.transactionMutex, (Object) null, 1, (Object) null);
                        try {
                            FileReadScope fileReadScope = new FileReadScope(this.file, this.serializer);
                            try {
                                Boolean boxBoolean = Boxing.boxBoolean(tryLock$default);
                                r02.L$0 = this;
                                r02.L$1 = fileReadScope;
                                r02.Z$0 = tryLock$default;
                                r02.label = 1;
                                Object invoke = function3.invoke(fileReadScope, boxBoolean, r02);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                fileStorageConnection = this;
                                closeable = fileReadScope;
                                obj = invoke;
                                function3 = tryLock$default ? 1 : 0;
                            } catch (Throwable th4) {
                                r02 = this;
                                closeable = fileReadScope;
                                th = th4;
                                function3 = tryLock$default ? 1 : 0;
                                closeable.close();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            r02 = this;
                            th = th5;
                            function3 = tryLock$default ? 1 : 0;
                            if (function3 != null) {
                            }
                            throw th;
                        }
                    }
                    closeable.close();
                    th = null;
                    if (th != null) {
                        if (function3 != null) {
                            Mutex.DefaultImpls.unlock$default(fileStorageConnection.transactionMutex, (Object) null, 1, (Object) null);
                        }
                        return obj;
                    }
                    throw th;
                }
            }
            if (i10 == 0) {
            }
            closeable.close();
            th = null;
            if (th != null) {
            }
        } catch (Throwable th6) {
            th = th6;
            if (function3 != null) {
                Mutex.DefaultImpls.unlock$default(r02.transactionMutex, (Object) null, 1, (Object) null);
            }
            throw th;
        }
        r02 = new FileStorageConnection$readScope$1(this, continuation);
        Object obj2 = r02.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = r02.label;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(6:(2:3|(10:5|6|7|(1:(1:(8:11|12|13|14|15|16|17|(5:19|(2:24|25)|27|28|29)(1:30))(2:41|42))(1:43))(2:61|(1:63)(1:64))|44|45|46|47|48|(1:50)(6:51|14|15|16|17|(0)(0))))|45|46|47|48|(0)(0))|70|6|7|(0)(0)|44|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f2, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f3, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bb A[Catch: all -> 0x00f0, IOException -> 0x00f2, TRY_ENTER, TryCatch #0 {all -> 0x00f0, blocks: (B:19:0x00bb, B:21:0x00c1, B:24:0x00ca, B:25:0x00ef, B:27:0x00f5, B:30:0x00fd, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:40:0x0107, B:37:0x010a, B:44:0x007a, B:46:0x0096), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fd A[Catch: all -> 0x00f0, IOException -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:19:0x00bb, B:21:0x00c1, B:24:0x00ca, B:25:0x00ef, B:27:0x00f5, B:30:0x00fd, B:57:0x010c, B:59:0x0112, B:60:0x0115, B:40:0x0107, B:37:0x010a, B:44:0x007a, B:46:0x0096), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, kotlinx.coroutines.sync.Mutex] */
    @Override // androidx.datastore.core.StorageConnection
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeScope(@NotNull Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        FileStorageConnection$writeScope$1 fileStorageConnection$writeScope$1;
        Object coroutine_suspended;
        ?? r22;
        File file;
        FileStorageConnection<T> fileStorageConnection;
        Mutex mutex;
        FileWriteScope fileWriteScope;
        Throwable th;
        Closeable closeable;
        File file2;
        FileStorageConnection<T> fileStorageConnection2;
        try {
            try {
                try {
                    if (continuation instanceof FileStorageConnection$writeScope$1) {
                        fileStorageConnection$writeScope$1 = (FileStorageConnection$writeScope$1) continuation;
                        int i10 = fileStorageConnection$writeScope$1.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            fileStorageConnection$writeScope$1.label = i10 - Integer.MIN_VALUE;
                            Object obj = fileStorageConnection$writeScope$1.result;
                            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            r22 = fileStorageConnection$writeScope$1.label;
                            if (r22 == 0) {
                                if (r22 != 1) {
                                    if (r22 == 2) {
                                        closeable = (Closeable) fileStorageConnection$writeScope$1.L$3;
                                        file2 = (File) fileStorageConnection$writeScope$1.L$2;
                                        mutex = (Mutex) fileStorageConnection$writeScope$1.L$1;
                                        fileStorageConnection2 = (FileStorageConnection) fileStorageConnection$writeScope$1.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj);
                                            Unit unit = Unit.INSTANCE;
                                            try {
                                                closeable.close();
                                                th = null;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                            if (th != null) {
                                                if (file2.exists() && !FileMoves_androidKt.atomicMoveTo(file2, fileStorageConnection2.file)) {
                                                    throw new IOException("Unable to rename " + file2 + " to " + fileStorageConnection2.file + ". This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                                                }
                                                Unit unit2 = Unit.INSTANCE;
                                                mutex.unlock((Object) null);
                                                return Unit.INSTANCE;
                                            }
                                            throw th;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            try {
                                                closeable.close();
                                            } catch (Throwable th4) {
                                                ExceptionsKt.addSuppressed(th, th4);
                                            }
                                            throw th;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Mutex mutex2 = (Mutex) fileStorageConnection$writeScope$1.L$2;
                                Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function22 = (Function2) fileStorageConnection$writeScope$1.L$1;
                                fileStorageConnection = (FileStorageConnection) fileStorageConnection$writeScope$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                mutex = mutex2;
                                function2 = function22;
                            } else {
                                ResultKt.throwOnFailure(obj);
                                checkNotClosed();
                                createParentDirectories(this.file);
                                Mutex mutex3 = this.transactionMutex;
                                fileStorageConnection$writeScope$1.L$0 = this;
                                fileStorageConnection$writeScope$1.L$1 = function2;
                                fileStorageConnection$writeScope$1.L$2 = mutex3;
                                fileStorageConnection$writeScope$1.label = 1;
                                if (mutex3.lock((Object) null, fileStorageConnection$writeScope$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                fileStorageConnection = this;
                                mutex = mutex3;
                            }
                            file = new File(fileStorageConnection.file.getAbsolutePath() + ".tmp");
                            fileWriteScope = new FileWriteScope(file, fileStorageConnection.serializer);
                            fileStorageConnection$writeScope$1.L$0 = fileStorageConnection;
                            fileStorageConnection$writeScope$1.L$1 = mutex;
                            fileStorageConnection$writeScope$1.L$2 = file;
                            fileStorageConnection$writeScope$1.L$3 = fileWriteScope;
                            fileStorageConnection$writeScope$1.label = 2;
                            if (function2.invoke(fileWriteScope, fileStorageConnection$writeScope$1) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            file2 = file;
                            fileStorageConnection2 = fileStorageConnection;
                            closeable = fileWriteScope;
                            Unit unit3 = Unit.INSTANCE;
                            closeable.close();
                            th = null;
                            if (th != null) {
                            }
                        }
                    }
                    fileStorageConnection$writeScope$1.L$0 = fileStorageConnection;
                    fileStorageConnection$writeScope$1.L$1 = mutex;
                    fileStorageConnection$writeScope$1.L$2 = file;
                    fileStorageConnection$writeScope$1.L$3 = fileWriteScope;
                    fileStorageConnection$writeScope$1.label = 2;
                    if (function2.invoke(fileWriteScope, fileStorageConnection$writeScope$1) != coroutine_suspended) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    closeable = fileWriteScope;
                    closeable.close();
                    throw th;
                }
                fileWriteScope = new FileWriteScope(file, fileStorageConnection.serializer);
            } catch (IOException e10) {
                e = e10;
                if (file.exists()) {
                    file.delete();
                }
                throw e;
            }
            if (r22 == 0) {
            }
            file = new File(fileStorageConnection.file.getAbsolutePath() + ".tmp");
        } catch (Throwable th6) {
            r22.unlock((Object) null);
            throw th6;
        }
        fileStorageConnection$writeScope$1 = new FileStorageConnection$writeScope$1(this, continuation);
        Object obj2 = fileStorageConnection$writeScope$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r22 = fileStorageConnection$writeScope$1.label;
    }
}
