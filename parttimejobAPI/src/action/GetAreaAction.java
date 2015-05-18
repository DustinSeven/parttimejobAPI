package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Area;

import org.apache.struts2.ServletActionContext;

import serviceImp.IGetAreaService;
import tool.ResultUtil;

public class GetAreaAction {

	private IGetAreaService getAreaService;
	private long cityid;

	public IGetAreaService getGetAreaService() {
		return getAreaService;
	}

	public void setGetAreaService(IGetAreaService getAreaService) {
		this.getAreaService = getAreaService;
	}

	public long getCityid() {
		return cityid;
	}

	public void setCityid(long cityid) {
		this.cityid = cityid;
	}

	public String execute() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		List areas = getAreaService.getArea(cityid);
		for (int i = 0; i < areas.size(); ++i) {
			Map<String, Object> map = new HashMap<String, Object>();
			Area area = (Area) areas.get(i);
			map.put("areaid", area.getCode());
			map.put("areaname", area.getName());
			list.add(map);
		}

		if (list.size() == 0)
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "无地区！");
		else
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "获取成功！");

		return null;
	}

}
