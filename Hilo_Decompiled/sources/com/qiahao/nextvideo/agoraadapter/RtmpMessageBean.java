package com.qiahao.nextvideo.agoraadapter;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class RtmpMessageBean {
    private CanvasDTO canvas;
    private String ver;
    private List<RegionsDTO> regions = new ArrayList();
    private Long ts = 0L;
    private String appData = "";

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class CanvasDTO {
        private String bgnd;
        private Integer h;
        private Integer w;

        public String getBgnd() {
            return this.bgnd;
        }

        public Integer getH() {
            return this.h;
        }

        public Integer getW() {
            return this.w;
        }

        public void setBgnd(String str) {
            this.bgnd = str;
        }

        public void setH(Integer num) {
            this.h = num;
        }

        public void setW(Integer num) {
            this.w = num;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class RegionsDTO {
        private Float alpha = Float.valueOf(1.0f);
        private Integer h;
        private Integer uid;
        private Integer volume;
        private Integer w;
        private Integer x;
        private Integer y;
        private Integer zOrder;
        private Integer zorder;

        public Float getAlpha() {
            return this.alpha;
        }

        public Integer getH() {
            return this.h;
        }

        public Integer getUid() {
            return this.uid;
        }

        public Integer getVolume() {
            return this.volume;
        }

        public Integer getW() {
            return this.w;
        }

        public Integer getX() {
            return this.x;
        }

        public Integer getY() {
            return this.y;
        }

        public Integer getZOrder() {
            return this.zOrder;
        }

        public Integer getZorder() {
            return this.zorder;
        }

        public void setAlpha(Float f) {
            this.alpha = f;
        }

        public void setH(Integer num) {
            this.h = num;
        }

        public void setUid(Integer num) {
            this.uid = num;
        }

        public void setVolume(Integer num) {
            this.volume = num;
        }

        public void setW(Integer num) {
            this.w = num;
        }

        public void setX(Integer num) {
            this.x = num;
        }

        public void setY(Integer num) {
            this.y = num;
        }

        public void setZOrder(Integer num) {
            this.zOrder = num;
        }

        public void setZorder(Integer num) {
            this.zorder = num;
        }
    }

    public String getAppData() {
        return this.appData;
    }

    public CanvasDTO getCanvas() {
        return this.canvas;
    }

    public List<RegionsDTO> getRegions() {
        return this.regions;
    }

    public Long getTs() {
        return this.ts;
    }

    public String getVer() {
        return this.ver;
    }

    public void setAppData(String str) {
        this.appData = str;
    }

    public void setCanvas(CanvasDTO canvasDTO) {
        this.canvas = canvasDTO;
    }

    public void setRegions(List<RegionsDTO> list) {
        this.regions = list;
    }

    public void setTs(Long l) {
        this.ts = l;
    }

    public void setVer(String str) {
        this.ver = str;
    }
}
