package com.qiahao.nextvideo.ui.foodie;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.wedgit.overlayView.CustomOverlayView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.foodie.FoodieBetBean;
import com.qiahao.nextvideo.data.foodie.FoodieGameInfo;
import com.qiahao.nextvideo.data.foodie.FoodieHotBean;
import com.qiahao.nextvideo.data.foodie.FoodieHotMessage;
import com.qiahao.nextvideo.data.foodie.FoodieItem;
import com.qiahao.nextvideo.databinding.ViewFoodieWheelBinding;
import com.qiahao.nextvideo.utilities.AnimationHelper;
import com.qiahao.nextvideo.utilities.AnimatorType;
import com.qiahao.nextvideo.utilities.AnimatorViewSet;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 z2\u00020\u0001:\u0001zB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0003¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\fJ\u000f\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010\fJ\u000f\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010\fJ\u000f\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010\fJ\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010\fJ\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\fJ\u000f\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010\fJ\u001d\u0010,\u001a\u00020\n2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\n¢\u0006\u0004\b.\u0010\fJ\u0015\u00101\u001a\u00020\n2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J\u001d\u00106\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00062\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u001d\u0010:\u001a\u00020\n2\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\r¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\n¢\u0006\u0004\b<\u0010\fJ\u0015\u0010=\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b=\u0010\u0017J\u0015\u0010>\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b>\u0010\u001aJ\r\u0010?\u001a\u00020\n¢\u0006\u0004\b?\u0010\fJ\r\u0010@\u001a\u00020\n¢\u0006\u0004\b@\u0010\fJ\r\u0010A\u001a\u00020\n¢\u0006\u0004\bA\u0010\fJ\r\u0010B\u001a\u00020\n¢\u0006\u0004\bB\u0010\fJ\r\u0010C\u001a\u00020\n¢\u0006\u0004\bC\u0010\fJ\r\u0010D\u001a\u00020\n¢\u0006\u0004\bD\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010E\u001a\u0004\bF\u0010GR*\u0010I\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010TR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\"\u0010c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010\u001aR'\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010X\u001a\u0004\bj\u0010kR\u0016\u0010m\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010dR\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010dR\u0018\u0010q\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010v\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010uR\u001c\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00060w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006{"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieWheelLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "initEvent", "()V", "Lcom/qiahao/nextvideo/data/foodie/FoodieItem;", "item", "onClickItem", "(Lcom/qiahao/nextvideo/data/foodie/FoodieItem;)V", "showResultAndGotoResultActivity", "fingerPick", "marqueeLight", "Lcom/qiahao/nextvideo/data/foodie/FoodieGameInfo;", "info", "fillData", "(Lcom/qiahao/nextvideo/data/foodie/FoodieGameInfo;)V", "left", "setCountDownText", "(I)V", "seconds", "startCenterCountDown", "", "isResult", "setCenterAreaState", "(Z)V", "playResultTextAnim", "startWheeling", "slowLoop", "fastLoop", "loopWheelItem", "dismissCurtainGuide", "resetAllShadowNoFinger", "Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;", "mViewModel", "Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "foodieGameDialog", "setViewModel", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;)V", "initView", "Lcom/qiahao/nextvideo/data/foodie/FoodieHotMessage;", "msg", "setHotItem", "(Lcom/qiahao/nextvideo/data/foodie/FoodieHotMessage;)V", "foodieId", "", "repeatDiamond", "checkFoodieItem", "(IJ)V", "addMoney", Constants.KEY_TARGET, "refreshItemBet", "(ILcom/qiahao/nextvideo/data/foodie/FoodieItem;)V", "setResultItemPositions", "setDataAndStart", "showEnd", "resetData", "resetItemBeanHasDrawState", "cleanItemHots", "removeHotTag", "onResume", "cleanCountDown", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Lkotlin/Function0;", "mListener", "Lkotlin/jvm/functions/Function0;", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/qiahao/nextvideo/databinding/ViewFoodieWheelBinding;", "mBinding", "Lcom/qiahao/nextvideo/databinding/ViewFoodieWheelBinding;", "Landroid/os/CountDownTimer;", "mCountDownHelper", "Landroid/os/CountDownTimer;", "mEndHelper", "Lcom/qiahao/nextvideo/ui/foodie/FoodieAnimHelper;", "mFoodieAnimHelper$delegate", "Lkotlin/Lazy;", "getMFoodieAnimHelper", "()Lcom/qiahao/nextvideo/ui/foodie/FoodieAnimHelper;", "mFoodieAnimHelper", "Lcom/qiahao/nextvideo/ui/foodie/FoodieResultDialog;", "resultDialog", "Lcom/qiahao/nextvideo/ui/foodie/FoodieResultDialog;", "mGameDialog", "Lcom/qiahao/nextvideo/ui/foodie/FoodieGameDialog;", "viewModel", "Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;", "marquePictureIndex", "I", "getMarquePictureIndex", "()I", "setMarquePictureIndex", "", "mFoodieItemMap$delegate", "getMFoodieItemMap", "()Ljava/util/Map;", "mFoodieItemMap", "mIsCountDownFinished", "Z", "mHighLightPosition", "mFingerPickPosition", "mPreviousHighLightItem", "Lcom/qiahao/nextvideo/data/foodie/FoodieItem;", "Lnd/c;", "mSlowWheelingDisposable", "Lnd/c;", "mFastWheelingDisposable", "", "mResultItemPositions", "Ljava/util/List;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFoodieWheelLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoodieWheelLayout.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieWheelLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,562:1\n1#2:563\n1869#3,2:564\n1869#3,2:566\n1869#3,2:572\n1878#3,3:574\n1563#3:577\n1634#3,3:578\n1869#3,2:581\n1869#3,2:583\n1869#3,2:585\n1869#3,2:587\n1869#3,2:589\n216#4,2:568\n216#4,2:570\n*S KotlinDebug\n*F\n+ 1 FoodieWheelLayout.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieWheelLayout\n*L\n104#1:564,2\n119#1:566,2\n198#1:572,2\n259#1:574,3\n317#1:577\n317#1:578,3\n318#1:581,2\n329#1:583,2\n516#1:585,2\n532#1:587,2\n538#1:589,2\n144#1:568,2\n194#1:570,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieWheelLayout extends FrameLayout {
    public static final long FAST_SPEED = 100;
    public static final long SLOW_SPEED = 200;
    private ViewFoodieWheelBinding mBinding;

    @NotNull
    private final Context mContext;

    @Nullable
    private CountDownTimer mCountDownHelper;

    @Nullable
    private CountDownTimer mEndHelper;

    @Nullable
    private nd.c mFastWheelingDisposable;
    private int mFingerPickPosition;

    /* renamed from: mFoodieAnimHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFoodieAnimHelper;

    /* renamed from: mFoodieItemMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFoodieItemMap;

    @Nullable
    private FoodieGameDialog mGameDialog;
    private int mHighLightPosition;
    private boolean mIsCountDownFinished;

    @Nullable
    private Function0<Unit> mListener;

    @Nullable
    private FoodieItem mPreviousHighLightItem;

    @NotNull
    private List<Integer> mResultItemPositions;

    @Nullable
    private nd.c mSlowWheelingDisposable;
    private int marquePictureIndex;

    @Nullable
    private FoodieResultDialog resultDialog;

    @Nullable
    private FoodieViewModel viewModel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieWheelLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    private final void dismissCurtainGuide() {
        CustomOverlayView overlayView;
        FoodieGameDialog foodieGameDialog = this.mGameDialog;
        if (foodieGameDialog != null && (overlayView = foodieGameDialog.getOverlayView()) != null) {
            overlayView.setVisibility(8);
        }
    }

    private final void fastLoop() {
        nd.c cVar = this.mFastWheelingDisposable;
        if (cVar != null) {
            cVar.dispose();
        }
        this.mFastWheelingDisposable = io.reactivex.rxjava3.core.z.interval(0L, 100L, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieWheelLayout$fastLoop$1
            public final void accept(Long l) {
                Intrinsics.checkNotNullParameter(l, "it");
                FoodieWheelLayout.this.loopWheelItem();
            }
        });
    }

    private final void fillData(FoodieGameInfo info) {
        Map map;
        boolean z;
        FoodieViewModel foodieViewModel;
        Set<Integer> selectedPositionSet;
        FoodieBetBean foodieBetBean;
        Object obj;
        List<FoodieBetBean> betRate = info.getBetRate();
        if (betRate == null) {
            betRate = new ArrayList<>();
        }
        List<FoodieBetBean> betInfo = info.getBetInfo();
        if (betInfo != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(betInfo, 10));
            for (FoodieBetBean foodieBetBean2 : betInfo) {
                arrayList.add(new Pair(Integer.valueOf(foodieBetBean2.getFoodieId()), foodieBetBean2));
            }
            map = MapsKt.toMap(arrayList);
        } else {
            map = null;
        }
        for (FoodieBetBean foodieBetBean3 : betRate) {
            if (map != null) {
                foodieBetBean = (FoodieBetBean) map.get(Integer.valueOf(foodieBetBean3.getFoodieId()));
            } else {
                foodieBetBean = null;
            }
            if (foodieBetBean != null) {
                foodieBetBean3.setHasBet(true);
                foodieBetBean3.setFoodieId(foodieBetBean.getFoodieId());
                foodieBetBean3.setDiamond(foodieBetBean.getDiamond());
            }
            Iterator<T> it = getMFoodieItemMap().values().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (foodieBetBean3.getFoodieId() == ((FoodieItem) obj).getType()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            FoodieItem foodieItem = (FoodieItem) obj;
            if (foodieItem != null) {
                foodieItem.setBetBean(foodieBetBean3);
            }
        }
        for (FoodieItem foodieItem2 : getMFoodieItemMap().values()) {
            foodieItem2.getView().setData(foodieItem2.getBetBean());
            FoodieBetBean betBean = foodieItem2.getBetBean();
            if (betBean != null) {
                z = betBean.getHasBet();
            } else {
                z = false;
            }
            if (z && (foodieViewModel = this.viewModel) != null && (selectedPositionSet = foodieViewModel.getSelectedPositionSet()) != null) {
                selectedPositionSet.add(Integer.valueOf(foodieItem2.getPosition()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fingerPick() {
        boolean z;
        int i = this.mFingerPickPosition % 8;
        Iterator<T> it = getMFoodieItemMap().values().iterator();
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (it.hasNext()) {
                Object next = it.next();
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FoodieItem foodieItem = (FoodieItem) next;
                FoodieItemView view = foodieItem.getView();
                if (i2 != i) {
                    z2 = false;
                }
                view.setFingerVisibility(z2);
                FoodieBetBean betBean = foodieItem.getBetBean();
                if (betBean != null) {
                    z = betBean.getHasBet();
                } else {
                    z = false;
                }
                if (!z && i2 != i) {
                    foodieItem.getView().setState(FoodieItemState.NORMAL);
                } else {
                    foodieItem.getView().setState(FoodieItemState.PICKED);
                }
                i2 = i3;
            } else {
                this.mFingerPickPosition++;
                return;
            }
        }
    }

    private final FoodieAnimHelper getMFoodieAnimHelper() {
        return (FoodieAnimHelper) this.mFoodieAnimHelper.getValue();
    }

    private final Map<Integer, FoodieItem> getMFoodieItemMap() {
        return (Map) this.mFoodieItemMap.getValue();
    }

    private final void initEvent() {
        FoodieViewModel foodieViewModel;
        MutableLiveData<Boolean> resultActivityFinishObserver;
        FoodieGameDialog foodieGameDialog = this.mGameDialog;
        if (foodieGameDialog != null && (foodieViewModel = this.viewModel) != null && (resultActivityFinishObserver = foodieViewModel.getResultActivityFinishObserver()) != null) {
            resultActivityFinishObserver.observe(foodieGameDialog, new FoodieWheelLayout$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.q1
                public final Object invoke(Object obj) {
                    Unit initEvent$lambda$10$lambda$9;
                    initEvent$lambda$10$lambda$9 = FoodieWheelLayout.initEvent$lambda$10$lambda$9(FoodieWheelLayout.this, (Boolean) obj);
                    return initEvent$lambda$10$lambda$9;
                }
            }));
        }
        for (final FoodieItem foodieItem : getMFoodieItemMap().values()) {
            foodieItem.getView().setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.r1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FoodieWheelLayout.this.onClickItem(foodieItem);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initEvent$lambda$10$lambda$9(FoodieWheelLayout foodieWheelLayout, Boolean bool) {
        foodieWheelLayout.dismissCurtainGuide();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loopWheelItem() {
        FoodiePageState foodiePageState;
        FoodieItemView view;
        FoodieItemView view2;
        int i = this.mHighLightPosition + 1;
        this.mHighLightPosition = i;
        FoodieItem foodieItem = getMFoodieItemMap().get(Integer.valueOf(i % 8));
        if (foodieItem != null && (view2 = foodieItem.getView()) != null) {
            view2.setState(FoodieItemState.DRAWING_HIGHLIGHT);
        }
        FoodieItem foodieItem2 = this.mPreviousHighLightItem;
        if (foodieItem2 != null && (view = foodieItem2.getView()) != null) {
            view.setState(FoodieItemState.DRAWING_SHADOW);
        }
        this.mPreviousHighLightItem = foodieItem;
        if (this.mHighLightPosition == 8) {
            nd.c cVar = this.mSlowWheelingDisposable;
            if (cVar != null) {
                cVar.dispose();
            }
            fastLoop();
        }
        if (this.mIsCountDownFinished) {
            FoodieViewModel foodieViewModel = this.viewModel;
            if (foodieViewModel != null) {
                foodiePageState = foodieViewModel.getPageState();
            } else {
                foodiePageState = null;
            }
            FoodiePageState foodiePageState2 = FoodiePageState.RESULT;
            if (foodiePageState != foodiePageState2) {
                FoodieViewModel foodieViewModel2 = this.viewModel;
                if (foodieViewModel2 != null) {
                    foodieViewModel2.changePageState(foodiePageState2);
                }
                showResultAndGotoResultActivity();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FoodieAnimHelper mFoodieAnimHelper_delegate$lambda$0() {
        return new FoodieAnimHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map mFoodieItemMap_delegate$lambda$1(FoodieWheelLayout foodieWheelLayout) {
        ViewFoodieWheelBinding viewFoodieWheelBinding = foodieWheelLayout.mBinding;
        if (viewFoodieWheelBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding = null;
        }
        FoodieItemView foodieItemView = viewFoodieWheelBinding.foodieItem0;
        Intrinsics.checkNotNullExpressionValue(foodieItemView, "foodieItem0");
        Pair pair = TuplesKt.to(0, new FoodieItem(0, 1, foodieItemView, null, 8, null));
        ViewFoodieWheelBinding viewFoodieWheelBinding2 = foodieWheelLayout.mBinding;
        if (viewFoodieWheelBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding2 = null;
        }
        FoodieItemView foodieItemView2 = viewFoodieWheelBinding2.foodieItem1;
        Intrinsics.checkNotNullExpressionValue(foodieItemView2, "foodieItem1");
        Pair pair2 = TuplesKt.to(1, new FoodieItem(1, 2, foodieItemView2, null, 8, null));
        ViewFoodieWheelBinding viewFoodieWheelBinding3 = foodieWheelLayout.mBinding;
        if (viewFoodieWheelBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding3 = null;
        }
        FoodieItemView foodieItemView3 = viewFoodieWheelBinding3.foodieItem2;
        Intrinsics.checkNotNullExpressionValue(foodieItemView3, "foodieItem2");
        Pair pair3 = TuplesKt.to(2, new FoodieItem(2, 3, foodieItemView3, null, 8, null));
        ViewFoodieWheelBinding viewFoodieWheelBinding4 = foodieWheelLayout.mBinding;
        if (viewFoodieWheelBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding4 = null;
        }
        FoodieItemView foodieItemView4 = viewFoodieWheelBinding4.foodieItem3;
        Intrinsics.checkNotNullExpressionValue(foodieItemView4, "foodieItem3");
        Pair pair4 = TuplesKt.to(3, new FoodieItem(3, 4, foodieItemView4, null, 8, null));
        ViewFoodieWheelBinding viewFoodieWheelBinding5 = foodieWheelLayout.mBinding;
        if (viewFoodieWheelBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding5 = null;
        }
        FoodieItemView foodieItemView5 = viewFoodieWheelBinding5.foodieItem4;
        Intrinsics.checkNotNullExpressionValue(foodieItemView5, "foodieItem4");
        Pair pair5 = TuplesKt.to(4, new FoodieItem(4, 5, foodieItemView5, null, 8, null));
        ViewFoodieWheelBinding viewFoodieWheelBinding6 = foodieWheelLayout.mBinding;
        if (viewFoodieWheelBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding6 = null;
        }
        FoodieItemView foodieItemView6 = viewFoodieWheelBinding6.foodieItem5;
        Intrinsics.checkNotNullExpressionValue(foodieItemView6, "foodieItem5");
        Pair pair6 = TuplesKt.to(5, new FoodieItem(5, 6, foodieItemView6, null, 8, null));
        ViewFoodieWheelBinding viewFoodieWheelBinding7 = foodieWheelLayout.mBinding;
        if (viewFoodieWheelBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding7 = null;
        }
        FoodieItemView foodieItemView7 = viewFoodieWheelBinding7.foodieItem6;
        Intrinsics.checkNotNullExpressionValue(foodieItemView7, "foodieItem6");
        Pair pair7 = TuplesKt.to(6, new FoodieItem(6, 7, foodieItemView7, null, 8, null));
        ViewFoodieWheelBinding viewFoodieWheelBinding8 = foodieWheelLayout.mBinding;
        if (viewFoodieWheelBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding8 = null;
        }
        FoodieItemView foodieItemView8 = viewFoodieWheelBinding8.foodieItem7;
        Intrinsics.checkNotNullExpressionValue(foodieItemView8, "foodieItem7");
        return MapsKt.mutableMapOf(new Pair[]{pair, pair2, pair3, pair4, pair5, pair6, pair7, TuplesKt.to(7, new FoodieItem(7, 8, foodieItemView8, null, 8, null))});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void marqueeLight() {
        ViewFoodieWheelBinding viewFoodieWheelBinding = null;
        if (this.marquePictureIndex % 2 == 0) {
            ViewFoodieWheelBinding viewFoodieWheelBinding2 = this.mBinding;
            if (viewFoodieWheelBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                viewFoodieWheelBinding = viewFoodieWheelBinding2;
            }
            viewFoodieWheelBinding.ivCenterMarquee.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_marquee_1));
        } else {
            ViewFoodieWheelBinding viewFoodieWheelBinding3 = this.mBinding;
            if (viewFoodieWheelBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                viewFoodieWheelBinding = viewFoodieWheelBinding3;
            }
            viewFoodieWheelBinding.ivCenterMarquee.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_marquee_2));
        }
        this.marquePictureIndex++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickItem(FoodieItem item) {
        FoodiePageState foodiePageState;
        FoodieViewModel foodieViewModel;
        int i;
        Set<Integer> selectedPositionSet;
        Set<Integer> selectedPositionSet2;
        FoodieViewModel foodieViewModel2 = this.viewModel;
        FoodiePageState foodiePageState2 = null;
        if (foodieViewModel2 != null) {
            foodiePageState = foodieViewModel2.getPageState();
        } else {
            foodiePageState = null;
        }
        if (foodiePageState == FoodiePageState.NORMAL) {
            FoodieViewModel foodieViewModel3 = this.viewModel;
            boolean z = false;
            if (foodieViewModel3 != null && (selectedPositionSet2 = foodieViewModel3.getSelectedPositionSet()) != null) {
                i = selectedPositionSet2.size();
            } else {
                i = 0;
            }
            if (i >= 6) {
                FoodieViewModel foodieViewModel4 = this.viewModel;
                if (foodieViewModel4 != null && (selectedPositionSet = foodieViewModel4.getSelectedPositionSet()) != null && selectedPositionSet.contains(Integer.valueOf(item.getPosition()))) {
                    z = true;
                }
                if (!z) {
                    return;
                }
            }
            getMFoodieAnimHelper().playSelectAnim(item.getView());
            FoodieViewModel foodieViewModel5 = this.viewModel;
            if (foodieViewModel5 != null) {
                foodieViewModel5.pressFoodieItem(item);
                return;
            }
            return;
        }
        FoodieViewModel foodieViewModel6 = this.viewModel;
        if (foodieViewModel6 != null) {
            foodiePageState2 = foodieViewModel6.getPageState();
        }
        if (foodiePageState2 != FoodiePageState.RESULT && (foodieViewModel = this.viewModel) != null) {
            foodieViewModel.getPageState();
        }
    }

    private final void playResultTextAnim() {
        ViewFoodieWheelBinding viewFoodieWheelBinding = this.mBinding;
        ViewFoodieWheelBinding viewFoodieWheelBinding2 = null;
        if (viewFoodieWheelBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding = null;
        }
        viewFoodieWheelBinding.flResult.setVisibility(0);
        AnimationHelper animationHelper = AnimationHelper.INSTANCE;
        ViewFoodieWheelBinding viewFoodieWheelBinding3 = this.mBinding;
        if (viewFoodieWheelBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            viewFoodieWheelBinding2 = viewFoodieWheelBinding3;
        }
        ConstraintLayout constraintLayout = viewFoodieWheelBinding2.flResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "flResult");
        animationHelper.start(animationHelper.with(animationHelper.startMyAnimator(constraintLayout, AnimatorType.ScaleX, 10.0f, 1.0f, 500L, 1, new AccelerateDecelerateInterpolator()), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.s1
            public final Object invoke(Object obj) {
                ObjectAnimator playResultTextAnim$lambda$29;
                playResultTextAnim$lambda$29 = FoodieWheelLayout.playResultTextAnim$lambda$29((AnimatorViewSet) obj);
                return playResultTextAnim$lambda$29;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObjectAnimator playResultTextAnim$lambda$29(AnimatorViewSet animatorViewSet) {
        Intrinsics.checkNotNullParameter(animatorViewSet, "it");
        return AnimationHelper.INSTANCE.startObjectAnimator(animatorViewSet, AnimatorType.ScaleY, 10.0f, 1.0f, 500L, 1, new AccelerateDecelerateInterpolator());
    }

    private final void resetAllShadowNoFinger() {
        for (FoodieItem foodieItem : getMFoodieItemMap().values()) {
            boolean z = false;
            foodieItem.getView().setFingerVisibility(false);
            FoodieBetBean betBean = foodieItem.getBetBean();
            if (betBean != null) {
                z = betBean.getHasBet();
            }
            if (z) {
                foodieItem.getView().setState(FoodieItemState.PICKED);
            } else {
                foodieItem.getView().setState(FoodieItemState.NORMAL);
            }
            foodieItem.getView().setState(FoodieItemState.DRAWING_SHADOW);
        }
    }

    private final void setCenterAreaState(boolean isResult) {
        ViewFoodieWheelBinding viewFoodieWheelBinding = null;
        if (isResult) {
            ViewFoodieWheelBinding viewFoodieWheelBinding2 = this.mBinding;
            if (viewFoodieWheelBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                viewFoodieWheelBinding2 = null;
            }
            viewFoodieWheelBinding2.tvSelectTips.setVisibility(8);
            ViewFoodieWheelBinding viewFoodieWheelBinding3 = this.mBinding;
            if (viewFoodieWheelBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                viewFoodieWheelBinding = viewFoodieWheelBinding3;
            }
            viewFoodieWheelBinding.ivDog.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_dog_result));
            playResultTextAnim();
            return;
        }
        ViewFoodieWheelBinding viewFoodieWheelBinding4 = this.mBinding;
        if (viewFoodieWheelBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding4 = null;
        }
        viewFoodieWheelBinding4.tvSelectTips.setVisibility(0);
        ViewFoodieWheelBinding viewFoodieWheelBinding5 = this.mBinding;
        if (viewFoodieWheelBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding5 = null;
        }
        viewFoodieWheelBinding5.flResult.setVisibility(8);
        ViewFoodieWheelBinding viewFoodieWheelBinding6 = this.mBinding;
        if (viewFoodieWheelBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            viewFoodieWheelBinding = viewFoodieWheelBinding6;
        }
        viewFoodieWheelBinding.ivDog.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ic_foodie_dog_normal));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void setCountDownText(int left) {
        ViewFoodieWheelBinding viewFoodieWheelBinding = this.mBinding;
        if (viewFoodieWheelBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            viewFoodieWheelBinding = null;
        }
        viewFoodieWheelBinding.tvCountDownTime.setText(left + "s");
    }

    @SuppressLint({"SuspiciousIndentation"})
    private final void showResultAndGotoResultActivity() {
        FoodieGameDialog foodieGameDialog;
        FoodieGameDialog foodieGameDialog2;
        FragmentManager childFragmentManager;
        FoodieResultDialog foodieResultDialog;
        CustomOverlayView overlayView;
        FoodieItemView view;
        CustomOverlayView overlayView2;
        CustomOverlayView overlayView3;
        nd.c cVar = this.mSlowWheelingDisposable;
        if (cVar != null) {
            cVar.dispose();
        }
        nd.c cVar2 = this.mFastWheelingDisposable;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        final FoodieGameDialog foodieGameDialog3 = this.mGameDialog;
        if (foodieGameDialog3 != null && !foodieGameDialog3.isRemoving() && !foodieGameDialog3.isDetached()) {
            CountDownTimer countDownTimer = this.mEndHelper;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            removeHotTag();
            CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieWheelLayout$showResultAndGotoResultActivity$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(FadeViewHelper.DEFAULT_FADE_OUT_DELAY, 1000L);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    FoodieViewModel foodieViewModel;
                    FoodieViewModel foodieViewModel2;
                    FoodieViewModel foodieViewModel3;
                    FoodieResultDialog foodieResultDialog2;
                    FoodieResultDialog foodieResultDialog3;
                    foodieViewModel = FoodieWheelLayout.this.viewModel;
                    if (foodieViewModel != null) {
                        foodieViewModel.changePageState(FoodiePageState.NORMAL);
                    }
                    FoodieWheelLayout.this.resetData();
                    foodieViewModel2 = FoodieWheelLayout.this.viewModel;
                    if (foodieViewModel2 != null) {
                        foodieViewModel2.requestFoodieGameInfo();
                    }
                    foodieViewModel3 = FoodieWheelLayout.this.viewModel;
                    if (foodieViewModel3 != null) {
                        foodieViewModel3.requestOutSideRank();
                    }
                    foodieResultDialog2 = FoodieWheelLayout.this.resultDialog;
                    if (foodieResultDialog2 != null && foodieResultDialog2.isAdded() && foodieGameDialog3.isResumed() && !foodieGameDialog3.isStateSaved()) {
                        foodieResultDialog3 = FoodieWheelLayout.this.resultDialog;
                        if (foodieResultDialog3 != null) {
                            foodieResultDialog3.dismiss();
                        }
                        FoodieWheelLayout.this.resultDialog = null;
                    }
                    FoodieWheelLayout.this.mEndHelper = null;
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                }
            };
            this.mEndHelper = countDownTimer2;
            countDownTimer2.start();
            FoodieViewModel foodieViewModel = this.viewModel;
            if (foodieViewModel != null && !foodieViewModel.getIsOtherDialogShowing() && foodieGameDialog3.isResumed()) {
                Iterator<Map.Entry<Integer, FoodieItem>> it = getMFoodieItemMap().entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().getView().setState(FoodieItemState.DRAWING_SHADOW);
                }
                FoodieGameDialog foodieGameDialog4 = this.mGameDialog;
                if (foodieGameDialog4 != null && (overlayView3 = foodieGameDialog4.getOverlayView()) != null) {
                    overlayView3.clearTargetList();
                }
                Iterator<T> it2 = this.mResultItemPositions.iterator();
                while (it2.hasNext()) {
                    FoodieItem foodieItem = getMFoodieItemMap().get(Integer.valueOf(((Number) it2.next()).intValue()));
                    if (foodieItem != null && (view = foodieItem.getView()) != null) {
                        view.setState(FoodieItemState.DRAWING_HIGHLIGHT);
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int i = iArr[0];
                        int i2 = iArr[1];
                        int px = UiKtxKt.toPX(76) / 2;
                        FoodieGameDialog foodieGameDialog5 = this.mGameDialog;
                        if (foodieGameDialog5 != null && (overlayView2 = foodieGameDialog5.getOverlayView()) != null) {
                            float f = px;
                            overlayView2.setTargetCircle(i + f, i2 + f, f);
                        }
                    }
                }
                FoodieGameDialog foodieGameDialog6 = this.mGameDialog;
                if (foodieGameDialog6 != null && (overlayView = foodieGameDialog6.getOverlayView()) != null) {
                    overlayView.refreshView();
                }
                FoodieViewModel foodieViewModel2 = this.viewModel;
                if (foodieViewModel2 != null && (foodieGameDialog = this.mGameDialog) != null && foodieGameDialog.isAdded() && (foodieGameDialog2 = this.mGameDialog) != null && (childFragmentManager = foodieGameDialog2.getChildFragmentManager()) != null && !childFragmentManager.isStateSaved()) {
                    FoodieResultDialog foodieResultDialog2 = new FoodieResultDialog(foodieViewModel2);
                    this.resultDialog = foodieResultDialog2;
                    if (!foodieResultDialog2.isAdded() && (foodieResultDialog = this.resultDialog) != null) {
                        foodieResultDialog.show(childFragmentManager, "FoodieResultDialog");
                    }
                }
                removeHotTag();
            }
        }
    }

    private final void slowLoop() {
        nd.c cVar = this.mSlowWheelingDisposable;
        if (cVar != null) {
            cVar.dispose();
        }
        this.mSlowWheelingDisposable = io.reactivex.rxjava3.core.z.interval(200L, 200L, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieWheelLayout$slowLoop$1
            public final void accept(Long l) {
                Intrinsics.checkNotNullParameter(l, "it");
                FoodieWheelLayout.this.loopWheelItem();
            }
        });
    }

    private final void startCenterCountDown(int seconds) {
        FoodieViewModel foodieViewModel = this.viewModel;
        if (foodieViewModel != null) {
            foodieViewModel.changePageState(FoodiePageState.NORMAL);
        }
        setCountDownText(seconds);
        fingerPick();
        CountDownTimer countDownTimer = this.mCountDownHelper;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j = seconds * 1000;
        CountDownTimer countDownTimer2 = new CountDownTimer(j) { // from class: com.qiahao.nextvideo.ui.foodie.FoodieWheelLayout$startCenterCountDown$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                FoodieWheelLayout.this.showEnd(5);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                FoodieWheelLayout.this.setCountDownText((int) (millisUntilFinished / 1000));
                FoodieWheelLayout.this.marqueeLight();
                FoodieWheelLayout.this.fingerPick();
            }
        };
        this.mCountDownHelper = countDownTimer2;
        countDownTimer2.start();
    }

    private final void startWheeling() {
        FoodieItemView view;
        setCenterAreaState(true);
        FoodieViewModel foodieViewModel = this.viewModel;
        if (foodieViewModel != null) {
            foodieViewModel.changePageState(FoodiePageState.OPENING);
        }
        FoodieViewModel foodieViewModel2 = this.viewModel;
        if (foodieViewModel2 != null) {
            foodieViewModel2.playMusic(FoodieMusicType.WHEELING);
        }
        resetAllShadowNoFinger();
        this.mHighLightPosition = 0;
        FoodieItem foodieItem = getMFoodieItemMap().get(0);
        if (foodieItem != null && (view = foodieItem.getView()) != null) {
            view.setState(FoodieItemState.DRAWING_HIGHLIGHT);
        }
        this.mPreviousHighLightItem = getMFoodieItemMap().get(0);
        slowLoop();
    }

    public final void checkFoodieItem(int foodieId, long repeatDiamond) {
        FoodieBetBean betBean;
        for (Map.Entry<Integer, FoodieItem> entry : getMFoodieItemMap().entrySet()) {
            FoodieBetBean betBean2 = entry.getValue().getBetBean();
            if (betBean2 != null && betBean2.getFoodieId() == foodieId && (betBean = entry.getValue().getBetBean()) != null) {
                betBean.setDiamond(betBean.getDiamond() + repeatDiamond);
                betBean.setHasBet(true);
                entry.getValue().getView().onlyRefreshRate(betBean);
            }
        }
    }

    public final void cleanCountDown() {
        CountDownTimer countDownTimer = this.mEndHelper;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mEndHelper = null;
        CountDownTimer countDownTimer2 = this.mCountDownHelper;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        this.mCountDownHelper = null;
    }

    public final void cleanItemHots() {
        Iterator<T> it = getMFoodieItemMap().values().iterator();
        while (it.hasNext()) {
            ((FoodieItem) it.next()).getView().removeAllHot();
        }
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    public final int getMarquePictureIndex() {
        return this.marquePictureIndex;
    }

    public final void initView() {
        FoodieViewModel foodieViewModel;
        setCenterAreaState(false);
        FoodieGameDialog foodieGameDialog = this.mGameDialog;
        if (foodieGameDialog != null && (foodieViewModel = this.viewModel) != null) {
            foodieViewModel.initHotIconHelper(foodieGameDialog);
        }
    }

    public final void onResume() {
        FoodieResultDialog foodieResultDialog;
        FoodieGameDialog foodieGameDialog;
        FoodieGameDialog foodieGameDialog2;
        if (this.mEndHelper == null && (foodieResultDialog = this.resultDialog) != null && foodieResultDialog.isAdded() && (foodieGameDialog = this.mGameDialog) != null && foodieGameDialog.isResumed() && (foodieGameDialog2 = this.mGameDialog) != null && !foodieGameDialog2.isStateSaved()) {
            FoodieResultDialog foodieResultDialog2 = this.resultDialog;
            if (foodieResultDialog2 != null) {
                foodieResultDialog2.dismiss();
            }
            this.resultDialog = null;
        }
    }

    public final void refreshItemBet(int addMoney, @NotNull FoodieItem target) {
        Object obj;
        FoodieBetBean betBean;
        Intrinsics.checkNotNullParameter(target, Constants.KEY_TARGET);
        Iterator<T> it = getMFoodieItemMap().values().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((FoodieItem) obj).getType() == target.getType()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FoodieItem foodieItem = (FoodieItem) obj;
        if (foodieItem != null && (betBean = foodieItem.getBetBean()) != null) {
            betBean.setDiamond(betBean.getDiamond() + addMoney);
            betBean.setHasBet(true);
            foodieItem.getView().onlyRefreshRate(betBean);
        }
    }

    public final void removeHotTag() {
        FoodieHotIconHelper hotIconHelper;
        FoodieViewModel foodieViewModel = this.viewModel;
        if (foodieViewModel != null && (hotIconHelper = foodieViewModel.getHotIconHelper()) != null) {
            hotIconHelper.removeHotView();
        }
    }

    public final void resetData() {
        Set<Integer> selectedPositionSet;
        removeHotTag();
        FoodieViewModel foodieViewModel = this.viewModel;
        if (foodieViewModel != null && (selectedPositionSet = foodieViewModel.getSelectedPositionSet()) != null) {
            selectedPositionSet.clear();
        }
        this.mHighLightPosition = 0;
        this.mFingerPickPosition = 0;
        this.mPreviousHighLightItem = null;
        this.mIsCountDownFinished = false;
        CountDownTimer countDownTimer = this.mCountDownHelper;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        nd.c cVar = this.mSlowWheelingDisposable;
        if (cVar != null) {
            cVar.dispose();
        }
        nd.c cVar2 = this.mFastWheelingDisposable;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        this.mResultItemPositions.clear();
        dismissCurtainGuide();
    }

    public final void resetItemBeanHasDrawState() {
        Iterator<T> it = getMFoodieItemMap().values().iterator();
        while (it.hasNext()) {
            FoodieBetBean betBean = ((FoodieItem) it.next()).getBetBean();
            if (betBean != null) {
                betBean.setHasBet(false);
            }
        }
    }

    public final void setDataAndStart(@NotNull FoodieGameInfo info) {
        FoodiePageState foodiePageState;
        Intrinsics.checkNotNullParameter(info, "info");
        FoodieViewModel foodieViewModel = this.viewModel;
        FoodiePageState foodiePageState2 = null;
        if (foodieViewModel != null) {
            foodiePageState = foodieViewModel.getPageState();
        } else {
            foodiePageState = null;
        }
        int i = 0;
        if (foodiePageState == FoodiePageState.NORMAL) {
            setCenterAreaState(false);
            resetItemBeanHasDrawState();
            resetData();
            fillData(info);
            cleanItemHots();
        }
        Integer status = info.getStatus();
        if (status != null && status.intValue() == 1) {
            FoodieViewModel foodieViewModel2 = this.viewModel;
            if (foodieViewModel2 != null) {
                foodieViewModel2.playMusic(FoodieMusicType.BACKGROUND);
            }
            Long remainSecond = info.getRemainSecond();
            if (remainSecond != null) {
                i = (int) remainSecond.longValue();
            }
            startCenterCountDown(i);
            return;
        }
        if (status != null && status.intValue() == 2) {
            FoodieViewModel foodieViewModel3 = this.viewModel;
            if (foodieViewModel3 != null) {
                foodiePageState2 = foodieViewModel3.getPageState();
            }
            if (foodiePageState2 == FoodiePageState.OPENING) {
                return;
            }
            setResultItemPositions();
            Long remainSecond2 = info.getRemainSecond();
            if (remainSecond2 != null) {
                i = (int) remainSecond2.longValue();
            }
            showEnd(i);
            return;
        }
        if (status != null && status.intValue() == 3) {
            FoodieViewModel foodieViewModel4 = this.viewModel;
            if (foodieViewModel4 != null) {
                foodiePageState2 = foodieViewModel4.getPageState();
            }
            FoodiePageState foodiePageState3 = FoodiePageState.RESULT;
            if (foodiePageState2 != foodiePageState3) {
                setResultItemPositions();
                FoodieViewModel foodieViewModel5 = this.viewModel;
                if (foodieViewModel5 != null) {
                    foodieViewModel5.changePageState(foodiePageState3);
                }
                showResultAndGotoResultActivity();
            }
        }
    }

    public final void setHotItem(@NotNull FoodieHotMessage msg) {
        Object obj;
        Object obj2;
        FoodieItemView view;
        FoodieViewModel foodieViewModel;
        FoodieHotIconHelper hotIconHelper;
        Intrinsics.checkNotNullParameter(msg, "msg");
        ArrayList<FoodieHotBean> hotFoodies = msg.getHotFoodies();
        if (hotFoodies != null) {
            Iterator<T> it = hotFoodies.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((FoodieHotBean) obj).getHot()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((FoodieHotBean) obj) != null) {
                FoodieItem foodieItem = getMFoodieItemMap().get(Integer.valueOf(r1.getFoodieId() - 1));
                if (foodieItem != null && (foodieViewModel = this.viewModel) != null && (hotIconHelper = foodieViewModel.getHotIconHelper()) != null) {
                    hotIconHelper.locateOnScreen(foodieItem.getType(), foodieItem.getView());
                }
            }
            for (FoodieHotBean foodieHotBean : hotFoodies) {
                Iterator<T> it2 = getMFoodieItemMap().values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj2 = it2.next();
                        if (((FoodieItem) obj2).getType() == foodieHotBean.getFoodieId()) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                FoodieItem foodieItem2 = (FoodieItem) obj2;
                if (foodieItem2 != null && (view = foodieItem2.getView()) != null) {
                    view.setFlame(foodieHotBean.getFlamesNumber());
                }
            }
        }
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }

    public final void setMarquePictureIndex(int i) {
        this.marquePictureIndex = i;
    }

    public final void setResultItemPositions() {
        FoodieGameInfo foodieGameInfo;
        int i;
        List<Integer> arrayList;
        FoodieGameInfo gameInfo;
        Integer winFoodieId;
        FoodieViewModel foodieViewModel = this.viewModel;
        if (foodieViewModel != null) {
            foodieGameInfo = foodieViewModel.getGameInfo();
        } else {
            foodieGameInfo = null;
        }
        if (foodieGameInfo == null) {
            this.mResultItemPositions = new ArrayList();
            return;
        }
        FoodieViewModel foodieViewModel2 = this.viewModel;
        if (foodieViewModel2 != null && (gameInfo = foodieViewModel2.getGameInfo()) != null && (winFoodieId = gameInfo.getWinFoodieId()) != null) {
            i = winFoodieId.intValue();
        } else {
            i = 0;
        }
        if (i == 100) {
            arrayList = CollectionsKt.mutableListOf(new Integer[]{0, 1, 2, 3});
        } else if (i == 200) {
            arrayList = CollectionsKt.mutableListOf(new Integer[]{4, 5, 6, 7});
        } else if (1 <= i && i < 9) {
            arrayList = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(i - 1)});
        } else {
            arrayList = new ArrayList<>();
        }
        this.mResultItemPositions = arrayList;
    }

    public final void setViewModel(@NotNull FoodieViewModel mViewModel, @NotNull FoodieGameDialog foodieGameDialog) {
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(foodieGameDialog, "foodieGameDialog");
        this.mBinding = ViewFoodieWheelBinding.inflate(LayoutInflater.from(this.mContext), this, true);
        this.viewModel = mViewModel;
        this.mGameDialog = foodieGameDialog;
        initView();
        initEvent();
    }

    public final void showEnd(int seconds) {
        setCountDownText(seconds);
        startWheeling();
        CountDownTimer countDownTimer = this.mCountDownHelper;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j = seconds * 1000;
        CountDownTimer countDownTimer2 = new CountDownTimer(j) { // from class: com.qiahao.nextvideo.ui.foodie.FoodieWheelLayout$showEnd$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                FoodieWheelLayout.this.mIsCountDownFinished = true;
                Function0<Unit> mListener = FoodieWheelLayout.this.getMListener();
                if (mListener != null) {
                    mListener.invoke();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
            
                r3 = r2.this$0.viewModel;
             */
            @Override // android.os.CountDownTimer
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onTick(long millisUntilFinished) {
                FoodieViewModel foodieViewModel;
                int i;
                FoodieViewModel foodieViewModel2;
                FoodieGameInfo gameInfo;
                Integer winFoodieId;
                int i2 = (int) (millisUntilFinished / 1000);
                FoodieWheelLayout.this.setCountDownText(i2);
                FoodieWheelLayout.this.marqueeLight();
                if (i2 == 1) {
                    foodieViewModel = FoodieWheelLayout.this.viewModel;
                    if (foodieViewModel != null && (gameInfo = foodieViewModel.getGameInfo()) != null && (winFoodieId = gameInfo.getWinFoodieId()) != null) {
                        i = winFoodieId.intValue();
                    } else {
                        i = 0;
                    }
                    if (i == 0 && foodieViewModel2 != null) {
                        foodieViewModel2.requestFoodieGameInfo();
                    }
                }
            }
        };
        this.mCountDownHelper = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieWheelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "mContext");
    }

    public /* synthetic */ FoodieWheelLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FoodieWheelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.mFoodieAnimHelper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.o1
            public final Object invoke() {
                FoodieAnimHelper mFoodieAnimHelper_delegate$lambda$0;
                mFoodieAnimHelper_delegate$lambda$0 = FoodieWheelLayout.mFoodieAnimHelper_delegate$lambda$0();
                return mFoodieAnimHelper_delegate$lambda$0;
            }
        });
        this.mFoodieItemMap = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.p1
            public final Object invoke() {
                Map mFoodieItemMap_delegate$lambda$1;
                mFoodieItemMap_delegate$lambda$1 = FoodieWheelLayout.mFoodieItemMap_delegate$lambda$1(FoodieWheelLayout.this);
                return mFoodieItemMap_delegate$lambda$1;
            }
        });
        this.mResultItemPositions = new ArrayList();
    }
}
