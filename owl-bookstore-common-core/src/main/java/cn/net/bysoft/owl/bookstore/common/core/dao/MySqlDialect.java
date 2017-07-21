package cn.net.bysoft.owl.bookstore.common.core.dao;

public class MySqlDialect implements Dialect {

    @Override
    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
        StringBuilder stringBuilder = new StringBuilder(sql);

        stringBuilder.append(" limit ");
        if (offset > 0) {
            stringBuilder.append(offsetPlaceholder);
            stringBuilder.append(",");
        }
        stringBuilder.append(limitPlaceholder);
        return stringBuilder.toString();
    }
}
