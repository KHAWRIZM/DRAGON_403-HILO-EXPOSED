package com.qiahao.nextvideo.room.rank;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityGroupAllRankBinding;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.rank.CommonGroupRankView;
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
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u00011B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J'\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0015J\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0015R$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/GroupAllRankActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGroupAllRankBinding;", "Lo6/b;", "Landroidx/viewpager/widget/ViewPager$j;", "<init>", "()V", "", "getLayoutResId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "event", "onRoomEvent", "(Lcom/qiahao/nextvideo/room/manager/RoomEvent;)V", "position", "onTabSelect", "(I)V", "onTabReselect", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "state", "onPageScrollStateChanged", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "", "mGroupId", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getMViewModel", "()Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "mViewModel", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGroupAllRankActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupAllRankActivity.kt\ncom/qiahao/nextvideo/room/rank/GroupAllRankActivity\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,163:1\n13472#2,2:164\n*S KotlinDebug\n*F\n+ 1 GroupAllRankActivity.kt\ncom/qiahao/nextvideo/room/rank/GroupAllRankActivity\n*L\n92#1:164,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupAllRankActivity extends HiloBaseBindingActivity<ActivityGroupAllRankBinding> implements o6.b, ViewPager.j {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GROUP_ID = "group_id";

    @NotNull
    private static final String TAG = "GroupAllRankActivity";

    @NotNull
    private final ArrayList<View> pageViews = new ArrayList<>();

    @NotNull
    private String mGroupId = "";

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.rank.n
        public final Object invoke() {
            BaseViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = GroupAllRankActivity.mViewModel_delegate$lambda$0(GroupAllRankActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/GroupAllRankActivity$Companion;", "", "<init>", "()V", "TAG", "", "GROUP_ID", "start", "", "context", "Landroid/content/Context;", "groupId", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull String groupId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intent putExtra = new Intent(context, (Class<?>) GroupAllRankActivity.class).putExtra("group_id", groupId);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        private Companion() {
        }
    }

    private final BaseViewModel getMViewModel() {
        return (BaseViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseViewModel mViewModel_delegate$lambda$0(GroupAllRankActivity groupAllRankActivity) {
        return new ViewModelProvider(groupAllRankActivity).get(BaseViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(GroupAllRankActivity groupAllRankActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = groupAllRankActivity.getBinding().toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public static final void onCreate$lambda$6(GroupAllRankActivity groupAllRankActivity, View view) {
        String string;
        int currentTab = ((ActivityGroupAllRankBinding) groupAllRankActivity.getBinding()).commonTabLayout.getCurrentTab();
        if (currentTab != 0) {
            if (currentTab != 1) {
                if (currentTab != 2) {
                    string = groupAllRankActivity.getString(2131953830);
                } else {
                    string = groupAllRankActivity.getString(2131951945);
                }
            } else {
                string = groupAllRankActivity.getString(2131953825);
            }
        } else {
            string = groupAllRankActivity.getString(2131953830);
        }
        Intrinsics.checkNotNull(string);
        ?? commonTextDialog = new CommonTextDialog(groupAllRankActivity, 0.0f, 2, null);
        commonTextDialog.setContentText(string, false, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.rank.GroupAllRankActivity$onCreate$3$1$1
            public void cancel() {
            }

            public void confirm() {
            }
        });
        commonTextDialog.show();
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull String str) {
        INSTANCE.start(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_group_all_rank;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = ((ActivityGroupAllRankBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.rank.o
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$1;
                onCreate$lambda$1 = GroupAllRankActivity.onCreate$lambda$1(GroupAllRankActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onCreate$lambda$1;
            }
        });
        setStatusBarIconColor(false);
        String stringExtra = getIntent().getStringExtra("group_id");
        Intrinsics.checkNotNull(stringExtra);
        this.mGroupId = stringExtra;
        ArrayList<View> arrayList = this.pageViews;
        CommonGroupRankView.Companion companion = CommonGroupRankView.INSTANCE;
        arrayList.add(companion.init(this, 1, stringExtra));
        this.pageViews.add(companion.init(this, 0, this.mGroupId));
        this.pageViews.add(CommonRoomActiveView.INSTANCE.init(this, this.mGroupId));
        ((ActivityGroupAllRankBinding) getBinding()).viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        ((ActivityGroupAllRankBinding) getBinding()).viewPager.setOffscreenPageLimit(this.pageViews.size());
        ((ActivityGroupAllRankBinding) getBinding()).viewPager.setCurrentItem(0);
        ((ActivityGroupAllRankBinding) getBinding()).viewPager.addOnPageChangeListener(this);
        String[] strArr = {getString(2131952697), getString(2131952206), ResourcesKtxKt.getStringById(this, 2131951944)};
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            Intrinsics.checkNotNull(str);
            arrayList2.add(new TabEntity(str, 0, 0));
        }
        ((ActivityGroupAllRankBinding) getBinding()).bgContent.setBackground(getResources().getDrawable(R.drawable.bg_rank_room));
        ((ActivityGroupAllRankBinding) getBinding()).commonTabLayout.setTabData(arrayList2);
        ((ActivityGroupAllRankBinding) getBinding()).commonTabLayout.setCurrentTab(0);
        View view = this.pageViews.get(0);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.room.rank.CommonGroupRankView");
        ((CommonGroupRankView) view).initView();
        ((ActivityGroupAllRankBinding) getBinding()).commonTabLayout.setOnTabSelectListener(this);
        ((ActivityGroupAllRankBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.rank.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupAllRankActivity.this.finish();
            }
        });
        ((ActivityGroupAllRankBinding) getBinding()).icQuestion.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.rank.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GroupAllRankActivity.onCreate$lambda$6(GroupAllRankActivity.this, view2);
            }
        });
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        getBinding().commonTabLayout.setCurrentTab(position);
        if (position != 0 && position != 1) {
            View view = this.pageViews.get(position);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.room.rank.CommonRoomActiveView");
            ((CommonRoomActiveView) view).initView();
        } else {
            View view2 = this.pageViews.get(position);
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.qiahao.nextvideo.room.rank.CommonGroupRankView");
            ((CommonGroupRankView) view2).initView();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 214) {
            finish();
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
}
