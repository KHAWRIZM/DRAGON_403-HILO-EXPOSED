package com.qiahao.base_common.support;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SendGiftListener;
import com.qiahao.base_common.model.MultiGiftData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import com.qiahao.base_common.network.model.ErrorResponse;
import io.reactivex.rxjava3.core.i0;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H&¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0010H&¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0010H&¢\u0006\u0004\b\u001a\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H&¢\u0006\u0004\b\u001c\u0010\u0015J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H&¢\u0006\u0004\b\u001d\u0010\u0015J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H&¢\u0006\u0004\b\u001e\u0010\u0015J\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0010H&¢\u0006\u0004\b\u001f\u0010\u0015J\u000f\u0010 \u001a\u00020\u0006H&¢\u0006\u0004\b \u0010\u000bJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0010H&¢\u0006\u0004\b!\u0010\u0015J\u000f\u0010\"\u001a\u00020\u0010H&¢\u0006\u0004\b\"\u0010\u0012J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0010H&¢\u0006\u0004\b&\u0010\u0012J;\u0010+\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00102\"\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010(j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001`)H&¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H&¢\u0006\u0004\b-\u0010\u000bJ\u0017\u00100\u001a\u00020.2\u0006\u0010/\u001a\u00020.H&¢\u0006\u0004\b0\u00101J#\u00103\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u00102\u001a\u00020\u0010H&¢\u0006\u0004\b3\u00104J\u0019\u00107\u001a\u0004\u0018\u0001062\u0006\u00105\u001a\u00020#H&¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H&¢\u0006\u0004\b9\u0010\u000bJ\u000f\u0010;\u001a\u00020:H&¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020.H&¢\u0006\u0004\b>\u0010?J#\u0010B\u001a\u00020\u00062\b\b\u0002\u0010@\u001a\u00020:2\b\b\u0002\u0010A\u001a\u00020:H&¢\u0006\u0004\bB\u0010CJm\u0010M\u001a\u00020\u00062\u0006\u0010E\u001a\u00020D2\u0006\u0010\u0018\u001a\u00020\u00102:\b\u0002\u0010J\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0002¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u0006\u0018\u00010F2\u0010\b\u0002\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010KH&¢\u0006\u0004\bM\u0010NJ?\u0010V\u001a\u00020\u00062\u0006\u0010P\u001a\u00020O2\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020S2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020.H&¢\u0006\u0004\bY\u0010?J\u0011\u0010Z\u001a\u0004\u0018\u00010QH&¢\u0006\u0004\bZ\u0010[J\u0017\u0010\\\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0010H&¢\u0006\u0004\b\\\u0010\u0015J\u0017\u0010]\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H&¢\u0006\u0004\b]\u0010\u0015J\u0017\u0010_\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0010H&¢\u0006\u0004\b_\u0010\u0015J\u0017\u0010a\u001a\u00020\u00062\u0006\u0010`\u001a\u00020#H&¢\u0006\u0004\ba\u0010bJ\u001f\u0010e\u001a\u00020\u00062\u0006\u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020.H&¢\u0006\u0004\be\u0010fJ\u001f\u0010i\u001a\u00020\u00062\u0006\u0010T\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0010H&¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\u0006H&¢\u0006\u0004\bk\u0010\u000bJ\u001f\u0010m\u001a\u00020\u00062\u0006\u0010R\u001a\u00020Q2\u0006\u0010l\u001a\u00020\u0010H&¢\u0006\u0004\bm\u0010nJ\u000f\u0010o\u001a\u00020\u0006H&¢\u0006\u0004\bo\u0010\u000bJ\u0017\u0010p\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0010H&¢\u0006\u0004\bp\u0010\u0015J\u0017\u0010q\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H&¢\u0006\u0004\bq\u0010\u0015J1\u0010u\u001a\u00020\u00062\b\b\u0002\u0010r\u001a\u00020.2\u0006\u0010d\u001a\u00020.2\u0006\u0010s\u001a\u00020.2\u0006\u0010t\u001a\u00020.H&¢\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u00020\u0006H&¢\u0006\u0004\bw\u0010\u000bJ\u0019\u0010z\u001a\u0004\u0018\u00010y2\u0006\u0010x\u001a\u00020\u0010H&¢\u0006\u0004\bz\u0010{J\u000f\u0010|\u001a\u00020\u0006H&¢\u0006\u0004\b|\u0010\u000bJ\u000f\u0010}\u001a\u00020\u0006H&¢\u0006\u0004\b}\u0010\u000bJ\u000f\u0010~\u001a\u00020\u0006H&¢\u0006\u0004\b~\u0010\u000bJ\u000f\u0010\u007f\u001a\u00020\u0006H&¢\u0006\u0004\b\u007f\u0010\u000bJ$\u0010\u0082\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00100\u0080\u0001j\t\u0012\u0004\u0012\u00020\u0010`\u0081\u0001H&¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u001b\u0010\u0085\u0001\u001a\u00020\u00022\u0007\u0010\u0084\u0001\u001a\u00020\u0010H&¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0011\u0010\u0087\u0001\u001a\u00020\u0006H&¢\u0006\u0005\b\u0087\u0001\u0010\u000bJ!\u0010\u0088\u0001\u001a\u00020\u00062\u0006\u0010T\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0010H&¢\u0006\u0005\b\u0088\u0001\u0010jJ#\u0010\u008a\u0001\u001a\u00020\u00062\u0006\u0010R\u001a\u00020Q2\u0007\u0010\r\u001a\u00030\u0089\u0001H&¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u001a\u0010\u008c\u0001\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0010H&¢\u0006\u0006\b\u008c\u0001\u0010\u0086\u0001J\u001a\u0010\u008d\u0001\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0010H&¢\u0006\u0006\b\u008d\u0001\u0010\u0086\u0001J\u0011\u0010\u008e\u0001\u001a\u00020\u0006H&¢\u0006\u0005\b\u008e\u0001\u0010\u000bJ\u0019\u0010\u008f\u0001\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H&¢\u0006\u0005\b\u008f\u0001\u0010\u0015J\u001e\u0010\u0092\u0001\u001a\u00020\u00062\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001H&¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001a\u0010\u0094\u0001\u001a\u00020\u00062\u0007\u0010\u0084\u0001\u001a\u00020\u0010H&¢\u0006\u0005\b\u0094\u0001\u0010\u0015J\u0011\u0010\u0095\u0001\u001a\u00020\u0006H&¢\u0006\u0005\b\u0095\u0001\u0010\u000bJ\u0011\u0010\u0096\u0001\u001a\u00020\u0006H&¢\u0006\u0005\b\u0096\u0001\u0010\u000bJ\u001c\u0010\u0097\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010t\u001a\u00020.H&¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0011\u0010\u0099\u0001\u001a\u00020#H&¢\u0006\u0005\b\u0099\u0001\u0010%J\u001b\u0010\u009b\u0001\u001a\u00020\u00102\u0007\u0010\u009a\u0001\u001a\u00020#H&¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0019\u0010\u009d\u0001\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H&¢\u0006\u0005\b\u009d\u0001\u0010\u0015J\u0086\u0001\u0010\u009f\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100¥\u00010¤\u00012\u000b\b\u0002\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00102\u0007\u0010\u009f\u0001\u001a\u00020y2\t\b\u0002\u0010 \u0001\u001a\u00020\u00022=\b\u0002\u0010£\u0001\u001a6\u0012\u0014\u0012\u00120#¢\u0006\r\bG\u0012\t\bH\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120#¢\u0006\r\bG\u0012\t\bH\u0012\u0005\b\b(¢\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010FH&¢\u0006\u0006\b\u009f\u0001\u0010¦\u0001J\u0012\u0010§\u0001\u001a\u00020.H&¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001a\u0010ª\u0001\u001a\u00020\u00062\u0007\u0010©\u0001\u001a\u00020.H&¢\u0006\u0005\bª\u0001\u0010?J<\u0010¯\u0001\u001a\u00020.2\u0007\u0010«\u0001\u001a\u00020#2\t\b\u0002\u0010¬\u0001\u001a\u00020\u00022\t\b\u0002\u0010\u00ad\u0001\u001a\u00020\u00022\t\b\u0002\u0010®\u0001\u001a\u00020\u0002H&¢\u0006\u0006\b¯\u0001\u0010°\u0001¨\u0006±\u0001"}, d2 = {"Lcom/qiahao/base_common/support/AppService;", "", "", "checkServerDebug", "()Z", "isSendEvent", "", "logout", "(Z)V", "isAuthenticated", "showUpdateDialog", "()V", "Lcom/qiahao/base_common/network/model/ErrorResponse;", "data", "showErrorTipDialog", "(Lcom/qiahao/base_common/network/model/ErrorResponse;)V", "", "getAuthenticationToken", "()Ljava/lang/String;", HeaderInterceptor.TOKEN, "setAuthenticationToken", "(Ljava/lang/String;)V", "groupId", "joinLive", "externalId", "openPersonPage", "openGroupSupport", "url", "openH5", "openDefaultBrowser", "openHorizontalH5", "videoCall", "openWallet", "toChat", "getUserExternalId", "", "getId", "()J", "getSimOperator", "event", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "values", "onEvent", "(Ljava/lang/String;Ljava/util/HashMap;)V", "startMyBag", "", "nobleLevel", "getNobleDrawableRes", "(I)I", "svgaUrl", "showImageOrSvga", "(Ljava/lang/String;Ljava/lang/String;)V", "giftId", "Lcom/qiahao/base_common/model/MultiGiftData;", "findGiftByGiftId", "(J)Lcom/qiahao/base_common/model/MultiGiftData;", "startWallet", "", "getDiamond", "()D", "likeCount", "refreshLikeCount", "(I)V", "diamonds", "pinkDiamondNum", "refreshDiamondOrGem", "(DD)V", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isLike", "likeListener", "Lkotlin/Function0;", "startVideo", "newStartVideo", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/qiahao/base_common/model/common/User;", "user", "Lcom/qiahao/base_common/interfaceing/SendGiftListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isStrange", "showChatGiftDialog", "(Landroidx/fragment/app/FragmentManager;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/interfaceing/SendGiftListener;Ljava/lang/String;Ljava/lang/Boolean;)V", "position", "showVipDialog", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "roomOpenUserInfo", "openLevelActivity", "id", "openActivityDetail", "familyID", "openFamily", "(J)V", "matchId", "gameId", "openSheep", "(II)V", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "tip", "showCpDialog", "(Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;Ljava/lang/String;)V", "openGemStore", "msg", "openCpDialog", "(Lcom/qiahao/base_common/model/common/User;Ljava/lang/String;)V", "openMemorial", "openCpZone", "openCommonLink", "mathId", "mode", "gameType", "matchGame", "(IIII)V", "exitToMainActivity", "filePath", "Ljava/io/File;", "getFile", "(Ljava/lang/String;)Ljava/io/File;", "openTask", "openPraise", "openSVIP", "openAristocracyBag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSensitiveList", "()Ljava/util/ArrayList;", "str", "checkSensitive", "(Ljava/lang/String;)Z", "openAristocracy", "showRelationDialog", "Lcom/qiahao/base_common/model/im/RelationMessageData;", "openRelationDialog", "(Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/im/RelationMessageData;)V", "checkStrangerGroupFromSDK", "checkStrangerGroupFromService", "openGameLevel", "openBaiShunH5", "", "throwable", "recordException", "(Ljava/lang/Throwable;)V", "recordLog", "openBaiShunCenter", "openPeopleCertification", "gameIcon", "(I)Ljava/lang/Integer;", "getServerTime", "num", "formatNumber", "(J)Ljava/lang/String;", "changeCommunityServer", "folder", "uploadFile", "isVideo", "current", "total", "progressListener", "Lio/reactivex/rxjava3/core/i0;", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/io/File;ZLkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/i0;", "roomMessageTab", "()I", "messageTab", "changeRoomMessageTab", FirebaseAnalytics.Param.LEVEL, "isCharm", "isWealth", "isActivity", "getLevelBg", "(JZZZ)I", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface AppService {
    void changeCommunityServer(@NotNull String url);

    void changeRoomMessageTab(int messageTab);

    boolean checkSensitive(@NotNull String str);

    boolean checkServerDebug();

    boolean checkStrangerGroupFromSDK(@NotNull String groupId);

    boolean checkStrangerGroupFromService(@NotNull String groupId);

    void exitToMainActivity();

    @Nullable
    MultiGiftData findGiftByGiftId(long giftId);

    @NotNull
    String formatNumber(long num);

    @Nullable
    Integer gameIcon(int gameType);

    @NotNull
    String getAuthenticationToken();

    double getDiamond();

    @Nullable
    File getFile(@NotNull String filePath);

    long getId();

    int getLevelBg(long level, boolean isCharm, boolean isWealth, boolean isActivity);

    int getNobleDrawableRes(int nobleLevel);

    @NotNull
    ArrayList<String> getSensitiveList();

    long getServerTime();

    @NotNull
    String getSimOperator();

    @Nullable
    User getUser();

    @NotNull
    String getUserExternalId();

    boolean isAuthenticated();

    void joinLive(@NotNull String groupId);

    void logout(boolean isSendEvent);

    void matchGame(int mathId, int gameId, int mode, int gameType);

    void newStartVideo(@NotNull Context context, @NotNull String externalId, @Nullable Function2<? super String, ? super Boolean, Unit> likeListener, @Nullable Function0<Unit> startVideo);

    void onEvent(@NotNull String event, @NotNull HashMap<String, Object> values);

    void openActivityDetail(@NotNull String id);

    void openAristocracy();

    void openAristocracyBag();

    void openBaiShunCenter();

    void openBaiShunH5(@NotNull String url);

    void openCommonLink(@NotNull String url);

    void openCpDialog(@NotNull User user, @NotNull String msg);

    void openCpZone(@NotNull String externalId);

    void openDefaultBrowser(@NotNull String url);

    void openFamily(long familyID);

    void openGameLevel();

    void openGemStore();

    void openGroupSupport(@NotNull String groupId);

    void openH5(@NotNull String url);

    void openHorizontalH5(@NotNull String url);

    void openLevelActivity(@NotNull String url);

    void openMemorial();

    void openPeopleCertification();

    void openPersonPage(@NotNull String externalId);

    void openPraise();

    void openRelationDialog(@NotNull User user, @NotNull RelationMessageData data);

    void openSVIP();

    void openSheep(int matchId, int gameId);

    void openTask();

    void openWallet();

    void recordException(@Nullable Throwable throwable);

    void recordLog(@NotNull String str);

    void refreshDiamondOrGem(double diamonds, double pinkDiamondNum);

    void refreshLikeCount(int likeCount);

    int roomMessageTab();

    void roomOpenUserInfo(@NotNull String externalId);

    void setAuthenticationToken(@NotNull String token);

    void showChatGiftDialog(@NotNull FragmentManager fragmentManager, @NotNull User user, @NotNull SendGiftListener listener, @Nullable String groupId, @Nullable Boolean isStrange);

    void showCpDialog(@NotNull OnCommonDialogListener listener, @NotNull String tip);

    void showErrorTipDialog(@NotNull ErrorResponse data);

    void showImageOrSvga(@NotNull String url, @NotNull String svgaUrl);

    void showRelationDialog(@NotNull OnCommonDialogListener listener, @NotNull String tip);

    void showUpdateDialog();

    void showVipDialog(int position);

    void startMyBag();

    void startWallet();

    void toChat(@NotNull String externalId);

    @NotNull
    i0<Pair<Boolean, String>> uploadFile(@Nullable String folder, @NotNull File uploadFile, boolean isVideo, @Nullable Function2<? super Long, ? super Long, Unit> progressListener);

    void videoCall(@NotNull String externalId);
}
