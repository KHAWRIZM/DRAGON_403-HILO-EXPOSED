package com.qiahao.nextvideo.room.luckyfruit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.foodie.FoodieRepeat;
import com.qiahao.nextvideo.data.foodie.FoodieRepeatItem;
import com.qiahao.nextvideo.data.model.LuckyFruitBetBean;
import com.qiahao.nextvideo.data.model.LuckyFruitGameDetailBean;
import com.qiahao.nextvideo.data.model.LuckyFruitGameTop3;
import com.qiahao.nextvideo.data.model.LuckyFruitRation;
import com.qiahao.nextvideo.data.model.LuckyFruitResultList;
import com.qiahao.nextvideo.data.model.LuckyFruitResultListItemBean;
import com.qiahao.nextvideo.data.model.MyStake;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewChatRoomGameLuckyFruitBinding;
import com.qiahao.nextvideo.databinding.ViewChatRoomGameLuckyFruitResultBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.luckyfruit.LuckyGridViewAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 j2\u00020\u0001:\u0001jB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\bJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\bJ\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\bJ\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\bJ\u0019\u0010$\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\bJ\u0019\u0010'\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b'\u0010%J\u0019\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(H\u0014¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0006¢\u0006\u0004\b,\u0010\bJ\u000f\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010\bJ\u000f\u0010.\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010\bJ\r\u0010/\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\bJ\u0015\u00100\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b0\u0010\u001dJ\u001d\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\n2\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0006¢\u0006\u0004\b5\u0010\bJ\r\u00106\u001a\u00020\u0006¢\u0006\u0004\b6\u0010\bJ\r\u00107\u001a\u00020\u0006¢\u0006\u0004\b7\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00108\u001a\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010C\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010JR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010ZR$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010d\u001a\u00020c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "", "initObserve", "()V", "initStyle", "", "getSelectMoney", "()I", "resultId", "refreshAdapter", "(I)V", "updateUserDiamond", "", ExchangeDetailActivity.TYPE_DIAMOND, "showDiamond", "(J)V", "getGameResultList", "fruitId", "position", "placeBet", "(II)V", "Lcom/qiahao/nextvideo/data/model/LuckyFruitGameDetailBean;", "data", "showResultView", "(Lcom/qiahao/nextvideo/data/model/LuckyFruitGameDetailBean;)V", "setResultViewAnim", "stopResultTimeCount", "formSocketTellMeFruitResult", "getRoundResult", "fruitRepeatData", "Lcom/qiahao/nextvideo/data/foodie/FoodieRepeat;", "showRepeatDialog", "(Lcom/qiahao/nextvideo/data/foodie/FoodieRepeat;)V", "fruitRepeat", "refreshRepeat", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViewAndEvent", "show", "dismiss", "release", "refreshData", "", "msg", "placeBetError", "(ILjava/lang/String;)V", "getGameDetails", "commonDialogShow", "gotoPurcharseView", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Landroid/view/animation/RotateAnimation;", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitAdapter;", "fruitAdapter", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitAdapter;", "mBettingTime", "J", "mLuckyFruitGameDetailBean", "Lcom/qiahao/nextvideo/data/model/LuckyFruitGameDetailBean;", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitResultAdapter;", "resultAdapter", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitResultAdapter;", "", "isReload", "Z", "Lkotlinx/coroutines/CoroutineScope;", "dialogScope", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitPlaceBetConfirmDialog;", "confirmDialog", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitPlaceBetConfirmDialog;", "isConfirmAgain", "Lcom/qiahao/nextvideo/databinding/ViewChatRoomGameLuckyFruitBinding;", "mDatabing", "Lcom/qiahao/nextvideo/databinding/ViewChatRoomGameLuckyFruitBinding;", "Lnd/c;", "resultViewDisposable", "Lnd/c;", "Landroid/view/animation/Animation;", "resultViewInAnim", "Landroid/view/animation/Animation;", "resultViewOutAnim", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialogListener;", "mLuckyFruitDialogListener", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialogListener;", "getMLuckyFruitDialogListener", "()Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialogListener;", "setMLuckyFruitDialogListener", "(Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialogListener;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyFruitDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyFruitDialog.kt\ncom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1156:1\n1#2:1157\n61#3,9:1158\n1878#4,3:1167\n1869#4,2:1170\n1869#4,2:1172\n1869#4,2:1174\n*S KotlinDebug\n*F\n+ 1 LuckyFruitDialog.kt\ncom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialog\n*L\n482#1:1158,9\n620#1:1167,3\n1092#1:1170,2\n639#1:1172,2\n760#1:1174,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitDialog extends AppCompatDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "LuckyFruitDialog";

    @Nullable
    private LuckyFruitPlaceBetConfirmDialog confirmDialog;

    @NotNull
    private final CoroutineScope dialogScope;

    @Nullable
    private LuckyFruitAdapter fruitAdapter;
    private boolean isConfirmAgain;
    private boolean isReload;
    private long mBettingTime;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private final Context mContext;

    @Nullable
    private ViewChatRoomGameLuckyFruitBinding mDatabing;

    @Nullable
    private LuckyFruitDialogListener mLuckyFruitDialogListener;

    @Nullable
    private LuckyFruitGameDetailBean mLuckyFruitGameDetailBean;

    @Nullable
    private LuckyFruitResultAdapter resultAdapter;

    @Nullable
    private nd.c resultViewDisposable;

    @Nullable
    private Animation resultViewInAnim;

    @Nullable
    private Animation resultViewOutAnim;

    @NotNull
    private final RotateAnimation rotateAnimation;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitDialog$Companion;", "", "<init>", "()V", "TAG", "", "getResultDrawable", "Landroid/graphics/drawable/Drawable;", "resultId", "", "getGoldBg", "gold", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Drawable getGoldBg(int gold) {
            switch (gold) {
                case 50:
                    Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity, R.drawable.chat_room_lucky_fruit_gold1_selector);
                case 100:
                    Activity currentActivity2 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity2 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity2, R.drawable.chat_room_lucky_fruit_gold2_selector);
                case 1000:
                    Activity currentActivity3 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity3 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity3, R.drawable.chat_room_lucky_fruit_gold3_selector);
                case 10000:
                    Activity currentActivity4 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity4 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity4, R.drawable.chat_room_lucky_fruit_gold4_selector);
                case 100000:
                    Activity currentActivity5 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity5 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity5, R.drawable.chat_room_lucky_fruit_gold5_selector);
                case 500000:
                    Activity currentActivity6 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity6 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity6, R.drawable.chat_room_lucky_fruit_gold6_selector);
                case 1000000:
                    Activity currentActivity7 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity7 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity7, R.drawable.chat_room_lucky_fruit_gold7_selector);
                case 3000000:
                    Activity currentActivity8 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity8 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity8, R.drawable.chat_room_lucky_fruit_gold8_selector);
                case 5000000:
                    Activity currentActivity9 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity9 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity9, R.drawable.chat_room_lucky_fruit_gold9_selector);
                case 10000000:
                    Activity currentActivity10 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity10 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity10, R.drawable.chat_room_lucky_fruit_gold10_selector);
                case 100000000:
                    Activity currentActivity11 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity11 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity11, R.drawable.chat_room_lucky_fruit_gold11_selector);
                default:
                    return null;
            }
        }

        @Nullable
        public final Drawable getResultDrawable(int resultId) {
            switch (resultId) {
                case 1:
                    Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity, R.drawable.chat_room_lucky_fruit_item1);
                case 2:
                    Activity currentActivity2 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity2 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity2, R.drawable.chat_room_lucky_fruit_item2);
                case 3:
                    Activity currentActivity3 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity3 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity3, R.drawable.chat_room_lucky_fruit_item3);
                case 4:
                    Activity currentActivity4 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity4 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity4, R.drawable.chat_room_lucky_fruit_item4);
                case 5:
                    Activity currentActivity5 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity5 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity5, R.drawable.chat_room_lucky_fruit_item5);
                case 6:
                    Activity currentActivity6 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity6 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity6, R.drawable.chat_room_lucky_fruit_item6);
                case 7:
                    Activity currentActivity7 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity7 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity7, R.drawable.chat_room_lucky_fruit_item7);
                case 8:
                    Activity currentActivity8 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity8 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity8, R.drawable.chat_room_lucky_fruit_item8);
                default:
                    Activity currentActivity9 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity9 == null) {
                        return null;
                    }
                    return r1.a.b(currentActivity9, R.drawable.fruit_no_icon);
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyFruitDialog(@NotNull Context context) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(5000L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.rotateAnimation = rotateAnimation;
        this.dialogScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.isConfirmAgain = !MeetingRoomManager.INSTANCE.getLuckyFruitConfirm();
        this.mCompositeDisposable = new nd.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void formSocketTellMeFruitResult() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getFruitMachineDetail(), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.k
            public final Object invoke(Object obj) {
                Unit formSocketTellMeFruitResult$lambda$50;
                formSocketTellMeFruitResult$lambda$50 = LuckyFruitDialog.formSocketTellMeFruitResult$lambda$50(LuckyFruitDialog.this, (ApiResponse) obj);
                return formSocketTellMeFruitResult$lambda$50;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.l
            public final Object invoke(Object obj) {
                Unit formSocketTellMeFruitResult$lambda$51;
                formSocketTellMeFruitResult$lambda$51 = LuckyFruitDialog.formSocketTellMeFruitResult$lambda$51((Throwable) obj);
                return formSocketTellMeFruitResult$lambda$51;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit formSocketTellMeFruitResult$lambda$50(LuckyFruitDialog luckyFruitDialog, ApiResponse apiResponse) {
        Integer num;
        LuckyFruitGameDetailBean luckyFruitGameDetailBean;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LuckyFruitGameDetailBean luckyFruitGameDetailBean2 = (LuckyFruitGameDetailBean) apiResponse.getData();
        if (luckyFruitGameDetailBean2 != null) {
            if (luckyFruitGameDetailBean2.getStatus() != 2) {
                Log.d(TAG, "formSocketTellMeFruitResult: 状态不为2");
                luckyFruitDialog.refreshData(luckyFruitGameDetailBean2);
            } else {
                Log.d(TAG, "formSocketTellMeFruitResult: 状态为2");
                LuckyFruitGameDetailBean luckyFruitGameDetailBean3 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean3 != null) {
                    Integer num2 = null;
                    if (luckyFruitGameDetailBean3 != null) {
                        num = Integer.valueOf(luckyFruitGameDetailBean3.getStatus());
                    } else {
                        num = null;
                    }
                    int round = luckyFruitGameDetailBean2.getRound();
                    LuckyFruitGameDetailBean luckyFruitGameDetailBean4 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                    if (luckyFruitGameDetailBean4 != null) {
                        num2 = Integer.valueOf(luckyFruitGameDetailBean4.getRound());
                    }
                    Log.d(TAG, "formSocketTellMeFruitResult: 当前轮次状态" + num + " " + round + "  " + num2);
                    LuckyFruitGameDetailBean luckyFruitGameDetailBean5 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                    if (luckyFruitGameDetailBean5 != null && luckyFruitGameDetailBean5.getStatus() == 2 && (luckyFruitGameDetailBean = luckyFruitDialog.mLuckyFruitGameDetailBean) != null && luckyFruitGameDetailBean2.getRound() == luckyFruitGameDetailBean.getRound()) {
                        luckyFruitDialog.mLuckyFruitGameDetailBean = luckyFruitGameDetailBean2;
                        LuckyFruitAdapter luckyFruitAdapter = luckyFruitDialog.fruitAdapter;
                        if (luckyFruitAdapter != null) {
                            luckyFruitAdapter.setResult(luckyFruitGameDetailBean2.getFruitId());
                        }
                    } else {
                        luckyFruitDialog.refreshData(luckyFruitGameDetailBean2);
                    }
                } else {
                    luckyFruitDialog.refreshData(luckyFruitGameDetailBean2);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit formSocketTellMeFruitResult$lambda$51(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fruitRepeat() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().fruitRepeat(), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.r
            public final Object invoke(Object obj) {
                Unit fruitRepeat$lambda$61;
                fruitRepeat$lambda$61 = LuckyFruitDialog.fruitRepeat$lambda$61(LuckyFruitDialog.this, (ApiResponse) obj);
                return fruitRepeat$lambda$61;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.s
            public final Object invoke(Object obj) {
                Unit fruitRepeat$lambda$62;
                fruitRepeat$lambda$62 = LuckyFruitDialog.fruitRepeat$lambda$62(LuckyFruitDialog.this, (Throwable) obj);
                return fruitRepeat$lambda$62;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fruitRepeat$lambda$61(LuckyFruitDialog luckyFruitDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        luckyFruitDialog.refreshRepeat((FoodieRepeat) apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit fruitRepeat$lambda$62(LuckyFruitDialog luckyFruitDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 4000) {
                luckyFruitDialog.commonDialogShow();
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = luckyFruitDialog.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(luckyFruitDialog, 2131952667);
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
    public final void fruitRepeatData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().fruitRepeatData(), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.o
            public final Object invoke(Object obj) {
                Unit fruitRepeatData$lambda$58;
                fruitRepeatData$lambda$58 = LuckyFruitDialog.fruitRepeatData$lambda$58(LuckyFruitDialog.this, (ApiResponse) obj);
                return fruitRepeatData$lambda$58;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.p
            public final Object invoke(Object obj) {
                Unit fruitRepeatData$lambda$59;
                fruitRepeatData$lambda$59 = LuckyFruitDialog.fruitRepeatData$lambda$59(LuckyFruitDialog.this, (Throwable) obj);
                return fruitRepeatData$lambda$59;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fruitRepeatData$lambda$58(LuckyFruitDialog luckyFruitDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        luckyFruitDialog.showRepeatDialog((FoodieRepeat) apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit fruitRepeatData$lambda$59(LuckyFruitDialog luckyFruitDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = luckyFruitDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(luckyFruitDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameDetails$lambda$56(LuckyFruitDialog luckyFruitDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LuckyFruitGameDetailBean luckyFruitGameDetailBean = (LuckyFruitGameDetailBean) apiResponse.getData();
        if (luckyFruitGameDetailBean != null) {
            luckyFruitDialog.refreshData(luckyFruitGameDetailBean);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameDetails$lambda$57(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void getGameResultList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getFruitMachineHistory(), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.m
            public final Object invoke(Object obj) {
                Unit gameResultList$lambda$27;
                gameResultList$lambda$27 = LuckyFruitDialog.getGameResultList$lambda$27(LuckyFruitDialog.this, (ApiResponse) obj);
                return gameResultList$lambda$27;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.n
            public final Object invoke(Object obj) {
                Unit gameResultList$lambda$28;
                gameResultList$lambda$28 = LuckyFruitDialog.getGameResultList$lambda$28((Throwable) obj);
                return gameResultList$lambda$28;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameResultList$lambda$27(LuckyFruitDialog luckyFruitDialog, ApiResponse apiResponse) {
        List<LuckyFruitResultListItemBean> list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LuckyFruitResultAdapter luckyFruitResultAdapter = luckyFruitDialog.resultAdapter;
        if (luckyFruitResultAdapter != null) {
            LuckyFruitResultList luckyFruitResultList = (LuckyFruitResultList) apiResponse.getData();
            if (luckyFruitResultList != null) {
                list = luckyFruitResultList.getList();
            } else {
                list = null;
            }
            luckyFruitResultAdapter.setList(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameResultList$lambda$28(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void getRoundResult() {
        int i;
        ServerApi apis = AppServer.INSTANCE.getApis();
        LuckyFruitGameDetailBean luckyFruitGameDetailBean = this.mLuckyFruitGameDetailBean;
        if (luckyFruitGameDetailBean != null) {
            i = luckyFruitGameDetailBean.getRound();
        } else {
            i = 0;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.getRoundFruitMachineDetail(i), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.h
            public final Object invoke(Object obj) {
                Unit roundResult$lambda$53;
                roundResult$lambda$53 = LuckyFruitDialog.getRoundResult$lambda$53(LuckyFruitDialog.this, (ApiResponse) obj);
                return roundResult$lambda$53;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.i
            public final Object invoke(Object obj) {
                Unit roundResult$lambda$54;
                roundResult$lambda$54 = LuckyFruitDialog.getRoundResult$lambda$54((Throwable) obj);
                return roundResult$lambda$54;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getRoundResult$lambda$53(LuckyFruitDialog luckyFruitDialog, ApiResponse apiResponse) {
        Integer num;
        LuckyFruitGameDetailBean luckyFruitGameDetailBean;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LuckyFruitGameDetailBean luckyFruitGameDetailBean2 = (LuckyFruitGameDetailBean) apiResponse.getData();
        if (luckyFruitGameDetailBean2 != null) {
            luckyFruitDialog.refreshAdapter(luckyFruitGameDetailBean2.getFruitId());
            if (luckyFruitGameDetailBean2.getStatus() != 2) {
                Log.d(TAG, "formSocketTellMeFruitResult: 状态不为2");
                luckyFruitDialog.refreshData(luckyFruitGameDetailBean2);
            } else {
                Log.d(TAG, "formSocketTellMeFruitResult: 状态为2");
                LuckyFruitGameDetailBean luckyFruitGameDetailBean3 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean3 != null) {
                    Integer num2 = null;
                    if (luckyFruitGameDetailBean3 != null) {
                        num = Integer.valueOf(luckyFruitGameDetailBean3.getStatus());
                    } else {
                        num = null;
                    }
                    int round = luckyFruitGameDetailBean2.getRound();
                    LuckyFruitGameDetailBean luckyFruitGameDetailBean4 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                    if (luckyFruitGameDetailBean4 != null) {
                        num2 = Integer.valueOf(luckyFruitGameDetailBean4.getRound());
                    }
                    Log.d(TAG, "formSocketTellMeFruitResult: 当前轮次状态" + num + " " + round + "  " + num2);
                    LuckyFruitGameDetailBean luckyFruitGameDetailBean5 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                    if (luckyFruitGameDetailBean5 != null && luckyFruitGameDetailBean5.getStatus() == 2 && (luckyFruitGameDetailBean = luckyFruitDialog.mLuckyFruitGameDetailBean) != null && luckyFruitGameDetailBean2.getRound() == luckyFruitGameDetailBean.getRound()) {
                        luckyFruitDialog.mLuckyFruitGameDetailBean = luckyFruitGameDetailBean2;
                        LuckyFruitAdapter luckyFruitAdapter = luckyFruitDialog.fruitAdapter;
                        if (luckyFruitAdapter != null) {
                            luckyFruitAdapter.setResult(luckyFruitGameDetailBean2.getFruitId());
                        }
                    } else {
                        luckyFruitDialog.refreshData(luckyFruitGameDetailBean2);
                    }
                } else {
                    luckyFruitDialog.refreshData(luckyFruitGameDetailBean2);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getRoundResult$lambda$54(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000f. Please report as an issue. */
    public final int getSelectMoney() {
        RadioGroup radioGroup;
        List<Integer> betNums;
        int intValue;
        List<Integer> betNums2;
        List<Integer> betNums3;
        List<Integer> betNums4;
        List<Integer> betNums5;
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding == null || (radioGroup = viewChatRoomGameLuckyFruitBinding.rgGold) == null) {
            return 1;
        }
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_gold1 /* 2131364450 */:
                LuckyFruitGameDetailBean luckyFruitGameDetailBean = this.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean != null && (betNums = luckyFruitGameDetailBean.getBetNums()) != null) {
                    intValue = betNums.get(0).intValue();
                    return intValue;
                }
                return 10;
            case R.id.rb_gold2 /* 2131364451 */:
                LuckyFruitGameDetailBean luckyFruitGameDetailBean2 = this.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean2 != null && (betNums2 = luckyFruitGameDetailBean2.getBetNums()) != null) {
                    intValue = betNums2.get(1).intValue();
                    return intValue;
                }
                return 10;
            case R.id.rb_gold3 /* 2131364452 */:
                LuckyFruitGameDetailBean luckyFruitGameDetailBean3 = this.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean3 != null && (betNums3 = luckyFruitGameDetailBean3.getBetNums()) != null) {
                    intValue = betNums3.get(2).intValue();
                    return intValue;
                }
                return 10;
            case R.id.rb_gold4 /* 2131364453 */:
                LuckyFruitGameDetailBean luckyFruitGameDetailBean4 = this.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean4 != null && (betNums4 = luckyFruitGameDetailBean4.getBetNums()) != null) {
                    intValue = betNums4.get(3).intValue();
                    return intValue;
                }
                return 10;
            case R.id.rb_gold5 /* 2131364454 */:
                LuckyFruitGameDetailBean luckyFruitGameDetailBean5 = this.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean5 != null && (betNums5 = luckyFruitGameDetailBean5.getBetNums()) != null) {
                    intValue = betNums5.get(4).intValue();
                    return intValue;
                }
                return 10;
            default:
                return 10;
        }
    }

    private final void initObserve() {
        BuildersKt.launch$default(this.dialogScope, Dispatchers.getMain(), (CoroutineStart) null, new LuckyFruitDialog$initObserve$1(this, null), 2, (Object) null);
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().filter(new pd.q() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$initObserve$2
            public final boolean test(UserObjectEvent userObjectEvent) {
                return userObjectEvent.isAuthenticated() && (userObjectEvent.getType() == UserObjectEventType.REFRESH || userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY);
            }
        }).observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$initObserve$3
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0007, code lost:
            
                r0 = r3.this$0.mDatabing;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void accept(UserObjectEvent userObjectEvent) {
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding;
                DiamondTickTextView diamondTickTextView;
                try {
                    User user = userObjectEvent.getUser();
                    if (user == null || viewChatRoomGameLuckyFruitBinding == null || (diamondTickTextView = viewChatRoomGameLuckyFruitBinding.diamondCountTickTextView) == null) {
                        return;
                    }
                    diamondTickTextView.setText((long) user.getDiamondNum());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.mCompositeDisposable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStyle() {
        setCanceledOnTouchOutside(true);
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setWindowAnimations(R.style.dialog_for_bottom_in_out_anim);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setDimAmount(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r2.getStatus() == 1) goto L٢٠;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initViewAndEvent$lambda$14$lambda$13(LuckyFruitDialog luckyFruitDialog, int i, boolean z) {
        TextView textView;
        boolean z2;
        int i2;
        boolean z3;
        LuckyFruitGameDetailBean luckyFruitGameDetailBean = luckyFruitDialog.mLuckyFruitGameDetailBean;
        if (luckyFruitGameDetailBean != null) {
            luckyFruitGameDetailBean.setStatus(2);
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = luckyFruitDialog.mDatabing;
        int i3 = 0;
        if (viewChatRoomGameLuckyFruitBinding != null && (textView = viewChatRoomGameLuckyFruitBinding.repeat) != null) {
            Context context = luckyFruitDialog.getContext();
            LuckyFruitGameDetailBean luckyFruitGameDetailBean2 = luckyFruitDialog.mLuckyFruitGameDetailBean;
            if (luckyFruitGameDetailBean2 != null) {
                z2 = Intrinsics.areEqual(luckyFruitGameDetailBean2.getAutoBet(), Boolean.FALSE);
            } else {
                z2 = false;
            }
            if (z2) {
                LuckyFruitGameDetailBean luckyFruitGameDetailBean3 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean3 != null) {
                    z3 = true;
                }
                z3 = false;
                if (z3) {
                    i2 = R.drawable.fruit_repeat_bg;
                    textView.setBackground(androidx.core.content.a.getDrawable(context, i2));
                }
            }
            i2 = R.drawable.fruit_repeat_bg_default;
            textView.setBackground(androidx.core.content.a.getDrawable(context, i2));
        }
        if (!z) {
            LuckyFruitGameDetailBean luckyFruitGameDetailBean4 = luckyFruitDialog.mLuckyFruitGameDetailBean;
            if (luckyFruitGameDetailBean4 != null) {
                i3 = luckyFruitGameDetailBean4.getFruitId();
            }
            if (i3 == 0) {
                luckyFruitDialog.getRoundResult();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initViewAndEvent$lambda$16(LuckyFruitDialog luckyFruitDialog, View view) {
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            Context context = luckyFruitDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new LuckyFruitRuleDialog(context, 0, 2, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initViewAndEvent$lambda$17(LuckyFruitDialog luckyFruitDialog, View view) {
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            Context context = luckyFruitDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new LuckyFruitRecordDialog(context, 0, 2, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initViewAndEvent$lambda$18(LuckyFruitDialog luckyFruitDialog, View view) {
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            Context context = luckyFruitDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            new LuckyFruitRankingDialog(context, 0, 2, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewAndEvent$lambda$19(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewAndEvent$lambda$2(LuckyFruitDialog luckyFruitDialog) {
        LuckyBaseGridView luckyBaseGridView;
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = luckyFruitDialog.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding != null && (luckyBaseGridView = viewChatRoomGameLuckyFruitBinding.luckyView) != null) {
            luckyBaseGridView.setAdapter(luckyFruitDialog.fruitAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initViewAndEvent$lambda$20(LuckyFruitDialog luckyFruitDialog, View view) {
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            WalletActivity.Companion companion = WalletActivity.INSTANCE;
            Context context = luckyFruitDialog.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.start(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void placeBet(final int fruitId, final int position) {
        double d;
        final int selectMoney = getSelectMoney();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (d >= selectMoney) {
            LuckyFruitAdapter luckyFruitAdapter = this.fruitAdapter;
            if (luckyFruitAdapter != null) {
                luckyFruitAdapter.showPlaceBetProgress(position, true);
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().setFruitMachineBet(fruitId, selectMoney), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.w
                public final Object invoke(Object obj) {
                    Unit placeBet$lambda$36;
                    placeBet$lambda$36 = LuckyFruitDialog.placeBet$lambda$36(LuckyFruitDialog.this, fruitId, selectMoney, (ApiResponse) obj);
                    return placeBet$lambda$36;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.x
                public final Object invoke(Object obj) {
                    Unit placeBet$lambda$37;
                    placeBet$lambda$37 = LuckyFruitDialog.placeBet$lambda$37(LuckyFruitDialog.this, position, (Throwable) obj);
                    return placeBet$lambda$37;
                }
            }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
            return;
        }
        commonDialogShow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit placeBet$lambda$36(LuckyFruitDialog luckyFruitDialog, int i, int i2, ApiResponse apiResponse) {
        Integer num;
        MyStake myStake;
        LuckyFruitAdapter luckyFruitAdapter;
        Long ts;
        long j;
        double d;
        long j2;
        ArrayList<MyStake> arrayList;
        Iterator<MyStake> it;
        long j3;
        ArrayList<MyStake> myStake2;
        long j4;
        ArrayList<MyStake> myStake3;
        LuckyFruitGameDetailBean luckyFruitGameDetailBean;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LuckyFruitBetBean luckyFruitBetBean = (LuckyFruitBetBean) apiResponse.getData();
        if (luckyFruitBetBean != null) {
            LuckyFruitGameDetailBean luckyFruitGameDetailBean2 = luckyFruitDialog.mLuckyFruitGameDetailBean;
            Double d2 = null;
            if (luckyFruitGameDetailBean2 != null) {
                num = Integer.valueOf(luckyFruitGameDetailBean2.getRound());
            } else {
                num = null;
            }
            if (!Intrinsics.areEqual(num, luckyFruitBetBean.getRound())) {
                return Unit.INSTANCE;
            }
            long j5 = 0;
            try {
                LuckyFruitGameDetailBean luckyFruitGameDetailBean3 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean3 != null) {
                    arrayList = luckyFruitGameDetailBean3.getMyStake();
                } else {
                    arrayList = null;
                }
                if (arrayList == null && (luckyFruitGameDetailBean = luckyFruitDialog.mLuckyFruitGameDetailBean) != null) {
                    luckyFruitGameDetailBean.setMyStake(new ArrayList<>());
                }
                LuckyFruitGameDetailBean luckyFruitGameDetailBean4 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean4 != null && (myStake3 = luckyFruitGameDetailBean4.getMyStake()) != null) {
                    it = myStake3.iterator();
                } else {
                    it = null;
                }
                boolean z = false;
                myStake = null;
                while (it != null) {
                    try {
                        if (!it.hasNext()) {
                            break;
                        }
                        MyStake next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        MyStake myStake4 = next;
                        if (myStake4.getFruitId() == i) {
                            long stake = myStake4.getStake();
                            Long amount = luckyFruitBetBean.getAmount();
                            if (amount != null) {
                                j4 = amount.longValue();
                            } else {
                                j4 = 0;
                            }
                            myStake4.setStake(stake + j4);
                            myStake = myStake4;
                            z = true;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        luckyFruitAdapter = luckyFruitDialog.fruitAdapter;
                        if (luckyFruitAdapter != null) {
                        }
                        ts = luckyFruitBetBean.getTs();
                        if (ts != null) {
                        }
                        if (j <= luckyFruitDialog.mBettingTime) {
                        }
                    }
                }
                if (!z) {
                    Long amount2 = luckyFruitBetBean.getAmount();
                    if (amount2 != null) {
                        j3 = amount2.longValue();
                    } else {
                        j3 = 0;
                    }
                    MyStake myStake5 = new MyStake(i, j3);
                    try {
                        LuckyFruitGameDetailBean luckyFruitGameDetailBean5 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                        if (luckyFruitGameDetailBean5 != null && (myStake2 = luckyFruitGameDetailBean5.getMyStake()) != null) {
                            myStake2.add(myStake5);
                        }
                        myStake = myStake5;
                    } catch (Exception e2) {
                        myStake = myStake5;
                        e = e2;
                        e.printStackTrace();
                        luckyFruitAdapter = luckyFruitDialog.fruitAdapter;
                        if (luckyFruitAdapter != null) {
                        }
                        ts = luckyFruitBetBean.getTs();
                        if (ts != null) {
                        }
                        if (j <= luckyFruitDialog.mBettingTime) {
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                myStake = null;
            }
            luckyFruitAdapter = luckyFruitDialog.fruitAdapter;
            if (luckyFruitAdapter != null) {
                if (myStake != null) {
                    j2 = myStake.getStake();
                } else {
                    j2 = 0;
                }
                luckyFruitAdapter.placeBet(i, j2);
            }
            ts = luckyFruitBetBean.getTs();
            if (ts != null) {
                j = ts.longValue();
            } else {
                j = 0;
            }
            if (j <= luckyFruitDialog.mBettingTime) {
                return Unit.INSTANCE;
            }
            Long ts2 = luckyFruitBetBean.getTs();
            if (ts2 != null) {
                j5 = ts2.longValue();
            }
            luckyFruitDialog.mBettingTime = j5;
            UserStore.Companion companion = UserStore.INSTANCE;
            User user = companion.getShared().getUser();
            if (user != null) {
                d2 = Double.valueOf(user.getDiamondNum());
            }
            if (!Intrinsics.areEqual(d2, luckyFruitBetBean.getDiamondNum())) {
                UserStore shared = companion.getShared();
                User user2 = companion.getShared().getUser();
                if (user2 != null) {
                    d = user2.getDiamondNum();
                } else {
                    d = 0.0d;
                }
                UserStore.refreshDiamondOrGem$default(shared, d - i2, 0.0d, 2, null);
                luckyFruitDialog.showDiamond(luckyFruitBetBean.getDiamondNum());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit placeBet$lambda$37(LuckyFruitDialog luckyFruitDialog, int i, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloException hiloException = (HiloException) th;
        if (hiloException.getCode() != 1013) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = luckyFruitDialog.getContext();
            String localizedMessage = hiloException.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = ResourcesKtxKt.getStringById(luckyFruitDialog, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        luckyFruitDialog.placeBetError(i, "");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshAdapter(int resultId) {
        String str;
        int i;
        RecyclerView recyclerView;
        LuckyFruitResultAdapter luckyFruitResultAdapter = this.resultAdapter;
        if (luckyFruitResultAdapter != null) {
            if (luckyFruitResultAdapter.getData().size() >= 20) {
                luckyFruitResultAdapter.removeAt(luckyFruitResultAdapter.getData().size() - 1);
            }
            LuckyFruitGameDetailBean luckyFruitGameDetailBean = this.mLuckyFruitGameDetailBean;
            if (luckyFruitGameDetailBean != null) {
                if (luckyFruitGameDetailBean == null || (str = luckyFruitGameDetailBean.getDate()) == null) {
                    str = "";
                }
                String str2 = str;
                LuckyFruitGameDetailBean luckyFruitGameDetailBean2 = this.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean2 != null) {
                    i = luckyFruitGameDetailBean2.getRound();
                } else {
                    i = 0;
                }
                LuckyFruitResultListItemBean luckyFruitResultListItemBean = new LuckyFruitResultListItemBean(str2, resultId, 0L, null, i);
                if (luckyFruitResultAdapter.getData().isEmpty()) {
                    luckyFruitResultAdapter.addData(0, luckyFruitResultListItemBean);
                } else if (((LuckyFruitResultListItemBean) luckyFruitResultAdapter.getData().get(0)).getRound() != luckyFruitGameDetailBean.getRound()) {
                    luckyFruitResultAdapter.addData(0, luckyFruitResultListItemBean);
                }
                if (luckyFruitResultAdapter.getData().size() > 1) {
                    luckyFruitResultAdapter.notifyItemRangeChanged(0, 2);
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding != null && (recyclerView = viewChatRoomGameLuckyFruitBinding.resultRecycler) != null) {
                        recyclerView.scrollToPosition(0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshData$lambda$34(LuckyFruitGameDetailBean luckyFruitGameDetailBean, LuckyFruitDialog luckyFruitDialog) {
        ArrayList<MyStake> myStake = luckyFruitGameDetailBean.getMyStake();
        if (myStake != null && !myStake.isEmpty()) {
            Iterator<MyStake> it = myStake.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MyStake next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MyStake myStake2 = next;
                LuckyFruitAdapter luckyFruitAdapter = luckyFruitDialog.fruitAdapter;
                if (luckyFruitAdapter != null) {
                    luckyFruitAdapter.placeBet(myStake2.getFruitId(), myStake2.getStake());
                }
            }
        }
        List<LuckyFruitRation> ratio = luckyFruitGameDetailBean.getRatio();
        if (ratio != null) {
            for (LuckyFruitRation luckyFruitRation : ratio) {
                LuckyFruitAdapter luckyFruitAdapter2 = luckyFruitDialog.fruitAdapter;
                if (luckyFruitAdapter2 != null) {
                    luckyFruitAdapter2.updateRate(luckyFruitRation.getFruitId(), luckyFruitRation.getRatio());
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        r13 = r13.getAutoBets();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
    
        if (r13 == null) goto L١١٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
    
        r13 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
    
        if (r13.hasNext() == false) goto L٩٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
    
        r3 = (com.qiahao.nextvideo.data.foodie.FoodieRepeatItem) r13.next();
        r4 = r12.mLuckyFruitGameDetailBean;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009d, code lost:
    
        if (r4 == null) goto L٥٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009f, code lost:
    
        r4 = r4.getMyStake();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a3, code lost:
    
        if (r4 == null) goto L٥٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
    
        r4 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
    
        r5 = 0;
        r7 = null;
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ae, code lost:
    
        if (r4 == null) goto L١٠٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:
    
        if (r4.hasNext() != true) goto L١٠٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
    
        r8 = r4.next();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "next(...)");
        r8 = r8;
        r10 = r8.getFruitId();
        r11 = r3.getFruitId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ca, code lost:
    
        if (r11 != null) goto L١٠١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d1, code lost:
    
        if (r10 != r11.intValue()) goto L١٠٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d3, code lost:
    
        r6 = r8.getStake();
        r10 = r3.getStake();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00db, code lost:
    
        if (r10 == null) goto L٦٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dd, code lost:
    
        r10 = r10.longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e3, code lost:
    
        r8.setStake(r6 + r10);
        r7 = r8;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e2, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ea, code lost:
    
        if (r6 != false) goto L٨٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ec, code lost:
    
        r4 = r3.getFruitId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f2, code lost:
    
        if (r4 == null) goto L٧٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f4, code lost:
    
        r4 = r4.intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00fa, code lost:
    
        r3 = r3.getStake();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fe, code lost:
    
        if (r3 == null) goto L٧٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0100, code lost:
    
        r8 = r3.longValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0106, code lost:
    
        r7 = new com.qiahao.nextvideo.data.model.MyStake(r4, r8);
        r3 = r12.mLuckyFruitGameDetailBean;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010b, code lost:
    
        if (r3 == null) goto L٨٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010d, code lost:
    
        r3 = r3.getMyStake();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0111, code lost:
    
        if (r3 == null) goto L٨٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0113, code lost:
    
        r3.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0105, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f9, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0116, code lost:
    
        r3 = r12.fruitAdapter;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0118, code lost:
    
        if (r3 == null) goto L٩٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x011a, code lost:
    
        if (r7 == null) goto L٨٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x011c, code lost:
    
        r5 = r7.getFruitId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0120, code lost:
    
        if (r7 == null) goto L٨٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0122, code lost:
    
        r6 = r7.getStake();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0128, code lost:
    
        r3.placeBet(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0127, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00aa, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshRepeat(FoodieRepeat data) {
        double d;
        long j;
        ArrayList<FoodieRepeatItem> arrayList;
        ArrayList<MyStake> arrayList2;
        LuckyFruitGameDetailBean luckyFruitGameDetailBean;
        Long diamondNum;
        Long diamondNum2;
        TextView textView;
        try {
            LuckyFruitGameDetailBean luckyFruitGameDetailBean2 = this.mLuckyFruitGameDetailBean;
            if (luckyFruitGameDetailBean2 != null) {
                luckyFruitGameDetailBean2.setAutoBet(Boolean.TRUE);
            }
            ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = this.mDatabing;
            if (viewChatRoomGameLuckyFruitBinding != null && (textView = viewChatRoomGameLuckyFruitBinding.repeat) != null) {
                textView.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.fruit_repeat_bg_default));
            }
            UserStore shared = UserStore.INSTANCE.getShared();
            if (data != null && (diamondNum2 = data.getDiamondNum()) != null) {
                d = diamondNum2.longValue();
            } else {
                d = 0.0d;
            }
            UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
            if (data != null && (diamondNum = data.getDiamondNum()) != null) {
                j = diamondNum.longValue();
            } else {
                j = 0;
            }
            showDiamond(j);
            if (data != null) {
                arrayList = data.getAutoBets();
            } else {
                arrayList = null;
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                LuckyFruitGameDetailBean luckyFruitGameDetailBean3 = this.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean3 != null) {
                    arrayList2 = luckyFruitGameDetailBean3.getMyStake();
                } else {
                    arrayList2 = null;
                }
                if ((arrayList2 == null || arrayList2.isEmpty()) && (luckyFruitGameDetailBean = this.mLuckyFruitGameDetailBean) != null) {
                    luckyFruitGameDetailBean.setMyStake(new ArrayList<>());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void setResultViewAnim() {
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding;
        ImageView imageView;
        Animation animation;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding2;
        ImageView imageView2;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding3;
        ConstraintLayout constraintLayout;
        if (this.resultViewInAnim == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130772074);
            this.resultViewInAnim = loadAnimation;
            if (loadAnimation != null) {
                loadAnimation.setFillAfter(true);
            }
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding != null && (viewChatRoomGameLuckyFruitResultBinding3 = viewChatRoomGameLuckyFruitBinding.llResult) != null && (constraintLayout = viewChatRoomGameLuckyFruitResultBinding3.viewResultContent) != null) {
            constraintLayout.setAnimation(this.resultViewInAnim);
        }
        Animation animation2 = this.resultViewInAnim;
        if (animation2 != null) {
            animation2.start();
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding2 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding2 != null && (viewChatRoomGameLuckyFruitResultBinding2 = viewChatRoomGameLuckyFruitBinding2.llResult) != null && (imageView2 = viewChatRoomGameLuckyFruitResultBinding2.resultBgLight) != null) {
            imageView2.setAnimation(this.rotateAnimation);
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding3 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding3 != null && (viewChatRoomGameLuckyFruitResultBinding = viewChatRoomGameLuckyFruitBinding3.llResult) != null && (imageView = viewChatRoomGameLuckyFruitResultBinding.resultBgLight) != null && (animation = imageView.getAnimation()) != null) {
            animation.start();
        }
    }

    private final void showDiamond(long diamond) {
        AppCompatTextView appCompatTextView;
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding != null && (appCompatTextView = viewChatRoomGameLuckyFruitBinding.diamondCountTickTextView) != null) {
            appCompatTextView.setText(String.valueOf(diamond));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showRepeatDialog(FoodieRepeat data) {
        Long l;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (data != null) {
            l = data.getStake();
        } else {
            l = null;
        }
        new FruitConfirmRepeatDialog(context, l).setListener(new Function0() { // from class: com.qiahao.nextvideo.room.luckyfruit.v
            public final Object invoke() {
                Unit showRepeatDialog$lambda$60;
                showRepeatDialog$lambda$60 = LuckyFruitDialog.showRepeatDialog$lambda$60(LuckyFruitDialog.this);
                return showRepeatDialog$lambda$60;
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showRepeatDialog$lambda$60(LuckyFruitDialog luckyFruitDialog) {
        luckyFruitDialog.fruitRepeat();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showResultView(final LuckyFruitGameDetailBean data) {
        Activity activity;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding;
        TextView textView;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding2;
        TextView textView2;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding3;
        TextView textView3;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding4;
        TextView textView4;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding5;
        TextView textView5;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding6;
        TextView textView6;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding7;
        TextView textView7;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding8;
        CircleImageView circleImageView;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding9;
        LinearLayout linearLayout;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding10;
        TextView textView8;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding11;
        TextView textView9;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding12;
        CircleImageView circleImageView2;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding13;
        LinearLayout linearLayout2;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding14;
        TextView textView10;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding15;
        TextView textView11;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding16;
        TextView textView12;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding17;
        CircleImageView circleImageView3;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding18;
        AppCompatImageView appCompatImageView;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding19;
        LinearLayout linearLayout3;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding20;
        TextView textView13;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding21;
        LinearLayout linearLayout4;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding22;
        LinearLayout linearLayout5;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding23;
        LinearLayout linearLayout6;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding24;
        TextView textView14;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding25;
        TextView textView15;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding26;
        TextView textView16;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding27;
        TextView textView17;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding28;
        TextView textView18;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding29;
        TextView textView19;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding30;
        TextView textView20;
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding31;
        ImageView imageView;
        LuckyBaseGridView luckyBaseGridView;
        TextView textView21;
        int i;
        LuckyFruitAdapter luckyFruitAdapter = this.fruitAdapter;
        if (luckyFruitAdapter != null) {
            luckyFruitAdapter.setGameType(3);
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding != null && (textView21 = viewChatRoomGameLuckyFruitBinding.repeat) != null) {
            Context context = getContext();
            if (Intrinsics.areEqual(data.getAutoBet(), Boolean.FALSE) && data.getStatus() == 1) {
                i = R.drawable.fruit_repeat_bg;
            } else {
                i = R.drawable.fruit_repeat_bg_default;
            }
            textView21.setBackground(androidx.core.content.a.getDrawable(context, i));
        }
        Context context2 = getContext();
        if (context2 instanceof Activity) {
            activity = (Activity) context2;
        } else {
            activity = null;
        }
        if (activity != null && (activity.isFinishing() || activity.isDestroyed())) {
            return;
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding2 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding2 != null && (luckyBaseGridView = viewChatRoomGameLuckyFruitBinding2.luckyView) != null) {
            luckyBaseGridView.post(new Runnable() { // from class: com.qiahao.nextvideo.room.luckyfruit.f
                @Override // java.lang.Runnable
                public final void run() {
                    LuckyFruitDialog.showResultView$lambda$42(LuckyFruitGameDetailBean.this, this);
                }
            });
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding3 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding3 != null && (viewChatRoomGameLuckyFruitResultBinding31 = viewChatRoomGameLuckyFruitBinding3.llResult) != null && (imageView = viewChatRoomGameLuckyFruitResultBinding31.resultImage) != null) {
            imageView.setImageDrawable(INSTANCE.getResultDrawable(data.getFruitId()));
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding4 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding4 != null && (viewChatRoomGameLuckyFruitResultBinding30 = viewChatRoomGameLuckyFruitBinding4.llResult) != null && (textView20 = viewChatRoomGameLuckyFruitResultBinding30.resultTvRound) != null) {
            textView20.setText(getContext().getString(2131953977, String.valueOf(data.getRound())));
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding5 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding5 != null && (viewChatRoomGameLuckyFruitResultBinding29 = viewChatRoomGameLuckyFruitBinding5.llResult) != null && (textView19 = viewChatRoomGameLuckyFruitResultBinding29.resultTvRound) != null) {
            ViewUtilitiesKt.setTargetTextColor(textView19, String.valueOf(data.getRound()), Color.parseColor("#ffd998"), Color.parseColor("#fcff00"));
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding6 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding6 != null && (viewChatRoomGameLuckyFruitResultBinding28 = viewChatRoomGameLuckyFruitBinding6.llResult) != null && (textView18 = viewChatRoomGameLuckyFruitResultBinding28.resultTvGold) != null) {
            textView18.setVisibility(8);
        }
        ArrayList<MyStake> myStake = data.getMyStake();
        if (myStake != null && !myStake.isEmpty()) {
            if (data.getMyAward() > 0) {
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding7 = this.mDatabing;
                if (viewChatRoomGameLuckyFruitBinding7 != null && (viewChatRoomGameLuckyFruitResultBinding27 = viewChatRoomGameLuckyFruitBinding7.llResult) != null && (textView17 = viewChatRoomGameLuckyFruitResultBinding27.resultTvHint) != null) {
                    textView17.setText(getContext().getString(2131952361));
                }
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding8 = this.mDatabing;
                if (viewChatRoomGameLuckyFruitBinding8 != null && (viewChatRoomGameLuckyFruitResultBinding26 = viewChatRoomGameLuckyFruitBinding8.llResult) != null && (textView16 = viewChatRoomGameLuckyFruitResultBinding26.resultTvGold) != null) {
                    textView16.setVisibility(0);
                    textView16.setText(NumberUtilsKt.rankNumberFormat(data.getMyAward()));
                }
            } else if (data.getFruitId() <= 0) {
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding9 = this.mDatabing;
                if (viewChatRoomGameLuckyFruitBinding9 != null && (viewChatRoomGameLuckyFruitResultBinding25 = viewChatRoomGameLuckyFruitBinding9.llResult) != null && (textView15 = viewChatRoomGameLuckyFruitResultBinding25.resultTvHint) != null) {
                    textView15.setText(getContext().getString(2131953926));
                }
            } else {
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding10 = this.mDatabing;
                if (viewChatRoomGameLuckyFruitBinding10 != null && (viewChatRoomGameLuckyFruitResultBinding24 = viewChatRoomGameLuckyFruitBinding10.llResult) != null && (textView14 = viewChatRoomGameLuckyFruitResultBinding24.resultTvHint) != null) {
                    textView14.setText(getContext().getString(2131954108));
                }
            }
        } else if (data.getFruitId() <= 0) {
            ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding11 = this.mDatabing;
            if (viewChatRoomGameLuckyFruitBinding11 != null && (viewChatRoomGameLuckyFruitResultBinding2 = viewChatRoomGameLuckyFruitBinding11.llResult) != null && (textView2 = viewChatRoomGameLuckyFruitResultBinding2.resultTvHint) != null) {
                textView2.setText(getContext().getString(2131953926));
            }
        } else {
            ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding12 = this.mDatabing;
            if (viewChatRoomGameLuckyFruitBinding12 != null && (viewChatRoomGameLuckyFruitResultBinding = viewChatRoomGameLuckyFruitBinding12.llResult) != null && (textView = viewChatRoomGameLuckyFruitResultBinding.resultTvHint) != null) {
                textView.setText(getContext().getString(2131954348));
            }
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding13 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding13 != null && (viewChatRoomGameLuckyFruitResultBinding23 = viewChatRoomGameLuckyFruitBinding13.llResult) != null && (linearLayout6 = viewChatRoomGameLuckyFruitResultBinding23.resultUserView1) != null) {
            linearLayout6.setVisibility(8);
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding14 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding14 != null && (viewChatRoomGameLuckyFruitResultBinding22 = viewChatRoomGameLuckyFruitBinding14.llResult) != null && (linearLayout5 = viewChatRoomGameLuckyFruitResultBinding22.resultUserView2) != null) {
            linearLayout5.setVisibility(8);
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding15 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding15 != null && (viewChatRoomGameLuckyFruitResultBinding21 = viewChatRoomGameLuckyFruitBinding15.llResult) != null && (linearLayout4 = viewChatRoomGameLuckyFruitResultBinding21.resultUserView3) != null) {
            linearLayout4.setVisibility(8);
        }
        List<LuckyFruitGameTop3> top3 = data.getTop3();
        if (top3 != null && !top3.isEmpty()) {
            ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding16 = this.mDatabing;
            if (viewChatRoomGameLuckyFruitBinding16 != null && (viewChatRoomGameLuckyFruitResultBinding20 = viewChatRoomGameLuckyFruitBinding16.llResult) != null && (textView13 = viewChatRoomGameLuckyFruitResultBinding20.resultTvHint2) != null) {
                textView13.setVisibility(8);
            }
            List<LuckyFruitGameTop3> top32 = data.getTop3();
            if (top32 != null) {
                if (top32.size() > 0) {
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding17 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding17 != null && (viewChatRoomGameLuckyFruitResultBinding19 = viewChatRoomGameLuckyFruitBinding17.llResult) != null && (linearLayout3 = viewChatRoomGameLuckyFruitResultBinding19.resultUserView1) != null) {
                        linearLayout3.setVisibility(0);
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding18 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding18 != null && (viewChatRoomGameLuckyFruitResultBinding18 = viewChatRoomGameLuckyFruitBinding18.llResult) != null && (appCompatImageView = viewChatRoomGameLuckyFruitResultBinding18.resultAvatar1) != null) {
                        appCompatImageView.setVisibility(0);
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding19 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding19 != null && (viewChatRoomGameLuckyFruitResultBinding17 = viewChatRoomGameLuckyFruitBinding19.llResult) != null && (circleImageView3 = viewChatRoomGameLuckyFruitResultBinding17.resultAvatar1) != null) {
                        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                        String avatar = top32.get(0).getUser().getAvatar();
                        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
                        Dimens dimens = Dimens.INSTANCE;
                        fill.setWidth(dimens.dpToPx(50));
                        fill.setHeight(dimens.dpToPx(50));
                        Unit unit = Unit.INSTANCE;
                        ViewUtilitiesKt.bind$default(circleImageView3, companion.displayUserAvatarImage(avatar, fill), null, 2, null);
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding20 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding20 != null && (viewChatRoomGameLuckyFruitResultBinding16 = viewChatRoomGameLuckyFruitBinding20.llResult) != null && (textView12 = viewChatRoomGameLuckyFruitResultBinding16.resultName1) != null) {
                        textView12.setText(top32.get(0).getUser().getName());
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding21 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding21 != null && (viewChatRoomGameLuckyFruitResultBinding15 = viewChatRoomGameLuckyFruitBinding21.llResult) != null && (textView11 = viewChatRoomGameLuckyFruitResultBinding15.resultUserGold1) != null) {
                        textView11.setText(NumberUtilsKt.rankNumberFormat(top32.get(0).getDiamond()));
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding22 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding22 != null && (viewChatRoomGameLuckyFruitResultBinding14 = viewChatRoomGameLuckyFruitBinding22.llResult) != null && (textView10 = viewChatRoomGameLuckyFruitResultBinding14.resultTvHint2) != null) {
                        textView10.setVisibility(8);
                    }
                } else {
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding23 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding23 != null && (viewChatRoomGameLuckyFruitResultBinding5 = viewChatRoomGameLuckyFruitBinding23.llResult) != null && (textView5 = viewChatRoomGameLuckyFruitResultBinding5.resultTvHint2) != null) {
                        textView5.setVisibility(0);
                    }
                }
                if (top32.size() > 1) {
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding24 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding24 != null && (viewChatRoomGameLuckyFruitResultBinding13 = viewChatRoomGameLuckyFruitBinding24.llResult) != null && (linearLayout2 = viewChatRoomGameLuckyFruitResultBinding13.resultUserView2) != null) {
                        linearLayout2.setVisibility(0);
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding25 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding25 != null && (viewChatRoomGameLuckyFruitResultBinding12 = viewChatRoomGameLuckyFruitBinding25.llResult) != null && (circleImageView2 = viewChatRoomGameLuckyFruitResultBinding12.resultAvatar2) != null) {
                        ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
                        String avatar2 = top32.get(1).getUser().getAvatar();
                        ResizeMode.FILL fill2 = ResizeMode.FILL.INSTANCE;
                        Dimens dimens2 = Dimens.INSTANCE;
                        fill2.setWidth(dimens2.dpToPx(46));
                        fill2.setHeight(dimens2.dpToPx(46));
                        Unit unit2 = Unit.INSTANCE;
                        ViewUtilitiesKt.bind$default(circleImageView2, companion2.displayUserAvatarImage(avatar2, fill2), null, 2, null);
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding26 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding26 != null && (viewChatRoomGameLuckyFruitResultBinding11 = viewChatRoomGameLuckyFruitBinding26.llResult) != null && (textView9 = viewChatRoomGameLuckyFruitResultBinding11.resultName2) != null) {
                        textView9.setText(top32.get(1).getUser().getName());
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding27 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding27 != null && (viewChatRoomGameLuckyFruitResultBinding10 = viewChatRoomGameLuckyFruitBinding27.llResult) != null && (textView8 = viewChatRoomGameLuckyFruitResultBinding10.resultUserGold2) != null) {
                        textView8.setText(NumberUtilsKt.rankNumberFormat(top32.get(1).getDiamond()));
                    }
                }
                if (top32.size() > 2) {
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding28 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding28 != null && (viewChatRoomGameLuckyFruitResultBinding9 = viewChatRoomGameLuckyFruitBinding28.llResult) != null && (linearLayout = viewChatRoomGameLuckyFruitResultBinding9.resultUserView3) != null) {
                        linearLayout.setVisibility(0);
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding29 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding29 != null && (viewChatRoomGameLuckyFruitResultBinding8 = viewChatRoomGameLuckyFruitBinding29.llResult) != null && (circleImageView = viewChatRoomGameLuckyFruitResultBinding8.resultAvatar3) != null) {
                        ImageUIModel.Companion companion3 = ImageUIModel.INSTANCE;
                        String avatar3 = top32.get(2).getUser().getAvatar();
                        ResizeMode.FILL fill3 = ResizeMode.FILL.INSTANCE;
                        Dimens dimens3 = Dimens.INSTANCE;
                        fill3.setWidth(dimens3.dpToPx(46));
                        fill3.setHeight(dimens3.dpToPx(46));
                        Unit unit3 = Unit.INSTANCE;
                        ViewUtilitiesKt.bind$default(circleImageView, companion3.displayUserAvatarImage(avatar3, fill3), null, 2, null);
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding30 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding30 != null && (viewChatRoomGameLuckyFruitResultBinding7 = viewChatRoomGameLuckyFruitBinding30.llResult) != null && (textView7 = viewChatRoomGameLuckyFruitResultBinding7.resultName3) != null) {
                        textView7.setText(top32.get(2).getUser().getName());
                    }
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding31 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding31 != null && (viewChatRoomGameLuckyFruitResultBinding6 = viewChatRoomGameLuckyFruitBinding31.llResult) != null && (textView6 = viewChatRoomGameLuckyFruitResultBinding6.resultUserGold3) != null) {
                        textView6.setText(NumberUtilsKt.rankNumberFormat(top32.get(2).getDiamond()));
                    }
                }
            }
        } else {
            ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding32 = this.mDatabing;
            if (viewChatRoomGameLuckyFruitBinding32 != null && (viewChatRoomGameLuckyFruitResultBinding3 = viewChatRoomGameLuckyFruitBinding32.llResult) != null && (textView3 = viewChatRoomGameLuckyFruitResultBinding3.resultTvHint2) != null) {
                textView3.setVisibility(0);
            }
        }
        stopResultTimeCount();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 5;
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding33 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding33 != null && (viewChatRoomGameLuckyFruitResultBinding4 = viewChatRoomGameLuckyFruitBinding33.llResult) != null && (textView4 = viewChatRoomGameLuckyFruitResultBinding4.resultTvTime) != null) {
            textView4.setText("5s");
        }
        this.resultViewDisposable = io.reactivex.rxjava3.core.z.interval(800L, 1000L, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$showResultView$5
            /* JADX WARN: Type inference failed for: r3v17, types: [com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog, android.app.Dialog] */
            public final void accept(Long l) {
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding34;
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding35;
                Animation animation;
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding36;
                ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding32;
                ConstraintLayout constraintLayout;
                Animation animation2;
                Animation animation3;
                Animation animation4;
                ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding33;
                ImageView imageView2;
                Animation animation5;
                ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding34;
                TextView textView22;
                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding37;
                ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding35;
                FrameLayout frameLayout;
                Intrinsics.checkNotNullParameter(l, "it");
                if (intRef.element == 5) {
                    viewChatRoomGameLuckyFruitBinding37 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding37 != null && (viewChatRoomGameLuckyFruitResultBinding35 = viewChatRoomGameLuckyFruitBinding37.llResult) != null && (frameLayout = viewChatRoomGameLuckyFruitResultBinding35.viewResultBase) != null) {
                        frameLayout.setVisibility(0);
                    }
                    this.setResultViewAnim();
                }
                viewChatRoomGameLuckyFruitBinding34 = this.mDatabing;
                if (viewChatRoomGameLuckyFruitBinding34 != null && (viewChatRoomGameLuckyFruitResultBinding34 = viewChatRoomGameLuckyFruitBinding34.llResult) != null && (textView22 = viewChatRoomGameLuckyFruitResultBinding34.resultTvTime) != null) {
                    textView22.setText(intRef.element + "s");
                }
                if (intRef.element <= 0) {
                    this.stopResultTimeCount();
                    viewChatRoomGameLuckyFruitBinding35 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding35 != null && (viewChatRoomGameLuckyFruitResultBinding33 = viewChatRoomGameLuckyFruitBinding35.llResult) != null && (imageView2 = viewChatRoomGameLuckyFruitResultBinding33.resultBgLight) != null && (animation5 = imageView2.getAnimation()) != null) {
                        animation5.cancel();
                    }
                    animation = this.resultViewOutAnim;
                    if (animation == null) {
                        ?? r3 = this;
                        ((LuckyFruitDialog) r3).resultViewOutAnim = AnimationUtils.loadAnimation(r3.getContext(), 2130772075);
                        animation3 = this.resultViewOutAnim;
                        if (animation3 != null) {
                            animation3.setFillAfter(true);
                        }
                        animation4 = this.resultViewOutAnim;
                        if (animation4 != null) {
                            final LuckyFruitDialog luckyFruitDialog = this;
                            animation4.setAnimationListener(new Animation.AnimationListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$showResultView$5.1
                                @Override // android.view.animation.Animation.AnimationListener
                                public void onAnimationEnd(Animation animation6) {
                                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding38;
                                    LuckyFruitGameDetailBean luckyFruitGameDetailBean;
                                    long j;
                                    ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding36;
                                    FrameLayout frameLayout2;
                                    viewChatRoomGameLuckyFruitBinding38 = LuckyFruitDialog.this.mDatabing;
                                    if (viewChatRoomGameLuckyFruitBinding38 != null && (viewChatRoomGameLuckyFruitResultBinding36 = viewChatRoomGameLuckyFruitBinding38.llResult) != null && (frameLayout2 = viewChatRoomGameLuckyFruitResultBinding36.viewResultBase) != null) {
                                        frameLayout2.setVisibility(8);
                                    }
                                    luckyFruitGameDetailBean = LuckyFruitDialog.this.mLuckyFruitGameDetailBean;
                                    if (luckyFruitGameDetailBean != null) {
                                        j = luckyFruitGameDetailBean.getMyAward();
                                    } else {
                                        j = 0;
                                    }
                                    if (j > 0) {
                                        LuckyFruitDialog.this.updateUserDiamond();
                                    }
                                    LuckyFruitDialog.this.getGameDetails();
                                }

                                @Override // android.view.animation.Animation.AnimationListener
                                public void onAnimationRepeat(Animation animation6) {
                                }

                                @Override // android.view.animation.Animation.AnimationListener
                                public void onAnimationStart(Animation animation6) {
                                }
                            });
                        }
                    }
                    viewChatRoomGameLuckyFruitBinding36 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding36 != null && (viewChatRoomGameLuckyFruitResultBinding32 = viewChatRoomGameLuckyFruitBinding36.llResult) != null && (constraintLayout = viewChatRoomGameLuckyFruitResultBinding32.viewResultContent) != null) {
                        animation2 = this.resultViewOutAnim;
                        constraintLayout.startAnimation(animation2);
                    }
                }
                Ref.IntRef intRef2 = intRef;
                intRef2.element--;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showResultView$lambda$42(LuckyFruitGameDetailBean luckyFruitGameDetailBean, LuckyFruitDialog luckyFruitDialog) {
        ArrayList<MyStake> myStake = luckyFruitGameDetailBean.getMyStake();
        if (myStake != null && !myStake.isEmpty()) {
            Iterator<MyStake> it = myStake.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                MyStake next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                MyStake myStake2 = next;
                LuckyFruitAdapter luckyFruitAdapter = luckyFruitDialog.fruitAdapter;
                if (luckyFruitAdapter != null) {
                    luckyFruitAdapter.placeBet(myStake2.getFruitId(), myStake2.getStake());
                }
            }
        }
        List<LuckyFruitRation> ratio = luckyFruitGameDetailBean.getRatio();
        if (ratio != null) {
            for (LuckyFruitRation luckyFruitRation : ratio) {
                LuckyFruitAdapter luckyFruitAdapter2 = luckyFruitDialog.fruitAdapter;
                if (luckyFruitAdapter2 != null) {
                    luckyFruitAdapter2.updateRate(luckyFruitRation.getFruitId(), luckyFruitRation.getRatio());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopResultTimeCount() {
        nd.c cVar = this.resultViewDisposable;
        if (cVar != null && !cVar.isDisposed()) {
            cVar.dispose();
        }
        this.resultViewDisposable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserDiamond() {
        Log.d(TAG, "updateUserDiamond: 准备网络请求更新钻石");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDiamond(), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.f0
            public final Object invoke(Object obj) {
                Unit updateUserDiamond$lambda$25;
                updateUserDiamond$lambda$25 = LuckyFruitDialog.updateUserDiamond$lambda$25(LuckyFruitDialog.this, (ApiResponse) obj);
                return updateUserDiamond$lambda$25;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.g
            public final Object invoke(Object obj) {
                Unit updateUserDiamond$lambda$26;
                updateUserDiamond$lambda$26 = LuckyFruitDialog.updateUserDiamond$lambda$26((Throwable) obj);
                return updateUserDiamond$lambda$26;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUserDiamond$lambda$25(LuckyFruitDialog luckyFruitDialog, ApiResponse apiResponse) {
        Double d;
        double d2;
        long j;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        Double d3 = null;
        if (user != null) {
            d = Double.valueOf(user.getDiamondNum());
        } else {
            d = null;
        }
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d3 = Double.valueOf(channelEventGiftAddTime.getDiamondNum());
        }
        if (!Intrinsics.areEqual(d, d3)) {
            UserStore shared = companion.getShared();
            ChannelEventGiftAddTime channelEventGiftAddTime2 = (ChannelEventGiftAddTime) apiResponse.getData();
            if (channelEventGiftAddTime2 != null) {
                d2 = channelEventGiftAddTime2.getDiamondNum();
            } else {
                d2 = 0.0d;
            }
            UserStore.refreshDiamondOrGem$default(shared, d2, 0.0d, 2, null);
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                j = (long) user2.getDiamondNum();
            } else {
                j = 0;
            }
            luckyFruitDialog.showDiamond(j);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateUserDiamond$lambda$26(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public final void commonDialogShow() {
        Activity activity;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (activity.isFinishing() || activity.isDestroyed())) {
            return;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        final ?? commonTextDialog = new CommonTextDialog(context2, 0.0f, 2, null);
        String string = commonTextDialog.getMContext().getString(2131953126);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        commonTextDialog.setContentText(string, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$commonDialogShow$2$1
            public void cancel() {
                commonTextDialog.dismiss();
            }

            public void confirm() {
                LuckyFruitDialog.this.gotoPurcharseView();
                commonTextDialog.dismiss();
            }
        });
        commonTextDialog.show();
    }

    public void dismiss() {
        super.dismiss();
        LuckyFruitAdapter luckyFruitAdapter = this.fruitAdapter;
        if (luckyFruitAdapter != null) {
            luckyFruitAdapter.setIsViewShowing(false);
        }
        CoroutineScopeKt.cancel$default(this.dialogScope, (CancellationException) null, 1, (Object) null);
        release();
        LuckyFruitDialogListener luckyFruitDialogListener = this.mLuckyFruitDialogListener;
        if (luckyFruitDialogListener != null) {
            luckyFruitDialogListener.isLuckyFruitDialogDissmiss();
        }
    }

    public final void getGameDetails() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getFruitMachineDetail(), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.t
            public final Object invoke(Object obj) {
                Unit gameDetails$lambda$56;
                gameDetails$lambda$56 = LuckyFruitDialog.getGameDetails$lambda$56(LuckyFruitDialog.this, (ApiResponse) obj);
                return gameDetails$lambda$56;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.u
            public final Object invoke(Object obj) {
                Unit gameDetails$lambda$57;
                gameDetails$lambda$57 = LuckyFruitDialog.getGameDetails$lambda$57((Throwable) obj);
                return gameDetails$lambda$57;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final LuckyFruitDialogListener getMLuckyFruitDialogListener() {
        return this.mLuckyFruitDialogListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void gotoPurcharseView() {
        Activity activity;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (activity.isFinishing() || activity.isDestroyed())) {
            return;
        }
        WalletActivity.Companion companion = WalletActivity.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        companion.start(context2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initViewAndEvent() {
        long j;
        final TextView textView;
        LinearLayout linearLayout;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        LuckyBaseGridView luckyBaseGridView;
        RecyclerView recyclerView;
        LuckyBaseGridView luckyBaseGridView2;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            j = (long) user.getDiamondNum();
        } else {
            j = 0;
        }
        showDiamond(j);
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding != null && (luckyBaseGridView2 = viewChatRoomGameLuckyFruitBinding.luckyView) != null) {
            luckyBaseGridView2.post(new Runnable() { // from class: com.qiahao.nextvideo.room.luckyfruit.q
                @Override // java.lang.Runnable
                public final void run() {
                    LuckyFruitDialog.initViewAndEvent$lambda$2(LuckyFruitDialog.this);
                }
            });
        }
        this.resultAdapter = new LuckyFruitResultAdapter();
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding2 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding2 != null && (recyclerView = viewChatRoomGameLuckyFruitBinding2.resultRecycler) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.setAdapter(this.resultAdapter);
        }
        ArrayList arrayList = new ArrayList();
        LuckyFruitBean luckyFruitBean = new LuckyFruitBean();
        luckyFruitBean.setMId(1);
        luckyFruitBean.setRate(5);
        luckyFruitBean.setTextColor(Color.parseColor("#ffffff"));
        arrayList.add(luckyFruitBean);
        LuckyFruitBean luckyFruitBean2 = new LuckyFruitBean();
        luckyFruitBean2.setMId(2);
        luckyFruitBean2.setRate(5);
        luckyFruitBean2.setTextColor(Color.parseColor("#ffffff"));
        arrayList.add(luckyFruitBean2);
        LuckyFruitBean luckyFruitBean3 = new LuckyFruitBean();
        luckyFruitBean3.setMId(3);
        luckyFruitBean3.setRate(5);
        luckyFruitBean3.setTextColor(Color.parseColor("#ffffff"));
        arrayList.add(luckyFruitBean3);
        LuckyFruitBean luckyFruitBean4 = new LuckyFruitBean();
        luckyFruitBean4.setMId(4);
        luckyFruitBean4.setRate(5);
        luckyFruitBean4.setTextColor(Color.parseColor("#ffffff"));
        arrayList.add(luckyFruitBean4);
        LuckyFruitBean luckyFruitBean5 = new LuckyFruitBean();
        luckyFruitBean5.setMId(5);
        luckyFruitBean5.setRate(10);
        luckyFruitBean5.setTextColor(Color.parseColor("#ffffff"));
        arrayList.add(luckyFruitBean5);
        LuckyFruitBean luckyFruitBean6 = new LuckyFruitBean();
        luckyFruitBean6.setMId(6);
        luckyFruitBean6.setRate(15);
        luckyFruitBean6.setTextColor(Color.parseColor("#ffffff"));
        arrayList.add(luckyFruitBean6);
        LuckyFruitBean luckyFruitBean7 = new LuckyFruitBean();
        luckyFruitBean7.setMId(7);
        luckyFruitBean7.setRate(25);
        luckyFruitBean7.setTextColor(Color.parseColor("#ffffff"));
        arrayList.add(luckyFruitBean7);
        LuckyFruitBean luckyFruitBean8 = new LuckyFruitBean();
        luckyFruitBean8.setMId(8);
        luckyFruitBean8.setRate(45);
        luckyFruitBean8.setTextColor(Color.parseColor("#ffffff"));
        arrayList.add(luckyFruitBean8);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final LuckyFruitAdapter luckyFruitAdapter = new LuckyFruitAdapter(context);
        this.fruitAdapter = luckyFruitAdapter;
        luckyFruitAdapter.setData(arrayList);
        luckyFruitAdapter.setOnItemClickListener(new LuckyGridViewAdapter.OnItemClickListener<LuckyFruitBean>() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$initViewAndEvent$3$1
            /* JADX WARN: Type inference failed for: r8v5, types: [com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog, android.app.Dialog] */
            @Override // com.qiahao.nextvideo.room.luckyfruit.LuckyGridViewAdapter.OnItemClickListener
            public void onItemClick(View view, final int position, final LuckyFruitBean bean) {
                LuckyFruitGameDetailBean luckyFruitGameDetailBean;
                boolean z;
                LuckyFruitPlaceBetConfirmDialog luckyFruitPlaceBetConfirmDialog;
                LuckyFruitPlaceBetConfirmDialog luckyFruitPlaceBetConfirmDialog2;
                LuckyFruitPlaceBetConfirmDialog luckyFruitPlaceBetConfirmDialog3;
                AppCompatDialog appCompatDialog;
                int selectMoney;
                int selectMoney2;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(bean, "bean");
                if (bean.getStake() != 0 || LuckyFruitAdapter.this.getPlaceSize() < 6) {
                    luckyFruitGameDetailBean = this.mLuckyFruitGameDetailBean;
                    if (luckyFruitGameDetailBean != null) {
                        final ?? r8 = this;
                        z = ((LuckyFruitDialog) r8).isConfirmAgain;
                        if (z) {
                            luckyFruitPlaceBetConfirmDialog = ((LuckyFruitDialog) r8).confirmDialog;
                            if (luckyFruitPlaceBetConfirmDialog == null) {
                                Context context2 = r8.getContext();
                                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                                selectMoney2 = r8.getSelectMoney();
                                ((LuckyFruitDialog) r8).confirmDialog = new LuckyFruitPlaceBetConfirmDialog(context2, selectMoney2, 0, 4, null);
                            }
                            luckyFruitPlaceBetConfirmDialog2 = ((LuckyFruitDialog) r8).confirmDialog;
                            if (luckyFruitPlaceBetConfirmDialog2 != null) {
                                selectMoney = r8.getSelectMoney();
                                luckyFruitPlaceBetConfirmDialog2.setTextDiamond(selectMoney);
                            }
                            luckyFruitPlaceBetConfirmDialog3 = ((LuckyFruitDialog) r8).confirmDialog;
                            if (luckyFruitPlaceBetConfirmDialog3 != null) {
                                luckyFruitPlaceBetConfirmDialog3.setMLuckyFruitPlaceBetConfirmDialogListener(new LuckyFruitPlaceBetConfirmDialogListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$initViewAndEvent$3$1$onItemClick$1$1
                                    @Override // com.qiahao.nextvideo.room.luckyfruit.LuckyFruitPlaceBetConfirmDialogListener
                                    public void onConfirm(boolean isCheckBox) {
                                        LuckyFruitDialog.this.isConfirmAgain = !isCheckBox;
                                        if (isCheckBox) {
                                            MeetingRoomManager.INSTANCE.setLuckyFruitConfirm(isCheckBox);
                                        }
                                        LuckyFruitDialog.this.placeBet(bean.getMId(), position);
                                    }
                                });
                            }
                            appCompatDialog = ((LuckyFruitDialog) r8).confirmDialog;
                            if (appCompatDialog != null) {
                                appCompatDialog.show();
                                return;
                            }
                            return;
                        }
                        r8.placeBet(bean.getMId(), position);
                        return;
                    }
                    return;
                }
                if (FastClickOneUtils.INSTANCE.isFastClick()) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    Context context3 = this.getContext();
                    String string = this.getContext().getString(2131952256);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, context3, string, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        });
        luckyFruitAdapter.setOnShowResultListener(new OnResult<Integer>() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$initViewAndEvent$3$2
            @Override // com.qiahao.nextvideo.room.luckyfruit.OnResult
            public /* bridge */ /* synthetic */ void onResult(Integer num) {
                onResult(num.intValue());
            }

            public void onResult(int t) {
                LuckyFruitGameDetailBean luckyFruitGameDetailBean;
                LuckyFruitGameDetailBean luckyFruitGameDetailBean2;
                LuckyFruitDialog.this.refreshAdapter(t);
                luckyFruitGameDetailBean = LuckyFruitDialog.this.mLuckyFruitGameDetailBean;
                if (luckyFruitGameDetailBean != null) {
                    LuckyFruitDialog luckyFruitDialog = LuckyFruitDialog.this;
                    luckyFruitGameDetailBean2 = luckyFruitDialog.mLuckyFruitGameDetailBean;
                    Intrinsics.checkNotNull(luckyFruitGameDetailBean2);
                    luckyFruitDialog.showResultView(luckyFruitGameDetailBean2);
                }
            }
        });
        luckyFruitAdapter.setOnGameTypeListener(new Function2() { // from class: com.qiahao.nextvideo.room.luckyfruit.y
            public final Object invoke(Object obj, Object obj2) {
                Unit initViewAndEvent$lambda$14$lambda$13;
                initViewAndEvent$lambda$14$lambda$13 = LuckyFruitDialog.initViewAndEvent$lambda$14$lambda$13(LuckyFruitDialog.this, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                return initViewAndEvent$lambda$14$lambda$13;
            }
        });
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding3 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding3 != null && (luckyBaseGridView = viewChatRoomGameLuckyFruitBinding3.luckyView) != null) {
            luckyBaseGridView.setRowCount(3);
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding4 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding4 != null && (imageView5 = viewChatRoomGameLuckyFruitBinding4.close) != null) {
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitDialog.this.dismiss();
                }
            });
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding5 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding5 != null && (imageView4 = viewChatRoomGameLuckyFruitBinding5.rule) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitDialog.initViewAndEvent$lambda$16(LuckyFruitDialog.this, view);
                }
            });
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding6 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding6 != null && (imageView3 = viewChatRoomGameLuckyFruitBinding6.record) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitDialog.initViewAndEvent$lambda$17(LuckyFruitDialog.this, view);
                }
            });
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding7 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding7 != null && (imageView2 = viewChatRoomGameLuckyFruitBinding7.rank) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitDialog.initViewAndEvent$lambda$18(LuckyFruitDialog.this, view);
                }
            });
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding8 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding8 != null && (imageView = viewChatRoomGameLuckyFruitBinding8.fruitActivity) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitDialog.initViewAndEvent$lambda$19(view);
                }
            });
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding9 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding9 != null && (linearLayout = viewChatRoomGameLuckyFruitBinding9.llDiamond) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitDialog.initViewAndEvent$lambda$20(LuckyFruitDialog.this, view);
                }
            });
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding10 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding10 != null && (textView = viewChatRoomGameLuckyFruitBinding10.repeat) != null) {
            final long j2 = 800;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitDialog$initViewAndEvent$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LuckyFruitGameDetailBean luckyFruitGameDetailBean;
                    boolean z;
                    LuckyFruitGameDetailBean luckyFruitGameDetailBean2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j2 || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        luckyFruitGameDetailBean = this.mLuckyFruitGameDetailBean;
                        boolean z2 = false;
                        if (luckyFruitGameDetailBean != null) {
                            z = Intrinsics.areEqual(luckyFruitGameDetailBean.getAutoBet(), Boolean.FALSE);
                        } else {
                            z = false;
                        }
                        if (z) {
                            luckyFruitGameDetailBean2 = this.mLuckyFruitGameDetailBean;
                            if (luckyFruitGameDetailBean2 != null && luckyFruitGameDetailBean2.getStatus() == 1) {
                                z2 = true;
                            }
                            if (z2) {
                                if (!((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "show_fruit_repeat", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue()) {
                                    this.fruitRepeatData();
                                } else {
                                    this.fruitRepeat();
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        View root;
        super.onCreate(savedInstanceState);
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = (ViewChatRoomGameLuckyFruitBinding) androidx.databinding.g.h(LayoutInflater.from(this.mContext), R.layout.view_chat_room_game_lucky_fruit, (ViewGroup) null, false);
        this.mDatabing = viewChatRoomGameLuckyFruitBinding;
        if (viewChatRoomGameLuckyFruitBinding != null && (root = viewChatRoomGameLuckyFruitBinding.getRoot()) != null) {
            setContentView(root);
        }
        initStyle();
        initViewAndEvent();
        initObserve();
    }

    public final void placeBetError(int position, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        LuckyFruitAdapter luckyFruitAdapter = this.fruitAdapter;
        if (luckyFruitAdapter != null) {
            luckyFruitAdapter.showPlaceBetProgress(position, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void refreshData(@NotNull final LuckyFruitGameDetailBean data) {
        LuckyBaseGridView luckyBaseGridView;
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        RadioButton radioButton4;
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding;
        RadioButton radioButton5;
        TextView textView;
        TextView textView2;
        int i;
        int i2 = 0;
        Intrinsics.checkNotNullParameter(data, "data");
        LuckyFruitAdapter luckyFruitAdapter = this.fruitAdapter;
        if (luckyFruitAdapter != null) {
            luckyFruitAdapter.setIsViewShowing(true);
        }
        this.isReload = false;
        this.mLuckyFruitGameDetailBean = data;
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding2 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding2 != null && (textView2 = viewChatRoomGameLuckyFruitBinding2.repeat) != null) {
            Context context = getContext();
            if (Intrinsics.areEqual(data.getAutoBet(), Boolean.FALSE) && data.getStatus() == 1) {
                i = R.drawable.fruit_repeat_bg;
            } else {
                i = R.drawable.fruit_repeat_bg_default;
            }
            textView2.setBackground(androidx.core.content.a.getDrawable(context, i));
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding3 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding3 != null && (textView = viewChatRoomGameLuckyFruitBinding3.tvRoundCount) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953977), Arrays.copyOf(new Object[]{String.valueOf(data.getRound())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            SpannableTextBuilder.changeTextColor$default(new SpannableTextBuilder(textView), format, String.valueOf(data.getRound()), Integer.valueOf(Color.parseColor("#ffd998")), (Integer) null, 8, (Object) null).apply();
        }
        List<Integer> betNums = data.getBetNums();
        if (betNums != null) {
            for (Object obj : betNums) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int intValue = ((Number) obj).intValue();
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4 && (viewChatRoomGameLuckyFruitBinding = this.mDatabing) != null && (radioButton5 = viewChatRoomGameLuckyFruitBinding.rbGold5) != null) {
                                    radioButton5.setBackground(INSTANCE.getGoldBg(intValue));
                                }
                            } else {
                                ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding4 = this.mDatabing;
                                if (viewChatRoomGameLuckyFruitBinding4 != null && (radioButton4 = viewChatRoomGameLuckyFruitBinding4.rbGold4) != null) {
                                    radioButton4.setBackground(INSTANCE.getGoldBg(intValue));
                                }
                            }
                        } else {
                            ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding5 = this.mDatabing;
                            if (viewChatRoomGameLuckyFruitBinding5 != null && (radioButton3 = viewChatRoomGameLuckyFruitBinding5.rbGold3) != null) {
                                radioButton3.setBackground(INSTANCE.getGoldBg(intValue));
                            }
                        }
                    } else {
                        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding6 = this.mDatabing;
                        if (viewChatRoomGameLuckyFruitBinding6 != null && (radioButton2 = viewChatRoomGameLuckyFruitBinding6.rbGold2) != null) {
                            radioButton2.setBackground(INSTANCE.getGoldBg(intValue));
                        }
                    }
                } else {
                    ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding7 = this.mDatabing;
                    if (viewChatRoomGameLuckyFruitBinding7 != null && (radioButton = viewChatRoomGameLuckyFruitBinding7.rbGold1) != null) {
                        radioButton.setBackground(INSTANCE.getGoldBg(intValue));
                    }
                }
                i2 = i3;
            }
        }
        LuckyFruitAdapter luckyFruitAdapter2 = this.fruitAdapter;
        if (luckyFruitAdapter2 != null) {
            luckyFruitAdapter2.setGameType(data.getStatus());
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding8 = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding8 != null && (luckyBaseGridView = viewChatRoomGameLuckyFruitBinding8.luckyView) != null) {
            luckyBaseGridView.post(new Runnable() { // from class: com.qiahao.nextvideo.room.luckyfruit.j
                @Override // java.lang.Runnable
                public final void run() {
                    LuckyFruitDialog.refreshData$lambda$34(LuckyFruitGameDetailBean.this, this);
                }
            });
        }
        int status = data.getStatus();
        if (status != 1) {
            if (status != 2) {
                if (status == 3) {
                    showResultView(data);
                    return;
                }
                return;
            } else {
                Log.d(TAG, "refreshData: startLotteryRound----重新展示倒计时");
                LuckyFruitAdapter luckyFruitAdapter3 = this.fruitAdapter;
                if (luckyFruitAdapter3 != null) {
                    luckyFruitAdapter3.showGameTimeType2Status(data.getFruitId(), data.getRemainSecond());
                    return;
                }
                return;
            }
        }
        LuckyFruitAdapter luckyFruitAdapter4 = this.fruitAdapter;
        if (luckyFruitAdapter4 != null) {
            luckyFruitAdapter4.startTimeRound(data.getRemainSecond());
        }
    }

    public final void release() {
        ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding;
        ImageView imageView;
        Animation animation;
        LuckyFruitAdapter luckyFruitAdapter = this.fruitAdapter;
        if (luckyFruitAdapter != null) {
            luckyFruitAdapter.release();
        }
        Animation animation2 = this.resultViewInAnim;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.resultViewOutAnim;
        if (animation3 != null) {
            animation3.setAnimationListener(null);
        }
        Animation animation4 = this.resultViewOutAnim;
        if (animation4 != null) {
            animation4.cancel();
        }
        ViewChatRoomGameLuckyFruitBinding viewChatRoomGameLuckyFruitBinding = this.mDatabing;
        if (viewChatRoomGameLuckyFruitBinding != null && (viewChatRoomGameLuckyFruitResultBinding = viewChatRoomGameLuckyFruitBinding.llResult) != null && (imageView = viewChatRoomGameLuckyFruitResultBinding.resultBgLight) != null && (animation = imageView.getAnimation()) != null) {
            animation.cancel();
        }
        stopResultTimeCount();
        this.mCompositeDisposable.dispose();
        this.fruitAdapter = null;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMLuckyFruitDialogListener(@Nullable LuckyFruitDialogListener luckyFruitDialogListener) {
        this.mLuckyFruitDialogListener = luckyFruitDialogListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        getGameDetails();
        getGameResultList();
        updateUserDiamond();
    }
}
