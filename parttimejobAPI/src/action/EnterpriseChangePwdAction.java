package action;

import model.EnterpriseAccount;
import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.IEnterpriseLoginService;
import tool.ResultUtil;

public class EnterpriseChangePwdAction {
	
	private String id;
	private String mobile;
	private String pwd;
	private String newpwd;
	private IEnterpriseLoginService enterpriseLoginService;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public IEnterpriseLoginService getEnterpriseLoginService() {
		return enterpriseLoginService;
	}
	public void setEnterpriseLoginService(
			IEnterpriseLoginService enterpriseLoginService) {
		this.enterpriseLoginService = enterpriseLoginService;
	}
	
	public String execute() {

		EnterpriseAccount tmpAccount = new EnterpriseAccount();
		tmpAccount.setEnterpriseid(Long.parseLong(id));
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);

		String result = enterpriseLoginService.checkAccount(tmpAccount);

		if (result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "密码错误！");
		else if (result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "用户账号不存在！");
		else {
			tmpAccount.setPassword(newpwd);
			enterpriseLoginService.changePwd(tmpAccount);
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), null, "密码修改成功！");
		}

		return null;
	}
}
