package com.qiahao.nextvideo.room.view.micro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemMiddleMicroViewBinding;
import com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0014J\b\u0010!\u001a\u00020\u0015H\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\u0015H\u0016J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/MiddleItemMicroView;", "Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ItemMiddleMicroViewBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ItemMiddleMicroViewBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ItemMiddleMicroViewBinding;)V", "muteDrawable8", "Landroid/graphics/drawable/Drawable;", "muteDrawable", "lockGoldDrawable", "lockDrawable", "initView", "", "updateView", "resetViewToEmptyState", "handleNonEmptyMicBean", "handleLockedMic", "handleUserInMic", "handleHeadwearWithSvga", "handleHeadwearWithoutSvga", "handleMysteryUser", "handleNoUserInMic", "stopMicSVGA", "onDetachedFromWindow", "recoverMicSVGA", "playSvga", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "playCpSvga", "showMicSpeakWaveAnim", "showFaceSvga", "faceSVGAUrl", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMiddleItemMicroView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiddleItemMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/MiddleItemMicroView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,528:1\n255#2:529\n*S KotlinDebug\n*F\n+ 1 MiddleItemMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/MiddleItemMicroView\n*L\n156#1:529\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MiddleItemMicroView extends BaseItemMicroView {

    @NotNull
    private static final String SVGA_RAW_PARAM = "?raw=true";

    @NotNull
    private static final String TAG = "MiddleItemMicroView";

    @Nullable
    private Drawable lockDrawable;

    @Nullable
    private Drawable lockGoldDrawable;
    public ItemMiddleMicroViewBinding mDataBinding;

    @Nullable
    private Drawable muteDrawable;

    @Nullable
    private Drawable muteDrawable8;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiddleItemMicroView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void handleHeadwearWithSvga() {
        String str;
        String obj = getMDataBinding().micUserHeadSvga.getTag().toString();
        MicroBean mMicBean = getMMicBean();
        if (mMicBean != null) {
            str = mMicBean.getEffectUrl();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(obj, str)) {
            getMDataBinding().micUserHeadSvga.stopAnimation(true);
            getMDataBinding().micUserHeadSvga.setVisibility(0);
            getMDataBinding().micUserHeadImg.setVisibility(8);
            MicroBean mMicBean2 = getMMicBean();
            if (mMicBean2 != null) {
                playSvga(mMicBean2);
                return;
            }
            return;
        }
        getMDataBinding().micUserHeadSvga.setVisibility(0);
        getMDataBinding().micUserHeadImg.setVisibility(8);
        getMDataBinding().micUserHeadSvga.stopAnimation(true);
        MicroBean mMicBean3 = getMMicBean();
        if (mMicBean3 != null) {
            playSvga(mMicBean3);
        }
    }

    private final void handleHeadwearWithoutSvga() {
        String str;
        MicroUserBean user;
        MicroUserBean user2;
        getMDataBinding().micUserHeadSvga.setVisibility(8);
        getMDataBinding().micUserHeadSvga.stopAnimation(true);
        getMDataBinding().micUserHeadSvga.setTag("");
        MicroBean mMicBean = getMMicBean();
        String str2 = null;
        if (mMicBean != null && (user2 = mMicBean.getUser()) != null) {
            str = user2.getHeadwearPicUrl();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            getMDataBinding().micUserHeadImg.setVisibility(0);
            ImageView imageView = getMDataBinding().micUserHeadImg;
            Intrinsics.checkNotNullExpressionValue(imageView, "micUserHeadImg");
            MicroBean mMicBean2 = getMMicBean();
            if (mMicBean2 != null && (user = mMicBean2.getUser()) != null) {
                str2 = user.getHeadwearPicUrl();
            }
            ViewUtilitiesKt.bind(imageView, new ImageUIModel(str2, null, null, null, 0, 0, null, 126, null));
            return;
        }
        getMDataBinding().micUserHeadImg.setVisibility(8);
    }

    private final void handleLockedMic() {
        getMDataBinding().baseMicro.setVisibility(8);
        getMDataBinding().lockMicro.setVisibility(0);
        getMDataBinding().lockMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiddleItemMicroView.handleLockedMic$lambda$2(MiddleItemMicroView.this, view);
            }
        });
        getMDataBinding().userInfoLinearLayout.setVisibility(0);
        getMDataBinding().userTag.setVisibility(8);
        getMDataBinding().userVip.setVisibility(8);
        getMDataBinding().iconNoble.setVisibility(8);
        getMDataBinding().iconSvip.setVisibility(8);
        getMDataBinding().userAvatar.setVisibility(8);
        getMDataBinding().userMute.setVisibility(8);
        getMDataBinding().speakWave.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleLockedMic$lambda$2(MiddleItemMicroView middleItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = middleItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnLockMic(middleItemMicroView.getMPosition(), middleItemMicroView.getMMicBean());
        }
    }

    private final void handleMysteryUser() {
        AppCompatImageView appCompatImageView = getMDataBinding().userAvatar;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
        ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        getMDataBinding().userName.setDefault(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
        getMDataBinding().userName.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.view.micro.t
            @Override // java.lang.Runnable
            public final void run() {
                MiddleItemMicroView.handleMysteryUser$lambda$10(MiddleItemMicroView.this);
            }
        }, 100L);
        getMDataBinding().micUserHeadSvga.setVisibility(8);
        getMDataBinding().micUserHeadSvga.stopAnimation(true);
        getMDataBinding().micUserHeadImg.setVisibility(8);
        getMDataBinding().iconSvip.setVisibility(8);
        getMDataBinding().userVip.setVisibility(8);
        getMDataBinding().iconNoble.setVisibility(8);
        getMDataBinding().userTag.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleMysteryUser$lambda$10(MiddleItemMicroView middleItemMicroView) {
        String str;
        MicroUserBean user;
        SvipData svip;
        NickTextView nickTextView = middleItemMicroView.getMDataBinding().userName;
        String stringById = ResourcesKtxKt.getStringById(middleItemMicroView, 2131953504);
        MicroBean mMicBean = middleItemMicroView.getMMicBean();
        if (mMicBean != null && (user = mMicBean.getUser()) != null && (svip = user.getSvip()) != null) {
            str = svip.mysteryNumber();
        } else {
            str = null;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        nickTextView.setText(format);
    }

    private final void handleNoUserInMic() {
        getMDataBinding().speakWave.setVisibility(8);
        getMDataBinding().micUserHeadSvga.setVisibility(8);
        getMDataBinding().micUserHeadSvga.stopAnimation(true);
        getMDataBinding().cpSvga.setVisibility(8);
        getMDataBinding().cpSvga.stopAnimation(true);
        if (getMDataBinding().speakWave.d()) {
            getMDataBinding().speakWave.a();
        }
        getMDataBinding().userMute.setOnClickListener(null);
        getMDataBinding().userAvatar.setOnClickListener(null);
        getMDataBinding().personMicOff.setVisibility(8);
    }

    private final void handleNonEmptyMicBean() {
        MicroUserBean microUserBean;
        getMDataBinding().lockMicro.setVisibility(8);
        getMDataBinding().userInfoLinearLayout.setVisibility(0);
        getMDataBinding().userTag.setVisibility(8);
        getMDataBinding().userVip.setVisibility(8);
        getMDataBinding().iconNoble.setVisibility(8);
        getMDataBinding().userName.setDefault(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
        getMDataBinding().userName.setText(String.valueOf(getMPosition()));
        getMDataBinding().userAvatar.setVisibility(8);
        getMDataBinding().userMute.setVisibility(8);
        getMDataBinding().baseMicro.setVisibility(0);
        getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiddleItemMicroView.handleNonEmptyMicBean$lambda$1(MiddleItemMicroView.this, view);
            }
        });
        SVGAImageView sVGAImageView = getMDataBinding().micUserHeadSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "micUserHeadSvga");
        if (sVGAImageView.getVisibility() != 0) {
            getMDataBinding().micUserHeadSvga.setVisibility(8);
        }
        getMDataBinding().micUserHeadImg.setVisibility(8);
        MicroBean mMicBean = getMMicBean();
        if (mMicBean != null && mMicBean.getLock()) {
            handleLockedMic();
        } else {
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().userInfoLinearLayout.setVisibility(0);
            getMDataBinding().userVip.setVisibility(8);
            getMDataBinding().iconNoble.setVisibility(8);
            getMDataBinding().iconSvip.setVisibility(8);
            getMDataBinding().userTag.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().speakWave.setVisibility(8);
        }
        MicroBean mMicBean2 = getMMicBean();
        if (mMicBean2 != null) {
            microUserBean = mMicBean2.getUser();
        } else {
            microUserBean = null;
        }
        if (microUserBean != null) {
            handleUserInMic();
        } else {
            handleNoUserInMic();
        }
        MicroBean mMicBean3 = getMMicBean();
        if (mMicBean3 != null && mMicBean3.getMicForbid()) {
            getMDataBinding().micOff.setVisibility(0);
        } else {
            getMDataBinding().micOff.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleNonEmptyMicBean$lambda$1(MiddleItemMicroView middleItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = middleItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(middleItemMicroView.getMPosition(), middleItemMicroView.getMMicBean());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleUserInMic() {
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        MicroBean mMicBean;
        String str2;
        MeetingRoomManager meetingRoomManager;
        MicroBean mMicBean2;
        String str3;
        int roomUserRole;
        MicroBean mMicBean3;
        String str4;
        boolean z2;
        MicroBean mMicBean4;
        boolean z3;
        MicroBean mMicBean5;
        String str5;
        MicroBean mMicBean6;
        MicroUserBean user;
        SvipData svip;
        MicroUserBean user2;
        MicroUserBean user3;
        MicroUserBean user4;
        MicroUserBean user5;
        String str6;
        String str7;
        Integer num;
        MicroUserBean user6;
        SvipData svip2;
        MicroUserBean user7;
        SvipData svip3;
        int i6;
        MicroUserBean user8;
        MicroUserBean user9;
        MicroUserBean user10;
        MicroUserBean user11;
        MicroUserBean user12;
        SvipData svip4;
        MicroUserBean user13;
        String nick;
        MicroUserBean user14;
        getMDataBinding().baseMicro.setVisibility(8);
        getMDataBinding().lockMicro.setVisibility(8);
        getMDataBinding().userMute.setVisibility(8);
        getMDataBinding().userAvatar.setVisibility(0);
        getMDataBinding().userInfoLinearLayout.setVisibility(0);
        NickTextView nickTextView = getMDataBinding().userName;
        UserService.Companion companion = UserService.INSTANCE;
        MicroBean mMicBean7 = getMMicBean();
        if (mMicBean7 != null && (user14 = mMicBean7.getUser()) != null) {
            i = user14.getNoble();
        } else {
            i = 0;
        }
        String str8 = null;
        nickTextView.setDefault(UserService.Companion.getNobleColor$default(companion, i, 0, 2, null));
        NickTextView nickTextView2 = getMDataBinding().userName;
        MicroBean mMicBean8 = getMMicBean();
        if (mMicBean8 != null && (user13 = mMicBean8.getUser()) != null && (nick = user13.getNick()) != null) {
            str = DataExternalKt.maxLengthSuffix(nick, 10, "...");
        } else {
            str = null;
        }
        MicroBean mMicBean9 = getMMicBean();
        if (mMicBean9 != null && (user12 = mMicBean9.getUser()) != null && (svip4 = user12.getSvip()) != null) {
            i2 = svip4.getSvipLevel();
        } else {
            i2 = 0;
        }
        MicroBean mMicBean10 = getMMicBean();
        if (mMicBean10 != null && (user11 = mMicBean10.getUser()) != null) {
            i3 = user11.getNoble();
        } else {
            i3 = 0;
        }
        nickTextView2.setSVipAndNoble(str, i2, i3);
        MicroBean mMicBean11 = getMMicBean();
        if (mMicBean11 != null && (user10 = mMicBean11.getUser()) != null && user10.isVip()) {
            getMDataBinding().userVip.setVisibility(0);
        }
        MicroBean mMicBean12 = getMMicBean();
        if (mMicBean12 != null && (user9 = mMicBean12.getUser()) != null) {
            i4 = user9.getNoble();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            getMDataBinding().userVip.setVisibility(8);
            getMDataBinding().iconNoble.setVisibility(0);
            ImageView imageView = getMDataBinding().iconNoble;
            Context context = getMDataBinding().getRoot().getContext();
            MicroBean mMicBean13 = getMMicBean();
            if (mMicBean13 != null && (user8 = mMicBean13.getUser()) != null) {
                i6 = user8.getNoble();
            } else {
                i6 = 0;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i6)));
        } else {
            getMDataBinding().iconNoble.setVisibility(8);
        }
        MicroBean mMicBean14 = getMMicBean();
        if (mMicBean14 != null && (user7 = mMicBean14.getUser()) != null && (svip3 = user7.getSvip()) != null) {
            i5 = svip3.getSvipLevel();
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            getMDataBinding().userVip.setVisibility(8);
            getMDataBinding().iconNoble.setVisibility(8);
            getMDataBinding().iconSvip.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            MicroBean mMicBean15 = getMMicBean();
            if (mMicBean15 != null && (user6 = mMicBean15.getUser()) != null && (svip2 = user6.getSvip()) != null) {
                num = Integer.valueOf(svip2.getSvipLevel());
            } else {
                num = null;
            }
            Integer svipMedal = svipTypeUtils.getSvipMedal(num);
            if (svipMedal != null) {
                getMDataBinding().iconSvip.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), svipMedal.intValue()));
            }
        } else {
            getMDataBinding().iconSvip.setVisibility(8);
        }
        MicroBean mMicBean16 = getMMicBean();
        if (mMicBean16 != null) {
            z = Intrinsics.areEqual(mMicBean16.getForbid(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            MicroBean mMicBean17 = getMMicBean();
            if (mMicBean17 != null) {
                str6 = mMicBean17.getExternalId();
            } else {
                str6 = null;
            }
            User user15 = UserStore.INSTANCE.getShared().getUser();
            if (user15 != null) {
                str7 = user15.getExternalId();
            } else {
                str7 = null;
            }
            if (Intrinsics.areEqual(str6, str7)) {
                getMDataBinding().userMute.setVisibility(0);
                getMDataBinding().userMute.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiddleItemMicroView.handleUserInMic$lambda$4(MiddleItemMicroView.this, view);
                    }
                });
                AppCompatImageView appCompatImageView = getMDataBinding().userAvatar;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
                mMicBean = getMMicBean();
                if (mMicBean == null && (user5 = mMicBean.getUser()) != null) {
                    str2 = user5.getAvatar();
                } else {
                    str2 = null;
                }
                ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(str2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
                getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiddleItemMicroView.handleUserInMic$lambda$5(MiddleItemMicroView.this, view);
                    }
                });
                meetingRoomManager = MeetingRoomManager.INSTANCE;
                mMicBean2 = getMMicBean();
                if (mMicBean2 == null && (user4 = mMicBean2.getUser()) != null) {
                    str3 = user4.getExternalId();
                } else {
                    str3 = null;
                }
                roomUserRole = meetingRoomManager.getRoomUserRole(str3);
                if (roomUserRole <= 1) {
                    getMDataBinding().userTag.setVisibility(0);
                    getMDataBinding().userTag.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), meetingRoomManager.getLevelRes(roomUserRole)));
                } else {
                    getMDataBinding().userTag.setVisibility(8);
                }
                mMicBean3 = getMMicBean();
                if (mMicBean3 == null) {
                    str4 = mMicBean3.getEffectUrl();
                } else {
                    str4 = null;
                }
                if (str4 == null && str4.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    handleHeadwearWithSvga();
                } else {
                    handleHeadwearWithoutSvga();
                }
                mMicBean4 = getMMicBean();
                if (mMicBean4 != null && (user3 = mMicBean4.getUser()) != null) {
                    str8 = user3.getMicEffect();
                }
                if (str8 == null && str8.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    getMDataBinding().cpSvga.setVisibility(0);
                    MicroBean mMicBean18 = getMMicBean();
                    if (mMicBean18 != null) {
                        playCpSvga(mMicBean18);
                    }
                } else {
                    getMDataBinding().cpSvga.stopAnimation(true);
                    getMDataBinding().cpSvga.setVisibility(8);
                }
                mMicBean5 = getMMicBean();
                if (mMicBean5 != null || (user2 = mMicBean5.getUser()) == null || (str5 = user2.getExternalId()) == null) {
                    str5 = "";
                }
                if (!meetingRoomManager.haveLocalMute(str5)) {
                    getMDataBinding().personMicOff.setVisibility(0);
                } else {
                    getMDataBinding().personMicOff.setVisibility(8);
                }
                mMicBean6 = getMMicBean();
                if (mMicBean6 == null && (user = mMicBean6.getUser()) != null && (svip = user.getSvip()) != null && svip.isMystery()) {
                    handleMysteryUser();
                    return;
                }
                return;
            }
        }
        getMDataBinding().userMute.setVisibility(8);
        getMDataBinding().userMute.setOnClickListener(null);
        AppCompatImageView appCompatImageView2 = getMDataBinding().userAvatar;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "userAvatar");
        mMicBean = getMMicBean();
        if (mMicBean == null) {
        }
        str2 = null;
        ImageKtxKt.loadImage$default(appCompatImageView2, ImageSizeKt.image100(str2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
        getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiddleItemMicroView.handleUserInMic$lambda$5(MiddleItemMicroView.this, view);
            }
        });
        meetingRoomManager = MeetingRoomManager.INSTANCE;
        mMicBean2 = getMMicBean();
        if (mMicBean2 == null) {
        }
        str3 = null;
        roomUserRole = meetingRoomManager.getRoomUserRole(str3);
        if (roomUserRole <= 1) {
        }
        mMicBean3 = getMMicBean();
        if (mMicBean3 == null) {
        }
        if (str4 == null) {
        }
        z2 = true;
        if (z2) {
        }
        mMicBean4 = getMMicBean();
        if (mMicBean4 != null) {
            str8 = user3.getMicEffect();
        }
        if (str8 == null) {
        }
        z3 = true;
        if (z3) {
        }
        mMicBean5 = getMMicBean();
        if (mMicBean5 != null) {
        }
        str5 = "";
        if (!meetingRoomManager.haveLocalMute(str5)) {
        }
        mMicBean6 = getMMicBean();
        if (mMicBean6 == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleUserInMic$lambda$4(MiddleItemMicroView middleItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = middleItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnMuteAvatarClick(middleItemMicroView.getMPosition(), middleItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleUserInMic$lambda$5(MiddleItemMicroView middleItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = middleItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onAvatarBtnClick(middleItemMicroView.getMPosition(), middleItemMicroView.getMMicBean());
        }
    }

    private final void playCpSvga(final MicroBean micBean) {
        String str;
        if (MeetingRoomManager.INSTANCE.checkGameMadel()) {
            return;
        }
        MicroUserBean user = micBean.getUser();
        String str2 = null;
        if (user != null) {
            str = user.getMicEffect();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            MicroUserBean user2 = micBean.getUser();
            if (user2 != null) {
                str2 = user2.getMicEffect();
            }
            final String str3 = str2 + SVGA_RAW_PARAM;
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(str3), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.MiddleItemMicroView$playCpSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String str4;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    MiddleItemMicroView.this.getMDataBinding().cpSvga.setVisibility(0);
                    SVGAImageView sVGAImageView = MiddleItemMicroView.this.getMDataBinding().cpSvga;
                    MicroUserBean user3 = micBean.getUser();
                    if (user3 != null) {
                        str4 = user3.getMicEffect();
                    } else {
                        str4 = null;
                    }
                    sVGAImageView.setTag(str4);
                    MiddleItemMicroView.this.getMDataBinding().cpSvga.stopAnimation(true);
                    MiddleItemMicroView.this.getMDataBinding().cpSvga.setImageDrawable(new SVGADrawable(videoItem));
                    MiddleItemMicroView.this.getMDataBinding().cpSvga.startAnimation();
                }

                public void onError() {
                    Log.e("MiddleItemMicroView", "Failed to decode CP SVG from URL: " + str3);
                    MiddleItemMicroView.this.getMDataBinding().cpSvga.setVisibility(8);
                    MiddleItemMicroView.this.getMDataBinding().cpSvga.setTag("");
                }
            });
        } catch (Exception e) {
            getMDataBinding().cpSvga.setVisibility(8);
            getMDataBinding().cpSvga.setTag("");
            DebugToolsKt.printfE(TAG, "playCpSvga 内部try()catch{}" + e.getLocalizedMessage());
        }
    }

    private final void playSvga(final MicroBean micBean) {
        if (MeetingRoomManager.INSTANCE.checkGameMadel() || TextUtils.isEmpty(micBean.getEffectUrl())) {
            return;
        }
        try {
            final String str = micBean.getEffectUrl() + SVGA_RAW_PARAM;
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(str), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.MiddleItemMicroView$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String headwearIcon;
                    String str2;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    MiddleItemMicroView.this.getMDataBinding().micUserHeadSvga.setTag(micBean.getEffectUrl());
                    SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                    MicroUserBean user = micBean.getUser();
                    if (user != null && (headwearIcon = user.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                        MicroUserBean user2 = micBean.getUser();
                        if (user2 == null || (str2 = user2.getHeadwearIcon()) == null) {
                            str2 = "";
                        }
                        DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str2, null, 2, null);
                    }
                    MiddleItemMicroView.this.getMDataBinding().micUserHeadSvga.stopAnimation(true);
                    MiddleItemMicroView.this.getMDataBinding().micUserHeadSvga.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                    MiddleItemMicroView.this.getMDataBinding().micUserHeadSvga.startAnimation();
                }

                public void onError() {
                    Log.e("MiddleItemMicroView", "Failed to decode SVG from URL: " + str);
                }
            });
        } catch (Exception e) {
            getMDataBinding().micUserHeadSvga.setTag("");
            DebugToolsKt.printfE(TAG, " 麦位头饰svga头饰加错出错 内部try()catch{}" + e.getLocalizedMessage());
        }
    }

    private final void resetViewToEmptyState() {
        getMDataBinding().lockMicro.setVisibility(8);
        getMDataBinding().userInfoLinearLayout.setVisibility(0);
        getMDataBinding().userTag.setVisibility(8);
        getMDataBinding().userName.setDefault(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
        getMDataBinding().userName.setText(String.valueOf(getMPosition()));
        getMDataBinding().userAvatar.setVisibility(8);
        getMDataBinding().userMute.setVisibility(8);
        getMDataBinding().userVip.setVisibility(8);
        getMDataBinding().iconNoble.setVisibility(8);
        getMDataBinding().baseMicro.setVisibility(0);
        getMDataBinding().speakWave.setVisibility(8);
        getMDataBinding().micUserHeadSvga.setVisibility(8);
        getMDataBinding().cpSvga.setVisibility(8);
        getMDataBinding().micUserHeadImg.setVisibility(8);
        getMDataBinding().personMicOff.setVisibility(8);
        getMDataBinding().micOff.setVisibility(8);
        getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiddleItemMicroView.resetViewToEmptyState$lambda$0(MiddleItemMicroView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resetViewToEmptyState$lambda$0(MiddleItemMicroView middleItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = middleItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(middleItemMicroView.getMPosition(), middleItemMicroView.getMMicBean());
        }
    }

    @NotNull
    public final ItemMiddleMicroViewBinding getMDataBinding() {
        ItemMiddleMicroViewBinding itemMiddleMicroViewBinding = this.mDataBinding;
        if (itemMiddleMicroViewBinding != null) {
            return itemMiddleMicroViewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void initView() {
        setMDataBinding((ItemMiddleMicroViewBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.item_middle_micro_view, this, true));
        setClipChildren(false);
        setClipToPadding(false);
        this.muteDrawable8 = androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute_8);
        this.muteDrawable = androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute);
        this.lockGoldDrawable = androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_lock_gold);
        this.lockDrawable = androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_lock);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMDataBinding().micUserHeadSvga.clear();
        getMDataBinding().cpSvga.clear();
        getMDataBinding().faceSvga.clear();
        getMDataBinding().unbind();
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void recoverMicSVGA() {
        MicroBean mMicBean = getMMicBean();
        if (mMicBean != null) {
            playSvga(mMicBean);
        }
    }

    public final void setMDataBinding(@NotNull ItemMiddleMicroViewBinding itemMiddleMicroViewBinding) {
        Intrinsics.checkNotNullParameter(itemMiddleMicroViewBinding, "<set-?>");
        this.mDataBinding = itemMiddleMicroViewBinding;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void showFaceSvga(@NotNull String faceSVGAUrl) {
        Intrinsics.checkNotNullParameter(faceSVGAUrl, "faceSVGAUrl");
        if (MeetingRoomManager.INSTANCE.checkGameMadel() || TextUtils.isEmpty(faceSVGAUrl)) {
            return;
        }
        try {
            final String str = faceSVGAUrl + SVGA_RAW_PARAM;
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(str), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.MiddleItemMicroView$showFaceSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    MiddleItemMicroView.this.getMDataBinding().faceSvga.setVideoItem(videoItem);
                    MiddleItemMicroView.this.getMDataBinding().faceSvga.startAnimation();
                }

                public void onError() {
                    Log.e("MiddleItemMicroView", "Failed to decode face SVG from URL: " + str);
                }
            });
        } catch (Exception e) {
            DebugToolsKt.printfE(TAG, "eventRelay 内部try()catch{}" + e.getLocalizedMessage());
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void showMicSpeakWaveAnim() {
        String str;
        int i;
        int i2;
        MicroUserBean user;
        MicroUserBean user2;
        MicroUserBean user3;
        MicroBean mMicBean = getMMicBean();
        if (mMicBean == null || !mMicBean.getMicForbid()) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            MicroBean mMicBean2 = getMMicBean();
            if (mMicBean2 == null || (user3 = mMicBean2.getUser()) == null || (str = user3.getExternalId()) == null) {
                str = "";
            }
            if (!meetingRoomManager.haveLocalMute(str) && !meetingRoomManager.checkGameMadel()) {
                MicroBean mMicBean3 = getMMicBean();
                if (mMicBean3 != null && (user2 = mMicBean3.getUser()) != null) {
                    i = user2.getNoble();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    PortraitAnimationView portraitAnimationView = getMDataBinding().speakWave;
                    UserService.Companion companion = UserService.INSTANCE;
                    MicroBean mMicBean4 = getMMicBean();
                    if (mMicBean4 != null && (user = mMicBean4.getUser()) != null) {
                        i2 = user.getNoble();
                    } else {
                        i2 = 0;
                    }
                    portraitAnimationView.setColor(UserService.Companion.getNobleColor$default(companion, i2, 0, 2, null));
                } else {
                    getMDataBinding().speakWave.setColor(androidx.core.content.a.getColor(getContext(), 2131101214));
                }
                getMDataBinding().speakWave.e();
            }
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void stopMicSVGA() {
        getMDataBinding().micUserHeadSvga.stopAnimation(true);
        getMDataBinding().cpSvga.stopAnimation(true);
        getMDataBinding().faceSvga.stopAnimation(true);
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void updateView() {
        Integer num;
        boolean z;
        boolean z2;
        int i;
        MicroUserBean user;
        MicroUserBean user2;
        Boolean music;
        MicroUserBean user3;
        ImageView imageView = getMDataBinding().emptyMicImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "emptyMicImage");
        SVGAImageView sVGAImageView = getMDataBinding().emptyMicSVGA;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "emptyMicSVGA");
        refreshEmptyMic(imageView, sVGAImageView);
        MicroBean mMicBean = getMMicBean();
        if (mMicBean != null && (user3 = mMicBean.getUser()) != null) {
            num = Integer.valueOf(user3.getNoble());
        } else {
            num = null;
        }
        SVGAImageView sVGAImageView2 = getMDataBinding().musicSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "musicSvga");
        MicroBean mMicBean2 = getMMicBean();
        int i2 = 0;
        if (mMicBean2 != null && (user2 = mMicBean2.getUser()) != null && (music = user2.getMusic()) != null) {
            z = music.booleanValue();
        } else {
            z = false;
        }
        MicroBean mMicBean3 = getMMicBean();
        if (mMicBean3 != null) {
            z2 = mMicBean3.getMicForbid();
        } else {
            z2 = false;
        }
        refreshMusicSvga(num, sVGAImageView2, z, z2);
        MicroBean mMicBean4 = getMMicBean();
        if (mMicBean4 != null && (user = mMicBean4.getUser()) != null) {
            i = user.getNoble();
        } else {
            i = 0;
        }
        if (i >= 8) {
            getMDataBinding().micOff.setImageDrawable(this.muteDrawable8);
        } else {
            getMDataBinding().micOff.setImageDrawable(this.muteDrawable);
        }
        Integer svipLevel = getSvipLevel();
        if (svipLevel != null) {
            i2 = svipLevel.intValue();
        }
        if (i2 >= 4) {
            getMDataBinding().lockMicro.setImageDrawable(this.lockGoldDrawable);
        } else {
            getMDataBinding().lockMicro.setImageDrawable(this.lockDrawable);
        }
        if (getMMicBean() == null) {
            resetViewToEmptyState();
        } else {
            handleNonEmptyMicBean();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiddleItemMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
