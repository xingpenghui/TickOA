package com.feri.common.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.feri.domain.Staff;
import com.feri.domain.Student;

public class ExcelUtils {

	//解析员工
	public static List<Staff> parseExcel(InputStream is) {
		List<Staff> list = new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// 创建单元
		HSSFWorkbook wb;
		try {
			wb = new HSSFWorkbook(is);
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
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}
	
	//解析学员
	public static List<Student> parseExcelS(InputStream is) {
		List<Student> list = new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// 创建单元
		HSSFWorkbook wb;
		try {
			wb = new HSSFWorkbook(is);
			HSSFSheet sheet = wb.getSheetAt(0);
			int l = sheet.getLastRowNum();
			for (int i = 1; i <= l; i++) {
				HSSFRow hr = sheet.getRow(i);
				Student student=new Student();
				student.setNo(hr.getCell(0).getStringCellValue());
				student.setName(hr.getCell(1).getStringCellValue());
				student.setGid((int)hr.getCell(2).getNumericCellValue());
				student.setSex(hr.getCell(3).getStringCellValue());
				student.setPhone(new Double(hr.getCell(4).getNumericCellValue()).intValue()+"");
				student.setQq(new Double(hr.getCell(5).getNumericCellValue()).intValue()+"");
				student.setEmail(hr.getCell(6).getStringCellValue());
				student.setCardno(hr.getCell(7).getStringCellValue());
				student.setSchool(hr.getCell(8).getStringCellValue());
				student.setEducation(hr.getCell(9).getStringCellValue());
				student.setIntrono(hr.getCell(10).getStringCellValue());
				student.setBirthday(sdf.parse(hr.getCell(11).getStringCellValue()));
				student.setCreatedate(sdf.parse(hr.getCell(12).getStringCellValue()));
				list.add(student);
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}
	
}
