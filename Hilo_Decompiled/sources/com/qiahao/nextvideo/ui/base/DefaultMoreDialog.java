package com.qiahao.nextvideo.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.DefaultMoreData;
import com.qiahao.nextvideo.databinding.DialogDefaultMoreBinding;
import com.qiahao.nextvideo.databinding.IncludeReportItemBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0017H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR7\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/ui/base/DefaultMoreDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogDefaultMoreBinding;", "mContext", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/DefaultMoreData;", "Lkotlin/collections/ArrayList;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getMContext", "()Landroid/content/Context;", "getList", "()Ljava/util/ArrayList;", "getLayoutResId", "", "mListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "isBottomStyle", "", "onInitialize", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultMoreDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultMoreDialog.kt\ncom/qiahao/nextvideo/ui/base/DefaultMoreDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,48:1\n1878#2,2:49\n1880#2:60\n61#3,9:51\n61#3,9:61\n*S KotlinDebug\n*F\n+ 1 DefaultMoreDialog.kt\ncom/qiahao/nextvideo/ui/base/DefaultMoreDialog\n*L\n31#1:49,2\n31#1:60\n37#1:51,9\n43#1:61,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DefaultMoreDialog extends BaseBindingDialog<DialogDefaultMoreBinding> {

    @Nullable
    private final ArrayList<DefaultMoreData> list;

    @NotNull
    private final Context mContext;

    @Nullable
    private Function1<? super String, Unit> mListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultMoreDialog(@NotNull Context context, @Nullable ArrayList<DefaultMoreData> arrayList) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.list = arrayList;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_default_more;
    }

    @Nullable
    public final ArrayList<DefaultMoreData> getList() {
        return this.list;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final Function1<String, Unit> getMListener() {
        return this.mListener;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ArrayList<DefaultMoreData> arrayList = this.list;
        if (arrayList != null) {
            int i = 0;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final DefaultMoreData defaultMoreData = (DefaultMoreData) obj;
                IncludeReportItemBinding inflate = IncludeReportItemBinding.inflate(LayoutInflater.from(getContext()), ((DialogDefaultMoreBinding) getBinding()).linearLayout, true);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                if (i != this.list.size() - 1) {
                    inflate.line.setVisibility(0);
                }
                inflate.button.setText(defaultMoreData.getTitle());
                final View root = inflate.getRoot();
                final long j = 800;
                root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.DefaultMoreDialog$onInitialize$lambda$1$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                            Function1<String, Unit> mListener = this.getMListener();
                            if (mListener != null) {
                                mListener.invoke(defaultMoreData.getType());
                            }
                            this.dismiss();
                        }
                    }
                });
                i = i2;
            }
        }
        final AppCompatButton appCompatButton = ((DialogDefaultMoreBinding) getBinding()).cancelButton;
        final long j2 = 800;
        appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.base.DefaultMoreDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatButton) > j2 || (appCompatButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatButton, currentTimeMillis);
                    AppCompatButton appCompatButton2 = appCompatButton;
                    this.dismiss();
                }
            }
        });
    }

    public final void setMListener(@Nullable Function1<? super String, Unit> function1) {
        this.mListener = function1;
    }

    public /* synthetic */ DefaultMoreDialog(Context context, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : arrayList);
    }
}
