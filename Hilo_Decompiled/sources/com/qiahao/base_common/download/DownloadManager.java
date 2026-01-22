package com.qiahao.base_common.download;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.download.DownloadRequest;
import com.qiahao.base_common.download.DownloadTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\"\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0007H\u0002J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0007J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002R'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR7\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e0\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\t¨\u0006&"}, d2 = {"Lcom/qiahao/base_common/download/DownloadManager;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "tasks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/qiahao/base_common/download/DownloadTask;", "getTasks", "()Ljava/util/concurrent/ConcurrentHashMap;", "tasks$delegate", "Lkotlin/Lazy;", "tags", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getTags", "tags$delegate", "stopAll", "", "stop", "url", ViewHierarchyConstants.TAG_KEY, "stopTag", "request", "Lcom/qiahao/base_common/download/DownloadRequest;", "download", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/qiahao/base_common/download/DownloadListener;", "listenerTag", "addListener", "removeListener", "getTask", "addTask", "task", "removeTask", "hasTask", "", "addTag", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDownloadManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadManager.kt\ncom/qiahao/base_common/download/DownloadManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n1563#2:241\n1634#2,3:242\n1869#2,2:245\n1869#2,2:247\n1869#2,2:250\n1869#2,2:252\n1#3:249\n*S KotlinDebug\n*F\n+ 1 DownloadManager.kt\ncom/qiahao/base_common/download/DownloadManager\n*L\n32#1:241\n32#1:242,3\n34#1:245,2\n64#1:247,2\n149#1:250,2\n216#1:252,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DownloadManager implements ILog {

    @NotNull
    public static final DownloadManager INSTANCE = new DownloadManager();

    /* renamed from: tasks$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy tasks = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.download.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ConcurrentHashMap tasks_delegate$lambda$0;
            tasks_delegate$lambda$0 = DownloadManager.tasks_delegate$lambda$0();
            return tasks_delegate$lambda$0;
        }
    });

    /* renamed from: tags$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy tags = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.download.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ConcurrentHashMap tags_delegate$lambda$1;
            tags_delegate$lambda$1 = DownloadManager.tags_delegate$lambda$1();
            return tags_delegate$lambda$1;
        }
    });

    private DownloadManager() {
    }

    private final void addTag(String tag, String url) {
        ILog.DefaultImpls.logE$default((ILog) this, "addTag() tag:" + tag + " ,url:" + url, (String) null, false, 6, (Object) null);
        if (tag.length() == 0 || url.length() == 0) {
            return;
        }
        synchronized (this) {
            try {
                DownloadManager downloadManager = INSTANCE;
                HashSet<String> hashSet = downloadManager.getTags().get(tag);
                if (hashSet != null) {
                    hashSet.add(url);
                } else {
                    ConcurrentHashMap<String, HashSet<String>> tags2 = downloadManager.getTags();
                    HashSet<String> hashSet2 = new HashSet<>();
                    hashSet2.add(url);
                    tags2.put(tag, hashSet2);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void addTask(DownloadTask task) {
        ILog.DefaultImpls.logD$default(this, "addTask()", null, false, 6, null);
        getTasks().put(task.getRequest().getUrl(), task);
    }

    public static /* synthetic */ void download$default(DownloadManager downloadManager, String str, DownloadListener downloadListener, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        downloadManager.download(str, downloadListener, str2);
    }

    private final ConcurrentHashMap<String, HashSet<String>> getTags() {
        return (ConcurrentHashMap) tags.getValue();
    }

    private final DownloadTask getTask(DownloadRequest request) {
        Collection<DownloadTask> values = getTasks().values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (DownloadTask downloadTask : values) {
            if (downloadTask.getRequest().equalsTarget(request)) {
                return downloadTask;
            }
        }
        return null;
    }

    private final ConcurrentHashMap<String, DownloadTask> getTasks() {
        return (ConcurrentHashMap) tasks.getValue();
    }

    private final boolean hasTask(String url) {
        return getTasks().containsKey(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap tags_delegate$lambda$1() {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap tasks_delegate$lambda$0() {
        return new ConcurrentHashMap();
    }

    public final void addListener(@NotNull String url, @NotNull DownloadListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DownloadTask task = getTask(url);
        if (task != null) {
            DownloadTask.DefaultImpls.addListener$default(task, null, listener, 1, null);
        }
    }

    public final void download(@NotNull String url, @NotNull DownloadListener listener, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        download(DownloadRequest.Companion.build$default(DownloadRequest.INSTANCE, url, null, tag, null, null, null, 48, null), listener);
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    public final void removeListener(@NotNull String url, @NotNull DownloadListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DownloadTask task = getTask(url);
        if (task != null) {
            task.removeListener(listener);
        }
    }

    public final void removeTask(@NotNull DownloadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        removeTask(task.getRequest().getUrl());
    }

    public final void stop(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ILog.DefaultImpls.logD$default(this, "stop() url:" + url, null, false, 6, null);
        DownloadTask task = getTask(url);
        if (task != null) {
            task.stop();
        }
    }

    public final void stopAll() {
        ILog.DefaultImpls.logD$default(this, "stopAll()", null, false, 6, null);
        Set<String> keySet = getTasks().keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        ArrayList<String> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        for (String str : arrayList) {
            DownloadManager downloadManager = INSTANCE;
            Intrinsics.checkNotNull(str);
            downloadManager.stop(str);
        }
        getTasks().clear();
        getTags().clear();
    }

    public final void stopTag(@NotNull String tag) {
        HashSet<String> remove;
        Intrinsics.checkNotNullParameter(tag, "tag");
        ILog.DefaultImpls.logD$default(this, "stopTag()", null, false, 6, null);
        if (getTags().containsKey(tag) && (remove = getTags().remove(tag)) != null) {
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                DownloadTask task = INSTANCE.getTask((String) it.next());
                if (task != null) {
                    task.removeListener(tag);
                }
            }
        }
    }

    private final boolean hasTask(DownloadRequest request) {
        Collection<DownloadTask> values = getTasks().values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            if (((DownloadTask) it.next()).getRequest().equalsTarget(request)) {
                return true;
            }
        }
        return false;
    }

    private final synchronized void removeTask(String url) {
        ILog.DefaultImpls.logD$default(this, "removeTask() url:" + url, null, false, 6, null);
        if (getTasks().remove(url) != null) {
            Iterator<Map.Entry<String, HashSet<String>>> it = INSTANCE.getTags().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, HashSet<String>> next = it.next();
                next.getValue().remove(url);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    public final void download(@NotNull DownloadRequest request, @NotNull DownloadListener listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        download(request, request.getTag(), listener);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    public final void stop(@NotNull String url, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(tag, "tag");
        ILog.DefaultImpls.logD$default(this, "stop() url:" + url + " ,tag:" + tag, null, false, 6, null);
        DownloadTask task = getTask(url);
        if (task != null) {
            task.removeListener(tag);
        }
    }

    private final DownloadTask getTask(String url) {
        if (hasTask(url)) {
            return getTasks().get(url);
        }
        return null;
    }

    public final void download(@NotNull DownloadRequest request, @NotNull String listenerTag, @NotNull DownloadListener listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listenerTag, "listenerTag");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ILog.DefaultImpls.logD$default(this, "download() url:" + request.getUrl() + " ,path:" + request.getFilePath() + " ,listenerTag:" + listenerTag, null, false, 6, null);
        addTag(request.getTag(), request.getUrl());
        synchronized (this) {
            try {
                DownloadManager downloadManager = INSTANCE;
                DownloadTask task = downloadManager.getTask(request);
                if (task != null) {
                    ILog.DefaultImpls.logE$default((ILog) downloadManager, "download() 有重复任务->关联复用", (String) null, false, 6, (Object) null);
                    task.addListener(listenerTag, listener);
                    task.start();
                    Unit unit = Unit.INSTANCE;
                } else {
                    ILog.DefaultImpls.logD$default(downloadManager, "download() 创建新任务", null, false, 6, null);
                    DownloadTask createTask = request.createTask();
                    if (createTask != null) {
                        createTask.addListener(listenerTag, listener);
                    } else {
                        createTask = null;
                    }
                    if (createTask != null) {
                        downloadManager.addTask(createTask);
                    }
                    if (createTask != null) {
                        createTask.start();
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void stop(@NotNull DownloadRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        stop(request.getUrl(), request.getTag());
    }
}
