package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.inputmore;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.InputView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class InputMoreDialogFragment extends DialogFragment {
    public static final int REQUEST_CODE_FILE = 1011;
    public static final int REQUEST_CODE_PHOTO = 1012;
    private SelectAdapter mAdapter;
    private IUIKitCallback mCallback;
    private RecyclerView mInputActionView;
    private List<InputMoreActionUnit> mInputMoreList = new ArrayList();
    private InputView.OnMoreActionsClickLisener mMoreActionsListener;
    private Dialog moreDialog;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class SelectAdapter extends RecyclerView.Adapter<SelectViewHolder> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class SelectViewHolder extends RecyclerView.ViewHolder {
            ImageView itemImage;
            RelativeLayout itemLayout;
            TextView itemLine;
            TextView itemText;

            public SelectViewHolder(View view) {
                super(view);
                this.itemLayout = (RelativeLayout) view.findViewById(R.id.item_layout);
                this.itemText = (TextView) view.findViewById(R.id.item_text);
                this.itemImage = (ImageView) view.findViewById(R.id.item_icon);
                this.itemLine = (TextView) view.findViewById(R.id.divide_line);
            }
        }

        SelectAdapter() {
        }

        public int getItemCount() {
            return InputMoreDialogFragment.this.mInputMoreList.size();
        }

        public void onBindViewHolder(SelectViewHolder selectViewHolder, int i) {
            final InputMoreActionUnit inputMoreActionUnit = (InputMoreActionUnit) InputMoreDialogFragment.this.mInputMoreList.get(i);
            if (inputMoreActionUnit.getTitleId() > 0) {
                selectViewHolder.itemText.setText(InputMoreDialogFragment.this.getContext().getString(inputMoreActionUnit.getTitleId()));
            }
            if (inputMoreActionUnit.getIconResId() > 0) {
                selectViewHolder.itemImage.setImageDrawable(a.getDrawable(InputMoreDialogFragment.this.getContext(), inputMoreActionUnit.getIconResId()));
            }
            selectViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.inputmore.InputMoreDialogFragment.SelectAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    inputMoreActionUnit.getOnClickListener().onClick();
                    if (inputMoreActionUnit.getActionType() == 0 && InputMoreDialogFragment.this.moreDialog != null) {
                        InputMoreDialogFragment.this.moreDialog.dismiss();
                    }
                }
            });
            if (i == InputMoreDialogFragment.this.mInputMoreList.size() - 1) {
                selectViewHolder.itemLine.setVisibility(8);
            }
        }

        public SelectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new SelectViewHolder(LayoutInflater.from(InputMoreDialogFragment.this.getContext()).inflate(R.layout.minimalist_input_more_item, viewGroup, false));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1011 || i == 1012) {
            if (i2 != -1) {
                Dialog dialog = this.moreDialog;
                if (dialog != null) {
                    dialog.dismiss();
                    return;
                }
                return;
            }
            Uri data = intent.getData();
            IUIKitCallback iUIKitCallback = this.mCallback;
            if (iUIKitCallback != null) {
                iUIKitCallback.onSuccess(data);
            }
            Dialog dialog2 = this.moreDialog;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.minimalist_input_more, viewGroup, false);
        this.mInputActionView = inflate.findViewById(R.id.input_extra_area);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel_button);
        this.moreDialog = getDialog();
        SelectAdapter selectAdapter = new SelectAdapter();
        this.mAdapter = selectAdapter;
        this.mInputActionView.setAdapter(selectAdapter);
        this.mInputActionView.setLayoutManager(new CustomLinearLayoutManager(getContext()));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.inputmore.InputMoreDialogFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (InputMoreDialogFragment.this.moreDialog != null) {
                    InputMoreDialogFragment.this.moreDialog.dismiss();
                }
            }
        });
        Dialog dialog = this.moreDialog;
        if (dialog != null) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width -= ScreenUtil.getPxByDp(16.0f);
            attributes.y = ScreenUtil.getPxByDp(34.0f);
            this.moreDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
            window.setGravity(81);
            window.setAttributes(attributes);
            this.moreDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.inputmore.InputMoreDialogFragment.2
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4 && keyEvent.getAction() == 0) {
                        InputMoreDialogFragment.this.moreDialog.dismiss();
                        return false;
                    }
                    return false;
                }
            });
        }
        return inflate;
    }

    public void setActions(List<InputMoreActionUnit> list) {
        this.mInputMoreList = list;
    }

    public void setCallback(IUIKitCallback iUIKitCallback) {
        this.mCallback = iUIKitCallback;
    }

    public void setMoreActionsListener(InputView.OnMoreActionsClickLisener onMoreActionsClickLisener) {
        this.mMoreActionsListener = onMoreActionsClickLisener;
    }
}
