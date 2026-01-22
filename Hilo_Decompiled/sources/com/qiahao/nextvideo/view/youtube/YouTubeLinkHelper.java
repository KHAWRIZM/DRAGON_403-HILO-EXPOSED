package com.qiahao.nextvideo.view.youtube;

import android.text.TextUtils;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/view/youtube/YouTubeLinkHelper;", "", "<init>", "()V", "URI1", "", "URI2", "ID_START", "checkUrlID", "url", "getLocalVideoData", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "Lkotlin/collections/ArrayList;", "getLocalNextVideo", "videoId", "deleteAndNextVideo", "saveID", "", AgooConstants.MESSAGE_ID, "getIDList", "removeId", "saveVideoData", "data", "getVideoData", "removeVideoData", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTubeLinkHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTubeLinkHelper.kt\ncom/qiahao/nextvideo/view/youtube/YouTubeLinkHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,166:1\n1#2:167\n1869#3,2:168\n1878#3,3:170\n1878#3,3:173\n*S KotlinDebug\n*F\n+ 1 YouTubeLinkHelper.kt\ncom/qiahao/nextvideo/view/youtube/YouTubeLinkHelper\n*L\n36#1:168,2\n57#1:170,3\n77#1:173,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTubeLinkHelper {

    @NotNull
    public static final String ID_START = "PL";

    @NotNull
    public static final YouTubeLinkHelper INSTANCE = new YouTubeLinkHelper();

    @NotNull
    public static final String URI1 = "youtu.be";

    @NotNull
    public static final String URI2 = "www.youtube.com";

    private YouTubeLinkHelper() {
    }

    @NotNull
    public final String checkUrlID(@Nullable String url) {
        List groupValues;
        String str;
        if (TextUtils.isEmpty(url) || url == null) {
            return "";
        }
        Regex regex = new Regex("^.*((youtu.be/)|(v/)|(/u/\\w/)|(embed/)|(watch\\?))\\??v?=?([^#&?]*).*");
        Regex regex2 = new Regex("^.*((www.youtube.com/live/)|(v/)|(/u/\\w/)|(embed/)|(watch\\?))\\??v?=?([^#&?]*).*");
        String str2 = null;
        MatchResult find$default = Regex.find$default(regex, url, 0, 2, (Object) null);
        if (find$default == null) {
            find$default = Regex.find$default(regex2, url, 0, 2, (Object) null);
        }
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = (String) groupValues.get(7)) == null) {
            return "";
        }
        if (str.length() == 11) {
            str2 = str;
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Nullable
    public final YouTuBeData deleteAndNextVideo(@NotNull String videoId) {
        YouTuBeData youTuBeData;
        YouTuBeData youTuBeData2;
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        ArrayList<YouTuBeData> localVideoData = getLocalVideoData();
        int i = -1;
        int i2 = 0;
        for (Object obj : localVideoData) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((YouTuBeData) obj).getVideoId(), videoId)) {
                i = i2;
            }
            i2 = i3;
        }
        int size = localVideoData.size();
        if (size != 1) {
            if (size != 2) {
                if (i == localVideoData.size() - 1) {
                    youTuBeData2 = localVideoData.get(0);
                } else {
                    youTuBeData2 = localVideoData.get(i + 1);
                }
                removeId(videoId);
                return youTuBeData2;
            }
            if (i == 0) {
                youTuBeData = localVideoData.get(1);
            } else {
                youTuBeData = localVideoData.get(0);
            }
            removeId(videoId);
            return youTuBeData;
        }
        removeId(videoId);
        return null;
    }

    @NotNull
    public final String getIDList() {
        return (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MeetingRoomManager.INSTANCE.getMGroupId(), "", (String) null, 4, (Object) null);
    }

    @Nullable
    public final YouTuBeData getLocalNextVideo(@NotNull String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        ArrayList<YouTuBeData> localVideoData = getLocalVideoData();
        if (localVideoData.size() == 0) {
            return null;
        }
        if (localVideoData.size() == 1) {
            return localVideoData.get(0);
        }
        int i = 0;
        int i2 = 0;
        for (Object obj : localVideoData) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((YouTuBeData) obj).getVideoId(), videoId)) {
                i = i2;
            }
            i2 = i3;
        }
        if (i == localVideoData.size() - 1) {
            return localVideoData.get(0);
        }
        return localVideoData.get(i + 1);
    }

    @NotNull
    public final ArrayList<YouTuBeData> getLocalVideoData() {
        ArrayList<YouTuBeData> arrayList = new ArrayList<>();
        for (String str : StringsKt.split$default(getIDList(), new String[]{ID_START}, false, 0, 6, (Object) null)) {
            if (!TextUtils.isEmpty(str)) {
                YouTuBeData videoData = INSTANCE.getVideoData(ID_START + str);
                if (videoData != null) {
                    arrayList.add(videoData);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final YouTuBeData getVideoData(@NotNull String id2) {
        Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
        String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, id2, "", (String) null, 4, (Object) null);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (YouTuBeData) BaseApplication.Companion.getGSON().j(str, YouTuBeData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void removeId(@NotNull String id2) {
        Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        String str = (String) IStore.DefaultImpls.getValue$default(mMKVStore, meetingRoomManager.getMGroupId(), "", (String) null, 4, (Object) null);
        if (StringsKt.contains$default(str, id2, false, 2, (Object) null)) {
            IStore.DefaultImpls.setValue$default(mMKVStore, meetingRoomManager.getMGroupId(), StringsKt.replace$default(str, id2, "", false, 4, (Object) null), (String) null, 4, (Object) null);
        }
    }

    public final void removeVideoData(@NotNull String id2) {
        Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
        IStore.DefaultImpls.removeValue$default(MMKVStore.INSTANCE, id2, (String) null, 2, (Object) null);
    }

    public final void saveID(@NotNull String id2) {
        Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        String str = (String) IStore.DefaultImpls.getValue$default(mMKVStore, meetingRoomManager.getMGroupId(), "", (String) null, 4, (Object) null);
        if (!StringsKt.contains$default(str, id2, false, 2, (Object) null)) {
            IStore.DefaultImpls.setValue$default(mMKVStore, meetingRoomManager.getMGroupId(), str + id2, (String) null, 4, (Object) null);
        }
    }

    public final void saveVideoData(@NotNull YouTuBeData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        String videoId = data.getVideoId();
        if (videoId == null) {
            videoId = "";
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, videoId, BaseApplication.Companion.getGSON().s(data), (String) null, 4, (Object) null);
    }
}
