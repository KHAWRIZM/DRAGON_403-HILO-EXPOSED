package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.inputmore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.BaseInputFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class InputMoreFragment extends BaseInputFragment {
    public static final int REQUEST_CODE_FILE = 1011;
    public static final int REQUEST_CODE_PHOTO = 1012;
    private View mBaseView;
    private IUIKitCallback mCallback;
    private List<InputMoreActionUnit> mInputMoreList = new ArrayList();

    public void onActivityResult(int i, int i2, Intent intent) {
        if ((i != 1011 && i != 1012) || i2 != -1) {
            return;
        }
        Uri data = intent.getData();
        IUIKitCallback iUIKitCallback = this.mCallback;
        if (iUIKitCallback != null) {
            iUIKitCallback.onSuccess(data);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.chat_inputmore_fragment, viewGroup, false);
        this.mBaseView = inflate;
        ((InputMoreLayout) inflate.findViewById(R.id.input_extra_area)).init(this.mInputMoreList);
        return this.mBaseView;
    }

    public void setActions(List<InputMoreActionUnit> list) {
        this.mInputMoreList = list;
    }

    public void setCallback(IUIKitCallback iUIKitCallback) {
        this.mCallback = iUIKitCallback;
    }
}
