package action;

import model.JobDetail;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class DisableJobAction {
	
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
		
		JobDetail job = jobDetailService.getJobDetailById(Long.parseLong(jobid));
		job.setEnable(0);
		jobDetailService.updateJob(job);
		
		ResultUtil.returnJsonWithCode200(
				ServletActionContext.getResponse(), null, "兼职下架成功！");
		
		return null;
	}

}
