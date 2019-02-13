package vip.housir.bookspider.entity;

import vip.housir.bookspider.common.Constant;

/**
 * @author housirvip
 */
public enum TaskType {

    /**
     * Book, Chapter
     */
    Book(Constant.BOOK), Chapter(Constant.CHAPTER);

    TaskType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
