package com.ekwing.simalayademo.test.bean;

public class BookBean extends BaseBean {


    private String mImageId;
    private String mTextCotent;

    public BookBean(String mImageId, String mTextCotent) {
        this.mImageId = mImageId;
        this.mTextCotent = mTextCotent;
    }

    public String getmImageId() {
        return mImageId;
    }

    public void setmImageId(String mImageId) {
        this.mImageId = mImageId;
    }

    public String getmTextCotent() {
        return mTextCotent;
    }

    public void setmTextCotent(String mTextCotent) {
        this.mTextCotent = mTextCotent;
    }
}
