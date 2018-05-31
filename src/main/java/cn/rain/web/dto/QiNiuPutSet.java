package cn.rain.web.dto;

/**
 * description: 定义七牛云的结果集映射对象，这里定义为final class为了不让其他类继承此类进行覆写。
 * @author 任伟
 * @date 2018/5/31 16:55
 */
public final class QiNiuPutSet {
    public String key;
    public String hash;
    public String bucket;
    public int width;
    public int height;

    @Override
    public String toString() {
        return "QiNiuPutSet{" +
                "key='" + key + '\'' +
                ", hash='" + hash + '\'' +
                ", bucket='" + bucket + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
