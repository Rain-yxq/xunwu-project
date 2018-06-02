package cn.rain.base;

/**
 * description: 房屋操作状态常亮定义
 *
 * @author 任伟
 * @date 2018/6/2 23:21
 */
public class HouseOperation {
    /** 审核通过 */
    public static final int PASS = 1;
    /** 下架，重新审核*/
    public static final int PULL_OUT = 2;
    /** 逻辑删除 */
    public static final int DELETE = 3;
    /** 已出租 */
    public static final int RENT = 4;
}
