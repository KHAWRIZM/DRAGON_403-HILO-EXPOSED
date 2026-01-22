package com.tencent.qcloud.tuicore.component.gatherimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MultiImageData implements Cloneable {
    static final int maxSize = 9;
    Map<Integer, Bitmap> bitmapMap;
    int columnCount;
    int defaultImageResId;
    List<Object> imageUrls;
    int maxHeight;
    int maxWidth;
    int rowCount;
    int targetImageSize;
    int bgColor = Color.parseColor("#cfd3d8");
    int gap = 6;

    public MultiImageData() {
    }

    public Bitmap getBitmap(int i) {
        Bitmap bitmap;
        Map<Integer, Bitmap> map = this.bitmapMap;
        if (map != null) {
            synchronized (map) {
                bitmap = this.bitmapMap.get(Integer.valueOf(i));
            }
            return bitmap;
        }
        return null;
    }

    public int getDefaultImageResId() {
        return this.defaultImageResId;
    }

    public List<Object> getImageUrls() {
        return this.imageUrls;
    }

    public void putBitmap(Bitmap bitmap, int i) {
        Map<Integer, Bitmap> map = this.bitmapMap;
        if (map != null) {
            synchronized (map) {
                this.bitmapMap.put(Integer.valueOf(i), bitmap);
            }
        } else {
            HashMap hashMap = new HashMap();
            this.bitmapMap = hashMap;
            synchronized (hashMap) {
                this.bitmapMap.put(Integer.valueOf(i), bitmap);
            }
        }
    }

    public void setDefaultImageResId(int i) {
        this.defaultImageResId = i;
    }

    public void setImageUrls(List<Object> list) {
        this.imageUrls = list;
    }

    public int size() {
        List<Object> list = this.imageUrls;
        if (list != null) {
            if (list.size() > 9) {
                return 9;
            }
            return this.imageUrls.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MultiImageData m١٣٣clone() throws CloneNotSupportedException {
        MultiImageData multiImageData = (MultiImageData) super.clone();
        if (this.imageUrls != null) {
            ArrayList arrayList = new ArrayList(this.imageUrls.size());
            multiImageData.imageUrls = arrayList;
            arrayList.addAll(this.imageUrls);
        }
        if (this.bitmapMap != null) {
            HashMap hashMap = new HashMap();
            multiImageData.bitmapMap = hashMap;
            hashMap.putAll(this.bitmapMap);
        }
        return multiImageData;
    }

    public MultiImageData(int i) {
        this.defaultImageResId = i;
    }

    public MultiImageData(List<Object> list, int i) {
        this.imageUrls = list;
        this.defaultImageResId = i;
    }
}
