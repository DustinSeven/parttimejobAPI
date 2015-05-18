package action;

import java.io.IOException;
import model.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import serviceImp.ILoginService;
import tool.ResultUtil;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private ILoginService loginService;
	private String mobile;
	private String password;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() {
    	UserAccount tmpAccount = new UserAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(password);
		
		String result = loginService.checkAccount(tmpAccount);
		Map<String, Object> map = new HashMap<String, Object>();

		if(result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"密码错误！");
		else if(result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"用户账号不存在！");
		else
		{
			map.put("id", Long.parseLong(result));
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list.add(map);
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"登陆成功！");
		}
		

		return null;
	}

}
