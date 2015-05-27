package action;

import java.util.List;

import model.JobDetail;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class GetMyShortJobDateAction {

	private String jobid;
	private IJobDetailService jobDetailService;

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

		List jobDates = jobDetailService.getShortDate(Long.parseLong(jobid));
		
		if (jobDates.size() == 0)
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "无兼职日期！");
		else
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), jobDates, "获取成功！");

		return null;
	}

}
