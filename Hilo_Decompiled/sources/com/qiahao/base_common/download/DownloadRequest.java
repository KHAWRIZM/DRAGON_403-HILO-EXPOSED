package com.qiahao.base_common.download;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0000H&¨\u0006\u0017"}, d2 = {"Lcom/qiahao/base_common/download/DownloadRequest;", "", "getUrl", "", "getFilePath", "getParentPath", "getFileName", "getFileName1", "isTemp", "", "()Ljava/lang/Boolean;", "getTempPath", "getTag", "getHeader", "", "createTask", "Lcom/qiahao/base_common/download/DownloadTask;", "getTimeout", "", "()Ljava/lang/Long;", "equalsTarget", "request", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface DownloadRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qiahao/base_common/download/DownloadRequest$Companion;", "", "<init>", "()V", "build", "Lcom/qiahao/base_common/download/DownloadRequest;", "url", "", "parentPath", ViewHierarchyConstants.TAG_KEY, "header", "", "timeout", "", "tempFile", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/qiahao/base_common/download/DownloadRequest;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ DownloadRequest build$default(Companion companion, String str, String str2, String str3, Map map, Long l10, Boolean bool, int i10, Object obj) {
            String str4;
            String str5;
            Map map2;
            Long l11;
            Boolean bool2 = null;
            if ((i10 & 2) != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
            if ((i10 & 4) != 0) {
                str5 = null;
            } else {
                str5 = str3;
            }
            if ((i10 & 8) != 0) {
                map2 = null;
            } else {
                map2 = map;
            }
            if ((i10 & 16) != 0) {
                l11 = null;
            } else {
                l11 = l10;
            }
            if ((i10 & 32) == 0) {
                bool2 = bool;
            }
            return companion.build(str, str4, str5, map2, l11, bool2);
        }

        @NotNull
        public final DownloadRequest build(@NotNull String url, @Nullable String parentPath, @Nullable String tag, @Nullable Map<String, String> header, @Nullable Long timeout, @Nullable Boolean tempFile) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new FileDownloadRequest(url, parentPath, tag, header, timeout, tempFile);
        }
    }

    @Nullable
    DownloadTask createTask();

    boolean equalsTarget(@NotNull DownloadRequest request);

    @NotNull
    String getFileName();

    @NotNull
    String getFileName1();

    @NotNull
    String getFilePath();

    @Nullable
    Map<String, String> getHeader();

    @NotNull
    String getParentPath();

    @NotNull
    String getTag();

    @NotNull
    String getTempPath();

    @Nullable
    Long getTimeout();

    @NotNull
    String getUrl();

    @Nullable
    /* renamed from: isTemp */
    Boolean getTempFile();
}
