package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.EmojiBean;
import com.qiahao.nextvideo.databinding.DialogGroupFaceBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.adapter.MicFaceAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.reusable.views.recyclerview.PagerGridLayoutManager;
import com.qiahao.nextvideo.ui.reusable.views.recyclerview.PagerGridSnapHelper;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010;\u001a\u00020:8\u0006X\u0086D¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020:8\u0006X\u0086D¢\u0006\f\n\u0004\b?\u0010<\u001a\u0004\b@\u0010>¨\u0006B"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/MicFaceDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Landroid/content/Context;", "mCurrentContext", "", "mGroupId", "Lcom/qiahao/nextvideo/room/dialog/MicFaceDialogListener;", "mMicFaceDialogListener", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/qiahao/nextvideo/room/dialog/MicFaceDialogListener;)V", "", "getFaceData", "()V", "initStyle", "initDataBinding", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "getMCurrentContext", "()Landroid/content/Context;", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "Lcom/qiahao/nextvideo/room/dialog/MicFaceDialogListener;", "getMMicFaceDialogListener", "()Lcom/qiahao/nextvideo/room/dialog/MicFaceDialogListener;", "setMMicFaceDialogListener", "(Lcom/qiahao/nextvideo/room/dialog/MicFaceDialogListener;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/databinding/DialogGroupFaceBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogGroupFaceBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogGroupFaceBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogGroupFaceBinding;)V", "Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager;", "gridLayoutManager", "Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager;", "getGridLayoutManager", "()Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager;", "setGridLayoutManager", "(Lcom/qiahao/nextvideo/ui/reusable/views/recyclerview/PagerGridLayoutManager;)V", "Lcom/qiahao/nextvideo/room/adapter/MicFaceAdapter;", "mMicFaceAdapter", "Lcom/qiahao/nextvideo/room/adapter/MicFaceAdapter;", "getMMicFaceAdapter", "()Lcom/qiahao/nextvideo/room/adapter/MicFaceAdapter;", "setMMicFaceAdapter", "(Lcom/qiahao/nextvideo/room/adapter/MicFaceAdapter;)V", "", "rowCount", "I", "getRowCount", "()I", "columnCount", "getColumnCount", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MicFaceDialog extends BottomSheetDialog {

    @NotNull
    private static final String TAG = "MicFaceDialog";
    public DialogGroupFaceBinding binding;
    private final int columnCount;
    public PagerGridLayoutManager gridLayoutManager;
    public nd.a mCompositeDisposable;

    @NotNull
    private final Context mCurrentContext;

    @NotNull
    private final String mGroupId;
    public MicFaceAdapter mMicFaceAdapter;

    @NotNull
    private MicFaceDialogListener mMicFaceDialogListener;
    private final int rowCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MicFaceDialog(@NotNull Context context, @NotNull String str, @NotNull MicFaceDialogListener micFaceDialogListener) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        Intrinsics.checkNotNullParameter(str, "mGroupId");
        Intrinsics.checkNotNullParameter(micFaceDialogListener, "mMicFaceDialogListener");
        this.mCurrentContext = context;
        this.mGroupId = str;
        this.mMicFaceDialogListener = micFaceDialogListener;
        this.rowCount = 2;
        this.columnCount = 4;
    }

    private final void getFaceData() {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.hasInitEmoji()) {
            getMMicFaceAdapter().setList(meetingRoomManager.getMMicEmoji());
        } else {
            RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getMicEmoji(), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.s0
                public final Object invoke(Object obj) {
                    Unit faceData$lambda$1;
                    faceData$lambda$1 = MicFaceDialog.getFaceData$lambda$1(MicFaceDialog.this, (ApiResponse) obj);
                    return faceData$lambda$1;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.t0
                public final Object invoke(Object obj) {
                    Unit faceData$lambda$2;
                    faceData$lambda$2 = MicFaceDialog.getFaceData$lambda$2(MicFaceDialog.this, (Throwable) obj);
                    return faceData$lambda$2;
                }
            }, (Function0) null, false, 12, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFaceData$lambda$1(MicFaceDialog micFaceDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<EmojiBean> list = (List) apiResponse.getData();
        if (list != null) {
            MeetingRoomManager.INSTANCE.setMMicEmoji(list);
            micFaceDialog.getMMicFaceAdapter().setList(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFaceData$lambda$2(MicFaceDialog micFaceDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = micFaceDialog.mCurrentContext;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            String string = micFaceDialog.mCurrentContext.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void initDataBinding() {
        setBinding((DialogGroupFaceBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_group_face, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        setMMicFaceAdapter(new MicFaceAdapter(R.layout.item_mic_face));
        setGridLayoutManager(new PagerGridLayoutManager(this.rowCount, this.columnCount, 1));
        RecyclerView recyclerView = getBinding().faceRecycler;
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        recyclerView.setLayoutManager(getGridLayoutManager());
        new PagerGridSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setLayoutDirection(3);
        recyclerView.setAdapter(getMMicFaceAdapter());
        getMMicFaceAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.u0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MicFaceDialog.initDataBinding$lambda$4(MicFaceDialog.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataBinding$lambda$4(MicFaceDialog micFaceDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EmojiBean");
        micFaceDialog.mMicFaceDialogListener.sendFace((EmojiBean) item);
        micFaceDialog.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStyle() {
        setCanceledOnTouchOutside(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131362643);
        if (frameLayout != null) {
            BottomSheetBehavior.s0(frameLayout).c1(false);
            frameLayout.getLayoutParams().height = Dimens.INSTANCE.dpToPx(UserProxyUtility.lobbyMatchSuccess);
            BottomSheetBehavior.s0(frameLayout).c(3);
            frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        }
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.0f;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setDimAmount(0.0f);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    @NotNull
    public final DialogGroupFaceBinding getBinding() {
        DialogGroupFaceBinding dialogGroupFaceBinding = this.binding;
        if (dialogGroupFaceBinding != null) {
            return dialogGroupFaceBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final int getColumnCount() {
        return this.columnCount;
    }

    @NotNull
    public final PagerGridLayoutManager getGridLayoutManager() {
        PagerGridLayoutManager pagerGridLayoutManager = this.gridLayoutManager;
        if (pagerGridLayoutManager != null) {
            return pagerGridLayoutManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        return null;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        nd.a aVar = this.mCompositeDisposable;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCompositeDisposable");
        return null;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @NotNull
    public final MicFaceAdapter getMMicFaceAdapter() {
        MicFaceAdapter micFaceAdapter = this.mMicFaceAdapter;
        if (micFaceAdapter != null) {
            return micFaceAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMicFaceAdapter");
        return null;
    }

    @NotNull
    public final MicFaceDialogListener getMMicFaceDialogListener() {
        return this.mMicFaceDialogListener;
    }

    public final int getRowCount() {
        return this.rowCount;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setMCompositeDisposable(new nd.a());
        initDataBinding();
        initStyle();
        getFaceData();
    }

    public final void setBinding(@NotNull DialogGroupFaceBinding dialogGroupFaceBinding) {
        Intrinsics.checkNotNullParameter(dialogGroupFaceBinding, "<set-?>");
        this.binding = dialogGroupFaceBinding;
    }

    public final void setGridLayoutManager(@NotNull PagerGridLayoutManager pagerGridLayoutManager) {
        Intrinsics.checkNotNullParameter(pagerGridLayoutManager, "<set-?>");
        this.gridLayoutManager = pagerGridLayoutManager;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMMicFaceAdapter(@NotNull MicFaceAdapter micFaceAdapter) {
        Intrinsics.checkNotNullParameter(micFaceAdapter, "<set-?>");
        this.mMicFaceAdapter = micFaceAdapter;
    }

    public final void setMMicFaceDialogListener(@NotNull MicFaceDialogListener micFaceDialogListener) {
        Intrinsics.checkNotNullParameter(micFaceDialogListener, "<set-?>");
        this.mMicFaceDialogListener = micFaceDialogListener;
    }
}
