package com.qiahao.base_common.utils;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.push.notification.PushData;
import com.oudi.utils.AppUtils;
import com.oudi.utils.EncryptUtils;
import com.oudi.utils.PathUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\b\u0010\u0019\u001a\u00020\u0005H\u0007J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005J\u0016\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J\u0016\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005J\u0010\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/qiahao/base_common/utils/PathHelper;", "", "<init>", "()V", "SUFFIX_TYPE_SVGA", "", "SUFFIX_TYPE_MP4", "SUFFIX_TYPE_IMAGE", "SUFFIX_TYPE_IMAGE_9", "SUFFIX_TYPE_GIF", "SUFFIX_TYPE_WEBP", "getAppCachePath", "getAppPrivateCachePath", "getAppPrivateFilePath", "getAppTempCachePath", "getAppPrivateTempCachePath", "getAppDownloadPath", "getAppDownloadCachePath", "getAppPrivateDownloadPath", "getDownloadFileCachePath", "url", "getDownloadFilePath", "getTempFilePath", "getMusicDirectory", "Ljava/io/File;", "getLogFilePath", "getLogDirectory", "getLogCacheDirectory", "getSvgaDownloadFilePath", "getNinePatchDownloadDirectory", "getHttpCachePath", "generateNameByUrl", "generateNameByUrl1", "generateNameByFile", "filePath", DispatchConstants.SIGN, "getPath", "directory", "name", "getSuffixType", "path", "isSVGA", "", "isMP4", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPathHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathHelper.kt\ncom/qiahao/base_common/utils/PathHelper\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,280:1\n170#2,6:281\n170#2,6:287\n*S KotlinDebug\n*F\n+ 1 PathHelper.kt\ncom/qiahao/base_common/utils/PathHelper\n*L\n249#1:281,6\n252#1:287,6\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PathHelper {

    @NotNull
    public static final PathHelper INSTANCE = new PathHelper();

    @NotNull
    public static final String SUFFIX_TYPE_GIF = ".gif";

    @NotNull
    public static final String SUFFIX_TYPE_IMAGE = ".png";

    @NotNull
    public static final String SUFFIX_TYPE_IMAGE_9 = ".9.png";

    @NotNull
    public static final String SUFFIX_TYPE_MP4 = ".mp4";

    @NotNull
    public static final String SUFFIX_TYPE_SVGA = ".svga";

    @NotNull
    public static final String SUFFIX_TYPE_WEBP = ".webp";

    private PathHelper() {
    }

    @NotNull
    public final String generateNameByFile(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String encryptMD5ToString = EncryptUtils.encryptMD5ToString(filePath);
        String suffixType = getSuffixType(filePath);
        if (suffixType == null) {
            suffixType = "";
        }
        return encryptMD5ToString + suffixType;
    }

    @NotNull
    public final String generateNameByUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String encryptMD5ToString = EncryptUtils.encryptMD5ToString(url);
        String suffixType = getSuffixType(url);
        if (suffixType == null) {
            suffixType = "";
        }
        return encryptMD5ToString + suffixType;
    }

    @NotNull
    public final String generateNameByUrl1(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String encryptMD5ToString = EncryptUtils.encryptMD5ToString(url);
        Intrinsics.checkNotNullExpressionValue(encryptMD5ToString, "encryptMD5ToString(...)");
        return encryptMD5ToString;
    }

    @NotNull
    public final String getAppCachePath() {
        String externalAppCachePath = PathUtils.getExternalAppCachePath(AppUtils.getApp());
        if (externalAppCachePath != null && externalAppCachePath.length() != 0) {
            return externalAppCachePath;
        }
        String internalAppCachePath = PathUtils.getInternalAppCachePath(AppUtils.getApp());
        Intrinsics.checkNotNullExpressionValue(internalAppCachePath, "getInternalAppCachePath(...)");
        return internalAppCachePath;
    }

    @NotNull
    public final String getAppDownloadCachePath() {
        return getPath(getAppCachePath(), "download");
    }

    @NotNull
    public final String getAppDownloadPath() {
        String externalAppDownloadPath = PathUtils.getExternalAppDownloadPath(AppUtils.getApp());
        if (externalAppDownloadPath != null && externalAppDownloadPath.length() != 0) {
            return externalAppDownloadPath;
        }
        return getPath(getAppPrivateFilePath(), "download");
    }

    @NotNull
    public final String getAppPrivateCachePath() {
        String internalAppCachePath = PathUtils.getInternalAppCachePath(AppUtils.getApp());
        Intrinsics.checkNotNullExpressionValue(internalAppCachePath, "getInternalAppCachePath(...)");
        return internalAppCachePath;
    }

    @NotNull
    public final String getAppPrivateDownloadPath() {
        return getPath(getAppPrivateFilePath(), "download");
    }

    @NotNull
    public final String getAppPrivateFilePath() {
        String internalAppFilesPath = PathUtils.getInternalAppFilesPath(AppUtils.getApp());
        Intrinsics.checkNotNullExpressionValue(internalAppFilesPath, "getInternalAppFilesPath(...)");
        return internalAppFilesPath;
    }

    @NotNull
    public final String getAppPrivateTempCachePath() {
        return getPath(getAppPrivateCachePath(), "temp");
    }

    @NotNull
    public final String getAppTempCachePath() {
        return getPath(getAppCachePath(), "temp");
    }

    @NotNull
    public final String getDownloadFileCachePath(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getPath(getAppDownloadCachePath(), generateNameByUrl(url));
    }

    @NotNull
    public final String getDownloadFilePath(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getPath(getAppDownloadPath(), generateNameByUrl(url));
    }

    @NotNull
    public final String getHttpCachePath() {
        return getPath(getAppPrivateCachePath(), HttpConstant.HTTP);
    }

    @NotNull
    public final String getLogCacheDirectory() {
        return getPath(getAppPrivateFilePath(), "log" + File.separator + "cache");
    }

    @NotNull
    public final String getLogDirectory() {
        return getPath(getAppPrivateFilePath(), "log" + File.separator + "log");
    }

    @Deprecated(message = "旧版版日志存储")
    @NotNull
    public final String getLogFilePath() {
        String absolutePath = new File(AppUtils.getApp().getExternalFilesDir("log"), new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date()) + ".log").getAbsolutePath();
        if (absolutePath == null) {
            return "";
        }
        return absolutePath;
    }

    @Nullable
    public final File getMusicDirectory() {
        return AppUtils.getApp().getExternalFilesDir(PushData.KEY_MUSIC);
    }

    @NotNull
    public final String getNinePatchDownloadDirectory() {
        return getPath(getAppPrivateDownloadPath(), "nine_patch");
    }

    @NotNull
    public final String getPath(@NotNull String directory, @NotNull String name) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(name, "name");
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        if (StringsKt.endsWith$default(directory, separator, false, 2, (Object) null)) {
            return directory + name;
        }
        return directory + separator + name;
    }

    @Nullable
    public final String getSuffixType(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        int i10 = -1;
        int length = path.length() - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if ('.' == path.charAt(length)) {
                    break;
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        length = -1;
        int length2 = path.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i12 = length2 - 1;
                if ('/' == path.charAt(length2)) {
                    i10 = length2;
                    break;
                }
                if (i12 < 0) {
                    break;
                }
                length2 = i12;
            }
        }
        if (length >= 0 && length > i10) {
            String substring = path.substring(length);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        return null;
    }

    @NotNull
    public final String getSvgaDownloadFilePath(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getPath(getAppPrivateDownloadPath(), generateNameByUrl(url));
    }

    @NotNull
    public final String getTempFilePath(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return getPath(getAppPrivateTempCachePath(), generateNameByUrl(url));
    }

    public final boolean isMP4(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return StringsKt.endsWith$default(path, ".mp4", false, 2, (Object) null);
    }

    public final boolean isSVGA(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return StringsKt.endsWith$default(path, SUFFIX_TYPE_SVGA, false, 2, (Object) null);
    }

    @NotNull
    public final String generateNameByFile(@NotNull String filePath, @NotNull String sign) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(sign, "sign");
        String encryptMD5ToString = EncryptUtils.encryptMD5ToString(sign + filePath);
        String suffixType = getSuffixType(filePath);
        if (suffixType == null) {
            suffixType = "";
        }
        return encryptMD5ToString + suffixType;
    }
}
