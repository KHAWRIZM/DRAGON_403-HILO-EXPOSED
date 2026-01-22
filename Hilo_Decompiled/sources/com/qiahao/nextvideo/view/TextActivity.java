package com.qiahao.nextvideo.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import c5.g;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.PathHelper;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ActivityTextBinding;
import com.qiahao.nextvideo.databinding.GiftEffectViewBinding;
import com.qiahao.nextvideo.room.help.VideoUploadManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/view/TextActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityTextBinding;", "<init>", "()V", "getLayoutResId", "", "onInitialize", "", "initGiftEffectView", "Lcom/qiahao/nextvideo/databinding/GiftEffectViewBinding;", "toBitmap", "Landroid/graphics/Bitmap;", "giftBinding", "viewToBitmap", "view", "Landroid/view/View;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTextActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextActivity.kt\ncom/qiahao/nextvideo/view/TextActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,133:1\n61#2,9:134\n84#3,6:143\n84#3,6:149\n*S KotlinDebug\n*F\n+ 1 TextActivity.kt\ncom/qiahao/nextvideo/view/TextActivity\n*L\n59#1:134,9\n90#1:143,6\n111#1:149,6\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TextActivity extends HiloBaseBindingActivity<ActivityTextBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/view/TextActivity$Companion;", "", "<init>", "()V", "start", "", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context activity) {
            Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
            activity.startActivity(new Intent(activity, (Class<?>) TextActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final GiftEffectViewBinding initGiftEffectView() {
        String str = null;
        GiftEffectViewBinding inflate = GiftEffectViewBinding.inflate(LayoutInflater.from(this), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ImageView imageView = inflate.avatar;
        Intrinsics.checkNotNullExpressionValue(imageView, "avatar");
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getAvatar();
        }
        ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        inflate.getRoot().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return inflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        String str = null;
        final GiftEffectViewBinding inflate = GiftEffectViewBinding.inflate(LayoutInflater.from(this), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        ImageView imageView = inflate.avatar;
        Intrinsics.checkNotNullExpressionValue(imageView, "avatar");
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getAvatar();
        }
        ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        inflate.getRoot().measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.getRoot().layout(0, 0, inflate.getRoot().getMeasuredWidth(), inflate.getRoot().getMeasuredHeight());
        final TextView textView = ((ActivityTextBinding) getBinding()).test;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.view.TextActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityTextBinding binding;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    Bitmap bitmap = this.toBitmap(inflate);
                    binding = this.getBinding();
                    ImageView imageView2 = binding.buttonImage;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "buttonImage");
                    ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, (Integer) null, bitmap, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65519, (Object) null);
                    VideoUploadManager.INSTANCE.saveBitmapToFile(bitmap, PathHelper.INSTANCE.getAppPrivateDownloadPath() + File.separator + System.currentTimeMillis() + ".png");
                }
            }
        });
    }

    @NotNull
    public final Bitmap toBitmap(@NotNull GiftEffectViewBinding giftBinding) {
        Intrinsics.checkNotNullParameter(giftBinding, "giftBinding");
        Bitmap createBitmap = Bitmap.createBitmap(giftBinding.getRoot().getWidth(), giftBinding.getRoot().getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = giftBinding.getRoot().getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(0);
        }
        giftBinding.getRoot().draw(canvas);
        return createBitmap;
    }

    @NotNull
    public final Bitmap viewToBitmap(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(0);
        }
        view.draw(canvas);
        return createBitmap;
    }
}
