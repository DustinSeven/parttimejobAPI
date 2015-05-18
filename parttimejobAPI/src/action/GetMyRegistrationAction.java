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

public class GetMyRegistrationAction {

	private ILoginService loginService;
	private IMyRegistrationService myRegistrationService;
	private String mobile;
	private String pwd;
	private long userid;
	private int page;
	private int pagesize;

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public IMyRegistrationService getMyRegistrationService() {
		return myRegistrationService;
	}

	public void setMyRegistrationService(
			IMyRegistrationService myRegistrationService) {
		this.myRegistrationService = myRegistrationService;
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
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
			List list = new ArrayList();
			List jobs = myRegistrationService.getMyRegistration(userid);
			for(int i = 0;i<jobs.size();++i)
			{
				JobDetail job = (JobDetail)jobs.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("amount", job.getPay());
				map.put("address", job.getAddress());
				map.put("parttimejob_logo", job.getImg());
				map.put("recruitment_tittle", job.getName());
				map.put("linkmanmobile", job.getEnterpriseAccount().getMobile());
				map.put("jianzhitu", "18868831847");
				map.put("check_in", 1);
				map.put("partjobid", job.getJobid());
				if(job.getWorktimetype() == 1)
					map.put("worktimetype", "longterm");
				else
					map.put("worktimetype", "shortterm");
				
				list.add(map);
			}
			
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "获取成功！");
		}

		return null;
	}

}
