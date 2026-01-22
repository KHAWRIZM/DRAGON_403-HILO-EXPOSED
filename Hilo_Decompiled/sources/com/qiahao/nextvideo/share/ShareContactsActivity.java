package com.qiahao.nextvideo.share;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityShareContactsBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.rank.CommonViewPagerAdapter;
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
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u00019B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u0019R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u000e0(j\b\u0012\u0004\u0012\u00020\u000e`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/qiahao/nextvideo/share/ShareContactsActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityShareContactsBinding;", "Landroid/view/View$OnClickListener;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "<init>", "()V", "", "initViewPager", "", "getLayoutResId", "()I", "onInitialize", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "", "mGroupUrl", "Ljava/lang/String;", "getMGroupUrl", "()Ljava/lang/String;", "setMGroupUrl", "(Ljava/lang/String;)V", "mGroupId", "getMGroupId", "setMGroupId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/share/GroupShareContactsChildView;", "mGroupShareContactsChildView", "Lcom/qiahao/nextvideo/share/GroupShareContactsChildView;", "getMGroupShareContactsChildView", "()Lcom/qiahao/nextvideo/share/GroupShareContactsChildView;", "setMGroupShareContactsChildView", "(Lcom/qiahao/nextvideo/share/GroupShareContactsChildView;)V", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShareContactsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShareContactsActivity.kt\ncom/qiahao/nextvideo/share/ShareContactsActivity\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,148:1\n13472#2,2:149\n*S KotlinDebug\n*F\n+ 1 ShareContactsActivity.kt\ncom/qiahao/nextvideo/share/ShareContactsActivity\n*L\n79#1:149,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ShareContactsActivity extends HiloBaseBindingActivity<ActivityShareContactsBinding> implements View.OnClickListener, ViewPager.j, o6.b {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ShareContactsActivity";
    public GroupShareContactsChildView mGroupShareContactsChildView;

    @NotNull
    private String mGroupUrl = "";

    @NotNull
    private String mGroupId = "";

    @NotNull
    private final ArrayList<View> pageViews = new ArrayList<>();

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.share.t
        public final Object invoke() {
            BaseViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = ShareContactsActivity.mViewModel_delegate$lambda$0(ShareContactsActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/share/ShareContactsActivity$Companion;", "", "<init>", "()V", "TAG", "", "start", "", "context", "Landroid/content/Context;", "group_url", "group_id", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String group_url, @NotNull String group_id) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(group_url, "group_url");
            Intrinsics.checkNotNullParameter(group_id, "group_id");
            Intent intent = new Intent(context, (Class<?>) ShareContactsActivity.class);
            intent.putExtra("group_url", group_url);
            intent.putExtra("group_id", group_id);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final BaseViewModel getMViewModel() {
        return (BaseViewModel) this.mViewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initViewPager() {
        setMGroupShareContactsChildView(new GroupShareContactsChildView(this, this.mGroupId));
        this.pageViews.add(getMGroupShareContactsChildView());
        ((ActivityShareContactsBinding) getBinding()).viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        ((ActivityShareContactsBinding) getBinding()).viewPager.setOffscreenPageLimit(this.pageViews.size());
        ((ActivityShareContactsBinding) getBinding()).viewPager.setCurrentItem(0);
        ((ActivityShareContactsBinding) getBinding()).viewPager.addOnPageChangeListener(this);
        String[] strArr = {getString(2131952370)};
        ArrayList arrayList = new ArrayList();
        String str = strArr[0];
        Intrinsics.checkNotNull(str);
        arrayList.add(new TabEntity(str, 0, 0));
        ((ActivityShareContactsBinding) getBinding()).commonTabLayout.setTabData(arrayList);
        ((ActivityShareContactsBinding) getBinding()).commonTabLayout.setCurrentTab(0);
        ((ActivityShareContactsBinding) getBinding()).commonTabLayout.setOnTabSelectListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel mViewModel_delegate$lambda$0(ShareContactsActivity shareContactsActivity) {
        return new ViewModelProvider(shareContactsActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(ShareContactsActivity shareContactsActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = shareContactsActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        INSTANCE.start(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_share_contacts;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @NotNull
    public final GroupShareContactsChildView getMGroupShareContactsChildView() {
        GroupShareContactsChildView groupShareContactsChildView = this.mGroupShareContactsChildView;
        if (groupShareContactsChildView != null) {
            return groupShareContactsChildView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGroupShareContactsChildView");
        return null;
    }

    @NotNull
    public final String getMGroupUrl() {
        return this.mGroupUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362039) {
            if (id2 == 2131364759 && ((ActivityShareContactsBinding) getBinding()).viewPager.getCurrentItem() == 0) {
                if (getMGroupShareContactsChildView().getHasSelectAll()) {
                    getMGroupShareContactsChildView().setIsSelectAll(false);
                    ((ActivityShareContactsBinding) getBinding()).selectAll.setText(2131954019);
                    return;
                } else {
                    getMGroupShareContactsChildView().setIsSelectAll(true);
                    ((ActivityShareContactsBinding) getBinding()).selectAll.setText(2131954349);
                    return;
                }
            }
            return;
        }
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ActivityShareContactsBinding) getBinding()).titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.share.u
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = ShareContactsActivity.onInitialize$lambda$1(ShareContactsActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        String stringExtra = getIntent().getStringExtra("group_url");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mGroupUrl = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("group_id");
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        this.mGroupId = str;
        ((ActivityShareContactsBinding) getBinding()).setClick(this);
        initViewPager();
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        getBinding().commonTabLayout.setCurrentTab(position);
        if (position == 0) {
            if (getMGroupShareContactsChildView().getHasSelectAll()) {
                getBinding().selectAll.setText(2131954349);
            } else {
                getBinding().selectAll.setText(2131954019);
            }
        }
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        getBinding().viewPager.setCurrentItem(position);
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMGroupShareContactsChildView(@NotNull GroupShareContactsChildView groupShareContactsChildView) {
        Intrinsics.checkNotNullParameter(groupShareContactsChildView, "<set-?>");
        this.mGroupShareContactsChildView = groupShareContactsChildView;
    }

    public final void setMGroupUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupUrl = str;
    }
}
