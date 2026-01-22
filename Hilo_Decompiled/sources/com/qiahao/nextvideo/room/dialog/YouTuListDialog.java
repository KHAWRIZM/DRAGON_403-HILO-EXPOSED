package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.databinding.DialogYouTuListBinding;
import com.qiahao.nextvideo.databinding.ViewYouTuMoreBinding;
import com.qiahao.nextvideo.room.adapter.YouTuAdapter;
import com.qiahao.nextvideo.view.youtube.YouTubeLinkHelper;
import com.tencent.qcloud.tuicore.util.PopWindowUtil;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u0013H\u0016J\u0006\u0010#\u001a\u00020\u0013J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR9\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/YouTuListDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogYouTuListBinding;", "context", "Landroid/content/Context;", "videoId", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getVideoId", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "Lkotlin/ParameterName;", "name", "data", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mAdapter", "Lcom/qiahao/nextvideo/room/adapter/YouTuAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/YouTuAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "isBottomStyle", "", "onInitialize", "refreshView", "showPopWindow", "view", "Landroid/view/View;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTuListDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTuListDialog.kt\ncom/qiahao/nextvideo/room/dialog/YouTuListDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,100:1\n61#2,9:101\n61#2,9:110\n61#2,9:119\n*S KotlinDebug\n*F\n+ 1 YouTuListDialog.kt\ncom/qiahao/nextvideo/room/dialog/YouTuListDialog\n*L\n54#1:101,9\n57#1:110,9\n88#1:119,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuListDialog extends BaseBindingDialog<DialogYouTuListBinding> {

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @Nullable
    private Function1<? super YouTuBeData, Unit> mListener;

    @Nullable
    private String videoId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTuListDialog(@NotNull Context context, @Nullable String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.videoId = str;
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.v5
            public final Object invoke() {
                YouTuAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = YouTuListDialog.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YouTuAdapter mAdapter_delegate$lambda$0() {
        return new YouTuAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$1(YouTuListDialog youTuListDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        youTuListDialog.showPopWindow((YouTuBeData) youTuListDialog.getMAdapter().getData().get(i), view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$2(YouTuListDialog youTuListDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        YouTuBeData youTuBeData = (YouTuBeData) youTuListDialog.getMAdapter().getData().get(i);
        Function1<? super YouTuBeData, Unit> function1 = youTuListDialog.mListener;
        if (function1 != null) {
            function1.invoke(youTuBeData);
        }
        youTuListDialog.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showPopWindow(final YouTuBeData data, View view) {
        ViewYouTuMoreBinding viewYouTuMoreBinding = (ViewYouTuMoreBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_you_tu_more, (ViewGroup) null, false);
        viewYouTuMoreBinding.constraint.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        final PopupWindow popupWindowAndShow = PopWindowUtil.popupWindowAndShow(viewYouTuMoreBinding.getRoot(), view, UiKtxKt.getDp(120), UiKtxKt.getDp(45));
        final ConstraintLayout constraintLayout = viewYouTuMoreBinding.constraint;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.YouTuListDialog$showPopWindow$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    YouTubeLinkHelper youTubeLinkHelper = YouTubeLinkHelper.INSTANCE;
                    String videoId = data.getVideoId();
                    if (videoId == null) {
                        videoId = "";
                    }
                    YouTuBeData deleteAndNextVideo = youTubeLinkHelper.deleteAndNextVideo(videoId);
                    if (deleteAndNextVideo != null) {
                        this.setVideoId(deleteAndNextVideo.getVideoId());
                    }
                    Function1<YouTuBeData, Unit> mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.invoke(deleteAndNextVideo);
                    }
                    this.refreshView();
                    popupWindowAndShow.dismiss();
                }
            }
        });
    }

    protected int getLayoutResId() {
        return R.layout.dialog_you_tu_list;
    }

    @NotNull
    public final YouTuAdapter getMAdapter() {
        return (YouTuAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final Function1<YouTuBeData, Unit> getMListener() {
        return this.mListener;
    }

    @Nullable
    public final String getVideoId() {
        return this.videoId;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ConstraintLayout constraintLayout = ((DialogYouTuListBinding) getBinding()).constraint;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, context, 2131101214, 2131101214, 16, 16, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
        ((DialogYouTuListBinding) getBinding()).addVideo.setBackground(ShapeUtil.createShape$default(shapeUtil, "#7B10FF", "#A359FF", 16, (GradientDrawable.Orientation) null, 8, (Object) null));
        getMAdapter().addChildClickViewIds(new int[]{R.id.more});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.dialog.t5
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YouTuListDialog.onInitialize$lambda$1(YouTuListDialog.this, baseQuickAdapter, view, i);
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.u5
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YouTuListDialog.onInitialize$lambda$2(YouTuListDialog.this, baseQuickAdapter, view, i);
            }
        });
        ((DialogYouTuListBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        final ImageView imageView = ((DialogYouTuListBinding) getBinding()).helper;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.YouTuListDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    Context context2 = this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    new YouTuHelperDialog(context2).show();
                }
            }
        });
        final TextView textView = ((DialogYouTuListBinding) getBinding()).addVideo;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.YouTuListDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    Context context2 = this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    YouTuLinkDialog youTuLinkDialog = new YouTuLinkDialog(context2);
                    final YouTuListDialog youTuListDialog = this;
                    youTuLinkDialog.setListener(new Function1<YouTuBeData, Unit>() { // from class: com.qiahao.nextvideo.room.dialog.YouTuListDialog$onInitialize$4$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((YouTuBeData) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(YouTuBeData youTuBeData) {
                            Intrinsics.checkNotNullParameter(youTuBeData, "it");
                            YouTuListDialog.this.refreshView();
                        }
                    });
                    youTuLinkDialog.show();
                }
            }
        });
        refreshView();
    }

    public final void refreshView() {
        ArrayList<YouTuBeData> localVideoData = YouTubeLinkHelper.INSTANCE.getLocalVideoData();
        if (localVideoData.isEmpty()) {
            ((DialogYouTuListBinding) getBinding()).emptyGroup.setVisibility(0);
            ((DialogYouTuListBinding) getBinding()).recyclerView.setVisibility(8);
        } else {
            ((DialogYouTuListBinding) getBinding()).emptyGroup.setVisibility(8);
            ((DialogYouTuListBinding) getBinding()).recyclerView.setVisibility(0);
            getMAdapter().setList(localVideoData);
        }
    }

    public final void setMListener(@Nullable Function1<? super YouTuBeData, Unit> function1) {
        this.mListener = function1;
    }

    public final void setVideoId(@Nullable String str) {
        this.videoId = str;
    }

    public /* synthetic */ YouTuListDialog(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str);
    }
}
