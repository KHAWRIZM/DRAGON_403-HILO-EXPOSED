package com.qiahao.nextvideo.ui.home.chat.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.StrangeChange;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogStrangeEndBinding;
import com.qiahao.nextvideo.ui.home.chat.activity.StrangeMatchActivity;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/dialog/StrangeEndDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogStrangeEndBinding;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/base_common/model/im/StrangeChange;", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/im/StrangeChange;)V", "getData", "()Lcom/qiahao/base_common/model/im/StrangeChange;", "getLayoutResId", "", "isBottomStyle", "", "onInitialize", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrangeEndDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrangeEndDialog.kt\ncom/qiahao/nextvideo/ui/home/chat/dialog/StrangeEndDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,62:1\n61#2,9:63\n61#2,9:72\n*S KotlinDebug\n*F\n+ 1 StrangeEndDialog.kt\ncom/qiahao/nextvideo/ui/home/chat/dialog/StrangeEndDialog\n*L\n53#1:63,9\n57#1:72,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StrangeEndDialog extends BaseBindingDialog<DialogStrangeEndBinding> {

    @Nullable
    private final StrangeChange data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrangeEndDialog(@NotNull Context context, @Nullable StrangeChange strangeChange) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = strangeChange;
    }

    @Nullable
    public final StrangeChange getData() {
        return this.data;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_strange_end;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        String str;
        String str2;
        User mOtherUser;
        User mOtherUser2;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        StrangeChange strangeChange = this.data;
        if (strangeChange != null && strangeChange.getCloseType() == 1) {
            ((DialogStrangeEndBinding) getBinding()).title.setText(ResourcesKtxKt.getStringById(this, 2131954156));
        } else {
            ((DialogStrangeEndBinding) getBinding()).title.setText(ResourcesKtxKt.getStringById(this, 2131954155));
        }
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogStrangeEndBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        StrangeChange strangeChange2 = this.data;
        Integer num = null;
        if (strangeChange2 != null && (mOtherUser2 = strangeChange2.getMOtherUser()) != null) {
            str = mOtherUser2.getMaskAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = ((DialogStrangeEndBinding) getBinding()).name;
        StrangeChange strangeChange3 = this.data;
        if (strangeChange3 != null && (mOtherUser = strangeChange3.getMOtherUser()) != null) {
            str2 = mOtherUser.getMaskNick();
        } else {
            str2 = null;
        }
        textView.setText(str2);
        TextView textView2 = ((DialogStrangeEndBinding) getBinding()).content;
        String stringById = ResourcesKtxKt.getStringById(this, 2131954157);
        StrangeChange strangeChange4 = this.data;
        if (strangeChange4 != null) {
            num = Integer.valueOf(strangeChange4.getScoreProcess());
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{num + "%"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
        ConstraintLayout constraintLayout = ((DialogStrangeEndBinding) getBinding()).constraint;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        constraintLayout.setBackground(shapeUtil.createShape(context, 2131101214, 2131101214, 15, 15, 0, 0, orientation));
        ((DialogStrangeEndBinding) getBinding()).continueBtn.setBackground(shapeUtil.createShape("#9036FF", "#9036FF", 25, orientation));
        final TextView textView3 = ((DialogStrangeEndBinding) getBinding()).continueBtn;
        final long j = 800;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.StrangeEndDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    StrangeMatchActivity.Companion companion = StrangeMatchActivity.Companion;
                    Context context2 = this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    StrangeMatchActivity.Companion.startActivity$default(companion, context2, false, 2, null);
                    this.dismiss();
                }
            }
        });
        final ImageView imageView = ((DialogStrangeEndBinding) getBinding()).close;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.StrangeEndDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    public /* synthetic */ StrangeEndDialog(Context context, StrangeChange strangeChange, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : strangeChange);
    }
}
