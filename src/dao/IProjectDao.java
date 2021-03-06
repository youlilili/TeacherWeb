package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ExcelProject;
import model.Paper;
import model.Patent;
import model.Project;

public interface IProjectDao {
public int delProject(String Psn);		//根据项目号删除对应的项目信息

	
	public int alterProject(Project project) throws SQLException;	//根据项目修改对应的修改项目内容
	
		
	
	
	public int insertProject(Project project)throws SQLException;						//插入新的项目信息
		
	
	//返回当前显示页的数据
	//currentPage：当前页（页码），pageSize：每页显示数据条数
	//college：所属学院，sdept：所属系，starttime：开始时间，endtime：结束时间，Tname：搜索的教师名
	public ResultSet selectCollegeProject(String college,String sdept,String starttime,String endtime,String Tname,int currentPage,int pageSize) throws SQLException;		//根据两个下拉框的改变显示不同的查询结果
		

	
	public List<ExcelProject> getExcelDataList(ResultSet rs);//获取导出excel的集合
	
	
	public List<Project> getDataList(ResultSet rs);//将结果集转化为集合
	
	public int projectAudit(String Psn,String Paudit,String message); //审核
	
	public List<Project> getlist(Project project); //获取审核的详细信息
	
	public String getAccessory(String Psn); //获取对应的附件路径
	
	public void saveFilePath(String path,String psn);  //保存上传的附件的路径
}
