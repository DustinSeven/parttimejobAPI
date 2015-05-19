package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.EnterpriseInfo;
import model.UserAccount;
import model.UserInfo;

import org.apache.struts2.ServletActionContext;

import serviceImp.IEnterpriseLoginService;
import tool.ResultUtil;

public class GetEnterpriseInfoAction {

	private IEnterpriseLoginService enterpriseLoginService;
	private String id;
	
	public IEnterpriseLoginService getEnterpriseLoginService() {
		return enterpriseLoginService;
	}
	public void setEnterpriseLoginService(
			IEnterpriseLoginService enterpriseLoginService) {
		this.enterpriseLoginService = enterpriseLoginService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
public String execute() {
		
		Map<String, Object> map = new HashMap<String, Object>();

			EnterpriseInfo tmpInfo = enterpriseLoginService.getEnterpriseInfo(id);
			if(tmpInfo != null)
			{
				map.put("id", tmpInfo.getEnterpriseid());
				map.put("account", tmpInfo.getAccount());
				map.put("sex",String.valueOf(tmpInfo.getSex()));
				map.put("remark", tmpInfo.getRemark());
				map.put("img", tmpInfo.getImg());
				map.put("company", tmpInfo.getCompany());
				map.put("email", tmpInfo.getEmail());
				map.put("qq", tmpInfo.getQq());
			}
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list.add(map);
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"获取成功！");

		return null;
	}
	
}
