package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.JobDetail;
import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.ILoginService;
import serviceImp.IMyRegistrationService;
import tool.ResultUtil;

public class GetMyRegistrationDetailAction 
{
	private String mobile;
	private String pwd;
	private long parttimeid;
	private long userid;
	private ILoginService loginService;
	private IMyRegistrationService myRegistrationService;
	
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public IMyRegistrationService getMyRegistrationService() {
		return myRegistrationService;
	}
	public void setMyRegistrationService(
			IMyRegistrationService myRegistrationService) {
		this.myRegistrationService = myRegistrationService;
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

		if (result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "密码错误！");
		else if (result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(
					ServletActionContext.getResponse(), null, "用户账号不存在！");
		else {
			List results = myRegistrationService.getMyRegistrationDetail(userid, parttimeid);
			for(int i=0;i<results.size();++i)
			{
				ResultUtil.returnJsonWithCode200(
						ServletActionContext.getResponse(), results, "获取成功！");
			}
		}
		return null;
	}
}
