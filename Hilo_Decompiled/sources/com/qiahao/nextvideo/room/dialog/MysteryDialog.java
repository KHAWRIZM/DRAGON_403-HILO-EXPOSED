package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.model.svip.SvipInfo;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.DialogMysteryBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.dialog.MysteryDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.svip.SvipPrivilegesActivity;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\rJ\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\rJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u0014R$\u0010#\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0012R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010!\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u00100R\"\u00101\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010!\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u00100R\u0017\u00105\u001a\u0002048\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/MysteryDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogMysteryBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/base_common/model/common/User;", "user", "", "micPosition", "<init>", "(Landroid/content/Context;Lcom/qiahao/base_common/model/common/User;I)V", "", "toSVIPPrivileges", "()V", "operateMuteOrUnMuteMic", "", "isMute", "isShowMuteIcon", "(Z)V", "getLayoutResId", "()I", "isBottomStyle", "()Z", "onInitialize", "svipKillOut", "Lcom/qiahao/nextvideo/room/dialog/MysteryDialog$MysteryDialogListener;", "listener", "setListener", "(Lcom/qiahao/nextvideo/room/dialog/MysteryDialog$MysteryDialogListener;)Lcom/qiahao/nextvideo/room/dialog/MysteryDialog;", "dismiss", "Lcom/qiahao/base_common/model/common/User;", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "I", "getMicPosition", "mListener", "Lcom/qiahao/nextvideo/room/dialog/MysteryDialog$MysteryDialogListener;", "getMListener", "()Lcom/qiahao/nextvideo/room/dialog/MysteryDialog$MysteryDialogListener;", "setMListener", "(Lcom/qiahao/nextvideo/room/dialog/MysteryDialog$MysteryDialogListener;)V", "mIsMyself", "Z", "getMIsMyself", "setMIsMyself", "mUserRole", "getMUserRole", "setMUserRole", "(I)V", "mMyUserRole", "getMMyUserRole", "setMMyUserRole", "Lnd/a;", "mConpose", "Lnd/a;", "getMConpose", "()Lnd/a;", "MysteryDialogListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMysteryDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MysteryDialog.kt\ncom/qiahao/nextvideo/room/dialog/MysteryDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,233:1\n61#2,9:234\n61#2,9:243\n61#2,9:252\n61#2,9:261\n*S KotlinDebug\n*F\n+ 1 MysteryDialog.kt\ncom/qiahao/nextvideo/room/dialog/MysteryDialog\n*L\n85#1:234,9\n89#1:243,9\n96#1:252,9\n111#1:261,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MysteryDialog extends BaseBindingDialog<DialogMysteryBinding> {

    @NotNull
    private final nd.a mConpose;
    private boolean mIsMyself;

    @Nullable
    private MysteryDialogListener mListener;
    private int mMyUserRole;
    private int mUserRole;
    private final int micPosition;

    @Nullable
    private final User user;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/MysteryDialog$MysteryDialogListener;", "", "unMuteMic", "", "micPosition", "", "muteMic", "isMyself", "", "downMic", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface MysteryDialogListener {
        void downMic(int micPosition);

        void muteMic(int micPosition, boolean isMyself);

        void unMuteMic(int micPosition);
    }

    public /* synthetic */ MysteryDialog(Context context, User user, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : user, (i2 & 4) != 0 ? -1 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void isShowMuteIcon(boolean isMute) {
        int i;
        if (isMute && !this.mIsMyself) {
            ((DialogMysteryBinding) getBinding()).openMic.setVisibility(8);
        } else {
            ((DialogMysteryBinding) getBinding()).openMic.setVisibility(0);
        }
        ImageView imageView = ((DialogMysteryBinding) getBinding()).openMic;
        Context context = getContext();
        if (isMute) {
            i = R.drawable.icon_user_un_mute_mic;
        } else {
            i = R.drawable.icon_user_mute_mic;
        }
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void operateMuteOrUnMuteMic() {
        MysteryDialogListener mysteryDialogListener;
        boolean z = false;
        MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(this.micPosition));
        if (microBean != null) {
            z = Intrinsics.areEqual(microBean.getForbid(), Boolean.TRUE);
        }
        if (z) {
            if (this.mIsMyself && (mysteryDialogListener = this.mListener) != null) {
                mysteryDialogListener.unMuteMic(this.micPosition);
                return;
            }
            return;
        }
        boolean z2 = this.mIsMyself;
        if (z2) {
            MysteryDialogListener mysteryDialogListener2 = this.mListener;
            if (mysteryDialogListener2 != null) {
                mysteryDialogListener2.muteMic(this.micPosition, z2);
                return;
            }
            return;
        }
        if (this.mMyUserRole > this.mUserRole) {
            MysteryDialogListener mysteryDialogListener3 = this.mListener;
            if (mysteryDialogListener3 != null) {
                mysteryDialogListener3.muteMic(this.micPosition, z2);
                return;
            }
            return;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952966), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit svipKillOut$lambda$5(MysteryDialog mysteryDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, mysteryDialog.getContext(), ResourcesKtxKt.getStringById(mysteryDialog, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            mysteryDialog.dismiss();
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, mysteryDialog.getContext(), ResourcesKtxKt.getStringById(mysteryDialog, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit svipKillOut$lambda$6(MysteryDialog mysteryDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 21002) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, mysteryDialog.getContext(), ResourcesKtxKt.getStringById(mysteryDialog, 2131953533), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = mysteryDialog.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(mysteryDialog, 2131952667);
                } else {
                    str = errorMessage;
                }
                Toast normal$default2 = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            }
        } else {
            Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, mysteryDialog.getContext(), ResourcesKtxKt.getStringById(mysteryDialog, 2131952667), false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void toSVIPPrivileges() {
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(getContext());
        if (activity != null) {
            ILoading.DefaultImpls.showLoading$default(activity, (Integer) null, (CharSequence) null, 3, (Object) null);
        }
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getSvipInfo(), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.x0
            public final Object invoke(Object obj) {
                Unit sVIPPrivileges$lambda$8;
                sVIPPrivileges$lambda$8 = MysteryDialog.toSVIPPrivileges$lambda$8(MysteryDialog.this, (ApiResponse) obj);
                return sVIPPrivileges$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.y0
            public final Object invoke(Object obj) {
                Unit sVIPPrivileges$lambda$9;
                sVIPPrivileges$lambda$9 = MysteryDialog.toSVIPPrivileges$lambda$9(MysteryDialog.this, (Throwable) obj);
                return sVIPPrivileges$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit toSVIPPrivileges$lambda$8(MysteryDialog mysteryDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(mysteryDialog.getContext());
        if (activity != null) {
            ILoading.DefaultImpls.dismissLoading$default(activity, (Integer) null, 1, (Object) null);
        }
        SvipInfo svipInfo = (SvipInfo) apiResponse.getData();
        if (svipInfo != null) {
            Intent intent = new Intent(mysteryDialog.getContext(), (Class<?>) SvipPrivilegesActivity.class);
            intent.putExtra("data", BaseApplication.Companion.getGSON().s(svipInfo));
            intent.putExtra("type", 17);
            mysteryDialog.getContext().startActivity(intent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit toSVIPPrivileges$lambda$9(MysteryDialog mysteryDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        BaseActivity activity = HiloUtils.INSTANCE.getActivity(mysteryDialog.getContext());
        if (activity != null) {
            ILoading.DefaultImpls.dismissLoading$default(activity, (Integer) null, 1, (Object) null);
        }
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = mysteryDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(mysteryDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super.dismiss();
        this.mConpose.d();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_mystery;
    }

    @NotNull
    public final nd.a getMConpose() {
        return this.mConpose;
    }

    public final boolean getMIsMyself() {
        return this.mIsMyself;
    }

    @Nullable
    public final MysteryDialogListener getMListener() {
        return this.mListener;
    }

    public final int getMMyUserRole() {
        return this.mMyUserRole;
    }

    public final int getMUserRole() {
        return this.mUserRole;
    }

    public final int getMicPosition() {
        return this.micPosition;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        String str;
        int i;
        String str2;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        boolean z = false;
        setBackgroundDimEnabled(false);
        User user = this.user;
        if (user != null) {
            AppCompatImageView appCompatImageView = ((DialogMysteryBinding) getBinding()).userAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
            ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            NickTextView nickTextView = ((DialogMysteryBinding) getBinding()).title;
            String stringById = ResourcesKtxKt.getStringById(user, 2131953504);
            SvipData svip = user.getSvip();
            if (svip != null) {
                str = svip.mysteryNumber();
            } else {
                str = null;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            SvipData svip2 = this.user.getSvip();
            if (svip2 != null) {
                i = svip2.getSvipLevel();
            } else {
                i = 0;
            }
            nickTextView.setTextAndVipLevel(format, i);
            ImageView imageView = ((DialogMysteryBinding) getBinding()).userHeadImg;
            Intrinsics.checkNotNullExpressionValue(imageView, "userHeadImg");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.mystery_header_frame), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            String externalId = this.user.getExternalId();
            UserStore.Companion companion = UserStore.INSTANCE;
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                str2 = user2.getExternalId();
            } else {
                str2 = null;
            }
            this.mIsMyself = Intrinsics.areEqual(externalId, str2);
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            this.mUserRole = meetingRoomManager.getRoomUserRole(user.getExternalId());
            User user3 = companion.getShared().getUser();
            Intrinsics.checkNotNull(user3);
            this.mMyUserRole = meetingRoomManager.getRoomUserRole(user3.getExternalId());
            User user4 = companion.getShared().getUser();
            Intrinsics.checkNotNull(user4);
            if (user4.isOfficialStaff()) {
                this.mMyUserRole = 1000;
            }
        }
        if (this.mIsMyself) {
            if (this.micPosition > 0) {
                ((DialogMysteryBinding) getBinding()).buttonLayout.setVisibility(0);
                MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(this.micPosition));
                if (microBean != null) {
                    z = Intrinsics.areEqual(microBean.getForbid(), Boolean.TRUE);
                }
                isShowMuteIcon(z);
            }
        } else if (this.mMyUserRole >= 10) {
            ((DialogMysteryBinding) getBinding()).exit.setVisibility(0);
        } else {
            ((DialogMysteryBinding) getBinding()).exit.setVisibility(8);
        }
        final ImageView imageView2 = ((DialogMysteryBinding) getBinding()).openMic;
        final long j = 800;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.MysteryDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    this.operateMuteOrUnMuteMic();
                    this.dismiss();
                }
            }
        });
        final ImageView imageView3 = ((DialogMysteryBinding) getBinding()).downMic;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.MysteryDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MysteryDialog.MysteryDialogListener mListener;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                    if (this.getMIsMyself() && (mListener = this.getMListener()) != null) {
                        mListener.downMic(this.getMicPosition());
                    }
                    this.dismiss();
                }
            }
        });
        final ImageView imageView4 = ((DialogMysteryBinding) getBinding()).exit;
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.MysteryDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2;
                SvipData svip3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                    User user5 = UserStore.INSTANCE.getShared().getUser();
                    if (user5 != null && (svip3 = user5.getSvip()) != null) {
                        i2 = svip3.getSvipLevel();
                    } else {
                        i2 = 0;
                    }
                    if (i2 >= 7) {
                        Context context = this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        RoomTipDialog tipContent = new RoomTipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953502));
                        final MysteryDialog mysteryDialog = this;
                        tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.MysteryDialog$onInitialize$4$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                MysteryDialog.this.svipKillOut();
                            }
                        }).show();
                        return;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131953503), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        });
        final TextView textView = ((DialogMysteryBinding) getBinding()).checkDetails;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.MysteryDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    this.toSVIPPrivileges();
                }
            }
        });
    }

    @NotNull
    public final MysteryDialog setListener(@NotNull MysteryDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
        return this;
    }

    public final void setMIsMyself(boolean z) {
        this.mIsMyself = z;
    }

    public final void setMListener(@Nullable MysteryDialogListener mysteryDialogListener) {
        this.mListener = mysteryDialogListener;
    }

    public final void setMMyUserRole(int i) {
        this.mMyUserRole = i;
    }

    public final void setMUserRole(int i) {
        this.mUserRole = i;
    }

    public final void svipKillOut() {
        String str;
        GroupService companion = GroupService.INSTANCE.getInstance();
        String mGroupId = MeetingRoomManager.INSTANCE.getMGroupId();
        User user = this.user;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(companion.groupBlockListAddUser(mGroupId, str, true, false), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.v0
            public final Object invoke(Object obj) {
                Unit svipKillOut$lambda$5;
                svipKillOut$lambda$5 = MysteryDialog.svipKillOut$lambda$5(MysteryDialog.this, (ApiResponse) obj);
                return svipKillOut$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.w0
            public final Object invoke(Object obj) {
                Unit svipKillOut$lambda$6;
                svipKillOut$lambda$6 = MysteryDialog.svipKillOut$lambda$6(MysteryDialog.this, (Throwable) obj);
                return svipKillOut$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), this.mConpose);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MysteryDialog(@NotNull Context context, @Nullable User user, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.user = user;
        this.micPosition = i;
        this.mConpose = new nd.a();
    }
}
