package com.qhqc.core.basic.picture.selector;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.luck.picture.lib.basic.PictureSelectionModel;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sf.f;
import sf.i;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\"#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper;", "Landroidx/lifecycle/LifecycleEventObserver;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callBack", "Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper$ICallback;", "getCallBack", "()Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper$ICallback;", "setCallBack", "(Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper$ICallback;)V", "isAddedObserver", "", "getPicture", "", "fragment", "Landroidx/fragment/app/Fragment;", "configures", "Lcom/qhqc/core/basic/picture/selector/PictureSelectorConfigures;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getPictureByCamera", "getPictureByCameraSelector", "picSelector", "Lcom/luck/picture/lib/basic/PictureSelector;", "getPictureSelector", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "registerLifecycle", "lifecycleOwner", "release", "ICallback", "MyResultCallBack", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PicSelectorHelper implements LifecycleEventObserver {

    @Nullable
    private ICallback callBack;
    private boolean isAddedObserver;

    @NotNull
    private final Context mContext;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper$ICallback;", "", "onPictureSelectorImagesResult", "", "result", "", "Lcom/luck/picture/lib/entity/LocalMedia;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface ICallback {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class DefaultImpls {
            public static void onPictureSelectorImagesResult(@NotNull ICallback iCallback, @NotNull List<LocalMedia> result) {
                Intrinsics.checkNotNullParameter(result, "result");
            }
        }

        void onPictureSelectorImagesResult(@NotNull List<LocalMedia> result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\u00020\t2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper$MyResultCallBack;", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "psh", "Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper;", "(Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper;)V", "weakReference", "Ljava/lang/ref/WeakReference;", "onCancel", "", "onResult", "result", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class MyResultCallBack implements OnResultCallbackListener<LocalMedia> {

        @Nullable
        private WeakReference<PicSelectorHelper> weakReference;

        public MyResultCallBack(@NotNull PicSelectorHelper psh) {
            Intrinsics.checkNotNullParameter(psh, "psh");
            this.weakReference = new WeakReference<>(psh);
        }

        @Override // com.luck.picture.lib.interfaces.OnResultCallbackListener
        public void onCancel() {
        }

        @Override // com.luck.picture.lib.interfaces.OnResultCallbackListener
        public void onResult(@Nullable ArrayList<LocalMedia> result) {
            PicSelectorHelper picSelectorHelper;
            ICallback callBack;
            WeakReference<PicSelectorHelper> weakReference = this.weakReference;
            if (weakReference != null && (picSelectorHelper = weakReference.get()) != null && result != null && !result.isEmpty() && (callBack = picSelectorHelper.getCallBack()) != null) {
                callBack.onPictureSelectorImagesResult(result);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PicSelectorHelper(@NotNull Context mContext) {
        LifecycleOwner lifecycleOwner;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        if (mContext instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) mContext;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null) {
            registerLifecycle(lifecycleOwner);
        }
    }

    private final void getPictureByCameraSelector(PictureSelector picSelector) {
        picSelector.openCamera(SelectMimeType.ofImage()).isCameraRotateImage(true).setCompressEngine(new CompressFileEngine() { // from class: com.qhqc.core.basic.picture.selector.PicSelectorHelper$getPictureByCameraSelector$1
            @Override // com.luck.picture.lib.engine.CompressFileEngine
            public void onStartCompress(@Nullable Context context, @Nullable ArrayList<Uri> source, @Nullable final OnKeyValueResultCallbackListener call) {
                if (source == null || context == null) {
                    return;
                }
                f.j(context).q(source).l(5).r(new i() { // from class: com.qhqc.core.basic.picture.selector.PicSelectorHelper$getPictureByCameraSelector$1$onStartCompress$1
                    public void onError(@Nullable String source2, @Nullable Throwable e10) {
                        OnKeyValueResultCallbackListener onKeyValueResultCallbackListener = OnKeyValueResultCallbackListener.this;
                        if (onKeyValueResultCallbackListener != null) {
                            onKeyValueResultCallbackListener.onCallback(source2, null);
                        }
                    }

                    public void onStart() {
                    }

                    public void onSuccess(@Nullable String source2, @Nullable File compressFile) {
                        String str;
                        OnKeyValueResultCallbackListener onKeyValueResultCallbackListener = OnKeyValueResultCallbackListener.this;
                        if (onKeyValueResultCallbackListener != null) {
                            if (compressFile != null) {
                                str = compressFile.getAbsolutePath();
                            } else {
                                str = null;
                            }
                            onKeyValueResultCallbackListener.onCallback(source2, str);
                        }
                    }
                }).m();
            }
        }).forResult(new MyResultCallBack(this));
    }

    private final void getPictureSelector(PictureSelector picSelector, final PictureSelectorConfigures configures) {
        int i10;
        PictureSelectionModel isDisplayCamera = picSelector.openGallery(configures.getShowType()).setSelectorUIStyle(new PictureSelectorUIStyle().getDefStyle()).setImageSpanCount(4).setImageEngine(GlideEngine.INSTANCE.getInstance()).setSkipCropMimeType("image/gif", "image/GIF").isGif(configures.getIsGif()).isPreviewImage(configures.getIsPreviewImage()).setMaxSelectNum(configures.getMaxSelect()).setMinSelectNum(1).isCameraRotateImage(true).isDisplayCamera(configures.getWithCamera());
        if (configures.getMaxSelect() > 1) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        PictureSelectionModel isDirectReturnSingle = isDisplayCamera.setSelectionMode(i10).isWithSelectVideoImage(false).isDirectReturnSingle(true);
        if (configures.getIsEnableCrop()) {
            isDirectReturnSingle.setCropEngine(new CropFileEngine() { // from class: com.qhqc.core.basic.picture.selector.a
                @Override // com.luck.picture.lib.engine.CropFileEngine
                public final void onStartCrop(Fragment fragment, Uri uri, Uri uri2, ArrayList arrayList, int i11) {
                    PicSelectorHelper.getPictureSelector$lambda$1(PictureSelectorConfigures.this, this, fragment, uri, uri2, arrayList, i11);
                }
            });
        }
        if (configures.getIsCompress()) {
            isDirectReturnSingle.setCompressEngine(new CompressFileEngine() { // from class: com.qhqc.core.basic.picture.selector.PicSelectorHelper$getPictureSelector$2
                @Override // com.luck.picture.lib.engine.CompressFileEngine
                public void onStartCompress(@Nullable Context context, @Nullable ArrayList<Uri> source, @Nullable final OnKeyValueResultCallbackListener call) {
                    if (source == null || context == null) {
                        return;
                    }
                    f.j(context).q(source).l(PictureSelectorConfigures.this.getMLeastCompressSize()).r(new i() { // from class: com.qhqc.core.basic.picture.selector.PicSelectorHelper$getPictureSelector$2$onStartCompress$1
                        public void onError(@Nullable String source2, @Nullable Throwable e10) {
                            OnKeyValueResultCallbackListener onKeyValueResultCallbackListener = OnKeyValueResultCallbackListener.this;
                            if (onKeyValueResultCallbackListener != null) {
                                onKeyValueResultCallbackListener.onCallback(source2, null);
                            }
                        }

                        public void onStart() {
                        }

                        public void onSuccess(@Nullable String source2, @Nullable File compressFile) {
                            String str;
                            OnKeyValueResultCallbackListener onKeyValueResultCallbackListener = OnKeyValueResultCallbackListener.this;
                            if (onKeyValueResultCallbackListener != null) {
                                if (compressFile != null) {
                                    str = compressFile.getAbsolutePath();
                                } else {
                                    str = null;
                                }
                                onKeyValueResultCallbackListener.onCallback(source2, str);
                            }
                        }
                    }).m();
                }
            });
        }
        isDirectReturnSingle.forResult(new MyResultCallBack(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPictureSelector$lambda$1(PictureSelectorConfigures configures, PicSelectorHelper this$0, Fragment fragment, Uri uri, Uri uri2, ArrayList arrayList, int i10) {
        Intrinsics.checkNotNullParameter(configures, "$configures");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UCrop of = UCrop.of(uri, uri2, arrayList);
        of.withAspectRatio(configures.getCropWidth(), configures.getCropHeight());
        of.setImageEngine(UCropGlideEngine.INSTANCE.getInstance());
        of.withMaxResultSize(configures.getCropWidth(), configures.getCropHeight());
        of.withOptions(new PictureSelectorUIStyle().getCropDefOptions());
        of.start(this$0.mContext, fragment, i10);
    }

    @Nullable
    public final ICallback getCallBack() {
        return this.callBack;
    }

    public final void getPicture(@NotNull FragmentActivity activity, @NotNull PictureSelectorConfigures configures) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(configures, "configures");
        PictureSelector create = PictureSelector.create(activity);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        getPictureSelector(create, configures);
    }

    public final void getPictureByCamera(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PictureSelector create = PictureSelector.create(activity);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        getPictureByCameraSelector(create);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.$EnumSwitchMapping$0[event.ordinal()] == 6) {
            source.getLifecycle().removeObserver(this);
            this.isAddedObserver = false;
            release();
        }
    }

    public final void registerLifecycle(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (!this.isAddedObserver) {
            lifecycleOwner.getLifecycle().addObserver(this);
        }
        this.isAddedObserver = true;
    }

    public final void release() {
        this.callBack = null;
    }

    public final void setCallBack(@Nullable ICallback iCallback) {
        this.callBack = iCallback;
    }

    public final void getPicture(@NotNull Fragment fragment, @NotNull PictureSelectorConfigures configures) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(configures, "configures");
        if (fragment.isAdded()) {
            PictureSelector create = PictureSelector.create(fragment);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            getPictureSelector(create, configures);
        }
    }

    public final void getPictureByCamera(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (fragment.isAdded()) {
            PictureSelector create = PictureSelector.create(fragment);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            getPictureByCameraSelector(create);
        }
    }
}
