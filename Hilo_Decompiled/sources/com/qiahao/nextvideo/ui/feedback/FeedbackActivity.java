package com.qiahao.nextvideo.ui.feedback;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewControllerFeedbackBinding;
import com.qiahao.nextvideo.ui.feedback.FeedbackActivity;
import com.qiahao.nextvideo.ui.feedback.GridImageAdapter;
import com.tencent.qcloud.tuicore.TUIConstants;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.j0;
import io.reactivex.rxjava3.core.l0;
import io.reactivex.rxjava3.core.z;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.o;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u001b\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/ui/feedback/FeedbackActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ViewControllerFeedbackBinding;", "<init>", "()V", "", "submitButtonPressed1", "", "feedbackContentText", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "requestFeedBack", "(Ljava/lang/String;Ljava/lang/String;)V", "", "getLayoutResId", "()I", "onInitialize", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter;", "adapter", "Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter;", "Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$OnAddPicClickListener;", "onAddPicClickListener", "Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$OnAddPicClickListener;", "com/qiahao/nextvideo/ui/feedback/FeedbackActivity$inputBoxEditTextWatcher$1", "inputBoxEditTextWatcher", "Lcom/qiahao/nextvideo/ui/feedback/FeedbackActivity$inputBoxEditTextWatcher$1;", "Companion", "MyResultCallback", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFeedbackActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedbackActivity.kt\ncom/qiahao/nextvideo/ui/feedback/FeedbackActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1617#2,9:209\n1869#2:218\n1870#2:221\n1626#2:222\n1563#2:223\n1634#2,3:224\n1#3:219\n1#3:220\n*S KotlinDebug\n*F\n+ 1 FeedbackActivity.kt\ncom/qiahao/nextvideo/ui/feedback/FeedbackActivity\n*L\n111#1:209,9\n111#1:218\n111#1:221\n111#1:222\n130#1:223\n130#1:224,3\n111#1:220\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FeedbackActivity extends HiloBaseBindingActivity<ViewControllerFeedbackBinding> {

    @NotNull
    public static final String TAG = "Feedback";
    private GridImageAdapter adapter;

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    @NotNull
    private final GridImageAdapter.OnAddPicClickListener onAddPicClickListener = new GridImageAdapter.OnAddPicClickListener() { // from class: com.qiahao.nextvideo.ui.feedback.FeedbackActivity$onAddPicClickListener$1
        @Override // com.qiahao.nextvideo.ui.feedback.GridImageAdapter.OnAddPicClickListener
        public void onAddPicClick() {
            GridImageAdapter gridImageAdapter;
            GridImageAdapter gridImageAdapter2;
            PictureSelectorConfigures.Companion.Builder mMaxSelect = new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(true).isMEnableCrop(false).setMMaxSelect(6);
            gridImageAdapter = FeedbackActivity.this.adapter;
            GridImageAdapter gridImageAdapter3 = null;
            if (gridImageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                gridImageAdapter = null;
            }
            PictureSelectorConfigures build = mMaxSelect.setSelectList(gridImageAdapter.getData()).build();
            PictureSelector pictureSelector = PictureSelector.INSTANCE;
            gridImageAdapter2 = FeedbackActivity.this.adapter;
            if (gridImageAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                gridImageAdapter3 = gridImageAdapter2;
            }
            pictureSelector.selectorPicture(build, new FeedbackActivity.MyResultCallback(gridImageAdapter3));
        }
    };

    @NotNull
    private final FeedbackActivity$inputBoxEditTextWatcher$1 inputBoxEditTextWatcher = new TextWatcher() { // from class: com.qiahao.nextvideo.ui.feedback.FeedbackActivity$inputBoxEditTextWatcher$1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            ViewControllerFeedbackBinding binding;
            ViewControllerFeedbackBinding binding2;
            int i;
            binding = FeedbackActivity.this.getBinding();
            AppCompatTextView appCompatTextView = binding.feedbackContentLengthTextView;
            binding2 = FeedbackActivity.this.getBinding();
            Editable text = binding2.feedbackContentEditText.getText();
            if (text != null) {
                i = text.length();
            } else {
                i = 0;
            }
            appCompatTextView.setText(i + "/800");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/feedback/FeedbackActivity$MyResultCallback;", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "adapter", "Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter;", "<init>", "(Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter;)V", "mAdapterWeakReference", "Ljava/lang/ref/WeakReference;", "onResult", "", "result", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFeedbackActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedbackActivity.kt\ncom/qiahao/nextvideo/ui/feedback/FeedbackActivity$MyResultCallback\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1#2:209\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class MyResultCallback implements OnResultCallbackListener<LocalMedia> {

        @NotNull
        private final WeakReference<GridImageAdapter> mAdapterWeakReference;

        public MyResultCallback(@Nullable GridImageAdapter gridImageAdapter) {
            this.mAdapterWeakReference = new WeakReference<>(gridImageAdapter);
        }

        public void onCancel() {
        }

        public void onResult(@Nullable ArrayList<LocalMedia> result) {
            GridImageAdapter gridImageAdapter;
            if (result != null && (gridImageAdapter = this.mAdapterWeakReference.get()) != null) {
                gridImageAdapter.setList(result);
            }
            GridImageAdapter gridImageAdapter2 = this.mAdapterWeakReference.get();
            if (gridImageAdapter2 != null) {
                gridImageAdapter2.notifyDataSetChanged();
            }
        }
    }

    private final void requestFeedBack(String feedbackContentText, String path) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().feedback(feedbackContentText, path), new Function1() { // from class: com.qiahao.nextvideo.ui.feedback.k
            public final Object invoke(Object obj) {
                Unit requestFeedBack$lambda$12;
                requestFeedBack$lambda$12 = FeedbackActivity.requestFeedBack$lambda$12(FeedbackActivity.this, (ApiResponse) obj);
                return requestFeedBack$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.feedback.b
            public final Object invoke(Object obj) {
                Unit requestFeedBack$lambda$14;
                requestFeedBack$lambda$14 = FeedbackActivity.requestFeedBack$lambda$14(FeedbackActivity.this, (Throwable) obj);
                return requestFeedBack$lambda$14;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit requestFeedBack$lambda$12(FeedbackActivity feedbackActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, feedbackActivity, ResourcesKtxKt.getStringById(feedbackActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        feedbackActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit requestFeedBack$lambda$14(FeedbackActivity feedbackActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(feedbackActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, feedbackActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        HiloBaseActivity.dismissProgressDialog$default(feedbackActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.feedback.g
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"CheckResult"})
    public final void submitButtonPressed1() {
        Editable text = ((ViewControllerFeedbackBinding) getBinding()).feedbackContentEditText.getText();
        if (text != null && !StringsKt.isBlank(text)) {
            HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) this, (String) null, false, new Function0() { // from class: com.qiahao.nextvideo.ui.feedback.a
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, 3, (Object) null);
            final String valueOf = String.valueOf(((ViewControllerFeedbackBinding) getBinding()).feedbackContentEditText.getText());
            GridImageAdapter gridImageAdapter = this.adapter;
            if (gridImageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                gridImageAdapter = null;
            }
            if (gridImageAdapter.getData().isEmpty()) {
                requestFeedBack(valueOf, "");
                return;
            }
            i0 d = i0.d(new l0() { // from class: com.qiahao.nextvideo.ui.feedback.c
                public final void a(j0 j0Var) {
                    FeedbackActivity.submitButtonPressed1$lambda$7(FeedbackActivity.this, valueOf, j0Var);
                }
            });
            Intrinsics.checkNotNullExpressionValue(d, "create(...)");
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(d, new Function1() { // from class: com.qiahao.nextvideo.ui.feedback.d
                public final Object invoke(Object obj) {
                    Unit submitButtonPressed1$lambda$8;
                    submitButtonPressed1$lambda$8 = FeedbackActivity.submitButtonPressed1$lambda$8(FeedbackActivity.this, (ApiResponse) obj);
                    return submitButtonPressed1$lambda$8;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.feedback.e
                public final Object invoke(Object obj) {
                    Unit submitButtonPressed1$lambda$9;
                    submitButtonPressed1$lambda$9 = FeedbackActivity.submitButtonPressed1$lambda$9(FeedbackActivity.this, (Throwable) obj);
                    return submitButtonPressed1$lambda$9;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.ui.feedback.f
                public final Object invoke() {
                    Unit submitButtonPressed1$lambda$11;
                    submitButtonPressed1$lambda$11 = FeedbackActivity.submitButtonPressed1$lambda$11(FeedbackActivity.this);
                    return submitButtonPressed1$lambda$11;
                }
            }, false, 8, (Object) null), this.compositeDisposable);
            return;
        }
        HiloToasty.Companion companion = HiloToasty.Companion;
        String string = getString(2131953676);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, this, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit submitButtonPressed1$lambda$11(FeedbackActivity feedbackActivity) {
        HiloBaseActivity.dismissProgressDialog$default(feedbackActivity, false, new Function0() { // from class: com.qiahao.nextvideo.ui.feedback.j
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x001d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void submitButtonPressed1$lambda$7(final FeedbackActivity feedbackActivity, final String str, final j0 j0Var) {
        String compressPath;
        File file;
        Intrinsics.checkNotNullParameter(j0Var, "feedbackSingleEmitter");
        GridImageAdapter gridImageAdapter = feedbackActivity.adapter;
        if (gridImageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            gridImageAdapter = null;
        }
        List<LocalMedia> data = gridImageAdapter.getData();
        ArrayList<File> arrayList = new ArrayList();
        for (LocalMedia localMedia : data) {
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
            if (compressPath != null) {
                try {
                    file = new File(compressPath);
                } catch (Exception unused) {
                }
                if (file == null) {
                    arrayList.add(file);
                }
            }
            file = null;
            if (file == null) {
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (File file2 : arrayList) {
            AliCloudService shared = AliCloudService.INSTANCE.getShared();
            File absoluteFile = file2.getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
            arrayList2.add(AliCloudService.uploadFileToAWS$default(shared, AliCloudService.OSS_FOLDER_FEEDBACK, absoluteFile, null, 4, null).q());
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        z.zip(arrayList2, new o() { // from class: com.qiahao.nextvideo.ui.feedback.FeedbackActivity$submitButtonPressed1$2$1
            public final Object[] apply(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "args");
                return objArr;
            }
        }).subscribeOn(ke.a.b()).observeOn(ke.a.b()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.feedback.FeedbackActivity$submitButtonPressed1$2$2
            public final void accept(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "it");
                for (Object obj : objArr) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Pair<kotlin.Boolean, kotlin.String>");
                    Ref.ObjectRef<String> objectRef2 = objectRef;
                    objectRef2.element = objectRef2.element + ((Pair) obj).getSecond() + ",";
                }
                Log.d(FeedbackActivity.TAG, "submitButtonPressed1: " + objectRef.element);
                i0 k = UserService.INSTANCE.getShared().feedback(str, (String) objectRef.element).k(ke.a.b());
                final j0 j0Var2 = j0Var;
                pd.g gVar = new pd.g() { // from class: com.qiahao.nextvideo.ui.feedback.FeedbackActivity$submitButtonPressed1$2$2.1
                    public final void accept(ApiResponse<Object> apiResponse) {
                        Intrinsics.checkNotNullParameter(apiResponse, "it");
                        j0Var2.onSuccess(apiResponse);
                    }
                };
                final j0 j0Var3 = j0Var;
                nd.c n = k.n(gVar, new pd.g() { // from class: com.qiahao.nextvideo.ui.feedback.FeedbackActivity$submitButtonPressed1$2$2.2
                    public final void accept(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "it");
                        j0Var3.onError(th);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(n, "subscribe(...)");
                RxUtilsKt.addTo(n, feedbackActivity.getCompositeDisposable());
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.ui.feedback.FeedbackActivity$submitButtonPressed1$2$3
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                j0Var.onError(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit submitButtonPressed1$lambda$8(FeedbackActivity feedbackActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, feedbackActivity, ResourcesKtxKt.getStringById(feedbackActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        feedbackActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit submitButtonPressed1$lambda$9(FeedbackActivity feedbackActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(feedbackActivity, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, feedbackActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.view_controller_feedback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = ((ViewControllerFeedbackBinding) getBinding()).toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        GridImageAdapter gridImageAdapter = new GridImageAdapter(this, this.onAddPicClickListener);
        this.adapter = gridImageAdapter;
        gridImageAdapter.setSelectMax(6);
        ((ViewControllerFeedbackBinding) getBinding()).recycler.setLayoutManager(new FullyGridLayoutManager(this, 4, 1, false));
        ((ViewControllerFeedbackBinding) getBinding()).recycler.addItemDecoration(new GridSpacingItemDecoration(4, UiKtxKt.toPX(8), false));
        RecyclerView recyclerView = ((ViewControllerFeedbackBinding) getBinding()).recycler;
        GridImageAdapter gridImageAdapter2 = this.adapter;
        if (gridImageAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            gridImageAdapter2 = null;
        }
        recyclerView.setAdapter(gridImageAdapter2);
        ((ViewControllerFeedbackBinding) getBinding()).submitButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.feedback.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackActivity.this.submitButtonPressed1();
            }
        });
        ((ViewControllerFeedbackBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.feedback.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackActivity.this.finish();
            }
        });
        ((ViewControllerFeedbackBinding) getBinding()).feedbackContentEditText.addTextChangedListener(this.inputBoxEditTextWatcher);
    }
}
