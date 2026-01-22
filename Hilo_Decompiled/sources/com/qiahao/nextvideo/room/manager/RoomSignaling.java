package com.qiahao.nextvideo.room.manager;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwnerKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBeanList;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MeetingRoomCustomContent;
import com.qiahao.nextvideo.data.model.MeetingRoomCustomData;
import com.qiahao.nextvideo.data.model.MeetingRoomReceiveGiftCustomContent;
import com.qiahao.nextvideo.data.model.RocketRoomSmallBean;
import com.qiahao.nextvideo.data.model.UserInRoom;
import com.tencent.imsdk.v2.V2TIMGroupListener;
import com.tencent.imsdk.v2.V2TIMManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010EJ\u0006\u0010F\u001a\u00020CJ\u0006\u0010G\u001a\u00020CR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u000509¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006H"}, d2 = {"Lcom/qiahao/nextvideo/room/manager/RoomSignaling;", "", "<init>", "()V", "TAG", "", "IM_GROUP_EDIT_PROFILE", "", "IM_GROUP_ROLE_CHANGE", "IM_GROUP_MIC_TYPE_CHANGE", "IM_GROUP_BLOCKED", "IM_GIFT", "IM_SOCKET_MIC_OUT", "IM_INVITE_USER_UP_MIC", "IM_USER_IN_ROOM", "IM_GROUP_MIC_FACE_RECEIVER", "IM_GROUP_LUCK_WHEEL_REFRESH", "IM_USER_OUT_ROOM", "IM_GROUP_ROCKET_STATE", "IM_GROUP_ONLINE_USER", "IM_GROUP_MIC_CHANGE", "IM_GROUP_INVITE", "IM_GROUP_USER_ROLE_CHANGE", "IM_CLEAR_MESSAGE", "IM_ALL_ROOM_GIFT", "IM_PK_MIC_CHANGE", "IM_PK_MATCH_SUCCESS", "IM_PK_MATCH_END", "IM_PK_PROGRESS", "IM_PK_PUNISH_FINISH", "IM_STRANGE_CHANGE", "IM_STRANGE_LOCK", "IM_STRANGE_END", "IM_YOU_TU_PROCESS", "IM_ENVELOPE", "IM_PK1v1_REFRESH", "IM_PK1v1_END", "IM_SVIP_10", "IM_GROUP_LUDO_GAME", "IM_GROUP_LUDO_GAME_END", "IM_GROUP_UNO_GAME", "IM_GROUP_UNO_GAME_END", "IM_GROUP_DOMINO_GAME", "IM_GROUP_DOMINO_GAME_END", "IM_GROUP_1V1_ERROR", "IM_GROUP_CRUSH_GAME", "IM_GROUP_CRUSH_GAME_END", "IM_GROUP_BALOOT_GAME", "IM_GROUP_BALOOT_GAME_END", "IM_GROUP_CARROM_GAME", "IM_GROUP_CARROM_GAME_END", "IM_GROUP_JACKARO_GAME", "IM_GROUP_JACKARO_GAME_END", "IM_GROUP_BACKGAMMON_GAME", "IM_GROUP_BACKGAMMON_GAME_END", "IM_GROUP_BLOCK_USER", "mSystem", "Lcom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem;", "getMSystem", "()Lcom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem;", "V2TIMGroupListener", "Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "getV2TIMGroupListener", "()Lcom/tencent/imsdk/v2/V2TIMGroupListener;", "setV2TIMGroupListener", "(Lcom/tencent/imsdk/v2/V2TIMGroupListener;)V", "imRoomSignalProtocolNotification", "", "signalProtocolNotification", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRoomSignalListener", "removeRoomSignalListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomSignaling {
    private static final int IM_ALL_ROOM_GIFT = 26;
    private static final int IM_CLEAR_MESSAGE = 25;
    private static final int IM_ENVELOPE = 36;
    private static final int IM_GIFT = 6;
    private static final int IM_GROUP_1V1_ERROR = 206;
    private static final int IM_GROUP_BACKGAMMON_GAME = 215;
    private static final int IM_GROUP_BACKGAMMON_GAME_END = 216;
    private static final int IM_GROUP_BALOOT_GAME = 209;
    private static final int IM_GROUP_BALOOT_GAME_END = 210;
    private static final int IM_GROUP_BLOCKED = 4;

    @NotNull
    public static final String IM_GROUP_BLOCK_USER = "3";
    private static final int IM_GROUP_CARROM_GAME = 211;
    private static final int IM_GROUP_CARROM_GAME_END = 212;
    private static final int IM_GROUP_CRUSH_GAME = 207;
    private static final int IM_GROUP_CRUSH_GAME_END = 208;
    private static final int IM_GROUP_DOMINO_GAME = 204;
    private static final int IM_GROUP_DOMINO_GAME_END = 205;
    private static final int IM_GROUP_EDIT_PROFILE = 1;
    private static final int IM_GROUP_INVITE = 23;
    private static final int IM_GROUP_JACKARO_GAME = 213;
    private static final int IM_GROUP_JACKARO_GAME_END = 214;
    private static final int IM_GROUP_LUCK_WHEEL_REFRESH = 18;
    private static final int IM_GROUP_LUDO_GAME = 200;
    private static final int IM_GROUP_LUDO_GAME_END = 201;
    private static final int IM_GROUP_MIC_CHANGE = 22;
    private static final int IM_GROUP_MIC_FACE_RECEIVER = 17;
    private static final int IM_GROUP_MIC_TYPE_CHANGE = 3;
    private static final int IM_GROUP_ONLINE_USER = 21;
    private static final int IM_GROUP_ROCKET_STATE = 20;
    private static final int IM_GROUP_ROLE_CHANGE = 2;
    private static final int IM_GROUP_UNO_GAME = 202;
    private static final int IM_GROUP_UNO_GAME_END = 203;
    private static final int IM_GROUP_USER_ROLE_CHANGE = 24;
    private static final int IM_INVITE_USER_UP_MIC = 15;
    private static final int IM_PK1v1_END = 38;
    private static final int IM_PK1v1_REFRESH = 37;
    private static final int IM_PK_MATCH_END = 29;
    private static final int IM_PK_MATCH_SUCCESS = 28;
    private static final int IM_PK_MIC_CHANGE = 27;
    private static final int IM_PK_PROGRESS = 30;
    private static final int IM_PK_PUNISH_FINISH = 31;
    private static final int IM_SOCKET_MIC_OUT = 14;
    public static final int IM_STRANGE_CHANGE = 32;
    public static final int IM_STRANGE_END = 34;
    public static final int IM_STRANGE_LOCK = 33;
    private static final int IM_SVIP_10 = 40;
    private static final int IM_USER_IN_ROOM = 16;
    private static final int IM_USER_OUT_ROOM = 19;
    private static final int IM_YOU_TU_PROCESS = 35;

    @NotNull
    public static final RoomSignaling INSTANCE = new RoomSignaling();

    @NotNull
    public static final String TAG = "RoomSignaling";

    @NotNull
    private static final AdvancedMessageProcessingSystem<String> mSystem = new AdvancedMessageProcessingSystem<>(TAG, 5, 0, 0, new RoomSignaling$mSystem$1(null), 12, (DefaultConstructorMarker) null);

    @NotNull
    private static V2TIMGroupListener V2TIMGroupListener = new V2TIMGroupListener() { // from class: com.qiahao.nextvideo.room.manager.RoomSignaling$V2TIMGroupListener$1
        @Override // com.tencent.imsdk.v2.V2TIMGroupListener
        public void onReceiveRESTCustomData(String groupID, byte[] customData) {
            super.onReceiveRESTCustomData(groupID, customData);
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (!TextUtils.isEmpty(meetingRoomManager.getMGroupId()) && Intrinsics.areEqual(meetingRoomManager.getMGroupId(), groupID)) {
                try {
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(HiloApplication.INSTANCE.getAppLifecycleScope()), Dispatchers.getIO(), (CoroutineStart) null, new RoomSignaling$V2TIMGroupListener$1$onReceiveRESTCustomData$1(customData, null), 2, (Object) null);
                } catch (Exception e) {
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "解析数据错误", e, false, 8, (Object) null);
                }
            }
        }
    };

    private RoomSignaling() {
    }

    public final void addRoomSignalListener() {
        V2TIMManager.getInstance().addGroupListener(V2TIMGroupListener);
        mSystem.start();
    }

    @NotNull
    public final AdvancedMessageProcessingSystem<String> getMSystem() {
        return mSystem;
    }

    @NotNull
    public final V2TIMGroupListener getV2TIMGroupListener() {
        return V2TIMGroupListener;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(4:(1:(1:(2:13|14))(1:16))|20|18|19)(6:21|22|23|(4:27|(1:29)|30|(2:34|(2:36|37)(18:38|(1:41)|42|(1:45)|46|(1:49)|50|(1:53)|54|(1:57)|58|(3:(3:61|(1:63)|64)|(3:66|(1:68)(1:70)|69)|(3:72|(1:74)|75))|(3:77|(1:79)|80)|(3:82|(1:84)|85)|(3:87|(1:89)|90)|(3:92|(1:94)|95)|96|(1:98))))(21:99|(2:589|(2:591|(1:593)))|579|(2:581|(1:583)(2:584|(1:586)))|(2:569|(2:571|(1:573))(3:574|(1:576)(1:578)|577))|556|(4:558|(1:560)(1:566)|561|(2:563|(1:565)))|(4:546|(1:548)|549|(3:551|(1:553)(1:555)|554))|541|(1:543)|112|(1:540)|535|(1:537)|(1:534)|525|(3:527|(1:529)(1:531)|530)|121|(1:523)(1:123)|(3:489|490|(6:511|(1:513)(1:522)|514|(2:521|518)|517|518)(4:494|(1:496)|497|(6:499|(1:501)(1:510)|502|(2:509|506)|505|506)))|485)|18|19)|17|18|19))|597|6|7|(0)(0)|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0405, code lost:
    
        if (r10 != null) goto L٢٠٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x043e, code lost:
    
        if (r10 != null) goto L٢١٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x04a1, code lost:
    
        if (r10 != null) goto L٢٣٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x04db, code lost:
    
        if (r10 != null) goto L٢٤٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0504, code lost:
    
        if (r10 != null) goto L٢٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x050e, code lost:
    
        if (r10.intValue() != 200) goto L٢٧٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0510, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0522, code lost:
    
        if (r1.getStatus() != 2) goto L٢٦٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0524, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.saveCreateLudoDateAndClear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x052f, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x053d, code lost:
    
        if (r4 == null) goto L٢٦٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x053f, code lost:
    
        r13 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0547, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r13) == false) goto L٢٦٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0549, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x054f, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0551, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_LUDO_GAME_CREATE, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0568, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x056e, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0570, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_LUDO_GAME_STATUS, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x052a, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.setMLudoGameData(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0589, code lost:
    
        if (r10 != null) goto L٢٧٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0592, code lost:
    
        if (r10.intValue() != 201) goto L٢٨٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0594, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameAward) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameAward.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x05a8, code lost:
    
        if (r2.isRoomOpen() == false) goto L٢٨١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x05aa, code lost:
    
        r2.saveCreateLudoDateAndClear();
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.tryEmit(r4.gameEnd(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_LUDO_GAME_END, r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x05c8, code lost:
    
        r2.setMLudoGameData(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x05cf, code lost:
    
        if (r10 != null) goto L٢٨٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0652, code lost:
    
        if (r10 != null) goto L٣٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0698, code lost:
    
        if (r10 != null) goto L٣١١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x071b, code lost:
    
        if (r10 != null) goto L٣٣٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0761, code lost:
    
        if (r10 != null) goto L٣٣٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x07e4, code lost:
    
        if (r10 != null) goto L٣٥٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x082a, code lost:
    
        if (r10 != null) goto L٣٦٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x08ad, code lost:
    
        if (r10 != null) goto L٣٨٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x08f3, code lost:
    
        if (r10 != null) goto L٣٩٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0976, code lost:
    
        if (r10 != null) goto L٤١١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x09bc, code lost:
    
        if (r10 != null) goto L٤١٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0a3f, code lost:
    
        if (r10 != null) goto L٤٣٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0a85, code lost:
    
        if (r10 != null) goto L٤٤٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0b08, code lost:
    
        if (r10 != null) goto L٤٦٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0b4c, code lost:
    
        if (r10 != null) goto L٤٧٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0b84, code lost:
    
        if (r10 != null) goto L٤٨٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0bab, code lost:
    
        if (r10 != null) goto L٤٨٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0bc8, code lost:
    
        if (r10 != null) goto L٤٩٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0c11, code lost:
    
        if (r10 != null) goto L٥٠٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0c65, code lost:
    
        if (r10 != null) goto L٥١٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0c92, code lost:
    
        if (r10 != null) goto L٥٢٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0cc6, code lost:
    
        if (r10 != null) goto L٥٣٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0d20, code lost:
    
        if (r10 != null) goto L٥٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0d65, code lost:
    
        if (r10 != null) goto L٥٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0db0, code lost:
    
        if (r10 != null) goto L٥٦٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0dba, code lost:
    
        if (r10.intValue() != 40) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0dbc, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0dc2, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0dc4, code lost:
    
        r2.getWsFlow().tryEmit(new com.qiahao.nextvideo.room.manager.RoomEvent().roomEvent(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_SVIP10_ONLINE, (com.qiahao.nextvideo.data.room.Svip10Signaling) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.room.Svip10Signaling.class)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0d6e, code lost:
    
        if (r10.intValue() != 38) goto L٥٦١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0d70, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.Pk1v1End) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.Pk1v1End.class);
        r2 = r1.getGroupId();
        r4 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0d8e, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r4.getMGroupId()) != false) goto L٥٥٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0d92, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0d93, code lost:
    
        r4.getWsFlow().tryEmit(new com.qiahao.nextvideo.room.manager.RoomEvent().roomEvent(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_PK1V1_END, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0da9, code lost:
    
        if (r4.isRoomSmall() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0dab, code lost:
    
        r4.setMPK1v1(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0d29, code lost:
    
        if (r10.intValue() != 37) goto L٥٥٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0d2b, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.Pk1v1Data) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.Pk1v1Data.class);
        r2 = r1.getGroupId();
        r4 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0d49, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r4.getMGroupId()) != false) goto L٥٤٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0d4d, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0d4e, code lost:
    
        r4.setMPK1v1(r1);
        r4.getWsFlow().tryEmit(com.qiahao.nextvideo.room.manager.RoomEvent.roomEvent$default(new com.qiahao.nextvideo.room.manager.RoomEvent(), com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_PK1V1_REFRESH, null, 2, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0ccf, code lost:
    
        if (r10.intValue() != 36) goto L٥٤١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0cd1, code lost:
    
        r1 = (com.qiahao.nextvideo.data.room.EnvelopeData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.room.EnvelopeData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0ce9, code lost:
    
        if (android.text.TextUtils.isEmpty(r5.getTarget()) != false) goto L٥٤٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0ceb, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0cf9, code lost:
    
        if (r4 == null) goto L٥٣٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0cfb, code lost:
    
        r4 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0d05, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r4) == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0d00, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0d07, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
        r2.setMEnvelopeData(r1);
        r2.getWsFlow().tryEmit(com.qiahao.nextvideo.room.manager.RoomEvent.roomEvent$default(new com.qiahao.nextvideo.room.manager.RoomEvent(), com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_ENVELOPE, null, 2, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0c9b, code lost:
    
        if (r10.intValue() != 35) goto L٥٢٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0c9d, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.YouTuGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.YouTuGameData.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
        r2.setMYouTuBe(r1);
        r2.getWsFlow().tryEmit(com.qiahao.nextvideo.room.manager.RoomEvent.roomEvent$default(new com.qiahao.nextvideo.room.manager.RoomEvent(), com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_YOU_TU, null, 2, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0c6e, code lost:
    
        if (r10.intValue() != 31) goto L٥٢٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0c70, code lost:
    
        r1 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
        r2 = r1.getMPK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0c76, code lost:
    
        if (r2 == null) goto L٥٢٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0c78, code lost:
    
        r2.setStatus(3);
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0c7e, code lost:
    
        r1.getWsFlow().tryEmit(com.qiahao.nextvideo.room.manager.RoomEvent.roomEvent$default(new com.qiahao.nextvideo.room.manager.RoomEvent(), com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_PK_PUNISH, null, 2, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0c1a, code lost:
    
        if (r10.intValue() != 30) goto L٥١٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0c1c, code lost:
    
        r1 = (com.qiahao.nextvideo.data.room.RoomPKScoreRes) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.room.RoomPKScoreRes.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
        r4 = r2.getMPK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0c32, code lost:
    
        if (r4 == null) goto L٥١١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x0c38, code lost:
    
        if (r4.getStatus() != 1) goto L٥١١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0c3a, code lost:
    
        r4 = r2.getMPK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0c3e, code lost:
    
        if (r4 == null) goto L٥١٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0c40, code lost:
    
        r4.setRoomPKPro(r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0c51, code lost:
    
        r2.getWsFlow().tryEmit(com.qiahao.nextvideo.room.manager.RoomEvent.roomEvent$default(new com.qiahao.nextvideo.room.manager.RoomEvent(), com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_PK_PRO, null, 2, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0c46, code lost:
    
        r1 = r2.getMPK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0c4a, code lost:
    
        if (r1 == null) goto L٥١٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0c4c, code lost:
    
        r1.setRoomPKPro(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0bd1, code lost:
    
        if (r10.intValue() != 29) goto L٥٠٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0bd3, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0bd9, code lost:
    
        if (r2.isRoomOpen() == false) goto L٤٩٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0bdb, code lost:
    
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.getWsFlow().tryEmit(new com.qiahao.nextvideo.room.manager.RoomEvent().roomEvent(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_PK_END, (com.qiahao.nextvideo.data.room.RoomPKEnd) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.room.RoomPKEnd.class))));
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0c03, code lost:
    
        r2.setMPK(null);
        r2.getMBoxLevel().clear();
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0bb4, code lost:
    
        if (r10.intValue() != 28) goto L٤٩٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0bb6, code lost:
    
        r1 = kotlinx.coroutines.Dispatchers.getMain();
        r7 = new com.qiahao.nextvideo.room.manager.RoomSignaling$imRoomSignalProtocolNotification$7(r5, null);
        r2.label = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0bc5, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r1, r7, r2) != r4) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0bc7, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0b8d, code lost:
    
        if (r10.intValue() != com.qiahao.nextvideo.room.manager.RoomSignaling.IM_GROUP_1V1_ERROR) goto L٤٨٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0b8f, code lost:
    
        r1 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0b95, code lost:
    
        if (r1.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0b97, code lost:
    
        r1.getWsFlow().tryEmit(com.qiahao.nextvideo.room.manager.RoomEvent.roomEvent$default(new com.qiahao.nextvideo.room.manager.RoomEvent(), com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_1V1_ERROR, null, 2, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0b55, code lost:
    
        if (r10.intValue() != 26) goto L٤٧٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0b57, code lost:
    
        r1 = (com.qiahao.nextvideo.data.signaling.RoomAllGift) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.signaling.RoomAllGift.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0b6d, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0b6f, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.allRoomGift(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0b0f, code lost:
    
        if (r10.intValue() != 216) goto L٤٧١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0b11, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameAward) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameAward.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0b25, code lost:
    
        if (r2.isRoomOpen() == false) goto L٤٧٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0b27, code lost:
    
        r2.saveCreateBackgammonDateAndClear();
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.tryEmit(r4.gameEnd(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_BACKGAMMON_GAME_END, r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0b45, code lost:
    
        r2.setMBackgammonGameData(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0a8f, code lost:
    
        if (r10.intValue() != 215) goto L٤٦٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0a91, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0aa3, code lost:
    
        if (r1.getStatus() != 2) goto L٤٥١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0aa5, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.saveCreateBackgammonDateAndClear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0ab0, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x0abe, code lost:
    
        if (r4 == null) goto L٤٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0ac0, code lost:
    
        r13 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0ac8, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r13) == false) goto L٤٦٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0aca, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0ad0, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0ad2, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_BACKGAMMON_GAME_CREATE, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0ae9, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0aef, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x0af1, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_BACKGAMMON_GAME_STATUS, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0aab, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.setMBackgammonGameData(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x0a48, code lost:
    
        if (r10.intValue() != 214) goto L٤٤٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x0a4a, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameAward) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameAward.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0a5e, code lost:
    
        if (r2.isRoomOpen() == false) goto L٤٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0a60, code lost:
    
        r2.saveCreateJackaroDateAndClear();
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.tryEmit(r4.gameEnd(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_JACKARO_GAME_END, r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x0a7e, code lost:
    
        r2.setMJackaroGameData(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x09c6, code lost:
    
        if (r10.intValue() != 213) goto L٤٣٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x09c8, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x09da, code lost:
    
        if (r1.getStatus() != 2) goto L٤٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x09dc, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.saveCreateJackaroDateAndClear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x09e7, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x09f5, code lost:
    
        if (r4 == null) goto L٤٢٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x09f7, code lost:
    
        r13 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x09ff, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r13) == false) goto L٤٣٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0a01, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0a07, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0a09, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_JACKARO_GAME_CREATE, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0a20, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0a26, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0a28, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_JACKARO_GAME_STATUS, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x09e2, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.setMJackaroGameData(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x097f, code lost:
    
        if (r10.intValue() != 212) goto L٤١٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0981, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameAward) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameAward.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0995, code lost:
    
        if (r2.isRoomOpen() == false) goto L٤١٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0997, code lost:
    
        r2.saveCreateCarromDateAndClear();
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.tryEmit(r4.gameEnd(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_CARROM_GAME_END, r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x09b5, code lost:
    
        r2.setMCarromGameData(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x08fd, code lost:
    
        if (r10.intValue() != 211) goto L٤٠٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x08ff, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0911, code lost:
    
        if (r1.getStatus() != 2) goto L٣٩٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0913, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.saveCreateCarromDateAndClear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x091e, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x092c, code lost:
    
        if (r4 == null) goto L٤٠١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x092e, code lost:
    
        r13 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0936, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r13) == false) goto L٤٠٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0938, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x093e, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0940, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_CARROM_GAME_CREATE, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x0957, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x095d, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x095f, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_CARROM_GAME_STATUS, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0919, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.setMCarromGameData(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x08b6, code lost:
    
        if (r10.intValue() != 210) goto L٣٩٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x08b8, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameAward) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameAward.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x08cc, code lost:
    
        if (r2.isRoomOpen() == false) goto L٣٨٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x08ce, code lost:
    
        r2.saveCreateBalootDateAndClear();
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.tryEmit(r4.gameEnd(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_BALOOT_GAME_END, r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x08ec, code lost:
    
        r2.setMBalootGameData(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0834, code lost:
    
        if (r10.intValue() != com.qiahao.nextvideo.room.manager.RoomSignaling.IM_GROUP_BALOOT_GAME) goto L٣٨٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x0836, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0848, code lost:
    
        if (r1.getStatus() != 2) goto L٣٧٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x084a, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.saveCreateBalootDateAndClear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x0855, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0863, code lost:
    
        if (r4 == null) goto L٣٧٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0865, code lost:
    
        r13 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x086d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r13) == false) goto L٣٧٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x086f, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0875, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0877, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_BALOOT_GAME_CREATE, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x088e, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0894, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0896, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_BALOOT_GAME_STATUS, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0850, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.setMBalootGameData(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x07ed, code lost:
    
        if (r10.intValue() != com.qiahao.nextvideo.room.manager.RoomSignaling.IM_GROUP_CRUSH_GAME_END) goto L٣٦٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x07ef, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameAward) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameAward.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0803, code lost:
    
        if (r2.isRoomOpen() == false) goto L٣٦٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0805, code lost:
    
        r2.saveCreateCrushDateAndClear();
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.tryEmit(r4.gameEnd(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_CRUSH_GAME_END, r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0823, code lost:
    
        r2.setMCrushGameData(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x076b, code lost:
    
        if (r10.intValue() != com.qiahao.nextvideo.room.manager.RoomSignaling.IM_GROUP_CRUSH_GAME) goto L٣٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x076d, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x077f, code lost:
    
        if (r1.getStatus() != 2) goto L٣٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0781, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.saveCreateCrushDateAndClear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x078c, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x079a, code lost:
    
        if (r4 == null) goto L٣٤٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x079c, code lost:
    
        r13 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x07a4, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r13) == false) goto L٣٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x07a6, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x07ac, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x07ae, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_CRUSH_GAME_CREATE, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x07c5, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x07cb, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x07cd, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_CRUSH_GAME_STATUS, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0787, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.setMCrushGameData(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0724, code lost:
    
        if (r10.intValue() != com.qiahao.nextvideo.room.manager.RoomSignaling.IM_GROUP_DOMINO_GAME_END) goto L٣٣٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x0726, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameAward) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameAward.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x073a, code lost:
    
        if (r2.isRoomOpen() == false) goto L٣٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x073c, code lost:
    
        r2.saveCreateDominoDateAndClear();
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.tryEmit(r4.gameEnd(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_DOMINO_GAME_END, r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x075a, code lost:
    
        r2.setMDominoGameData(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x06a2, code lost:
    
        if (r10.intValue() != com.qiahao.nextvideo.room.manager.RoomSignaling.IM_GROUP_DOMINO_GAME) goto L٣٢٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x06a4, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x06b6, code lost:
    
        if (r1.getStatus() != 2) goto L٣١٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x06b8, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.saveCreateDominoDateAndClear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x06c3, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x06d1, code lost:
    
        if (r4 == null) goto L٣٢٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x06d3, code lost:
    
        r13 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x06db, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r13) == false) goto L٣٢٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x06dd, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x06e3, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x06e5, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_DOMINO_GAME_CREATE, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x06fc, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x0702, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x0704, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_DOMINO_GAME_STATUS, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x06be, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.setMDominoGameData(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x065b, code lost:
    
        if (r10.intValue() != com.qiahao.nextvideo.room.manager.RoomSignaling.IM_GROUP_UNO_GAME_END) goto L٣٠٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x065d, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameAward) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameAward.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x0671, code lost:
    
        if (r2.isRoomOpen() == false) goto L٣٠٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x0673, code lost:
    
        r2.saveCreateUnoDateAndClear();
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.tryEmit(r4.gameEnd(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_UNO_GAME_END, r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x0691, code lost:
    
        r2.setMUnoGameData(null);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x05d9, code lost:
    
        if (r10.intValue() != com.qiahao.nextvideo.room.manager.RoomSignaling.IM_GROUP_UNO_GAME) goto L٣٠١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x05db, code lost:
    
        r1 = (com.qiahao.nextvideo.data.game.SUDGameData) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.game.SUDGameData.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x05ed, code lost:
    
        if (r1.getStatus() != 2) goto L٢٨٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x05ef, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.saveCreateUnoDateAndClear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x05fa, code lost:
    
        r2 = r5.getTarget();
        r4 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x0608, code lost:
    
        if (r4 == null) goto L٢٩٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:439:0x060a, code lost:
    
        r13 = r4.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x0612, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r13) == false) goto L٢٩٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x0614, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:443:0x061a, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x061c, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_UNO_GAME_CREATE, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x0633, code lost:
    
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x0639, code lost:
    
        if (r2.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:447:0x063b, code lost:
    
        r2 = r2.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.gameState(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_UNO_GAME_STATUS, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x05f5, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.setMUnoGameData(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x04e4, code lost:
    
        if (r10.intValue() != 18) goto L٢٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x04e6, code lost:
    
        r1 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x04ec, code lost:
    
        if (r1.isRoomOpen() == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x04ee, code lost:
    
        r1.getWsFlow().tryEmit(new com.qiahao.nextvideo.room.manager.RoomEvent().setEventId(com.qiahao.nextvideo.room.manager.RoomEvent.ROOM_LUCKY_WHEEL_EVENT));
     */
    /* JADX WARN: Code restructure failed: missing block: B:455:0x04aa, code lost:
    
        if (r10.intValue() != 17) goto L٢٤٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x04ac, code lost:
    
        r1 = (com.qiahao.nextvideo.data.model.EmojiBean) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.model.EmojiBean.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.getWsFlow();
        r4 = new com.qiahao.nextvideo.room.manager.RoomEvent();
        r5 = r5.getSource();
     */
    /* JADX WARN: Code restructure failed: missing block: B:457:0x04cb, code lost:
    
        if (r5 != null) goto L٢٤٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:459:0x04cf, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r2.tryEmit(r4.setMicEmoji(r12, r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x04ce, code lost:
    
        r12 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x0447, code lost:
    
        if (r10.intValue() != 24) goto L٢٣٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:463:0x0449, code lost:
    
        r2 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared();
        r4 = r5.getTarget();
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x0453, code lost:
    
        if (r4 != null) goto L٢٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:467:0x045b, code lost:
    
        if (r2.isMySelf(r12) != false) goto L٢٢٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:469:0x045f, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:470:0x0460, code lost:
    
        r1 = (com.qiahao.nextvideo.data.model.RoomChangeRole) r1.getGSON().j(r5.getContent(), com.qiahao.nextvideo.data.model.RoomChangeRole.class);
        r2 = com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE;
        r4 = r2.getMGroupDetailBean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x0476, code lost:
    
        if (r4 == null) goto L٢٣٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x0478, code lost:
    
        r4.setRole(kotlin.coroutines.jvm.internal.Boxing.boxInt(r1.getRole()));
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x0485, code lost:
    
        r1 = r2.getMGroupDetailBean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x0489, code lost:
    
        if (r1 == null) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x048b, code lost:
    
        kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2.getWsFlow().tryEmit(new com.qiahao.nextvideo.room.manager.RoomEvent().updateGroupDetail(r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:0x0456, code lost:
    
        r12 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x040e, code lost:
    
        if (r10.intValue() != 23) goto L٢١٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x0410, code lost:
    
        r1 = r5.getTarget();
        r2 = com.qiahao.nextvideo.data.UserStore.INSTANCE.getShared().getUser();
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x041e, code lost:
    
        if (r2 == null) goto L٢١٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x0420, code lost:
    
        r13 = r2.getExternalId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x0428, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r13) == false) goto L٦٠٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x042a, code lost:
    
        com.qiahao.nextvideo.room.manager.MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new com.qiahao.nextvideo.room.manager.RoomEvent().inviteUserBecomeMember());
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x0403, code lost:
    
        if (r10.intValue() != 3) goto L٢٠٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:524:0x03ed, code lost:
    
        if (r10.intValue() != 22) goto L١٩٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:594:0x0039, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:596:0x0e4c, code lost:
    
        r0.printStackTrace();
        android.util.Log.d(com.qiahao.nextvideo.room.manager.RoomSignaling.TAG, "房间信令，解析报错");
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object imRoomSignalProtocolNotification(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        RoomSignaling$imRoomSignalProtocolNotification$1 roomSignaling$imRoomSignalProtocolNotification$1;
        int i;
        int i2;
        if (continuation instanceof RoomSignaling$imRoomSignalProtocolNotification$1) {
            roomSignaling$imRoomSignalProtocolNotification$1 = (RoomSignaling$imRoomSignalProtocolNotification$1) continuation;
            int i3 = roomSignaling$imRoomSignalProtocolNotification$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                roomSignaling$imRoomSignalProtocolNotification$1.label = i3 - Integer.MIN_VALUE;
                Object obj = roomSignaling$imRoomSignalProtocolNotification$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = roomSignaling$imRoomSignalProtocolNotification$1.label;
                boolean z = true;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3 && i != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                BaseApplication.Companion companion = BaseApplication.Companion;
                MeetingRoomCustomData meetingRoomCustomData = (MeetingRoomCustomData) companion.getGSON().j(str, MeetingRoomCustomData.class);
                Integer msgId = meetingRoomCustomData.getMsgId();
                String str2 = "";
                if (msgId != null && msgId.intValue() == 1) {
                    UserStore shared = UserStore.INSTANCE.getShared();
                    String source = meetingRoomCustomData.getSource();
                    if (source == null) {
                        source = "";
                    }
                    if (!shared.isMySelf(source) && !TextUtils.isEmpty(meetingRoomCustomData.getContent())) {
                        MeetingRoomCustomContent meetingRoomCustomContent = (MeetingRoomCustomContent) companion.getGSON().j(meetingRoomCustomData.getContent(), MeetingRoomCustomContent.class);
                        if (meetingRoomCustomContent == null) {
                            return Unit.INSTANCE;
                        }
                        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                        GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
                        if (!TextUtils.isEmpty(meetingRoomCustomContent.getName()) && mGroupDetailBean != null) {
                            String name = meetingRoomCustomContent.getName();
                            Intrinsics.checkNotNull(name);
                            mGroupDetailBean.setName(name);
                            Unit unit = Unit.INSTANCE;
                        }
                        if (!TextUtils.isEmpty(meetingRoomCustomContent.getIntroduction()) && mGroupDetailBean != null) {
                            String introduction = meetingRoomCustomContent.getIntroduction();
                            Intrinsics.checkNotNull(introduction);
                            mGroupDetailBean.setIntroduction(introduction);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        if (!TextUtils.isEmpty(meetingRoomCustomContent.getFaceUrl()) && mGroupDetailBean != null) {
                            String faceUrl = meetingRoomCustomContent.getFaceUrl();
                            Intrinsics.checkNotNull(faceUrl);
                            mGroupDetailBean.setFaceUrl(faceUrl);
                            Unit unit3 = Unit.INSTANCE;
                        }
                        if (!TextUtils.isEmpty(meetingRoomCustomContent.getNotification()) && mGroupDetailBean != null) {
                            String notification = meetingRoomCustomContent.getNotification();
                            Intrinsics.checkNotNull(notification);
                            mGroupDetailBean.setNotification(notification);
                            Unit unit4 = Unit.INSTANCE;
                        }
                        if (meetingRoomCustomContent.getMicOn() != null && mGroupDetailBean != null) {
                            Boolean micOn = meetingRoomCustomContent.getMicOn();
                            Intrinsics.checkNotNull(micOn);
                            mGroupDetailBean.setMicOn(micOn.booleanValue());
                            Unit unit5 = Unit.INSTANCE;
                        }
                        if (meetingRoomCustomContent.getThemeId() != null) {
                            if (mGroupDetailBean != null) {
                                Integer themeId = meetingRoomCustomContent.getThemeId();
                                if (themeId == null) {
                                    themeId = Boxing.boxInt(0);
                                }
                                mGroupDetailBean.setThemeId(themeId);
                                Unit unit6 = Unit.INSTANCE;
                            }
                            if (mGroupDetailBean != null) {
                                String themeUrl = meetingRoomCustomContent.getThemeUrl();
                                if (themeUrl != null) {
                                    str2 = themeUrl;
                                }
                                mGroupDetailBean.setThemeUrl(str2);
                                Unit unit7 = Unit.INSTANCE;
                            }
                            if (mGroupDetailBean != null) {
                                Integer themeType = meetingRoomCustomContent.getThemeType();
                                if (themeType == null) {
                                    themeType = Boxing.boxInt(0);
                                }
                                mGroupDetailBean.setThemeType(themeType);
                                Unit unit8 = Unit.INSTANCE;
                            }
                        }
                        if (mGroupDetailBean != null) {
                            Integer memberFee = meetingRoomCustomContent.getMemberFee();
                            if (memberFee == null) {
                                memberFee = Boxing.boxInt(0);
                            }
                            mGroupDetailBean.setMemberFee(memberFee);
                            Unit unit9 = Unit.INSTANCE;
                        }
                        if (mGroupDetailBean != null) {
                            Integer touristSendMsg = meetingRoomCustomContent.getTouristSendMsg();
                            if (touristSendMsg == null) {
                                touristSendMsg = Boxing.boxInt(1);
                            }
                            mGroupDetailBean.setTouristSendMsg(touristSendMsg);
                            Unit unit10 = Unit.INSTANCE;
                        }
                        if (mGroupDetailBean != null) {
                            Integer touristSendPic = meetingRoomCustomContent.getTouristSendPic();
                            if (touristSendPic == null) {
                                touristSendPic = Boxing.boxInt(1);
                            }
                            mGroupDetailBean.setTouristSendPic(touristSendPic);
                            Unit unit11 = Unit.INSTANCE;
                        }
                        if (mGroupDetailBean != null) {
                            Integer touristMic = meetingRoomCustomContent.getTouristMic();
                            if (touristMic == null) {
                                touristMic = Boxing.boxInt(1);
                            }
                            mGroupDetailBean.setTouristMic(touristMic);
                            Unit unit12 = Unit.INSTANCE;
                        }
                        meetingRoomManager.setMGroupDetailBean(mGroupDetailBean);
                        GroupDetailBean mGroupDetailBean2 = meetingRoomManager.getMGroupDetailBean();
                        if (mGroupDetailBean2 != null) {
                            Boxing.boxBoolean(meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().updateGroupDetail(mGroupDetailBean2)));
                        }
                    }
                } else {
                    String str3 = null;
                    if (msgId != null && msgId.intValue() == 2) {
                        if (MeetingRoomManager.INSTANCE.isRoomSmall()) {
                            MainCoroutineDispatcher main = Dispatchers.getMain();
                            RoomSignaling$imRoomSignalProtocolNotification$3 roomSignaling$imRoomSignalProtocolNotification$3 = new RoomSignaling$imRoomSignalProtocolNotification$3(null);
                            roomSignaling$imRoomSignalProtocolNotification$1.label = 1;
                            if (BuildersKt.withContext(main, roomSignaling$imRoomSignalProtocolNotification$3, roomSignaling$imRoomSignalProtocolNotification$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    if (msgId.intValue() == 4) {
                        MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                        if (meetingRoomManager2.isRoomOpen()) {
                            cf.c.c().l(new RoomEvent().blockRoom());
                            Unit unit13 = Unit.INSTANCE;
                        } else {
                            meetingRoomManager2.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
                            MainCoroutineDispatcher main2 = Dispatchers.getMain();
                            RoomSignaling$imRoomSignalProtocolNotification$4 roomSignaling$imRoomSignalProtocolNotification$4 = new RoomSignaling$imRoomSignalProtocolNotification$4(null);
                            roomSignaling$imRoomSignalProtocolNotification$1.label = 2;
                            obj = BuildersKt.withContext(main2, roomSignaling$imRoomSignalProtocolNotification$4, roomSignaling$imRoomSignalProtocolNotification$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    if (msgId != null && msgId.intValue() == 6) {
                        MeetingRoomManager meetingRoomManager3 = MeetingRoomManager.INSTANCE;
                        if (meetingRoomManager3.isRoomSmall()) {
                            MeetingRoomReceiveGiftCustomContent meetingRoomReceiveGiftCustomContent = (MeetingRoomReceiveGiftCustomContent) companion.getGSON().j(meetingRoomCustomData.getContent(), MeetingRoomReceiveGiftCustomContent.class);
                            GroupDetailBean mGroupDetailBean3 = meetingRoomManager3.getMGroupDetailBean();
                            if (mGroupDetailBean3 != null) {
                                mGroupDetailBean3.setTotalConsume(Boxing.boxLong(meetingRoomReceiveGiftCustomContent.getGroupConsume()));
                                Unit unit14 = Unit.INSTANCE;
                            }
                        } else {
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "收到礼物消息IM_GIFT", false, 4, (Object) null);
                            MutableSharedFlow<RoomEvent> wsFlowGift = meetingRoomManager3.getWsFlowGift();
                            RoomEvent roomEvent = new RoomEvent();
                            String content = meetingRoomCustomData.getContent();
                            if (content != null) {
                                str2 = content;
                            }
                            Boxing.boxBoolean(wsFlowGift.tryEmit(roomEvent.receivedRoomGift(str2)));
                        }
                    }
                    if (msgId.intValue() == 14) {
                        UserStore shared2 = UserStore.INSTANCE.getShared();
                        String source2 = meetingRoomCustomData.getSource();
                        if (source2 != null) {
                            str2 = source2;
                        }
                        if (shared2.isMySelf(str2)) {
                            MainCoroutineDispatcher main3 = Dispatchers.getMain();
                            RoomSignaling$imRoomSignalProtocolNotification$5 roomSignaling$imRoomSignalProtocolNotification$5 = new RoomSignaling$imRoomSignalProtocolNotification$5(null);
                            roomSignaling$imRoomSignalProtocolNotification$1.label = 3;
                            if (BuildersKt.withContext(main3, roomSignaling$imRoomSignalProtocolNotification$5, roomSignaling$imRoomSignalProtocolNotification$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    if (msgId != null && msgId.intValue() == 15) {
                        String target = meetingRoomCustomData.getTarget();
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user != null) {
                            str3 = user.getExternalId();
                        }
                        if (Intrinsics.areEqual(target, str3)) {
                            MutableSharedFlow<RoomEvent> wsFlow = MeetingRoomManager.INSTANCE.getWsFlow();
                            RoomEvent roomEvent2 = new RoomEvent();
                            String content2 = meetingRoomCustomData.getContent();
                            if (content2 != null) {
                                str2 = content2;
                            }
                            wsFlow.tryEmit(roomEvent2.inReceiverUserInviteUpMic(str2));
                        }
                    }
                    if (msgId.intValue() == 16) {
                        UserInRoom userInRoom = (UserInRoom) companion.getGSON().j(meetingRoomCustomData.getContent(), UserInRoom.class);
                        userInRoom.setExternalId(meetingRoomCustomData.getSource());
                        MutableSharedFlow<RoomEvent> wsFlow2 = MeetingRoomManager.INSTANCE.getWsFlow();
                        RoomEvent roomEvent3 = new RoomEvent();
                        Intrinsics.checkNotNull(userInRoom);
                        wsFlow2.tryEmit(roomEvent3.hasUserInRoom(userInRoom));
                    }
                    if (msgId != null && msgId.intValue() == 19) {
                        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setEventId(216));
                    }
                    if (msgId.intValue() == 25) {
                        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setEventId(RoomEvent.ROOM_CLEAN));
                    }
                    if (msgId != null && msgId.intValue() == 20) {
                        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().setRocket((RocketRoomSmallBean) companion.getGSON().j(meetingRoomCustomData.getContent(), RocketRoomSmallBean.class)));
                    }
                    if (msgId.intValue() == 21) {
                        CurrentRoomOnlineBeanList currentRoomOnlineBeanList = (CurrentRoomOnlineBeanList) companion.getGSON().j(meetingRoomCustomData.getContent(), CurrentRoomOnlineBeanList.class);
                        MeetingRoomManager meetingRoomManager4 = MeetingRoomManager.INSTANCE;
                        if (currentRoomOnlineBeanList != null) {
                            i2 = currentRoomOnlineBeanList.getTotal();
                        } else {
                            i2 = 0;
                        }
                        meetingRoomManager4.setMRoomOnLine(i2);
                        MutableSharedFlow<RoomEvent> wsFlow3 = meetingRoomManager4.getWsFlow();
                        RoomEvent roomEvent4 = new RoomEvent();
                        Intrinsics.checkNotNull(currentRoomOnlineBeanList);
                        wsFlow3.tryEmit(roomEvent4.setCurrentUserOnline(RoomEvent.ROOM_CURRENT_USER_ONLINE, currentRoomOnlineBeanList));
                    }
                    if (msgId != null) {
                    }
                    if (msgId != null && msgId.intValue() == 27) {
                        String target2 = meetingRoomCustomData.getTarget();
                        if (target2 != null && target2.length() > 0) {
                            String target3 = meetingRoomCustomData.getTarget();
                            User user2 = UserStore.INSTANCE.getShared().getUser();
                            if (user2 != null) {
                                str3 = user2.getExternalId();
                            }
                            if (Intrinsics.areEqual(target3, str3)) {
                                MeetingRoomManager meetingRoomManager5 = MeetingRoomManager.INSTANCE;
                                String content3 = meetingRoomCustomData.getContent();
                                if (content3 != null) {
                                    str2 = content3;
                                }
                                Integer msgId2 = meetingRoomCustomData.getMsgId();
                                if (msgId2 != null && msgId2.intValue() == 22) {
                                    meetingRoomManager5.changeMicMapData(str2, z);
                                }
                                z = false;
                                meetingRoomManager5.changeMicMapData(str2, z);
                            }
                        } else {
                            MeetingRoomManager meetingRoomManager6 = MeetingRoomManager.INSTANCE;
                            String content4 = meetingRoomCustomData.getContent();
                            if (content4 != null) {
                                str2 = content4;
                            }
                            Integer msgId3 = meetingRoomCustomData.getMsgId();
                            if (msgId3 != null && msgId3.intValue() == 22) {
                                meetingRoomManager6.changeMicMapData(str2, z);
                            }
                            z = false;
                            meetingRoomManager6.changeMicMapData(str2, z);
                        }
                    }
                }
                return Unit.INSTANCE;
                return Unit.INSTANCE;
            }
        }
        roomSignaling$imRoomSignalProtocolNotification$1 = new RoomSignaling$imRoomSignalProtocolNotification$1(this, continuation);
        Object obj2 = roomSignaling$imRoomSignalProtocolNotification$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = roomSignaling$imRoomSignalProtocolNotification$1.label;
        boolean z2 = true;
        if (i == 0) {
        }
        return Unit.INSTANCE;
    }

    public final void removeRoomSignalListener() {
        V2TIMManager.getInstance().removeGroupListener(V2TIMGroupListener);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(HiloApplication.INSTANCE.getAppLifecycleScope()), (CoroutineContext) null, (CoroutineStart) null, new RoomSignaling$removeRoomSignalListener$1(null), 3, (Object) null);
    }

    public final void setV2TIMGroupListener(@NotNull V2TIMGroupListener v2TIMGroupListener) {
        Intrinsics.checkNotNullParameter(v2TIMGroupListener, "<set-?>");
        V2TIMGroupListener = v2TIMGroupListener;
    }
}
