package androidx.datastore.core.okio;

import androidx.datastore.core.Closeable;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.ReadScope;
import androidx.datastore.core.StorageConnection;
import androidx.datastore.core.WriteScope;
import com.google.android.gms.appinvite.PreviewActivity;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
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
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016JX\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0001\u0010\u00182B\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001a¢\u0006\u0002\b\"H\u0096@¢\u0006\u0002\u0010#J=\u0010$\u001a\u00020\r2-\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0 \u0012\u0006\u0012\u0004\u0018\u00010!0%¢\u0006\u0002\b\"H\u0096@¢\u0006\u0002\u0010'R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/datastore/core/okio/OkioStorageConnection;", "T", "Landroidx/datastore/core/StorageConnection;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "coordinator", "Landroidx/datastore/core/InterProcessCoordinator;", "onClose", "Lkotlin/Function0;", "", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;Landroidx/datastore/core/InterProcessCoordinator;Lkotlin/jvm/functions/Function0;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getCoordinator", "()Landroidx/datastore/core/InterProcessCoordinator;", "transactionMutex", "Lkotlinx/coroutines/sync/Mutex;", "checkNotClosed", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "readScope", "R", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function3;", "Landroidx/datastore/core/ReadScope;", "", "Lkotlin/ParameterName;", "name", "locked", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeScope", "Lkotlin/Function2;", "Landroidx/datastore/core/WriteScope;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOkioStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioStorageConnection\n+ 2 Closeable.kt\nandroidx/datastore/core/CloseableKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,230:1\n38#2,23:231\n38#2,23:262\n120#3,8:254\n129#3:285\n1#4:286\n*S KotlinDebug\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioStorageConnection\n*L\n112#1:231,23\n136#1:262,23\n129#1:254,8\n129#1:285\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class OkioStorageConnection<T> implements StorageConnection<T> {

    @NotNull
    private final AtomicBoolean closed;

    @NotNull
    private final InterProcessCoordinator coordinator;

    @NotNull
    private final FileSystem fileSystem;

    @NotNull
    private final Function0<Unit> onClose;

    @NotNull
    private final Path path;

    @NotNull
    private final OkioSerializer<T> serializer;

    @NotNull
    private final Mutex transactionMutex;

    public OkioStorageConnection(@NotNull FileSystem fileSystem, @NotNull Path path, @NotNull OkioSerializer<T> serializer, @NotNull InterProcessCoordinator coordinator, @NotNull Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.coordinator = coordinator;
        this.onClose = onClose;
        this.closed = new AtomicBoolean(false);
        this.transactionMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    private final void checkNotClosed() {
        if (!this.closed.get()) {
        } else {
            throw new IllegalStateException("StorageConnection has already been disposed.");
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

    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:3|(8:5|6|7|(1:(3:10|11|12)(2:32|33))(6:34|35|36|37|38|(1:40)(1:41))|13|14|15|(2:(1:18)|19)(1:21)))|7|(0)(0)|13|14|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[Catch: all -> 0x007e, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x007e, blocks: (B:21:0x007d, B:31:0x008b, B:28:0x008e, B:27:0x0086), top: B:7:0x0022, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.okio.OkioStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.okio.OkioStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r10v15, types: [boolean] */
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
        OkioStorageConnection<T> okioStorageConnection;
        try {
            if (continuation instanceof OkioStorageConnection$readScope$1) {
                OkioStorageConnection$readScope$1 okioStorageConnection$readScope$1 = (OkioStorageConnection$readScope$1) continuation;
                int i11 = okioStorageConnection$readScope$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    okioStorageConnection$readScope$1.label = i11 - Integer.MIN_VALUE;
                    r02 = okioStorageConnection$readScope$1;
                    Object obj = r02.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = r02.label;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            function3 = (Function3<? super ReadScope<T>, ? super Boolean, ? super Continuation<? super R>, ? extends Object>) r02.Z$0;
                            closeable = (Closeable) r02.L$1;
                            r02 = (OkioStorageConnection) r02.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                okioStorageConnection = r02;
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
                            OkioReadScope okioReadScope = new OkioReadScope(this.fileSystem, this.path, this.serializer);
                            try {
                                Boolean boxBoolean = Boxing.boxBoolean(tryLock$default);
                                r02.L$0 = this;
                                r02.L$1 = okioReadScope;
                                r02.Z$0 = tryLock$default;
                                r02.label = 1;
                                Object invoke = function3.invoke(okioReadScope, boxBoolean, r02);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                okioStorageConnection = this;
                                closeable = okioReadScope;
                                obj = invoke;
                                function3 = tryLock$default ? 1 : 0;
                            } catch (Throwable th4) {
                                r02 = this;
                                closeable = okioReadScope;
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
                            Mutex.DefaultImpls.unlock$default(okioStorageConnection.transactionMutex, (Object) null, 1, (Object) null);
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
        r02 = new OkioStorageConnection$readScope$1(this, continuation);
        Object obj2 = r02.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = r02.label;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf A[Catch: all -> 0x00df, IOException -> 0x00e2, TRY_ENTER, TryCatch #2 {IOException -> 0x00e2, blocks: (B:19:0x00cf, B:21:0x00d7, B:26:0x00ef, B:36:0x00fb, B:33:0x00fe), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ef A[Catch: all -> 0x00df, IOException -> 0x00e2, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x00e2, blocks: (B:19:0x00cf, B:21:0x00d7, B:26:0x00ef, B:36:0x00fb, B:33:0x00fe), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    @Override // androidx.datastore.core.StorageConnection
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeScope(@NotNull Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        OkioStorageConnection$writeScope$1 okioStorageConnection$writeScope$1;
        Object coroutine_suspended;
        ?? r22;
        Mutex mutex;
        OkioStorageConnection<T> okioStorageConnection;
        Path path;
        Path parent;
        OkioWriteScope okioWriteScope;
        Throwable th;
        Closeable closeable;
        Path path2;
        OkioStorageConnection<T> okioStorageConnection2;
        Mutex mutex2;
        try {
            try {
                try {
                    try {
                        try {
                            if (continuation instanceof OkioStorageConnection$writeScope$1) {
                                OkioStorageConnection$writeScope$1 okioStorageConnection$writeScope$12 = (OkioStorageConnection$writeScope$1) continuation;
                                int i10 = okioStorageConnection$writeScope$12.label;
                                if ((i10 & Integer.MIN_VALUE) != 0) {
                                    okioStorageConnection$writeScope$12.label = i10 - Integer.MIN_VALUE;
                                    okioStorageConnection$writeScope$1 = okioStorageConnection$writeScope$12;
                                    Object obj = okioStorageConnection$writeScope$1.result;
                                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    r22 = okioStorageConnection$writeScope$1.label;
                                    if (r22 == 0) {
                                        if (r22 != 1) {
                                            if (r22 == 2) {
                                                closeable = (Closeable) okioStorageConnection$writeScope$1.L$3;
                                                path2 = (Path) okioStorageConnection$writeScope$1.L$2;
                                                mutex2 = (Mutex) okioStorageConnection$writeScope$1.L$1;
                                                okioStorageConnection2 = (OkioStorageConnection) okioStorageConnection$writeScope$1.L$0;
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
                                                        if (okioStorageConnection2.fileSystem.exists(path2)) {
                                                            okioStorageConnection2.fileSystem.atomicMove(path2, okioStorageConnection2.path);
                                                        }
                                                        Unit unit2 = Unit.INSTANCE;
                                                        mutex2.unlock((Object) null);
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
                                        Mutex mutex3 = (Mutex) okioStorageConnection$writeScope$1.L$3;
                                        parent = (Path) okioStorageConnection$writeScope$1.L$2;
                                        Function2<? super WriteScope<T>, ? super Continuation<? super Unit>, ? extends Object> function22 = (Function2) okioStorageConnection$writeScope$1.L$1;
                                        okioStorageConnection = (OkioStorageConnection) okioStorageConnection$writeScope$1.L$0;
                                        ResultKt.throwOnFailure(obj);
                                        mutex = mutex3;
                                        function2 = function22;
                                    } else {
                                        ResultKt.throwOnFailure(obj);
                                        checkNotClosed();
                                        parent = this.path.parent();
                                        if (parent != null) {
                                            this.fileSystem.createDirectories(parent, false);
                                            mutex = this.transactionMutex;
                                            okioStorageConnection$writeScope$1.L$0 = this;
                                            okioStorageConnection$writeScope$1.L$1 = function2;
                                            okioStorageConnection$writeScope$1.L$2 = parent;
                                            okioStorageConnection$writeScope$1.L$3 = mutex;
                                            okioStorageConnection$writeScope$1.label = 1;
                                            if (mutex.lock((Object) null, okioStorageConnection$writeScope$1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            okioStorageConnection = this;
                                        } else {
                                            throw new IllegalStateException("must have a parent path");
                                        }
                                    }
                                    path = parent.resolve(okioStorageConnection.path.name() + ".tmp");
                                    okioStorageConnection.fileSystem.delete(path, false);
                                    okioWriteScope = new OkioWriteScope(okioStorageConnection.fileSystem, path, okioStorageConnection.serializer);
                                    okioStorageConnection$writeScope$1.L$0 = okioStorageConnection;
                                    okioStorageConnection$writeScope$1.L$1 = mutex;
                                    okioStorageConnection$writeScope$1.L$2 = path;
                                    okioStorageConnection$writeScope$1.L$3 = okioWriteScope;
                                    okioStorageConnection$writeScope$1.label = 2;
                                    if (function2.invoke(okioWriteScope, okioStorageConnection$writeScope$1) != coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    path2 = path;
                                    closeable = okioWriteScope;
                                    okioStorageConnection2 = okioStorageConnection;
                                    mutex2 = mutex;
                                    Unit unit3 = Unit.INSTANCE;
                                    closeable.close();
                                    th = null;
                                    if (th != null) {
                                    }
                                }
                            }
                            okioStorageConnection$writeScope$1.L$0 = okioStorageConnection;
                            okioStorageConnection$writeScope$1.L$1 = mutex;
                            okioStorageConnection$writeScope$1.L$2 = path;
                            okioStorageConnection$writeScope$1.L$3 = okioWriteScope;
                            okioStorageConnection$writeScope$1.label = 2;
                            if (function2.invoke(okioWriteScope, okioStorageConnection$writeScope$1) != coroutine_suspended) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = okioWriteScope;
                            closeable.close();
                            throw th;
                        }
                        okioStorageConnection.fileSystem.delete(path, false);
                        okioWriteScope = new OkioWriteScope(okioStorageConnection.fileSystem, path, okioStorageConnection.serializer);
                    } catch (IOException e10) {
                        e = e10;
                        if (okioStorageConnection.fileSystem.exists(path)) {
                            try {
                                okioStorageConnection.fileSystem.delete(path);
                            } catch (IOException unused) {
                            }
                        }
                        throw e;
                    }
                    path = parent.resolve(okioStorageConnection.path.name() + ".tmp");
                } catch (Throwable th6) {
                    th = th6;
                    mutex.unlock((Object) null);
                    throw th;
                }
                if (r22 == 0) {
                }
            } catch (IOException e11) {
                e = e11;
                okioStorageConnection = okioStorageConnection$writeScope$1;
                mutex = r22;
                path = coroutine_suspended;
            }
        } catch (Throwable th7) {
            th = th7;
            mutex = r22;
            mutex.unlock((Object) null);
            throw th;
        }
        okioStorageConnection$writeScope$1 = new OkioStorageConnection$writeScope$1(this, continuation);
        Object obj2 = okioStorageConnection$writeScope$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r22 = okioStorageConnection$writeScope$1.label;
    }
}
