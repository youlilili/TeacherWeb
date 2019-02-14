package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import dao.IBaseDao;
import dao.IExcelDao;
import util.CommonUnit;
import util.DbUtil;

public class ExcelDaoImpl extends BaseDaoImpl implements IExcelDao {
	private PreparedStatement stmt = null;
	DbUtil dbutil = new DbUtil();
	IBaseDao baseDao = new BaseDaoImpl();
	CommonUnit unit = new CommonUnit();
	TeacherDaoImpl teacherdao = new TeacherDaoImpl();

	public int insertPatentValues(List datalist) {
		try {
			String sql = "insert into Patent (Patname,Patsn,Patapdate,Patendate,Patgrad,Patremarks,Tsn) Values(?,?,?,?,?,?,?)";
			stmt = dbutil.getConnection().prepareStatement(sql);
			int count = datalist.size();
			List list = dbutil.disposeNullCell(datalist);
			int times = 0; // 用来记录导入数据的条数
			for (int i = 0; i < count / 7; i++) {
				// j为专利信息表的列数
				String Tsn = teacherdao.getTsn((String) list.get(i * 7 + 2));// 教师名在excel中的第二列
				// 获取专利申请日期，将util.Date转化为sql.Date
				Date Patapdate = (Date) list.get(3 + i * 7);
				java.sql.Date sqlDate1 = new java.sql.Date(Patapdate.getTime());
				// 获取专利授权日期，将util.Date转化为sql.Date
				Date Patendate = (Date) list.get(4 + i * 7);
				java.sql.Date sqlDate2 = new java.sql.Date(Patendate.getTime());
				List params = Arrays.asList(list.get(0),list.get(1),sqlDate1,sqlDate2,list.get(5),list.get(6),Tsn);
				dbutil.getUpdateResult(sql, params);
				times++;
				if (times == count / 7) {
					return 1;
				}

			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("系统异常！");
		}
		return 0;

	}

	public int insertHonorValues(List datalist) {
		try {
			String sql = "insert into Honor (Hsn,Hname,Hwinner,Hdate,Hcompany,Hgrad,Hreward,Hremarks,Tsn) Values(?,?,?,?,?,?,?,?,?)";
			int count = datalist.size();
			int times = 0; // 用来记录导入数据的条数
			List list = dbutil.disposeNullCell(datalist);
			for (int i = 0; i < count / 8; i++) {
				// j为荣誉信息表的列数
				String Tsn = teacherdao.getTsn((String) list.get(i * 8 + 2));// 荣誉号在excel中的第一列
				// 获取获奖日期，将util.Date转化为sql.Date
				Date Hdate = (Date) list.get(3 + i * 7);
				java.sql.Date sqlDate1 = new java.sql.Date(Hdate.getTime());
				List params = Arrays.asList(list.get(0),list.get(1),list.get(2),sqlDate1,list.get(4),list.get(5),list.get(6),list.get(7),Tsn);
				dbutil.getUpdateResult(sql, params);
				times++;
				if (times == count / 8) {
					return 1;
				}
			}

			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("系统异常！");
		}
		return 0;	
	}

	@Override
	public int insertProjectValues(List datalist) {
		try {
			String sql = "insert into Project (Psn,Pname,Pleader,Pgrad,Pkind,Pcondition,Pmember,Pmoney,Pstatime,Pendtime,Premarks,Tsn) Values(?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt = dbutil.getConnection().prepareStatement(sql);
			int count = datalist.size();
			int times = 0; // 用来记录导入数据的条数
			List list = dbutil.disposeNullCell(datalist);
			for(Object a : list) {
				System.out.println(a);
			}
			for (int i = 0; i < count / 7; i++) {
				// j为专利信息表的列数
				String Tsn = teacherdao.getTsn((String) list.get(i * 7 + 2));// 教师名在excel中的第二列
				Date Pstatime = (Date) list.get(8 + i * 7);
				java.sql.Date sqlDate1 = new java.sql.Date(Pstatime.getTime());
				Date Pendtime = (Date) list.get(9 + i * 7);
				java.sql.Date sqlDate2 = new java.sql.Date(Pendtime.getTime());
				List params = Arrays.asList(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4),
						list.get(5), list.get(6),list.get(7),sqlDate1,sqlDate2, list.get(10),Tsn);
				dbutil.getUpdateResult(sql, params);
				times++;
			}
			if (times == count / 7) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				baseDao.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}


	@Override
	public int insertPaperValues(List datalist) {
		try {
			String sql = "insert into paper (Pasearchnum,Paname,Pawriter,Papublish,Padate,Pagrad,Paremarks,Tsn) Values(?,?,?,?,?,?,?,?)";
			int count = datalist.size();
			int times = 0; // 用来记录导入数据的条数
			List list = dbutil.disposeNullCell(datalist);
			for (int i = 0; i < count / 7; i++) {
				// j为论文信息表的列数
				String Tsn = teacherdao.getTsn((String) list.get(i * 7 + 2));// 教师名在excel中的第三列
				Date Pstatime = (Date) list.get(4 + i * 7);
				java.sql.Date sqlDate1 = new java.sql.Date(Pstatime.getTime());
				List params = Arrays.asList(list.get(0), list.get(1), list.get(2), list.get(3), sqlDate1,
						list.get(5), list.get(6),Tsn);
				dbutil.getUpdateResult(sql, params);
				times++;
			}
			if (times == count / 7) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				baseDao.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	

	public static void main(String[] args) {

	}
}
