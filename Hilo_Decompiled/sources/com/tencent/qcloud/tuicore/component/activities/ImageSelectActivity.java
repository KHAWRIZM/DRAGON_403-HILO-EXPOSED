package com.tencent.qcloud.tuicore.component.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c5.g;
import c5.h;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.j;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.gatherimage.SynthesizedImageView;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import o4.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ImageSelectActivity extends BaseLightActivity {
    public static final String DATA = "data";
    public static final String ITEM_HEIGHT = "itemHeight";
    public static final String ITEM_WIDTH = "itemWidth";
    public static final String NEED_DOWLOAD_LOCAL = "needdowmload";
    public static final String PLACEHOLDER = "placeholder";
    public static final int RESULT_CODE_ERROR = -1;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final String SELECTED = "selected";
    public static final String SPAN_COUNT = "spanCount";
    private static final String TAG = "ImageSelectActivity";
    public static final String TITLE = "title";
    private int columnNum;
    private List<ImageBean> data;
    private int defaultSpacing;
    private ImageGridAdapter gridAdapter;
    private GridLayoutManager gridLayoutManager;
    private RecyclerView imageGrid;
    private int itemHeight;
    private int itemWidth;
    private int placeHolder;
    private ImageBean selected;
    private TitleBarLayout titleBarLayout;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class GridDecoration extends RecyclerView.ItemDecoration {
        private final int columnNum;
        private final int leftRightSpace;
        private final int topBottomSpace;

        public GridDecoration(int i, int i2, int i3) {
            this.columnNum = i;
            this.leftRightSpace = i2;
            this.topBottomSpace = i3;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.columnNum;
            int i2 = childAdapterPosition % i;
            int i3 = this.leftRightSpace;
            rect.left = (i2 * i3) / i;
            rect.right = (i3 * ((i - 1) - i2)) / i;
            if (childAdapterPosition >= i) {
                rect.top = this.topBottomSpace;
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ImageGridAdapter extends RecyclerView.Adapter<ImageViewHolder> {
        private List<ImageBean> data;
        private int itemHeight;
        private int itemWidth;
        private OnItemClickListener onItemClickListener;
        private int placeHolder;
        private ImageBean selected;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public static class ImageViewHolder extends RecyclerView.ViewHolder {
            private final Button defaultLayout;
            private final ImageView imageView;
            private final RelativeLayout selectBorderLayout;
            private final ImageView selectedBorder;

            public ImageViewHolder(View view) {
                super(view);
                this.imageView = (ImageView) view.findViewById(R.id.content_image);
                this.selectedBorder = (ImageView) view.findViewById(R.id.select_border);
                this.selectBorderLayout = (RelativeLayout) view.findViewById(R.id.selected_border_area);
                this.defaultLayout = (Button) view.findViewById(R.id.default_image_layout);
            }
        }

        private void setItemLayoutParams(ImageViewHolder imageViewHolder) {
            if (this.itemHeight > 0 && this.itemWidth > 0) {
                ViewGroup.LayoutParams layoutParams = imageViewHolder.imageView.getLayoutParams();
                layoutParams.width = this.itemWidth;
                layoutParams.height = this.itemHeight;
                imageViewHolder.imageView.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = imageViewHolder.selectBorderLayout.getLayoutParams();
                layoutParams2.width = this.itemWidth;
                layoutParams2.height = this.itemHeight;
                imageViewHolder.selectBorderLayout.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = imageViewHolder.selectedBorder.getLayoutParams();
                layoutParams3.width = this.itemWidth;
                layoutParams3.height = this.itemHeight;
                imageViewHolder.selectedBorder.setLayoutParams(layoutParams3);
            }
        }

        public int getItemCount() {
            List<ImageBean> list = this.data;
            if (list != null && !list.isEmpty()) {
                return this.data.size();
            }
            return 0;
        }

        public void setData(List<ImageBean> list) {
            this.data = list;
        }

        public void setItemHeight(int i) {
            this.itemHeight = i;
        }

        public void setItemWidth(int i) {
            this.itemWidth = i;
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public void setPlaceHolder(int i) {
            this.placeHolder = i;
        }

        public void setSelected(ImageBean imageBean) {
            List<ImageBean> list = this.data;
            if (list != null && !list.isEmpty()) {
                this.selected = imageBean;
                notifyDataSetChanged();
            } else {
                this.selected = imageBean;
            }
        }

        public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
            ImageView imageView = imageViewHolder.imageView;
            setItemLayoutParams(imageViewHolder);
            final ImageBean imageBean = this.data.get(i);
            ImageBean imageBean2 = this.selected;
            if (imageBean2 == null || imageBean == null || !TextUtils.equals(imageBean2.getThumbnailUri(), imageBean.getThumbnailUri())) {
                imageViewHolder.selectBorderLayout.setVisibility(8);
            } else {
                imageViewHolder.selectBorderLayout.setVisibility(0);
            }
            if (imageBean.getGroupGridAvatar() != null) {
                imageViewHolder.defaultLayout.setVisibility(8);
                if (imageView instanceof SynthesizedImageView) {
                    SynthesizedImageView synthesizedImageView = (SynthesizedImageView) imageView;
                    String imageId = imageBean.getImageId();
                    synthesizedImageView.setImageId(imageId);
                    synthesizedImageView.displayImage(imageBean.getGroupGridAvatar()).load(imageId);
                }
            } else if (imageBean.isDefault()) {
                imageViewHolder.defaultLayout.setVisibility(0);
                imageView.setImageDrawable(a.getDrawable(imageView.getContext(), android.R.color.transparent));
            } else {
                imageViewHolder.defaultLayout.setVisibility(8);
                Glide.with(((RecyclerView.ViewHolder) imageViewHolder).itemView.getContext()).b().K0(imageBean.getThumbnailUri()).X(this.placeHolder).q0(new h().j(this.placeHolder)).D0(imageView);
            }
            ((RecyclerView.ViewHolder) imageViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity.ImageGridAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ImageGridAdapter.this.onItemClickListener != null) {
                        ImageGridAdapter.this.onItemClickListener.onClick(imageBean);
                    }
                }
            });
        }

        public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.core_select_image_item_layout, viewGroup, false));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnItemClickListener {
        void onClick(ImageBean imageBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void DownloadUrl() {
        ImageBean imageBean = this.selected;
        if (imageBean == null) {
            return;
        }
        if (imageBean.isDefault()) {
            this.selected.setLocalPath(TUIConstants.TUIChat.CHAT_CONVERSATION_BACKGROUND_DEFAULT_URL);
            setResult(this.selected);
            ToastUtil.toastShortMessage(getResources().getString(R.string.setting_success));
            finish();
            return;
        }
        String imageUri = this.selected.getImageUri();
        if (TextUtils.isEmpty(imageUri)) {
            Log.d(TAG, "DownloadUrl is null");
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ImageSelectActivity.this.finish();
            }
        });
        progressDialog.setMessage(getResources().getString(R.string.setting));
        progressDialog.show();
        final ImageBean imageBean2 = this.selected;
        Glide.with(this).i().K0(imageUri).F0(new g() { // from class: com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity.5
            public boolean onLoadFailed(q qVar, Object obj, j jVar, boolean z) {
                progressDialog.cancel();
                Log.e(ImageSelectActivity.TAG, "DownloadUrl onLoadFailed e = " + qVar);
                ToastUtil.toastShortMessage(ImageSelectActivity.this.getResources().getString(R.string.setting_fail));
                return false;
            }

            public boolean onResourceReady(File file, Object obj, j jVar, m4.a aVar, boolean z) {
                progressDialog.cancel();
                String absolutePath = file.getAbsolutePath();
                Log.e(ImageSelectActivity.TAG, "DownloadUrl resource path = " + absolutePath);
                imageBean2.setLocalPath(absolutePath);
                ImageSelectActivity.this.setResult(imageBean2);
                ToastUtil.toastShortMessage(ImageSelectActivity.this.getResources().getString(R.string.setting_success));
                return false;
            }
        }).O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setResult(ImageBean imageBean) {
        Intent intent = new Intent();
        intent.putExtra("data", imageBean);
        setResult(0, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setSelectedStatus() {
        List<ImageBean> list;
        ImageBean imageBean = this.selected;
        if (imageBean != null && (list = this.data) != null && list.contains(imageBean)) {
            this.titleBarLayout.getRightTitle().setEnabled(true);
            this.titleBarLayout.getRightTitle().setTextColor(getResources().getColor(TUIThemeManager.getAttrResId(this, R.attr.core_primary_color)));
        } else {
            this.titleBarLayout.getRightTitle().setEnabled(false);
            this.titleBarLayout.getRightTitle().setTextColor(-10066330);
        }
        this.gridAdapter.setSelected(this.selected);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.defaultSpacing = ScreenUtil.dip2px(12.0f);
        setContentView(R.layout.core_activity_image_select_layout);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        final boolean booleanExtra = intent.getBooleanExtra(NEED_DOWLOAD_LOCAL, false);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.image_select_title);
        this.titleBarLayout = titleBarLayout;
        titleBarLayout.setTitle(stringExtra, ITitleBarLayout.Position.MIDDLE);
        this.titleBarLayout.setTitle(getString(R.string.sure), ITitleBarLayout.Position.RIGHT);
        this.titleBarLayout.getRightIcon().setVisibility(8);
        this.titleBarLayout.getRightTitle().setTextColor(-16748801);
        this.titleBarLayout.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageSelectActivity.this.setResult(-1);
                ImageSelectActivity.this.finish();
            }
        });
        this.titleBarLayout.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageSelectActivity.this.selected == null) {
                    return;
                }
                if (booleanExtra) {
                    ImageSelectActivity.this.DownloadUrl();
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("data", ImageSelectActivity.this.selected);
                ImageSelectActivity.this.setResult(0, intent2);
                ImageSelectActivity.this.finish();
            }
        });
        this.data = (List) intent.getSerializableExtra("data");
        this.selected = (ImageBean) intent.getSerializableExtra(SELECTED);
        this.placeHolder = intent.getIntExtra(PLACEHOLDER, 0);
        this.itemHeight = intent.getIntExtra(ITEM_HEIGHT, 0);
        this.itemWidth = intent.getIntExtra(ITEM_WIDTH, 0);
        int intExtra = intent.getIntExtra(SPAN_COUNT, 2);
        this.columnNum = intExtra;
        this.gridLayoutManager = new GridLayoutManager(this, intExtra);
        RecyclerView findViewById = findViewById(R.id.image_select_grid);
        this.imageGrid = findViewById;
        int i = this.columnNum;
        int i2 = this.defaultSpacing;
        findViewById.addItemDecoration(new GridDecoration(i, i2, i2));
        this.imageGrid.setLayoutManager(this.gridLayoutManager);
        this.imageGrid.setItemAnimator((RecyclerView.ItemAnimator) null);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter();
        this.gridAdapter = imageGridAdapter;
        imageGridAdapter.setPlaceHolder(this.placeHolder);
        this.gridAdapter.setSelected(this.selected);
        this.gridAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity.3
            @Override // com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity.OnItemClickListener
            public void onClick(ImageBean imageBean) {
                ImageSelectActivity.this.selected = imageBean;
                ImageSelectActivity.this.setSelectedStatus();
            }
        });
        this.gridAdapter.setItemWidth(this.itemWidth);
        this.gridAdapter.setItemHeight(this.itemHeight);
        this.imageGrid.setAdapter(this.gridAdapter);
        this.gridAdapter.setData(this.data);
        setSelectedStatus();
        this.gridAdapter.notifyDataSetChanged();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ImageBean implements Serializable {
        List<Object> groupGridAvatar;
        String imageId;
        String imageUri;
        boolean isDefault;
        String localPath;
        String thumbnailUri;

        public ImageBean() {
            this.isDefault = false;
            this.groupGridAvatar = null;
        }

        public List<Object> getGroupGridAvatar() {
            return this.groupGridAvatar;
        }

        public String getImageId() {
            return this.imageId;
        }

        public String getImageUri() {
            return this.imageUri;
        }

        public String getLocalPath() {
            return this.localPath;
        }

        public String getThumbnailUri() {
            return this.thumbnailUri;
        }

        public boolean isDefault() {
            return this.isDefault;
        }

        public void setDefault(boolean z) {
            this.isDefault = z;
        }

        public void setGroupGridAvatar(List<Object> list) {
            this.groupGridAvatar = list;
        }

        public void setImageId(String str) {
            this.imageId = str;
        }

        public void setImageUri(String str) {
            this.imageUri = str;
        }

        public void setLocalPath(String str) {
            this.localPath = str;
        }

        public void setThumbnailUri(String str) {
            this.thumbnailUri = str;
        }

        public ImageBean(String str, String str2, boolean z) {
            this.groupGridAvatar = null;
            this.thumbnailUri = str;
            this.imageUri = str2;
            this.isDefault = z;
        }
    }
}
