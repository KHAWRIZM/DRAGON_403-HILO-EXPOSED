package com.qiahao.nextvideo.ui.videocall;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.date.DateUtils;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces;
import com.qiahao.nextvideo.data.model.VideoResultData;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.ActivityVideoResultBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.dialog.UserMenuDialog;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoResultActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityVideoResultBinding;", "<init>", "()V", "", "initData", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/nextvideo/data/model/VideoResultData;", "resultData", "refreshData", "(Lcom/qiahao/nextvideo/data/model/VideoResultData;)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/data/model/VideoResultData;", "getResultData", "()Lcom/qiahao/nextvideo/data/model/VideoResultData;", "setResultData", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoResultActivity extends HiloBaseBindingActivity<ActivityVideoResultBinding> {

    @NotNull
    public static final String ENTER_MATCH = "match";

    @NotNull
    public static final String ENTER_TYPE = "enter_type";

    @NotNull
    public static final String ENTER_VIDEO = "video";

    @NotNull
    public static final String VIDEO_MATCH_UNIQUE_ID = "matchUniqueID";

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    @Nullable
    private VideoResultData resultData;

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        String stringExtra = getIntent().getStringExtra(VIDEO_MATCH_UNIQUE_ID);
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra(ENTER_TYPE);
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        if (Intrinsics.areEqual(str, "video")) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().videoEnd(stringExtra), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.b0
                public final Object invoke(Object obj) {
                    Unit initData$lambda$5;
                    initData$lambda$5 = VideoResultActivity.initData$lambda$5(VideoResultActivity.this, (ApiResponse) obj);
                    return initData$lambda$5;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.c0
                public final Object invoke(Object obj) {
                    Unit initData$lambda$6;
                    initData$lambda$6 = VideoResultActivity.initData$lambda$6((Throwable) obj);
                    return initData$lambda$6;
                }
            }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().matchTalkingEnd(stringExtra, 1), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.d0
                public final Object invoke(Object obj) {
                    Unit initData$lambda$8;
                    initData$lambda$8 = VideoResultActivity.initData$lambda$8(VideoResultActivity.this, (ApiResponse) obj);
                    return initData$lambda$8;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.e0
                public final Object invoke(Object obj) {
                    Unit initData$lambda$9;
                    initData$lambda$9 = VideoResultActivity.initData$lambda$9((Throwable) obj);
                    return initData$lambda$9;
                }
            }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(VideoResultActivity videoResultActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        VideoResultData videoResultData = (VideoResultData) apiResponse.getData();
        if (videoResultData != null) {
            videoResultActivity.refreshData(videoResultData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$8(VideoResultActivity videoResultActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        VideoResultData videoResultData = (VideoResultData) apiResponse.getData();
        if (videoResultData != null) {
            videoResultActivity.refreshData(videoResultData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$9(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$0(VideoResultActivity videoResultActivity, int i, int i2) {
        videoResultActivity.getBinding().bar.setLayoutParams(new ConstraintLayout.b(-1, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onInitialize$lambda$1(VideoResultActivity videoResultActivity, View view) {
        if (HiloUtils.INSTANCE.notFastClick()) {
            videoResultActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onInitialize$lambda$3(final VideoResultActivity videoResultActivity, View view) {
        String str;
        User otherUser;
        if (HiloUtils.INSTANCE.notFastClick()) {
            VideoResultData videoResultData = videoResultActivity.resultData;
            if (videoResultData == null || (otherUser = videoResultData.getOtherUser()) == null || (str = otherUser.getExternalId()) == null) {
                str = "";
            }
            final UserMenuDialog userMenuDialog = new UserMenuDialog(videoResultActivity, str);
            userMenuDialog.setHideProfile(true);
            userMenuDialog.setHideDelete(true);
            userMenuDialog.setListener(new UserMenuInterfaces() { // from class: com.qiahao.nextvideo.ui.videocall.VideoResultActivity$onInitialize$3$1$1
                @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
                public void onClickBlock(String uid) {
                    Intrinsics.checkNotNullParameter(uid, "uid");
                    FeedbackService.INSTANCE.getShared().getReportEventRelay().accept(uid);
                    VideoResultActivity.this.finish();
                }

                @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
                public void onClickDelete() {
                }

                @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
                public void onClickDeleteSvip10() {
                    UserMenuInterfaces.DefaultImpls.onClickDeleteSvip10(this);
                }

                @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
                public void onClickPinned() {
                    UserMenuInterfaces.DefaultImpls.onClickPinned(this);
                }

                @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
                public void onClickProfile(String uid) {
                    Intrinsics.checkNotNullParameter(uid, "uid");
                }

                @Override // com.qiahao.nextvideo.data.interfaces.UserMenuInterfaces
                public void onClickReport(String uid) {
                    Intrinsics.checkNotNullParameter(uid, "uid");
                    new ReportWhiteDialog(VideoResultActivity.this).setListener(new VideoResultActivity$onInitialize$3$1$1$onClickReport$1(VideoResultActivity.this, userMenuDialog)).show();
                }
            });
            userMenuDialog.show();
        }
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_video_result;
    }

    @Nullable
    public final VideoResultData getResultData() {
        return this.resultData;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = getBinding().bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.f0
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$0;
                onInitialize$lambda$0 = VideoResultActivity.onInitialize$lambda$0(VideoResultActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$0;
            }
        });
        getBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoResultActivity.onInitialize$lambda$1(VideoResultActivity.this, view2);
            }
        });
        getBinding().reportImage.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoResultActivity.onInitialize$lambda$3(VideoResultActivity.this, view2);
            }
        });
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void refreshData(@NotNull VideoResultData resultData) {
        String str;
        String str2;
        int i;
        int i2;
        long j;
        String str3;
        Country countryInfo;
        Long birthday;
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        this.resultData = resultData;
        AppCompatImageView appCompatImageView = ((ActivityVideoResultBinding) getBinding()).userAvatar;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
        User otherUser = resultData.getOtherUser();
        String str4 = null;
        if (otherUser != null) {
            str = otherUser.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
        AppCompatTextView appCompatTextView = ((ActivityVideoResultBinding) getBinding()).nickName;
        User otherUser2 = resultData.getOtherUser();
        if (otherUser2 == null || (str2 = otherUser2.getNick()) == null) {
            str2 = "";
        }
        appCompatTextView.setText(str2);
        GenderAgeTextView genderAgeTextView = ((ActivityVideoResultBinding) getBinding()).ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        User otherUser3 = resultData.getOtherUser();
        if (otherUser3 != null && otherUser3.getSex() == 1) {
            i = R.drawable.icon_boy;
        } else {
            i = R.drawable.icon_girl;
        }
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, androidx.core.content.a.getDrawable(this, i));
        GenderAgeTextView genderAgeTextView2 = ((ActivityVideoResultBinding) getBinding()).ageTextView;
        User otherUser4 = resultData.getOtherUser();
        if (otherUser4 != null && otherUser4.getSex() == 1) {
            i2 = R.drawable.bg_age_male;
        } else {
            i2 = R.drawable.bg_age_female;
        }
        genderAgeTextView2.setBackgroundResource(i2);
        AppCompatTextView appCompatTextView2 = ((ActivityVideoResultBinding) getBinding()).ageTextView;
        GroupService.Companion companion = GroupService.INSTANCE;
        User otherUser5 = resultData.getOtherUser();
        long j2 = 0;
        if (otherUser5 != null && (birthday = otherUser5.getBirthday()) != null) {
            j = birthday.longValue();
        } else {
            j = 0;
        }
        appCompatTextView2.setText(companion.changeAge(j));
        ImageView imageView = ((ActivityVideoResultBinding) getBinding()).countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        User otherUser6 = resultData.getOtherUser();
        if (otherUser6 != null) {
            str3 = otherUser6.getCountryIcon();
        } else {
            str3 = null;
        }
        ImageKtxKt.loadImage$default(imageView, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        AppCompatTextView appCompatTextView3 = ((ActivityVideoResultBinding) getBinding()).countryName;
        User otherUser7 = resultData.getOtherUser();
        if (otherUser7 != null && (countryInfo = otherUser7.getCountryInfo()) != null) {
            str4 = countryInfo.getShortName();
        }
        appCompatTextView3.setText(str4);
        AppCompatTextView appCompatTextView4 = ((ActivityVideoResultBinding) getBinding()).time;
        DateUtils dateUtils = DateUtils.INSTANCE;
        Integer talkDuration = resultData.getTalkDuration();
        if (talkDuration != null) {
            j2 = talkDuration.intValue();
        }
        appCompatTextView4.setText(dateUtils.format123Time(j2));
        ((ActivityVideoResultBinding) getBinding()).revenueNum.setText(String.valueOf(resultData.getTalkBean()));
        ((ActivityVideoResultBinding) getBinding()).proceedsNum.setText(String.valueOf(resultData.getGiftBean()));
        User otherUser8 = resultData.getOtherUser();
        if (otherUser8 != null && otherUser8.isVip()) {
            ((ActivityVideoResultBinding) getBinding()).vip.setVisibility(0);
        } else {
            ((ActivityVideoResultBinding) getBinding()).vip.setVisibility(8);
        }
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setResultData(@Nullable VideoResultData videoResultData) {
        this.resultData = videoResultData;
    }
}
