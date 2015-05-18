package action;

import java.util.List;
import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class GetShortDateAction {
	
	private long userid;
	private String mobile;
	private String pwd;
	private long parttimeid;
	private IJobDetailService jobDetailService;
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
	public long getParttimeid() {
		return parttimeid;
	}
	public void setParttimeid(long parttimeid) {
		this.parttimeid = parttimeid;
	}
	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}
	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}
	
	public String execute() {
		
		List jobDates = jobDetailService.getShortDate(parttimeid, userid);
	
		if (jobDates.size() == 0)
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "无兼职日期！");
		else
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), jobDates, "获取成功！");

		
		return null;
	}

}
