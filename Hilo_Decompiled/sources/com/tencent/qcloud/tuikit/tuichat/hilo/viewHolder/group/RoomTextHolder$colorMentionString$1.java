package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.oudi.utils.SpannableTextBuilder;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.databinding.MessageAdapterContentTextBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\f"}, d2 = {"com/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomTextHolder$colorMentionString$1", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "", "Lcom/tencent/imsdk/v2/V2TIMUserFullInfo;", "onError", "", "i", "", "s", "", "onSuccess", "v2TIMUserFullInfos", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomTextHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomTextHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomTextHolder$colorMentionString$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,179:1\n1#2:180\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomTextHolder$colorMentionString$1 implements V2TIMValueCallback<List<? extends V2TIMUserFullInfo>> {
    final /* synthetic */ String $contnet;
    final /* synthetic */ RoomTextHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomTextHolder$colorMentionString$1(String str, RoomTextHolder roomTextHolder) {
        this.$contnet = str;
        this.this$0 = roomTextHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$1(RoomTextHolder roomTextHolder, List list, int i, String str) {
        OnItemClickListener onItemClickListener;
        Intrinsics.checkNotNullParameter(str, "it");
        onItemClickListener = ((MessageBaseHolder) roomTextHolder).onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onType(5, ((V2TIMUserFullInfo) list.get(i)).getUserID());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSuccess$lambda$2(RoomTextHolder roomTextHolder, List list, int i, String str) {
        OnItemClickListener onItemClickListener;
        Intrinsics.checkNotNullParameter(str, "it");
        onItemClickListener = ((MessageBaseHolder) roomTextHolder).onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onType(5, ((V2TIMUserFullInfo) list.get(i)).getUserID());
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
    public void onError(int i, String s) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
    public void onSuccess(final List<? extends V2TIMUserFullInfo> v2TIMUserFullInfos) {
        TextView textView;
        Intrinsics.checkNotNullParameter(v2TIMUserFullInfos, "v2TIMUserFullInfos");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.$contnet);
        MessageAdapterContentTextBinding binding = this.this$0.getBinding();
        if (binding != null && (textView = binding.msgBodyTv) != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        int size = v2TIMUserFullInfos.size();
        for (final int i = 0; i < size; i++) {
            String str = "@" + v2TIMUserFullInfos.get(i).getNickName();
            int i2 = 0;
            while (true) {
                int indexOf$default = StringsKt.indexOf$default(this.$contnet, str, i2, false, 4, (Object) null);
                if (indexOf$default != -1) {
                    int length = str.length() + indexOf$default;
                    i2 = indexOf$default + str.length();
                    if (Intrinsics.areEqual(v2TIMUserFullInfos.get(i).getUserID(), V2TIMManager.getInstance().getLoginUser())) {
                        final RoomTextHolder roomTextHolder = this.this$0;
                        spannableStringBuilder.setSpan(new SpannableTextBuilder.TextClickableSpan(new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.j
                            public final Object invoke(Object obj) {
                                Unit onSuccess$lambda$1;
                                onSuccess$lambda$1 = RoomTextHolder$colorMentionString$1.onSuccess$lambda$1(RoomTextHolder.this, v2TIMUserFullInfos, i, (String) obj);
                                return onSuccess$lambda$1;
                            }
                        }, str, Color.parseColor("#f96101"), false), indexOf$default, length, 33);
                    } else {
                        final RoomTextHolder roomTextHolder2 = this.this$0;
                        spannableStringBuilder.setSpan(new SpannableTextBuilder.TextClickableSpan(new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.k
                            public final Object invoke(Object obj) {
                                Unit onSuccess$lambda$2;
                                onSuccess$lambda$2 = RoomTextHolder$colorMentionString$1.onSuccess$lambda$2(RoomTextHolder.this, v2TIMUserFullInfos, i, (String) obj);
                                return onSuccess$lambda$2;
                            }
                        }, str, Color.parseColor("#ffe222"), false), indexOf$default, length, 33);
                    }
                }
            }
        }
        MessageAdapterContentTextBinding binding2 = this.this$0.getBinding();
        FaceManager.handlerEmojiText(binding2 != null ? binding2.msgBodyTv : null, spannableStringBuilder, false);
    }
}
