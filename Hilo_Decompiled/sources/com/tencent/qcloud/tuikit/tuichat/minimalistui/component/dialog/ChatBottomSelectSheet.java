package com.tencent.qcloud.tuikit.tuichat.minimalistui.component.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatBottomSelectSheet {
    private Dialog dialog;
    private ArrayAdapter<String> listAdapter;
    private BottomSelectSheetOnClickListener onClickListener;
    private List<String> selectList = new ArrayList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface BottomSelectSheetOnClickListener {
        void onSheetClick(int i);
    }

    public ChatBottomSelectSheet(Context context) {
        View inflate = View.inflate(context, R.layout.chat_minimalist_bottom_select_sheet, null);
        Dialog dialog = new Dialog(context, R.style.ChatBottomSelectSheet);
        this.dialog = dialog;
        dialog.setContentView(inflate);
        this.dialog.setCancelable(true);
        this.dialog.setCanceledOnTouchOutside(true);
        Window window = this.dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = defaultDisplay.getWidth();
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setGravity(80);
        window.setWindowAnimations(R.style.ChatBottomSelectSheet_Anim);
        ListView listView = (ListView) inflate.findViewById(R.id.item_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, R.layout.chat_minimalist_bottom_sheet_item, R.id.sheet_item, this.selectList);
        this.listAdapter = arrayAdapter;
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.dialog.ChatBottomSelectSheet.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ChatBottomSelectSheet.this.dismiss();
                if (ChatBottomSelectSheet.this.onClickListener != null) {
                    ChatBottomSelectSheet.this.onClickListener.onSheetClick(i);
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.dialog.ChatBottomSelectSheet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ChatBottomSelectSheet.this.dismiss();
            }
        });
    }

    public void dismiss() {
        Dialog dialog = this.dialog;
        if (dialog != null && dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    public void setOnClickListener(BottomSelectSheetOnClickListener bottomSelectSheetOnClickListener) {
        this.onClickListener = bottomSelectSheetOnClickListener;
    }

    public void setSelectList(List<String> list) {
        this.selectList.clear();
        this.selectList.addAll(list);
    }

    public void show() {
        Dialog dialog = this.dialog;
        if (dialog != null && !dialog.isShowing()) {
            this.listAdapter.notifyDataSetChanged();
            this.dialog.show();
        }
    }
}
