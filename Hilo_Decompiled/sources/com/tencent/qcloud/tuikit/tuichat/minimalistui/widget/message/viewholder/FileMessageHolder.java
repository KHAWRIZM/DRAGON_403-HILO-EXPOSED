package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FileMessageHolder extends MessageContentHolder {
    private View fileContent;
    private Drawable fileContentBackground;
    private TextView fileNameText;
    private TextView fileSizeText;
    private String msgId;
    private NetworkConnectionListener networkConnectionListener;
    private Drawable normalBackground;
    private ProgressPresenter.ProgressListener progressListener;

    public FileMessageHolder(View view) {
        super(view);
        this.fileNameText = (TextView) view.findViewById(R.id.file_name_tv);
        this.fileSizeText = (TextView) view.findViewById(R.id.file_size_tv);
        this.fileContent = view.findViewById(R.id.file_content);
        this.timeInLineTextLayout = (TimeInLineTextLayout) view.findViewById(R.id.file_msg_time_in_line_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFile(final FileMessageBean fileMessageBean, final String str, final String str2, boolean z) {
        if (fileMessageBean.getDownloadStatus() == 6) {
            return;
        }
        if (fileMessageBean.getDownloadStatus() == 4 && z) {
            return;
        }
        this.fileStatusImage.setVisibility(8);
        fileMessageBean.setDownloadStatus(4);
        fileMessageBean.downloadFile(str, new FileMessageBean.FileDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.FileMessageHolder.7
            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onError(int i, String str3) {
                ToastUtil.toastLongMessage("download file failed:" + i + "=" + str3);
                FileMessageHolder.this.fileStatusImage.setImageResource(R.drawable.chat_minimalist_file_download_icon);
                FileMessageHolder.this.fileStatusImage.setVisibility(0);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onProgress(long j, long j2) {
                ProgressPresenter.getInstance().updateProgress(fileMessageBean.getId(), (int) ((j * 100) / j2));
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onSuccess() {
                fileMessageBean.setDataPath(str);
                fileMessageBean.setDownloadStatus(6);
                FileMessageHolder.this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.FileMessageHolder.7.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (fileMessageBean.getDownloadStatus() == 6) {
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            FileUtil.openFile(str, str2);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(int i, FileMessageBean fileMessageBean) {
        if (!TextUtils.equals(fileMessageBean.getId(), this.msgId)) {
            return;
        }
        fileMessageBean.setDownloadStatus(4);
        if (i != 0 && i != 100) {
            this.fileSizeText.setText(i + "%");
            return;
        }
        if (i == 100) {
            this.fileSizeText.setText(FileUtil.formatFileSize(fileMessageBean.getFileSize()));
            fileMessageBean.setDownloadStatus(6);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.normalBackground;
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
        Drawable drawable2 = this.fileContentBackground;
        if (drawable2 != null) {
            drawable2.setColorFilter(null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.minimalist_message_adapter_content_file;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i) {
        this.msgArea.setPadding(0, 0, 0, 0);
        this.msgId = tUIMessageBean.getId();
        if (this.isForwardMode || this.isMessageDetailMode) {
            this.fileStatusImage.setVisibility(8);
        }
        this.normalBackground = this.msgArea.getBackground();
        this.fileContentBackground = this.fileContent.getBackground();
        this.progressListener = new ProgressPresenter.ProgressListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.FileMessageHolder.1
            @Override // com.tencent.qcloud.tuikit.tuichat.component.progress.ProgressPresenter.ProgressListener
            public void onProgress(int i2) {
                FileMessageHolder.this.updateProgress(i2, (FileMessageBean) tUIMessageBean);
            }
        };
        final FileMessageBean fileMessageBean = (FileMessageBean) tUIMessageBean;
        final String dataPath = fileMessageBean.getDataPath();
        this.fileNameText.setText(fileMessageBean.getFileName());
        String formatFileSize = FileUtil.formatFileSize(fileMessageBean.getFileSize());
        final String fileName = fileMessageBean.getFileName();
        this.fileSizeText.setText(formatFileSize);
        if (!this.isMultiSelectMode) {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.FileMessageHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fileMessageBean.getDownloadStatus() == 6) {
                        FileUtil.openFile(dataPath, fileName);
                    }
                }
            });
        } else {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.FileMessageHolder.3
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
            this.fileStatusImage.setVisibility(8);
        } else if (fileMessageBean.getStatus() != 1 && fileMessageBean.getStatus() != 3) {
            if (fileMessageBean.getDownloadStatus() == 4) {
                this.fileStatusImage.setVisibility(8);
            } else if (fileMessageBean.getDownloadStatus() == 6) {
                this.fileStatusImage.setVisibility(8);
            } else if (fileMessageBean.getDownloadStatus() == 5) {
                this.fileStatusImage.setImageResource(R.drawable.chat_minimalist_file_download_icon);
                this.fileStatusImage.setVisibility(0);
            }
        }
        if (fileMessageBean.getDownloadStatus() == 5) {
            if (this.isMultiSelectMode) {
                return;
            }
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.FileMessageHolder.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FileMessageHolder.this.downloadFile(fileMessageBean, dataPath, fileName, true);
                }
            });
            this.fileStatusImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.FileMessageHolder.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FileMessageHolder.this.downloadFile(fileMessageBean, dataPath, fileName, true);
                }
            });
        }
        this.networkConnectionListener = new NetworkConnectionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.FileMessageHolder.6
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

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void onRecycled() {
        ProgressPresenter.getInstance().unregisterProgressListener(this.msgId, this.progressListener);
        this.progressListener = null;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i) {
        Drawable drawable = this.normalBackground;
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        Drawable drawable2 = this.fileContentBackground;
        if (drawable2 != null) {
            drawable2.setColorFilter(i, PorterDuff.Mode.SRC_OVER);
        }
    }
}
