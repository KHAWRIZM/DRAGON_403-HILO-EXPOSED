package com.qhqc.core.feature.community.data.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.feature.community.data.room.dao.PostsBlockHistoryDao;
import com.qhqc.core.feature.community.data.room.data.PostsBlockHistory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Database(entities = {PostsBlockHistory.class}, exportSchema = false, version = 2)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/qhqc/core/feature/community/data/room/CommunityRoomLocalDB;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "postsBlockHistoryDao", "Lcom/qhqc/core/feature/community/data/room/dao/PostsBlockHistoryDao;", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class CommunityRoomLocalDB extends RoomDatabase {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static volatile CommunityRoomLocalDB INSTANCE;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qhqc/core/feature/community/data/room/CommunityRoomLocalDB$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/qhqc/core/feature/community/data/room/CommunityRoomLocalDB;", "get", "buildDatabase", "appContext", "Landroid/content/Context;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final CommunityRoomLocalDB buildDatabase(Context appContext) {
            return (CommunityRoomLocalDB) Room.databaseBuilder(appContext, CommunityRoomLocalDB.class, "DATABASE_FEATURE_COMMUNITY").fallbackToDestructiveMigration().build();
        }

        @JvmStatic
        @NotNull
        public final CommunityRoomLocalDB get() {
            CommunityRoomLocalDB communityRoomLocalDB = CommunityRoomLocalDB.INSTANCE;
            if (communityRoomLocalDB == null) {
                synchronized (this) {
                    communityRoomLocalDB = CommunityRoomLocalDB.INSTANCE;
                    if (communityRoomLocalDB == null) {
                        communityRoomLocalDB = CommunityRoomLocalDB.INSTANCE.buildDatabase(BasicModuleApp.application());
                        CommunityRoomLocalDB.INSTANCE = communityRoomLocalDB;
                    }
                }
            }
            return communityRoomLocalDB;
        }

        private Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final CommunityRoomLocalDB get() {
        return INSTANCE.get();
    }

    @NotNull
    public abstract PostsBlockHistoryDao postsBlockHistoryDao();
}
