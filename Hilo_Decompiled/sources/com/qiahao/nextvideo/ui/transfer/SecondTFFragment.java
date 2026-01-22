package com.qiahao.nextvideo.ui.transfer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.github.gzuliyujiang.wheelpicker.OptionPicker;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.data.transfer.SecondMonth;
import com.qiahao.nextvideo.data.transfer.SecondRank;
import com.qiahao.nextvideo.data.transfer.TransferDate;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.databinding.FragmentSecondHeadBinding;
import com.qiahao.nextvideo.databinding.FragmentSecondTfBinding;
import com.qiahao.nextvideo.databinding.IncludeTransferTextBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010,\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0013J\b\u0010-\u001a\u00020\u0006H\u0014J\b\u0010.\u001a\u00020\rH\u0016J\b\u0010/\u001a\u00020\rH\u0003J\b\u00100\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\rH\u0007J\b\u00102\u001a\u00020\rH\u0002J\u0018\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u001704j\b\u0012\u0004\u0012\u00020\u0017`5H\u0002J\b\u00106\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b)\u0010*¨\u00068"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondTFFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentSecondTfBinding;", "<init>", "()V", "mSelectPosition", "", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "Lkotlin/ParameterName;", "name", "data", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mPeriodData", "Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;", "mHeaderBinding", "Lcom/qiahao/nextvideo/databinding/FragmentSecondHeadBinding;", "mCenterType", "", "getMCenterType", "()Ljava/lang/String;", "setMCenterType", "(Ljava/lang/String;)V", "mType", "getMType", "()I", "setMType", "(I)V", "mViewModel", "Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/ui/transfer/SecondFragmentAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/transfer/SecondFragmentAdapter;", "mAdapter$delegate", "refreshPeriodData", "getLayoutResId", "onInitialize", "initData", "initView", "refreshRange", "showPickerDialog", "getPickerData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSecondTFFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SecondTFFragment.kt\ncom/qiahao/nextvideo/ui/transfer/SecondTFFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,249:1\n1#2:250\n61#3,9:251\n1869#4,2:260\n1869#4,2:262\n*S KotlinDebug\n*F\n+ 1 SecondTFFragment.kt\ncom/qiahao/nextvideo/ui/transfer/SecondTFFragment\n*L\n128#1:251,9\n230#1:260,2\n235#1:262,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SecondTFFragment extends BaseBindingFragment<FragmentSecondTfBinding> {
    public static final int TRANSFER_MONTH = 1;

    @NotNull
    public static final String TRANSFER_TYPE = "transfer_type";
    public static final int TRANSFER_WEEKLY = 0;

    @Nullable
    private FragmentSecondHeadBinding mHeaderBinding;

    @Nullable
    private Function1<? super DealerDiamondConfig, Unit> mListener;

    @Nullable
    private TransferPeriod mPeriodData;
    private int mType;
    private int mSelectPosition = -1;

    @NotNull
    private String mCenterType = TransferCenterFragment.TYPE_DIAMONDS;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.g
        public final Object invoke() {
            SecondViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = SecondTFFragment.mViewModel_delegate$lambda$0(SecondTFFragment.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.h
        public final Object invoke() {
            SecondFragmentAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = SecondTFFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final SecondFragmentAdapter getMAdapter() {
        return (SecondFragmentAdapter) this.mAdapter.getValue();
    }

    private final SecondViewModel getMViewModel() {
        return (SecondViewModel) this.mViewModel.getValue();
    }

    private final ArrayList<String> getPickerData() {
        ArrayList<TransferDate> month;
        int i;
        String str;
        ArrayList<TransferDate> week;
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.mType == 0) {
            TransferPeriod transferPeriod = this.mPeriodData;
            if (transferPeriod != null && (week = transferPeriod.getWeek()) != null) {
                for (TransferDate transferDate : week) {
                    arrayList.add(transferDate.getStartDate() + "~" + transferDate.getEndDate());
                }
            }
        } else {
            TransferPeriod transferPeriod2 = this.mPeriodData;
            if (transferPeriod2 != null && (month = transferPeriod2.getMonth()) != null) {
                for (TransferDate transferDate2 : month) {
                    String startDate = transferDate2.getStartDate();
                    if (startDate != null) {
                        i = StringsKt.lastIndexOf$default(startDate, "-", 0, false, 6, (Object) null);
                    } else {
                        i = 0;
                    }
                    String startDate2 = transferDate2.getStartDate();
                    if (startDate2 != null) {
                        str = startDate2.substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                    str = "";
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"SetTextI18n"})
    private final void initData() {
        getMViewModel().getSecondRank().observe(this, new SecondTFFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.i
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = SecondTFFragment.initData$lambda$3(SecondTFFragment.this, (ApiList) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getSearch().observe(this, new SecondTFFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.j
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = SecondTFFragment.initData$lambda$4(SecondTFFragment.this, (SecondMonth) obj);
                return initData$lambda$4;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(SecondTFFragment secondTFFragment, ApiList apiList) {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentSecondTfBinding fragmentSecondTfBinding;
        SmartRefreshLayout smartRefreshLayout3;
        if (secondTFFragment.getMViewModel().getSecondRankData().isOnePage()) {
            secondTFFragment.getMAdapter().setList(apiList.getData());
        } else {
            List data = apiList.getData();
            if (data != null) {
                secondTFFragment.getMAdapter().addData(data);
            }
        }
        if (!apiList.getHasNextPage() && (fragmentSecondTfBinding = (FragmentSecondTfBinding) secondTFFragment.getBinding()) != null && (smartRefreshLayout3 = fragmentSecondTfBinding.refreshLayout) != null) {
            smartRefreshLayout3.setNoMoreData(true);
        }
        FragmentSecondTfBinding fragmentSecondTfBinding2 = (FragmentSecondTfBinding) secondTFFragment.getBinding();
        if (fragmentSecondTfBinding2 != null && (smartRefreshLayout2 = fragmentSecondTfBinding2.refreshLayout) != null) {
            smartRefreshLayout2.finishRefresh();
        }
        FragmentSecondTfBinding fragmentSecondTfBinding3 = (FragmentSecondTfBinding) secondTFFragment.getBinding();
        if (fragmentSecondTfBinding3 != null && (smartRefreshLayout = fragmentSecondTfBinding3.refreshLayout) != null) {
            smartRefreshLayout.finishLoadMore();
        }
        FragmentSecondTfBinding fragmentSecondTfBinding4 = (FragmentSecondTfBinding) secondTFFragment.getBinding();
        if (fragmentSecondTfBinding4 != null && (superStatusView = fragmentSecondTfBinding4.statusView) != null) {
            superStatusView.showContent();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(SecondTFFragment secondTFFragment, SecondMonth secondMonth) {
        IncludeTransferTextBinding includeTransferTextBinding;
        TextView textView;
        String str;
        Integer clients;
        IncludeTransferTextBinding includeTransferTextBinding2;
        TextView textView2;
        Long reCharges;
        IncludeTransferTextBinding includeTransferTextBinding3;
        TextView textView3;
        long j;
        Long totalSales;
        FragmentSecondHeadBinding fragmentSecondHeadBinding = secondTFFragment.mHeaderBinding;
        long j2 = 0;
        if (fragmentSecondHeadBinding != null && (includeTransferTextBinding3 = fragmentSecondHeadBinding.salesLayout) != null && (textView3 = includeTransferTextBinding3.number) != null) {
            if (secondMonth != null && (totalSales = secondMonth.getTotalSales()) != null) {
                j = totalSales.longValue();
            } else {
                j = 0;
            }
            textView3.setText("$" + NumberUtilsKt.rankNumberFormat(j / 100));
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding2 = secondTFFragment.mHeaderBinding;
        if (fragmentSecondHeadBinding2 != null && (includeTransferTextBinding2 = fragmentSecondHeadBinding2.recharge) != null && (textView2 = includeTransferTextBinding2.number) != null) {
            if (secondMonth != null && (reCharges = secondMonth.getReCharges()) != null) {
                j2 = reCharges.longValue();
            }
            textView2.setText("$" + NumberUtilsKt.rankNumberFormat(j2 / 100));
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding3 = secondTFFragment.mHeaderBinding;
        if (fragmentSecondHeadBinding3 != null && (includeTransferTextBinding = fragmentSecondHeadBinding3.clientLayout) != null && (textView = includeTransferTextBinding.number) != null) {
            if (secondMonth == null || (clients = secondMonth.getClients()) == null || (str = clients.toString()) == null) {
                str = MessageService.MSG_DB_READY_REPORT;
            }
            textView.setText(str);
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        String str;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView recyclerView2;
        SmartRefreshLayout smartRefreshLayout2;
        final View view;
        IncludeTransferTextBinding includeTransferTextBinding;
        TextView textView;
        IncludeTransferTextBinding includeTransferTextBinding2;
        TextView textView2;
        IncludeTransferTextBinding includeTransferTextBinding3;
        TextView textView3;
        View view2;
        View view3;
        View view4;
        Drawable drawable;
        View root;
        SmartRefreshLayout smartRefreshLayout3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("transfer_type");
        } else {
            i = 0;
        }
        this.mType = i;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString(TransferCenterFragment.CENTER_TYPE)) == null) {
            str = TransferCenterFragment.TYPE_DIAMONDS;
        }
        this.mCenterType = str;
        Drawable drawable2 = null;
        this.mHeaderBinding = (FragmentSecondHeadBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.fragment_second_head, (ViewGroup) null, false);
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentSecondTfBinding fragmentSecondTfBinding = (FragmentSecondTfBinding) getBinding();
            if (fragmentSecondTfBinding != null && (smartRefreshLayout3 = fragmentSecondTfBinding.refreshLayout) != null) {
                smartRefreshLayout3.setRefreshFooter(footLoading);
            }
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding = this.mHeaderBinding;
        if (fragmentSecondHeadBinding != null && (root = fragmentSecondHeadBinding.getRoot()) != null) {
            BaseQuickAdapter.addHeaderView$default(getMAdapter(), root, 0, 0, 6, (Object) null);
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding2 = this.mHeaderBinding;
        if (fragmentSecondHeadBinding2 != null && (view4 = fragmentSecondHeadBinding2.selectBg) != null) {
            Context context2 = getContext();
            if (context2 != null) {
                drawable = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context2, 2131101214, 2131101214, 17, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            } else {
                drawable = null;
            }
            view4.setBackground(drawable);
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding3 = this.mHeaderBinding;
        if (fragmentSecondHeadBinding3 != null && (view3 = fragmentSecondHeadBinding3.numberBg) != null) {
            Context context3 = getContext();
            if (context3 != null) {
                drawable2 = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context3, 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            }
            view3.setBackground(drawable2);
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding4 = this.mHeaderBinding;
        if (fragmentSecondHeadBinding4 != null && (view2 = fragmentSecondHeadBinding4.saleDetail) != null) {
            view2.setBackground(ShapeUtil.INSTANCE.createShape("#8850f6", "#b043ff", 4, GradientDrawable.Orientation.TOP_BOTTOM));
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding5 = this.mHeaderBinding;
        if (fragmentSecondHeadBinding5 != null && (includeTransferTextBinding3 = fragmentSecondHeadBinding5.salesLayout) != null && (textView3 = includeTransferTextBinding3.title) != null) {
            textView3.setText(ResourcesKtxKt.getStringById(this, 2131954300));
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding6 = this.mHeaderBinding;
        if (fragmentSecondHeadBinding6 != null && (includeTransferTextBinding2 = fragmentSecondHeadBinding6.recharge) != null && (textView2 = includeTransferTextBinding2.title) != null) {
            textView2.setText(ResourcesKtxKt.getStringById(this, 2131953850));
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding7 = this.mHeaderBinding;
        if (fragmentSecondHeadBinding7 != null && (includeTransferTextBinding = fragmentSecondHeadBinding7.clientLayout) != null && (textView = includeTransferTextBinding.title) != null) {
            textView.setText(ResourcesKtxKt.getStringById(this, 2131952270));
        }
        FragmentSecondHeadBinding fragmentSecondHeadBinding8 = this.mHeaderBinding;
        if (fragmentSecondHeadBinding8 != null && (view = fragmentSecondHeadBinding8.selectBg) != null) {
            final long j = 800;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTFFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                        this.showPickerDialog();
                    }
                }
            });
        }
        FragmentSecondTfBinding fragmentSecondTfBinding2 = (FragmentSecondTfBinding) getBinding();
        if (fragmentSecondTfBinding2 != null && (smartRefreshLayout2 = fragmentSecondTfBinding2.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.transfer.d
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    SecondTFFragment.initView$lambda$11(SecondTFFragment.this, fVar);
                }
            });
        }
        FragmentSecondTfBinding fragmentSecondTfBinding3 = (FragmentSecondTfBinding) getBinding();
        if (fragmentSecondTfBinding3 != null && (recyclerView2 = fragmentSecondTfBinding3.recyclerView) != null) {
            recyclerView2.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTFFragment$initView$8
                public void getItemOffsets(Rect outRect, View view5, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view5, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view5, parent, state);
                    if (parent.getChildLayoutPosition(view5) == state.getItemCount() - 1) {
                        outRect.bottom = UiKtxKt.toPX(20);
                    }
                }
            });
        }
        FragmentSecondTfBinding fragmentSecondTfBinding4 = (FragmentSecondTfBinding) getBinding();
        if (fragmentSecondTfBinding4 != null && (smartRefreshLayout = fragmentSecondTfBinding4.refreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.transfer.e
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    SecondTFFragment.initView$lambda$12(SecondTFFragment.this, fVar);
                }
            });
        }
        getMAdapter().addChildClickViewIds(new int[]{R.id.transfer});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.f
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view5, int i2) {
                SecondTFFragment.initView$lambda$15(SecondTFFragment.this, baseQuickAdapter, view5, i2);
            }
        });
        FragmentSecondTfBinding fragmentSecondTfBinding5 = (FragmentSecondTfBinding) getBinding();
        if (fragmentSecondTfBinding5 != null && (recyclerView = fragmentSecondTfBinding5.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11(SecondTFFragment secondTFFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        secondTFFragment.refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(SecondTFFragment secondTFFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        secondTFFragment.getMViewModel().getSecondRankData().resetPage();
        secondTFFragment.refreshRange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$15(SecondTFFragment secondTFFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        User user;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        SecondRank secondRank = (SecondRank) secondTFFragment.getMAdapter().getData().get(i);
        Context context = secondTFFragment.getContext();
        if (context != null && (user = secondRank.getUser()) != null) {
            SecondTransferActivity.INSTANCE.startActivity(context, user);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecondFragmentAdapter mAdapter_delegate$lambda$1() {
        return new SecondFragmentAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecondViewModel mViewModel_delegate$lambda$0(SecondTFFragment secondTFFragment) {
        return new ViewModelProvider(secondTFFragment).get(SecondViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPickerDialog() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity != null) {
            OptionPicker optionPicker = new OptionPicker(activity);
            optionPicker.F().setVisibility(8);
            TextView C = optionPicker.C();
            C.setTextColor(androidx.core.content.a.getColor(activity, 2131099914));
            Intrinsics.checkNotNull(C);
            C.setText(ResourcesKtxKt.getStringById(C, 2131952171));
            optionPicker.D().setBackgroundColor(androidx.core.content.a.getColor(activity, 2131099808));
            optionPicker.B().setBackgroundColor(androidx.core.content.a.getColor(activity, 2131101214));
            optionPicker.G().setVisibility(8);
            TextView E = optionPicker.E();
            E.setTextColor(androidx.core.content.a.getColor(activity, 2131099914));
            Intrinsics.checkNotNull(E);
            E.setText(ResourcesKtxKt.getStringById(E, 2131952331));
            optionPicker.K().setStyle(R.style.WheelStyleDemo);
            optionPicker.setCanceledOnTouchOutside(false);
            optionPicker.M(getPickerData());
            optionPicker.setOnOptionPickedListener(new r6.l() { // from class: com.qiahao.nextvideo.ui.transfer.k
                public final void a(int i, Object obj) {
                    SecondTFFragment.showPickerDialog$lambda$20$lambda$19(SecondTFFragment.this, i, obj);
                }
            });
            optionPicker.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPickerDialog$lambda$20$lambda$19(SecondTFFragment secondTFFragment, int i, Object obj) {
        secondTFFragment.mSelectPosition = i;
        secondTFFragment.refreshRange();
    }

    protected int getLayoutResId() {
        return R.layout.fragment_second_tf;
    }

    @NotNull
    public final String getMCenterType() {
        return this.mCenterType;
    }

    @Nullable
    public final Function1<DealerDiamondConfig, Unit> getMListener() {
        return this.mListener;
    }

    public final int getMType() {
        return this.mType;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getMViewModel().getSecondRankData().destroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public final void refreshPeriodData(@Nullable TransferPeriod data) {
        ArrayList<TransferDate> month;
        ArrayList<TransferDate> week;
        if (this.mType == 0 && data != null && (week = data.getWeek()) != null && week.isEmpty()) {
            return;
        }
        if (this.mType == 1 && data != null && (month = data.getMonth()) != null && month.isEmpty()) {
            return;
        }
        this.mSelectPosition = 0;
        this.mPeriodData = data;
        refreshRange();
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0089, code lost:
    
        if (r0 == null) goto L٣٩;
     */
    @SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshRange() {
        int i;
        String str;
        TransferDate transferDate;
        TextView textView;
        String startDate;
        String startDate2;
        ArrayList<TransferDate> month;
        String str2;
        String str3;
        String str4;
        String endDate;
        TextView textView2;
        String str5;
        ArrayList<TransferDate> week;
        if (this.mSelectPosition == -1) {
            return;
        }
        TransferDate transferDate2 = null;
        String str6 = null;
        transferDate2 = null;
        String str7 = "";
        if (this.mType == 0) {
            TransferPeriod transferPeriod = this.mPeriodData;
            if (transferPeriod != null && (week = transferPeriod.getWeek()) != null) {
                transferDate = week.get(this.mSelectPosition);
            } else {
                transferDate = null;
            }
            FragmentSecondHeadBinding fragmentSecondHeadBinding = this.mHeaderBinding;
            if (fragmentSecondHeadBinding != null && (textView2 = fragmentSecondHeadBinding.time) != null) {
                if (transferDate != null) {
                    str5 = transferDate.getStartDate();
                } else {
                    str5 = null;
                }
                if (transferDate != null) {
                    str6 = transferDate.getEndDate();
                }
                textView2.setText(str5 + "~" + str6);
            }
        } else {
            TransferPeriod transferPeriod2 = this.mPeriodData;
            if (transferPeriod2 != null && (month = transferPeriod2.getMonth()) != null) {
                transferDate2 = month.get(this.mSelectPosition);
            }
            if (transferDate2 != null && (startDate2 = transferDate2.getStartDate()) != null) {
                i = StringsKt.lastIndexOf$default(startDate2, "-", 0, false, 6, (Object) null);
            } else {
                i = 0;
            }
            if (transferDate2 != null && (startDate = transferDate2.getStartDate()) != null) {
                str = startDate.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
            }
            str = "";
            FragmentSecondHeadBinding fragmentSecondHeadBinding2 = this.mHeaderBinding;
            if (fragmentSecondHeadBinding2 != null && (textView = fragmentSecondHeadBinding2.time) != null) {
                textView.setText(str);
            }
            transferDate = transferDate2;
        }
        SecondViewModel mViewModel = getMViewModel();
        if (transferDate == null || (str2 = transferDate.getStartDate()) == null) {
            str2 = "";
        }
        if (transferDate == null || (str3 = transferDate.getEndDate()) == null) {
            str3 = "";
        }
        mViewModel.secondRange(str2, str3);
        SecondViewModel mViewModel2 = getMViewModel();
        if (transferDate == null || (str4 = transferDate.getStartDate()) == null) {
            str4 = "";
        }
        if (transferDate != null && (endDate = transferDate.getEndDate()) != null) {
            str7 = endDate;
        }
        mViewModel2.secondRank(str4, str7);
    }

    public final void setMCenterType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCenterType = str;
    }

    public final void setMListener(@Nullable Function1<? super DealerDiamondConfig, Unit> function1) {
        this.mListener = function1;
    }

    public final void setMType(int i) {
        this.mType = i;
    }
}
