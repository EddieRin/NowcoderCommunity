package com.nowcoder.community.entity;

public class Page {
    private Integer current = 1;
    private Integer limit = 10;
    private Integer rows;
    private String path;

    public Page() {
    }

    public Page(Integer current, Integer limit, Integer rows, String path) {
        this.current = current;
        this.limit = limit;
        this.rows = rows;
        this.path = path;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if(current >= 1) {
            this.current = current;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if(limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        if(rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Page{" +
                "current=" + current +
                ", limit=" + limit +
                ", rows=" + rows +
                ", path='" + path + '\'' +
                '}';
    }

    public int getOffset() {
        return (current - 1) * limit;
    }

    public int getTotal() {
        if(rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    public int getFrom() {
        int from = current - 2;
        return Math.max(from, 1);
    }

    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }
}
