package com.feri.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.feri.common.util.FileUtils;
import com.feri.common.vo.ResultVo;

//项目的文件上传 主要用来图片上传
@Controller
public class PhotoController {

	//实现文件上传
	@RequestMapping(value="photoupload.do",method= {RequestMethod.POST})
	@ResponseBody
	public ResultVo upload(@RequestParam("file")MultipartFile mFile,HttpServletRequest request) {
		File dir=FileUtils.createDir(request.getServletContext().getRealPath("/"), "photos");
		File file=new File(dir,FileUtils.createFileName(mFile.getOriginalFilename()));
		try {
			mFile.transferTo(file);
			
			return ResultVo.setOK(dir.getName()+File.separator+file.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultVo.setERROR("ERROR");
		}
		
		
	}
	
}
