package com.qiahao.base_common.room.roomDao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.qiahao.base_common.room.roomModel.DownloadFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0013\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/qiahao/base_common/room/roomDao/DownloadFileDao;", "", "getAllFile", "", "Lcom/qiahao/base_common/room/roomModel/DownloadFile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadFileByUrl", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDownloadFile", "", "downloadFile", "(Lcom/qiahao/base_common/room/roomModel/DownloadFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDownloadFiles", "downloadFiles", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDownloadFile", "deleteDownloadFile", "deleteAllDownloadFiles", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface DownloadFileDao {
    @Query("DELETE FROM download_file")
    @Nullable
    Object deleteAllDownloadFiles(@NotNull Continuation<? super Unit> continuation);

    @Delete
    @Nullable
    Object deleteDownloadFile(@NotNull DownloadFile downloadFile, @NotNull Continuation<? super Unit> continuation);

    @Query("SELECT * FROM download_file")
    @Nullable
    Object getAllFile(@NotNull Continuation<? super List<DownloadFile>> continuation);

    @Query("SELECT * FROM download_file WHERE url = :url")
    @Nullable
    Object getDownloadFileByUrl(@NotNull String str, @NotNull Continuation<? super DownloadFile> continuation);

    @Insert(onConflict = 1)
    @Nullable
    Object insertDownloadFile(@NotNull DownloadFile downloadFile, @NotNull Continuation<? super Unit> continuation);

    @Insert(onConflict = 1)
    @Nullable
    Object insertDownloadFiles(@NotNull List<DownloadFile> list, @NotNull Continuation<? super Unit> continuation);

    @Update
    @Nullable
    Object updateDownloadFile(@NotNull DownloadFile downloadFile, @NotNull Continuation<? super Unit> continuation);
}
