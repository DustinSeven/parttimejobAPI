package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.ILoginService;
import serviceImp.IRegistrationService;
import tool.ResultUtil;

public class RegistrationLongAction {
	
	private IRegistrationService registrationService;
	private ILoginService loginService;
	private String mobile;
	private String pwd;
	private long userid;
	private long parttimeid;
	
	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	public IRegistrationService getRegistrationService() {
		return registrationService;
	}
	public void setRegistrationService(IRegistrationService registrationService) {
		this.registrationService = registrationService;
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
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getParttimeid() {
		return parttimeid;
	}
	public void setParttimeid(long parttimeid) {
		this.parttimeid = parttimeid;
	}
	
	public String execute() {
		
		UserAccount tmpAccount = new UserAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);
		
		String result = loginService.checkAccount(tmpAccount);

		if(result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"密码错误！");
		else if(result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"用户账号不存在！");
		else
		{
			List list = new ArrayList();
			String mob = registrationService.registrationLong(parttimeid, userid);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("mobile", mob);
			list.add(map);
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"报名成功！");
		}
		
		
		return null;
	}

}
