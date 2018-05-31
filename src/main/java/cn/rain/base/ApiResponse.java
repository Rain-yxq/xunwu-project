package cn.rain.base;

/**
 * description: API返回格式封装
 * @author 任伟
 * @date 2018/5/30 16:03
 */
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
    /** 是否还有其他描述 */
    private boolean more;

    /**
     * 创建常用构造器
     */
    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 当仅仅只需传递成功状态时，可使用该空参构造器
     */
    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    /**
     * 定义常用的静态方法，避免每次使用都要new对象。
     * 下面第一个静态方法仅用于传递状态，无数据的情况
     */
    public static ApiResponse ofMessage(int code, String message){
        return new ApiResponse(code, message, null);
    }

    /**
     * 定义成功时且需要传递数据的静态方法
     * @param data 请求的结果数据
     * @return code：200；message：OK；data：请求的结果
     */
    public static ApiResponse ofSuccess(Object data){
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    /**
     * 定义自定义Status的返回结果集，需要创建Status（创建的时候自定义code和message）然后调用该方法传入，
     * 同时还可以传递结果数据，如果没有可以传入null，也可以调用下面的重载方法。
     * @param status 结果状态
     * @param data 结果数据，没有可以传null
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status, Object data){
        return new ApiResponse(status.getCode(), status.getStandardMessage(), data);
    }

    /**
     * 上面方法的重载
     */
    public static ApiResponse ofStatus(Status status){
        return new ApiResponse(status.getCode(), status.getStandardMessage(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    /**
     * 自定义常用的状态，使用内部枚举类
     */
    public enum Status {
        /** 枚举字段 */
        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
        NOT_VALID_PARAM(40005, "Not valid Params"),
        NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
        NOT_LOGIN(50000, "Not Login"),;

        private int code;
        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }
}
