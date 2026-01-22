package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.MedalBean;
import com.qiahao.base_common.model.UserRoleType;
import com.qiahao.base_common.model.im.TIMUserExtBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.component.gatherimage.SynthesizedImageView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.databinding.IncludeMessageTitleChatBinding;
import com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010J\u001a\u00020KH\u0016J\r\u0010L\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\n\u0010M\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010C2\u0006\u0010Q\u001a\u00020KH\u0016J\u0018\u0010R\u001a\u00020O2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010BH\u0016J\u0012\u0010T\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010BH\u0016J\b\u0010U\u001a\u00020OH\u0002J\u001e\u0010V\u001a\u00020O2\u0006\u0010W\u001a\u00020X2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020K0BH\u0002J\u0018\u0010Z\u001a\u00020O2\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\H\u0002J\u0006\u0010]\u001a\u00020OR\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u001a\u0010?\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R\u0016\u0010A\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006^"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "B", "Landroidx/databinding/ViewDataBinding;", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/viewholder/MessageBaseHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "getBinding", "()Landroidx/databinding/ViewDataBinding;", "setBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "titleBinding", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/IncludeMessageTitleChatBinding;", "getTitleBinding", "()Lcom/tencent/qcloud/tuikit/tuichat/databinding/IncludeMessageTitleChatBinding;", "setTitleBinding", "(Lcom/tencent/qcloud/tuikit/tuichat/databinding/IncludeMessageTitleChatBinding;)V", "titleLayout", "Landroid/widget/FrameLayout;", "getTitleLayout", "()Landroid/widget/FrameLayout;", "setTitleLayout", "(Landroid/widget/FrameLayout;)V", "leftUserIcon", "Lcom/tencent/qcloud/tuicore/component/gatherimage/UserIconView;", "getLeftUserIcon", "()Lcom/tencent/qcloud/tuicore/component/gatherimage/UserIconView;", "setLeftUserIcon", "(Lcom/tencent/qcloud/tuicore/component/gatherimage/UserIconView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "messageStatus", "Landroid/widget/ImageView;", "getMessageStatus", "()Landroid/widget/ImageView;", "setMessageStatus", "(Landroid/widget/ImageView;)V", "timUserExtBean", "Lcom/qiahao/base_common/model/im/TIMUserExtBean;", "getTimUserExtBean", "()Lcom/qiahao/base_common/model/im/TIMUserExtBean;", "setTimUserExtBean", "(Lcom/qiahao/base_common/model/im/TIMUserExtBean;)V", "baseService", "Lcom/qiahao/base_common/service/BaseService;", "getBaseService", "()Lcom/qiahao/base_common/service/BaseService;", "setBaseService", "(Lcom/qiahao/base_common/service/BaseService;)V", "isForwardMode", "", "()Z", "setForwardMode", "(Z)V", "isReplyDetailMode", "setReplyDetailMode", "isMultiSelectMode", "setMultiSelectMode", "mDataSource", "", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "presenter", "Lcom/tencent/qcloud/tuikit/tuichat/presenter/ChatPresenter;", "getPresenter", "()Lcom/tencent/qcloud/tuikit/tuichat/presenter/ChatPresenter;", "setPresenter", "(Lcom/tencent/qcloud/tuikit/tuichat/presenter/ChatPresenter;)V", "getVariableLayout", "", "inflateViewBinding", "getBindingLayout", "layoutViews", "", "msg", "position", "setDataSource", "dataSource", "getDataSource", "hideView", "createMedalsView", "llMedal", "Landroid/widget/LinearLayout;", "medals", "createImgView", "url", "", "setBubble", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloRoomContentHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloRoomContentHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,351:1\n61#2,9:352\n61#2,9:361\n61#2,9:370\n439#3:379\n439#3:380\n1#4:381\n*S KotlinDebug\n*F\n+ 1 HiloRoomContentHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder\n*L\n99#1:352,9\n106#1:361,9\n109#1:370,9\n182#1:379\n187#1:380\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomContentHolder<B extends ViewDataBinding> extends MessageBaseHolder {

    @Nullable
    private BaseService baseService;

    @Nullable
    private B binding;
    private boolean isForwardMode;
    private boolean isMultiSelectMode;
    private boolean isReplyDetailMode;

    @Nullable
    private UserIconView leftUserIcon;

    @Nullable
    private List<? extends TUIMessageBean> mDataSource;

    @Nullable
    private ImageView messageStatus;

    @Nullable
    private ChatPresenter presenter;

    @Nullable
    private ProgressBar progressBar;

    @Nullable
    private TIMUserExtBean timUserExtBean;

    @Nullable
    private IncludeMessageTitleChatBinding titleBinding;

    @Nullable
    private FrameLayout titleLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloRoomContentHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.baseService = AllModuleServiceManager.Companion.get().getAppService();
        this.mDataSource = new ArrayList();
        this.titleLayout = (FrameLayout) view.findViewById(R.id.titleLayout);
        this.leftUserIcon = (UserIconView) view.findViewById(R.id.left_user_icon_view);
        this.progressBar = (ProgressBar) view.findViewById(R.id.message_sending_pb);
        this.messageStatus = (ImageView) view.findViewById(R.id.message_status_iv);
        if (this.titleLayout != null) {
            this.titleBinding = (IncludeMessageTitleChatBinding) androidx.databinding.g.h(LayoutInflater.from(view.getContext()), R.layout.include_message_title_chat, this.titleLayout, true);
        }
    }

    private final void createImgView(LinearLayout llMedal, String url) {
        if (url.length() > 0) {
            ImageView imageView = new ImageView(llMedal.getContext());
            llMedal.addView(imageView);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = UiKtxKt.toPX(19);
            layoutParams2.height = UiKtxKt.toPX(17);
            layoutParams2.setMarginStart(UiKtxKt.toPX(4));
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(url, UiKtxKt.toPX(19), UiKtxKt.toPX(17)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
    }

    private final void createMedalsView(LinearLayout llMedal, List<Integer> medals) {
        List<MedalBean> list;
        try {
            BaseService baseService = this.baseService;
            if (baseService != null) {
                list = baseService.getMedalList();
            } else {
                list = null;
            }
            if (list != null && (!list.isEmpty())) {
                llMedal.setVisibility(0);
                int size = medals.size();
                int i = 0;
                for (int i2 = 0; i2 < size && i <= 7; i2++) {
                    MedalBean medalBean = null;
                    for (MedalBean medalBean2 : list) {
                        if (medalBean2.getMedalId() == medals.get(i2).intValue()) {
                            medalBean = medalBean2;
                        }
                    }
                    if (medalBean != null) {
                        i++;
                        createImgView(llMedal, medalBean.getPicUrl());
                    }
                }
                return;
            }
            llMedal.setVisibility(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void hideView() {
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding;
        View root;
        ImageView imageView;
        LinearLayout linearLayout;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        HiloGradeView hiloGradeView;
        HiloGradeView hiloGradeView2;
        ImageView imageView5;
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding = this.titleBinding;
        if (includeMessageTitleChatBinding != null && (imageView5 = includeMessageTitleChatBinding.userTag) != null) {
            imageView5.setVisibility(8);
        }
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding2 = this.titleBinding;
        if (includeMessageTitleChatBinding2 != null && (hiloGradeView2 = includeMessageTitleChatBinding2.wealthLevel) != null) {
            hiloGradeView2.setVisibility(8);
        }
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding3 = this.titleBinding;
        if (includeMessageTitleChatBinding3 != null && (hiloGradeView = includeMessageTitleChatBinding3.charmLevel) != null) {
            hiloGradeView.setVisibility(8);
        }
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding4 = this.titleBinding;
        if (includeMessageTitleChatBinding4 != null && (imageView4 = includeMessageTitleChatBinding4.imgBeautyAccount) != null) {
            imageView4.setVisibility(8);
        }
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding5 = this.titleBinding;
        if (includeMessageTitleChatBinding5 != null && (imageView3 = includeMessageTitleChatBinding5.iconNoble) != null) {
            imageView3.setVisibility(8);
        }
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding6 = this.titleBinding;
        if (includeMessageTitleChatBinding6 != null && (imageView2 = includeMessageTitleChatBinding6.iconVip) != null) {
            imageView2.setVisibility(8);
        }
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding7 = this.titleBinding;
        if (includeMessageTitleChatBinding7 != null && (linearLayout = includeMessageTitleChatBinding7.llMedal) != null) {
            linearLayout.setVisibility(8);
        }
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding8 = this.titleBinding;
        if (includeMessageTitleChatBinding8 != null && (imageView = includeMessageTitleChatBinding8.svip) != null) {
            imageView.setVisibility(8);
        }
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding9 = this.titleBinding;
        if (includeMessageTitleChatBinding9 != null && (includeFamilyNamePlateBinding = includeMessageTitleChatBinding9.familyNamePlate) != null && (root = includeFamilyNamePlateBinding.getRoot()) != null) {
            root.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean layoutViews$lambda$3(HiloRoomContentHolder hiloRoomContentHolder, int i, TUIMessageBean tUIMessageBean, View view) {
        OnItemClickListener onItemClickListener = hiloRoomContentHolder.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onUserIconLongClick(view, i, tUIMessageBean);
            return true;
        }
        return true;
    }

    @Nullable
    public final BaseService getBaseService() {
        return this.baseService;
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

    @Nullable
    public List<TUIMessageBean> getDataSource() {
        return this.mDataSource;
    }

    @Nullable
    public final UserIconView getLeftUserIcon() {
        return this.leftUserIcon;
    }

    @Nullable
    public final ImageView getMessageStatus() {
        return this.messageStatus;
    }

    @Nullable
    public final ChatPresenter getPresenter() {
        return this.presenter;
    }

    @Nullable
    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    @Nullable
    public final TIMUserExtBean getTimUserExtBean() {
        return this.timUserExtBean;
    }

    @Nullable
    public final IncludeMessageTitleChatBinding getTitleBinding() {
        return this.titleBinding;
    }

    @Nullable
    public final FrameLayout getTitleLayout() {
        return this.titleLayout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return 0;
    }

    @NotNull
    public abstract B inflateViewBinding();

    /* renamed from: isForwardMode, reason: from getter */
    public final boolean getIsForwardMode() {
        return this.isForwardMode;
    }

    /* renamed from: isMultiSelectMode, reason: from getter */
    public final boolean getIsMultiSelectMode() {
        return this.isMultiSelectMode;
    }

    /* renamed from: isReplyDetailMode, reason: from getter */
    public final boolean getIsReplyDetailMode() {
        return this.isReplyDetailMode;
    }

    /* JADX WARN: Removed duplicated region for block: B:226:0x03c8 A[Catch: Exception -> 0x0174, TryCatch #0 {Exception -> 0x0174, blocks: (B:61:0x015e, B:63:0x016f, B:65:0x017a, B:67:0x0180, B:68:0x018a, B:70:0x0190, B:72:0x0196, B:74:0x019a, B:77:0x01a0, B:79:0x01a6, B:81:0x01ac, B:82:0x01b6, B:84:0x01b9, B:86:0x01bd, B:88:0x01c1, B:89:0x01d0, B:91:0x01d8, B:93:0x01de, B:94:0x01e4, B:96:0x01ea, B:98:0x01f0, B:99:0x01f6, B:102:0x01fe, B:104:0x0202, B:106:0x0206, B:107:0x0233, B:109:0x0237, B:111:0x023b, B:112:0x024a, B:114:0x024e, B:116:0x0256, B:118:0x025a, B:120:0x025e, B:121:0x0261, B:123:0x0265, B:125:0x0269, B:126:0x027a, B:128:0x027e, B:130:0x0286, B:132:0x028a, B:134:0x028e, B:135:0x0291, B:137:0x0295, B:139:0x0299, B:140:0x02aa, B:142:0x02ae, B:145:0x02b8, B:147:0x02be, B:149:0x02c2, B:151:0x02c6, B:152:0x02c9, B:154:0x02cd, B:156:0x02d9, B:158:0x02dd, B:161:0x02e3, B:163:0x02e9, B:165:0x02ef, B:166:0x02f5, B:168:0x02f8, B:170:0x02fc, B:172:0x0300, B:174:0x0304, B:175:0x0312, B:177:0x0330, B:179:0x0334, B:181:0x033c, B:183:0x0342, B:185:0x0346, B:187:0x034a, B:188:0x0359, B:190:0x035d, B:192:0x0365, B:194:0x036b, B:196:0x036f, B:198:0x0373, B:199:0x0382, B:201:0x0386, B:203:0x038a, B:205:0x038e, B:207:0x0394, B:208:0x039c, B:210:0x03a0, B:214:0x03aa, B:217:0x03b0, B:219:0x03b4, B:221:0x03bc, B:226:0x03c8, B:228:0x03cc, B:230:0x03d0, B:231:0x03d3, B:233:0x03d7, B:235:0x03db, B:237:0x03e3, B:239:0x03e7, B:241:0x03eb, B:242:0x03ee, B:244:0x03f2, B:246:0x03f6, B:247:0x0405, B:249:0x0409, B:251:0x040f, B:253:0x0415, B:255:0x041c, B:257:0x0420, B:258:0x043e, B:260:0x0442, B:262:0x0448, B:263:0x044b, B:265:0x044f, B:267:0x0455, B:275:0x03fa, B:277:0x03fe, B:279:0x0402, B:282:0x0377, B:284:0x037b, B:286:0x037f, B:288:0x034e, B:290:0x0352, B:292:0x0356, B:295:0x0316, B:297:0x031a, B:299:0x031e, B:300:0x0321, B:302:0x0325, B:304:0x0329, B:308:0x023f, B:310:0x0243, B:312:0x0247, B:316:0x01c5, B:318:0x01c9, B:320:0x01cd), top: B:60:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0409 A[Catch: Exception -> 0x0174, TryCatch #0 {Exception -> 0x0174, blocks: (B:61:0x015e, B:63:0x016f, B:65:0x017a, B:67:0x0180, B:68:0x018a, B:70:0x0190, B:72:0x0196, B:74:0x019a, B:77:0x01a0, B:79:0x01a6, B:81:0x01ac, B:82:0x01b6, B:84:0x01b9, B:86:0x01bd, B:88:0x01c1, B:89:0x01d0, B:91:0x01d8, B:93:0x01de, B:94:0x01e4, B:96:0x01ea, B:98:0x01f0, B:99:0x01f6, B:102:0x01fe, B:104:0x0202, B:106:0x0206, B:107:0x0233, B:109:0x0237, B:111:0x023b, B:112:0x024a, B:114:0x024e, B:116:0x0256, B:118:0x025a, B:120:0x025e, B:121:0x0261, B:123:0x0265, B:125:0x0269, B:126:0x027a, B:128:0x027e, B:130:0x0286, B:132:0x028a, B:134:0x028e, B:135:0x0291, B:137:0x0295, B:139:0x0299, B:140:0x02aa, B:142:0x02ae, B:145:0x02b8, B:147:0x02be, B:149:0x02c2, B:151:0x02c6, B:152:0x02c9, B:154:0x02cd, B:156:0x02d9, B:158:0x02dd, B:161:0x02e3, B:163:0x02e9, B:165:0x02ef, B:166:0x02f5, B:168:0x02f8, B:170:0x02fc, B:172:0x0300, B:174:0x0304, B:175:0x0312, B:177:0x0330, B:179:0x0334, B:181:0x033c, B:183:0x0342, B:185:0x0346, B:187:0x034a, B:188:0x0359, B:190:0x035d, B:192:0x0365, B:194:0x036b, B:196:0x036f, B:198:0x0373, B:199:0x0382, B:201:0x0386, B:203:0x038a, B:205:0x038e, B:207:0x0394, B:208:0x039c, B:210:0x03a0, B:214:0x03aa, B:217:0x03b0, B:219:0x03b4, B:221:0x03bc, B:226:0x03c8, B:228:0x03cc, B:230:0x03d0, B:231:0x03d3, B:233:0x03d7, B:235:0x03db, B:237:0x03e3, B:239:0x03e7, B:241:0x03eb, B:242:0x03ee, B:244:0x03f2, B:246:0x03f6, B:247:0x0405, B:249:0x0409, B:251:0x040f, B:253:0x0415, B:255:0x041c, B:257:0x0420, B:258:0x043e, B:260:0x0442, B:262:0x0448, B:263:0x044b, B:265:0x044f, B:267:0x0455, B:275:0x03fa, B:277:0x03fe, B:279:0x0402, B:282:0x0377, B:284:0x037b, B:286:0x037f, B:288:0x034e, B:290:0x0352, B:292:0x0356, B:295:0x0316, B:297:0x031a, B:299:0x031e, B:300:0x0321, B:302:0x0325, B:304:0x0329, B:308:0x023f, B:310:0x0243, B:312:0x0247, B:316:0x01c5, B:318:0x01c9, B:320:0x01cd), top: B:60:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03fa A[Catch: Exception -> 0x0174, TryCatch #0 {Exception -> 0x0174, blocks: (B:61:0x015e, B:63:0x016f, B:65:0x017a, B:67:0x0180, B:68:0x018a, B:70:0x0190, B:72:0x0196, B:74:0x019a, B:77:0x01a0, B:79:0x01a6, B:81:0x01ac, B:82:0x01b6, B:84:0x01b9, B:86:0x01bd, B:88:0x01c1, B:89:0x01d0, B:91:0x01d8, B:93:0x01de, B:94:0x01e4, B:96:0x01ea, B:98:0x01f0, B:99:0x01f6, B:102:0x01fe, B:104:0x0202, B:106:0x0206, B:107:0x0233, B:109:0x0237, B:111:0x023b, B:112:0x024a, B:114:0x024e, B:116:0x0256, B:118:0x025a, B:120:0x025e, B:121:0x0261, B:123:0x0265, B:125:0x0269, B:126:0x027a, B:128:0x027e, B:130:0x0286, B:132:0x028a, B:134:0x028e, B:135:0x0291, B:137:0x0295, B:139:0x0299, B:140:0x02aa, B:142:0x02ae, B:145:0x02b8, B:147:0x02be, B:149:0x02c2, B:151:0x02c6, B:152:0x02c9, B:154:0x02cd, B:156:0x02d9, B:158:0x02dd, B:161:0x02e3, B:163:0x02e9, B:165:0x02ef, B:166:0x02f5, B:168:0x02f8, B:170:0x02fc, B:172:0x0300, B:174:0x0304, B:175:0x0312, B:177:0x0330, B:179:0x0334, B:181:0x033c, B:183:0x0342, B:185:0x0346, B:187:0x034a, B:188:0x0359, B:190:0x035d, B:192:0x0365, B:194:0x036b, B:196:0x036f, B:198:0x0373, B:199:0x0382, B:201:0x0386, B:203:0x038a, B:205:0x038e, B:207:0x0394, B:208:0x039c, B:210:0x03a0, B:214:0x03aa, B:217:0x03b0, B:219:0x03b4, B:221:0x03bc, B:226:0x03c8, B:228:0x03cc, B:230:0x03d0, B:231:0x03d3, B:233:0x03d7, B:235:0x03db, B:237:0x03e3, B:239:0x03e7, B:241:0x03eb, B:242:0x03ee, B:244:0x03f2, B:246:0x03f6, B:247:0x0405, B:249:0x0409, B:251:0x040f, B:253:0x0415, B:255:0x041c, B:257:0x0420, B:258:0x043e, B:260:0x0442, B:262:0x0448, B:263:0x044b, B:265:0x044f, B:267:0x0455, B:275:0x03fa, B:277:0x03fe, B:279:0x0402, B:282:0x0377, B:284:0x037b, B:286:0x037f, B:288:0x034e, B:290:0x0352, B:292:0x0356, B:295:0x0316, B:297:0x031a, B:299:0x031e, B:300:0x0321, B:302:0x0325, B:304:0x0329, B:308:0x023f, B:310:0x0243, B:312:0x0247, B:316:0x01c5, B:318:0x01c9, B:320:0x01cd), top: B:60:0x015e }] */
    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutViews(@Nullable final TUIMessageBean msg, final int position) {
        String str;
        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageView imageView;
        ImageView imageView2;
        TextView textView4;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        boolean z;
        LinearLayout linearLayout;
        SvipData svip;
        SynthesizedImageView avatar;
        SynthesizedImageView avatar2;
        TextView textView5;
        LinearLayout linearLayout2;
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding;
        String str2;
        String powerNameplate;
        Integer powerGrade;
        ImageView imageView6;
        ImageView imageView7;
        TextView textView6;
        IncludeMessageTitleChatBinding includeMessageTitleChatBinding2;
        ImageView imageView8;
        View root;
        Context context;
        ImageView imageView9;
        HiloGradeView hiloGradeView;
        HiloGradeView hiloGradeView2;
        HiloGradeView hiloGradeView3;
        HiloGradeView hiloGradeView4;
        ImageView imageView10;
        ImageView imageView11;
        V2TIMMessage v2TIMMessage;
        V2TIMMessage v2TIMMessage2;
        ImageView imageView12;
        ImageView imageView13;
        View root2;
        Context context2;
        V2TIMMessage v2TIMMessage3;
        TextView textView7;
        super.layoutViews(msg, position);
        this.msgContentFrame.setBackground(null);
        ArrayList arrayList = new ArrayList();
        if (msg == null || (str = msg.getFaceUrl()) == null) {
            str = "";
        }
        arrayList.add(str);
        UserIconView userIconView = this.leftUserIcon;
        if (userIconView != null) {
            userIconView.setIconUrls(arrayList);
        }
        if (TextUtils.isEmpty(msg != null ? msg.getNameCard() : null)) {
            if (TextUtils.isEmpty(msg != null ? msg.getFriendRemark() : null)) {
                if (!TextUtils.isEmpty(msg != null ? msg.getNickName() : null)) {
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding3 = this.titleBinding;
                    if (includeMessageTitleChatBinding3 != null && (textView2 = includeMessageTitleChatBinding3.userNameTv) != null) {
                        textView2.setText(msg != null ? msg.getNickName() : null);
                    }
                } else {
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding4 = this.titleBinding;
                    if (includeMessageTitleChatBinding4 != null && (textView = includeMessageTitleChatBinding4.userNameTv) != null) {
                        textView.setText(msg != null ? msg.getSender() : null);
                    }
                }
            } else {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding5 = this.titleBinding;
                if (includeMessageTitleChatBinding5 != null && (textView3 = includeMessageTitleChatBinding5.userNameTv) != null) {
                    textView3.setText(msg != null ? msg.getFriendRemark() : null);
                }
            }
        } else {
            IncludeMessageTitleChatBinding includeMessageTitleChatBinding6 = this.titleBinding;
            if (includeMessageTitleChatBinding6 != null && (textView7 = includeMessageTitleChatBinding6.userNameTv) != null) {
                textView7.setText(msg != null ? msg.getNameCard() : null);
            }
        }
        if (msg != null && msg.isSelf()) {
            if (msg.getStatus() != 3 && msg.getStatus() != 2 && !msg.isPeerRead()) {
                ProgressBar progressBar = this.progressBar;
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
            } else {
                ProgressBar progressBar2 = this.progressBar;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                }
            }
        } else {
            ProgressBar progressBar3 = this.progressBar;
            if (progressBar3 != null) {
                progressBar3.setVisibility(8);
            }
        }
        if (msg != null && msg.getStatus() == 3) {
            ImageView imageView14 = this.messageStatus;
            if (imageView14 != null) {
                imageView14.setVisibility(0);
            }
            final ImageView imageView15 = this.messageStatus;
            if (imageView15 != null) {
                final long j = 800;
                imageView15.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder$layoutViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OnItemClickListener onItemClickListener;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView15) > j || (imageView15 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(imageView15, currentTimeMillis);
                            ImageView imageView16 = (ImageView) imageView15;
                            onItemClickListener = ((MessageBaseHolder) this).onItemClickListener;
                            if (onItemClickListener != null) {
                                onItemClickListener.onSendFailBtnClick(imageView16, position, msg);
                            }
                        }
                    }
                });
            }
        } else {
            ImageView imageView16 = this.messageStatus;
            if (imageView16 != null) {
                imageView16.setOnClickListener(null);
            }
            ImageView imageView17 = this.messageStatus;
            if (imageView17 != null) {
                imageView17.setVisibility(8);
            }
        }
        final FrameLayout frameLayout = this.msgContentFrame;
        if (frameLayout != null) {
            final long j2 = 800;
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder$layoutViews$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnItemClickListener onItemClickListener;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j2 || (frameLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                        onItemClickListener = ((MessageBaseHolder) this).onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onMessageLongClick(this.msgContentFrame, position, msg);
                        }
                    }
                }
            });
        }
        final UserIconView userIconView2 = this.leftUserIcon;
        if (userIconView2 != null) {
            final long j3 = 800;
            userIconView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder$layoutViews$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnItemClickListener onItemClickListener;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(userIconView2) > j3 || (userIconView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(userIconView2, currentTimeMillis);
                        UserIconView userIconView3 = (UserIconView) userIconView2;
                        onItemClickListener = ((MessageBaseHolder) this).onItemClickListener;
                        if (onItemClickListener != null) {
                            onItemClickListener.onUserIconClick(userIconView3, position, msg);
                        }
                    }
                }
            });
        }
        UserIconView userIconView3 = this.leftUserIcon;
        if (userIconView3 != null) {
            userIconView3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.a
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean layoutViews$lambda$3;
                    layoutViews$lambda$3 = HiloRoomContentHolder.layoutViews$lambda$3(HiloRoomContentHolder.this, position, msg, view);
                    return layoutViews$lambda$3;
                }
            });
        }
        String cloudCustomData = (msg == null || (v2TIMMessage3 = msg.getV2TIMMessage()) == null) ? null : v2TIMMessage3.getCloudCustomData();
        if (TextUtils.isEmpty(cloudCustomData)) {
            hideView();
            return;
        }
        try {
            TIMUserExtBean tIMUserExtBean = (TIMUserExtBean) new com.google.gson.d().j(cloudCustomData, TIMUserExtBean.class);
            this.timUserExtBean = tIMUserExtBean;
            if ((tIMUserExtBean != null ? tIMUserExtBean.getSvipLevel() : 0) > 0) {
                SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                TIMUserExtBean tIMUserExtBean2 = this.timUserExtBean;
                Integer svipType = svipTypeUtils.getSvipType(tIMUserExtBean2 != null ? Integer.valueOf(tIMUserExtBean2.getSvipLevel()) : null);
                if (svipType != null && svipType.intValue() > 0) {
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding7 = this.titleBinding;
                    if (includeMessageTitleChatBinding7 != null && (imageView13 = includeMessageTitleChatBinding7.svip) != null) {
                        imageView13.setImageDrawable((includeMessageTitleChatBinding7 == null || (root2 = includeMessageTitleChatBinding7.getRoot()) == null || (context2 = root2.getContext()) == null) ? null : androidx.core.content.a.getDrawable(context2, svipType.intValue()));
                    }
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding8 = this.titleBinding;
                    if (includeMessageTitleChatBinding8 != null && (imageView12 = includeMessageTitleChatBinding8.svip) != null) {
                        imageView12.setVisibility(0);
                    }
                }
            } else {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding9 = this.titleBinding;
                if (includeMessageTitleChatBinding9 != null && (imageView = includeMessageTitleChatBinding9.svip) != null) {
                    imageView.setVisibility(8);
                }
            }
            UserRoleType.Companion companion = UserRoleType.Companion;
            int roomUserRole = companion.get().getRoomUserRole((msg == null || (v2TIMMessage2 = msg.getV2TIMMessage()) == null) ? null : v2TIMMessage2.getSender());
            if (!TextUtils.isEmpty((msg == null || (v2TIMMessage = msg.getV2TIMMessage()) == null) ? null : v2TIMMessage.getSender()) && roomUserRole > 1) {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding10 = this.titleBinding;
                if (includeMessageTitleChatBinding10 != null && (imageView11 = includeMessageTitleChatBinding10.userTag) != null) {
                    ImageKtxKt.loadImage$default(imageView11, (String) null, (Uri) null, (File) null, Integer.valueOf(companion.getLevelRes(roomUserRole)), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding11 = this.titleBinding;
                if (includeMessageTitleChatBinding11 != null && (imageView10 = includeMessageTitleChatBinding11.userTag) != null) {
                    imageView10.setVisibility(0);
                }
            } else {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding12 = this.titleBinding;
                if (includeMessageTitleChatBinding12 != null && (imageView2 = includeMessageTitleChatBinding12.userTag) != null) {
                    imageView2.setVisibility(8);
                }
            }
            TIMUserExtBean tIMUserExtBean3 = this.timUserExtBean;
            Long wealthGrade = tIMUserExtBean3 != null ? tIMUserExtBean3.getWealthGrade() : null;
            if (wealthGrade != null) {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding13 = this.titleBinding;
                if (includeMessageTitleChatBinding13 != null && (hiloGradeView4 = includeMessageTitleChatBinding13.wealthLevel) != null) {
                    hiloGradeView4.setVisibility(0);
                }
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding14 = this.titleBinding;
                if (includeMessageTitleChatBinding14 != null && (hiloGradeView3 = includeMessageTitleChatBinding14.wealthLevel) != null) {
                    HiloGradeView.setLevelBg$default(hiloGradeView3, wealthGrade.longValue(), false, true, false, 10, (Object) null);
                }
            }
            TIMUserExtBean tIMUserExtBean4 = this.timUserExtBean;
            Long charmGrade = tIMUserExtBean4 != null ? tIMUserExtBean4.getCharmGrade() : null;
            if (charmGrade != null) {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding15 = this.titleBinding;
                if (includeMessageTitleChatBinding15 != null && (hiloGradeView2 = includeMessageTitleChatBinding15.charmLevel) != null) {
                    hiloGradeView2.setVisibility(0);
                }
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding16 = this.titleBinding;
                if (includeMessageTitleChatBinding16 != null && (hiloGradeView = includeMessageTitleChatBinding16.charmLevel) != null) {
                    HiloGradeView.setLevelBg$default(hiloGradeView, charmGrade.longValue(), true, false, false, 12, (Object) null);
                }
            }
            TIMUserExtBean tIMUserExtBean5 = this.timUserExtBean;
            Integer nobleLevel = tIMUserExtBean5 != null ? tIMUserExtBean5.getNobleLevel() : null;
            if (nobleLevel != null && nobleLevel.intValue() > 0) {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding17 = this.titleBinding;
                if (includeMessageTitleChatBinding17 != null && (imageView9 = includeMessageTitleChatBinding17.iconNoble) != null) {
                    imageView9.setVisibility(0);
                }
                BaseService baseService = this.baseService;
                int nobleDrawableRes = baseService != null ? baseService.getNobleDrawableRes(nobleLevel.intValue()) : 0;
                if (nobleDrawableRes > 0 && (includeMessageTitleChatBinding2 = this.titleBinding) != null && (imageView8 = includeMessageTitleChatBinding2.iconNoble) != null) {
                    imageView8.setImageDrawable((includeMessageTitleChatBinding2 == null || (root = includeMessageTitleChatBinding2.getRoot()) == null || (context = root.getContext()) == null) ? null : androidx.core.content.a.getDrawable(context, nobleDrawableRes));
                }
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding18 = this.titleBinding;
                if (includeMessageTitleChatBinding18 != null && (textView6 = includeMessageTitleChatBinding18.userNameTv) != null) {
                    BaseService baseService2 = this.baseService;
                    textView6.setTextColor(baseService2 != null ? baseService2.getNobleColor(nobleLevel.intValue(), Color.parseColor("#ffffff")) : 0);
                }
            } else {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding19 = this.titleBinding;
                if (includeMessageTitleChatBinding19 != null && (imageView3 = includeMessageTitleChatBinding19.iconNoble) != null) {
                    imageView3.setVisibility(8);
                }
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding20 = this.titleBinding;
                if (includeMessageTitleChatBinding20 != null && (textView4 = includeMessageTitleChatBinding20.userNameTv) != null) {
                    textView4.setTextColor(Color.parseColor("#ffffff"));
                }
            }
            TIMUserExtBean tIMUserExtBean6 = this.timUserExtBean;
            Boolean isVip = tIMUserExtBean6 != null ? tIMUserExtBean6.isVip() : null;
            if (isVip != null && isVip.booleanValue()) {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding21 = this.titleBinding;
                if (includeMessageTitleChatBinding21 != null && (imageView7 = includeMessageTitleChatBinding21.iconVip) != null) {
                    imageView7.setVisibility(0);
                }
            } else {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding22 = this.titleBinding;
                if (includeMessageTitleChatBinding22 != null && (imageView4 = includeMessageTitleChatBinding22.iconVip) != null) {
                    imageView4.setVisibility(8);
                }
            }
            TIMUserExtBean tIMUserExtBean7 = this.timUserExtBean;
            Boolean isPretty = tIMUserExtBean7 != null ? tIMUserExtBean7.isPretty() : null;
            if (isPretty != null && isPretty.booleanValue()) {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding23 = this.titleBinding;
                if (includeMessageTitleChatBinding23 != null && (imageView6 = includeMessageTitleChatBinding23.imgBeautyAccount) != null) {
                    imageView6.setVisibility(0);
                }
            } else {
                IncludeMessageTitleChatBinding includeMessageTitleChatBinding24 = this.titleBinding;
                if (includeMessageTitleChatBinding24 != null && (imageView5 = includeMessageTitleChatBinding24.imgBeautyAccount) != null) {
                    imageView5.setVisibility(8);
                }
            }
            IncludeMessageTitleChatBinding includeMessageTitleChatBinding25 = this.titleBinding;
            if (includeMessageTitleChatBinding25 != null && (includeFamilyNamePlateBinding = includeMessageTitleChatBinding25.familyNamePlate) != null) {
                TIMUserExtBean tIMUserExtBean8 = this.timUserExtBean;
                int intValue = (tIMUserExtBean8 == null || (powerGrade = tIMUserExtBean8.getPowerGrade()) == null) ? -1 : powerGrade.intValue();
                TIMUserExtBean tIMUserExtBean9 = this.timUserExtBean;
                if (tIMUserExtBean9 != null && (powerNameplate = tIMUserExtBean9.getPowerNameplate()) != null) {
                    str2 = powerNameplate;
                    AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, intValue, str2, 0, 4, (Object) null);
                }
                str2 = "";
                AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, intValue, str2, 0, 4, (Object) null);
            }
            TIMUserExtBean tIMUserExtBean10 = this.timUserExtBean;
            List<Integer> medals = tIMUserExtBean10 != null ? tIMUserExtBean10.getMedals() : null;
            if (medals != null && !medals.isEmpty()) {
                z = false;
                if (z) {
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding26 = this.titleBinding;
                    if (includeMessageTitleChatBinding26 != null && (linearLayout5 = includeMessageTitleChatBinding26.llMedal) != null) {
                        linearLayout5.setVisibility(0);
                    }
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding27 = this.titleBinding;
                    if (((includeMessageTitleChatBinding27 == null || (linearLayout4 = includeMessageTitleChatBinding27.llMedal) == null) ? 0 : linearLayout4.getChildCount()) > 0 && (includeMessageTitleChatBinding = this.titleBinding) != null && (linearLayout3 = includeMessageTitleChatBinding.llMedal) != null) {
                        linearLayout3.removeAllViews();
                    }
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding28 = this.titleBinding;
                    if (includeMessageTitleChatBinding28 != null && (linearLayout2 = includeMessageTitleChatBinding28.llMedal) != null) {
                        createMedalsView(linearLayout2, medals);
                    }
                } else {
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding29 = this.titleBinding;
                    if (includeMessageTitleChatBinding29 != null && (linearLayout = includeMessageTitleChatBinding29.llMedal) != null) {
                        linearLayout.setVisibility(8);
                    }
                }
                TIMUserExtBean tIMUserExtBean11 = this.timUserExtBean;
                svip = tIMUserExtBean11 != null ? tIMUserExtBean11.getSvip() : null;
                if (svip == null && svip.isMystery()) {
                    hideView();
                    IncludeMessageTitleChatBinding includeMessageTitleChatBinding30 = this.titleBinding;
                    if (includeMessageTitleChatBinding30 != null && (textView5 = includeMessageTitleChatBinding30.userNameTv) != null) {
                        String format = String.format(ResourcesKtxKt.getStringById(this, R.string.mystery_name), Arrays.copyOf(new Object[]{svip.mysteryNumber()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        textView5.setText(format);
                    }
                    UserIconView userIconView4 = this.leftUserIcon;
                    if (userIconView4 != null && (avatar2 = userIconView4.getAvatar()) != null) {
                        avatar2.clear();
                    }
                    UserIconView userIconView5 = this.leftUserIcon;
                    if (userIconView5 == null || (avatar = userIconView5.getAvatar()) == null) {
                        return;
                    }
                    avatar.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.mystery_header));
                    return;
                }
            }
            z = true;
            if (z) {
            }
            TIMUserExtBean tIMUserExtBean112 = this.timUserExtBean;
            if (tIMUserExtBean112 != null) {
            }
            if (svip == null) {
            }
        } catch (Exception e) {
            hideView();
            e.printStackTrace();
        }
    }

    public final void setBaseService(@Nullable BaseService baseService) {
        this.baseService = baseService;
    }

    public final void setBinding(@Nullable B b) {
        this.binding = b;
    }

    public final void setBubble() {
        Integer num;
        TIMUserExtBean tIMUserExtBean = this.timUserExtBean;
        if (tIMUserExtBean != null) {
            num = tIMUserExtBean.getNobleLevel();
        } else {
            num = null;
        }
        int i = 0;
        if (num != null && num.intValue() > 0) {
            FrameLayout frameLayout = this.msgContentFrame;
            BaseService baseService = this.baseService;
            if (baseService != null) {
                i = baseService.getChatNobleBackGroupDrawable(num.intValue());
            }
            frameLayout.setBackgroundResource(i);
            return;
        }
        FrameLayout frameLayout2 = this.msgContentFrame;
        BaseService baseService2 = this.baseService;
        if (baseService2 != null) {
            i = baseService2.getChatNobleBackGroupDrawable(0);
        }
        frameLayout2.setBackgroundResource(i);
    }

    public void setDataSource(@Nullable List<? extends TUIMessageBean> dataSource) {
        if (dataSource == null || dataSource.isEmpty()) {
            this.mDataSource = null;
        }
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(dataSource);
        for (TUIMessageBean tUIMessageBean : dataSource) {
            int msgType = tUIMessageBean.getMsgType();
            if (msgType == 3 || msgType == 5) {
                arrayList.add(tUIMessageBean);
            }
        }
        this.mDataSource = arrayList;
    }

    public final void setForwardMode(boolean z) {
        this.isForwardMode = z;
    }

    public final void setLeftUserIcon(@Nullable UserIconView userIconView) {
        this.leftUserIcon = userIconView;
    }

    public final void setMessageStatus(@Nullable ImageView imageView) {
        this.messageStatus = imageView;
    }

    public final void setMultiSelectMode(boolean z) {
        this.isMultiSelectMode = z;
    }

    public final void setPresenter(@Nullable ChatPresenter chatPresenter) {
        this.presenter = chatPresenter;
    }

    public final void setProgressBar(@Nullable ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public final void setReplyDetailMode(boolean z) {
        this.isReplyDetailMode = z;
    }

    public final void setTimUserExtBean(@Nullable TIMUserExtBean tIMUserExtBean) {
        this.timUserExtBean = tIMUserExtBean;
    }

    public final void setTitleBinding(@Nullable IncludeMessageTitleChatBinding includeMessageTitleChatBinding) {
        this.titleBinding = includeMessageTitleChatBinding;
    }

    public final void setTitleLayout(@Nullable FrameLayout frameLayout) {
        this.titleLayout = frameLayout;
    }
}
