package com.qiahao.nextvideo.ui.gameLevel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.appbar.AppBarLayout;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.DeepCopy;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelCard;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelData;
import com.qiahao.nextvideo.data.model.gameLevel.GameLevelPrivilege;
import com.qiahao.nextvideo.data.model.gameLevel.UserGameLevel;
import com.qiahao.nextvideo.databinding.ActivityGameLevelBinding;
import com.zhpan.bannerview.BannerViewPager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J'\u0010\r\u001a\u00020\u00062\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J!\u0010\u0017\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0019\u0010\u0005R\u0014\u0010\u001a\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGameLevelBinding;", "Lcom/google/android/material/appbar/AppBarLayout$h;", "<init>", "()V", "", "initData", "initView", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/gameLevel/GameLevelCard;", "Lkotlin/collections/ArrayList;", "list", "initCard", "(Ljava/util/ArrayList;)V", "initPrivilege", "", "getLayoutResId", "()I", "onInitialize", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "verticalOffset", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "onResume", "STATE_COLLAPSED", "I", "STATE_EXPANDED", "mCollapsingState", "mSelectPosition", "Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelViewModel;", "viewModel", "Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelPrivilegesAdapter;", "mPrivilegesAdapter$delegate", "getMPrivilegesAdapter", "()Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelPrivilegesAdapter;", "mPrivilegesAdapter", "Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelCardAdapter;", "mCardAdapter$delegate", "getMCardAdapter", "()Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelCardAdapter;", "mCardAdapter", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameLevelActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameLevelActivity.kt\ncom/qiahao/nextvideo/ui/gameLevel/GameLevelActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,170:1\n61#2,9:171\n61#2,9:180\n1869#3:189\n1870#3:191\n1#4:190\n*S KotlinDebug\n*F\n+ 1 GameLevelActivity.kt\ncom/qiahao/nextvideo/ui/gameLevel/GameLevelActivity\n*L\n98#1:171,9\n101#1:180,9\n74#1:189\n74#1:191\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameLevelActivity extends HiloBaseBindingActivity<ActivityGameLevelBinding> implements AppBarLayout.h {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int STATE_COLLAPSED;
    private int mSelectPosition;
    private final int STATE_EXPANDED = 1;
    private int mCollapsingState = 1;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.gameLevel.e
        public final Object invoke() {
            GameLevelViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = GameLevelActivity.viewModel_delegate$lambda$0(GameLevelActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mPrivilegesAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPrivilegesAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.gameLevel.f
        public final Object invoke() {
            GameLevelPrivilegesAdapter mPrivilegesAdapter_delegate$lambda$1;
            mPrivilegesAdapter_delegate$lambda$1 = GameLevelActivity.mPrivilegesAdapter_delegate$lambda$1();
            return mPrivilegesAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: mCardAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCardAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.gameLevel.g
        public final Object invoke() {
            GameLevelCardAdapter mCardAdapter_delegate$lambda$2;
            mCardAdapter_delegate$lambda$2 = GameLevelActivity.mCardAdapter_delegate$lambda$2();
            return mCardAdapter_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) GameLevelActivity.class));
        }

        private Companion() {
        }
    }

    private final GameLevelCardAdapter getMCardAdapter() {
        return (GameLevelCardAdapter) this.mCardAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameLevelPrivilegesAdapter getMPrivilegesAdapter() {
        return (GameLevelPrivilegesAdapter) this.mPrivilegesAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameLevelViewModel getViewModel() {
        return (GameLevelViewModel) this.viewModel.getValue();
    }

    private final void initCard(ArrayList<GameLevelCard> list) {
        getBinding().bannerView.X(2).a0(UiKtxKt.toPX(10)).W(UiKtxKt.toPX(15)).G(getMCardAdapter()).I(false).H(false).Z(HiloUtils.INSTANCE.getRightToLeftDirection()).R(8).E(new GameLevelActivity$initCard$1(this)).T(new BannerViewPager.b() { // from class: com.qiahao.nextvideo.ui.gameLevel.a
            @Override // com.zhpan.bannerview.BannerViewPager.b
            public final void a(View view, int i) {
                GameLevelActivity.initCard$lambda$10(view, i);
            }
        }).h(list);
        getBinding().bannerView.J(this.mSelectPosition, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCard$lambda$10(View view, int i) {
    }

    private final void initData() {
        getViewModel().getGameLevel().observe(this, new GameLevelActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.gameLevel.b
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = GameLevelActivity.initData$lambda$6(GameLevelActivity.this, (GameLevelData) obj);
                return initData$lambda$6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(final GameLevelActivity gameLevelActivity, final GameLevelData gameLevelData) {
        int i;
        GameLevelCard gameLevelCard;
        Integer level;
        Integer num;
        ArrayList<GameLevelCard> arrayList = new ArrayList<>();
        ArrayList<GameLevelCard> cards = gameLevelData.getCards();
        String str = null;
        if (cards != null) {
            Iterator<T> it = cards.iterator();
            while (it.hasNext()) {
                GameLevelCard gameLevelCard2 = (GameLevelCard) DeepCopy.INSTANCE.deepCopy((GameLevelCard) it.next());
                Integer level2 = gameLevelCard2.getLevel();
                UserGameLevel userLevel = gameLevelData.getUserLevel();
                if (userLevel != null) {
                    num = userLevel.getLevel();
                } else {
                    num = null;
                }
                if (Intrinsics.areEqual(level2, num)) {
                    gameLevelCard2.setUserLevel(gameLevelData.getUserLevel());
                }
                arrayList.add(gameLevelCard2);
            }
        }
        UserGameLevel userLevel2 = gameLevelData.getUserLevel();
        if (userLevel2 != null && (level = userLevel2.getLevel()) != null) {
            i = level.intValue();
        } else {
            i = 1;
        }
        int i2 = i - 1;
        gameLevelActivity.mSelectPosition = i2;
        if (i2 < 0) {
            gameLevelActivity.mSelectPosition = 0;
        }
        gameLevelActivity.initCard(arrayList);
        gameLevelActivity.getBinding().recyclerView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.gameLevel.d
            @Override // java.lang.Runnable
            public final void run() {
                GameLevelActivity.initData$lambda$6$lambda$5(GameLevelActivity.this, gameLevelData);
            }
        });
        ImageView imageView = gameLevelActivity.getBinding().topBg;
        Intrinsics.checkNotNullExpressionValue(imageView, "topBg");
        ArrayList<GameLevelCard> cards2 = gameLevelData.getCards();
        if (cards2 != null && (gameLevelCard = cards2.get(gameLevelActivity.mSelectPosition)) != null) {
            str = gameLevelCard.getBgUrl();
        }
        ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$6$lambda$5(GameLevelActivity gameLevelActivity, GameLevelData gameLevelData) {
        ArrayList<GameLevelPrivilege> arrayList;
        ArrayList<GameLevelCard> cards;
        GameLevelCard gameLevelCard;
        GameLevelPrivilegesAdapter mPrivilegesAdapter = gameLevelActivity.getMPrivilegesAdapter();
        if (gameLevelData != null && (cards = gameLevelData.getCards()) != null && (gameLevelCard = cards.get(gameLevelActivity.mSelectPosition)) != null) {
            arrayList = gameLevelCard.getPrivileges();
        } else {
            arrayList = null;
        }
        mPrivilegesAdapter.setList(arrayList);
    }

    private final void initPrivilege() {
        getBinding().recyclerView.setAdapter(getMPrivilegesAdapter());
        getMPrivilegesAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.gameLevel.h
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GameLevelActivity.initPrivilege$lambda$11(baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPrivilege$lambda$11(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
    }

    private final void initView() {
        FrameLayout frameLayout = getBinding().activityMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "activityMainContainer");
        getStatusBarTopOrBottom(frameLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.gameLevel.c
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$7;
                initView$lambda$7 = GameLevelActivity.initView$lambda$7(GameLevelActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$7;
            }
        });
        setStatusBarIconColor(false);
        final AppCompatImageView appCompatImageView = getBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gameLevel.GameLevelActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = getBinding().help;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gameLevel.GameLevelActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    this.startActivity(new Intent((Context) this, (Class<?>) GameLevelRulesActivity.class));
                }
            }
        });
        initPrivilege();
        getBinding().appbar.addOnOffsetChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$7(GameLevelActivity gameLevelActivity, int i, int i2) {
        gameLevelActivity.getBinding().collapseToolbar.setPadding(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameLevelCardAdapter mCardAdapter_delegate$lambda$2() {
        return new GameLevelCardAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameLevelPrivilegesAdapter mPrivilegesAdapter_delegate$lambda$1() {
        return new GameLevelPrivilegesAdapter();
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameLevelViewModel viewModel_delegate$lambda$0(GameLevelActivity gameLevelActivity) {
        return new ViewModelProvider(gameLevelActivity).get(GameLevelViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_game_level;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public void onOffsetChanged(@Nullable AppBarLayout appBarLayout, int verticalOffset) {
        if (appBarLayout != null) {
            if (Math.abs(verticalOffset) >= 100) {
                int i = this.mCollapsingState;
                int i2 = this.STATE_COLLAPSED;
                if (i != i2) {
                    this.mCollapsingState = i2;
                    getBinding().collapseToolbar.setBackgroundResource(2131099931);
                    return;
                }
                return;
            }
            int i3 = this.mCollapsingState;
            int i4 = this.STATE_EXPANDED;
            if (i3 != i4) {
                this.mCollapsingState = i4;
                getBinding().collapseToolbar.setBackgroundResource(2131101182);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        getViewModel().m٧١getGameLevel();
    }
}
