package com.tencent.qcloud.tuicore.component.gatherimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TeamHeadSynthesizer implements Synthesizer {
    ImageView imageView;
    Context mContext;
    MultiImageData multiImageData;
    private String currentImageId = "";
    Callback callback = new Callback() { // from class: com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.1
        @Override // com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.Callback
        public void onCall(Bitmap bitmap, String str) {
            if (!TextUtils.equals(TeamHeadSynthesizer.this.getImageId(), str)) {
                return;
            }
            GlideEngine.loadUserIcon(TeamHeadSynthesizer.this.imageView, bitmap);
        }
    };

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    interface Callback {
        void onCall(Bitmap bitmap, String str);
    }

    public TeamHeadSynthesizer(Context context, ImageView imageView) {
        this.mContext = context;
        this.imageView = imageView;
        init();
    }

    private Bitmap asyncLoadImage(Object obj, int i) throws ExecutionException, InterruptedException {
        return GlideEngine.loadBitmap(obj, i);
    }

    private void init() {
        this.multiImageData = new MultiImageData();
    }

    @Override // com.tencent.qcloud.tuicore.component.gatherimage.Synthesizer
    public boolean asyncLoadImageList(MultiImageData multiImageData) {
        List<Object> imageUrls = multiImageData.getImageUrls();
        for (int i = 0; i < imageUrls.size(); i++) {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), TUIConfig.getDefaultAvatarImage());
            try {
                multiImageData.putBitmap(asyncLoadImage(imageUrls.get(i), multiImageData.targetImageSize), i);
            } catch (InterruptedException e) {
                e.printStackTrace();
                multiImageData.putBitmap(decodeResource, i);
            } catch (ExecutionException e2) {
                e2.printStackTrace();
                multiImageData.putBitmap(decodeResource, i);
            }
        }
        return true;
    }

    protected int[] calculateGridParam(int i) {
        int i2;
        int[] iArr = new int[2];
        if (i < 3) {
            iArr[0] = 1;
            iArr[1] = i;
        } else if (i <= 4) {
            iArr[0] = 2;
            iArr[1] = 2;
        } else {
            int i3 = i / 3;
            if (i % 3 == 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            iArr[0] = i3 + i2;
            iArr[1] = 3;
        }
        return iArr;
    }

    public void clearImage() {
        GlideEngine.clear(this.imageView);
    }

    public void drawBitmapAtPosition(Canvas canvas, int i, int i2, int i3, int i4, Bitmap bitmap) {
        if (bitmap == null && this.multiImageData.getDefaultImageResId() > 0) {
            bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), this.multiImageData.getDefaultImageResId());
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(i, i2, i3, i4), (Paint) null);
        }
    }

    @Override // com.tencent.qcloud.tuicore.component.gatherimage.Synthesizer
    public void drawDrawable(Canvas canvas, MultiImageData multiImageData) {
        int i;
        canvas.drawColor(multiImageData.bgColor);
        int size = multiImageData.size();
        int i2 = multiImageData.maxHeight;
        int i3 = multiImageData.gap;
        int i4 = (i2 + i3) / 2;
        int i5 = (i2 - i3) / 2;
        int i6 = multiImageData.maxWidth;
        int i7 = (i6 + i3) / 2;
        int i8 = (i6 - i3) / 2;
        int i9 = (i2 - multiImageData.targetImageSize) / 2;
        int i10 = 0;
        while (i10 < size) {
            int i11 = multiImageData.columnCount;
            int i12 = i10 / i11;
            int i13 = i10 % i11;
            int i14 = multiImageData.targetImageSize;
            int i15 = i4;
            double d = i14 * (i11 == 1 ? i13 + 0.5d : i13);
            int i16 = multiImageData.gap;
            int i17 = i5;
            int i18 = (int) (d + ((i13 + 1) * i16));
            int i19 = (int) ((i14 * (i11 == 1 ? i12 + 0.5d : i12)) + (i16 * (i12 + 1)));
            int i20 = i18 + i14;
            int i21 = i19 + i14;
            Bitmap bitmap = multiImageData.getBitmap(i10);
            if (size == 1) {
                i = i10;
                drawBitmapAtPosition(canvas, i18, i19, i20, i21, bitmap);
            } else {
                i = i10;
                if (size == 2) {
                    drawBitmapAtPosition(canvas, i18, i9, i20, i9 + multiImageData.targetImageSize, bitmap);
                } else if (size == 3) {
                    if (i == 0) {
                        drawBitmapAtPosition(canvas, i9, i19, i9 + multiImageData.targetImageSize, i21, bitmap);
                    } else {
                        int i22 = multiImageData.gap;
                        int i23 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i - 1) * i23) + (i22 * i), i15, (i22 * i) + (i23 * i), i15 + i23, bitmap);
                    }
                } else if (size == 4) {
                    drawBitmapAtPosition(canvas, i18, i19, i20, i21, bitmap);
                } else if (size == 5) {
                    if (i == 0) {
                        int i24 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, i8 - i24, i8 - i24, i8, i8, bitmap);
                    } else if (i == 1) {
                        int i25 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, i7, i8 - i25, i7 + i25, i8, bitmap);
                    } else {
                        int i26 = multiImageData.gap;
                        int i27 = i - 1;
                        int i28 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i - 2) * i28) + (i26 * i27), i15, (i26 * i27) + (i27 * i28), i15 + i28, bitmap);
                    }
                } else if (size == 6) {
                    if (i < 3) {
                        int i29 = multiImageData.gap;
                        int i30 = i + 1;
                        int i31 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, (i31 * i) + (i29 * i30), i17 - i31, (i29 * i30) + (i31 * i30), i17, bitmap);
                    } else {
                        int i32 = multiImageData.gap;
                        int i33 = i - 2;
                        int i34 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i - 3) * i34) + (i32 * i33), i15, (i32 * i33) + (i33 * i34), i15 + i34, bitmap);
                    }
                } else if (size == 7) {
                    if (i == 0) {
                        int i35 = multiImageData.gap;
                        int i36 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, i9, i35, i9 + i36, i35 + i36, bitmap);
                    } else if (i > 0 && i < 4) {
                        int i37 = multiImageData.gap;
                        int i38 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i - 1) * i38) + (i37 * i), i9, (i37 * i) + (i38 * i), i9 + i38, bitmap);
                    } else {
                        int i39 = multiImageData.gap;
                        int i40 = i - 3;
                        int i41 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i - 4) * i41) + (i39 * i40), i15 + (i41 / 2), (i39 * i40) + (i40 * i41), i15 + (i41 / 2) + i41, bitmap);
                    }
                } else if (size == 8) {
                    if (i == 0) {
                        int i42 = multiImageData.targetImageSize;
                        int i43 = multiImageData.gap;
                        drawBitmapAtPosition(canvas, i8 - i42, i43, i8, i43 + i42, bitmap);
                    } else if (i == 1) {
                        int i44 = multiImageData.gap;
                        int i45 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, i7, i44, i7 + i45, i44 + i45, bitmap);
                    } else if (i > 1 && i < 5) {
                        int i46 = multiImageData.gap;
                        int i47 = i - 1;
                        int i48 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i - 2) * i48) + (i46 * i47), i9, (i46 * i47) + (i47 * i48), i9 + i48, bitmap);
                    } else {
                        int i49 = multiImageData.gap;
                        int i50 = i - 4;
                        int i51 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i - 5) * i51) + (i49 * i50), i15 + (i51 / 2), (i49 * i50) + (i50 * i51), i15 + (i51 / 2) + i51, bitmap);
                    }
                } else if (size == 9) {
                    drawBitmapAtPosition(canvas, i18, i19, i20, i21, bitmap);
                }
            }
            i10 = i + 1;
            i4 = i15;
            i5 = i17;
        }
    }

    public int getDefaultImage() {
        return this.multiImageData.getDefaultImageResId();
    }

    public String getImageId() {
        return this.currentImageId;
    }

    public MultiImageData getMultiImageData() {
        return this.multiImageData;
    }

    public void load(final String str) {
        final MultiImageData multiImageData;
        if (this.multiImageData.size() == 0) {
            if (str != null && !TextUtils.equals(str, this.currentImageId)) {
                return;
            }
            GlideEngine.loadUserIcon(this.imageView, Integer.valueOf(getDefaultImage()));
            return;
        }
        if (this.multiImageData.size() == 1) {
            if (str != null && !TextUtils.equals(str, this.currentImageId)) {
                return;
            }
            GlideEngine.loadUserIcon(this.imageView, this.multiImageData.getImageUrls().get(0));
            return;
        }
        clearImage();
        try {
            multiImageData = this.multiImageData.m١٣٣clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            ArrayList arrayList = new ArrayList();
            List<Object> list = this.multiImageData.imageUrls;
            if (list != null) {
                arrayList.addAll(list);
            }
            multiImageData = new MultiImageData(arrayList, this.multiImageData.defaultImageResId);
        }
        int[] calculateGridParam = calculateGridParam(this.multiImageData.size());
        multiImageData.rowCount = calculateGridParam[0];
        int i = calculateGridParam[1];
        multiImageData.columnCount = i;
        int i2 = multiImageData.maxWidth - ((i + 1) * multiImageData.gap);
        if (i == 1) {
            i = 2;
        }
        multiImageData.targetImageSize = i2 / i;
        ThreadHelper.INST.execute(new Runnable() { // from class: com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.2
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap bitmap;
                File file = new File(TUIConfig.getImageBaseDir() + str);
                boolean z = false;
                if (file.exists() && file.isFile()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(file.getPath(), options);
                    if (options.outWidth > 0 && options.outHeight > 0) {
                        z = true;
                    }
                } else {
                    bitmap = null;
                }
                if (!z) {
                    TeamHeadSynthesizer.this.asyncLoadImageList(multiImageData);
                    final Bitmap synthesizeImageList = TeamHeadSynthesizer.this.synthesizeImageList(multiImageData);
                    ImageUtil.storeBitmap(file, synthesizeImageList);
                    ImageUtil.setGroupConversationAvatar(str, file.getAbsolutePath());
                    BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            TeamHeadSynthesizer.this.callback.onCall(synthesizeImageList, str);
                        }
                    });
                    return;
                }
                BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        TeamHeadSynthesizer.this.callback.onCall(bitmap, str);
                    }
                });
            }
        });
    }

    public void setBgColor(int i) {
        this.multiImageData.bgColor = i;
    }

    public void setDefaultImage(int i) {
        this.multiImageData.setDefaultImageResId(i);
    }

    public void setGap(int i) {
        this.multiImageData.gap = i;
    }

    public void setImageId(String str) {
        this.currentImageId = str;
    }

    public void setMaxWidthHeight(int i, int i2) {
        MultiImageData multiImageData = this.multiImageData;
        multiImageData.maxWidth = i;
        multiImageData.maxHeight = i2;
    }

    @Override // com.tencent.qcloud.tuicore.component.gatherimage.Synthesizer
    public Bitmap synthesizeImageList(MultiImageData multiImageData) {
        Bitmap createBitmap = Bitmap.createBitmap(multiImageData.maxWidth, multiImageData.maxHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawDrawable(canvas, multiImageData);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }
}
