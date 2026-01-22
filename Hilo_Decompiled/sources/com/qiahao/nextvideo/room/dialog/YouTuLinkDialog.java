package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.databinding.DialogYouTuLinkBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0014R?\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\n\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/YouTuLinkDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogYouTuLinkBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "groupId", "youtubeUrl", "", "addYouTuBeVideo", "(Ljava/lang/String;Ljava/lang/String;)V", "", "getLayoutResId", "()I", "", "isBottomStyle", "()Z", "onInitialize", "()V", "dismiss", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "Lkotlin/ParameterName;", "name", "link", "listener", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTuLinkDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTuLinkDialog.kt\ncom/qiahao/nextvideo/room/dialog/YouTuLinkDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n61#2,9:78\n1#3:87\n*S KotlinDebug\n*F\n+ 1 YouTuLinkDialog.kt\ncom/qiahao/nextvideo/room/dialog/YouTuLinkDialog\n*L\n40#1:78,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuLinkDialog extends BaseBindingDialog<DialogYouTuLinkBinding> {

    @Nullable
    private Function1<? super YouTuBeData, Unit> listener;

    @NotNull
    private nd.a mCompositeDisposable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTuLinkDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCompositeDisposable = new nd.a();
    }

    public static final /* synthetic */ DialogYouTuLinkBinding access$getBinding(YouTuLinkDialog youTuLinkDialog) {
        return (DialogYouTuLinkBinding) youTuLinkDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addYouTuBeVideo(String groupId, String youtubeUrl) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().addYouTuBeVideo(groupId, youtubeUrl), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.r5
            public final Object invoke(Object obj) {
                Unit addYouTuBeVideo$lambda$2;
                addYouTuBeVideo$lambda$2 = YouTuLinkDialog.addYouTuBeVideo$lambda$2(YouTuLinkDialog.this, (ApiResponse) obj);
                return addYouTuBeVideo$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.s5
            public final Object invoke(Object obj) {
                Unit addYouTuBeVideo$lambda$3;
                addYouTuBeVideo$lambda$3 = YouTuLinkDialog.addYouTuBeVideo$lambda$3(YouTuLinkDialog.this, (Throwable) obj);
                return addYouTuBeVideo$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit addYouTuBeVideo$lambda$2(YouTuLinkDialog youTuLinkDialog, ApiResponse apiResponse) {
        Function1<? super YouTuBeData, Unit> function1;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, youTuLinkDialog.getContext(), ResourcesKtxKt.getStringById(youTuLinkDialog, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        YouTuBeData youTuBeData = (YouTuBeData) apiResponse.getData();
        if (youTuBeData != null && (function1 = youTuLinkDialog.listener) != null) {
            function1.invoke(youTuBeData);
        }
        youTuLinkDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit addYouTuBeVideo$lambda$3(YouTuLinkDialog youTuLinkDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = youTuLinkDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(youTuLinkDialog, 2131952667);
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
        this.mCompositeDisposable.d();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_you_tu_link;
    }

    @Nullable
    public final Function1<YouTuBeData, Unit> getListener() {
        return this.listener;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogYouTuLinkBinding) getBinding()).addButton.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#821CFF", "#A359FF", 16, (GradientDrawable.Orientation) null, 8, (Object) null));
        final TextView textView = ((DialogYouTuLinkBinding) getBinding()).addButton;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.YouTuLinkDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    String obj = StringsKt.trim(String.valueOf(YouTuLinkDialog.access$getBinding(this).linkEdit.getText())).toString();
                    if (!TextUtils.isEmpty(obj)) {
                        this.addYouTuBeVideo(MeetingRoomManager.INSTANCE.getMGroupId(), obj);
                        return;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131954543), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        });
    }

    public final void setListener(@Nullable Function1<? super YouTuBeData, Unit> function1) {
        this.listener = function1;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
