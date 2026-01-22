package com.qiahao.nextvideo.ui.hiloassistant;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.CellHiloAssistantHolderType1Binding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantDiamondTypeViewHolder;", "Lcom/qiahao/nextvideo/ui/hiloassistant/BaseLogicViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/CellHiloAssistantHolderType1Binding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/CellHiloAssistantHolderType1Binding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/CellHiloAssistantHolderType1Binding;", VerificationCodeFragment.TYPE_BIND, "", "item", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "clickListener", "Lcom/qiahao/nextvideo/ui/hiloassistant/ClickListener;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloAssistantDiamondTypeViewHolder extends BaseLogicViewHolder {

    @NotNull
    private final CellHiloAssistantHolderType1Binding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HiloAssistantDiamondTypeViewHolder(@NotNull CellHiloAssistantHolderType1Binding cellHiloAssistantHolderType1Binding) {
        super(r0);
        Intrinsics.checkNotNullParameter(cellHiloAssistantHolderType1Binding, "binding");
        View root = cellHiloAssistantHolderType1Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = cellHiloAssistantHolderType1Binding;
    }

    public final void bind(@NotNull final HiloAssistantCellUIModel item, @Nullable final ClickListener clickListener) {
        int i;
        Intrinsics.checkNotNullParameter(item, "item");
        if (clickListener != null) {
            this.binding.messageContainer.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.hiloassistant.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloAssistantDiamondTypeViewHolder.this.onItemClick(item, clickListener);
                }
            });
        }
        CellHiloAssistantHolderType1Binding cellHiloAssistantHolderType1Binding = this.binding;
        LinearLayout linearLayout = cellHiloAssistantHolderType1Binding.messageContainer;
        Context context = cellHiloAssistantHolderType1Binding.getRoot().getContext();
        if (ViewUtilitiesKt.getRightToLeftDirection()) {
            i = 2131233179;
        } else {
            i = 2131233176;
        }
        linearLayout.setBackground(androidx.core.content.a.getDrawable(context, i));
        this.binding.subtitleTextView.setText(item.getContent());
        this.binding.subtitleTextView.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        if (item.getCreateTimeInDate() != null) {
            this.binding.timeTextView.setVisibility(0);
            this.binding.timeTextView.setText(item.getCreateTimeInDate());
        }
        if (item.getUser() == null) {
            AppCompatImageView appCompatImageView = this.binding.userAvatarCircleImageView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatarCircleImageView");
            ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_hilo_assistant), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            User user = item.getUser();
            if (user != null) {
                AppCompatImageView appCompatImageView2 = this.binding.userAvatarCircleImageView;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "userAvatarCircleImageView");
                ImageKtxKt.loadImage$default(appCompatImageView2, ImageSizeKt.image100(user.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
            }
        }
    }

    @NotNull
    public final CellHiloAssistantHolderType1Binding getBinding() {
        return this.binding;
    }
}
