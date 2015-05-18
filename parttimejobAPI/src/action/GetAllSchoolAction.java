package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.School;

import org.apache.struts2.ServletActionContext;

import serviceImp.IGetSchoolService;
import tool.ResultUtil;

public class GetAllSchoolAction {
	
	private IGetSchoolService getSchoolService;
	private long collegeid;
	public IGetSchoolService getGetSchoolService() {
		return getSchoolService;
	}
	public void setGetSchoolService(IGetSchoolService getSchoolService) {
		this.getSchoolService = getSchoolService;
	}
	public long getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(long collegeid) {
		this.collegeid = collegeid;
	}
	
	public String execute() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		List schools = getSchoolService.getAllSchool(collegeid);
		for (int i = 0; i < schools.size(); ++i) {
			Map<String, Object> map = new HashMap<String, Object>();
			School school = (School) schools.get(i);
			map.put("departmentid", school.getId());
			map.put("departmentname", school.getName());
			list.add(map);
		}

		if (list.size() == 0)
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "无院系！");
		else
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "获取成功！");

		return null;
	}

}
