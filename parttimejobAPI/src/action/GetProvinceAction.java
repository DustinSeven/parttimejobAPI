package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.UserAccount;
import model.UserInfo;
import model.Province;

import org.apache.struts2.ServletActionContext;

import serviceImp.IGetProvinceService;
import tool.ResultUtil;

public class GetProvinceAction {
	
	private IGetProvinceService getProvinceService;

	public IGetProvinceService getGetProvinceService() {
		return getProvinceService;
	}

	public void setGetProvinceService(IGetProvinceService getProvinceService) {
		this.getProvinceService = getProvinceService;
	}
	
	
public String execute() {
	
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	
	List provinces = getProvinceService.getAllProvince();
	for(int i = 0;i<provinces.size();++i)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Province province = (Province)provinces.get(i);
		map.put("provinceid", province.getCode() );
		map.put("pname", province.getName());
		list.add(map);
	}
	
		if(list.size() == 0)
			ResultUtil.returnJsonWithCode300(ServletActionContext.getResponse(), null,"无省份！");
		else 
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"获取成功！");

		return null;
	}

}
