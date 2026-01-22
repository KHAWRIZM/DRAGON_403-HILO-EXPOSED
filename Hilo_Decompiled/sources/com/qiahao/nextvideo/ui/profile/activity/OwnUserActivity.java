package com.qiahao.nextvideo.ui.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qhqc.core.feature.community.ui.activity.PostsCreateActivity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EditEvent;
import com.qiahao.nextvideo.data.UserStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/OwnUserActivity;", "Lcom/qiahao/nextvideo/ui/profile/activity/BaseUserDetailActivity;", "<init>", "()V", "onInitialize", "", "onEditEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EditEvent;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOwnUserActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OwnUserActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/OwnUserActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,59:1\n61#2,9:60\n*S KotlinDebug\n*F\n+ 1 OwnUserActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/OwnUserActivity\n*L\n37#1:60,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OwnUserActivity extends BaseUserDetailActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/OwnUserActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "user", "Lcom/qiahao/base_common/model/common/User;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @Nullable User user) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) OwnUserActivity.class);
            intent.putExtra("user", (Parcelable) user);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(OwnUserActivity ownUserActivity, boolean z) {
        AppCompatImageView appCompatImageView = ownUserActivity.getBinding().postBtn;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "postBtn");
        ViewKtxKt.visibleOrGone(appCompatImageView, z);
        return Unit.INSTANCE;
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onEditEvent(@NotNull EditEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "photo")) {
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<com.qiahao.nextvideo.data.model.UserPictureResponseBean>");
            updatePhotoViewData((List) data);
        }
    }

    @Override // com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        UserStore.fetchUserDetailInfo$default(UserStore.INSTANCE.getShared(), false, 1, null);
        final AppCompatImageView appCompatImageView = getBinding().postBtn;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.OwnUserActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    PostsCreateActivity.Companion.start(this);
                }
            }
        });
        setShowPostBtnOrNot(new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.u0
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = OwnUserActivity.onInitialize$lambda$1(OwnUserActivity.this, ((Boolean) obj).booleanValue());
                return onInitialize$lambda$1;
            }
        });
    }
}
