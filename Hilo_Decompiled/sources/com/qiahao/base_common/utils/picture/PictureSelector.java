package com.qiahao.base_common.utils.picture;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.luck.picture.lib.basic.PictureSelectionModel;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.CropFileEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.style.TitleBarStyle;
import com.oudi.core.support.ActivityLifecycleManager;
import com.qiahao.base_common.R;
import com.qiahao.base_common.utils.GlideEngine;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sf.f;
import sf.i;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/qiahao/base_common/utils/picture/PictureSelector;", "", "<init>", "()V", "selectorPicture", "Lcom/luck/picture/lib/basic/PictureSelectionModel;", "configures", "Lcom/qiahao/base_common/utils/picture/PictureSelectorConfigures;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PictureSelector {

    @NotNull
    public static final PictureSelector INSTANCE = new PictureSelector();

    private PictureSelector() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectorPicture$lambda$6$lambda$5(PictureSelectorConfigures pictureSelectorConfigures, Activity activity, Fragment fragment, Uri uri, Uri uri2, ArrayList arrayList, int i10) {
        UCrop of = UCrop.of(uri, uri2, arrayList);
        of.withAspectRatio(pictureSelectorConfigures.getCropWidth(), pictureSelectorConfigures.getCropHeight());
        of.setImageEngine(UCropGlideEngine.INSTANCE.getInstance());
        of.withMaxResultSize(pictureSelectorConfigures.getCropWidth(), pictureSelectorConfigures.getCropHeight());
        UCrop.Options options = new UCrop.Options();
        options.setShowCropGrid(false);
        options.setCompressionQuality(90);
        options.setHideBottomControls(true);
        options.setSkipCropMimeType(new String[]{"image/gif", "image/GIF"});
        int i11 = R.color.colorPrimary;
        options.setToolbarColor(androidx.core.content.a.getColor(activity, i11));
        options.setStatusBarColor(androidx.core.content.a.getColor(activity, i11));
        options.setToolbarTitleSize(15);
        options.setToolbarWidgetColor(-1);
        of.withOptions(options);
        of.start(activity, fragment, i10);
    }

    @Nullable
    public final PictureSelectionModel selectorPicture(@NotNull final PictureSelectorConfigures configures, @NotNull OnResultCallbackListener<LocalMedia> listener) {
        int i10;
        Intrinsics.checkNotNullParameter(configures, "configures");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity != null) {
            PictureSelectionModel openGallery = com.luck.picture.lib.basic.PictureSelector.create(currentActivity).openGallery(configures.getShowType());
            PictureSelectorStyle pictureSelectorStyle = new PictureSelectorStyle();
            TitleBarStyle titleBarStyle = new TitleBarStyle();
            titleBarStyle.setTitleTextSize(15);
            titleBarStyle.setTitleAlbumBackgroundResource(R.drawable.bg_picture_selector_title);
            int i11 = R.color.colorPrimary;
            titleBarStyle.setTitleBackgroundColor(androidx.core.content.a.getColor(currentActivity, i11));
            titleBarStyle.setHideCancelButton(true);
            pictureSelectorStyle.setTitleBarStyle(titleBarStyle);
            SelectMainStyle selectMainStyle = new SelectMainStyle();
            selectMainStyle.setSelectTextColor(androidx.core.content.a.getColor(currentActivity, i11));
            pictureSelectorStyle.setSelectMainStyle(selectMainStyle);
            BottomNavBarStyle bottomNavBarStyle = new BottomNavBarStyle();
            bottomNavBarStyle.setBottomPreviewSelectTextColor(androidx.core.content.a.getColor(currentActivity, i11));
            pictureSelectorStyle.setBottomBarStyle(bottomNavBarStyle);
            PictureSelectionModel isDisplayCamera = openGallery.setSelectorUIStyle(pictureSelectorStyle).setImageSpanCount(3).setImageEngine(GlideEngine.INSTANCE.createGlideEngine()).setSkipCropMimeType("image/gif", "image/GIF").isGif(configures.getIsGif()).isPreviewImage(configures.getIsPreviewImage()).setMaxSelectNum(configures.getMaxSelect()).setMinSelectNum(1).isDisplayCamera(configures.getWithCamera());
            if (configures.getMaxSelect() > 1) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            PictureSelectionModel filterVideoMinSecond = isDisplayCamera.setSelectionMode(i10).isWithSelectVideoImage(false).isDirectReturnSingle(true).setFilterVideoMaxSecond(configures.getMVideoMaxSecond()).setFilterVideoMinSecond(configures.getMVideoMinSecond());
            if (configures.getMFileMaxSize() > 0 && filterVideoMinSecond != null) {
                filterVideoMinSecond.setFilterMaxFileSize(configures.getMFileMaxSize());
            }
            List<LocalMedia> mSelectList = configures.getMSelectList();
            if (mSelectList != null && !mSelectList.isEmpty() && filterVideoMinSecond != null) {
                filterVideoMinSecond.setSelectedData(configures.getMSelectList());
            }
            if (configures.getIsEnableCrop() && filterVideoMinSecond != null) {
                filterVideoMinSecond.setCropEngine(new CropFileEngine() { // from class: com.qiahao.base_common.utils.picture.a
                    @Override // com.luck.picture.lib.engine.CropFileEngine
                    public final void onStartCrop(Fragment fragment, Uri uri, Uri uri2, ArrayList arrayList, int i12) {
                        PictureSelector.selectorPicture$lambda$6$lambda$5(PictureSelectorConfigures.this, currentActivity, fragment, uri, uri2, arrayList, i12);
                    }
                });
            }
            if (configures.getIsCompress() && filterVideoMinSecond != null) {
                filterVideoMinSecond.setCompressEngine(new CompressFileEngine() { // from class: com.qiahao.base_common.utils.picture.PictureSelector$selectorPicture$1$3
                    @Override // com.luck.picture.lib.engine.CompressFileEngine
                    public void onStartCompress(Context context, ArrayList<Uri> source, final OnKeyValueResultCallbackListener call) {
                        if (source == null || context == null) {
                            return;
                        }
                        f.j(context).q(source).l(100).r(new i() { // from class: com.qiahao.base_common.utils.picture.PictureSelector$selectorPicture$1$3$onStartCompress$1
                            public void onError(String source2, Throwable e10) {
                                OnKeyValueResultCallbackListener onKeyValueResultCallbackListener = OnKeyValueResultCallbackListener.this;
                                if (onKeyValueResultCallbackListener != null) {
                                    onKeyValueResultCallbackListener.onCallback(source2, null);
                                }
                            }

                            public void onStart() {
                            }

                            public void onSuccess(String source2, File compressFile) {
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
            if (filterVideoMinSecond != null) {
                filterVideoMinSecond.forResult(listener);
                return filterVideoMinSecond;
            }
            return filterVideoMinSecond;
        }
        return null;
    }
}
