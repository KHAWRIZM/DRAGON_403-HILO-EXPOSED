package com.oudi.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.adapter.BaseNodeListAdapter;
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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0016J]\u0010\u001d\u001a\u00020\u00112S\u0010\u001e\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\tH\u0016J]\u0010 \u001a\u00020\u00112S\u0010\u001e\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\tH\u0016J]\u0010!\u001a\u00020\u00112S\u0010\u001e\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\tH\u0016J]\u0010\"\u001a\u00020\u00112S\u0010\u001e\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\tH\u0016J%\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110%H\u0016¢\u0006\u0002\u0010&R]\u0010\b\u001aQ\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R]\u0010\u0012\u001aQ\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R]\u0010\u0014\u001aQ\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R]\u0010\u0015\u001aQ\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0013\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/oudi/adapter/BaseNodeListAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "Lcom/oudi/adapter/IListAdapter;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "data", "", "<init>", "(Ljava/util/List;)V", "onItemClickListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "adapter", "Landroid/view/View;", "v", "", "position", "", "onItemLongClickListener", "", "onItemChildClickListener", "onItemChildLongClickListener", "getRecyclerViewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "addData", "list", "", "getDatas", "replaceData", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, ViewHierarchyConstants.VIEW_KEY, "setOnItemLongClickListener", "setOnItemChildClickListener", "setOnItemChildLongClickListener", "setPreLoadNumber", "preLoadNumber", "Lkotlin/Function0;", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "lib_adapter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseNodeListAdapter extends BaseNodeAdapter implements IListAdapter<BaseNode> {
    private Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Unit> onItemChildClickListener;
    private Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Boolean> onItemChildLongClickListener;
    private Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Unit> onItemClickListener;
    private Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Boolean> onItemLongClickListener;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseNodeListAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnItemChildClickListener$lambda$2(BaseNodeListAdapter baseNodeListAdapter, BaseQuickAdapter adapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Unit> function3 = baseNodeListAdapter.onItemChildClickListener;
        if (function3 != null) {
            function3.invoke(baseNodeListAdapter, view, Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnItemChildLongClickListener$lambda$3(BaseNodeListAdapter baseNodeListAdapter, BaseQuickAdapter adapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Boolean> function3 = baseNodeListAdapter.onItemChildLongClickListener;
        if (function3 != null) {
            return function3.invoke(baseNodeListAdapter, view, Integer.valueOf(i10)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnItemClickListener$lambda$0(BaseNodeListAdapter baseNodeListAdapter, BaseQuickAdapter adapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Unit> function3 = baseNodeListAdapter.onItemClickListener;
        if (function3 != null) {
            function3.invoke(baseNodeListAdapter, view, Integer.valueOf(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnItemLongClickListener$lambda$1(BaseNodeListAdapter baseNodeListAdapter, BaseQuickAdapter adapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Boolean> function3 = baseNodeListAdapter.onItemLongClickListener;
        if (function3 != null) {
            return function3.invoke(baseNodeListAdapter, view, Integer.valueOf(i10)).booleanValue();
        }
        return false;
    }

    @Override // com.oudi.adapter.IListAdapter
    public void addData(List<? extends BaseNode> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        super.addData((Collection<? extends BaseNode>) list);
    }

    @Override // com.oudi.adapter.IListAdapter
    public List<BaseNode> getDatas() {
        return getData();
    }

    @Override // com.oudi.adapter.IListAdapter
    public RecyclerView.Adapter<?> getRecyclerViewAdapter() {
        return this;
    }

    @Override // com.oudi.adapter.IListAdapter
    public void replaceData(List<? extends BaseNode> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        super.setList(list);
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setOnItemChildClickListener(Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemChildClickListener = listener;
        setOnItemChildClickListener(new OnItemChildClickListener() { // from class: ra.k
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                BaseNodeListAdapter.setOnItemChildClickListener$lambda$2(BaseNodeListAdapter.this, baseQuickAdapter, view, i10);
            }
        });
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setOnItemChildLongClickListener(Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Boolean> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemChildLongClickListener = listener;
        setOnItemChildLongClickListener(new OnItemChildLongClickListener() { // from class: ra.i
            @Override // com.chad.library.adapter.base.listener.OnItemChildLongClickListener
            public final boolean onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                boolean onItemChildLongClickListener$lambda$3;
                onItemChildLongClickListener$lambda$3 = BaseNodeListAdapter.setOnItemChildLongClickListener$lambda$3(BaseNodeListAdapter.this, baseQuickAdapter, view, i10);
                return onItemChildLongClickListener$lambda$3;
            }
        });
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setOnItemClickListener(Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemClickListener = listener;
        setOnItemClickListener(new OnItemClickListener() { // from class: ra.l
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                BaseNodeListAdapter.setOnItemClickListener$lambda$0(BaseNodeListAdapter.this, baseQuickAdapter, view, i10);
            }
        });
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setOnItemLongClickListener(Function3<? super IListAdapter<? extends BaseNode>, ? super View, ? super Integer, Boolean> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onItemLongClickListener = listener;
        setOnItemLongClickListener(new OnItemLongClickListener() { // from class: ra.j
            @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                boolean onItemLongClickListener$lambda$1;
                onItemLongClickListener$lambda$1 = BaseNodeListAdapter.setOnItemLongClickListener$lambda$1(BaseNodeListAdapter.this, baseQuickAdapter, view, i10);
                return onItemLongClickListener$lambda$1;
            }
        });
    }

    @Override // com.oudi.adapter.IListAdapter
    public void setPreLoadNumber(Integer preLoadNumber, Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.oudi.adapter.IListAdapter
    public void update(int i10, Object obj, Function1<? super BaseNode, Unit> function1) {
        IListAdapter.DefaultImpls.update(this, i10, obj, function1);
    }

    @Override // com.oudi.adapter.IListAdapter
    public void updateFirst(Function2<? super Integer, ? super BaseNode, Boolean> function2, Object obj, Function2<? super Integer, ? super BaseNode, Unit> function22) {
        IListAdapter.DefaultImpls.updateFirst(this, function2, obj, function22);
    }

    public /* synthetic */ BaseNodeListAdapter(List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new ArrayList() : list);
    }

    @Override // com.oudi.adapter.IListAdapter
    public void update(Function2<? super Integer, ? super BaseNode, Boolean> function2, Object obj, Function2<? super Integer, ? super BaseNode, Unit> function22) {
        IListAdapter.DefaultImpls.update(this, function2, obj, function22);
    }

    public BaseNodeListAdapter(List<BaseNode> list) {
        super(list);
    }
}
