package androidx.datastore.core;

import androidx.datastore.core.SharedCounter;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0002J\u000e\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J2\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u001c\u0010(\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0)H\u0096@¢\u0006\u0002\u0010,J8\u0010-\u001a\u0002H'\"\u0004\b\u0000\u0010'2\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.H\u0096@¢\u0006\u0002\u00100J:\u00101\u001a\u0002H'\"\u0004\b\u0000\u0010'2$\b\u0004\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0*\u0012\u0006\u0012\u0004\u0018\u00010+0.H\u0082H¢\u0006\u0002\u00100J\f\u00102\u001a\u00020\u001d*\u00020\u0005H\u0002J\f\u00103\u001a\u00020\u001d*\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a*\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator;", "Landroidx/datastore/core/InterProcessCoordinator;", "context", "Lkotlin/coroutines/CoroutineContext;", "file", "Ljava/io/File;", "(Lkotlin/coroutines/CoroutineContext;Ljava/io/File;)V", "LOCK_ERROR_MESSAGE", "", "LOCK_SUFFIX", "VERSION_SUFFIX", "getFile", "()Ljava/io/File;", "inMemoryMutex", "Lkotlinx/coroutines/sync/Mutex;", "lazySharedCounter", "Lkotlin/Lazy;", "Landroidx/datastore/core/SharedCounter;", "lockFile", "getLockFile", "lockFile$delegate", "Lkotlin/Lazy;", "sharedCounter", "getSharedCounter$delegate", "(Landroidx/datastore/core/MultiProcessCoordinator;)Ljava/lang/Object;", "getSharedCounter", "()Landroidx/datastore/core/SharedCounter;", "updateNotifications", "Lkotlinx/coroutines/flow/Flow;", "", "getUpdateNotifications", "()Lkotlinx/coroutines/flow/Flow;", "fileWithSuffix", DynamicLink.Builder.KEY_SUFFIX, "getVersion", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementAndGetVersion", "lock", "T", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withLazyCounter", "createIfNotExists", "createParentDirectories", "Companion", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMultiProcessCoordinator.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiProcessCoordinator.android.kt\nandroidx/datastore/core/MultiProcessCoordinator\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 MutexUtils.kt\nandroidx/datastore/core/MutexUtilsKt\n*L\n1#1,205:1\n159#1,8:226\n159#1,8:234\n120#2,10:206\n32#3,10:216\n*S KotlinDebug\n*F\n+ 1 MultiProcessCoordinator.android.kt\nandroidx/datastore/core/MultiProcessCoordinator\n*L\n99#1:226,8\n106#1:234,8\n43#1:206,10\n60#1:216,10\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class MultiProcessCoordinator implements InterProcessCoordinator {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    private static final long INITIAL_WAIT_MILLIS = 10;
    private static final long MAX_WAIT_MILLIS = 60000;

    @NotNull
    private final String LOCK_ERROR_MESSAGE;

    @NotNull
    private final String LOCK_SUFFIX;

    @NotNull
    private final String VERSION_SUFFIX;

    @NotNull
    private final CoroutineContext context;

    @NotNull
    private final File file;

    @NotNull
    private final Mutex inMemoryMutex;

    @NotNull
    private final Lazy<SharedCounter> lazySharedCounter;

    /* renamed from: lockFile$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy lockFile;

    @NotNull
    private final Flow<Unit> updateNotifications;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/datastore/core/MultiProcessCoordinator$Companion;", "", "()V", "DEADLOCK_ERROR_MESSAGE", "", "INITIAL_WAIT_MILLIS", "", "MAX_WAIT_MILLIS", "getExclusiveFileLockWithRetryIfDeadlock", "Ljava/nio/channels/FileLock;", "lockFileStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007a -> B:10:0x007d). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object getExclusiveFileLockWithRetryIfDeadlock(FileOutputStream fileOutputStream, Continuation<? super FileLock> continuation) {
            MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1;
            int i10;
            long j10;
            if (continuation instanceof MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) {
                multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 = (MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) continuation;
                int i11 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            j10 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.J$0;
                            fileOutputStream = (FileOutputStream) multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            j10 *= 2;
                            if (j10 > MultiProcessCoordinator.MAX_WAIT_MILLIS) {
                                try {
                                } catch (IOException e10) {
                                    String message = e10.getMessage();
                                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) MultiProcessCoordinator.DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null)) {
                                        multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.L$0 = fileOutputStream;
                                        multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.J$0 = j10;
                                        multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label = 1;
                                        if (DelayKt.delay(j10, multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        throw e10;
                                    }
                                }
                                FileLock lock = fileOutputStream.getChannel().lock(0L, LongCompanionObject.MAX_VALUE, false);
                                Intrinsics.checkNotNullExpressionValue(lock, "lockFileStream.getChanne…LUE, /* shared= */ false)");
                                return lock;
                            }
                            FileLock lock2 = fileOutputStream.getChannel().lock(0L, LongCompanionObject.MAX_VALUE, false);
                            Intrinsics.checkNotNullExpressionValue(lock2, "lockFileStream.getChanne…LUE, /* shared= */ false)");
                            return lock2;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    j10 = MultiProcessCoordinator.INITIAL_WAIT_MILLIS;
                    if (j10 > MultiProcessCoordinator.MAX_WAIT_MILLIS) {
                    }
                }
            }
            multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 = new MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1(this, continuation);
            Object obj2 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i10 = multiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1.label;
            if (i10 == 0) {
            }
        }

        private Companion() {
        }
    }

    public MultiProcessCoordinator(@NotNull CoroutineContext context, @NotNull File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        this.context = context;
        this.file = file;
        this.updateNotifications = MulticastFileObserver.INSTANCE.observe(file);
        this.LOCK_SUFFIX = ".lock";
        this.VERSION_SUFFIX = ".version";
        this.LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
        this.inMemoryMutex = MutexKt.Mutex$default(false, 1, (Object) null);
        this.lockFile = LazyKt.lazy(new Function0<File>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lockFile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final File invoke() {
                String str;
                File fileWithSuffix;
                MultiProcessCoordinator multiProcessCoordinator = MultiProcessCoordinator.this;
                str = multiProcessCoordinator.LOCK_SUFFIX;
                fileWithSuffix = multiProcessCoordinator.fileWithSuffix(str);
                MultiProcessCoordinator.this.createIfNotExists(fileWithSuffix);
                return fileWithSuffix;
            }
        });
        this.lazySharedCounter = LazyKt.lazy(new Function0<SharedCounter>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lazySharedCounter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SharedCounter invoke() {
                SharedCounter.Companion companion = SharedCounter.INSTANCE;
                companion.loadLib();
                final MultiProcessCoordinator multiProcessCoordinator = MultiProcessCoordinator.this;
                return companion.create$datastore_core_release(new Function0<File>() { // from class: androidx.datastore.core.MultiProcessCoordinator$lazySharedCounter$1.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final File invoke() {
                        String str;
                        File fileWithSuffix;
                        MultiProcessCoordinator multiProcessCoordinator2 = MultiProcessCoordinator.this;
                        str = multiProcessCoordinator2.VERSION_SUFFIX;
                        fileWithSuffix = multiProcessCoordinator2.fileWithSuffix(str);
                        MultiProcessCoordinator.this.createIfNotExists(fileWithSuffix);
                        return fileWithSuffix;
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createIfNotExists(File file) {
        createParentDirectories(file);
        if (!file.exists()) {
            file.createNewFile();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final File fileWithSuffix(String suffix) {
        return new File(this.file.getAbsolutePath() + suffix);
    }

    private final File getLockFile() {
        return (File) this.lockFile.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return this.lazySharedCounter.getValue();
    }

    private final <T> Object withLazyCounter(Function2<? super SharedCounter, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return function2.invoke(getSharedCounter(), continuation);
        }
        CoroutineContext coroutineContext = this.context;
        MultiProcessCoordinator$withLazyCounter$2 multiProcessCoordinator$withLazyCounter$2 = new MultiProcessCoordinator$withLazyCounter$2(function2, this, null);
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(coroutineContext, multiProcessCoordinator$withLazyCounter$2, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    @NotNull
    protected final File getFile() {
        return this.file;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    @NotNull
    public Flow<Unit> getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    @Nullable
    public Object getVersion(@NotNull Continuation<? super Integer> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return Boxing.boxInt(getSharedCounter().getValue());
        }
        return BuildersKt.withContext(this.context, new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, null), continuation);
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    @Nullable
    public Object incrementAndGetVersion(@NotNull Continuation<? super Integer> continuation) {
        if (this.lazySharedCounter.isInitialized()) {
            return Boxing.boxInt(getSharedCounter().incrementAndGetValue());
        }
        return BuildersKt.withContext(this.context, new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, null), continuation);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bb A[Catch: all -> 0x00bf, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00bf, blocks: (B:16:0x00bb, B:30:0x00d9, B:31:0x00dc), top: B:7:0x0024, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d9 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #7 {all -> 0x00bf, blocks: (B:16:0x00bb, B:30:0x00d9, B:31:0x00dc), top: B:7:0x0024, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.Closeable, java.lang.Object] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object lock(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        MultiProcessCoordinator$lock$1 multiProcessCoordinator$lock$1;
        ?? r10;
        ?? coroutine_suspended;
        int i10;
        MultiProcessCoordinator multiProcessCoordinator;
        Throwable th;
        Object exclusiveFileLockWithRetryIfDeadlock;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        java.io.Closeable closeable;
        Mutex mutex;
        Object obj;
        FileLock fileLock;
        FileLock fileLock2;
        Object invoke;
        java.io.Closeable closeable2;
        Object obj2;
        Mutex mutex2;
        try {
            try {
                try {
                    if (continuation instanceof MultiProcessCoordinator$lock$1) {
                        multiProcessCoordinator$lock$1 = (MultiProcessCoordinator$lock$1) continuation;
                        int i11 = multiProcessCoordinator$lock$1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            multiProcessCoordinator$lock$1.label = i11 - Integer.MIN_VALUE;
                            r10 = multiProcessCoordinator$lock$1.result;
                            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i10 = multiProcessCoordinator$lock$1.label;
                            if (i10 == 0) {
                                if (i10 != 1) {
                                    if (i10 != 2) {
                                        if (i10 == 3) {
                                            fileLock = (FileLock) multiProcessCoordinator$lock$1.L$2;
                                            closeable2 = (java.io.Closeable) multiProcessCoordinator$lock$1.L$1;
                                            mutex2 = (Mutex) multiProcessCoordinator$lock$1.L$0;
                                            try {
                                                ResultKt.throwOnFailure(r10);
                                                obj2 = r10;
                                                if (fileLock != null) {
                                                    fileLock.release();
                                                }
                                                try {
                                                    kotlin.io.CloseableKt.closeFinally(closeable2, null);
                                                    mutex2.unlock((Object) null);
                                                    return obj2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    r10 = mutex2;
                                                    r10.unlock((Object) null);
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (fileLock != null) {
                                                }
                                                throw th;
                                            }
                                        }
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    closeable = (java.io.Closeable) multiProcessCoordinator$lock$1.L$2;
                                    mutex = (Mutex) multiProcessCoordinator$lock$1.L$1;
                                    function12 = (Function1) multiProcessCoordinator$lock$1.L$0;
                                    try {
                                        ResultKt.throwOnFailure(r10);
                                        obj = r10;
                                        fileLock2 = (FileLock) obj;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        fileLock = null;
                                        if (fileLock != null) {
                                        }
                                        throw th;
                                    }
                                    try {
                                        multiProcessCoordinator$lock$1.L$0 = mutex;
                                        multiProcessCoordinator$lock$1.L$1 = closeable;
                                        multiProcessCoordinator$lock$1.L$2 = fileLock2;
                                        multiProcessCoordinator$lock$1.label = 3;
                                        invoke = function12.invoke(multiProcessCoordinator$lock$1);
                                        if (invoke != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        closeable2 = closeable;
                                        fileLock = fileLock2;
                                        obj2 = invoke;
                                        mutex2 = mutex;
                                        if (fileLock != null) {
                                        }
                                        kotlin.io.CloseableKt.closeFinally(closeable2, null);
                                        mutex2.unlock((Object) null);
                                        return obj2;
                                    } catch (Throwable th5) {
                                        fileLock = fileLock2;
                                        th = th5;
                                        if (fileLock != null) {
                                        }
                                        throw th;
                                    }
                                }
                                Mutex mutex3 = (Mutex) multiProcessCoordinator$lock$1.L$2;
                                Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) multiProcessCoordinator$lock$1.L$1;
                                multiProcessCoordinator = (MultiProcessCoordinator) multiProcessCoordinator$lock$1.L$0;
                                ResultKt.throwOnFailure(r10);
                                r10 = mutex3;
                                function1 = function13;
                            } else {
                                ResultKt.throwOnFailure(r10);
                                Mutex mutex4 = this.inMemoryMutex;
                                multiProcessCoordinator$lock$1.L$0 = this;
                                multiProcessCoordinator$lock$1.L$1 = function1;
                                multiProcessCoordinator$lock$1.L$2 = mutex4;
                                multiProcessCoordinator$lock$1.label = 1;
                                if (mutex4.lock((Object) null, multiProcessCoordinator$lock$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                multiProcessCoordinator = this;
                                r10 = mutex4;
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(multiProcessCoordinator.getLockFile());
                            Companion companion = INSTANCE;
                            multiProcessCoordinator$lock$1.L$0 = function1;
                            multiProcessCoordinator$lock$1.L$1 = r10;
                            multiProcessCoordinator$lock$1.L$2 = fileOutputStream;
                            multiProcessCoordinator$lock$1.label = 2;
                            exclusiveFileLockWithRetryIfDeadlock = companion.getExclusiveFileLockWithRetryIfDeadlock(fileOutputStream, multiProcessCoordinator$lock$1);
                            if (exclusiveFileLockWithRetryIfDeadlock != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function12 = function1;
                            closeable = fileOutputStream;
                            mutex = r10;
                            obj = exclusiveFileLockWithRetryIfDeadlock;
                            fileLock2 = (FileLock) obj;
                            multiProcessCoordinator$lock$1.L$0 = mutex;
                            multiProcessCoordinator$lock$1.L$1 = closeable;
                            multiProcessCoordinator$lock$1.L$2 = fileLock2;
                            multiProcessCoordinator$lock$1.label = 3;
                            invoke = function12.invoke(multiProcessCoordinator$lock$1);
                            if (invoke != coroutine_suspended) {
                            }
                        }
                    }
                    Companion companion2 = INSTANCE;
                    multiProcessCoordinator$lock$1.L$0 = function1;
                    multiProcessCoordinator$lock$1.L$1 = r10;
                    multiProcessCoordinator$lock$1.L$2 = fileOutputStream;
                    multiProcessCoordinator$lock$1.label = 2;
                    exclusiveFileLockWithRetryIfDeadlock = companion2.getExclusiveFileLockWithRetryIfDeadlock(fileOutputStream, multiProcessCoordinator$lock$1);
                    if (exclusiveFileLockWithRetryIfDeadlock != coroutine_suspended) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileLock = null;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    throw th;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(multiProcessCoordinator.getLockFile());
            } catch (Throwable th7) {
                th = th7;
                r10.unlock((Object) null);
                throw th;
            }
            if (i10 == 0) {
            }
        } catch (Throwable th8) {
            r10 = multiProcessCoordinator$lock$1;
            try {
                throw th8;
            } catch (Throwable th9) {
                kotlin.io.CloseableKt.closeFinally(coroutine_suspended, th8);
                throw th9;
            }
        }
        multiProcessCoordinator$lock$1 = new MultiProcessCoordinator$lock$1(this, continuation);
        r10 = multiProcessCoordinator$lock$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = multiProcessCoordinator$lock$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00e4 A[Catch: all -> 0x00e8, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x00e8, blocks: (B:15:0x00e4, B:24:0x00fd, B:25:0x0100), top: B:7:0x0029, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fd A[Catch: all -> 0x00e8, TRY_ENTER, TryCatch #6 {all -> 0x00e8, blocks: (B:15:0x00e4, B:24:0x00fd, B:25:0x0100), top: B:7:0x0029, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int, java.io.Closeable] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object tryLock(@NotNull Function2<? super Boolean, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        MultiProcessCoordinator$tryLock$1 multiProcessCoordinator$tryLock$1;
        ?? r52;
        String message;
        FileLock fileLock;
        FileLock fileLock2;
        MultiProcessCoordinator$tryLock$1 multiProcessCoordinator$tryLock$12;
        boolean z10;
        java.io.Closeable closeable;
        MultiProcessCoordinator$tryLock$1 multiProcessCoordinator$tryLock$13;
        boolean z11;
        Function2<? super Boolean, ? super Continuation<? super T>, ? extends Object> function22 = function2;
        try {
            try {
                if (continuation instanceof MultiProcessCoordinator$tryLock$1) {
                    multiProcessCoordinator$tryLock$1 = (MultiProcessCoordinator$tryLock$1) continuation;
                    int i10 = multiProcessCoordinator$tryLock$1.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        multiProcessCoordinator$tryLock$1.label = i10 - Integer.MIN_VALUE;
                        Object obj = multiProcessCoordinator$tryLock$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        r52 = multiProcessCoordinator$tryLock$1.label;
                        boolean z12 = true;
                        if (r52 == 0) {
                            if (r52 != 1) {
                                if (r52 == 2) {
                                    z10 = multiProcessCoordinator$tryLock$1.Z$0;
                                    fileLock2 = (FileLock) multiProcessCoordinator$tryLock$1.L$2;
                                    closeable = (java.io.Closeable) multiProcessCoordinator$tryLock$1.L$1;
                                    multiProcessCoordinator$tryLock$12 = (Mutex) multiProcessCoordinator$tryLock$1.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        if (fileLock2 != null) {
                                            fileLock2.release();
                                        }
                                        kotlin.io.CloseableKt.closeFinally(closeable, null);
                                        if (z10) {
                                            multiProcessCoordinator$tryLock$12.unlock((Object) null);
                                        }
                                        return obj;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileLock2 != null) {
                                        }
                                        throw th;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            z11 = multiProcessCoordinator$tryLock$1.Z$0;
                            multiProcessCoordinator$tryLock$13 = (Mutex) multiProcessCoordinator$tryLock$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (z11) {
                                multiProcessCoordinator$tryLock$13.unlock((Object) null);
                            }
                            return obj;
                        }
                        ResultKt.throwOnFailure(obj);
                        MultiProcessCoordinator$tryLock$1 multiProcessCoordinator$tryLock$14 = this.inMemoryMutex;
                        boolean tryLock = multiProcessCoordinator$tryLock$14.tryLock((Object) null);
                        try {
                            if (!tryLock) {
                                Boolean boxBoolean = Boxing.boxBoolean(false);
                                multiProcessCoordinator$tryLock$1.L$0 = multiProcessCoordinator$tryLock$14;
                                multiProcessCoordinator$tryLock$1.Z$0 = tryLock;
                                multiProcessCoordinator$tryLock$1.label = 1;
                                obj = function22.invoke(boxBoolean, multiProcessCoordinator$tryLock$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                multiProcessCoordinator$tryLock$13 = multiProcessCoordinator$tryLock$14;
                                z11 = tryLock ? 1 : 0;
                                if (z11) {
                                }
                                return obj;
                            }
                            FileInputStream fileInputStream = new FileInputStream(getLockFile());
                            try {
                                try {
                                    fileLock = fileInputStream.getChannel().tryLock(0L, LongCompanionObject.MAX_VALUE, true);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileLock2 = null;
                                    if (fileLock2 != null) {
                                        fileLock2.release();
                                    }
                                    throw th;
                                }
                            } catch (IOException e10) {
                                String message2 = e10.getMessage();
                                if ((message2 == null || !StringsKt.startsWith$default(message2, this.LOCK_ERROR_MESSAGE, false, 2, (Object) null)) && ((message = e10.getMessage()) == null || !StringsKt.startsWith$default(message, DEADLOCK_ERROR_MESSAGE, false, 2, (Object) null))) {
                                    throw e10;
                                }
                                fileLock = null;
                            }
                            if (fileLock == null) {
                                z12 = false;
                            }
                            try {
                                Boolean boxBoolean2 = Boxing.boxBoolean(z12);
                                multiProcessCoordinator$tryLock$1.L$0 = multiProcessCoordinator$tryLock$14;
                                multiProcessCoordinator$tryLock$1.L$1 = fileInputStream;
                                multiProcessCoordinator$tryLock$1.L$2 = fileLock;
                                multiProcessCoordinator$tryLock$1.Z$0 = tryLock;
                                multiProcessCoordinator$tryLock$1.label = 2;
                                obj = function22.invoke(boxBoolean2, multiProcessCoordinator$tryLock$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                multiProcessCoordinator$tryLock$12 = multiProcessCoordinator$tryLock$14;
                                z10 = tryLock ? 1 : 0;
                                closeable = fileInputStream;
                                fileLock2 = fileLock;
                                if (fileLock2 != null) {
                                }
                                kotlin.io.CloseableKt.closeFinally(closeable, null);
                                if (z10) {
                                }
                                return obj;
                            } catch (Throwable th3) {
                                th = th3;
                                fileLock2 = fileLock;
                                if (fileLock2 != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            multiProcessCoordinator$tryLock$1 = multiProcessCoordinator$tryLock$14;
                            function22 = tryLock ? 1 : 0;
                            if (function22 != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (r52 == 0) {
                }
            } finally {
            }
        } catch (Throwable th5) {
            th = th5;
            if (function22 != null) {
                multiProcessCoordinator$tryLock$1.unlock((Object) null);
            }
            throw th;
        }
        multiProcessCoordinator$tryLock$1 = new MultiProcessCoordinator$tryLock$1(this, continuation);
        Object obj2 = multiProcessCoordinator$tryLock$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r52 = multiProcessCoordinator$tryLock$1.label;
        boolean z122 = true;
    }
}
