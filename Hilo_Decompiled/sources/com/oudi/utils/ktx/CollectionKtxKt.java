package com.oudi.utils.ktx;

import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0010)\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0003j\b\u0012\u0004\u0012\u0002H\u0002`\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001a4\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0003j\b\u0012\u0004\u0012\u0002H\u0002`\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001a:\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0003j\b\u0012\u0004\u0012\u0002H\u0002`\u00042\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n\u001a*\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001a*\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001a0\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n\u001a*\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001a*\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001aN\u0010\u000e\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00020\u0003j\b\u0012\u0004\u0012\u0002H\u0002`\u00040\u0003j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00020\u0003j\b\u0012\u0004\u0012\u0002H\u0002`\u0004`\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b\u001a*\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\u0006\u001a*\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\u0006¨\u0006\u0015"}, d2 = {"removeIf2", "", "T", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "filter", "Lkotlin/Function1;", "removeFirst2", "predicate", "removeIfIndexed2", "Lkotlin/Function2;", "", "", "", "split", "", "pageSize", "forEachRemaining2", "", "", NativeProtocol.WEB_DIALOG_ACTION, "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CollectionKtxKt {
    public static final <T> void forEachRemaining2(Iterator<? extends T> it, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    public static final <T> boolean removeFirst2(ArrayList<T> arrayList, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ListIterator<T> listIterator = arrayList.listIterator();
        Intrinsics.checkNotNullExpressionValue(listIterator, "listIterator(...)");
        return removeFirst2(listIterator, predicate);
    }

    public static final <T> boolean removeIf2(ArrayList<T> arrayList, Function1<? super T, Boolean> filter) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(filter, "filter");
        ListIterator<T> listIterator = arrayList.listIterator();
        Intrinsics.checkNotNullExpressionValue(listIterator, "listIterator(...)");
        return removeIf2(listIterator, filter);
    }

    public static final <T> boolean removeIfIndexed2(ArrayList<T> arrayList, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i10 = 0;
        boolean z10 = false;
        while (i10 < arrayList.size()) {
            if (predicate.invoke(Integer.valueOf(i10), arrayList.get(i10)).booleanValue()) {
                arrayList.remove(i10);
                i10--;
                z10 = true;
            }
            i10++;
        }
        return z10;
    }

    public static final <T> ArrayList<ArrayList<T>> split(List<? extends T> list, int i10) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList<ArrayList<T>> arrayList = new ArrayList<>();
        ArrayList<T> arrayList2 = new ArrayList<>();
        int i11 = 0;
        for (T t10 : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList2.add(t10);
            if (arrayList2.size() == i10 || i11 == list.size() - 1) {
                arrayList.add(arrayList2);
                arrayList2 = new ArrayList<>();
            }
            i11 = i12;
        }
        return arrayList;
    }

    public static final <T> boolean removeFirst2(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return removeFirst2(list.listIterator(), predicate);
    }

    public static final <T> boolean removeIf2(List<T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return removeIf2(list.listIterator(), predicate);
    }

    public static final <T> void forEachRemaining2(List<? extends T> list, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        forEachRemaining2(list.iterator(), action);
    }

    public static final <T> boolean removeFirst2(Iterator<? extends T> it, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public static final <T> boolean removeIf2(Iterator<? extends T> it, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean z10 = false;
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static final <T> boolean removeIfIndexed2(List<T> list, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i10 = 0;
        boolean z10 = false;
        while (i10 < list.size()) {
            if (predicate.invoke(Integer.valueOf(i10), list.get(i10)).booleanValue()) {
                list.remove(i10);
                i10--;
                z10 = true;
            }
            i10++;
        }
        return z10;
    }
}
