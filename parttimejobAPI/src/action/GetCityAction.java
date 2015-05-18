package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.City;

import org.apache.struts2.ServletActionContext;

import serviceImp.IGetCityService;
import tool.ResultUtil;

public class GetCityAction {

	private IGetCityService getCityService;
	private long provinceid;

	public IGetCityService getGetCityService() {
		return getCityService;
	}

	public void setGetCityService(IGetCityService getCityService) {
		this.getCityService = getCityService;
	}
	
	public long getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(long provinceid) {
		this.provinceid = provinceid;
	}

	public String execute() {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		List citys = getCityService.getCity(provinceid);
		for(int i = 0;i<citys.size();++i)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			City city = (City)citys.get(i);
			map.put("cityid", city.getCode() );
			map.put("city", city.getName());
			list.add(map);
		}
		
		if(list.size() == 0)
			ResultUtil.returnJsonWithCode300(ServletActionContext.getResponse(), null,"无城市！");
		else 
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"获取成功！");

		return null;
	}

}
