package com.qiahao.nextvideo.ui.home.chat;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.IMUserExtraBean;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GameMsg;
import com.qiahao.nextvideo.data.model.MsgForHiloOfficial;
import com.qiahao.nextvideo.data.model.SysMsg;
import com.qiahao.nextvideo.data.model.UserMsg;
import com.qiahao.nextvideo.databinding.CellConversationBinding;
import com.qiahao.nextvideo.ui.im.MessageListInfo;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J$\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/MessageListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/ui/im/MessageListInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/CellConversationBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "data", "getUserVip", "cellUIModel", "binding", "setupC2CSessionCell", "setupSystemSessionCell", "type", "", "system", "Lcom/qiahao/nextvideo/data/model/MsgForHiloOfficial;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageListAdapter.kt\ncom/qiahao/nextvideo/ui/home/chat/MessageListAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,258:1\n1#2:259\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MessageListAdapter extends BaseQuickAdapter<MessageListInfo, BaseDataBindingHolder<CellConversationBinding>> {

    @NotNull
    public static final String AVATAR = "USER-AVATAR";

    @NotNull
    public static final String TAG = "MessageListAdapter";

    @NotNull
    public static final String VIDEO_CALL = "VIDEO-CALL";

    public MessageListAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupC2CSessionCell(CellConversationBinding binding, MessageListInfo data) {
        int i;
        String lastMessageStr;
        View view = binding.onlineStatus;
        if (data.getUserStatus() == 1 && !data.getIsHide()) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        QMUIRadiusImageView qMUIRadiusImageView = binding.userAvatarCimageView;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "userAvatarCimageView");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, data.getIconUrlList().get(0).toString(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        binding.unreadMessageCountTextView.setAlpha(0.0f);
        AppCompatImageView appCompatImageView = binding.videoCallImageView;
        appCompatImageView.setVisibility(8);
        appCompatImageView.setTag(VIDEO_CALL);
        binding.nicknameTextView.setText(data.getTitle());
        if (data.getUnRead() == 0) {
            binding.unreadMessageCountTextView.setAlpha(0.0f);
        } else if (data.getUnRead() <= 99) {
            binding.unreadMessageCountTextView.setAlpha(1.0f);
            binding.unreadMessageCountTextView.setText(String.valueOf(data.getUnRead()));
        } else {
            binding.unreadMessageCountTextView.setAlpha(1.0f);
            binding.unreadMessageCountTextView.setText(ResourcesKtxKt.getStringById(this, 2131952516));
            binding.messageInDateTextView.setText(DateTimeUtilityKt.getGroupDateString(getContext(), data.getLastMessageTime()));
            AppCompatTextView appCompatTextView = binding.lastMessageTextView;
            lastMessageStr = data.getLastMessageStr();
            if (lastMessageStr == null) {
                lastMessageStr = "";
            }
            appCompatTextView.setText(lastMessageStr);
        }
        binding.messageInDateTextView.setText(DateTimeUtilityKt.getGroupDateString(getContext(), data.getLastMessageTime()));
        AppCompatTextView appCompatTextView2 = binding.lastMessageTextView;
        lastMessageStr = data.getLastMessageStr();
        if (lastMessageStr == null) {
        }
        appCompatTextView2.setText(lastMessageStr);
    }

    private final void setupSystemSessionCell(CellConversationBinding binding, String type, MsgForHiloOfficial system) {
        String content;
        String content2;
        if (system != null) {
            String str = null;
            String str2 = "";
            switch (type.hashCode()) {
                case -1979315295:
                    if (type.equals("Strange_list")) {
                        AppCompatTextView appCompatTextView = binding.lastMessageTextView;
                        String format = String.format(ResourcesKtxKt.getStringById(this, 2131954153), Arrays.copyOf(new Object[]{Integer.valueOf(Random.Default.nextInt(170000, 190000))}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        appCompatTextView.setText(format);
                        binding.userAvatarCimageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_hilo_strange));
                        return;
                    }
                    return;
                case -1675218269:
                    if (type.equals("Hilo_Assistant")) {
                        AppCompatTextView appCompatTextView2 = binding.lastMessageTextView;
                        UserMsg userMsg = system.getUserMsg();
                        if (userMsg != null) {
                            str = userMsg.replacedInContent();
                        }
                        appCompatTextView2.setText(str);
                        binding.userAvatarCimageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_hilo_assistant));
                        return;
                    }
                    return;
                case -1273866319:
                    if (type.equals("Hilo_Information")) {
                        AppCompatTextView appCompatTextView3 = binding.lastMessageTextView;
                        SysMsg sysMsg = system.getSysMsg();
                        if (sysMsg != null && (content = sysMsg.getContent()) != null) {
                            str2 = content;
                        }
                        appCompatTextView3.setText(str2);
                        binding.userAvatarCimageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_hilo_information));
                        return;
                    }
                    return;
                case -1136986362:
                    if (type.equals("Hilo_Notification")) {
                        binding.userAvatarCimageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_hilo_notification));
                        binding.lastMessageTextView.setText(ResourcesKtxKt.getStringById(this, 2131953669));
                        return;
                    }
                    return;
                case -933217857:
                    if (type.equals("Hilo_Family")) {
                        AppCompatTextView appCompatTextView4 = binding.lastMessageTextView;
                        String familyMsg = system.getFamilyMsg();
                        if (familyMsg != null) {
                            str2 = familyMsg;
                        }
                        appCompatTextView4.setText(str2);
                        binding.userAvatarCimageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), 2131232564));
                        return;
                    }
                    return;
                case -271174614:
                    if (type.equals("Hilo_match")) {
                        AppCompatTextView appCompatTextView5 = binding.lastMessageTextView;
                        GameMsg gameMsg = system.getGameMsg();
                        if (gameMsg != null && (content2 = gameMsg.getContent()) != null) {
                            str2 = content2;
                        }
                        appCompatTextView5.setText(str2);
                        QMUIRadiusImageView qMUIRadiusImageView = binding.userAvatarCimageView;
                        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "userAvatarCimageView");
                        GameMsg gameMsg2 = system.getGameMsg();
                        if (gameMsg2 != null) {
                            str = gameMsg2.getPicUrl();
                        }
                        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void setupSystemSessionCell$default(MessageListAdapter messageListAdapter, CellConversationBinding cellConversationBinding, String str, MsgForHiloOfficial msgForHiloOfficial, int i, Object obj) {
        if ((i & 4) != 0) {
            msgForHiloOfficial = null;
        }
        messageListAdapter.setupSystemSessionCell(cellConversationBinding, str, msgForHiloOfficial);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void getUserVip(@NotNull MessageListInfo cellUIModel, @NotNull final CellConversationBinding binding) {
        Intrinsics.checkNotNullParameter(cellUIModel, "cellUIModel");
        Intrinsics.checkNotNullParameter(binding, "binding");
        binding.iconVip.setVisibility(8);
        ArrayList arrayList = new ArrayList();
        String id2 = cellUIModel.getId();
        if (id2 != null) {
            arrayList.add(id2);
        }
        V2TIMManager.getInstance().getUsersInfo(arrayList, new V2TIMValueCallback<List<? extends V2TIMUserFullInfo>>() { // from class: com.qiahao.nextvideo.ui.home.chat.MessageListAdapter$getUserVip$2
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int code, String desc) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<? extends V2TIMUserFullInfo> v2TIMUserFullInfos) {
                byte[] bArr;
                if (v2TIMUserFullInfos == null || v2TIMUserFullInfos.isEmpty()) {
                    return;
                }
                int i = 0;
                HashMap<String, byte[]> customInfo = v2TIMUserFullInfos.get(0).getCustomInfo();
                Intrinsics.checkNotNullExpressionValue(customInfo, "getCustomInfo(...)");
                if (customInfo.size() <= 0 || (bArr = customInfo.get("Hilo")) == null) {
                    return;
                }
                if (bArr.length == 0) {
                    return;
                }
                try {
                    IMUserExtraBean iMUserExtraBean = (IMUserExtraBean) new com.google.gson.d().j(new String(bArr, Charsets.UTF_8), IMUserExtraBean.class);
                    ImageView imageView = CellConversationBinding.this.iconVip;
                    Boolean isVip = iMUserExtraBean.isVip();
                    Intrinsics.checkNotNull(isVip);
                    if (!isVip.booleanValue()) {
                        i = 8;
                    }
                    imageView.setVisibility(i);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception unused) {
                    Log.d(MessageListAdapter.TAG, "onSuccess: ");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<CellConversationBinding> holder, @NotNull MessageListInfo data) {
        GameMsg gameMsg;
        String title;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.CellConversationBinding");
        CellConversationBinding cellConversationBinding = (CellConversationBinding) dataBinding;
        cellConversationBinding.unreadMessageCountTextView.setAlpha(0.0f);
        String str = "";
        cellConversationBinding.lastMessageTextView.setText("");
        cellConversationBinding.messageInDateTextView.setText("");
        cellConversationBinding.videoCallImageView.setVisibility(8);
        AppCompatTextView appCompatTextView = cellConversationBinding.nicknameTextView;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "nicknameTextView");
        ViewUtilitiesKt.setDrawableRight(appCompatTextView, null);
        cellConversationBinding.line.setVisibility(8);
        getUserVip(data, cellConversationBinding);
        String messageType = data.getMessageType();
        switch (messageType.hashCode()) {
            case -1979315295:
                if (messageType.equals("Strange_list")) {
                    cellConversationBinding.nicknameTextView.setText(ResourcesKtxKt.getStringById(this, 2131954151));
                    if (data.getUnRead() > 0) {
                        cellConversationBinding.unreadMessageCountTextView.setAlpha(1.0f);
                        cellConversationBinding.unreadMessageCountTextView.setText(String.valueOf(data.getUnRead()));
                    }
                    cellConversationBinding.onlineStatus.setVisibility(8);
                    cellConversationBinding.iconVip.setVisibility(8);
                    cellConversationBinding.line.setVisibility(0);
                    setupSystemSessionCell(cellConversationBinding, data.getMessageType(), data.getSystemMessage());
                    return;
                }
                return;
            case -1675218269:
                if (messageType.equals("Hilo_Assistant")) {
                    cellConversationBinding.nicknameTextView.setText(ResourcesKtxKt.getStringById(this, 2131953057));
                    if (data.getUnRead() > 0) {
                        cellConversationBinding.unreadMessageCountTextView.setAlpha(1.0f);
                        cellConversationBinding.unreadMessageCountTextView.setText(String.valueOf(data.getUnRead()));
                    }
                    cellConversationBinding.onlineStatus.setVisibility(8);
                    cellConversationBinding.iconVip.setVisibility(8);
                    setupSystemSessionCell(cellConversationBinding, data.getMessageType(), data.getSystemMessage());
                    return;
                }
                return;
            case -1273866319:
                if (messageType.equals("Hilo_Information")) {
                    cellConversationBinding.nicknameTextView.setText(ResourcesKtxKt.getStringById(this, 2131953059));
                    if (data.getUnRead() > 0) {
                        cellConversationBinding.unreadMessageCountTextView.setAlpha(1.0f);
                        cellConversationBinding.unreadMessageCountTextView.setText(String.valueOf(data.getUnRead()));
                    }
                    cellConversationBinding.onlineStatus.setVisibility(8);
                    cellConversationBinding.iconVip.setVisibility(8);
                    setupSystemSessionCell(cellConversationBinding, data.getMessageType(), data.getSystemMessage());
                    return;
                }
                return;
            case -1136986362:
                if (messageType.equals("Hilo_Notification")) {
                    cellConversationBinding.nicknameTextView.setText(ResourcesKtxKt.getStringById(this, 2131953668));
                    if (data.getUnRead() > 0) {
                        cellConversationBinding.unreadMessageCountTextView.setAlpha(1.0f);
                        cellConversationBinding.unreadMessageCountTextView.setText(String.valueOf(data.getUnRead()));
                    }
                    cellConversationBinding.onlineStatus.setVisibility(8);
                    cellConversationBinding.iconVip.setVisibility(8);
                    setupSystemSessionCell(cellConversationBinding, data.getMessageType(), data.getSystemMessage());
                    return;
                }
                return;
            case -933217857:
                if (messageType.equals("Hilo_Family")) {
                    cellConversationBinding.nicknameTextView.setText(ResourcesKtxKt.getStringById(this, 2131952679));
                    if (data.getUnRead() > 0) {
                        cellConversationBinding.unreadMessageCountTextView.setAlpha(1.0f);
                        cellConversationBinding.unreadMessageCountTextView.setText(String.valueOf(data.getUnRead()));
                    }
                    cellConversationBinding.onlineStatus.setVisibility(8);
                    cellConversationBinding.iconVip.setVisibility(8);
                    setupSystemSessionCell(cellConversationBinding, data.getMessageType(), data.getSystemMessage());
                    return;
                }
                return;
            case -271174614:
                if (messageType.equals("Hilo_match")) {
                    AppCompatTextView appCompatTextView2 = cellConversationBinding.nicknameTextView;
                    MsgForHiloOfficial systemMessage = data.getSystemMessage();
                    if (systemMessage != null && (gameMsg = systemMessage.getGameMsg()) != null && (title = gameMsg.getTitle()) != null) {
                        str = title;
                    }
                    appCompatTextView2.setText(str);
                    if (data.getUnRead() > 0) {
                        cellConversationBinding.unreadMessageCountTextView.setAlpha(1.0f);
                        cellConversationBinding.unreadMessageCountTextView.setText(String.valueOf(data.getUnRead()));
                    }
                    cellConversationBinding.onlineStatus.setVisibility(8);
                    cellConversationBinding.iconVip.setVisibility(8);
                    setupSystemSessionCell(cellConversationBinding, data.getMessageType(), data.getSystemMessage());
                    return;
                }
                return;
            case 248287468:
                if (messageType.equals("HILO_Message")) {
                    setupC2CSessionCell(cellConversationBinding, data);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
