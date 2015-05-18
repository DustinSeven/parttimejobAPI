package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.EnterpriseAccount;
import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.IEnterpriseLoginService;
import tool.ResultUtil;

public class EnterpriseLoginAction {
	
	 private IEnterpriseLoginService enterpriseLoginService;
	 private String mobile;
	 private String pwd;
	 
	public IEnterpriseLoginService getEnterpriseLoginService() {
		return enterpriseLoginService;
	}
	public void setEnterpriseLoginService(
			IEnterpriseLoginService enterpriseLoginService) {
		this.enterpriseLoginService = enterpriseLoginService;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	 
	public String execute() {
    	EnterpriseAccount tmpAccount = new EnterpriseAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);
		
		System.out.print(mobile + " " + pwd);
		
		String result = enterpriseLoginService.checkAccount(tmpAccount);
		Map<String, Object> map = new HashMap<String, Object>();

		if(result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"�������");
		else if(result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"�û��˺Ų����ڣ�");
		else
		{
			map.put("id", Long.parseLong(result));
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list.add(map);
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"��½�ɹ���");
		}
		

		return null;
	}

}
