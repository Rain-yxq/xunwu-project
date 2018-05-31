package cn.rain.web.controller;

import cn.rain.base.ApiResponse;
import cn.rain.service.house.IQiNiuService;
import cn.rain.web.dto.QiNiuPutSet;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/5/31 10:56
 */
@Controller
public class AdminController {

    @Autowired
    private IQiNiuService qiNiuService;
    @Autowired
    private Gson gson;

    @GetMapping("/admin/center")
    public String adminCenterPage(){
        return "admin/center";
    }

    @GetMapping("/admin/welcome")
    public String welcomePage(){
        return "admin/welcome";
    }

    @GetMapping("/admin/login")
    public String adminLoginPage(){
        return "admin/login";
    }

    @GetMapping("admin/add/house")
    public String addHousePage(){
        return "admin/house-add";
    }

    /**
     * 图片上传接口，可以通过file或InputStream两种形式完成上传。但是实际用InputStream较多，
     * 因为通过File的方式还要在服务器转存，造成服务器的磁盘空间的耗费。
     * @param file 上传的图片
     * @return 操作结果
     */
    @PostMapping(value = "admin/upload/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ApiResponse uploadPhoto(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }

        // 通过文件的形式上传至七牛云
//        String fileName = file.getOriginalFilename();
//        File target = new File("E:/IDEA-Protects/xunwu-project/tmp/" + fileName);
//        try {
//            file.transferTo(target);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
//        }
//        return ApiResponse.ofSuccess(null);

        // 通过InputStream形式上传至七牛云
        try {
            InputStream inputStream = file.getInputStream();
            Response response = qiNiuService.uploadFile(inputStream);
            if (response.isOK()){
                QiNiuPutSet set = gson.fromJson(response.bodyString(), QiNiuPutSet.class);
                return ApiResponse.ofSuccess(set);
            }
            else {
                return ApiResponse.ofMessage(response.statusCode, response.getInfo());
            }
        }catch (QiniuException e){
            Response response = e.response;
            try {
                return ApiResponse.ofMessage(response.statusCode, response.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
                return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
