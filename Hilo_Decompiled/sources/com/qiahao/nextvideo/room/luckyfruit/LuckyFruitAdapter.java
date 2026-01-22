package com.qiahao.nextvideo.room.luckyfruit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.oudi.core.support.ActivityLifecycleManager;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\u0016J\u001d\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u000b¢\u0006\u0004\b&\u0010\u000fJ\u001d\u0010'\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b'\u0010%J\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010\u0016J\u001d\u0010,\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t¢\u0006\u0004\b0\u0010\rJ\u001d\u00102\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007¢\u0006\u0004\b2\u0010%J\u0015\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\t¢\u0006\u0004\b4\u0010\u0012J\r\u00105\u001a\u00020\u0007¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\u0007¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\t¢\u0006\u0004\b:\u0010\u0012R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010=R\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010GR\"\u0010I\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010G\u001a\u0004\bJ\u00106\"\u0004\bK\u0010\u0016R\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010G\u001a\u0004\bL\u00106\"\u0004\bM\u0010\u0016R\"\u0010N\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010G\u001a\u0004\bO\u00106\"\u0004\bP\u0010\u0016R\"\u0010R\u001a\u00020Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010Z\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010\u0012R*\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cRT\u0010h\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(g\u0012\u0013\u0012\u00110\t¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010YR\u0016\u0010o\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010GR\u0016\u0010p\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010G¨\u0006q"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitAdapter;", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter;", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitBean;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", AgooConstants.MESSAGE_TIME, "", "isNewRound", "", "timeCountDown", "(IZ)V", "releaseTaskCycle", "()V", "start", "setBorderAnim", "(Z)V", "stopAnimTaskCycle", "onItemSelectLottery", "setTime1", "(I)V", "setTime2", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView;", "parentView", "onAddView", "(Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView;)V", "Landroid/view/View;", "itemView", "item", "convert", "(Landroid/view/View;Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitBean;)V", "countDownTime", "startTimeRound", "resultId", "showGameTimeType2Status", "(II)V", "release", "startLotteryRound", AgooConstants.MESSAGE_ID, "setResult", "", "gold", "placeBet", "(IJ)V", "position", "isVisibility", "showPlaceBetProgress", "rate", "updateRate", "isStart", "startFingerAnim", "getPlaceSize", "()I", "getItemById", "(I)Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitBean;", "isShow", "setIsViewShowing", "Landroid/widget/ImageView;", "time1", "Landroid/widget/ImageView;", "time2", "borderView", "Landroid/view/View;", "Lnd/c;", "mTaskCycle", "Lnd/c;", "animTaskCycle", "imgFinger", "selectCount", "I", "currentCount", "gameType", "getGameType", "setGameType", "getResultId", "setResultId", "resultIdRound", "getResultIdRound", "setResultIdRound", "", GameMatchActivity.GAME_ID, "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "isViewShowing", "Z", "isPlaceBet", "()Z", "setPlaceBet", "Lcom/qiahao/nextvideo/room/luckyfruit/OnResult;", "onShowResultListener", "Lcom/qiahao/nextvideo/room/luckyfruit/OnResult;", "getOnShowResultListener", "()Lcom/qiahao/nextvideo/room/luckyfruit/OnResult;", "setOnShowResultListener", "(Lcom/qiahao/nextvideo/room/luckyfruit/OnResult;)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "round", "onGameTypeListener", "Lkotlin/jvm/functions/Function2;", "getOnGameTypeListener", "()Lkotlin/jvm/functions/Function2;", "setOnGameTypeListener", "(Lkotlin/jvm/functions/Function2;)V", "isLoadRoundView", "centerTimeCount", "num1", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyFruitAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyFruitAdapter.kt\ncom/qiahao/nextvideo/room/luckyfruit/LuckyFruitAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,544:1\n1#2:545\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitAdapter extends LuckyGridViewAdapter<LuckyFruitBean> {

    @Nullable
    private nd.c animTaskCycle;

    @Nullable
    private View borderView;
    private int centerTimeCount;
    private int currentCount;

    @NotNull
    private String gameId;
    private int gameType;

    @Nullable
    private ImageView imgFinger;
    private boolean isLoadRoundView;
    private boolean isPlaceBet;
    private boolean isViewShowing;

    @Nullable
    private nd.c mTaskCycle;
    private int num1;

    @Nullable
    private Function2<? super Integer, ? super Boolean, Unit> onGameTypeListener;

    @Nullable
    private OnResult<Integer> onShowResultListener;
    private int resultId;
    private int resultIdRound;
    private int selectCount;

    @Nullable
    private ImageView time1;

    @Nullable
    private ImageView time2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyFruitAdapter(@NotNull Context context) {
        super(context, R.layout.item_chat_room_lucky_fruit);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gameType = 1;
        this.gameId = "";
        this.isViewShowing = true;
        setCenterView(LayoutInflater.from(context).inflate(R.layout.view_chat_room_game_lucky_fruit_time, (ViewGroup) null));
        View centerView = getCenterView();
        if (centerView != null) {
            this.time1 = (ImageView) centerView.findViewById(R.id.time_num1);
            this.time2 = (ImageView) centerView.findViewById(R.id.time_num2);
            this.borderView = centerView.findViewById(R.id.bg_image);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CutPasteId"})
    public final void onItemSelectLottery() {
        int i;
        int i2 = this.selectCount;
        if (i2 != 0 && this.currentCount > i2) {
            return;
        }
        if (this.currentCount == i2) {
            OnResult<Integer> onResult = this.onShowResultListener;
            if (onResult != null) {
                onResult.onResult(Integer.valueOf(this.resultId));
            }
            stopAnimTaskCycle();
        }
        if (!this.isViewShowing || getListData().size() < 2) {
            return;
        }
        int size = (this.currentCount % getListData().size()) - 1;
        if (size == -1) {
            size = getListData().size() - 1;
        }
        if (size == 0) {
            i = getListData().size() - 1;
        } else {
            i = size - 1;
        }
        View itemView = getItemView(i);
        if (itemView != null) {
            View findViewById = itemView.findViewById(R.id.view_selected);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (itemView.findViewById(R.id.fl_gold).getVisibility() == 0) {
                itemView.findViewById(R.id.view_select_nor).setVisibility(8);
            } else {
                itemView.findViewById(R.id.view_select_nor).setVisibility(0);
            }
        }
        View itemView2 = getItemView(size);
        if (itemView2 != null) {
            View findViewById2 = itemView2.findViewById(R.id.view_selected);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            if (itemView2.findViewById(R.id.fl_gold).getVisibility() == 0) {
                itemView2.findViewById(R.id.view_select_nor).setVisibility(8);
            } else {
                itemView2.findViewById(R.id.view_select_nor).setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseTaskCycle() {
        nd.c cVar = this.mTaskCycle;
        if (cVar != null && !cVar.isDisposed()) {
            cVar.dispose();
        }
        this.mTaskCycle = null;
    }

    private final void setBorderAnim(boolean start) {
        View view = this.borderView;
        if (view != null && (view.getBackground() instanceof AnimationDrawable)) {
            Drawable background = view.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            AnimationDrawable animationDrawable = (AnimationDrawable) background;
            if (start && !animationDrawable.isRunning()) {
                animationDrawable.start();
            } else if (!start && animationDrawable.isRunning()) {
                animationDrawable.stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTime1(int time) {
        int i = time / 10;
        if (i == this.num1) {
            return;
        }
        this.num1 = i;
        ImageView imageView = this.time1;
        if (imageView != null) {
            Drawable drawable = null;
            switch (i) {
                case 1:
                    Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity, R.drawable.chat_room_lucky_fruit_time_1);
                        break;
                    }
                    break;
                case 2:
                    Activity currentActivity2 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity2 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity2, R.drawable.chat_room_lucky_fruit_time_2);
                        break;
                    }
                    break;
                case 3:
                    Activity currentActivity3 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity3 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity3, R.drawable.chat_room_lucky_fruit_time_3);
                        break;
                    }
                    break;
                case 4:
                    Activity currentActivity4 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity4 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity4, R.drawable.chat_room_lucky_fruit_time_4);
                        break;
                    }
                    break;
                case 5:
                    Activity currentActivity5 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity5 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity5, R.drawable.chat_room_lucky_fruit_time_5);
                        break;
                    }
                    break;
                case 6:
                    Activity currentActivity6 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity6 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity6, R.drawable.chat_room_lucky_fruit_time_6);
                        break;
                    }
                    break;
                case 7:
                    Activity currentActivity7 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity7 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity7, R.drawable.chat_room_lucky_fruit_time_7);
                        break;
                    }
                    break;
                case 8:
                    Activity currentActivity8 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity8 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity8, R.drawable.chat_room_lucky_fruit_time_8);
                        break;
                    }
                    break;
                case 9:
                    Activity currentActivity9 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity9 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity9, R.drawable.chat_room_lucky_fruit_time_9);
                        break;
                    }
                    break;
                default:
                    Activity currentActivity10 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity10 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity10, R.drawable.chat_room_lucky_fruit_time_null);
                        break;
                    }
                    break;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTime2(int time) {
        int i = time % 10;
        ImageView imageView = this.time2;
        if (imageView != null) {
            Drawable drawable = null;
            switch (i) {
                case 0:
                    Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity, R.drawable.chat_room_lucky_fruit_time_0);
                        break;
                    }
                    break;
                case 1:
                    Activity currentActivity2 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity2 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity2, R.drawable.chat_room_lucky_fruit_time_1);
                        break;
                    }
                    break;
                case 2:
                    Activity currentActivity3 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity3 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity3, R.drawable.chat_room_lucky_fruit_time_2);
                        break;
                    }
                    break;
                case 3:
                    Activity currentActivity4 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity4 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity4, R.drawable.chat_room_lucky_fruit_time_3);
                        break;
                    }
                    break;
                case 4:
                    Activity currentActivity5 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity5 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity5, R.drawable.chat_room_lucky_fruit_time_4);
                        break;
                    }
                    break;
                case 5:
                    Activity currentActivity6 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity6 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity6, R.drawable.chat_room_lucky_fruit_time_5);
                        break;
                    }
                    break;
                case 6:
                    Activity currentActivity7 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity7 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity7, R.drawable.chat_room_lucky_fruit_time_6);
                        break;
                    }
                    break;
                case 7:
                    Activity currentActivity8 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity8 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity8, R.drawable.chat_room_lucky_fruit_time_7);
                        break;
                    }
                    break;
                case 8:
                    Activity currentActivity9 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity9 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity9, R.drawable.chat_room_lucky_fruit_time_8);
                        break;
                    }
                    break;
                case 9:
                    Activity currentActivity10 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity10 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity10, R.drawable.chat_room_lucky_fruit_time_9);
                        break;
                    }
                    break;
                default:
                    Activity currentActivity11 = ActivityLifecycleManager.INSTANCE.currentActivity();
                    if (currentActivity11 != null) {
                        drawable = androidx.core.content.a.getDrawable(currentActivity11, R.drawable.chat_room_lucky_fruit_time_null);
                        break;
                    }
                    break;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFingerAnim$lambda$14(LuckyFruitAdapter luckyFruitAdapter, boolean z) {
        ImageView imageView = luckyFruitAdapter.imgFinger;
        if (imageView != null) {
            if (z && luckyFruitAdapter.isViewShowing && luckyFruitAdapter.gameType == 1) {
                imageView.setVisibility(0);
                Animation loadAnimation = AnimationUtils.loadAnimation(luckyFruitAdapter.getContext(), R.anim.chat_room_lucky_fruit_finger_anim);
                loadAnimation.setRepeatMode(1);
                loadAnimation.setRepeatCount(-1);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitAdapter$startFingerAnim$1$1$1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (animation != null) {
                            animation.reset();
                            animation.start();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                imageView.startAnimation(loadAnimation);
                return;
            }
            imageView.setVisibility(8);
            imageView.clearAnimation();
        }
    }

    private final void stopAnimTaskCycle() {
        nd.c cVar = this.animTaskCycle;
        if (cVar != null && !cVar.isDisposed()) {
            cVar.dispose();
        }
        this.animTaskCycle = null;
    }

    private final void timeCountDown(int time, final boolean isNewRound) {
        releaseTaskCycle();
        if (time <= 0) {
            return;
        }
        this.centerTimeCount = time;
        this.mTaskCycle = io.reactivex.rxjava3.core.z.interval(0L, 1000L, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitAdapter$timeCountDown$1
            public final void accept(Long l) {
                int i;
                boolean z;
                int i2;
                int i3;
                int i4;
                Intrinsics.checkNotNullParameter(l, "it");
                i = LuckyFruitAdapter.this.centerTimeCount;
                if (i < 0) {
                    LuckyFruitAdapter.this.releaseTaskCycle();
                    if (LuckyFruitAdapter.this.getGameType() == 2 || isNewRound) {
                        LuckyFruitAdapter.this.setItemClickable(false);
                        LuckyFruitAdapter.this.setGameType(2);
                        Function2<Integer, Boolean, Unit> onGameTypeListener = LuckyFruitAdapter.this.getOnGameTypeListener();
                        if (onGameTypeListener != null) {
                            onGameTypeListener.invoke(2, Boolean.valueOf(isNewRound));
                        }
                        LuckyFruitAdapter.this.startLotteryRound(0, 10);
                        return;
                    }
                    return;
                }
                z = LuckyFruitAdapter.this.isViewShowing;
                if (z) {
                    if (LuckyFruitAdapter.this.getGameType() == 3) {
                        LuckyFruitAdapter.this.setTime1(10);
                        LuckyFruitAdapter.this.setTime2(10);
                    } else {
                        LuckyFruitAdapter luckyFruitAdapter = LuckyFruitAdapter.this;
                        i3 = luckyFruitAdapter.centerTimeCount;
                        luckyFruitAdapter.setTime1(i3);
                        LuckyFruitAdapter luckyFruitAdapter2 = LuckyFruitAdapter.this;
                        i4 = luckyFruitAdapter2.centerTimeCount;
                        luckyFruitAdapter2.setTime2(i4);
                    }
                }
                i2 = LuckyFruitAdapter.this.centerTimeCount;
                LuckyFruitAdapter.this.centerTimeCount = i2 - 1;
            }
        });
    }

    @NotNull
    public final String getGameId() {
        return this.gameId;
    }

    public final int getGameType() {
        return this.gameType;
    }

    @Nullable
    public final LuckyFruitBean getItemById(int resultId) {
        for (LuckyFruitBean luckyFruitBean : getListData()) {
            if (luckyFruitBean.getMId() == resultId) {
                return luckyFruitBean;
            }
        }
        return null;
    }

    @Nullable
    public final Function2<Integer, Boolean, Unit> getOnGameTypeListener() {
        return this.onGameTypeListener;
    }

    @Nullable
    public final OnResult<Integer> getOnShowResultListener() {
        return this.onShowResultListener;
    }

    public final int getPlaceSize() {
        Iterator<LuckyFruitBean> it = getListData().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getStake() > 0) {
                i++;
            }
        }
        return i;
    }

    public final int getResultId() {
        return this.resultId;
    }

    public final int getResultIdRound() {
        return this.resultIdRound;
    }

    /* renamed from: isPlaceBet, reason: from getter */
    public final boolean getIsPlaceBet() {
        return this.isPlaceBet;
    }

    @Override // com.qiahao.nextvideo.room.luckyfruit.LuckyGridViewAdapter
    public void onAddView(@NotNull LuckyBaseGridView parentView) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        ImageView imageView = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = parentView.getItemWidth();
        layoutParams.height = parentView.getItemHeight();
        layoutParams.leftMargin = parentView.getItemWidth() / 4;
        layoutParams.topMargin = parentView.getItemHeight() / 4;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(layoutParams);
        Context context = getContext();
        if (context != null) {
            drawable = androidx.core.content.a.getDrawable(context, R.drawable.chat_room_lucky_fruit_finger);
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        this.imgFinger = imageView;
        parentView.addView(imageView);
    }

    public final void placeBet(int id2, long gold) {
        int size = getListData().size();
        for (int i = 0; i < size; i++) {
            if (id2 == getListData().get(i).getMId()) {
                getListData().get(i).setStake(gold);
                View itemView = getItemView(i);
                if (itemView != null) {
                    itemView.findViewById(R.id.fl_gold).setVisibility(0);
                    ((TextView) itemView.findViewById(R.id.tv_gold)).setText(NumberUtilsKt.formatNumberWithSuffix(getListData().get(i).getStake(), 3));
                    ((ProgressBar) itemView.findViewById(R.id.progress_bar)).setVisibility(8);
                }
                this.isPlaceBet = true;
                return;
            }
        }
    }

    public final void release() {
        setIsViewShowing(false);
        this.onShowResultListener = null;
        this.onGameTypeListener = null;
        releaseTaskCycle();
        stopAnimTaskCycle();
    }

    public final void setGameId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameId = str;
    }

    public final void setGameType(int i) {
        this.gameType = i;
    }

    public final void setIsViewShowing(boolean isShow) {
        this.isViewShowing = isShow;
        setBorderAnim(isShow);
        startFingerAnim(isShow);
        if (isShow) {
            setTime1(this.centerTimeCount);
            setTime2(this.centerTimeCount);
            int i = this.gameType;
            if (i == 2) {
                for (View view : getListView()) {
                    view.findViewById(R.id.view_select_nor).setVisibility(0);
                    view.findViewById(R.id.view_selected).setVisibility(8);
                }
                return;
            }
            if (i == 1 && !this.isLoadRoundView) {
                for (View view2 : getListView()) {
                    view2.findViewById(R.id.fl_gold).setVisibility(8);
                    view2.findViewById(R.id.view_select_nor).setVisibility(8);
                    view2.findViewById(R.id.view_selected).setVisibility(8);
                }
                this.isLoadRoundView = true;
            }
        }
    }

    public final void setOnGameTypeListener(@Nullable Function2<? super Integer, ? super Boolean, Unit> function2) {
        this.onGameTypeListener = function2;
    }

    public final void setOnShowResultListener(@Nullable OnResult<Integer> onResult) {
        this.onShowResultListener = onResult;
    }

    public final void setPlaceBet(boolean z) {
        this.isPlaceBet = z;
    }

    public final void setResult(int id2) {
        int size;
        OnResult<Integer> onResult;
        this.resultId = id2;
        int size2 = getListData().size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size2) {
                break;
            }
            if (getListData().get(i2).getMId() == this.resultId) {
                i = i2 + 1;
                break;
            }
            i2++;
        }
        int i3 = this.currentCount;
        if (i3 < 64) {
            i3 = 64;
        }
        int size3 = i3 % getListData().size();
        if (i >= size3) {
            size = i3 + (i - size3);
        } else {
            size = i3 + (getListData().size() - (size3 - i));
        }
        this.selectCount = size;
        if (this.currentCount == size && (onResult = this.onShowResultListener) != null) {
            onResult.onResult(Integer.valueOf(this.resultId));
        }
    }

    public final void setResultId(int i) {
        this.resultId = i;
    }

    public final void setResultIdRound(int i) {
        this.resultIdRound = i;
    }

    public final void showGameTimeType2Status(int resultId, int time) {
        setItemClickable(false);
        startLotteryRound(resultId, time);
    }

    public final void showPlaceBetProgress(int position, boolean isVisibility) {
        View findViewById;
        int i;
        View itemView = getItemView(position);
        if (itemView != null && (findViewById = itemView.findViewById(R.id.progress_bar)) != null) {
            if (isVisibility) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
    }

    public final void startFingerAnim(final boolean isStart) {
        ImageView imageView = this.imgFinger;
        if (imageView != null) {
            imageView.post(new Runnable() { // from class: com.qiahao.nextvideo.room.luckyfruit.e
                @Override // java.lang.Runnable
                public final void run() {
                    LuckyFruitAdapter.startFingerAnim$lambda$14(LuckyFruitAdapter.this, isStart);
                }
            });
        }
    }

    public final void startLotteryRound(int resultId, int time) {
        if (time <= 0) {
            return;
        }
        int i = 0;
        if (this.isViewShowing) {
            for (View view : getListView()) {
                if (view.findViewById(R.id.fl_gold).getVisibility() == 0) {
                    view.findViewById(R.id.view_select_nor).setVisibility(8);
                } else {
                    view.findViewById(R.id.view_select_nor).setVisibility(0);
                }
                view.findViewById(R.id.view_selected).setVisibility(8);
            }
        }
        startFingerAnim(false);
        timeCountDown(time, false);
        stopAnimTaskCycle();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (time < 10) {
            intRef.element = (10 - time) * 992;
            switch (time) {
                case 1:
                    i = 58;
                    break;
                case 2:
                    i = 55;
                    break;
                case 3:
                    i = 52;
                    break;
                case 4:
                    i = 47;
                    break;
                case 5:
                    i = 42;
                    break;
                case 6:
                    i = 37;
                    break;
                case 7:
                    i = 32;
                    break;
                case 8:
                    i = 24;
                    break;
                case 9:
                    i = 16;
                    break;
            }
            this.currentCount = i;
        }
        if (resultId > 0) {
            setResult(resultId);
        }
        this.animTaskCycle = io.reactivex.rxjava3.core.z.interval(0L, 62L, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitAdapter$startLotteryRound$1
            public final void accept(Long l) {
                int i2;
                int i3;
                Intrinsics.checkNotNullParameter(l, "it");
                Ref.IntRef intRef2 = intRef;
                int i4 = intRef2.element + 62;
                intRef2.element = i4;
                if (i4 < 0 || i4 >= 1001) {
                    if (1001 > i4 || i4 >= 3001) {
                        if (3001 <= i4 && i4 < 7001) {
                            if (i4 % UserProxyUtility.surePKMicChange != 0) {
                                return;
                            }
                        } else if (i4 % 248 != 0) {
                            return;
                        }
                    } else if (i4 % 124 != 0) {
                        return;
                    }
                }
                i2 = this.currentCount;
                this.currentCount = i2 + 1;
                this.onItemSelectLottery();
                int i5 = intRef.element;
                i3 = this.currentCount;
                Log.d("startLotteryRound", i5 + "___" + i3);
            }
        });
    }

    public final void startTimeRound(int countDownTime) {
        timeCountDown(countDownTime, true);
        setItemClickable(true);
        this.isPlaceBet = false;
        if (this.isViewShowing) {
            this.isLoadRoundView = true;
            for (View view : getListView()) {
                view.findViewById(R.id.fl_gold).setVisibility(8);
                view.findViewById(R.id.view_select_nor).setVisibility(8);
                view.findViewById(R.id.view_selected).setVisibility(8);
            }
        } else {
            this.isLoadRoundView = false;
        }
        Iterator<LuckyFruitBean> it = getListData().iterator();
        while (it.hasNext()) {
            it.next().setStake(0L);
        }
        startFingerAnim(true);
        this.currentCount = 0;
        this.selectCount = 0;
        stopAnimTaskCycle();
        this.resultId = 0;
        this.resultIdRound = 0;
    }

    public final void updateRate(int id2, int rate) {
        int size = getListData().size();
        for (int i = 0; i < size; i++) {
            if (getListData().get(i).getMId() == id2 && rate != getListData().get(i).getRate()) {
                getListData().get(i).setRate(rate);
                View itemView = getItemView(i);
                if (itemView != null) {
                    ((TextView) itemView.findViewById(2131364012)).setText(getListData().get(i).getDes());
                    return;
                }
                return;
            }
        }
    }

    @Override // com.qiahao.nextvideo.room.luckyfruit.LuckyGridViewAdapter
    public void convert(@Nullable View itemView, @NotNull LuckyFruitBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (itemView != null) {
            TextView textView = (TextView) itemView.findViewById(2131364012);
            if (textView != null) {
                textView.setText(item.getDes());
                if (item.getTextColor() != 0) {
                    textView.setTextColor(item.getTextColor());
                }
            }
            ImageView imageView = (ImageView) itemView.findViewById(2131363201);
            if (imageView != null) {
                imageView.setImageDrawable(item.getItemDrawable());
            }
        }
    }
}
