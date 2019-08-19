package com.ekwing.simalayademo.test.bean;

public class BaseBean {

    private int Type;
    public static final int BANNER = 0;
    public static final int MUSIC = 1;
    public static final int MOREBOOK = 2;
    public static final int BOOK = 3;
    public static final int MOVE = 4;
    public static final int HENG = 5;
    public static final int VIEW_PAGER=6;
    public static final int TYPE_VERT=7;


    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }
}
