package androidx.datastore.core.okio;

import androidx.datastore.core.ReadScope;
import com.google.android.gms.appinvite.PreviewActivity;
import java.io.Closeable;
import java.io.FileNotFoundException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0004J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/okio/OkioReadScope;", "T", "Landroidx/datastore/core/ReadScope;", "fileSystem", "Lokio/FileSystem;", "path", "Lokio/Path;", "serializer", "Landroidx/datastore/core/okio/OkioSerializer;", "(Lokio/FileSystem;Lokio/Path;Landroidx/datastore/core/okio/OkioSerializer;)V", "closed", "Landroidx/datastore/core/okio/AtomicBoolean;", "getFileSystem", "()Lokio/FileSystem;", "getPath", "()Lokio/Path;", "getSerializer", "()Landroidx/datastore/core/okio/OkioSerializer;", "checkClose", "", PreviewActivity.ON_CLICK_LISTENER_CLOSE, "readData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core-okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOkioStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioReadScope\n+ 2 Okio.kt\nokio/Okio__OkioKt\n+ 3 FileSystem.kt\nokio/FileSystem\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,230:1\n66#2:231\n52#2,5:233\n60#2,10:239\n57#2,2:249\n71#2,2:251\n66#2:253\n52#2,5:255\n60#2,10:261\n57#2,2:271\n71#2,2:273\n67#3:232\n68#3:238\n67#3:254\n68#3:260\n1#4:275\n*S KotlinDebug\n*F\n+ 1 OkioStorage.kt\nandroidx/datastore/core/okio/OkioReadScope\n*L\n177#1:231\n177#1:233,5\n177#1:239,10\n177#1:249,2\n177#1:251,2\n187#1:253\n187#1:255,5\n187#1:261,10\n187#1:271,2\n187#1:273,2\n177#1:232\n177#1:238\n187#1:254\n187#1:260\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class OkioReadScope<T> implements ReadScope<T> {

    @NotNull
    private final AtomicBoolean closed;

    @NotNull
    private final FileSystem fileSystem;

    @NotNull
    private final Path path;

    @NotNull
    private final OkioSerializer<T> serializer;

    public OkioReadScope(@NotNull FileSystem fileSystem, @NotNull Path path, @NotNull OkioSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.fileSystem = fileSystem;
        this.path = path;
        this.serializer = serializer;
        this.closed = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0091 A[Catch: FileNotFoundException -> 0x008a, TryCatch #9 {FileNotFoundException -> 0x008a, blocks: (B:40:0x0091, B:42:0x0095, B:55:0x0086, B:52:0x0081), top: B:51:0x0081, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095 A[Catch: FileNotFoundException -> 0x008a, TRY_LEAVE, TryCatch #9 {FileNotFoundException -> 0x008a, blocks: (B:40:0x0091, B:42:0x0095, B:55:0x0086, B:52:0x0081), top: B:51:0x0081, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <T> Object readData$suspendImpl(OkioReadScope<T> okioReadScope, Continuation<? super T> continuation) {
        OkioReadScope$readData$1 okioReadScope$readData$1;
        int i10;
        OkioReadScope<T> okioReadScope2;
        Closeable closeable;
        Throwable th;
        Throwable th2;
        Closeable closeable2;
        Object readFrom;
        Throwable th3;
        if (continuation instanceof OkioReadScope$readData$1) {
            okioReadScope$readData$1 = (OkioReadScope$readData$1) continuation;
            int i11 = okioReadScope$readData$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                okioReadScope$readData$1.label = i11 - Integer.MIN_VALUE;
                Object obj = okioReadScope$readData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = okioReadScope$readData$1.label;
                Throwable th4 = null;
                if (i10 == 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            closeable2 = (Closeable) okioReadScope$readData$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (closeable2 != null) {
                                    try {
                                        closeable2.close();
                                    } catch (Throwable th5) {
                                        th4 = th5;
                                    }
                                }
                            } catch (Throwable th6) {
                                th2 = th6;
                                if (closeable2 != null) {
                                    try {
                                        closeable2.close();
                                    } catch (Throwable th7) {
                                        ExceptionsKt.addSuppressed(th2, th7);
                                    }
                                }
                                th4 = th2;
                                obj = null;
                                if (th4 != null) {
                                }
                            }
                            if (th4 != null) {
                                Intrinsics.checkNotNull(obj);
                                return obj;
                            }
                            throw th4;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable = (Closeable) okioReadScope$readData$1.L$1;
                    okioReadScope2 = (OkioReadScope) okioReadScope$readData$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th8) {
                        th = th8;
                        if (closeable != null) {
                            try {
                                try {
                                    closeable.close();
                                } catch (Throwable th9) {
                                    ExceptionsKt.addSuppressed(th, th9);
                                }
                            } catch (FileNotFoundException unused) {
                                okioReadScope = okioReadScope2;
                                if (!((OkioReadScope) okioReadScope).fileSystem.exists(((OkioReadScope) okioReadScope).path)) {
                                }
                            }
                        }
                        th3 = th;
                        obj = null;
                        if (th3 != null) {
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    okioReadScope.checkClose();
                    try {
                        BufferedSource buffer = Okio.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                        try {
                            OkioSerializer<T> okioSerializer = ((OkioReadScope) okioReadScope).serializer;
                            okioReadScope$readData$1.L$0 = okioReadScope;
                            okioReadScope$readData$1.L$1 = buffer;
                            okioReadScope$readData$1.label = 1;
                            Object readFrom2 = okioSerializer.readFrom(buffer, okioReadScope$readData$1);
                            if (readFrom2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            closeable = buffer;
                            obj = readFrom2;
                        } catch (Throwable th10) {
                            okioReadScope2 = okioReadScope;
                            closeable = buffer;
                            th = th10;
                            if (closeable != null) {
                            }
                            th3 = th;
                            obj = null;
                            if (th3 != null) {
                            }
                        }
                    } catch (FileNotFoundException unused2) {
                        if (!((OkioReadScope) okioReadScope).fileSystem.exists(((OkioReadScope) okioReadScope).path)) {
                            BufferedSource buffer2 = Okio.buffer(((OkioReadScope) okioReadScope).fileSystem.source(((OkioReadScope) okioReadScope).path));
                            try {
                                OkioSerializer<T> okioSerializer2 = ((OkioReadScope) okioReadScope).serializer;
                                okioReadScope$readData$1.L$0 = buffer2;
                                okioReadScope$readData$1.L$1 = null;
                                okioReadScope$readData$1.label = 2;
                                readFrom = okioSerializer2.readFrom(buffer2, okioReadScope$readData$1);
                            } catch (Throwable th11) {
                                th2 = th11;
                                closeable2 = buffer2;
                                if (closeable2 != null) {
                                }
                                th4 = th2;
                                obj = null;
                                if (th4 != null) {
                                }
                            }
                            if (readFrom == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = readFrom;
                            closeable2 = buffer2;
                            if (closeable2 != null) {
                            }
                            if (th4 != null) {
                            }
                        } else {
                            return ((OkioReadScope) okioReadScope).serializer.getDefaultValue();
                        }
                    }
                }
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Throwable th12) {
                        th3 = th12;
                    }
                }
                th3 = null;
                if (th3 != null) {
                    Intrinsics.checkNotNull(obj);
                    return obj;
                }
                throw th3;
            }
        }
        okioReadScope$readData$1 = new OkioReadScope$readData$1(okioReadScope, continuation);
        Object obj2 = okioReadScope$readData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = okioReadScope$readData$1.label;
        Throwable th42 = null;
        if (i10 == 0) {
        }
        if (closeable != null) {
        }
        th3 = null;
        if (th3 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkClose() {
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
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Path getPath() {
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final OkioSerializer<T> getSerializer() {
        return this.serializer;
    }

    @Override // androidx.datastore.core.ReadScope
    @Nullable
    public Object readData(@NotNull Continuation<? super T> continuation) {
        return readData$suspendImpl(this, continuation);
    }
}
