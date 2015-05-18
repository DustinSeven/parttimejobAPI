package action;

import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.ILoginService;
import tool.ResultUtil;

public class ChangePasswordAction {

	private long userid;
	private String mobile;
	private String pwd;
	private String newpwd;
	private ILoginService loginService;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
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

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String execute() {

		UserAccount tmpAccount = new UserAccount();
		tmpAccount.setUserid(userid);
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
			tmpAccount.setPassword(newpwd);
			loginService.changePwd(tmpAccount);
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), null, "密码修改成功！");
		}

		return null;
	}

}
