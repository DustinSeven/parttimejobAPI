package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.ILoginService;
import serviceImp.IUserSettingService;
import tool.ResultUtil;

public class SetUserSettingAction {

	private IUserSettingService userSettingService;
	private ILoginService loginService;
	private String mobile;
	private String pwd;
	private long userid;
	private int opentoalumnus;
	public IUserSettingService getUserSettingService() {
		return userSettingService;
	}
	public void setUserSettingService(IUserSettingService userSettingService) {
		this.userSettingService = userSettingService;
	}
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
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public int getOpentoalumnus() {
		return opentoalumnus;
	}
	public void setOpentoalumnus(int opentoalumnus) {
		this.opentoalumnus = opentoalumnus;
	}
	
	public String execute() {

		UserAccount tmpAccount = new UserAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);

		String result = loginService.checkAccount(tmpAccount);

		if (result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "密码错误！");
		else if (result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "用户账号不存在！");
		else {
			
			userSettingService.setUserPrivacy(opentoalumnus, userid);
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), null, "设置成功！");
		}
		
		return null;
	}
}
