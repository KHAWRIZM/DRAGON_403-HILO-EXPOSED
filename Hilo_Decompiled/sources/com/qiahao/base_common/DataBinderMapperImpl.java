package com.qiahao.base_common;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.qiahao.base_common.databinding.DialogChatMenuBindingImpl;
import com.qiahao.base_common.databinding.DialogImageTypeBindingImpl;
import com.qiahao.base_common.databinding.DialogLoadingBindingImpl;
import com.qiahao.base_common.databinding.DialogProgressBindingImpl;
import com.qiahao.base_common.databinding.DialogReportBindingImpl;
import com.qiahao.base_common.databinding.DialogSelectPickerBindingImpl;
import com.qiahao.base_common.databinding.DialogTipBindingImpl;
import com.qiahao.base_common.databinding.DialogTipBlackBindingImpl;
import com.qiahao.base_common.databinding.DialogTipTitleBindingImpl;
import com.qiahao.base_common.databinding.DialogWhiteReportBindingImpl;
import com.qiahao.base_common.databinding.HiloGradeBindingImpl;
import com.qiahao.base_common.databinding.HiloMedalItemBindingImpl;
import com.qiahao.base_common.databinding.HiloMedalViewBindingImpl;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBindingImpl;
import com.qiahao.base_common.databinding.IncludeGameLevelBindingImpl;
import com.qiahao.base_common.databinding.NickTextViewBindingImpl;
import com.qiahao.base_common.databinding.ViewCountryIdBindingImpl;
import com.qiahao.base_common.databinding.ViewTabLayoutTitleBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class DataBinderMapperImpl extends e {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f١٢٣٨٦a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final HashMap f١٢٣٨٧a;

        static {
            HashMap hashMap = new HashMap(18);
            f١٢٣٨٧a = hashMap;
            hashMap.put("layout/dialog_chat_menu_0", Integer.valueOf(R.layout.dialog_chat_menu));
            hashMap.put("layout/dialog_image_type_0", Integer.valueOf(R.layout.dialog_image_type));
            hashMap.put("layout/dialog_loading_0", Integer.valueOf(R.layout.dialog_loading));
            hashMap.put("layout/dialog_progress_0", Integer.valueOf(R.layout.dialog_progress));
            hashMap.put("layout/dialog_report_0", Integer.valueOf(R.layout.dialog_report));
            hashMap.put("layout/dialog_select_picker_0", Integer.valueOf(R.layout.dialog_select_picker));
            hashMap.put("layout/dialog_tip_0", Integer.valueOf(R.layout.dialog_tip));
            hashMap.put("layout/dialog_tip_black_0", Integer.valueOf(R.layout.dialog_tip_black));
            hashMap.put("layout/dialog_tip_title_0", Integer.valueOf(R.layout.dialog_tip_title));
            hashMap.put("layout/dialog_white_report_0", Integer.valueOf(R.layout.dialog_white_report));
            hashMap.put("layout/hilo_grade_0", Integer.valueOf(R.layout.hilo_grade));
            hashMap.put("layout/hilo_medal_item_0", Integer.valueOf(R.layout.hilo_medal_item));
            hashMap.put("layout/hilo_medal_view_0", Integer.valueOf(R.layout.hilo_medal_view));
            hashMap.put("layout/include_family_name_plate_0", Integer.valueOf(R.layout.include_family_name_plate));
            hashMap.put("layout/include_game_level_0", Integer.valueOf(R.layout.include_game_level));
            hashMap.put("layout/nick_text_view_0", Integer.valueOf(R.layout.nick_text_view));
            hashMap.put("layout/view_country_id_0", Integer.valueOf(R.layout.view_country_id));
            hashMap.put("layout/view_tab_layout_title_0", Integer.valueOf(R.layout.view_tab_layout_title));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(18);
        f١٢٣٨٦a = sparseIntArray;
        sparseIntArray.put(R.layout.dialog_chat_menu, 1);
        sparseIntArray.put(R.layout.dialog_image_type, 2);
        sparseIntArray.put(R.layout.dialog_loading, 3);
        sparseIntArray.put(R.layout.dialog_progress, 4);
        sparseIntArray.put(R.layout.dialog_report, 5);
        sparseIntArray.put(R.layout.dialog_select_picker, 6);
        sparseIntArray.put(R.layout.dialog_tip, 7);
        sparseIntArray.put(R.layout.dialog_tip_black, 8);
        sparseIntArray.put(R.layout.dialog_tip_title, 9);
        sparseIntArray.put(R.layout.dialog_white_report, 10);
        sparseIntArray.put(R.layout.hilo_grade, 11);
        sparseIntArray.put(R.layout.hilo_medal_item, 12);
        sparseIntArray.put(R.layout.hilo_medal_view, 13);
        sparseIntArray.put(R.layout.include_family_name_plate, 14);
        sparseIntArray.put(R.layout.include_game_level, 15);
        sparseIntArray.put(R.layout.nick_text_view, 16);
        sparseIntArray.put(R.layout.view_country_id, 17);
        sparseIntArray.put(R.layout.view_tab_layout_title, 18);
    }

    @Override // androidx.databinding.e
    public List collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.ruffian.library.widget.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View view, int i10) {
        int i11 = f١٢٣٨٦a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i11) {
                case 1:
                    if ("layout/dialog_chat_menu_0".equals(tag)) {
                        return new DialogChatMenuBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_chat_menu is invalid. Received: " + tag);
                case 2:
                    if ("layout/dialog_image_type_0".equals(tag)) {
                        return new DialogImageTypeBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_image_type is invalid. Received: " + tag);
                case 3:
                    if ("layout/dialog_loading_0".equals(tag)) {
                        return new DialogLoadingBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_loading is invalid. Received: " + tag);
                case 4:
                    if ("layout/dialog_progress_0".equals(tag)) {
                        return new DialogProgressBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_progress is invalid. Received: " + tag);
                case 5:
                    if ("layout/dialog_report_0".equals(tag)) {
                        return new DialogReportBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_report is invalid. Received: " + tag);
                case 6:
                    if ("layout/dialog_select_picker_0".equals(tag)) {
                        return new DialogSelectPickerBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_select_picker is invalid. Received: " + tag);
                case 7:
                    if ("layout/dialog_tip_0".equals(tag)) {
                        return new DialogTipBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_tip is invalid. Received: " + tag);
                case 8:
                    if ("layout/dialog_tip_black_0".equals(tag)) {
                        return new DialogTipBlackBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_tip_black is invalid. Received: " + tag);
                case 9:
                    if ("layout/dialog_tip_title_0".equals(tag)) {
                        return new DialogTipTitleBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_tip_title is invalid. Received: " + tag);
                case 10:
                    if ("layout/dialog_white_report_0".equals(tag)) {
                        return new DialogWhiteReportBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_white_report is invalid. Received: " + tag);
                case 11:
                    if ("layout/hilo_grade_0".equals(tag)) {
                        return new HiloGradeBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_grade is invalid. Received: " + tag);
                case 12:
                    if ("layout/hilo_medal_item_0".equals(tag)) {
                        return new HiloMedalItemBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_medal_item is invalid. Received: " + tag);
                case 13:
                    if ("layout/hilo_medal_view_0".equals(tag)) {
                        return new HiloMedalViewBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_medal_view is invalid. Received: " + tag);
                case 14:
                    if ("layout/include_family_name_plate_0".equals(tag)) {
                        return new IncludeFamilyNamePlateBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for include_family_name_plate is invalid. Received: " + tag);
                case 15:
                    if ("layout/include_game_level_0".equals(tag)) {
                        return new IncludeGameLevelBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for include_game_level is invalid. Received: " + tag);
                case 16:
                    if ("layout/nick_text_view_0".equals(tag)) {
                        return new NickTextViewBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for nick_text_view is invalid. Received: " + tag);
                case 17:
                    if ("layout/view_country_id_0".equals(tag)) {
                        return new ViewCountryIdBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for view_country_id is invalid. Received: " + tag);
                case 18:
                    if ("layout/view_tab_layout_title_0".equals(tag)) {
                        return new ViewTabLayoutTitleBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for view_tab_layout_title is invalid. Received: " + tag);
                default:
                    return null;
            }
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = (Integer) a.f١٢٣٨٧a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f١٢٣٨٦a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
