package action;

import java.util.HashMap;
import java.util.Map;

import model.EnterpriseAccount;
import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.IEnterpriseLoginService;
import serviceImp.ILoginService;
import tool.ResultUtil;

public class EnterpriseRegisterAction {

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
		
		EnterpriseAccount enterprise = new EnterpriseAccount();
		enterprise.setMobile(mobile);
		enterprise.setPassword(pwd);
		boolean isSuccess = enterpriseLoginService.addAccount(enterprise);
		
		Map<String, Object> map = new HashMap<String, Object>();

		if(isSuccess != true)
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"账户已存在！");
		else 
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"注册成功！");
		
		return null;
	}
}
