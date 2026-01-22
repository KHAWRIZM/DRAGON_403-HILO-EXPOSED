package com.luck.picture.lib.adapter.holder;

import android.content.Context;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnGridItemSelectAnimListener;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.AnimUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ValueOf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BaseRecyclerMediaHolder extends RecyclerView.ViewHolder {
    public View btnCheck;
    private ColorFilter defaultColorFilter;
    public boolean isHandleMask;
    public boolean isSelectNumberStyle;
    public ImageView ivPicture;
    private PictureImageGridAdapter.OnItemClickListener listener;
    public Context mContext;
    private ColorFilter maskWhiteColorFilter;
    private ColorFilter selectColorFilter;
    public SelectorConfig selectorConfig;
    public TextView tvCheck;

    public BaseRecyclerMediaHolder(View view) {
        super(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (com.luck.picture.lib.config.PictureMimeType.isHasImage(r5.getMimeType()) == false) goto L٣٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        if (com.luck.picture.lib.config.PictureMimeType.isHasVideo(r5.getMimeType()) == false) goto L٣٩;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dispatchHandleMask(LocalMedia localMedia) {
        if (this.selectorConfig.getSelectCount() > 0 && !this.selectorConfig.getSelectedResult().contains(localMedia)) {
            SelectorConfig selectorConfig = this.selectorConfig;
            int i10 = Integer.MAX_VALUE;
            if (selectorConfig.isWithVideoImage) {
                if (selectorConfig.selectionMode == 1) {
                }
            } else {
                if (PictureMimeType.isHasVideo(selectorConfig.getResultFirstMimeType())) {
                    SelectorConfig selectorConfig2 = this.selectorConfig;
                    if (selectorConfig2.selectionMode != 1) {
                        int i11 = selectorConfig2.maxVideoSelectNum;
                        if (i11 <= 0) {
                            i11 = selectorConfig2.maxSelectNum;
                        }
                        i10 = i11;
                    }
                    if (selectorConfig2.getSelectCount() != i10) {
                    }
                    this.ivPicture.setColorFilter(this.maskWhiteColorFilter);
                    localMedia.setMaxSelectEnabledMask(true);
                    return;
                }
                SelectorConfig selectorConfig3 = this.selectorConfig;
                if (selectorConfig3.selectionMode != 1) {
                    i10 = selectorConfig3.maxSelectNum;
                }
                if (selectorConfig3.getSelectCount() != i10) {
                }
                this.ivPicture.setColorFilter(this.maskWhiteColorFilter);
                localMedia.setMaxSelectEnabledMask(true);
                return;
            }
        }
        localMedia.setMaxSelectEnabledMask(false);
    }

    public static BaseRecyclerMediaHolder generate(ViewGroup viewGroup, int i10, int i11, SelectorConfig selectorConfig) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        if (i10 != 1) {
            if (i10 != 3) {
                if (i10 != 4) {
                    return new ImageViewHolder(inflate, selectorConfig);
                }
                return new AudioViewHolder(inflate, selectorConfig);
            }
            return new VideoViewHolder(inflate, selectorConfig);
        }
        return new CameraViewHolder(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSelected(LocalMedia localMedia) {
        LocalMedia compareLocalMedia;
        boolean contains = this.selectorConfig.getSelectedResult().contains(localMedia);
        if (contains && (compareLocalMedia = localMedia.getCompareLocalMedia()) != null && compareLocalMedia.isEditorImage()) {
            localMedia.setCutPath(compareLocalMedia.getCutPath());
            localMedia.setCut(!TextUtils.isEmpty(compareLocalMedia.getCutPath()));
            localMedia.setEditorImage(compareLocalMedia.isEditorImage());
        }
        return contains;
    }

    private void notifySelectNumberStyle(LocalMedia localMedia) {
        this.tvCheck.setText("");
        for (int i10 = 0; i10 < this.selectorConfig.getSelectCount(); i10++) {
            LocalMedia localMedia2 = this.selectorConfig.getSelectedResult().get(i10);
            if (TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                this.tvCheck.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectedMedia(boolean z10) {
        ColorFilter colorFilter;
        if (this.tvCheck.isSelected() != z10) {
            this.tvCheck.setSelected(z10);
        }
        if (this.selectorConfig.isDirectReturnSingle) {
            this.ivPicture.setColorFilter(this.defaultColorFilter);
            return;
        }
        ImageView imageView = this.ivPicture;
        if (z10) {
            colorFilter = this.selectColorFilter;
        } else {
            colorFilter = this.defaultColorFilter;
        }
        imageView.setColorFilter(colorFilter);
    }

    public void bindData(final LocalMedia localMedia, final int i10) {
        localMedia.position = getAbsoluteAdapterPosition();
        selectedMedia(isSelected(localMedia));
        if (this.isSelectNumberStyle) {
            notifySelectNumberStyle(localMedia);
        }
        if (this.isHandleMask && this.selectorConfig.isMaxSelectEnabledMask) {
            dispatchHandleMask(localMedia);
        }
        String path = localMedia.getPath();
        if (localMedia.isEditorImage()) {
            path = localMedia.getCutPath();
        }
        loadCover(path);
        this.tvCheck.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseRecyclerMediaHolder.this.btnCheck.performClick();
            }
        });
        this.btnCheck.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int onSelected;
                OnGridItemSelectAnimListener onGridItemSelectAnimListener;
                if (BaseRecyclerMediaHolder.this.listener == null || (onSelected = BaseRecyclerMediaHolder.this.listener.onSelected(BaseRecyclerMediaHolder.this.tvCheck, i10, localMedia)) == -1) {
                    return;
                }
                if (onSelected == 0) {
                    BaseRecyclerMediaHolder baseRecyclerMediaHolder = BaseRecyclerMediaHolder.this;
                    SelectorConfig selectorConfig = baseRecyclerMediaHolder.selectorConfig;
                    if (selectorConfig.isSelectZoomAnim) {
                        OnGridItemSelectAnimListener onGridItemSelectAnimListener2 = selectorConfig.onItemSelectAnimListener;
                        if (onGridItemSelectAnimListener2 != null) {
                            onGridItemSelectAnimListener2.onSelectItemAnim(baseRecyclerMediaHolder.ivPicture, true);
                        } else {
                            AnimUtils.selectZoom(baseRecyclerMediaHolder.ivPicture);
                        }
                    }
                } else if (onSelected == 1) {
                    BaseRecyclerMediaHolder baseRecyclerMediaHolder2 = BaseRecyclerMediaHolder.this;
                    SelectorConfig selectorConfig2 = baseRecyclerMediaHolder2.selectorConfig;
                    if (selectorConfig2.isSelectZoomAnim && (onGridItemSelectAnimListener = selectorConfig2.onItemSelectAnimListener) != null) {
                        onGridItemSelectAnimListener.onSelectItemAnim(baseRecyclerMediaHolder2.ivPicture, false);
                    }
                }
                BaseRecyclerMediaHolder baseRecyclerMediaHolder3 = BaseRecyclerMediaHolder.this;
                baseRecyclerMediaHolder3.selectedMedia(baseRecyclerMediaHolder3.isSelected(localMedia));
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (BaseRecyclerMediaHolder.this.listener != null) {
                    BaseRecyclerMediaHolder.this.listener.onItemLongClick(view, i10);
                    return false;
                }
                return false;
            }
        });
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder.4
            /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
            
                if (r4.selectionMode != 1) goto L١٧;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
            
                if (r4.selectionMode != 1) goto L٢٤;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                if (BaseRecyclerMediaHolder.this.listener == null) {
                    return;
                }
                if ((!PictureMimeType.isHasImage(localMedia.getMimeType()) || !BaseRecyclerMediaHolder.this.selectorConfig.isEnablePreviewImage) && !BaseRecyclerMediaHolder.this.selectorConfig.isDirectReturnSingle) {
                    if (PictureMimeType.isHasVideo(localMedia.getMimeType())) {
                        SelectorConfig selectorConfig = BaseRecyclerMediaHolder.this.selectorConfig;
                        if (!selectorConfig.isEnablePreviewVideo) {
                        }
                    }
                    if (PictureMimeType.isHasAudio(localMedia.getMimeType())) {
                        SelectorConfig selectorConfig2 = BaseRecyclerMediaHolder.this.selectorConfig;
                        if (!selectorConfig2.isEnablePreviewAudio) {
                        }
                    }
                    BaseRecyclerMediaHolder.this.btnCheck.performClick();
                    return;
                }
                if (localMedia.isMaxSelectEnabledMask()) {
                    return;
                }
                BaseRecyclerMediaHolder.this.listener.onItemClick(BaseRecyclerMediaHolder.this.tvCheck, i10, localMedia);
            }
        });
    }

    protected void loadCover(String str) {
        ImageEngine imageEngine = this.selectorConfig.imageEngine;
        if (imageEngine != null) {
            imageEngine.loadGridImage(this.ivPicture.getContext(), str, this.ivPicture);
        }
    }

    public void setOnItemClickListener(PictureImageGridAdapter.OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public BaseRecyclerMediaHolder(View view, SelectorConfig selectorConfig) {
        super(view);
        int i10;
        this.selectorConfig = selectorConfig;
        Context context = view.getContext();
        this.mContext = context;
        this.defaultColorFilter = StyleUtils.getColorFilter(context, R.color.ps_color_20);
        this.selectColorFilter = StyleUtils.getColorFilter(this.mContext, R.color.ps_color_80);
        this.maskWhiteColorFilter = StyleUtils.getColorFilter(this.mContext, R.color.ps_color_half_white);
        SelectMainStyle selectMainStyle = this.selectorConfig.selectorStyle.getSelectMainStyle();
        this.isSelectNumberStyle = selectMainStyle.isSelectNumberStyle();
        this.ivPicture = (ImageView) view.findViewById(R.id.ivPicture);
        this.tvCheck = (TextView) view.findViewById(R.id.tvCheck);
        this.btnCheck = view.findViewById(R.id.btnCheck);
        boolean z10 = true;
        if (selectorConfig.selectionMode == 1 && selectorConfig.isDirectReturnSingle) {
            this.tvCheck.setVisibility(8);
            this.btnCheck.setVisibility(8);
        } else {
            this.tvCheck.setVisibility(0);
            this.btnCheck.setVisibility(0);
        }
        if (selectorConfig.isDirectReturnSingle || ((i10 = selectorConfig.selectionMode) != 1 && i10 != 2)) {
            z10 = false;
        }
        this.isHandleMask = z10;
        int adapterSelectTextSize = selectMainStyle.getAdapterSelectTextSize();
        if (StyleUtils.checkSizeValidity(adapterSelectTextSize)) {
            this.tvCheck.setTextSize(adapterSelectTextSize);
        }
        int adapterSelectTextColor = selectMainStyle.getAdapterSelectTextColor();
        if (StyleUtils.checkStyleValidity(adapterSelectTextColor)) {
            this.tvCheck.setTextColor(adapterSelectTextColor);
        }
        int selectBackground = selectMainStyle.getSelectBackground();
        if (StyleUtils.checkStyleValidity(selectBackground)) {
            this.tvCheck.setBackgroundResource(selectBackground);
        }
        int[] adapterSelectStyleGravity = selectMainStyle.getAdapterSelectStyleGravity();
        if (StyleUtils.checkArrayValidity(adapterSelectStyleGravity)) {
            if (this.tvCheck.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.tvCheck.getLayoutParams()).removeRule(21);
                for (int i11 : adapterSelectStyleGravity) {
                    ((RelativeLayout.LayoutParams) this.tvCheck.getLayoutParams()).addRule(i11);
                }
            }
            if (this.btnCheck.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.btnCheck.getLayoutParams()).removeRule(21);
                for (int i12 : adapterSelectStyleGravity) {
                    ((RelativeLayout.LayoutParams) this.btnCheck.getLayoutParams()).addRule(i12);
                }
            }
            int adapterSelectClickArea = selectMainStyle.getAdapterSelectClickArea();
            if (StyleUtils.checkSizeValidity(adapterSelectClickArea)) {
                ViewGroup.LayoutParams layoutParams = this.btnCheck.getLayoutParams();
                layoutParams.width = adapterSelectClickArea;
                layoutParams.height = adapterSelectClickArea;
            }
        }
    }
}
