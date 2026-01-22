package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.TabConfig;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.wedgit.BackgroundTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityFamilyRecordingBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0010j\b\u0012\u0004\u0012\u00020\u0015`\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyRecordingActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityFamilyRecordingBinding;", "<init>", "()V", "", "initView", "refreshRedPoint", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "event", "onSheepEvent", "(Lcom/qiahao/base_common/model/eventBus/EventBusKey;)V", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/TabConfig;", "Lkotlin/collections/ArrayList;", "mTypeList", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "mFragments", "Landroidx/viewpager2/adapter/a;", "mPagerAdapter", "Landroidx/viewpager2/adapter/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyRecordingActivity extends HiloBaseBindingActivity<ActivityFamilyRecordingBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private androidx.viewpager2.adapter.a mPagerAdapter;

    @NotNull
    private ArrayList<TabConfig> mTypeList = new ArrayList<>();

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyRecordingActivity$Companion;", "", "<init>", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) FamilyRecordingActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityFamilyRecordingBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.family.b3
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = FamilyRecordingActivity.initView$lambda$0(FamilyRecordingActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        ((ActivityFamilyRecordingBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.c3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FamilyRecordingActivity.this.onBackPressed();
            }
        });
        ((ActivityFamilyRecordingBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.toStringRes(2131952679));
        ArrayList<Fragment> arrayList = this.mFragments;
        if (arrayList == null || arrayList.isEmpty()) {
            this.mFragments.add(new FamilyApplicationFragment());
            this.mFragments.add(new FamilyExitFragment());
        }
        ArrayList<TabConfig> arrayList2 = this.mTypeList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            this.mTypeList.add(new TabConfig(getString(2131952015), 2131099900, 2131099872, 13.0f, 13.0f));
            this.mTypeList.add(new TabConfig(getString(2131952674), 2131099900, 2131099872, 13.0f, 13.0f));
        }
        this.mPagerAdapter = new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.family.FamilyRecordingActivity$initView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(FamilyRecordingActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList3;
                arrayList3 = FamilyRecordingActivity.this.mFragments;
                Object obj = arrayList3.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList3;
                arrayList3 = FamilyRecordingActivity.this.mFragments;
                return arrayList3.size();
            }
        };
        ((ActivityFamilyRecordingBinding) getBinding()).viewPage.setOffscreenPageLimit(2);
        ViewPager2 viewPager2 = ((ActivityFamilyRecordingBinding) getBinding()).viewPage;
        RecyclerView.Adapter adapter = this.mPagerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagerAdapter");
            adapter = null;
        }
        viewPager2.setAdapter(adapter);
        ((ActivityFamilyRecordingBinding) getBinding()).tabSegment.r(((ActivityFamilyRecordingBinding) getBinding()).viewPage, this.mTypeList);
        ((ActivityFamilyRecordingBinding) getBinding()).tabSegment.setShowBackground(true);
        ((ActivityFamilyRecordingBinding) getBinding()).tabSegment.setBackgroundColor(androidx.core.content.a.getColor(this, 2131101214));
        ((ActivityFamilyRecordingBinding) getBinding()).tabSegment.setonTabSelectListener(new BackgroundTabLayout.b() { // from class: com.qiahao.nextvideo.ui.family.FamilyRecordingActivity$initView$4
            public void notRedPoint() {
            }

            public void onPageSelected(int position) {
                if (position == 1) {
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "video_miss_number", 0, (String) null, 4, (Object) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(FamilyRecordingActivity familyRecordingActivity, int i, int i2) {
        familyRecordingActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    private final void refreshRedPoint() {
        getBinding().viewPage.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.family.d3
            @Override // java.lang.Runnable
            public final void run() {
                FamilyRecordingActivity.refreshRedPoint$lambda$2(FamilyRecordingActivity.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRedPoint$lambda$2(FamilyRecordingActivity familyRecordingActivity) {
        int intValue = ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "family_count", 0, (String) null, 4, (Object) null)).intValue();
        if (intValue > 0) {
            familyRecordingActivity.getBinding().tabSegment.q(0, true, intValue);
        } else {
            familyRecordingActivity.getBinding().tabSegment.q(0, false, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_family_recording;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onSheepEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.areEqual(event.getType(), "family_point");
    }
}
