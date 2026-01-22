package com.qiahao.nextvideo.ui.mainActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import c5.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.mainActivity.HomeRoomBannerData;
import com.qiahao.nextvideo.data.mainActivity.MainActivityData;
import com.qiahao.nextvideo.ui.family.FamilyRankActivity;
import com.therouter.TheRouter;
import com.zhpan.bannerview.e;
import com.zhpan.bannerview.f;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\bJ\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0004R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/ui/mainActivity/MainBannerPagerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/mainActivity/HomeRoomBannerData;", "<init>", "()V", "", "viewType", "getLayoutId", "(I)I", "Lcom/zhpan/bannerview/f;", "holder", "data", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/mainActivity/HomeRoomBannerData;II)V", "getViewType", "release", "Landroid/os/CountDownTimer;", "countDownTimer", "Landroid/os/CountDownTimer;", "getCountDownTimer", "()Landroid/os/CountDownTimer;", "setCountDownTimer", "(Landroid/os/CountDownTimer;)V", "", "isStart", "Z", "()Z", "setStart", "(Z)V", "Lkotlin/Function0;", "mListener", "Lkotlin/jvm/functions/Function0;", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainBannerPagerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainBannerPagerAdapter.kt\ncom/qiahao/nextvideo/ui/mainActivity/MainBannerPagerAdapter\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,125:1\n61#2,9:126\n61#2,9:135\n*S KotlinDebug\n*F\n+ 1 MainBannerPagerAdapter.kt\ncom/qiahao/nextvideo/ui/mainActivity/MainBannerPagerAdapter\n*L\n62#1:126,9\n81#1:135,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MainBannerPagerAdapter extends e {

    @Nullable
    private CountDownTimer countDownTimer;
    private boolean isStart = true;

    @Nullable
    private Function0<Unit> mListener;

    @Nullable
    public final CountDownTimer getCountDownTimer() {
        return this.countDownTimer;
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return (viewType == 1 || viewType != 2) ? R.layout.item_banner_family : R.layout.item_banner_activity;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    @Override // com.zhpan.bannerview.e
    protected int getViewType(int position) {
        Integer type = ((HomeRoomBannerData) this.mList.get(position)).getType();
        if (type != null) {
            return type.intValue();
        }
        return 1;
    }

    /* renamed from: isStart, reason: from getter */
    public final boolean getIsStart() {
        return this.isStart;
    }

    public final void release() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
    }

    public final void setCountDownTimer(@Nullable CountDownTimer countDownTimer) {
        this.countDownTimer = countDownTimer;
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }

    public final void setStart(boolean z) {
        this.isStart = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return;
     */
    @Override // com.zhpan.bannerview.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bindData(@NotNull f holder, @NotNull HomeRoomBannerData data, int position, int pageSize) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Integer type = data.getType();
            if (type != null && type.intValue() == 1) {
                final SVGAImageView a = holder.a(R.id.svgaView);
                ((TextView) holder.a(2131365026)).setText(ResourcesKtxKt.getStringById(this, 2131954089));
                if (this.isStart) {
                    if (a != null) {
                        a.startAnimation();
                    }
                } else if (a != null) {
                    a.stopAnimation();
                }
                if (a != null) {
                    final long j = 800;
                    a.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.mainActivity.MainBannerPagerAdapter$bindData$$inlined$singleClick$default$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            long j2;
                            FamilyInfo groupPower;
                            Long id2;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(a) > j || (a instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(a, currentTimeMillis);
                                SVGAImageView sVGAImageView = a;
                                User user = UserStore.INSTANCE.getShared().getUser();
                                if (user != null && (groupPower = user.getGroupPower()) != null && (id2 = groupPower.getId()) != null) {
                                    j2 = id2.longValue();
                                } else {
                                    j2 = 0;
                                }
                                if (j2 != 0) {
                                    String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "FAMILY_WHEEL_URL", "", (String) null, 4, (Object) null);
                                    AppService appService = (AppService) TheRouter.get(AppService.class, new Object[0]);
                                    if (appService != null) {
                                        appService.openCommonLink(str);
                                        return;
                                    }
                                    return;
                                }
                                Context context = a.getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                                TipDialog confirmContent = new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953158)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952244));
                                final SVGAImageView sVGAImageView2 = a;
                                confirmContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.mainActivity.MainBannerPagerAdapter$bindData$1$1
                                    public void cancel() {
                                        OnCommonDialogListener.DefaultImpls.cancel(this);
                                    }

                                    public void confirm() {
                                        FamilyRankActivity.Companion companion = FamilyRankActivity.Companion;
                                        Context context2 = sVGAImageView2.getContext();
                                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                                        companion.startActivity(context2);
                                    }
                                }).show();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if (type.intValue() == 2) {
                final ImageView imageView = (ImageView) holder.a(2131362100);
                final TextView textView = (TextView) holder.a(2131365026);
                if (imageView != null) {
                    final long j2 = 800;
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.mainActivity.MainBannerPagerAdapter$bindData$$inlined$singleClick$default$2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j2 || (imageView instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                                Function0<Unit> mListener = this.getMListener();
                                if (mListener != null) {
                                    mListener.invoke();
                                }
                            }
                        }
                    });
                }
                if (textView != null) {
                    textView.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#7f000000", "#7f000000", 11, (GradientDrawable.Orientation) null, 8, (Object) null));
                }
                if (data.getData() instanceof MainActivityData) {
                    Object data2 = data.getData();
                    Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type com.qiahao.nextvideo.data.mainActivity.MainActivityData");
                    MainActivityData mainActivityData = (MainActivityData) data2;
                    if (imageView != null) {
                        ImageKtxKt.loadImage$default(imageView, mainActivityData.getFloatPicUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
                    }
                    Long deadlineTimestamp = mainActivityData.getDeadlineTimestamp();
                    long longValue = deadlineTimestamp != null ? deadlineTimestamp.longValue() : 0L;
                    AppService service = AppController.INSTANCE.getService();
                    final long serverTime = longValue - ((service != null ? service.getServerTime() : 0L) * 1000);
                    if (textView != null) {
                        textView.setText(HiloUtils.INSTANCE.formatRemainingTime2(serverTime));
                    }
                    if (this.isStart) {
                        CountDownTimer countDownTimer = this.countDownTimer;
                        if (countDownTimer != null) {
                            countDownTimer.cancel();
                        }
                        CountDownTimer countDownTimer2 = new CountDownTimer(serverTime) { // from class: com.qiahao.nextvideo.ui.mainActivity.MainBannerPagerAdapter$bindData$3
                            @Override // android.os.CountDownTimer
                            public void onFinish() {
                                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "main_activity_data", "", (String) null, 4, (Object) null);
                                cf.c.c().l(new EventBusKey("REFRESH_HOME_MAIN_ACTIVITY", (Object) null, 2, (DefaultConstructorMarker) null));
                            }

                            @Override // android.os.CountDownTimer
                            public void onTick(long millisUntilFinished) {
                                TextView textView2 = textView;
                                if (textView2 != null) {
                                    textView2.setText(HiloUtils.INSTANCE.formatRemainingTime2(millisUntilFinished));
                                }
                            }
                        };
                        this.countDownTimer = countDownTimer2;
                        countDownTimer2.start();
                        return;
                    }
                    release();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
