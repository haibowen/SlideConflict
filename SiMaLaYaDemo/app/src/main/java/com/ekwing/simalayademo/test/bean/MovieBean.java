package com.ekwing.simalayademo.test.bean;

public class MovieBean extends BaseBean {

    private String mImageId;
    private String mTextContent;
    private int mPrice;

    public MovieBean(String mImageId, String mTextContent, int mPrice) {
        this.mImageId = mImageId;
        this.mTextContent = mTextContent;
        this.mPrice = mPrice;
    }

    public String getmImageId() {
        return mImageId;
    }

    public void setmImageId(String mImageId) {
        this.mImageId = mImageId;
    }

    public String getmTextContent() {
        return mTextContent;
    }

    public void setmTextContent(String mTextContent) {
        this.mTextContent = mTextContent;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }
}
