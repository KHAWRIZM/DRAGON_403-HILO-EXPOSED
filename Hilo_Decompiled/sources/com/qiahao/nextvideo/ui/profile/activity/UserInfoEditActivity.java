package com.qiahao.nextvideo.ui.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.core.loading.ILoading;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EditEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.EditCountryData;
import com.qiahao.nextvideo.data.model.EditUserTextDataUIModel;
import com.qiahao.nextvideo.data.model.UserPictureResponseBean;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityUserInfoEditBinding;
import com.qiahao.nextvideo.ui.profile.ChangeSexDialog;
import com.qiahao.nextvideo.ui.profile.MyGridLayoutManager;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;
import com.qiahao.nextvideo.ui.userdetail.UserDetailPicItemDecoration;
import com.qiahao.nextvideo.ui.userdetail.UserDetailPictureAdapter;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.StorageUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.yalantis.ucrop.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u0012J\u000f\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\u0004J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0014¢\u0006\u0004\b%\u0010\u0004R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R6\u00100\u001a\u0016\u0012\u0004\u0012\u00020.\u0018\u00010-j\n\u0012\u0004\u0012\u00020.\u0018\u0001`/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R2\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u000f0-j\b\u0012\u0004\u0012\u00020\u000f`/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00101\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\"\u0010@\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b@\u0010B\"\u0004\bC\u0010\u000eR\u0017\u0010E\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H¨\u0006J"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/UserInfoEditActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityUserInfoEditBinding;", "<init>", "()V", "", "initView", "showAgeSwitchViewPressed", "setRecyclerViewData", "initRecyclerView", "checkUserNobel", "", "isGif", "uploadPicture", "(Z)V", "", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "startUpload", "(Ljava/lang/String;)V", "url", "Ljava/io/File;", "file", "addUserPicture", "(Ljava/lang/String;Ljava/io/File;)V", "ossFileKey", "updateUserHeadPicture", "change", "getPhotoData", "updateImAvatar", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/base_common/model/eventBus/EditEvent;", "event", "onEditEvent", "(Lcom/qiahao/base_common/model/eventBus/EditEvent;)V", "onDestroy", "Lcom/qiahao/base_common/model/common/User;", "mUser", "Lcom/qiahao/base_common/model/common/User;", "getMUser", "()Lcom/qiahao/base_common/model/common/User;", "setMUser", "(Lcom/qiahao/base_common/model/common/User;)V", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/UserPictureResponseBean;", "Lkotlin/collections/ArrayList;", "mPhotoList", "Ljava/util/ArrayList;", "getMPhotoList", "()Ljava/util/ArrayList;", "setMPhotoList", "(Ljava/util/ArrayList;)V", "Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapter;", "adapter", "Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapter;", "setAdapter", "(Lcom/qiahao/nextvideo/ui/userdetail/UserDetailPictureAdapter;)V", "photoList", "getPhotoList", "setPhotoList", "isUpdateHeadImage", "Z", "()Z", "setUpdateHeadImage", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUserInfoEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserInfoEditActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/UserInfoEditActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,473:1\n1869#2,2:474\n1#3:476\n*S KotlinDebug\n*F\n+ 1 UserInfoEditActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/UserInfoEditActivity\n*L\n207#1:474,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserInfoEditActivity extends HiloBaseBindingActivity<ActivityUserInfoEditBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String PHOTO_LIST = "photo_list";

    @NotNull
    public static final String USER = "user";

    @Nullable
    private UserDetailPictureAdapter adapter;
    private boolean isUpdateHeadImage;

    @Nullable
    private ArrayList<UserPictureResponseBean> mPhotoList;

    @Nullable
    private User mUser;

    @NotNull
    private ArrayList<String> photoList = new ArrayList<>();

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/UserInfoEditActivity$Companion;", "", "<init>", "()V", "USER", "", "PHOTO_LIST", "start", "", "context", "Landroid/content/Context;", "user", "Lcom/qiahao/base_common/model/common/User;", "photoList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/UserPictureResponseBean;", "Lkotlin/collections/ArrayList;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull User user, @Nullable ArrayList<UserPictureResponseBean> photoList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(user, "user");
            Intent intent = new Intent(context, (Class<?>) UserInfoEditActivity.class);
            intent.putExtra("user", (Parcelable) user);
            intent.putExtra(UserInfoEditActivity.PHOTO_LIST, photoList);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final void addUserPicture(String url, File file) {
        ArrayList arrayList = new ArrayList();
        int size = this.photoList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.photoList.get(i));
        }
        arrayList.add(url);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchSetUserPhotos$default(UserService.INSTANCE.getShared(), DataExternalKt.arrayListToString(arrayList), null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.q2
            public final Object invoke(Object obj) {
                Unit addUserPicture$lambda$22;
                addUserPicture$lambda$22 = UserInfoEditActivity.addUserPicture$lambda$22(UserInfoEditActivity.this, (ApiResponse) obj);
                return addUserPicture$lambda$22;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.r2
            public final Object invoke(Object obj) {
                Unit addUserPicture$lambda$23;
                addUserPicture$lambda$23 = UserInfoEditActivity.addUserPicture$lambda$23(UserInfoEditActivity.this, (Throwable) obj);
                return addUserPicture$lambda$23;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.s2
            public final Object invoke() {
                Unit addUserPicture$lambda$24;
                addUserPicture$lambda$24 = UserInfoEditActivity.addUserPicture$lambda$24(UserInfoEditActivity.this);
                return addUserPicture$lambda$24;
            }
        }, false, 8, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit addUserPicture$lambda$22(UserInfoEditActivity userInfoEditActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            userInfoEditActivity.getPhotoData(true);
        } else {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String message = apiResponse.getMessage();
            if (message == null) {
                message = ResourcesKtxKt.getStringById(userInfoEditActivity, 2131954177);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, userInfoEditActivity, message, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit addUserPicture$lambda$23(UserInfoEditActivity userInfoEditActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(userInfoEditActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, userInfoEditActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addUserPicture$lambda$24(UserInfoEditActivity userInfoEditActivity) {
        ILoading.DefaultImpls.dismissLoading$default(userInfoEditActivity, (Integer) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUserNobel() {
        int i;
        NobleInfo noble;
        Integer level;
        User user = UserStore.INSTANCE.getShared().getUser();
        boolean z = false;
        if (user != null && (noble = user.getNoble()) != null && (level = noble.getLevel()) != null) {
            i = level.intValue();
        } else {
            i = 0;
        }
        if (i >= 6) {
            z = true;
        }
        uploadPicture(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getPhotoData(final boolean change) {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.fetchUserPhotos(str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.i2
            public final Object invoke(Object obj) {
                Unit photoData$lambda$26;
                photoData$lambda$26 = UserInfoEditActivity.getPhotoData$lambda$26(UserInfoEditActivity.this, change, (ApiResponse) obj);
                return photoData$lambda$26;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.j2
            public final Object invoke(Object obj) {
                Unit photoData$lambda$27;
                photoData$lambda$27 = UserInfoEditActivity.getPhotoData$lambda$27(UserInfoEditActivity.this, (Throwable) obj);
                return photoData$lambda$27;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    static /* synthetic */ void getPhotoData$default(UserInfoEditActivity userInfoEditActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        userInfoEditActivity.getPhotoData(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPhotoData$lambda$26(UserInfoEditActivity userInfoEditActivity, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        userInfoEditActivity.photoList.clear();
        List list = (List) apiResponse.getData();
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                userInfoEditActivity.photoList.add(((UserPictureResponseBean) list.get(i)).getPhoto_url());
            }
            UserDetailPictureAdapter userDetailPictureAdapter = userInfoEditActivity.adapter;
            if (userDetailPictureAdapter != null) {
                userDetailPictureAdapter.setData(userInfoEditActivity.photoList);
            }
            if (userInfoEditActivity.photoList.size() > 0 && userInfoEditActivity.isUpdateHeadImage) {
                String str = userInfoEditActivity.photoList.get(0);
                Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                userInfoEditActivity.updateImAvatar(str);
            }
            cf.c.c().l(new EditEvent("photo", list));
        }
        if (z) {
            UserStore.fetchUserDetailInfo$default(UserStore.INSTANCE.getShared(), false, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getPhotoData$lambda$27(UserInfoEditActivity userInfoEditActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(userInfoEditActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, userInfoEditActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initRecyclerView() {
        RecyclerView recyclerView = ((ActivityUserInfoEditBinding) getBinding()).picRecycler;
        MyGridLayoutManager myGridLayoutManager = new MyGridLayoutManager(this, 3);
        int i = 0;
        myGridLayoutManager.setScrollEnabled(false);
        recyclerView.setLayoutManager(myGridLayoutManager);
        recyclerView.addItemDecoration(new UserDetailPicItemDecoration());
        UserDetailPictureAdapter userDetailPictureAdapter = new UserDetailPictureAdapter(new UserInfoEditActivity$initRecyclerView$1$1(this));
        this.adapter = userDetailPictureAdapter;
        User user = this.mUser;
        if (user != null) {
            i = user.getSex();
        }
        userDetailPictureAdapter.setSex(i);
        recyclerView.setAdapter(this.adapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str;
        String string;
        String str2;
        String str3;
        String str4;
        Country countryInfo;
        String icon;
        Country countryInfo2;
        Integer isShowAge;
        this.mUser = getIntent().getParcelableExtra("user");
        this.mPhotoList = (ArrayList) getIntent().getParcelableExtra(PHOTO_LIST);
        if (this.mUser == null) {
            finish();
        }
        Toolbar toolbar = ((ActivityUserInfoEditBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        boolean z = false;
        setStatusBarTopOrBottom(toolbar, false);
        ((ActivityUserInfoEditBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoEditActivity.this.finish();
            }
        });
        ((ActivityUserInfoEditBinding) getBinding()).countryCellLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoEditActivity.initView$lambda$1(UserInfoEditActivity.this, view);
            }
        });
        ((ActivityUserInfoEditBinding) getBinding()).nicknameCellLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.m2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoEditActivity.initView$lambda$2(UserInfoEditActivity.this, view);
            }
        });
        ((ActivityUserInfoEditBinding) getBinding()).signatureCellLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoEditActivity.initView$lambda$3(UserInfoEditActivity.this, view);
            }
        });
        ((ActivityUserInfoEditBinding) getBinding()).sexCellLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoEditActivity.initView$lambda$10(UserInfoEditActivity.this, view);
            }
        });
        ((ActivityUserInfoEditBinding) getBinding()).showAgeSwitchView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoEditActivity.this.showAgeSwitchViewPressed();
            }
        });
        SwitchButton switchButton = ((ActivityUserInfoEditBinding) getBinding()).showAgeSwitchView;
        User user = this.mUser;
        if (user != null && (isShowAge = user.isShowAge()) != null && isShowAge.intValue() == 1) {
            z = true;
        }
        switchButton.setChecked(z);
        AppCompatTextView appCompatTextView = ((ActivityUserInfoEditBinding) getBinding()).nicknameTextView;
        User user2 = this.mUser;
        if (user2 != null) {
            str = user2.getNick();
        } else {
            str = null;
        }
        appCompatTextView.setText(str);
        AppCompatTextView appCompatTextView2 = ((ActivityUserInfoEditBinding) getBinding()).sexTextView;
        User user3 = this.mUser;
        if (user3 != null && user3.getSex() == 1) {
            string = getString(2131953316);
        } else {
            string = getString(2131952747);
        }
        appCompatTextView2.setText(string);
        AppCompatTextView appCompatTextView3 = ((ActivityUserInfoEditBinding) getBinding()).signatureTextView;
        User user4 = this.mUser;
        if (user4 == null || (str2 = user4.getDescription()) == null) {
            str2 = "";
        }
        appCompatTextView3.setText(str2);
        AppCompatTextView appCompatTextView4 = ((ActivityUserInfoEditBinding) getBinding()).countryTextView;
        User user5 = this.mUser;
        if (user5 == null || (countryInfo2 = user5.getCountryInfo()) == null || (str3 = countryInfo2.getName()) == null) {
            str3 = "";
        }
        appCompatTextView4.setText(str3);
        AppCompatImageView appCompatImageView = ((ActivityUserInfoEditBinding) getBinding()).countrySymbolImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countrySymbolImageView");
        User user6 = this.mUser;
        if (user6 == null || (countryInfo = user6.getCountryInfo()) == null || (icon = countryInfo.getIcon()) == null) {
            str4 = "";
        } else {
            str4 = icon;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, str4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        initRecyclerView();
        setRecyclerViewData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$1(UserInfoEditActivity userInfoEditActivity, View view) {
        SelectCountryActivity.INSTANCE.start(userInfoEditActivity, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$10(final UserInfoEditActivity userInfoEditActivity, View view) {
        final ChangeSexDialog changeSexDialog = new ChangeSexDialog(userInfoEditActivity);
        changeSexDialog.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.k2
            public final Object invoke(Object obj) {
                Unit initView$lambda$10$lambda$9$lambda$8;
                initView$lambda$10$lambda$9$lambda$8 = UserInfoEditActivity.initView$lambda$10$lambda$9$lambda$8(UserInfoEditActivity.this, changeSexDialog, ((Integer) obj).intValue());
                return initView$lambda$10$lambda$9$lambda$8;
            }
        });
        changeSexDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$10$lambda$9$lambda$8(final UserInfoEditActivity userInfoEditActivity, final ChangeSexDialog changeSexDialog, final int i) {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && i != user.getSex()) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.updateUserInformation$default(UserService.INSTANCE.getShared(), null, null, null, null, null, Integer.valueOf(i), 31, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.e2
                public final Object invoke(Object obj) {
                    Unit initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$5;
                    initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$5 = UserInfoEditActivity.initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$5(UserInfoEditActivity.this, i, changeSexDialog, (ApiResponse) obj);
                    return initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$5;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.f2
                public final Object invoke(Object obj) {
                    Unit initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6;
                    initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6 = UserInfoEditActivity.initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6(ChangeSexDialog.this, (Throwable) obj);
                    return initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6;
                }
            }, (Function0) null, false, 12, (Object) null), userInfoEditActivity.compositeDisposable);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$5(UserInfoEditActivity userInfoEditActivity, int i, ChangeSexDialog changeSexDialog, ApiResponse apiResponse) {
        String string;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserSummaryInfo userSummaryInfo = (UserSummaryInfo) apiResponse.getData();
        if (userSummaryInfo != null) {
            UserStore.INSTANCE.getShared().refreshUserInfo(userSummaryInfo);
        }
        User user = userInfoEditActivity.mUser;
        if (user != null) {
            user.setSex(i);
        }
        AppCompatTextView appCompatTextView = ((ActivityUserInfoEditBinding) userInfoEditActivity.getBinding()).sexTextView;
        if (i == 1) {
            string = userInfoEditActivity.getString(2131953316);
        } else {
            string = userInfoEditActivity.getString(2131952747);
        }
        appCompatTextView.setText(string);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, changeSexDialog.getContext(), ResourcesKtxKt.getStringById(changeSexDialog, 2131954176), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initView$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6(ChangeSexDialog changeSexDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, changeSexDialog.getContext(), ResourcesKtxKt.getStringById(changeSexDialog, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(UserInfoEditActivity userInfoEditActivity, View view) {
        String str;
        String stringById = ResourcesKtxKt.getStringById(userInfoEditActivity, 2131953527);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getNick()) == null) {
            str = "";
        }
        EditNameOrSignatureActivity.INSTANCE.start(userInfoEditActivity, new EditUserTextDataUIModel(stringById, str, 16, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$3(UserInfoEditActivity userInfoEditActivity, View view) {
        String str;
        String stringById = ResourcesKtxKt.getStringById(userInfoEditActivity, 2131954091);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getDescription()) == null) {
            str = "";
        }
        EditNameOrSignatureActivity.INSTANCE.start(userInfoEditActivity, new EditUserTextDataUIModel(stringById, str, 120, 2));
    }

    private final void setRecyclerViewData() {
        this.photoList.clear();
        ArrayList<UserPictureResponseBean> arrayList = this.mPhotoList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<UserPictureResponseBean> arrayList2 = this.mPhotoList;
            if (arrayList2 != null) {
                Iterator<T> it = arrayList2.iterator();
                while (it.hasNext()) {
                    this.photoList.add(((UserPictureResponseBean) it.next()).getPhoto_url());
                }
            }
            UserDetailPictureAdapter userDetailPictureAdapter = this.adapter;
            if (userDetailPictureAdapter != null) {
                userDetailPictureAdapter.setData(this.photoList);
                return;
            }
            return;
        }
        getPhotoData$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showAgeSwitchViewPressed() {
        Integer isShowAge;
        int i = 2;
        boolean z = true;
        if (!((ActivityUserInfoEditBinding) getBinding()).showAgeSwitchView.isChecked()) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && user.isVip()) {
                UserService shared = UserService.INSTANCE.getShared();
                if (((ActivityUserInfoEditBinding) getBinding()).showAgeSwitchView.isChecked()) {
                    i = 1;
                }
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.updateUserInformation$default(shared, null, null, null, null, Integer.valueOf(i), null, 47, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.t2
                    public final Object invoke(Object obj) {
                        Unit showAgeSwitchViewPressed$lambda$13;
                        showAgeSwitchViewPressed$lambda$13 = UserInfoEditActivity.showAgeSwitchViewPressed$lambda$13((ApiResponse) obj);
                        return showAgeSwitchViewPressed$lambda$13;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.b2
                    public final Object invoke(Object obj) {
                        Unit showAgeSwitchViewPressed$lambda$14;
                        showAgeSwitchViewPressed$lambda$14 = UserInfoEditActivity.showAgeSwitchViewPressed$lambda$14(UserInfoEditActivity.this, (Throwable) obj);
                        return showAgeSwitchViewPressed$lambda$14;
                    }
                }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
                return;
            }
            SwitchButton switchButton = ((ActivityUserInfoEditBinding) getBinding()).showAgeSwitchView;
            User user2 = this.mUser;
            if (user2 == null || (isShowAge = user2.isShowAge()) == null || isShowAge.intValue() != 1) {
                z = false;
            }
            switchButton.setChecked(z);
            new VipViewDialog(3, this).show();
            return;
        }
        UserService shared2 = UserService.INSTANCE.getShared();
        if (((ActivityUserInfoEditBinding) getBinding()).showAgeSwitchView.isChecked()) {
            i = 1;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.updateUserInformation$default(shared2, null, null, null, null, Integer.valueOf(i), null, 47, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.c2
            public final Object invoke(Object obj) {
                Unit showAgeSwitchViewPressed$lambda$16;
                showAgeSwitchViewPressed$lambda$16 = UserInfoEditActivity.showAgeSwitchViewPressed$lambda$16((ApiResponse) obj);
                return showAgeSwitchViewPressed$lambda$16;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.d2
            public final Object invoke(Object obj) {
                Unit showAgeSwitchViewPressed$lambda$17;
                showAgeSwitchViewPressed$lambda$17 = UserInfoEditActivity.showAgeSwitchViewPressed$lambda$17(UserInfoEditActivity.this, (Throwable) obj);
                return showAgeSwitchViewPressed$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAgeSwitchViewPressed$lambda$13(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserSummaryInfo userSummaryInfo = (UserSummaryInfo) apiResponse.getData();
        if (userSummaryInfo != null) {
            UserStore.INSTANCE.getShared().refreshUserInfo(userSummaryInfo);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showAgeSwitchViewPressed$lambda$14(UserInfoEditActivity userInfoEditActivity, Throwable th) {
        Integer isShowAge;
        Intrinsics.checkNotNullParameter(th, "it");
        SwitchButton switchButton = ((ActivityUserInfoEditBinding) userInfoEditActivity.getBinding()).showAgeSwitchView;
        User user = userInfoEditActivity.mUser;
        boolean z = false;
        if (user != null && (isShowAge = user.isShowAge()) != null && isShowAge.intValue() == 1) {
            z = true;
        }
        switchButton.setChecked(z);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoEditActivity, ResourcesKtxKt.getStringById(userInfoEditActivity, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAgeSwitchViewPressed$lambda$16(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserSummaryInfo userSummaryInfo = (UserSummaryInfo) apiResponse.getData();
        if (userSummaryInfo != null) {
            UserStore.INSTANCE.getShared().refreshUserInfo(userSummaryInfo);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showAgeSwitchViewPressed$lambda$17(UserInfoEditActivity userInfoEditActivity, Throwable th) {
        Integer isShowAge;
        Intrinsics.checkNotNullParameter(th, "it");
        SwitchButton switchButton = ((ActivityUserInfoEditBinding) userInfoEditActivity.getBinding()).showAgeSwitchView;
        User user = userInfoEditActivity.mUser;
        boolean z = false;
        if (user != null && (isShowAge = user.isShowAge()) != null && isShowAge.intValue() == 1) {
            z = true;
        }
        switchButton.setChecked(z);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoEditActivity, ResourcesKtxKt.getStringById(userInfoEditActivity, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void startUpload(String path) {
        String str;
        final File fileCompat = StorageUtils.INSTANCE.getFileCompat(path);
        if (fileCompat != null && fileCompat.exists()) {
            if (StringsKt.endsWith$default(path, FileUtils.GIF, false, 2, (Object) null)) {
                str = FileUtils.GIF;
            } else {
                str = ".png";
            }
            if (Intrinsics.areEqual(str, FileUtils.GIF) && fileCompat.length() > 5242880) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131953110), Arrays.copyOf(new Object[]{5}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, this, format, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
            ILoading.DefaultImpls.showLoading$default(this, (Integer) null, (CharSequence) null, 3, (Object) null);
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AliCloudService.INSTANCE.getShared().uploadFileToAWS(AliCloudService.OSS_FOLDER_AVATAR, fileCompat, str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.g2
                public final Object invoke(Object obj) {
                    Unit startUpload$lambda$20;
                    startUpload$lambda$20 = UserInfoEditActivity.startUpload$lambda$20(UserInfoEditActivity.this, fileCompat, (Pair) obj);
                    return startUpload$lambda$20;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.h2
                public final Object invoke(Object obj) {
                    Unit startUpload$lambda$21;
                    startUpload$lambda$21 = UserInfoEditActivity.startUpload$lambda$21(UserInfoEditActivity.this, (Throwable) obj);
                    return startUpload$lambda$21;
                }
            }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit startUpload$lambda$20(UserInfoEditActivity userInfoEditActivity, File file, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            if (userInfoEditActivity.isUpdateHeadImage) {
                userInfoEditActivity.updateUserHeadPicture((String) pair.getSecond(), file);
            } else {
                userInfoEditActivity.addUserPicture((String) pair.getSecond(), file);
            }
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userInfoEditActivity, ResourcesKtxKt.getStringById(userInfoEditActivity, 2131952667), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            ILoading.DefaultImpls.dismissLoading$default(userInfoEditActivity, (Integer) null, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit startUpload$lambda$21(UserInfoEditActivity userInfoEditActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ILoading.DefaultImpls.dismissLoading$default(userInfoEditActivity, (Integer) null, 1, (Object) null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(userInfoEditActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, userInfoEditActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void updateImAvatar(String ossFileKey) {
        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
        v2TIMUserFullInfo.setFaceUrl(ossFileKey);
        V2TIMManager.getInstance().setSelfInfo(v2TIMUserFullInfo, null);
    }

    private final void updateUserHeadPicture(String ossFileKey, File file) {
        ArrayList arrayList = new ArrayList();
        if (this.photoList.isEmpty()) {
            arrayList.add(ossFileKey);
        } else {
            int size = this.photoList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(this.photoList.get(i));
            }
        }
        arrayList.set(0, ossFileKey);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserInfoEditActivity$updateUserHeadPicture$1(file, arrayList, this, null), 3, (Object) null);
    }

    private final void uploadPicture(boolean isGif) {
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(false).isMGif(isGif).isMCompress(false).build(), new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.ui.profile.activity.UserInfoEditActivity$uploadPicture$1
            public void onCancel() {
            }

            public void onResult(ArrayList<LocalMedia> result) {
                String compressPath;
                if (result != null && (!result.isEmpty())) {
                    LocalMedia localMedia = (LocalMedia) CollectionsKt.first(result);
                    if (localMedia.isCut() && !localMedia.isCompressed()) {
                        compressPath = localMedia.getCutPath();
                    } else if (!localMedia.isCompressed() && (!localMedia.isCut() || !localMedia.isCompressed())) {
                        if (!TextUtils.isEmpty(localMedia.getRealPath())) {
                            compressPath = localMedia.getRealPath();
                        } else {
                            compressPath = localMedia.getPath();
                        }
                    } else {
                        compressPath = localMedia.getCompressPath();
                    }
                    UserInfoEditActivity userInfoEditActivity = UserInfoEditActivity.this;
                    Intrinsics.checkNotNull(compressPath);
                    userInfoEditActivity.startUpload(compressPath);
                }
            }
        });
    }

    static /* synthetic */ void uploadPicture$default(UserInfoEditActivity userInfoEditActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        userInfoEditActivity.uploadPicture(z);
    }

    @Nullable
    public final UserDetailPictureAdapter getAdapter() {
        return this.adapter;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_user_info_edit;
    }

    @Nullable
    public final ArrayList<UserPictureResponseBean> getMPhotoList() {
        return this.mPhotoList;
    }

    @Nullable
    public final User getMUser() {
        return this.mUser;
    }

    @NotNull
    public final ArrayList<String> getPhotoList() {
        return this.photoList;
    }

    /* renamed from: isUpdateHeadImage, reason: from getter */
    public final boolean getIsUpdateHeadImage() {
        return this.isUpdateHeadImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.compositeDisposable.d();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onEditEvent(@NotNull EditEvent event) {
        Country countryInfo;
        Country countryInfo2;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        int hashCode = type.hashCode();
        if (hashCode != 3373707) {
            if (hashCode != 957831062) {
                if (hashCode == 1073584312 && type.equals(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE)) {
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EditUserTextDataUIModel");
                    EditUserTextDataUIModel editUserTextDataUIModel = (EditUserTextDataUIModel) data;
                    User user = this.mUser;
                    if (user != null) {
                        user.setDescription(editUserTextDataUIModel.getEditInputBoxText());
                    }
                    getBinding().signatureTextView.setText(editUserTextDataUIModel.getEditInputBoxText());
                    return;
                }
                return;
            }
            if (type.equals("country")) {
                Object data2 = event.getData();
                Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EditCountryData");
                EditCountryData editCountryData = (EditCountryData) data2;
                User user2 = this.mUser;
                String str = "";
                if (user2 != null && (countryInfo2 = user2.getCountryInfo()) != null) {
                    String name = editCountryData.getName();
                    if (name == null) {
                        name = "";
                    }
                    countryInfo2.setName(name);
                }
                User user3 = this.mUser;
                if (user3 != null && (countryInfo = user3.getCountryInfo()) != null) {
                    String icon = editCountryData.getIcon();
                    if (icon != null) {
                        str = icon;
                    }
                    countryInfo.setIcon(str);
                }
                getBinding().countryTextView.setText(editCountryData.getName());
                AppCompatImageView appCompatImageView = getBinding().countrySymbolImageView;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countrySymbolImageView");
                ImageKtxKt.loadImage$default(appCompatImageView, editCountryData.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                return;
            }
            return;
        }
        if (type.equals("name")) {
            Object data3 = event.getData();
            Intrinsics.checkNotNull(data3, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.EditUserTextDataUIModel");
            EditUserTextDataUIModel editUserTextDataUIModel2 = (EditUserTextDataUIModel) data3;
            User user4 = this.mUser;
            if (user4 != null) {
                user4.setNick(editUserTextDataUIModel2.getEditInputBoxText());
            }
            getBinding().nicknameTextView.setText(editUserTextDataUIModel2.getEditInputBoxText());
        }
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    public final void setAdapter(@Nullable UserDetailPictureAdapter userDetailPictureAdapter) {
        this.adapter = userDetailPictureAdapter;
    }

    public final void setMPhotoList(@Nullable ArrayList<UserPictureResponseBean> arrayList) {
        this.mPhotoList = arrayList;
    }

    public final void setMUser(@Nullable User user) {
        this.mUser = user;
    }

    public final void setPhotoList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.photoList = arrayList;
    }

    public final void setUpdateHeadImage(boolean z) {
        this.isUpdateHeadImage = z;
    }
}
