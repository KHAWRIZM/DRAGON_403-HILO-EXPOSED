package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean;
import com.tencent.qcloud.tuikit.tuichat.util.FileUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ImageVideoScanPresenter {
    private static final String TAG = "ImageVideoScanPresenter";
    private static MessageChangedListener messageChangedListener = new MessageChangedListener();
    private ImageVideoScanAdapter mAdapter;
    private String mChatID;
    private ImageVideoScanProvider mImageVideoScanProvider;
    private RecyclerView mRecyclerView;
    private ViewPagerLayoutManager mViewPagerLayoutManager;
    private int mCurrentPosition = -1;
    private int mIndex = 0;
    private boolean mIsForwardMode = false;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class MessageChangedListener implements ITUINotification {
        private WeakReference<ImageVideoScanPresenter> presenterWeakReference;

        @Override // com.tencent.qcloud.tuicore.interfaces.ITUINotification
        public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
            WeakReference<ImageVideoScanPresenter> weakReference = this.presenterWeakReference;
            if (weakReference != null && weakReference.get() != null) {
                this.presenterWeakReference.get().onMessageStatusChanged((TUIMessageBean) map.get("messageBean"));
            }
        }

        private MessageChangedListener() {
        }
    }

    public ImageVideoScanPresenter() {
        messageChangedListener.presenterWeakReference = new WeakReference(this);
        TUICore.registerEvent(TUIChatConstants.EVENT_KEY_MESSAGE_STATUS_CHANGED, TUIChatConstants.EVENT_SUB_KEY_MESSAGE_SEND, messageChangedListener);
    }

    private void saveImage(final Context context, final String str) {
        ThreadHelper.INST.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.3
            @Override // java.lang.Runnable
            public void run() {
                if (FileUtil.saveImageToGallery(context, str)) {
                    ToastUtil.toastShortMessage(context.getString(R.string.save_success));
                } else {
                    ToastUtil.toastShortMessage(context.getString(R.string.save_failed));
                }
            }
        });
    }

    private void saveVideo(final Context context, final String str) {
        ThreadHelper.INST.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                if (FileUtil.saveVideoToGallery(context, str)) {
                    ToastUtil.toastShortMessage(context.getString(R.string.save_success));
                } else {
                    ToastUtil.toastShortMessage(context.getString(R.string.save_failed));
                }
            }
        });
    }

    public void init(final TUIMessageBean tUIMessageBean, List<TUIMessageBean> list, boolean z) {
        String userID;
        this.mIsForwardMode = z;
        if (z) {
            this.mAdapter.setDataSource(list);
            this.mAdapter.notifyDataSetChanged();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                if (list.get(i2).getId().equals(tUIMessageBean.getId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            this.mRecyclerView.scrollToPosition(i);
            this.mCurrentPosition = i;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tUIMessageBean);
            this.mAdapter.setDataSource(arrayList);
            this.mAdapter.notifyDataSetChanged();
            this.mImageVideoScanProvider = new ImageVideoScanProvider();
            if (tUIMessageBean.isGroup()) {
                userID = tUIMessageBean.getV2TIMMessage().getGroupID();
            } else {
                userID = tUIMessageBean.getV2TIMMessage().getUserID();
            }
            this.mChatID = userID;
            this.mImageVideoScanProvider.initMessageList(userID, tUIMessageBean.isGroup(), tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.1
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i3, String str2) {
                    TUIChatLog.e(ImageVideoScanPresenter.TAG, "loadChatMessages initMessageList failed, code = " + i3 + ", desc = " + str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list2) {
                    ImageVideoScanPresenter.this.mAdapter.setDataSource(list2);
                    ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list2.size()) {
                            break;
                        }
                        if (list2.get(i4).getId().equals(tUIMessageBean.getId())) {
                            i3 = i4;
                            break;
                        }
                        i4++;
                    }
                    ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(i3);
                    ImageVideoScanPresenter.this.mCurrentPosition = i3;
                }
            });
        }
        this.mViewPagerLayoutManager.setOnViewPagerListener(new OnViewPagerListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.OnViewPagerListener
            public void onInitComplete() {
                Log.i(ImageVideoScanPresenter.TAG, "onInitComplete");
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.OnViewPagerListener
            public void onPageRelease(boolean z2, int i3) {
                Log.i(ImageVideoScanPresenter.TAG, "release position :" + i3 + " next page:" + z2);
                ImageVideoScanPresenter.this.mIndex = !z2 ? 1 : 0;
                ImageVideoScanPresenter.this.releaseUI();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.OnViewPagerListener
            public void onPageSelected(final int i3, boolean z2, boolean z3) {
                Log.i(ImageVideoScanPresenter.TAG, "select:" + i3 + " isBottom:" + z2 + "isLeftScroll:" + z2);
                ImageVideoScanPresenter.this.mCurrentPosition = i3;
                if (ImageVideoScanPresenter.this.mIsForwardMode) {
                    return;
                }
                if (z3) {
                    if (i3 == 0) {
                        if (ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage() != null) {
                            Log.d(ImageVideoScanPresenter.TAG, "mAdapter.getOldLocateMessage() seq:" + ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage().getV2TIMMessage().getSeq());
                        }
                        ImageVideoScanPresenter.this.mImageVideoScanProvider.loadLocalMediaMessageForward(ImageVideoScanPresenter.this.mChatID, tUIMessageBean.isGroup(), ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage(), new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.2.1
                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onError(String str, int i4, String str2) {
                                TUIChatLog.e(ImageVideoScanPresenter.TAG, "onPageSelected loadLocalMediaMessageForward failed, code = " + i4 + ", desc = " + str2);
                            }

                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onSuccess(List<TUIMessageBean> list2) {
                                if (list2 == null || list2.isEmpty()) {
                                    return;
                                }
                                ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(ImageVideoScanPresenter.this.mAdapter.addDataToSource(list2, 0, i3));
                                ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                            }
                        });
                        return;
                    }
                    return;
                }
                if (i3 == ImageVideoScanPresenter.this.mAdapter.getItemCount() - 1) {
                    if (ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage() != null) {
                        Log.d(ImageVideoScanPresenter.TAG, "mAdapter.getNewLocateMessage() seq:" + ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage().getV2TIMMessage().getSeq());
                    }
                    ImageVideoScanPresenter.this.mImageVideoScanProvider.loadLocalMediaMessageBackward(ImageVideoScanPresenter.this.mChatID, tUIMessageBean.isGroup(), ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage(), new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.2.2
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i4, String str2) {
                            TUIChatLog.e(ImageVideoScanPresenter.TAG, "onPageSelected loadLocalMediaMessageBackward failed, code = " + i4 + ", desc = " + str2);
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(List<TUIMessageBean> list2) {
                            if (list2 == null || list2.isEmpty()) {
                                return;
                            }
                            ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(ImageVideoScanPresenter.this.mAdapter.addDataToSource(list2, 1, i3));
                            ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    public void onMessageStatusChanged(TUIMessageBean tUIMessageBean) {
        ImageVideoScanAdapter imageVideoScanAdapter = this.mAdapter;
        if (imageVideoScanAdapter != null) {
            imageVideoScanAdapter.onDataChanged(tUIMessageBean);
        }
    }

    public void releaseUI() {
        ImageVideoScanAdapter imageVideoScanAdapter = this.mAdapter;
        if (imageVideoScanAdapter != null) {
            imageVideoScanAdapter.destroyView(this.mRecyclerView, this.mIndex);
        }
    }

    public void saveLocal(Context context) {
        int i;
        String str = TAG;
        TUIChatLog.d(str, "mCurrentPosition = " + this.mCurrentPosition);
        ImageVideoScanAdapter imageVideoScanAdapter = this.mAdapter;
        if (imageVideoScanAdapter != null && (i = this.mCurrentPosition) >= 0 && i < imageVideoScanAdapter.getItemCount()) {
            TUIMessageBean tUIMessageBean = this.mAdapter.getDataSource().get(this.mCurrentPosition);
            if (tUIMessageBean instanceof ImageMessageBean) {
                ImageMessageBean imageMessageBean = (ImageMessageBean) tUIMessageBean;
                String dataPath = imageMessageBean.getDataPath();
                TUIChatLog.d(str, "imagePath = " + dataPath);
                String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
                TUIChatLog.d(str, "originImagePath = " + originImagePath);
                if (!TextUtils.isEmpty(originImagePath)) {
                    dataPath = originImagePath;
                }
                saveImage(context, dataPath);
                return;
            }
            if (tUIMessageBean instanceof RoomImageBean) {
                RoomImageBean roomImageBean = (RoomImageBean) tUIMessageBean;
                String dataPath2 = roomImageBean.getDataPath();
                TUIChatLog.d(str, "imagePath = " + dataPath2);
                String originImagePath2 = TUIChatUtils.getOriginImagePath(roomImageBean);
                TUIChatLog.d(str, "originImagePath = " + originImagePath2);
                if (!TextUtils.isEmpty(originImagePath2)) {
                    dataPath2 = originImagePath2;
                }
                saveImage(context, dataPath2);
                return;
            }
            if (tUIMessageBean instanceof RoomVideoBean) {
                String str2 = TUIConfig.getVideoDownloadDir() + ((RoomVideoBean) tUIMessageBean).getVideoUUID();
                File file = new File(str2);
                if (file.exists() && file.length() == r1.getVideoSize()) {
                    saveVideo(context, str2);
                    return;
                } else {
                    ToastUtil.toastShortMessage(context.getString(R.string.downloading));
                    return;
                }
            }
            if (tUIMessageBean instanceof VideoMessageBean) {
                String str3 = TUIConfig.getVideoDownloadDir() + ((VideoMessageBean) tUIMessageBean).getVideoUUID();
                File file2 = new File(str3);
                if (file2.exists() && file2.length() == r1.getVideoSize()) {
                    saveVideo(context, str3);
                    return;
                } else {
                    ToastUtil.toastShortMessage(context.getString(R.string.downloading));
                    return;
                }
            }
            TUIChatLog.d(str, "error message type");
        }
    }

    public void setAdapter(ImageVideoScanAdapter imageVideoScanAdapter) {
        this.mAdapter = imageVideoScanAdapter;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setViewPagerLayoutManager(ViewPagerLayoutManager viewPagerLayoutManager) {
        this.mViewPagerLayoutManager = viewPagerLayoutManager;
    }
}
