package com.qiahao.nextvideo.ui.videocall.videoIM;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.protobuf.h0;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.video.VideoIMEntity;
import com.qiahao.nextvideo.databinding.ItemVideoImGiftBinding;
import com.qiahao.nextvideo.databinding.ItemVideoImTextBinding;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import userProxy.UserProxy;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\rB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/videoIM/VideoIMAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/qiahao/nextvideo/data/video/VideoIMEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemVideoImGiftBinding;", "data", "", "<init>", "(Ljava/util/List;)V", "convert", "", "holder", "item", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoIMAdapter extends BaseMultiItemQuickAdapter<VideoIMEntity, BaseDataBindingHolder<ItemVideoImGiftBinding>> {
    public static final int VIDEO_IM_GIFT = 174;
    public static final int VIDEO_IM_INTERACTION = 175;
    public static final int VIDEO_IM_TEXT = 173;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoIMAdapter(@NotNull List<VideoIMEntity> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "data");
        addItemType(174, R.layout.item_video_im_gift);
        addItemType(175, R.layout.item_video_im_gift);
        addItemType(173, R.layout.item_video_im_text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemVideoImGiftBinding> holder, @NotNull VideoIMEntity item) {
        h0 h0Var;
        String nick;
        String maxLengthSuffix;
        String nick2;
        String maxLengthSuffix2;
        String nick3;
        String maxLengthSuffix3;
        String nick4;
        String maxLengthSuffix4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.getItemType()) {
            case 173:
                ViewDataBinding dataBinding = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemVideoImTextBinding");
                ItemVideoImTextBinding itemVideoImTextBinding = (ItemVideoImTextBinding) dataBinding;
                itemVideoImTextBinding.getRoot().setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#66000000", "#66000000", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
                Object data = item.getData();
                h0Var = data instanceof UserProxy.TextInfo ? (UserProxy.TextInfo) data : null;
                if (h0Var != null) {
                    TextView textView = itemVideoImTextBinding.title;
                    String plainText = h0Var.getPlainText();
                    textView.setText(plainText != null ? plainText : "");
                    return;
                }
                return;
            case 174:
                ViewDataBinding dataBinding2 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemVideoImGiftBinding");
                ItemVideoImGiftBinding itemVideoImGiftBinding = (ItemVideoImGiftBinding) dataBinding2;
                itemVideoImGiftBinding.getRoot().setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#66000000", "#66000000", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
                Object data2 = item.getData();
                h0Var = data2 instanceof UserProxy.GiftInfo ? (UserProxy.GiftInfo) data2 : null;
                if (h0Var != null) {
                    SpannableTextBuilder spannableTextBuilder = new SpannableTextBuilder(itemVideoImGiftBinding.title);
                    User user = item.getUser();
                    SpannableTextBuilder appendText$default = SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(spannableTextBuilder, (user == null || (nick2 = user.getNick()) == null || (maxLengthSuffix2 = DataExternalKt.maxLengthSuffix(nick2, 8, "...")) == null) ? "" : maxLengthSuffix2, Integer.valueOf(Color.parseColor("#7fffffff")), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), ": ", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), ResourcesKtxKt.getStringById(this, 2131954058), Integer.valueOf(Color.parseColor("#FFE222")), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), " ", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null);
                    User toUser = item.getToUser();
                    SpannableTextBuilder.appendText$default(appendText$default, (toUser == null || (nick = toUser.getNick()) == null || (maxLengthSuffix = DataExternalKt.maxLengthSuffix(nick, 8, "...")) == null) ? "" : maxLengthSuffix, Integer.valueOf(Color.parseColor("#ffffff")), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null).apply();
                    itemVideoImGiftBinding.number.setVisibility(0);
                    itemVideoImGiftBinding.number.setText("X" + h0Var.getNum());
                    ImageView imageView = itemVideoImGiftBinding.giftIcon;
                    Intrinsics.checkNotNullExpressionValue(imageView, "giftIcon");
                    ImageKtxKt.loadImage$default(imageView, h0Var.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
                    return;
                }
                return;
            case 175:
                ViewDataBinding dataBinding3 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding3, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemVideoImGiftBinding");
                ItemVideoImGiftBinding itemVideoImGiftBinding2 = (ItemVideoImGiftBinding) dataBinding3;
                itemVideoImGiftBinding2.getRoot().setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#66000000", "#66000000", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
                Object data3 = item.getData();
                h0Var = data3 instanceof UserProxy.InterInfo ? (UserProxy.InterInfo) data3 : null;
                if (h0Var != null) {
                    SpannableTextBuilder spannableTextBuilder2 = new SpannableTextBuilder(itemVideoImGiftBinding2.title);
                    User user2 = item.getUser();
                    SpannableTextBuilder appendText$default2 = SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(spannableTextBuilder2, (user2 == null || (nick4 = user2.getNick()) == null || (maxLengthSuffix4 = DataExternalKt.maxLengthSuffix(nick4, 8, "...")) == null) ? "" : maxLengthSuffix4, Integer.valueOf(Color.parseColor("#7fffffff")), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), ": ", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), ResourcesKtxKt.getStringById(this, 2131954072), Integer.valueOf(Color.parseColor("#FFE222")), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null), " ", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null);
                    User toUser2 = item.getToUser();
                    SpannableTextBuilder.appendText$default(appendText$default2, (toUser2 == null || (nick3 = toUser2.getNick()) == null || (maxLengthSuffix3 = DataExternalKt.maxLengthSuffix(nick3, 8, "...")) == null) ? "" : maxLengthSuffix3, Integer.valueOf(Color.parseColor("#ffffff")), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null).apply();
                    itemVideoImGiftBinding2.number.setVisibility(0);
                    ImageView imageView2 = itemVideoImGiftBinding2.giftIcon;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "giftIcon");
                    ImageKtxKt.loadImage$default(imageView2, h0Var.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
