package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityCpRankBinding;
import com.qiahao.nextvideo.ui.aristocracy.VipRecordFragment;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpRankActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityCpRankBinding;", "<init>", "()V", "titleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mFragments", "Landroidx/fragment/app/Fragment;", "position", "", "getLayoutResId", "onInitialize", "", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpRankActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpRankActivity.kt\ncom/qiahao/nextvideo/ui/cp/CpRankActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,128:1\n61#2,9:129\n61#2,9:138\n*S KotlinDebug\n*F\n+ 1 CpRankActivity.kt\ncom/qiahao/nextvideo/ui/cp/CpRankActivity\n*L\n75#1:129,9\n79#1:138,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRankActivity extends HiloBaseBindingActivity<ActivityCpRankBinding> {

    @NotNull
    public static final String CP_POSITION = "position";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String FRAGMENT_PERIOD = "fragment_period";

    @NotNull
    public static final String FRAGMENT_TYPE = "fragment_type";

    @NotNull
    private ArrayList<Fragment> mFragments;
    private int position;

    @NotNull
    private ArrayList<String> titleList;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpRankActivity$Companion;", "", "<init>", "()V", VipRecordFragment.FRAGMENT_TYPE, "", "FRAGMENT_PERIOD", "CP_POSITION", "startActivity", "", "context", "Landroid/content/Context;", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            companion.startActivity(context, i);
        }

        public final void startActivity(@NotNull Context context, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) CpRankActivity.class);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    public CpRankActivity() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131952430));
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131953898));
        arrayList.add(ResourcesKtxKt.getStringById(arrayList, 2131953865));
        this.titleList = arrayList;
        this.mFragments = new ArrayList<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        int i;
        this.position = getIntent().getIntExtra("position", 0);
        View view = ((ActivityCpRankBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.cp.o0
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$1;
                initView$lambda$1 = CpRankActivity.initView$lambda$1(CpRankActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$1;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityCpRankBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpRankActivity.this.onBackPressed();
            }
        });
        final String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "CP_activity_url", "", (String) null, 4, (Object) null);
        AppCompatImageView appCompatImageView = ((ActivityCpRankBinding) getBinding()).activityImage;
        if (TextUtils.isEmpty(str)) {
            i = 8;
        } else {
            i = 0;
        }
        appCompatImageView.setVisibility(i);
        final AppCompatImageView appCompatImageView2 = ((ActivityCpRankBinding) getBinding()).activityImage;
        final long j = 800;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpRankActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, this, str, null, 4, null);
                }
            }
        });
        final AppCompatImageView appCompatImageView3 = ((ActivityCpRankBinding) getBinding()).helperImage;
        final long j2 = 800;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpRankActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivityCpRankBinding binding;
                CpRankActivity cpRankActivity;
                int i2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j2 || (appCompatImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                    AppCompatImageView appCompatImageView4 = appCompatImageView3;
                    TipDialog hideCancel = new TipDialog(this).hideCancel(true);
                    binding = this.getBinding();
                    if (binding.viewPage.getCurrentItem() == 1) {
                        cpRankActivity = this;
                        i2 = 2131952433;
                    } else {
                        cpRankActivity = this;
                        i2 = 2131952432;
                    }
                    hideCancel.setTipContent(ResourcesKtxKt.getStringById(cpRankActivity, i2)).show();
                }
            }
        });
        if (this.mFragments.isEmpty()) {
            ArrayList<Fragment> arrayList = this.mFragments;
            CpFragment cpFragment = new CpFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CpFragment.FRAGMENT_TYPE_RELATION, CpFragment.FRAGMENT_CP);
            bundle.putInt("fragment_type", 0);
            bundle.putString("fragment_period", "day");
            cpFragment.setArguments(bundle);
            arrayList.add(cpFragment);
            ArrayList<Fragment> arrayList2 = this.mFragments;
            CpFragment cpFragment2 = new CpFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString(CpFragment.FRAGMENT_TYPE_RELATION, CpFragment.FRAGMENT_RELATIONSHIP);
            bundle2.putInt("fragment_type", 0);
            bundle2.putString("fragment_period", "day");
            cpFragment2.setArguments(bundle2);
            arrayList2.add(cpFragment2);
            this.mFragments.add(new CpRecordFragment());
        }
        ((ActivityCpRankBinding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.cp.CpRankActivity$initView$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(CpRankActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList3;
                arrayList3 = CpRankActivity.this.mFragments;
                Object obj = arrayList3.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList3;
                arrayList3 = CpRankActivity.this.mFragments;
                return arrayList3.size();
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = ((ActivityCpRankBinding) getBinding()).tabLayout;
        ViewPager2 viewPager2 = ((ActivityCpRankBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new ViewPage2TabLayout.StandardTextTabAdapter(this.titleList, "#ffffff", "#66FFFFFF", 15, 15));
        if (this.position < this.titleList.size()) {
            ((ActivityCpRankBinding) getBinding()).viewPage.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.cp.q0
                @Override // java.lang.Runnable
                public final void run() {
                    CpRankActivity.initView$lambda$7(CpRankActivity.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1(CpRankActivity cpRankActivity, int i, int i2) {
        cpRankActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(CpRankActivity cpRankActivity) {
        cpRankActivity.getBinding().viewPage.setCurrentItem(cpRankActivity.position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_cp_rank;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }
}
