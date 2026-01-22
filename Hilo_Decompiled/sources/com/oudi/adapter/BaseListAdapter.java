package com.oudi.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.adapter.BaseListAdapter;
import com.oudi.adapter.IListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B#\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\u0016\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016J]\u0010 \u001a\u00020\u00142S\u0010!\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rH\u0016J]\u0010#\u001a\u00020\u00142S\u0010!\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160\rH\u0016J]\u0010$\u001a\u00020\u00142S\u0010!\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rH\u0016J]\u0010%\u001a\u00020\u00142S\u0010!\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00160\rH\u0016J%\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140(H\u0016¢\u0006\u0002\u0010)R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\f\u001aQ\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R]\u0010\u0015\u001aQ\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R]\u0010\u0017\u001aQ\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R]\u0010\u0018\u001aQ\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/oudi/adapter/BaseListAdapter;", "T", "H", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/oudi/adapter/IListAdapter;", "layoutResId", "", "data", "", "<init>", "(ILjava/util/List;)V", "onItemClickListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "adapter", "Landroid/view/View;", "v", "position", "", "onItemLongClickListener", "", "onItemChildClickListener", "onItemChildLongClickListener", "getRecyclerViewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "addData", "list", "", "getDatas", "replaceData", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, ViewHierarchyConstants.VIEW_KEY, "setOnItemLongClickListener", "setOnItemChildClickListener", "setOnItemChildLongClickListener", "setPreLoadNumber", "preLoadNumber", "Lkotlin/Function0;", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "lib_adapter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseListAdapter<T, H extends BaseViewHolder> extends BaseQuickAdapter<T, H> implements IListAdapter<T> {
    private final int layoutResId;
    private Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Unit> onItemChildClickListener;
    private Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Boolean> onItemChildLongClickListener;
    private Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Unit> onItemClickListener;
    private Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Boolean> onItemLongClickListener;

    public /* synthetic */ BaseListAdapter(int i10, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? new ArrayList() : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnItemChildClickListener$lambda$2(BaseListAdapter baseListAdapter, BaseQuickAdapter adapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Unit> function3 = baseListAdapter.onItemChildClickListener;
        if (function3 != null) {
            function3.invoke(baseListAdapter, view, Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnItemChildLongClickListener$lambda$3(BaseListAdapter baseListAdapter, BaseQuickAdapter adapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Boolean> function3 = baseListAdapter.onItemChildLongClickListener;
        if (function3 != null) {
            return function3.invoke(baseListAdapter, view, Integer.valueOf(i10)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnItemClickListener$lambda$0(BaseListAdapter baseListAdapter, BaseQuickAdapter adapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Unit> function3 = baseListAdapter.onItemClickListener;
        if (function3 != null) {
            function3.invoke(baseListAdapter, view, Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnItemLongClickListener$lambda$1(BaseListAdapter baseListAdapter, BaseQuickAdapter adapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Boolean> function3 = baseListAdapter.onItemLongClickListener;
        if (function3 != null) {
            return function3.invoke(baseListAdapter, view, Integer.valueOf(i10)).booleanValue();
        }
        return false;
    }

    @Override // com.oudi.adapter.IListAdapter
    public void addData(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        super.addData((Collection) list);
    }

    @Override // com.oudi.adapter.IListAdapter
    public List<T> getDatas() {
        return getData();
    }

    @Override // com.oudi.adapter.IListAdapter
    public RecyclerView.Adapter<?> getRecyclerViewAdapter() {
        return this;
    }

    @Override // com.oudi.adapter.IListAdapter
    public void replaceData(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        super.setList(list);
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setOnItemChildClickListener(Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemChildClickListener = listener;
        setOnItemChildClickListener(new OnItemChildClickListener() { // from class: ra.c
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                BaseListAdapter.setOnItemChildClickListener$lambda$2(BaseListAdapter.this, baseQuickAdapter, view, i10);
            }
        });
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setOnItemChildLongClickListener(Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Boolean> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemChildLongClickListener = listener;
        setOnItemChildLongClickListener(new OnItemChildLongClickListener() { // from class: ra.a
            @Override // com.chad.library.adapter.base.listener.OnItemChildLongClickListener
            public final boolean onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                boolean onItemChildLongClickListener$lambda$3;
                onItemChildLongClickListener$lambda$3 = BaseListAdapter.setOnItemChildLongClickListener$lambda$3(BaseListAdapter.this, baseQuickAdapter, view, i10);
                return onItemChildLongClickListener$lambda$3;
            }
        });
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setOnItemClickListener(Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemClickListener = listener;
        setOnItemClickListener(new OnItemClickListener() { // from class: ra.d
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                BaseListAdapter.setOnItemClickListener$lambda$0(BaseListAdapter.this, baseQuickAdapter, view, i10);
            }
        });
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setOnItemLongClickListener(Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Boolean> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemLongClickListener = listener;
        setOnItemLongClickListener(new OnItemLongClickListener() { // from class: ra.b
            @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                boolean onItemLongClickListener$lambda$1;
                onItemLongClickListener$lambda$1 = BaseListAdapter.setOnItemLongClickListener$lambda$1(BaseListAdapter.this, baseQuickAdapter, view, i10);
                return onItemLongClickListener$lambda$1;
            }
        });
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setPreLoadNumber(Integer preLoadNumber, Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.oudi.adapter.IListAdapter
    public void update(int i10, Object obj, Function1<? super T, Unit> function1) {
        IListAdapter.DefaultImpls.update(this, i10, obj, function1);
    }

    @Override // com.oudi.adapter.IListAdapter
    public void updateFirst(Function2<? super Integer, ? super T, Boolean> function2, Object obj, Function2<? super Integer, ? super T, Unit> function22) {
        IListAdapter.DefaultImpls.updateFirst(this, function2, obj, function22);
    }

    @Override // com.oudi.adapter.IListAdapter
    public void update(Function2<? super Integer, ? super T, Boolean> function2, Object obj, Function2<? super Integer, ? super T, Unit> function22) {
        IListAdapter.DefaultImpls.update(this, function2, obj, function22);
    }

    public BaseListAdapter(int i10, List<T> list) {
        super(i10, list);
        this.layoutResId = i10;
    }
}
