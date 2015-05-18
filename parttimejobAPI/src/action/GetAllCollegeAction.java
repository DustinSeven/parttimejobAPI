package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.City;
import model.College;

import org.apache.struts2.ServletActionContext;

import serviceImp.IGetCollegeService;
import tool.ResultUtil;

public class GetAllCollegeAction {

	private IGetCollegeService getCollegeService;
	private long provinceid;

	public long getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(long provinceid) {
		this.provinceid = provinceid;
	}

	public IGetCollegeService getGetCollegeService() {
		return getCollegeService;
	}

	public void setGetCollegeService(IGetCollegeService getCollegeService) {
		this.getCollegeService = getCollegeService;
	}

	public String execute() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		List colleges = getCollegeService.getCollege(provinceid);
		for (int i = 0; i < colleges.size(); ++i) {
			Map<String, Object> map = new HashMap<String, Object>();
			College college = (College) colleges.get(i);
			map.put("coid", college.getId());
			map.put("name", college.getName());
			list.add(map);
		}

		if (list.size() == 0)
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "无高校！");
		else
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "获取成功！");

		return null;
	}

}
