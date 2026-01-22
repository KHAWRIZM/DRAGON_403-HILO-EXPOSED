package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.support.BaseControlUtils;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/viewholder/MessageBaseHolder;", "item", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "getVariableLayout", "", "inflateViewBinding", "getBindingLayout", "setUserAvatar", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "leftAvatar", "Lcom/tencent/qcloud/tuicore/component/gatherimage/UserIconView;", "rightAvatar", "msgContentLl", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageEmptyBaseHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageEmptyBaseHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,107:1\n61#2,9:108\n*S KotlinDebug\n*F\n+ 1 MessageEmptyBaseHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder\n*L\n94#1:108,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MessageEmptyBaseHolder<B extends ViewDataBinding> extends MessageBaseHolder {

    @Nullable
    private B binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageEmptyBaseHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "item");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUserAvatar$lambda$1(MessageEmptyBaseHolder messageEmptyBaseHolder, TUIMessageBean tUIMessageBean, View view) {
        if (!messageEmptyBaseHolder.checkStrange()) {
            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
            String sender = tUIMessageBean.getSender();
            Intrinsics.checkNotNullExpressionValue(sender, "getSender(...)");
            baseControlUtils.openPersonPage(sender);
        }
    }

    @Nullable
    public final B getBinding() {
        return this.binding;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    @Nullable
    public View getBindingLayout() {
        B inflateViewBinding = inflateViewBinding();
        this.binding = inflateViewBinding;
        if (inflateViewBinding != null) {
            return inflateViewBinding.getRoot();
        }
        return null;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return 0;
    }

    @NotNull
    public abstract B inflateViewBinding();

    public final void setBinding(@Nullable B b) {
        this.binding = b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
    
        if (r1 == null) goto L٣٣;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setUserAvatar(@NotNull final TUIMessageBean msg, @Nullable final UserIconView leftAvatar, @Nullable UserIconView rightAvatar, @Nullable View msgContentLl) {
        ViewGroup.LayoutParams layoutParams;
        String str;
        String str2;
        ViewGroup.LayoutParams layoutParams2;
        Intrinsics.checkNotNullParameter(msg, "msg");
        ViewGroup.LayoutParams layoutParams3 = null;
        if (msgContentLl != null) {
            layoutParams = msgContentLl.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        if (this.properties.getAvatarRadius() != 0) {
            if (leftAvatar != null) {
                leftAvatar.setRadius(this.properties.getAvatarRadius());
            }
            if (rightAvatar != null) {
                rightAvatar.setRadius(this.properties.getAvatarRadius());
            }
        }
        if (this.properties.getAvatarSize() != null && this.properties.getAvatarSize().length == 2) {
            if (leftAvatar != null) {
                layoutParams2 = leftAvatar.getLayoutParams();
            } else {
                layoutParams2 = null;
            }
            Intrinsics.checkNotNull(layoutParams2);
            layoutParams2.width = this.properties.getAvatarSize()[0];
            layoutParams2.height = this.properties.getAvatarSize()[1];
            leftAvatar.setLayoutParams(layoutParams2);
            if (rightAvatar != null) {
                layoutParams3 = rightAvatar.getLayoutParams();
            }
            Intrinsics.checkNotNull(layoutParams3);
            layoutParams3.width = this.properties.getAvatarSize()[0];
            layoutParams3.height = this.properties.getAvatarSize()[1];
            rightAvatar.setLayoutParams(layoutParams3);
        }
        List<Object> arrayList = new ArrayList<>();
        if (checkStrange()) {
            IMCheckDataListener iMCheckDataListener = this.onItemDateListener;
            if (iMCheckDataListener != null) {
                if (msg.isSelf()) {
                    str2 = "avatarMy";
                } else {
                    str2 = "avatarReceive";
                }
                str = iMCheckDataListener.checkString(str2);
            }
            str = "";
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        } else {
            Object faceUrl = msg.getFaceUrl();
            Intrinsics.checkNotNullExpressionValue(faceUrl, "getFaceUrl(...)");
            arrayList.add(faceUrl);
        }
        if (msg.isSelf()) {
            bVar.G = 1.0f;
            if (leftAvatar != null) {
                leftAvatar.setVisibility(4);
            }
            if (rightAvatar != null) {
                rightAvatar.setVisibility(0);
            }
            if (arrayList.size() > 0) {
                if (rightAvatar != null) {
                    rightAvatar.setIconUrls(arrayList);
                }
            } else if (rightAvatar != null) {
                rightAvatar.setImageResId(R.drawable.ic_user_place_avatar);
            }
        } else {
            bVar.G = 0.0f;
            if (leftAvatar != null) {
                leftAvatar.setVisibility(0);
            }
            if (rightAvatar != null) {
                rightAvatar.setVisibility(4);
            }
            if (arrayList.size() > 0) {
                if (leftAvatar != null) {
                    leftAvatar.setIconUrls(arrayList);
                }
            } else if (leftAvatar != null) {
                leftAvatar.setImageResId(R.drawable.ic_user_place_avatar);
            }
        }
        if (leftAvatar != null) {
            final long j = 800;
            leftAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder$setUserAvatar$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(leftAvatar) > j || (leftAvatar instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(leftAvatar, currentTimeMillis);
                        if (!this.checkStrange()) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            String sender = msg.getSender();
                            Intrinsics.checkNotNullExpressionValue(sender, "getSender(...)");
                            baseControlUtils.openPersonPage(sender);
                        }
                    }
                }
            });
        }
        if (rightAvatar != null) {
            rightAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessageEmptyBaseHolder.setUserAvatar$lambda$1(MessageEmptyBaseHolder.this, msg, view);
                }
            });
        }
    }
}
