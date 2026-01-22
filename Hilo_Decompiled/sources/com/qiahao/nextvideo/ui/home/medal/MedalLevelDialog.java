package com.qiahao.nextvideo.ui.home.medal;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MedalLevelUserHasBean;
import com.qiahao.nextvideo.data.model.MedalLevelUserHasBeanBody;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.DialogMedalLevelBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
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

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ#\u0010\u0011\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000bJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R*\u00103\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010B¨\u0006D"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/medal/MedalLevelDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogMedalLevelBinding;", "Landroid/content/Context;", "context", "", "medalType", "<init>", "(Landroid/content/Context;I)V", "", "getDataAfterShowView", "()V", "showButtonStatus", "initRecyclerView", "", "svgaUrl", "pic", "playSvgaOrShowPic", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserMedal", "medalLevel", "getTypeString", "(ILjava/lang/String;)Ljava/lang/String;", "getLayoutResId", "()I", "onInitialize", "", "isNeedFullScreen", "()Z", "getData", "updateLevelIndex", "dismiss", "I", "Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBeanBody;", "mMedalLevelUserHasBeanBody", "Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBeanBody;", "Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBean;", "mCurrentMedalLevelBean", "Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBean;", "getMCurrentMedalLevelBean", "()Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBean;", "setMCurrentMedalLevelBean", "(Lcom/qiahao/nextvideo/data/model/MedalLevelUserHasBean;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lkotlin/Function0;", "listener", "Lkotlin/jvm/functions/Function0;", "getListener", "()Lkotlin/jvm/functions/Function0;", "setListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/opensource/svgaplayer/SVGAParser;", "parser$delegate", "Lkotlin/Lazy;", "getParser", "()Lcom/opensource/svgaplayer/SVGAParser;", "parser", "Lcom/qiahao/nextvideo/ui/home/medal/MedalLevelAdapter;", "mMedalLevelAdapter$delegate", "getMMedalLevelAdapter", "()Lcom/qiahao/nextvideo/ui/home/medal/MedalLevelAdapter;", "mMedalLevelAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMedalLevelDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MedalLevelDialog.kt\ncom/qiahao/nextvideo/ui/home/medal/MedalLevelDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,287:1\n61#2,9:288\n61#2,9:297\n1869#3,2:306\n*S KotlinDebug\n*F\n+ 1 MedalLevelDialog.kt\ncom/qiahao/nextvideo/ui/home/medal/MedalLevelDialog\n*L\n60#1:288,9\n70#1:297,9\n107#1:306,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MedalLevelDialog extends BaseBindingDialog<DialogMedalLevelBinding> {

    @Nullable
    private Function0<Unit> listener;

    @NotNull
    private nd.a mCompositeDisposable;

    @Nullable
    private MedalLevelUserHasBean mCurrentMedalLevelBean;

    /* renamed from: mMedalLevelAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMedalLevelAdapter;

    @Nullable
    private MedalLevelUserHasBeanBody mMedalLevelUserHasBeanBody;
    private final int medalType;

    /* renamed from: parser$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy parser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MedalLevelDialog(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.medalType = i;
        this.mCompositeDisposable = new nd.a();
        this.parser = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.medal.k
            public final Object invoke() {
                SVGAParser parser_delegate$lambda$0;
                parser_delegate$lambda$0 = MedalLevelDialog.parser_delegate$lambda$0();
                return parser_delegate$lambda$0;
            }
        });
        this.mMedalLevelAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.medal.l
            public final Object invoke() {
                MedalLevelAdapter mMedalLevelAdapter_delegate$lambda$1;
                mMedalLevelAdapter_delegate$lambda$1 = MedalLevelDialog.mMedalLevelAdapter_delegate$lambda$1();
                return mMedalLevelAdapter_delegate$lambda$1;
            }
        });
    }

    public static final /* synthetic */ DialogMedalLevelBinding access$getBinding(MedalLevelDialog medalLevelDialog) {
        return (DialogMedalLevelBinding) medalLevelDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$5(MedalLevelDialog medalLevelDialog, ApiResponse apiResponse) {
        List<MedalLevelUserHasBean> list;
        int i;
        List<MedalLevelUserHasBean> medals;
        MedalLevelUserHasBean medalLevelUserHasBean;
        List<MedalLevelUserHasBean> medals2;
        List<MedalLevelUserHasBean> medals3;
        List<MedalLevelUserHasBean> medals4;
        List<MedalLevelUserHasBean> medals5;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MedalLevelUserHasBeanBody medalLevelUserHasBeanBody = (MedalLevelUserHasBeanBody) apiResponse.getData();
        if (medalLevelUserHasBeanBody != null && (medals5 = medalLevelUserHasBeanBody.getMedals()) != null && medals5.isEmpty()) {
            return Unit.INSTANCE;
        }
        medalLevelDialog.mMedalLevelUserHasBeanBody = (MedalLevelUserHasBeanBody) apiResponse.getData();
        MedalLevelAdapter mMedalLevelAdapter = medalLevelDialog.getMMedalLevelAdapter();
        MedalLevelUserHasBeanBody medalLevelUserHasBeanBody2 = (MedalLevelUserHasBeanBody) apiResponse.getData();
        MedalLevelUserHasBean medalLevelUserHasBean2 = null;
        if (medalLevelUserHasBeanBody2 != null) {
            list = medalLevelUserHasBeanBody2.getMedals();
        } else {
            list = null;
        }
        mMedalLevelAdapter.setList(list);
        MedalLevelUserHasBeanBody medalLevelUserHasBeanBody3 = medalLevelDialog.mMedalLevelUserHasBeanBody;
        if (medalLevelUserHasBeanBody3 != null && (medals4 = medalLevelUserHasBeanBody3.getMedals()) != null && medals4.isEmpty()) {
            return Unit.INSTANCE;
        }
        MedalLevelUserHasBean medalLevelUserHasBean3 = medalLevelDialog.mCurrentMedalLevelBean;
        if (medalLevelUserHasBean3 == null) {
            MedalLevelUserHasBeanBody medalLevelUserHasBeanBody4 = medalLevelDialog.mMedalLevelUserHasBeanBody;
            if (medalLevelUserHasBeanBody4 != null && (medals3 = medalLevelUserHasBeanBody4.getMedals()) != null) {
                i = medals3.size();
            } else {
                i = 0;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                MedalLevelUserHasBeanBody medalLevelUserHasBeanBody5 = medalLevelDialog.mMedalLevelUserHasBeanBody;
                if (medalLevelUserHasBeanBody5 != null && (medals2 = medalLevelUserHasBeanBody5.getMedals()) != null) {
                    medalLevelUserHasBean = medals2.get(i2);
                } else {
                    medalLevelUserHasBean = null;
                }
                if (medalLevelUserHasBean != null && !medalLevelUserHasBean.isHas()) {
                    medalLevelDialog.mCurrentMedalLevelBean = medalLevelUserHasBean;
                    break;
                }
                i2++;
            }
            if (medalLevelDialog.mCurrentMedalLevelBean == null) {
                MedalLevelUserHasBeanBody medalLevelUserHasBeanBody6 = medalLevelDialog.mMedalLevelUserHasBeanBody;
                if (medalLevelUserHasBeanBody6 != null && (medals = medalLevelUserHasBeanBody6.getMedals()) != null) {
                    medalLevelUserHasBean2 = medals.get(0);
                }
                medalLevelDialog.mCurrentMedalLevelBean = medalLevelUserHasBean2;
            }
        } else {
            Intrinsics.checkNotNull(medalLevelUserHasBean3);
            int id2 = medalLevelUserHasBean3.getId();
            MedalLevelUserHasBeanBody medalLevelUserHasBeanBody7 = medalLevelDialog.mMedalLevelUserHasBeanBody;
            Intrinsics.checkNotNull(medalLevelUserHasBeanBody7);
            for (MedalLevelUserHasBean medalLevelUserHasBean4 : medalLevelUserHasBeanBody7.getMedals()) {
                if (medalLevelUserHasBean4.getId() == id2) {
                    medalLevelDialog.mCurrentMedalLevelBean = medalLevelUserHasBean4;
                }
            }
        }
        medalLevelDialog.getDataAfterShowView();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void getDataAfterShowView() {
        long j;
        String str;
        MedalLevelUserHasBean medalLevelUserHasBean = this.mCurrentMedalLevelBean;
        if (medalLevelUserHasBean != null) {
            j = medalLevelUserHasBean.getThreshold();
        } else {
            j = 0;
        }
        ((DialogMedalLevelBinding) getBinding()).levelText.setText(getTypeString(this.medalType, String.valueOf(j)));
        MedalLevelUserHasBean medalLevelUserHasBean2 = this.mCurrentMedalLevelBean;
        String str2 = null;
        if (medalLevelUserHasBean2 != null) {
            str = medalLevelUserHasBean2.getSvgaUrl();
        } else {
            str = null;
        }
        MedalLevelUserHasBean medalLevelUserHasBean3 = this.mCurrentMedalLevelBean;
        if (medalLevelUserHasBean3 != null) {
            str2 = medalLevelUserHasBean3.getYesPicUrl();
        }
        playSvgaOrShowPic(str, str2);
        showButtonStatus();
        updateLevelIndex();
    }

    private final MedalLevelAdapter getMMedalLevelAdapter() {
        return (MedalLevelAdapter) this.mMedalLevelAdapter.getValue();
    }

    private final SVGAParser getParser() {
        return (SVGAParser) this.parser.getValue();
    }

    private final String getTypeString(int medalType, String medalLevel) {
        MedalLevelUserHasBean medalLevelUserHasBean;
        String desc;
        switch (medalType) {
            case 1:
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131954479), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format;
            case 2:
                String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131952205), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                return format2;
            case 3:
                String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131954039), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                return format3;
            case 4:
                String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131954046), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                return format4;
            case 5:
                String format5 = String.format(ResourcesKtxKt.getStringById(this, 2131954045), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                return format5;
            case 6:
                String format6 = String.format(ResourcesKtxKt.getStringById(this, 2131954041), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
                return format6;
            case 7:
                String format7 = String.format(ResourcesKtxKt.getStringById(this, 2131954262), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format7, "format(...)");
                return format7;
            case 8:
                String format8 = String.format(ResourcesKtxKt.getStringById(this, 2131953371), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format8, "format(...)");
                return format8;
            case 9:
                String format9 = String.format(ResourcesKtxKt.getStringById(this, 2131953360), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format9, "format(...)");
                return format9;
            case 10:
                String format10 = String.format(ResourcesKtxKt.getStringById(this, 2131953354), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format10, "format(...)");
                return format10;
            case 11:
                String format11 = String.format(ResourcesKtxKt.getStringById(this, 2131953361), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format11, "format(...)");
                return format11;
            case 12:
                String format12 = String.format(ResourcesKtxKt.getStringById(this, 2131953372), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format12, "format(...)");
                return format12;
            case 13:
                String format13 = String.format(ResourcesKtxKt.getStringById(this, 2131953378), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format13, "format(...)");
                return format13;
            case 14:
                String format14 = String.format(ResourcesKtxKt.getStringById(this, 2131953362), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format14, "format(...)");
                return format14;
            case 15:
                String format15 = String.format(ResourcesKtxKt.getStringById(this, 2131953364), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format15, "format(...)");
                return format15;
            case 16:
                String format16 = String.format(ResourcesKtxKt.getStringById(this, 2131953356), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format16, "format(...)");
                return format16;
            case 17:
                String format17 = String.format(ResourcesKtxKt.getStringById(this, 2131953375), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format17, "format(...)");
                return format17;
            case 18:
                String format18 = String.format(ResourcesKtxKt.getStringById(this, 2131953373), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format18, "format(...)");
                return format18;
            case 19:
                String format19 = String.format(ResourcesKtxKt.getStringById(this, 2131953376), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format19, "format(...)");
                return format19;
            case 20:
                String format20 = String.format(ResourcesKtxKt.getStringById(this, 2131953359), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format20, "format(...)");
                return format20;
            case 21:
                String format21 = String.format(ResourcesKtxKt.getStringById(this, 2131953363), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format21, "format(...)");
                return format21;
            case 22:
                String format22 = String.format(ResourcesKtxKt.getStringById(this, 2131953377), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format22, "format(...)");
                return format22;
            case 23:
                String format23 = String.format(ResourcesKtxKt.getStringById(this, 2131953366), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format23, "format(...)");
                return format23;
            case 24:
                String format24 = String.format(ResourcesKtxKt.getStringById(this, 2131953357), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format24, "format(...)");
                return format24;
            case 25:
                String format25 = String.format(ResourcesKtxKt.getStringById(this, 2131953355), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format25, "format(...)");
                return format25;
            case 26:
                String format26 = String.format(ResourcesKtxKt.getStringById(this, 2131953379), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format26, "format(...)");
                return format26;
            case 27:
                String format27 = String.format(ResourcesKtxKt.getStringById(this, 2131954434), Arrays.copyOf(new Object[]{medalLevel}, 1));
                Intrinsics.checkNotNullExpressionValue(format27, "format(...)");
                return format27;
            case 28:
                return ResourcesKtxKt.getStringById(this, 2131953185);
            case 29:
                return ResourcesKtxKt.getStringById(this, 2131953184);
            default:
                if (medalType < 30 || (medalLevelUserHasBean = this.mCurrentMedalLevelBean) == null || (desc = medalLevelUserHasBean.getDesc()) == null) {
                    return "";
                }
                return desc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getUserMedal() {
        MedalLevelUserHasBean medalLevelUserHasBean = this.mCurrentMedalLevelBean;
        if (medalLevelUserHasBean != null) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getMedalForUser(medalLevelUserHasBean.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.o
                public final Object invoke(Object obj) {
                    Unit userMedal$lambda$11;
                    userMedal$lambda$11 = MedalLevelDialog.getUserMedal$lambda$11(MedalLevelDialog.this, (ApiResponse) obj);
                    return userMedal$lambda$11;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.p
                public final Object invoke(Object obj) {
                    Unit userMedal$lambda$12;
                    userMedal$lambda$12 = MedalLevelDialog.getUserMedal$lambda$12(MedalLevelDialog.this, (Throwable) obj);
                    return userMedal$lambda$12;
                }
            }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getUserMedal$lambda$11(MedalLevelDialog medalLevelDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, medalLevelDialog.getContext(), ResourcesKtxKt.getStringById(medalLevelDialog, 2131953570), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        ((DialogMedalLevelBinding) medalLevelDialog.getBinding()).getMedalSvga.startAnimation();
        medalLevelDialog.getData();
        UserStore.INSTANCE.getShared().fetchUserDetailInfo(true);
        Function0<Unit> function0 = medalLevelDialog.listener;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getUserMedal$lambda$12(MedalLevelDialog medalLevelDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = medalLevelDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(medalLevelDialog, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView = ((DialogMedalLevelBinding) getBinding()).medalRecyclerView;
        recyclerView.setAdapter(getMMedalLevelAdapter());
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext(), 0, false));
        getMMedalLevelAdapter().addChildClickViewIds(new int[]{R.id.img_medal_level});
        getMMedalLevelAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.j
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MedalLevelDialog.initRecyclerView$lambda$8(MedalLevelDialog.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$8(MedalLevelDialog medalLevelDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.MedalLevelUserHasBean");
        medalLevelDialog.mCurrentMedalLevelBean = (MedalLevelUserHasBean) item;
        medalLevelDialog.getDataAfterShowView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MedalLevelAdapter mMedalLevelAdapter_delegate$lambda$1() {
        return new MedalLevelAdapter(R.layout.item_medal_level);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SVGAParser parser_delegate$lambda$0() {
        return SVGAParser.Companion.shareParser();
    }

    private final void playSvgaOrShowPic(String svgaUrl, String pic) {
        if (svgaUrl != null && svgaUrl.length() > 0) {
            ((DialogMedalLevelBinding) getBinding()).bigSvga.setVisibility(0);
            ((DialogMedalLevelBinding) getBinding()).bigPic.setVisibility(8);
            getParser().decodeFromURL(new URL(svgaUrl + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.home.medal.MedalLevelDialog$playSvgaOrShowPic$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    MedalLevelDialog.access$getBinding(MedalLevelDialog.this).bigSvga.stopAnimation(true);
                    MedalLevelDialog.access$getBinding(MedalLevelDialog.this).bigSvga.setImageDrawable(new SVGADrawable(videoItem));
                    MedalLevelDialog.access$getBinding(MedalLevelDialog.this).bigSvga.startAnimation();
                }

                public void onError() {
                }
            });
            return;
        }
        ((DialogMedalLevelBinding) getBinding()).bigSvga.setVisibility(8);
        ((DialogMedalLevelBinding) getBinding()).bigPic.setVisibility(0);
        ImageView imageView = ((DialogMedalLevelBinding) getBinding()).bigPic;
        Intrinsics.checkNotNullExpressionValue(imageView, "bigPic");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        lfit.setWidth(dimens.dpToPx(279));
        lfit.setHeight(dimens.dpToPx(231));
        Unit unit = Unit.INSTANCE;
        ImageUIModel displayImage = companion.displayImage(pic, lfit);
        displayImage.setPlaceholder(null);
        ViewUtilitiesKt.bind(imageView, displayImage);
    }

    private final void showButtonStatus() {
        boolean z;
        MedalLevelUserHasBean medalLevelUserHasBean;
        MedalLevelUserHasBean medalLevelUserHasBean2;
        TextView textView = ((DialogMedalLevelBinding) getBinding()).buttonActivity;
        MedalLevelUserHasBean medalLevelUserHasBean3 = this.mCurrentMedalLevelBean;
        if (medalLevelUserHasBean3 != null && !medalLevelUserHasBean3.isHas() && (medalLevelUserHasBean2 = this.mCurrentMedalLevelBean) != null && medalLevelUserHasBean2.getCanHas()) {
            z = true;
        } else {
            z = false;
        }
        textView.setSelected(z);
        MedalLevelUserHasBean medalLevelUserHasBean4 = this.mCurrentMedalLevelBean;
        if (medalLevelUserHasBean4 != null && medalLevelUserHasBean4.isHas() && (medalLevelUserHasBean = this.mCurrentMedalLevelBean) != null && medalLevelUserHasBean.getCanHas()) {
            ((DialogMedalLevelBinding) getBinding()).buttonActivity.setText(ResourcesKtxKt.getStringById(this, 2131953570));
        } else {
            ((DialogMedalLevelBinding) getBinding()).buttonActivity.setText(ResourcesKtxKt.getStringById(this, 2131951942));
        }
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
    }

    public final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getUserHasMedalList(this.medalType), new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.m
            public final Object invoke(Object obj) {
                Unit data$lambda$5;
                data$lambda$5 = MedalLevelDialog.getData$lambda$5(MedalLevelDialog.this, (ApiResponse) obj);
                return data$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.n
            public final Object invoke(Object obj) {
                Unit data$lambda$6;
                data$lambda$6 = MedalLevelDialog.getData$lambda$6((Throwable) obj);
                return data$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    protected int getLayoutResId() {
        return R.layout.dialog_medal_level;
    }

    @Nullable
    public final Function0<Unit> getListener() {
        return this.listener;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Nullable
    public final MedalLevelUserHasBean getMCurrentMedalLevelBean() {
        return this.mCurrentMedalLevelBean;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initRecyclerView();
        getData();
        final TextView textView = ((DialogMedalLevelBinding) getBinding()).buttonActivity;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.MedalLevelDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MedalLevelUserHasBean mCurrentMedalLevelBean;
                MedalLevelUserHasBean mCurrentMedalLevelBean2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    MedalLevelUserHasBean mCurrentMedalLevelBean3 = this.getMCurrentMedalLevelBean();
                    if (mCurrentMedalLevelBean3 != null && !mCurrentMedalLevelBean3.isHas() && (mCurrentMedalLevelBean2 = this.getMCurrentMedalLevelBean()) != null && !mCurrentMedalLevelBean2.getCanHas()) {
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131951943), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    MedalLevelUserHasBean mCurrentMedalLevelBean4 = this.getMCurrentMedalLevelBean();
                    if (mCurrentMedalLevelBean4 == null || !mCurrentMedalLevelBean4.isHas() || (mCurrentMedalLevelBean = this.getMCurrentMedalLevelBean()) == null || !mCurrentMedalLevelBean.getCanHas()) {
                        this.getUserMedal();
                    }
                }
            }
        });
        final FrameLayout frameLayout = ((DialogMedalLevelBinding) getBinding()).frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.MedalLevelDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    public final void setListener(@Nullable Function0<Unit> function0) {
        this.listener = function0;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMCurrentMedalLevelBean(@Nullable MedalLevelUserHasBean medalLevelUserHasBean) {
        this.mCurrentMedalLevelBean = medalLevelUserHasBean;
    }

    public final void updateLevelIndex() {
        long j;
        MedalLevelUserHasBean medalLevelUserHasBean = this.mCurrentMedalLevelBean;
        long j2 = 0;
        if (medalLevelUserHasBean != null) {
            j = medalLevelUserHasBean.getThreshold();
        } else {
            j = 0;
        }
        MedalLevelUserHasBeanBody medalLevelUserHasBeanBody = this.mMedalLevelUserHasBeanBody;
        if (medalLevelUserHasBeanBody != null) {
            j2 = medalLevelUserHasBeanBody.getNum();
        }
        ((DialogMedalLevelBinding) getBinding()).maxTextView.setText(String.valueOf(j));
        if (j2 > j) {
            j2 = j;
        }
        ((DialogMedalLevelBinding) getBinding()).currentTextView.setText(String.valueOf(j2));
        ProgressBar progressBar = ((DialogMedalLevelBinding) getBinding()).progressBar;
        progressBar.setMax(100);
        progressBar.setProgress((int) ((100 * j2) / j));
        if (j2 == j) {
            ((DialogMedalLevelBinding) getBinding()).currentTextView.setVisibility(8);
            return;
        }
        ((DialogMedalLevelBinding) getBinding()).currentTextView.setVisibility(0);
        int width = ((DialogMedalLevelBinding) getBinding()).progressBar.getWidth();
        float progress = (((DialogMedalLevelBinding) getBinding()).progressBar.getProgress() / ((DialogMedalLevelBinding) getBinding()).progressBar.getMax()) * width;
        ConstraintLayout.b layoutParams = ((DialogMedalLevelBinding) getBinding()).currentTextView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        float dpToPx = width - Dimens.INSTANCE.dpToPx(40);
        if (progress > dpToPx) {
            progress = dpToPx;
        }
        bVar.setMarginStart((int) progress);
        ((DialogMedalLevelBinding) getBinding()).currentTextView.setLayoutParams(bVar);
    }
}
