package cn.net.bysoft.owl.bookstore.common.entity;

public class OwlBookstoreResponse {
	
    private final String status;
    private final String msg;
    private final Object data;

    public OwlBookstoreResponse(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

}
