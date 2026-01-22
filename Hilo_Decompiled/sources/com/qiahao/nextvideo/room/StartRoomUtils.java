package com.qiahao.nextvideo.room;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.data.model.EnterRoomData;
import com.qiahao.nextvideo.room.activity.RoomActivity;
import com.qiahao.nextvideo.room.dialog.JoinLockRoomBottomDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¦\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u0011J\u0099\u0001\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u000f¢\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/room/StartRoomUtils;", "", "<init>", "()V", "ENTER_ROOM_DATA", "", "mGroupID", "getMGroupID", "()Ljava/lang/String;", "setMGroupID", "(Ljava/lang/String;)V", "start", "", "groupId", "isForSmallRoom", "", "sceneType", "", "sceneUid", "password", "agoraChannel", "agoraToken", "agoraId", "microType", "gameType", "gameCode", "groupPk", "isPasswordRoom", "provider", "is1V1", "gameMode", "startRoom", "groupRoomId", "groupCode", "groupFaceString", "groupName", "groupPassWord", "groupCountry", TUIConstants.TUIGroup.GROUP_INTRODUCTION, "groupAnnouncement", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;IZ)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StartRoomUtils {

    @NotNull
    public static final String ENTER_ROOM_DATA = "enter_room_data";

    @NotNull
    public static final StartRoomUtils INSTANCE = new StartRoomUtils();

    @NotNull
    private static String mGroupID = "";

    private StartRoomUtils() {
    }

    public static /* synthetic */ void start$default(StartRoomUtils startRoomUtils, String str, boolean z, int i, String str2, String str3, String str4, String str5, int i2, int i3, int i4, String str6, String str7, boolean z2, int i5, boolean z3, int i6, int i7, Object obj) {
        boolean z4;
        int i8;
        String str8;
        String str9;
        String str10;
        String str11;
        int i9;
        int i10;
        int i11;
        String str12;
        boolean z5;
        int i12;
        boolean z6;
        int i13 = 0;
        if ((i7 & 2) != 0) {
            z4 = false;
        } else {
            z4 = z;
        }
        if ((i7 & 4) != 0) {
            i8 = 0;
        } else {
            i8 = i;
        }
        String str13 = "";
        if ((i7 & 8) != 0) {
            str8 = "";
        } else {
            str8 = str2;
        }
        if ((i7 & 16) != 0) {
            str9 = "";
        } else {
            str9 = str3;
        }
        if ((i7 & 32) != 0) {
            str10 = "";
        } else {
            str10 = str4;
        }
        if ((i7 & 64) != 0) {
            str11 = "";
        } else {
            str11 = str5;
        }
        if ((i7 & 128) != 0) {
            i9 = 0;
        } else {
            i9 = i2;
        }
        if ((i7 & 256) != 0) {
            i10 = 0;
        } else {
            i10 = i3;
        }
        if ((i7 & 512) != 0) {
            i11 = 0;
        } else {
            i11 = i4;
        }
        if ((i7 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) == 0) {
            str13 = str6;
        }
        if ((i7 & 2048) != 0) {
            str12 = null;
        } else {
            str12 = str7;
        }
        if ((i7 & 4096) != 0) {
            z5 = false;
        } else {
            z5 = z2;
        }
        if ((i7 & 8192) != 0) {
            i12 = -1;
        } else {
            i12 = i5;
        }
        if ((i7 & 16384) != 0) {
            z6 = false;
        } else {
            z6 = z3;
        }
        if ((i7 & 32768) == 0) {
            i13 = i6;
        }
        startRoomUtils.start(str, z4, i8, str8, str9, str10, str11, i9, i10, i11, str13, str12, z5, i12, z6, i13);
    }

    public static /* synthetic */ void startRoom$default(StartRoomUtils startRoomUtils, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, int i, int i2, String str8, int i3, boolean z, int i4, Object obj) {
        String str9;
        String str10;
        String str11;
        Boolean bool2;
        String str12;
        String str13;
        String str14;
        int i5;
        int i6;
        int i7;
        String str15 = "";
        if ((i4 & 2) != 0) {
            str9 = "";
        } else {
            str9 = str2;
        }
        if ((i4 & 4) != 0) {
            str10 = "";
        } else {
            str10 = str3;
        }
        if ((i4 & 8) != 0) {
            str11 = "";
        } else {
            str11 = str4;
        }
        if ((i4 & 16) != 0) {
            bool2 = null;
        } else {
            bool2 = bool;
        }
        if ((i4 & 32) != 0) {
            str12 = "";
        } else {
            str12 = str5;
        }
        if ((i4 & 64) != 0) {
            str13 = "";
        } else {
            str13 = str6;
        }
        if ((i4 & 128) != 0) {
            str14 = "";
        } else {
            str14 = str7;
        }
        boolean z2 = false;
        if ((i4 & 256) != 0) {
            i5 = 0;
        } else {
            i5 = i;
        }
        if ((i4 & 512) != 0) {
            i6 = 0;
        } else {
            i6 = i2;
        }
        if ((i4 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) == 0) {
            str15 = str8;
        }
        if ((i4 & 2048) != 0) {
            i7 = -1;
        } else {
            i7 = i3;
        }
        if ((i4 & 4096) == 0) {
            z2 = z;
        }
        startRoomUtils.startRoom(str, str9, str10, str11, bool2, str12, str13, str14, i5, i6, str15, i7, z2);
    }

    public static final Unit startRoom$lambda$2(String str, final String str2, String str3, String str4, String str5, String str6, String str7, String str8, final boolean z, final int i, final int i2, final String str9, final int i3, final boolean z2, boolean z3) {
        long j;
        mGroupID = "";
        if (z3) {
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            if (currentActivity != null) {
                if (!currentActivity.isFinishing() && !currentActivity.isDestroyed()) {
                    new JoinLockRoomBottomDialog(currentActivity, str2, null, 0, str3, str4, str5, str6, str7, str8, 0, false, 3080, null).show();
                } else {
                    return Unit.INSTANCE;
                }
            }
        } else {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            boolean z4 = false;
            if (meetingRoomManager.getMGroupId().length() > 0) {
                if (str.length() == 0) {
                    Activity currentActivity2 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity2 != null && !(currentActivity2 instanceof RoomActivity)) {
                        z4 = true;
                    }
                    cf.c.c().l(new RoomEvent().closeRoom(meetingRoomManager.getMGroupId(), !Intrinsics.areEqual(str2, meetingRoomManager.getMGroupId())));
                } else {
                    MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
                }
            }
            cf.c.c().l(new RoomEvent().setEventId(RoomEvent.ROOM_IN));
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            Runnable runnable = new Runnable() { // from class: com.qiahao.nextvideo.room.a
                @Override // java.lang.Runnable
                public final void run() {
                    StartRoomUtils.startRoom$lambda$2$lambda$1(str2, z, i, i2, str9, i3, z2);
                }
            };
            if (z4) {
                j = 500;
            } else {
                j = 0;
            }
            hiloUtils.runInMainThread(runnable, j);
        }
        return Unit.INSTANCE;
    }

    public static final void startRoom$lambda$2$lambda$1(String str, boolean z, int i, int i2, String str2, int i3, boolean z2) {
        start$default(INSTANCE, str, z, i, null, null, null, null, 0, 0, i2, str2, null, false, i3, z2, 0, 39416, null);
    }

    public static final Unit startRoom$lambda$3() {
        mGroupID = "";
        return Unit.INSTANCE;
    }

    @NotNull
    public final String getMGroupID() {
        return mGroupID;
    }

    public final void setMGroupID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mGroupID = str;
    }

    public final void start(@NotNull String groupId, boolean isForSmallRoom, int sceneType, @NotNull String sceneUid, @NotNull String password, @NotNull String agoraChannel, @NotNull String agoraToken, int agoraId, int microType, int gameType, @NotNull String gameCode, @Nullable String groupPk, boolean isPasswordRoom, int provider, boolean is1V1, int gameMode) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(sceneUid, "sceneUid");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(agoraChannel, "agoraChannel");
        Intrinsics.checkNotNullParameter(agoraToken, "agoraToken");
        Intrinsics.checkNotNullParameter(gameCode, "gameCode");
        ActivityLifecycleManager activityLifecycleManager = ActivityLifecycleManager.INSTANCE;
        BaseActivity currentActivity = activityLifecycleManager.currentActivity();
        if (currentActivity != null && (currentActivity instanceof RoomActivity) && !((RoomActivity) currentActivity).isFinishing()) {
            activityLifecycleManager.finishLastActivity();
        }
        Activity currentActivity2 = activityLifecycleManager.currentActivity();
        if (currentActivity2 != null && !currentActivity2.isFinishing() && !currentActivity2.isDestroyed()) {
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            if (groupPk == null) {
                str2 = "";
            } else {
                str2 = groupPk;
            }
            IStore.DefaultImpls.setValue$default(mMKVStore, "enter_room_pk_data", str2, (String) null, 4, (Object) null);
            Intent putExtra = new Intent(currentActivity2, (Class<?>) RoomActivity.class).putExtra(ENTER_ROOM_DATA, BaseApplication.Companion.getGSON().s(new EnterRoomData(groupId, isForSmallRoom, sceneType, sceneUid, password, agoraChannel, agoraToken, agoraId, microType, gameType, gameCode, null, isPasswordRoom, provider, is1V1, gameMode, 2048, null)));
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            currentActivity2.startActivity(putExtra);
            return;
        }
        Activity previousActivity = activityLifecycleManager.previousActivity();
        if (previousActivity != null && !previousActivity.isFinishing() && !previousActivity.isDestroyed()) {
            MMKVStore mMKVStore2 = MMKVStore.INSTANCE;
            if (groupPk == null) {
                str = "";
            } else {
                str = groupPk;
            }
            IStore.DefaultImpls.setValue$default(mMKVStore2, "enter_room_pk_data", str, (String) null, 4, (Object) null);
            Intent putExtra2 = new Intent(previousActivity, (Class<?>) RoomActivity.class).putExtra(ENTER_ROOM_DATA, BaseApplication.Companion.getGSON().s(new EnterRoomData(groupId, isForSmallRoom, sceneType, sceneUid, password, agoraChannel, agoraToken, agoraId, microType, gameType, gameCode, null, isPasswordRoom, provider, is1V1, gameMode, 2048, null)));
            Intrinsics.checkNotNullExpressionValue(putExtra2, "putExtra(...)");
            previousActivity.startActivity(putExtra2);
        }
    }

    public final void startRoom(@NotNull final String groupRoomId, @Nullable final String groupCode, @Nullable final String groupFaceString, @Nullable final String groupName, @Nullable Boolean groupPassWord, @Nullable final String groupCountry, @Nullable final String r29, @Nullable final String groupAnnouncement, final int sceneType, final int gameType, @NotNull final String gameCode, final int provider, final boolean is1V1) {
        final String str;
        Intrinsics.checkNotNullParameter(groupRoomId, "groupRoomId");
        Intrinsics.checkNotNullParameter(gameCode, "gameCode");
        if (TextUtils.isEmpty(groupRoomId) && !TextUtils.isEmpty(mGroupID)) {
            return;
        }
        mGroupID = groupRoomId;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!meetingRoomManager.isRoomSmall()) {
            str = "";
        } else {
            str = meetingRoomManager.getMGroupId();
        }
        final boolean areEqual = Intrinsics.areEqual(groupRoomId, str);
        if (areEqual) {
            start$default(this, groupRoomId, true, sceneType, null, meetingRoomManager.getMPassword(), null, null, 0, 0, gameType, gameCode, null, false, provider, is1V1, 0, 39400, null);
            mGroupID = "";
        } else {
            AppRequestUtils.INSTANCE.checkRoomPassword(groupRoomId, new Function1() { // from class: com.qiahao.nextvideo.room.b
                public final Object invoke(Object obj) {
                    Unit startRoom$lambda$2;
                    startRoom$lambda$2 = StartRoomUtils.startRoom$lambda$2(str, groupRoomId, groupCode, groupFaceString, groupName, groupCountry, r29, groupAnnouncement, areEqual, sceneType, gameType, gameCode, provider, is1V1, ((Boolean) obj).booleanValue());
                    return startRoom$lambda$2;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.room.c
                public final Object invoke() {
                    Unit startRoom$lambda$3;
                    startRoom$lambda$3 = StartRoomUtils.startRoom$lambda$3();
                    return startRoom$lambda$3;
                }
            });
        }
    }
}
