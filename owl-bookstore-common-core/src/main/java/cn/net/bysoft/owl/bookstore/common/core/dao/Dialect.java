package cn.net.bysoft.owl.bookstore.common.core.dao;

public interface Dialect {

    default boolean supportsLimit() {
        return false;
    }

    default boolean supportsLimitOffset() {
        return supportsLimit();
    }

    default String getLimitString(String sql, int offset, int limit) {
        return getLimitString(sql, offset, Integer.toString(offset), limit, Integer.toString(limit));
    }

    String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder);
    
}
