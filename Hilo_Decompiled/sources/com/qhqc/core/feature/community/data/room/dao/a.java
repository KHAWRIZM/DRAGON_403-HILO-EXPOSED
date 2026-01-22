package com.qhqc.core.feature.community.data.room.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.feature.community.data.room.dao.PostsBlockHistoryDao;
import com.qhqc.core.feature.community.data.room.data.PostsBlockHistory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a implements PostsBlockHistoryDao {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f١٢٢٧٨a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter f١٢٢٧٩b;

    /* renamed from: c, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f١٢٢٨٠c;

    /* renamed from: com.qhqc.core.feature.community.data.room.dao.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class C٠١٤٥a extends EntityInsertionAdapter {
        C٠١٤٥a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PostsBlockHistory postsBlockHistory) {
            supportSQLiteStatement.bindLong(1, postsBlockHistory.getId());
            supportSQLiteStatement.bindLong(2, postsBlockHistory.getUid());
            if (postsBlockHistory.getPostId() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, postsBlockHistory.getPostId());
            }
            supportSQLiteStatement.bindLong(4, postsBlockHistory.getCreateAt());
        }

        @Override // androidx.room.SharedSQLiteStatement
        protected String createQuery() {
            return "INSERT OR REPLACE INTO `tb_user_block_posts` (`id`,`uid`,`postId`,`createAt`) VALUES (nullif(?, 0),?,?,?)";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class b extends EntityDeletionOrUpdateAdapter {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, PostsBlockHistory postsBlockHistory) {
            supportSQLiteStatement.bindLong(1, postsBlockHistory.getId());
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        protected String createQuery() {
            return "DELETE FROM `tb_user_block_posts` WHERE `id` = ?";
        }
    }

    public a(RoomDatabase roomDatabase) {
        this.f١٢٢٧٨a = roomDatabase;
        this.f١٢٢٧٩b = new C٠١٤٥a(roomDatabase);
        this.f١٢٢٨٠c = new b(roomDatabase);
    }

    public static List a() {
        return Collections.emptyList();
    }

    @Override // com.qhqc.core.feature.community.data.room.dao.PostsBlockHistoryDao
    public void blockPosts(long j10, String str) {
        this.f١٢٢٧٨a.beginTransaction();
        try {
            PostsBlockHistoryDao.DefaultImpls.blockPosts(this, j10, str);
            this.f١٢٢٧٨a.setTransactionSuccessful();
        } finally {
            this.f١٢٢٧٨a.endTransaction();
        }
    }

    @Override // com.qhqc.core.feature.community.data.room.dao.PostsBlockHistoryDao
    public void delete(PostsBlockHistory postsBlockHistory) {
        this.f١٢٢٧٨a.assertNotSuspendingTransaction();
        this.f١٢٢٧٨a.beginTransaction();
        try {
            this.f١٢٢٨٠c.handle(postsBlockHistory);
            this.f١٢٢٧٨a.setTransactionSuccessful();
        } finally {
            this.f١٢٢٧٨a.endTransaction();
        }
    }

    @Override // com.qhqc.core.feature.community.data.room.dao.PostsBlockHistoryDao
    public PostsBlockHistory getBlockHistory(long j10, String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM tb_user_block_posts WHERE uid = ? AND postId = ?", 2);
        acquire.bindLong(1, j10);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.f١٢٢٧٨a.assertNotSuspendingTransaction();
        PostsBlockHistory postsBlockHistory = null;
        String string = null;
        Cursor query = DBUtil.query(this.f١٢٢٧٨a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, ShareConstants.RESULT_POST_ID);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "createAt");
            if (query.moveToFirst()) {
                long j11 = query.getLong(columnIndexOrThrow);
                long j12 = query.getLong(columnIndexOrThrow2);
                if (!query.isNull(columnIndexOrThrow3)) {
                    string = query.getString(columnIndexOrThrow3);
                }
                postsBlockHistory = new PostsBlockHistory(j11, j12, string, query.getLong(columnIndexOrThrow4));
            }
            return postsBlockHistory;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.qhqc.core.feature.community.data.room.dao.PostsBlockHistoryDao
    public List getBlockHistoryPostsIdList(long j10) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT postId FROM tb_user_block_posts WHERE uid = ?", 1);
        acquire.bindLong(1, j10);
        this.f١٢٢٧٨a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f١٢٢٧٨a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    string = null;
                } else {
                    string = query.getString(0);
                }
                arrayList.add(string);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.qhqc.core.feature.community.data.room.dao.PostsBlockHistoryDao
    public void insert(PostsBlockHistory postsBlockHistory) {
        this.f١٢٢٧٨a.assertNotSuspendingTransaction();
        this.f١٢٢٧٨a.beginTransaction();
        try {
            this.f١٢٢٧٩b.insert((EntityInsertionAdapter) postsBlockHistory);
            this.f١٢٢٧٨a.setTransactionSuccessful();
        } finally {
            this.f١٢٢٧٨a.endTransaction();
        }
    }

    @Override // com.qhqc.core.feature.community.data.room.dao.PostsBlockHistoryDao
    public void unBlockPosts(long j10, String str) {
        this.f١٢٢٧٨a.beginTransaction();
        try {
            PostsBlockHistoryDao.DefaultImpls.unBlockPosts(this, j10, str);
            this.f١٢٢٧٨a.setTransactionSuccessful();
        } finally {
            this.f١٢٢٧٨a.endTransaction();
        }
    }
}
