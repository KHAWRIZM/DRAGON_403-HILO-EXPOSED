package com.qiahao.nextvideo.ui.hiloassistant;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.databinding.CellHiloAssistantEnterCarBinding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCarTypeViewHolder;", "Lcom/qiahao/nextvideo/ui/hiloassistant/BaseLogicViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/CellHiloAssistantEnterCarBinding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/CellHiloAssistantEnterCarBinding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/CellHiloAssistantEnterCarBinding;", VerificationCodeFragment.TYPE_BIND, "", "item", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "clickListener", "Lcom/qiahao/nextvideo/ui/hiloassistant/ClickListener;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloAssistantCarTypeViewHolder extends BaseLogicViewHolder {

    @NotNull
    private final CellHiloAssistantEnterCarBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HiloAssistantCarTypeViewHolder(@NotNull CellHiloAssistantEnterCarBinding cellHiloAssistantEnterCarBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(cellHiloAssistantEnterCarBinding, "binding");
        View root = cellHiloAssistantEnterCarBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = cellHiloAssistantEnterCarBinding;
    }

    public final void bind(@NotNull final HiloAssistantCellUIModel item, @Nullable final ClickListener clickListener) {
        Integer actionType;
        Integer actionType2;
        Integer actionType3;
        Integer actionType4;
        int i;
        String str;
        Intrinsics.checkNotNullParameter(item, "item");
        if (clickListener != null) {
            this.binding.messageContainer.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.hiloassistant.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloAssistantCarTypeViewHolder.this.onItemClick(item, clickListener);
                }
            });
        }
        Integer actionType5 = item.getActionType();
        if ((actionType5 == null || actionType5.intValue() != 1) && (((actionType = item.getActionType()) == null || actionType.intValue() != 4) && (((actionType2 = item.getActionType()) == null || actionType2.intValue() != 5) && (((actionType3 = item.getActionType()) == null || actionType3.intValue() != 6) && ((actionType4 = item.getActionType()) == null || actionType4.intValue() != 7))))) {
            this.binding.canJump.setVisibility(8);
        } else {
            this.binding.canJump.setVisibility(0);
        }
        CellHiloAssistantEnterCarBinding cellHiloAssistantEnterCarBinding = this.binding;
        LinearLayout linearLayout = cellHiloAssistantEnterCarBinding.messageContainer;
        Context context = cellHiloAssistantEnterCarBinding.getRoot().getContext();
        if (ViewUtilitiesKt.getRightToLeftDirection()) {
            i = 2131233179;
        } else {
            i = 2131233176;
        }
        linearLayout.setBackground(androidx.core.content.a.getDrawable(context, i));
        this.binding.carText.setText(item.getContent());
        this.binding.carText.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        if (item.getCreateTimeInDate() != null) {
            this.binding.timeTextView.setVisibility(0);
            this.binding.timeTextView.setText(item.getCreateTimeInDate());
        }
        ArrayList<String> contentIcons = item.getContentIcons();
        if (contentIcons != null && !contentIcons.isEmpty()) {
            ArrayList<String> contentIcons2 = item.getContentIcons();
            Intrinsics.checkNotNull(contentIcons2);
            str = contentIcons2.get(0);
        } else {
            str = "";
        }
        ImageView imageView = this.binding.carPic;
        Intrinsics.checkNotNullExpressionValue(imageView, "carPic");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(str, UiKtxKt.toPX(60)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232497, (c5.g) null, 49150, (Object) null);
    }

    @NotNull
    public final CellHiloAssistantEnterCarBinding getBinding() {
        return this.binding;
    }
}
