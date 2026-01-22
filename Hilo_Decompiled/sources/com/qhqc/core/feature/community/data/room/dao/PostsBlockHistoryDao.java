package com.qhqc.core.feature.community.data.room.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.feature.community.data.room.data.PostsBlockHistory;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH'J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH'J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0017J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0017¨\u0006\u0010"}, d2 = {"Lcom/qhqc/core/feature/community/data/room/dao/PostsBlockHistoryDao;", "", "getBlockHistoryPostsIdList", "", "", "uid", "", "getBlockHistory", "Lcom/qhqc/core/feature/community/data/room/data/PostsBlockHistory;", ShareConstants.RESULT_POST_ID, "insert", "", "data", ChatMenuDialog.CLICK_DELETE, "blockPosts", "unBlockPosts", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface PostsBlockHistoryDao {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void blockPosts(@NotNull PostsBlockHistoryDao postsBlockHistoryDao, long j10, @Nullable String str) {
            if (postsBlockHistoryDao.getBlockHistory(j10, str) != null) {
                return;
            }
            postsBlockHistoryDao.insert(new PostsBlockHistory(0L, j10, str, System.currentTimeMillis() / 1000));
        }

        public static void unBlockPosts(@NotNull PostsBlockHistoryDao postsBlockHistoryDao, long j10, @Nullable String str) {
            PostsBlockHistory blockHistory = postsBlockHistoryDao.getBlockHistory(j10, str);
            if (blockHistory != null) {
                postsBlockHistoryDao.delete(blockHistory);
            }
        }
    }

    void blockPosts(long uid, @Nullable String postId);

    @Delete
    void delete(@NotNull PostsBlockHistory data);

    @Query("SELECT * FROM tb_user_block_posts WHERE uid = :uid AND postId = :postId")
    @Nullable
    PostsBlockHistory getBlockHistory(long uid, @Nullable String postId);

    @Query("SELECT postId FROM tb_user_block_posts WHERE uid = :uid")
    @NotNull
    List<String> getBlockHistoryPostsIdList(long uid);

    @Insert(onConflict = 1)
    void insert(@NotNull PostsBlockHistory data);

    void unBlockPosts(long uid, @Nullable String postId);
}
