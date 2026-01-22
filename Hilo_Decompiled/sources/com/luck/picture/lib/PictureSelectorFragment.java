package com.luck.picture.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.a;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.animators.AlphaInAnimationAdapter;
import com.luck.picture.lib.animators.SlideInBottomAnimationAdapter;
import com.luck.picture.lib.basic.FragmentInjectManager;
import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.basic.IPictureSelectorEvent;
import com.luck.picture.lib.basic.PictureCommonFragment;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.dialog.AlbumListPopWindow;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnAlbumItemClickListener;
import com.luck.picture.lib.interfaces.OnPermissionsInterceptListener;
import com.luck.picture.lib.interfaces.OnPreviewInterceptListener;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener;
import com.luck.picture.lib.interfaces.OnRequestPermissionListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import com.luck.picture.lib.magical.BuildRecycleItemViewParams;
import com.luck.picture.lib.permissions.PermissionChecker;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.luck.picture.lib.permissions.PermissionResultCallback;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.ActivityCompatHelper;
import com.luck.picture.lib.utils.AnimUtils;
import com.luck.picture.lib.utils.DateUtils;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.DoubleUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ToastUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.luck.picture.lib.widget.BottomNavBar;
import com.luck.picture.lib.widget.CompleteSelectView;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.luck.picture.lib.widget.SlideSelectTouchListener;
import com.luck.picture.lib.widget.SlideSelectionHandler;
import com.luck.picture.lib.widget.TitleBar;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureSelectorFragment extends PictureCommonFragment implements OnRecyclerViewPreloadMoreListener, IPictureSelectorEvent {
    private static final Object LOCK = new Object();
    private static int SELECT_ANIM_DURATION = 135;
    public static final String TAG = "PictureSelectorFragment";
    private AlbumListPopWindow albumListPopWindow;
    private int allFolderSize;
    private BottomNavBar bottomNarBar;
    private CompleteSelectView completeSelectView;
    private boolean isCameraCallback;
    private boolean isDisplayCamera;
    private boolean isMemoryRecycling;
    private PictureImageGridAdapter mAdapter;
    private SlideSelectTouchListener mDragSelectTouchListener;
    private RecyclerPreloadView mRecycler;
    private TitleBar titleBar;
    private TextView tvCurrentDataTime;
    private TextView tvDataEmpty;
    private long intervalClickTime = 0;
    private int currentPosition = -1;

    private void addAlbumPopWindowAction() {
        this.albumListPopWindow.setOnIBridgeAlbumWidget(new OnAlbumItemClickListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.7
            @Override // com.luck.picture.lib.interfaces.OnAlbumItemClickListener
            public void onItemClick(int i10, LocalMediaFolder localMediaFolder) {
                boolean z10;
                PictureSelectorFragment pictureSelectorFragment = PictureSelectorFragment.this;
                if (((PictureCommonFragment) pictureSelectorFragment).selectorConfig.isDisplayCamera && localMediaFolder.getBucketId() == -1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                pictureSelectorFragment.isDisplayCamera = z10;
                PictureSelectorFragment.this.mAdapter.setDisplayCamera(PictureSelectorFragment.this.isDisplayCamera);
                PictureSelectorFragment.this.titleBar.setTitle(localMediaFolder.getFolderName());
                LocalMediaFolder localMediaFolder2 = ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.currentLocalMediaFolder;
                long bucketId = localMediaFolder2.getBucketId();
                if (((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.isPageStrategy) {
                    if (localMediaFolder.getBucketId() != bucketId) {
                        localMediaFolder2.setData(PictureSelectorFragment.this.mAdapter.getData());
                        localMediaFolder2.setCurrentDataPage(((PictureCommonFragment) PictureSelectorFragment.this).mPage);
                        localMediaFolder2.setHasMore(PictureSelectorFragment.this.mRecycler.isEnabledLoadMore());
                        if (localMediaFolder.getData().size() <= 0 || localMediaFolder.isHasMore()) {
                            ((PictureCommonFragment) PictureSelectorFragment.this).mPage = 1;
                            if (((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.loaderDataEngine != null) {
                                ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.loaderDataEngine.loadFirstPageMediaData(PictureSelectorFragment.this.getContext(), localMediaFolder.getBucketId(), ((PictureCommonFragment) PictureSelectorFragment.this).mPage, ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorFragment.7.1
                                    @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                                    public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                                        PictureSelectorFragment.this.handleSwitchAlbum(arrayList, z11);
                                    }
                                });
                            } else {
                                ((PictureCommonFragment) PictureSelectorFragment.this).mLoader.loadPageMediaData(localMediaFolder.getBucketId(), ((PictureCommonFragment) PictureSelectorFragment.this).mPage, ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorFragment.7.2
                                    @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                                    public void onComplete(ArrayList<LocalMedia> arrayList, boolean z11) {
                                        PictureSelectorFragment.this.handleSwitchAlbum(arrayList, z11);
                                    }
                                });
                            }
                        } else {
                            PictureSelectorFragment.this.setAdapterData(localMediaFolder.getData());
                            ((PictureCommonFragment) PictureSelectorFragment.this).mPage = localMediaFolder.getCurrentDataPage();
                            PictureSelectorFragment.this.mRecycler.setEnabledLoadMore(localMediaFolder.isHasMore());
                            PictureSelectorFragment.this.mRecycler.smoothScrollToPosition(0);
                        }
                    }
                } else if (localMediaFolder.getBucketId() != bucketId) {
                    PictureSelectorFragment.this.setAdapterData(localMediaFolder.getData());
                    PictureSelectorFragment.this.mRecycler.smoothScrollToPosition(0);
                }
                ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.currentLocalMediaFolder = localMediaFolder;
                PictureSelectorFragment.this.albumListPopWindow.dismiss();
                if (PictureSelectorFragment.this.mDragSelectTouchListener != null && ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.isFastSlidingSelect) {
                    PictureSelectorFragment.this.mDragSelectTouchListener.setRecyclerViewHeaderCount(PictureSelectorFragment.this.mAdapter.isDisplayCamera() ? 1 : 0);
                }
            }
        });
    }

    private void addRecyclerAction() {
        this.mAdapter.setOnItemClickListener(new PictureImageGridAdapter.OnItemClickListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.16
            @Override // com.luck.picture.lib.adapter.PictureImageGridAdapter.OnItemClickListener
            public void onItemClick(View view, int i10, LocalMedia localMedia) {
                if (((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.selectionMode == 1 && ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.isDirectReturnSingle) {
                    ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.selectedResult.clear();
                    if (PictureSelectorFragment.this.confirmSelect(localMedia, false) == 0) {
                        PictureSelectorFragment.this.dispatchTransformResult();
                        return;
                    }
                    return;
                }
                if (!DoubleUtils.isFastDoubleClick()) {
                    PictureSelectorFragment.this.onStartPreview(i10, false);
                }
            }

            @Override // com.luck.picture.lib.adapter.PictureImageGridAdapter.OnItemClickListener
            public void onItemLongClick(View view, int i10) {
                if (PictureSelectorFragment.this.mDragSelectTouchListener != null && ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.isFastSlidingSelect) {
                    ((Vibrator) PictureSelectorFragment.this.getActivity().getSystemService("vibrator")).vibrate(50L);
                    PictureSelectorFragment.this.mDragSelectTouchListener.startSlideSelection(i10);
                }
            }

            @Override // com.luck.picture.lib.adapter.PictureImageGridAdapter.OnItemClickListener
            public int onSelected(View view, int i10, LocalMedia localMedia) {
                int confirmSelect = PictureSelectorFragment.this.confirmSelect(localMedia, view.isSelected());
                if (confirmSelect == 0) {
                    if (((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.onSelectAnimListener != null) {
                        long onSelectAnim = ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.onSelectAnimListener.onSelectAnim(view);
                        if (onSelectAnim > 0) {
                            int unused = PictureSelectorFragment.SELECT_ANIM_DURATION = (int) onSelectAnim;
                        }
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(PictureSelectorFragment.this.getContext(), R.anim.ps_anim_modal_in);
                        int unused2 = PictureSelectorFragment.SELECT_ANIM_DURATION = (int) loadAnimation.getDuration();
                        view.startAnimation(loadAnimation);
                    }
                }
                return confirmSelect;
            }

            @Override // com.luck.picture.lib.adapter.PictureImageGridAdapter.OnItemClickListener
            public void openCameraClick() {
                if (DoubleUtils.isFastDoubleClick()) {
                    return;
                }
                PictureSelectorFragment.this.openSelectedCamera();
            }
        });
        this.mRecycler.setOnRecyclerViewScrollStateListener(new OnRecyclerViewScrollStateListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.17
            @Override // com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener
            public void onScrollFast() {
                if (((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.imageEngine != null) {
                    ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.imageEngine.pauseRequests(PictureSelectorFragment.this.getContext());
                }
            }

            @Override // com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener
            public void onScrollSlow() {
                if (((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.imageEngine != null) {
                    ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.imageEngine.resumeRequests(PictureSelectorFragment.this.getContext());
                }
            }
        });
        this.mRecycler.setOnRecyclerViewScrollListener(new OnRecyclerViewScrollListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.18
            @Override // com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener
            public void onScrollStateChanged(int i10) {
                if (i10 == 1) {
                    PictureSelectorFragment.this.showCurrentMediaCreateTimeUI();
                } else if (i10 == 0) {
                    PictureSelectorFragment.this.hideCurrentMediaCreateTimeUI();
                }
            }

            @Override // com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener
            public void onScrolled(int i10, int i11) {
                PictureSelectorFragment.this.setCurrentMediaCreateTimeText();
            }
        });
        if (this.selectorConfig.isFastSlidingSelect) {
            final HashSet hashSet = new HashSet();
            SlideSelectTouchListener withSelectListener = new SlideSelectTouchListener().setRecyclerViewHeaderCount(this.mAdapter.isDisplayCamera() ? 1 : 0).withSelectListener(new SlideSelectionHandler(new SlideSelectionHandler.ISelectionHandler() { // from class: com.luck.picture.lib.PictureSelectorFragment.19
                @Override // com.luck.picture.lib.widget.SlideSelectionHandler.ISelectionHandler
                public void changeSelection(int i10, int i11, boolean z10, boolean z11) {
                    boolean z12;
                    ArrayList<LocalMedia> data = PictureSelectorFragment.this.mAdapter.getData();
                    if (data.size() != 0 && i10 <= data.size()) {
                        LocalMedia localMedia = data.get(i10);
                        PictureSelectorFragment pictureSelectorFragment = PictureSelectorFragment.this;
                        int confirmSelect = pictureSelectorFragment.confirmSelect(localMedia, ((PictureCommonFragment) pictureSelectorFragment).selectorConfig.getSelectedResult().contains(localMedia));
                        SlideSelectTouchListener slideSelectTouchListener = PictureSelectorFragment.this.mDragSelectTouchListener;
                        if (confirmSelect != -1) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        slideSelectTouchListener.setActive(z12);
                    }
                }

                @Override // com.luck.picture.lib.widget.SlideSelectionHandler.ISelectionHandler
                public HashSet<Integer> getSelection() {
                    for (int i10 = 0; i10 < ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.getSelectCount(); i10++) {
                        hashSet.add(Integer.valueOf(((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.getSelectedResult().get(i10).position));
                    }
                    return hashSet;
                }
            }));
            this.mDragSelectTouchListener = withSelectListener;
            this.mRecycler.addOnItemTouchListener(withSelectListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginLoadData() {
        onPermissionExplainEvent(false, null);
        if (this.selectorConfig.isOnlySandboxDir) {
            loadOnlyInAppDirectoryAllMediaData();
        } else {
            loadAllAlbumData();
        }
    }

    private boolean checkNotifyStrategy(boolean z10) {
        SelectorConfig selectorConfig = this.selectorConfig;
        if (!selectorConfig.isMaxSelectEnabledMask) {
            return false;
        }
        if (selectorConfig.isWithVideoImage) {
            if (selectorConfig.selectionMode == 1) {
                return false;
            }
            int selectCount = selectorConfig.getSelectCount();
            SelectorConfig selectorConfig2 = this.selectorConfig;
            if (selectCount != selectorConfig2.maxSelectNum && (z10 || selectorConfig2.getSelectCount() != this.selectorConfig.maxSelectNum - 1)) {
                return false;
            }
        } else if (selectorConfig.getSelectCount() != 0 && (!z10 || this.selectorConfig.getSelectCount() != 1)) {
            if (PictureMimeType.isHasVideo(this.selectorConfig.getResultFirstMimeType())) {
                SelectorConfig selectorConfig3 = this.selectorConfig;
                int i10 = selectorConfig3.maxVideoSelectNum;
                if (i10 <= 0) {
                    i10 = selectorConfig3.maxSelectNum;
                }
                if (selectorConfig3.getSelectCount() != i10 && (z10 || this.selectorConfig.getSelectCount() != i10 - 1)) {
                    return false;
                }
            } else {
                int selectCount2 = this.selectorConfig.getSelectCount();
                SelectorConfig selectorConfig4 = this.selectorConfig;
                if (selectCount2 != selectorConfig4.maxSelectNum && (z10 || selectorConfig4.getSelectCount() != this.selectorConfig.maxSelectNum - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAllAlbumData(boolean z10, List<LocalMediaFolder> list) {
        LocalMediaFolder localMediaFolder;
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        if (list.size() > 0) {
            if (z10) {
                localMediaFolder = list.get(0);
                this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
            } else {
                localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
                if (localMediaFolder == null) {
                    localMediaFolder = list.get(0);
                    this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
                }
            }
            this.titleBar.setTitle(localMediaFolder.getFolderName());
            this.albumListPopWindow.bindAlbumData(list);
            SelectorConfig selectorConfig = this.selectorConfig;
            if (selectorConfig.isPageStrategy) {
                if (selectorConfig.isPreloadFirst) {
                    this.mRecycler.setEnabledLoadMore(true);
                    return;
                } else {
                    loadFirstPageMediaData(localMediaFolder.getBucketId());
                    return;
                }
            }
            setAdapterData(localMediaFolder.getData());
            return;
        }
        showDataNull();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFirstPageMedia(ArrayList<LocalMedia> arrayList, boolean z10) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        this.mRecycler.setEnabledLoadMore(z10);
        if (this.mRecycler.isEnabledLoadMore() && arrayList.size() == 0) {
            onRecyclerViewPreloadMore();
        } else {
            setAdapterData(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInAppDirAllMedia(LocalMediaFolder localMediaFolder) {
        boolean z10;
        String name;
        if (!ActivityCompatHelper.isDestroy(getActivity())) {
            String str = this.selectorConfig.sandboxDir;
            if (localMediaFolder != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                name = localMediaFolder.getFolderName();
            } else {
                name = new File(str).getName();
            }
            this.titleBar.setTitle(name);
            if (z10) {
                this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
                setAdapterData(localMediaFolder.getData());
            } else {
                showDataNull();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMoreMediaData(List<LocalMedia> list, boolean z10) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        this.mRecycler.setEnabledLoadMore(z10);
        if (this.mRecycler.isEnabledLoadMore()) {
            removePageCameraRepeatData(list);
            if (list.size() > 0) {
                int size = this.mAdapter.getData().size();
                this.mAdapter.getData().addAll(list);
                PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
                pictureImageGridAdapter.notifyItemRangeChanged(size, pictureImageGridAdapter.getItemCount());
                hideDataNull();
            } else {
                onRecyclerViewPreloadMore();
            }
            if (list.size() < 10) {
                RecyclerPreloadView recyclerPreloadView = this.mRecycler;
                recyclerPreloadView.onScrolled(recyclerPreloadView.getScrollX(), this.mRecycler.getScrollY());
            }
        }
    }

    private void handleRecoverAlbumData(List<LocalMediaFolder> list) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        if (list.size() > 0) {
            LocalMediaFolder localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
            if (localMediaFolder == null) {
                localMediaFolder = list.get(0);
                this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
            }
            this.titleBar.setTitle(localMediaFolder.getFolderName());
            this.albumListPopWindow.bindAlbumData(list);
            if (this.selectorConfig.isPageStrategy) {
                handleFirstPageMedia(new ArrayList<>(this.selectorConfig.dataSource), true);
                return;
            } else {
                setAdapterData(localMediaFolder.getData());
                return;
            }
        }
        showDataNull();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSwitchAlbum(ArrayList<LocalMedia> arrayList, boolean z10) {
        if (ActivityCompatHelper.isDestroy(getActivity())) {
            return;
        }
        this.mRecycler.setEnabledLoadMore(z10);
        if (arrayList.size() == 0) {
            this.mAdapter.getData().clear();
        }
        setAdapterData(arrayList);
        this.mRecycler.onScrolled(0, 0);
        this.mRecycler.smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCurrentMediaCreateTimeUI() {
        if (this.selectorConfig.isDisplayTimeAxis && this.mAdapter.getData().size() > 0) {
            this.tvCurrentDataTime.animate().setDuration(250L).alpha(DownloadProgress.UNKNOWN_PROGRESS).start();
        }
    }

    private void hideDataNull() {
        if (this.tvDataEmpty.getVisibility() == 0) {
            this.tvDataEmpty.setVisibility(8);
        }
    }

    private void initAlbumListPopWindow() {
        AlbumListPopWindow buildPopWindow = AlbumListPopWindow.buildPopWindow(getContext(), this.selectorConfig);
        this.albumListPopWindow = buildPopWindow;
        buildPopWindow.setOnPopupWindowStatusListener(new AlbumListPopWindow.OnPopupWindowStatusListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.4
            @Override // com.luck.picture.lib.dialog.AlbumListPopWindow.OnPopupWindowStatusListener
            public void onDismissPopupWindow() {
                if (!((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.isOnlySandboxDir) {
                    AnimUtils.rotateArrow(PictureSelectorFragment.this.titleBar.getImageArrow(), false);
                }
            }

            @Override // com.luck.picture.lib.dialog.AlbumListPopWindow.OnPopupWindowStatusListener
            public void onShowPopupWindow() {
                if (!((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.isOnlySandboxDir) {
                    AnimUtils.rotateArrow(PictureSelectorFragment.this.titleBar.getImageArrow(), true);
                }
            }
        });
        addAlbumPopWindowAction();
    }

    private void initBottomNavBar() {
        this.bottomNarBar.setBottomNavBarStyle();
        this.bottomNarBar.setOnBottomNavBarListener(new BottomNavBar.OnBottomNavBarListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.8
            @Override // com.luck.picture.lib.widget.BottomNavBar.OnBottomNavBarListener
            public void onCheckOriginalChange() {
                PictureSelectorFragment.this.sendSelectedOriginalChangeEvent();
            }

            @Override // com.luck.picture.lib.widget.BottomNavBar.OnBottomNavBarListener
            public void onPreview() {
                PictureSelectorFragment.this.onStartPreview(0, true);
            }
        });
        this.bottomNarBar.setSelectedChange();
    }

    private void initComplete() {
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.selectionMode == 1 && selectorConfig.isDirectReturnSingle) {
            selectorConfig.selectorStyle.getTitleBarStyle().setHideCancelButton(false);
            this.titleBar.getTitleCancelView().setVisibility(0);
            this.completeSelectView.setVisibility(8);
            return;
        }
        this.completeSelectView.setCompleteSelectViewStyle();
        this.completeSelectView.setSelectedChange(false);
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isCompleteSelectRelativeTop()) {
            if (this.completeSelectView.getLayoutParams() instanceof ConstraintLayout.b) {
                ConstraintLayout.b bVar = (ConstraintLayout.b) this.completeSelectView.getLayoutParams();
                int i10 = R.id.title_bar;
                bVar.f٢٣١٥i = i10;
                ((ConstraintLayout.b) this.completeSelectView.getLayoutParams()).f٢٣٢١l = i10;
                if (this.selectorConfig.isPreviewFullScreenMode) {
                    ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) this.completeSelectView.getLayoutParams())).topMargin = DensityUtil.getStatusBarHeight(getContext());
                }
            } else if ((this.completeSelectView.getLayoutParams() instanceof RelativeLayout.LayoutParams) && this.selectorConfig.isPreviewFullScreenMode) {
                ((RelativeLayout.LayoutParams) this.completeSelectView.getLayoutParams()).topMargin = DensityUtil.getStatusBarHeight(getContext());
            }
        }
        this.completeSelectView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.isEmptyResultReturn || ((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.getSelectCount() != 0) {
                    PictureSelectorFragment.this.dispatchTransformResult();
                } else {
                    PictureSelectorFragment.this.onExitPictureSelector();
                }
            }
        });
    }

    private void initRecycler(View view) {
        this.mRecycler = (RecyclerPreloadView) view.findViewById(R.id.recycler);
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        int mainListBackgroundColor = selectMainStyle.getMainListBackgroundColor();
        if (StyleUtils.checkStyleValidity(mainListBackgroundColor)) {
            this.mRecycler.setBackgroundColor(mainListBackgroundColor);
        } else {
            this.mRecycler.setBackgroundColor(a.getColor(getAppContext(), R.color.ps_color_black));
        }
        int i10 = this.selectorConfig.imageSpanCount;
        if (i10 <= 0) {
            i10 = 4;
        }
        if (this.mRecycler.getItemDecorationCount() == 0) {
            if (StyleUtils.checkSizeValidity(selectMainStyle.getAdapterItemSpacingSize())) {
                this.mRecycler.addItemDecoration(new GridSpacingItemDecoration(i10, selectMainStyle.getAdapterItemSpacingSize(), selectMainStyle.isAdapterItemIncludeEdge()));
            } else {
                this.mRecycler.addItemDecoration(new GridSpacingItemDecoration(i10, DensityUtil.dip2px(view.getContext(), 1.0f), selectMainStyle.isAdapterItemIncludeEdge()));
            }
        }
        this.mRecycler.setLayoutManager(new GridLayoutManager(getContext(), i10));
        RecyclerView.ItemAnimator itemAnimator = this.mRecycler.getItemAnimator();
        if (itemAnimator != null) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            this.mRecycler.setItemAnimator(null);
        }
        if (this.selectorConfig.isPageStrategy) {
            this.mRecycler.setReachBottomRow(2);
            this.mRecycler.setOnRecyclerViewPreloadListener(this);
        } else {
            this.mRecycler.setHasFixedSize(true);
        }
        PictureImageGridAdapter pictureImageGridAdapter = new PictureImageGridAdapter(getContext(), this.selectorConfig);
        this.mAdapter = pictureImageGridAdapter;
        pictureImageGridAdapter.setDisplayCamera(this.isDisplayCamera);
        int i11 = this.selectorConfig.animationMode;
        if (i11 != 1) {
            if (i11 != 2) {
                this.mRecycler.setAdapter(this.mAdapter);
            } else {
                this.mRecycler.setAdapter(new SlideInBottomAnimationAdapter(this.mAdapter));
            }
        } else {
            this.mRecycler.setAdapter(new AlphaInAnimationAdapter(this.mAdapter));
        }
        addRecyclerAction();
    }

    private void initTitleBar() {
        if (this.selectorConfig.selectorStyle.getTitleBarStyle().isHideTitleBar()) {
            this.titleBar.setVisibility(8);
        }
        this.titleBar.setTitleBarStyle();
        this.titleBar.setOnTitleBarListener(new TitleBar.OnTitleBarListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.3
            @Override // com.luck.picture.lib.widget.TitleBar.OnTitleBarListener
            public void onBackPressed() {
                if (PictureSelectorFragment.this.albumListPopWindow.isShowing()) {
                    PictureSelectorFragment.this.albumListPopWindow.dismiss();
                } else {
                    PictureSelectorFragment.this.onKeyBackFragmentFinish();
                }
            }

            @Override // com.luck.picture.lib.widget.TitleBar.OnTitleBarListener
            public void onShowAlbumPopWindow(View view) {
                PictureSelectorFragment.this.albumListPopWindow.showAsDropDown(view);
            }

            @Override // com.luck.picture.lib.widget.TitleBar.OnTitleBarListener
            public void onTitleDoubleClick() {
                if (((PictureCommonFragment) PictureSelectorFragment.this).selectorConfig.isAutomaticTitleRecyclerTop) {
                    if (SystemClock.uptimeMillis() - PictureSelectorFragment.this.intervalClickTime < 500 && PictureSelectorFragment.this.mAdapter.getItemCount() > 0) {
                        PictureSelectorFragment.this.mRecycler.scrollToPosition(0);
                    } else {
                        PictureSelectorFragment.this.intervalClickTime = SystemClock.uptimeMillis();
                    }
                }
            }
        });
    }

    private boolean isAddSameImp(int i10) {
        int i11;
        if (i10 == 0 || (i11 = this.allFolderSize) <= 0 || i11 >= i10) {
            return false;
        }
        return true;
    }

    private void mergeFolder(LocalMedia localMedia) {
        LocalMediaFolder folder;
        int folderTotalNum;
        LocalMediaFolder localMediaFolder;
        int folderTotalNum2;
        String str;
        int i10;
        List<LocalMediaFolder> albumList = this.albumListPopWindow.getAlbumList();
        if (this.albumListPopWindow.getFolderCount() == 0) {
            folder = new LocalMediaFolder();
            if (TextUtils.isEmpty(this.selectorConfig.defaultAlbumName)) {
                if (this.selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                    i10 = R.string.ps_all_audio;
                } else {
                    i10 = R.string.ps_camera_roll;
                }
                str = getString(i10);
            } else {
                str = this.selectorConfig.defaultAlbumName;
            }
            folder.setFolderName(str);
            folder.setFirstImagePath("");
            folder.setBucketId(-1L);
            albumList.add(0, folder);
        } else {
            folder = this.albumListPopWindow.getFolder(0);
        }
        folder.setFirstImagePath(localMedia.getPath());
        folder.setFirstMimeType(localMedia.getMimeType());
        folder.setData(this.mAdapter.getData());
        folder.setBucketId(-1L);
        if (isAddSameImp(folder.getFolderTotalNum())) {
            folderTotalNum = folder.getFolderTotalNum();
        } else {
            folderTotalNum = folder.getFolderTotalNum() + 1;
        }
        folder.setFolderTotalNum(folderTotalNum);
        LocalMediaFolder localMediaFolder2 = this.selectorConfig.currentLocalMediaFolder;
        if (localMediaFolder2 == null || localMediaFolder2.getFolderTotalNum() == 0) {
            this.selectorConfig.currentLocalMediaFolder = folder;
        }
        int i11 = 0;
        while (true) {
            if (i11 < albumList.size()) {
                localMediaFolder = albumList.get(i11);
                if (TextUtils.equals(localMediaFolder.getFolderName(), localMedia.getParentFolderName())) {
                    break;
                } else {
                    i11++;
                }
            } else {
                localMediaFolder = null;
                break;
            }
        }
        if (localMediaFolder == null) {
            localMediaFolder = new LocalMediaFolder();
            albumList.add(localMediaFolder);
        }
        localMediaFolder.setFolderName(localMedia.getParentFolderName());
        if (localMediaFolder.getBucketId() == -1 || localMediaFolder.getBucketId() == 0) {
            localMediaFolder.setBucketId(localMedia.getBucketId());
        }
        if (this.selectorConfig.isPageStrategy) {
            localMediaFolder.setHasMore(true);
        } else if (!isAddSameImp(folder.getFolderTotalNum()) || !TextUtils.isEmpty(this.selectorConfig.outPutCameraDir) || !TextUtils.isEmpty(this.selectorConfig.outPutAudioDir)) {
            localMediaFolder.getData().add(0, localMedia);
        }
        if (isAddSameImp(folder.getFolderTotalNum())) {
            folderTotalNum2 = localMediaFolder.getFolderTotalNum();
        } else {
            folderTotalNum2 = localMediaFolder.getFolderTotalNum() + 1;
        }
        localMediaFolder.setFolderTotalNum(folderTotalNum2);
        localMediaFolder.setFirstImagePath(this.selectorConfig.cameraPath);
        localMediaFolder.setFirstMimeType(localMedia.getMimeType());
        this.albumListPopWindow.bindAlbumData(albumList);
    }

    public static PictureSelectorFragment newInstance() {
        PictureSelectorFragment pictureSelectorFragment = new PictureSelectorFragment();
        pictureSelectorFragment.setArguments(new Bundle());
        return pictureSelectorFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStartPreview(int i10, boolean z10) {
        ArrayList<LocalMedia> arrayList;
        int size;
        long j10;
        ArrayList<LocalMedia> arrayList2;
        long bucketId;
        int i11;
        OnPreviewInterceptListener onPreviewInterceptListener;
        FragmentActivity activity = getActivity();
        String str = PictureSelectorPreviewFragment.TAG;
        if (ActivityCompatHelper.checkFragmentNonExits(activity, str)) {
            int i12 = 0;
            if (z10) {
                arrayList = new ArrayList<>(this.selectorConfig.getSelectedResult());
                size = arrayList.size();
                j10 = 0;
            } else {
                arrayList = new ArrayList<>(this.mAdapter.getData());
                LocalMediaFolder localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
                if (localMediaFolder != null) {
                    int folderTotalNum = localMediaFolder.getFolderTotalNum();
                    arrayList2 = arrayList;
                    bucketId = localMediaFolder.getBucketId();
                    i11 = folderTotalNum;
                    if (!z10) {
                        SelectorConfig selectorConfig = this.selectorConfig;
                        if (selectorConfig.isPreviewZoomEffect) {
                            RecyclerPreloadView recyclerPreloadView = this.mRecycler;
                            if (!selectorConfig.isPreviewFullScreenMode) {
                                i12 = DensityUtil.getStatusBarHeight(getContext());
                            }
                            BuildRecycleItemViewParams.generateViewParams(recyclerPreloadView, i12);
                        }
                    }
                    onPreviewInterceptListener = this.selectorConfig.onPreviewInterceptListener;
                    if (onPreviewInterceptListener == null) {
                        onPreviewInterceptListener.onPreview(getContext(), i10, i11, this.mPage, bucketId, this.titleBar.getTitleText(), this.mAdapter.isDisplayCamera(), arrayList2, z10);
                        return;
                    } else {
                        if (ActivityCompatHelper.checkFragmentNonExits(getActivity(), str)) {
                            PictureSelectorPreviewFragment newInstance = PictureSelectorPreviewFragment.newInstance();
                            newInstance.setInternalPreviewData(z10, this.titleBar.getTitleText(), this.mAdapter.isDisplayCamera(), i10, i11, this.mPage, bucketId, arrayList2);
                            FragmentInjectManager.injectFragment(getActivity(), str, newInstance);
                            return;
                        }
                        return;
                    }
                }
                size = arrayList.size();
                if (arrayList.size() > 0) {
                    j10 = arrayList.get(0).getBucketId();
                } else {
                    j10 = -1;
                }
            }
            arrayList2 = arrayList;
            i11 = size;
            bucketId = j10;
            if (!z10) {
            }
            onPreviewInterceptListener = this.selectorConfig.onPreviewInterceptListener;
            if (onPreviewInterceptListener == null) {
            }
        }
    }

    private boolean preloadPageFirstData() {
        Context requireContext;
        int i10;
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.isPageStrategy && selectorConfig.isPreloadFirst) {
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            localMediaFolder.setBucketId(-1L);
            if (TextUtils.isEmpty(this.selectorConfig.defaultAlbumName)) {
                TitleBar titleBar = this.titleBar;
                if (this.selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                    requireContext = requireContext();
                    i10 = R.string.ps_all_audio;
                } else {
                    requireContext = requireContext();
                    i10 = R.string.ps_camera_roll;
                }
                titleBar.setTitle(requireContext.getString(i10));
            } else {
                this.titleBar.setTitle(this.selectorConfig.defaultAlbumName);
            }
            localMediaFolder.setFolderName(this.titleBar.getTitleText());
            this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
            loadFirstPageMediaData(localMediaFolder.getBucketId());
            return true;
        }
        return false;
    }

    private void recoverSaveInstanceData() {
        this.mAdapter.setDisplayCamera(this.isDisplayCamera);
        setEnterAnimationDuration(0L);
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.isOnlySandboxDir) {
            handleInAppDirAllMedia(selectorConfig.currentLocalMediaFolder);
        } else {
            handleRecoverAlbumData(new ArrayList(this.selectorConfig.albumDataSource));
        }
    }

    private void recoveryRecyclerPosition() {
        if (this.currentPosition > 0) {
            this.mRecycler.post(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorFragment.15
                @Override // java.lang.Runnable
                public void run() {
                    PictureSelectorFragment.this.mRecycler.scrollToPosition(PictureSelectorFragment.this.currentPosition);
                    PictureSelectorFragment.this.mRecycler.setLastVisiblePosition(PictureSelectorFragment.this.currentPosition);
                }
            });
        }
    }

    private void removePageCameraRepeatData(List<LocalMedia> list) {
        try {
            try {
                if (this.selectorConfig.isPageStrategy && this.isCameraCallback) {
                    synchronized (LOCK) {
                        try {
                            Iterator<LocalMedia> it = list.iterator();
                            while (it.hasNext()) {
                                if (this.mAdapter.getData().contains(it.next())) {
                                    it.remove();
                                }
                            }
                        } finally {
                        }
                    }
                }
            } finally {
                this.isCameraCallback = false;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void requestLoadData() {
        this.mAdapter.setDisplayCamera(this.isDisplayCamera);
        if (PermissionChecker.isCheckReadStorage(this.selectorConfig.chooseMode, getContext())) {
            beginLoadData();
            return;
        }
        final String[] readPermissionArray = PermissionConfig.getReadPermissionArray(getAppContext(), this.selectorConfig.chooseMode);
        onPermissionExplainEvent(true, readPermissionArray);
        if (this.selectorConfig.onPermissionsEventListener != null) {
            onApplyPermissionsEvent(-1, readPermissionArray);
        } else {
            PermissionChecker.getInstance().requestPermissions(this, readPermissionArray, new PermissionResultCallback() { // from class: com.luck.picture.lib.PictureSelectorFragment.5
                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onDenied() {
                    PictureSelectorFragment.this.handlePermissionDenied(readPermissionArray);
                }

                @Override // com.luck.picture.lib.permissions.PermissionResultCallback
                public void onGranted() {
                    PictureSelectorFragment.this.beginLoadData();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NotifyDataSetChanged"})
    public void setAdapterData(final ArrayList<LocalMedia> arrayList) {
        long enterAnimationDuration = getEnterAnimationDuration();
        if (enterAnimationDuration > 0) {
            requireView().postDelayed(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorFragment.20
                @Override // java.lang.Runnable
                public void run() {
                    PictureSelectorFragment.this.setAdapterDataComplete(arrayList);
                }
            }, enterAnimationDuration);
        } else {
            setAdapterDataComplete(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdapterDataComplete(ArrayList<LocalMedia> arrayList) {
        setEnterAnimationDuration(0L);
        sendChangeSubSelectPositionEvent(false);
        this.mAdapter.setDataAndDataSetChanged(arrayList);
        this.selectorConfig.dataSource.clear();
        this.selectorConfig.albumDataSource.clear();
        recoveryRecyclerPosition();
        if (this.mAdapter.isDataEmpty()) {
            showDataNull();
        } else {
            hideDataNull();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentMediaCreateTimeText() {
        int firstVisiblePosition;
        if (this.selectorConfig.isDisplayTimeAxis && (firstVisiblePosition = this.mRecycler.getFirstVisiblePosition()) != -1) {
            ArrayList<LocalMedia> data = this.mAdapter.getData();
            if (data.size() > firstVisiblePosition && data.get(firstVisiblePosition).getDateAddedTime() > 0) {
                this.tvCurrentDataTime.setText(DateUtils.getDataFormat(getContext(), data.get(firstVisiblePosition).getDateAddedTime()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCurrentMediaCreateTimeUI() {
        if (this.selectorConfig.isDisplayTimeAxis && this.mAdapter.getData().size() > 0 && this.tvCurrentDataTime.getAlpha() == DownloadProgress.UNKNOWN_PROGRESS) {
            this.tvCurrentDataTime.animate().setDuration(150L).alphaBy(1.0f).start();
        }
    }

    private void showDataNull() {
        int i10;
        LocalMediaFolder localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
        if (localMediaFolder == null || localMediaFolder.getBucketId() == -1) {
            if (this.tvDataEmpty.getVisibility() == 8) {
                this.tvDataEmpty.setVisibility(0);
            }
            this.tvDataEmpty.setCompoundDrawablesRelativeWithIntrinsicBounds(0, R.drawable.ps_ic_no_data, 0, 0);
            if (this.selectorConfig.chooseMode == SelectMimeType.ofAudio()) {
                i10 = R.string.ps_audio_empty;
            } else {
                i10 = R.string.ps_empty;
            }
            this.tvDataEmpty.setText(getString(i10));
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void dispatchCameraMediaResult(LocalMedia localMedia) {
        if (!isAddSameImp(this.albumListPopWindow.getFirstAlbumImageCount())) {
            this.mAdapter.getData().add(0, localMedia);
            this.isCameraCallback = true;
        }
        SelectorConfig selectorConfig = this.selectorConfig;
        if (selectorConfig.selectionMode == 1 && selectorConfig.isDirectReturnSingle) {
            selectorConfig.selectedResult.clear();
            if (confirmSelect(localMedia, false) == 0) {
                dispatchTransformResult();
            }
        } else {
            confirmSelect(localMedia, false);
        }
        this.mAdapter.notifyItemInserted(this.selectorConfig.isDisplayCamera ? 1 : 0);
        PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        boolean z10 = this.selectorConfig.isDisplayCamera;
        pictureImageGridAdapter.notifyItemRangeChanged(z10 ? 1 : 0, pictureImageGridAdapter.getData().size());
        SelectorConfig selectorConfig2 = this.selectorConfig;
        if (selectorConfig2.isOnlySandboxDir) {
            LocalMediaFolder localMediaFolder = selectorConfig2.currentLocalMediaFolder;
            if (localMediaFolder == null) {
                localMediaFolder = new LocalMediaFolder();
            }
            localMediaFolder.setBucketId(ValueOf.toLong(Integer.valueOf(localMedia.getParentFolderName().hashCode())));
            localMediaFolder.setFolderName(localMedia.getParentFolderName());
            localMediaFolder.setFirstMimeType(localMedia.getMimeType());
            localMediaFolder.setFirstImagePath(localMedia.getPath());
            localMediaFolder.setFolderTotalNum(this.mAdapter.getData().size());
            localMediaFolder.setCurrentDataPage(this.mPage);
            localMediaFolder.setHasMore(false);
            localMediaFolder.setData(this.mAdapter.getData());
            this.mRecycler.setEnabledLoadMore(false);
            this.selectorConfig.currentLocalMediaFolder = localMediaFolder;
        } else {
            mergeFolder(localMedia);
        }
        this.allFolderSize = 0;
        if (this.mAdapter.getData().size() <= 0 && !this.selectorConfig.isDirectReturnSingle) {
            showDataNull();
        } else {
            hideDataNull();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment
    public String getFragmentTag() {
        return TAG;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public int getResourceId() {
        int layoutResource = InjectResourceSource.getLayoutResource(getContext(), 1, this.selectorConfig);
        if (layoutResource != 0) {
            return layoutResource;
        }
        return R.layout.ps_fragment_selector;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void handlePermissionSettingResult(String[] strArr) {
        boolean z10;
        boolean isCheckSelfPermission;
        if (strArr == null) {
            return;
        }
        onPermissionExplainEvent(false, null);
        if (strArr.length > 0 && TextUtils.equals(strArr[0], PermissionConfig.CAMERA[0])) {
            z10 = true;
        } else {
            z10 = false;
        }
        OnPermissionsInterceptListener onPermissionsInterceptListener = this.selectorConfig.onPermissionsEventListener;
        if (onPermissionsInterceptListener != null) {
            isCheckSelfPermission = onPermissionsInterceptListener.hasPermissions(this, strArr);
        } else {
            isCheckSelfPermission = PermissionChecker.isCheckSelfPermission(getContext(), strArr);
        }
        if (isCheckSelfPermission) {
            if (z10) {
                openSelectedCamera();
            } else {
                beginLoadData();
            }
        } else if (z10) {
            ToastUtils.showToast(getContext(), getString(R.string.ps_camera));
        } else {
            ToastUtils.showToast(getContext(), getString(R.string.ps_jurisdiction));
            onKeyBackFragmentFinish();
        }
        PermissionConfig.CURRENT_REQUEST_PERMISSION = new String[0];
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorEvent
    public void loadAllAlbumData() {
        ExtendLoaderEngine extendLoaderEngine = this.selectorConfig.loaderDataEngine;
        if (extendLoaderEngine != null) {
            extendLoaderEngine.loadAllAlbumData(getContext(), new OnQueryAllAlbumListener<LocalMediaFolder>() { // from class: com.luck.picture.lib.PictureSelectorFragment.9
                @Override // com.luck.picture.lib.interfaces.OnQueryAllAlbumListener
                public void onComplete(List<LocalMediaFolder> list) {
                    PictureSelectorFragment.this.handleAllAlbumData(false, list);
                }
            });
        } else {
            final boolean preloadPageFirstData = preloadPageFirstData();
            this.mLoader.loadAllAlbum(new OnQueryAllAlbumListener<LocalMediaFolder>() { // from class: com.luck.picture.lib.PictureSelectorFragment.10
                @Override // com.luck.picture.lib.interfaces.OnQueryAllAlbumListener
                public void onComplete(List<LocalMediaFolder> list) {
                    PictureSelectorFragment.this.handleAllAlbumData(preloadPageFirstData, list);
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorEvent
    public void loadFirstPageMediaData(long j10) {
        this.mPage = 1;
        this.mRecycler.setEnabledLoadMore(true);
        SelectorConfig selectorConfig = this.selectorConfig;
        ExtendLoaderEngine extendLoaderEngine = selectorConfig.loaderDataEngine;
        if (extendLoaderEngine != null) {
            Context context = getContext();
            int i10 = this.mPage;
            extendLoaderEngine.loadFirstPageMediaData(context, j10, i10, i10 * this.selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorFragment.11
                @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z10) {
                    PictureSelectorFragment.this.handleFirstPageMedia(arrayList, z10);
                }
            });
        } else {
            IBridgeMediaLoader iBridgeMediaLoader = this.mLoader;
            int i11 = this.mPage;
            iBridgeMediaLoader.loadPageMediaData(j10, i11, i11 * selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorFragment.12
                @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z10) {
                    PictureSelectorFragment.this.handleFirstPageMedia(arrayList, z10);
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorEvent
    public void loadMoreMediaData() {
        long j10;
        if (this.mRecycler.isEnabledLoadMore()) {
            this.mPage++;
            LocalMediaFolder localMediaFolder = this.selectorConfig.currentLocalMediaFolder;
            if (localMediaFolder != null) {
                j10 = localMediaFolder.getBucketId();
            } else {
                j10 = 0;
            }
            SelectorConfig selectorConfig = this.selectorConfig;
            ExtendLoaderEngine extendLoaderEngine = selectorConfig.loaderDataEngine;
            if (extendLoaderEngine != null) {
                Context context = getContext();
                int i10 = this.mPage;
                int i11 = this.selectorConfig.pageSize;
                extendLoaderEngine.loadMoreMediaData(context, j10, i10, i11, i11, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorFragment.22
                    @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                    public void onComplete(ArrayList<LocalMedia> arrayList, boolean z10) {
                        PictureSelectorFragment.this.handleMoreMediaData(arrayList, z10);
                    }
                });
                return;
            }
            this.mLoader.loadPageMediaData(j10, this.mPage, selectorConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.PictureSelectorFragment.23
                @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                public void onComplete(ArrayList<LocalMedia> arrayList, boolean z10) {
                    PictureSelectorFragment.this.handleMoreMediaData(arrayList, z10);
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.IPictureSelectorEvent
    public void loadOnlyInAppDirectoryAllMediaData() {
        ExtendLoaderEngine extendLoaderEngine = this.selectorConfig.loaderDataEngine;
        if (extendLoaderEngine != null) {
            extendLoaderEngine.loadOnlyInAppDirAllMediaData(getContext(), new OnQueryAlbumListener<LocalMediaFolder>() { // from class: com.luck.picture.lib.PictureSelectorFragment.13
                @Override // com.luck.picture.lib.interfaces.OnQueryAlbumListener
                public void onComplete(LocalMediaFolder localMediaFolder) {
                    PictureSelectorFragment.this.handleInAppDirAllMedia(localMediaFolder);
                }
            });
        } else {
            this.mLoader.loadOnlyInAppDirAllMedia(new OnQueryAlbumListener<LocalMediaFolder>() { // from class: com.luck.picture.lib.PictureSelectorFragment.14
                @Override // com.luck.picture.lib.interfaces.OnQueryAlbumListener
                public void onComplete(LocalMediaFolder localMediaFolder) {
                    PictureSelectorFragment.this.handleInAppDirAllMedia(localMediaFolder);
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onApplyPermissionsEvent(int i10, String[] strArr) {
        if (i10 != -1) {
            super.onApplyPermissionsEvent(i10, strArr);
        } else {
            this.selectorConfig.onPermissionsEventListener.requestPermission(this, strArr, new OnRequestPermissionListener() { // from class: com.luck.picture.lib.PictureSelectorFragment.6
                @Override // com.luck.picture.lib.interfaces.OnRequestPermissionListener
                public void onCall(String[] strArr2, boolean z10) {
                    if (z10) {
                        PictureSelectorFragment.this.beginLoadData();
                    } else {
                        PictureSelectorFragment.this.handlePermissionDenied(strArr2);
                    }
                }
            });
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onCheckOriginalChange() {
        this.bottomNarBar.setOriginalCheck();
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onCreateLoader() {
        IBridgeMediaLoader localMediaLoader;
        SelectorConfig selectorConfig = this.selectorConfig;
        IBridgeLoaderFactory iBridgeLoaderFactory = selectorConfig.loaderFactory;
        if (iBridgeLoaderFactory != null) {
            IBridgeMediaLoader onCreateLoader = iBridgeLoaderFactory.onCreateLoader();
            this.mLoader = onCreateLoader;
            if (onCreateLoader == null) {
                throw new NullPointerException("No available " + IBridgeMediaLoader.class + " loader found");
            }
            return;
        }
        if (selectorConfig.isPageStrategy) {
            localMediaLoader = new LocalMediaPageLoader(getAppContext(), this.selectorConfig);
        } else {
            localMediaLoader = new LocalMediaLoader(getAppContext(), this.selectorConfig);
        }
        this.mLoader = localMediaLoader;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SlideSelectTouchListener slideSelectTouchListener = this.mDragSelectTouchListener;
        if (slideSelectTouchListener != null) {
            slideSelectTouchListener.stopAutoScroll();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onFixedSelectedChange(LocalMedia localMedia) {
        this.mAdapter.notifyItemPositionChanged(localMedia.position);
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void onFragmentResume() {
        setRootViewKeyListener(requireView());
    }

    @Override // com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener
    public void onRecyclerViewPreloadMore() {
        if (this.isMemoryRecycling) {
            requireView().postDelayed(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorFragment.21
                @Override // java.lang.Runnable
                public void run() {
                    PictureSelectorFragment.this.loadMoreMediaData();
                }
            }, 350L);
        } else {
            loadMoreMediaData();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(PictureConfig.EXTRA_ALL_FOLDER_SIZE, this.allFolderSize);
        bundle.putInt(PictureConfig.EXTRA_CURRENT_PAGE, this.mPage);
        RecyclerPreloadView recyclerPreloadView = this.mRecycler;
        if (recyclerPreloadView != null) {
            bundle.putInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, recyclerPreloadView.getLastVisiblePosition());
        }
        PictureImageGridAdapter pictureImageGridAdapter = this.mAdapter;
        if (pictureImageGridAdapter != null) {
            bundle.putBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, pictureImageGridAdapter.isDisplayCamera());
            this.selectorConfig.addDataSource(this.mAdapter.getData());
        }
        AlbumListPopWindow albumListPopWindow = this.albumListPopWindow;
        if (albumListPopWindow != null) {
            this.selectorConfig.addAlbumDataSource(albumListPopWindow.getAlbumList());
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    @SuppressLint({"NotifyDataSetChanged"})
    public void onSelectedChange(boolean z10, LocalMedia localMedia) {
        this.bottomNarBar.setSelectedChange();
        this.completeSelectView.setSelectedChange(false);
        if (checkNotifyStrategy(z10)) {
            this.mAdapter.notifyItemPositionChanged(localMedia.position);
            this.mRecycler.postDelayed(new Runnable() { // from class: com.luck.picture.lib.PictureSelectorFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    PictureSelectorFragment.this.mAdapter.notifyDataSetChanged();
                }
            }, SELECT_ANIM_DURATION);
        } else {
            this.mAdapter.notifyItemPositionChanged(localMedia.position);
        }
        if (!z10) {
            sendChangeSubSelectPositionEvent(true);
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z10;
        super.onViewCreated(view, bundle);
        reStartSavedInstance(bundle);
        if (bundle != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.isMemoryRecycling = z10;
        this.tvDataEmpty = (TextView) view.findViewById(R.id.tv_data_empty);
        this.completeSelectView = (CompleteSelectView) view.findViewById(R.id.ps_complete_select);
        this.titleBar = (TitleBar) view.findViewById(R.id.title_bar);
        this.bottomNarBar = (BottomNavBar) view.findViewById(R.id.bottom_nar_bar);
        this.tvCurrentDataTime = (TextView) view.findViewById(R.id.tv_current_data_time);
        onCreateLoader();
        initAlbumListPopWindow();
        initTitleBar();
        initComplete();
        initRecycler(view);
        initBottomNavBar();
        if (this.isMemoryRecycling) {
            recoverSaveInstanceData();
        } else {
            requestLoadData();
        }
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void reStartSavedInstance(Bundle bundle) {
        if (bundle != null) {
            this.allFolderSize = bundle.getInt(PictureConfig.EXTRA_ALL_FOLDER_SIZE);
            this.mPage = bundle.getInt(PictureConfig.EXTRA_CURRENT_PAGE, this.mPage);
            this.currentPosition = bundle.getInt(PictureConfig.EXTRA_PREVIEW_CURRENT_POSITION, this.currentPosition);
            this.isDisplayCamera = bundle.getBoolean(PictureConfig.EXTRA_DISPLAY_CAMERA, this.selectorConfig.isDisplayCamera);
            return;
        }
        this.isDisplayCamera = this.selectorConfig.isDisplayCamera;
    }

    @Override // com.luck.picture.lib.basic.PictureCommonFragment, com.luck.picture.lib.basic.IPictureSelectorCommonEvent
    public void sendChangeSubSelectPositionEvent(boolean z10) {
        if (this.selectorConfig.selectorStyle.getSelectMainStyle().isSelectNumberStyle()) {
            int i10 = 0;
            while (i10 < this.selectorConfig.getSelectCount()) {
                LocalMedia localMedia = this.selectorConfig.getSelectedResult().get(i10);
                i10++;
                localMedia.setNum(i10);
                if (z10) {
                    this.mAdapter.notifyItemPositionChanged(localMedia.position);
                }
            }
        }
    }
}
