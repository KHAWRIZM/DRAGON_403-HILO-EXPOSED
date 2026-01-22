package com.qiahao.base_common.download;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.utils.PathHelper;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0001H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u000f\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0003H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00038DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/qiahao/base_common/download/FileDownloadRequest;", "Lcom/qiahao/base_common/download/DownloadRequest;", "url", "", "parentPath", ViewHierarchyConstants.TAG_KEY, "header", "", "timeout", "", "tempFile", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Boolean;)V", "Ljava/lang/Long;", "Ljava/lang/Boolean;", "fullPath", "getFullPath", "()Ljava/lang/String;", "fullPath$delegate", "Lkotlin/Lazy;", "getUrl", "getFilePath", "getTag", "getHeader", "createTask", "Lcom/qiahao/base_common/download/DownloadTask;", "getTimeout", "()Ljava/lang/Long;", "equalsTarget", "request", "getParentPath", "getFileName", "getFileName1", "isTemp", "()Ljava/lang/Boolean;", "getTempPath", "generatedFilePath", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class FileDownloadRequest implements DownloadRequest {

    /* renamed from: fullPath$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy fullPath;

    @Nullable
    private final Map<String, String> header;

    @Nullable
    private final String parentPath;

    @Nullable
    private final String tag;

    @Nullable
    private Boolean tempFile;

    @Nullable
    private final Long timeout;

    @NotNull
    private final String url;

    public FileDownloadRequest(@NotNull String url, @Nullable String str, @Nullable String str2, @Nullable Map<String, String> map, @Nullable Long l10, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.parentPath = str;
        this.tag = str2;
        this.header = map;
        this.timeout = l10;
        this.tempFile = bool;
        this.fullPath = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.download.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String generatedFilePath;
                generatedFilePath = FileDownloadRequest.this.generatedFilePath();
                return generatedFilePath;
            }
        });
        if (url.length() != 0) {
            File file = new File(str == null ? PathHelper.INSTANCE.getAppDownloadPath() : str);
            if (file.exists()) {
                return;
            }
            file.mkdir();
            return;
        }
        throw new NullPointerException("url is empty");
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @Nullable
    public DownloadTask createTask() {
        return new FileDownloadTask(this);
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    public boolean equalsTarget(@NotNull DownloadRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return Intrinsics.areEqual(request.getUrl(), getUrl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String generatedFilePath() {
        PathHelper pathHelper = PathHelper.INSTANCE;
        return pathHelper.getPath(getParentPath(), pathHelper.generateNameByUrl(getUrl()));
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @NotNull
    public String getFileName() {
        return PathHelper.INSTANCE.generateNameByUrl(getUrl());
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @NotNull
    public String getFileName1() {
        return PathHelper.INSTANCE.generateNameByUrl1(getUrl());
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @NotNull
    public String getFilePath() {
        return getFullPath();
    }

    @NotNull
    protected final String getFullPath() {
        return (String) this.fullPath.getValue();
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @Nullable
    public Map<String, String> getHeader() {
        return this.header;
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @NotNull
    public String getParentPath() {
        String str = this.parentPath;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @NotNull
    public String getTag() {
        String str = this.tag;
        if (str == null) {
            return "DEFAULT_TAG";
        }
        return str;
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @NotNull
    public String getTempPath() {
        return PathHelper.INSTANCE.getPath(getParentPath(), getFileName1());
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @Nullable
    public Long getTimeout() {
        return this.timeout;
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @NotNull
    public String getUrl() {
        return this.url;
    }

    @Override // com.qiahao.base_common.download.DownloadRequest
    @Nullable
    /* renamed from: isTemp, reason: from getter */
    public Boolean getTempFile() {
        return this.tempFile;
    }

    public /* synthetic */ FileDownloadRequest(String str, String str2, String str3, Map map, Long l10, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : map, (i10 & 16) != 0 ? null : l10, (i10 & 32) == 0 ? bool : null);
    }
}
