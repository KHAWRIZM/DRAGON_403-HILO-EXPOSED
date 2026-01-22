package com.qhqc.core.feature.community.data.room.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Entity(tableName = "tb_user_block_posts")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/qhqc/core/feature/community/data/room/data/PostsBlockHistory;", "", "id", "", "uid", ShareConstants.RESULT_POST_ID, "", "createAt", "<init>", "(JJLjava/lang/String;J)V", "getId", "()J", "getUid", "setUid", "(J)V", "getPostId", "()Ljava/lang/String;", "setPostId", "(Ljava/lang/String;)V", "getCreateAt", "setCreateAt", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsBlockHistory {

    @ColumnInfo
    private long createAt;

    @PrimaryKey(autoGenerate = true)
    private final long id;

    @ColumnInfo
    @Nullable
    private String postId;

    @ColumnInfo
    private long uid;

    public PostsBlockHistory(long j10, long j11, @Nullable String str, long j12) {
        this.id = j10;
        this.uid = j11;
        this.postId = str;
        this.createAt = j12;
    }

    public final long getCreateAt() {
        return this.createAt;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getPostId() {
        return this.postId;
    }

    public final long getUid() {
        return this.uid;
    }

    public final void setCreateAt(long j10) {
        this.createAt = j10;
    }

    public final void setPostId(@Nullable String str) {
        this.postId = str;
    }

    public final void setUid(long j10) {
        this.uid = j10;
    }
}
