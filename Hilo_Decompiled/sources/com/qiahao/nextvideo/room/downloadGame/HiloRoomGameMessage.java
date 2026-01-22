package com.qiahao.nextvideo.room.downloadGame;

import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.download.DownloadListener;
import com.qiahao.base_common.download.DownloadTask;
import com.qiahao.base_common.interfaceing.ZipListener;
import com.qiahao.base_common.player.MediaDownloader;
import com.qiahao.nextvideo.room.downloadGame.GameListener;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.utilities.FileManager;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/room/downloadGame/HiloRoomGameMessage;", "", "<init>", "()V", "HILO_GAME", "", "INDEX", "isDownload", "", "checkGameType", "gameType", "", "getGameFile", "Ljava/io/File;", "downloadGame", "", "url", GameMatchActivity.GAME_ID, "listener", "Lcom/qiahao/nextvideo/room/downloadGame/GameListener;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloRoomGameMessage {

    @NotNull
    public static final String HILO_GAME = "hilo_game_";

    @NotNull
    private static final String INDEX = "index.html";

    @NotNull
    public static final HiloRoomGameMessage INSTANCE = new HiloRoomGameMessage();
    private static boolean isDownload;

    private HiloRoomGameMessage() {
    }

    public final boolean checkGameType(int gameType) {
        return new File((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, HILO_GAME + gameType, "", (String) null, 4, (Object) null)).exists();
    }

    public final void downloadGame(@NotNull final String url, final int gameId, @NotNull final GameListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isDownload) {
            return;
        }
        isDownload = true;
        new MediaDownloader.MediaDownloaderImpl(120000L).download(url, new DownloadListener() { // from class: com.qiahao.nextvideo.room.downloadGame.HiloRoomGameMessage$downloadGame$1
            public void onCompleted(DownloadTask task) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadListener.DefaultImpls.onCompleted(this, task);
                String filePath = task.getFilePath();
                final String str = "";
                if (filePath == null) {
                    filePath = "";
                }
                File file = new File(filePath);
                if (!file.exists()) {
                    HiloRoomGameMessage.isDownload = false;
                    return;
                }
                String parent = file.getParent();
                if (parent != null) {
                    String str2 = parent + File.separator;
                    if (str2 != null) {
                        str = str2;
                    }
                }
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                FileManager fileManager = FileManager.INSTANCE;
                final String str3 = url;
                final int i = gameId;
                final GameListener gameListener = listener;
                fileManager.unzip(file, file2, true, new ZipListener() { // from class: com.qiahao.nextvideo.room.downloadGame.HiloRoomGameMessage$downloadGame$1$onCompleted$1
                    public void onError(IOException e) {
                        Intrinsics.checkNotNullParameter(e, "e");
                        HiloRoomGameMessage.isDownload = false;
                        GameListener.DefaultImpls.onDownloadFailed$default(gameListener, null, 1, null);
                    }

                    public void onSuccess() {
                        ZipListener.DefaultImpls.onSuccess(this);
                        String substring = str3.substring(StringsKt.lastIndexOf$default(str3, '/', 0, false, 6, (Object) null) + 1, StringsKt.lastIndexOf$default(str3, '.', 0, false, 6, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        File file3 = new File(str + substring + File.separator + "index.html");
                        HiloRoomGameMessage.isDownload = false;
                        if (file3.exists()) {
                            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, HiloRoomGameMessage.HILO_GAME + i, file3.getAbsolutePath(), (String) null, 4, (Object) null);
                            GameListener gameListener2 = gameListener;
                            String absolutePath = file3.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                            gameListener2.onDownloadSuccess(absolutePath);
                            return;
                        }
                        GameListener.DefaultImpls.onDownloadFailed$default(gameListener, null, 1, null);
                    }
                });
            }

            public void onError(DownloadTask task, Throwable throwable) {
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                DownloadListener.DefaultImpls.onError(this, task, throwable);
                HiloRoomGameMessage.isDownload = false;
                listener.onDownloadFailed(throwable);
            }

            public void onProgress(DownloadTask task, int soFarBytes, int totalBytes) {
                Intrinsics.checkNotNullParameter(task, "task");
                DownloadListener.DefaultImpls.onProgress(this, task, soFarBytes, totalBytes);
            }
        }, Boolean.FALSE);
    }

    @Nullable
    public final File getGameFile(int gameType) {
        File file = new File((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, HILO_GAME + gameType, "", (String) null, 4, (Object) null));
        if (file.exists()) {
            return file;
        }
        return null;
    }
}
