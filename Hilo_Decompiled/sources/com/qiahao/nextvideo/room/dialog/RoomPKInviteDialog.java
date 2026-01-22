package com.qiahao.nextvideo.room.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.room.PKInviteCancel;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.databinding.DialogRoomPkInviteBinding;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.viewmodel.RoomPKViewModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0019\u001a\u00020\u0014H\u0014J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomPKInviteDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/DialogRoomPkInviteBinding;", "data", "Lcom/qiahao/nextvideo/data/room/RoomPK;", "pkData", "Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "<init>", "(Lcom/qiahao/nextvideo/data/room/RoomPK;Lcom/qiahao/nextvideo/data/room/PKInviteCancel;)V", "getData", "()Lcom/qiahao/nextvideo/data/room/RoomPK;", "getPkData", "()Lcom/qiahao/nextvideo/data/room/PKInviteCancel;", "viewModel", "Lcom/qiahao/nextvideo/room/viewmodel/RoomPKViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/RoomPKViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mCount", "", "getMCount", "()I", "setMCount", "(I)V", "getLayoutResId", "getGravity", "onStart", "", "onInitialize", "initView", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomPKInviteDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomPKInviteDialog.kt\ncom/qiahao/nextvideo/room/dialog/RoomPKInviteDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,252:1\n61#2,9:253\n61#2,9:262\n61#2,9:271\n*S KotlinDebug\n*F\n+ 1 RoomPKInviteDialog.kt\ncom/qiahao/nextvideo/room/dialog/RoomPKInviteDialog\n*L\n113#1:253,9\n155#1:262,9\n162#1:271,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomPKInviteDialog extends BaseBindingDialogFragment<DialogRoomPkInviteBinding> {

    @Nullable
    private final RoomPK data;
    private int mCount;

    @Nullable
    private final PKInviteCancel pkData;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomPKInviteDialog() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final void initView() {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        int i2;
        Drawable drawable;
        int i3;
        long j;
        long j2;
        CharSequence valueOf;
        Long birthDay;
        long j3;
        int i4;
        String str5;
        String str6;
        int i5;
        int i6;
        Integer num;
        Integer svipLevel;
        Long birthDay2;
        Long birthDay3;
        Resources resources;
        boolean z;
        Integer gameId;
        String str7;
        String str8;
        String str9;
        String str10;
        Drawable drawable2;
        int i7;
        long j4;
        CharSequence valueOf2;
        Long birthDay4;
        String str11;
        int i8;
        Integer num2;
        Integer svipLevel2;
        Long birthDay5;
        Resources resources2;
        Integer gameId2;
        boolean z2 = true;
        ((DialogRoomPkInviteBinding) getBinding()).pkSearch.startAnimation();
        ImageView imageView = ((DialogRoomPkInviteBinding) getBinding()).blueBg;
        Intrinsics.checkNotNullExpressionValue(imageView, "blueBg");
        ImageKtxKt.toHorizontalMirror(imageView, R.drawable.pk_invite_blue);
        ImageView imageView2 = ((DialogRoomPkInviteBinding) getBinding()).redBg;
        Intrinsics.checkNotNullExpressionValue(imageView2, "redBg");
        ImageKtxKt.toHorizontalMirror(imageView2, R.drawable.pk_invite_red);
        TextView textView = ((DialogRoomPkInviteBinding) getBinding()).title;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        ImageKtxKt.toHorizontalMirror(textView, R.drawable.pk_invite_top_bg);
        ConstraintLayout constraintLayout = ((DialogRoomPkInviteBinding) getBinding()).constraint;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "constraint");
        ImageKtxKt.toHorizontalMirror(constraintLayout, R.drawable.pk_invite_bg);
        PKInviteCancel pKInviteCancel = this.pkData;
        if (pKInviteCancel != null && (gameId2 = pKInviteCancel.getGameId()) != null && gameId2.intValue() == 25) {
            ((DialogRoomPkInviteBinding) getBinding()).accept.setText(ResourcesKtxKt.getStringById(this, 2131954162));
        }
        RoomPK roomPK = this.data;
        int i9 = R.drawable.icon_girl;
        final long j5 = 800;
        long j6 = 0;
        Drawable drawable3 = null;
        if (roomPK != null) {
            QMUIRadiusImageView qMUIRadiusImageView = ((DialogRoomPkInviteBinding) getBinding()).leftAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "leftAvatar");
            GroupDetailBean inviteGroup = this.data.getInviteGroup();
            if (inviteGroup != null) {
                str7 = inviteGroup.getFaceUrl();
            } else {
                str7 = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, str7, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            TextView textView2 = ((DialogRoomPkInviteBinding) getBinding()).leftName;
            GroupDetailBean inviteGroup2 = this.data.getInviteGroup();
            if (inviteGroup2 != null) {
                str8 = inviteGroup2.getName();
            } else {
                str8 = null;
            }
            textView2.setText(str8);
            TextView textView3 = ((DialogRoomPkInviteBinding) getBinding()).leftId;
            String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
            GroupDetailBean inviteGroup3 = this.data.getInviteGroup();
            if (inviteGroup3 != null) {
                str9 = inviteGroup3.getCode();
            } else {
                str9 = null;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str9}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView3.setText(format);
            QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogRoomPkInviteBinding) getBinding()).rightAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "rightAvatar");
            GroupDetailBean receiveGroup = this.data.getReceiveGroup();
            if (receiveGroup != null) {
                str10 = receiveGroup.getFaceUrl();
            } else {
                str10 = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str10, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            ((DialogRoomPkInviteBinding) getBinding()).title.setText(ResourcesKtxKt.getStringById(this, 2131953964));
            GenderAgeTextView genderAgeTextView = ((DialogRoomPkInviteBinding) getBinding()).ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
            Context context = getContext();
            if (context != null && (resources2 = context.getResources()) != null) {
                PKInviteCancel pkExternalData = this.data.getPkExternalData();
                if (pkExternalData != null && pkExternalData.getSex() == 1) {
                    i9 = R.drawable.icon_boy;
                }
                drawable2 = ResourceUtilsKt.getDrawable(resources2, i9, 0);
            } else {
                drawable2 = null;
            }
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, drawable2);
            GenderAgeTextView genderAgeTextView2 = ((DialogRoomPkInviteBinding) getBinding()).ageTextView;
            PKInviteCancel pkExternalData2 = this.data.getPkExternalData();
            if (pkExternalData2 != null && pkExternalData2.getSex() == 1) {
                i7 = R.drawable.bg_age_male;
            } else {
                i7 = R.drawable.bg_age_female;
            }
            genderAgeTextView2.setBackgroundResource(i7);
            AppCompatTextView appCompatTextView = ((DialogRoomPkInviteBinding) getBinding()).ageTextView;
            PKInviteCancel pkExternalData3 = this.data.getPkExternalData();
            if (pkExternalData3 != null && (birthDay5 = pkExternalData3.getBirthDay()) != null) {
                j4 = birthDay5.longValue();
            } else {
                j4 = 0;
            }
            if (j4 <= 0) {
                valueOf2 = MessageService.MSG_DB_READY_REPORT;
            } else {
                long constantTimeSecs = DateTimeUtilityKt.getConstantTimeSecs();
                PKInviteCancel pkExternalData4 = this.data.getPkExternalData();
                if (pkExternalData4 != null && (birthDay4 = pkExternalData4.getBirthDay()) != null) {
                    j6 = birthDay4.longValue();
                }
                valueOf2 = String.valueOf((constantTimeSecs - j6) / 31536000);
            }
            appCompatTextView.setText(valueOf2);
            ImageView imageView3 = ((DialogRoomPkInviteBinding) getBinding()).countryImg;
            Intrinsics.checkNotNullExpressionValue(imageView3, "countryImg");
            PKInviteCancel pkExternalData5 = this.data.getPkExternalData();
            if (pkExternalData5 != null) {
                str11 = pkExternalData5.getCountry();
            } else {
                str11 = null;
            }
            ImageKtxKt.loadImage$default(imageView3, str11, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            PKInviteCancel pkExternalData6 = this.data.getPkExternalData();
            if (pkExternalData6 != null && (svipLevel2 = pkExternalData6.getSvipLevel()) != null) {
                i8 = svipLevel2.intValue();
            } else {
                i8 = 0;
            }
            if (i8 > 0) {
                SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                PKInviteCancel pkExternalData7 = this.data.getPkExternalData();
                if (pkExternalData7 != null) {
                    num2 = pkExternalData7.getSvipLevel();
                } else {
                    num2 = null;
                }
                Integer svipType = svipTypeUtils.getSvipType(num2);
                if (svipType != null) {
                    int intValue = svipType.intValue();
                    ((DialogRoomPkInviteBinding) getBinding()).svipType.setVisibility(0);
                    ImageView imageView4 = ((DialogRoomPkInviteBinding) getBinding()).svipType;
                    Context context2 = getContext();
                    if (context2 != null) {
                        drawable3 = androidx.core.content.a.getDrawable(context2, intValue);
                    }
                    imageView4.setImageDrawable(drawable3);
                }
            } else {
                ((DialogRoomPkInviteBinding) getBinding()).svipType.setVisibility(8);
            }
            ((DialogRoomPkInviteBinding) getBinding()).ageTextView.setVisibility(8);
            final QMUIRadiusImageView qMUIRadiusImageView3 = ((DialogRoomPkInviteBinding) getBinding()).leftAvatar;
            qMUIRadiusImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKInviteDialog$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str12;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView3) > j5 || (qMUIRadiusImageView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(qMUIRadiusImageView3, currentTimeMillis);
                        QMUIRadiusImageView qMUIRadiusImageView4 = qMUIRadiusImageView3;
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        PKInviteCancel pkExternalData8 = this.getData().getPkExternalData();
                        if (pkExternalData8 == null || (str12 = pkExternalData8.getExternalId()) == null) {
                            str12 = "";
                        }
                        baseControlUtils.openPersonPage(str12);
                    }
                }
            });
        } else {
            QMUIRadiusImageView qMUIRadiusImageView4 = ((DialogRoomPkInviteBinding) getBinding()).leftAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView4, "leftAvatar");
            PKInviteCancel pKInviteCancel2 = this.pkData;
            if (pKInviteCancel2 != null) {
                str = pKInviteCancel2.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView4, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            TextView textView4 = ((DialogRoomPkInviteBinding) getBinding()).leftName;
            PKInviteCancel pKInviteCancel3 = this.pkData;
            if (pKInviteCancel3 != null) {
                str2 = pKInviteCancel3.getName();
            } else {
                str2 = null;
            }
            textView4.setText(str2);
            TextView textView5 = ((DialogRoomPkInviteBinding) getBinding()).leftId;
            String stringById2 = ResourcesKtxKt.getStringById(this, 2131953102);
            PKInviteCancel pKInviteCancel4 = this.pkData;
            if (pKInviteCancel4 != null) {
                str3 = pKInviteCancel4.getCode();
            } else {
                str3 = null;
            }
            String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{str3}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView5.setText(format2);
            TextView textView6 = ((DialogRoomPkInviteBinding) getBinding()).leftId;
            PKInviteCancel pKInviteCancel5 = this.pkData;
            if (pKInviteCancel5 != null) {
                str4 = pKInviteCancel5.getCode();
            } else {
                str4 = null;
            }
            if (TextUtils.isEmpty(str4)) {
                i = 4;
            } else {
                i = 0;
            }
            textView6.setVisibility(i);
            TextView textView7 = ((DialogRoomPkInviteBinding) getBinding()).title;
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            PKInviteCancel pKInviteCancel6 = this.pkData;
            if (pKInviteCancel6 != null && (gameId = pKInviteCancel6.getGameId()) != null) {
                i2 = gameId.intValue();
            } else {
                i2 = 0;
            }
            textView7.setText(meetingRoomManager.getRoomPKTitle(i2));
            GenderAgeTextView genderAgeTextView3 = ((DialogRoomPkInviteBinding) getBinding()).ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView3, "ageTextView");
            Context context3 = getContext();
            if (context3 != null && (resources = context3.getResources()) != null) {
                PKInviteCancel pKInviteCancel7 = this.pkData;
                if (pKInviteCancel7 != null && pKInviteCancel7.getSex() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i9 = R.drawable.icon_boy;
                }
                drawable = ResourceUtilsKt.getDrawable(resources, i9, 0);
            } else {
                drawable = null;
            }
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView3, drawable);
            GenderAgeTextView genderAgeTextView4 = ((DialogRoomPkInviteBinding) getBinding()).ageTextView;
            PKInviteCancel pKInviteCancel8 = this.pkData;
            if (pKInviteCancel8 == null || pKInviteCancel8.getSex() != 1) {
                z2 = false;
            }
            if (z2) {
                i3 = R.drawable.bg_age_male;
            } else {
                i3 = R.drawable.bg_age_female;
            }
            genderAgeTextView4.setBackgroundResource(i3);
            AppCompatTextView appCompatTextView2 = ((DialogRoomPkInviteBinding) getBinding()).ageTextView;
            PKInviteCancel pKInviteCancel9 = this.pkData;
            if (pKInviteCancel9 != null && (birthDay3 = pKInviteCancel9.getBirthDay()) != null) {
                j = birthDay3.longValue();
            } else {
                j = 0;
            }
            if (j <= 0) {
                valueOf = "";
            } else {
                long constantTimeSecs2 = DateTimeUtilityKt.getConstantTimeSecs();
                PKInviteCancel pKInviteCancel10 = this.pkData;
                if (pKInviteCancel10 != null && (birthDay = pKInviteCancel10.getBirthDay()) != null) {
                    j2 = birthDay.longValue();
                } else {
                    j2 = 0;
                }
                valueOf = String.valueOf((constantTimeSecs2 - j2) / 31536000);
            }
            appCompatTextView2.setText(valueOf);
            AppCompatTextView appCompatTextView3 = ((DialogRoomPkInviteBinding) getBinding()).ageTextView;
            PKInviteCancel pKInviteCancel11 = this.pkData;
            if (pKInviteCancel11 != null && (birthDay2 = pKInviteCancel11.getBirthDay()) != null) {
                j3 = birthDay2.longValue();
            } else {
                j3 = 0;
            }
            if (j3 <= 0) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            appCompatTextView3.setVisibility(i4);
            ImageView imageView5 = ((DialogRoomPkInviteBinding) getBinding()).countryImg;
            Intrinsics.checkNotNullExpressionValue(imageView5, "countryImg");
            PKInviteCancel pKInviteCancel12 = this.pkData;
            if (pKInviteCancel12 != null) {
                str5 = pKInviteCancel12.getCountry();
            } else {
                str5 = null;
            }
            ImageKtxKt.loadImage$default(imageView5, str5, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            ImageView imageView6 = ((DialogRoomPkInviteBinding) getBinding()).countryImg;
            PKInviteCancel pKInviteCancel13 = this.pkData;
            if (pKInviteCancel13 != null) {
                str6 = pKInviteCancel13.getCountry();
            } else {
                str6 = null;
            }
            if (TextUtils.isEmpty(str6)) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            imageView6.setVisibility(i5);
            PKInviteCancel pKInviteCancel14 = this.pkData;
            if (pKInviteCancel14 != null && (svipLevel = pKInviteCancel14.getSvipLevel()) != null) {
                i6 = svipLevel.intValue();
            } else {
                i6 = 0;
            }
            if (i6 > 0) {
                SvipTypeUtils svipTypeUtils2 = SvipTypeUtils.INSTANCE;
                PKInviteCancel pKInviteCancel15 = this.pkData;
                if (pKInviteCancel15 != null) {
                    num = pKInviteCancel15.getSvipLevel();
                } else {
                    num = null;
                }
                Integer svipType2 = svipTypeUtils2.getSvipType(num);
                if (svipType2 != null) {
                    int intValue2 = svipType2.intValue();
                    ((DialogRoomPkInviteBinding) getBinding()).svipType.setVisibility(0);
                    ImageView imageView7 = ((DialogRoomPkInviteBinding) getBinding()).svipType;
                    Context context4 = getContext();
                    if (context4 != null) {
                        drawable3 = androidx.core.content.a.getDrawable(context4, intValue2);
                    }
                    imageView7.setImageDrawable(drawable3);
                }
            } else {
                ((DialogRoomPkInviteBinding) getBinding()).svipType.setVisibility(8);
            }
            final QMUIRadiusImageView qMUIRadiusImageView5 = ((DialogRoomPkInviteBinding) getBinding()).leftAvatar;
            qMUIRadiusImageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKInviteDialog$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str12;
                    Integer gameId3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView5) > j5 || (qMUIRadiusImageView5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(qMUIRadiusImageView5, currentTimeMillis);
                        QMUIRadiusImageView qMUIRadiusImageView6 = qMUIRadiusImageView5;
                        PKInviteCancel pkData = this.getPkData();
                        if (pkData == null || (gameId3 = pkData.getGameId()) == null || gameId3.intValue() != 25) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            PKInviteCancel pkData2 = this.getPkData();
                            if (pkData2 == null || (str12 = pkData2.getExternalId()) == null) {
                                str12 = "";
                            }
                            baseControlUtils.openPersonPage(str12);
                        }
                    }
                }
            });
        }
        final TextView textView8 = ((DialogRoomPkInviteBinding) getBinding()).accept;
        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKInviteDialog$initView$$inlined$singleClick$default$3
            /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str12;
                String groupId;
                int i10;
                int i11;
                int i12;
                Integer gameType;
                Integer mode;
                Integer gameId3;
                Integer gameId4;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView8) > j5 || (textView8 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView8, currentTimeMillis);
                    String str13 = "";
                    if (this.getData() == null) {
                        PKInviteCancel pkData = this.getPkData();
                        if (pkData != null && (gameId4 = pkData.getGameId()) != null && gameId4.intValue() == 25) {
                            if (this.getMCount() <= 0) {
                                RoomPKInviteDialog roomPKInviteDialog = this;
                                roomPKInviteDialog.setMCount(roomPKInviteDialog.getMCount() + 1);
                                RoomPKViewModel viewModel = this.getViewModel();
                                String externalId = this.getPkData().getExternalId();
                                if (externalId != null) {
                                    str13 = externalId;
                                }
                                viewModel.acceptStrangeChat(str13);
                                return;
                            }
                            return;
                        }
                        GameJum gameJum = GameJum.INSTANCE;
                        PKInviteCancel pkData2 = this.getPkData();
                        if (pkData2 != null && (gameId3 = pkData2.getGameId()) != null) {
                            i10 = gameId3.intValue();
                        } else {
                            i10 = 0;
                        }
                        PKInviteCancel pkData3 = this.getPkData();
                        if (pkData3 != null && (mode = pkData3.getMode()) != null) {
                            i11 = mode.intValue();
                        } else {
                            i11 = 0;
                        }
                        PKInviteCancel pkData4 = this.getPkData();
                        if (pkData4 != null && (gameType = pkData4.getGameType()) != null) {
                            i12 = gameType.intValue();
                        } else {
                            i12 = 0;
                        }
                        GameJum.matchGame$default(gameJum, 0, i10, i11, i12, MeetingRoomManager.INSTANCE.getMGroupId(), 1, null);
                        return;
                    }
                    MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                    if (meetingRoomManager2.getMLudoGameData() == null && meetingRoomManager2.getMUnoGameData() == null && meetingRoomManager2.getMDominoGameData() == null && meetingRoomManager2.getMCrushGameData() == null) {
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user != null) {
                            str12 = user.getExternalId();
                        } else {
                            str12 = null;
                        }
                        if (meetingRoomManager2.checkUserOnMic(str12)) {
                            RoomPKViewModel viewModel2 = this.getViewModel();
                            String mGroupId = meetingRoomManager2.getMGroupId();
                            GroupDetailBean inviteGroup4 = this.getData().getInviteGroup();
                            if (inviteGroup4 != null && (groupId = inviteGroup4.getGroupId()) != null) {
                                str13 = groupId;
                            }
                            viewModel2.acceptPK(mGroupId, str13);
                            return;
                        }
                        Context context5 = this.getContext();
                        if (context5 != null) {
                            ?? commonTextDialog = new CommonTextDialog(context5, 0.0f, 2, null);
                            String stringById3 = ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131953654);
                            final RoomPKInviteDialog roomPKInviteDialog2 = this;
                            commonTextDialog.setContentText(stringById3, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomPKInviteDialog$initView$7$1$1$1
                                public void cancel() {
                                }

                                public void confirm() {
                                    RoomPKViewModel.upMic$default(RoomPKInviteDialog.this.getViewModel(), null, false, 2, null);
                                }
                            });
                            commonTextDialog.show();
                            return;
                        }
                        return;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131953653), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                    this.dismiss();
                }
            }
        });
        getViewModel().getMException().observe(this, new RoomPKInviteDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.u3
            public final Object invoke(Object obj) {
                Unit initView$lambda$13;
                initView$lambda$13 = RoomPKInviteDialog.initView$lambda$13(RoomPKInviteDialog.this, (Pair) obj);
                return initView$lambda$13;
            }
        }));
        getViewModel().getMSuccess().observe(this, new RoomPKInviteDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.dialog.v3
            public final Object invoke(Object obj) {
                Unit initView$lambda$15;
                initView$lambda$15 = RoomPKInviteDialog.initView$lambda$15(RoomPKInviteDialog.this, (Pair) obj);
                return initView$lambda$15;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$13(RoomPKInviteDialog roomPKInviteDialog, Pair pair) {
        if (pair.getSecond() instanceof HiloException) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloException hiloException = (HiloException) second;
            if (hiloException.getCode() == 27058) {
                MeetingRoomManager.INSTANCE.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.ROOM_PK_INVITE_OR_CANCEL, new PKInviteCancel(2, 22, null, null, null, null, null, null, null, null, null, 0, null, 8188, null)));
            }
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = roomPKInviteDialog.getContext();
            String errorMessage = hiloException.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(roomPKInviteDialog, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        if (Intrinsics.areEqual(pair.getFirst(), RoomPKViewModel.STRANGE_CHAT)) {
            roomPKInviteDialog.mCount = 0;
        }
        roomPKInviteDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$15(final RoomPKInviteDialog roomPKInviteDialog, Pair pair) {
        String externalId;
        GroupDetailBean inviteGroup;
        String groupId;
        String str = (String) pair.getFirst();
        String str2 = "";
        if (Intrinsics.areEqual(str, RoomPKViewModel.PK_AUTO_MIC)) {
            RoomPKViewModel viewModel = roomPKInviteDialog.getViewModel();
            String mGroupId = MeetingRoomManager.INSTANCE.getMGroupId();
            RoomPK roomPK = roomPKInviteDialog.data;
            if (roomPK != null && (inviteGroup = roomPK.getInviteGroup()) != null && (groupId = inviteGroup.getGroupId()) != null) {
                str2 = groupId;
            }
            viewModel.acceptPK(mGroupId, str2);
        } else if (Intrinsics.areEqual(str, RoomPKViewModel.STRANGE_CHAT)) {
            if (pair.getSecond() instanceof String) {
                Object second = pair.getSecond();
                Intrinsics.checkNotNull(second, "null cannot be cast to non-null type kotlin.String");
                String str3 = (String) second;
                AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                PKInviteCancel pKInviteCancel = roomPKInviteDialog.pkData;
                if (pKInviteCancel != null && (externalId = pKInviteCancel.getExternalId()) != null) {
                    str2 = externalId;
                }
                appRequestUtils.openStrangeChatActivity(str2, true, str3, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.s3
                    public final Object invoke(Object obj) {
                        Unit initView$lambda$15$lambda$14;
                        initView$lambda$15$lambda$14 = RoomPKInviteDialog.initView$lambda$15$lambda$14(RoomPKInviteDialog.this, ((Boolean) obj).booleanValue());
                        return initView$lambda$15$lambda$14;
                    }
                });
            }
        } else {
            roomPKInviteDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$15$lambda$14(RoomPKInviteDialog roomPKInviteDialog, boolean z) {
        roomPKInviteDialog.mCount = 0;
        roomPKInviteDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomPKViewModel viewModel_delegate$lambda$0(RoomPKInviteDialog roomPKInviteDialog) {
        return new ViewModelProvider(roomPKInviteDialog).get(RoomPKViewModel.class);
    }

    @Nullable
    public final RoomPK getData() {
        return this.data;
    }

    protected int getGravity() {
        return 80;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_room_pk_invite;
    }

    public final int getMCount() {
        return this.mCount;
    }

    @Nullable
    public final PKInviteCancel getPkData() {
        return this.pkData;
    }

    @NotNull
    public final RoomPKViewModel getViewModel() {
        return (RoomPKViewModel) this.viewModel.getValue();
    }

    public void onDestroy() {
        ((DialogRoomPkInviteBinding) getBinding()).pkSearch.stopAnimation();
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onDestroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        initView();
    }

    public void onStart() {
        Window window;
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public final void setMCount(int i) {
        this.mCount = i;
    }

    public /* synthetic */ RoomPKInviteDialog(RoomPK roomPK, PKInviteCancel pKInviteCancel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : roomPK, (i & 2) != 0 ? null : pKInviteCancel);
    }

    public RoomPKInviteDialog(@Nullable RoomPK roomPK, @Nullable PKInviteCancel pKInviteCancel) {
        this.data = roomPK;
        this.pkData = pKInviteCancel;
        this.viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.t3
            public final Object invoke() {
                RoomPKViewModel viewModel_delegate$lambda$0;
                viewModel_delegate$lambda$0 = RoomPKInviteDialog.viewModel_delegate$lambda$0(RoomPKInviteDialog.this);
                return viewModel_delegate$lambda$0;
            }
        });
    }
}
