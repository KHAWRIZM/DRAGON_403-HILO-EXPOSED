package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.DialogRoomToolBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/RoomToolDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogRoomToolBinding;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "mListener", "Lcom/qiahao/nextvideo/room/dialog/RoomGamePanelListener;", "getMListener", "()Lcom/qiahao/nextvideo/room/dialog/RoomGamePanelListener;", "setMListener", "(Lcom/qiahao/nextvideo/room/dialog/RoomGamePanelListener;)V", "noiseReduction", "", "getLayoutResId", "", "isBottomStyle", "onInitialize", "", "dismiss", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomToolDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomToolDialog.kt\ncom/qiahao/nextvideo/room/dialog/RoomToolDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,71:1\n61#2,9:72\n61#2,9:81\n61#2,9:90\n61#2,9:99\n61#2,9:108\n61#2,9:117\n61#2,9:126\n*S KotlinDebug\n*F\n+ 1 RoomToolDialog.kt\ncom/qiahao/nextvideo/room/dialog/RoomToolDialog\n*L\n34#1:72,9\n38#1:81,9\n42#1:90,9\n46#1:99,9\n51#1:108,9\n55#1:117,9\n60#1:126,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomToolDialog extends BaseBindingDialog<DialogRoomToolBinding> {

    @NotNull
    private final Context mContext;

    @Nullable
    private RoomGamePanelListener mListener;
    private boolean noiseReduction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomToolDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
    }

    public void dismiss() {
        super.dismiss();
        this.mListener = null;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_room_tool;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final RoomGamePanelListener getMListener() {
        return this.mListener;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        String str;
        int i;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        setBackgroundDimEnabled(false);
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        this.noiseReduction = ((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, "noiseReduction" + str, Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
        ImageView imageView = ((DialogRoomToolBinding) getBinding()).noiseReductionImage;
        Context context = getContext();
        if (this.noiseReduction) {
            i = R.drawable.noise_reduction_on;
        } else {
            i = R.drawable.noise_reduction_off;
        }
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, i));
        final LinearLayout linearLayout = ((DialogRoomToolBinding) getBinding()).llToolsRoomMemberMass;
        final long j = 800;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomToolDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                    RoomGamePanelListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.roomMemberMass();
                    }
                    this.dismiss();
                }
            }
        });
        final LinearLayout linearLayout2 = ((DialogRoomToolBinding) getBinding()).llToolsMusic;
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomToolDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout2) > j || (linearLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout2, currentTimeMillis);
                    RoomGamePanelListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.music();
                    }
                    this.dismiss();
                }
            }
        });
        final LinearLayout linearLayout3 = ((DialogRoomToolBinding) getBinding()).llInviteUser;
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomToolDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout3) > j || (linearLayout3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout3, currentTimeMillis);
                    RoomGamePanelListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.inviteUser();
                    }
                    this.dismiss();
                }
            }
        });
        final LinearLayout linearLayout4 = ((DialogRoomToolBinding) getBinding()).llToolsGlobalRoomBroadcast;
        linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomToolDialog$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout4) > j || (linearLayout4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout4, currentTimeMillis);
                    RoomGamePanelListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.globalBroadcast();
                    }
                    this.dismiss();
                }
            }
        });
        final LinearLayout linearLayout5 = ((DialogRoomToolBinding) getBinding()).animateEffect;
        linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomToolDialog$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout5) > j || (linearLayout5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout5, currentTimeMillis);
                    RoomGamePanelListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.animationEffect();
                    }
                    this.dismiss();
                }
            }
        });
        final LinearLayout linearLayout6 = ((DialogRoomToolBinding) getBinding()).clearMessage;
        linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomToolDialog$onInitialize$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout6) > j || (linearLayout6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout6, currentTimeMillis);
                    RoomGamePanelListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.clearMessage();
                    }
                    this.dismiss();
                }
            }
        });
        final LinearLayout linearLayout7 = ((DialogRoomToolBinding) getBinding()).noiseReduction;
        linearLayout7.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.RoomToolDialog$onInitialize$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout7) > j || (linearLayout7 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout7, currentTimeMillis);
                    RoomGamePanelListener mListener = this.getMListener();
                    if (mListener != null) {
                        z = this.noiseReduction;
                        mListener.noiseReduction(!z);
                    }
                    this.dismiss();
                }
            }
        });
    }

    public final void setMListener(@Nullable RoomGamePanelListener roomGamePanelListener) {
        this.mListener = roomGamePanelListener;
    }
}
