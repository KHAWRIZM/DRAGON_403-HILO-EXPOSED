package com.qiahao.nextvideo.ui.task;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.widget.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityTaskBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/TasksActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityTaskBinding;", "<init>", "()V", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "getLayoutResId", "onInitialize", "", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TasksActivity extends HiloBaseBindingActivity<ActivityTaskBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String SELECT_POSITION = "position";

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private int selectPosition;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/TasksActivity$Companion;", "", "<init>", "()V", "SELECT_POSITION", "", "start", "", "context", "Landroid/content/Context;", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            companion.start(context, i);
        }

        public final void start(@NotNull Context context, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) TasksActivity.class);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        this.selectPosition = getIntent().getIntExtra("position", 0);
        ((ActivityTaskBinding) getBinding()).topBg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ED74F7", "#8430FF", 0, 0, 0, 0, (GradientDrawable.Orientation) null, 124, (Object) null));
        AppCompatImageView appCompatImageView = ((ActivityTaskBinding) getBinding()).backImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "backImageView");
        getStatusBarTopOrBottom(appCompatImageView, new Function2() { // from class: com.qiahao.nextvideo.ui.task.t1
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = TasksActivity.initView$lambda$0(TasksActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityTaskBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.task.u1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TasksActivity.this.finish();
            }
        });
        if (this.mFragments.isEmpty()) {
            FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
            RoomTaskFragment findFragment = fragmentUtils.findFragment(getSupportFragmentManager(), RoomTaskFragment.class);
            if (findFragment == null) {
                findFragment = new RoomTaskFragment();
            }
            this.mFragments.add(findFragment);
            GoldTaskFragment findFragment2 = fragmentUtils.findFragment(getSupportFragmentManager(), GoldTaskFragment.class);
            if (findFragment2 == null) {
                findFragment2 = new GoldTaskFragment();
            }
            this.mFragments.add(findFragment2);
        }
        ((ActivityTaskBinding) getBinding()).viewPage.setOffscreenPageLimit(this.mFragments.size());
        ((ActivityTaskBinding) getBinding()).viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.task.TasksActivity$initView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(TasksActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList;
                arrayList = TasksActivity.this.mFragments;
                Object obj = arrayList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList;
                arrayList = TasksActivity.this.mFragments;
                return arrayList.size();
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = ((ActivityTaskBinding) getBinding()).tabSegment;
        ViewPager2 viewPager2 = ((ActivityTaskBinding) getBinding()).viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new TabTaskActivityAdapter());
        ViewPage2TabLayout viewPage2TabLayout2 = ((ActivityTaskBinding) getBinding()).tabSegment;
        Intrinsics.checkNotNullExpressionValue(viewPage2TabLayout2, "tabSegment");
        ViewKtxKt.disableTooltipText(viewPage2TabLayout2);
        ((ActivityTaskBinding) getBinding()).viewPage.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.task.v1
            @Override // java.lang.Runnable
            public final void run() {
                TasksActivity.initView$lambda$2(TasksActivity.this);
            }
        }, 500L);
    }

    public static final Unit initView$lambda$0(TasksActivity tasksActivity, int i, int i2) {
        ConstraintLayout.b layoutParams = tasksActivity.getBinding().backImageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = i;
        tasksActivity.getBinding().backImageView.setLayoutParams(bVar);
        return Unit.INSTANCE;
    }

    public static final void initView$lambda$2(TasksActivity tasksActivity) {
        if (tasksActivity.selectPosition < tasksActivity.mFragments.size()) {
            tasksActivity.getBinding().viewPage.setCurrentItem(tasksActivity.selectPosition);
        }
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_task;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }
}
