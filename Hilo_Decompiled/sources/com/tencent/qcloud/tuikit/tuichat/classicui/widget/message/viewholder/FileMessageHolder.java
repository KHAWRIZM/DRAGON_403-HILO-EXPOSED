package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FileMessageHolder extends MessageContentHolder {
    private TextView fileNameText;
    private TextView fileSizeText;
    private TextView fileStatusText;
    private String msgId;
    private NetworkConnectionListener networkConnectionListener;
    private Drawable normalBackground;
    private ProgressDrawable progressDrawable;
    private ProgressPresenter.ProgressListener progressListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ProgressDrawable extends Drawable {
        private Drawable backgroundDrawable;
        private final Paint borderPaint;
        private final float borderWidth;
        private final Paint highLightPaint;
        private boolean isSelf;
        private final Paint paint;
        private int progress;
        private final Path rectPath = new Path();
        private final Path solidPath = new Path();
        private final Path highLightPath = new Path();

        ProgressDrawable() {
            float dip2px = ScreenUtil.dip2px(0.96f);
            this.borderWidth = dip2px;
            Paint paint = new Paint();
            this.paint = paint;
            Paint paint2 = new Paint();
            this.borderPaint = paint2;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(dip2px);
            paint.setAntiAlias(true);
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.highLightPaint = paint3;
            paint3.setAntiAlias(true);
            paint3.setStyle(style);
            paint3.setColor(0);
        }

        public void clearHighLightColor() {
            this.highLightPaint.setColor(0);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            float[] fArr;
            if (this.progress == 0) {
                return;
            }
            Rect bounds = this.backgroundDrawable.getBounds();
            int i = bounds.right;
            int i2 = bounds.bottom;
            int i3 = (this.progress * i) / 100;
            float dip2px = ScreenUtil.dip2px(10.96f);
            float dip2px2 = ScreenUtil.dip2px(2.19f);
            if (this.isSelf) {
                fArr = new float[]{dip2px, dip2px, dip2px2, dip2px2, dip2px, dip2px, dip2px, dip2px};
            } else {
                fArr = new float[]{dip2px2, dip2px2, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px};
            }
            this.rectPath.reset();
            this.solidPath.reset();
            this.highLightPath.reset();
            Path path = this.rectPath;
            float f = this.borderWidth;
            float f2 = i2;
            RectF rectF = new RectF(f / 2.0f, f / 2.0f, i - (f / 2.0f), f2 - (f / 2.0f));
            Path.Direction direction = Path.Direction.CW;
            path.addRoundRect(rectF, fArr, direction);
            this.highLightPath.set(this.rectPath);
            canvas.drawPath(this.rectPath, this.borderPaint);
            Path path2 = this.solidPath;
            float f3 = this.borderWidth;
            path2.addRect(new RectF(f3 / 2.0f, f3 / 2.0f, i3 - (f3 / 2.0f), f2 - (f3 / 2.0f)), direction);
            this.rectPath.op(this.solidPath, Path.Op.INTERSECT);
            canvas.drawPath(this.rectPath, this.paint);
            canvas.drawPath(this.highLightPath, this.highLightPaint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        public void setBackgroundDrawable(Drawable drawable) {
            this.backgroundDrawable = drawable;
        }

        public void setBorderColor(int i) {
            this.borderPaint.setColor(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public void setHighLightColor(int i) {
            this.highLightPaint.setColor(i);
        }

        public void setPaintColor(int i) {
            this.paint.setColor(i);
        }

        public void setProgress(int i) {
            this.progress = i;
        }

        public void setSelf(boolean z) {
            this.isSelf = z;
        }
    }

    public FileMessageHolder(View view) {
        super(view);
        this.fileNameText = (TextView) view.findViewById(R.id.file_name_tv);
        this.fileSizeText = (TextView) view.findViewById(R.id.file_size_tv);
        this.fileStatusText = (TextView) view.findViewById(R.id.file_status_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFile(final FileMessageBean fileMessageBean, final String str, final String str2, boolean z) {
        if (fileMessageBean.getDownloadStatus() == 6) {
            return;
        }
        if (fileMessageBean.getDownloadStatus() == 4 && z) {
            return;
        }
        fileMessageBean.setDownloadStatus(4);
        this.fileStatusText.setText(R.string.downloading);
        fileMessageBean.downloadFile(str, new FileMessageBean.FileDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder.6
            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onError(int i, String str3) {
                ToastUtil.toastLongMessage("getToFile fail:" + i + "=" + str3);
                FileMessageHolder.this.fileStatusText.setText(R.string.un_download);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onProgress(long j, long j2) {
                ProgressPresenter.getInstance().updateProgress(fileMessageBean.getId(), (int) ((j * 100) / j2));
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onSuccess() {
                fileMessageBean.setDataPath(str);
                if (!fileMessageBean.isSelf()) {
                    FileMessageHolder.this.fileStatusText.setText(R.string.downloaded);
                } else {
                    FileMessageHolder.this.fileStatusText.setText(R.string.sended);
                }
                fileMessageBean.setDownloadStatus(6);
                FileMessageHolder.this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (fileMessageBean.getDownloadStatus() == 6) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            FileUtil.openFile(str, str2);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(int i, TUIMessageBean tUIMessageBean) {
        if (!TextUtils.equals(tUIMessageBean.getId(), this.msgId)) {
            return;
        }
        if (!tUIMessageBean.isSelf()) {
            this.fileStatusText.setText(R.string.downloading);
        } else {
            this.fileStatusText.setText(R.string.sending);
        }
        tUIMessageBean.setDownloadStatus(4);
        if (i != 0 && i != 100) {
            Drawable background = this.msgArea.getBackground();
            if (background != null) {
                ProgressDrawable progressDrawable = this.progressDrawable;
                if (progressDrawable == null) {
                    ProgressDrawable progressDrawable2 = new ProgressDrawable();
                    this.progressDrawable = progressDrawable2;
                    progressDrawable2.setProgress(i);
                    Context context = ((RecyclerView.ViewHolder) this).itemView.getContext();
                    this.progressDrawable.setPaintColor(context.getResources().getColor(TUIThemeManager.getAttrResId(context, com.tencent.qcloud.tuicore.R.attr.core_bubble_bg_color)));
                    this.progressDrawable.setBorderColor(context.getResources().getColor(R.color.chat_message_bubble_bg_stoke_color));
                    this.progressDrawable.setSelf(tUIMessageBean.isSelf());
                    this.progressDrawable.setBackgroundDrawable(background);
                    this.msgArea.setBackground(this.progressDrawable);
                    return;
                }
                progressDrawable.setProgress(i);
                this.msgArea.setBackground(this.progressDrawable);
                this.msgArea.getBackground().invalidateSelf();
                return;
            }
            return;
        }
        this.msgArea.setBackground(this.normalBackground);
        ProgressDrawable progressDrawable3 = this.progressDrawable;
        if (progressDrawable3 != null) {
            progressDrawable3.setProgress(0);
        }
        if (i == 100) {
            if (!tUIMessageBean.isSelf()) {
                this.fileStatusText.setText(R.string.downloaded);
            } else {
                this.fileStatusText.setText(R.string.sended);
            }
            tUIMessageBean.setDownloadStatus(6);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.normalBackground;
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
        ProgressDrawable progressDrawable = this.progressDrawable;
        if (progressDrawable != null) {
            progressDrawable.clearHighLightColor();
            this.progressDrawable.invalidateSelf();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_file;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView] */
    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i) {
        this.msgArea.setPadding(0, 0, 0, 0);
        this.msgId = tUIMessageBean.getId();
        ?? r0 = this.reactView;
        r0.setThemeColorId(TUIThemeManager.getAttrResId(r0.getContext(), R.attr.chat_react_other_text_color));
        if (!this.isForwardMode && !this.isReplyDetailMode) {
            if (tUIMessageBean.isSelf()) {
                if (this.properties.getRightBubble() != null && this.properties.getRightBubble().getConstantState() != null) {
                    this.msgArea.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
                } else {
                    this.msgArea.setBackgroundResource(R.drawable.chat_bubble_self_cavity_bg);
                }
            } else if (this.properties.getLeftBubble() != null && this.properties.getLeftBubble().getConstantState() != null) {
                this.msgArea.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
            } else {
                this.msgArea.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
            }
        } else {
            this.msgArea.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
            this.statusImage.setVisibility(8);
        }
        this.normalBackground = this.msgArea.getBackground();
        this.progressListener = new ProgressPresenter.ProgressListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder.1
            @Override // com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter.ProgressListener
            public void onProgress(int i2) {
                FileMessageHolder.this.updateProgress(i2, tUIMessageBean);
            }
        };
        this.sendingProgress.setVisibility(8);
        final FileMessageBean fileMessageBean = (FileMessageBean) tUIMessageBean;
        final String dataPath = fileMessageBean.getDataPath();
        this.fileNameText.setText(fileMessageBean.getFileName());
        String formatFileSize = FileUtil.formatFileSize(fileMessageBean.getFileSize());
        final String fileName = fileMessageBean.getFileName();
        this.fileSizeText.setText(formatFileSize);
        if (!this.isMultiSelectMode) {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fileMessageBean.getDownloadStatus() == 6) {
                        FileUtil.openFile(dataPath, fileName);
                    }
                }
            });
        } else {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = FileMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageClick(view, i, tUIMessageBean);
                    }
                }
            });
        }
        if (fileMessageBean.getStatus() == 2 && fileMessageBean.getDownloadStatus() == 6) {
            this.fileStatusText.setText(R.string.sended);
        } else if (fileMessageBean.getStatus() == 1) {
            this.fileStatusText.setText(R.string.sending);
        } else if (fileMessageBean.getStatus() == 3) {
            this.fileStatusText.setText(R.string.send_failed);
        } else if (fileMessageBean.getDownloadStatus() == 4) {
            this.fileStatusText.setText(R.string.downloading);
        } else if (fileMessageBean.getDownloadStatus() == 6) {
            if (!fileMessageBean.isSelf()) {
                this.fileStatusText.setText(R.string.downloaded);
            } else {
                this.fileStatusText.setText(R.string.sended);
            }
        } else if (fileMessageBean.getDownloadStatus() == 5) {
            this.fileStatusText.setText(R.string.un_download);
        }
        if (fileMessageBean.getDownloadStatus() == 5) {
            if (this.isMultiSelectMode) {
                return;
            } else {
                this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FileMessageHolder.this.downloadFile(fileMessageBean, dataPath, fileName, true);
                    }
                });
            }
        }
        this.networkConnectionListener = new NetworkConnectionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.FileMessageHolder.5
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener
            public void onConnected() {
                if (fileMessageBean.getDownloadStatus() == 4) {
                    FileMessageHolder.this.downloadFile(fileMessageBean, dataPath, fileName, false);
                }
            }
        };
        TUIChatService.getInstance().registerNetworkListener(this.networkConnectionListener);
        ProgressPresenter.getInstance().registerProgressListener(tUIMessageBean.getId(), this.progressListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void onRecycled() {
        super.onRecycled();
        this.progressListener = null;
        ProgressPresenter.getInstance().unregisterProgressListener(this.msgId, this.progressListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i) {
        Drawable drawable = this.normalBackground;
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        ProgressDrawable progressDrawable = this.progressDrawable;
        if (progressDrawable != null) {
            progressDrawable.setHighLightColor(i);
            this.progressDrawable.invalidateSelf();
        }
    }
}
