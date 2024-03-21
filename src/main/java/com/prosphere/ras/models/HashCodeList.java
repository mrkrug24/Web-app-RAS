package com.prosphere.ras.models;

import java.util.List;
import java.util.Objects;

public class HashCodeList<T> {
    private List<T> list;

    public HashCodeList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HashCodeList<?> other = (HashCodeList<?>) obj;
        return Objects.equals(list, other.list);
    }

    @Override
    public String toString() {
        return "HashCodeList [list=" + list + "]";
    }
}