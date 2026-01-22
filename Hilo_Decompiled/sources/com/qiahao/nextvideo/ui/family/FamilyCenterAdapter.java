package com.qiahao.nextvideo.ui.family;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyRoomInfo;
import com.qiahao.nextvideo.data.model.GroupMedalDetailBean;
import com.qiahao.nextvideo.databinding.ItemFamilyRoomBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.rank.GroupMedalAndPowerLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyCenterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/family/FamilyRoomInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFamilyRoomBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyCenterAdapter extends BaseQuickAdapter<FamilyRoomInfo, BaseDataBindingHolder<ItemFamilyRoomBinding>> {
    public FamilyCenterAdapter() {
        super(R.layout.item_family_room, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x022f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void convert(@NotNull BaseDataBindingHolder<ItemFamilyRoomBinding> holder, @NotNull FamilyRoomInfo item) {
        int i;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        LinearLayout linearLayout;
        ImageView imageView4;
        ItemFamilyRoomBinding itemFamilyRoomBinding;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        ImageView imageView13;
        GroupMedalAndPowerLayout groupMedalAndPowerLayout;
        TextView textView;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding;
        String str;
        Integer grade;
        RoundedImageView roundedImageView;
        ImageView imageView14;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFamilyRoomBinding itemFamilyRoomBinding2 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding2 != null && (textView3 = itemFamilyRoomBinding2.groupName) != null) {
            textView3.setText(item.getName());
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding3 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding3 != null && (textView2 = itemFamilyRoomBinding3.groupAnnounce) != null) {
            textView2.setText(item.getNotification());
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding4 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding4 != null && (imageView14 = itemFamilyRoomBinding4.iconCount) != null) {
            ImageKtxKt.loadImage$default(imageView14, ImageSizeKt.image100(item.getCountryIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding5 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding5 != null && (roundedImageView = itemFamilyRoomBinding5.roomAvatar) != null) {
            ImageKtxKt.loadImage$default(roundedImageView, ImageSizeKt.image200(item.getFaceUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding6 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding6 != null && (includeFamilyNamePlateBinding = itemFamilyRoomBinding6.familyNamePlate) != null) {
            FamilyInfo groupPower = item.getGroupPower();
            int intValue = (groupPower == null || (grade = groupPower.getGrade()) == null) ? -1 : grade.intValue();
            FamilyInfo groupPower2 = item.getGroupPower();
            if (groupPower2 == null || (str = groupPower2.getNameplate()) == null) {
                str = "";
            }
            AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, intValue, str, 0, 4, (Object) null);
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding7 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding7 != null && (textView = itemFamilyRoomBinding7.personNumber) != null) {
            textView.setText(String.valueOf(item.getGroupInUserDuration()));
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding8 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding8 != null && (groupMedalAndPowerLayout = itemFamilyRoomBinding8.groupMedalAndPower) != null) {
            List<GroupMedalDetailBean> groupMedals = item.getGroupMedals();
            GroupMedalAndPowerLayout.setDataAndLayoutView$default(groupMedalAndPowerLayout, null, (ArrayList) (groupMedals != null ? CollectionsKt.toMutableList(groupMedals) : null), 6, 1, null);
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding9 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding9 != null && (imageView13 = itemFamilyRoomBinding9.groupSupportMedal) != null) {
            imageView13.setVisibility(8);
        }
        if (item.getSupportLevel() > 0) {
            int supportMedal = MeetingRoomManager.INSTANCE.getSupportMedal(item.getSupportLevel());
            if (supportMedal == 0) {
                ItemFamilyRoomBinding itemFamilyRoomBinding10 = (ItemFamilyRoomBinding) holder.getDataBinding();
                if (itemFamilyRoomBinding10 != null && (imageView12 = itemFamilyRoomBinding10.groupSupportMedal) != null) {
                    imageView12.setVisibility(8);
                }
            } else {
                ItemFamilyRoomBinding itemFamilyRoomBinding11 = (ItemFamilyRoomBinding) holder.getDataBinding();
                if (itemFamilyRoomBinding11 != null && (imageView11 = itemFamilyRoomBinding11.groupSupportMedal) != null) {
                    imageView11.setVisibility(0);
                }
                ItemFamilyRoomBinding itemFamilyRoomBinding12 = (ItemFamilyRoomBinding) holder.getDataBinding();
                if (itemFamilyRoomBinding12 != null && (imageView10 = itemFamilyRoomBinding12.groupSupportMedal) != null) {
                    ImageKtxKt.loadImage$default(imageView10, (String) null, (Uri) null, (File) null, Integer.valueOf(supportMedal), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
            }
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding13 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding13 != null && (imageView9 = itemFamilyRoomBinding13.rocket1) != null) {
            imageView9.setVisibility(8);
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding14 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding14 != null && (imageView8 = itemFamilyRoomBinding14.rocket2) != null) {
            imageView8.setVisibility(8);
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding15 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding15 != null && (imageView7 = itemFamilyRoomBinding15.rocket3) != null) {
            imageView7.setVisibility(8);
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding16 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding16 != null && (imageView6 = itemFamilyRoomBinding16.rocket4) != null) {
            imageView6.setVisibility(8);
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding17 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding17 != null && (imageView5 = itemFamilyRoomBinding17.rocket5) != null) {
            imageView5.setVisibility(8);
        }
        Integer maxStage = item.getMaxStage();
        int intValue2 = maxStage != null ? maxStage.intValue() : -1;
        if (intValue2 <= 2 || intValue2 - 2 >= 4) {
            i = 0;
        }
        while (i < 5) {
            if (i == 0) {
                ItemFamilyRoomBinding itemFamilyRoomBinding18 = (ItemFamilyRoomBinding) holder.getDataBinding();
                if (itemFamilyRoomBinding18 != null) {
                    imageView4 = itemFamilyRoomBinding18.rocket1;
                    if (imageView4 != null) {
                    }
                    i++;
                }
                imageView4 = null;
                if (imageView4 != null) {
                }
                i++;
            } else if (i == 1) {
                ItemFamilyRoomBinding itemFamilyRoomBinding19 = (ItemFamilyRoomBinding) holder.getDataBinding();
                if (itemFamilyRoomBinding19 != null) {
                    imageView4 = itemFamilyRoomBinding19.rocket2;
                    if (imageView4 != null) {
                    }
                    i++;
                }
                imageView4 = null;
                if (imageView4 != null) {
                }
                i++;
            } else if (i == 2) {
                ItemFamilyRoomBinding itemFamilyRoomBinding20 = (ItemFamilyRoomBinding) holder.getDataBinding();
                if (itemFamilyRoomBinding20 != null) {
                    imageView4 = itemFamilyRoomBinding20.rocket3;
                    if (imageView4 != null) {
                    }
                    i++;
                }
                imageView4 = null;
                if (imageView4 != null) {
                }
                i++;
            } else if (i != 3) {
                if (i == 4 && (itemFamilyRoomBinding = (ItemFamilyRoomBinding) holder.getDataBinding()) != null) {
                    imageView4 = itemFamilyRoomBinding.rocket5;
                    if (imageView4 != null) {
                        imageView4.setVisibility(i <= intValue2 ? 0 : 8);
                    }
                    i++;
                }
                imageView4 = null;
                if (imageView4 != null) {
                }
                i++;
            } else {
                ItemFamilyRoomBinding itemFamilyRoomBinding21 = (ItemFamilyRoomBinding) holder.getDataBinding();
                if (itemFamilyRoomBinding21 != null) {
                    imageView4 = itemFamilyRoomBinding21.rocket4;
                    if (imageView4 != null) {
                    }
                    i++;
                }
                imageView4 = null;
                if (imageView4 != null) {
                }
                i++;
            }
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding22 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding22 != null && (linearLayout = itemFamilyRoomBinding22.llRocket) != null) {
            linearLayout.setVisibility(intValue2 > -1 ? 0 : 8);
        }
        String gameTypeIcon = item.getGameTypeIcon();
        if (gameTypeIcon != null && gameTypeIcon.length() > 0) {
            ItemFamilyRoomBinding itemFamilyRoomBinding23 = (ItemFamilyRoomBinding) holder.getDataBinding();
            if (itemFamilyRoomBinding23 != null && (imageView3 = itemFamilyRoomBinding23.gameImage) != null) {
                imageView3.setVisibility(0);
            }
            ItemFamilyRoomBinding itemFamilyRoomBinding24 = (ItemFamilyRoomBinding) holder.getDataBinding();
            if (itemFamilyRoomBinding24 == null || (imageView2 = itemFamilyRoomBinding24.gameImage) == null) {
                return;
            }
            ImageKtxKt.loadImage$default(imageView2, item.getGameTypeIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            return;
        }
        ItemFamilyRoomBinding itemFamilyRoomBinding25 = (ItemFamilyRoomBinding) holder.getDataBinding();
        if (itemFamilyRoomBinding25 == null || (imageView = itemFamilyRoomBinding25.gameImage) == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}
