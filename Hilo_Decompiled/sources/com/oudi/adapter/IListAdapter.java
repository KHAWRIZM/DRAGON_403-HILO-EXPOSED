package com.oudi.adapter;

import a.TheRouterServiceProvideInjecter;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H&J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&J]\u0010\u0012\u001a\u00020\u00062S\u0010\u0013\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0014H&J]\u0010\u001a\u001a\u00020\u00062S\u0010\u0013\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u001b0\u0014H&J]\u0010\u001c\u001a\u00020\u00062S\u0010\u0013\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0014H&J]\u0010\u001d\u001a\u00020\u00062S\u0010\u0013\u001aO\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u001b0\u0014H&J\b\u0010\u001e\u001a\u00020\u0006H&J$\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH&J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH&J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH&J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010*\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0002H&J\b\u0010+\u001a\u00020\nH&J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH&JC\u0010-\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022%\b\u0002\u0010.\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010/H\u0016J\u0088\u0001\u00100\u001a\u00020\u000626\u00101\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u001b022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022:\b\u0002\u0010.\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u000102H\u0016J\u0088\u0001\u0010-\u001a\u00020\u000626\u00101\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u001b022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022:\b\u0002\u0010.\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u000102H\u0016J\u0090\u0001\u00103\u001a\u00020\u000626\u00101\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u001b022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u00104\u001a\u00020\u001b2:\b\u0002\u0010.\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u000102H\u0002J%\u00105\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000607H&¢\u0006\u0002\u00108¨\u00069"}, d2 = {"Lcom/oudi/adapter/IListAdapter;", "T", "", "getRecyclerViewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "addData", "", "list", "", "position", "", "item", "(ILjava/lang/Object;)V", "remove", "getDatas", "getItem", "(I)Ljava/lang/Object;", "replaceData", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "adapter", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "setOnItemLongClickListener", "", "setOnItemChildClickListener", "setOnItemChildLongClickListener", "notifyDataSetChanged", "notifyItemRangeChanged", "positionStart", "itemCount", "payload", "notifyItemMoved", "fromPosition", "toPosition", "notifyItemRangeInserted", "notifyItemRemoved", "notifyItemRangeRemoved", "notifyItemInserted", "notifyItemChanged", "getItemCount", "getItemViewType", "update", "call", "Lkotlin/Function1;", "updateFirst", "predicate", "Lkotlin/Function2;", "editUpdate", "onlyFirst", "setPreLoadNumber", "preLoadNumber", "Lkotlin/Function0;", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "lib_adapter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface IListAdapter<T> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        private static <T> void editUpdate(IListAdapter<T> iListAdapter, Function2<? super Integer, ? super T, Boolean> function2, Object obj, boolean z10, Function2<? super Integer, ? super T, Unit> function22) {
            int i10 = 0;
            for (T t10 : iListAdapter.getDatas()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (function2.invoke(Integer.valueOf(i10), t10).booleanValue()) {
                    if (function22 != null) {
                        function22.invoke(Integer.valueOf(i10), t10);
                    }
                    iListAdapter.notifyItemChanged(i10, obj);
                    if (z10) {
                        return;
                    }
                }
                i10 = i11;
            }
        }

        public static /* synthetic */ void editUpdate$default(IListAdapter iListAdapter, Function2 function2, Object obj, boolean z10, Function2 function22, int i10, Object obj2) {
            if (obj2 == null) {
                if ((i10 & 2) != 0) {
                    obj = null;
                }
                if ((i10 & 8) != 0) {
                    function22 = null;
                }
                editUpdate(iListAdapter, function2, obj, z10, function22);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: editUpdate");
        }

        public static /* synthetic */ void notifyItemChanged$default(IListAdapter iListAdapter, int i10, Object obj, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 2) != 0) {
                    obj = null;
                }
                iListAdapter.notifyItemChanged(i10, obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyItemChanged");
        }

        public static /* synthetic */ void notifyItemRangeChanged$default(IListAdapter iListAdapter, int i10, int i11, Object obj, int i12, Object obj2) {
            if (obj2 == null) {
                if ((i12 & 4) != 0) {
                    obj = null;
                }
                iListAdapter.notifyItemRangeChanged(i10, i11, obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyItemRangeChanged");
        }

        public static <T> void update(IListAdapter<T> iListAdapter, int i10, Object obj, Function1<? super T, Unit> function1) {
            TheRouterServiceProvideInjecter theRouterServiceProvideInjecter = (Object) CollectionsKt.getOrNull(iListAdapter.getDatas(), i10);
            if (theRouterServiceProvideInjecter != null) {
                if (function1 != null) {
                    function1.invoke(theRouterServiceProvideInjecter);
                }
                iListAdapter.notifyItemChanged(i10, obj);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void update$default(IListAdapter iListAdapter, int i10, Object obj, Function1 function1, int i11, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
            }
            if ((i11 & 2) != 0) {
                obj = null;
            }
            if ((i11 & 4) != 0) {
                function1 = null;
            }
            iListAdapter.update(i10, obj, function1);
        }

        public static <T> void updateFirst(IListAdapter<T> iListAdapter, Function2<? super Integer, ? super T, Boolean> predicate, Object obj, Function2<? super Integer, ? super T, Unit> function2) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            editUpdate(iListAdapter, predicate, obj, true, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateFirst$default(IListAdapter iListAdapter, Function2 function2, Object obj, Function2 function22, int i10, Object obj2) {
            if (obj2 == null) {
                if ((i10 & 2) != 0) {
                    obj = null;
                }
                if ((i10 & 4) != 0) {
                    function22 = null;
                }
                iListAdapter.updateFirst(function2, obj, function22);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateFirst");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void update$default(IListAdapter iListAdapter, Function2 function2, Object obj, Function2 function22, int i10, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
            }
            if ((i10 & 2) != 0) {
                obj = null;
            }
            if ((i10 & 4) != 0) {
                function22 = null;
            }
            iListAdapter.update(function2, obj, function22);
        }

        public static <T> void update(IListAdapter<T> iListAdapter, Function2<? super Integer, ? super T, Boolean> predicate, Object obj, Function2<? super Integer, ? super T, Unit> function2) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            editUpdate(iListAdapter, predicate, obj, false, function2);
        }
    }

    void addData(int position, T item);

    void addData(List<? extends T> list);

    List<T> getDatas();

    T getItem(int position);

    int getItemCount();

    int getItemViewType(int position);

    RecyclerView.Adapter<?> getRecyclerViewAdapter();

    void notifyDataSetChanged();

    void notifyItemChanged(int position, Object payload);

    void notifyItemInserted(int position);

    void notifyItemMoved(int fromPosition, int toPosition);

    void notifyItemRangeChanged(int positionStart, int itemCount, Object payload);

    void notifyItemRangeInserted(int positionStart, int itemCount);

    void notifyItemRangeRemoved(int positionStart, int itemCount);

    void notifyItemRemoved(int position);

    void remove(int position);

    void replaceData(List<? extends T> list);

    void setOnItemChildClickListener(Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Unit> listener);

    void setOnItemChildLongClickListener(Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Boolean> listener);

    void setOnItemClickListener(Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Unit> listener);

    void setOnItemLongClickListener(Function3<? super IListAdapter<? extends T>, ? super View, ? super Integer, Boolean> listener);

    void setPreLoadNumber(Integer preLoadNumber, Function0<Unit> listener);

    void update(int position, Object payload, Function1<? super T, Unit> call);

    void update(Function2<? super Integer, ? super T, Boolean> predicate, Object payload, Function2<? super Integer, ? super T, Unit> call);

    void updateFirst(Function2<? super Integer, ? super T, Boolean> predicate, Object payload, Function2<? super Integer, ? super T, Unit> call);
}
