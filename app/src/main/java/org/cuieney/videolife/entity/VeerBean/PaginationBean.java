package org.cuieney.videolife.entity.VeerBean;

/**
 * Created by cuieney on 2017/6/6.
 */

public class PaginationBean {

    /**
     * current_page : 1
     * total_pages : 228
     * total_count : 2728
     * size : 12
     */

    private int current_page;
    private int total_pages;
    private int total_count;
    private int size;

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
