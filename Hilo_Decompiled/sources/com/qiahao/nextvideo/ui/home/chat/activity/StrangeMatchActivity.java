package com.qiahao.nextvideo.ui.home.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ActivityStrangeMatchBinding;
import com.qiahao.nextvideo.ui.home.chat.StrangeMatchViewModel;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.SVGAUtil;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
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
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0006\u0010\u0018\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/StrangeMatchActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityStrangeMatchBinding;", "<init>", "()V", "isShowSetting", "", "isDialog", "isShowSVGA", "viewModel", "Lcom/qiahao/nextvideo/ui/home/chat/StrangeMatchViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/chat/StrangeMatchViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "onMatchSuccessEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "initData", "initView", "refreshView", "showSVGA", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrangeMatchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrangeMatchActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/StrangeMatchActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,219:1\n61#2,9:220\n61#2,9:229\n61#2,9:238\n61#2,9:247\n*S KotlinDebug\n*F\n+ 1 StrangeMatchActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/StrangeMatchActivity\n*L\n139#1:220,9\n142#1:229,9\n145#1:238,9\n151#1:247,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StrangeMatchActivity extends HiloBaseBindingActivity<ActivityStrangeMatchBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String IS_DIALOG = "IS_DIALOG";
    private boolean isDialog;
    private boolean isShowSVGA;
    private boolean isShowSetting;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.i2
        public final Object invoke() {
            StrangeMatchViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = StrangeMatchActivity.viewModel_delegate$lambda$0(StrangeMatchActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/StrangeMatchActivity$Companion;", "", "<init>", "()V", StrangeMatchActivity.IS_DIALOG, "", "startActivity", "", "context", "Landroid/content/Context;", "isDialog", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.startActivity(context, z);
        }

        public final void startActivity(@NotNull Context context, boolean isDialog) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) StrangeMatchActivity.class);
            intent.putExtra(StrangeMatchActivity.IS_DIALOG, isDialog);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final void initData() {
        getViewModel().getMSuccess().observe(this, new StrangeMatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.j2
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = StrangeMatchActivity.initData$lambda$3(StrangeMatchActivity.this, (Pair) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getMException().observe(this, new StrangeMatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.k2
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = StrangeMatchActivity.initData$lambda$4(StrangeMatchActivity.this, (Pair) obj);
                return initData$lambda$4;
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$3(StrangeMatchActivity strangeMatchActivity, Pair pair) {
        String str = (String) pair.getFirst();
        switch (str.hashCode()) {
            case -1529565272:
                if (str.equals(StrangeMatchViewModel.START_MATCH)) {
                    strangeMatchActivity.isShowSetting = false;
                    strangeMatchActivity.refreshView();
                    break;
                }
                break;
            case -1495467562:
                if (str.equals(StrangeMatchViewModel.MATCH_SETTING)) {
                    strangeMatchActivity.isShowSetting = true;
                    strangeMatchActivity.refreshView();
                    break;
                }
                break;
            case -1341184824:
                if (str.equals(StrangeMatchViewModel.CHANGE_AVATAR)) {
                    strangeMatchActivity.refreshView();
                    break;
                }
                break;
            case 486942564:
                if (str.equals(StrangeMatchViewModel.EXIT_MATCH)) {
                    if (strangeMatchActivity.isShowSetting) {
                        strangeMatchActivity.isShowSetting = false;
                        strangeMatchActivity.refreshView();
                        strangeMatchActivity.getViewModel().startMatch();
                        break;
                    } else {
                        strangeMatchActivity.finish();
                        break;
                    }
                }
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$4(StrangeMatchActivity strangeMatchActivity, Pair pair) {
        if (pair.getSecond() instanceof HiloException) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(strangeMatchActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, strangeMatchActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str;
        this.isDialog = getIntent().getBooleanExtra(IS_DIALOG, false);
        TextView textView = ((ActivityStrangeMatchBinding) getBinding()).match;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        textView.setBackground(shapeUtil.createShape("#33ffffff", "#33ffffff", 25, GradientDrawable.Orientation.TOP_BOTTOM));
        ((ActivityStrangeMatchBinding) getBinding()).next.setBackground(ShapeUtil.createShape$default(shapeUtil, "#33ffffff", "#33ffffff", 15, (GradientDrawable.Orientation) null, 8, (Object) null));
        setStatusBarIconColor(false);
        final ImageView imageView = ((ActivityStrangeMatchBinding) getBinding()).close;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.StrangeMatchActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    StrangeMatchViewModel.exitMatch$default(this.getViewModel(), false, 1, null);
                }
            }
        });
        final ImageView imageView2 = ((ActivityStrangeMatchBinding) getBinding()).setting;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.StrangeMatchActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    this.getViewModel().exitMatch(true);
                }
            }
        });
        final TextView textView2 = ((ActivityStrangeMatchBinding) getBinding()).match;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.StrangeMatchActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    this.isShowSetting = false;
                    this.refreshView();
                    this.getViewModel().startMatch();
                }
            }
        });
        final TextView textView3 = ((ActivityStrangeMatchBinding) getBinding()).next;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.StrangeMatchActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    this.getViewModel().strangeConfirmChange();
                }
            }
        });
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getMaskAvatar();
        } else {
            str = null;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        this.isShowSetting = isEmpty;
        if (isEmpty) {
            getViewModel().strangeConfirmChange();
        } else {
            refreshView();
            getViewModel().startMatch();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onMatchSuccessEvent$lambda$2$lambda$1(StrangeMatchActivity strangeMatchActivity, boolean z) {
        strangeMatchActivity.finish();
        return Unit.INSTANCE;
    }

    private final void showSVGA() {
        if (this.isShowSVGA) {
            return;
        }
        this.isShowSVGA = true;
        try {
            SVGAParser.Companion.shareParser().decodeFromAssets("svga/strange_match.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.StrangeMatchActivity$showSVGA$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    ActivityStrangeMatchBinding binding;
                    boolean z;
                    int i;
                    String str;
                    ActivityStrangeMatchBinding binding2;
                    ActivityStrangeMatchBinding binding3;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    binding = StrangeMatchActivity.this.getBinding();
                    SVGAImageView sVGAImageView = binding.matchSvga;
                    z = StrangeMatchActivity.this.isShowSetting;
                    if (z) {
                        i = 8;
                    } else {
                        i = 0;
                    }
                    sVGAImageView.setVisibility(i);
                    UserStore.Companion companion = UserStore.INSTANCE;
                    User user = companion.getShared().getUser();
                    String str2 = null;
                    if (user != null) {
                        str = user.getMaskAvatar();
                    } else {
                        str = null;
                    }
                    if (StringKtxKt.isUrl(str)) {
                        SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                        User user2 = companion.getShared().getUser();
                        if (user2 != null) {
                            str2 = user2.getMaskAvatar();
                        }
                        sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(str2, UserProxyUtility.cpUpgrades), SVGAUtil.SENDER_AVATAR);
                        Drawable sVGADrawable = new SVGADrawable(videoItem, sVGADynamicEntity);
                        binding3 = StrangeMatchActivity.this.getBinding();
                        binding3.matchSvga.setImageDrawable(sVGADrawable);
                    }
                    binding2 = StrangeMatchActivity.this.getBinding();
                    binding2.matchSvga.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final StrangeMatchViewModel viewModel_delegate$lambda$0(StrangeMatchActivity strangeMatchActivity) {
        return new ViewModelProvider(strangeMatchActivity).get(StrangeMatchViewModel.class);
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_strange_match;
    }

    @NotNull
    public final StrangeMatchViewModel getViewModel() {
        return (StrangeMatchViewModel) this.viewModel.getValue();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getBinding().matchSvga.clear();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onMatchSuccessEvent(@NotNull EventBusKey event) {
        User user;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "STRANGE_MATCH_SUCCESS")) {
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type userProxy.UserProxy1.MaskChatMatchSuccess");
            UserProxy1.MaskChatMatchSuccess maskChatMatchSuccess = (UserProxy1.MaskChatMatchSuccess) data;
            UserProxy.User targetUser = maskChatMatchSuccess.getTargetUser();
            if (targetUser != null) {
                user = DataExternalKt.toUser(targetUser);
            } else {
                user = null;
            }
            if (user != null) {
                AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                boolean z = this.isDialog;
                String groupId = maskChatMatchSuccess.getGroupId();
                if (groupId == null) {
                    groupId = "";
                }
                appRequestUtils.openStrangeChatActivity(user, z, groupId, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.h2
                    public final Object invoke(Object obj) {
                        Unit onMatchSuccessEvent$lambda$2$lambda$1;
                        onMatchSuccessEvent$lambda$2$lambda$1 = StrangeMatchActivity.onMatchSuccessEvent$lambda$2$lambda$1(StrangeMatchActivity.this, ((Boolean) obj).booleanValue());
                        return onMatchSuccessEvent$lambda$2$lambda$1;
                    }
                });
            }
        }
    }

    public final void refreshView() {
        String str;
        if (this.isShowSetting) {
            getBinding().setting.setVisibility(8);
            getBinding().settingGroup.setVisibility(0);
            getBinding().matchSvga.setVisibility(8);
            this.isShowSVGA = false;
            QMUIRadiusImageView qMUIRadiusImageView = getBinding().avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
            UserStore.Companion companion = UserStore.INSTANCE;
            User user = companion.getShared().getUser();
            String str2 = null;
            if (user != null) {
                str = user.getMaskAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            TextView textView = getBinding().name;
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                str2 = user2.getMaskNick();
            }
            textView.setText(str2);
            return;
        }
        getBinding().setting.setVisibility(0);
        getBinding().settingGroup.setVisibility(8);
        showSVGA();
    }
}
