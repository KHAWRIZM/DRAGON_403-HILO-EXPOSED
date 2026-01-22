package l3;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.MedalBean;
import com.qiahao.base_common.model.UserRoleType;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.hilo_message.R;
import com.qiahao.hilo_message.adapter.RoomMessageAdapter;
import com.qiahao.hilo_message.data.CloudCustomData;
import com.qiahao.hilo_message.data.GMSvipDetail;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.ImageInfo;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.data.TextElemContent;
import com.qiahao.hilo_message.data.TextElemContentAt;
import com.qiahao.hilo_message.data.VideoElemContent;
import com.qiahao.hilo_message.databinding.IncludeMessageTitleBinding;
import com.qiahao.hilo_message.databinding.RoomCustomActivityBinding;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class z {
    public static final Unit a(RoomMessageItemListener roomMessageItemListener, TextElemContentAt textElemContentAt, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (roomMessageItemListener != null) {
            roomMessageItemListener.onType(5, textElemContentAt.getAtAccount());
        }
        return Unit.INSTANCE;
    }

    public static final void b(RoomMessageAdapter roomMessageAdapter, int i10, ProgressBar progress, ImageView errorImage) {
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(errorImage, "errorImage");
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    progress.setVisibility(8);
                    errorImage.setVisibility(0);
                    return;
                }
                return;
            }
            progress.setVisibility(8);
            errorImage.setVisibility(8);
            return;
        }
        progress.setVisibility(0);
        errorImage.setVisibility(8);
    }

    public static final void c(RoomMessageAdapter roomMessageAdapter, int i10, ConstraintLayout msgContentFrame, boolean z10) {
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(msgContentFrame, "msgContentFrame");
        int i11 = 0;
        if (i10 > 0 && !z10) {
            BaseService mAppService = AllModuleServiceManager.INSTANCE.get().getMAppService();
            if (mAppService != null) {
                i11 = mAppService.getChatNobleBackGroupDrawable(i10);
            }
            msgContentFrame.setBackgroundResource(i11);
            return;
        }
        BaseService mAppService2 = AllModuleServiceManager.INSTANCE.get().getMAppService();
        if (mAppService2 != null) {
            i11 = mAppService2.getChatNobleBackGroupDrawable(0);
        }
        msgContentFrame.setBackgroundResource(i11);
    }

    public static final void d(RoomMessageAdapter roomMessageAdapter, LinearLayout rollerLinearLayout, int i10) {
        int i11;
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(rollerLinearLayout, "rollerLinearLayout");
        ImageView imageView = new ImageView(rollerLinearLayout.getContext());
        rollerLinearLayout.addView(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.width = dimens.dpToPx(14);
        layoutParams2.height = dimens.dpToPx(16);
        layoutParams2.setMarginStart(dimens.dpToPx(8));
        imageView.setLayoutParams(layoutParams2);
        Context context = imageView.getContext();
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        switch (i10) {
            case 0:
                i11 = R.drawable.icon_dice0;
                break;
            case 1:
                i11 = R.drawable.icon_dice1;
                break;
            case 2:
                i11 = R.drawable.icon_dice2;
                break;
            case 3:
                i11 = R.drawable.icon_dice3;
                break;
            case 4:
                i11 = R.drawable.icon_dice4;
                break;
            case 5:
                i11 = R.drawable.icon_dice5;
                break;
            case 6:
                i11 = R.drawable.icon_dice6;
                break;
            case 7:
                i11 = R.drawable.icon_dice7;
                break;
            case 8:
                i11 = R.drawable.icon_dice8;
                break;
            case 9:
                i11 = R.drawable.icon_dice9;
                break;
            default:
                i11 = R.drawable.icon_dice0;
                break;
        }
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, i11));
    }

    public static final void e(RoomMessageAdapter roomMessageAdapter, LinearLayout llMedal, String url) {
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(llMedal, "llMedal");
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() > 0) {
            ImageView imageView = new ImageView(llMedal.getContext());
            llMedal.addView(imageView);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = UiKtxKt.toPX(19);
            layoutParams2.height = UiKtxKt.toPX(19);
            layoutParams2.setMarginStart(UiKtxKt.toPX(4));
            layoutParams2.gravity = 16;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(url, UiKtxKt.toPX(19)), null, null, null, null, null, false, 0, false, null, null, null, null, null, null, null, 65534, null);
        }
    }

    public static final void f(RoomMessageAdapter roomMessageAdapter, LinearLayout llMedal, List medals) {
        List<MedalBean> list;
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(llMedal, "llMedal");
        Intrinsics.checkNotNullParameter(medals, "medals");
        try {
            BaseService mAppService = AllModuleServiceManager.INSTANCE.get().getMAppService();
            if (mAppService != null) {
                list = mAppService.getMedalList();
            } else {
                list = null;
            }
            if (list != null && (!list.isEmpty())) {
                llMedal.setVisibility(0);
                int size = medals.size();
                int i10 = 0;
                for (int i11 = 0; i11 < size && i10 <= 7; i11++) {
                    MedalBean medalBean = null;
                    for (MedalBean medalBean2 : list) {
                        if (medalBean2.getMedalId() == ((int) ((Number) medals.get(i11)).longValue())) {
                            medalBean = medalBean2;
                        }
                    }
                    if (medalBean != null) {
                        i10++;
                        e(roomMessageAdapter, llMedal, medalBean.getPicUrl());
                    }
                }
                return;
            }
            llMedal.setVisibility(8);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static final void g(RoomMessageAdapter roomMessageAdapter, TextView textView, TextElemContent textContext, final RoomMessageItemListener roomMessageItemListener) {
        String str;
        User user;
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(textContext, "textContext");
        String text = textContext.getText();
        if (text == null) {
            text = "";
        }
        if (TextUtils.isEmpty(text)) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        List<TextElemContentAt> atAccount = textContext.getAtAccount();
        if (atAccount != null) {
            for (final TextElemContentAt textElemContentAt : atAccount) {
                String str2 = "@" + textElemContentAt.getAtNick();
                int i10 = 0;
                while (true) {
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) text, str2, i10, false, 4, (Object) null);
                    if (indexOf$default != -1) {
                        int length = str2.length() + indexOf$default;
                        i10 = str2.length() + indexOf$default;
                        String atAccount2 = textElemContentAt.getAtAccount();
                        AppService service = AppController.INSTANCE.getService();
                        if (service != null && (user = service.getUser()) != null) {
                            str = user.getExternalId();
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(atAccount2, str)) {
                            spannableStringBuilder.setSpan(new SpannableTextBuilder.TextClickableSpan(new Function1() { // from class: l3.x
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return z.a(RoomMessageItemListener.this, textElemContentAt, (String) obj);
                                }
                            }, str2, Color.parseColor("#f96101"), false), indexOf$default, length, 33);
                        } else {
                            spannableStringBuilder.setSpan(new SpannableTextBuilder.TextClickableSpan(new Function1() { // from class: l3.y
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return z.n(RoomMessageItemListener.this, textElemContentAt, (String) obj);
                                }
                            }, str2, Color.parseColor("#ffe222"), false), indexOf$default, length, 33);
                        }
                    }
                }
            }
        }
        FaceManager.handlerEmojiText(textView, spannableStringBuilder, false);
    }

    public static final void h(RoomMessageAdapter roomMessageAdapter, ActivityDetailData data, String str, RoomCustomActivityBinding binding) {
        long j10;
        long j11;
        long j12;
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(binding, "binding");
        data.setMessageId(str);
        binding.stateImage.setImageDrawable(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), data.getActivityTypeIcon()));
        binding.stateContent.setText(data.getActivityTypeText());
        AppCompatTextView appCompatTextView = binding.timeContent;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        Long startAt = data.getStartAt();
        long j13 = 0;
        if (startAt != null) {
            j10 = startAt.longValue();
        } else {
            j10 = 0;
        }
        Long endAt = data.getEndAt();
        if (endAt != null) {
            j11 = endAt.longValue();
        } else {
            j11 = 0;
        }
        appCompatTextView.setText(hiloUtils.formatActivityTime(j10, j11));
        binding.title.setText(data.getTheme());
        ImageView image = binding.image;
        Intrinsics.checkNotNullExpressionValue(image, "image");
        String imageSize = ImageSizeKt.imageSize(data.getBanner(), UiKtxKt.toPX(150));
        int i10 = com.tencent.qcloud.tuikit.tuichat.R.drawable.group_placeholde;
        ImageKtxKt.loadImage$default(image, imageSize, null, null, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i10), Integer.valueOf(i10), null, 40958, null);
        Long startAt2 = data.getStartAt();
        if (startAt2 != null) {
            j12 = startAt2.longValue();
        } else {
            j12 = 0;
        }
        Long endAt2 = data.getEndAt();
        if (endAt2 != null) {
            j13 = endAt2.longValue();
        }
        int checkActivityStart = hiloUtils.checkActivityStart(j12, j13);
        if (checkActivityStart != 0) {
            if (checkActivityStart != 1) {
                binding.interested.setBackground(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.shape_gradient_33ffffff_24dp));
                binding.interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.activity_icon_subscribe));
                binding.interestedText.setTextColor(androidx.core.content.a.getColor(binding.getRoot().getContext(), R.color.white));
                TextView textView = binding.interestedText;
                String format = String.format(ResourcesKtxKt.getStringById(roomMessageAdapter, R.string.activity_subscribed), Arrays.copyOf(new Object[]{Integer.valueOf(data.getPersonNum())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
                return;
            }
            binding.timeImage.setImageDrawable(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.discover_icon_start));
            binding.timeContent.setTextColor(androidx.core.content.a.getColor(binding.getRoot().getContext(), R.color.color_ff9600));
            binding.interested.setBackground(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.shape_gradient_ff9600_ff7200_24dp));
            binding.interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.discover_icon_online_white));
            binding.interestedText.setTextColor(androidx.core.content.a.getColor(binding.getRoot().getContext(), R.color.white));
            TextView textView2 = binding.interestedText;
            String format2 = String.format(ResourcesKtxKt.getStringById(roomMessageAdapter, R.string.activity_now), Arrays.copyOf(new Object[]{Integer.valueOf(data.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView2.setText(format2);
            return;
        }
        binding.timeImage.setImageDrawable(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.discover_time_ash));
        binding.timeContent.setTextColor(androidx.core.content.a.getColor(binding.getRoot().getContext(), R.color.color_7fffffff));
        if (Intrinsics.areEqual(data.isSubscribe(), Boolean.FALSE)) {
            binding.interested.setBackground(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.shape_gradient_b043ff_6f2df7_24dp));
            binding.interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.activity_icon_subscribe));
            binding.interestedText.setTextColor(androidx.core.content.a.getColor(binding.getRoot().getContext(), R.color.white));
            TextView textView3 = binding.interestedText;
            String format3 = String.format(ResourcesKtxKt.getStringById(roomMessageAdapter, R.string.activity_subscription), Arrays.copyOf(new Object[]{Integer.valueOf(data.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            textView3.setText(format3);
            return;
        }
        binding.interested.setBackground(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.shape_gradient_33ffffff_24dp));
        binding.interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(binding.getRoot().getContext(), R.drawable.activity_icon_subscribe));
        binding.interestedText.setTextColor(androidx.core.content.a.getColor(binding.getRoot().getContext(), R.color.white));
        TextView textView4 = binding.interestedText;
        String format4 = String.format(ResourcesKtxKt.getStringById(roomMessageAdapter, R.string.activity_subscribed), Arrays.copyOf(new Object[]{Integer.valueOf(data.getPersonNum())}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
        textView4.setText(format4);
    }

    public static final void i(RoomMessageAdapter roomMessageAdapter, IncludeMessageTitleBinding titleBinding) {
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(titleBinding, "titleBinding");
        titleBinding.userTag.setVisibility(8);
        titleBinding.wealthLevel.setVisibility(8);
        titleBinding.charmLevel.setVisibility(8);
        titleBinding.imgBeautyCode.setVisibility(8);
        titleBinding.iconNoble.setVisibility(8);
        titleBinding.iconVip.setVisibility(8);
        titleBinding.llMedal.setVisibility(8);
        titleBinding.svip.setVisibility(8);
        titleBinding.familyNamePlate.getRoot().setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02b1 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ca A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02df A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e5 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0136 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f6 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0148 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0159 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018c A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0195 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ac A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b5 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cc A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e2 A[Catch: Exception -> 0x00ec, TRY_ENTER, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0244 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024d A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0260 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0269 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0283 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0294 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02a8 A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:143:0x00e1, B:145:0x00e7, B:29:0x00f6, B:31:0x00fa, B:33:0x0100, B:34:0x010c, B:36:0x0112, B:38:0x0118, B:39:0x013c, B:41:0x0148, B:42:0x014f, B:44:0x0159, B:45:0x0160, B:49:0x0169, B:51:0x018c, B:53:0x0195, B:55:0x01ac, B:57:0x01b5, B:59:0x01cc, B:61:0x01d2, B:64:0x01e2, B:66:0x01e8, B:68:0x01f9, B:70:0x0205, B:71:0x0216, B:73:0x0222, B:74:0x0230, B:76:0x0244, B:78:0x024d, B:80:0x0253, B:82:0x0260, B:84:0x0269, B:86:0x026f, B:87:0x027a, B:89:0x0283, B:91:0x0289, B:93:0x0294, B:97:0x02a0, B:99:0x02a8, B:101:0x02b1, B:104:0x02b8, B:106:0x02ca, B:107:0x02cf, B:109:0x02df, B:111:0x02e5, B:113:0x02ef, B:121:0x02d8, B:125:0x0275, B:127:0x0259, B:131:0x0234, B:135:0x0185, B:141:0x0136), top: B:142:0x00e1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void j(RoomMessageAdapter roomMessageAdapter, QMUIRadiusImageView avatar, ProgressBar progress, ImageView errorImage, IncludeMessageTitleBinding titleBinding, final RoomMessageMulti itemData, final RoomMessageItemListener roomMessageItemListener) {
        QMUIRadiusImageView qMUIRadiusImageView;
        String str;
        ImageView imageView;
        QMUIRadiusImageView qMUIRadiusImageView2;
        int i10;
        String str2;
        CloudCustomData cloudCustomData;
        boolean z10;
        Long svipLevel;
        long longValue;
        int i11;
        GroupMessageNew data;
        String str3;
        GroupMessageNew data2;
        String str4;
        int i12;
        Long l10;
        Long l11;
        Integer num;
        Boolean bool;
        Boolean bool2;
        int i13;
        String str5;
        List<Long> list;
        LinearLayout linearLayout;
        Long powerGrade;
        int i14;
        int i15;
        Long nobleLevel;
        Integer num2;
        Long svipLevel2;
        Integer status;
        String str6;
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(errorImage, "errorImage");
        Intrinsics.checkNotNullParameter(titleBinding, "titleBinding");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        GMSvipDetail gMSvipDetail = null;
        if (!itemData.checkMystery()) {
            GroupMessageNew data3 = itemData.getData();
            if (data3 != null) {
                str6 = data3.getSenderAvatar();
            } else {
                str6 = null;
            }
            String image100 = ImageSizeKt.image100(str6);
            int i16 = R.drawable.default_user_icon;
            str = "llMedal";
            qMUIRadiusImageView = avatar;
            ImageKtxKt.loadImage$default(avatar, image100, null, null, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i16), Integer.valueOf(i16), null, 40958, null);
        } else {
            qMUIRadiusImageView = avatar;
            str = "llMedal";
            qMUIRadiusImageView.setImageDrawable(androidx.core.content.a.getDrawable(avatar.getContext(), R.drawable.mystery_header));
        }
        GroupMessageNew data4 = itemData.getData();
        if (data4 != null && (status = data4.getStatus()) != null) {
            i10 = status.intValue();
            imageView = errorImage;
            qMUIRadiusImageView2 = qMUIRadiusImageView;
        } else {
            imageView = errorImage;
            qMUIRadiusImageView2 = qMUIRadiusImageView;
            i10 = 0;
        }
        b(roomMessageAdapter, i10, progress, imageView);
        TextView textView = titleBinding.name;
        GroupMessageNew data5 = itemData.getData();
        if (data5 != null) {
            str2 = data5.getSenderNick();
        } else {
            str2 = null;
        }
        textView.setText(str2);
        GroupMessageNew data6 = itemData.getData();
        if (data6 != null) {
            cloudCustomData = data6.getCloudCustomData();
        } else {
            cloudCustomData = null;
        }
        ImageView ivNewUser = titleBinding.ivNewUser;
        Intrinsics.checkNotNullExpressionValue(ivNewUser, "ivNewUser");
        if (cloudCustomData != null && cloudCustomData.getCornerMark() == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        ViewKtxKt.visibleOrGone(ivNewUser, z10);
        if (cloudCustomData != null) {
            try {
                svipLevel = cloudCustomData.getSvipLevel();
            } catch (Exception e10) {
                e10.printStackTrace();
                i(roomMessageAdapter, titleBinding);
            }
            if (svipLevel != null) {
                longValue = svipLevel.longValue();
                if (longValue <= 0) {
                    SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                    if (cloudCustomData != null && (svipLevel2 = cloudCustomData.getSvipLevel()) != null) {
                        num2 = Integer.valueOf((int) svipLevel2.longValue());
                    } else {
                        num2 = null;
                    }
                    Integer svipType = svipTypeUtils.getSvipType(num2);
                    if (svipType != null && svipType.intValue() > 0) {
                        titleBinding.svip.setImageDrawable(androidx.core.content.a.getDrawable(titleBinding.getRoot().getContext(), svipType.intValue()));
                        i11 = 0;
                        titleBinding.svip.setVisibility(0);
                    } else {
                        i11 = 0;
                    }
                } else {
                    i11 = 0;
                    titleBinding.svip.setVisibility(8);
                }
                UserRoleType.Companion companion = UserRoleType.INSTANCE;
                UserRoleType userRoleType = companion.get();
                data = itemData.getData();
                if (data == null) {
                    str3 = data.getFromAccount();
                } else {
                    str3 = null;
                }
                int roomUserRole = userRoleType.getRoomUserRole(str3);
                data2 = itemData.getData();
                if (data2 == null) {
                    str4 = data2.getFromAccount();
                } else {
                    str4 = null;
                }
                if (TextUtils.isEmpty(str4)) {
                    i12 = 1;
                    if (roomUserRole > 1) {
                        titleBinding.userTag.setImageDrawable(androidx.core.content.a.getDrawable(titleBinding.getRoot().getContext(), companion.getLevelRes(roomUserRole)));
                        titleBinding.userTag.setVisibility(i11);
                        if (cloudCustomData != null) {
                            l10 = cloudCustomData.getWealthGrade();
                        } else {
                            l10 = null;
                        }
                        if (l10 != null) {
                            titleBinding.wealthLevel.setVisibility(i11);
                            HiloGradeView.setLevelBg$default(titleBinding.wealthLevel, l10.longValue(), false, true, false, 10, null);
                        }
                        if (cloudCustomData != null) {
                            l11 = cloudCustomData.getCharmGrade();
                        } else {
                            l11 = null;
                        }
                        if (l11 != null) {
                            titleBinding.charmLevel.setVisibility(i11);
                            HiloGradeView.setLevelBg$default(titleBinding.charmLevel, l11.longValue(), true, false, false, 12, null);
                        }
                        if (cloudCustomData == null && (nobleLevel = cloudCustomData.getNobleLevel()) != null) {
                            num = Integer.valueOf((int) nobleLevel.longValue());
                        } else {
                            num = null;
                        }
                        if (num == null && num.intValue() > 0) {
                            titleBinding.iconNoble.setVisibility(i11);
                            AllModuleServiceManager.Companion companion2 = AllModuleServiceManager.INSTANCE;
                            BaseService mAppService = companion2.get().getMAppService();
                            if (mAppService != null) {
                                i14 = mAppService.getNobleDrawableRes(num.intValue());
                            } else {
                                i14 = 0;
                            }
                            if (i14 > 0) {
                                titleBinding.iconNoble.setImageDrawable(androidx.core.content.a.getDrawable(titleBinding.getRoot().getContext(), i14));
                            }
                            TextView textView2 = titleBinding.name;
                            BaseService mAppService2 = companion2.get().getMAppService();
                            if (mAppService2 != null) {
                                i15 = mAppService2.getNobleColor(num.intValue(), Color.parseColor("#ffffff"));
                            } else {
                                i15 = 0;
                            }
                            textView2.setTextColor(i15);
                        } else {
                            titleBinding.iconNoble.setVisibility(8);
                            titleBinding.name.setTextColor(Color.parseColor("#ffffff"));
                        }
                        if (cloudCustomData != null) {
                            bool = cloudCustomData.isVip();
                        } else {
                            bool = null;
                        }
                        if (bool == null && bool.booleanValue()) {
                            titleBinding.iconVip.setVisibility(i11);
                        } else {
                            titleBinding.iconVip.setVisibility(8);
                        }
                        if (cloudCustomData != null) {
                            bool2 = cloudCustomData.isPretty();
                        } else {
                            bool2 = null;
                        }
                        if (bool2 == null && bool2.booleanValue()) {
                            titleBinding.imgBeautyCode.setVisibility(i11);
                        } else {
                            titleBinding.imgBeautyCode.setVisibility(8);
                        }
                        IncludeFamilyNamePlateBinding familyNamePlate = titleBinding.familyNamePlate;
                        Intrinsics.checkNotNullExpressionValue(familyNamePlate, "familyNamePlate");
                        if (cloudCustomData == null && (powerGrade = cloudCustomData.getPowerGrade()) != null) {
                            i13 = (int) powerGrade.longValue();
                        } else {
                            i13 = -1;
                        }
                        if (cloudCustomData != null) {
                            str5 = cloudCustomData.getPowerNameplate();
                            if (str5 != null) {
                            }
                            AppUtilitiesKt.familyNamePlate$default(familyNamePlate, i13, str5, 0, 4, null);
                            if (cloudCustomData == null) {
                                list = cloudCustomData.getMedals();
                            } else {
                                list = null;
                            }
                            if (list != null && !list.isEmpty()) {
                                titleBinding.llMedal.setVisibility(i11);
                                linearLayout = titleBinding.llMedal;
                                String str7 = str;
                                Intrinsics.checkNotNullExpressionValue(linearLayout, str7);
                                if (linearLayout.getChildCount() != 0) {
                                    titleBinding.llMedal.removeAllViews();
                                }
                                LinearLayout linearLayout2 = titleBinding.llMedal;
                                Intrinsics.checkNotNullExpressionValue(linearLayout2, str7);
                                f(roomMessageAdapter, linearLayout2, list);
                                if (cloudCustomData != null) {
                                    gMSvipDetail = cloudCustomData.getSvip();
                                }
                                if (gMSvipDetail != null && !TextUtils.isEmpty(gMSvipDetail.getMysteryCode())) {
                                    i(roomMessageAdapter, titleBinding);
                                    TextView textView3 = titleBinding.name;
                                    String stringById = ResourcesKtxKt.getStringById(roomMessageAdapter, R.string.mystery_name);
                                    Object[] objArr = new Object[i12];
                                    objArr[i11] = gMSvipDetail.getMysteryCode();
                                    String format = String.format(stringById, Arrays.copyOf(objArr, i12));
                                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                                    textView3.setText(format);
                                    titleBinding.name.setTextColor(Color.parseColor("#ffffff"));
                                    qMUIRadiusImageView2.setImageDrawable(androidx.core.content.a.getDrawable(avatar.getContext(), R.drawable.mystery_header));
                                }
                                imageView.setOnClickListener(new u(imageView, roomMessageItemListener, itemData));
                                qMUIRadiusImageView2.setOnClickListener(new v(qMUIRadiusImageView2, roomMessageItemListener, itemData));
                                qMUIRadiusImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: l3.w
                                    @Override // android.view.View.OnLongClickListener
                                    public final boolean onLongClick(View view) {
                                        return z.m(RoomMessageItemListener.this, itemData, view);
                                    }
                                });
                            }
                            titleBinding.llMedal.setVisibility(8);
                            if (cloudCustomData != null) {
                            }
                            if (gMSvipDetail != null) {
                                i(roomMessageAdapter, titleBinding);
                                TextView textView32 = titleBinding.name;
                                String stringById2 = ResourcesKtxKt.getStringById(roomMessageAdapter, R.string.mystery_name);
                                Object[] objArr2 = new Object[i12];
                                objArr2[i11] = gMSvipDetail.getMysteryCode();
                                String format2 = String.format(stringById2, Arrays.copyOf(objArr2, i12));
                                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                                textView32.setText(format2);
                                titleBinding.name.setTextColor(Color.parseColor("#ffffff"));
                                qMUIRadiusImageView2.setImageDrawable(androidx.core.content.a.getDrawable(avatar.getContext(), R.drawable.mystery_header));
                            }
                            imageView.setOnClickListener(new u(imageView, roomMessageItemListener, itemData));
                            qMUIRadiusImageView2.setOnClickListener(new v(qMUIRadiusImageView2, roomMessageItemListener, itemData));
                            qMUIRadiusImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: l3.w
                                @Override // android.view.View.OnLongClickListener
                                public final boolean onLongClick(View view) {
                                    return z.m(RoomMessageItemListener.this, itemData, view);
                                }
                            });
                        }
                        str5 = "";
                        AppUtilitiesKt.familyNamePlate$default(familyNamePlate, i13, str5, 0, 4, null);
                        if (cloudCustomData == null) {
                        }
                        if (list != null) {
                            titleBinding.llMedal.setVisibility(i11);
                            linearLayout = titleBinding.llMedal;
                            String str72 = str;
                            Intrinsics.checkNotNullExpressionValue(linearLayout, str72);
                            if (linearLayout.getChildCount() != 0) {
                            }
                            LinearLayout linearLayout22 = titleBinding.llMedal;
                            Intrinsics.checkNotNullExpressionValue(linearLayout22, str72);
                            f(roomMessageAdapter, linearLayout22, list);
                            if (cloudCustomData != null) {
                            }
                            if (gMSvipDetail != null) {
                            }
                            imageView.setOnClickListener(new u(imageView, roomMessageItemListener, itemData));
                            qMUIRadiusImageView2.setOnClickListener(new v(qMUIRadiusImageView2, roomMessageItemListener, itemData));
                            qMUIRadiusImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: l3.w
                                @Override // android.view.View.OnLongClickListener
                                public final boolean onLongClick(View view) {
                                    return z.m(RoomMessageItemListener.this, itemData, view);
                                }
                            });
                        }
                        titleBinding.llMedal.setVisibility(8);
                        if (cloudCustomData != null) {
                        }
                        if (gMSvipDetail != null) {
                        }
                        imageView.setOnClickListener(new u(imageView, roomMessageItemListener, itemData));
                        qMUIRadiusImageView2.setOnClickListener(new v(qMUIRadiusImageView2, roomMessageItemListener, itemData));
                        qMUIRadiusImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: l3.w
                            @Override // android.view.View.OnLongClickListener
                            public final boolean onLongClick(View view) {
                                return z.m(RoomMessageItemListener.this, itemData, view);
                            }
                        });
                    }
                } else {
                    i12 = 1;
                }
                titleBinding.userTag.setVisibility(8);
                if (cloudCustomData != null) {
                }
                if (l10 != null) {
                }
                if (cloudCustomData != null) {
                }
                if (l11 != null) {
                }
                if (cloudCustomData == null) {
                }
                num = null;
                if (num == null) {
                }
                titleBinding.iconNoble.setVisibility(8);
                titleBinding.name.setTextColor(Color.parseColor("#ffffff"));
                if (cloudCustomData != null) {
                }
                if (bool == null) {
                }
                titleBinding.iconVip.setVisibility(8);
                if (cloudCustomData != null) {
                }
                if (bool2 == null) {
                }
                titleBinding.imgBeautyCode.setVisibility(8);
                IncludeFamilyNamePlateBinding familyNamePlate2 = titleBinding.familyNamePlate;
                Intrinsics.checkNotNullExpressionValue(familyNamePlate2, "familyNamePlate");
                if (cloudCustomData == null) {
                }
                i13 = -1;
                if (cloudCustomData != null) {
                }
                str5 = "";
                AppUtilitiesKt.familyNamePlate$default(familyNamePlate2, i13, str5, 0, 4, null);
                if (cloudCustomData == null) {
                }
                if (list != null) {
                }
                titleBinding.llMedal.setVisibility(8);
                if (cloudCustomData != null) {
                }
                if (gMSvipDetail != null) {
                }
                imageView.setOnClickListener(new u(imageView, roomMessageItemListener, itemData));
                qMUIRadiusImageView2.setOnClickListener(new v(qMUIRadiusImageView2, roomMessageItemListener, itemData));
                qMUIRadiusImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: l3.w
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return z.m(RoomMessageItemListener.this, itemData, view);
                    }
                });
            }
        }
        longValue = 0;
        if (longValue <= 0) {
        }
        UserRoleType.Companion companion3 = UserRoleType.INSTANCE;
        UserRoleType userRoleType2 = companion3.get();
        data = itemData.getData();
        if (data == null) {
        }
        int roomUserRole2 = userRoleType2.getRoomUserRole(str3);
        data2 = itemData.getData();
        if (data2 == null) {
        }
        if (TextUtils.isEmpty(str4)) {
        }
        titleBinding.userTag.setVisibility(8);
        if (cloudCustomData != null) {
        }
        if (l10 != null) {
        }
        if (cloudCustomData != null) {
        }
        if (l11 != null) {
        }
        if (cloudCustomData == null) {
        }
        num = null;
        if (num == null) {
        }
        titleBinding.iconNoble.setVisibility(8);
        titleBinding.name.setTextColor(Color.parseColor("#ffffff"));
        if (cloudCustomData != null) {
        }
        if (bool == null) {
        }
        titleBinding.iconVip.setVisibility(8);
        if (cloudCustomData != null) {
        }
        if (bool2 == null) {
        }
        titleBinding.imgBeautyCode.setVisibility(8);
        IncludeFamilyNamePlateBinding familyNamePlate22 = titleBinding.familyNamePlate;
        Intrinsics.checkNotNullExpressionValue(familyNamePlate22, "familyNamePlate");
        if (cloudCustomData == null) {
        }
        i13 = -1;
        if (cloudCustomData != null) {
        }
        str5 = "";
        AppUtilitiesKt.familyNamePlate$default(familyNamePlate22, i13, str5, 0, 4, null);
        if (cloudCustomData == null) {
        }
        if (list != null) {
        }
        titleBinding.llMedal.setVisibility(8);
        if (cloudCustomData != null) {
        }
        if (gMSvipDetail != null) {
        }
        imageView.setOnClickListener(new u(imageView, roomMessageItemListener, itemData));
        qMUIRadiusImageView2.setOnClickListener(new v(qMUIRadiusImageView2, roomMessageItemListener, itemData));
        qMUIRadiusImageView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: l3.w
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return z.m(RoomMessageItemListener.this, itemData, view);
            }
        });
    }

    public static final void k(RoomMessageAdapter roomMessageAdapter, QMUIRadiusImageView imageView, ImageInfo imageInfo) {
        Integer height;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (imageInfo == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        Integer width = imageInfo.getWidth();
        if ((width == null || width.intValue() != 0) && ((height = imageInfo.getHeight()) == null || height.intValue() != 0)) {
            Integer width2 = imageInfo.getWidth();
            int i12 = 0;
            if (width2 != null) {
                i10 = width2.intValue();
            } else {
                i10 = 0;
            }
            Integer height2 = imageInfo.getHeight();
            if (height2 != null) {
                i11 = height2.intValue();
            } else {
                i11 = 0;
            }
            int i13 = 1;
            if (i10 > i11) {
                ((ViewGroup.MarginLayoutParams) bVar).width = 540;
                Integer width3 = imageInfo.getWidth();
                if (width3 != null) {
                    i12 = width3.intValue();
                }
                int i14 = i12 * 540;
                Integer height3 = imageInfo.getHeight();
                if (height3 != null) {
                    i13 = height3.intValue();
                }
                ((ViewGroup.MarginLayoutParams) bVar).height = i14 / i13;
            } else {
                Integer width4 = imageInfo.getWidth();
                if (width4 != null) {
                    i12 = width4.intValue();
                }
                int i15 = i12 * 540;
                Integer height4 = imageInfo.getHeight();
                if (height4 != null) {
                    i13 = height4.intValue();
                }
                ((ViewGroup.MarginLayoutParams) bVar).width = i15 / i13;
                ((ViewGroup.MarginLayoutParams) bVar).height = 540;
            }
            imageView.setLayoutParams(bVar);
            return;
        }
        ((ViewGroup.MarginLayoutParams) bVar).width = 540;
        ((ViewGroup.MarginLayoutParams) bVar).height = 540;
        imageView.setLayoutParams(bVar);
    }

    public static final void l(RoomMessageAdapter roomMessageAdapter, QMUIRadiusImageView imageView, VideoElemContent videoElemContent) {
        Integer thumbHeight;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(roomMessageAdapter, "<this>");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (videoElemContent == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        Integer thumbWidth = videoElemContent.getThumbWidth();
        if ((thumbWidth == null || thumbWidth.intValue() != 0) && ((thumbHeight = videoElemContent.getThumbHeight()) == null || thumbHeight.intValue() != 0)) {
            Integer thumbWidth2 = videoElemContent.getThumbWidth();
            int i12 = 0;
            if (thumbWidth2 != null) {
                i10 = thumbWidth2.intValue();
            } else {
                i10 = 0;
            }
            Integer thumbHeight2 = videoElemContent.getThumbHeight();
            if (thumbHeight2 != null) {
                i11 = thumbHeight2.intValue();
            } else {
                i11 = 0;
            }
            int i13 = 1;
            if (i10 > i11) {
                ((ViewGroup.MarginLayoutParams) bVar).width = 540;
                Integer thumbWidth3 = videoElemContent.getThumbWidth();
                if (thumbWidth3 != null) {
                    i12 = thumbWidth3.intValue();
                }
                int i14 = i12 * 540;
                Integer thumbHeight3 = videoElemContent.getThumbHeight();
                if (thumbHeight3 != null) {
                    i13 = thumbHeight3.intValue();
                }
                ((ViewGroup.MarginLayoutParams) bVar).height = i14 / i13;
            } else {
                Integer thumbWidth4 = videoElemContent.getThumbWidth();
                if (thumbWidth4 != null) {
                    i12 = thumbWidth4.intValue();
                }
                int i15 = i12 * 540;
                Integer thumbHeight4 = videoElemContent.getThumbHeight();
                if (thumbHeight4 != null) {
                    i13 = thumbHeight4.intValue();
                }
                ((ViewGroup.MarginLayoutParams) bVar).width = i15 / i13;
                ((ViewGroup.MarginLayoutParams) bVar).height = 540;
            }
            imageView.setLayoutParams(bVar);
            return;
        }
        ((ViewGroup.MarginLayoutParams) bVar).width = 540;
        ((ViewGroup.MarginLayoutParams) bVar).height = 540;
        imageView.setLayoutParams(bVar);
    }

    public static final boolean m(RoomMessageItemListener roomMessageItemListener, RoomMessageMulti roomMessageMulti, View view) {
        if (roomMessageItemListener != null) {
            roomMessageItemListener.onUserIconLongClick(roomMessageMulti);
            return true;
        }
        return true;
    }

    public static final Unit n(RoomMessageItemListener roomMessageItemListener, TextElemContentAt textElemContentAt, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (roomMessageItemListener != null) {
            roomMessageItemListener.onType(5, textElemContentAt.getAtAccount());
        }
        return Unit.INSTANCE;
    }
}
