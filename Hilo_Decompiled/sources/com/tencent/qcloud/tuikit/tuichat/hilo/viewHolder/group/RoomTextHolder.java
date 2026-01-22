package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.im.TIMUserBean;
import com.qiahao.base_common.model.im.TIMUserExtBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.databinding.MessageAdapterContentTextBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomTextBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0011"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomTextHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/MessageAdapterContentTextBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "showDialog", "atMentionString", "colorMentionString", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomTextHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomTextHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomTextHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n1#2:180\n1869#3,2:181\n*S KotlinDebug\n*F\n+ 1 RoomTextHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomTextHolder\n*L\n102#1:181,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomTextHolder extends HiloRoomContentHolder<MessageAdapterContentTextBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTextHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    private final void atMentionString(TUIMessageBean msg) {
        TextView textView;
        List<TIMUserBean> mentionUsers;
        TextView textView2;
        String str = msg.getExtra().toString();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        MessageAdapterContentTextBinding binding = getBinding();
        if (binding != null && (textView2 = binding.msgBodyTv) != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TIMUserExtBean timUserExtBean = getTimUserExtBean();
        if (timUserExtBean != null && (mentionUsers = timUserExtBean.getMentionUsers()) != null) {
            for (final TIMUserBean tIMUserBean : mentionUsers) {
                String str2 = "@" + tIMUserBean.getNick();
                int i = 0;
                while (true) {
                    int indexOf$default = StringsKt.indexOf$default(str, str2, i, false, 4, (Object) null);
                    if (indexOf$default != -1) {
                        int length = str2.length() + indexOf$default;
                        i = str2.length() + indexOf$default;
                        if (Intrinsics.areEqual(tIMUserBean.getExternalId(), V2TIMManager.getInstance().getLoginUser())) {
                            spannableStringBuilder.setSpan(new SpannableTextBuilder.TextClickableSpan(new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.f
                                public final Object invoke(Object obj) {
                                    Unit atMentionString$lambda$7$lambda$6$lambda$4;
                                    atMentionString$lambda$7$lambda$6$lambda$4 = RoomTextHolder.atMentionString$lambda$7$lambda$6$lambda$4(RoomTextHolder.this, tIMUserBean, (String) obj);
                                    return atMentionString$lambda$7$lambda$6$lambda$4;
                                }
                            }, str2, Color.parseColor("#f96101"), false), indexOf$default, length, 33);
                        } else {
                            spannableStringBuilder.setSpan(new SpannableTextBuilder.TextClickableSpan(new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.g
                                public final Object invoke(Object obj) {
                                    Unit atMentionString$lambda$7$lambda$6$lambda$5;
                                    atMentionString$lambda$7$lambda$6$lambda$5 = RoomTextHolder.atMentionString$lambda$7$lambda$6$lambda$5(RoomTextHolder.this, tIMUserBean, (String) obj);
                                    return atMentionString$lambda$7$lambda$6$lambda$5;
                                }
                            }, str2, Color.parseColor("#ffe222"), false), indexOf$default, length, 33);
                        }
                    }
                }
            }
        }
        MessageAdapterContentTextBinding binding2 = getBinding();
        if (binding2 != null) {
            textView = binding2.msgBodyTv;
        } else {
            textView = null;
        }
        FaceManager.handlerEmojiText(textView, spannableStringBuilder, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit atMentionString$lambda$7$lambda$6$lambda$4(RoomTextHolder roomTextHolder, TIMUserBean tIMUserBean, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        OnItemClickListener onItemClickListener = roomTextHolder.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onType(5, tIMUserBean.getExternalId());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit atMentionString$lambda$7$lambda$6$lambda$5(RoomTextHolder roomTextHolder, TIMUserBean tIMUserBean, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        OnItemClickListener onItemClickListener = roomTextHolder.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onType(5, tIMUserBean.getExternalId());
        }
        return Unit.INSTANCE;
    }

    private final void colorMentionString(TUIMessageBean msg) {
        String str = msg.getExtra().toString();
        List<String> groupAtUserList = msg.getV2TIMMessage().getGroupAtUserList();
        Intrinsics.checkNotNullExpressionValue(groupAtUserList, "getGroupAtUserList(...)");
        if (TextUtils.isEmpty(str) && HiloUtils.INSTANCE.isEmpty(groupAtUserList)) {
            return;
        }
        V2TIMManager.getInstance().getUsersInfo(groupAtUserList, new RoomTextHolder$colorMentionString$1(str, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean layoutViews$lambda$1(RoomTextHolder roomTextHolder, TUIMessageBean tUIMessageBean, int i, View view) {
        roomTextHolder.showDialog(tUIMessageBean, i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean layoutViews$lambda$2(RoomTextHolder roomTextHolder, TUIMessageBean tUIMessageBean, int i, View view) {
        roomTextHolder.showDialog(tUIMessageBean, i);
        return true;
    }

    private final void showDialog(TUIMessageBean msg, int position) {
        TextView textView;
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            MessageAdapterContentTextBinding binding = getBinding();
            if (binding != null) {
                textView = binding.msgBodyTv;
            } else {
                textView = null;
            }
            onItemClickListener.onTypeClick(textView, position, msg, 3);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, final int position) {
        SvipData svipData;
        TextView textView;
        TextView textView2;
        List list;
        TextView textView3;
        View root;
        Context context;
        MessageAdapterContentTextBinding binding;
        TextView textView4;
        MessageAdapterContentTextBinding binding2;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomTextBean)) {
            return;
        }
        MessageAdapterContentTextBinding binding3 = getBinding();
        if (binding3 != null && (textView7 = binding3.msgBodyTv) != null) {
            textView7.setMaxWidth(UiKtxKt.toPX(RoomEvent.ROOM_CURRENT_USER_ONLINE));
        }
        TIMUserExtBean timUserExtBean = getTimUserExtBean();
        TextView textView8 = null;
        List list2 = null;
        TextView textView9 = null;
        TextView textView10 = null;
        if (timUserExtBean != null) {
            svipData = timUserExtBean.getSvip();
        } else {
            svipData = null;
        }
        if (svipData != null && svipData.isMystery()) {
            this.msgContentFrame.setBackgroundResource(R.drawable.ic_noble_chat_bg_v0);
        } else {
            setBubble();
        }
        MessageAdapterContentTextBinding binding4 = getBinding();
        int i = 0;
        if (binding4 != null && (textView6 = binding4.msgBodyTv) != null) {
            textView6.setVisibility(0);
        }
        if (this.properties.getChatContextFontSize() != 0 && (binding2 = getBinding()) != null && (textView5 = binding2.msgBodyTv) != null) {
            textView5.setTextSize(this.properties.getChatContextFontSize());
        }
        MessageAdapterContentTextBinding binding5 = getBinding();
        if (binding5 != null && (root = binding5.getRoot()) != null && (context = root.getContext()) != null && (binding = getBinding()) != null && (textView4 = binding.msgBodyTv) != null) {
            textView4.setTextColor(androidx.core.content.a.getColor(context, R.color.white));
        }
        RoomTextBean roomTextBean = (RoomTextBean) msg;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(roomTextBean.getExtra().toString());
        MessageAdapterContentTextBinding binding6 = getBinding();
        if (binding6 != null) {
            textView = binding6.msgBodyTv;
        } else {
            textView = null;
        }
        FaceManager.handlerEmojiText(textView, roomTextBean.getExtra().toString(), false);
        MessageAdapterContentTextBinding binding7 = getBinding();
        if (binding7 != null && (textView3 = binding7.msgBodyTv) != null) {
            textView3.setText(spannableStringBuilder);
        }
        if (getTimUserExtBean() != null) {
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            TIMUserExtBean timUserExtBean2 = getTimUserExtBean();
            if (timUserExtBean2 != null) {
                list = timUserExtBean2.getMentionUsers();
            } else {
                list = null;
            }
            if (hiloUtils.notEmpty(list)) {
                atMentionString(msg);
            } else {
                TIMUserExtBean timUserExtBean3 = getTimUserExtBean();
                if (timUserExtBean3 != null) {
                    list2 = timUserExtBean3.getMentionUsers();
                }
                if (hiloUtils.isEmpty(list2)) {
                    List<String> groupAtUserList = roomTextBean.getV2TIMMessage().getGroupAtUserList();
                    if (groupAtUserList != null) {
                        i = groupAtUserList.size();
                    }
                    if (i > 0) {
                        colorMentionString(msg);
                    }
                }
            }
        } else if (roomTextBean.getText() != null) {
            MessageAdapterContentTextBinding binding8 = getBinding();
            if (binding8 != null) {
                textView9 = binding8.msgBodyTv;
            }
            FaceManager.handlerEmojiText(textView9, roomTextBean.getText(), false);
        } else if (!TextUtils.isEmpty(roomTextBean.getExtra())) {
            MessageAdapterContentTextBinding binding9 = getBinding();
            if (binding9 != null) {
                textView10 = binding9.msgBodyTv;
            }
            FaceManager.handlerEmojiText(textView10, roomTextBean.getExtra(), false);
        } else {
            MessageAdapterContentTextBinding binding10 = getBinding();
            if (binding10 != null) {
                textView8 = binding10.msgBodyTv;
            }
            FaceManager.handlerEmojiText(textView8, ServiceInitializer.getAppContext().getString(R.string.this_message_type_is_not_supported), false);
        }
        FrameLayout frameLayout = this.msgContentFrame;
        if (frameLayout != null) {
            frameLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.h
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean layoutViews$lambda$1;
                    layoutViews$lambda$1 = RoomTextHolder.layoutViews$lambda$1(RoomTextHolder.this, msg, position, view);
                    return layoutViews$lambda$1;
                }
            });
        }
        MessageAdapterContentTextBinding binding11 = getBinding();
        if (binding11 != null && (textView2 = binding11.msgBodyTv) != null) {
            textView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.i
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean layoutViews$lambda$2;
                    layoutViews$lambda$2 = RoomTextHolder.layoutViews$lambda$2(RoomTextHolder.this, msg, position, view);
                    return layoutViews$lambda$2;
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public MessageAdapterContentTextBinding inflateViewBinding() {
        MessageAdapterContentTextBinding inflate = MessageAdapterContentTextBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
