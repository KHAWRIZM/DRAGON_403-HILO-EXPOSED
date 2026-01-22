package com.qiahao.nextvideo.support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qhqc.core.feature.community.CommunityManager;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.MultiGiftData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.network.model.ErrorResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipTitleDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.app.MainActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.activity.GroupSupportActivity;
import com.qiahao.nextvideo.room.dialog.OtherGiftDialog;
import com.qiahao.nextvideo.room.dialog.PicOrSvgaShowDialog;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.aristocracy.AristocracyBagActivity;
import com.qiahao.nextvideo.ui.aristocracy.BuyAristocracyActivity;
import com.qiahao.nextvideo.ui.baishun.BaiShunGameActivity;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.InteractiveTrackingType;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.FriendStatusListActivity;
import com.qiahao.nextvideo.ui.cp.CpConfirmTwoDialog;
import com.qiahao.nextvideo.ui.cp.CpInvitationReceiveDialog;
import com.qiahao.nextvideo.ui.cp.CpMemorialActivity;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.cp.RelationInvitationReceiveDialog;
import com.qiahao.nextvideo.ui.family.FamilyCenterActivity;
import com.qiahao.nextvideo.ui.gameLevel.GameLevelActivity;
import com.qiahao.nextvideo.ui.gem.GemStoreDialog;
import com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity;
import com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity;
import com.qiahao.nextvideo.ui.im.StrangerProvide;
import com.qiahao.nextvideo.ui.peopleCertification.PeopleCertificationActivity;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.store.MyBagActivity;
import com.qiahao.nextvideo.ui.svip.SvipActivity;
import com.qiahao.nextvideo.ui.task.TasksActivity;
import com.qiahao.nextvideo.ui.transfer.TransferCenterFragment;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.ui.webview.BaiShunWebActivity;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.ui.webview.HorizontalWebActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.ClientLogUtils;
import com.qiahao.nextvideo.utilities.GameIconUtils;
import com.qiahao.nextvideo.utilities.SensitiveUtil;
import com.qiahao.nextvideo.utilities.StorageUtils;
import com.qiahao.nextvideo.utilities.data_utils.GiftUtils;
import com.qiahao.nextvideo.utilities.firebase.FirebaseHelper;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMManager;
import com.therouter.inject.ServiceProvider;
import io.reactivex.rxjava3.core.i0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001d\u0010\u0016J\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b \u0010\u0016J\u000f\u0010!\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\u0003J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010\u0016J\u000f\u0010#\u001a\u00020\u0011H\u0016¢\u0006\u0004\b#\u0010\u0013J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0011H\u0016¢\u0006\u0004\b'\u0010\u0013J;\u0010-\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00112\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*0)j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*`+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\bH\u0016¢\u0006\u0004\b/\u0010\u0003J\u0017\u00102\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0011H\u0016¢\u0006\u0004\b5\u00106J\u0019\u00109\u001a\u0004\u0018\u0001082\u0006\u00107\u001a\u00020$H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010\u0003J\u000f\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u000200H\u0016¢\u0006\u0004\b@\u0010AJ\u001f\u0010D\u001a\u00020\b2\u0006\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020<H\u0016¢\u0006\u0004\bD\u0010EJi\u0010O\u001a\u00020\b2\u0006\u0010G\u001a\u00020F2\u0006\u0010\u0019\u001a\u00020\u001128\u0010L\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0004¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\b\u0018\u00010H2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010MH\u0016¢\u0006\u0004\bO\u0010PJ;\u0010X\u001a\u00020\b2\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020S2\u0006\u0010V\u001a\u00020U2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010W\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\b2\u0006\u0010Z\u001a\u000200H\u0016¢\u0006\u0004\b[\u0010AJ\u0011\u0010\\\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b^\u0010\u0016J\u0017\u0010_\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b_\u0010\u0016J\u0017\u0010a\u001a\u00020\b2\u0006\u0010`\u001a\u00020\u0011H\u0016¢\u0006\u0004\ba\u0010\u0016J\u0017\u0010c\u001a\u00020\b2\u0006\u0010b\u001a\u00020$H\u0016¢\u0006\u0004\bc\u0010dJ\u001f\u0010g\u001a\u00020\b2\u0006\u0010e\u001a\u0002002\u0006\u0010f\u001a\u000200H\u0016¢\u0006\u0004\bg\u0010hJ\u001f\u0010k\u001a\u00020\b2\u0006\u0010V\u001a\u00020i2\u0006\u0010j\u001a\u00020\u0011H\u0016¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020\bH\u0016¢\u0006\u0004\bm\u0010\u0003J\u001f\u0010o\u001a\u00020\b2\u0006\u0010T\u001a\u00020S2\u0006\u0010n\u001a\u00020\u0011H\u0016¢\u0006\u0004\bo\u0010pJ\u000f\u0010q\u001a\u00020\bH\u0016¢\u0006\u0004\bq\u0010\u0003J\u0017\u0010r\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\br\u0010\u0016J\u0017\u0010s\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\bs\u0010\u0016J/\u0010w\u001a\u00020\b2\u0006\u0010t\u001a\u0002002\u0006\u0010f\u001a\u0002002\u0006\u0010u\u001a\u0002002\u0006\u0010v\u001a\u000200H\u0016¢\u0006\u0004\bw\u0010xJ\u000f\u0010y\u001a\u00020\bH\u0016¢\u0006\u0004\by\u0010\u0003J\u0019\u0010|\u001a\u0004\u0018\u00010{2\u0006\u0010z\u001a\u00020\u0011H\u0016¢\u0006\u0004\b|\u0010}J\u000f\u0010~\u001a\u00020\bH\u0016¢\u0006\u0004\b~\u0010\u0003J\u000f\u0010\u007f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u007f\u0010\u0003J\u0011\u0010\u0080\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0080\u0001\u0010\u0003J\u0011\u0010\u0081\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0081\u0001\u0010\u0003J$\u0010\u0084\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00110\u0082\u0001j\t\u0012\u0004\u0012\u00020\u0011`\u0083\u0001H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001b\u0010\u0087\u0001\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00020\u0011H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0089\u0001\u0010\u0003J!\u0010\u008a\u0001\u001a\u00020\b2\u0006\u0010V\u001a\u00020i2\u0006\u0010j\u001a\u00020\u0011H\u0016¢\u0006\u0005\b\u008a\u0001\u0010lJ#\u0010\u008c\u0001\u001a\u00020\b2\u0006\u0010T\u001a\u00020S2\u0007\u0010\u000e\u001a\u00030\u008b\u0001H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001a\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0006\b\u008e\u0001\u0010\u0088\u0001J\u001a\u0010\u008f\u0001\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0088\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0090\u0001\u0010\u0003J\u0019\u0010\u0091\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0005\b\u0091\u0001\u0010\u0016J\u001e\u0010\u0094\u0001\u001a\u00020\b2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001a\u0010\u0096\u0001\u001a\u00020\b2\u0007\u0010\u0086\u0001\u001a\u00020\u0011H\u0016¢\u0006\u0005\b\u0096\u0001\u0010\u0016J\u0011\u0010\u0097\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0097\u0001\u0010\u0003J\u0011\u0010\u0098\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0098\u0001\u0010\u0003J\u001c\u0010\u0099\u0001\u001a\u0004\u0018\u0001002\u0006\u0010v\u001a\u000200H\u0016¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0011\u0010\u009b\u0001\u001a\u00020$H\u0016¢\u0006\u0005\b\u009b\u0001\u0010&J\u001b\u0010\u009d\u0001\u001a\u00020\u00112\u0007\u0010\u009c\u0001\u001a\u00020$H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0019\u0010\u009f\u0001\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0005\b\u009f\u0001\u0010\u0016J`\u0010¡\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110¥\u00010¤\u00012\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00112\u0007\u0010¡\u0001\u001a\u00020{2\u0007\u0010¢\u0001\u001a\u00020\u00042\u001b\u0010£\u0001\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b\u0018\u00010HH\u0016¢\u0006\u0006\b¡\u0001\u0010¦\u0001J\u0012\u0010§\u0001\u001a\u000200H\u0016¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001a\u0010ª\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u000200H\u0016¢\u0006\u0005\bª\u0001\u0010AJ6\u0010¯\u0001\u001a\u0002002\u0007\u0010«\u0001\u001a\u00020$2\u0007\u0010¬\u0001\u001a\u00020\u00042\u0007\u0010\u00ad\u0001\u001a\u00020\u00042\u0007\u0010®\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0006\b¯\u0001\u0010°\u0001¨\u0006±\u0001"}, d2 = {"Lcom/qiahao/nextvideo/support/AppServiceImpl;", "Lcom/qiahao/base_common/support/AppService;", "<init>", "()V", "", "checkServerDebug", "()Z", "isSendEvent", "", "logout", "(Z)V", "isAuthenticated", "showUpdateDialog", "Lcom/qiahao/base_common/network/model/ErrorResponse;", "data", "showErrorTipDialog", "(Lcom/qiahao/base_common/network/model/ErrorResponse;)V", "", "getAuthenticationToken", "()Ljava/lang/String;", "token", "setAuthenticationToken", "(Ljava/lang/String;)V", "groupId", "joinLive", SupportGiftRankActivity.EXTERNAL_ID, "openPersonPage", "openGroupSupport", "url", "openH5", "openDefaultBrowser", "openHorizontalH5", "videoCall", "openWallet", "toChat", "getUserExternalId", "", "getId", "()J", "getSimOperator", "event", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "values", "onEvent", "(Ljava/lang/String;Ljava/util/HashMap;)V", "startMyBag", "", "nobleLevel", "getNobleDrawableRes", "(I)I", "svgaUrl", "showImageOrSvga", "(Ljava/lang/String;Ljava/lang/String;)V", "giftId", "Lcom/qiahao/base_common/model/MultiGiftData;", "findGiftByGiftId", "(J)Lcom/qiahao/base_common/model/MultiGiftData;", "startWallet", "", "getDiamond", "()D", "likeCount", "refreshLikeCount", "(I)V", TransferCenterFragment.TYPE_DIAMONDS, "pinkDiamondNum", "refreshDiamondOrGem", "(DD)V", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isLike", "likeListener", "Lkotlin/Function0;", "startVideo", "newStartVideo", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/qiahao/base_common/model/common/User;", "user", "Lcom/qiahao/base_common/interfaceing/SendGiftListener;", "listener", "isStrange", "showChatGiftDialog", "(Landroidx/fragment/app/FragmentManager;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/interfaceing/SendGiftListener;Ljava/lang/String;Ljava/lang/Boolean;)V", "position", "showVipDialog", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "roomOpenUserInfo", "openLevelActivity", AgooConstants.MESSAGE_ID, "openActivityDetail", "familyID", "openFamily", "(J)V", "matchId", GameMatchActivity.GAME_ID, "openSheep", "(II)V", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "tip", "showCpDialog", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;Ljava/lang/String;)V", "openGemStore", "msg", "openCpDialog", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;)V", "openMemorial", "openCpZone", "openCommonLink", GameMatchActivity.MATH_ID, Constants.KEY_MODE, "gameType", "matchGame", "(IIII)V", "exitToMainActivity", "filePath", "Ljava/io/File;", "getFile", "(Ljava/lang/String;)Ljava/io/File;", "openTask", "openPraise", "openSVIP", "openAristocracyBag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSensitiveList", "()Ljava/util/ArrayList;", "str", "checkSensitive", "(Ljava/lang/String;)Z", "openAristocracy", "showRelationDialog", "Lcom/qiahao/base_common/model/im/RelationMessageData;", "openRelationDialog", "(Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/im/RelationMessageData;)V", "checkStrangerGroupFromSDK", "checkStrangerGroupFromService", "openGameLevel", "openBaiShunH5", "", "throwable", "recordException", "(Ljava/lang/Throwable;)V", "recordLog", "openBaiShunCenter", "openPeopleCertification", "gameIcon", "(I)Ljava/lang/Integer;", "getServerTime", "num", "formatNumber", "(J)Ljava/lang/String;", "changeCommunityServer", "folder", "uploadFile", MatchingProvide.IS_VIDEO, "progressListener", "Lio/reactivex/rxjava3/core/i0;", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/io/File;ZLkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/i0;", "roomMessageTab", "()I", "messageTab", "changeRoomMessageTab", "level", "isCharm", "isWealth", "isActivity", "getLevelBg", "(JZZZ)I", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ServiceProvider(returnType = AppService.class)
@SourceDebugExtension({"SMAP\nAppServiceImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppServiceImpl.kt\ncom/qiahao/nextvideo/support/AppServiceImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,561:1\n1#2:562\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AppServiceImpl implements AppService {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitToMainActivity$lambda$42() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            Intent intent = new Intent(currentActivity, (Class<?>) MainActivity.class);
            intent.addFlags(67108864);
            currentActivity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openAristocracy$lambda$52() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            BuyAristocracyActivity.INSTANCE.start(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openAristocracyBag$lambda$50() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            AristocracyBagActivity.INSTANCE.start(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openBaiShunCenter$lambda$62() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            BaiShunGameActivity.INSTANCE.start(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openBaiShunH5$lambda$59(String str) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            BaiShunWebActivity.INSTANCE.start(currentActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openCommonLink$lambda$40(String str) {
        NavigationHelper.jump$default(NavigationHelper.INSTANCE, str, (SuperCallBack) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openCpDialog$lambda$36(User user, String str) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            new CpInvitationReceiveDialog(currentActivity, user, str).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openDefaultBrowser$lambda$8(String str) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openGameLevel$lambda$57() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            GameLevelActivity.INSTANCE.start(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openGemStore$lambda$34() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(ActivityLifecycleManager.INSTANCE.currentActivity());
        if (activity != null) {
            new GemStoreDialog().show(activity.getSupportFragmentManager(), "other");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openGroupSupport$lambda$4(String str) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            GroupSupportActivity.INSTANCE.start(currentActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openH5$lambda$6(String str) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, currentActivity, str, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openHorizontalH5$lambda$10(String str) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            HorizontalWebActivity.INSTANCE.start(currentActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openMemorial$lambda$38() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(new Intent(currentActivity, (Class<?>) CpMemorialActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openPeopleCertification$lambda$64() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            PeopleCertificationActivity.INSTANCE.start(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openPraise$lambda$46() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            FriendStatusListActivity.INSTANCE.start(currentActivity, InteractiveTrackingType.Praise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openRelationDialog$lambda$55(User user, RelationMessageData relationMessageData) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            new RelationInvitationReceiveDialog(currentActivity, user, relationMessageData).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openSVIP$lambda$48() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(new Intent(currentActivity, (Class<?>) SvipActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openTask$lambda$44() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            TasksActivity.Companion.start$default(TasksActivity.INSTANCE, currentActivity, 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openWallet$lambda$14() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            WalletActivity.INSTANCE.start(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorTipDialog$lambda$2(final ErrorResponse errorResponse) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            TipTitleDialog tipTitleDialog = new TipTitleDialog(currentActivity);
            String title = errorResponse.getTitle();
            String str = "";
            if (title == null) {
                title = "";
            }
            TipTitleDialog titleContent = tipTitleDialog.setTitleContent(title);
            String detail = errorResponse.getDetail();
            if (detail != null) {
                str = detail;
            }
            titleContent.setTipContent(str).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.support.AppServiceImpl$showErrorTipDialog$1$1$1
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                }

                public void confirm() {
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        String actionUrl = errorResponse.getActionUrl();
                        if (actionUrl == null) {
                            actionUrl = "";
                        }
                        service.openCommonLink(actionUrl);
                    }
                }
            }).hideCancel(true).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showImageOrSvga$lambda$23(String str, String str2) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            new PicOrSvgaShowDialog(str, str2, currentActivity).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUpdateDialog$lambda$0() {
        UserService.INSTANCE.getShared().getMUploadEventRelay().accept("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showVipDialog$lambda$28(int i) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            new VipViewDialog(i, currentActivity).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startMyBag$lambda$21() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            MyBagActivity.INSTANCE.start(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWallet$lambda$25() {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            WalletActivity.INSTANCE.start(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toChat$lambda$19(String str) {
        final Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(UserService.INSTANCE.getShared(), str, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.support.h
                public final Object invoke(Object obj) {
                    Unit chat$lambda$19$lambda$18$lambda$16;
                    chat$lambda$19$lambda$18$lambda$16 = AppServiceImpl.toChat$lambda$19$lambda$18$lambda$16(currentActivity, (ApiResponse) obj);
                    return chat$lambda$19$lambda$18$lambda$16;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.support.i
                public final Object invoke(Object obj) {
                    Unit chat$lambda$19$lambda$18$lambda$17;
                    chat$lambda$19$lambda$18$lambda$17 = AppServiceImpl.toChat$lambda$19$lambda$18$lambda$17((Throwable) obj);
                    return chat$lambda$19$lambda$18$lambda$17;
                }
            }, (Function0) null, false, 12, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toChat$lambda$19$lambda$18$lambda$16(Activity activity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = (User) apiResponse.getData();
        if (user != null) {
            ChatActivity.Companion.start$default(ChatActivity.INSTANCE, activity, user, false, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toChat$lambda$19$lambda$18$lambda$17(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void videoCall$lambda$12(String str) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            VideoCallMessage.newStartVideo$default(VideoCallMessage.INSTANCE, currentActivity, str, null, null, 12, null);
        }
    }

    public void changeCommunityServer(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        CommunityManager.Companion.getInstance().initApiConfigs(HiloApplication.INSTANCE.getCONTEXT(), url);
    }

    public void changeRoomMessageTab(int messageTab) {
        MeetingRoomManager.INSTANCE.setMRoomChatTab(messageTab);
    }

    public boolean checkSensitive(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        return SensitiveUtil.INSTANCE.checkSensitive(str);
    }

    public boolean checkServerDebug() {
        return BaseServer.INSTANCE.checkServerDebug();
    }

    public boolean checkStrangerGroupFromSDK(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return StrangerProvide.INSTANCE.getGroupIdSet().contains(groupId);
    }

    public boolean checkStrangerGroupFromService(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return StrangerProvide.INSTANCE.getStrangerSet().contains(groupId);
    }

    public void exitToMainActivity() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.c
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.exitToMainActivity$lambda$42();
            }
        });
    }

    @Nullable
    public MultiGiftData findGiftByGiftId(long giftId) {
        return GiftUtils.INSTANCE.findGiftByGiftId(giftId);
    }

    @NotNull
    public String formatNumber(long num) {
        return NumberUtilsKt.rankNumberFormat(num);
    }

    @Nullable
    public Integer gameIcon(int gameType) {
        return GameIconUtils.INSTANCE.gameIcon(gameType);
    }

    @NotNull
    public String getAuthenticationToken() {
        String authenticationToken = UserStore.INSTANCE.getShared().getAuthenticationToken();
        if (authenticationToken == null) {
            return "";
        }
        return authenticationToken;
    }

    public double getDiamond() {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            return user.getDiamondNum();
        }
        return 0.0d;
    }

    @Nullable
    public File getFile(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return StorageUtils.INSTANCE.getFileCompat(filePath);
    }

    public long getId() {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            return user.getId();
        }
        return 0L;
    }

    public int getLevelBg(long level, boolean isCharm, boolean isWealth, boolean isActivity) {
        return UserService.INSTANCE.getLevelBg(level, isCharm, isWealth, isActivity);
    }

    public int getNobleDrawableRes(int nobleLevel) {
        return UserService.INSTANCE.getNobleDrawableRes(nobleLevel);
    }

    @NotNull
    public ArrayList<String> getSensitiveList() {
        return SensitiveUtil.INSTANCE.getSensitiveList();
    }

    public long getServerTime() {
        long serverTime = V2TIMManager.getInstance().getServerTime();
        if (serverTime <= 0) {
            return com.qiahao.base_common.utils.f.e() / 1000;
        }
        return serverTime;
    }

    @NotNull
    public String getSimOperator() {
        return HiloApplication.INSTANCE.getSimOperator();
    }

    @Nullable
    public User getUser() {
        return UserStore.INSTANCE.getShared().getUser();
    }

    @NotNull
    public String getUserExternalId() {
        String externalId;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (externalId = user.getExternalId()) == null) {
            return "";
        }
        return externalId;
    }

    public boolean isAuthenticated() {
        return UserStore.INSTANCE.getShared().isAuthenticated();
    }

    public void joinLive(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, groupId, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    public void logout(boolean isSendEvent) {
        UserStore.INSTANCE.getShared().logout();
    }

    public void matchGame(int mathId, int gameId, int mode, int gameType) {
        GameJum.matchGame$default(GameJum.INSTANCE, mathId, gameId, mode, gameType, null, 16, null);
    }

    public void newStartVideo(@NotNull Context context, @NotNull String externalId, @Nullable Function2<? super String, ? super Boolean, Unit> likeListener, @Nullable Function0<Unit> startVideo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        VideoCallMessage.INSTANCE.newStartVideo(context, externalId, likeListener, startVideo);
    }

    public void onEvent(@NotNull String event, @NotNull HashMap<String, Object> values) {
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(values, "values");
        FirebaseHelper.INSTANCE.onEvent(event, values);
        if (Intrinsics.areEqual(event, "login_hilo_e")) {
            ClientLogUtils clientLogUtils = ClientLogUtils.INSTANCE;
            Object obj = values.get(Constants.SHARED_MESSAGE_ID_FILE);
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            clientLogUtils.loginException(str);
        }
    }

    public void openActivityDetail(@NotNull String id2) {
        Intrinsics.checkNotNullParameter(id2, AgooConstants.MESSAGE_ID);
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            Intent intent = new Intent(currentActivity, (Class<?>) ActivitiesDetailActivity.class);
            intent.putExtra(ActivitiesDetailActivity.ACTIVITY_ID, id2);
            currentActivity.startActivity(intent);
        }
    }

    public void openAristocracy() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.o
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openAristocracy$lambda$52();
            }
        });
    }

    public void openAristocracyBag() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.k
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openAristocracyBag$lambda$50();
            }
        });
    }

    public void openBaiShunCenter() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.w
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openBaiShunCenter$lambda$62();
            }
        });
    }

    public void openBaiShunH5(@NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.n
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openBaiShunH5$lambda$59(url);
            }
        });
    }

    public void openCommonLink(@NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.a0
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openCommonLink$lambda$40(url);
            }
        });
    }

    public void openCpDialog(@NotNull final User user, @NotNull final String msg) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(msg, "msg");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.p
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openCpDialog$lambda$36(user, msg);
            }
        });
    }

    public void openCpZone(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            CpSpaceActivity.Companion.startActivity$default(CpSpaceActivity.INSTANCE, currentActivity, externalId, null, 0, 12, null);
        }
    }

    public void openDefaultBrowser(@NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.m
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openDefaultBrowser$lambda$8(url);
            }
        });
    }

    public void openFamily(long familyID) {
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            FamilyCenterActivity.INSTANCE.startActivity(currentActivity, familyID);
        }
    }

    public void openGameLevel() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.b
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openGameLevel$lambda$57();
            }
        });
    }

    public void openGemStore() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.x
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openGemStore$lambda$34();
            }
        });
    }

    public void openGroupSupport(@NotNull final String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.t
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openGroupSupport$lambda$4(groupId);
            }
        });
    }

    public void openH5(@NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.e
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openH5$lambda$6(url);
            }
        });
    }

    public void openHorizontalH5(@NotNull final String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.j
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openHorizontalH5$lambda$10(url);
            }
        });
    }

    public void openLevelActivity(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, currentActivity, url, null, 4, null);
        }
    }

    public void openMemorial() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.l
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openMemorial$lambda$38();
            }
        });
    }

    public void openPeopleCertification() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.y
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openPeopleCertification$lambda$64();
            }
        });
    }

    public void openPersonPage(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    public void openPraise() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.z
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openPraise$lambda$46();
            }
        });
    }

    public void openRelationDialog(@NotNull final User user, @NotNull final RelationMessageData data) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(data, "data");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.u
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openRelationDialog$lambda$55(user, data);
            }
        });
    }

    public void openSVIP() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.g
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openSVIP$lambda$48();
            }
        });
    }

    public void openSheep(int matchId, int gameId) {
        GameJum.matchGame$default(GameJum.INSTANCE, matchId, gameId, 0, 0, null, 28, null);
    }

    public void openTask() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.b0
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openTask$lambda$44();
            }
        });
    }

    public void openWallet() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.c0
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.openWallet$lambda$14();
            }
        });
    }

    public void recordException(@Nullable Throwable throwable) {
        if (throwable != null) {
            FirebaseCrashlytics.getInstance().recordException(throwable);
        }
    }

    public void recordLog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        FirebaseCrashlytics.getInstance().log(str);
    }

    public void refreshDiamondOrGem(double diamonds, double pinkDiamondNum) {
        UserStore.INSTANCE.getShared().refreshDiamondOrGem(diamonds, pinkDiamondNum);
    }

    public void refreshLikeCount(int likeCount) {
        User user;
        UserStore.Companion companion = UserStore.INSTANCE;
        UserStore shared = companion.getShared();
        User user2 = companion.getShared().getUser();
        if (user2 != null) {
            user2.setILikeCount(user2.getILikeCount() + likeCount);
            user = user2;
        } else {
            user = null;
        }
        UserStore.refreshUserInfo$default(shared, user, null, null, false, 14, null);
    }

    public int roomMessageTab() {
        return MeetingRoomManager.INSTANCE.getMRoomChatTab();
    }

    public void roomOpenUserInfo(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().openUseInfoEvent(externalId));
    }

    public void setAuthenticationToken(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        UserStore.INSTANCE.getShared().setAuthenticationToken(token);
    }

    public void showChatGiftDialog(@NotNull FragmentManager fragmentManager, @NotNull User user, @NotNull SendGiftListener listener, @Nullable String groupId, @Nullable Boolean isStrange) {
        String nick;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String externalId = user.getExternalId();
        String str = "";
        if (!Intrinsics.areEqual(isStrange, Boolean.TRUE) ? (nick = user.getNick()) != null : (nick = user.getMaskNick()) != null) {
            str = nick;
        }
        new OtherGiftDialog(externalId, str, false, groupId).setListener(listener).show(fragmentManager, "OtherGiftDialog");
    }

    public void showCpDialog(@NotNull OnCommonDialogListener listener, @NotNull String tip) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(tip, "tip");
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            new CpConfirmTwoDialog(currentActivity, false, 2, null).setCancelContent(ResourcesKtxKt.getStringById(this, 2131952171)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331)).setDialogListener(listener).setTipContent(tip).show();
        }
    }

    public void showErrorTipDialog(@NotNull final ErrorResponse data) {
        Intrinsics.checkNotNullParameter(data, "data");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.q
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.showErrorTipDialog$lambda$2(data);
            }
        });
    }

    public void showImageOrSvga(@NotNull final String url, @NotNull final String svgaUrl) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(svgaUrl, "svgaUrl");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.a
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.showImageOrSvga$lambda$23(url, svgaUrl);
            }
        });
    }

    public void showRelationDialog(@NotNull OnCommonDialogListener listener, @NotNull String tip) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(tip, "tip");
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            new CpConfirmTwoDialog(currentActivity, false).setCancelContent(ResourcesKtxKt.getStringById(this, 2131952171)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331)).setDialogListener(listener).setTipContent(tip).show();
        }
    }

    public void showUpdateDialog() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.r
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.showUpdateDialog$lambda$0();
            }
        });
    }

    public void showVipDialog(final int position) {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.d0
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.showVipDialog$lambda$28(position);
            }
        });
    }

    public void startMyBag() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.f
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.startMyBag$lambda$21();
            }
        });
    }

    public void startWallet() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.d
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.startWallet$lambda$25();
            }
        });
    }

    public void toChat(@NotNull final String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.s
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.toChat$lambda$19(externalId);
            }
        });
    }

    @NotNull
    public i0<Pair<Boolean, String>> uploadFile(@Nullable String folder, @NotNull File uploadFile, boolean isVideo, @Nullable Function2<? super Long, ? super Long, Unit> progressListener) {
        Intrinsics.checkNotNullParameter(uploadFile, "uploadFile");
        AliCloudService shared = AliCloudService.INSTANCE.getShared();
        if (TextUtils.isEmpty(folder)) {
            folder = AliCloudService.OSS_USER_REPORTS;
        } else if (folder == null) {
            folder = "";
        }
        return shared.uploadFile(folder, uploadFile, isVideo, progressListener);
    }

    public void videoCall(@NotNull final String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.support.v
            @Override // java.lang.Runnable
            public final void run() {
                AppServiceImpl.videoCall$lambda$12(externalId);
            }
        });
    }
}
