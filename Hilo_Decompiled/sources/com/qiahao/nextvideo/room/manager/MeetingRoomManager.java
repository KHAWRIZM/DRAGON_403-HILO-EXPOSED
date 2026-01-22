package com.qiahao.nextvideo.room.manager;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.reflect.TypeToken;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.RoomRuleBean;
import com.qiahao.base_common.model.UserRoleType;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.ChatRoomStatusEvent;
import com.qiahao.base_common.model.eventBus.GlobalEvent;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ThrottleByKeyExecutor;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.CreateSudData;
import com.qiahao.nextvideo.data.game.Pk1v1Data;
import com.qiahao.nextvideo.data.game.SUDGameData;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.data.model.EmojiBean;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GiftBannerData;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.LuckWheelInfo;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.room.BoxLevel;
import com.qiahao.nextvideo.data.room.EnvelopeData;
import com.qiahao.nextvideo.data.room.GiftBannerButtonData;
import com.qiahao.nextvideo.data.room.PKInviteCancel;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.room.RoomPKScore;
import com.qiahao.nextvideo.data.room.RoomPKScoreRes;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.music.MusicLoader;
import com.qiahao.nextvideo.room.music.MusicStatus;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\fJ\r\u0010\u0015\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\fJ\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\tJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\tJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b!\u0010 J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0015\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u0004\u0018\u00010,¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\n¢\u0006\u0004\b2\u0010\fJ\u0015\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u0010$J\r\u00105\u001a\u00020\n¢\u0006\u0004\b5\u0010\fJ\r\u00106\u001a\u00020\n¢\u0006\u0004\b6\u0010\fJ\u0015\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020\n¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\n¢\u0006\u0004\b:\u0010\fJ\u0015\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\n¢\u0006\u0004\b<\u00109J\r\u0010=\u001a\u00020\n¢\u0006\u0004\b=\u0010\fJ\u001d\u0010A\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@¢\u0006\u0004\bA\u0010BJ#\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020E0D2\b\b\u0002\u0010C\u001a\u00020\n¢\u0006\u0004\bF\u0010GJ\r\u0010I\u001a\u00020H¢\u0006\u0004\bI\u0010JJ\u001f\u0010M\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u001e2\b\b\u0002\u0010L\u001a\u00020\n¢\u0006\u0004\bM\u0010NJ\u001f\u0010P\u001a\u00020\u00042\u0006\u0010O\u001a\u00020E2\b\b\u0002\u0010L\u001a\u00020\n¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\n¢\u0006\u0004\bS\u00109J\r\u0010T\u001a\u00020\u0004¢\u0006\u0004\bT\u0010\u0003J\u0015\u0010V\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n¢\u0006\u0004\bV\u0010WJ\u001d\u0010X\u001a\u0012\u0012\u0004\u0012\u00020E0>j\b\u0012\u0004\u0012\u00020E`@¢\u0006\u0004\bX\u0010BJ\u0017\u0010Z\u001a\u00020\u00062\b\u0010Y\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bZ\u0010[J\u0017\u0010]\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u0006¢\u0006\u0004\b]\u0010$J\r\u0010^\u001a\u00020\n¢\u0006\u0004\b^\u0010\fJ\r\u0010_\u001a\u00020\u0004¢\u0006\u0004\b_\u0010\u0003J\r\u0010`\u001a\u00020\u0004¢\u0006\u0004\b`\u0010\u0003J\r\u0010a\u001a\u00020\n¢\u0006\u0004\ba\u0010\fJ\u0017\u0010c\u001a\u00020\u00042\b\b\u0002\u0010b\u001a\u00020\n¢\u0006\u0004\bc\u00109J\u0015\u0010e\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u001e¢\u0006\u0004\be\u0010fJ\u001d\u0010i\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020g¢\u0006\u0004\bi\u0010jJ\r\u0010k\u001a\u00020\u0004¢\u0006\u0004\bk\u0010\u0003J\r\u0010l\u001a\u00020\u0004¢\u0006\u0004\bl\u0010\u0003J\r\u0010m\u001a\u00020\u0004¢\u0006\u0004\bm\u0010\u0003J\r\u0010n\u001a\u00020\u0004¢\u0006\u0004\bn\u0010\u0003J\r\u0010o\u001a\u00020\u0004¢\u0006\u0004\bo\u0010\u0003J\r\u0010p\u001a\u00020\u0004¢\u0006\u0004\bp\u0010\u0003J\r\u0010q\u001a\u00020\u0004¢\u0006\u0004\bq\u0010\u0003J\r\u0010r\u001a\u00020\u0004¢\u0006\u0004\br\u0010\u0003J\u0015\u0010s\u001a\u00020\n2\u0006\u0010d\u001a\u00020\u001e¢\u0006\u0004\bs\u0010tJ\r\u0010u\u001a\u00020\n¢\u0006\u0004\bu\u0010\fJ\r\u0010v\u001a\u00020\n¢\u0006\u0004\bv\u0010\fJ\u0015\u0010x\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\n¢\u0006\u0004\bx\u00109J\r\u0010y\u001a\u00020\n¢\u0006\u0004\by\u0010\fJ\r\u0010z\u001a\u00020\n¢\u0006\u0004\bz\u0010\fJ\u0015\u0010{\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u001e¢\u0006\u0004\b{\u0010[J\u0017\u0010|\u001a\u00020\n2\b\u0010Y\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b|\u0010tJ\r\u0010}\u001a\u00020\n¢\u0006\u0004\b}\u0010\fJ\u0018\u0010\u007f\u001a\u0004\u0018\u00010E2\u0006\u0010~\u001a\u00020\u001e¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u000f\u0010\u0081\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0081\u0001\u0010\u0017J\"\u0010\u0082\u0001\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010C\u001a\u00020\n¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001a\u0010\u0084\u0001\u001a\u0004\u0018\u00010E2\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0018\u0010\u0087\u0001\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0087\u0001\u0010$J\u000f\u0010\u0088\u0001\u001a\u00020\u0004¢\u0006\u0005\b\u0088\u0001\u0010\u0003J)\u0010\u008a\u0001\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00062\u0007\u0010\u0089\u0001\u001a\u00020\n¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0017\u0010\u008c\u0001\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\n¢\u0006\u0005\b\u008c\u0001\u00109J\u0017\u0010\u008d\u0001\u001a\u00020\n2\u0006\u0010~\u001a\u00020\u001e¢\u0006\u0005\b\u008d\u0001\u0010tJ\u0017\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\u001e¢\u0006\u0005\b\u008e\u0001\u0010fJ\u001a\u0010\u0091\u0001\u001a\u00020\u00042\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0017\u0010\u0093\u0001\u001a\u00020\u001e8\u0006X\u0086T¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0017\u0010\u0095\u0001\u001a\u00020\u001e8\u0006X\u0086T¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0094\u0001R\u0017\u0010\u0096\u0001\u001a\u00020\u001e8\u0006X\u0086T¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0094\u0001R\u0017\u0010\u0097\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u0099\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0098\u0001R\u0017\u0010\u009a\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0098\u0001R\u0017\u0010\u009b\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0098\u0001R\u0017\u0010\u009c\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u0098\u0001R\u0017\u0010\u009d\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u0098\u0001R\u0017\u0010\u009e\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u0098\u0001R\u0017\u0010\u009f\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u0098\u0001R\u0017\u0010 \u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b \u0001\u0010\u0098\u0001R\u0017\u0010¡\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¡\u0001\u0010\u0098\u0001R\u0017\u0010¢\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¢\u0001\u0010\u0098\u0001R\u0017\u0010£\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b£\u0001\u0010\u0098\u0001R\u0017\u0010¤\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¤\u0001\u0010\u0098\u0001R\u0017\u0010¥\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¥\u0001\u0010\u0098\u0001R\u0017\u0010¦\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¦\u0001\u0010\u0098\u0001R\u0017\u0010§\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b§\u0001\u0010\u0098\u0001R\u0017\u0010¨\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¨\u0001\u0010\u0098\u0001R\u0017\u0010©\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b©\u0001\u0010\u0098\u0001R\u0017\u0010ª\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\bª\u0001\u0010\u0098\u0001R\u0017\u0010«\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b«\u0001\u0010\u0098\u0001R\u0017\u0010¬\u0001\u001a\u00020\u00068\u0006X\u0086T¢\u0006\b\n\u0006\b¬\u0001\u0010\u0098\u0001R\u001d\u0010®\u0001\u001a\u00030\u00ad\u00018\u0006¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R0\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R0\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010´\u0001\u001a\u0006\bº\u0001\u0010¶\u0001\"\u0006\b»\u0001\u0010¸\u0001R0\u0010¼\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010´\u0001\u001a\u0006\b½\u0001\u0010¶\u0001\"\u0006\b¾\u0001\u0010¸\u0001R8\u0010¿\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001e0>j\b\u0012\u0004\u0012\u00020\u001e`@8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0005\bÁ\u0001\u0010B\"\u0006\bÂ\u0001\u0010Ã\u0001R'\u0010Ä\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0005\bÆ\u0001\u0010\f\"\u0005\bÇ\u0001\u00109R'\u0010È\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÈ\u0001\u0010Å\u0001\u001a\u0005\bÈ\u0001\u0010\f\"\u0005\bÉ\u0001\u00109R$\u0010Ì\u0001\u001a\n\u0012\u0005\u0012\u00030Ë\u00010Ê\u00018\u0006¢\u0006\u0010\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001R$\u0010Ð\u0001\u001a\n\u0012\u0005\u0012\u00030Ë\u00010Ê\u00018\u0006¢\u0006\u0010\n\u0006\bÐ\u0001\u0010Í\u0001\u001a\u0006\bÑ\u0001\u0010Ï\u0001R5\u0010Ò\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020E0D8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R5\u0010Ø\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020E0D8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ó\u0001\u001a\u0006\bÙ\u0001\u0010Õ\u0001\"\u0006\bÚ\u0001\u0010×\u0001RU\u0010Ý\u0001\u001a\u0014\u0012\u0005\u0012\u00030Û\u00010>j\t\u0012\u0005\u0012\u00030Û\u0001`@2\u0019\u0010Ü\u0001\u001a\u0014\u0012\u0005\u0012\u00030Û\u00010>j\t\u0012\u0005\u0012\u00030Û\u0001`@8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\bÝ\u0001\u0010À\u0001\u001a\u0005\bÞ\u0001\u0010B\"\u0006\bß\u0001\u0010Ã\u0001R(\u0010à\u0001\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bà\u0001\u0010\u0094\u0001\u001a\u0006\bá\u0001\u0010â\u0001\"\u0005\bã\u0001\u0010fR(\u0010ä\u0001\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bä\u0001\u0010\u0094\u0001\u001a\u0006\bå\u0001\u0010â\u0001\"\u0005\bæ\u0001\u0010fR(\u0010ç\u0001\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bç\u0001\u0010\u0094\u0001\u001a\u0006\bè\u0001\u0010â\u0001\"\u0005\bé\u0001\u0010fR'\u0010ê\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bê\u0001\u0010\u0098\u0001\u001a\u0005\bë\u0001\u0010\u0017\"\u0005\bì\u0001\u0010$R'\u0010í\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bí\u0001\u0010\u0098\u0001\u001a\u0005\bî\u0001\u0010\u0017\"\u0005\bï\u0001\u0010$R(\u0010ð\u0001\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bð\u0001\u0010\u0094\u0001\u001a\u0006\bñ\u0001\u0010â\u0001\"\u0005\bò\u0001\u0010fR'\u0010ó\u0001\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bó\u0001\u0010Å\u0001\u001a\u0005\bô\u0001\u0010\f\"\u0005\bõ\u0001\u00109R'\u0010ö\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bö\u0001\u0010\u0098\u0001\u001a\u0005\b÷\u0001\u0010\u0017\"\u0005\bø\u0001\u0010$R\u001b\u0010ù\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R(\u0010û\u0001\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bû\u0001\u0010\u0094\u0001\u001a\u0006\bü\u0001\u0010â\u0001\"\u0005\bý\u0001\u0010fR1\u0010\u0080\u0002\u001a\n\u0012\u0005\u0012\u00030ÿ\u00010þ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R'\u0010\u0086\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0086\u0002\u0010\u0098\u0001\u001a\u0005\b\u0087\u0002\u0010\u0017\"\u0005\b\u0088\u0002\u0010$R'\u0010\u0089\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0089\u0002\u0010\u0098\u0001\u001a\u0005\b\u008a\u0002\u0010\u0017\"\u0005\b\u008b\u0002\u0010$R)\u0010\u008c\u0002\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u008c\u0002\u0010\u008d\u0002\u001a\u0005\b\u008e\u0002\u00101\"\u0005\b\u008f\u0002\u0010/R,\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0002\u0010\u0092\u0002\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002\"\u0006\b\u0095\u0002\u0010\u0096\u0002R,\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0002\u0010\u0099\u0002\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010\u009d\u0002R,\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0002\u0010\u0092\u0002\u001a\u0006\b\u009f\u0002\u0010\u0094\u0002\"\u0006\b \u0002\u0010\u0096\u0002R,\u0010¡\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¡\u0002\u0010\u0099\u0002\u001a\u0006\b¢\u0002\u0010\u009b\u0002\"\u0006\b£\u0002\u0010\u009d\u0002R,\u0010¤\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0002\u0010\u0092\u0002\u001a\u0006\b¥\u0002\u0010\u0094\u0002\"\u0006\b¦\u0002\u0010\u0096\u0002R,\u0010§\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0002\u0010\u0099\u0002\u001a\u0006\b¨\u0002\u0010\u009b\u0002\"\u0006\b©\u0002\u0010\u009d\u0002R,\u0010ª\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bª\u0002\u0010\u0092\u0002\u001a\u0006\b«\u0002\u0010\u0094\u0002\"\u0006\b¬\u0002\u0010\u0096\u0002R,\u0010\u00ad\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0002\u0010\u0099\u0002\u001a\u0006\b®\u0002\u0010\u009b\u0002\"\u0006\b¯\u0002\u0010\u009d\u0002R,\u0010°\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b°\u0002\u0010\u0092\u0002\u001a\u0006\b±\u0002\u0010\u0094\u0002\"\u0006\b²\u0002\u0010\u0096\u0002R,\u0010³\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0002\u0010\u0099\u0002\u001a\u0006\b´\u0002\u0010\u009b\u0002\"\u0006\bµ\u0002\u0010\u009d\u0002R,\u0010¶\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¶\u0002\u0010\u0092\u0002\u001a\u0006\b·\u0002\u0010\u0094\u0002\"\u0006\b¸\u0002\u0010\u0096\u0002R,\u0010¹\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¹\u0002\u0010\u0099\u0002\u001a\u0006\bº\u0002\u0010\u009b\u0002\"\u0006\b»\u0002\u0010\u009d\u0002R,\u0010¼\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¼\u0002\u0010\u0092\u0002\u001a\u0006\b½\u0002\u0010\u0094\u0002\"\u0006\b¾\u0002\u0010\u0096\u0002R,\u0010¿\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¿\u0002\u0010\u0099\u0002\u001a\u0006\bÀ\u0002\u0010\u009b\u0002\"\u0006\bÁ\u0002\u0010\u009d\u0002R,\u0010Â\u0002\u001a\u0005\u0018\u00010\u0090\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0002\u0010\u0092\u0002\u001a\u0006\bÃ\u0002\u0010\u0094\u0002\"\u0006\bÄ\u0002\u0010\u0096\u0002R,\u0010Å\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÅ\u0002\u0010\u0099\u0002\u001a\u0006\bÆ\u0002\u0010\u009b\u0002\"\u0006\bÇ\u0002\u0010\u009d\u0002R,\u0010É\u0002\u001a\u0005\u0018\u00010È\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÉ\u0002\u0010Ê\u0002\u001a\u0006\bË\u0002\u0010Ì\u0002\"\u0006\bÍ\u0002\u0010Î\u0002R,\u0010Ð\u0002\u001a\u0005\u0018\u00010Ï\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÐ\u0002\u0010Ñ\u0002\u001a\u0006\bÒ\u0002\u0010Ó\u0002\"\u0006\bÔ\u0002\u0010Õ\u0002R,\u0010×\u0002\u001a\u0005\u0018\u00010Ö\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b×\u0002\u0010Ø\u0002\u001a\u0006\bÙ\u0002\u0010Ú\u0002\"\u0006\bÛ\u0002\u0010Ü\u0002R,\u0010Þ\u0002\u001a\u0005\u0018\u00010Ý\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÞ\u0002\u0010ß\u0002\u001a\u0006\bà\u0002\u0010á\u0002\"\u0006\bâ\u0002\u0010ã\u0002R:\u0010å\u0002\u001a\u0014\u0012\u0005\u0012\u00030ä\u00020>j\t\u0012\u0005\u0012\u00030ä\u0002`@8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bå\u0002\u0010À\u0001\u001a\u0005\bæ\u0002\u0010B\"\u0006\bç\u0002\u0010Ã\u0001R,\u0010é\u0002\u001a\u0005\u0018\u00010è\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bé\u0002\u0010ê\u0002\u001a\u0006\bë\u0002\u0010ì\u0002\"\u0006\bí\u0002\u0010î\u0002R,\u0010ð\u0002\u001a\u0005\u0018\u00010ï\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bð\u0002\u0010ñ\u0002\u001a\u0006\bò\u0002\u0010ó\u0002\"\u0006\bô\u0002\u0010õ\u0002R'\u0010ö\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bö\u0002\u0010Å\u0001\u001a\u0005\bö\u0002\u0010\f\"\u0005\b÷\u0002\u00109R'\u0010ø\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bø\u0002\u0010Å\u0001\u001a\u0005\bø\u0002\u0010\f\"\u0005\bù\u0002\u00109R'\u0010ú\u0002\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bú\u0002\u0010Å\u0001\u001a\u0005\bú\u0002\u0010\f\"\u0005\bû\u0002\u00109R'\u0010ü\u0002\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bü\u0002\u0010\u0098\u0001\u001a\u0005\bý\u0002\u0010\u0017\"\u0005\bþ\u0002\u0010$R,\u0010\u0080\u0003\u001a\u0005\u0018\u00010ÿ\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0003\u0010\u0081\u0003\u001a\u0006\b\u0082\u0003\u0010\u0083\u0003\"\u0006\b\u0084\u0003\u0010\u0085\u0003R+\u0010\u0086\u0003\u001a\u0012\u0012\u0004\u0012\u00020%0>j\b\u0012\u0004\u0012\u00020%`@8\u0006¢\u0006\u000f\n\u0006\b\u0086\u0003\u0010À\u0001\u001a\u0005\b\u0087\u0003\u0010BR+\u0010\u0088\u0003\u001a\u0012\u0012\u0004\u0012\u00020)0>j\b\u0012\u0004\u0012\u00020)`@8\u0006¢\u0006\u000f\n\u0006\b\u0088\u0003\u0010À\u0001\u001a\u0005\b\u0089\u0003\u0010BR+\u0010\u008a\u0003\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0003\u0010\u008b\u0003\u001a\u0006\b\u008c\u0003\u0010\u008d\u0003\"\u0006\b\u008e\u0003\u0010\u008f\u0003R8\u0010\u0091\u0003\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0090\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0003\u0010\u0092\u0003\u001a\u0006\b\u0093\u0003\u0010\u0094\u0003\"\u0006\b\u0095\u0003\u0010\u0096\u0003R0\u0010\u0097\u0003\u001a\t\u0012\u0004\u0012\u00020\r0²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0003\u0010´\u0001\u001a\u0006\b\u0098\u0003\u0010¶\u0001\"\u0006\b\u0099\u0003\u0010¸\u0001R'\u0010\u009a\u0003\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u009a\u0003\u0010\u0098\u0001\u001a\u0005\b\u009b\u0003\u0010\u0017\"\u0005\b\u009c\u0003\u0010$R*\u0010\u009e\u0003\u001a\u00030\u009d\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009e\u0003\u0010\u009f\u0003\u001a\u0006\b \u0003\u0010¡\u0003\"\u0006\b¢\u0003\u0010£\u0003¨\u0006¤\u0003"}, d2 = {"Lcom/qiahao/nextvideo/room/manager/MeetingRoomManager;", "", "<init>", "()V", "", "mySelfDownMicAndCloseMusic", "", "type", "getMicSize", "(I)I", "", "isCanShowSmallLuckyRouletteOrBox", "()Z", "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", Constants.SHARED_MESSAGE_ID_FILE, "addRoomMessage", "(Lcom/qiahao/hilo_message/data/RoomMessageMulti;)V", GameMatchActivity.GAME_ID, "isLuckyGame", "(I)Z", "isCanShowSmallLuckyFruit", "isCanShowFoodie", "getCurrentMicSize", "()I", "level", "getLevelRes", "getGameLevelRes", "getSupportMedal", "getRoomPKGameIcon", "(I)Ljava/lang/Integer;", "", "getRoomPKTitle", "(I)Ljava/lang/String;", "getLevelString", "agoraId", "addCurrentUserSaid", "(I)V", "Lcom/qiahao/nextvideo/data/model/GiftBannerData;", "globalGiftBanner", "addReceiverGiftTip", "(Lcom/qiahao/nextvideo/data/model/GiftBannerData;)V", "Lcom/qiahao/nextvideo/data/room/GiftBannerButtonData;", "addGiftBannerButtonData", "(Lcom/qiahao/nextvideo/data/room/GiftBannerButtonData;)V", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "groupDetailBean", "setGroupDetailBean", "(Lcom/qiahao/nextvideo/data/model/GroupDetailBean;)V", "getGroupDetailBean", "()Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "checkOwnOrManager", TUIConstants.TUILive.ROOM_STATUS, "changeRoomStatus", "isRoomSmall", "isRoomOpen", "isNeedConfig", "setLuckyFruitConfirm", "(Z)V", "getLuckyFruitConfirm", "isOpenMic", "setLocalRoomMicStatus", "getLocalRoomMicStatus", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Lkotlin/collections/ArrayList;", "getGameList", "()Ljava/util/ArrayList;", "isOther", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "getMicQueue", "(Z)Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/qiahao/nextvideo/room/music/c;", "getMusicManager", "()Lcom/qiahao/nextvideo/room/music/c;", "content", "isMe", "changeMicMapData", "(Ljava/lang/String;Z)V", "microBean", "changeMicData", "(Lcom/qiahao/nextvideo/data/model/MicroBean;Z)V", "isMute", "setMicMemberAllRemoteMute", "changePKRoomMic", "isRed", "checkPKRoomMic", "(Z)Z", "getMicQueueMemberList", "extraId", "getRoomUserRole", "(Ljava/lang/String;)I", "initSize", "emptyMicInit", "hasInitEmoji", "joinRoom", "smallRoom", "checkMatchGame", "needFetchLeaveRoom", "leaveRoom", "groupId", "imLeaveGroup", "(Ljava/lang/String;)V", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "callBack", "imJoinGroup", "(Ljava/lang/String;Lcom/tencent/imsdk/v2/V2TIMCallback;)V", "saveCreateLudoDateAndClear", "saveCreateUnoDateAndClear", "saveCreateDominoDateAndClear", "saveCreateCrushDateAndClear", "saveCreateBalootDateAndClear", "saveCreateCarromDateAndClear", "saveCreateJackaroDateAndClear", "saveCreateBackgammonDateAndClear", "currentInRoom", "(Ljava/lang/String;)Z", "checkGameMadel", "checkShowEffect", "isOpenLocalAudio", "enableLocalAudio", "checkPKMadel", "checkOpenHiloGame", "findMicPositionFromExtraId", "checkUserOnMic", "isMySelfOnMic", SupportGiftRankActivity.EXTERNAL_ID, "checkUserMic", "(Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/MicroBean;", "findNullMicPosition", "findMicPositionFromAgoraId", "(IZ)I", "findMicInfoFromAgoraId", "(I)Lcom/qiahao/nextvideo/data/model/MicroBean;", ExchangeDetailActivity.TYPE_DIAMOND, "setTaskMicCompletePairs", "getRoomRole", "abc", "localMute", "(Ljava/lang/String;IZ)V", "adjustRecordingSignalVolume", "haveLocalMute", "removeLocalMute", "Lcom/qiahao/base_common/model/ActivityDetailData;", "data", "subscribActivity", "(Lcom/qiahao/base_common/model/ActivityDetailData;)V", "TAG", "Ljava/lang/String;", "IS_OPEN_ROOM_MIC", "IS_LUCKY_FRUIT_CONFIG", "ROOM_MIC_TYPE_ONE", "I", "ROOM_MIC_TYPE_TWO", "ROOM_MIC_TYPE_THREE", "ROOM_MIC_TYPE_FOUR", "ROOM_MIC_TYPE_FIVE", "ROOM_MIC_TYPE_SIX", "ROOM_MIC_TYPE_SEVEN", "ROOM_MIC_TYPE_EIGHT", "ROOM_MIC_TYPE_NINE", "ROOM_MIC_TYPE_TEN", "ROOM_MIC_TYPE_ELEVEN", "ROOM_MIC_TYPE_TWELVE", "ROOM_MIC_TYPE_THIRTEEN", "ROOM_MIC_TYPE_FIFTEEN", "ROOM_MIC_TYPE_SIXTEEN", "ROOM_MIC_TYPE_SEVENTEEN", "ROOM_MIC_TYPE_EIGHTEEN", "ROOM_MIC_TYPE_TWENTY", "ROOM_STATUS_OPEN", "ROOM_STATUS_SMALL", "ROOM_STATUS_CLOSE", "Lnd/a;", "mConpose", "Lnd/a;", "getMConpose", "()Lnd/a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mCurrentSayIdArrayList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getMCurrentSayIdArrayList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setMCurrentSayIdArrayList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "mNewMicArrayList", "getMNewMicArrayList", "setMNewMicArrayList", "mOldMicArrayList", "getMOldMicArrayList", "setMOldMicArrayList", "localMuteList", "Ljava/util/ArrayList;", "getLocalMuteList", "setLocalMuteList", "(Ljava/util/ArrayList;)V", "micPermission", "Z", "getMicPermission", "setMicPermission", "is1V1", "set1V1", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "wsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getWsFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "wsFlowGift", "getWsFlowGift", "mMicQueueMemberMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getMMicQueueMemberMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setMMicQueueMemberMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "mPKMicQueueMemberMap", "getMPKMicQueueMemberMap", "setMPKMicQueueMemberMap", "Lcom/qiahao/base_common/model/RoomRuleBean;", "value", "mRoomUserRoleList", "getMRoomUserRoleList", "setMRoomUserRoleList", "mRoomChannelId", "getMRoomChannelId", "()Ljava/lang/String;", "setMRoomChannelId", "mGroupId", "getMGroupId", "setMGroupId", "mAgoraToken", "getMAgoraToken", "setMAgoraToken", "mAgoraId", "getMAgoraId", "setMAgoraId", "mProvider", "getMProvider", "setMProvider", "mPassword", "getMPassword", "setMPassword", "mRoomMute", "getMRoomMute", "setMRoomMute", "mOldPKGameID", "getMOldPKGameID", "setMOldPKGameID", "mMusicManager", "Lcom/qiahao/nextvideo/room/music/c;", "mCurrentAgoraChannelId", "getMCurrentAgoraChannelId", "setMCurrentAgoraChannelId", "", "Lcom/qiahao/nextvideo/data/model/EmojiBean;", "mMicEmoji", "Ljava/util/List;", "getMMicEmoji", "()Ljava/util/List;", "setMMicEmoji", "(Ljava/util/List;)V", "mCurrentRoomMicType", "getMCurrentRoomMicType", "setMCurrentRoomMicType", "mRoomStatus", "getMRoomStatus", "setMRoomStatus", "mGroupDetailBean", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "getMGroupDetailBean", "setMGroupDetailBean", "Lcom/qiahao/nextvideo/data/game/SUDGameData;", "mLudoGameData", "Lcom/qiahao/nextvideo/data/game/SUDGameData;", "getMLudoGameData", "()Lcom/qiahao/nextvideo/data/game/SUDGameData;", "setMLudoGameData", "(Lcom/qiahao/nextvideo/data/game/SUDGameData;)V", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "mCreateLudoData", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "getMCreateLudoData", "()Lcom/qiahao/nextvideo/data/game/CreateSudData;", "setMCreateLudoData", "(Lcom/qiahao/nextvideo/data/game/CreateSudData;)V", "mUnoGameData", "getMUnoGameData", "setMUnoGameData", "mCreateUnoData", "getMCreateUnoData", "setMCreateUnoData", "mDominoGameData", "getMDominoGameData", "setMDominoGameData", "mCreateDominoData", "getMCreateDominoData", "setMCreateDominoData", "mCrushGameData", "getMCrushGameData", "setMCrushGameData", "mCreateCrushData", "getMCreateCrushData", "setMCreateCrushData", "mBalootGameData", "getMBalootGameData", "setMBalootGameData", "mCreateBalootData", "getMCreateBalootData", "setMCreateBalootData", "mCarromGameData", "getMCarromGameData", "setMCarromGameData", "mCreateCarromData", "getMCreateCarromData", "setMCreateCarromData", "mJackaroGameData", "getMJackaroGameData", "setMJackaroGameData", "mCreateJackaroData", "getMCreateJackaroData", "setMCreateJackaroData", "mBackgammonGameData", "getMBackgammonGameData", "setMBackgammonGameData", "mCreateBackgammonData", "getMCreateBackgammonData", "setMCreateBackgammonData", "Lcom/qiahao/nextvideo/data/room/RoomPK;", "mPK", "Lcom/qiahao/nextvideo/data/room/RoomPK;", "getMPK", "()Lcom/qiahao/nextvideo/data/room/RoomPK;", "setMPK", "(Lcom/qiahao/nextvideo/data/room/RoomPK;)V", "Lcom/qiahao/nextvideo/data/game/Pk1v1Data;", "mPK1v1", "Lcom/qiahao/nextvideo/data/game/Pk1v1Data;", "getMPK1v1", "()Lcom/qiahao/nextvideo/data/game/Pk1v1Data;", "setMPK1v1", "(Lcom/qiahao/nextvideo/data/game/Pk1v1Data;)V", "Lcom/qiahao/nextvideo/data/game/YouTuGameData;", "mYouTuBe", "Lcom/qiahao/nextvideo/data/game/YouTuGameData;", "getMYouTuBe", "()Lcom/qiahao/nextvideo/data/game/YouTuGameData;", "setMYouTuBe", "(Lcom/qiahao/nextvideo/data/game/YouTuGameData;)V", "Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "mEnvelopeData", "Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "getMEnvelopeData", "()Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "setMEnvelopeData", "(Lcom/qiahao/nextvideo/data/room/EnvelopeData;)V", "Lcom/qiahao/nextvideo/data/room/BoxLevel;", "mBoxLevel", "getMBoxLevel", "setMBoxLevel", "Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "mPKGame", "Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "getMPKGame", "()Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "setMPKGame", "(Lcom/qiahao/nextvideo/data/room/PKInviteCancel;)V", "Ljava/util/Timer;", "mMicInfoTimer", "Ljava/util/Timer;", "getMMicInfoTimer", "()Ljava/util/Timer;", "setMMicInfoTimer", "(Ljava/util/Timer;)V", "isShowGiftEffect", "setShowGiftEffect", "isShowEnterEffect", "setShowEnterEffect", "isShowRocketEffect", "setShowRocketEffect", "mRoomOnLine", "getMRoomOnLine", "setMRoomOnLine", "Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "mRoomLuckWheelInfo", "Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "getMRoomLuckWheelInfo", "()Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "setMRoomLuckWheelInfo", "(Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;)V", "mReceiverGlobalGiftSvgaList", "getMReceiverGlobalGiftSvgaList", "mGiftBannerButtonList", "getMGiftBannerButtonList", "mHiloGameConfiguration", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "getMHiloGameConfiguration", "()Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "setMHiloGameConfiguration", "(Lcom/qiahao/nextvideo/data/model/GameConfiguration;)V", "Lkotlin/Pair;", "mTaskMicCompletePairs", "Lkotlin/Pair;", "getMTaskMicCompletePairs", "()Lkotlin/Pair;", "setMTaskMicCompletePairs", "(Lkotlin/Pair;)V", "mRoomMessageData", "getMRoomMessageData", "setMRoomMessageData", "mRoomChatTab", "getMRoomChatTab", "setMRoomChatTab", "", "mRequestMicTime", "J", "getMRequestMicTime", "()J", "setMRequestMicTime", "(J)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMeetingRoomManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeetingRoomManager.kt\ncom/qiahao/nextvideo/room/manager/MeetingRoomManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1370:1\n1869#2,2:1371\n1869#2,2:1373\n1869#2,2:1375\n1869#2,2:1377\n1#3:1379\n*S KotlinDebug\n*F\n+ 1 MeetingRoomManager.kt\ncom/qiahao/nextvideo/room/manager/MeetingRoomManager\n*L\n321#1:1371,2\n338#1:1373,2\n790#1:1375,2\n1327#1:1377,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MeetingRoomManager {

    @NotNull
    public static final MeetingRoomManager INSTANCE;

    @NotNull
    public static final String IS_LUCKY_FRUIT_CONFIG = "isLuckyFruitConfig";

    @NotNull
    public static final String IS_OPEN_ROOM_MIC = "isOpenRoomMic";
    public static final int ROOM_MIC_TYPE_EIGHT = 8;
    public static final int ROOM_MIC_TYPE_EIGHTEEN = 18;
    public static final int ROOM_MIC_TYPE_ELEVEN = 11;
    public static final int ROOM_MIC_TYPE_FIFTEEN = 15;
    public static final int ROOM_MIC_TYPE_FIVE = 1;
    public static final int ROOM_MIC_TYPE_FOUR = 4;
    public static final int ROOM_MIC_TYPE_NINE = 9;
    public static final int ROOM_MIC_TYPE_ONE = 5;
    public static final int ROOM_MIC_TYPE_SEVEN = 7;
    public static final int ROOM_MIC_TYPE_SEVENTEEN = 17;
    public static final int ROOM_MIC_TYPE_SIX = 6;
    public static final int ROOM_MIC_TYPE_SIXTEEN = 16;
    public static final int ROOM_MIC_TYPE_TEN = 2;
    public static final int ROOM_MIC_TYPE_THIRTEEN = 13;
    public static final int ROOM_MIC_TYPE_THREE = 3;
    public static final int ROOM_MIC_TYPE_TWELVE = 12;
    public static final int ROOM_MIC_TYPE_TWENTY = 20;
    public static final int ROOM_MIC_TYPE_TWO = 10;
    public static final int ROOM_STATUS_CLOSE = 0;
    public static final int ROOM_STATUS_OPEN = 2;
    public static final int ROOM_STATUS_SMALL = 1;

    @NotNull
    public static final String TAG = "MeetingRoomManager";
    private static boolean is1V1;
    private static boolean isShowEnterEffect;
    private static boolean isShowGiftEffect;
    private static boolean isShowRocketEffect;

    @NotNull
    private static ArrayList<String> localMuteList;
    private static int mAgoraId;

    @NotNull
    private static String mAgoraToken;

    @Nullable
    private static SUDGameData mBackgammonGameData;

    @Nullable
    private static SUDGameData mBalootGameData;

    @NotNull
    private static ArrayList<BoxLevel> mBoxLevel;

    @Nullable
    private static SUDGameData mCarromGameData;

    @NotNull
    private static final nd.a mConpose;

    @Nullable
    private static CreateSudData mCreateBackgammonData;

    @Nullable
    private static CreateSudData mCreateBalootData;

    @Nullable
    private static CreateSudData mCreateCarromData;

    @Nullable
    private static CreateSudData mCreateCrushData;

    @Nullable
    private static CreateSudData mCreateDominoData;

    @Nullable
    private static CreateSudData mCreateJackaroData;

    @Nullable
    private static CreateSudData mCreateLudoData;

    @Nullable
    private static CreateSudData mCreateUnoData;

    @Nullable
    private static SUDGameData mCrushGameData;

    @NotNull
    private static String mCurrentAgoraChannelId;
    private static int mCurrentRoomMicType;

    @NotNull
    private static CopyOnWriteArrayList<Integer> mCurrentSayIdArrayList;

    @Nullable
    private static SUDGameData mDominoGameData;

    @Nullable
    private static EnvelopeData mEnvelopeData;

    @NotNull
    private static final ArrayList<GiftBannerButtonData> mGiftBannerButtonList;

    @Nullable
    private static GroupDetailBean mGroupDetailBean;

    @NotNull
    private static String mGroupId;

    @Nullable
    private static GameConfiguration mHiloGameConfiguration;

    @Nullable
    private static SUDGameData mJackaroGameData;

    @Nullable
    private static SUDGameData mLudoGameData;

    @NotNull
    private static List<EmojiBean> mMicEmoji;

    @Nullable
    private static Timer mMicInfoTimer;

    @NotNull
    private static ConcurrentHashMap<Integer, MicroBean> mMicQueueMemberMap;

    @Nullable
    private static com.qiahao.nextvideo.room.music.c mMusicManager;

    @NotNull
    private static CopyOnWriteArrayList<Integer> mNewMicArrayList;

    @NotNull
    private static CopyOnWriteArrayList<Integer> mOldMicArrayList;
    private static int mOldPKGameID;

    @Nullable
    private static RoomPK mPK;

    @Nullable
    private static Pk1v1Data mPK1v1;

    @Nullable
    private static PKInviteCancel mPKGame;

    @NotNull
    private static ConcurrentHashMap<Integer, MicroBean> mPKMicQueueMemberMap;

    @NotNull
    private static String mPassword;
    private static int mProvider;

    @NotNull
    private static final ArrayList<GiftBannerData> mReceiverGlobalGiftSvgaList;
    private static long mRequestMicTime;

    @NotNull
    private static String mRoomChannelId;
    private static int mRoomChatTab;

    @Nullable
    private static LuckWheelInfo mRoomLuckWheelInfo;

    @NotNull
    private static CopyOnWriteArrayList<RoomMessageMulti> mRoomMessageData;
    private static boolean mRoomMute;
    private static int mRoomOnLine;
    private static int mRoomStatus;

    @NotNull
    private static ArrayList<RoomRuleBean> mRoomUserRoleList;

    @Nullable
    private static Pair<Boolean, Integer> mTaskMicCompletePairs;

    @Nullable
    private static SUDGameData mUnoGameData;

    @Nullable
    private static YouTuGameData mYouTuBe;
    private static boolean micPermission;

    @NotNull
    private static final MutableSharedFlow<RoomEvent> wsFlow;

    @NotNull
    private static final MutableSharedFlow<RoomEvent> wsFlowGift;

    static {
        MeetingRoomManager meetingRoomManager = new MeetingRoomManager();
        INSTANCE = meetingRoomManager;
        mConpose = new nd.a();
        mCurrentSayIdArrayList = new CopyOnWriteArrayList<>();
        mNewMicArrayList = new CopyOnWriteArrayList<>();
        mOldMicArrayList = new CopyOnWriteArrayList<>();
        localMuteList = new ArrayList<>();
        emptyMicInit$default(meetingRoomManager, 0, 1, null);
        BufferOverflow bufferOverflow = BufferOverflow.DROP_OLDEST;
        wsFlow = SharedFlowKt.MutableSharedFlow(0, 500, bufferOverflow);
        wsFlowGift = SharedFlowKt.MutableSharedFlow(0, 500, bufferOverflow);
        mMicQueueMemberMap = new ConcurrentHashMap<>();
        mPKMicQueueMemberMap = new ConcurrentHashMap<>();
        mRoomUserRoleList = new ArrayList<>();
        mRoomChannelId = "";
        mGroupId = "";
        mAgoraToken = "";
        mProvider = -1;
        mPassword = "";
        mOldPKGameID = -1;
        mCurrentAgoraChannelId = "";
        mMicEmoji = new ArrayList();
        mCurrentRoomMicType = 5;
        mBoxLevel = new ArrayList<>();
        isShowGiftEffect = true;
        isShowEnterEffect = true;
        isShowRocketEffect = true;
        mReceiverGlobalGiftSvgaList = new ArrayList<>();
        mGiftBannerButtonList = new ArrayList<>();
        mRoomMessageData = new CopyOnWriteArrayList<>();
    }

    private MeetingRoomManager() {
    }

    public static /* synthetic */ void changeMicData$default(MeetingRoomManager meetingRoomManager, MicroBean microBean, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        meetingRoomManager.changeMicData(microBean, z);
    }

    public static final Unit changeMicData$lambda$4() {
        INSTANCE.setMicMemberAllRemoteMute(!r0.getLocalRoomMicStatus());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void changeMicMapData$default(MeetingRoomManager meetingRoomManager, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        meetingRoomManager.changeMicMapData(str, z);
    }

    public static final void changeMicMapData$lambda$2(MicroBean microBean, boolean z) {
        MeetingRoomManager meetingRoomManager = INSTANCE;
        Intrinsics.checkNotNull(microBean);
        meetingRoomManager.changeMicData(microBean, z);
    }

    public static /* synthetic */ void emptyMicInit$default(MeetingRoomManager meetingRoomManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        meetingRoomManager.emptyMicInit(i);
    }

    public static /* synthetic */ int findMicPositionFromAgoraId$default(MeetingRoomManager meetingRoomManager, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return meetingRoomManager.findMicPositionFromAgoraId(i, z);
    }

    public static /* synthetic */ ConcurrentHashMap getMicQueue$default(MeetingRoomManager meetingRoomManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return meetingRoomManager.getMicQueue(z);
    }

    public static final Unit getRoomRole$lambda$18(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        mRoomUserRoleList.clear();
        List list = (List) apiResponse.getData();
        if (list != null) {
            mRoomUserRoleList.addAll(list);
        }
        return Unit.INSTANCE;
    }

    public static final Unit getRoomRole$lambda$19(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "getMicInfo: 获取房间用户权限列表报错！！！");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void leaveRoom$default(MeetingRoomManager meetingRoomManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        meetingRoomManager.leaveRoom(z);
    }

    private final void mySelfDownMicAndCloseMusic() {
        String str;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        int findMicPositionFromExtraId = findMicPositionFromExtraId(str);
        if (findMicPositionFromExtraId > 0) {
            getMusicManager().q();
            RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().downMic(mGroupId, findMicPositionFromExtraId), new Function1() { // from class: com.qiahao.nextvideo.room.manager.h
                public final Object invoke(Object obj) {
                    Unit mySelfDownMicAndCloseMusic$lambda$7;
                    mySelfDownMicAndCloseMusic$lambda$7 = MeetingRoomManager.mySelfDownMicAndCloseMusic$lambda$7((ApiResponse) obj);
                    return mySelfDownMicAndCloseMusic$lambda$7;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.manager.i
                public final Object invoke(Object obj) {
                    Unit mySelfDownMicAndCloseMusic$lambda$8;
                    mySelfDownMicAndCloseMusic$lambda$8 = MeetingRoomManager.mySelfDownMicAndCloseMusic$lambda$8((Throwable) obj);
                    return mySelfDownMicAndCloseMusic$lambda$8;
                }
            }, (Function0) null, false, 12, (Object) null);
        }
    }

    public static final Unit mySelfDownMicAndCloseMusic$lambda$7(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            Log.d(TAG, "mySelfDownMic: 下麦成功" + apiResponse.getMessage());
        } else {
            Log.d(TAG, "mySelfDownMic: 下麦失败" + apiResponse.getMessage());
        }
        return Unit.INSTANCE;
    }

    public static final Unit mySelfDownMicAndCloseMusic$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "mySelfDownMic: 下麦失败" + th.getMessage());
        return Unit.INSTANCE;
    }

    public static final void setMicMemberAllRemoteMute$lambda$5() {
        String str;
        int i;
        boolean z;
        MeetingRoomManager meetingRoomManager = INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        int findMicPositionFromExtraId = meetingRoomManager.findMicPositionFromExtraId(str);
        if (findMicPositionFromExtraId > 0) {
            HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
            hiloRtcEngine.setClientRole(1);
            MicroBean microBean = (MicroBean) getMicQueue$default(meetingRoomManager, false, 1, null).get(Integer.valueOf(findMicPositionFromExtraId));
            if (microBean != null) {
                i = microBean.getAgoraId();
            } else {
                i = 0;
            }
            hiloRtcEngine.setRemoteMute(i, true);
            MicroBean microBean2 = (MicroBean) getMicQueue$default(meetingRoomManager, false, 1, null).get(Integer.valueOf(findMicPositionFromExtraId));
            if (microBean2 != null) {
                z = Intrinsics.areEqual(microBean2.getForbid(), Boolean.FALSE);
            } else {
                z = false;
            }
            if (z) {
                meetingRoomManager.adjustRecordingSignalVolume(false);
                return;
            } else {
                meetingRoomManager.adjustRecordingSignalVolume(true);
                return;
            }
        }
        HiloRtcEngine.INSTANCE.setClientRole(2);
        if (meetingRoomManager.getMusicManager().i() == MusicStatus.PLAY) {
            meetingRoomManager.getMusicManager().q();
        }
    }

    public static final Unit subscribActivity$lambda$21(ActivityDetailData activityDetailData, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Boolean isSubscribe = activityDetailData.isSubscribe();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isSubscribe, bool)) {
            activityDetailData.setSubscribe(Boolean.FALSE);
            activityDetailData.setPersonNum(activityDetailData.getPersonNum() - 1);
        } else {
            activityDetailData.setSubscribe(bool);
            activityDetailData.setPersonNum(activityDetailData.getPersonNum() + 1);
        }
        cf.c.c().l(new LiveEvent("refreshSubActivity", activityDetailData));
        return Unit.INSTANCE;
    }

    public static final Unit subscribActivity$lambda$22(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public final void addCurrentUserSaid(int agoraId) {
        if (!mCurrentSayIdArrayList.contains(Integer.valueOf(agoraId))) {
            mCurrentSayIdArrayList.add(Integer.valueOf(agoraId));
        }
    }

    public final void addGiftBannerButtonData(@NotNull GiftBannerButtonData globalGiftBanner) {
        Intrinsics.checkNotNullParameter(globalGiftBanner, "globalGiftBanner");
        if (!ActivityLifecycleManager.INSTANCE.isAppOnBackground() && ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "open_gift_banner", Boolean.TRUE, (String) null, 4, (Object) null)).booleanValue()) {
            mGiftBannerButtonList.add(globalGiftBanner);
            cf.c.c().l(new GlobalEvent("global_envelope", (Object) null, 2, (DefaultConstructorMarker) null));
        }
    }

    public final void addReceiverGiftTip(@NotNull GiftBannerData globalGiftBanner) {
        Intrinsics.checkNotNullParameter(globalGiftBanner, "globalGiftBanner");
        if (!ActivityLifecycleManager.INSTANCE.isAppOnBackground() && ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "open_gift_banner", Boolean.TRUE, (String) null, 4, (Object) null)).booleanValue()) {
            mReceiverGlobalGiftSvgaList.add(globalGiftBanner);
            cf.c.c().l(new GlobalEvent("global_gift_banner", (Object) null, 2, (DefaultConstructorMarker) null));
        }
    }

    public final void addRoomMessage(@NotNull RoomMessageMulti r7) {
        String str;
        Intrinsics.checkNotNullParameter(r7, Constants.SHARED_MESSAGE_ID_FILE);
        boolean z = false;
        for (RoomMessageMulti roomMessageMulti : mRoomMessageData) {
            GroupMessageNew data = roomMessageMulti.getData();
            String str2 = null;
            if (data != null) {
                str = data.getMsgId();
            } else {
                str = null;
            }
            GroupMessageNew data2 = r7.getData();
            if (data2 != null) {
                str2 = data2.getMsgId();
            }
            if (Intrinsics.areEqual(str, str2)) {
                GroupMessageNew data3 = roomMessageMulti.getData();
                if (data3 != null) {
                    data3.setStatus(1);
                }
                z = true;
            }
        }
        if (!z) {
            mRoomMessageData.add(r7);
        }
    }

    public final void adjustRecordingSignalVolume(boolean isMute) {
        HiloRtcEngine.INSTANCE.adjustRecordingSignalVolume(isMute);
    }

    public final void changeMicData(@NotNull MicroBean microBean, boolean isMe) {
        int i;
        String externalId;
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(microBean, "microBean");
        MicroUserBean user = microBean.getUser();
        if (user != null) {
            user.setTag(INSTANCE.getRoomUserRole(user.getExternalId()));
        }
        RoomPK roomPK = mPK;
        if (roomPK != null) {
            i = roomPK.getStatus();
        } else {
            i = 0;
        }
        if (i > 0) {
            RoomPK roomPK2 = mPK;
            if (roomPK2 != null && roomPK2.checkIsInvite()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (isMe) {
                    microBean.setRed(true);
                    mMicQueueMemberMap.put(Integer.valueOf(microBean.getI()), microBean);
                } else {
                    microBean.setRed(false);
                    mPKMicQueueMemberMap.put(Integer.valueOf(microBean.getI()), microBean);
                }
            } else if (isMe) {
                microBean.setRed(false);
                mPKMicQueueMemberMap.put(Integer.valueOf(microBean.getI()), microBean);
            } else {
                microBean.setRed(true);
                mMicQueueMemberMap.put(Integer.valueOf(microBean.getI()), microBean);
            }
        } else {
            mMicQueueMemberMap.put(Integer.valueOf(microBean.getI()), microBean);
        }
        String str2 = "";
        if (microBean.getAgoraId() > 0) {
            MicroUserBean user2 = microBean.getUser();
            String str3 = null;
            if (user2 != null) {
                str = user2.getExternalId();
            } else {
                str = null;
            }
            User user3 = UserStore.INSTANCE.getShared().getUser();
            if (user3 != null) {
                str3 = user3.getExternalId();
            }
            if (Intrinsics.areEqual(str, str3)) {
                setMicMemberAllRemoteMute(!getLocalRoomMicStatus());
            } else {
                if (getLocalRoomMicStatus()) {
                    String externalId2 = microBean.getExternalId();
                    if (externalId2 != null) {
                        str2 = externalId2;
                    }
                    if (!haveLocalMute(str2) && !microBean.getMicForbid() && !checkPKRoomMic(microBean.isRed())) {
                        HiloRtcEngine.INSTANCE.setRemoteMute(microBean.getAgoraId(), false);
                    }
                }
                HiloRtcEngine.INSTANCE.setRemoteMute(microBean.getAgoraId(), true);
            }
        } else {
            ThrottleByKeyExecutor throttleByKeyExecutor = ThrottleByKeyExecutor.INSTANCE;
            User user4 = UserStore.INSTANCE.getShared().getUser();
            if (user4 != null && (externalId = user4.getExternalId()) != null) {
                str2 = externalId;
            }
            throttleByKeyExecutor.execute(str2, 1000L, new Function0() { // from class: com.qiahao.nextvideo.room.manager.f
                public final Object invoke() {
                    Unit changeMicData$lambda$4;
                    changeMicData$lambda$4 = MeetingRoomManager.changeMicData$lambda$4();
                    return changeMicData$lambda$4;
                }
            });
        }
        wsFlow.tryEmit(new RoomEvent().setMicUpdate(microBean));
    }

    public final void changeMicMapData(@NotNull String content, final boolean isMe) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            final MicroBean microBean = (MicroBean) new com.google.gson.d().j(content, MicroBean.class);
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.manager.g
                @Override // java.lang.Runnable
                public final void run() {
                    MeetingRoomManager.changeMicMapData$lambda$2(MicroBean.this, isMe);
                }
            }, 200L);
        } catch (Exception unused) {
            Log.d(TAG, "changeMicMapData: 解析收到的麦位信息报错！！！！");
        }
    }

    public final void changePKRoomMic() {
        RoomPKScoreRes roomPKPro;
        ArrayList<RoomPKScore> scoreInfo;
        boolean z;
        RoomPK roomPK = mPK;
        if (roomPK != null && (roomPKPro = roomPK.getRoomPKPro()) != null && (scoreInfo = roomPKPro.getScoreInfo()) != null) {
            for (RoomPKScore roomPKScore : scoreInfo) {
                if (!Intrinsics.areEqual(roomPKScore.getGroupId(), mGroupId) && !Intrinsics.areEqual(Boolean.valueOf(mRoomMute), roomPKScore.isMute())) {
                    Boolean isMute = roomPKScore.isMute();
                    if (isMute != null) {
                        z = isMute.booleanValue();
                    } else {
                        z = false;
                    }
                    mRoomMute = z;
                    INSTANCE.setMicMemberAllRemoteMute(!r1.getLocalRoomMicStatus());
                }
            }
        }
    }

    public final void changeRoomStatus(int r3) {
        if (r3 <= 2 && r3 >= 0) {
            mRoomStatus = r3;
        } else {
            DebugToolsKt.printfE(TAG, "传入房间状态有误");
        }
    }

    public final boolean checkGameMadel() {
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        Boolean bool = Boolean.FALSE;
        if (!((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "open_game", bool, (String) null, 4, (Object) null)).booleanValue() && !((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "hilo_game_open", bool, (String) null, 4, (Object) null)).booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean checkMatchGame() {
        if (mLudoGameData == null && mUnoGameData == null && mDominoGameData == null && mCrushGameData == null && mBalootGameData == null) {
            return false;
        }
        return true;
    }

    public final boolean checkOpenHiloGame() {
        return ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "hilo_game_open", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
    }

    public final boolean checkOwnOrManager() {
        String str;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        int roomUserRole = getRoomUserRole(str);
        if (roomUserRole != 100 && roomUserRole != 50) {
            return false;
        }
        return true;
    }

    public final boolean checkPKMadel() {
        return ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "open_pk", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
    }

    public final boolean checkPKRoomMic(boolean isRed) {
        RoomPK roomPK;
        RoomPK roomPK2;
        RoomPK roomPK3 = mPK;
        if (((roomPK3 != null && roomPK3.getStatus() == 1) || ((roomPK = mPK) != null && roomPK.getStatus() == 2)) && mRoomMute) {
            RoomPK roomPK4 = mPK;
            if ((roomPK4 != null && roomPK4.checkIsInvite() && !isRed) || ((roomPK2 = mPK) != null && !roomPK2.checkIsInvite() && isRed)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean checkShowEffect() {
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        Boolean bool = Boolean.FALSE;
        if (!((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "open_game", bool, (String) null, 4, (Object) null)).booleanValue() && !((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "hilo_game_open", bool, (String) null, 4, (Object) null)).booleanValue()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final MicroBean checkUserMic(@NotNull String r5) {
        Intrinsics.checkNotNullParameter(r5, SupportGiftRankActivity.EXTERNAL_ID);
        if (TextUtils.isEmpty(r5)) {
            return null;
        }
        for (Map.Entry entry : getMicQueue$default(this, false, 1, null).entrySet()) {
            if (!TextUtils.isEmpty(((MicroBean) entry.getValue()).getExternalId()) && Intrinsics.areEqual(((MicroBean) entry.getValue()).getExternalId(), r5)) {
                return (MicroBean) entry.getValue();
            }
        }
        return null;
    }

    public final boolean checkUserOnMic(@Nullable String extraId) {
        if (TextUtils.isEmpty(extraId)) {
            return false;
        }
        if (extraId == null) {
            extraId = "";
        }
        if (findMicPositionFromExtraId(extraId) <= 0) {
            return false;
        }
        return true;
    }

    public final boolean currentInRoom(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if (mGroupId.length() > 0 && Intrinsics.areEqual(mGroupId, groupId)) {
            return true;
        }
        return false;
    }

    public final void emptyMicInit(int initSize) {
        if (initSize == 0) {
            return;
        }
        mMicQueueMemberMap.clear();
        mPKMicQueueMemberMap.clear();
        if (1 <= initSize) {
            int i = 1;
            while (true) {
                Integer valueOf = Integer.valueOf(i);
                ConcurrentHashMap<Integer, MicroBean> concurrentHashMap = mMicQueueMemberMap;
                MicroBean.Companion companion = MicroBean.INSTANCE;
                concurrentHashMap.put(valueOf, companion.emptyMicroBean(i, true));
                if (mPK != null) {
                    mPKMicQueueMemberMap.put(Integer.valueOf(i), companion.emptyMicroBean(i, false));
                }
                if (i != initSize) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void enableLocalAudio(boolean isOpenLocalAudio) {
        HiloRtcEngine.INSTANCE.enableLocalAudio(isOpenLocalAudio);
    }

    @Nullable
    public final MicroBean findMicInfoFromAgoraId(int agoraId) {
        for (Map.Entry entry : getMicQueue$default(this, false, 1, null).entrySet()) {
            if (((MicroBean) entry.getValue()).getAgoraId() > 0 && agoraId == ((MicroBean) entry.getValue()).getAgoraId()) {
                return (MicroBean) entry.getValue();
            }
        }
        return null;
    }

    public final int findMicPositionFromAgoraId(int agoraId, boolean isOther) {
        for (Map.Entry<Integer, MicroBean> entry : getMicQueue(isOther).entrySet()) {
            if (entry.getValue().getAgoraId() > 0 && agoraId == entry.getValue().getAgoraId()) {
                return entry.getValue().getI();
            }
        }
        return 0;
    }

    public final int findMicPositionFromExtraId(@NotNull String extraId) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        for (Map.Entry entry : getMicQueue$default(this, false, 1, null).entrySet()) {
            MicroBean microBean = (MicroBean) entry.getValue();
            if (microBean == null || (str = microBean.getExternalId()) == null) {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                MicroBean microBean2 = (MicroBean) entry.getValue();
                if (microBean2 != null) {
                    str2 = microBean2.getExternalId();
                } else {
                    str2 = null;
                }
                if (Intrinsics.areEqual(extraId, str2)) {
                    return ((MicroBean) entry.getValue()).getI();
                }
            }
        }
        return 0;
    }

    public final int findNullMicPosition() {
        String str;
        for (Map.Entry entry : getMicQueue$default(this, false, 1, null).entrySet()) {
            MicroBean microBean = (MicroBean) entry.getValue();
            if (microBean == null || (str = microBean.getExternalId()) == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return ((MicroBean) entry.getValue()).getI();
            }
        }
        return 0;
    }

    public final int getCurrentMicSize() {
        return getMicSize(mCurrentRoomMicType);
    }

    public final int getGameLevelRes(int level) {
        if (level == 10) {
            return 2131232598;
        }
        if (level != 50) {
            return level != 100 ? 0 : 2131232599;
        }
        return 2131232600;
    }

    @NotNull
    public final ArrayList<GameConfiguration> getGameList() {
        ArrayList<GameConfiguration> arrayList = new ArrayList<>();
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        String str = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "game_party_list", "", (String) null, 4, (Object) null);
        String str2 = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "game_lucky_list", "", (String) null, 4, (Object) null);
        String str3 = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "game_together_list", "", (String) null, 4, (Object) null);
        try {
            Type type = new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.manager.MeetingRoomManager$getGameList$type$1
            }.getType();
            BaseApplication.Companion companion = BaseApplication.Companion;
            ArrayList arrayList2 = (ArrayList) companion.getGSON().k(str, type);
            ArrayList arrayList3 = (ArrayList) companion.getGSON().k(str2, type);
            ArrayList arrayList4 = (ArrayList) companion.getGSON().k(str3, type);
            arrayList.addAll(arrayList2);
            arrayList.addAll(arrayList3);
            arrayList.addAll(arrayList4);
        } catch (Exception unused) {
        }
        return arrayList;
    }

    @Nullable
    public final GroupDetailBean getGroupDetailBean() {
        return mGroupDetailBean;
    }

    public final int getLevelRes(int level) {
        if (level == 10) {
            return 2131232598;
        }
        if (level != 50) {
            return level != 100 ? 0 : 2131232599;
        }
        return 2131232600;
    }

    @NotNull
    public final String getLevelString(int level) {
        if (level != 10) {
            if (level != 50) {
                if (level != 100) {
                    return ResourcesKtxKt.getStringById(this, 2131952992);
                }
                return ResourcesKtxKt.getStringById(this, 2131953001);
            }
            return ResourcesKtxKt.getStringById(this, 2131952990);
        }
        return ResourcesKtxKt.getStringById(this, 2131952947);
    }

    @NotNull
    public final ArrayList<String> getLocalMuteList() {
        return localMuteList;
    }

    public final boolean getLocalRoomMicStatus() {
        return ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, IS_OPEN_ROOM_MIC, Boolean.TRUE, (String) null, 4, (Object) null)).booleanValue();
    }

    public final boolean getLuckyFruitConfirm() {
        return ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, IS_LUCKY_FRUIT_CONFIG, Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
    }

    public final int getMAgoraId() {
        return mAgoraId;
    }

    @NotNull
    public final String getMAgoraToken() {
        return mAgoraToken;
    }

    @Nullable
    public final SUDGameData getMBackgammonGameData() {
        return mBackgammonGameData;
    }

    @Nullable
    public final SUDGameData getMBalootGameData() {
        return mBalootGameData;
    }

    @NotNull
    public final ArrayList<BoxLevel> getMBoxLevel() {
        return mBoxLevel;
    }

    @Nullable
    public final SUDGameData getMCarromGameData() {
        return mCarromGameData;
    }

    @NotNull
    public final nd.a getMConpose() {
        return mConpose;
    }

    @Nullable
    public final CreateSudData getMCreateBackgammonData() {
        return mCreateBackgammonData;
    }

    @Nullable
    public final CreateSudData getMCreateBalootData() {
        return mCreateBalootData;
    }

    @Nullable
    public final CreateSudData getMCreateCarromData() {
        return mCreateCarromData;
    }

    @Nullable
    public final CreateSudData getMCreateCrushData() {
        return mCreateCrushData;
    }

    @Nullable
    public final CreateSudData getMCreateDominoData() {
        return mCreateDominoData;
    }

    @Nullable
    public final CreateSudData getMCreateJackaroData() {
        return mCreateJackaroData;
    }

    @Nullable
    public final CreateSudData getMCreateLudoData() {
        return mCreateLudoData;
    }

    @Nullable
    public final CreateSudData getMCreateUnoData() {
        return mCreateUnoData;
    }

    @Nullable
    public final SUDGameData getMCrushGameData() {
        return mCrushGameData;
    }

    @NotNull
    public final String getMCurrentAgoraChannelId() {
        return mCurrentAgoraChannelId;
    }

    public final int getMCurrentRoomMicType() {
        return mCurrentRoomMicType;
    }

    @NotNull
    public final CopyOnWriteArrayList<Integer> getMCurrentSayIdArrayList() {
        return mCurrentSayIdArrayList;
    }

    @Nullable
    public final SUDGameData getMDominoGameData() {
        return mDominoGameData;
    }

    @Nullable
    public final EnvelopeData getMEnvelopeData() {
        return mEnvelopeData;
    }

    @NotNull
    public final ArrayList<GiftBannerButtonData> getMGiftBannerButtonList() {
        return mGiftBannerButtonList;
    }

    @Nullable
    public final GroupDetailBean getMGroupDetailBean() {
        return mGroupDetailBean;
    }

    @NotNull
    public final String getMGroupId() {
        return mGroupId;
    }

    @Nullable
    public final GameConfiguration getMHiloGameConfiguration() {
        return mHiloGameConfiguration;
    }

    @Nullable
    public final SUDGameData getMJackaroGameData() {
        return mJackaroGameData;
    }

    @Nullable
    public final SUDGameData getMLudoGameData() {
        return mLudoGameData;
    }

    @NotNull
    public final List<EmojiBean> getMMicEmoji() {
        return mMicEmoji;
    }

    @Nullable
    public final Timer getMMicInfoTimer() {
        return mMicInfoTimer;
    }

    @NotNull
    public final ConcurrentHashMap<Integer, MicroBean> getMMicQueueMemberMap() {
        return mMicQueueMemberMap;
    }

    @NotNull
    public final CopyOnWriteArrayList<Integer> getMNewMicArrayList() {
        return mNewMicArrayList;
    }

    @NotNull
    public final CopyOnWriteArrayList<Integer> getMOldMicArrayList() {
        return mOldMicArrayList;
    }

    public final int getMOldPKGameID() {
        return mOldPKGameID;
    }

    @Nullable
    public final RoomPK getMPK() {
        return mPK;
    }

    @Nullable
    public final Pk1v1Data getMPK1v1() {
        return mPK1v1;
    }

    @Nullable
    public final PKInviteCancel getMPKGame() {
        return mPKGame;
    }

    @NotNull
    public final ConcurrentHashMap<Integer, MicroBean> getMPKMicQueueMemberMap() {
        return mPKMicQueueMemberMap;
    }

    @NotNull
    public final String getMPassword() {
        return mPassword;
    }

    public final int getMProvider() {
        return mProvider;
    }

    @NotNull
    public final ArrayList<GiftBannerData> getMReceiverGlobalGiftSvgaList() {
        return mReceiverGlobalGiftSvgaList;
    }

    public final long getMRequestMicTime() {
        return mRequestMicTime;
    }

    @NotNull
    public final String getMRoomChannelId() {
        return mRoomChannelId;
    }

    public final int getMRoomChatTab() {
        return mRoomChatTab;
    }

    @Nullable
    public final LuckWheelInfo getMRoomLuckWheelInfo() {
        return mRoomLuckWheelInfo;
    }

    @NotNull
    public final CopyOnWriteArrayList<RoomMessageMulti> getMRoomMessageData() {
        return mRoomMessageData;
    }

    public final boolean getMRoomMute() {
        return mRoomMute;
    }

    public final int getMRoomOnLine() {
        return mRoomOnLine;
    }

    public final int getMRoomStatus() {
        return mRoomStatus;
    }

    @NotNull
    public final ArrayList<RoomRuleBean> getMRoomUserRoleList() {
        return mRoomUserRoleList;
    }

    @Nullable
    public final Pair<Boolean, Integer> getMTaskMicCompletePairs() {
        return mTaskMicCompletePairs;
    }

    @Nullable
    public final SUDGameData getMUnoGameData() {
        return mUnoGameData;
    }

    @Nullable
    public final YouTuGameData getMYouTuBe() {
        return mYouTuBe;
    }

    public final boolean getMicPermission() {
        return micPermission;
    }

    @NotNull
    public final ConcurrentHashMap<Integer, MicroBean> getMicQueue(boolean isOther) {
        int i;
        RoomPK roomPK = mPK;
        boolean z = false;
        if (roomPK != null) {
            i = roomPK.getStatus();
        } else {
            i = 0;
        }
        if (i > 0) {
            RoomPK roomPK2 = mPK;
            if (roomPK2 != null && roomPK2.checkIsInvite()) {
                z = true;
            }
            if (z) {
                if (isOther) {
                    return mPKMicQueueMemberMap;
                }
                return mMicQueueMemberMap;
            }
            if (isOther) {
                return mMicQueueMemberMap;
            }
            return mPKMicQueueMemberMap;
        }
        return mMicQueueMemberMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final ArrayList<MicroBean> getMicQueueMemberList() {
        String str;
        ArrayList<MicroBean> arrayList = new ArrayList<>();
        for (Map.Entry entry : getMicQueue$default(this, false, 1, null).entrySet()) {
            MicroBean microBean = (MicroBean) entry.getValue();
            if (microBean == null || (str = microBean.getExternalId()) == null) {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    public final int getMicSize(int type) {
        switch (type) {
            case 1:
            case 14:
            case 19:
            default:
                return 5;
            case 2:
                return 10;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 1;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 2;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 15:
                return 15;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            case 20:
                return 20;
        }
    }

    @NotNull
    public final com.qiahao.nextvideo.room.music.c getMusicManager() {
        com.qiahao.nextvideo.room.music.c cVar = mMusicManager;
        if (cVar == null) {
            com.qiahao.nextvideo.room.music.c cVar2 = new com.qiahao.nextvideo.room.music.c(new MusicLoader(HiloApplication.INSTANCE.getCONTEXT().getContentResolver()));
            mMusicManager = cVar2;
            Intrinsics.checkNotNull(cVar2);
            return cVar2;
        }
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    @Nullable
    public final Integer getRoomPKGameIcon(int r2) {
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 9) {
                    if (r2 != 22) {
                        if (r2 != 25) {
                            if (r2 != 41) {
                                if (r2 != 15) {
                                    if (r2 != 16) {
                                        return null;
                                    }
                                    return Integer.valueOf(R.drawable.room_pk_domino_icon);
                                }
                                return Integer.valueOf(R.drawable.room_pk_snake_icon);
                            }
                            return Integer.valueOf(R.drawable.room_pk_carrom_icon);
                        }
                        return Integer.valueOf(R.drawable.room_pk_strange_icon);
                    }
                    return Integer.valueOf(R.drawable.room_pk_center_icon);
                }
                return Integer.valueOf(R.drawable.room_pk_sheep_icon);
            }
            return Integer.valueOf(R.drawable.room_pk_uno_icon);
        }
        return Integer.valueOf(R.drawable.room_pk_ludo_icon);
    }

    @NotNull
    public final String getRoomPKTitle(int r2) {
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 9) {
                    if (r2 != 22) {
                        if (r2 != 25) {
                            if (r2 != 41) {
                                if (r2 != 15) {
                                    if (r2 != 16) {
                                        return "";
                                    }
                                    return "Domino PK";
                                }
                                return "Snake PK";
                            }
                            return "Carrom PK";
                        }
                        return ResourcesKtxKt.getStringById(this, 2131954151);
                    }
                    return ResourcesKtxKt.getStringById(this, 2131953964);
                }
                return "Sheep PK";
            }
            return "UNO PK";
        }
        return "Ludo PK";
    }

    public final void getRoomRole() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomRole(mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.manager.d
            public final Object invoke(Object obj) {
                Unit roomRole$lambda$18;
                roomRole$lambda$18 = MeetingRoomManager.getRoomRole$lambda$18((ApiResponse) obj);
                return roomRole$lambda$18;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.manager.e
            public final Object invoke(Object obj) {
                Unit roomRole$lambda$19;
                roomRole$lambda$19 = MeetingRoomManager.getRoomRole$lambda$19((Throwable) obj);
                return roomRole$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null), mConpose);
    }

    public final int getRoomUserRole(@Nullable String extraId) {
        if (extraId == null) {
            return 0;
        }
        Iterator<RoomRuleBean> it = mRoomUserRoleList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            RoomRuleBean next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            RoomRuleBean roomRuleBean = next;
            if (Intrinsics.areEqual(extraId, roomRuleBean.getExternalId())) {
                return roomRuleBean.getRole();
            }
        }
        return 0;
    }

    public final int getSupportMedal(int level) {
        switch (level) {
            case 1:
                return 2131232301;
            case 2:
                return 2131232302;
            case 3:
                return 2131232303;
            case 4:
                return 2131232304;
            case 5:
                return 2131232305;
            case 6:
                return 2131232306;
            case 7:
                return 2131232307;
            case 8:
                return 2131232308;
            case 9:
                return 2131232309;
            case 10:
                return 2131232310;
            case 11:
                return 2131232311;
            case 12:
                return 2131232312;
            case 13:
                return 2131232313;
            case 14:
                return 2131232314;
            case 15:
                return 2131232315;
            default:
                return 0;
        }
    }

    @NotNull
    public final MutableSharedFlow<RoomEvent> getWsFlow() {
        return wsFlow;
    }

    @NotNull
    public final MutableSharedFlow<RoomEvent> getWsFlowGift() {
        return wsFlowGift;
    }

    public final boolean hasInitEmoji() {
        return !mMicEmoji.isEmpty();
    }

    public final boolean haveLocalMute(@NotNull String r4) {
        Intrinsics.checkNotNullParameter(r4, SupportGiftRankActivity.EXTERNAL_ID);
        Iterator<T> it = localMuteList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), r4)) {
                z = true;
            }
        }
        return z;
    }

    public final void imJoinGroup(@NotNull String groupId, @NotNull V2TIMCallback callBack) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        V2TIMManager.getInstance().joinGroup(groupId, "", callBack);
    }

    public final void imLeaveGroup(@NotNull final String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        V2TIMManager.getInstance().quitGroup(groupId, new V2TIMCallback() { // from class: com.qiahao.nextvideo.room.manager.MeetingRoomManager$imLeaveGroup$1
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int code, String desc) {
                Log.d(MeetingRoomManager.TAG, "judgeCallTencentLeaveRoom: 离开群组id" + groupId + " fail");
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                Log.d(MeetingRoomManager.TAG, "judgeCallTencentLeaveRoom: 离开群组id" + groupId + " success");
            }
        });
    }

    public final boolean is1V1() {
        return is1V1;
    }

    public final boolean isCanShowFoodie() {
        if (getMicSize(mCurrentRoomMicType) < 16 && !checkPKMadel() && isLuckyGame(43)) {
            return true;
        }
        return false;
    }

    public final boolean isCanShowSmallLuckyFruit() {
        if (getMicSize(mCurrentRoomMicType) < 16 && !checkPKMadel() && isLuckyGame(6)) {
            return true;
        }
        return false;
    }

    public final boolean isCanShowSmallLuckyRouletteOrBox() {
        if (getMicSize(mCurrentRoomMicType) < 11 && !checkPKMadel()) {
            return true;
        }
        return false;
    }

    public final boolean isLuckyGame(int r7) {
        String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "game_lucky_list", "", (String) null, 4, (Object) null);
        boolean z = false;
        try {
            ArrayList arrayList = (ArrayList) BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.room.manager.MeetingRoomManager$isLuckyGame$type$1
            }.getType());
            Intrinsics.checkNotNull(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer gameId = ((GameConfiguration) it.next()).getGameId();
                if (gameId != null && gameId.intValue() == r7) {
                    z = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public final boolean isMySelfOnMic() {
        String str;
        String str2;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (Map.Entry entry : getMicQueue$default(this, false, 1, null).entrySet()) {
            MicroBean microBean = (MicroBean) entry.getValue();
            if (microBean == null || (str2 = microBean.getExternalId()) == null) {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2) && Intrinsics.areEqual(str, ((MicroBean) entry.getValue()).getExternalId())) {
                return true;
            }
        }
        return false;
    }

    public final boolean isRoomOpen() {
        if (mRoomStatus == 2) {
            return true;
        }
        return false;
    }

    public final boolean isRoomSmall() {
        if (mRoomStatus == 1) {
            return true;
        }
        return false;
    }

    public final boolean isShowEnterEffect() {
        return isShowEnterEffect;
    }

    public final boolean isShowGiftEffect() {
        return isShowGiftEffect;
    }

    public final boolean isShowRocketEffect() {
        return isShowRocketEffect;
    }

    public final void joinRoom() {
        RoomSignaling.INSTANCE.addRoomSignalListener();
    }

    public final void leaveRoom(boolean needFetchLeaveRoom) {
        String externalId;
        if (needFetchLeaveRoom && !TextUtils.isEmpty(mGroupId)) {
            imLeaveGroup(mGroupId);
            AppRequestUtils.INSTANCE.callServiceLeaveRoom(mGroupId);
        }
        cf.c.c().l(new ChatRoomStatusEvent("stop_service", (Object) null, 2, (DefaultConstructorMarker) null));
        V2TIMManager.getMessageManager().clearGroupHistoryMessage(mGroupId, null);
        WebSocketProvide.roomWebSocket$default(WebSocketProvide.INSTANCE, 153, mGroupId, null, null, 12, null);
        RoomSignaling.INSTANCE.removeRoomSignalListener();
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        Boolean bool = Boolean.FALSE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "SHOW_LUCKY_FRUIT", bool, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "show_foodie", bool, (String) null, 4, (Object) null);
        setLocalRoomMicStatus(true);
        changeRoomStatus(0);
        mySelfDownMicAndCloseMusic();
        Timer timer = mMicInfoTimer;
        if (timer != null) {
            timer.cancel();
        }
        mConpose.d();
        emptyMicInit$default(this, 0, 1, null);
        HiloRtcEngine.INSTANCE.leaveChannel();
        String str = "";
        mRoomChannelId = "";
        mGroupId = "";
        is1V1 = false;
        mAgoraToken = "";
        mRoomMute = false;
        mOldPKGameID = -1;
        mAgoraId = 0;
        mPassword = "";
        mProvider = -1;
        mHiloGameConfiguration = null;
        mGroupDetailBean = null;
        mRoomOnLine = 0;
        mLudoGameData = null;
        mUnoGameData = null;
        mDominoGameData = null;
        mCrushGameData = null;
        mBalootGameData = null;
        mCarromGameData = null;
        mJackaroGameData = null;
        mBackgammonGameData = null;
        mEnvelopeData = null;
        mPK1v1 = null;
        mYouTuBe = null;
        mCurrentAgoraChannelId = "";
        mTaskMicCompletePairs = null;
        mCurrentSayIdArrayList.clear();
        mNewMicArrayList.clear();
        mOldMicArrayList.clear();
        mRoomUserRoleList.clear();
        localMuteList.clear();
        ThrottleByKeyExecutor throttleByKeyExecutor = ThrottleByKeyExecutor.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && (externalId = user.getExternalId()) != null) {
            str = externalId;
        }
        throttleByKeyExecutor.cancel(str);
        mCurrentRoomMicType = 5;
        if (mMusicManager != null) {
            mMusicManager = null;
        }
        if (mRoomLuckWheelInfo != null) {
            mRoomLuckWheelInfo = null;
        }
    }

    public final void localMute(@NotNull String r2, int agoraId, boolean abc) {
        Intrinsics.checkNotNullParameter(r2, SupportGiftRankActivity.EXTERNAL_ID);
        if (!haveLocalMute(r2) && !abc) {
            HiloRtcEngine.INSTANCE.setRemoteMute(agoraId, false);
        } else {
            HiloRtcEngine.INSTANCE.setRemoteMute(agoraId, true);
        }
    }

    public final void removeLocalMute(@NotNull String r4) {
        Intrinsics.checkNotNullParameter(r4, SupportGiftRankActivity.EXTERNAL_ID);
        Iterator<String> it = localMuteList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (Intrinsics.areEqual(next, r4)) {
                it.remove();
            }
        }
    }

    public final void saveCreateBackgammonDateAndClear() {
        SUDGameData sUDGameData = mBackgammonGameData;
        if (sUDGameData != null) {
            mCreateBackgammonData = new CreateSudData(sUDGameData.getGameType(), sUDGameData.getMode(), sUDGameData.getPiece(), 0, sUDGameData.getDiamond(), sUDGameData.getAutoMatch(), mGroupId, 55L, 8, null);
        }
        mBackgammonGameData = null;
    }

    public final void saveCreateBalootDateAndClear() {
        SUDGameData sUDGameData = mBalootGameData;
        if (sUDGameData != null) {
            mCreateBalootData = new CreateSudData(sUDGameData.getGameType(), sUDGameData.getMode(), sUDGameData.getPiece(), sUDGameData.getOnOff1(), sUDGameData.getDiamond(), sUDGameData.getAutoMatch(), mGroupId, 29L);
        }
        mBalootGameData = null;
    }

    public final void saveCreateCarromDateAndClear() {
        SUDGameData sUDGameData = mCarromGameData;
        if (sUDGameData != null) {
            mCreateCarromData = new CreateSudData(sUDGameData.getGameType(), sUDGameData.getMode(), sUDGameData.getPiece(), sUDGameData.getOnOff1(), sUDGameData.getDiamond(), sUDGameData.getAutoMatch(), mGroupId, 41L);
        }
        mCarromGameData = null;
    }

    public final void saveCreateCrushDateAndClear() {
        SUDGameData sUDGameData = mCrushGameData;
        if (sUDGameData != null) {
            mCreateCrushData = new CreateSudData(sUDGameData.getGameType(), sUDGameData.getMode(), sUDGameData.getPiece(), sUDGameData.getOnOff1(), sUDGameData.getDiamond(), sUDGameData.getAutoMatch(), mGroupId, 16L);
        }
        mCrushGameData = null;
    }

    public final void saveCreateDominoDateAndClear() {
        SUDGameData sUDGameData = mDominoGameData;
        if (sUDGameData != null) {
            mCreateDominoData = new CreateSudData(sUDGameData.getGameType(), sUDGameData.getMode(), sUDGameData.getPiece(), sUDGameData.getOnOff1(), sUDGameData.getDiamond(), sUDGameData.getAutoMatch(), mGroupId, 16L);
        }
        mDominoGameData = null;
    }

    public final void saveCreateJackaroDateAndClear() {
        SUDGameData sUDGameData = mJackaroGameData;
        if (sUDGameData != null) {
            mCreateJackaroData = new CreateSudData(sUDGameData.getGameType(), sUDGameData.getMode(), sUDGameData.getPiece(), sUDGameData.getOnOff1(), sUDGameData.getDiamond(), sUDGameData.getAutoMatch(), mGroupId, 45L);
        }
        mJackaroGameData = null;
    }

    public final void saveCreateLudoDateAndClear() {
        SUDGameData sUDGameData = mLudoGameData;
        if (sUDGameData != null) {
            mCreateLudoData = new CreateSudData(sUDGameData.getGameType(), sUDGameData.getMode(), sUDGameData.getPiece(), sUDGameData.getOnOff1(), sUDGameData.getDiamond(), sUDGameData.getAutoMatch(), mGroupId, 1L);
        }
        mLudoGameData = null;
    }

    public final void saveCreateUnoDateAndClear() {
        SUDGameData sUDGameData = mUnoGameData;
        if (sUDGameData != null) {
            mCreateUnoData = new CreateSudData(sUDGameData.getGameType(), sUDGameData.getMode(), sUDGameData.getPiece(), sUDGameData.getOnOff1(), sUDGameData.getDiamond(), sUDGameData.getAutoMatch(), mGroupId, 2L);
        }
        mUnoGameData = null;
    }

    public final void set1V1(boolean z) {
        is1V1 = z;
    }

    public final void setGroupDetailBean(@NotNull GroupDetailBean groupDetailBean) {
        Intrinsics.checkNotNullParameter(groupDetailBean, "groupDetailBean");
        mGroupDetailBean = groupDetailBean;
    }

    public final void setLocalMuteList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        localMuteList = arrayList;
    }

    public final void setLocalRoomMicStatus(boolean isOpenMic) {
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, IS_OPEN_ROOM_MIC, Boolean.valueOf(isOpenMic), (String) null, 4, (Object) null);
    }

    public final void setLuckyFruitConfirm(boolean isNeedConfig) {
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, IS_LUCKY_FRUIT_CONFIG, Boolean.valueOf(isNeedConfig), (String) null, 4, (Object) null);
    }

    public final void setMAgoraId(int i) {
        mAgoraId = i;
    }

    public final void setMAgoraToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mAgoraToken = str;
    }

    public final void setMBackgammonGameData(@Nullable SUDGameData sUDGameData) {
        mBackgammonGameData = sUDGameData;
    }

    public final void setMBalootGameData(@Nullable SUDGameData sUDGameData) {
        mBalootGameData = sUDGameData;
    }

    public final void setMBoxLevel(@NotNull ArrayList<BoxLevel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        mBoxLevel = arrayList;
    }

    public final void setMCarromGameData(@Nullable SUDGameData sUDGameData) {
        mCarromGameData = sUDGameData;
    }

    public final void setMCreateBackgammonData(@Nullable CreateSudData createSudData) {
        mCreateBackgammonData = createSudData;
    }

    public final void setMCreateBalootData(@Nullable CreateSudData createSudData) {
        mCreateBalootData = createSudData;
    }

    public final void setMCreateCarromData(@Nullable CreateSudData createSudData) {
        mCreateCarromData = createSudData;
    }

    public final void setMCreateCrushData(@Nullable CreateSudData createSudData) {
        mCreateCrushData = createSudData;
    }

    public final void setMCreateDominoData(@Nullable CreateSudData createSudData) {
        mCreateDominoData = createSudData;
    }

    public final void setMCreateJackaroData(@Nullable CreateSudData createSudData) {
        mCreateJackaroData = createSudData;
    }

    public final void setMCreateLudoData(@Nullable CreateSudData createSudData) {
        mCreateLudoData = createSudData;
    }

    public final void setMCreateUnoData(@Nullable CreateSudData createSudData) {
        mCreateUnoData = createSudData;
    }

    public final void setMCrushGameData(@Nullable SUDGameData sUDGameData) {
        mCrushGameData = sUDGameData;
    }

    public final void setMCurrentAgoraChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mCurrentAgoraChannelId = str;
    }

    public final void setMCurrentRoomMicType(int i) {
        mCurrentRoomMicType = i;
    }

    public final void setMCurrentSayIdArrayList(@NotNull CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        mCurrentSayIdArrayList = copyOnWriteArrayList;
    }

    public final void setMDominoGameData(@Nullable SUDGameData sUDGameData) {
        mDominoGameData = sUDGameData;
    }

    public final void setMEnvelopeData(@Nullable EnvelopeData envelopeData) {
        mEnvelopeData = envelopeData;
    }

    public final void setMGroupDetailBean(@Nullable GroupDetailBean groupDetailBean) {
        mGroupDetailBean = groupDetailBean;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mGroupId = str;
    }

    public final void setMHiloGameConfiguration(@Nullable GameConfiguration gameConfiguration) {
        mHiloGameConfiguration = gameConfiguration;
    }

    public final void setMJackaroGameData(@Nullable SUDGameData sUDGameData) {
        mJackaroGameData = sUDGameData;
    }

    public final void setMLudoGameData(@Nullable SUDGameData sUDGameData) {
        mLudoGameData = sUDGameData;
    }

    public final void setMMicEmoji(@NotNull List<EmojiBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        mMicEmoji = list;
    }

    public final void setMMicInfoTimer(@Nullable Timer timer) {
        mMicInfoTimer = timer;
    }

    public final void setMMicQueueMemberMap(@NotNull ConcurrentHashMap<Integer, MicroBean> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        mMicQueueMemberMap = concurrentHashMap;
    }

    public final void setMNewMicArrayList(@NotNull CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        mNewMicArrayList = copyOnWriteArrayList;
    }

    public final void setMOldMicArrayList(@NotNull CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        mOldMicArrayList = copyOnWriteArrayList;
    }

    public final void setMOldPKGameID(int i) {
        mOldPKGameID = i;
    }

    public final void setMPK(@Nullable RoomPK roomPK) {
        mPK = roomPK;
    }

    public final void setMPK1v1(@Nullable Pk1v1Data pk1v1Data) {
        mPK1v1 = pk1v1Data;
    }

    public final void setMPKGame(@Nullable PKInviteCancel pKInviteCancel) {
        mPKGame = pKInviteCancel;
    }

    public final void setMPKMicQueueMemberMap(@NotNull ConcurrentHashMap<Integer, MicroBean> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        mPKMicQueueMemberMap = concurrentHashMap;
    }

    public final void setMPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mPassword = str;
    }

    public final void setMProvider(int i) {
        mProvider = i;
    }

    public final void setMRequestMicTime(long j) {
        mRequestMicTime = j;
    }

    public final void setMRoomChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mRoomChannelId = str;
    }

    public final void setMRoomChatTab(int i) {
        mRoomChatTab = i;
    }

    public final void setMRoomLuckWheelInfo(@Nullable LuckWheelInfo luckWheelInfo) {
        mRoomLuckWheelInfo = luckWheelInfo;
    }

    public final void setMRoomMessageData(@NotNull CopyOnWriteArrayList<RoomMessageMulti> copyOnWriteArrayList) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        mRoomMessageData = copyOnWriteArrayList;
    }

    public final void setMRoomMute(boolean z) {
        mRoomMute = z;
    }

    public final void setMRoomOnLine(int i) {
        mRoomOnLine = i;
    }

    public final void setMRoomStatus(int i) {
        mRoomStatus = i;
    }

    public final void setMRoomUserRoleList(@NotNull ArrayList<RoomRuleBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "value");
        mRoomUserRoleList = arrayList;
        UserRoleType.Companion.get().setMRoomUserRoleList(arrayList);
    }

    public final void setMTaskMicCompletePairs(@Nullable Pair<Boolean, Integer> pair) {
        mTaskMicCompletePairs = pair;
    }

    public final void setMUnoGameData(@Nullable SUDGameData sUDGameData) {
        mUnoGameData = sUDGameData;
    }

    public final void setMYouTuBe(@Nullable YouTuGameData youTuGameData) {
        mYouTuBe = youTuGameData;
    }

    public final void setMicMemberAllRemoteMute(boolean isMute) {
        String str;
        if (isMute) {
            HiloRtcEngine.INSTANCE.muteAllRemoteAudioStreams(true);
        } else {
            Iterator<Map.Entry<Integer, MicroBean>> it = mMicQueueMemberMap.entrySet().iterator();
            while (true) {
                String str2 = "";
                String str3 = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, MicroBean> next = it.next();
                if (next.getValue().getAgoraId() > 0) {
                    String externalId = next.getValue().getExternalId();
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        str3 = user.getExternalId();
                    }
                    if (!Intrinsics.areEqual(externalId, str3)) {
                        String externalId2 = next.getValue().getExternalId();
                        if (externalId2 != null) {
                            str2 = externalId2;
                        }
                        if (!haveLocalMute(str2) && !next.getValue().getMicForbid() && !checkPKRoomMic(true)) {
                            HiloRtcEngine.INSTANCE.setRemoteMute(next.getValue().getAgoraId(), false);
                        }
                    }
                    HiloRtcEngine.INSTANCE.setRemoteMute(next.getValue().getAgoraId(), true);
                }
            }
            for (Map.Entry<Integer, MicroBean> entry : mPKMicQueueMemberMap.entrySet()) {
                if (entry.getValue().getAgoraId() > 0) {
                    String externalId3 = entry.getValue().getExternalId();
                    User user2 = UserStore.INSTANCE.getShared().getUser();
                    if (user2 != null) {
                        str = user2.getExternalId();
                    } else {
                        str = null;
                    }
                    if (!Intrinsics.areEqual(externalId3, str)) {
                        String externalId4 = entry.getValue().getExternalId();
                        if (externalId4 == null) {
                            externalId4 = "";
                        }
                        if (!haveLocalMute(externalId4) && !entry.getValue().getMicForbid() && !checkPKRoomMic(false)) {
                            HiloRtcEngine.INSTANCE.setRemoteMute(entry.getValue().getAgoraId(), false);
                        }
                    }
                    HiloRtcEngine.INSTANCE.setRemoteMute(entry.getValue().getAgoraId(), true);
                }
            }
        }
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                MeetingRoomManager.setMicMemberAllRemoteMute$lambda$5();
            }
        });
    }

    public final void setMicPermission(boolean z) {
        micPermission = z;
    }

    public final void setShowEnterEffect(boolean z) {
        isShowEnterEffect = z;
    }

    public final void setShowGiftEffect(boolean z) {
        isShowGiftEffect = z;
    }

    public final void setShowRocketEffect(boolean z) {
        isShowRocketEffect = z;
    }

    public final void setTaskMicCompletePairs(int r4) {
        mTaskMicCompletePairs = new Pair<>(Boolean.TRUE, Integer.valueOf(r4));
        wsFlow.tryEmit(new RoomEvent().upMicTaskComplete(r4));
    }

    public final void smallRoom() {
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "RoomFloatViewX", -1, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "RoomFloatViewY", -1, (String) null, 4, (Object) null);
        changeRoomStatus(1);
    }

    public final void subscribActivity(@NotNull final ActivityDetailData data) {
        int i;
        Intrinsics.checkNotNullParameter(data, "data");
        UserService shared = UserService.INSTANCE.getShared();
        String id2 = data.getId();
        if (id2 == null) {
            id2 = "";
        }
        if (Intrinsics.areEqual(data.isSubscribe(), Boolean.TRUE)) {
            i = 2;
        } else {
            i = 1;
        }
        RxUtilsKt.observeOnMainThread$default(shared.activitySubscribe(id2, i), new Function1() { // from class: com.qiahao.nextvideo.room.manager.a
            public final Object invoke(Object obj) {
                Unit subscribActivity$lambda$21;
                subscribActivity$lambda$21 = MeetingRoomManager.subscribActivity$lambda$21(data, (ApiResponse) obj);
                return subscribActivity$lambda$21;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.manager.b
            public final Object invoke(Object obj) {
                Unit subscribActivity$lambda$22;
                subscribActivity$lambda$22 = MeetingRoomManager.subscribActivity$lambda$22((Throwable) obj);
                return subscribActivity$lambda$22;
            }
        }, (Function0) null, false, 12, (Object) null);
    }
}
