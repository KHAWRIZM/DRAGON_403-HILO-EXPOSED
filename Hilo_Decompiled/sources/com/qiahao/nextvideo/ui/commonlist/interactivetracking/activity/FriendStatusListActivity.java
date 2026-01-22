package com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ActivityControllerInteractiveTrackingListBinding;
import com.qiahao.nextvideo.room.adapter.ViewPagerFragmentAdapter;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.InteractiveTrackingType;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.FriendStatusFragment;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import pd.g;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\f\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR+\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/activity/FriendStatusListActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityControllerInteractiveTrackingListBinding;", "<init>", "()V", "", "initView", "initObserver", "", "getLayoutResId", "()I", "onInitialize", "onDestroy", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "mCurStatusType", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mFragments$delegate", "Lkotlin/Lazy;", "getMFragments", "()Ljava/util/ArrayList;", "mFragments", "Lnd/a;", "compositeDisposable$delegate", "getCompositeDisposable", "()Lnd/a;", "compositeDisposable", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFriendStatusListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FriendStatusListActivity.kt\ncom/qiahao/nextvideo/ui/commonlist/interactivetracking/activity/FriendStatusListActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,142:1\n167#2,2:143\n*S KotlinDebug\n*F\n+ 1 FriendStatusListActivity.kt\ncom/qiahao/nextvideo/ui/commonlist/interactivetracking/activity/FriendStatusListActivity\n*L\n65#1:143,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FriendStatusListActivity extends HiloBaseBindingActivity<ActivityControllerInteractiveTrackingListBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_TYPE = "key_type";

    @NotNull
    private InteractiveTrackingType mCurStatusType = InteractiveTrackingType.Follow;

    /* renamed from: mFragments$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFragments = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.c
        public final Object invoke() {
            ArrayList mFragments_delegate$lambda$0;
            mFragments_delegate$lambda$0 = FriendStatusListActivity.mFragments_delegate$lambda$0();
            return mFragments_delegate$lambda$0;
        }
    });

    /* renamed from: compositeDisposable$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy compositeDisposable = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.d
        public final Object invoke() {
            nd.a compositeDisposable_delegate$lambda$1;
            compositeDisposable_delegate$lambda$1 = FriendStatusListActivity.compositeDisposable_delegate$lambda$1();
            return compositeDisposable_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/activity/FriendStatusListActivity$Companion;", "", "<init>", "()V", "KEY_TYPE", "", "start", "", "context", "Landroid/content/Context;", "type", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, InteractiveTrackingType interactiveTrackingType, int i, Object obj) {
            if ((i & 2) != 0) {
                interactiveTrackingType = InteractiveTrackingType.Follow;
            }
            companion.start(context, interactiveTrackingType);
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull InteractiveTrackingType type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intent intent = new Intent(context, (Class<?>) FriendStatusListActivity.class);
            intent.putExtra(FriendStatusListActivity.KEY_TYPE, type.name());
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final nd.a compositeDisposable_delegate$lambda$1() {
        return new nd.a();
    }

    private final nd.a getCompositeDisposable() {
        return (nd.a) this.compositeDisposable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Fragment> getMFragments() {
        return (ArrayList) this.mFragments.getValue();
    }

    private final void initObserver() {
        nd.c subscribe = UserStore.INSTANCE.getShared().getLikeEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new g() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.FriendStatusListActivity$initObserver$1
            public final void accept(Pair<String, Boolean> pair) {
                ArrayList<FriendStatusFragment> mFragments;
                ActivityControllerInteractiveTrackingListBinding binding;
                ActivityControllerInteractiveTrackingListBinding binding2;
                try {
                    mFragments = FriendStatusListActivity.this.getMFragments();
                    for (FriendStatusFragment friendStatusFragment : mFragments) {
                        FriendStatusFragment friendStatusFragment2 = friendStatusFragment instanceof FriendStatusFragment ? friendStatusFragment : null;
                        if (friendStatusFragment2 != null) {
                            friendStatusFragment2.loadListData();
                        }
                    }
                    binding = FriendStatusListActivity.this.getBinding();
                    binding.likeSvgaImageView.stopAnimation();
                    binding2 = FriendStatusListActivity.this.getBinding();
                    binding2.likeSvgaImageView.startAnimation();
                } catch (Exception e) {
                    DebugToolsKt.printfE("FriendStatusListActivity", "likeEventRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getCompositeDisposable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str;
        LinearLayout linearLayout = ((ActivityControllerInteractiveTrackingListBinding) getBinding()).linearLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "linearLayout");
        getStatusBarTopOrBottom(linearLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$2;
                initView$lambda$2 = FriendStatusListActivity.initView$lambda$2(FriendStatusListActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$2;
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra(KEY_TYPE);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            this.mCurStatusType = InteractiveTrackingType.valueOf(str);
        }
        getMFragments().clear();
        if (getMFragments().isEmpty()) {
            ArrayList<Fragment> mFragments = getMFragments();
            FriendStatusFragment.Companion companion = FriendStatusFragment.INSTANCE;
            mFragments.add(companion.newInstance(InteractiveTrackingType.ILike));
            getMFragments().add(companion.newInstance(InteractiveTrackingType.Follow));
            getMFragments().add(companion.newInstance(InteractiveTrackingType.Visitor));
            getMFragments().add(companion.newInstance(InteractiveTrackingType.Praise));
        }
        ViewPager viewPager = ((ActivityControllerInteractiveTrackingListBinding) getBinding()).viewPager2;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new ViewPagerFragmentAdapter(supportFragmentManager, getMFragments()));
        ((ActivityControllerInteractiveTrackingListBinding) getBinding()).viewPager2.setOffscreenPageLimit(getMFragments().size());
        ((ActivityControllerInteractiveTrackingListBinding) getBinding()).viewPager2.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.FriendStatusListActivity$initView$2
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivityControllerInteractiveTrackingListBinding binding;
                binding = FriendStatusListActivity.this.getBinding();
                binding.commonTabLayout.setCurrentTab(position);
            }
        });
        ((ActivityControllerInteractiveTrackingListBinding) getBinding()).commonTabLayout.l(((ActivityControllerInteractiveTrackingListBinding) getBinding()).viewPager2, new String[]{getString(2131953096), getString(2131952761), getString(2131954460), getString(2131953219)});
        ((ActivityControllerInteractiveTrackingListBinding) getBinding()).commonTabLayout.setCurrentTab(this.mCurStatusType.ordinal());
        ((ActivityControllerInteractiveTrackingListBinding) getBinding()).commonTabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.FriendStatusListActivity$initView$3
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityControllerInteractiveTrackingListBinding binding;
                binding = FriendStatusListActivity.this.getBinding();
                binding.viewPager2.setCurrentItem(position);
            }
        });
        ((ActivityControllerInteractiveTrackingListBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendStatusListActivity.this.onBackPressed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$2(FriendStatusListActivity friendStatusListActivity, int i, int i2) {
        LinearLayout linearLayout = friendStatusListActivity.getBinding().linearLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "linearLayout");
        linearLayout.setPadding(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList mFragments_delegate$lambda$0() {
        return new ArrayList();
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull InteractiveTrackingType interactiveTrackingType) {
        INSTANCE.start(context, interactiveTrackingType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_controller_interactive_tracking_list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getCompositeDisposable().d();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initObserver();
    }
}
