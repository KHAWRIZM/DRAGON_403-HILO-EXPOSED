package com.qiahao.nextvideo.ui.mainActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c5.g;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.mainActivity.MainActivityItem;
import com.qiahao.nextvideo.data.mainActivity.MainAwardData;
import com.qiahao.nextvideo.utilities.google.pay.WalletPay;
import com.qiahao.nextvideo.view.StaticGradientTextView;
import com.zhpan.bannerview.e;
import com.zhpan.bannerview.f;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0015¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0004R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/qiahao/nextvideo/ui/mainActivity/MainActivityAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/mainActivity/MainActivityItem;", "<init>", "()V", "Lcom/zhpan/bannerview/f;", "holder", "data", "", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/mainActivity/MainActivityItem;II)V", "Lcom/qiahao/nextvideo/data/mainActivity/MainAwardData;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "viewGroup", "refreshItem", "(Lcom/qiahao/nextvideo/data/mainActivity/MainAwardData;Landroidx/constraintlayout/widget/ConstraintLayout;)V", "viewType", "getLayoutId", "(I)I", "release", "", "mBgUrl", "Ljava/lang/String;", "getMBgUrl", "()Ljava/lang/String;", "setMBgUrl", "(Ljava/lang/String;)V", "", "mTime", "Ljava/lang/Long;", "getMTime", "()Ljava/lang/Long;", "setMTime", "(Ljava/lang/Long;)V", "mContent", "getMContent", "setMContent", "", "Landroid/os/CountDownTimer;", "countDownTimers", "Ljava/util/Map;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainActivityAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivityAdapter.kt\ncom/qiahao/nextvideo/ui/mainActivity/MainActivityAdapter\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,172:1\n439#2:173\n439#2:174\n439#2:175\n439#2:176\n61#3,9:177\n61#3,9:186\n1869#4,2:195\n*S KotlinDebug\n*F\n+ 1 MainActivityAdapter.kt\ncom/qiahao/nextvideo/ui/mainActivity/MainActivityAdapter\n*L\n68#1:173\n71#1:174\n72#1:175\n73#1:176\n105#1:177,9\n113#1:186,9\n169#1:195,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MainActivityAdapter extends e {

    @Nullable
    private String mBgUrl;

    @Nullable
    private Long mTime;

    @NotNull
    private String mContent = "";

    @NotNull
    private final Map<Integer, CountDownTimer> countDownTimers = new LinkedHashMap();

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_main_activity;
    }

    @Nullable
    public final String getMBgUrl() {
        return this.mBgUrl;
    }

    @NotNull
    public final String getMContent() {
        return this.mContent;
    }

    @Nullable
    public final Long getMTime() {
        return this.mTime;
    }

    public final void refreshItem(@Nullable MainAwardData data, @Nullable ConstraintLayout viewGroup) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        String str;
        String str2;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        Long l = null;
        if (viewGroup != null) {
            imageView = (ImageView) viewGroup.findViewById(2131363157);
        } else {
            imageView = null;
        }
        if (viewGroup != null) {
            imageView2 = (ImageView) viewGroup.findViewById(R.id.dataImage);
        } else {
            imageView2 = null;
        }
        if (viewGroup != null) {
            textView = (TextView) viewGroup.findViewById(2131365189);
        } else {
            textView = null;
        }
        if (imageView != null) {
            if (data == null || (str2 = data.getPicUrl()) == null) {
                str2 = "";
            }
            ImageKtxKt.loadImage$default(imageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        }
        if (textView != null) {
            if (data == null || (str = data.getName()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        if (data != null) {
            l = data.getDuration();
        }
        if (l != null && l.longValue() == 3) {
            if (imageView2 != null) {
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(imageView2.getContext(), R.drawable.main_activity_three));
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        if (l != null && l.longValue() == 7) {
            if (imageView2 != null) {
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(imageView2.getContext(), R.drawable.main_activity_seven));
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        if (l != null && l.longValue() == 10) {
            if (imageView2 != null) {
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(imageView2.getContext(), R.drawable.main_activity_ten));
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        if (l != null && l.longValue() == 30) {
            if (imageView2 != null) {
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(imageView2.getContext(), R.drawable.main_activity_thirty));
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                return;
            }
            return;
        }
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    public final void release() {
        Iterator<T> it = this.countDownTimers.values().iterator();
        while (it.hasNext()) {
            ((CountDownTimer) it.next()).cancel();
        }
        this.countDownTimers.clear();
    }

    public final void setMBgUrl(@Nullable String str) {
        this.mBgUrl = str;
    }

    public final void setMContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMTime(@Nullable Long l) {
        this.mTime = l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.TextView, com.qiahao.nextvideo.view.StaticGradientTextView] */
    /* JADX WARN: Type inference failed for: r1v33 */
    @Override // com.zhpan.bannerview.e
    @SuppressLint({"SetTextI18n"})
    public void bindData(@Nullable f holder, @Nullable final MainActivityItem data, int position, int pageSize) {
        ?? r1;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3;
        ConstraintLayout constraintLayout4;
        ImageView imageView;
        ConstraintLayout constraintLayout5;
        MainAwardData mainAwardData;
        List<MainAwardData> awards;
        List<MainAwardData> awards2;
        ConstraintLayout constraintLayout6;
        MainAwardData mainAwardData2;
        List<MainAwardData> awards3;
        List<MainAwardData> awards4;
        ConstraintLayout constraintLayout7;
        MainAwardData mainAwardData3;
        List<MainAwardData> awards5;
        List<MainAwardData> awards6;
        ConstraintLayout constraintLayout8;
        MainAwardData mainAwardData4;
        List<MainAwardData> awards7;
        String stringById;
        View a = holder != null ? holder.a(R.id.topBg) : null;
        final TextView textView = holder != null ? (TextView) holder.a(R.id.countDown) : null;
        ImageView imageView2 = holder != null ? (ImageView) holder.a(R.id.help) : null;
        ImageView imageView3 = holder != null ? (ImageView) holder.a(R.id.topTitle) : null;
        View a2 = holder != null ? holder.a(R.id.diamondBg) : null;
        ImageView imageView4 = holder != null ? (ImageView) holder.a(R.id.diamondImage) : null;
        ConstraintLayout constraintLayout9 = holder != null ? (ConstraintLayout) holder.a(R.id.oneItem) : null;
        ConstraintLayout constraintLayout10 = holder != null ? (ConstraintLayout) holder.a(R.id.twoItem) : null;
        ConstraintLayout constraintLayout11 = holder != null ? (ConstraintLayout) holder.a(R.id.threeItem) : null;
        ConstraintLayout constraintLayout12 = holder != null ? (ConstraintLayout) holder.a(R.id.fourItem) : null;
        StaticGradientTextView staticGradientTextView = holder != null ? (StaticGradientTextView) holder.a(R.id.confirmText) : null;
        ImageView imageView5 = holder != null ? (ImageView) holder.a(R.id.confirmBg) : null;
        if (a != null) {
            a.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33D329FE", "#33D329FE", 20, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        if (imageView3 != null) {
            r1 = staticGradientTextView;
            constraintLayout = constraintLayout12;
            constraintLayout2 = constraintLayout11;
            constraintLayout3 = constraintLayout10;
            constraintLayout4 = constraintLayout9;
            ImageKtxKt.loadImage$default(imageView3, this.mBgUrl, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        } else {
            r1 = staticGradientTextView;
            constraintLayout = constraintLayout12;
            constraintLayout2 = constraintLayout11;
            constraintLayout3 = constraintLayout10;
            constraintLayout4 = constraintLayout9;
        }
        if (a2 != null) {
            a2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#FFFAEF", "#FFFAEF", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        if (imageView4 != null) {
            ImageKtxKt.loadImage$default(imageView4, data != null ? data.getDiamondNumPicUrl() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        }
        int i = 0;
        if (imageView5 != null) {
            imageView5.setImageDrawable(androidx.core.content.a.getDrawable(imageView5.getContext(), data != null ? Intrinsics.areEqual(data.getHasGetReward(), Boolean.TRUE) : false ? R.drawable.main_activity_button_default : R.drawable.main_activity_button_select));
        }
        if (r1 != 0) {
            if (data != null ? Intrinsics.areEqual(data.getHasGetReward(), Boolean.FALSE) : false) {
                Integer charge = data.getCharge();
                stringById = "$" + ((charge != null ? charge.intValue() : 0) / 100.0f);
            } else {
                stringById = ResourcesKtxKt.getStringById(this, 2131952587);
            }
            r1.setText(stringById);
        }
        if (data != null ? Intrinsics.areEqual(data.getHasGetReward(), Boolean.TRUE) : false) {
            if (r1 != 0) {
                r1.setGradientColors(new int[]{Color.parseColor("#ffffff"), Color.parseColor("#ffffff")});
            }
        } else if (r1 != 0) {
            r1.setGradientColors(new int[]{Color.parseColor("#FFFFEFBD"), Color.parseColor("#FFFFC300"), Color.parseColor("#FFFFECAE")});
        }
        if ((data == null || (awards7 = data.getAwards()) == null || !(awards7.isEmpty() ^ true)) ? false : true) {
            List<MainAwardData> awards8 = data.getAwards();
            if (awards8 != null) {
                mainAwardData4 = awards8.get(0);
                constraintLayout8 = constraintLayout4;
            } else {
                constraintLayout8 = constraintLayout4;
                mainAwardData4 = null;
            }
            refreshItem(mainAwardData4, constraintLayout8);
        }
        if (((data == null || (awards6 = data.getAwards()) == null) ? 0 : awards6.size()) > 1) {
            if (data == null || (awards5 = data.getAwards()) == null) {
                constraintLayout7 = constraintLayout3;
                mainAwardData3 = null;
            } else {
                mainAwardData3 = awards5.get(1);
                constraintLayout7 = constraintLayout3;
            }
            refreshItem(mainAwardData3, constraintLayout7);
        }
        if (((data == null || (awards4 = data.getAwards()) == null) ? 0 : awards4.size()) > 2) {
            if (data == null || (awards3 = data.getAwards()) == null) {
                constraintLayout6 = constraintLayout2;
                mainAwardData2 = null;
            } else {
                mainAwardData2 = awards3.get(2);
                constraintLayout6 = constraintLayout2;
            }
            refreshItem(mainAwardData2, constraintLayout6);
        }
        if (data != null && (awards2 = data.getAwards()) != null) {
            i = awards2.size();
        }
        if (i > 3) {
            if (data == null || (awards = data.getAwards()) == null) {
                constraintLayout5 = constraintLayout;
                mainAwardData = null;
            } else {
                mainAwardData = awards.get(3);
                constraintLayout5 = constraintLayout;
            }
            refreshItem(mainAwardData, constraintLayout5);
        }
        CountDownTimer countDownTimer = this.countDownTimers.get(Integer.valueOf(position));
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        Long l = this.mTime;
        long longValue = l != null ? l.longValue() : 0L;
        AppService service = AppController.INSTANCE.getService();
        final long serverTime = longValue - ((service != null ? service.getServerTime() : 0L) * 1000);
        if (serverTime > 0) {
            CountDownTimer countDownTimer2 = new CountDownTimer(serverTime) { // from class: com.qiahao.nextvideo.ui.mainActivity.MainActivityAdapter$bindData$countDownTimer$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    TextView textView2 = textView;
                    if (textView2 != null) {
                        textView2.setText(ResourcesKtxKt.getStringById(this, 2131952392) + ":" + HiloUtils.INSTANCE.formatRemainingTime(millisUntilFinished));
                    }
                }
            };
            this.countDownTimers.put(Integer.valueOf(position), countDownTimer2);
            countDownTimer2.start();
        }
        if (imageView2 != null) {
            final long j = 800;
            imageView = imageView5;
            final ImageView imageView6 = imageView2;
            final ImageView imageView7 = imageView2;
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.mainActivity.MainActivityAdapter$bindData$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView6) > j || (imageView6 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView6, currentTimeMillis);
                        Context context = imageView7.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        TipDialog tipContent = new TipDialog(context).setTipContent(this.getMContent());
                        tipContent.getTipText().setGravity(8388611);
                        tipContent.hideCancel(true).show();
                    }
                }
            });
        } else {
            imageView = imageView5;
        }
        if (imageView != null) {
            final long j2 = 800;
            final ImageView imageView8 = imageView;
            final ImageView imageView9 = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.mainActivity.MainActivityAdapter$bindData$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    boolean z;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView8) > j2 || (imageView8 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView8, currentTimeMillis);
                        MainActivityItem mainActivityItem = data;
                        boolean z2 = false;
                        if (mainActivityItem != null) {
                            z = Intrinsics.areEqual(mainActivityItem.isCanRecharge(), Boolean.FALSE);
                        } else {
                            z = false;
                        }
                        if (z) {
                            Context context = imageView9.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131953314)).hideCancel(true).show();
                            return;
                        }
                        MainActivityItem mainActivityItem2 = data;
                        if (mainActivityItem2 != null) {
                            z2 = Intrinsics.areEqual(mainActivityItem2.getHasGetReward(), Boolean.FALSE);
                        }
                        if (z2) {
                            WalletPay walletPay = WalletPay.INSTANCE;
                            String productId = data.getProductId();
                            if (productId == null) {
                                productId = "";
                            }
                            walletPay.checkWriteList(productId);
                        }
                    }
                }
            });
        }
    }
}
