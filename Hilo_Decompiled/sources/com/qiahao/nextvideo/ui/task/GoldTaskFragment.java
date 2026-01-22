package com.qiahao.nextvideo.ui.task;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.tabs.TabLayout;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.CustomTabLayout;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.tab.TaskTabData;
import com.qiahao.nextvideo.data.task.GoldTaskData;
import com.qiahao.nextvideo.data.task.TaskProcess;
import com.qiahao.nextvideo.databinding.FragmentGoldTaskBinding;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.view.TaskView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u001b\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/GoldTaskFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentGoldTaskBinding;", "<init>", "()V", "", "initData", "initView", "Lcom/qiahao/nextvideo/data/task/GoldTaskData;", "goldTask", "initTab", "(Lcom/qiahao/nextvideo/data/task/GoldTaskData;)V", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/nextvideo/ui/task/TaskViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/task/TaskViewModel;", "viewModel", "Lcom/qiahao/nextvideo/ui/task/GoldGameListAdapter;", "mGameAdapter$delegate", "getMGameAdapter", "()Lcom/qiahao/nextvideo/ui/task/GoldGameListAdapter;", "mGameAdapter", "Lcom/google/android/material/tabs/TabLayout$d;", "mListener", "Lcom/google/android/material/tabs/TabLayout$d;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGoldTaskFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoldTaskFragment.kt\ncom/qiahao/nextvideo/ui/task/GoldTaskFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,210:1\n61#2,9:211\n61#2,9:220\n1#3:229\n1869#4,2:230\n1869#4,2:232\n*S KotlinDebug\n*F\n+ 1 GoldTaskFragment.kt\ncom/qiahao/nextvideo/ui/task/GoldTaskFragment\n*L\n127#1:211,9\n133#1:220,9\n164#1:230,2\n167#1:232,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GoldTaskFragment extends BaseBindingFragment<FragmentGoldTaskBinding> {

    @Nullable
    private TabLayout.d mListener;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.r
        public final Object invoke() {
            TaskViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = GoldTaskFragment.viewModel_delegate$lambda$0(GoldTaskFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mGameAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mGameAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.s
        public final Object invoke() {
            GoldGameListAdapter mGameAdapter_delegate$lambda$1;
            mGameAdapter_delegate$lambda$1 = GoldTaskFragment.mGameAdapter_delegate$lambda$1();
            return mGameAdapter_delegate$lambda$1;
        }
    });

    private final GoldGameListAdapter getMGameAdapter() {
        return (GoldGameListAdapter) this.mGameAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskViewModel getViewModel() {
        return (TaskViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getTaskProcess().observe(this, new GoldTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.n
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = GoldTaskFragment.initData$lambda$2(GoldTaskFragment.this, (GoldTaskData) obj);
                return initData$lambda$2;
            }
        }));
        getViewModel().getTaskList().observe(this, new GoldTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.o
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = GoldTaskFragment.initData$lambda$3(GoldTaskFragment.this, (ArrayList) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getMException().observe(this, new GoldTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.p
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = GoldTaskFragment.initData$lambda$4(GoldTaskFragment.this, (Pair) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getMSuccess().observe(this, new GoldTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.q
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = GoldTaskFragment.initData$lambda$5(GoldTaskFragment.this, (Pair) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().taskGameList();
        getViewModel().taskProcess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(GoldTaskFragment goldTaskFragment, GoldTaskData goldTaskData) {
        goldTaskFragment.initTab(goldTaskData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(GoldTaskFragment goldTaskFragment, ArrayList arrayList) {
        goldTaskFragment.getMGameAdapter().setList(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(GoldTaskFragment goldTaskFragment, Pair pair) {
        String str;
        if (pair.getSecond() instanceof HiloException) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = goldTaskFragment.getContext();
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(goldTaskFragment, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(GoldTaskFragment goldTaskFragment, Pair pair) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, goldTaskFragment.getContext(), ResourcesKtxKt.getStringById(goldTaskFragment, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    @SuppressLint({"SetTextI18n"})
    private final void initTab(final GoldTaskData goldTask) {
        int i;
        int i2;
        TextView textView;
        Integer num;
        CustomTabLayout customTabLayout;
        CustomTabLayout customTabLayout2;
        CustomTabLayout customTabLayout3;
        List<TaskProcess> process;
        TaskProcess taskProcess;
        TextView textView2;
        int i3;
        TextView textView3;
        Context context;
        FragmentGoldTaskBinding fragmentGoldTaskBinding;
        TextView textView4;
        int i4;
        TextView textView5;
        Drawable drawable;
        int i5;
        TaskView taskView;
        TabLayout.f fVar;
        FragmentGoldTaskBinding fragmentGoldTaskBinding2;
        CustomTabLayout customTabLayout4;
        TaskTabView taskTabView;
        CustomTabLayout customTabLayout5;
        List<TaskProcess> process2;
        String str;
        boolean z;
        TextView textView6;
        Context context2;
        Integer monthCharge;
        Integer monthCharge2;
        CustomTabLayout customTabLayout6;
        CustomTabLayout customTabLayout7;
        TabLayout.d dVar = this.mListener;
        TabLayout.f fVar2 = null;
        if (dVar != null) {
            FragmentGoldTaskBinding fragmentGoldTaskBinding3 = (FragmentGoldTaskBinding) getBinding();
            if (fragmentGoldTaskBinding3 != null && (customTabLayout7 = fragmentGoldTaskBinding3.tabLayout) != null) {
                customTabLayout7.removeOnTabSelectedListener(dVar);
            }
            this.mListener = null;
        }
        FragmentGoldTaskBinding fragmentGoldTaskBinding4 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding4 != null && (customTabLayout6 = fragmentGoldTaskBinding4.tabLayout) != null) {
            customTabLayout6.removeAllTabs();
        }
        if (goldTask != null && (monthCharge2 = goldTask.getMonthCharge()) != null) {
            i = monthCharge2.intValue();
        } else {
            i = 0;
        }
        String str2 = "$" + i;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953860);
        if (goldTask != null && (monthCharge = goldTask.getMonthCharge()) != null) {
            i2 = monthCharge.intValue();
        } else {
            i2 = 0;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        FragmentGoldTaskBinding fragmentGoldTaskBinding5 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding5 != null) {
            textView = fragmentGoldTaskBinding5.subTitle;
        } else {
            textView = null;
        }
        SpannableTextBuilder spannableTextBuilder = new SpannableTextBuilder(textView);
        FragmentGoldTaskBinding fragmentGoldTaskBinding6 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding6 != null && (textView6 = fragmentGoldTaskBinding6.subTitle) != null && (context2 = textView6.getContext()) != null) {
            num = Integer.valueOf(androidx.core.content.a.getColor(context2, 2131099986));
        } else {
            num = null;
        }
        SpannableTextBuilder.changeTextColor$default(spannableTextBuilder, format, str2, num, (Integer) null, 8, (Object) null).apply();
        ArrayList<TaskTabData> arrayList = new ArrayList();
        if (goldTask != null && (process2 = goldTask.getProcess()) != null) {
            for (TaskProcess taskProcess2 : process2) {
                TaskTabData.Companion companion = TaskTabData.INSTANCE;
                if (taskProcess2 == null || (str = taskProcess2.getTitle()) == null) {
                    str = "";
                }
                if (taskProcess2 != null) {
                    z = Intrinsics.areEqual(taskProcess2.getUnlock(), Boolean.TRUE);
                } else {
                    z = false;
                }
                arrayList.add(companion.initDefault(str, z));
            }
        }
        for (TaskTabData taskTabData : arrayList) {
            FragmentGoldTaskBinding fragmentGoldTaskBinding7 = (FragmentGoldTaskBinding) getBinding();
            if (fragmentGoldTaskBinding7 != null && (customTabLayout5 = fragmentGoldTaskBinding7.tabLayout) != null) {
                fVar = customTabLayout5.newTab();
            } else {
                fVar = null;
            }
            if (fVar != null) {
                Context context3 = getContext();
                if (context3 != null) {
                    taskTabView = new TaskTabView(context3, taskTabData);
                } else {
                    taskTabView = null;
                }
                fVar.o(taskTabView);
            }
            if (fVar != null && (fragmentGoldTaskBinding2 = (FragmentGoldTaskBinding) getBinding()) != null && (customTabLayout4 = fragmentGoldTaskBinding2.tabLayout) != null) {
                customTabLayout4.addTab(fVar);
            }
        }
        if (goldTask != null && (process = goldTask.getProcess()) != null && (taskProcess = process.get(getViewModel().getSelectPosition())) != null) {
            FragmentGoldTaskBinding fragmentGoldTaskBinding8 = (FragmentGoldTaskBinding) getBinding();
            if (fragmentGoldTaskBinding8 != null && (taskView = fragmentGoldTaskBinding8.taskView) != null) {
                taskView.refreshData(taskProcess);
            }
            FragmentGoldTaskBinding fragmentGoldTaskBinding9 = (FragmentGoldTaskBinding) getBinding();
            if (fragmentGoldTaskBinding9 != null && (textView5 = fragmentGoldTaskBinding9.signIn) != null) {
                Context context4 = getContext();
                if (context4 != null) {
                    Boolean sign = taskProcess.getSign();
                    Boolean bool = Boolean.TRUE;
                    if (Intrinsics.areEqual(sign, bool) && Intrinsics.areEqual(taskProcess.getUnlock(), bool)) {
                        i5 = R.drawable.task_button_default;
                    } else {
                        i5 = R.drawable.task_button_select;
                    }
                    drawable = androidx.core.content.a.getDrawable(context4, i5);
                } else {
                    drawable = null;
                }
                textView5.setBackground(drawable);
            }
            FragmentGoldTaskBinding fragmentGoldTaskBinding10 = (FragmentGoldTaskBinding) getBinding();
            if (fragmentGoldTaskBinding10 != null && (textView3 = fragmentGoldTaskBinding10.signIn) != null && (context = textView3.getContext()) != null && (fragmentGoldTaskBinding = (FragmentGoldTaskBinding) getBinding()) != null && (textView4 = fragmentGoldTaskBinding.signIn) != null) {
                Boolean sign2 = taskProcess.getSign();
                Boolean bool2 = Boolean.TRUE;
                if (Intrinsics.areEqual(sign2, bool2) && Intrinsics.areEqual(taskProcess.getUnlock(), bool2)) {
                    i4 = 2131099900;
                } else {
                    i4 = 2131099959;
                }
                textView4.setTextColor(androidx.core.content.a.getColor(context, i4));
            }
            FragmentGoldTaskBinding fragmentGoldTaskBinding11 = (FragmentGoldTaskBinding) getBinding();
            if (fragmentGoldTaskBinding11 != null && (textView2 = fragmentGoldTaskBinding11.signIn) != null) {
                Boolean sign3 = taskProcess.getSign();
                Boolean bool3 = Boolean.TRUE;
                if (Intrinsics.areEqual(sign3, bool3) && Intrinsics.areEqual(taskProcess.getUnlock(), bool3)) {
                    i3 = 2131954092;
                } else {
                    i3 = 2131954087;
                }
                textView2.setText(ResourcesKtxKt.getStringById(this, i3));
            }
        }
        if (this.mListener == null) {
            TabLayout.d dVar2 = new TabLayout.d() { // from class: com.qiahao.nextvideo.ui.task.GoldTaskFragment$initTab$6
                public void onTabReselected(TabLayout.f tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                }

                public void onTabSelected(TabLayout.f tab) {
                    TaskViewModel viewModel;
                    int i6;
                    View view;
                    TaskTabView taskTabView2;
                    List<TaskProcess> process3;
                    int i7;
                    TextView textView7;
                    int i8;
                    TextView textView8;
                    Context context5;
                    FragmentGoldTaskBinding fragmentGoldTaskBinding12;
                    TextView textView9;
                    int i9;
                    TextView textView10;
                    int i10;
                    TaskView taskView2;
                    viewModel = GoldTaskFragment.this.getViewModel();
                    if (tab != null) {
                        i6 = tab.g();
                    } else {
                        i6 = 0;
                    }
                    viewModel.setSelectPosition(i6);
                    Drawable drawable2 = null;
                    if (tab != null) {
                        view = tab.e();
                    } else {
                        view = null;
                    }
                    if (view instanceof TaskTabView) {
                        taskTabView2 = (TaskTabView) view;
                    } else {
                        taskTabView2 = null;
                    }
                    if (taskTabView2 != null) {
                        taskTabView2.setSelected(true);
                    }
                    GoldTaskData goldTaskData = goldTask;
                    if (goldTaskData != null && (process3 = goldTaskData.getProcess()) != null) {
                        if (tab != null) {
                            i7 = tab.g();
                        } else {
                            i7 = -1;
                        }
                        TaskProcess taskProcess3 = process3.get(i7);
                        if (taskProcess3 != null) {
                            GoldTaskFragment goldTaskFragment = GoldTaskFragment.this;
                            FragmentGoldTaskBinding fragmentGoldTaskBinding13 = (FragmentGoldTaskBinding) goldTaskFragment.getBinding();
                            if (fragmentGoldTaskBinding13 != null && (taskView2 = fragmentGoldTaskBinding13.taskView) != null) {
                                taskView2.refreshData(taskProcess3);
                            }
                            FragmentGoldTaskBinding fragmentGoldTaskBinding14 = (FragmentGoldTaskBinding) goldTaskFragment.getBinding();
                            if (fragmentGoldTaskBinding14 != null && (textView10 = fragmentGoldTaskBinding14.signIn) != null) {
                                Context context6 = goldTaskFragment.getContext();
                                if (context6 != null) {
                                    Boolean sign4 = taskProcess3.getSign();
                                    Boolean bool4 = Boolean.TRUE;
                                    if (Intrinsics.areEqual(sign4, bool4) && Intrinsics.areEqual(taskProcess3.getUnlock(), bool4)) {
                                        i10 = R.drawable.task_button_default;
                                    } else {
                                        i10 = R.drawable.task_button_select;
                                    }
                                    drawable2 = androidx.core.content.a.getDrawable(context6, i10);
                                }
                                textView10.setBackground(drawable2);
                            }
                            FragmentGoldTaskBinding fragmentGoldTaskBinding15 = (FragmentGoldTaskBinding) goldTaskFragment.getBinding();
                            if (fragmentGoldTaskBinding15 != null && (textView8 = fragmentGoldTaskBinding15.signIn) != null && (context5 = textView8.getContext()) != null && (fragmentGoldTaskBinding12 = (FragmentGoldTaskBinding) goldTaskFragment.getBinding()) != null && (textView9 = fragmentGoldTaskBinding12.signIn) != null) {
                                Boolean sign5 = taskProcess3.getSign();
                                Boolean bool5 = Boolean.TRUE;
                                if (Intrinsics.areEqual(sign5, bool5) && Intrinsics.areEqual(taskProcess3.getUnlock(), bool5)) {
                                    i9 = 2131099900;
                                } else {
                                    i9 = 2131099959;
                                }
                                textView9.setTextColor(androidx.core.content.a.getColor(context5, i9));
                            }
                            FragmentGoldTaskBinding fragmentGoldTaskBinding16 = (FragmentGoldTaskBinding) goldTaskFragment.getBinding();
                            if (fragmentGoldTaskBinding16 != null && (textView7 = fragmentGoldTaskBinding16.signIn) != null) {
                                Boolean sign6 = taskProcess3.getSign();
                                Boolean bool6 = Boolean.TRUE;
                                if (Intrinsics.areEqual(sign6, bool6) && Intrinsics.areEqual(taskProcess3.getUnlock(), bool6)) {
                                    i8 = 2131954092;
                                } else {
                                    i8 = 2131954087;
                                }
                                textView7.setText(ResourcesKtxKt.getStringById(this, i8));
                            }
                        }
                    }
                }

                public void onTabUnselected(TabLayout.f tab) {
                    KeyEvent.Callback callback;
                    TaskTabView taskTabView2 = null;
                    if (tab != null) {
                        callback = tab.e();
                    } else {
                        callback = null;
                    }
                    if (callback instanceof TaskTabView) {
                        taskTabView2 = (TaskTabView) callback;
                    }
                    if (taskTabView2 != null) {
                        taskTabView2.setSelected(false);
                    }
                }
            };
            this.mListener = dVar2;
            FragmentGoldTaskBinding fragmentGoldTaskBinding12 = (FragmentGoldTaskBinding) getBinding();
            if (fragmentGoldTaskBinding12 != null && (customTabLayout3 = fragmentGoldTaskBinding12.tabLayout) != null) {
                customTabLayout3.addOnTabSelectedListener(dVar2);
            }
        }
        FragmentGoldTaskBinding fragmentGoldTaskBinding13 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding13 != null && (customTabLayout = fragmentGoldTaskBinding13.tabLayout) != null) {
            FragmentGoldTaskBinding fragmentGoldTaskBinding14 = (FragmentGoldTaskBinding) getBinding();
            if (fragmentGoldTaskBinding14 != null && (customTabLayout2 = fragmentGoldTaskBinding14.tabLayout) != null) {
                fVar2 = customTabLayout2.getTabAt(getViewModel().getSelectPosition());
            }
            customTabLayout.selectTab(fVar2);
        }
    }

    static /* synthetic */ void initTab$default(GoldTaskFragment goldTaskFragment, GoldTaskData goldTaskData, int i, Object obj) {
        if ((i & 1) != 0) {
            goldTaskData = null;
        }
        goldTaskFragment.initTab(goldTaskData);
    }

    private final void initView() {
        final TextView textView;
        final ImageView imageView;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        CustomTabLayout customTabLayout;
        ConstraintLayout constraintLayout;
        TaskView taskView;
        ConstraintLayout constraintLayout2;
        FragmentGoldTaskBinding fragmentGoldTaskBinding = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding != null && (constraintLayout2 = fragmentGoldTaskBinding.goldLayout) != null) {
            constraintLayout2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentGoldTaskBinding fragmentGoldTaskBinding2 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding2 != null && (taskView = fragmentGoldTaskBinding2.taskView) != null) {
            taskView.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#E1D7FF", 8, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 104, (Object) null));
        }
        FragmentGoldTaskBinding fragmentGoldTaskBinding3 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding3 != null && (constraintLayout = fragmentGoldTaskBinding3.taskLayout) != null) {
            constraintLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentGoldTaskBinding fragmentGoldTaskBinding4 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding4 != null && (customTabLayout = fragmentGoldTaskBinding4.tabLayout) != null) {
            customTabLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#C9BEFA", "#C9BEFA", 16, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentGoldTaskBinding fragmentGoldTaskBinding5 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding5 != null && (recyclerView2 = fragmentGoldTaskBinding5.recyclerView) != null) {
            recyclerView2.setAdapter(getMGameAdapter());
        }
        getMGameAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.task.m
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GoldTaskFragment.initView$lambda$7(GoldTaskFragment.this, baseQuickAdapter, view, i);
            }
        });
        FragmentGoldTaskBinding fragmentGoldTaskBinding6 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding6 != null && (recyclerView = fragmentGoldTaskBinding6.recyclerView) != null) {
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.task.GoldTaskFragment$initView$2
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view, parent, state);
                    int childLayoutPosition = parent.getChildLayoutPosition(view);
                    outRect.top = UiKtxKt.toPX(14);
                    int i = childLayoutPosition % 4;
                    if (i != 0) {
                        if (i != 3) {
                            outRect.right = UiKtxKt.toPX(15);
                            outRect.left = UiKtxKt.toPX(15);
                            return;
                        } else if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                            outRect.right = UiKtxKt.toPX(15);
                            outRect.left = UiKtxKt.toPX(10);
                            return;
                        } else {
                            outRect.left = UiKtxKt.toPX(15);
                            outRect.right = UiKtxKt.toPX(10);
                            return;
                        }
                    }
                    if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                        outRect.right = UiKtxKt.toPX(10);
                        outRect.left = UiKtxKt.toPX(15);
                    } else {
                        outRect.left = UiKtxKt.toPX(10);
                        outRect.right = UiKtxKt.toPX(15);
                    }
                }
            });
        }
        FragmentGoldTaskBinding fragmentGoldTaskBinding7 = (FragmentGoldTaskBinding) getBinding();
        final long j = 800;
        if (fragmentGoldTaskBinding7 != null && (imageView = fragmentGoldTaskBinding7.question) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.task.GoldTaskFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            new GoldTaskDialog(context).show();
                        }
                    }
                }
            });
        }
        FragmentGoldTaskBinding fragmentGoldTaskBinding8 = (FragmentGoldTaskBinding) getBinding();
        if (fragmentGoldTaskBinding8 != null && (textView = fragmentGoldTaskBinding8.signIn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.task.GoldTaskFragment$initView$$inlined$singleClick$default$2
                /* JADX WARN: Code restructure failed: missing block: B:32:0x00cd, code lost:
                
                    if (r7 != null) goto L٣٥;
                 */
                /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
                /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
                /* JADX WARN: Removed duplicated region for block: B:37:0x00d9  */
                /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void onClick(View view) {
                    TaskViewModel viewModel;
                    boolean z;
                    TaskViewModel viewModel2;
                    boolean z2;
                    TaskViewModel viewModel3;
                    TaskViewModel viewModel4;
                    List<TaskProcess> process;
                    TaskViewModel viewModel5;
                    Integer level;
                    TaskViewModel viewModel6;
                    String str;
                    List<TaskProcess> process2;
                    TaskViewModel viewModel7;
                    List<TaskProcess> process3;
                    TaskViewModel viewModel8;
                    List<TaskProcess> process4;
                    TaskViewModel viewModel9;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        viewModel = this.getViewModel();
                        GoldTaskData goldTaskData = (GoldTaskData) viewModel.getTaskProcess().getValue();
                        int i = 0;
                        if (goldTaskData != null && (process4 = goldTaskData.getProcess()) != null) {
                            viewModel9 = this.getViewModel();
                            TaskProcess taskProcess = process4.get(viewModel9.getSelectPosition());
                            if (taskProcess != null) {
                                z = Intrinsics.areEqual(taskProcess.getSign(), Boolean.TRUE);
                                if (z) {
                                    viewModel2 = this.getViewModel();
                                    GoldTaskData goldTaskData2 = (GoldTaskData) viewModel2.getTaskProcess().getValue();
                                    if (goldTaskData2 != null && (process3 = goldTaskData2.getProcess()) != null) {
                                        viewModel8 = this.getViewModel();
                                        TaskProcess taskProcess2 = process3.get(viewModel8.getSelectPosition());
                                        if (taskProcess2 != null) {
                                            z2 = Intrinsics.areEqual(taskProcess2.getUnlock(), Boolean.FALSE);
                                            if (z2) {
                                                viewModel3 = this.getViewModel();
                                                viewModel4 = this.getViewModel();
                                                GoldTaskData goldTaskData3 = (GoldTaskData) viewModel4.getTaskProcess().getValue();
                                                if (goldTaskData3 != null && (process = goldTaskData3.getProcess()) != null) {
                                                    viewModel5 = this.getViewModel();
                                                    TaskProcess taskProcess3 = process.get(viewModel5.getSelectPosition());
                                                    if (taskProcess3 != null && (level = taskProcess3.getLevel()) != null) {
                                                        i = level.intValue();
                                                    }
                                                }
                                                viewModel3.taskSign(i);
                                                return;
                                            }
                                            Context context = this.getContext();
                                            if (context != null) {
                                                TipDialog tipDialog = new TipDialog(context);
                                                viewModel6 = this.getViewModel();
                                                GoldTaskData goldTaskData4 = (GoldTaskData) viewModel6.getTaskProcess().getValue();
                                                if (goldTaskData4 != null && (process2 = goldTaskData4.getProcess()) != null) {
                                                    viewModel7 = this.getViewModel();
                                                    TaskProcess taskProcess4 = process2.get(viewModel7.getSelectPosition());
                                                    if (taskProcess4 != null) {
                                                        str = taskProcess4.getUnlockDesc();
                                                    }
                                                }
                                                str = "";
                                                tipDialog.setTipContent(str).show();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    z2 = false;
                                    if (z2) {
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(GoldTaskFragment goldTaskFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GameConfiguration gameConfiguration = (GameConfiguration) goldTaskFragment.getMGameAdapter().getData().get(i);
        Context context = goldTaskFragment.getContext();
        if (context != null) {
            GameJum.INSTANCE.showGame(context, gameConfiguration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GoldGameListAdapter mGameAdapter_delegate$lambda$1() {
        return new GoldGameListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskViewModel viewModel_delegate$lambda$0(GoldTaskFragment goldTaskFragment) {
        return new ViewModelProvider(goldTaskFragment).get(TaskViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_gold_task;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }
}
