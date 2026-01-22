package kotlin.io.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {191, 197, 210, 216}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"})
@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,180:1\n44#2,19:181\n44#2,19:200\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n70#1:181,19\n81#1:200,19\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ PathTreeWalk this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$dfsIterator$1> continuation) {
        super(2, continuation);
        this.this$0 = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.this$0, continuation);
        pathTreeWalk$dfsIterator$1.L$0 = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0146  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0259 -> B:9:0x01a0). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ArrayDeque arrayDeque;
        DirectoryEntriesReader directoryEntriesReader;
        boolean followLinks;
        PathNode pathNode;
        Path path;
        Path path2;
        Object keyOf;
        PathTreeWalk pathTreeWalk;
        Path path3;
        boolean isDirectory;
        LinkOption linkOption;
        boolean exists;
        boolean createsCycle;
        PathTreeWalk pathTreeWalk2;
        ArrayDeque arrayDeque2;
        PathNode pathNode2;
        DirectoryEntriesReader directoryEntriesReader2;
        Path path4;
        DirectoryEntriesReader directoryEntriesReader3;
        PathNode pathNode3;
        boolean isDirectory2;
        boolean isDirectory3;
        boolean isDirectory4;
        boolean createsCycle2;
        LinkOption linkOption2;
        boolean exists2;
        SequenceScope sequenceScope = (SequenceScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 4) {
                            e.a(this.L$9);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        Path path5 = e.a(this.L$9);
                        PathTreeWalk pathTreeWalk3 = (PathTreeWalk) this.L$7;
                        PathNode pathNode4 = (PathNode) this.L$6;
                        PathNode pathNode5 = (PathNode) this.L$3;
                        DirectoryEntriesReader directoryEntriesReader4 = (DirectoryEntriesReader) this.L$2;
                        ArrayDeque arrayDeque3 = (ArrayDeque) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        Path path6 = path5;
                        PathTreeWalk pathTreeWalk4 = pathTreeWalk3;
                        pathNode3 = pathNode5;
                        directoryEntriesReader3 = directoryEntriesReader4;
                        ArrayDeque arrayDeque4 = arrayDeque3;
                        PathNode pathNode6 = pathNode4;
                        arrayDeque = arrayDeque4;
                        LinkOption[] linkOptions = pathTreeWalk4.getLinkOptions();
                        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                        isDirectory3 = Files.isDirectory(path6, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
                        if (isDirectory3) {
                            pathNode6.setContentIterator(directoryEntriesReader3.readEntries(pathNode6).iterator());
                            arrayDeque.addLast(pathNode6);
                        }
                        while (!arrayDeque.isEmpty()) {
                            PathNode pathNode7 = (PathNode) arrayDeque.last();
                            Iterator<PathNode> contentIterator = pathNode7.getContentIterator();
                            Intrinsics.checkNotNull(contentIterator);
                            if (contentIterator.hasNext()) {
                                pathNode6 = contentIterator.next();
                                pathTreeWalk4 = this.this$0;
                                path6 = pathNode6.getPath();
                                if (pathNode6.getParent() != null) {
                                    PathsKt__PathRecursiveFunctionsKt.checkFileName(path6);
                                }
                                LinkOption[] linkOptions2 = pathTreeWalk4.getLinkOptions();
                                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                                isDirectory4 = Files.isDirectory(path6, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
                                if (isDirectory4) {
                                    createsCycle2 = PathTreeWalkKt.createsCycle(pathNode6);
                                    if (!createsCycle2) {
                                        if (pathTreeWalk4.getIncludeDirectories()) {
                                            this.L$0 = sequenceScope;
                                            this.L$1 = arrayDeque;
                                            this.L$2 = directoryEntriesReader3;
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode3);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(pathNode7);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(contentIterator);
                                            this.L$6 = pathNode6;
                                            this.L$7 = pathTreeWalk4;
                                            this.L$8 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                                            this.L$9 = path6;
                                            this.I$0 = 0;
                                            this.label = 3;
                                            if (sequenceScope.yield(path6, this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            pathNode5 = pathNode3;
                                            directoryEntriesReader4 = directoryEntriesReader3;
                                            pathTreeWalk3 = pathTreeWalk4;
                                            path5 = path6;
                                            arrayDeque3 = arrayDeque;
                                            pathNode4 = pathNode6;
                                            Path path62 = path5;
                                            PathTreeWalk pathTreeWalk42 = pathTreeWalk3;
                                            pathNode3 = pathNode5;
                                            directoryEntriesReader3 = directoryEntriesReader4;
                                            ArrayDeque arrayDeque42 = arrayDeque3;
                                            PathNode pathNode62 = pathNode4;
                                            arrayDeque = arrayDeque42;
                                        }
                                        LinkOption[] linkOptions3 = pathTreeWalk42.getLinkOptions();
                                        LinkOption[] linkOptionArr3 = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                                        isDirectory3 = Files.isDirectory(path62, (LinkOption[]) Arrays.copyOf(linkOptionArr3, linkOptionArr3.length));
                                        if (isDirectory3) {
                                        }
                                        while (!arrayDeque.isEmpty()) {
                                        }
                                    } else {
                                        a0.a();
                                        throw z.a(path62.toString());
                                    }
                                } else {
                                    linkOption2 = LinkOption.NOFOLLOW_LINKS;
                                    exists2 = Files.exists(path62, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption2}, 1));
                                    if (!exists2) {
                                        while (!arrayDeque.isEmpty()) {
                                        }
                                    } else {
                                        this.L$0 = sequenceScope;
                                        this.L$1 = arrayDeque;
                                        this.L$2 = directoryEntriesReader3;
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode3);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(pathNode7);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable(contentIterator);
                                        this.L$6 = SpillingKt.nullOutSpilledVariable(pathNode62);
                                        this.L$7 = SpillingKt.nullOutSpilledVariable(pathTreeWalk42);
                                        this.L$8 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                                        this.L$9 = SpillingKt.nullOutSpilledVariable(path62);
                                        this.I$0 = 0;
                                        this.label = 4;
                                        if (sequenceScope.yield(path62, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                            } else {
                                arrayDeque.removeLast();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    e.a(this.L$6);
                }
                pathNode3 = (PathNode) this.L$3;
                directoryEntriesReader3 = (DirectoryEntriesReader) this.L$2;
                arrayDeque = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
                while (!arrayDeque.isEmpty()) {
                }
                return Unit.INSTANCE;
            }
            path4 = e.a(this.L$6);
            pathTreeWalk2 = (PathTreeWalk) this.L$4;
            pathNode2 = (PathNode) this.L$3;
            directoryEntriesReader2 = (DirectoryEntriesReader) this.L$2;
            arrayDeque2 = (ArrayDeque) this.L$1;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            arrayDeque = new ArrayDeque();
            followLinks = this.this$0.getFollowLinks();
            directoryEntriesReader = new DirectoryEntriesReader(followLinks);
            path = this.this$0.start;
            path2 = this.this$0.start;
            keyOf = PathTreeWalkKt.keyOf(path2, this.this$0.getLinkOptions());
            pathNode = new PathNode(path, keyOf, null);
            pathTreeWalk = this.this$0;
            path3 = pathNode.getPath();
            if (pathNode.getParent() != null) {
                PathsKt__PathRecursiveFunctionsKt.checkFileName(path3);
            }
            LinkOption[] linkOptions4 = pathTreeWalk.getLinkOptions();
            LinkOption[] linkOptionArr4 = (LinkOption[]) Arrays.copyOf(linkOptions4, linkOptions4.length);
            isDirectory = Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr4, linkOptionArr4.length));
            if (isDirectory) {
                createsCycle = PathTreeWalkKt.createsCycle(pathNode);
                if (!createsCycle) {
                    if (pathTreeWalk.getIncludeDirectories()) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = directoryEntriesReader;
                        this.L$3 = pathNode;
                        this.L$4 = pathTreeWalk;
                        this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.L$6 = path3;
                        this.I$0 = 0;
                        this.label = 1;
                        if (sequenceScope.yield(path3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pathTreeWalk2 = pathTreeWalk;
                        arrayDeque2 = arrayDeque;
                        pathNode2 = pathNode;
                        directoryEntriesReader2 = directoryEntriesReader;
                        path4 = path3;
                    }
                    LinkOption[] linkOptions5 = pathTreeWalk.getLinkOptions();
                    LinkOption[] linkOptionArr5 = (LinkOption[]) Arrays.copyOf(linkOptions5, linkOptions5.length);
                    isDirectory2 = Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr5, linkOptionArr5.length));
                    if (isDirectory2) {
                        pathNode.setContentIterator(directoryEntriesReader.readEntries(pathNode).iterator());
                        arrayDeque.addLast(pathNode);
                    }
                    directoryEntriesReader3 = directoryEntriesReader;
                    pathNode3 = pathNode;
                    while (!arrayDeque.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                }
                a0.a();
                throw z.a(path3.toString());
            }
            linkOption = LinkOption.NOFOLLOW_LINKS;
            exists = Files.exists(path3, (LinkOption[]) Arrays.copyOf(new LinkOption[]{linkOption}, 1));
            if (exists) {
                this.L$0 = sequenceScope;
                this.L$1 = arrayDeque;
                this.L$2 = directoryEntriesReader;
                this.L$3 = SpillingKt.nullOutSpilledVariable(pathNode);
                this.L$4 = SpillingKt.nullOutSpilledVariable(pathTreeWalk);
                this.L$5 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.L$6 = SpillingKt.nullOutSpilledVariable(path3);
                this.I$0 = 0;
                this.label = 2;
                if (sequenceScope.yield(path3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            directoryEntriesReader3 = directoryEntriesReader;
            pathNode3 = pathNode;
            while (!arrayDeque.isEmpty()) {
            }
            return Unit.INSTANCE;
        }
        path3 = path4;
        directoryEntriesReader = directoryEntriesReader2;
        pathNode = pathNode2;
        arrayDeque = arrayDeque2;
        pathTreeWalk = pathTreeWalk2;
        LinkOption[] linkOptions52 = pathTreeWalk.getLinkOptions();
        LinkOption[] linkOptionArr52 = (LinkOption[]) Arrays.copyOf(linkOptions52, linkOptions52.length);
        isDirectory2 = Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr52, linkOptionArr52.length));
        if (isDirectory2) {
        }
        directoryEntriesReader3 = directoryEntriesReader;
        pathNode3 = pathNode;
        while (!arrayDeque.isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
