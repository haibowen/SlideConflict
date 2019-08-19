package com.ekwing.simalayademo.test.bean;

public class MusicBean extends BaseBean {
    private String mTypeWord;

    public MusicBean(String mTypeWord) {
        this.mTypeWord = mTypeWord;
    }

    public String getmTypeWord() {
        return mTypeWord;
    }

    public void setmTypeWord(String mTypeWord) {
        this.mTypeWord = mTypeWord;
    }
}
