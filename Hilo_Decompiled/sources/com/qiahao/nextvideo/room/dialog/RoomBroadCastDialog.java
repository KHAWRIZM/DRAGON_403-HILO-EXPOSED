package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatImageView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupBroadCastBean;
import com.qiahao.nextvideo.databinding.DialogRoomBroadCastBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomBroadCastDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "mCurrentContext", "Landroid/content/Context;", "groupBroadCastBean", "Lcom/qiahao/nextvideo/data/model/GroupBroadCastBean;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/model/GroupBroadCastBean;)V", "getMCurrentContext", "()Landroid/content/Context;", "setMCurrentContext", "(Landroid/content/Context;)V", "binding", "Lcom/qiahao/nextvideo/databinding/DialogRoomBroadCastBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogRoomBroadCastBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogRoomBroadCastBinding;)V", "mGroupBroadCastBean", "getMGroupBroadCastBean", "()Lcom/qiahao/nextvideo/data/model/GroupBroadCastBean;", "setMGroupBroadCastBean", "(Lcom/qiahao/nextvideo/data/model/GroupBroadCastBean;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "onClick", "v", "Landroid/view/View;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomBroadCastDialog extends AppCompatDialog implements View.OnClickListener {
    public DialogRoomBroadCastBinding binding;

    @NotNull
    private Context mCurrentContext;

    @Nullable
    private GroupBroadCastBean mGroupBroadCastBean;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomBroadCastDialog(@NotNull Context context, @Nullable GroupBroadCastBean groupBroadCastBean) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        this.mCurrentContext = context;
        this.mGroupBroadCastBean = groupBroadCastBean;
    }

    private final void initView() {
        int i;
        int i2;
        String str;
        if (this.mGroupBroadCastBean == null) {
            return;
        }
        CircleImageView circleImageView = getBinding().userAvatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        GroupBroadCastBean groupBroadCastBean = this.mGroupBroadCastBean;
        Intrinsics.checkNotNull(groupBroadCastBean);
        String senderAvatar = groupBroadCastBean.getSenderAvatar();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(56));
        fill.setHeight(dimens.dpToPx(56));
        Unit unit = Unit.INSTANCE;
        Integer num = null;
        ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(senderAvatar, fill), null, 2, null);
        TextView textView = getBinding().broadCastText;
        GroupBroadCastBean groupBroadCastBean2 = this.mGroupBroadCastBean;
        Intrinsics.checkNotNull(groupBroadCastBean2);
        textView.setText(groupBroadCastBean2.getText());
        CircleImageView circleImageView2 = getBinding().sex;
        GroupBroadCastBean groupBroadCastBean3 = this.mGroupBroadCastBean;
        Intrinsics.checkNotNull(groupBroadCastBean3);
        if (groupBroadCastBean3.getSenderSex() == 1) {
            i = R.drawable.bg_age_male;
        } else {
            i = R.drawable.bg_age_female;
        }
        circleImageView2.setBackgroundResource(i);
        AppCompatImageView appCompatImageView = getBinding().sex;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "sex");
        GroupBroadCastBean groupBroadCastBean4 = this.mGroupBroadCastBean;
        Intrinsics.checkNotNull(groupBroadCastBean4);
        if (groupBroadCastBean4.getSenderSex() == 1) {
            i2 = R.drawable.icon_boy;
        } else {
            i2 = R.drawable.icon_girl;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(i2), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        TextView textView2 = getBinding().groupName;
        GroupBroadCastBean groupBroadCastBean5 = this.mGroupBroadCastBean;
        Intrinsics.checkNotNull(groupBroadCastBean5);
        textView2.setText(groupBroadCastBean5.getGroupName());
        TextView textView3 = getBinding().groupId;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        GroupBroadCastBean groupBroadCastBean6 = this.mGroupBroadCastBean;
        if (groupBroadCastBean6 == null || (str = groupBroadCastBean6.getGroupCode()) == null) {
            str = "";
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView3.setText(format);
        RoundedImageView roundedImageView = getBinding().imageGroup;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "imageGroup");
        GroupBroadCastBean groupBroadCastBean7 = this.mGroupBroadCastBean;
        Intrinsics.checkNotNull(groupBroadCastBean7);
        String groupAvatar = groupBroadCastBean7.getGroupAvatar();
        fill.setWidth(dimens.dpToPx(66));
        fill.setHeight(dimens.dpToPx(66));
        ViewUtilitiesKt.bind(roundedImageView, companion.displayImage(groupAvatar, fill));
        TextView textView4 = getBinding().onlineNumber;
        GroupBroadCastBean groupBroadCastBean8 = this.mGroupBroadCastBean;
        if (groupBroadCastBean8 != null) {
            num = Integer.valueOf(groupBroadCastBean8.getUserInNum());
        }
        textView4.setText(String.valueOf(num));
    }

    @NotNull
    public final DialogRoomBroadCastBinding getBinding() {
        DialogRoomBroadCastBinding dialogRoomBroadCastBinding = this.binding;
        if (dialogRoomBroadCastBinding != null) {
            return dialogRoomBroadCastBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    @Nullable
    public final GroupBroadCastBean getMGroupBroadCastBean() {
        return this.mGroupBroadCastBean;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362369) {
            if (id2 != 2131362783) {
                if (id2 == 2131365536 && FastClickOneUtils.INSTANCE.isFastClick()) {
                    AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                    GroupBroadCastBean groupBroadCastBean = this.mGroupBroadCastBean;
                    if (groupBroadCastBean != null) {
                        str2 = groupBroadCastBean.getSenderExtId();
                    } else {
                        str2 = null;
                    }
                    AppRequestUtils.openPersonPage$default(appRequestUtils, str2, false, 2, null);
                    return;
                }
                return;
            }
            if (FastClickOneUtils.INSTANCE.isFastClick()) {
                dismiss();
                StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                GroupBroadCastBean groupBroadCastBean2 = this.mGroupBroadCastBean;
                if (groupBroadCastBean2 == null || (str = groupBroadCastBean2.getGroupId()) == null) {
                    str = "";
                }
                StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                return;
            }
            return;
        }
        dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        WindowManager.LayoutParams attributes;
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setBinding((DialogRoomBroadCastBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.dialog_room_broad_cast, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.gravity = 17;
            Dimens dimens = Dimens.INSTANCE;
            attributes.width = dimens.getScreenWidth() - dimens.dpToPx(110);
            attributes.height = -2;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.0f);
        }
        initView();
    }

    public final void setBinding(@NotNull DialogRoomBroadCastBinding dialogRoomBroadCastBinding) {
        Intrinsics.checkNotNullParameter(dialogRoomBroadCastBinding, "<set-?>");
        this.binding = dialogRoomBroadCastBinding;
    }

    public final void setMCurrentContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mCurrentContext = context;
    }

    public final void setMGroupBroadCastBean(@Nullable GroupBroadCastBean groupBroadCastBean) {
        this.mGroupBroadCastBean = groupBroadCastBean;
    }
}
