package action;

import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import serviceImp.ILoginService;
import tool.ResultUtil;

public class GetLongJobEnrollAction {
	
	private long userid;
	private long parttimeid;
	private String mobile;
	private String pwd;
	private IJobDetailService jobDetailService;
	private ILoginService loginService;
	
	
	
	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
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
	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}
	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
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
			
			boolean isEnroll = jobDetailService.getEnroll(parttimeid, userid);
			if(isEnroll)
				ResultUtil.returnJsonWithCode300(
						ServletActionContext.getResponse(), null, "该兼职已报名！");
			else
				ResultUtil.returnJsonWithCode200(
						ServletActionContext.getResponse(), null, "该兼职未报名！");
			
		}
		
		return null;
	}

}
