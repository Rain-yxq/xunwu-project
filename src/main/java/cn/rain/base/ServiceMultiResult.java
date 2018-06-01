package cn.rain.base;

import java.util.List;

/**
 * description: 定义通用多结果Service返回结构
 *
 * @author 任伟
 * @date 2018/6/1 9:50
 */
public class ServiceMultiResult<T> {
    /** 数据库总共的数据记录数 */
    private long total;
    /** list结果集 */
    private List<T> result;

    /**
     * 定义返回当前list结果集中记录数的方法
     * @return 结果的数量
     */
    public int getResultSize(){
        if (this.result == null){
            return 0;
        }
        return this.result.size();
    }

    public ServiceMultiResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
