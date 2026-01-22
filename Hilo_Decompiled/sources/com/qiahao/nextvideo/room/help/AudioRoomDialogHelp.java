package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.MyCp;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipTitleDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.CreateSudData;
import com.qiahao.nextvideo.data.game.GameConfig;
import com.qiahao.nextvideo.data.game.GameConfigLudo;
import com.qiahao.nextvideo.data.game.Pk1v1Data;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.LuckWheelInfo;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.model.groupSets;
import com.qiahao.nextvideo.data.room.EnvelopeData;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.databinding.AudioHiloGameBinding;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.activity.MyMusicActivity;
import com.qiahao.nextvideo.room.dialog.Create1v1PKDialog;
import com.qiahao.nextvideo.room.dialog.GroupMusicDialog;
import com.qiahao.nextvideo.room.dialog.InviteFriendsBottomSheetDialog;
import com.qiahao.nextvideo.room.dialog.InviteFriendsListener;
import com.qiahao.nextvideo.room.dialog.LeaveRoomDialog;
import com.qiahao.nextvideo.room.dialog.LeaveRoomDialogListener;
import com.qiahao.nextvideo.room.dialog.LuckyWheelDialog;
import com.qiahao.nextvideo.room.dialog.LuckyWheelListener;
import com.qiahao.nextvideo.room.dialog.MicOperateBottomDialog;
import com.qiahao.nextvideo.room.dialog.MusicDialogListener;
import com.qiahao.nextvideo.room.dialog.MysteryDialog;
import com.qiahao.nextvideo.room.dialog.RoomAnimationEffectBottomDialog;
import com.qiahao.nextvideo.room.dialog.RoomAnimationEffectListener;
import com.qiahao.nextvideo.room.dialog.RoomGameDialog;
import com.qiahao.nextvideo.room.dialog.RoomGamePanelListener;
import com.qiahao.nextvideo.room.dialog.RoomPKCreateDialog;
import com.qiahao.nextvideo.room.dialog.RoomPowerJoinDialog;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.dialog.RoomToolDialog;
import com.qiahao.nextvideo.room.dialog.SendGroupBroadcastDialog;
import com.qiahao.nextvideo.room.dialog.TakeMicTaskCompleteDialog;
import com.qiahao.nextvideo.room.dialog.TakeMicTaskCompleteDialogListener;
import com.qiahao.nextvideo.room.dialog.UserInfoBottomSheetDialog;
import com.qiahao.nextvideo.room.dialog.UserInfoCpDialog;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.game.CreateBackgammonDialog;
import com.qiahao.nextvideo.room.game.CreateBalootDialog;
import com.qiahao.nextvideo.room.game.CreateCarromDialog;
import com.qiahao.nextvideo.room.game.CreateCrushDialog;
import com.qiahao.nextvideo.room.game.CreateDominoDialog;
import com.qiahao.nextvideo.room.game.CreateJackaroDialog;
import com.qiahao.nextvideo.room.game.CreateLudoDialog;
import com.qiahao.nextvideo.room.game.CreateUnoDialog;
import com.qiahao.nextvideo.room.interfaces.UserInfoListener;
import com.qiahao.nextvideo.room.luckybox.LuckyBoxDialog;
import com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog;
import com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialogListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeCreateDialog;
import com.qiahao.nextvideo.room.rocket.RoomRocketDialog;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.view.RocketSvgaCountdownView;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.share.ShareContactsActivity;
import com.qiahao.nextvideo.share.r;
import com.qiahao.nextvideo.ui.foodie.FoodieGameDialog;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.ui.webview.H5DiamondGameDialog;
import com.qiahao.nextvideo.ui.webview.H5GameDialog;
import com.qiahao.nextvideo.ui.webview.H5GemGameDialog;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010§\u0001\u001a\u00030¨\u00012\f\b\u0002\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001J\b\u0010«\u0001\u001a\u00030¨\u0001J\b\u0010¬\u0001\u001a\u00030¨\u0001J\b\u0010\u00ad\u0001\u001a\u00030¨\u0001J\b\u0010®\u0001\u001a\u00030¨\u0001J\b\u0010¯\u0001\u001a\u00030¨\u0001J\b\u0010°\u0001\u001a\u00030¨\u0001J\b\u0010±\u0001\u001a\u00030¨\u0001J\u001c\u0010²\u0001\u001a\u00030¨\u00012\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001J\u0012\u0010·\u0001\u001a\u00030¨\u00012\b\u0010¸\u0001\u001a\u00030¹\u0001J\b\u0010º\u0001\u001a\u00030¨\u0001J\u0012\u0010»\u0001\u001a\u00030¨\u00012\b\u0010¼\u0001\u001a\u00030½\u0001J\n\u0010¾\u0001\u001a\u00030¨\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030¨\u0001H\u0002J\b\u0010À\u0001\u001a\u00030¨\u0001J\b\u0010Á\u0001\u001a\u00030¨\u0001J\b\u0010Â\u0001\u001a\u00030¨\u0001J\b\u0010Ã\u0001\u001a\u00030¨\u0001J\b\u0010Ä\u0001\u001a\u00030¨\u0001J\b\u0010Å\u0001\u001a\u00030¨\u0001J\n\u0010Æ\u0001\u001a\u00030¨\u0001H\u0002J\b\u0010Ç\u0001\u001a\u00030¨\u0001J\b\u0010È\u0001\u001a\u00030¨\u0001J\b\u0010É\u0001\u001a\u00030¨\u0001J,\u0010Ê\u0001\u001a\u00030¨\u00012\n\b\u0002\u0010Ë\u0001\u001a\u00030Ì\u00012\n\b\u0002\u0010Í\u0001\u001a\u00030Ì\u00012\n\b\u0002\u0010Î\u0001\u001a\u00030\u0087\u0001J\b\u0010Ï\u0001\u001a\u00030¨\u0001J\u0012\u0010Ð\u0001\u001a\u00030¨\u00012\b\u0010Ñ\u0001\u001a\u00030Ì\u0001J\u0012\u0010Ò\u0001\u001a\u00030¨\u00012\b\u0010Ó\u0001\u001a\u00030Ì\u0001J#\u0010Ô\u0001\u001a\u00030¨\u00012\b\u0010Õ\u0001\u001a\u00030½\u00012\u000f\u0010Ö\u0001\u001a\n\u0012\u0005\u0012\u00030¨\u00010×\u0001J(\u0010Ø\u0001\u001a\u00030¨\u00012\b\u0010Ù\u0001\u001a\u00030½\u00012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u00012\b\u0010Ü\u0001\u001a\u00030\u0087\u0001J\u001c\u0010Ý\u0001\u001a\u00030¨\u00012\b\u0010Þ\u0001\u001a\u00030Ì\u00012\b\u0010ß\u0001\u001a\u00030½\u0001J_\u0010à\u0001\u001a\u00030¨\u00012\b\u0010Þ\u0001\u001a\u00030Ì\u00012\n\b\u0002\u0010á\u0001\u001a\u00030Ì\u00012(\u0010Ö\u0001\u001a#\u0012\u0017\u0012\u00150ã\u0001¢\u0006\u000f\bä\u0001\u0012\n\bÑ\u0001\u0012\u0005\b\b(å\u0001\u0012\u0005\u0012\u00030¨\u00010â\u00012\u0013\b\u0002\u0010æ\u0001\u001a\f\u0012\u0005\u0012\u00030¨\u0001\u0018\u00010×\u0001H\u0002J\b\u0010ç\u0001\u001a\u00030¨\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010z\u001a\u0004\u0018\u00010{X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\"\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R \u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u008f\u0001\"\u0006\b\u0094\u0001\u0010\u0091\u0001R\"\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u008f\u0001\"\u0006\b\u0097\u0001\u0010\u0091\u0001R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u008f\u0001\"\u0006\b\u009a\u0001\u0010\u0091\u0001R\"\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u008f\u0001\"\u0006\b\u009d\u0001\u0010\u0091\u0001R\"\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u008f\u0001\"\u0006\b \u0001\u0010\u0091\u0001R\"\u0010¡\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0001\u0010\u008f\u0001\"\u0006\b£\u0001\u0010\u0091\u0001R\"\u0010¤\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010\u008f\u0001\"\u0006\b¦\u0001\u0010\u0091\u0001¨\u0006è\u0001"}, d2 = {"Lcom/qiahao/nextvideo/room/help/AudioRoomDialogHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "mLuckyWheelDialog", "Lcom/qiahao/nextvideo/room/dialog/LuckyWheelDialog;", "getMLuckyWheelDialog", "()Lcom/qiahao/nextvideo/room/dialog/LuckyWheelDialog;", "setMLuckyWheelDialog", "(Lcom/qiahao/nextvideo/room/dialog/LuckyWheelDialog;)V", "mRoomGameDialog", "Lcom/qiahao/nextvideo/room/dialog/RoomGameDialog;", "getMRoomGameDialog", "()Lcom/qiahao/nextvideo/room/dialog/RoomGameDialog;", "setMRoomGameDialog", "(Lcom/qiahao/nextvideo/room/dialog/RoomGameDialog;)V", "mRoomToolDialog", "Lcom/qiahao/nextvideo/room/dialog/RoomToolDialog;", "getMRoomToolDialog", "()Lcom/qiahao/nextvideo/room/dialog/RoomToolDialog;", "setMRoomToolDialog", "(Lcom/qiahao/nextvideo/room/dialog/RoomToolDialog;)V", "mUserInfoBottomSheetDialog", "Lcom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog;", "getMUserInfoBottomSheetDialog", "()Lcom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog;", "setMUserInfoBottomSheetDialog", "(Lcom/qiahao/nextvideo/room/dialog/UserInfoBottomSheetDialog;)V", "mUserInfoCpDialog", "Lcom/qiahao/nextvideo/room/dialog/UserInfoCpDialog;", "getMUserInfoCpDialog", "()Lcom/qiahao/nextvideo/room/dialog/UserInfoCpDialog;", "setMUserInfoCpDialog", "(Lcom/qiahao/nextvideo/room/dialog/UserInfoCpDialog;)V", "roomTipDialog", "Lcom/qiahao/nextvideo/room/dialog/RoomTipDialog;", "getRoomTipDialog", "()Lcom/qiahao/nextvideo/room/dialog/RoomTipDialog;", "setRoomTipDialog", "(Lcom/qiahao/nextvideo/room/dialog/RoomTipDialog;)V", "mRocketDialog", "Lcom/qiahao/nextvideo/room/rocket/RoomRocketDialog;", "getMRocketDialog", "()Lcom/qiahao/nextvideo/room/rocket/RoomRocketDialog;", "setMRocketDialog", "(Lcom/qiahao/nextvideo/room/rocket/RoomRocketDialog;)V", "mLeaveRoomDialog", "Lcom/qiahao/nextvideo/room/dialog/LeaveRoomDialog;", "getMLeaveRoomDialog", "()Lcom/qiahao/nextvideo/room/dialog/LeaveRoomDialog;", "setMLeaveRoomDialog", "(Lcom/qiahao/nextvideo/room/dialog/LeaveRoomDialog;)V", "mLuckyFruitDialog", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialog;", "getMLuckyFruitDialog", "()Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialog;", "setMLuckyFruitDialog", "(Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialog;)V", "commonTextDialog", "Lcom/qiahao/nextvideo/app/base/CommonTextDialog;", "getCommonTextDialog", "()Lcom/qiahao/nextvideo/app/base/CommonTextDialog;", "setCommonTextDialog", "(Lcom/qiahao/nextvideo/app/base/CommonTextDialog;)V", "mGroupMusicDialog", "Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog;", "getMGroupMusicDialog", "()Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog;", "setMGroupMusicDialog", "(Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog;)V", "mCreateLudoDialog", "Lcom/qiahao/nextvideo/room/game/CreateLudoDialog;", "getMCreateLudoDialog", "()Lcom/qiahao/nextvideo/room/game/CreateLudoDialog;", "setMCreateLudoDialog", "(Lcom/qiahao/nextvideo/room/game/CreateLudoDialog;)V", "mCreateUnoDialog", "Lcom/qiahao/nextvideo/room/game/CreateUnoDialog;", "getMCreateUnoDialog", "()Lcom/qiahao/nextvideo/room/game/CreateUnoDialog;", "setMCreateUnoDialog", "(Lcom/qiahao/nextvideo/room/game/CreateUnoDialog;)V", "mCreateDominoDialog", "Lcom/qiahao/nextvideo/room/game/CreateDominoDialog;", "getMCreateDominoDialog", "()Lcom/qiahao/nextvideo/room/game/CreateDominoDialog;", "setMCreateDominoDialog", "(Lcom/qiahao/nextvideo/room/game/CreateDominoDialog;)V", "mCreateCrushDialog", "Lcom/qiahao/nextvideo/room/game/CreateCrushDialog;", "getMCreateCrushDialog", "()Lcom/qiahao/nextvideo/room/game/CreateCrushDialog;", "setMCreateCrushDialog", "(Lcom/qiahao/nextvideo/room/game/CreateCrushDialog;)V", "mCreateBalootDialog", "Lcom/qiahao/nextvideo/room/game/CreateBalootDialog;", "getMCreateBalootDialog", "()Lcom/qiahao/nextvideo/room/game/CreateBalootDialog;", "setMCreateBalootDialog", "(Lcom/qiahao/nextvideo/room/game/CreateBalootDialog;)V", "mCreateCarromDialog", "Lcom/qiahao/nextvideo/room/game/CreateCarromDialog;", "getMCreateCarromDialog", "()Lcom/qiahao/nextvideo/room/game/CreateCarromDialog;", "setMCreateCarromDialog", "(Lcom/qiahao/nextvideo/room/game/CreateCarromDialog;)V", "mCreateJackaroDialog", "Lcom/qiahao/nextvideo/room/game/CreateJackaroDialog;", "getMCreateJackaroDialog", "()Lcom/qiahao/nextvideo/room/game/CreateJackaroDialog;", "setMCreateJackaroDialog", "(Lcom/qiahao/nextvideo/room/game/CreateJackaroDialog;)V", "mCreateBackgammonDialog", "Lcom/qiahao/nextvideo/room/game/CreateBackgammonDialog;", "getMCreateBackgammonDialog", "()Lcom/qiahao/nextvideo/room/game/CreateBackgammonDialog;", "setMCreateBackgammonDialog", "(Lcom/qiahao/nextvideo/room/game/CreateBackgammonDialog;)V", "mPk1v1", "Lcom/qiahao/nextvideo/room/dialog/Create1v1PKDialog;", "getMPk1v1", "()Lcom/qiahao/nextvideo/room/dialog/Create1v1PKDialog;", "setMPk1v1", "(Lcom/qiahao/nextvideo/room/dialog/Create1v1PKDialog;)V", "mFoodieDialog", "Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "getMFoodieDialog", "()Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "setMFoodieDialog", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;)V", "mSmallLuckWheelDialog", "", "getMSmallLuckWheelDialog", "()Z", "setMSmallLuckWheelDialog", "(Z)V", "mCreateLudoData", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "getMCreateLudoData", "()Lcom/qiahao/nextvideo/data/game/CreateSudData;", "setMCreateLudoData", "(Lcom/qiahao/nextvideo/data/game/CreateSudData;)V", "mCreateUnoData", "getMCreateUnoData", "setMCreateUnoData", "mCreateDominoData", "getMCreateDominoData", "setMCreateDominoData", "mCreateCrushData", "getMCreateCrushData", "setMCreateCrushData", "mCreateBalootData", "getMCreateBalootData", "setMCreateBalootData", "mCreateCarromData", "getMCreateCarromData", "setMCreateCarromData", "mCreateJackaroData", "getMCreateJackaroData", "setMCreateJackaroData", "mCreateBackgamonData", "getMCreateBackgamonData", "setMCreateBackgamonData", "showLuckyDialog", "", "data", "Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "showLeaveRoomDialog", "showLuckyFruitDialog", "showFoodieDialog", "showRocketDialog", "showRoomTipDialog", "showToolDialog", "showGameDialog", "showGame", "context", "Landroid/content/Context;", "gameConfiguration", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "showRoomMemberMass", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroidx/fragment/app/FragmentActivity;", "createLudoDialog", "callCreate", "gameType", "", "createUnoDialog", "createDominoDialog", "createBalootDialog", "createCarromDialog", "createJackaroDialog", "createBackgammonDialog", "createPk1v1", "createPKDialog", "createCrushDialog", "inviteUserDialog", "showGroupMusicDialog", "showGameLuckWheel", "showToastOrLog", "toastText", "", "logText", "writeIn", "showTakeMicTaskCompleteDialog", "showInviteUserUpDialog", "name", "autoOnMic", "micType", "checkTouristRole", "touristRole", "onSuccess", "Lkotlin/Function0;", "showMicOperateBottomDialog", "position", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "showLockLayout", "showUserInfoDialog", "extraId", "micPosition", "getUserInfoByExtraId", "groupId", "Lkotlin/Function1;", "Lcom/qiahao/base_common/model/common/User;", "Lkotlin/ParameterName;", "user", "onError", "release", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomDialogHelp {

    @Nullable
    private CommonTextDialog commonTextDialog;

    @NotNull
    private final AudioRoomFragment fragment;

    @Nullable
    private CreateBackgammonDialog mCreateBackgammonDialog;

    @Nullable
    private CreateSudData mCreateBackgamonData;

    @Nullable
    private CreateSudData mCreateBalootData;

    @Nullable
    private CreateBalootDialog mCreateBalootDialog;

    @Nullable
    private CreateSudData mCreateCarromData;

    @Nullable
    private CreateCarromDialog mCreateCarromDialog;

    @Nullable
    private CreateSudData mCreateCrushData;

    @Nullable
    private CreateCrushDialog mCreateCrushDialog;

    @Nullable
    private CreateSudData mCreateDominoData;

    @Nullable
    private CreateDominoDialog mCreateDominoDialog;

    @Nullable
    private CreateSudData mCreateJackaroData;

    @Nullable
    private CreateJackaroDialog mCreateJackaroDialog;

    @Nullable
    private CreateSudData mCreateLudoData;

    @Nullable
    private CreateLudoDialog mCreateLudoDialog;

    @Nullable
    private CreateSudData mCreateUnoData;

    @Nullable
    private CreateUnoDialog mCreateUnoDialog;

    @Nullable
    private FoodieGameDialog mFoodieDialog;

    @Nullable
    private GroupMusicDialog mGroupMusicDialog;

    @Nullable
    private LeaveRoomDialog mLeaveRoomDialog;

    @Nullable
    private LuckyFruitDialog mLuckyFruitDialog;

    @Nullable
    private LuckyWheelDialog mLuckyWheelDialog;

    @Nullable
    private Create1v1PKDialog mPk1v1;

    @Nullable
    private RoomRocketDialog mRocketDialog;

    @Nullable
    private RoomGameDialog mRoomGameDialog;

    @Nullable
    private RoomToolDialog mRoomToolDialog;
    private boolean mSmallLuckWheelDialog;

    @Nullable
    private UserInfoBottomSheetDialog mUserInfoBottomSheetDialog;

    @Nullable
    private UserInfoCpDialog mUserInfoCpDialog;

    @Nullable
    private RoomTipDialog roomTipDialog;

    public AudioRoomDialogHelp(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit callCreate$lambda$24$lambda$21(int i, AudioRoomDialogHelp audioRoomDialogHelp) {
        CreateBackgammonDialog createBackgammonDialog;
        if (i != 1) {
            if (i != 2) {
                if (i != 10) {
                    if (i != 11) {
                        if (i != 14) {
                            if (i != 18) {
                                if (i != 21) {
                                    if (i == 23 && (createBackgammonDialog = audioRoomDialogHelp.mCreateBackgammonDialog) != null) {
                                        createBackgammonDialog.dismiss();
                                    }
                                } else {
                                    CreateJackaroDialog createJackaroDialog = audioRoomDialogHelp.mCreateJackaroDialog;
                                    if (createJackaroDialog != null) {
                                        createJackaroDialog.dismiss();
                                    }
                                }
                            } else {
                                CreateCarromDialog createCarromDialog = audioRoomDialogHelp.mCreateCarromDialog;
                                if (createCarromDialog != null) {
                                    createCarromDialog.dismiss();
                                }
                            }
                        } else {
                            CreateBalootDialog createBalootDialog = audioRoomDialogHelp.mCreateBalootDialog;
                            if (createBalootDialog != null) {
                                createBalootDialog.dismiss();
                            }
                        }
                    } else {
                        CreateCrushDialog createCrushDialog = audioRoomDialogHelp.mCreateCrushDialog;
                        if (createCrushDialog != null) {
                            createCrushDialog.dismiss();
                        }
                    }
                } else {
                    CreateDominoDialog createDominoDialog = audioRoomDialogHelp.mCreateDominoDialog;
                    if (createDominoDialog != null) {
                        createDominoDialog.dismiss();
                    }
                }
            } else {
                CreateUnoDialog createUnoDialog = audioRoomDialogHelp.mCreateUnoDialog;
                if (createUnoDialog != null) {
                    createUnoDialog.dismiss();
                }
            }
        } else {
            CreateLudoDialog createLudoDialog = audioRoomDialogHelp.mCreateLudoDialog;
            if (createLudoDialog != null) {
                createLudoDialog.dismiss();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit callCreate$lambda$24$lambda$23(AudioRoomDialogHelp audioRoomDialogHelp, Throwable th) {
        String str;
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 4000) {
                final FragmentActivity activity = audioRoomDialogHelp.fragment.getActivity();
                if (activity != null) {
                    new RoomTipDialog(activity).setTipContent(ResourcesKtxKt.getStringById(audioRoomDialogHelp, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$callCreate$1$2$1$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            WalletActivity.INSTANCE.start(activity);
                        }
                    }).show();
                }
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = audioRoomDialogHelp.fragment.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(audioRoomDialogHelp, 2131952667);
                } else {
                    str = errorMessage;
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkTouristRole$lambda$66$lambda$65$lambda$64(AudioRoomDialogHelp audioRoomDialogHelp, FragmentActivity fragmentActivity, int i) {
        int i2;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            i2 = (int) user.getDiamondNum();
        } else {
            i2 = 0;
        }
        if (i2 >= i) {
            RoomViewModel.acceptInvite$default(audioRoomDialogHelp.fragment.getMViewModel(), 0, 1, null);
        } else {
            WalletActivity.INSTANCE.start(fragmentActivity);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createBackgammonDialog$lambda$48$lambda$46$lambda$45(AudioRoomDialogHelp audioRoomDialogHelp, CreateSudData createSudData) {
        String str;
        Intrinsics.checkNotNullParameter(createSudData, "it");
        audioRoomDialogHelp.mCreateBackgamonData = createSudData;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (meetingRoomManager.checkUserOnMic(str)) {
            audioRoomDialogHelp.callCreate(23);
        } else {
            AudioRoomDialogHelp mDialogHelp = audioRoomDialogHelp.fragment.getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.autoOnMic(RoomViewModel.MIC_CREATE_BACKGAMMON);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createBackgammonDialog$lambda$48$lambda$47(AudioRoomDialogHelp audioRoomDialogHelp, DialogInterface dialogInterface) {
        audioRoomDialogHelp.mCreateBackgammonDialog = null;
        audioRoomDialogHelp.mCreateBackgamonData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createBalootDialog$lambda$36$lambda$34$lambda$33(AudioRoomDialogHelp audioRoomDialogHelp, CreateSudData createSudData) {
        String str;
        Intrinsics.checkNotNullParameter(createSudData, "it");
        audioRoomDialogHelp.mCreateBalootData = createSudData;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (meetingRoomManager.checkUserOnMic(str)) {
            audioRoomDialogHelp.callCreate(14);
        } else {
            AudioRoomDialogHelp mDialogHelp = audioRoomDialogHelp.fragment.getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.autoOnMic(RoomViewModel.MIC_CREATE_BALOOT);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createBalootDialog$lambda$36$lambda$35(AudioRoomDialogHelp audioRoomDialogHelp, DialogInterface dialogInterface) {
        audioRoomDialogHelp.mCreateBalootDialog = null;
        audioRoomDialogHelp.mCreateBalootData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createCarromDialog$lambda$40$lambda$38$lambda$37(AudioRoomDialogHelp audioRoomDialogHelp, CreateSudData createSudData) {
        String str;
        Intrinsics.checkNotNullParameter(createSudData, "it");
        audioRoomDialogHelp.mCreateCarromData = createSudData;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (meetingRoomManager.checkUserOnMic(str)) {
            audioRoomDialogHelp.callCreate(18);
        } else {
            AudioRoomDialogHelp mDialogHelp = audioRoomDialogHelp.fragment.getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.autoOnMic(RoomViewModel.MIC_CREATE_CARROM);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCarromDialog$lambda$40$lambda$39(AudioRoomDialogHelp audioRoomDialogHelp, DialogInterface dialogInterface) {
        audioRoomDialogHelp.mCreateCarromDialog = null;
        audioRoomDialogHelp.mCreateCarromData = null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.qiahao.nextvideo.room.game.CreateCrushDialog, android.app.Dialog] */
    private final void createCrushDialog() {
        GameConfigLudo gameConfigLudo;
        GameConfig gameConfig;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null) {
                gameConfigLudo = gameConfig.getCrush();
            } else {
                gameConfigLudo = null;
            }
            ?? createCrushDialog = new CreateCrushDialog(activity, null, null, gameConfigLudo, 6, null);
            createCrushDialog.setCreateListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.q
                public final Object invoke(Object obj) {
                    Unit createCrushDialog$lambda$55$lambda$53$lambda$52;
                    createCrushDialog$lambda$55$lambda$53$lambda$52 = AudioRoomDialogHelp.createCrushDialog$lambda$55$lambda$53$lambda$52(AudioRoomDialogHelp.this, (CreateSudData) obj);
                    return createCrushDialog$lambda$55$lambda$53$lambda$52;
                }
            });
            this.mCreateCrushDialog = createCrushDialog;
            createCrushDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.b0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.createCrushDialog$lambda$55$lambda$54(AudioRoomDialogHelp.this, dialogInterface);
                }
            });
            CreateCrushDialog createCrushDialog2 = this.mCreateCrushDialog;
            if (createCrushDialog2 != null) {
                createCrushDialog2.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createCrushDialog$lambda$55$lambda$53$lambda$52(AudioRoomDialogHelp audioRoomDialogHelp, CreateSudData createSudData) {
        String str;
        Intrinsics.checkNotNullParameter(createSudData, "it");
        audioRoomDialogHelp.mCreateCrushData = createSudData;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (meetingRoomManager.checkUserOnMic(str)) {
            audioRoomDialogHelp.callCreate(11);
        } else {
            AudioRoomDialogHelp mDialogHelp = audioRoomDialogHelp.fragment.getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.autoOnMic(RoomViewModel.MIC_CREATE_CRUSH);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createCrushDialog$lambda$55$lambda$54(AudioRoomDialogHelp audioRoomDialogHelp, DialogInterface dialogInterface) {
        audioRoomDialogHelp.mCreateCrushDialog = null;
        audioRoomDialogHelp.mCreateCrushData = null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.qiahao.nextvideo.room.game.CreateDominoDialog, android.app.Dialog] */
    private final void createDominoDialog() {
        ArrayList<Integer> arrayList;
        GameConfig gameConfig;
        GameConfigLudo domino;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null && (domino = gameConfig.getDomino()) != null) {
                arrayList = domino.getDiamond();
            } else {
                arrayList = null;
            }
            ?? createDominoDialog = new CreateDominoDialog(activity, null, null, arrayList, 6, null);
            createDominoDialog.setCreateListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.w
                public final Object invoke(Object obj) {
                    Unit createDominoDialog$lambda$32$lambda$30$lambda$29;
                    createDominoDialog$lambda$32$lambda$30$lambda$29 = AudioRoomDialogHelp.createDominoDialog$lambda$32$lambda$30$lambda$29(AudioRoomDialogHelp.this, (CreateSudData) obj);
                    return createDominoDialog$lambda$32$lambda$30$lambda$29;
                }
            });
            this.mCreateDominoDialog = createDominoDialog;
            createDominoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.x
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.createDominoDialog$lambda$32$lambda$31(AudioRoomDialogHelp.this, dialogInterface);
                }
            });
            CreateDominoDialog createDominoDialog2 = this.mCreateDominoDialog;
            if (createDominoDialog2 != null) {
                createDominoDialog2.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createDominoDialog$lambda$32$lambda$30$lambda$29(AudioRoomDialogHelp audioRoomDialogHelp, CreateSudData createSudData) {
        String str;
        Intrinsics.checkNotNullParameter(createSudData, "it");
        audioRoomDialogHelp.mCreateDominoData = createSudData;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (meetingRoomManager.checkUserOnMic(str)) {
            audioRoomDialogHelp.callCreate(10);
        } else {
            AudioRoomDialogHelp mDialogHelp = audioRoomDialogHelp.fragment.getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.autoOnMic(RoomViewModel.MIC_CREATE_DOMINO);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDominoDialog$lambda$32$lambda$31(AudioRoomDialogHelp audioRoomDialogHelp, DialogInterface dialogInterface) {
        audioRoomDialogHelp.mCreateDominoDialog = null;
        audioRoomDialogHelp.mCreateDominoData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createJackaroDialog$lambda$44$lambda$42$lambda$41(AudioRoomDialogHelp audioRoomDialogHelp, CreateSudData createSudData) {
        String str;
        Intrinsics.checkNotNullParameter(createSudData, "it");
        audioRoomDialogHelp.mCreateJackaroData = createSudData;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (meetingRoomManager.checkUserOnMic(str)) {
            audioRoomDialogHelp.callCreate(21);
        } else {
            AudioRoomDialogHelp mDialogHelp = audioRoomDialogHelp.fragment.getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.autoOnMic(RoomViewModel.MIC_CREATE_JACKAROO);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createJackaroDialog$lambda$44$lambda$43(AudioRoomDialogHelp audioRoomDialogHelp, DialogInterface dialogInterface) {
        audioRoomDialogHelp.mCreateJackaroDialog = null;
        audioRoomDialogHelp.mCreateJackaroData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createLudoDialog$lambda$20$lambda$18$lambda$17(AudioRoomDialogHelp audioRoomDialogHelp, CreateSudData createSudData) {
        String str;
        Intrinsics.checkNotNullParameter(createSudData, "it");
        audioRoomDialogHelp.mCreateLudoData = createSudData;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (meetingRoomManager.checkUserOnMic(str)) {
            audioRoomDialogHelp.callCreate(1);
        } else {
            AudioRoomDialogHelp mDialogHelp = audioRoomDialogHelp.fragment.getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.autoOnMic(RoomViewModel.MIC_CREATE_LUDO);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createLudoDialog$lambda$20$lambda$19(AudioRoomDialogHelp audioRoomDialogHelp, DialogInterface dialogInterface) {
        audioRoomDialogHelp.mCreateLudoDialog = null;
        audioRoomDialogHelp.mCreateLudoData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createPk1v1$lambda$51$lambda$50$lambda$49(AudioRoomDialogHelp audioRoomDialogHelp) {
        audioRoomDialogHelp.mPk1v1 = null;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.qiahao.nextvideo.room.game.CreateUnoDialog, android.app.Dialog] */
    private final void createUnoDialog() {
        GameConfigLudo gameConfigLudo;
        GameConfig gameConfig;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null) {
                gameConfigLudo = gameConfig.getUno();
            } else {
                gameConfigLudo = null;
            }
            ?? createUnoDialog = new CreateUnoDialog(activity, null, null, gameConfigLudo, 6, null);
            createUnoDialog.setCreateListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.g0
                public final Object invoke(Object obj) {
                    Unit createUnoDialog$lambda$28$lambda$26$lambda$25;
                    createUnoDialog$lambda$28$lambda$26$lambda$25 = AudioRoomDialogHelp.createUnoDialog$lambda$28$lambda$26$lambda$25(AudioRoomDialogHelp.this, (CreateSudData) obj);
                    return createUnoDialog$lambda$28$lambda$26$lambda$25;
                }
            });
            this.mCreateUnoDialog = createUnoDialog;
            createUnoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.h0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.createUnoDialog$lambda$28$lambda$27(AudioRoomDialogHelp.this, dialogInterface);
                }
            });
            CreateUnoDialog createUnoDialog2 = this.mCreateUnoDialog;
            if (createUnoDialog2 != null) {
                createUnoDialog2.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createUnoDialog$lambda$28$lambda$26$lambda$25(AudioRoomDialogHelp audioRoomDialogHelp, CreateSudData createSudData) {
        String str;
        Intrinsics.checkNotNullParameter(createSudData, "it");
        audioRoomDialogHelp.mCreateUnoData = createSudData;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (meetingRoomManager.checkUserOnMic(str)) {
            audioRoomDialogHelp.callCreate(2);
        } else {
            AudioRoomDialogHelp mDialogHelp = audioRoomDialogHelp.fragment.getMDialogHelp();
            if (mDialogHelp != null) {
                mDialogHelp.autoOnMic(RoomViewModel.MIC_CREATE_UNO);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createUnoDialog$lambda$28$lambda$27(AudioRoomDialogHelp audioRoomDialogHelp, DialogInterface dialogInterface) {
        audioRoomDialogHelp.mCreateUnoDialog = null;
        audioRoomDialogHelp.mCreateUnoData = null;
    }

    private final void getUserInfoByExtraId(String extraId, String groupId, final Function1<? super User, Unit> onSuccess, final Function0<Unit> onError) {
        RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().roomUserInfo(extraId, groupId), new Function1() { // from class: com.qiahao.nextvideo.room.help.o0
            public final Object invoke(Object obj) {
                Unit userInfoByExtraId$lambda$75;
                userInfoByExtraId$lambda$75 = AudioRoomDialogHelp.getUserInfoByExtraId$lambda$75(AudioRoomDialogHelp.this, onSuccess, (ApiResponse) obj);
                return userInfoByExtraId$lambda$75;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.help.p0
            public final Object invoke(Object obj) {
                Unit userInfoByExtraId$lambda$76;
                userInfoByExtraId$lambda$76 = AudioRoomDialogHelp.getUserInfoByExtraId$lambda$76(onError, (Throwable) obj);
                return userInfoByExtraId$lambda$76;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getUserInfoByExtraId$default(AudioRoomDialogHelp audioRoomDialogHelp, String str, String str2, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        audioRoomDialogHelp.getUserInfoByExtraId(str, str2, function1, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfoByExtraId$lambda$75(AudioRoomDialogHelp audioRoomDialogHelp, Function1 function1, ApiResponse apiResponse) {
        FragmentActivity activity;
        FragmentActivity activity2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = (User) apiResponse.getData();
        if (user != null && (activity = audioRoomDialogHelp.fragment.getActivity()) != null && !activity.isFinishing() && (activity2 = audioRoomDialogHelp.fragment.getActivity()) != null && !activity2.isDestroyed()) {
            function1.invoke(user);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfoByExtraId$lambda$76(Function0 function0, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showFoodieDialog$lambda$7$lambda$6$lambda$5(AudioRoomDialogHelp audioRoomDialogHelp) {
        audioRoomDialogHelp.mFoodieDialog = null;
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "show_foodie", Boolean.FALSE, (String) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void showLuckyDialog$default(AudioRoomDialogHelp audioRoomDialogHelp, LuckWheelInfo luckWheelInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            luckWheelInfo = null;
        }
        audioRoomDialogHelp.showLuckyDialog(luckWheelInfo);
    }

    public static /* synthetic */ void showToastOrLog$default(AudioRoomDialogHelp audioRoomDialogHelp, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        audioRoomDialogHelp.showToastOrLog(str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.app.Dialog, com.qiahao.nextvideo.room.dialog.UserInfoCpDialog] */
    public static final Unit showUserInfoDialog$lambda$73$lambda$71(final FragmentActivity fragmentActivity, int i, final AudioRoomDialogHelp audioRoomDialogHelp, User user) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(user, "it");
        if (fragmentActivity instanceof HiloBaseActivity) {
            HiloBaseActivity.dismissProgressDialog$default((HiloBaseActivity) fragmentActivity, false, null, 3, null);
        }
        SvipData svip = user.getSvip();
        if (svip != null && svip.isMystery()) {
            new MysteryDialog(fragmentActivity, user, i).setListener(new MysteryDialog.MysteryDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showUserInfoDialog$1$1$1
                @Override // com.qiahao.nextvideo.room.dialog.MysteryDialog.MysteryDialogListener
                public void downMic(int micPosition) {
                    RoomViewModel.downMic$default(AudioRoomDialogHelp.this.getFragment().getMViewModel(), micPosition, false, 2, null);
                }

                @Override // com.qiahao.nextvideo.room.dialog.MysteryDialog.MysteryDialogListener
                public void muteMic(int micPosition, boolean isMyself) {
                    AudioRoomDialogHelp.this.getFragment().getMViewModel().muteMic(micPosition);
                }

                @Override // com.qiahao.nextvideo.room.dialog.MysteryDialog.MysteryDialogListener
                public void unMuteMic(int micPosition) {
                    AudioRoomDialogHelp.this.getFragment().getMViewModel().unMuteMic(micPosition);
                }
            }).show();
            return Unit.INSTANCE;
        }
        UserInfoListener userInfoListener = new UserInfoListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showUserInfoDialog$1$1$listener$1
            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void callUser(String extraId, String userName) {
                GroupInputLayoutView groupInputLayoutView;
                GroupInputLayoutView groupInputLayoutView2;
                Intrinsics.checkNotNullParameter(extraId, "extraId");
                Intrinsics.checkNotNullParameter(userName, "userName");
                FragmentAudioRoomBinding binding = AudioRoomDialogHelp.this.getFragment().getBinding();
                if (binding != null && (groupInputLayoutView2 = binding.groupInput) != null) {
                    groupInputLayoutView2.updateInputText(userName, extraId, true);
                }
                FragmentAudioRoomBinding binding2 = AudioRoomDialogHelp.this.getFragment().getBinding();
                if (binding2 != null && (groupInputLayoutView = binding2.groupInput) != null) {
                    groupInputLayoutView.showSoftInput();
                }
                AudioRoomDialogHelp.this.getFragment().showSoftKeyBoard();
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void downMic(int micPosition) {
                RoomViewModel.downMic$default(AudioRoomDialogHelp.this.getFragment().getMViewModel(), micPosition, false, 2, null);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void giftShow(String extraId, String userName) {
                Intrinsics.checkNotNullParameter(extraId, "extraId");
                Intrinsics.checkNotNullParameter(userName, "userName");
                AudioRoomFragmentHelp mAudioHelp = AudioRoomDialogHelp.this.getFragment().getMAudioHelp();
                if (mAudioHelp != null) {
                    mAudioHelp.showSendGiftPanel(extraId, userName, false);
                }
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void inviteUserUpMic(String userId) {
                Intrinsics.checkNotNullParameter(userId, TUIConstants.TUILive.USER_ID);
                AudioRoomDialogHelp.this.getFragment().getMViewModel().inviteUserUpMic(userId);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void kickDownMic(int micPosition) {
                AudioRoomDialogHelp.this.getFragment().getMViewModel().downMic(micPosition, true);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void muteMic(int micPosition, boolean isMyself) {
                AudioRoomDialogHelp.this.getFragment().getMViewModel().muteMic(micPosition);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void unMuteMic(int micPosition) {
                AudioRoomDialogHelp.this.getFragment().getMViewModel().unMuteMic(micPosition);
            }

            @Override // com.qiahao.nextvideo.room.interfaces.UserInfoListener
            public void videoRequesPermiss() {
                androidx.core.app.b.g(fragmentActivity, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 102);
            }
        };
        MyCp cp = user.getCp();
        if (cp != null && cp.isDynamicCard()) {
            String mGroupId = audioRoomDialogHelp.fragment.getMViewModel().getMGroupId();
            GroupDetailBean groupDetailBean = (GroupDetailBean) audioRoomDialogHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null) {
                z2 = groupDetailBean.getMicOn();
            } else {
                z2 = true;
            }
            ?? userInfoCpDialog = new UserInfoCpDialog(fragmentActivity, user, i, mGroupId, z2);
            userInfoCpDialog.setUserInfoListener(userInfoListener);
            audioRoomDialogHelp.mUserInfoCpDialog = userInfoCpDialog;
            userInfoCpDialog.show();
            return Unit.INSTANCE;
        }
        if (!fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed()) {
            String mGroupId2 = audioRoomDialogHelp.fragment.getMViewModel().getMGroupId();
            GroupDetailBean groupDetailBean2 = (GroupDetailBean) audioRoomDialogHelp.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean2 != null) {
                z = groupDetailBean2.getMicOn();
            } else {
                z = true;
            }
            UserInfoBottomSheetDialog userInfoBottomSheetDialog = new UserInfoBottomSheetDialog(fragmentActivity, user, i, mGroupId2, z);
            userInfoBottomSheetDialog.setUserInfoListener(userInfoListener);
            audioRoomDialogHelp.mUserInfoBottomSheetDialog = userInfoBottomSheetDialog;
            userInfoBottomSheetDialog.show();
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showUserInfoDialog$lambda$73$lambda$72(FragmentActivity fragmentActivity) {
        if (fragmentActivity instanceof HiloBaseActivity) {
            HiloBaseActivity.dismissProgressDialog$default((HiloBaseActivity) fragmentActivity, false, null, 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_JOIN_CARROM) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_JOIN_JACKAROO) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_JOIN_BALOOT) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_JOIN_BACKGAMMON) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_CREATE_CRUSH) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a3, code lost:
    
        r1 = com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r6, 2131953681);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_CREATE_JACKAROO) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_CREATE_DOMINO) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_CREATE_CARROM) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_CREATE_LUDO) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_CREATE_BALOOT) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_JOIN_LUDO) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_JOIN_CRUSH) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_CREATE_BACKGAMMON) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a0, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_CREATE_UNO) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b1, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_JOIN_UNO) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r7.equals(com.qiahao.nextvideo.room.viewmodel.RoomViewModel.MIC_JOIN_DOMINO) == false) goto L٥٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00b6, code lost:
    
        r1 = com.oudi.utils.ktx.ResourcesKtxKt.getStringById(r6, 2131953682);
     */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void autoOnMic(@NotNull final String micType) {
        String str;
        Intrinsics.checkNotNullParameter(micType, "micType");
        Context context = this.fragment.getContext();
        if (context != null) {
            switch (micType.hashCode()) {
                case -2102077607:
                    break;
                case -1956674517:
                    break;
                case -1815909845:
                    break;
                case -1478445986:
                    break;
                case -740157999:
                    break;
                case -550333422:
                    break;
                case -527629505:
                    break;
                case -521522649:
                    break;
                case -480121837:
                    break;
                case 206367771:
                    break;
                case 814970032:
                    break;
                case 1322305341:
                    break;
                case 1368214052:
                    break;
                case 1389520301:
                    break;
                case 1397024825:
                    break;
                case 1438425637:
                    break;
                default:
                    str = "";
                    break;
            }
            ?? commonTextDialog = new CommonTextDialog(context, 0.0f, 2, null);
            commonTextDialog.setContentText(str, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$autoOnMic$1$1$1
                public void cancel() {
                }

                public void confirm() {
                    RoomViewModel.upMic$default(AudioRoomDialogHelp.this.getFragment().getMViewModel(), null, micType, false, 4, null);
                }
            });
            commonTextDialog.show();
        }
    }

    public final void callCreate(final int gameType) {
        CreateSudData createSudData;
        if (gameType != 1) {
            if (gameType != 2) {
                if (gameType != 10) {
                    if (gameType != 11) {
                        if (gameType != 14) {
                            if (gameType != 18) {
                                if (gameType != 21) {
                                    if (gameType != 23) {
                                        createSudData = null;
                                    } else {
                                        createSudData = this.mCreateBackgamonData;
                                    }
                                } else {
                                    createSudData = this.mCreateJackaroData;
                                }
                            } else {
                                createSudData = this.mCreateCarromData;
                            }
                        } else {
                            createSudData = this.mCreateBalootData;
                        }
                    } else {
                        createSudData = this.mCreateCrushData;
                    }
                } else {
                    createSudData = this.mCreateDominoData;
                }
            } else {
                createSudData = this.mCreateUnoData;
            }
        } else {
            createSudData = this.mCreateLudoData;
        }
        if (createSudData != null) {
            this.fragment.getMViewModel().createSudGame(createSudData, new Function0() { // from class: com.qiahao.nextvideo.room.help.k0
                public final Object invoke() {
                    Unit callCreate$lambda$24$lambda$21;
                    callCreate$lambda$24$lambda$21 = AudioRoomDialogHelp.callCreate$lambda$24$lambda$21(gameType, this);
                    return callCreate$lambda$24$lambda$21;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.help.l0
                public final Object invoke(Object obj) {
                    Unit callCreate$lambda$24$lambda$23;
                    callCreate$lambda$24$lambda$23 = AudioRoomDialogHelp.callCreate$lambda$24$lambda$23(AudioRoomDialogHelp.this, (Throwable) obj);
                    return callCreate$lambda$24$lambda$23;
                }
            });
        }
    }

    public final void checkTouristRole(int touristRole, @NotNull Function0<Unit> onSuccess) {
        Integer role;
        int i;
        Integer memberFee;
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
        if (groupDetailBean != null && (role = groupDetailBean.getRole()) != null && role.intValue() == 0 && touristRole != 1) {
            final FragmentActivity activity = this.fragment.getActivity();
            if (activity != null) {
                GroupDetailBean groupDetailBean2 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
                if (groupDetailBean2 != null && (memberFee = groupDetailBean2.getMemberFee()) != null) {
                    i = memberFee.intValue();
                } else {
                    i = 0;
                }
                RoomPowerJoinDialog roomPowerJoinDialog = new RoomPowerJoinDialog(activity, i);
                roomPowerJoinDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.u
                    public final Object invoke(Object obj) {
                        Unit checkTouristRole$lambda$66$lambda$65$lambda$64;
                        checkTouristRole$lambda$66$lambda$65$lambda$64 = AudioRoomDialogHelp.checkTouristRole$lambda$66$lambda$65$lambda$64(AudioRoomDialogHelp.this, activity, ((Integer) obj).intValue());
                        return checkTouristRole$lambda$66$lambda$65$lambda$64;
                    }
                });
                roomPowerJoinDialog.show();
                return;
            }
            return;
        }
        onSuccess.invoke();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.qiahao.nextvideo.room.game.CreateBackgammonDialog, android.app.Dialog] */
    public final void createBackgammonDialog() {
        GameConfigLudo gameConfigLudo;
        GameConfig gameConfig;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null) {
                gameConfigLudo = gameConfig.getBackgammon();
            } else {
                gameConfigLudo = null;
            }
            ?? createBackgammonDialog = new CreateBackgammonDialog(activity, null, null, gameConfigLudo, 6, null);
            createBackgammonDialog.setCreateListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.i0
                public final Object invoke(Object obj) {
                    Unit createBackgammonDialog$lambda$48$lambda$46$lambda$45;
                    createBackgammonDialog$lambda$48$lambda$46$lambda$45 = AudioRoomDialogHelp.createBackgammonDialog$lambda$48$lambda$46$lambda$45(AudioRoomDialogHelp.this, (CreateSudData) obj);
                    return createBackgammonDialog$lambda$48$lambda$46$lambda$45;
                }
            });
            this.mCreateBackgammonDialog = createBackgammonDialog;
            createBackgammonDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.j0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.createBackgammonDialog$lambda$48$lambda$47(AudioRoomDialogHelp.this, dialogInterface);
                }
            });
            CreateBackgammonDialog createBackgammonDialog2 = this.mCreateBackgammonDialog;
            if (createBackgammonDialog2 != null) {
                createBackgammonDialog2.show();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.qiahao.nextvideo.room.game.CreateBalootDialog] */
    public final void createBalootDialog() {
        ArrayList<Integer> arrayList;
        GameConfig gameConfig;
        GameConfigLudo baloot;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null && (baloot = gameConfig.getBaloot()) != null) {
                arrayList = baloot.getDiamond();
            } else {
                arrayList = null;
            }
            ?? createBalootDialog = new CreateBalootDialog(activity, null, null, arrayList, 6, null);
            createBalootDialog.setCreateListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.e0
                public final Object invoke(Object obj) {
                    Unit createBalootDialog$lambda$36$lambda$34$lambda$33;
                    createBalootDialog$lambda$36$lambda$34$lambda$33 = AudioRoomDialogHelp.createBalootDialog$lambda$36$lambda$34$lambda$33(AudioRoomDialogHelp.this, (CreateSudData) obj);
                    return createBalootDialog$lambda$36$lambda$34$lambda$33;
                }
            });
            this.mCreateBalootDialog = createBalootDialog;
            createBalootDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.f0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.createBalootDialog$lambda$36$lambda$35(AudioRoomDialogHelp.this, dialogInterface);
                }
            });
            CreateBalootDialog createBalootDialog2 = this.mCreateBalootDialog;
            if (createBalootDialog2 != null) {
                createBalootDialog2.show();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.qiahao.nextvideo.room.game.CreateCarromDialog] */
    public final void createCarromDialog() {
        GameConfigLudo gameConfigLudo;
        GameConfig gameConfig;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null) {
                gameConfigLudo = gameConfig.getCarrom();
            } else {
                gameConfigLudo = null;
            }
            ?? createCarromDialog = new CreateCarromDialog(activity, null, null, gameConfigLudo, 6, null);
            createCarromDialog.setCreateListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.m0
                public final Object invoke(Object obj) {
                    Unit createCarromDialog$lambda$40$lambda$38$lambda$37;
                    createCarromDialog$lambda$40$lambda$38$lambda$37 = AudioRoomDialogHelp.createCarromDialog$lambda$40$lambda$38$lambda$37(AudioRoomDialogHelp.this, (CreateSudData) obj);
                    return createCarromDialog$lambda$40$lambda$38$lambda$37;
                }
            });
            this.mCreateCarromDialog = createCarromDialog;
            createCarromDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.n0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.createCarromDialog$lambda$40$lambda$39(AudioRoomDialogHelp.this, dialogInterface);
                }
            });
            CreateCarromDialog createCarromDialog2 = this.mCreateCarromDialog;
            if (createCarromDialog2 != null) {
                createCarromDialog2.show();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.qiahao.nextvideo.room.game.CreateJackaroDialog, android.app.Dialog] */
    public final void createJackaroDialog() {
        GameConfigLudo gameConfigLudo;
        GameConfig gameConfig;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null) {
                gameConfigLudo = gameConfig.getJackaroo();
            } else {
                gameConfigLudo = null;
            }
            ?? createJackaroDialog = new CreateJackaroDialog(activity, null, null, gameConfigLudo, 6, null);
            createJackaroDialog.setCreateListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.y
                public final Object invoke(Object obj) {
                    Unit createJackaroDialog$lambda$44$lambda$42$lambda$41;
                    createJackaroDialog$lambda$44$lambda$42$lambda$41 = AudioRoomDialogHelp.createJackaroDialog$lambda$44$lambda$42$lambda$41(AudioRoomDialogHelp.this, (CreateSudData) obj);
                    return createJackaroDialog$lambda$44$lambda$42$lambda$41;
                }
            });
            this.mCreateJackaroDialog = createJackaroDialog;
            createJackaroDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.z
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.createJackaroDialog$lambda$44$lambda$43(AudioRoomDialogHelp.this, dialogInterface);
                }
            });
            CreateJackaroDialog createJackaroDialog2 = this.mCreateJackaroDialog;
            if (createJackaroDialog2 != null) {
                createJackaroDialog2.show();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.qiahao.nextvideo.room.game.CreateLudoDialog, android.app.Dialog] */
    public final void createLudoDialog() {
        GameConfigLudo gameConfigLudo;
        GameConfig gameConfig;
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (gameConfig = groupDetailBean.getGameConfig()) != null) {
                gameConfigLudo = gameConfig.getLudo();
            } else {
                gameConfigLudo = null;
            }
            ?? createLudoDialog = new CreateLudoDialog(activity, null, null, gameConfigLudo, 6, null);
            createLudoDialog.setCreateListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.s
                public final Object invoke(Object obj) {
                    Unit createLudoDialog$lambda$20$lambda$18$lambda$17;
                    createLudoDialog$lambda$20$lambda$18$lambda$17 = AudioRoomDialogHelp.createLudoDialog$lambda$20$lambda$18$lambda$17(AudioRoomDialogHelp.this, (CreateSudData) obj);
                    return createLudoDialog$lambda$20$lambda$18$lambda$17;
                }
            });
            this.mCreateLudoDialog = createLudoDialog;
            createLudoDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.t
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.createLudoDialog$lambda$20$lambda$19(AudioRoomDialogHelp.this, dialogInterface);
                }
            });
            CreateLudoDialog createLudoDialog2 = this.mCreateLudoDialog;
            if (createLudoDialog2 != null) {
                createLudoDialog2.show();
            }
        }
    }

    public final void createPKDialog() {
        new RoomPKCreateDialog().show(this.fragment.getChildFragmentManager(), "RoomPKCreateDialog");
    }

    public final void createPk1v1() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            Create1v1PKDialog create1v1PKDialog = new Create1v1PKDialog();
            create1v1PKDialog.setMListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.v
                public final Object invoke() {
                    Unit createPk1v1$lambda$51$lambda$50$lambda$49;
                    createPk1v1$lambda$51$lambda$50$lambda$49 = AudioRoomDialogHelp.createPk1v1$lambda$51$lambda$50$lambda$49(AudioRoomDialogHelp.this);
                    return createPk1v1$lambda$51$lambda$50$lambda$49;
                }
            });
            this.mPk1v1 = create1v1PKDialog;
            create1v1PKDialog.show(activity.getSupportFragmentManager(), "Create1v1PKDialog");
        }
    }

    @Nullable
    public final CommonTextDialog getCommonTextDialog() {
        return this.commonTextDialog;
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public final CreateBackgammonDialog getMCreateBackgammonDialog() {
        return this.mCreateBackgammonDialog;
    }

    @Nullable
    public final CreateSudData getMCreateBackgamonData() {
        return this.mCreateBackgamonData;
    }

    @Nullable
    public final CreateSudData getMCreateBalootData() {
        return this.mCreateBalootData;
    }

    @Nullable
    public final CreateBalootDialog getMCreateBalootDialog() {
        return this.mCreateBalootDialog;
    }

    @Nullable
    public final CreateSudData getMCreateCarromData() {
        return this.mCreateCarromData;
    }

    @Nullable
    public final CreateCarromDialog getMCreateCarromDialog() {
        return this.mCreateCarromDialog;
    }

    @Nullable
    public final CreateSudData getMCreateCrushData() {
        return this.mCreateCrushData;
    }

    @Nullable
    public final CreateCrushDialog getMCreateCrushDialog() {
        return this.mCreateCrushDialog;
    }

    @Nullable
    public final CreateSudData getMCreateDominoData() {
        return this.mCreateDominoData;
    }

    @Nullable
    public final CreateDominoDialog getMCreateDominoDialog() {
        return this.mCreateDominoDialog;
    }

    @Nullable
    public final CreateSudData getMCreateJackaroData() {
        return this.mCreateJackaroData;
    }

    @Nullable
    public final CreateJackaroDialog getMCreateJackaroDialog() {
        return this.mCreateJackaroDialog;
    }

    @Nullable
    public final CreateSudData getMCreateLudoData() {
        return this.mCreateLudoData;
    }

    @Nullable
    public final CreateLudoDialog getMCreateLudoDialog() {
        return this.mCreateLudoDialog;
    }

    @Nullable
    public final CreateSudData getMCreateUnoData() {
        return this.mCreateUnoData;
    }

    @Nullable
    public final CreateUnoDialog getMCreateUnoDialog() {
        return this.mCreateUnoDialog;
    }

    @Nullable
    public final FoodieGameDialog getMFoodieDialog() {
        return this.mFoodieDialog;
    }

    @Nullable
    public final GroupMusicDialog getMGroupMusicDialog() {
        return this.mGroupMusicDialog;
    }

    @Nullable
    public final LeaveRoomDialog getMLeaveRoomDialog() {
        return this.mLeaveRoomDialog;
    }

    @Nullable
    public final LuckyFruitDialog getMLuckyFruitDialog() {
        return this.mLuckyFruitDialog;
    }

    @Nullable
    public final LuckyWheelDialog getMLuckyWheelDialog() {
        return this.mLuckyWheelDialog;
    }

    @Nullable
    public final Create1v1PKDialog getMPk1v1() {
        return this.mPk1v1;
    }

    @Nullable
    public final RoomRocketDialog getMRocketDialog() {
        return this.mRocketDialog;
    }

    @Nullable
    public final RoomGameDialog getMRoomGameDialog() {
        return this.mRoomGameDialog;
    }

    @Nullable
    public final RoomToolDialog getMRoomToolDialog() {
        return this.mRoomToolDialog;
    }

    public final boolean getMSmallLuckWheelDialog() {
        return this.mSmallLuckWheelDialog;
    }

    @Nullable
    public final UserInfoBottomSheetDialog getMUserInfoBottomSheetDialog() {
        return this.mUserInfoBottomSheetDialog;
    }

    @Nullable
    public final UserInfoCpDialog getMUserInfoCpDialog() {
        return this.mUserInfoCpDialog;
    }

    @Nullable
    public final RoomTipDialog getRoomTipDialog() {
        return this.roomTipDialog;
    }

    public final void inviteUserDialog() {
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            new InviteFriendsBottomSheetDialog(activity, new InviteFriendsListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$inviteUserDialog$1$1
                @Override // com.qiahao.nextvideo.room.dialog.InviteFriendsListener
                public void shareContacts() {
                    GroupDetailBean groupDetailBean = (GroupDetailBean) AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean == null) {
                        return;
                    }
                    ShareContactsActivity.Companion companion = ShareContactsActivity.INSTANCE;
                    FragmentActivity fragmentActivity = activity;
                    String faceUrl = groupDetailBean.getFaceUrl();
                    if (faceUrl == null) {
                        faceUrl = "";
                    }
                    companion.start(fragmentActivity, faceUrl, AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupId());
                }

                @Override // com.qiahao.nextvideo.room.dialog.InviteFriendsListener
                public void shareCopyLink() {
                    GroupDetailBean groupDetailBean = (GroupDetailBean) AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean == null) {
                        return;
                    }
                    r.c cVar = new r.c();
                    String format = String.format(ResourcesKtxKt.getStringById(this, 2131953140), Arrays.copyOf(new Object[]{groupDetailBean.getName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    cVar.i(format).m(ResourcesKtxKt.getStringById(this, 2131952013)).l("https://www.hiloconn.com?groupId=" + AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupId()).j("https://www.hiloconn.com?groupId=" + AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupId()).h(activity).h(com.qiahao.nextvideo.share.q.COPYURL);
                }

                @Override // com.qiahao.nextvideo.room.dialog.InviteFriendsListener
                public void shareWhatApps() {
                    GroupDetailBean groupDetailBean = (GroupDetailBean) AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(String.format(ResourcesKtxKt.getStringById(this, 2131953140), Arrays.copyOf(new Object[]{groupDetailBean.getName()}, 1)), "format(...)");
                    r.c cVar = new r.c();
                    String format = String.format(ResourcesKtxKt.getStringById(this, 2131953140), Arrays.copyOf(new Object[]{groupDetailBean.getName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    cVar.i(format).m(ResourcesKtxKt.getStringById(this, 2131952013)).k(groupDetailBean.getFaceUrl()).l("https://www.hiloconn.com?groupId=" + AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupId()).j("https://www.hiloconn.com?groupId=" + AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupId()).h(activity).h(com.qiahao.nextvideo.share.q.WHATSAPP);
                    AudioRoomDialogHelp.showToastOrLog$default(AudioRoomDialogHelp.this, null, "shareWhatApps: ", false, 5, null);
                }
            }).show();
        }
    }

    public final void release() {
        FoodieGameDialog foodieGameDialog;
        UserInfoBottomSheetDialog userInfoBottomSheetDialog = this.mUserInfoBottomSheetDialog;
        if (userInfoBottomSheetDialog != null) {
            userInfoBottomSheetDialog.dismiss();
        }
        this.mUserInfoBottomSheetDialog = null;
        UserInfoCpDialog userInfoCpDialog = this.mUserInfoCpDialog;
        if (userInfoCpDialog != null) {
            userInfoCpDialog.dismiss();
        }
        this.mUserInfoCpDialog = null;
        LuckyWheelDialog luckyWheelDialog = this.mLuckyWheelDialog;
        if (luckyWheelDialog != null) {
            luckyWheelDialog.dismiss();
        }
        this.mLuckyWheelDialog = null;
        RoomRocketDialog roomRocketDialog = this.mRocketDialog;
        if (roomRocketDialog != null) {
            roomRocketDialog.dismiss();
        }
        this.mRocketDialog = null;
        GroupMusicDialog groupMusicDialog = this.mGroupMusicDialog;
        if (groupMusicDialog != null) {
            groupMusicDialog.dismiss();
        }
        this.mGroupMusicDialog = null;
        RoomGameDialog roomGameDialog = this.mRoomGameDialog;
        if (roomGameDialog != null) {
            roomGameDialog.dismiss();
        }
        this.mRoomGameDialog = null;
        LuckyFruitDialog luckyFruitDialog = this.mLuckyFruitDialog;
        if (luckyFruitDialog != null) {
            luckyFruitDialog.dismiss();
        }
        this.mLuckyFruitDialog = null;
        CommonTextDialog commonTextDialog = this.commonTextDialog;
        if (commonTextDialog != null) {
            commonTextDialog.dismiss();
        }
        this.commonTextDialog = null;
        LeaveRoomDialog leaveRoomDialog = this.mLeaveRoomDialog;
        if (leaveRoomDialog != null) {
            leaveRoomDialog.dismiss();
        }
        this.mLeaveRoomDialog = null;
        try {
            if (this.fragment.isAdded() && (foodieGameDialog = this.mFoodieDialog) != null && foodieGameDialog.isAdded()) {
                FoodieGameDialog foodieGameDialog2 = this.mFoodieDialog;
                if (foodieGameDialog2 != null) {
                    foodieGameDialog2.dismiss();
                }
                this.mFoodieDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mLuckyFruitDialog = null;
    }

    public final void setCommonTextDialog(@Nullable CommonTextDialog commonTextDialog) {
        this.commonTextDialog = commonTextDialog;
    }

    public final void setMCreateBackgammonDialog(@Nullable CreateBackgammonDialog createBackgammonDialog) {
        this.mCreateBackgammonDialog = createBackgammonDialog;
    }

    public final void setMCreateBackgamonData(@Nullable CreateSudData createSudData) {
        this.mCreateBackgamonData = createSudData;
    }

    public final void setMCreateBalootData(@Nullable CreateSudData createSudData) {
        this.mCreateBalootData = createSudData;
    }

    public final void setMCreateBalootDialog(@Nullable CreateBalootDialog createBalootDialog) {
        this.mCreateBalootDialog = createBalootDialog;
    }

    public final void setMCreateCarromData(@Nullable CreateSudData createSudData) {
        this.mCreateCarromData = createSudData;
    }

    public final void setMCreateCarromDialog(@Nullable CreateCarromDialog createCarromDialog) {
        this.mCreateCarromDialog = createCarromDialog;
    }

    public final void setMCreateCrushData(@Nullable CreateSudData createSudData) {
        this.mCreateCrushData = createSudData;
    }

    public final void setMCreateCrushDialog(@Nullable CreateCrushDialog createCrushDialog) {
        this.mCreateCrushDialog = createCrushDialog;
    }

    public final void setMCreateDominoData(@Nullable CreateSudData createSudData) {
        this.mCreateDominoData = createSudData;
    }

    public final void setMCreateDominoDialog(@Nullable CreateDominoDialog createDominoDialog) {
        this.mCreateDominoDialog = createDominoDialog;
    }

    public final void setMCreateJackaroData(@Nullable CreateSudData createSudData) {
        this.mCreateJackaroData = createSudData;
    }

    public final void setMCreateJackaroDialog(@Nullable CreateJackaroDialog createJackaroDialog) {
        this.mCreateJackaroDialog = createJackaroDialog;
    }

    public final void setMCreateLudoData(@Nullable CreateSudData createSudData) {
        this.mCreateLudoData = createSudData;
    }

    public final void setMCreateLudoDialog(@Nullable CreateLudoDialog createLudoDialog) {
        this.mCreateLudoDialog = createLudoDialog;
    }

    public final void setMCreateUnoData(@Nullable CreateSudData createSudData) {
        this.mCreateUnoData = createSudData;
    }

    public final void setMCreateUnoDialog(@Nullable CreateUnoDialog createUnoDialog) {
        this.mCreateUnoDialog = createUnoDialog;
    }

    public final void setMFoodieDialog(@Nullable FoodieGameDialog foodieGameDialog) {
        this.mFoodieDialog = foodieGameDialog;
    }

    public final void setMGroupMusicDialog(@Nullable GroupMusicDialog groupMusicDialog) {
        this.mGroupMusicDialog = groupMusicDialog;
    }

    public final void setMLeaveRoomDialog(@Nullable LeaveRoomDialog leaveRoomDialog) {
        this.mLeaveRoomDialog = leaveRoomDialog;
    }

    public final void setMLuckyFruitDialog(@Nullable LuckyFruitDialog luckyFruitDialog) {
        this.mLuckyFruitDialog = luckyFruitDialog;
    }

    public final void setMLuckyWheelDialog(@Nullable LuckyWheelDialog luckyWheelDialog) {
        this.mLuckyWheelDialog = luckyWheelDialog;
    }

    public final void setMPk1v1(@Nullable Create1v1PKDialog create1v1PKDialog) {
        this.mPk1v1 = create1v1PKDialog;
    }

    public final void setMRocketDialog(@Nullable RoomRocketDialog roomRocketDialog) {
        this.mRocketDialog = roomRocketDialog;
    }

    public final void setMRoomGameDialog(@Nullable RoomGameDialog roomGameDialog) {
        this.mRoomGameDialog = roomGameDialog;
    }

    public final void setMRoomToolDialog(@Nullable RoomToolDialog roomToolDialog) {
        this.mRoomToolDialog = roomToolDialog;
    }

    public final void setMSmallLuckWheelDialog(boolean z) {
        this.mSmallLuckWheelDialog = z;
    }

    public final void setMUserInfoBottomSheetDialog(@Nullable UserInfoBottomSheetDialog userInfoBottomSheetDialog) {
        this.mUserInfoBottomSheetDialog = userInfoBottomSheetDialog;
    }

    public final void setMUserInfoCpDialog(@Nullable UserInfoCpDialog userInfoCpDialog) {
        this.mUserInfoCpDialog = userInfoCpDialog;
    }

    public final void setRoomTipDialog(@Nullable RoomTipDialog roomTipDialog) {
        this.roomTipDialog = roomTipDialog;
    }

    public final void showFoodieDialog() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "show_foodie", Boolean.TRUE, (String) null, 4, (Object) null);
            FoodieGameDialog foodieGameDialog = new FoodieGameDialog();
            foodieGameDialog.setMListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.a0
                public final Object invoke() {
                    Unit showFoodieDialog$lambda$7$lambda$6$lambda$5;
                    showFoodieDialog$lambda$7$lambda$6$lambda$5 = AudioRoomDialogHelp.showFoodieDialog$lambda$7$lambda$6$lambda$5(AudioRoomDialogHelp.this);
                    return showFoodieDialog$lambda$7$lambda$6$lambda$5;
                }
            });
            this.mFoodieDialog = foodieGameDialog;
            foodieGameDialog.show(activity.getSupportFragmentManager(), "FoodieGameDialog");
        }
    }

    public final void showGame(@NotNull Context context, @NotNull GameConfiguration gameConfiguration) {
        boolean z;
        EnvelopeHelper mEnvelopeHelper;
        int i;
        int i2;
        int i3;
        boolean z2;
        Integer role;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        Pk1v1Help mPk1v1Help;
        Integer type;
        Integer role2;
        int i5;
        boolean z6;
        boolean z7;
        Integer type2;
        Integer role3;
        int i6;
        boolean z8;
        boolean z9;
        AudioRoomFragmentHelp mAudioHelp;
        boolean z10;
        Integer type3;
        HiloGameHelp mHiloGameHelp;
        Integer role4;
        int i7;
        boolean z11;
        boolean z12;
        AudioRoomFragmentHelp mAudioHelp2;
        boolean z13;
        Integer type4;
        Integer role5;
        int i8;
        boolean z14;
        boolean z15;
        AudioRoomFragmentHelp mAudioHelp3;
        boolean z16;
        Integer type5;
        Integer role6;
        int i9;
        boolean z17;
        boolean z18;
        AudioRoomFragmentHelp mAudioHelp4;
        boolean z19;
        Integer type6;
        Integer role7;
        int i10;
        boolean z20;
        boolean z21;
        AudioRoomFragmentHelp mAudioHelp5;
        boolean z22;
        Integer type7;
        Integer role8;
        int i11;
        boolean z23;
        boolean z24;
        AudioRoomFragmentHelp mAudioHelp6;
        boolean z25;
        Integer type8;
        Integer role9;
        int i12;
        boolean z26;
        boolean z27;
        AudioRoomFragmentHelp mAudioHelp7;
        boolean z28;
        Integer type9;
        Integer role10;
        int i13;
        boolean z29;
        boolean z30;
        AudioRoomFragmentHelp mAudioHelp8;
        boolean z31;
        Integer type10;
        Integer role11;
        int i14;
        boolean z32;
        boolean z33;
        AudioRoomFragmentHelp mAudioHelp9;
        boolean z34;
        Integer type11;
        Integer role12;
        boolean z35 = true;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameConfiguration, "gameConfiguration");
        Boolean inGameCenter = gameConfiguration.getInGameCenter();
        Boolean bool = Boolean.TRUE;
        String str = "";
        AudioHiloGameBinding audioHiloGameBinding = null;
        int i15 = 0;
        if (Intrinsics.areEqual(inGameCenter, bool)) {
            if (Intrinsics.areEqual(gameConfiguration.isFull(), bool)) {
                NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                String url = gameConfiguration.getUrl();
                if (url != null) {
                    str = url;
                }
                NavigationHelper.jump$default(navigationHelper, str, (SuperCallBack) null, 2, (Object) null);
                return;
            }
            Integer gameId = gameConfiguration.getGameId();
            if (gameId != null) {
                i15 = gameId.intValue();
            }
            new H5DiamondGameDialog(context, i15).show();
            Unit unit = Unit.INSTANCE;
            return;
        }
        Integer gameType = gameConfiguration.getGameType();
        if (gameType != null && gameType.intValue() == 0) {
            if (!TextUtils.isEmpty(gameConfiguration.getUrl())) {
                NavigationHelper navigationHelper2 = NavigationHelper.INSTANCE;
                String url2 = gameConfiguration.getUrl();
                if (url2 == null) {
                    url2 = "";
                }
                gameConfiguration.setUrl(navigationHelper2.addParams(url2, new Pair[]{new Pair("current_room_id", this.fragment.getMViewModel().getMGroupId())}));
            }
            if (Intrinsics.areEqual(gameConfiguration.isFull(), bool)) {
                NavigationHelper navigationHelper3 = NavigationHelper.INSTANCE;
                String url3 = gameConfiguration.getUrl();
                if (url3 != null) {
                    str = url3;
                }
                NavigationHelper.jump$default(navigationHelper3, str, (SuperCallBack) null, 2, (Object) null);
                return;
            }
            new H5GameDialog(context, gameConfiguration).show();
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        if (gameType != null && gameType.intValue() == 1) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (role12 = groupDetailBean.getRole()) != null) {
                i14 = role12.intValue();
            } else {
                i14 = 0;
            }
            if (i14 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.getMUnoGameData() == null && meetingRoomManager.getMDominoGameData() == null && meetingRoomManager.getMCrushGameData() == null && meetingRoomManager.getMBalootGameData() == null && meetingRoomManager.getMCarromGameData() == null) {
                Pk1v1Data mPK1v1 = meetingRoomManager.getMPK1v1();
                if (mPK1v1 != null && mPK1v1.checkIsPk()) {
                    z32 = true;
                } else {
                    z32 = false;
                }
                if (!z32 && meetingRoomManager.getMJackaroGameData() == null && meetingRoomManager.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager.checkPKMadel()) {
                        RoomPK mpk = meetingRoomManager.getMPK();
                        if (mpk != null && mpk.checkIsInvite()) {
                            z33 = true;
                        } else {
                            z33 = false;
                        }
                        if (!z33 && !meetingRoomManager.checkOpenHiloGame()) {
                            if (meetingRoomManager.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe = meetingRoomManager.getMYouTuBe();
                                if (mYouTuBe != null && (type11 = mYouTuBe.getType()) != null && type11.intValue() == 4) {
                                    z34 = true;
                                } else {
                                    z34 = false;
                                }
                                if (!z34) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            if (meetingRoomManager.getMLudoGameData() == null) {
                                createLudoDialog();
                                return;
                            }
                            AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
                            if (mGameHelp == null || mGameHelp.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35 && (mAudioHelp9 = this.fragment.getMAudioHelp()) != null) {
                                mAudioHelp9.showLudoGameView();
                                Unit unit3 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 2) {
            GroupDetailBean groupDetailBean2 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean2 != null && (role11 = groupDetailBean2.getRole()) != null) {
                i13 = role11.intValue();
            } else {
                i13 = 0;
            }
            if (i13 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager2.getMLudoGameData() == null && meetingRoomManager2.getMDominoGameData() == null && meetingRoomManager2.getMCrushGameData() == null && meetingRoomManager2.getMBalootGameData() == null && meetingRoomManager2.getMCarromGameData() == null) {
                Pk1v1Data mPK1v12 = meetingRoomManager2.getMPK1v1();
                if (mPK1v12 != null && mPK1v12.checkIsPk()) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                if (!z29 && meetingRoomManager2.getMJackaroGameData() == null && meetingRoomManager2.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager2.checkPKMadel()) {
                        RoomPK mpk2 = meetingRoomManager2.getMPK();
                        if (mpk2 != null && mpk2.checkIsInvite()) {
                            z30 = true;
                        } else {
                            z30 = false;
                        }
                        if (!z30 && !meetingRoomManager2.checkOpenHiloGame()) {
                            if (meetingRoomManager2.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe2 = meetingRoomManager2.getMYouTuBe();
                                if (mYouTuBe2 != null && (type10 = mYouTuBe2.getType()) != null && type10.intValue() == 4) {
                                    z31 = true;
                                } else {
                                    z31 = false;
                                }
                                if (!z31) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            if (meetingRoomManager2.getMUnoGameData() == null) {
                                createUnoDialog();
                                return;
                            }
                            AudioGameHelp mGameHelp2 = this.fragment.getMGameHelp();
                            if (mGameHelp2 == null || mGameHelp2.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35 && (mAudioHelp8 = this.fragment.getMAudioHelp()) != null) {
                                mAudioHelp8.showUnoGameView();
                                Unit unit4 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 10) {
            GroupDetailBean groupDetailBean3 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean3 != null && (role10 = groupDetailBean3.getRole()) != null) {
                i12 = role10.intValue();
            } else {
                i12 = 0;
            }
            if (i12 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager3 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager3.getMLudoGameData() == null && meetingRoomManager3.getMUnoGameData() == null && meetingRoomManager3.getMCrushGameData() == null && meetingRoomManager3.getMBalootGameData() == null && meetingRoomManager3.getMCarromGameData() == null) {
                Pk1v1Data mPK1v13 = meetingRoomManager3.getMPK1v1();
                if (mPK1v13 != null && mPK1v13.checkIsPk()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (!z26 && meetingRoomManager3.getMJackaroGameData() == null && meetingRoomManager3.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager3.checkPKMadel()) {
                        RoomPK mpk3 = meetingRoomManager3.getMPK();
                        if (mpk3 != null && mpk3.checkIsInvite()) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        if (!z27 && !meetingRoomManager3.checkOpenHiloGame()) {
                            if (meetingRoomManager3.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe3 = meetingRoomManager3.getMYouTuBe();
                                if (mYouTuBe3 != null && (type9 = mYouTuBe3.getType()) != null && type9.intValue() == 4) {
                                    z28 = true;
                                } else {
                                    z28 = false;
                                }
                                if (!z28) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            if (meetingRoomManager3.getMDominoGameData() == null) {
                                createDominoDialog();
                                return;
                            }
                            AudioGameHelp mGameHelp3 = this.fragment.getMGameHelp();
                            if (mGameHelp3 == null || mGameHelp3.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35 && (mAudioHelp7 = this.fragment.getMAudioHelp()) != null) {
                                mAudioHelp7.showDominoGameView();
                                Unit unit5 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 11) {
            GroupDetailBean groupDetailBean4 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean4 != null && (role9 = groupDetailBean4.getRole()) != null) {
                i11 = role9.intValue();
            } else {
                i11 = 0;
            }
            if (i11 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager4 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager4.getMLudoGameData() == null && meetingRoomManager4.getMUnoGameData() == null && meetingRoomManager4.getMDominoGameData() == null && meetingRoomManager4.getMBalootGameData() == null && meetingRoomManager4.getMCarromGameData() == null) {
                Pk1v1Data mPK1v14 = meetingRoomManager4.getMPK1v1();
                if (mPK1v14 != null && mPK1v14.checkIsPk()) {
                    z23 = true;
                } else {
                    z23 = false;
                }
                if (!z23 && meetingRoomManager4.getMJackaroGameData() == null && meetingRoomManager4.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager4.checkPKMadel()) {
                        RoomPK mpk4 = meetingRoomManager4.getMPK();
                        if (mpk4 != null && mpk4.checkIsInvite()) {
                            z24 = true;
                        } else {
                            z24 = false;
                        }
                        if (!z24 && !meetingRoomManager4.checkOpenHiloGame()) {
                            if (meetingRoomManager4.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe4 = meetingRoomManager4.getMYouTuBe();
                                if (mYouTuBe4 != null && (type8 = mYouTuBe4.getType()) != null && type8.intValue() == 4) {
                                    z25 = true;
                                } else {
                                    z25 = false;
                                }
                                if (!z25) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            if (meetingRoomManager4.getMCrushGameData() == null) {
                                createCrushDialog();
                                return;
                            }
                            AudioGameHelp mGameHelp4 = this.fragment.getMGameHelp();
                            if (mGameHelp4 == null || mGameHelp4.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35 && (mAudioHelp6 = this.fragment.getMAudioHelp()) != null) {
                                mAudioHelp6.showCrushGameView();
                                Unit unit6 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 14) {
            GroupDetailBean groupDetailBean5 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean5 != null && (role8 = groupDetailBean5.getRole()) != null) {
                i10 = role8.intValue();
            } else {
                i10 = 0;
            }
            if (i10 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager5 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager5.getMLudoGameData() == null && meetingRoomManager5.getMUnoGameData() == null && meetingRoomManager5.getMDominoGameData() == null && meetingRoomManager5.getMCrushGameData() == null && meetingRoomManager5.getMCarromGameData() == null) {
                Pk1v1Data mPK1v15 = meetingRoomManager5.getMPK1v1();
                if (mPK1v15 != null && mPK1v15.checkIsPk()) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                if (!z20 && meetingRoomManager5.getMJackaroGameData() == null && meetingRoomManager5.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager5.checkPKMadel()) {
                        RoomPK mpk5 = meetingRoomManager5.getMPK();
                        if (mpk5 != null && mpk5.checkIsInvite()) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        if (!z21 && !meetingRoomManager5.checkOpenHiloGame()) {
                            if (meetingRoomManager5.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe5 = meetingRoomManager5.getMYouTuBe();
                                if (mYouTuBe5 != null && (type7 = mYouTuBe5.getType()) != null && type7.intValue() == 4) {
                                    z22 = true;
                                } else {
                                    z22 = false;
                                }
                                if (!z22) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            if (meetingRoomManager5.getMBalootGameData() == null) {
                                createBalootDialog();
                                return;
                            }
                            AudioGameHelp mGameHelp5 = this.fragment.getMGameHelp();
                            if (mGameHelp5 == null || mGameHelp5.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35 && (mAudioHelp5 = this.fragment.getMAudioHelp()) != null) {
                                mAudioHelp5.showBalootGameView();
                                Unit unit7 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 18) {
            GroupDetailBean groupDetailBean6 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean6 != null && (role7 = groupDetailBean6.getRole()) != null) {
                i9 = role7.intValue();
            } else {
                i9 = 0;
            }
            if (i9 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager6 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager6.getMLudoGameData() == null && meetingRoomManager6.getMUnoGameData() == null && meetingRoomManager6.getMDominoGameData() == null && meetingRoomManager6.getMCrushGameData() == null && meetingRoomManager6.getMBalootGameData() == null) {
                Pk1v1Data mPK1v16 = meetingRoomManager6.getMPK1v1();
                if (mPK1v16 != null && mPK1v16.checkIsPk()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && meetingRoomManager6.getMJackaroGameData() == null && meetingRoomManager6.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager6.checkPKMadel()) {
                        RoomPK mpk6 = meetingRoomManager6.getMPK();
                        if (mpk6 != null && mpk6.checkIsInvite()) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18 && !meetingRoomManager6.checkOpenHiloGame()) {
                            if (meetingRoomManager6.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe6 = meetingRoomManager6.getMYouTuBe();
                                if (mYouTuBe6 != null && (type6 = mYouTuBe6.getType()) != null && type6.intValue() == 4) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                if (!z19) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            if (meetingRoomManager6.getMCarromGameData() == null) {
                                createCarromDialog();
                                return;
                            }
                            AudioGameHelp mGameHelp6 = this.fragment.getMGameHelp();
                            if (mGameHelp6 == null || mGameHelp6.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35 && (mAudioHelp4 = this.fragment.getMAudioHelp()) != null) {
                                mAudioHelp4.showCarromGameView();
                                Unit unit8 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 21) {
            GroupDetailBean groupDetailBean7 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean7 != null && (role6 = groupDetailBean7.getRole()) != null) {
                i8 = role6.intValue();
            } else {
                i8 = 0;
            }
            if (i8 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager7 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager7.getMLudoGameData() == null && meetingRoomManager7.getMUnoGameData() == null && meetingRoomManager7.getMDominoGameData() == null && meetingRoomManager7.getMCrushGameData() == null && meetingRoomManager7.getMBalootGameData() == null) {
                Pk1v1Data mPK1v17 = meetingRoomManager7.getMPK1v1();
                if (mPK1v17 != null && mPK1v17.checkIsPk()) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (!z14 && meetingRoomManager7.getMCarromGameData() == null && meetingRoomManager7.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager7.checkPKMadel()) {
                        RoomPK mpk7 = meetingRoomManager7.getMPK();
                        if (mpk7 != null && mpk7.checkIsInvite()) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if (!z15 && !meetingRoomManager7.checkOpenHiloGame()) {
                            if (meetingRoomManager7.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe7 = meetingRoomManager7.getMYouTuBe();
                                if (mYouTuBe7 != null && (type5 = mYouTuBe7.getType()) != null && type5.intValue() == 4) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                if (!z16) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            if (meetingRoomManager7.getMJackaroGameData() == null) {
                                createJackaroDialog();
                                return;
                            }
                            AudioGameHelp mGameHelp7 = this.fragment.getMGameHelp();
                            if (mGameHelp7 == null || mGameHelp7.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35 && (mAudioHelp3 = this.fragment.getMAudioHelp()) != null) {
                                mAudioHelp3.showJackaroGameView();
                                Unit unit9 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 23) {
            GroupDetailBean groupDetailBean8 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean8 != null && (role5 = groupDetailBean8.getRole()) != null) {
                i7 = role5.intValue();
            } else {
                i7 = 0;
            }
            if (i7 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager8 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager8.getMLudoGameData() == null && meetingRoomManager8.getMUnoGameData() == null && meetingRoomManager8.getMDominoGameData() == null && meetingRoomManager8.getMCrushGameData() == null && meetingRoomManager8.getMBalootGameData() == null) {
                Pk1v1Data mPK1v18 = meetingRoomManager8.getMPK1v1();
                if (mPK1v18 != null && mPK1v18.checkIsPk()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11 && meetingRoomManager8.getMCarromGameData() == null && meetingRoomManager8.getMJackaroGameData() == null) {
                    if (!meetingRoomManager8.checkPKMadel()) {
                        RoomPK mpk8 = meetingRoomManager8.getMPK();
                        if (mpk8 != null && mpk8.checkIsInvite()) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (!z12 && !meetingRoomManager8.checkOpenHiloGame()) {
                            if (meetingRoomManager8.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe8 = meetingRoomManager8.getMYouTuBe();
                                if (mYouTuBe8 != null && (type4 = mYouTuBe8.getType()) != null && type4.intValue() == 4) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                if (!z13) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            if (meetingRoomManager8.getMBackgammonGameData() == null) {
                                createBackgammonDialog();
                                return;
                            }
                            AudioGameHelp mGameHelp8 = this.fragment.getMGameHelp();
                            if (mGameHelp8 == null || mGameHelp8.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35 && (mAudioHelp2 = this.fragment.getMAudioHelp()) != null) {
                                mAudioHelp2.showBackgammonGameView();
                                Unit unit10 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 12) {
            GroupDetailBean groupDetailBean9 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean9 != null && (role4 = groupDetailBean9.getRole()) != null) {
                i6 = role4.intValue();
            } else {
                i6 = 0;
            }
            if (i6 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager9 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager9.getMLudoGameData() == null && meetingRoomManager9.getMUnoGameData() == null && meetingRoomManager9.getMDominoGameData() == null && meetingRoomManager9.getMCrushGameData() == null && meetingRoomManager9.getMBalootGameData() == null && meetingRoomManager9.getMCarromGameData() == null) {
                Pk1v1Data mPK1v19 = meetingRoomManager9.getMPK1v1();
                if (mPK1v19 != null && mPK1v19.checkIsPk()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (!z8) {
                    AudioGameHelp mGameHelp9 = this.fragment.getMGameHelp();
                    if (mGameHelp9 != null && (mHiloGameHelp = mGameHelp9.getMHiloGameHelp()) != null) {
                        audioHiloGameBinding = mHiloGameHelp.getBinding();
                    }
                    if (audioHiloGameBinding == null && meetingRoomManager9.getMJackaroGameData() == null && meetingRoomManager9.getMBackgammonGameData() == null) {
                        if (meetingRoomManager9.getMYouTuBe() != null) {
                            YouTuGameData mYouTuBe9 = meetingRoomManager9.getMYouTuBe();
                            if (mYouTuBe9 != null && (type3 = mYouTuBe9.getType()) != null && type3.intValue() == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (!z10) {
                                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                return;
                            }
                        }
                        if (meetingRoomManager9.getMPK() == null) {
                            createPKDialog();
                            return;
                        }
                        AudioGameHelp mGameHelp10 = this.fragment.getMGameHelp();
                        if (mGameHelp10 != null && !mGameHelp10.checkGameIsShow()) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (z9 && (mAudioHelp = this.fragment.getMAudioHelp()) != null) {
                            mAudioHelp.checkPK();
                            Unit unit11 = Unit.INSTANCE;
                        }
                        RoomPK mpk9 = meetingRoomManager9.getMPK();
                        if (mpk9 == null || mpk9.getStatus() != 0) {
                            z35 = false;
                        }
                        if (!z35) {
                            return;
                        }
                        createPKDialog();
                        return;
                    }
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 22) {
            GroupDetailBean groupDetailBean10 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean10 != null && (role3 = groupDetailBean10.getRole()) != null) {
                i5 = role3.intValue();
            } else {
                i5 = 0;
            }
            if (i5 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager10 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager10.getMLudoGameData() == null && meetingRoomManager10.getMUnoGameData() == null && meetingRoomManager10.getMDominoGameData() == null && meetingRoomManager10.getMCrushGameData() == null && meetingRoomManager10.getMBalootGameData() == null && meetingRoomManager10.getMCarromGameData() == null) {
                Pk1v1Data mPK1v110 = meetingRoomManager10.getMPK1v1();
                if (mPK1v110 != null && mPK1v110.checkIsPk()) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (!z6 && meetingRoomManager10.getMJackaroGameData() == null && meetingRoomManager10.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager10.checkPKMadel()) {
                        RoomPK mpk10 = meetingRoomManager10.getMPK();
                        if (mpk10 != null && mpk10.checkIsInvite()) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (!z7) {
                            if (meetingRoomManager10.getMYouTuBe() != null) {
                                YouTuGameData mYouTuBe10 = meetingRoomManager10.getMYouTuBe();
                                if (mYouTuBe10 == null || (type2 = mYouTuBe10.getType()) == null || type2.intValue() != 4) {
                                    z35 = false;
                                }
                                if (!z35) {
                                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                    return;
                                }
                            }
                            AudioGameHelp mGameHelp11 = this.fragment.getMGameHelp();
                            if (mGameHelp11 != null) {
                                mGameHelp11.showGameView(22, gameConfiguration);
                                Unit unit12 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 19) {
            GroupDetailBean groupDetailBean11 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean11 != null && (role2 = groupDetailBean11.getRole()) != null) {
                i4 = role2.intValue();
            } else {
                i4 = 0;
            }
            if (i4 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager11 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager11.getMLudoGameData() == null && meetingRoomManager11.getMUnoGameData() == null && meetingRoomManager11.getMDominoGameData() == null && meetingRoomManager11.getMCrushGameData() == null && meetingRoomManager11.getMBalootGameData() == null && meetingRoomManager11.getMCarromGameData() == null && meetingRoomManager11.getMJackaroGameData() == null && meetingRoomManager11.getMBackgammonGameData() == null) {
                if (!meetingRoomManager11.checkPKMadel()) {
                    RoomPK mpk11 = meetingRoomManager11.getMPK();
                    if (mpk11 != null && mpk11.checkIsInvite()) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5 && !meetingRoomManager11.checkOpenHiloGame()) {
                        if (meetingRoomManager11.getMYouTuBe() != null) {
                            YouTuGameData mYouTuBe11 = meetingRoomManager11.getMYouTuBe();
                            if (mYouTuBe11 == null || (type = mYouTuBe11.getType()) == null || type.intValue() != 4) {
                                z35 = false;
                            }
                            if (!z35) {
                                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131954549), null, false, 6, null);
                                return;
                            }
                        }
                        if (meetingRoomManager11.getMPK1v1() == null) {
                            createPk1v1();
                            Unit unit13 = Unit.INSTANCE;
                            return;
                        }
                        AudioGameHelp mGameHelp12 = this.fragment.getMGameHelp();
                        if (mGameHelp12 != null && (mPk1v1Help = mGameHelp12.getMPk1v1Help()) != null) {
                            mPk1v1Help.showPk1v1();
                            Unit unit14 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                }
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                return;
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131952837), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 13) {
            MeetingRoomManager meetingRoomManager12 = MeetingRoomManager.INSTANCE;
            if (!meetingRoomManager12.checkOwnOrManager()) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953587), null, false, 6, null);
                return;
            }
            if (meetingRoomManager12.getMLudoGameData() == null && meetingRoomManager12.getMUnoGameData() == null && meetingRoomManager12.getMDominoGameData() == null && meetingRoomManager12.getMCrushGameData() == null && meetingRoomManager12.getMBalootGameData() == null && meetingRoomManager12.getMCarromGameData() == null) {
                Pk1v1Data mPK1v111 = meetingRoomManager12.getMPK1v1();
                if (mPK1v111 != null && mPK1v111.checkIsPk()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3 && meetingRoomManager12.getMJackaroGameData() == null && meetingRoomManager12.getMBackgammonGameData() == null) {
                    if (!meetingRoomManager12.checkPKMadel()) {
                        RoomPK mpk12 = meetingRoomManager12.getMPK();
                        if (mpk12 != null && mpk12.checkIsInvite()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4 && !meetingRoomManager12.checkOpenHiloGame()) {
                            AudioGameHelp mGameHelp13 = this.fragment.getMGameHelp();
                            if (mGameHelp13 == null || mGameHelp13.checkGameIsShow()) {
                                z35 = false;
                            }
                            if (z35) {
                                this.fragment.getMViewModel().startYouTuBe();
                                return;
                            }
                            return;
                        }
                    }
                    showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
                    return;
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 3) {
            showToastOrLog$default(this, null, "diceGame: 骰子游戏", false, 5, null);
            this.fragment.getMViewModel().toGameDice();
            return;
        }
        if (gameType != null && gameType.intValue() == 4) {
            GroupDetailBean groupDetailBean12 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean12 != null && (role = groupDetailBean12.getRole()) != null) {
                i3 = role.intValue();
            } else {
                i3 = 0;
            }
            if (i3 <= 1) {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953290), null, false, 6, null);
                return;
            }
            MeetingRoomManager meetingRoomManager13 = MeetingRoomManager.INSTANCE;
            if (!meetingRoomManager13.checkPKMadel()) {
                RoomPK mpk13 = meetingRoomManager13.getMPK();
                if (mpk13 != null && mpk13.checkIsInvite()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 && !meetingRoomManager13.checkOpenHiloGame()) {
                    AudioGameHelp mGameHelp14 = this.fragment.getMGameHelp();
                    if (mGameHelp14 == null || !mGameHelp14.checkGameIsShow()) {
                        z35 = false;
                    }
                    if (z35) {
                        showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953281), null, false, 6, null);
                        return;
                    } else {
                        showToastOrLog$default(this, null, "luckyWheel: 轮盘游戏", false, 5, null);
                        showGameLuckWheel();
                        return;
                    }
                }
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953653), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 5) {
            MeetingRoomManager meetingRoomManager14 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager14.getMLudoGameData() == null && meetingRoomManager14.getMUnoGameData() == null && meetingRoomManager14.getMDominoGameData() == null && meetingRoomManager14.getMCrushGameData() == null && meetingRoomManager14.getMBalootGameData() == null && meetingRoomManager14.getMCarromGameData() == null && meetingRoomManager14.getMJackaroGameData() == null && meetingRoomManager14.getMBackgammonGameData() == null) {
                showToastOrLog$default(this, null, "luckyBox: 幸运盒子", false, 5, null);
                if (FastClickUtils.INSTANCE.isFastClick()) {
                    new LuckyBoxDialog(this.fragment.getMViewModel().getMGroupId(), context, 0, 4, null).show();
                    return;
                }
                return;
            }
            showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953281), null, false, 6, null);
            return;
        }
        if (gameType != null && gameType.intValue() == 6) {
            MeetingRoomManager meetingRoomManager15 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager15.getMLudoGameData() == null && meetingRoomManager15.getMUnoGameData() == null && meetingRoomManager15.getMDominoGameData() == null && meetingRoomManager15.getMCrushGameData() == null && meetingRoomManager15.getMBalootGameData() == null && meetingRoomManager15.getMCarromGameData() == null && meetingRoomManager15.getMJackaroGameData() == null && meetingRoomManager15.getMBackgammonGameData() == null) {
                showToastOrLog$default(this, null, "inviteUser: 打开水果机", false, 5, null);
                showLuckyFruitDialog();
                return;
            } else {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953281), null, false, 6, null);
                return;
            }
        }
        if (gameType != null && gameType.intValue() == 20) {
            MeetingRoomManager meetingRoomManager16 = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager16.getMLudoGameData() == null && meetingRoomManager16.getMUnoGameData() == null && meetingRoomManager16.getMDominoGameData() == null && meetingRoomManager16.getMCrushGameData() == null && meetingRoomManager16.getMBalootGameData() == null && meetingRoomManager16.getMCarromGameData() == null && meetingRoomManager16.getMJackaroGameData() == null && meetingRoomManager16.getMBackgammonGameData() == null) {
                showToastOrLog$default(this, null, "inviteUser: 打开Foodie", false, 5, null);
                showFoodieDialog();
                return;
            } else {
                showToastOrLog$default(this, ResourcesKtxKt.getStringById(this, 2131953281), null, false, 6, null);
                return;
            }
        }
        if ((gameType == null || gameType.intValue() != 7) && (gameType == null || gameType.intValue() != 9)) {
            if (gameType != null && gameType.intValue() == 8) {
                if (Intrinsics.areEqual(gameConfiguration.isFull(), bool)) {
                    NavigationHelper navigationHelper4 = NavigationHelper.INSTANCE;
                    String url4 = gameConfiguration.getUrl();
                    if (url4 != null) {
                        str = url4;
                    }
                    NavigationHelper.jump$default(navigationHelper4, str, (SuperCallBack) null, 2, (Object) null);
                    return;
                }
                Integer gameId2 = gameConfiguration.getGameId();
                if (gameId2 != null) {
                    i = gameId2.intValue();
                } else {
                    i = 0;
                }
                new H5GemGameDialog(context, i).show();
                Unit unit15 = Unit.INSTANCE;
                return;
            }
            if (gameType != null && gameType.intValue() == 16) {
                NavigationHelper navigationHelper5 = NavigationHelper.INSTANCE;
                String url5 = gameConfiguration.getUrl();
                if (url5 != null) {
                    str = url5;
                }
                NavigationHelper.jump$default(navigationHelper5, str, (SuperCallBack) null, 2, (Object) null);
                return;
            }
            if (gameType != null && gameType.intValue() == 17) {
                MeetingRoomManager meetingRoomManager17 = MeetingRoomManager.INSTANCE;
                EnvelopeData mEnvelopeData = meetingRoomManager17.getMEnvelopeData();
                if (mEnvelopeData != null && mEnvelopeData.checkEnvelopeExpired()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && meetingRoomManager17.getMEnvelopeData() != null) {
                    AudioGameHelp mGameHelp15 = this.fragment.getMGameHelp();
                    if (mGameHelp15 != null && (mEnvelopeHelper = mGameHelp15.getMEnvelopeHelper()) != null) {
                        EnvelopeHelper.checkEnvelope$default(mEnvelopeHelper, false, 1, null);
                        Unit unit16 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
                FragmentActivity activity = this.fragment.getActivity();
                if (activity != null) {
                    new RedEnvelopeCreateDialog().show(activity.getSupportFragmentManager(), "RedEnvelopeCreateDialog");
                    Unit unit17 = Unit.INSTANCE;
                    return;
                }
                return;
            }
            return;
        }
        RoomViewModel mViewModel = this.fragment.getMViewModel();
        Integer gameId3 = gameConfiguration.getGameId();
        if (gameId3 != null) {
            i2 = gameId3.intValue();
        } else {
            i2 = 0;
        }
        mViewModel.requestMatchGame(i2, this.fragment.getMViewModel().getMGroupId());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.qiahao.nextvideo.room.dialog.RoomGameDialog, android.app.Dialog] */
    public final void showGameDialog() {
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            RoomGameDialog roomGameDialog = this.mRoomGameDialog;
            if (roomGameDialog != null) {
                roomGameDialog.setMListener(null);
            }
            this.mRoomGameDialog = null;
            ?? roomGameDialog2 = new RoomGameDialog(activity);
            roomGameDialog2.setMListener(new RoomGamePanelListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showGameDialog$1$1$1
                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void animationEffect() {
                    RoomGamePanelListener.DefaultImpls.animationEffect(this);
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void clearMessage() {
                    RoomGamePanelListener.DefaultImpls.clearMessage(this);
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void clickGame(GameConfiguration gameConfiguration) {
                    Intrinsics.checkNotNullParameter(gameConfiguration, "gameConfiguration");
                    AudioRoomDialogHelp.this.showGame(activity, gameConfiguration);
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void globalBroadcast() {
                    RoomGamePanelListener.DefaultImpls.globalBroadcast(this);
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void inviteUser() {
                    RoomGamePanelListener.DefaultImpls.inviteUser(this);
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void music() {
                    RoomGamePanelListener.DefaultImpls.music(this);
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void noiseReduction(boolean z) {
                    RoomGamePanelListener.DefaultImpls.noiseReduction(this, z);
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void roomMemberMass() {
                    RoomGamePanelListener.DefaultImpls.roomMemberMass(this);
                }
            });
            this.mRoomGameDialog = roomGameDialog2;
            roomGameDialog2.show();
        }
    }

    public final void showGameLuckWheel() {
        if (MeetingRoomManager.INSTANCE.getMRoomLuckWheelInfo() == null) {
            this.fragment.getMViewModel().refreshLuckLyDialog(true);
            return;
        }
        LuckyWheelDialog luckyWheelDialog = this.mLuckyWheelDialog;
        if (luckyWheelDialog != null) {
            luckyWheelDialog.show();
        }
    }

    public final void showGroupMusicDialog() {
        if (this.mGroupMusicDialog != null) {
            this.mGroupMusicDialog = null;
        }
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            GroupMusicDialog groupMusicDialog = new GroupMusicDialog(activity, new MusicDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showGroupMusicDialog$1$1
                @Override // com.qiahao.nextvideo.room.dialog.MusicDialogListener
                public void addMusic() {
                }

                @Override // com.qiahao.nextvideo.room.dialog.MusicDialogListener
                public void musicList() {
                    MyMusicActivity.INSTANCE.start(activity);
                }

                @Override // com.qiahao.nextvideo.room.dialog.MusicDialogListener
                public void musicRotationType() {
                }

                @Override // com.qiahao.nextvideo.room.dialog.MusicDialogListener
                public void nextMusic() {
                }

                @Override // com.qiahao.nextvideo.room.dialog.MusicDialogListener
                public void oldMusic() {
                }

                @Override // com.qiahao.nextvideo.room.dialog.MusicDialogListener
                public void playPauseMusic() {
                }
            });
            this.mGroupMusicDialog = groupMusicDialog;
            groupMusicDialog.show();
        }
    }

    public final void showInviteUserUpDialog(@NotNull String name) {
        CommonTextDialog commonTextDialog;
        Intrinsics.checkNotNullParameter(name, "name");
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null && mGameHelp.checkGameIsShow()) {
            return;
        }
        AppCompatDialog appCompatDialog = this.commonTextDialog;
        if (appCompatDialog != null && appCompatDialog != null && appCompatDialog.isShowing() && (commonTextDialog = this.commonTextDialog) != null) {
            commonTextDialog.dismiss();
        }
        Context context = this.fragment.getContext();
        if (context != null) {
            CommonTextDialog commonTextDialog2 = new CommonTextDialog(context, 0.0f, 2, null);
            commonTextDialog2.setContentText(name, true, new AudioRoomDialogHelp$showInviteUserUpDialog$1$1$1(this));
            this.commonTextDialog = commonTextDialog2;
        }
        AppCompatDialog appCompatDialog2 = this.commonTextDialog;
        if (appCompatDialog2 != null) {
            appCompatDialog2.show();
        }
    }

    public final void showLeaveRoomDialog() {
        final FragmentActivity activity;
        int i;
        User owner;
        NobleInfo noble;
        Integer level;
        if (this.mLeaveRoomDialog == null && (activity = this.fragment.getActivity()) != null) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null && (owner = groupDetailBean.getOwner()) != null && (noble = owner.getNoble()) != null && (level = noble.getLevel()) != null) {
                i = level.intValue();
            } else {
                i = 0;
            }
            LeaveRoomDialog leaveRoomDialog = new LeaveRoomDialog(activity, i);
            leaveRoomDialog.setMLeaveRoomDialogListener(new LeaveRoomDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showLeaveRoomDialog$1$1$1
                /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
                @Override // com.qiahao.nextvideo.room.dialog.LeaveRoomDialogListener
                public void onLeaveRoomDialogListenerLeaveRoom() {
                    AudioGameHelp mGameHelp = AudioRoomDialogHelp.this.getFragment().getMGameHelp();
                    if (mGameHelp != null && mGameHelp.checkJoinGame()) {
                        ?? commonTextDialog = new CommonTextDialog(activity, 0.0f, 2, null);
                        final AudioRoomDialogHelp audioRoomDialogHelp = AudioRoomDialogHelp.this;
                        commonTextDialog.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131952852), true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showLeaveRoomDialog$1$1$1$onLeaveRoomDialogListenerLeaveRoom$1$1
                            public void cancel() {
                            }

                            public void confirm() {
                                AudioRoomFragment.leaveRoom$default(AudioRoomDialogHelp.this.getFragment(), false, 1, null);
                            }
                        });
                        commonTextDialog.show();
                        return;
                    }
                    AudioRoomFragment.leaveRoom$default(AudioRoomDialogHelp.this.getFragment(), false, 1, null);
                }

                @Override // com.qiahao.nextvideo.room.dialog.LeaveRoomDialogListener
                public void onLeaveRoomDialogListenerSmallRoom() {
                    AudioRoomDialogHelp.this.getFragment().smallRoom();
                }
            });
            this.mLeaveRoomDialog = leaveRoomDialog;
        }
        LeaveRoomDialog leaveRoomDialog2 = this.mLeaveRoomDialog;
        if (leaveRoomDialog2 != null) {
            leaveRoomDialog2.show();
        }
    }

    public final void showLuckyDialog(@Nullable LuckWheelInfo data) {
        ImageView imageView;
        BaseBindingDialog baseBindingDialog;
        ImageView imageView2;
        LuckyWheelDialog luckyWheelDialog;
        AudioGameHelp mGameHelp;
        FragmentActivity activity;
        ImageView imageView3;
        if (data != null && data.getStatus() != 0) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.isCanShowSmallLuckyRouletteOrBox()) {
                FragmentAudioRoomBinding binding = this.fragment.getBinding();
                if (binding != null && (imageView3 = binding.smallRoulette) != null) {
                    imageView3.setVisibility(0);
                }
            } else {
                FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                if (binding2 != null && (imageView2 = binding2.smallRoulette) != null) {
                    imageView2.setVisibility(8);
                }
            }
            if (this.mLuckyWheelDialog == null && (activity = this.fragment.getActivity()) != null) {
                LuckyWheelDialog luckyWheelDialog2 = new LuckyWheelDialog(activity);
                this.mLuckyWheelDialog = luckyWheelDialog2;
                luckyWheelDialog2.setMLuckyWheelListener(new LuckyWheelListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showLuckyDialog$1$1
                    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
                    @Override // com.qiahao.nextvideo.room.dialog.LuckyWheelListener
                    public void closeLuckyWheelView() {
                        FragmentActivity activity2 = AudioRoomDialogHelp.this.getFragment().getActivity();
                        if (activity2 != null) {
                            final AudioRoomDialogHelp audioRoomDialogHelp = AudioRoomDialogHelp.this;
                            ?? commonTextDialog = new CommonTextDialog(activity2, 0.0f, 2, null);
                            commonTextDialog.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131952272), true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showLuckyDialog$1$1$closeLuckyWheelView$1$1$1
                                public void cancel() {
                                }

                                public void confirm() {
                                    AudioRoomDialogHelp.this.getFragment().getMViewModel().closeLuckyDialog();
                                }
                            });
                            commonTextDialog.show();
                        }
                    }

                    @Override // com.qiahao.nextvideo.room.dialog.LuckyWheelListener
                    public void joinLuckyWheelGame() {
                        AudioRoomDialogHelp.this.getFragment().getMViewModel().joinRoomLuckWheel();
                    }

                    @Override // com.qiahao.nextvideo.room.dialog.LuckyWheelListener
                    public void luckyWheelGameWinSvgaFinish(boolean hasNextTime) {
                        ImageView imageView4;
                        BaseBindingDialog mLuckyWheelDialog;
                        LuckyWheelDialog mLuckyWheelDialog2;
                        View view;
                        FragmentAudioRoomBinding binding3 = AudioRoomDialogHelp.this.getFragment().getBinding();
                        if (binding3 != null && (view = binding3.bgAllBlack) != null) {
                            view.setVisibility(8);
                        }
                        AudioRoomDialogHelp.showToastOrLog$default(AudioRoomDialogHelp.this, null, "LucklyWheel luckyWheelGameWinSvgaFinish:", false, 5, null);
                        if (hasNextTime) {
                            AudioRoomDialogHelp.showToastOrLog$default(AudioRoomDialogHelp.this, null, "LucklyWheel luckyWheelGameWinSvgaFinish: 游戏结束  重新获取游戏", false, 5, null);
                            RoomViewModel.refreshLuckLyDialog$default(AudioRoomDialogHelp.this.getFragment().getMViewModel(), false, 1, null);
                            if (AudioRoomDialogHelp.this.getMLuckyWheelDialog() != null && (mLuckyWheelDialog2 = AudioRoomDialogHelp.this.getMLuckyWheelDialog()) != null) {
                                mLuckyWheelDialog2.setHasNextTime(false);
                                return;
                            }
                            return;
                        }
                        AudioRoomDialogHelp.showToastOrLog$default(AudioRoomDialogHelp.this, null, "LucklyWheel luckyWheelGameWinSvgaFinish:直接隐藏", false, 5, null);
                        AudioRoomDialogHelp mDialogHelp = AudioRoomDialogHelp.this.getFragment().getMDialogHelp();
                        if (mDialogHelp != null && (mLuckyWheelDialog = mDialogHelp.getMLuckyWheelDialog()) != null) {
                            mLuckyWheelDialog.hide();
                        }
                        FragmentAudioRoomBinding binding4 = AudioRoomDialogHelp.this.getFragment().getBinding();
                        if (binding4 != null && (imageView4 = binding4.smallRoulette) != null) {
                            imageView4.setVisibility(8);
                        }
                        AudioRoomDialogHelp.this.setMSmallLuckWheelDialog(false);
                        MeetingRoomManager.INSTANCE.setMRoomLuckWheelInfo(null);
                    }

                    @Override // com.qiahao.nextvideo.room.dialog.LuckyWheelListener
                    public void playLuckyWheelView() {
                        AudioRoomDialogHelp.this.getFragment().getMViewModel().playLuckWheel();
                    }

                    @Override // com.qiahao.nextvideo.room.dialog.LuckyWheelListener
                    public void smallLuckyWheelView() {
                        AudioRoomDialogHelp.this.setMSmallLuckWheelDialog(true);
                    }

                    @Override // com.qiahao.nextvideo.room.dialog.LuckyWheelListener
                    public void winSvgaStartPlay() {
                        View view;
                        AudioGameHelp mGameHelp2 = AudioRoomDialogHelp.this.getFragment().getMGameHelp();
                        if (mGameHelp2 != null && !mGameHelp2.checkGameIsShow()) {
                            LuckyWheelDialog mLuckyWheelDialog = AudioRoomDialogHelp.this.getMLuckyWheelDialog();
                            if (mLuckyWheelDialog != null) {
                                mLuckyWheelDialog.show();
                            }
                            FragmentAudioRoomBinding binding3 = AudioRoomDialogHelp.this.getFragment().getBinding();
                            if (binding3 != null && (view = binding3.bgAllBlack) != null) {
                                view.setVisibility(0);
                            }
                        }
                        AudioRoomDialogHelp.this.setMSmallLuckWheelDialog(false);
                    }
                });
            }
            LuckyWheelDialog luckyWheelDialog3 = this.mLuckyWheelDialog;
            if (luckyWheelDialog3 != null) {
                luckyWheelDialog3.setDate(data);
            }
            LuckWheelInfo mRoomLuckWheelInfo = meetingRoomManager.getMRoomLuckWheelInfo();
            if ((mRoomLuckWheelInfo == null || mRoomLuckWheelInfo.getWheelId() != data.getWheelId()) && (luckyWheelDialog = this.mLuckyWheelDialog) != null) {
                luckyWheelDialog.setHasNextTime(true);
            }
            if (!this.mSmallLuckWheelDialog && (mGameHelp = this.fragment.getMGameHelp()) != null && !mGameHelp.checkGameIsShow()) {
                LuckyWheelDialog luckyWheelDialog4 = this.mLuckyWheelDialog;
                if (luckyWheelDialog4 != null) {
                    luckyWheelDialog4.show();
                }
            } else {
                this.mSmallLuckWheelDialog = true;
            }
            meetingRoomManager.setMRoomLuckWheelInfo(data);
            return;
        }
        AudioRoomDialogHelp mDialogHelp = this.fragment.getMDialogHelp();
        if (mDialogHelp != null && (baseBindingDialog = mDialogHelp.mLuckyWheelDialog) != null) {
            baseBindingDialog.hide();
        }
        FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
        if (binding3 != null && (imageView = binding3.smallRoulette) != null) {
            imageView.setVisibility(8);
        }
        this.mSmallLuckWheelDialog = false;
        MeetingRoomManager.INSTANCE.setMRoomLuckWheelInfo(null);
    }

    public final void showLuckyFruitDialog() {
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "SHOW_LUCKY_FRUIT", Boolean.TRUE, (String) null, 4, (Object) null);
            LuckyFruitDialog luckyFruitDialog = new LuckyFruitDialog(activity);
            luckyFruitDialog.setMLuckyFruitDialogListener(new LuckyFruitDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showLuckyFruitDialog$1$1$1
                @Override // com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialogListener
                public void isLuckyFruitDialogDissmiss() {
                    AudioRoomDialogHelp.this.setMLuckyFruitDialog(null);
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "SHOW_LUCKY_FRUIT", Boolean.FALSE, (String) null, 4, (Object) null);
                }
            });
            this.mLuckyFruitDialog = luckyFruitDialog;
            luckyFruitDialog.show();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.app.Dialog, com.qiahao.nextvideo.room.dialog.MicOperateBottomDialog] */
    public final void showMicOperateBottomDialog(int position, @Nullable MicroBean micBean, boolean showLockLayout) {
        String str;
        FragmentActivity activity;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        int roomUserRole = meetingRoomManager.getRoomUserRole(str);
        boolean z = true;
        if (roomUserRole > 1 && (activity = this.fragment.getActivity()) != null) {
            if (micBean == null || micBean.getMicForbid()) {
                z = false;
            }
            ?? micOperateBottomDialog = new MicOperateBottomDialog(activity, showLockLayout, z);
            micOperateBottomDialog.setMicOperateListener(new AudioRoomDialogHelp$showMicOperateBottomDialog$1$1$1(this, position, micBean));
            micOperateBottomDialog.show();
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.app.Dialog, com.qiahao.nextvideo.room.rocket.RoomRocketDialog] */
    public final void showRocketDialog() {
        FragmentActivity activity;
        if (this.mRocketDialog == null && (activity = this.fragment.getActivity()) != null) {
            ?? roomRocketDialog = new RoomRocketDialog(this.fragment.getMViewModel().getMGroupId(), activity, 0, 4, null);
            roomRocketDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.room.help.r
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    AudioRoomDialogHelp.this.mRocketDialog = null;
                }
            });
            this.mRocketDialog = roomRocketDialog;
        }
        RoomRocketDialog roomRocketDialog2 = this.mRocketDialog;
        if (roomRocketDialog2 != null) {
            roomRocketDialog2.show();
        }
    }

    public final void showRoomMemberMass(@NotNull FragmentActivity activity) {
        String str;
        int i;
        groupSets groupSet;
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        showToastOrLog$default(this, null, "luckyWheel: 本群的群组广播", false, 5, null);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str);
        if (meetingRoomManager.getRoomUserRole(str) > 1) {
            RoomTipDialog roomTipDialog = new RoomTipDialog(activity);
            String stringById = ResourcesKtxKt.getStringById(this, 2131954026);
            PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
            if (purchaseFeeDetail != null && (groupSet = purchaseFeeDetail.getGroupSet()) != null) {
                i = groupSet.getGroupIMMass();
            } else {
                i = 0;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            RoomTipDialog tipContent = roomTipDialog.setConfirmContent(format).setAutoDismiss(false).setTipContent(ResourcesKtxKt.getStringById(this, 2131953139));
            tipContent.setDialogListener(new AudioRoomDialogHelp$showRoomMemberMass$1(this, activity, tipContent));
            tipContent.show();
            return;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.fragment.getContext(), ResourcesKtxKt.getStringById(this, 2131952147), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        showToastOrLog$default(this, null, "点击onClick:群里播放广告 不够等级", false, 5, null);
    }

    public final void showRoomTipDialog() {
        RoomTipDialog roomTipDialog = this.roomTipDialog;
        if (roomTipDialog != null) {
            if (roomTipDialog != null) {
                roomTipDialog.dismiss();
            }
            this.roomTipDialog = null;
        }
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            RoomTipDialog dialogListener = new RoomTipDialog(activity).setTipContent(ResourcesKtxKt.getStringById(this, 2131953135)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131951935)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showRoomTipDialog$1$1
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                    AudioRoomDialogHelp.this.setRoomTipDialog(null);
                }

                public void confirm() {
                    AudioRoomDialogHelp.this.setRoomTipDialog(null);
                    AudioRoomDialogHelp.this.getFragment().getMViewModel().acceptInvite(1);
                }
            });
            this.roomTipDialog = dialogListener;
            if (dialogListener != null) {
                dialogListener.show();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.qiahao.nextvideo.room.dialog.TakeMicTaskCompleteDialog, android.app.Dialog] */
    public final void showTakeMicTaskCompleteDialog() {
        Integer num;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        Pair<Boolean, Integer> mTaskMicCompletePairs = meetingRoomManager.getMTaskMicCompletePairs();
        if (mTaskMicCompletePairs != null) {
            num = (Integer) mTaskMicCompletePairs.getSecond();
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
        int intValue = num.intValue();
        FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            ?? takeMicTaskCompleteDialog = new TakeMicTaskCompleteDialog(activity, intValue);
            takeMicTaskCompleteDialog.setMTakeMicTaskCompleteDialogListener(new TakeMicTaskCompleteDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showTakeMicTaskCompleteDialog$1$1
                @Override // com.qiahao.nextvideo.room.dialog.TakeMicTaskCompleteDialogListener
                public void confirm() {
                    if (AudioRoomDialogHelp.this.getMLuckyFruitDialog() == null) {
                        AudioRoomDialogHelp.this.showLuckyFruitDialog();
                    }
                }
            });
            takeMicTaskCompleteDialog.show();
        }
        meetingRoomManager.setMTaskMicCompletePairs(null);
    }

    public final void showToastOrLog(@NotNull String toastText, @NotNull String logText, boolean writeIn) {
        Context context;
        Toast normal$default;
        Intrinsics.checkNotNullParameter(toastText, "toastText");
        Intrinsics.checkNotNullParameter(logText, "logText");
        if (!TextUtils.isEmpty(toastText) && (context = this.fragment.getContext()) != null && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, context, toastText, false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        if (!TextUtils.isEmpty(logText)) {
            if (writeIn) {
                n5.e.c("AudioRoomFragment : " + logText);
                return;
            }
            Log.i("AudioRoomFragment", logText);
        }
    }

    public final void showToolDialog() {
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null) {
            RoomToolDialog roomToolDialog = this.mRoomToolDialog;
            if (roomToolDialog != null) {
                roomToolDialog.setMListener(null);
            }
            this.mRoomToolDialog = null;
            RoomToolDialog roomToolDialog2 = new RoomToolDialog(activity);
            roomToolDialog2.setMListener(new RoomGamePanelListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showToolDialog$1$1$1
                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void animationEffect() {
                    RoomAnimationEffectBottomDialog roomAnimationEffectBottomDialog = new RoomAnimationEffectBottomDialog(activity);
                    final AudioRoomDialogHelp audioRoomDialogHelp = AudioRoomDialogHelp.this;
                    roomAnimationEffectBottomDialog.setMRoomGamePanelListener(new RoomAnimationEffectListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showToolDialog$1$1$1$animationEffect$1$1
                        @Override // com.qiahao.nextvideo.room.dialog.RoomAnimationEffectListener
                        public void clickEnterEffect(boolean isSelect) {
                            MeetingRoomManager.INSTANCE.setShowEnterEffect(isSelect);
                            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "EnterEffect", Boolean.valueOf(isSelect), (String) null, 4, (Object) null);
                        }

                        @Override // com.qiahao.nextvideo.room.dialog.RoomAnimationEffectListener
                        public void clickGiftEffect(boolean isSelect) {
                            MeetingRoomManager.INSTANCE.setShowGiftEffect(isSelect);
                            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "GiftEffect", Boolean.valueOf(isSelect), (String) null, 4, (Object) null);
                        }

                        @Override // com.qiahao.nextvideo.room.dialog.RoomAnimationEffectListener
                        public void clickRocketEffect(boolean isSelect) {
                            FragmentAudioRoomBinding binding;
                            RocketSvgaCountdownView rocketSvgaCountdownView;
                            MeetingRoomManager.INSTANCE.setShowRocketEffect(isSelect);
                            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "RocketEffect", Boolean.valueOf(isSelect), (String) null, 4, (Object) null);
                            if (!isSelect && (binding = AudioRoomDialogHelp.this.getFragment().getBinding()) != null && (rocketSvgaCountdownView = binding.rocketSvga) != null) {
                                rocketSvgaCountdownView.stopRocket();
                            }
                        }
                    });
                    roomAnimationEffectBottomDialog.show();
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void clearMessage() {
                    int i;
                    Integer role;
                    GroupDetailBean groupDetailBean = (GroupDetailBean) AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupDetailBean().getValue();
                    if (groupDetailBean != null && (role = groupDetailBean.getRole()) != null) {
                        i = role.intValue();
                    } else {
                        i = 0;
                    }
                    if (i <= 1) {
                        AudioRoomDialogHelp.showToastOrLog$default(AudioRoomDialogHelp.this, ResourcesKtxKt.getStringById(this, 2131953950), null, false, 6, null);
                        return;
                    }
                    FragmentActivity activity2 = AudioRoomDialogHelp.this.getFragment().getActivity();
                    if (activity2 != null) {
                        final AudioRoomDialogHelp audioRoomDialogHelp = AudioRoomDialogHelp.this;
                        new RoomTipDialog(activity2).setTipContent(ResourcesKtxKt.getStringById(this, 2131954191)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showToolDialog$1$1$1$clearMessage$1$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                AudioRoomDialogHelp.this.getFragment().getMViewModel().cleanMessage();
                            }
                        }).show();
                    }
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void clickGame(GameConfiguration gameConfiguration) {
                    RoomGamePanelListener.DefaultImpls.clickGame(this, gameConfiguration);
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void globalBroadcast() {
                    AudioRoomDialogHelp.showToastOrLog$default(AudioRoomDialogHelp.this, null, "inviteUser: 所有群广播", false, 5, null);
                    new SendGroupBroadcastDialog(activity, AudioRoomDialogHelp.this.getFragment().getMViewModel().getMGroupId(), 1).show();
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void inviteUser() {
                    AudioRoomDialogHelp.showToastOrLog$default(AudioRoomDialogHelp.this, null, "inviteUser: 邀请用户", false, 5, null);
                    if (FastClickUtils.INSTANCE.isFastClick()) {
                        AudioRoomDialogHelp.this.inviteUserDialog();
                    }
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void music() {
                    AudioRoomDialogHelp.showToastOrLog$default(AudioRoomDialogHelp.this, null, "luckyWheel: 音乐", false, 5, null);
                    String str = null;
                    if (AudioRoomFragment.checkWriteOrStoragePermission$default(AudioRoomDialogHelp.this.getFragment(), null, 1, null)) {
                        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user != null) {
                            str = user.getExternalId();
                        }
                        if (meetingRoomManager.checkUserOnMic(str)) {
                            AudioRoomDialogHelp.this.showGroupMusicDialog();
                            return;
                        }
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, AudioRoomDialogHelp.this.getFragment().getContext(), ResourcesKtxKt.getStringById(this, 2131953694), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                    }
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void noiseReduction(final boolean noiseReduction) {
                    RoomGamePanelListener.DefaultImpls.noiseReduction(this, noiseReduction);
                    if (noiseReduction) {
                        new TipTitleDialog(activity).setTitleContent(ResourcesKtxKt.getStringById(this, 2131953551)).setTipContent(ResourcesKtxKt.getStringById(this, 2131953549) + "\n" + ResourcesKtxKt.getStringById(this, 2131953550)).setRoom(true).setTipAlign(8388611).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showToolDialog$1$1$1$noiseReduction$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                HiloRtcEngine.INSTANCE.setEnableAiNoiseReduction(noiseReduction);
                            }
                        }).show();
                        return;
                    }
                    new TipTitleDialog(activity).setTitleContent(ResourcesKtxKt.getStringById(this, 2131953548)).setTipContent(ResourcesKtxKt.getStringById(this, 2131953547)).setRoom(true).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomDialogHelp$showToolDialog$1$1$1$noiseReduction$2
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            HiloRtcEngine.INSTANCE.setEnableAiNoiseReduction(noiseReduction);
                        }
                    }).show();
                }

                @Override // com.qiahao.nextvideo.room.dialog.RoomGamePanelListener
                public void roomMemberMass() {
                    AudioRoomDialogHelp.this.showRoomMemberMass(activity);
                }
            });
            this.mRoomToolDialog = roomToolDialog2;
            roomToolDialog2.show();
        }
    }

    public final void showUserInfoDialog(@NotNull String extraId, final int micPosition) {
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        final FragmentActivity activity = this.fragment.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (activity instanceof HiloBaseActivity) {
                HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) activity, (String) null, false, (Function0) null, 7, (Object) null);
            }
            getUserInfoByExtraId(extraId, MeetingRoomManager.INSTANCE.getMGroupId(), new Function1() { // from class: com.qiahao.nextvideo.room.help.c0
                public final Object invoke(Object obj) {
                    Unit showUserInfoDialog$lambda$73$lambda$71;
                    showUserInfoDialog$lambda$73$lambda$71 = AudioRoomDialogHelp.showUserInfoDialog$lambda$73$lambda$71(activity, micPosition, this, (User) obj);
                    return showUserInfoDialog$lambda$73$lambda$71;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.room.help.d0
                public final Object invoke() {
                    Unit showUserInfoDialog$lambda$73$lambda$72;
                    showUserInfoDialog$lambda$73$lambda$72 = AudioRoomDialogHelp.showUserInfoDialog$lambda$73$lambda$72(activity);
                    return showUserInfoDialog$lambda$73$lambda$72;
                }
            });
        }
    }
}
