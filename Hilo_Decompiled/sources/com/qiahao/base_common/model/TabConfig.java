package com.qiahao.base_common.model;

import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class TabConfig implements Serializable {
    private int defaultColor;
    private float defaultSize;
    private int selectColor;
    private float selectSize;
    private String textContent;

    public TabConfig() {
        this.textContent = "";
        this.defaultColor = -16777216;
        this.defaultSize = 15.0f;
    }

    public int getDefaultColor() {
        return this.defaultColor;
    }

    public float getDefaultSize() {
        return this.defaultSize;
    }

    public int getSelectColor() {
        int i10 = this.selectColor;
        if (i10 == 0) {
            return this.defaultColor;
        }
        return i10;
    }

    public float getSelectSize() {
        float f10 = this.selectSize;
        if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
            return this.defaultSize;
        }
        return f10;
    }

    public String getTextContent() {
        return this.textContent;
    }

    public void setDefaultColor(int i10) {
        this.defaultColor = i10;
    }

    public void setDefaultSize(float f10) {
        this.defaultSize = f10;
    }

    public void setSelectColor(int i10) {
        this.selectColor = i10;
    }

    public void setSelectSize(float f10) {
        this.selectSize = f10;
    }

    public void setTextContent(String str) {
        this.textContent = str;
    }

    public TabConfig(String str, int i10, float f10) {
        this.textContent = str;
        this.defaultColor = i10;
        this.defaultSize = f10;
    }

    public TabConfig(String str, int i10, int i11, float f10, float f11) {
        this.textContent = str;
        this.defaultColor = i10;
        this.selectColor = i11;
        this.defaultSize = f10;
        this.selectSize = f11;
    }
}
