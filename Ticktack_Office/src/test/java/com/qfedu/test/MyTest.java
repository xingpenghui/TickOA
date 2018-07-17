package com.qfedu.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import com.feri.common.util.MD5Utils;
import com.feri.domain.Staff;

public class MyTest {

	@Test
	public void test1() {
		System.out.println("admin--->"+MD5Utils.md5("admin"));
		System.out.println("123456--->"+MD5Utils.md5("123456"));
	}
	@Test
	public void test2() {

		// TODO Auto-generated method stub
		List<Staff> list = new ArrayList<>();
		// 创建单元
		HSSFWorkbook wb;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			wb = new HSSFWorkbook(new FileInputStream("stafftem.xls"));
			HSSFSheet sheet = wb.getSheetAt(0);
			int l = sheet.getLastRowNum();
			for (int i = 1; i <= l; i++) {
				HSSFRow hr = sheet.getRow(i);
				Staff staff=new Staff();
				staff.setNo(hr.getCell(0).getStringCellValue());
				staff.setName(hr.getCell(1).getStringCellValue());
				staff.setDid((int)hr.getCell(2).getNumericCellValue());
				staff.setSex(hr.getCell(3).getStringCellValue());
				staff.setPhone(new Double(hr.getCell(4).getNumericCellValue()).intValue()+"");
				staff.setEmail(hr.getCell(5).getStringCellValue());
				staff.setQq(new Double(hr.getCell(6).getNumericCellValue()).intValue()+"");
				staff.setCreatedate(sdf.parse(hr.getCell(7).getStringCellValue()));
				list.add(staff);
				//获取数据类型
				/*System.out.println(hr.getCell(0).getCellTypeEnum().name());
				System.out.println(hr.getCell(1).getCellTypeEnum().name());
				System.out.println(hr.getCell(2).getCellTypeEnum().name());
				System.out.println(hr.getCell(3).getCellTypeEnum().name());
				System.out.println(hr.getCell(4).getCellTypeEnum().name());
				System.out.println(hr.getCell(5).getCellTypeEnum().name());
				System.out.println(hr.getCell(6).getCellTypeEnum().name());*/
				
				/*staff.setNo(hr.getCell(0).getStringCellValue());
				staff.setName(hr.getCell(1).getStringCellValue());
				staff.setDid((int)hr.getCell(2).getNumericCellValue());
				staff.setSex(hr.getCell(3).getStringCellValue());
				staff.setPhone(hr.getCell(4).getStringCellValue());
				staff.setEmail(hr.getCell(5).getStringCellValue());
				staff.setQq(hr.getCell(5).getStringCellValue());
				staff.setCreatedate(hr.getCell(6).getDateCellValue());*/
				list.add(staff);
			}
			System.out.println(list);
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
