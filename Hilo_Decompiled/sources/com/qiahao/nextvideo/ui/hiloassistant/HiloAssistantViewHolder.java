package com.qiahao.nextvideo.ui.hiloassistant;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.CellHiloAssistantBinding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantViewHolder;", "Lcom/qiahao/nextvideo/ui/hiloassistant/BaseLogicViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/CellHiloAssistantBinding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/CellHiloAssistantBinding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/CellHiloAssistantBinding;", VerificationCodeFragment.TYPE_BIND, "", "item", "Lcom/qiahao/nextvideo/ui/hiloassistant/HiloAssistantCellUIModel;", "clickListener", "Lcom/qiahao/nextvideo/ui/hiloassistant/ClickListener;", "changeImageSize", "image", "Landroid/widget/ImageView;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloAssistantViewHolder extends BaseLogicViewHolder {

    @NotNull
    private final CellHiloAssistantBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HiloAssistantViewHolder(@NotNull CellHiloAssistantBinding cellHiloAssistantBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(cellHiloAssistantBinding, "binding");
        View root = cellHiloAssistantBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = cellHiloAssistantBinding;
    }

    public static /* synthetic */ void bind$default(HiloAssistantViewHolder hiloAssistantViewHolder, HiloAssistantCellUIModel hiloAssistantCellUIModel, ClickListener clickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            clickListener = null;
        }
        hiloAssistantViewHolder.bind(hiloAssistantCellUIModel, clickListener);
    }

    private final void changeImageSize(final ImageView image, final HiloAssistantCellUIModel item) {
        image.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.hiloassistant.j
            @Override // java.lang.Runnable
            public final void run() {
                HiloAssistantViewHolder.changeImageSize$lambda$4(HiloAssistantCellUIModel.this, image);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeImageSize$lambda$4(HiloAssistantCellUIModel hiloAssistantCellUIModel, ImageView imageView) {
        int i;
        int i2;
        int i3;
        Integer picWidth = hiloAssistantCellUIModel.getPicWidth();
        int i4 = 0;
        if (picWidth != null) {
            i = picWidth.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            Integer picHeight = hiloAssistantCellUIModel.getPicHeight();
            if (picHeight != null) {
                i2 = picHeight.intValue();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int width = imageView.getWidth();
                Integer picHeight2 = hiloAssistantCellUIModel.getPicHeight();
                if (picHeight2 != null) {
                    i4 = picHeight2.intValue();
                }
                int i5 = width * i4;
                Integer picWidth2 = hiloAssistantCellUIModel.getPicWidth();
                if (picWidth2 != null) {
                    i3 = picWidth2.intValue();
                } else {
                    i3 = 1;
                }
                layoutParams.height = i5 / i3;
                imageView.setLayoutParams(layoutParams);
            }
        }
    }

    public final void bind(@NotNull final HiloAssistantCellUIModel item, @Nullable final ClickListener clickListener) {
        Integer actionType;
        Integer actionType2;
        Integer actionType3;
        Integer actionType4;
        int i;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(item, "item");
        if (clickListener != null) {
            this.binding.messageContainer.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.hiloassistant.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloAssistantViewHolder.this.onItemClick(item, clickListener);
                }
            });
        }
        if (TextUtils.isEmpty(item.getPicUrl())) {
            ArrayList<String> contentIcons = item.getContentIcons();
            if (contentIcons != null && !contentIcons.isEmpty()) {
                ArrayList<String> contentIcons2 = item.getContentIcons();
                if (contentIcons2 != null) {
                    str = contentIcons2.get(0);
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    this.binding.imageView.setVisibility(0);
                    ImageView imageView = this.binding.imageView;
                    Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
                    changeImageSize(imageView, item);
                    ArrayList<String> contentIcons3 = item.getContentIcons();
                    if (contentIcons3 != null && (str2 = contentIcons3.get(0)) != null) {
                        ImageView imageView2 = this.binding.imageView;
                        Intrinsics.checkNotNullExpressionValue(imageView2, "imageView");
                        ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.imageSize(str2, UiKtxKt.toPX(300)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, UiKtxKt.toPX(10), false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40830, (Object) null);
                    }
                    ViewGroup.LayoutParams layoutParams = this.binding.messageContainer.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                    this.binding.messageContainer.setLayoutParams(layoutParams);
                } else {
                    this.binding.imageView.setVisibility(8);
                }
            } else {
                this.binding.imageView.setVisibility(8);
                ViewGroup.LayoutParams layoutParams2 = this.binding.messageContainer.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                this.binding.messageContainer.setLayoutParams(layoutParams2);
            }
        } else {
            this.binding.imageView.setVisibility(0);
            ImageView imageView3 = this.binding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView3, "imageView");
            changeImageSize(imageView3, item);
            ImageView imageView4 = this.binding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView4, "imageView");
            ImageKtxKt.loadImage$default(imageView4, ImageSizeKt.imageSize(item.getPicUrl(), UiKtxKt.toPX(300)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, UiKtxKt.toPX(10), false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40830, (Object) null);
            ViewGroup.LayoutParams layoutParams3 = this.binding.messageContainer.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = -2;
            this.binding.messageContainer.setLayoutParams(layoutParams3);
        }
        Integer actionType5 = item.getActionType();
        if ((actionType5 == null || actionType5.intValue() != 1) && (((actionType = item.getActionType()) == null || actionType.intValue() != 4) && (((actionType2 = item.getActionType()) == null || actionType2.intValue() != 5) && (((actionType3 = item.getActionType()) == null || actionType3.intValue() != 6) && ((actionType4 = item.getActionType()) == null || actionType4.intValue() != 7))))) {
            this.binding.canJump.setVisibility(8);
        } else {
            this.binding.canJump.setVisibility(0);
        }
        CellHiloAssistantBinding cellHiloAssistantBinding = this.binding;
        LinearLayout linearLayout = cellHiloAssistantBinding.messageContainer;
        Context context = cellHiloAssistantBinding.getRoot().getContext();
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
    public final CellHiloAssistantBinding getBinding() {
        return this.binding;
    }
}
