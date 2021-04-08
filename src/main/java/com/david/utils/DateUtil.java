package com.david.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {
    //集中常用的日期格式
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String MM_DD = "MM-dd";
	public static final String MM_DD_HH_MM = "MM-dd HH:mm";
	public static final String MM_DD_HH_MM_SS = "MM-dd HH:mm:ss";
	public static final String HH_MM = "HH:mm";
	public static final String HH_MM_SS = "HH:mm:ss";
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

	/**
	 * 按yyyy-MM-dd样式获取当前日期
	 * 
	 * @return
	 */
	public static String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	/**
	 * 按yyyy-MM-dd HH:mm:ss样式获取当前时间
	 * 
	 * @return
	 */
	public static String getTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 根据样式获取当前日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getDate(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	/**
	 * 
	 * 方法描述
	 * 
	 * @param strDate
	 *            时间的字符串
	 * @param pattern
	 *            时间格式
	 * @param days
	 *            天数
	 * @return 指定天数加上指定天数的时间的字符串格式
	 */
	public static String AddDay(String strDate, String pattern, int days) {
		if (strDate == null || "".equals(strDate) || pattern == null || "".equals(pattern) || strDate.length() < pattern.length()) {
			return null;
		}
		String resultDate = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			Date date = dateFormat.parse(strDate.substring(0, pattern.length()));
			Calendar cale = Calendar.getInstance();
			cale.setTime(date);
			// 指定时间内加上指定天数
			cale.add(Calendar.DAY_OF_MONTH, days);
			date = cale.getTime();
			// 结果时间的字符串格式
			resultDate = dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultDate;
	}

	/**
	 * 得到系统当前日期时间
	 * 
	 * @return 当前日期时间
	 */
	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 页面日期字符串的处理 参数为 long的时间转化为 string 方法描述
	 * 
	 * @param str
	 *            要格式化的字符串
	 * @return 格式为：yyyy-MM-dd HH:mm:ss的String
	 */
	public static String getCheckDate(String str) {
		if (str == null || "".equals(str) || "-1".equals(str) || Long.parseLong(str) < 0) {
			return "&nbsp;";
		}

		SimpleDateFormat t_myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		date.setTime(Long.parseLong(str));
		String returnStr = t_myFmt.format(date);
		return returnStr;
	}

	/**
	 * 日期，时间格式转换
	 * 
	 * @param datestr
	 *            待转换的字符串
	 * @param pattern
	 *            待转换的字符串的时间格式
	 * @param targetpattern
	 *            要转换的时间格式
	 * @return
	 */
	public static String convertFormat(String datestr, String pattern, String targetpattern) {

		String t_date = "";
		Date t_ddate = null;
		SimpleDateFormat t_dateFormat = new SimpleDateFormat(pattern);
		try {
			t_ddate = t_dateFormat.parse(datestr);
			t_dateFormat = new SimpleDateFormat(targetpattern);
			t_date = t_dateFormat.format(t_ddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t_date;
	}

	/**
	 * 以某种格式获取当前的日期数据
	 * 
	 * @param pattern －
	 *            日期格式，如果没有缺省日期格式："yyyy-MM-dd"
	 * @return 当前的日期
	 */
	public static String getCurrentDate(String pattern) {

		String t_rtn = null;

		if (null == pattern || "".equals(pattern)) {
			pattern = "yyyy-MM-dd";
		}

		// 转换日期
		SimpleDateFormat t_dateFormat = new SimpleDateFormat(pattern);
		t_rtn = t_dateFormat.format(getNow());

		return t_rtn;

	}

	/**
	 * 得到当前年份
	 * 
	 * @return 当前年份
	 */
	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * 得到当前月份
	 * 
	 * @return 当前月份
	 */
	public static int getCurrentMonth() {
		// 用get得到的月份数比实际的小1，需要加上
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	/**
	 * 得到当前月份
	 * 
	 * @return 传入时间月份
	 */
	public static int getCurrentMonth(Date date) {
		// 用get得到的月份数比实际的小1，需要加上
		return date.getMonth()+ 1;
	}
	/**
	 * 得到当前日
	 * 
	 * @return 当前日
	 */
	public static int getCurrentDay() {
		return Calendar.getInstance().get(Calendar.DATE);
	}

	/**
	 * 得到当前日的开始时间
	 * 
	 * @return Date
	 */
	public static Date getCurrentDayStart() {
		Date todayDate = new Date();
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(todayDate);

		calendar.set(Calendar.AM_PM, Calendar.HOUR);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(0, Calendar.DATE);
		Date todayDateStart = calendar.getTime();
		return todayDateStart;
	}
	
	/**
	 * 根据时间戳获得时间
     * @return 时间
     */
    public static Date getDateByTimeMillis(long timeMillis) {
        return new Date(timeMillis);
    }
    /**
     * 根据时间戳获得时间
     * @return 时间
     */
    public static Date getDateByTimeMillis(String timeMillisStr) {
        Date rtn = null;
        try {
            long timeMillis = Long.parseLong(timeMillisStr);
            rtn = new Date(timeMillis);
        } catch (NumberFormatException e) {
            return null;
        }
        return rtn;
    }

	/**
	 * 取得当前日期以后若干天的日期。如果要得到以前的日期，参数用负数。 例如要得到上星期同一天的日期，参数则为-7
	 * 
	 * @param days
	 *            增加的日期数
	 * @return 增加以后的日期
	 */
	public static Date addDays(int days) {
		return add(getNow(), days, Calendar.DATE);
	}
	/**
	 * 取得当前日期以后若干天的日期。如果要得到以前的日期，参数用负数。 例如要得到上星期同一天的日期，参数则为-7
	 * 
	 * @param days
	 *            增加的日期数
	 * @return 增加以后的日期
	 */
	public static Date addYears(Date input,int years) {
		return add(input, years, Calendar.YEAR);
	}
	/**
	 * 取得指定日期以后若干天的日期。如果要得到以前的日期，参数用负数。
	 * 
	 * @param date
	 *            基准日期
	 * @param days
	 *            增加的日期数
	 * @return 增加以后的日期
	 */
	public static Date addDays(Date date, int days) {
		return add(date, days, Calendar.DATE);
	}

	/**
	 * 取得当前日期以后某月的日期。如果要得到以前月份的日期，参数用负数。
	 * 
	 * @param months
	 *            增加的月份数
	 * @return 增加以后的日期
	 */
	public static Date addMonths(int months) {
		return add(getNow(), months, Calendar.MONTH);
	}

	/**
	 * 取得指定日期以后某月的日期。如果要得到以前月份的日期，参数用负数.
	 * <p>
	 * 注意，可能不是同一日子，例如2003-1-31加上一个月是2003-2-28
	 * 
	 * @param date -
	 *            基准日期.
	 * @param months -
	 *            增加的月份数.
	 * @return 增加以后的日期.
	 */
	public static Date addMonths(Date date, int months) {
		return add(date, months, Calendar.MONTH);
	}

	/**
	 * 为指定日期增加相应的天数或月数.
	 * 
	 * @param date -
	 *            基准日期.
	 * @param amount -
	 *            增加的数量.
	 * @param field -
	 *            增加的单位，年，月，日，分钟，小时,Calendar类的常量值.
	 * @return 增加以后的日期.
	 */
	public static Date add(Date date, int amount, int field) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(field, amount);

		return calendar.getTime();
	}

	/**
	 * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数.
	 * 
	 * @param one -
	 *            第一个日期数，作为基准.
	 * @param two -
	 *            第二个日期数，作为比较.
	 * @return 两个日期相差天数.
	 */
	public static long diffDays(Date one, Date two) {
		return (one.getTime() - two.getTime()) / (24 * 60 * 60 * 1000);
	}

	/**
	 * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数.
	 * 
	 * @param one -
	 *            第一个日期数，作为基准.
	 * @param two -
	 *            第二个日期数，作为比较.
	 * @return 两个日期相差天数.
	 */
	public static long getDiffDays(Date one, Date two) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(one);
		c2.setTime(two);
		int sumdays = 0;// 两个日期间隔的天数
		int start = c1.get(Calendar.YEAR) >= c2.get(Calendar.YEAR) ? c2.get(Calendar.YEAR) : c1.get(Calendar.YEAR);
		int end = c2.get(Calendar.YEAR) >= c1.get(Calendar.YEAR) ? c2.get(Calendar.YEAR) : c1.get(Calendar.YEAR);
		int flag = c1.get(Calendar.YEAR) >= c2.get(Calendar.YEAR) ? 1 : -1;
		for (int i = start; i < end; i++) {
			Calendar temp = Calendar.getInstance();
			temp.set(i, 11, 31);// 设置为当前年最后一天
			sumdays += temp.get(Calendar.DAY_OF_YEAR);
		}
		if (flag == 1) {
			sumdays += c1.get(Calendar.DAY_OF_YEAR);
			sumdays -= c2.get(Calendar.DAY_OF_YEAR);
		} else {
			sumdays -= c1.get(Calendar.DAY_OF_YEAR);
			sumdays += c2.get(Calendar.DAY_OF_YEAR);
		}
		return sumdays * flag;
	}

	/**
	 * 计算两个日期相差月份数 如果前一个日期小于后一个日期，则返回负数.
	 * 
	 * @param one -
	 *            第一个日期数，作为基准
	 * @param two -
	 *            第二个日期数，作为比较
	 * @return 两个日期相差月份数.
	 */
	public static int diffMonths(Date one, Date two) {

		Calendar calendar = Calendar.getInstance();

		// 得到第一个日期的年分和月份数
		calendar.setTime(one);
		int yearOne = calendar.get(Calendar.YEAR);
		int monthOne = calendar.get(Calendar.MONDAY);

		// 得到第二个日期的年份和月份
		calendar.setTime(two);
		int yearTwo = calendar.get(Calendar.YEAR);
		int monthTwo = calendar.get(Calendar.MONDAY);

		return (yearOne - yearTwo) * 12 + (monthOne - monthTwo);
	}
	
	/**
	 * 计算两个日期相差年数 .
	 * 
	 * @param begin -
	 *            第一个日期数
	 * @param end -
	 *            第二个日期数
	 * @return 两个日期相差年数.
	 */
	public static int diffYear(String begin, String end){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate;
		Date endDate;
		int beginYear=0;
		int endYear=0;
		try {
			beginDate = df.parse(begin);
			endDate = df.parse(end);
			beginYear = beginDate.getYear();
			endYear = endDate.getYear();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		return endYear-beginYear; 

	}

	/**
	 * 计算两个日期之间相差多少分钟
	 * 
	 * @param one -
	 *            第一个日期数，作为基准
	 * @param two -
	 *            第二个日期数，作为比较
	 * @return 两个日期相差分钟数.
	 */
	public static long diffMinute(Date one, Date two) {
		return (one.getTime() - two.getTime()) / (60 * 1000);
	}

	/**
	 * 计算两个时间之间相差多少分钟
	 * 
	 * @param one -
	 *            第一个日期数，作为基准
	 * @param two -
	 *            第二个日期数，作为比较
	 * @return 两个时间相差分钟数.
	 */
	public static long diffMinute(String one, String two) {
		return diffMinute(parse("2013-01-01 " + one), parse("2013-01-01 " + two));
	}

	/**
	 * 计算两个日期之间相差多少毫秒
	 * 
	 * @param one -
	 *            第一个日期数，作为基准
	 * @param two -
	 *            第二个日期数，作为比较
	 * @return 两个日期相差毫秒数.
	 */
	public static long diffMilliSecend(Date one, Date two) {
		return (one.getTime() - two.getTime());
	}

	/**
	 * 将一个字符串用给定的格式转换为日期类型. <br>
	 * 注意：如果返回null，则表示解析失败.
	 * 
	 * @param datestr -
	 *            需要解析的日期字符串.
	 * @param pattern -
	 *            日期字符串的格式，默认为“yyyy-MM-dd”的形式.
	 * @return 解析后的日期
	 */
	public static Date parse(String datestr, String pattern) {
		Date date = null;
		if (null != pattern && !"".equals(pattern)) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
				date = dateFormat.parse(datestr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return date;
	}

	/**
	 * 按照默认的格式将字符串的时间转换成日期.
	 * 
	 * @param datestr -
	 *            日期字符串.
	 * @return Date
	 */
	public static Date parse(String datestr) {

		try {
			if (null != datestr && datestr.length() > 0) {
				if (datestr.length() == 19) {
					return DateUtil.parse(datestr, "yyyy-MM-dd HH:mm:ss");
				} else if (datestr.length() == 16) {
					return DateUtil.parse(datestr, "yyyy-MM-dd HH:mm");// 分钟
				} else if (datestr.length() == 13) {
					return DateUtil.parse(datestr, "yyyy-MM-dd HH");// 小时
				} else if (datestr.length() == 12) {// 分钟
					return DateUtil.parse(datestr, "yyyyMMddHHmm");
				} else if (datestr.length() == 10) {
					if (datestr.indexOf("-") > 0) {
						return DateUtil.parse(datestr, "yyyy-MM-dd");// 天
					} else {
						return DateUtil.parse(datestr, "yyyyMMddHH");// 小时
					}
				} else if (datestr.length() == 8) {// 天
					return DateUtil.parse(datestr, "yyyyMMdd");
				} else if (datestr.length() == 7) {
					return DateUtil.parse(datestr, "yyyy-MM");// 月
				} else if (datestr.length() == 6) {// 月
					return DateUtil.parse(datestr, "yyyyMM");
				} else if (datestr.length() == 4) {// 年
					return DateUtil.parse(datestr, "yyyy");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 返回本月的最后一天.
	 * 
	 * @return 本月最后一天的日期.
	 */
	public static Date getMonthLastDay() {
		return getMonthLastDay(getNow());
	}

	/**
	 * 返回给定日期中的月份中的最后一天.
	 * 
	 * @param date -
	 *            基准日期.
	 * @return 该月最后一天的日期.
	 */
	public static Date getMonthLastDay(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// 将日期设置为下一月第一天
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);

		// 减去1天，得到的即本月的最后一天
		calendar.add(Calendar.DATE, -1);

		return calendar.getTime();
	}

	/**
	 * 返回给定日期中的月份中的第一天.
	 * 
	 * @param date -
	 *            基准日期.
	 * @return 该月最第一天的日期.
	 */
	public static Date getMonthFirstDay(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// 将日期设置为该月第一天
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);

		return calendar.getTime();
	}

	/**
	 * 去当前时间给要返回的时间类型得到年、月、日、小时方法的详细描述.
	 * 
	 * @param timeType -
	 *            时间类型如：Calendar.YEAR.
	 * @return
	 */
	public static int dateNum(int timeType) {
		return dateNum(null, timeType);
	}

	/**
	 * 给一个时间和要返回的时间类型得到年、月、日、小时方法的详细描述.
	 * 
	 * @param date -
	 *            时间
	 * @param timeType -
	 *            时间类型如：Calendar.YEAR.
	 * @return
	 */
	public static int dateNum(Date date, int field) {
		int t_temp = 100;
		Calendar calendar = Calendar.getInstance();

		if (null != date) {
			calendar.setTime(date);
			t_temp = calendar.get(field);
		}

		return t_temp;
	}

	/**
	 * 获得当前时间前24小时的时间.
	 * 
	 * @param format -
	 *            指定返回的时间格式.
	 * @return 时间
	 */
	public static String getRecently24InHour(String format) {
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(add(now, -24, Calendar.HOUR));
	}

	/**
	 * 格式化字符串.
	 * 
	 * @param date -
	 *            要格式的日期对象.
	 * @param style -
	 *            格式返回的格式（类似yyyy-MM-dd HH:mm:ss）.
	 * @return 字符串.
	 */
	public static String format(Date date, String style) {
		if(date==null){return "";};
		DateFormat t_dateFormat = new SimpleDateFormat(style);
		return t_dateFormat.format(date);
	}
	/**
	 * 格式化字符串.
	 * 
	 * @param dateStr -
	 *            要格式的日期字符串.
	 * @param style -
	 *            格式返回的格式（类似yyyy-MM-dd HH:mm:ss）.
	 * @return 字符串.
	 */
	public static String format(String dateStr,String style){
		DateFormat t_dateFormat = new SimpleDateFormat(style);
		return t_dateFormat.format(parse(dateStr));
		
	}

	/**
	 * 获得当前日期在本年内所在的周数
	 * 
	 * @return 周数
	 */
	public static String getNowWeekNo() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatter.applyPattern("w");
		return dateFormatter.format(new Date());
	}

	/**
	 * 将毫秒转换成分钟
	 * 
	 * @return 分钟
	 */
	public static long transforMillisecondToMinute(long millisecond) {
		return millisecond / 1000 / 60;
	}

	/**
	 * 获得指定天数的毫秒数
	 * 
	 * @param days -
	 *            指定天数
	 * @return 毫秒数
	 */
	public static long getDaysMillisecond(long days) {
		return days * 24 * 60 * 1000;
	}

	/**
	 * 得到当前星期几
	 * 
	 * @return 当前星期几
	 */
	public static int getCurrentDayOfWeek() {
		return Calendar.getInstance().get(Calendar.WEDNESDAY);
	}
	
	/**
	 * 根据时间字符串判断是星期几
	 * @param day 日期字符串(yyyy-MM-dd)
	 * @return 星期几
	 */
     public static int getDayOfWeek(String day){
         SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd",Locale.CHINA);
         int week = 0;
         try {
            Date date = dateFormatter.parse(day);
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            calendar.setTime(date);
            week = calendar.get(Calendar.DAY_OF_WEEK)-1;
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return week;
     }
     
     /**
      * @Description 取得当前时间所在星期的任意一天的日期（例如当前日期是2016.9.18，type是1，返回的时候这天所在星期一的日期）
      * @author jms
      * @param type 代表周几
      * @return
      */
     public static Date getDayOfWeekSection(String type){
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	 Date date=null;
    	 Calendar calendar=Calendar.getInstance(Locale.CHINA);
    	 //其余的行不变只加入这一行即可，设定每周的起始日。
    	 calendar.setFirstDayOfWeek(Calendar.MONDAY); //以周1为首日
    	 if(type.equals("1")){
    		 calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    		 date= calendar.getTime();
    	 } else if(type.equals("2")){
    		 calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
    		 date= calendar.getTime();
    	 } else if(type.equals("3")){
    		 calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
    		 date= calendar.getTime();
    	 } else if(type.equals("4")){
    		 calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
    		 date= calendar.getTime();
    	 } else if(type.equals("5")){
    		 calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    		 date= calendar.getTime();
    	 } else if(type.equals("6")){
    		 calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
    		 date= calendar.getTime();
    	 }else{
    		 calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    		 date= calendar.getTime();
    	 }

    	 return date;
     }
     
	/**
	 * 格式化字符串.
	 * 
	 * @param l -
	 *            要格式的日期long对象.
	 * @param style -
	 *            格式返回的格式（类似yyyy-MM-dd HH:mm:ss）.
	 * @return
	 */
	public static String format(long l, String style) {
		Date date = new Date(l);
		DateFormat t_dateFormat = new SimpleDateFormat(style);
		return t_dateFormat.format(date);
	}

	/**
	 * 判断时间是否在指定的时间段内
	 * 
	 * @param startTime -
	 *            开始时间(HH:mm:ss)
	 * @param endTime -
	 *            结束时间(HH:mm:ss)
	 * @param searchTime -
	 *            查询时间(HH:mm:ss)
	 * @return boolean
	 */
	public static boolean betweenTime(String startTime, String endTime, String searchTime) {
		// 获取时间
		String sstartTime = startTime.substring(0, 2) + startTime.substring(3, 5) + startTime.substring(6, 8);
		String sendTime = endTime.substring(0, 2) + endTime.substring(3, 5) + endTime.substring(6, 8);
		String ssearchTime = searchTime.substring(0, 2) + searchTime.substring(3, 5) + searchTime.substring(6, 8);
		// 将系统时间转换为Int型
		int startTime_i = Integer.parseInt(sstartTime);
		int endTime_i = Integer.parseInt(sendTime);
		int searchTime_i = Integer.parseInt(ssearchTime);

		if (startTime_i <= searchTime_i && searchTime_i <= endTime_i) {
			return true;
		}

		return false;

	}

	/**
	 * 是小于被比较的时间
	 * 
	 * @param searchTime -
	 *            查询时间(HH:mm:ss)
	 * @param contrastTime -
	 *            被比较的时间(HH:mm:ss)
	 * @return
	 */
	public static boolean beforeTime(String searchTime, String contrastTime) {
		// 获取时间
		String searchTime_s = searchTime.substring(0, 2) + searchTime.substring(3, 5) + searchTime.substring(6, 8);
		String contrastTime_s = contrastTime.substring(0, 2) + contrastTime.substring(3, 5) + contrastTime.substring(6, 8);
		// 将系统时间转换为Int型
		int searchTime_i = Integer.parseInt(searchTime_s);
		int contrastTime_i = Integer.parseInt(contrastTime_s);
		searchTime_s = null;
		contrastTime_s = null;
		if (searchTime_i < contrastTime_i) {
			return true;
		}
		return false;
	}

	/**
	 * 是大于被比较的时间
	 * 
	 * @param searchTime -
	 *            查询时间(HH:mm:ss)
	 * @param contrastTime -
	 *            被比较的时间(HH:mm:ss)
	 * @return
	 */
	public static boolean behindTime(String searchTime, String contrastTime) {
		// 获取时间
		String searchTime_s = searchTime.substring(0, 2) + searchTime.substring(3, 5) + searchTime.substring(6, 8);
		String contrastTime_s = contrastTime.substring(0, 2) + contrastTime.substring(3, 5) + contrastTime.substring(6, 8);
		// 将系统时间转换为Int型
		int searchTime_i = Integer.parseInt(searchTime_s);
		int contrastTime_i = Integer.parseInt(contrastTime_s);
		searchTime_s = null;
		contrastTime_s = null;
		if (searchTime_i > contrastTime_i) {
			return true;
		}
		return false;
	}

	/**
	 * 在指定的时间基础上增加分钟数
	 * 
	 * @param time -
	 *            时间(HH:mm:ss)
	 * @return
	 */
	public static String addMinute(String time, int minute) {
		int hh = Integer.parseInt(time.substring(0, 2));
		int mm = Integer.parseInt(time.substring(3, 5));
		int ss = Integer.parseInt(time.substring(6, 8));
		if ((mm + minute) >= 60) {
			hh++;
			if (hh >= 24) {
				hh = 0;
			}
			mm = mm + minute - 60;
		} else {
			mm = mm + minute;
		}
		String shh = String.valueOf(hh);
		String smm = String.valueOf(mm);
		String sss = String.valueOf(ss);
		if (shh.length() == 1) {
			shh = "0" + shh;
		}
		if (smm.length() == 1) {
			smm = "0" + smm;
		}
		if (sss.length() == 1) {
			sss = "0" + sss;
		}
		return shh + ":" + smm + ":" + sss;
	}
	
	/**
	 * 在指定的时间基础上增加 秒数 
	 *  负数为往前 计算
	 * 
	 * @param time -
	 *            时间(HH:mm:ss)
	 * @return
	 */
	public static Date addSeconds(Date time, int seconds) {
		Calendar c = new GregorianCalendar();
		c.setTime(time);//设置参数时间
		c.add(Calendar.SECOND, seconds);//把日期往后增加SECOND 秒.整数往后推,负数往前移动
		time=c.getTime(); //这个时间就是日期往后推一天的结果
		return time;
	}

	
	/**
	 * @author asus
	 * @description 根据时间和所要计算的分钟数进行分钟数的加减 yyyy-MM-dd HH:mm:ss
	 * @date 2013年3月7日15:47:42
	 * @param time
	 * @param minute
	 * @return
	 */
	public static String countMinutes(String time, int minute){
		Calendar cl= Calendar.getInstance();
		cl.setTime(parse(time));
		cl.add(Calendar.MINUTE, minute);
		Date date2 = cl.getTime();
		return format(date2, "HH:mm:ss");
		
	}
	
	/**
	 * 在指定的时间基础上减少分钟数
	 * 
	 * @param time -
	 *            时间(HH:mm:ss)
	 * @return
	 */
	public static String cutMinute(String time, int minute) {
		int hh = Integer.parseInt(time.substring(0, 2));
		int mm = Integer.parseInt(time.substring(3, 5));
		int ss = Integer.parseInt(time.substring(6, 8));
		if ((mm - minute) < 0) {
			hh--;
			if (hh < 0) {
				hh = 23;
			}
			mm = 60 - minute - mm;
		} else {
			mm = mm - minute;
		}
		String shh = String.valueOf(hh);
		String smm = String.valueOf(mm);
		String sss = String.valueOf(ss);
		if (shh.length() == 1) {
			shh = "0" + shh;
		}
		if (smm.length() == 1) {
			smm = "0" + smm;
		}
		if (sss.length() == 1) {
			sss = "0" + sss;
		}
		return shh + ":" + smm + ":" + sss;
	}
	/**
	 * 根据出身日期计算出实际年龄
	 * @see com.kangyouyl.yxk.mch.web.common.util.DateUtil#getAgeByBirthday(Date)
	 * @deprecated
	 */
	@Deprecated
	public static String getAgeByBirthDay(String birth){
		if(birth==null){
			return "";
		}
		Date d1=new Date();
		Date d2=DateUtil.parse(birth, "yyyy-MM-dd");
		long i=(d1.getTime() - d2.getTime())/(1000*60*60*24); 
		String age=""+i/365;
		return age;
	}
	/**
	 * 获取任意日期所在年份的周数
	 * @throws ParseException 
	 */
	public static int getWeekNo(String dayDate) throws ParseException {
		Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date datez = sdf.parse(dayDate);   // 把前台传递来的字符串类型的日期转换成日期格式  然后操作
        calendar.setTime(datez);//系统当前时间
        int weekNo = calendar.get(Calendar.WEEK_OF_YEAR);//本年的第几周
        return weekNo;
	}
	
	/**
	 * 精确根据生日计算年龄
	 */
	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthday)) {
			return 0;
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		}
		return age;
	}
	
	/**
	 * 精确根据生日计算年龄
	 */
	public static int getAgeByBirthday(String birthday) {
		Date birth = DateUtil.parse(birthday);
		return getAgeByBirthday(birth);
	}
	
	/**
	 * 判断时间格式的正确性
	 * @param str
	 * @param formatString  标准格式
	 * @return
	 */
	public static boolean isValidDate(String str,String formatString) {
	      boolean convertSuccess=true;
	       // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
	       SimpleDateFormat format = new SimpleDateFormat(formatString);
	       try {
           // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
	          format.setLenient(false);
	          format.parse(str);
	       } catch (ParseException e) {
	          // e.printStackTrace();
	    	  // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	           convertSuccess=false;
	       } 
	       return convertSuccess;
	}
	/**
	 * 获得时间与现在的时间的距离：
	 * 1. 半个小时内：分钟为单位
	 * 2. 半个小时以上用小时为单位
	 * 3. 天以上 用天为单位
	 * @return
	 */
	public static String getDistanceOfNow(Date createTime){
		String res = "";
		Date now = new Date();
		long n1 = now.getTime();
		long n2 = createTime.getTime();
		long t0 = 1000*60;
		long t1 = 1000 * 60 * 30;
		long t2 = 1000 * 60 * 60 * 24;
		long t = n1 - n2;
		if(t<t0){
			long f = t / 1000;
			res = f+"秒";
		}
		if(t>t0&&t < t1){
			long f = t / 1000 / 60;
			res = f+"分钟";
		}
		if(t > t1 && t < t2){
			long f = t / 1000 / 60 / 60;
			res = f+"小时";
		}
		if(t > t2){
			long f = t / 1000 / 60 / 60 / 24;
			res = f+"天";
		}
		return res;
	}
	/**
	 * 另外一套模版，返回数据，刚刚，09：11，昨天，06-11
	 * @param createTime
	 * @return
	 */
	public static String getDistanceOfNow2(Date createTime){
		String res = "";
		Date now = new Date();
		long n1 = now.getTime();
		long n2 = createTime.getTime();
		long t1 = 1000 * 60 * 5;//5分钟内算刚刚
		long t2 = 1000 * 60 * 60 * 24;//1天内计算时分,以上计算日期
		long t = n1 - n2;
		if(t < t1){
			long f = t / 1000 / 60;
			res = "刚刚";
		}else if(t > t1 && t < t2){
			String temp = format(now, "yyyy-MM-dd");
			Date tempDate = parse(temp, "yyyy-MM-dd");
			long tempTime = tempDate.getTime();
			res = format(createTime, "HH:mm");
			if(tempTime > n2){
				res = "昨天 "+ res;
			}
		}
		if(t > t2){
			res = format(createTime, "MM-dd");
		}
		return res;
	}
	
	/**
	 * 获取当前是该学期第几周
	 * @auther zhy
	 * @since May 20, 2016
	 */
	public static int getWeekNo(Date nowDate,Date startDate){
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar now = Calendar.getInstance();
		now.setTime(nowDate);
		return now.get(Calendar.WEEK_OF_YEAR)-start.get(Calendar.WEEK_OF_YEAR)+1;
	}
	/**
	 * 计算两个日期之间相差的周次
	 * 按照中国习惯，周一到周日算一周
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getWeekCountBetween(Date start,Date end){
		Calendar c_start = Calendar.getInstance();
		c_start.setTime(start);
		c_start.set(Calendar.HOUR, 0);
		c_start.set(Calendar.MINUTE, 0);
		c_start.set(Calendar.SECOND, 0);
		c_start.set(Calendar.MILLISECOND, 0);
		Calendar c_end = Calendar.getInstance();
		c_end.setTime(end);
		c_end.set(Calendar.HOUR, 0);
		c_end.set(Calendar.MINUTE, 0);
		c_end.set(Calendar.SECOND, 0);
		c_end.set(Calendar.MILLISECOND, 0);
		int  start_week = c_start.get(Calendar.DAY_OF_WEEK);
		int  end_week = c_end.get(Calendar.DAY_OF_WEEK);
		int ret = 0;
		if(start_week!=2){
			//不是周一，则加到周一
			ret++;
			c_start.add(Calendar.DATE, 9-start_week);
		}
		if(end_week!=1){
			//不是周日，则减到周日
			ret++;
			c_end.add(Calendar.DATE, 1-end_week);
		}
		//周日-周六123456
		long days = diffDays(c_end.getTime(),c_start.getTime())+1;
		int week = (new Long(days).intValue())/7;
		return week+ret;
	}
	
	/**
	 * 获取当前周期开始日期， 格式：yyyy-MM-dd
	 * @param att_start_date 周期开始日
	 * @return
	 */
	public static String getCurrentAttendanceCycleStartDate(int att_start_date){
		String current = DateUtil.getDate();
    	String currentAttendanceCycleStartDate = current.substring(0, 8) + (att_start_date > 9 ? att_start_date : "0" + att_start_date);
    	if (DateUtil.getCurrentDay() < att_start_date) {
    		//上个月的周期还未结束
    		currentAttendanceCycleStartDate = DateUtil.format(DateUtil.addMonths(DateUtil.parse(currentAttendanceCycleStartDate), -1), YYYY_MM_DD);
    	}
    	
    	return currentAttendanceCycleStartDate;
	}
	
	/**
	 * 获取当前周期结束日期， 格式：yyyy-MM-dd
	 * @param att_start_date 周期开始日
	 * @return
	 */
	public static String getCurrentAttendanceCycleEndDate(int att_start_date){
		String currentAttendanceCycleStartDate = getCurrentAttendanceCycleStartDate(att_start_date);
    	String currentAttendanceCycleEndDate = DateUtil.format(DateUtil.addDays(DateUtil.addMonths(DateUtil.parse(currentAttendanceCycleStartDate), 1), -1), YYYY_MM_DD);
    	
    	return currentAttendanceCycleEndDate;
	}
	
	/**
	 * 获取上一周期结算日期， 格式：yyyy-MM-dd
	 * @param att_start_date 周期开始日
	 * @param att_acc_day 周期结算日
	 * @return
	 */
	public static String getPreviousAttendanceCycleBalanceDate(int att_start_date, int att_acc_day){
		String currentAttendanceCycleStartDate = getCurrentAttendanceCycleStartDate(att_start_date);
		String previousAttendanceCycleBalanceDate = DateUtil.AddDay(currentAttendanceCycleStartDate, YYYY_MM_DD, (att_acc_day - 1));
    	
    	return previousAttendanceCycleBalanceDate;
	}
	
	/**
	 * 获取未结算的周期开始日期， 格式：yyyy-MM-dd
	 * @param att_start_date 周期开始日
	 * @param att_acc_day 周期结算日
	 * @return
	 */
	public static String getAttendanceCycleStartDate(int att_start_date, int att_acc_day){
		String currentAttendanceCycleStartDate = getCurrentAttendanceCycleStartDate(att_start_date);
		String currentAttendanceCycleBalanceDate = getPreviousAttendanceCycleBalanceDate(att_start_date, att_acc_day);
		String attendanceCycleStartDate = "";
		if (DateUtil.diffDays(DateUtil.parse(DateUtil.getDate()), DateUtil.parse(currentAttendanceCycleBalanceDate)) <= 0) {
    		//上个月
			attendanceCycleStartDate = DateUtil.format(DateUtil.addMonths(DateUtil.parse(currentAttendanceCycleStartDate), -1), YYYY_MM_DD);
    	}
		else {
			attendanceCycleStartDate = currentAttendanceCycleStartDate;
    	}
    	
    	return attendanceCycleStartDate;
	}
	
	/**
	 * 获取当前有效周期结算日期， 格式：yyyy-MM-dd
	 * @param att_start_date 周期开始日
	 * @param att_acc_day 周期结算日
	 * @return
	 */
	public static String getCurrentAttendanceCycleBalanceDate(int att_start_date, int att_acc_day){
		String currentAttendanceCycleBalanceDate = "";
		String currentAttendanceCycleStartDate = getCurrentAttendanceCycleStartDate(att_start_date);
		String previousAttendanceCycleBalanceDate = getPreviousAttendanceCycleBalanceDate(att_start_date, att_acc_day);
		//如果当前日期   > 上一周期的考勤结算日，就取当前周期开始日 + 1个月 + 结算天数
		if (DateUtil.diffDays(DateUtil.parse(DateUtil.getDate()), DateUtil.parse(previousAttendanceCycleBalanceDate)) > 0) {
			currentAttendanceCycleBalanceDate = DateUtil.AddDay(DateUtil.format(DateUtil.addMonths(DateUtil.parse(currentAttendanceCycleStartDate), 1), YYYY_MM_DD), YYYY_MM_DD, (att_acc_day - 1));
    	}
		else {
			//否则就取当前周期开始日 + 结算天数
			currentAttendanceCycleBalanceDate = DateUtil.AddDay(currentAttendanceCycleStartDate, YYYY_MM_DD, (att_acc_day - 1));;
    	}
    	
    	return currentAttendanceCycleBalanceDate;
	}

	/**
	 * 获取日期年份
	 * @param date 日期
	 * @return
	 */
	public static String getYear(Date date) {
		return format(date,YYYY_MM_DD_HH_MM_SS).substring(0, 4);
	}
	/**
	 * 功能描述：返回月
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小
	 *
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分
	 *
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 *
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫
	 *
	 * @param date
	 *            日期
	 * @return 返回毫
	 */
	public static long getMillis(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * 	判断是不是昨天、明天
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static boolean isYestoday(long day1, long day2) {
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(day1);
		int d1 = instance.get(Calendar.DAY_OF_YEAR);
		instance.setTimeInMillis(day2);
		int d2 = instance.get(Calendar.DAY_OF_YEAR);
		return d1 - d2 == 1 || d2 - d1 == 1;
	}

	/**
	 * 	判断是不是明天
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static boolean isAfterDay(long day1, long day2) {
		Calendar instance = Calendar.getInstance();
		instance.setTimeInMillis(day1);
		int d1 = instance.get(Calendar.DAY_OF_YEAR);
		instance.setTimeInMillis(day2);
		int d2 = instance.get(Calendar.DAY_OF_YEAR);
		return d2 - d1 == 1;
	}
}
