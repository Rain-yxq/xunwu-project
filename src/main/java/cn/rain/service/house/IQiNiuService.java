package cn.rain.service.house;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 * description:七牛云服务
 *
 * @author 任伟
 * @date 2018/5/31 15:15
 */
public interface IQiNiuService {

    // 上传七牛云可以通过文件直接上传或者文件流上传，这里都进行演示

    /**
     * 通过文件上传七牛云
     * @param file 要上传的文件
     * @return 七牛云定义的操作结果对象
     * @throws QiniuException 异常
     */
    Response uploadFile(File file) throws QiniuException;

    /**
     * 使用文件流上传七牛云
     * @param inputStream 要上传的文件流
     * @return 七牛云定义的操作结果对象
     * @throws QiniuException 异常
     */
    Response uploadFile(InputStream inputStream) throws QiniuException;

    /**
     * 通过key删除七牛云中的文件
     * @param key bucket中对象的唯一标识
     * @return 七牛云定义的操作结果对象
     * @throws QiniuException 异常
     */
    Response delete(String key) throws QiniuException;
}
