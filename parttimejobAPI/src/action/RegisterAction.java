package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import model.UserAccount;
import serviceImp.ILoginService;
import tool.ResultUtil;

public class RegisterAction {
	
	private ILoginService loginService;
	private String mobile;
	private String pwd;
	
	
	public ILoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
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
		
		UserAccount userAccount = new UserAccount();
		userAccount.setMobile(mobile);
		userAccount.setPassword(pwd);
		boolean isSuccess = loginService.addAccount(userAccount);
		
		Map<String, Object> map = new HashMap<String, Object>();

		if(isSuccess != true)
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"账户已存在！");
		else 
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), null,"注册成功！");
		
		return null;
	}

}
