package com.qiahao.nextvideo.room.viewmodel;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.im.TIMUserBean;
import com.qiahao.base_common.model.im.TIMUserExtBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.CreateSudData;
import com.qiahao.nextvideo.data.game.LudoCode;
import com.qiahao.nextvideo.data.game.Pk1v1End;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.data.model.AutoInviteUserUpMicBean;
import com.qiahao.nextvideo.data.model.BeanBaseBean;
import com.qiahao.nextvideo.data.model.EnterRoomData;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.InRoomBean;
import com.qiahao.nextvideo.data.model.LuckWheelInfo;
import com.qiahao.nextvideo.data.model.RocketResultBean;
import com.qiahao.nextvideo.data.model.RocketResultListBean;
import com.qiahao.nextvideo.data.model.RocketRoomSmallBean;
import com.qiahao.nextvideo.data.room.BoxData;
import com.qiahao.nextvideo.data.room.BoxGet;
import com.qiahao.nextvideo.data.room.EnvelopeData;
import com.qiahao.nextvideo.data.room.GameCategory;
import com.qiahao.nextvideo.data.room.RoomCurrentPK;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.room.RoomPKEnd;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.music.MusicStatus;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.qiahao.nextvideo.ui.task.RoomAndPersonalTaskViewModel;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatApi;
import com.tencent.qcloud.tuikit.tuichat.hilo.network.ChatServer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Î\u00012\u00020\u0001:\u0002Î\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JW\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u0003J\r\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010\u0003J%\u0010#\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00102\b\b\u0002\u0010%\u001a\u00020\r¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010%\u001a\u00020\r¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00102\b\b\u0002\u0010,\u001a\u00020\u0004¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u0010¢\u0006\u0004\b/\u0010\u0003J\r\u00100\u001a\u00020\u0010¢\u0006\u0004\b0\u0010\u0003J\r\u00101\u001a\u00020\u0010¢\u0006\u0004\b1\u0010\u0003J\u0015\u00103\u001a\u00020\u00102\u0006\u00102\u001a\u00020\r¢\u0006\u0004\b3\u0010'J-\u00107\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00106\u001a\u00020\r¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u0006¢\u0006\u0004\b:\u0010;J\u001f\u0010=\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\r¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0004¢\u0006\u0004\b?\u0010.J\u0015\u0010@\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0004¢\u0006\u0004\b@\u0010.J\u0015\u0010A\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0004¢\u0006\u0004\bA\u0010.J\u0015\u0010B\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0004¢\u0006\u0004\bB\u0010.J\u0015\u0010C\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0004¢\u0006\u0004\bC\u0010.J=\u0010K\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u00042\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u00042\u0016\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u00060Hj\b\u0012\u0004\u0012\u00020\u0006`I¢\u0006\u0004\bK\u0010LJ\u0015\u0010M\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0004¢\u0006\u0004\bM\u0010.J\r\u0010N\u001a\u00020\u0010¢\u0006\u0004\bN\u0010\u0003J\r\u0010O\u001a\u00020\u0010¢\u0006\u0004\bO\u0010\u0003J\u0015\u0010Q\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\r¢\u0006\u0004\bQ\u0010'J\r\u0010R\u001a\u00020\u0010¢\u0006\u0004\bR\u0010\u0003J\r\u0010S\u001a\u00020\u0010¢\u0006\u0004\bS\u0010\u0003J\u0017\u0010U\u001a\u00020\u00102\b\b\u0002\u0010T\u001a\u00020\r¢\u0006\u0004\bU\u0010'J\u0015\u0010W\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\u0006¢\u0006\u0004\bW\u0010;J\r\u0010X\u001a\u00020\u0010¢\u0006\u0004\bX\u0010\u0003J!\u0010\\\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010Y¢\u0006\u0004\b\\\u0010]J^\u0010i\u001a\u00020\u00102\u0006\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010a2%\b\u0002\u0010h\u001a\u001f\u0012\u0013\u0012\u00110d¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u0010\u0018\u00010c¢\u0006\u0004\bi\u0010jJP\u0010l\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020k2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010a2'\b\u0002\u0010h\u001a!\u0012\u0015\u0012\u0013\u0018\u00010d¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u0010\u0018\u00010c¢\u0006\u0004\bl\u0010mJ1\u0010n\u001a\u00020\u00102\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010a2\u0010\b\u0002\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010a¢\u0006\u0004\bn\u0010oJ\r\u0010p\u001a\u00020\u0010¢\u0006\u0004\bp\u0010\u0003J#\u0010r\u001a\u00020\u00102\b\b\u0002\u0010q\u001a\u00020\u00042\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\br\u0010sJ%\u0010u\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u00062\u0006\u0010_\u001a\u00020\u0004¢\u0006\u0004\bu\u0010vJ+\u0010x\u001a\u00020\u00102\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010a2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bx\u0010yJ\r\u0010z\u001a\u00020\u0010¢\u0006\u0004\bz\u0010\u0003J\r\u0010{\u001a\u00020\u0010¢\u0006\u0004\b{\u0010\u0003J\r\u0010|\u001a\u00020\u0010¢\u0006\u0004\b|\u0010\u0003J\u0015\u0010}\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\u0006¢\u0006\u0004\b}\u0010;J\u0015\u0010\u007f\u001a\u00020\u00102\u0006\u0010~\u001a\u00020\u0004¢\u0006\u0004\b\u007f\u0010.J\u000f\u0010\u0080\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u0080\u0001\u0010\u0003J\u000f\u0010\u0081\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u0081\u0001\u0010\u0003J\u000f\u0010\u0082\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u0082\u0001\u0010\u0003JB\u0010\u0085\u0001\u001a\u00020\u00102\u0007\u0010\u0083\u0001\u001a\u00020\u00062\u0011\b\u0002\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010a2\u0014\u0010h\u001a\u0010\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020\u0010\u0018\u00010c¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J/\u0010\u0088\u0001\u001a\u00020\u00102\u0007\u0010\u0087\u0001\u001a\u00020^2\u0014\u0010h\u001a\u0010\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020\u0010\u0018\u00010c¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J*\u0010\u008b\u0001\u001a\u00020\u00102\u0018\b\u0002\u0010\u0084\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u008a\u0001\u0012\u0004\u0012\u00020\u0010\u0018\u00010c¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u000f\u0010\u008d\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u008d\u0001\u0010\u0003R(\u0010\u008e\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0005\b\u0092\u0001\u0010;R1\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R0\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u0096\u0001\u001a\u0006\b\u009c\u0001\u0010\u0098\u0001\"\u0006\b\u009d\u0001\u0010\u009a\u0001R=\u0010\u009f\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u009e\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010\u0096\u0001\u001a\u0006\b \u0001\u0010\u0098\u0001\"\u0006\b¡\u0001\u0010\u009a\u0001R1\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¢\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0001\u0010\u0096\u0001\u001a\u0006\b¤\u0001\u0010\u0098\u0001\"\u0006\b¥\u0001\u0010\u009a\u0001R7\u0010§\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¦\u00010Y0\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010\u0096\u0001\u001a\u0006\b¨\u0001\u0010\u0098\u0001\"\u0006\b©\u0001\u0010\u009a\u0001R0\u0010ª\u0001\u001a\t\u0012\u0004\u0012\u00020(0\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010\u0096\u0001\u001a\u0006\b«\u0001\u0010\u0098\u0001\"\u0006\b¬\u0001\u0010\u009a\u0001R0\u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0001\u0010\u0096\u0001\u001a\u0006\b®\u0001\u0010\u0098\u0001\"\u0006\b¯\u0001\u0010\u009a\u0001R0\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b°\u0001\u0010\u0096\u0001\u001a\u0006\b°\u0001\u0010\u0098\u0001\"\u0006\b±\u0001\u0010\u009a\u0001R$\u0010³\u0001\u001a\n\u0012\u0005\u0012\u00030²\u00010\u0093\u00018\u0006¢\u0006\u0010\n\u0006\b³\u0001\u0010\u0096\u0001\u001a\u0006\b´\u0001\u0010\u0098\u0001R0\u0010µ\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010\u0096\u0001\u001a\u0006\b¶\u0001\u0010\u0098\u0001\"\u0006\b·\u0001\u0010\u009a\u0001RB\u0010¹\u0001\u001a\u001b\u0012\u0016\u0012\u0014\u0012\u0005\u0012\u00030¸\u00010Hj\t\u0012\u0005\u0012\u00030¸\u0001`I0\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010\u0096\u0001\u001a\u0006\bº\u0001\u0010\u0098\u0001\"\u0006\b»\u0001\u0010\u009a\u0001R7\u0010½\u0001\u001a\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¼\u00010Y0\u009e\u00010\u0093\u00018\u0006¢\u0006\u0010\n\u0006\b½\u0001\u0010\u0096\u0001\u001a\u0006\b¾\u0001\u0010\u0098\u0001R3\u0010À\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010¿\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÀ\u0001\u0010\u0096\u0001\u001a\u0006\bÁ\u0001\u0010\u0098\u0001\"\u0006\bÂ\u0001\u0010\u009a\u0001R(\u0010Ã\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÃ\u0001\u0010\u008f\u0001\u001a\u0006\bÄ\u0001\u0010\u0091\u0001\"\u0005\bÅ\u0001\u0010;R;\u0010È\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00060Æ\u0001j\t\u0012\u0004\u0012\u00020\u0006`Ç\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001¨\u0006Ï\u0001"}, d2 = {"Lcom/qiahao/nextvideo/room/viewmodel/RoomViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "", "sceneType", "", "sceneUid", "password", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "callBack", "gameType", "gameCode", "", "is1V1", "gameMode", "", "joinRoomNetRequest", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/imsdk/v2/V2TIMCallback;ILjava/lang/String;ZI)V", "Lcom/qiahao/nextvideo/data/model/EnterRoomData;", "data", "initRoomBaseKeyValue", "(Lcom/qiahao/nextvideo/data/model/EnterRoomData;)V", "joinChannel", "(Lcom/tencent/imsdk/v2/V2TIMCallback;Lcom/qiahao/nextvideo/data/model/EnterRoomData;)V", "token", "channelId", "agoraId", "provider", "(Ljava/lang/String;Ljava/lang/String;II)V", "getRoomInfo", "getRoomRole", "autoRestart", "selfJoin", "lastId", "createLuckyWheel", "(ZZI)V", "isCreateGame", "refreshLuckLyDialog", "(Z)V", "Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "luckWheelInfo", "updateLuckyWheelInfo", "(Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;Z)V", "isInvite", "acceptInvite", "(I)V", "closeLuckyDialog", "joinRoomLuckWheel", "playLuckWheel", "isMute", "setRemoteAllMute", "micIndex", "micType", "micForbid", "upMic", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", TUIConstants.TUILive.USER_ID, "inviteUserUpMic", "(Ljava/lang/String;)V", "isKick", "downMic", "(IZ)V", "lockMic", "unlockMic", "muteMic", "unMuteByIndex", "muteByIndex", "sendType", "Lcom/qiahao/base_common/model/GiftData;", "selectedGiftItem", FamilySettingFragment.FAMILY_NUMBER, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "extraIdList", "sendGift", "(ILcom/qiahao/base_common/model/GiftData;ILjava/util/ArrayList;)V", "unMuteMic", "enterRoomCheckAutoInviteUpMicDialog", "getRocketEnterData", "isFirstIn", "getRocketSvgaCountDown", "getRoomBanner", "toGameDice", "needFetchLeaveRoom", "leaveRoom", "groupId", "getGameList", "smallRoom", "", "Lcom/qiahao/base_common/model/im/TIMUserBean;", "mentionUsers", "initUserImExtBean", "(Ljava/util/List;)Ljava/lang/String;", "", GameMatchActivity.GAME_ID, "opt", "Lkotlin/Function0;", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "e", "onError", "sudGameReport", "(JILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "createSudGame", "(Lcom/qiahao/nextvideo/data/game/CreateSudData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getSudCode", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cleanMessage", "gameID", "requestMatchGame", "(ILjava/lang/String;)V", "matchId", "roomMatchGameJoin", "(ILjava/lang/String;I)V", "isSmall", "requestNewToken", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;)V", "requestBoxList", "getPKBox", "getPKStatus", "getDiamondGameList", "type", "changeOtherRoomMic", "youTuBeProcess", "startYouTuBe", "exitYouTuBe", "videoUrl", "listener", "addVideoMyRoom", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", AgooConstants.MESSAGE_ID, "getEnvelopeInfo", "(JLkotlin/jvm/functions/Function1;)V", "Lcom/qiahao/nextvideo/data/game/Pk1v1End;", "pk1v1", "(Lkotlin/jvm/functions/Function1;)V", "exitHiloGameModel", "mGroupId", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "Lma/b;", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "mGroupDetailBean", "Lma/b;", "getMGroupDetailBean", "()Lma/b;", "setMGroupDetailBean", "(Lma/b;)V", "mGetRoomMicType", "getMGetRoomMicType", "setMGetRoomMicType", "Lkotlin/Pair;", "mMicOperationResponse", "getMMicOperationResponse", "setMMicOperationResponse", "Lcom/qiahao/nextvideo/data/model/AutoInviteUserUpMicBean;", "mEnterRoomAutoUpMicBean", "getMEnterRoomAutoUpMicBean", "setMEnterRoomAutoUpMicBean", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "mBannerList", "getMBannerList", "setMBannerList", "mRoomLuckWheelInfo", "getMRoomLuckWheelInfo", "setMRoomLuckWheelInfo", "mRoomShowSelectLuckWheelDialog", "getMRoomShowSelectLuckWheelDialog", "setMRoomShowSelectLuckWheelDialog", "isEnterRoomBoolean", "setEnterRoomBoolean", "Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;", "mRocketRoomSmallBean", "getMRocketRoomSmallBean", "mRoomPasswordError", "getMRoomPasswordError", "setMRoomPasswordError", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "mDiamondGameList", "getMDiamondGameList", "setMDiamondGameList", "Lcom/qiahao/nextvideo/data/model/RocketResultBean;", "mRocketResultSvgaBean", "getMRocketResultSvgaBean", "Lcom/qiahao/nextvideo/data/room/BoxData;", "mRoomPKBox", "getMRoomPKBox", "setMRoomPKBox", "mGameCode", "getMGameCode", "setMGameCode", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mRocketResultList", "Ljava/util/HashSet;", "getMRocketResultList", "()Ljava/util/HashSet;", "setMRocketResultList", "(Ljava/util/HashSet;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomViewModel.kt\ncom/qiahao/nextvideo/room/viewmodel/RoomViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1311:1\n1#2:1312\n1869#3,2:1313\n1869#3:1315\n1869#3,2:1316\n1870#3:1318\n*S KotlinDebug\n*F\n+ 1 RoomViewModel.kt\ncom/qiahao/nextvideo/room/viewmodel/RoomViewModel\n*L\n808#1:1313,2\n873#1:1315\n875#1:1316,2\n873#1:1318\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomViewModel extends BaseViewModel {

    @NotNull
    public static final String INTERFACE_DELETE_MESSAGE = "delete_message";

    @NotNull
    public static final String INTERFACE_DOWN_MIC = "down_mic";

    @NotNull
    public static final String INTERFACE_ENTER_ROOM = "enter_room";

    @NotNull
    public static final String INTERFACE_JOIN_ROOM = "join_room";

    @NotNull
    public static final String INTERFACE_LOCK_MIC = "lock_mic";

    @NotNull
    public static final String INTERFACE_MUTE_MIC = "mute_mic";

    @NotNull
    public static final String INTERFACE_SEND_GIFT = "send_gift";

    @NotNull
    public static final String INTERFACE_UN_LOCK_MIC = "un_lock_mic";

    @NotNull
    public static final String INTERFACE_UN_MUTE_MIC = "un_mute_mic";

    @NotNull
    public static final String INTERFACE_UP_MIC = "up_mic";

    @NotNull
    public static final String MIC_CREATE_BACKGAMMON = "mic_create_backgammon";

    @NotNull
    public static final String MIC_CREATE_BALOOT = "mic_create_baloot";

    @NotNull
    public static final String MIC_CREATE_CARROM = "mic_create_carrom";

    @NotNull
    public static final String MIC_CREATE_CRUSH = "mic_create_crush";

    @NotNull
    public static final String MIC_CREATE_DOMINO = "mic_create_domino";

    @NotNull
    public static final String MIC_CREATE_JACKAROO = "mic_create_jackaroo";

    @NotNull
    public static final String MIC_CREATE_LUDO = "mic_create_ludo";

    @NotNull
    public static final String MIC_CREATE_UNO = "mic_create_uno";

    @NotNull
    public static final String MIC_JOIN_BACKGAMMON = "mic_join_backgammon";

    @NotNull
    public static final String MIC_JOIN_BALOOT = "mic_join_baloot";

    @NotNull
    public static final String MIC_JOIN_CARROM = "mic_join_carrom";

    @NotNull
    public static final String MIC_JOIN_CRUSH = "mic_join_crush";

    @NotNull
    public static final String MIC_JOIN_DOMINO = "mic_join_domino";

    @NotNull
    public static final String MIC_JOIN_JACKAROO = "mic_join_jackaroo";

    @NotNull
    public static final String MIC_JOIN_LUDO = "mic_join_ludo";

    @NotNull
    public static final String MIC_JOIN_UNO = "mic_join_uno";

    @NotNull
    public static final String TAG = "RoomViewModel";

    @NotNull
    private String mGroupId = "";

    @NotNull
    private ma.b mGroupDetailBean = new ma.b();

    @NotNull
    private ma.b mGetRoomMicType = new ma.b();

    @NotNull
    private ma.b mMicOperationResponse = new ma.b();

    @NotNull
    private ma.b mEnterRoomAutoUpMicBean = new ma.b();

    @NotNull
    private ma.b mBannerList = new ma.b();

    @NotNull
    private ma.b mRoomLuckWheelInfo = new ma.b();

    @NotNull
    private ma.b mRoomShowSelectLuckWheelDialog = new ma.b();

    @NotNull
    private ma.b isEnterRoomBoolean = new ma.b();

    @NotNull
    private final ma.b mRocketRoomSmallBean = new ma.b();

    @NotNull
    private ma.b mRoomPasswordError = new ma.b();

    @NotNull
    private ma.b mDiamondGameList = new ma.b();

    @NotNull
    private final ma.b mRocketResultSvgaBean = new ma.b();

    @NotNull
    private ma.b mRoomPKBox = new ma.b();

    @NotNull
    private String mGameCode = "";

    @NotNull
    private HashSet<String> mRocketResultList = new HashSet<>();

    public static /* synthetic */ void acceptInvite$default(RoomViewModel roomViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        roomViewModel.acceptInvite(i);
    }

    public static final Unit acceptInvite$lambda$15(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131954176), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        roomViewModel.getRoomInfo();
        return Unit.INSTANCE;
    }

    public static final Unit acceptInvite$lambda$16(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().postValue(new Pair(INTERFACE_JOIN_ROOM, th));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addVideoMyRoom$default(RoomViewModel roomViewModel, String str, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        roomViewModel.addVideoMyRoom(str, function0, function1);
    }

    public static final Unit addVideoMyRoom$lambda$103(Function0 function0, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final Unit addVideoMyRoom$lambda$104(Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function1 != null) {
            function1.invoke(th);
        }
        return Unit.INSTANCE;
    }

    public static final Unit changeOtherRoomMic$lambda$95(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    public static final Unit changeOtherRoomMic$lambda$96(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit cleanMessage$lambda$75(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public static final Unit cleanMessage$lambda$76(RoomViewModel roomViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(roomViewModel, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit closeLuckyDialog$lambda$17(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            MeetingRoomManager.INSTANCE.setMRoomLuckWheelInfo(null);
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131954176), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Log.d(TAG, "closeLuckyDialog: " + apiResponse.getMessage());
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit closeLuckyDialog$lambda$18(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "closeLuckyDialog: 权限不够！！！");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public static final Unit createLuckyWheel$lambda$10(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        n5.e.c("LucklyWheel create: 创建轮盘游戏成功");
        return Unit.INSTANCE;
    }

    public static final Unit createLuckyWheel$lambda$11(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        n5.e.c("LucklyWheel create: 创建轮盘游戏失败");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void createSudGame$default(RoomViewModel roomViewModel, CreateSudData createSudData, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        roomViewModel.createSudGame(createSudData, function0, function1);
    }

    public static final Unit createSudGame$lambda$71(CreateSudData createSudData, RoomViewModel roomViewModel, final Function0 function0, final Function1 function1, final ApiResponse apiResponse) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "ludoCode");
        ServerApi apis = AppServer.INSTANCE.getApis();
        Integer gameType = createSudData.getGameType();
        if (gameType != null) {
            i = gameType.intValue();
        } else {
            i = 0;
        }
        int mode = createSudData.getMode();
        int piece = createSudData.getPiece();
        int onOff1 = createSudData.getOnOff1();
        int diamond = createSudData.getDiamond();
        int autoMatch = createSudData.getAutoMatch();
        String groupId = createSudData.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        LudoCode ludoCode = (LudoCode) apiResponse.getData();
        if (ludoCode == null || (str = ludoCode.getCode()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.createSud(i, mode, piece, onOff1, diamond, autoMatch, groupId, str), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.w2
            public final Object invoke(Object obj) {
                Unit createSudGame$lambda$71$lambda$69;
                createSudGame$lambda$71$lambda$69 = RoomViewModel.createSudGame$lambda$71$lambda$69(RoomViewModel.this, apiResponse, function0, (ApiResponse) obj);
                return createSudGame$lambda$71$lambda$69;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.x2
            public final Object invoke(Object obj) {
                Unit createSudGame$lambda$71$lambda$70;
                createSudGame$lambda$71$lambda$70 = RoomViewModel.createSudGame$lambda$71$lambda$70(function1, (Throwable) obj);
                return createSudGame$lambda$71$lambda$70;
            }
        }, (Function0) null, false, 12, (Object) null), roomViewModel.getMCompositeDisposable());
        return Unit.INSTANCE;
    }

    public static final Unit createSudGame$lambda$71$lambda$69(RoomViewModel roomViewModel, ApiResponse apiResponse, Function0 function0, ApiResponse apiResponse2) {
        double d;
        String str;
        Intrinsics.checkNotNullParameter(apiResponse2, "it");
        BeanBaseBean beanBaseBean = (BeanBaseBean) apiResponse2.getData();
        double d2 = 0.0d;
        if (beanBaseBean != null) {
            d = beanBaseBean.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (d >= 0.0d) {
            UserStore shared = UserStore.INSTANCE.getShared();
            BeanBaseBean beanBaseBean2 = (BeanBaseBean) apiResponse2.getData();
            if (beanBaseBean2 != null) {
                d2 = beanBaseBean2.getDiamondNum();
            }
            UserStore.refreshDiamondOrGem$default(shared, d2, 0.0d, 2, null);
        }
        LudoCode ludoCode = (LudoCode) apiResponse.getData();
        if (ludoCode == null || (str = ludoCode.getCode()) == null) {
            str = "";
        }
        roomViewModel.mGameCode = str;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final Unit createSudGame$lambda$71$lambda$70(Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function1 != null) {
            function1.invoke(th);
        }
        return Unit.INSTANCE;
    }

    public static final Unit createSudGame$lambda$72(Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function1 != null) {
            function1.invoke(th);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void downMic$default(RoomViewModel roomViewModel, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        roomViewModel.downMic(i, z);
    }

    public static final Unit downMic$lambda$27(RoomViewModel roomViewModel, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            ma.b bVar = roomViewModel.mMicOperationResponse;
            String message = apiResponse.getMessage();
            if (message == null) {
                message = "ok";
            }
            bVar.setValue(new Pair(INTERFACE_DOWN_MIC, message));
            if (!z) {
                HiloRtcEngine.INSTANCE.setClientRole(2);
                MeetingRoomManager.INSTANCE.getMusicManager().q();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit downMic$lambda$28(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(INTERFACE_DOWN_MIC, th));
        return Unit.INSTANCE;
    }

    public static final Unit enterRoomCheckAutoInviteUpMicDialog$lambda$48(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        AutoInviteUserUpMicBean autoInviteUserUpMicBean = (AutoInviteUserUpMicBean) apiResponse.getData();
        if (autoInviteUserUpMicBean != null && autoInviteUserUpMicBean.getFlag()) {
            roomViewModel.mEnterRoomAutoUpMicBean.setValue(autoInviteUserUpMicBean);
            Log.d(TAG, "enterRoomCheckAutoInviteUpMicDialog:" + autoInviteUserUpMicBean.getFlag());
        }
        return Unit.INSTANCE;
    }

    public static final Unit enterRoomCheckAutoInviteUpMicDialog$lambda$49(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "enterRoomCheckAutoInviteUpMicDialog:" + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    public static final Unit exitHiloGameModel$lambda$110(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    public static final Unit exitHiloGameModel$lambda$111(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit exitYouTuBe$lambda$101(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    public static final Unit exitYouTuBe$lambda$102(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit getDiamondGameList$lambda$93(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null) {
            roomViewModel.mDiamondGameList.setValue(arrayList);
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "DIAMOND_GAME_LIST", BaseApplication.Companion.getGSON().s(arrayList), (String) null, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public static final Unit getDiamondGameList$lambda$94(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit getEnvelopeInfo$lambda$105(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MeetingRoomManager.INSTANCE.setMEnvelopeData((EnvelopeData) apiResponse.getData());
        cf.c.c().l(new LiveEvent("click_envelope", (Object) null, 2, (DefaultConstructorMarker) null));
        return Unit.INSTANCE;
    }

    public static final Unit getEnvelopeInfo$lambda$106(Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function1 != null) {
            function1.invoke(th);
        }
        return Unit.INSTANCE;
    }

    public static final Unit getGameList$lambda$64(ApiResponse apiResponse) {
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "game_party_list", "", (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "game_lucky_list", "", (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "game_together_list", "", (String) null, 4, (Object) null);
        List<GameCategory> list = (List) apiResponse.getData();
        if (list != null) {
            for (GameCategory gameCategory : list) {
                ArrayList arrayList = new ArrayList();
                List<GameConfiguration> gameList = gameCategory.getGameList();
                if (gameList != null) {
                    for (GameConfiguration gameConfiguration : gameList) {
                        Integer gameType = gameConfiguration.getGameType();
                        if (gameType != null) {
                            i = gameType.intValue();
                        } else {
                            i = 0;
                        }
                        if (i <= 23) {
                            arrayList.add(gameConfiguration);
                        }
                    }
                }
                Integer category = gameCategory.getCategory();
                if (category != null && category.intValue() == 1) {
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "game_party_list", BaseApplication.Companion.getGSON().s(arrayList), (String) null, 4, (Object) null);
                } else {
                    Integer category2 = gameCategory.getCategory();
                    if (category2 != null && category2.intValue() == 2) {
                        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "game_lucky_list", BaseApplication.Companion.getGSON().s(arrayList), (String) null, 4, (Object) null);
                    } else {
                        Integer category3 = gameCategory.getCategory();
                        if (category3 != null && category3.intValue() == 3) {
                            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "game_together_list", BaseApplication.Companion.getGSON().s(arrayList), (String) null, 4, (Object) null);
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit getGameList$lambda$65(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit getPKBox$lambda$88(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        int i;
        BoxData boxData;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BoxGet boxGet = (BoxGet) apiResponse.getData();
        if (boxGet != null) {
            ArrayList<BoxData> list = boxGet.getList();
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            if (i > 0) {
                ma.b bVar = roomViewModel.mRoomPKBox;
                ArrayList<BoxData> list2 = boxGet.getList();
                if (list2 != null) {
                    boxData = list2.get(0);
                } else {
                    boxData = null;
                }
                bVar.setValue(boxData);
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit getPKBox$lambda$89(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit getPKStatus$lambda$90(ApiResponse apiResponse) {
        RoomPKEnd roomPKEnd;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        RoomCurrentPK roomCurrentPK = (RoomCurrentPK) apiResponse.getData();
        if (roomCurrentPK != null && roomCurrentPK.getStatus() == 2) {
            MutableSharedFlow<RoomEvent> wsFlow = MeetingRoomManager.INSTANCE.getWsFlow();
            RoomEvent roomEvent = new RoomEvent();
            RoomCurrentPK roomCurrentPK2 = (RoomCurrentPK) apiResponse.getData();
            if (roomCurrentPK2 != null) {
                roomPKEnd = roomCurrentPK2.getGroupPkFinish();
            } else {
                roomPKEnd = null;
            }
            wsFlow.tryEmit(roomEvent.roomEvent(RoomEvent.ROOM_PK_END, roomPKEnd));
        }
        return Unit.INSTANCE;
    }

    public static final Unit getPKStatus$lambda$91(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit getRocketEnterData$lambda$51(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Log.d(TAG, " getRocketEnterData getRoomRocketSmallData: onSuccess");
        RocketRoomSmallBean rocketRoomSmallBean = (RocketRoomSmallBean) apiResponse.getData();
        if (rocketRoomSmallBean != null) {
            roomViewModel.mRocketRoomSmallBean.setValue(rocketRoomSmallBean);
        }
        return Unit.INSTANCE;
    }

    public static final Unit getRocketEnterData$lambda$52(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "getRocketEnterData getRoomRocketSmallData:" + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    public static final Unit getRocketSvgaCountDown$lambda$55(RoomViewModel roomViewModel, boolean z, ApiResponse apiResponse) {
        List<RocketResultBean> rockets;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = new ArrayList();
        RocketResultListBean rocketResultListBean = (RocketResultListBean) apiResponse.getData();
        if (rocketResultListBean != null && (rockets = rocketResultListBean.getRockets()) != null) {
            for (RocketResultBean rocketResultBean : rockets) {
                if (!CollectionsKt.contains(roomViewModel.mRocketResultList, rocketResultBean.getId())) {
                    HashSet<String> hashSet = roomViewModel.mRocketResultList;
                    String id2 = rocketResultBean.getId();
                    if (id2 == null) {
                        id2 = "";
                    }
                    hashSet.add(id2);
                    arrayList.add(rocketResultBean);
                }
            }
        }
        roomViewModel.mRocketResultSvgaBean.setValue(new Pair(Boolean.valueOf(z), arrayList));
        return Unit.INSTANCE;
    }

    public static final Unit getRocketSvgaCountDown$lambda$56(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "getRocketEnterData getRoomRocketSmallData:" + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    public static final Unit getRoomBanner$lambda$58(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            roomViewModel.mBannerList.postValue(list);
        }
        return Unit.INSTANCE;
    }

    public static final Unit getRoomBanner$lambda$59(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit getRoomInfo$lambda$8(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        int i;
        RoomPK mpk;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GroupDetailBean groupDetailBean = (GroupDetailBean) apiResponse.getData();
        if (groupDetailBean != null) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            Integer micNumType = groupDetailBean.getMicNumType();
            if (micNumType != null) {
                i = micNumType.intValue();
            } else {
                i = 0;
            }
            meetingRoomManager.setMCurrentRoomMicType(i);
            RoomPK mpk2 = meetingRoomManager.getMPK();
            if (mpk2 != null && mpk2.getStatus() == 0 && (mpk = meetingRoomManager.getMPK()) != null) {
                mpk.setInviteGroup(groupDetailBean);
            }
            meetingRoomManager.setGroupDetailBean(groupDetailBean);
            roomViewModel.mGroupDetailBean.setValue(groupDetailBean);
        }
        return Unit.INSTANCE;
    }

    public static final Unit getRoomInfo$lambda$9(Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        String message = th.getMessage();
        if (message == null) {
            str = th.getLocalizedMessage();
        } else {
            str = message;
        }
        Intrinsics.checkNotNull(str);
        Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void getSudCode$default(RoomViewModel roomViewModel, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        roomViewModel.getSudCode(function0, function02);
    }

    public static final Unit getSudCode$lambda$73(RoomViewModel roomViewModel, Function0 function0, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "sudCode");
        LudoCode ludoCode = (LudoCode) apiResponse.getData();
        if (ludoCode == null || (str = ludoCode.getCode()) == null) {
            str = "";
        }
        roomViewModel.mGameCode = str;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final Unit getSudCode$lambda$74(Function0 function0, RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function0 != null) {
            function0.invoke();
        }
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(roomViewModel, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String initUserImExtBean$default(RoomViewModel roomViewModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return roomViewModel.initUserImExtBean(list);
    }

    public static final Unit inviteUserUpMic$lambda$25(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            Log.d(TAG, "inviteUserUpMic: 邀请用户上麦成功!!!");
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131953144), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit inviteUserUpMic$lambda$26(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(RoomAndPersonalTaskViewModel.COMMON_TIP, th));
        return Unit.INSTANCE;
    }

    public static final Unit joinChannel$lambda$1$lambda$0(RoomViewModel roomViewModel, V2TIMCallback v2TIMCallback, int i, boolean z) {
        if (i == 152) {
            MeetingRoomManager.INSTANCE.imJoinGroup(roomViewModel.mGroupId, v2TIMCallback);
        }
        return Unit.INSTANCE;
    }

    public static final Unit joinRoomLuckWheel$lambda$19(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    public static final Unit joinRoomLuckWheel$lambda$20(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (((HiloException) th).getCode() == 16003) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131953167), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void joinRoomNetRequest(int sceneType, String sceneUid, String password, final V2TIMCallback callBack, int gameType, String gameCode, boolean is1V1, int gameMode) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().inRoom(this.mGroupId, sceneType, sceneUid, password, gameType, gameCode, is1V1, gameMode), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.r2
            public final Object invoke(Object obj) {
                Unit joinRoomNetRequest$lambda$5;
                joinRoomNetRequest$lambda$5 = RoomViewModel.joinRoomNetRequest$lambda$5(RoomViewModel.this, callBack, (ApiResponse) obj);
                return joinRoomNetRequest$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.t2
            public final Object invoke(Object obj) {
                Unit joinRoomNetRequest$lambda$6;
                joinRoomNetRequest$lambda$6 = RoomViewModel.joinRoomNetRequest$lambda$6(RoomViewModel.this, (Throwable) obj);
                return joinRoomNetRequest$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    static /* synthetic */ void joinRoomNetRequest$default(RoomViewModel roomViewModel, int i, String str, String str2, V2TIMCallback v2TIMCallback, int i2, String str3, boolean z, int i3, int i4, Object obj) {
        int i5;
        String str4;
        boolean z2;
        int i6;
        if ((i4 & 16) != 0) {
            i5 = 0;
        } else {
            i5 = i2;
        }
        if ((i4 & 32) != 0) {
            str4 = "";
        } else {
            str4 = str3;
        }
        if ((i4 & 64) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i4 & 128) != 0) {
            i6 = 0;
        } else {
            i6 = i3;
        }
        roomViewModel.joinRoomNetRequest(i, str, str2, v2TIMCallback, i5, str4, z2, i6);
    }

    public static final Unit joinRoomNetRequest$lambda$5(RoomViewModel roomViewModel, final V2TIMCallback v2TIMCallback, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        InRoomBean inRoomBean = (InRoomBean) apiResponse.getData();
        if (inRoomBean != null) {
            roomViewModel.mGetRoomMicType.setValue(Integer.valueOf(inRoomBean.getMicNumType()));
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            meetingRoomManager.setMRoomChannelId(inRoomBean.getChannelId());
            meetingRoomManager.setMAgoraToken(inRoomBean.getToken());
            meetingRoomManager.setMAgoraId(inRoomBean.getAgoraId());
            meetingRoomManager.setMProvider(inRoomBean.getProvider());
            meetingRoomManager.setMPK(inRoomBean.getGroupPk());
            roomViewModel.joinChannel(inRoomBean.getToken(), inRoomBean.getChannelId(), inRoomBean.getAgoraId(), inRoomBean.getProvider());
            meetingRoomManager.setMCurrentRoomMicType(inRoomBean.getMicNumType());
            meetingRoomManager.emptyMicInit(meetingRoomManager.getMicSize(inRoomBean.getMicNumType()));
            WebSocketProvide.roomWebSocket$default(WebSocketProvide.INSTANCE, 152, roomViewModel.mGroupId, null, new Function2() { // from class: com.qiahao.nextvideo.room.viewmodel.s3
                public final Object invoke(Object obj, Object obj2) {
                    Unit joinRoomNetRequest$lambda$5$lambda$4$lambda$3;
                    joinRoomNetRequest$lambda$5$lambda$4$lambda$3 = RoomViewModel.joinRoomNetRequest$lambda$5$lambda$4$lambda$3(RoomViewModel.this, v2TIMCallback, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                    return joinRoomNetRequest$lambda$5$lambda$4$lambda$3;
                }
            }, 4, null);
            roomViewModel.getRoomInfo();
            GroupService.INSTANCE.getMGroupEventProcessorObservable().onNext(new GroupEvent().enterRoom(meetingRoomManager.getMGroupId()));
            roomViewModel.isEnterRoomBoolean.setValue(Boolean.TRUE);
        }
        return Unit.INSTANCE;
    }

    public static final Unit joinRoomNetRequest$lambda$5$lambda$4$lambda$3(RoomViewModel roomViewModel, V2TIMCallback v2TIMCallback, int i, boolean z) {
        if (i == 152) {
            MeetingRoomManager.INSTANCE.imJoinGroup(roomViewModel.mGroupId, v2TIMCallback);
        }
        return Unit.INSTANCE;
    }

    public static final Unit joinRoomNetRequest$lambda$6(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 14003) {
                if (code != 14005) {
                    if (code != 14007) {
                        if (code != 14011) {
                            HiloToasty.Companion companion = HiloToasty.Companion;
                            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                            String errorMessage = hiloException.getErrorMessage();
                            if (errorMessage == null) {
                                errorMessage = ResourcesKtxKt.getStringById(roomViewModel, 2131952667);
                            }
                            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, errorMessage, false, 4, (Object) null);
                            if (normal$default != null) {
                                normal$default.show();
                            }
                        } else {
                            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952976), false, 4, (Object) null);
                            if (normal$default2 != null) {
                                normal$default2.show();
                            }
                        }
                    } else {
                        HiloToasty.Companion companion2 = HiloToasty.Companion;
                        Activity currentActivity2 = ActivityLifecycleManager.INSTANCE.currentActivity();
                        String format = String.format(ResourcesKtxKt.getStringById(roomViewModel, 2131952985), Arrays.copyOf(new Object[]{AgooConstants.ACK_REMOVE_PACKAGE}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        Toast normal$default3 = HiloToasty.Companion.normal$default(companion2, currentActivity2, format, false, 4, (Object) null);
                        if (normal$default3 != null) {
                            normal$default3.show();
                        }
                    }
                } else {
                    Toast normal = HiloToasty.Companion.normal(ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952092), false);
                    if (normal != null) {
                        normal.show();
                    }
                }
            } else {
                roomViewModel.mRoomPasswordError.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            }
        } else {
            HiloToasty.Companion companion3 = HiloToasty.Companion;
            Activity currentActivity3 = ActivityLifecycleManager.INSTANCE.currentActivity();
            String message = th.getMessage();
            if (message == null) {
                message = ResourcesKtxKt.getStringById(roomViewModel, 2131952667);
            }
            Toast normal$default4 = HiloToasty.Companion.normal$default(companion3, currentActivity3, message, false, 4, (Object) null);
            if (normal$default4 != null) {
                normal$default4.show();
            }
        }
        roomViewModel.mGroupId = "";
        roomViewModel.getMException().setValue(new Pair(INTERFACE_ENTER_ROOM, th));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void leaveRoom$default(RoomViewModel roomViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        roomViewModel.leaveRoom(z);
    }

    public static final Unit lockMic$lambda$29(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            ma.b bVar = roomViewModel.mMicOperationResponse;
            String message = apiResponse.getMessage();
            if (message == null) {
                message = "ok";
            }
            bVar.setValue(new Pair(INTERFACE_LOCK_MIC, message));
        }
        return Unit.INSTANCE;
    }

    public static final Unit lockMic$lambda$30(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(INTERFACE_LOCK_MIC, th));
        return Unit.INSTANCE;
    }

    public static final Unit muteByIndex$lambda$37(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public static final Unit muteByIndex$lambda$38(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public static final Unit muteMic$lambda$33(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            ma.b bVar = roomViewModel.mMicOperationResponse;
            String message = apiResponse.getMessage();
            if (message == null) {
                message = "ok";
            }
            bVar.setValue(new Pair(INTERFACE_MUTE_MIC, message));
        }
        return Unit.INSTANCE;
    }

    public static final Unit muteMic$lambda$34(RoomViewModel roomViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 21001) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131953534), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(roomViewModel, 2131952667);
                } else {
                    str = errorMessage;
                }
                Toast normal$default2 = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952667), false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void pk1v1$default(RoomViewModel roomViewModel, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        roomViewModel.pk1v1(function1);
    }

    public static final Unit pk1v1$lambda$108(Function1 function1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Pk1v1End pk1v1End = (Pk1v1End) apiResponse.getData();
        if (pk1v1End != null && function1 != null) {
            function1.invoke(pk1v1End);
        }
        return Unit.INSTANCE;
    }

    public static final Unit pk1v1$lambda$109(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit playLuckWheel$lambda$21(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Log.d(TAG, "playLuckWheel: --onSuccess--");
        return Unit.INSTANCE;
    }

    public static final Unit playLuckWheel$lambda$22(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "playLuckWheel: --onError--");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void refreshLuckLyDialog$default(RoomViewModel roomViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        roomViewModel.refreshLuckLyDialog(z);
    }

    public static final Unit refreshLuckLyDialog$lambda$13(RoomViewModel roomViewModel, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GroupDetailBean groupDetailBean = (GroupDetailBean) roomViewModel.mGroupDetailBean.getValue();
        if (groupDetailBean != null) {
            groupDetailBean.setLuckyWheel((LuckWheelInfo) apiResponse.getData());
        }
        LuckWheelInfo luckWheelInfo = (LuckWheelInfo) apiResponse.getData();
        if (luckWheelInfo != null) {
            roomViewModel.updateLuckyWheelInfo(luckWheelInfo, z);
        }
        return Unit.INSTANCE;
    }

    public static final Unit refreshLuckLyDialog$lambda$14(RoomViewModel roomViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(roomViewModel, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit requestBoxList$lambda$85(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null) {
            MeetingRoomManager.INSTANCE.getMBoxLevel().addAll(arrayList);
        }
        return Unit.INSTANCE;
    }

    public static final Unit requestBoxList$lambda$86(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void requestMatchGame$default(RoomViewModel roomViewModel, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 9;
        }
        if ((i2 & 2) != 0) {
            str = "";
        }
        roomViewModel.requestMatchGame(i, str);
    }

    public static final Unit requestMatchGame$lambda$77(int i, String str, ApiResponse apiResponse) {
        int i2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GameJum gameJum = GameJum.INSTANCE;
        Integer num = (Integer) apiResponse.getData();
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        if (str == null) {
            str = "";
        }
        GameJum.matchGame$default(gameJum, i2, i, 0, 0, str, 12, null);
        return Unit.INSTANCE;
    }

    public static final Unit requestMatchGame$lambda$78(RoomViewModel roomViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(roomViewModel, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestNewToken$default(RoomViewModel roomViewModel, Function0 function0, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            bool = Boolean.FALSE;
        }
        roomViewModel.requestNewToken(function0, bool);
    }

    public static final Unit requestNewToken$lambda$82(RoomViewModel roomViewModel, Function0 function0, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        InRoomBean inRoomBean = (InRoomBean) apiResponse.getData();
        if (inRoomBean != null) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            meetingRoomManager.setMRoomChannelId(inRoomBean.getChannelId());
            meetingRoomManager.setMAgoraToken(inRoomBean.getToken());
            meetingRoomManager.setMAgoraId(inRoomBean.getAgoraId());
            meetingRoomManager.setMProvider(inRoomBean.getProvider());
            roomViewModel.isEnterRoomBoolean.setValue(Boolean.TRUE);
            HiloRtcEngine.INSTANCE.leaveChannel();
            roomViewModel.joinChannel(inRoomBean.getToken(), inRoomBean.getChannelId(), inRoomBean.getAgoraId(), inRoomBean.getProvider());
            if (function0 != null) {
                function0.invoke();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit requestNewToken$lambda$83(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit roomMatchGameJoin$lambda$79(int i, int i2, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GameJum.matchGame$default(GameJum.INSTANCE, i, i2, 0, 0, str, 12, null);
        return Unit.INSTANCE;
    }

    public static final Unit roomMatchGameJoin$lambda$80(RoomViewModel roomViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(roomViewModel, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit sendGift$lambda$39(ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        return Unit.INSTANCE;
    }

    public static final Unit sendGift$lambda$40(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(INTERFACE_SEND_GIFT, th));
        return Unit.INSTANCE;
    }

    public static final Unit sendGift$lambda$41(ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        return Unit.INSTANCE;
    }

    public static final Unit sendGift$lambda$42(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(INTERFACE_SEND_GIFT, th));
        return Unit.INSTANCE;
    }

    public static final Unit sendGift$lambda$43(ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        return Unit.INSTANCE;
    }

    public static final Unit sendGift$lambda$44(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(INTERFACE_SEND_GIFT, th));
        return Unit.INSTANCE;
    }

    public static final Unit startYouTuBe$lambda$100(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static final Unit startYouTuBe$lambda$99(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void sudGameReport$default(RoomViewModel roomViewModel, long j, int i, String str, Function0 function0, Function1 function1, int i2, Object obj) {
        Function0 function02;
        Function1 function12;
        if ((i2 & 8) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        if ((i2 & 16) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        roomViewModel.sudGameReport(j, i, str, function02, function12);
    }

    public static final Unit sudGameReport$lambda$67(int i, Function0 function0, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "游戏上报成功:" + i, false, 4, (Object) null);
        BeanBaseBean beanBaseBean = (BeanBaseBean) apiResponse.getData();
        double d2 = 0.0d;
        if (beanBaseBean != null) {
            d = beanBaseBean.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (d >= 0.0d) {
            UserStore shared = UserStore.INSTANCE.getShared();
            BeanBaseBean beanBaseBean2 = (BeanBaseBean) apiResponse.getData();
            if (beanBaseBean2 != null) {
                d2 = beanBaseBean2.getDiamondNum();
            }
            UserStore.refreshDiamondOrGem$default(shared, d2, 0.0d, 2, null);
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final Unit sudGameReport$lambda$68(Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function1 != null) {
            function1.invoke(th);
        }
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "游戏上报失败", false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public static final Unit toGameDice$lambda$60(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            Log.d(TAG, "toGameDice: success");
        } else {
            Log.d(TAG, "toGameDice:" + apiResponse.getMessage());
        }
        return Unit.INSTANCE;
    }

    public static final Unit toGameDice$lambda$61(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "toGameDice:" + th.getLocalizedMessage());
        return Unit.INSTANCE;
    }

    public static final Unit unMuteByIndex$lambda$35(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public static final Unit unMuteByIndex$lambda$36(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(INTERFACE_UN_LOCK_MIC, th));
        return Unit.INSTANCE;
    }

    public static final Unit unMuteMic$lambda$45(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            ma.b bVar = roomViewModel.mMicOperationResponse;
            String message = apiResponse.getMessage();
            if (message == null) {
                message = "ok";
            }
            bVar.setValue(new Pair(INTERFACE_UN_MUTE_MIC, message));
        }
        return Unit.INSTANCE;
    }

    public static final Unit unMuteMic$lambda$46(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(INTERFACE_UN_MUTE_MIC, th));
        return Unit.INSTANCE;
    }

    public static final Unit unlockMic$lambda$31(RoomViewModel roomViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            ma.b bVar = roomViewModel.mMicOperationResponse;
            String message = apiResponse.getMessage();
            if (message == null) {
                message = "ok";
            }
            bVar.setValue(new Pair(INTERFACE_UN_LOCK_MIC, message));
        }
        return Unit.INSTANCE;
    }

    public static final Unit unlockMic$lambda$32(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomViewModel.getMException().setValue(new Pair(INTERFACE_UN_LOCK_MIC, th));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void upMic$default(RoomViewModel roomViewModel, Integer num, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        roomViewModel.upMic(num, str, z);
    }

    public static final Unit upMic$lambda$23(boolean z, RoomViewModel roomViewModel, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk() && !z) {
            ma.b bVar = roomViewModel.mMicOperationResponse;
            if (str == null) {
                str = "ok";
            }
            bVar.setValue(new Pair(INTERFACE_UP_MIC, str));
            HiloRtcEngine.INSTANCE.setClientRole(1);
        }
        return Unit.INSTANCE;
    }

    public static final Unit upMic$lambda$24(RoomViewModel roomViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            int code = ((HiloException) th).getCode();
            if (code != 12008) {
                if (code != 12009) {
                    roomViewModel.getMException().setValue(new Pair(INTERFACE_UP_MIC, th));
                } else {
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131953000), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            } else {
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(roomViewModel, 2131953529), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            roomViewModel.getMException().setValue(new Pair(INTERFACE_UP_MIC, th));
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void updateLuckyWheelInfo$default(RoomViewModel roomViewModel, LuckWheelInfo luckWheelInfo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        roomViewModel.updateLuckyWheelInfo(luckWheelInfo, z);
    }

    public static final Unit youTuBeProcess$lambda$97(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        YouTuGameData youTuGameData = (YouTuGameData) apiResponse.getData();
        if (youTuGameData != null) {
            youTuGameData.setOwner(true);
        }
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        meetingRoomManager.setMYouTuBe((YouTuGameData) apiResponse.getData());
        meetingRoomManager.getWsFlow().tryEmit(RoomEvent.roomEvent$default(new RoomEvent(), RoomEvent.ROOM_YOU_TU, null, 2, null));
        return Unit.INSTANCE;
    }

    public static final Unit youTuBeProcess$lambda$98(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "获取进度失败", false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public final void acceptInvite(int isInvite) {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().joinGroup(this.mGroupId, isInvite), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.p2
            public final Object invoke(Object obj) {
                Unit acceptInvite$lambda$15;
                acceptInvite$lambda$15 = RoomViewModel.acceptInvite$lambda$15(RoomViewModel.this, (ApiResponse) obj);
                return acceptInvite$lambda$15;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.q2
            public final Object invoke(Object obj) {
                Unit acceptInvite$lambda$16;
                acceptInvite$lambda$16 = RoomViewModel.acceptInvite$lambda$16(RoomViewModel.this, (Throwable) obj);
                return acceptInvite$lambda$16;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void addVideoMyRoom(@NotNull String videoUrl, @Nullable final Function0<Unit> listener, @Nullable final Function1<? super Throwable, Unit> onError) {
        String str;
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        ServerApi apis = AppServer.INSTANCE.getApis();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getGroupId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.addYouTuBeVideo(str, videoUrl), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.y0
            public final Object invoke(Object obj) {
                Unit addVideoMyRoom$lambda$103;
                addVideoMyRoom$lambda$103 = RoomViewModel.addVideoMyRoom$lambda$103(listener, (ApiResponse) obj);
                return addVideoMyRoom$lambda$103;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.z0
            public final Object invoke(Object obj) {
                Unit addVideoMyRoom$lambda$104;
                addVideoMyRoom$lambda$104 = RoomViewModel.addVideoMyRoom$lambda$104(onError, (Throwable) obj);
                return addVideoMyRoom$lambda$104;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void changeOtherRoomMic(int type) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().changeOtherRoomMic(type), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.l0
            public final Object invoke(Object obj) {
                Unit changeOtherRoomMic$lambda$95;
                changeOtherRoomMic$lambda$95 = RoomViewModel.changeOtherRoomMic$lambda$95((ApiResponse) obj);
                return changeOtherRoomMic$lambda$95;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.m0
            public final Object invoke(Object obj) {
                Unit changeOtherRoomMic$lambda$96;
                changeOtherRoomMic$lambda$96 = RoomViewModel.changeOtherRoomMic$lambda$96((Throwable) obj);
                return changeOtherRoomMic$lambda$96;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void cleanMessage() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().cleanMessage(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.q1
            public final Object invoke(Object obj) {
                Unit cleanMessage$lambda$75;
                cleanMessage$lambda$75 = RoomViewModel.cleanMessage$lambda$75(RoomViewModel.this, (ApiResponse) obj);
                return cleanMessage$lambda$75;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.r1
            public final Object invoke(Object obj) {
                Unit cleanMessage$lambda$76;
                cleanMessage$lambda$76 = RoomViewModel.cleanMessage$lambda$76(RoomViewModel.this, (Throwable) obj);
                return cleanMessage$lambda$76;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void closeLuckyDialog() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().closeRoomLuckWheel(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.w0
            public final Object invoke(Object obj) {
                Unit closeLuckyDialog$lambda$17;
                closeLuckyDialog$lambda$17 = RoomViewModel.closeLuckyDialog$lambda$17(RoomViewModel.this, (ApiResponse) obj);
                return closeLuckyDialog$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.x0
            public final Object invoke(Object obj) {
                Unit closeLuckyDialog$lambda$18;
                closeLuckyDialog$lambda$18 = RoomViewModel.closeLuckyDialog$lambda$18(RoomViewModel.this, (Throwable) obj);
                return closeLuckyDialog$lambda$18;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void createLuckyWheel(boolean autoRestart, boolean selfJoin, int lastId) {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().createRoomLuckWheel(lastId, selfJoin, autoRestart, this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.h3
            public final Object invoke(Object obj) {
                Unit createLuckyWheel$lambda$10;
                createLuckyWheel$lambda$10 = RoomViewModel.createLuckyWheel$lambda$10((ApiResponse) obj);
                return createLuckyWheel$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.i3
            public final Object invoke(Object obj) {
                Unit createLuckyWheel$lambda$11;
                createLuckyWheel$lambda$11 = RoomViewModel.createLuckyWheel$lambda$11(RoomViewModel.this, (Throwable) obj);
                return createLuckyWheel$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void createSudGame(@NotNull final CreateSudData data, @Nullable final Function0<Unit> onSuccess, @Nullable final Function1<? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(data, "data");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().sudCode(), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.u1
            public final Object invoke(Object obj) {
                Unit createSudGame$lambda$71;
                createSudGame$lambda$71 = RoomViewModel.createSudGame$lambda$71(CreateSudData.this, this, onSuccess, onError, (ApiResponse) obj);
                return createSudGame$lambda$71;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.v1
            public final Object invoke(Object obj) {
                Unit createSudGame$lambda$72;
                createSudGame$lambda$72 = RoomViewModel.createSudGame$lambda$72(onError, (Throwable) obj);
                return createSudGame$lambda$72;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void downMic(int micIndex, final boolean isKick) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().downMic(this.mGroupId, micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.h0
            public final Object invoke(Object obj) {
                Unit downMic$lambda$27;
                downMic$lambda$27 = RoomViewModel.downMic$lambda$27(RoomViewModel.this, isKick, (ApiResponse) obj);
                return downMic$lambda$27;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.i0
            public final Object invoke(Object obj) {
                Unit downMic$lambda$28;
                downMic$lambda$28 = RoomViewModel.downMic$lambda$28(RoomViewModel.this, (Throwable) obj);
                return downMic$lambda$28;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void enterRoomCheckAutoInviteUpMicDialog() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().enterRoomCheckAutoInviteUpMicDialog(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.u2
            public final Object invoke(Object obj) {
                Unit enterRoomCheckAutoInviteUpMicDialog$lambda$48;
                enterRoomCheckAutoInviteUpMicDialog$lambda$48 = RoomViewModel.enterRoomCheckAutoInviteUpMicDialog$lambda$48(RoomViewModel.this, (ApiResponse) obj);
                return enterRoomCheckAutoInviteUpMicDialog$lambda$48;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.v2
            public final Object invoke(Object obj) {
                Unit enterRoomCheckAutoInviteUpMicDialog$lambda$49;
                enterRoomCheckAutoInviteUpMicDialog$lambda$49 = RoomViewModel.enterRoomCheckAutoInviteUpMicDialog$lambda$49((Throwable) obj);
                return enterRoomCheckAutoInviteUpMicDialog$lambda$49;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void exitHiloGameModel() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().exitHiloGameModel(MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.m1
            public final Object invoke(Object obj) {
                Unit exitHiloGameModel$lambda$110;
                exitHiloGameModel$lambda$110 = RoomViewModel.exitHiloGameModel$lambda$110((ApiResponse) obj);
                return exitHiloGameModel$lambda$110;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.n1
            public final Object invoke(Object obj) {
                Unit exitHiloGameModel$lambda$111;
                exitHiloGameModel$lambda$111 = RoomViewModel.exitHiloGameModel$lambda$111((Throwable) obj);
                return exitHiloGameModel$lambda$111;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void exitYouTuBe() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().exitYouTuBe(MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.o1
            public final Object invoke(Object obj) {
                Unit exitYouTuBe$lambda$101;
                exitYouTuBe$lambda$101 = RoomViewModel.exitYouTuBe$lambda$101((ApiResponse) obj);
                return exitYouTuBe$lambda$101;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.p1
            public final Object invoke(Object obj) {
                Unit exitYouTuBe$lambda$102;
                exitYouTuBe$lambda$102 = RoomViewModel.exitYouTuBe$lambda$102((Throwable) obj);
                return exitYouTuBe$lambda$102;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getDiamondGameList(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().diamondGameData(groupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.f2
            public final Object invoke(Object obj) {
                Unit diamondGameList$lambda$93;
                diamondGameList$lambda$93 = RoomViewModel.getDiamondGameList$lambda$93(RoomViewModel.this, (ApiResponse) obj);
                return diamondGameList$lambda$93;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.g2
            public final Object invoke(Object obj) {
                Unit diamondGameList$lambda$94;
                diamondGameList$lambda$94 = RoomViewModel.getDiamondGameList$lambda$94((Throwable) obj);
                return diamondGameList$lambda$94;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getEnvelopeInfo(long r10, @Nullable final Function1<? super Throwable, Unit> onError) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getEnvelopeData(r10, MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.f3
            public final Object invoke(Object obj) {
                Unit envelopeInfo$lambda$105;
                envelopeInfo$lambda$105 = RoomViewModel.getEnvelopeInfo$lambda$105((ApiResponse) obj);
                return envelopeInfo$lambda$105;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.g3
            public final Object invoke(Object obj) {
                Unit envelopeInfo$lambda$106;
                envelopeInfo$lambda$106 = RoomViewModel.getEnvelopeInfo$lambda$106(onError, (Throwable) obj);
                return envelopeInfo$lambda$106;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getGameList(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGameListOfType(groupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.k2
            public final Object invoke(Object obj) {
                Unit gameList$lambda$64;
                gameList$lambda$64 = RoomViewModel.getGameList$lambda$64((ApiResponse) obj);
                return gameList$lambda$64;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.l2
            public final Object invoke(Object obj) {
                Unit gameList$lambda$65;
                gameList$lambda$65 = RoomViewModel.getGameList$lambda$65((Throwable) obj);
                return gameList$lambda$65;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    @NotNull
    public final ma.b getMBannerList() {
        return this.mBannerList;
    }

    @NotNull
    public final ma.b getMDiamondGameList() {
        return this.mDiamondGameList;
    }

    @NotNull
    public final ma.b getMEnterRoomAutoUpMicBean() {
        return this.mEnterRoomAutoUpMicBean;
    }

    @NotNull
    public final String getMGameCode() {
        return this.mGameCode;
    }

    @NotNull
    public final ma.b getMGetRoomMicType() {
        return this.mGetRoomMicType;
    }

    @NotNull
    public final ma.b getMGroupDetailBean() {
        return this.mGroupDetailBean;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @NotNull
    public final ma.b getMMicOperationResponse() {
        return this.mMicOperationResponse;
    }

    @NotNull
    public final HashSet<String> getMRocketResultList() {
        return this.mRocketResultList;
    }

    @NotNull
    public final ma.b getMRocketResultSvgaBean() {
        return this.mRocketResultSvgaBean;
    }

    @NotNull
    public final ma.b getMRocketRoomSmallBean() {
        return this.mRocketRoomSmallBean;
    }

    @NotNull
    public final ma.b getMRoomLuckWheelInfo() {
        return this.mRoomLuckWheelInfo;
    }

    @NotNull
    public final ma.b getMRoomPKBox() {
        return this.mRoomPKBox;
    }

    @NotNull
    public final ma.b getMRoomPasswordError() {
        return this.mRoomPasswordError;
    }

    @NotNull
    public final ma.b getMRoomShowSelectLuckWheelDialog() {
        return this.mRoomShowSelectLuckWheelDialog;
    }

    public final void getPKBox() {
        this.mRoomPKBox.setValue((Object) null);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getPKBox(), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.e0
            public final Object invoke(Object obj) {
                Unit pKBox$lambda$88;
                pKBox$lambda$88 = RoomViewModel.getPKBox$lambda$88(RoomViewModel.this, (ApiResponse) obj);
                return pKBox$lambda$88;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.p0
            public final Object invoke(Object obj) {
                Unit pKBox$lambda$89;
                pKBox$lambda$89 = RoomViewModel.getPKBox$lambda$89((Throwable) obj);
                return pKBox$lambda$89;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getPKStatus() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().currentPKStatus(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.d1
            public final Object invoke(Object obj) {
                Unit pKStatus$lambda$90;
                pKStatus$lambda$90 = RoomViewModel.getPKStatus$lambda$90((ApiResponse) obj);
                return pKStatus$lambda$90;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.e1
            public final Object invoke(Object obj) {
                Unit pKStatus$lambda$91;
                pKStatus$lambda$91 = RoomViewModel.getPKStatus$lambda$91((Throwable) obj);
                return pKStatus$lambda$91;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getRocketEnterData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomRocketSmallData(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.s1
            public final Object invoke(Object obj) {
                Unit rocketEnterData$lambda$51;
                rocketEnterData$lambda$51 = RoomViewModel.getRocketEnterData$lambda$51(RoomViewModel.this, (ApiResponse) obj);
                return rocketEnterData$lambda$51;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.t1
            public final Object invoke(Object obj) {
                Unit rocketEnterData$lambda$52;
                rocketEnterData$lambda$52 = RoomViewModel.getRocketEnterData$lambda$52((Throwable) obj);
                return rocketEnterData$lambda$52;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getRocketSvgaCountDown(final boolean isFirstIn) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRocketRoomResultData(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.i2
            public final Object invoke(Object obj) {
                Unit rocketSvgaCountDown$lambda$55;
                rocketSvgaCountDown$lambda$55 = RoomViewModel.getRocketSvgaCountDown$lambda$55(RoomViewModel.this, isFirstIn, (ApiResponse) obj);
                return rocketSvgaCountDown$lambda$55;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.j2
            public final Object invoke(Object obj) {
                Unit rocketSvgaCountDown$lambda$56;
                rocketSvgaCountDown$lambda$56 = RoomViewModel.getRocketSvgaCountDown$lambda$56((Throwable) obj);
                return rocketSvgaCountDown$lambda$56;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getRoomBanner() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomBanner(), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.x1
            public final Object invoke(Object obj) {
                Unit roomBanner$lambda$58;
                roomBanner$lambda$58 = RoomViewModel.getRoomBanner$lambda$58(RoomViewModel.this, (ApiResponse) obj);
                return roomBanner$lambda$58;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.y1
            public final Object invoke(Object obj) {
                Unit roomBanner$lambda$59;
                roomBanner$lambda$59 = RoomViewModel.getRoomBanner$lambda$59((Throwable) obj);
                return roomBanner$lambda$59;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getRoomInfo() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomInfo(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.b1
            public final Object invoke(Object obj) {
                Unit roomInfo$lambda$8;
                roomInfo$lambda$8 = RoomViewModel.getRoomInfo$lambda$8(RoomViewModel.this, (ApiResponse) obj);
                return roomInfo$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.c1
            public final Object invoke(Object obj) {
                Unit roomInfo$lambda$9;
                roomInfo$lambda$9 = RoomViewModel.getRoomInfo$lambda$9((Throwable) obj);
                return roomInfo$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getRoomRole() {
        MeetingRoomManager.INSTANCE.getRoomRole();
    }

    public final void getSudCode(@Nullable final Function0<Unit> onSuccess, @Nullable final Function0<Unit> onError) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().sudCode(), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.z1
            public final Object invoke(Object obj) {
                Unit sudCode$lambda$73;
                sudCode$lambda$73 = RoomViewModel.getSudCode$lambda$73(RoomViewModel.this, onSuccess, (ApiResponse) obj);
                return sudCode$lambda$73;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.a2
            public final Object invoke(Object obj) {
                Unit sudCode$lambda$74;
                sudCode$lambda$74 = RoomViewModel.getSudCode$lambda$74(onError, this, (Throwable) obj);
                return sudCode$lambda$74;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void initRoomBaseKeyValue(@NotNull EnterRoomData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        meetingRoomManager.setMRoomChannelId(data.getAgoraChannel());
        meetingRoomManager.setMAgoraToken(data.getAgoraToken());
        meetingRoomManager.setMAgoraId(data.getAgoraId());
        meetingRoomManager.setMPassword(data.getPassword());
        meetingRoomManager.setMProvider(data.getProvider());
        if (data.getMicroType() > 0) {
            meetingRoomManager.setMCurrentRoomMicType(data.getMicroType());
            meetingRoomManager.emptyMicInit(meetingRoomManager.getMicSize(data.getMicroType()));
            this.mGetRoomMicType.setValue(Integer.valueOf(data.getMicroType()));
        }
    }

    @Nullable
    public final String initUserImExtBean(@Nullable List<TIMUserBean> mentionUsers) {
        String str;
        Integer num;
        int i;
        User user = UserStore.INSTANCE.getShared().getUser();
        Integer num2 = null;
        if (user == null) {
            return null;
        }
        com.google.gson.d dVar = new com.google.gson.d();
        long charmUserGrade = user.getCharmUserGrade();
        long wealthUserGrade = user.getWealthUserGrade();
        Boolean isPrettyCode = user.isPrettyCode();
        boolean isVip = user.isVip();
        String myGroupPowerName = user.getMyGroupPowerName();
        FamilyInfo groupPower = user.getGroupPower();
        if (groupPower != null) {
            str = groupPower.getNameplate();
        } else {
            str = null;
        }
        FamilyInfo groupPower2 = user.getGroupPower();
        if (groupPower2 != null) {
            num = groupPower2.getGrade();
        } else {
            num = null;
        }
        NobleInfo noble = user.getNoble();
        if (noble != null) {
            num2 = noble.getLevel();
        }
        Integer num3 = num2;
        List medals = user.getMedals();
        SvipData svip = user.getSvip();
        if (svip != null) {
            i = svip.getSvipLevel();
        } else {
            i = 0;
        }
        return dVar.s(new TIMUserExtBean(Long.valueOf(charmUserGrade), isPrettyCode, Boolean.valueOf(isVip), medals, myGroupPowerName, num3, Long.valueOf(wealthUserGrade), i, user.getSvip(), mentionUsers, str, num));
    }

    public final void inviteUserUpMic(@NotNull String r10) {
        Intrinsics.checkNotNullParameter(r10, TUIConstants.TUILive.USER_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().inviteOtherUpMic(this.mGroupId, r10), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.n3
            public final Object invoke(Object obj) {
                Unit inviteUserUpMic$lambda$25;
                inviteUserUpMic$lambda$25 = RoomViewModel.inviteUserUpMic$lambda$25(RoomViewModel.this, (ApiResponse) obj);
                return inviteUserUpMic$lambda$25;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.p3
            public final Object invoke(Object obj) {
                Unit inviteUserUpMic$lambda$26;
                inviteUserUpMic$lambda$26 = RoomViewModel.inviteUserUpMic$lambda$26(RoomViewModel.this, (Throwable) obj);
                return inviteUserUpMic$lambda$26;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    /* renamed from: isEnterRoomBoolean, reason: from getter */
    public final ma.b getIsEnterRoomBoolean() {
        return this.isEnterRoomBoolean;
    }

    public final void joinChannel(@Nullable final V2TIMCallback callBack, @NotNull EnterRoomData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        meetingRoomManager.joinRoom();
        if (!data.isPasswordRoom()) {
            if (callBack != null) {
                joinRoomNetRequest(data.getSceneType(), data.getSceneUid(), data.getPassword(), callBack, data.getGameType(), data.getGameCode(), data.is1V1(), data.getGameMode());
                return;
            }
            return;
        }
        if (callBack != null) {
            RoomPK roomPK = (RoomPK) BaseApplication.Companion.getGSON().j((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "enter_room_pk_data", "", (String) null, 4, (Object) null), RoomPK.class);
            this.mGetRoomMicType.setValue(Integer.valueOf(data.getMicroType()));
            meetingRoomManager.setMRoomChannelId(data.getAgoraChannel());
            meetingRoomManager.setMAgoraToken(data.getAgoraToken());
            meetingRoomManager.setMAgoraId(data.getAgoraId());
            meetingRoomManager.setMProvider(data.getProvider());
            meetingRoomManager.setMPK(roomPK);
            joinChannel(data.getAgoraToken(), data.getAgoraChannel(), data.getAgoraId(), data.getProvider());
            meetingRoomManager.setMCurrentRoomMicType(data.getMicroType());
            meetingRoomManager.emptyMicInit(meetingRoomManager.getMicSize(data.getMicroType()));
            WebSocketProvide.roomWebSocket$default(WebSocketProvide.INSTANCE, 152, data.getGroupId(), null, new Function2() { // from class: com.qiahao.nextvideo.room.viewmodel.m2
                public final Object invoke(Object obj, Object obj2) {
                    Unit joinChannel$lambda$1$lambda$0;
                    joinChannel$lambda$1$lambda$0 = RoomViewModel.joinChannel$lambda$1$lambda$0(RoomViewModel.this, callBack, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                    return joinChannel$lambda$1$lambda$0;
                }
            }, 4, null);
            getRoomInfo();
            GroupService.INSTANCE.getMGroupEventProcessorObservable().onNext(new GroupEvent().enterRoom(meetingRoomManager.getMGroupId()));
            this.isEnterRoomBoolean.setValue(Boolean.TRUE);
        }
    }

    public final void joinRoomLuckWheel() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().joinRoomLuckyWheel(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.o3
            public final Object invoke(Object obj) {
                Unit joinRoomLuckWheel$lambda$19;
                joinRoomLuckWheel$lambda$19 = RoomViewModel.joinRoomLuckWheel$lambda$19((ApiResponse) obj);
                return joinRoomLuckWheel$lambda$19;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.t3
            public final Object invoke(Object obj) {
                Unit joinRoomLuckWheel$lambda$20;
                joinRoomLuckWheel$lambda$20 = RoomViewModel.joinRoomLuckWheel$lambda$20(RoomViewModel.this, (Throwable) obj);
                return joinRoomLuckWheel$lambda$20;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void leaveRoom(boolean needFetchLeaveRoom) {
        Log.d(TAG, "leaveRoom: 离开房间");
        MeetingRoomManager.INSTANCE.leaveRoom(needFetchLeaveRoom);
        getMCompositeDisposable().d();
        getMCompositeDisposable().dispose();
    }

    public final void lockMic(int micIndex) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().lockMic(this.mGroupId, micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.w1
            public final Object invoke(Object obj) {
                Unit lockMic$lambda$29;
                lockMic$lambda$29 = RoomViewModel.lockMic$lambda$29(RoomViewModel.this, (ApiResponse) obj);
                return lockMic$lambda$29;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.h2
            public final Object invoke(Object obj) {
                Unit lockMic$lambda$30;
                lockMic$lambda$30 = RoomViewModel.lockMic$lambda$30(RoomViewModel.this, (Throwable) obj);
                return lockMic$lambda$30;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void muteByIndex(int micIndex) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().muteByIndex(this.mGroupId, micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.y2
            public final Object invoke(Object obj) {
                Unit muteByIndex$lambda$37;
                muteByIndex$lambda$37 = RoomViewModel.muteByIndex$lambda$37(RoomViewModel.this, (ApiResponse) obj);
                return muteByIndex$lambda$37;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.z2
            public final Object invoke(Object obj) {
                Unit muteByIndex$lambda$38;
                muteByIndex$lambda$38 = RoomViewModel.muteByIndex$lambda$38(RoomViewModel.this, (Throwable) obj);
                return muteByIndex$lambda$38;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void muteMic(int micIndex) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().muteMic(this.mGroupId, micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.a1
            public final Object invoke(Object obj) {
                Unit muteMic$lambda$33;
                muteMic$lambda$33 = RoomViewModel.muteMic$lambda$33(RoomViewModel.this, (ApiResponse) obj);
                return muteMic$lambda$33;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.l1
            public final Object invoke(Object obj) {
                Unit muteMic$lambda$34;
                muteMic$lambda$34 = RoomViewModel.muteMic$lambda$34(RoomViewModel.this, (Throwable) obj);
                return muteMic$lambda$34;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void pk1v1(@Nullable final Function1<? super Pk1v1End, Unit> listener) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().pk1v1(MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.s2
            public final Object invoke(Object obj) {
                Unit pk1v1$lambda$108;
                pk1v1$lambda$108 = RoomViewModel.pk1v1$lambda$108(listener, (ApiResponse) obj);
                return pk1v1$lambda$108;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.d3
            public final Object invoke(Object obj) {
                Unit pk1v1$lambda$109;
                pk1v1$lambda$109 = RoomViewModel.pk1v1$lambda$109((Throwable) obj);
                return pk1v1$lambda$109;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void playLuckWheel() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().playRoomLuckyWheel(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.a3
            public final Object invoke(Object obj) {
                Unit playLuckWheel$lambda$21;
                playLuckWheel$lambda$21 = RoomViewModel.playLuckWheel$lambda$21((ApiResponse) obj);
                return playLuckWheel$lambda$21;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.b3
            public final Object invoke(Object obj) {
                Unit playLuckWheel$lambda$22;
                playLuckWheel$lambda$22 = RoomViewModel.playLuckWheel$lambda$22(RoomViewModel.this, (Throwable) obj);
                return playLuckWheel$lambda$22;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void refreshLuckLyDialog(final boolean isCreateGame) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomLuckWheelInfo(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.u0
            public final Object invoke(Object obj) {
                Unit refreshLuckLyDialog$lambda$13;
                refreshLuckLyDialog$lambda$13 = RoomViewModel.refreshLuckLyDialog$lambda$13(RoomViewModel.this, isCreateGame, (ApiResponse) obj);
                return refreshLuckLyDialog$lambda$13;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.v0
            public final Object invoke(Object obj) {
                Unit refreshLuckLyDialog$lambda$14;
                refreshLuckLyDialog$lambda$14 = RoomViewModel.refreshLuckLyDialog$lambda$14(RoomViewModel.this, (Throwable) obj);
                return refreshLuckLyDialog$lambda$14;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void requestBoxList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getPKBoxList(), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.j1
            public final Object invoke(Object obj) {
                Unit requestBoxList$lambda$85;
                requestBoxList$lambda$85 = RoomViewModel.requestBoxList$lambda$85((ApiResponse) obj);
                return requestBoxList$lambda$85;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.k1
            public final Object invoke(Object obj) {
                Unit requestBoxList$lambda$86;
                requestBoxList$lambda$86 = RoomViewModel.requestBoxList$lambda$86((Throwable) obj);
                return requestBoxList$lambda$86;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void requestMatchGame(final int gameID, @Nullable final String groupId) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatApi.DefaultImpls.inviteSheep$default(ChatServer.INSTANCE.getApis(), null, gameID, groupId, 1, null), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.d2
            public final Object invoke(Object obj) {
                Unit requestMatchGame$lambda$77;
                requestMatchGame$lambda$77 = RoomViewModel.requestMatchGame$lambda$77(gameID, groupId, (ApiResponse) obj);
                return requestMatchGame$lambda$77;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.e2
            public final Object invoke(Object obj) {
                Unit requestMatchGame$lambda$78;
                requestMatchGame$lambda$78 = RoomViewModel.requestMatchGame$lambda$78(RoomViewModel.this, (Throwable) obj);
                return requestMatchGame$lambda$78;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void requestNewToken(@Nullable final Function0<Unit> callBack, @Nullable Boolean isSmall) {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMusicManager().i() == MusicStatus.PLAY) {
            if (Intrinsics.areEqual(isSmall, Boolean.TRUE)) {
                return;
            } else {
                meetingRoomManager.getMusicManager().v();
            }
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getNewPKToken(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.n2
            public final Object invoke(Object obj) {
                Unit requestNewToken$lambda$82;
                requestNewToken$lambda$82 = RoomViewModel.requestNewToken$lambda$82(RoomViewModel.this, callBack, (ApiResponse) obj);
                return requestNewToken$lambda$82;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.o2
            public final Object invoke(Object obj) {
                Unit requestNewToken$lambda$83;
                requestNewToken$lambda$83 = RoomViewModel.requestNewToken$lambda$83((Throwable) obj);
                return requestNewToken$lambda$83;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void roomMatchGameJoin(final int matchId, @NotNull final String groupId, final int r11) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ChatServer.INSTANCE.getApis().roomMatchGameJoin(matchId, groupId, r11), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.h1
            public final Object invoke(Object obj) {
                Unit roomMatchGameJoin$lambda$79;
                roomMatchGameJoin$lambda$79 = RoomViewModel.roomMatchGameJoin$lambda$79(matchId, r11, groupId, (ApiResponse) obj);
                return roomMatchGameJoin$lambda$79;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.i1
            public final Object invoke(Object obj) {
                Unit roomMatchGameJoin$lambda$80;
                roomMatchGameJoin$lambda$80 = RoomViewModel.roomMatchGameJoin$lambda$80(RoomViewModel.this, (Throwable) obj);
                return roomMatchGameJoin$lambda$80;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void sendGift(int sendType, @NotNull GiftData selectedGiftItem, int r25, @NotNull ArrayList<String> extraIdList) {
        Intrinsics.checkNotNullParameter(selectedGiftItem, "selectedGiftItem");
        Intrinsics.checkNotNullParameter(extraIdList, "extraIdList");
        long j = 0;
        if (sendType != 0) {
            if (sendType != 1) {
                if (sendType == 2) {
                    ServerApi apis = AppServer.INSTANCE.getApis();
                    String str = this.mGroupId;
                    Long giftId = selectedGiftItem.getGiftId();
                    if (giftId != null) {
                        j = giftId.longValue();
                    }
                    RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.sendGiftToRoomAllMember(str, j, r25, selectedGiftItem.getGiftText()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.s0
                        public final Object invoke(Object obj) {
                            Unit sendGift$lambda$43;
                            sendGift$lambda$43 = RoomViewModel.sendGift$lambda$43((ApiResponse) obj);
                            return sendGift$lambda$43;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.t0
                        public final Object invoke(Object obj) {
                            Unit sendGift$lambda$44;
                            sendGift$lambda$44 = RoomViewModel.sendGift$lambda$44(RoomViewModel.this, (Throwable) obj);
                            return sendGift$lambda$44;
                        }
                    }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
                    return;
                }
                return;
            }
            ServerApi apis2 = AppServer.INSTANCE.getApis();
            String str2 = this.mGroupId;
            Long giftId2 = selectedGiftItem.getGiftId();
            if (giftId2 != null) {
                j = giftId2.longValue();
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis2.sendGiftToMicAllMember(str2, j, r25, selectedGiftItem.getGiftText()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.n0
                public final Object invoke(Object obj) {
                    Unit sendGift$lambda$39;
                    sendGift$lambda$39 = RoomViewModel.sendGift$lambda$39((ApiResponse) obj);
                    return sendGift$lambda$39;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.o0
                public final Object invoke(Object obj) {
                    Unit sendGift$lambda$40;
                    sendGift$lambda$40 = RoomViewModel.sendGift$lambda$40(RoomViewModel.this, (Throwable) obj);
                    return sendGift$lambda$40;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
            return;
        }
        ServerApi apis3 = AppServer.INSTANCE.getApis();
        String str3 = extraIdList.get(0);
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        String str4 = str3;
        Long giftId3 = selectedGiftItem.getGiftId();
        if (giftId3 != null) {
            j = giftId3.longValue();
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis3.sendGift(str4, j, 4, this.mGroupId, r25, selectedGiftItem.getGiftText()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.q0
            public final Object invoke(Object obj) {
                Unit sendGift$lambda$41;
                sendGift$lambda$41 = RoomViewModel.sendGift$lambda$41((ApiResponse) obj);
                return sendGift$lambda$41;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.r0
            public final Object invoke(Object obj) {
                Unit sendGift$lambda$42;
                sendGift$lambda$42 = RoomViewModel.sendGift$lambda$42(RoomViewModel.this, (Throwable) obj);
                return sendGift$lambda$42;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setEnterRoomBoolean(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.isEnterRoomBoolean = bVar;
    }

    public final void setMBannerList(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mBannerList = bVar;
    }

    public final void setMDiamondGameList(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mDiamondGameList = bVar;
    }

    public final void setMEnterRoomAutoUpMicBean(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mEnterRoomAutoUpMicBean = bVar;
    }

    public final void setMGameCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGameCode = str;
    }

    public final void setMGetRoomMicType(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mGetRoomMicType = bVar;
    }

    public final void setMGroupDetailBean(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mGroupDetailBean = bVar;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMMicOperationResponse(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mMicOperationResponse = bVar;
    }

    public final void setMRocketResultList(@NotNull HashSet<String> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.mRocketResultList = hashSet;
    }

    public final void setMRoomLuckWheelInfo(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mRoomLuckWheelInfo = bVar;
    }

    public final void setMRoomPKBox(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mRoomPKBox = bVar;
    }

    public final void setMRoomPasswordError(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mRoomPasswordError = bVar;
    }

    public final void setMRoomShowSelectLuckWheelDialog(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mRoomShowSelectLuckWheelDialog = bVar;
    }

    public final void setRemoteAllMute(boolean isMute) {
        MeetingRoomManager.INSTANCE.setMicMemberAllRemoteMute(isMute);
    }

    public final void smallRoom() {
        Log.d(TAG, "smallRoom: 最小化房间");
        MeetingRoomManager.INSTANCE.smallRoom();
        getMCompositeDisposable().d();
        getMCompositeDisposable().dispose();
    }

    public final void startYouTuBe() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().startYouTuBe(MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.f0
            public final Object invoke(Object obj) {
                Unit startYouTuBe$lambda$99;
                startYouTuBe$lambda$99 = RoomViewModel.startYouTuBe$lambda$99((ApiResponse) obj);
                return startYouTuBe$lambda$99;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.g0
            public final Object invoke(Object obj) {
                Unit startYouTuBe$lambda$100;
                startYouTuBe$lambda$100 = RoomViewModel.startYouTuBe$lambda$100((Throwable) obj);
                return startYouTuBe$lambda$100;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void sudGameReport(long r15, final int opt, @NotNull String gameCode, @Nullable final Function0<Unit> onSuccess, @Nullable final Function1<? super Throwable, Unit> onError) {
        Intrinsics.checkNotNullParameter(gameCode, "gameCode");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().reportSud(r15, opt, gameCode, MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.l3
            public final Object invoke(Object obj) {
                Unit sudGameReport$lambda$67;
                sudGameReport$lambda$67 = RoomViewModel.sudGameReport$lambda$67(opt, onSuccess, (ApiResponse) obj);
                return sudGameReport$lambda$67;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.m3
            public final Object invoke(Object obj) {
                Unit sudGameReport$lambda$68;
                sudGameReport$lambda$68 = RoomViewModel.sudGameReport$lambda$68(onError, (Throwable) obj);
                return sudGameReport$lambda$68;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void toGameDice() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().toGameDice(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.f1
            public final Object invoke(Object obj) {
                Unit gameDice$lambda$60;
                gameDice$lambda$60 = RoomViewModel.toGameDice$lambda$60((ApiResponse) obj);
                return gameDice$lambda$60;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.g1
            public final Object invoke(Object obj) {
                Unit gameDice$lambda$61;
                gameDice$lambda$61 = RoomViewModel.toGameDice$lambda$61((Throwable) obj);
                return gameDice$lambda$61;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void unMuteByIndex(int micIndex) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().unMuteByIndex(this.mGroupId, micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.q3
            public final Object invoke(Object obj) {
                Unit unMuteByIndex$lambda$35;
                unMuteByIndex$lambda$35 = RoomViewModel.unMuteByIndex$lambda$35(RoomViewModel.this, (ApiResponse) obj);
                return unMuteByIndex$lambda$35;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.r3
            public final Object invoke(Object obj) {
                Unit unMuteByIndex$lambda$36;
                unMuteByIndex$lambda$36 = RoomViewModel.unMuteByIndex$lambda$36(RoomViewModel.this, (Throwable) obj);
                return unMuteByIndex$lambda$36;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void unMuteMic(int micIndex) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().unMuteMic(this.mGroupId, micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.j0
            public final Object invoke(Object obj) {
                Unit unMuteMic$lambda$45;
                unMuteMic$lambda$45 = RoomViewModel.unMuteMic$lambda$45(RoomViewModel.this, (ApiResponse) obj);
                return unMuteMic$lambda$45;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.k0
            public final Object invoke(Object obj) {
                Unit unMuteMic$lambda$46;
                unMuteMic$lambda$46 = RoomViewModel.unMuteMic$lambda$46(RoomViewModel.this, (Throwable) obj);
                return unMuteMic$lambda$46;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void unlockMic(int micIndex) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().unlockMic(this.mGroupId, micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.c3
            public final Object invoke(Object obj) {
                Unit unlockMic$lambda$31;
                unlockMic$lambda$31 = RoomViewModel.unlockMic$lambda$31(RoomViewModel.this, (ApiResponse) obj);
                return unlockMic$lambda$31;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.e3
            public final Object invoke(Object obj) {
                Unit unlockMic$lambda$32;
                unlockMic$lambda$32 = RoomViewModel.unlockMic$lambda$32(RoomViewModel.this, (Throwable) obj);
                return unlockMic$lambda$32;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void upMic(@Nullable Integer micIndex, @Nullable final String micType, final boolean micForbid) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().upMic(this.mGroupId, micIndex), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.b2
            public final Object invoke(Object obj) {
                Unit upMic$lambda$23;
                upMic$lambda$23 = RoomViewModel.upMic$lambda$23(micForbid, this, micType, (ApiResponse) obj);
                return upMic$lambda$23;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.c2
            public final Object invoke(Object obj) {
                Unit upMic$lambda$24;
                upMic$lambda$24 = RoomViewModel.upMic$lambda$24(RoomViewModel.this, (Throwable) obj);
                return upMic$lambda$24;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void updateLuckyWheelInfo(@NotNull LuckWheelInfo luckWheelInfo, boolean isCreateGame) {
        Intrinsics.checkNotNullParameter(luckWheelInfo, "luckWheelInfo");
        if (isCreateGame && luckWheelInfo.getStatus() == 0) {
            this.mRoomShowSelectLuckWheelDialog.postValue(Boolean.TRUE);
        } else {
            this.mRoomLuckWheelInfo.postValue(luckWheelInfo);
        }
    }

    public final void youTuBeProcess() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().youTuBeProcess(MeetingRoomManager.INSTANCE.getMGroupId()), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.j3
            public final Object invoke(Object obj) {
                Unit youTuBeProcess$lambda$97;
                youTuBeProcess$lambda$97 = RoomViewModel.youTuBeProcess$lambda$97((ApiResponse) obj);
                return youTuBeProcess$lambda$97;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.k3
            public final Object invoke(Object obj) {
                Unit youTuBeProcess$lambda$98;
                youTuBeProcess$lambda$98 = RoomViewModel.youTuBeProcess$lambda$98((Throwable) obj);
                return youTuBeProcess$lambda$98;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void joinChannel(@NotNull String token, @NotNull String channelId, int agoraId, int provider) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        HiloRtcEngine.INSTANCE.joinChannel(token, channelId, agoraId, provider);
    }
}
