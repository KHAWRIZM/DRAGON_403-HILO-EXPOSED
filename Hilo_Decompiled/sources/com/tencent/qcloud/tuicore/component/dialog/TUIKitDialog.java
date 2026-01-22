package com.tencent.qcloud.tuicore.component.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.method.MovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.SPUtils;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIKitDialog {
    protected Dialog dialog;
    private LinearLayout mBackgroundLayout;
    private Button mCancelButton;
    private Context mContext;
    private Display mDisplay;
    private ImageView mLineImg;
    private LinearLayout mMainLayout;
    private Button mSureButton;
    protected TextView mTitleTv;
    private boolean showTitle = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;
    private float dialogWidth = 0.7f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class TUIIMUpdateDialog {
        public static final String KEY_NEVER_SHOW = "neverShow";
        private String dialogFeatureName;
        private boolean isNeverShow;
        private boolean isShowOnlyDebug;
        private WeakReference<TUIKitDialog> tuiKitDialog;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        private static final class TUIIMUpdateDialogHolder {
            private static final TUIIMUpdateDialog instance = new TUIIMUpdateDialog();

            private TUIIMUpdateDialogHolder() {
            }
        }

        private String getDialogFeatureName() {
            return this.dialogFeatureName;
        }

        public static TUIIMUpdateDialog getInstance() {
            return TUIIMUpdateDialogHolder.instance;
        }

        public TUIIMUpdateDialog createDialog(Context context) {
            WeakReference<TUIKitDialog> weakReference = new WeakReference<>(new TUIKitDialog(context));
            this.tuiKitDialog = weakReference;
            weakReference.get().builder();
            return this;
        }

        public void dismiss() {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().dismiss();
            }
        }

        public TUIIMUpdateDialog setCancelOutside(boolean z) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().setCancelOutside(z);
            }
            return this;
        }

        public TUIIMUpdateDialog setCancelable(boolean z) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().setCancelable(z);
            }
            return this;
        }

        public TUIIMUpdateDialog setDialogFeatureName(String str) {
            this.dialogFeatureName = str;
            return this;
        }

        public TUIIMUpdateDialog setDialogWidth(float f) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().setDialogWidth(f);
            }
            return this;
        }

        public TUIIMUpdateDialog setHighlightColor(int i) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().mTitleTv.setHighlightColor(i);
            }
            return this;
        }

        public TUIIMUpdateDialog setMovementMethod(MovementMethod movementMethod) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().mTitleTv.setMovementMethod(movementMethod);
            }
            return this;
        }

        public TUIIMUpdateDialog setNegativeButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().setNegativeButton(charSequence, onClickListener);
            }
            return this;
        }

        public void setNeverShow(boolean z) {
            this.isNeverShow = z;
            SPUtils.getInstance(TUIConfig.TUICORE_SETTINGS_SP_NAME).put(getDialogFeatureName(), z);
        }

        public TUIIMUpdateDialog setPositiveButton(CharSequence charSequence, View.OnClickListener onClickListener) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().setPositiveButton(charSequence, onClickListener);
            }
            return this;
        }

        public TUIIMUpdateDialog setShowOnlyDebug(boolean z) {
            this.isShowOnlyDebug = z;
            return this;
        }

        public TUIIMUpdateDialog setTitle(CharSequence charSequence) {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.tuiKitDialog.get().setTitle(charSequence);
            }
            return this;
        }

        public void show() {
            WeakReference<TUIKitDialog> weakReference = this.tuiKitDialog;
            if (weakReference != null && weakReference.get() != null) {
                this.isNeverShow = SPUtils.getInstance(TUIConfig.TUICORE_SETTINGS_SP_NAME).getBoolean(getDialogFeatureName(), false);
                Dialog dialog = this.tuiKitDialog.get().dialog;
                if (dialog == null || dialog.isShowing() || this.isNeverShow || this.isShowOnlyDebug) {
                    return;
                }
                this.tuiKitDialog.get().show();
            }
        }

        private TUIIMUpdateDialog() {
            this.isShowOnlyDebug = false;
            this.isNeverShow = SPUtils.getInstance(TUIConfig.TUICORE_SETTINGS_SP_NAME).getBoolean(getDialogFeatureName(), false);
        }
    }

    public TUIKitDialog(Context context) {
        this.mContext = context;
        this.mDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private void setLayout() {
        if (!this.showTitle) {
            this.mTitleTv.setVisibility(8);
        }
        if (this.showTitle) {
            this.mTitleTv.setVisibility(0);
        }
        if (!this.showPosBtn && !this.showNegBtn) {
            this.mSureButton.setVisibility(8);
            this.mSureButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TUIKitDialog.this.dialog.dismiss();
                }
            });
        }
        if (this.showPosBtn && this.showNegBtn) {
            this.mSureButton.setVisibility(0);
            this.mCancelButton.setVisibility(0);
            this.mLineImg.setVisibility(0);
        }
        if (this.showPosBtn && !this.showNegBtn) {
            this.mSureButton.setVisibility(0);
        }
        if (!this.showPosBtn && this.showNegBtn) {
            this.mCancelButton.setVisibility(0);
        }
    }

    public TUIKitDialog builder() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.view_dialog, (ViewGroup) null);
        this.mBackgroundLayout = (LinearLayout) inflate.findViewById(R.id.ll_background);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_alert);
        this.mMainLayout = linearLayout;
        linearLayout.setVerticalGravity(8);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
        this.mTitleTv = textView;
        textView.setVisibility(8);
        Button button = (Button) inflate.findViewById(R.id.btn_neg);
        this.mCancelButton = button;
        button.setVisibility(8);
        Button button2 = (Button) inflate.findViewById(R.id.btn_pos);
        this.mSureButton = button2;
        button2.setVisibility(8);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_line);
        this.mLineImg = imageView;
        imageView.setVisibility(8);
        Dialog dialog = new Dialog(this.mContext, R.style.TUIKit_AlertDialogStyle);
        this.dialog = dialog;
        dialog.setContentView(inflate);
        this.mBackgroundLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (this.mDisplay.getWidth() * this.dialogWidth), -2));
        return this;
    }

    public void dismiss() {
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    public boolean isShowing() {
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return false;
    }

    public TUIKitDialog setCancelOutside(boolean z) {
        this.dialog.setCanceledOnTouchOutside(z);
        return this;
    }

    public TUIKitDialog setCancelable(boolean z) {
        this.dialog.setCancelable(z);
        return this;
    }

    public TUIKitDialog setDialogWidth(float f) {
        LinearLayout linearLayout = this.mBackgroundLayout;
        if (linearLayout != null) {
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams((int) (this.mDisplay.getWidth() * f), -2));
        }
        this.dialogWidth = f;
        return this;
    }

    public TUIKitDialog setNegativeButton(CharSequence charSequence, final View.OnClickListener onClickListener) {
        this.showNegBtn = true;
        this.mCancelButton.setText(charSequence);
        this.mCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
                TUIKitDialog.this.dialog.dismiss();
            }
        });
        return this;
    }

    public TUIKitDialog setPositiveButton(CharSequence charSequence, final View.OnClickListener onClickListener) {
        this.showPosBtn = true;
        this.mSureButton.setText(charSequence);
        this.mSureButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
                TUIKitDialog.this.dialog.dismiss();
            }
        });
        return this;
    }

    public TUIKitDialog setTitle(CharSequence charSequence) {
        this.showTitle = true;
        this.mTitleTv.setText(charSequence);
        return this;
    }

    public void setTitleGravity(int i) {
        this.mTitleTv.setGravity(i);
    }

    public void show() {
        setLayout();
        this.dialog.show();
    }

    public TUIKitDialog setNegativeButton(View.OnClickListener onClickListener) {
        setNegativeButton(TUIConfig.getAppContext().getString(R.string.cancel), onClickListener);
        return this;
    }

    public TUIKitDialog setPositiveButton(View.OnClickListener onClickListener) {
        setPositiveButton(TUIConfig.getAppContext().getString(R.string.sure), onClickListener);
        return this;
    }
}
