package com.luck.picture.lib;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.d;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.ToastUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureSelectorSystemFragment extends PictureCommonFragment {
    public static final String TAG = "PictureSelectorSystemFragment";
    private d mContentLauncher;
    private d mContentsLauncher;
    private d mDocMultipleLauncher;
    private d mDocSingleLauncher;

    private void createContent() {
        this.mContentLauncher = registerForActivityResult(new ActivityResultContract<String, Uri>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.9
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String str) {
                if (TextUtils.equals(SelectMimeType.SYSTEM_VIDEO, str)) {
                    return new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                }
                if (TextUtils.equals(SelectMimeType.SYSTEM_AUDIO, str)) {
                    return new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                }
                return new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Uri parseResult(int i10, Intent intent) {
                if (intent == null) {
                    return null;
                }
                return intent.getData();
            }
        }, new ActivityResultCallback<Uri>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.10
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(Uri uri) {
                if (uri != null) {
                    LocalMedia buildLocalMedia = PictureSelectorSystemFragment.this.buildLocalMedia(uri.toString());
                    buildLocalMedia.setPath(SdkVersionUtils.isQ() ? buildLocalMedia.getPath() : buildLocalMedia.getRealPath());
                    if (PictureSelectorSystemFragment.this.confirmSelect(buildLocalMedia, false) == 0) {
                        PictureSelectorSystemFragment.this.dispatchTransformResult();
                        return;
                    } else {
                        PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                        return;
                    }
                }
                PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
            }
        });
    }

    private void createMultipleContents() {
        this.mContentsLauncher = registerForActivityResult(new ActivityResultContract<String, List<Uri>>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.7
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String str) {
                Intent intent;
                if (TextUtils.equals(SelectMimeType.SYSTEM_VIDEO, str)) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                } else if (TextUtils.equals(SelectMimeType.SYSTEM_AUDIO, str)) {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                } else {
                    intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                return intent;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public List<Uri> parseResult(int i10, Intent intent) {
                ArrayList arrayList = new ArrayList();
                if (intent == null) {
                    return arrayList;
                }
                if (intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    int itemCount = clipData.getItemCount();
                    for (int i11 = 0; i11 < itemCount; i11++) {
                        arrayList.add(clipData.getItemAt(i11).getUri());
                    }
                } else if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
                return arrayList;
            }
        }, new ActivityResultCallback<List<Uri>>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.8
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(List<Uri> list) {
                if (list != null && list.size() != 0) {
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        LocalMedia buildLocalMedia = PictureSelectorSystemFragment.this.buildLocalMedia(list.get(i10).toString());
                        buildLocalMedia.setPath(SdkVersionUtils.isQ() ? buildLocalMedia.getPath() : buildLocalMedia.getRealPath());
                        ((PictureCommonFragment) PictureSelectorSystemFragment.this).selectorConfig.addSelectResult(buildLocalMedia);
                    }
                    PictureSelectorSystemFragment.this.dispatchTransformResult();
                    return;
                }
                PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
            }
        });
    }

    private void createMultipleDocuments() {
        this.mDocMultipleLauncher = registerForActivityResult(new ActivityResultContract<String, List<Uri>>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.3
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String str) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intent.setType(str);
                return intent;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public List<Uri> parseResult(int i10, Intent intent) {
                ArrayList arrayList = new ArrayList();
                if (intent == null) {
                    return arrayList;
                }
                if (intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    int itemCount = clipData.getItemCount();
                    for (int i11 = 0; i11 < itemCount; i11++) {
                        arrayList.add(clipData.getItemAt(i11).getUri());
                    }
                } else if (intent.getData() != null) {
                    arrayList.add(intent.getData());
                }
                return arrayList;
            }
        }, new ActivityResultCallback<List<Uri>>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.4
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(List<Uri> list) {
                if (list != null && list.size() != 0) {
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        LocalMedia buildLocalMedia = PictureSelectorSystemFragment.this.buildLocalMedia(list.get(i10).toString());
                        buildLocalMedia.setPath(SdkVersionUtils.isQ() ? buildLocalMedia.getPath() : buildLocalMedia.getRealPath());
                        ((PictureCommonFragment) PictureSelectorSystemFragment.this).selectorConfig.addSelectResult(buildLocalMedia);
                    }
                    PictureSelectorSystemFragment.this.dispatchTransformResult();
                    return;
                }
                PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
            }
        });
    }

    private void createSingleDocuments() {
        this.mDocSingleLauncher = registerForActivityResult(new ActivityResultContract<String, Uri>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.5
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String str) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType(str);
                return intent;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Uri parseResult(int i10, Intent intent) {
                if (intent == null) {
                    return null;
                }
                return intent.getData();
            }
        }, new ActivityResultCallback<Uri>() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.6
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(Uri uri) {
                if (uri != null) {
                    LocalMedia buildLocalMedia = PictureSelectorSystemFragment.this.buildLocalMedia(uri.toString());
                    buildLocalMedia.setPath(SdkVersionUtils.isQ() ? buildLocalMedia.getPath() : buildLocalMedia.getRealPath());
                    if (PictureSelectorSystemFragment.this.confirmSelect(buildLocalMedia, false) == 0) {
                        PictureSelectorSystemFragment.this.dispatchTransformResult();
                        return;
                    } else {
                        PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
                        return;
                    }
                }
                PictureSelectorSystemFragment.this.onKeyBackFragmentFinish();
            }
        });
    }

    private void createSystemContracts() {
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.selectionMode == 1) {
            if (selectorConfig.chooseMode == SelectMimeType.ofAll()) {
                createSingleDocuments();
                return;
            } else {
                createContent();
                return;
            }
        }
        if (selectorConfig.chooseMode == SelectMimeType.ofAll()) {
            createMultipleDocuments();
        } else {
            createMultipleContents();
        }
    }

    private String getInput() {
        if (this.selectorConfig.chooseMode == SelectMimeType.ofVideo()) {
            return SelectMimeType.SYSTEM_VIDEO;
        }
        if (this.selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
            return SelectMimeType.SYSTEM_AUDIO;
        }
        return SelectMimeType.SYSTEM_IMAGE;
    }

    public static PictureSelectorSystemFragment newInstance() {
        return new PictureSelectorSystemFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSystemAlbum() {
        onPermissionExplainEvent(false, null);
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.selectionMode == 1) {
            if (selectorConfig.chooseMode == SelectMimeType.ofAll()) {
                this.mDocSingleLauncher.launch(SelectMimeType.SYSTEM_ALL);
                return;
            } else {
                this.mContentLauncher.launch(getInput());
                return;
            }
        }
        if (selectorConfig.chooseMode == SelectMimeType.ofAll()) {
            this.mDocMultipleLauncher.launch(SelectMimeType.SYSTEM_ALL);
        } else {
            this.mContentsLauncher.launch(getInput());
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment
    public String getFragmentTag() {
        return TAG;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public int getResourceId() {
        return R.layout.ps_empty;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void handlePermissionSettingResult(String[] strArr) {
        boolean isCheckReadStorage;
        onPermissionExplainEvent(false, null);
        SelectorConfig selectorConfig = this.selectorConfig;
        OnPermissionsInterceptListener onPermissionsInterceptListener = selectorConfig.onPermissionsEventListener;
        if (onPermissionsInterceptListener != null) {
            isCheckReadStorage = onPermissionsInterceptListener.hasPermissions(this, strArr);
        } else {
            isCheckReadStorage = PermissionChecker.isCheckReadStorage(selectorConfig.chooseMode, getContext());
        }
        if (isCheckReadStorage) {
            openSystemAlbum();
        } else {
            ToastUtils.showToast(getContext(), getString(R.string.ps_jurisdiction));
            onKeyBackFragmentFinish();
        }
        PermissionConfig.CURRENT_REQUEST_PERMISSION = new String[0];
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == 0) {
            onKeyBackFragmentFinish();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onApplyPermissionsEvent(int i10, String[] strArr) {
        if (i10 == -2) {
            this.selectorConfig.onPermissionsEventListener.requestPermission(this, PermissionConfig.getReadPermissionArray(getAppContext(), this.selectorConfig.chooseMode), new OnRequestPermissionListener() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.2
                @Override // com.luck.picture.lib.interfaces.OnRequestPermissionListener
                public void onCall(String[] strArr2, boolean z10) {
                    if (z10) {
                        PictureSelectorSystemFragment.this.openSystemAlbum();
                    } else {
                        PictureSelectorSystemFragment.this.handlePermissionDenied(strArr2);
                    }
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.mDocMultipleLauncher;
        if (dVar != null) {
            dVar.unregister();
        }
        d dVar2 = this.mDocSingleLauncher;
        if (dVar2 != null) {
            dVar2.unregister();
        }
        d dVar3 = this.mContentsLauncher;
        if (dVar3 != null) {
            dVar3.unregister();
        }
        d dVar4 = this.mContentLauncher;
        if (dVar4 != null) {
            dVar4.unregister();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        createSystemContracts();
        if (PermissionChecker.isCheckReadStorage(this.selectorConfig.chooseMode, getContext())) {
            openSystemAlbum();
            return;
        }
        final String[] readPermissionArray = PermissionConfig.getReadPermissionArray(getAppContext(), this.selectorConfig.chooseMode);
        onPermissionExplainEvent(true, readPermissionArray);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(-2, readPermissionArray);
        } else {
            PermissionChecker.getInstance().requestPermissions(this, readPermissionArray, new PermissionResultCallback() { // from class: com.luck.picture.lib.PictureSelectorSystemFragment.1
                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onDenied() {
                    PictureSelectorSystemFragment.this.handlePermissionDenied(readPermissionArray);
                }

                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onGranted() {
                    PictureSelectorSystemFragment.this.openSystemAlbum();
                }
            });
        }
    }
}
