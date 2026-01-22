package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.contrarywind.view.WheelView;
import com.qiahao.base_common.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BaseDialogBottomSheetDatePickerBinding implements a {
    public final TextView cancel;
    public final TextView confirm;
    public final WheelView day;
    public final WheelView hour;
    public final WheelView min;
    public final WheelView month;
    private final FrameLayout rootView;
    public final WheelView second;
    public final LinearLayout timepicker;
    public final FrameLayout title;
    public final WheelView year;

    private BaseDialogBottomSheetDatePickerBinding(FrameLayout frameLayout, TextView textView, TextView textView2, WheelView wheelView, WheelView wheelView2, WheelView wheelView3, WheelView wheelView4, WheelView wheelView5, LinearLayout linearLayout, FrameLayout frameLayout2, WheelView wheelView6) {
        this.rootView = frameLayout;
        this.cancel = textView;
        this.confirm = textView2;
        this.day = wheelView;
        this.hour = wheelView2;
        this.min = wheelView3;
        this.month = wheelView4;
        this.second = wheelView5;
        this.timepicker = linearLayout;
        this.title = frameLayout2;
        this.year = wheelView6;
    }

    public static BaseDialogBottomSheetDatePickerBinding bind(View view) {
        int i10 = R.id.cancel;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.confirm;
            TextView textView2 = (TextView) b.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.day;
                WheelView wheelView = (WheelView) b.a(view, i10);
                if (wheelView != null) {
                    i10 = R.id.hour;
                    WheelView wheelView2 = (WheelView) b.a(view, i10);
                    if (wheelView2 != null) {
                        i10 = R.id.min;
                        WheelView wheelView3 = (WheelView) b.a(view, i10);
                        if (wheelView3 != null) {
                            i10 = R.id.month;
                            WheelView wheelView4 = (WheelView) b.a(view, i10);
                            if (wheelView4 != null) {
                                i10 = R.id.second;
                                WheelView wheelView5 = (WheelView) b.a(view, i10);
                                if (wheelView5 != null) {
                                    i10 = R.id.timepicker;
                                    LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                                    if (linearLayout != null) {
                                        i10 = R.id.title;
                                        FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
                                        if (frameLayout != null) {
                                            i10 = R.id.year;
                                            WheelView wheelView6 = (WheelView) b.a(view, i10);
                                            if (wheelView6 != null) {
                                                return new BaseDialogBottomSheetDatePickerBinding((FrameLayout) view, textView, textView2, wheelView, wheelView2, wheelView3, wheelView4, wheelView5, linearLayout, frameLayout, wheelView6);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BaseDialogBottomSheetDatePickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BaseDialogBottomSheetDatePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.base_dialog_bottom_sheet_date_picker, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
