package com.qiahao.nextvideo.ui.home.medal;

import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.TabConfig;
import com.qiahao.base_common.wedgit.BackgroundTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityMedalBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004R&\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/medal/MedalActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityMedalBinding;", "<init>", "()V", "", "initView", "", "getLayoutResId", "()I", "onInitialize", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/TabConfig;", "Lkotlin/collections/ArrayList;", "mTypeList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/home/medal/MedalFragment;", "mFragments", "Landroidx/viewpager2/adapter/a;", "mPagerAdapter", "Landroidx/viewpager2/adapter/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMedalActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MedalActivity.kt\ncom/qiahao/nextvideo/ui/home/medal/MedalActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,119:1\n61#2,9:120\n*S KotlinDebug\n*F\n+ 1 MedalActivity.kt\ncom/qiahao/nextvideo/ui/home/medal/MedalActivity\n*L\n54#1:120,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MedalActivity extends HiloBaseBindingActivity<ActivityMedalBinding> {

    @NotNull
    public static final String FRAGMENT_TYPE = "fragment_type";

    @NotNull
    public static final String TYPE_PERSONAL = "personal";

    @NotNull
    public static final String TYPE_ROOM = "room";
    private androidx.viewpager2.adapter.a mPagerAdapter;

    @NotNull
    private ArrayList<TabConfig> mTypeList = new ArrayList<>();

    @NotNull
    private ArrayList<MedalFragment> mFragments = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityMedalBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.medal.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = MedalActivity.initView$lambda$0(MedalActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityMedalBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MedalActivity.this.finish();
            }
        });
        ((ActivityMedalBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.toStringRes(2131953353));
        final TextView textView = ((ActivityMedalBinding) getBinding()).myMedal;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.MedalActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    MedalManageActivity.Companion.start(this);
                }
            }
        });
        if (this.mFragments.isEmpty()) {
            ArrayList<MedalFragment> arrayList = this.mFragments;
            MedalFragment medalFragment = new MedalFragment();
            Bundle bundle = new Bundle();
            bundle.putString("fragment_type", TYPE_PERSONAL);
            medalFragment.setArguments(bundle);
            arrayList.add(medalFragment);
            ArrayList<MedalFragment> arrayList2 = this.mFragments;
            MedalFragment medalFragment2 = new MedalFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("fragment_type", TYPE_ROOM);
            medalFragment2.setArguments(bundle2);
            arrayList2.add(medalFragment2);
        }
        ArrayList<TabConfig> arrayList3 = this.mTypeList;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            this.mTypeList.add(new TabConfig(getString(2131953370), 2131101214, 2131101214, 13.0f, 13.0f));
            this.mTypeList.add(new TabConfig(getString(2131953374), 2131101214, 2131101214, 13.0f, 13.0f));
        }
        this.mPagerAdapter = new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.home.medal.MedalActivity$initView$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(MedalActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList4;
                arrayList4 = MedalActivity.this.mFragments;
                Object obj = arrayList4.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList4;
                arrayList4 = MedalActivity.this.mFragments;
                return arrayList4.size();
            }
        };
        ViewPager2 viewPager2 = ((ActivityMedalBinding) getBinding()).viewPage;
        RecyclerView.Adapter adapter = this.mPagerAdapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagerAdapter");
            adapter = null;
        }
        viewPager2.setAdapter(adapter);
        ((ActivityMedalBinding) getBinding()).tabSegment.r(((ActivityMedalBinding) getBinding()).viewPage, this.mTypeList);
        ((ActivityMedalBinding) getBinding()).tabSegment.setShowBackground(true);
        ((ActivityMedalBinding) getBinding()).tabSegment.setBackgroundColor(androidx.core.content.a.getColor(this, 2131099887));
        ((ActivityMedalBinding) getBinding()).tabSegment.setonTabSelectListener(new BackgroundTabLayout.b() { // from class: com.qiahao.nextvideo.ui.home.medal.MedalActivity$initView$7
            public void notRedPoint() {
            }

            public void onPageSelected(int position) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(MedalActivity medalActivity, int i, int i2) {
        medalActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_medal;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }
}
