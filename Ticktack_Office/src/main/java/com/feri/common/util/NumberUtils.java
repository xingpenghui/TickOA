package com.feri.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class NumberUtils {

	//保留N位小数
		public static double tranPointNum(int length,double num) {
			BigDecimal bd=new BigDecimal(num);
			bd=bd.setScale(length, RoundingMode.HALF_UP);
			
			
			return bd.doubleValue();
		}
		public static double tranPointNum2(int length,double num) {
			return Double.parseDouble(String.format("%."+length+"f", num));
		}
		public static double tranPointNum3(double num) {
			DecimalFormat df=new DecimalFormat("0.00");
			return Double.parseDouble(df.format(num));

		}
}
