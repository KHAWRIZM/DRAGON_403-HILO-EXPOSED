package com.qiahao.nextvideo.ui.store;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.MyBagBean;
import com.qiahao.base_common.model.eventBus.BagEvent;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.store.BagCarromData;
import com.qiahao.nextvideo.databinding.ActivityMyBagBinding;
import com.qiahao.nextvideo.ui.cp.SearchUserActivity;
import java.util.ArrayList;
import java.util.List;
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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0007R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/store/MyBagActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityMyBagBinding;", "<init>", "()V", "mFragmentList", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mTypeList", "", "", "getMTypeList", "()[Ljava/lang/String;", "setMTypeList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getLayoutResId", "", "mViewModel", "Lcom/qiahao/nextvideo/ui/store/MyBagViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/store/MyBagViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "onInitialize", "", "initView", "refreshPositionView", "position", "onBagEvent", "event", "Lcom/qiahao/base_common/model/eventBus/BagEvent;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyBagActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyBagActivity.kt\ncom/qiahao/nextvideo/ui/store/MyBagActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,183:1\n61#2,9:184\n61#2,9:193\n61#2,9:202\n61#2,9:211\n*S KotlinDebug\n*F\n+ 1 MyBagActivity.kt\ncom/qiahao/nextvideo/ui/store/MyBagActivity\n*L\n75#1:184,9\n79#1:193,9\n87#1:202,9\n95#1:211,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyBagActivity extends HiloBaseBindingActivity<ActivityMyBagBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();

    @NotNull
    private String[] mTypeList = {ResourcesKtxKt.getStringById(this, 2131953047), ResourcesKtxKt.getStringById(this, 2131953421), ResourcesKtxKt.getStringById(this, 2131952188)};

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.p
        public final Object invoke() {
            MyBagViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = MyBagActivity.mViewModel_delegate$lambda$0();
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/MyBagActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) MyBagActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View root = ((ActivityMyBagBinding) getBinding()).titleLayout.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        getStatusBarTopOrBottom(root, new Function2() { // from class: com.qiahao.nextvideo.ui.store.o
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$1;
                initView$lambda$1 = MyBagActivity.initView$lambda$1(MyBagActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$1;
            }
        });
        ((ActivityMyBagBinding) getBinding()).use.setBackground(ShapeUtil.INSTANCE.createShape("#ED74F7", "#8430FF", 32, GradientDrawable.Orientation.LEFT_RIGHT));
        ((ActivityMyBagBinding) getBinding()).titleLayout.linearLayout.setBackground(androidx.core.content.a.getDrawable(this, 2131101214));
        final AppCompatImageView appCompatImageView = ((ActivityMyBagBinding) getBinding()).titleLayout.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.MyBagActivity$initView$$inlined$singleClick$default$1
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
        final TextView textView = ((ActivityMyBagBinding) getBinding()).use;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.MyBagActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    BagCarromData mSelectCarrom = this.getMViewModel().getMSelectCarrom();
                    if (mSelectCarrom != null) {
                        z = Intrinsics.areEqual(mSelectCarrom.getUsing(), Boolean.TRUE);
                    } else {
                        z = false;
                    }
                    if (z) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        BaseActivity baseActivity = this;
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131954393), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    cf.c.c().l(new BagEvent("carrom_use", this.getMViewModel().getMSelectCarrom()));
                }
            }
        });
        final TextView textView2 = ((ActivityMyBagBinding) getBinding()).textUse;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.MyBagActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityMyBagBinding binding;
                ActivityMyBagBinding binding2;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    MyBagBean mSelectData = this.getMViewModel().getMSelectData();
                    if (mSelectData != null && mSelectData.getUsing()) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        BaseActivity baseActivity = this;
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131954393), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    cf.c c = cf.c.c();
                    binding = this.getBinding();
                    if (binding.viewPager.getCurrentItem() != 0) {
                        binding2 = this.getBinding();
                        if (binding2.viewPager.getCurrentItem() == 1) {
                            str = MyBagViewModel.BAG_MOUNTS;
                        } else {
                            str = "";
                        }
                    } else {
                        str = MyBagViewModel.BAG_HEAD;
                    }
                    c.l(new BagEvent("bag_use", str));
                }
            }
        });
        final TextView textView3 = ((ActivityMyBagBinding) getBinding()).textSend;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.MyBagActivity$initView$$inlined$singleClick$default$4
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.qiahao.nextvideo.ui.store.MyBagActivity] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityMyBagBinding binding;
                ActivityMyBagBinding binding2;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    MyBagBean mSelectData = this.getMViewModel().getMSelectData();
                    if (mSelectData != null && mSelectData.getUsing()) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        BaseActivity baseActivity = this;
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131953145), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    SearchUserActivity.Companion companion2 = SearchUserActivity.Companion;
                    ?? r1 = this;
                    binding = r1.getBinding();
                    if (binding.viewPager.getCurrentItem() != 0) {
                        binding2 = this.getBinding();
                        if (binding2.viewPager.getCurrentItem() == 1) {
                            str = MyBagViewModel.BAG_MOUNTS;
                        } else {
                            str = "";
                        }
                    } else {
                        str = MyBagViewModel.BAG_HEAD;
                    }
                    companion2.startActivity(r1, SearchUserActivity.SEND_BAG, str);
                }
            }
        });
        if (this.mFragmentList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putString("type", MyBagViewModel.BAG_HEAD);
            Fragment myBagFragment = new MyBagFragment();
            myBagFragment.setArguments(bundle);
            this.mFragmentList.add(myBagFragment);
            Bundle bundle2 = new Bundle();
            bundle2.putString("type", MyBagViewModel.BAG_MOUNTS);
            Fragment myBagFragment2 = new MyBagFragment();
            myBagFragment2.setArguments(bundle2);
            this.mFragmentList.add(myBagFragment2);
            this.mFragmentList.add(new CarromBagFragment());
        }
        ViewPager viewPager = ((ActivityMyBagBinding) getBinding()).viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new CommonFragmentStatePagerAdapter(supportFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        ((ActivityMyBagBinding) getBinding()).viewPager.setOffscreenPageLimit(this.mFragmentList.size());
        ((ActivityMyBagBinding) getBinding()).tabLayout.l(((ActivityMyBagBinding) getBinding()).viewPager, this.mTypeList);
        ((ActivityMyBagBinding) getBinding()).tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.store.MyBagActivity$initView$6
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityMyBagBinding binding;
                binding = MyBagActivity.this.getBinding();
                binding.viewPager.setCurrentItem(position);
            }
        });
        ((ActivityMyBagBinding) getBinding()).viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.store.MyBagActivity$initView$7
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivityMyBagBinding binding;
                binding = MyBagActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
                MyBagActivity.this.refreshPositionView(position);
            }
        });
        refreshPositionView(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(MyBagActivity myBagActivity, int i, int i2) {
        ViewKtxKt.setMargin(myBagActivity.getBinding().titleLayout.bar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyBagViewModel mViewModel_delegate$lambda$0() {
        return new MyBagViewModel();
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_my_bag;
    }

    @NotNull
    public final String[] getMTypeList() {
        return this.mTypeList;
    }

    @NotNull
    public final MyBagViewModel getMViewModel() {
        return (MyBagViewModel) this.mViewModel.getValue();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onBagEvent(@NotNull BagEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        MyBagBean myBagBean = null;
        if (Intrinsics.areEqual(type, "bag_select")) {
            if (event.getData() instanceof MyBagBean) {
                MyBagViewModel mViewModel = getMViewModel();
                Object data = event.getData();
                if (data instanceof MyBagBean) {
                    myBagBean = (MyBagBean) data;
                }
                mViewModel.setMSelectData(myBagBean);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(type, "carrom_select")) {
            if (event.getData() instanceof BagCarromData) {
                MyBagViewModel mViewModel2 = getMViewModel();
                Object data2 = event.getData();
                if (data2 instanceof BagCarromData) {
                    myBagBean = (BagCarromData) data2;
                }
                mViewModel2.setMSelectCarrom(myBagBean);
                return;
            }
            getMViewModel().setMSelectCarrom(null);
        }
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    public final void refreshPositionView(int position) {
        int i;
        int i2;
        TextView textView = getBinding().textSend;
        int i3 = 8;
        if (position < 2) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = getBinding().textUse;
        if (position < 2) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        TextView textView3 = getBinding().use;
        if (position == 2) {
            i3 = 0;
        }
        textView3.setVisibility(i3);
    }

    public final void setMTypeList(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.mTypeList = strArr;
    }
}
