package action;

import model.JobDetail;
import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import serviceImp.ILoginService;
import tool.ResultUtil;

public class SignInAction {

	private String jobid;
	private IJobDetailService jobDetailService;
	private String userid;
	private String mobile;
	private String pwd;
	private ILoginService loginService;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
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

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}

	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}

	public String execute() {

		UserAccount tmpAccount = new UserAccount();
		tmpAccount.setUserid(Long.parseLong(userid));
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

			JobDetail job = jobDetailService.getJobDetailById(Long
					.parseLong(jobid));
			String resultStr;
			if (job.getWorktimetype() == 1) {
				resultStr = jobDetailService.signLong(Long.parseLong(userid),
						Long.parseLong(jobid));
			} else {
				resultStr = jobDetailService.signShort(Long.parseLong(userid),
						Long.parseLong(jobid));
			}

			if (resultStr.endsWith("success"))
				ResultUtil.returnJsonWithCode200(
						ServletActionContext.getResponse(), null, "签到成功！");
			if (resultStr.endsWith("already"))
				ResultUtil.returnJsonWithCode300(
						ServletActionContext.getResponse(), null, "您已签到该兼职！");
			if (resultStr.endsWith("nouserjob"))
				ResultUtil.returnJsonWithCode300(
						ServletActionContext.getResponse(), null, "您未报名今天的兼职！");

		}

		return null;
	}

}
