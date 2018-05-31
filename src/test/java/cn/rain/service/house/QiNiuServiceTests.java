package cn.rain.service.house;

import cn.rain.ApplicationTests;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/5/31 16:36
 */
public class QiNiuServiceTests extends ApplicationTests {

    @Autowired
    private IQiNiuService qiNiuService;

    /**
     * 测试通过file的方式上传图片至七牛云
     */
    @Test
    public void testUploadFile(){
        String fileName = "E:\\IDEA-Protects\\xunwu-project\\tmp\\1525240472327.png";
        File file = new File(fileName);
        Assert.assertTrue(file.exists());

        try {
            Response response = qiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试通过key删除七牛云中的图片
     */
    @Test
    public void testDelete(){
        String key = "FndnqHehaz9MqTPkUY062QK0Vfm2";
        try {
            Response response = qiNiuService.delete(key);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}
