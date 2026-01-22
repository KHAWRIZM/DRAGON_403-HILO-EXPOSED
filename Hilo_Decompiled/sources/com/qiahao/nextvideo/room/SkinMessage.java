package com.qiahao.nextvideo.room;

import android.text.TextUtils;
import com.google.gson.d;
import com.google.gson.n;
import com.oudi.utils.FileUtils;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.download.DownloadListener;
import com.qiahao.base_common.download.DownloadTask;
import com.qiahao.base_common.interfaceing.ZipListener;
import com.qiahao.base_common.player.MediaDownloader;
import com.qiahao.nextvideo.data.game.SkinData;
import com.qiahao.nextvideo.data.model.SkinConfiguration;
import com.qiahao.nextvideo.utilities.FileManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/room/SkinMessage;", "", "<init>", "()V", "SKIN_DATA", "", "isDownload", "", "parentPath", "mSkinData", "Lcom/qiahao/nextvideo/data/game/SkinData;", "configData", "Lcom/qiahao/nextvideo/data/model/SkinConfiguration;", "initData", "", "skinData", "checkSkin", "downloadSkin", "url", "saveSkinData", "fileName", "readJson", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SkinMessage {

    @NotNull
    public static final SkinMessage INSTANCE;

    @NotNull
    private static final String SKIN_DATA = "skin.json";

    @Nullable
    private static SkinConfiguration configData;
    private static boolean isDownload;

    @Nullable
    private static SkinData mSkinData;

    @NotNull
    private static String parentPath;

    static {
        SkinMessage skinMessage = new SkinMessage();
        INSTANCE = skinMessage;
        parentPath = "";
        skinMessage.initData();
    }

    private SkinMessage() {
    }

    private final String readJson(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return "";
        }
        return FilesKt.readText$default(file, (Charset) null, 1, (Object) null);
    }

    public final boolean checkSkin() {
        String str;
        SkinData skinData = mSkinData;
        if (skinData == null || (str = skinData.getSelectIcon0()) == null) {
            str = "";
        }
        File file = new File(str);
        SkinConfiguration skinConfiguration = configData;
        if (skinConfiguration != null && skinConfiguration.getOn() && mSkinData != null && file.exists()) {
            return true;
        }
        return false;
    }

    public final void downloadSkin(@NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (isDownload) {
            return;
        }
        isDownload = true;
        new MediaDownloader.MediaDownloaderImpl(0L, 1, (DefaultConstructorMarker) null).download(url, new DownloadListener() { // from class: com.qiahao.nextvideo.room.SkinMessage$downloadSkin$1
            public void onCompleted(DownloadTask task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadListener.DefaultImpls.onCompleted(this, task);
                String filePath = task.getFilePath();
                String str = "";
                if (filePath == null) {
                    filePath = "";
                }
                File file = new File(filePath);
                if (!file.exists()) {
                    SkinMessage.isDownload = false;
                    return;
                }
                SkinMessage skinMessage = SkinMessage.INSTANCE;
                String parent = file.getParent();
                if (parent != null) {
                    String str2 = parent + File.separator;
                    if (str2 != null) {
                        str = str2;
                    }
                }
                SkinMessage.parentPath = str;
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                FileManager fileManager = FileManager.INSTANCE;
                final String str3 = url;
                fileManager.unzip(file, file2, true, new ZipListener() { // from class: com.qiahao.nextvideo.room.SkinMessage$downloadSkin$1$onCompleted$1
                    public void onError(IOException e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        SkinMessage.isDownload = false;
                    }

                    public void onSuccess() {
                        ZipListener.DefaultImpls.onSuccess(this);
                        int lastIndexOf$default = StringsKt.lastIndexOf$default(str3, '/', 0, false, 6, (Object) null);
                        String substring = str3.substring(lastIndexOf$default + 1, StringsKt.lastIndexOf$default(str3, '.', 0, false, 6, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        SkinMessage.INSTANCE.saveSkinData(substring);
                        SkinMessage.isDownload = false;
                    }
                });
            }

            public void onError(DownloadTask task, Throwable throwable) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                DownloadListener.DefaultImpls.onError(this, task, throwable);
                SkinMessage.isDownload = false;
            }

            public void onProgress(DownloadTask downloadTask, int i, int i2) {
                DownloadListener.DefaultImpls.onProgress(this, downloadTask, i, i2);
            }
        }, Boolean.FALSE);
    }

    public final void initData() {
        SkinConfiguration skinConfiguration;
        try {
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            configData = (SkinConfiguration) BaseApplication.Companion.getGSON().j((String) IStore.DefaultImpls.getValue$default(mMKVStore, "skin_configuration", "", (String) null, 4, (Object) null), SkinConfiguration.class);
            SkinData skinData = (SkinData) new d().j((String) IStore.DefaultImpls.getValue$default(mMKVStore, "skin_data", "", (String) null, 4, (Object) null), SkinData.class);
            if (!TextUtils.isEmpty(skinData.getTabButtonBg()) && (skinConfiguration = configData) != null && skinConfiguration.getOn()) {
                mSkinData = skinData;
            }
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "SkinMessage", "解析皮肤数据失败", false, 4, (Object) null);
        }
    }

    public final void saveSkinData(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            String readTextFile = FileUtils.readTextFile(new File(parentPath + fileName + File.separator + SKIN_DATA));
            n.c(readTextFile);
            SkinData skinData = (SkinData) new d().j(readTextFile, SkinData.class);
            if (skinData != null) {
                skinData.resetValue(parentPath, fileName);
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "skin_data", new d().s(skinData), (String) null, 4, (Object) null);
            }
        } catch (Exception unused) {
            LogUtil.e$default(LogUtil.INSTANCE, "SkinMessage", "解析皮肤数据失败", false, 4, (Object) null);
        }
    }

    @Nullable
    public final SkinData skinData() {
        return mSkinData;
    }
}
