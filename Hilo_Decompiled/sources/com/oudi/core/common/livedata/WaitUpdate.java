package com.oudi.core.common.livedata;

import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\u0000\"\u0004\b\u0000\u0010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u0001H\fH\u0016¢\u0006\u0002\u0010\u000fJ\u0016\u0010\b\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0006\u0010\u0011\u001a\u00020\nR&\u0010\u0004\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/oudi/core/common/livedata/WaitUpdate;", "Lcom/oudi/core/common/livedata/WaitUpdateBuilder;", "<init>", "()V", "list", "Ljava/util/ArrayList;", "Lcom/oudi/core/common/livedata/WaitLiveData;", "Lkotlin/collections/ArrayList;", "completeListener", "Lkotlin/Function0;", "", "wait", "T", "liveData", "value", "(Lcom/oudi/core/common/livedata/WaitLiveData;Ljava/lang/Object;)Lcom/oudi/core/common/livedata/WaitUpdate;", ChatMenuDialog.CLICK_BLOCK, "update", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWaitUpdate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WaitUpdate.kt\ncom/oudi/core/common/livedata/WaitUpdate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,32:1\n1863#2,2:33\n1863#2,2:35\n*S KotlinDebug\n*F\n+ 1 WaitUpdate.kt\ncom/oudi/core/common/livedata/WaitUpdate\n*L\n26#1:33,2\n29#1:35,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class WaitUpdate implements WaitUpdateBuilder {

    @NotNull
    private final ArrayList<WaitLiveData<?>> list = new ArrayList<>();

    @NotNull
    private final ArrayList<Function0<Unit>> completeListener = new ArrayList<>();

    @Override // com.oudi.core.common.livedata.WaitUpdateBuilder
    public void completeListener(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.completeListener.add(block);
    }

    public final void update() {
        Iterator<T> it = this.list.iterator();
        while (it.hasNext()) {
            WaitLiveData waitLiveData = (WaitLiveData) it.next();
            waitLiveData.setValue((Void) waitLiveData.getValue());
        }
        Iterator<T> it2 = this.completeListener.iterator();
        while (it2.hasNext()) {
            ((Function0) it2.next()).invoke();
        }
        this.completeListener.clear();
    }

    @Override // com.oudi.core.common.livedata.WaitUpdateBuilder
    public /* bridge */ /* synthetic */ WaitUpdateBuilder wait(WaitLiveData waitLiveData, Object obj) {
        return wait((WaitLiveData<WaitLiveData>) waitLiveData, (WaitLiveData) obj);
    }

    @Override // com.oudi.core.common.livedata.WaitUpdateBuilder
    @NotNull
    public <T> WaitUpdate wait(@Nullable WaitLiveData<T> liveData, @Nullable T value) {
        if (liveData == null) {
            return this;
        }
        liveData.onlySetValue(value);
        this.list.add(liveData);
        return this;
    }
}
