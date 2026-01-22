package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.BaseApplication;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ImageVideoScanActivity extends Activity {
    private static final String TAG = "ImageVideoScanActivity";
    private ImageVideoScanAdapter mAdapter;
    private ImageView mDownloadView;
    private ImageVideoScanPresenter mImageVideoScanPresenter;
    private ViewPagerLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private TUIMessageBean mCurrentMessageBean = null;
    private List<TUIMessageBean> mForwardDataSource = new ArrayList();
    private boolean mIsForwardMode = false;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnItemClickListener {
        void onClickItem();
    }

    private void initView() {
        this.mRecyclerView = findViewById(R.id.recycler);
        ImageView imageView = (ImageView) findViewById(R.id.download_button);
        this.mDownloadView = imageView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        BaseApplication.Companion companion = BaseApplication.Companion;
        BaseApplication companion2 = companion.getInstance();
        Objects.requireNonNull(companion2);
        layoutParams.setMargins(0, 0, 30, companion2.getMNavigationHeight() + 15);
        this.mDownloadView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mRecyclerView.getLayoutParams();
        BaseApplication companion3 = companion.getInstance();
        Objects.requireNonNull(companion3);
        layoutParams2.setMargins(0, 0, 0, companion3.getMNavigationHeight());
        this.mRecyclerView.setLayoutParams(layoutParams2);
        this.mDownloadView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIChatLog.d(ImageVideoScanActivity.TAG, "onClick");
                if (Build.VERSION.SDK_INT >= 29) {
                    ImageVideoScanActivity.this.mImageVideoScanPresenter.saveLocal(ImageVideoScanActivity.this);
                } else {
                    PermissionHelper.requestPermission(3, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity.1.1
                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onDenied() {
                            ToastUtil.toastShortMessage(ImageVideoScanActivity.this.getString(R.string.save_failed));
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                        public void onGranted() {
                            ImageVideoScanActivity.this.mImageVideoScanPresenter.saveLocal(ImageVideoScanActivity.this);
                        }
                    });
                }
            }
        });
        this.mLayoutManager = new ViewPagerLayoutManager(this, 0);
        this.mAdapter = new ImageVideoScanAdapter();
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        ImageVideoScanPresenter imageVideoScanPresenter = new ImageVideoScanPresenter();
        this.mImageVideoScanPresenter = imageVideoScanPresenter;
        imageVideoScanPresenter.setAdapter(this.mAdapter);
        this.mImageVideoScanPresenter.setRecyclerView(this.mRecyclerView);
        this.mImageVideoScanPresenter.setViewPagerLayoutManager(this.mLayoutManager);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity.OnItemClickListener
            public void onClickItem() {
                ImageVideoScanActivity.this.finish();
            }
        });
    }

    public void initData() {
        if (getIntent() == null) {
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra(TUIChatConstants.FORWARD_MODE, false);
        this.mIsForwardMode = booleanExtra;
        if (booleanExtra) {
            List<TUIMessageBean> list = (List) getIntent().getSerializableExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD);
            this.mForwardDataSource = list;
            if (list == null || list.isEmpty()) {
                TUIChatLog.e(TAG, "mForwardDataSource is null");
                return;
            }
        }
        TUIMessageBean tUIMessageBean = (TUIMessageBean) getIntent().getSerializableExtra(TUIChatConstants.OPEN_MESSAGE_SCAN);
        this.mCurrentMessageBean = tUIMessageBean;
        if (tUIMessageBean == null) {
            TUIChatLog.e(TAG, "mCurrentMessageBean is null");
        } else {
            this.mImageVideoScanPresenter.init(tUIMessageBean, this.mForwardDataSource, this.mIsForwardMode);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY, LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY);
        setContentView(R.layout.image_video_scan_layout);
        initView();
        initData();
    }

    @Override // android.app.Activity
    protected void onPause() {
        TUIChatLog.i(TAG, "onPause");
        super.onPause();
        ImageVideoScanPresenter imageVideoScanPresenter = this.mImageVideoScanPresenter;
        if (imageVideoScanPresenter != null) {
            imageVideoScanPresenter.releaseUI();
        }
    }
}
