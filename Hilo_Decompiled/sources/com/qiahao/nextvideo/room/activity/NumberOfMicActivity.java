package com.qiahao.nextvideo.room.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityNumberOfMicBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001%B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/NumberOfMicActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityNumberOfMicBinding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "micNumType", "", "groupId", "", "changeMicNumber", "(ILjava/lang/String;)V", "getLayoutResId", "()I", "onInitialize", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "numberType", "", "isCheck", "selectMic", "(IZ)V", "mCurrencyMicType", "I", "getMCurrencyMicType", "setMCurrencyMicType", "(I)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NumberOfMicActivity extends HiloBaseBindingActivity<ActivityNumberOfMicBinding> implements View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private nd.a mCompositeDisposable;
    private int mCurrencyMicType;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/activity/NumberOfMicActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "requestCode", "", "micNumType", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, int requestCode, int micNumType) {
            Intrinsics.checkNotNullParameter(context, "context");
            ((Activity) context).startActivityForResult(new Intent(context, (Class<?>) NumberOfMicActivity.class), requestCode);
        }

        private Companion() {
        }
    }

    private final void changeMicNumber(final int micNumType, String groupId) {
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().changeMicNum(micNumType, true, groupId), new Function1() { // from class: com.qiahao.nextvideo.room.activity.x0
            public final Object invoke(Object obj) {
                Unit changeMicNumber$lambda$1;
                changeMicNumber$lambda$1 = NumberOfMicActivity.changeMicNumber$lambda$1(NumberOfMicActivity.this, micNumType, (ApiResponse) obj);
                return changeMicNumber$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.activity.y0
            public final Object invoke(Object obj) {
                Unit changeMicNumber$lambda$2;
                changeMicNumber$lambda$2 = NumberOfMicActivity.changeMicNumber$lambda$2(NumberOfMicActivity.this, (Throwable) obj);
                return changeMicNumber$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null);
        nd.a aVar = this.mCompositeDisposable;
        Intrinsics.checkNotNull(aVar);
        RxUtilsKt.addTo(observeOnMainThread$default, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit changeMicNumber$lambda$1(NumberOfMicActivity numberOfMicActivity, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        numberOfMicActivity.setResult(-1, new Intent().putExtra(GroupSettingActivity.TYPE_ROOM_CHANGE_DATA, i));
        numberOfMicActivity.finish();
        HiloToasty.Companion companion = HiloToasty.Companion;
        String string = numberOfMicActivity.getString(2131954176);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, numberOfMicActivity, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit changeMicNumber$lambda$2(NumberOfMicActivity numberOfMicActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = numberOfMicActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, numberOfMicActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$0(NumberOfMicActivity numberOfMicActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = numberOfMicActivity.getBinding().titleBar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, i, 0, 0);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void selectMic$default(NumberOfMicActivity numberOfMicActivity, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        numberOfMicActivity.selectMic(i, z);
    }

    @JvmStatic
    public static final void start(@NotNull Context context, int i, int i2) {
        INSTANCE.start(context, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_number_of_mic;
    }

    @Nullable
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    public final int getMCurrencyMicType() {
        return this.mCurrencyMicType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362039) {
            if (id2 != 2131362419) {
                switch (id2) {
                    case 2131365027:
                        selectMic$default(this, 5, false, 2, null);
                        return;
                    case R.id.text10 /* 2131365028 */:
                        selectMic$default(this, 2, false, 2, null);
                        return;
                    case R.id.text11 /* 2131365029 */:
                        selectMic$default(this, 11, false, 2, null);
                        return;
                    case R.id.text12 /* 2131365030 */:
                        selectMic$default(this, 12, false, 2, null);
                        return;
                    case R.id.text13 /* 2131365031 */:
                        selectMic$default(this, 13, false, 2, null);
                        return;
                    case R.id.text15 /* 2131365032 */:
                        selectMic$default(this, 15, false, 2, null);
                        return;
                    case R.id.text16 /* 2131365033 */:
                        selectMic$default(this, 16, false, 2, null);
                        return;
                    case R.id.text17 /* 2131365034 */:
                        selectMic$default(this, 17, false, 2, null);
                        return;
                    case R.id.text18 /* 2131365035 */:
                        selectMic$default(this, 18, false, 2, null);
                        return;
                    case 2131365036:
                        selectMic$default(this, 10, false, 2, null);
                        return;
                    case R.id.text20 /* 2131365037 */:
                        selectMic$default(this, 20, false, 2, null);
                        return;
                    case R.id.text3 /* 2131365038 */:
                        selectMic$default(this, 3, false, 2, null);
                        return;
                    case R.id.text4 /* 2131365039 */:
                        selectMic$default(this, 4, false, 2, null);
                        return;
                    case R.id.text5 /* 2131365040 */:
                        selectMic$default(this, 1, false, 2, null);
                        return;
                    case R.id.text6 /* 2131365041 */:
                        selectMic$default(this, 6, false, 2, null);
                        return;
                    case R.id.text7 /* 2131365042 */:
                        selectMic$default(this, 7, false, 2, null);
                        return;
                    case R.id.text8 /* 2131365043 */:
                        selectMic$default(this, 8, false, 2, null);
                        return;
                    case R.id.text9 /* 2131365044 */:
                        selectMic$default(this, 9, false, 2, null);
                        return;
                    default:
                        return;
                }
            }
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            int mCurrentRoomMicType = meetingRoomManager.getMCurrentRoomMicType();
            int i = this.mCurrencyMicType;
            if (mCurrentRoomMicType == i) {
                return;
            }
            changeMicNumber(i, meetingRoomManager.getMGroupId());
            return;
        }
        finish();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.room.activity.w0
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$0;
                onInitialize$lambda$0 = NumberOfMicActivity.onInitialize$lambda$0(NumberOfMicActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$0;
            }
        });
        setStatusBarIconColor(false);
        this.mCompositeDisposable = new nd.a();
        getBinding().setClick(this);
        int mCurrentRoomMicType = MeetingRoomManager.INSTANCE.getMCurrentRoomMicType();
        this.mCurrencyMicType = mCurrentRoomMicType;
        selectMic(mCurrentRoomMicType, false);
    }

    public final void selectMic(int numberType, boolean isCheck) {
        if (isCheck && this.mCurrencyMicType == numberType) {
            return;
        }
        this.mCurrencyMicType = numberType;
        getBinding().text1.setSelected(false);
        getBinding().text2.setSelected(false);
        getBinding().text3.setSelected(false);
        getBinding().text4.setSelected(false);
        getBinding().text5.setSelected(false);
        getBinding().text6.setSelected(false);
        getBinding().text7.setSelected(false);
        getBinding().text8.setSelected(false);
        getBinding().text9.setSelected(false);
        getBinding().text10.setSelected(false);
        getBinding().text11.setSelected(false);
        getBinding().text12.setSelected(false);
        getBinding().text13.setSelected(false);
        getBinding().text15.setSelected(false);
        getBinding().text16.setSelected(false);
        getBinding().text17.setSelected(false);
        getBinding().text18.setSelected(false);
        getBinding().text20.setSelected(false);
        switch (numberType) {
            case 1:
                getBinding().text5.setSelected(true);
                RoundedImageView roundedImageView = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic5), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 2:
                getBinding().text10.setSelected(true);
                RoundedImageView roundedImageView2 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView2, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic10), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 3:
                getBinding().text3.setSelected(true);
                RoundedImageView roundedImageView3 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView3, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic3), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 4:
                getBinding().text4.setSelected(true);
                RoundedImageView roundedImageView4 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView4, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic4), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 5:
                getBinding().text1.setSelected(true);
                RoundedImageView roundedImageView5 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView5, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView5, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 6:
                getBinding().text6.setSelected(true);
                RoundedImageView roundedImageView6 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView6, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView6, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic6), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 7:
                getBinding().text7.setSelected(true);
                RoundedImageView roundedImageView7 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView7, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView7, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic7), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 8:
                getBinding().text8.setSelected(true);
                RoundedImageView roundedImageView8 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView8, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView8, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic8), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 9:
                getBinding().text9.setSelected(true);
                RoundedImageView roundedImageView9 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView9, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView9, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic9), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 10:
                getBinding().text2.setSelected(true);
                RoundedImageView roundedImageView10 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView10, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView10, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic2), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 11:
                getBinding().text11.setSelected(true);
                RoundedImageView roundedImageView11 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView11, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView11, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic11), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 12:
                getBinding().text12.setSelected(true);
                RoundedImageView roundedImageView12 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView12, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView12, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic12), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 13:
                getBinding().text13.setSelected(true);
                RoundedImageView roundedImageView13 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView13, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView13, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic13), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 14:
            case 19:
            default:
                return;
            case 15:
                getBinding().text15.setSelected(true);
                RoundedImageView roundedImageView14 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView14, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView14, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic15), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 16:
                getBinding().text16.setSelected(true);
                RoundedImageView roundedImageView15 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView15, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView15, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic16), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 17:
                getBinding().text17.setSelected(true);
                RoundedImageView roundedImageView16 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView16, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView16, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic17), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 18:
                getBinding().text18.setSelected(true);
                RoundedImageView roundedImageView17 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView17, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView17, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic18), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            case 20:
                getBinding().text20.setSelected(true);
                RoundedImageView roundedImageView18 = getBinding().micTypeImage;
                Intrinsics.checkNotNullExpressionValue(roundedImageView18, "micTypeImage");
                ImageKtxKt.loadImage$default(roundedImageView18, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_type_mic20), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
        }
    }

    public final void setMCompositeDisposable(@Nullable nd.a aVar) {
        this.mCompositeDisposable = aVar;
    }

    public final void setMCurrencyMicType(int i) {
        this.mCurrencyMicType = i;
    }
}
