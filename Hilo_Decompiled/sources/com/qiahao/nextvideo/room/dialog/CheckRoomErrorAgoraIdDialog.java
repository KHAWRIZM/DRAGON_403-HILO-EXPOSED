package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogCheckRoomErrorAgoraBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.adapter.AgoraErrorAgoraIdAdapter;
import com.qiahao.nextvideo.room.adapter.AgoraErrorUserInfoAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/CheckRoomErrorAgoraIdDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "", "initRecyclerView", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "setCurrentAgoraIdAdapter", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "getUserInfoAndShow", "onDetachedFromWindow", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "Lcom/qiahao/nextvideo/databinding/DialogCheckRoomErrorAgoraBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogCheckRoomErrorAgoraBinding;", "Lcom/qiahao/nextvideo/room/adapter/AgoraErrorUserInfoAdapter;", "mAgoraErrorUserInfoAdapter$delegate", "Lkotlin/Lazy;", "getMAgoraErrorUserInfoAdapter", "()Lcom/qiahao/nextvideo/room/adapter/AgoraErrorUserInfoAdapter;", "mAgoraErrorUserInfoAdapter", "Lcom/qiahao/nextvideo/room/adapter/AgoraErrorAgoraIdAdapter;", "mAgoraErrorAgoraIdAdapter$delegate", "getMAgoraErrorAgoraIdAdapter", "()Lcom/qiahao/nextvideo/room/adapter/AgoraErrorAgoraIdAdapter;", "mAgoraErrorAgoraIdAdapter", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCheckRoomErrorAgoraIdDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckRoomErrorAgoraIdDialog.kt\ncom/qiahao/nextvideo/room/dialog/CheckRoomErrorAgoraIdDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,131:1\n1869#2,2:132\n*S KotlinDebug\n*F\n+ 1 CheckRoomErrorAgoraIdDialog.kt\ncom/qiahao/nextvideo/room/dialog/CheckRoomErrorAgoraIdDialog\n*L\n78#1:132,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CheckRoomErrorAgoraIdDialog extends AppCompatDialog implements View.OnClickListener {

    @NotNull
    private static final String TAG = "CheckRoomErrorAgoraIdDi";
    private DialogCheckRoomErrorAgoraBinding binding;

    /* renamed from: mAgoraErrorAgoraIdAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAgoraErrorAgoraIdAdapter;

    /* renamed from: mAgoraErrorUserInfoAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAgoraErrorUserInfoAdapter;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private final Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckRoomErrorAgoraIdDialog(@NotNull Context context) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.mAgoraErrorUserInfoAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.a
            public final Object invoke() {
                AgoraErrorUserInfoAdapter mAgoraErrorUserInfoAdapter_delegate$lambda$0;
                mAgoraErrorUserInfoAdapter_delegate$lambda$0 = CheckRoomErrorAgoraIdDialog.mAgoraErrorUserInfoAdapter_delegate$lambda$0();
                return mAgoraErrorUserInfoAdapter_delegate$lambda$0;
            }
        });
        this.mAgoraErrorAgoraIdAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.b
            public final Object invoke() {
                AgoraErrorAgoraIdAdapter mAgoraErrorAgoraIdAdapter_delegate$lambda$1;
                mAgoraErrorAgoraIdAdapter_delegate$lambda$1 = CheckRoomErrorAgoraIdDialog.mAgoraErrorAgoraIdAdapter_delegate$lambda$1();
                return mAgoraErrorAgoraIdAdapter_delegate$lambda$1;
            }
        });
        this.mCompositeDisposable = new nd.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfoAndShow$lambda$5(CheckRoomErrorAgoraIdDialog checkRoomErrorAgoraIdDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        checkRoomErrorAgoraIdDialog.getMAgoraErrorUserInfoAdapter().setList((Collection) apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfoAndShow$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void initRecyclerView() {
        DialogCheckRoomErrorAgoraBinding dialogCheckRoomErrorAgoraBinding = this.binding;
        DialogCheckRoomErrorAgoraBinding dialogCheckRoomErrorAgoraBinding2 = null;
        if (dialogCheckRoomErrorAgoraBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogCheckRoomErrorAgoraBinding = null;
        }
        RecyclerView recyclerView = dialogCheckRoomErrorAgoraBinding.recyclerCurrentAgoraId;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMAgoraErrorAgoraIdAdapter());
        DialogCheckRoomErrorAgoraBinding dialogCheckRoomErrorAgoraBinding3 = this.binding;
        if (dialogCheckRoomErrorAgoraBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogCheckRoomErrorAgoraBinding2 = dialogCheckRoomErrorAgoraBinding3;
        }
        RecyclerView recyclerView2 = dialogCheckRoomErrorAgoraBinding2.recyclerCurrentUserInfo;
        recyclerView2.setLayoutManager(new CustomLinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.setAdapter(getMAgoraErrorUserInfoAdapter());
        setCurrentAgoraIdAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgoraErrorAgoraIdAdapter mAgoraErrorAgoraIdAdapter_delegate$lambda$1() {
        return new AgoraErrorAgoraIdAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgoraErrorUserInfoAdapter mAgoraErrorUserInfoAdapter_delegate$lambda$0() {
        return new AgoraErrorUserInfoAdapter();
    }

    @NotNull
    public final AgoraErrorAgoraIdAdapter getMAgoraErrorAgoraIdAdapter() {
        return (AgoraErrorAgoraIdAdapter) this.mAgoraErrorAgoraIdAdapter.getValue();
    }

    @NotNull
    public final AgoraErrorUserInfoAdapter getMAgoraErrorUserInfoAdapter() {
        return (AgoraErrorUserInfoAdapter) this.mAgoraErrorUserInfoAdapter.getValue();
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void getUserInfoAndShow() {
        Toast normal$default;
        setCurrentAgoraIdAdapter();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMCurrentSayIdArrayList().isEmpty() && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.mContext, "目前没有人", false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        StringBuilder sb2 = new StringBuilder();
        int size = meetingRoomManager.getMCurrentSayIdArrayList().size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                Integer num = MeetingRoomManager.INSTANCE.getMCurrentSayIdArrayList().get(i);
                Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                sb2.append(num.intValue());
            } else {
                Integer num2 = MeetingRoomManager.INSTANCE.getMCurrentSayIdArrayList().get(i);
                Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
                sb2.append(num2.intValue());
                sb2.append(",");
            }
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.getUserIdForAgoraId(sb3), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.c
            public final Object invoke(Object obj) {
                Unit userInfoAndShow$lambda$5;
                userInfoAndShow$lambda$5 = CheckRoomErrorAgoraIdDialog.getUserInfoAndShow$lambda$5(CheckRoomErrorAgoraIdDialog.this, (ApiResponse) obj);
                return userInfoAndShow$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.d
            public final Object invoke(Object obj) {
                Unit userInfoAndShow$lambda$6;
                userInfoAndShow$lambda$6 = CheckRoomErrorAgoraIdDialog.getUserInfoAndShow$lambda$6((Throwable) obj);
                return userInfoAndShow$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362358) {
            if (id2 != 2131362385) {
                if (id2 == 2131362999) {
                    getUserInfoAndShow();
                    return;
                }
                return;
            }
            setCurrentAgoraIdAdapter();
            return;
        }
        MeetingRoomManager.INSTANCE.getMCurrentSayIdArrayList().clear();
        setCurrentAgoraIdAdapter();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogCheckRoomErrorAgoraBinding dialogCheckRoomErrorAgoraBinding = null;
        DialogCheckRoomErrorAgoraBinding dialogCheckRoomErrorAgoraBinding2 = (DialogCheckRoomErrorAgoraBinding) androidx.databinding.g.h(LayoutInflater.from(this.mContext), R.layout.dialog_check_room_error_agora, (ViewGroup) null, false);
        this.binding = dialogCheckRoomErrorAgoraBinding2;
        if (dialogCheckRoomErrorAgoraBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogCheckRoomErrorAgoraBinding2 = null;
        }
        setContentView(dialogCheckRoomErrorAgoraBinding2.getRoot());
        DialogCheckRoomErrorAgoraBinding dialogCheckRoomErrorAgoraBinding3 = this.binding;
        if (dialogCheckRoomErrorAgoraBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogCheckRoomErrorAgoraBinding = dialogCheckRoomErrorAgoraBinding3;
        }
        dialogCheckRoomErrorAgoraBinding.setClick(this);
        initRecyclerView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.mCompositeDisposable.d();
    }

    public final void setCurrentAgoraIdAdapter() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = MeetingRoomManager.INSTANCE.getMCurrentSayIdArrayList().iterator();
        while (it.hasNext()) {
            arrayList.add((Integer) it.next());
        }
        getMAgoraErrorAgoraIdAdapter().setList(arrayList);
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
