package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.oudi.core.utils.FragmentUtils;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityGroupThemesBinding;
import com.qiahao.nextvideo.room.activity.CustomThemeActivity;
import com.qiahao.nextvideo.room.adapter.ViewPagerFragmentAdapter;
import com.qiahao.nextvideo.room.fragment.GroupMyThemeFragment;
import com.qiahao.nextvideo.room.fragment.GroupThemeFragment;
import com.qiahao.nextvideo.room.fragment.GroupThemeViewModel;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.viewmodel.GroupThemesViewModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001GB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ'\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u001bJ\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\u001bR\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R'\u0010/\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020A8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/GroupThemesActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGroupThemesBinding;", "Landroid/view/View$OnClickListener;", "Lo6/b;", "Landroidx/viewpager/widget/ViewPager$j;", "<init>", "()V", "", "initView", "", "getLayoutResId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "event", "onRoomEvent", "(Lcom/qiahao/nextvideo/room/manager/RoomEvent;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "position", "onTabSelect", "(I)V", "onTabReselect", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "state", "onPageScrollStateChanged", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "viewPagerFragments", "Ljava/util/ArrayList;", "getViewPagerFragments", "()Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/room/fragment/GroupThemeFragment;", "mGroupThemeFragment", "Lcom/qiahao/nextvideo/room/fragment/GroupThemeFragment;", "getMGroupThemeFragment", "()Lcom/qiahao/nextvideo/room/fragment/GroupThemeFragment;", "setMGroupThemeFragment", "(Lcom/qiahao/nextvideo/room/fragment/GroupThemeFragment;)V", "Lcom/qiahao/nextvideo/room/fragment/GroupMyThemeFragment;", "mMyGroupThemeFragment", "Lcom/qiahao/nextvideo/room/fragment/GroupMyThemeFragment;", "getMMyGroupThemeFragment", "()Lcom/qiahao/nextvideo/room/fragment/GroupMyThemeFragment;", "setMMyGroupThemeFragment", "(Lcom/qiahao/nextvideo/room/fragment/GroupMyThemeFragment;)V", "Lcom/qiahao/nextvideo/room/viewmodel/GroupThemesViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/GroupThemesViewModel;", "mViewModel", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGroupThemesActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupThemesActivity.kt\ncom/qiahao/nextvideo/room/activity/GroupThemesActivity\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,181:1\n13472#2,2:182\n*S KotlinDebug\n*F\n+ 1 GroupThemesActivity.kt\ncom/qiahao/nextvideo/room/activity/GroupThemesActivity\n*L\n96#1:182,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupThemesActivity extends HiloBaseBindingActivity<ActivityGroupThemesBinding> implements View.OnClickListener, o6.b, ViewPager.j {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int THEME_CUSTOM = 2;
    public static final int THEME_OFFICIAL = 1;

    @Nullable
    private GroupThemeFragment mGroupThemeFragment;

    @Nullable
    private GroupMyThemeFragment mMyGroupThemeFragment;

    @NotNull
    private nd.a mCompositeDisposable = new nd.a();

    @NotNull
    private final ArrayList<Fragment> viewPagerFragments = new ArrayList<>();

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.activity.o0
        public final Object invoke() {
            GroupThemesViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = GroupThemesActivity.mViewModel_delegate$lambda$0(GroupThemesActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/GroupThemesActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "groupId", "", "themeId", "", "themeType", "THEME_OFFICIAL", "THEME_CUSTOM", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String groupId, int themeId, int themeType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent putExtra = new Intent(context, (Class<?>) GroupThemesActivity.class).putExtra("groupId", groupId).putExtra("themeId", themeId).putExtra("themeType", themeType);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String[] strArr = {getString(2131954261), getString(2131953490)};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            Intrinsics.checkNotNull(str);
            arrayList.add(new TabEntity(str, 0, 0));
        }
        ((ActivityGroupThemesBinding) getBinding()).tabLayout.setTabData(arrayList);
        ((ActivityGroupThemesBinding) getBinding()).tabLayout.setOnTabSelectListener(this);
        if (this.viewPagerFragments.isEmpty()) {
            FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
            Fragment findFragment = fragmentUtils.findFragment(getSupportFragmentManager(), GroupThemeFragment.class);
            if (findFragment == null) {
                findFragment = new GroupThemeFragment();
            }
            this.viewPagerFragments.add(findFragment);
            Fragment findFragment2 = fragmentUtils.findFragment(getSupportFragmentManager(), GroupMyThemeFragment.class);
            if (findFragment2 == null) {
                findFragment2 = new GroupMyThemeFragment();
            }
            this.viewPagerFragments.add(findFragment2);
        }
        ViewPager viewPager = ((ActivityGroupThemesBinding) getBinding()).viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new ViewPagerFragmentAdapter(supportFragmentManager, this.viewPagerFragments));
        ((ActivityGroupThemesBinding) getBinding()).viewPager.setCurrentItem(0);
        ((ActivityGroupThemesBinding) getBinding()).viewPager.addOnPageChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupThemesViewModel mViewModel_delegate$lambda$0(GroupThemesActivity groupThemesActivity) {
        return new ViewModelProvider(groupThemesActivity).get(GroupThemesViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(GroupThemesActivity groupThemesActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = groupThemesActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str, int i, int i2) {
        INSTANCE.start(context, str, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_group_themes;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Nullable
    public final GroupThemeFragment getMGroupThemeFragment() {
        return this.mGroupThemeFragment;
    }

    @Nullable
    public final GroupMyThemeFragment getMMyGroupThemeFragment() {
        return this.mMyGroupThemeFragment;
    }

    @NotNull
    public final GroupThemesViewModel getMViewModel() {
        return (GroupThemesViewModel) this.mViewModel.getValue();
    }

    @NotNull
    public final ArrayList<Fragment> getViewPagerFragments() {
        return this.viewPagerFragments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        int i;
        GroupThemeViewModel mViewModel;
        ma.b mCustomThemeListUnPeekLiveData;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131361932) {
            if (id2 == 2131362039) {
                finish();
                return;
            }
            return;
        }
        GroupMyThemeFragment groupMyThemeFragment = this.mMyGroupThemeFragment;
        if (groupMyThemeFragment != null && (mViewModel = groupMyThemeFragment.getMViewModel()) != null && (mCustomThemeListUnPeekLiveData = mViewModel.getMCustomThemeListUnPeekLiveData()) != null && (arrayList = (ArrayList) mCustomThemeListUnPeekLiveData.getValue()) != null) {
            i = arrayList.size();
        } else {
            i = 0;
        }
        if (i >= 50) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = getString(2131954248);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, this, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
                return;
            }
            return;
        }
        CustomThemeActivity.Companion companion2 = CustomThemeActivity.INSTANCE;
        Object value = getMViewModel().getMGroupId().getValue();
        Intrinsics.checkNotNull(value);
        companion2.start(this, (String) value, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMViewModel().getMThemeId().setValue(Integer.valueOf(getIntent().getIntExtra("themeId", -1)));
        ma.b mGroupId = getMViewModel().getMGroupId();
        String stringExtra = getIntent().getStringExtra("groupId");
        if (stringExtra == null) {
            stringExtra = "";
        }
        mGroupId.setValue(stringExtra);
        getMViewModel().setMThemeType(getIntent().getIntExtra("themeType", 0));
        ((ActivityGroupThemesBinding) getBinding()).setClick(this);
        Toolbar toolbar = ((ActivityGroupThemesBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.n0
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$1;
                onCreate$lambda$1 = GroupThemesActivity.onCreate$lambda$1(GroupThemesActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onCreate$lambda$1;
            }
        });
        setStatusBarIconColor(false);
        initView();
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        getBinding().tabLayout.setCurrentTab(position);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        int i;
        Intrinsics.checkNotNullParameter(event, "event");
        int mEventId = event.getMEventId();
        if (mEventId != 214) {
            if (mEventId == 502) {
                GroupThemesViewModel mViewModel = getMViewModel();
                Integer mThemeType = event.getMThemeType();
                if (mThemeType != null) {
                    i = mThemeType.intValue();
                } else {
                    i = 0;
                }
                mViewModel.setMThemeType(i);
                ma.b mThemeId = getMViewModel().getMThemeId();
                int mThemeId2 = event.getMThemeId();
                if (mThemeId2 == null) {
                    mThemeId2 = 0;
                }
                mThemeId.setValue(mThemeId2);
                return;
            }
            return;
        }
        finish();
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        getBinding().viewPager.setCurrentItem(position);
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMGroupThemeFragment(@Nullable GroupThemeFragment groupThemeFragment) {
        this.mGroupThemeFragment = groupThemeFragment;
    }

    public final void setMMyGroupThemeFragment(@Nullable GroupMyThemeFragment groupMyThemeFragment) {
        this.mMyGroupThemeFragment = groupMyThemeFragment;
    }
}
