package com.qiahao.base_common.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.databinding.DialogSelectPickerBinding;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.WheelItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00002\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u000fR&\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010!¨\u0006\""}, d2 = {"Lcom/qiahao/base_common/ui/dialog/BaseSelectDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/base_common/databinding/DialogSelectPickerBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "getLayoutResId", "()I", "", "isBottomStyle", "()Z", "", "onInitialize", "()V", "Ljava/util/ArrayList;", "Lbb/a;", "Lkotlin/collections/ArrayList;", "list", "setDataList", "(Ljava/util/ArrayList;)Lcom/qiahao/base_common/ui/dialog/BaseSelectDialog;", "", "", "setDataListOfString", "(Ljava/util/List;)Lcom/qiahao/base_common/ui/dialog/BaseSelectDialog;", "Lcom/qiahao/base_common/interfaceing/SelectInterface;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/qiahao/base_common/interfaceing/SelectInterface;)Lcom/qiahao/base_common/ui/dialog/BaseSelectDialog;", "show", "dataList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/interfaceing/SelectInterface;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseSelectDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseSelectDialog.kt\ncom/qiahao/base_common/ui/dialog/BaseSelectDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,76:1\n61#2,9:77\n61#2,9:86\n1869#3,2:95\n37#4:97\n36#4,3:98\n*S KotlinDebug\n*F\n+ 1 BaseSelectDialog.kt\ncom/qiahao/base_common/ui/dialog/BaseSelectDialog\n*L\n31#1:77,9\n35#1:86,9\n53#1:95,2\n72#1:97\n72#1:98,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BaseSelectDialog extends BaseBindingDialog<DialogSelectPickerBinding> {

    @NotNull
    private ArrayList<bb.a> dataList;

    @Nullable
    private SelectInterface listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSelectDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dataList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oudi.core.component.SuperDialog
    public int getLayoutResId() {
        return R.layout.dialog_select_picker;
    }

    @Override // com.qiahao.base_common.common.BaseDialog
    protected boolean isBottomStyle() {
        return true;
    }

    @Override // com.oudi.core.component.SuperDialog, com.oudi.core.component.IComponent
    public void onInitialize() {
        super.onInitialize();
        final TextView textView = getBinding().cancel;
        final long j10 = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.BaseSelectDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j10 || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final TextView textView2 = getBinding().confirm;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.base_common.ui.dialog.BaseSelectDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectInterface selectInterface;
                DialogSelectPickerBinding binding;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j10 || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    selectInterface = this.listener;
                    if (selectInterface != null) {
                        binding = this.getBinding();
                        selectInterface.onSelect(binding.selectView.getSelectedIndex());
                    }
                    this.dismiss();
                }
            }
        });
    }

    @NotNull
    public final BaseSelectDialog setDataList(@NotNull ArrayList<bb.a> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList = list;
        return this;
    }

    @NotNull
    public final BaseSelectDialog setDataListOfString(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.dataList.add(new WheelItem((String) it.next()));
        }
        return this;
    }

    @NotNull
    public final BaseSelectDialog setListener(@NotNull SelectInterface listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        return this;
    }

    @Override // com.oudi.core.component.SuperDialog, android.app.Dialog
    public void show() {
        super.show();
        if (!this.dataList.isEmpty()) {
            getBinding().selectView.setItems((bb.a[]) this.dataList.toArray(new bb.a[0]));
        }
    }
}
