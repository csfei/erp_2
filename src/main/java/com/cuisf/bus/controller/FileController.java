package com.cuisf.bus.controller;

import cn.hutool.core.date.DateUtil;
import com.cuisf.sys.common.AppFileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuisf on 2020-05-29.
 */
@RestController
@RequestMapping("file")
public class FileController {

    /**
     * 文件上传
     * @return
     */
    @RequestMapping("uploadFile")
    public Map<String,Object> uploadFile(MultipartFile mf){
        Map<String,Object> map=new HashMap<String, Object>();
        //1.得到文件名
        String oldName  = mf.getOriginalFilename();
        //根据文件名生产新的文件名
        String newName= AppFileUtils.createNewFileName(oldName);
        //3.得到当前日期的字符串
        String dirName= DateUtil.format(new Date(), "yyyy-MM-dd");
        //4构造文件夹
        File dirFile=new File(AppFileUtils.UPLOAD_PATH,dirName);
        //5判断当前文件夹是否存在
        if(!dirFile.exists()) {
            dirFile.mkdirs();//创建文件夹
        }
        //构造文件对象
        File file=new File(dirFile, newName+"_temp");
        //吧mf里面的图片信息写入file
        try {
            mf.transferTo(file);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        map.put("path", dirName+"/"+newName+"_temp");
        return map;
    }


    /**
     * 图片下载
     */
    @RequestMapping("showImageByPath")
    public ResponseEntity<Object> showImageByPath(String path){
        return AppFileUtils.createResponseEntity(path);
    }
}
