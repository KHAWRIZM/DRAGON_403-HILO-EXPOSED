package com.luck.picture.lib.basic;

import android.app.Activity;
import android.text.TextUtils;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryDataSourceListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureSelectionQueryModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionQueryModel(PictureSelector pictureSelector, int i10) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i10;
    }

    public IBridgeMediaLoader buildMediaLoader() {
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            if (this.selectionConfig.isPageStrategy) {
                return new LocalMediaPageLoader(activity, this.selectionConfig);
            }
            return new LocalMediaLoader(activity, this.selectionConfig);
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public PictureSelectionQueryModel isBmp(boolean z10) {
        this.selectionConfig.isBmp = z10;
        return this;
    }

    public PictureSelectionQueryModel isGif(boolean z10) {
        this.selectionConfig.isGif = z10;
        return this;
    }

    public PictureSelectionQueryModel isHeic(boolean z10) {
        this.selectionConfig.isHeic = z10;
        return this;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z10) {
        this.selectionConfig.isPageStrategy = z10;
        return this;
    }

    public PictureSelectionQueryModel isWebp(boolean z10) {
        this.selectionConfig.isWebp = z10;
        return this;
    }

    public void obtainAlbumData(final OnQueryDataSourceListener<LocalMediaFolder> onQueryDataSourceListener) {
        IBridgeMediaLoader localMediaLoader;
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            if (onQueryDataSourceListener != null) {
                if (this.selectionConfig.isPageStrategy) {
                    localMediaLoader = new LocalMediaPageLoader(activity, this.selectionConfig);
                } else {
                    localMediaLoader = new LocalMediaLoader(activity, this.selectionConfig);
                }
                localMediaLoader.loadAllAlbum(new OnQueryAllAlbumListener<LocalMediaFolder>() { // from class: com.luck.picture.lib.basic.PictureSelectionQueryModel.1
                    @Override // com.luck.picture.lib.interfaces.OnQueryAllAlbumListener
                    public void onComplete(List<LocalMediaFolder> list) {
                        onQueryDataSourceListener.onComplete(list);
                    }
                });
                return;
            }
            throw new NullPointerException("OnQueryDataSourceListener cannot be null");
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public void obtainMediaData(final OnQueryDataSourceListener<LocalMedia> onQueryDataSourceListener) {
        final IBridgeMediaLoader localMediaLoader;
        Activity activity = this.selector.getActivity();
        if (activity != null) {
            if (onQueryDataSourceListener != null) {
                if (this.selectionConfig.isPageStrategy) {
                    localMediaLoader = new LocalMediaPageLoader(activity, this.selectionConfig);
                } else {
                    localMediaLoader = new LocalMediaLoader(activity, this.selectionConfig);
                }
                localMediaLoader.loadAllAlbum(new OnQueryAllAlbumListener<LocalMediaFolder>() { // from class: com.luck.picture.lib.basic.PictureSelectionQueryModel.2
                    @Override // com.luck.picture.lib.interfaces.OnQueryAllAlbumListener
                    public void onComplete(List<LocalMediaFolder> list) {
                        if (list != null && list.size() > 0) {
                            LocalMediaFolder localMediaFolder = list.get(0);
                            if (PictureSelectionQueryModel.this.selectionConfig.isPageStrategy) {
                                localMediaLoader.loadPageMediaData(localMediaFolder.getBucketId(), 1, PictureSelectionQueryModel.this.selectionConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.basic.PictureSelectionQueryModel.2.1
                                    @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                                    public void onComplete(ArrayList<LocalMedia> arrayList, boolean z10) {
                                        onQueryDataSourceListener.onComplete(arrayList);
                                    }
                                });
                            } else {
                                onQueryDataSourceListener.onComplete(localMediaFolder.getData());
                            }
                        }
                    }
                });
                return;
            }
            throw new NullPointerException("OnQueryDataSourceListener cannot be null");
        }
        throw new NullPointerException("Activity cannot be null");
    }

    public PictureSelectionQueryModel setFilterMaxFileSize(long j10) {
        if (j10 >= 1048576) {
            this.selectionConfig.filterMaxFileSize = j10;
        } else {
            this.selectionConfig.filterMaxFileSize = j10 * 1024;
        }
        return this;
    }

    public PictureSelectionQueryModel setFilterMinFileSize(long j10) {
        if (j10 >= 1048576) {
            this.selectionConfig.filterMinFileSize = j10;
        } else {
            this.selectionConfig.filterMinFileSize = j10 * 1024;
        }
        return this;
    }

    public PictureSelectionQueryModel setFilterVideoMaxSecond(int i10) {
        this.selectionConfig.filterVideoMaxSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionQueryModel setFilterVideoMinSecond(int i10) {
        this.selectionConfig.filterVideoMinSecond = i10 * 1000;
        return this;
    }

    public PictureSelectionQueryModel setQueryFilterListener(OnQueryFilterListener onQueryFilterListener) {
        this.selectionConfig.onQueryFilterListener = onQueryFilterListener;
        return this;
    }

    public PictureSelectionQueryModel setQuerySortOrder(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.selectionConfig.sortOrder = str;
        }
        return this;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z10, int i10) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z10;
        if (i10 < 10) {
            i10 = 60;
        }
        selectorConfig.pageSize = i10;
        return this;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z10, int i10, boolean z11) {
        SelectorConfig selectorConfig = this.selectionConfig;
        selectorConfig.isPageStrategy = z10;
        if (i10 < 10) {
            i10 = 60;
        }
        selectorConfig.pageSize = i10;
        selectorConfig.isFilterInvalidFile = z11;
        return this;
    }
}
