package action;

import model.JobDetail;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class DeleteUserJobAction {

	private String userjobid;
	private String jobid;
	private IJobDetailService jobDetailService;

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getUserjobid() {
		return userjobid;
	}

	public void setUserjobid(String userjobid) {
		this.userjobid = userjobid;
	}

	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}

	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}

	public String execute() {

		JobDetail job = jobDetailService
				.getJobDetailById(Long.parseLong(jobid));
		if (job.getWorktimetype() == 1)
			jobDetailService.deleteUserJobLong(Long.parseLong(userjobid));
		else
			jobDetailService.deleteUserJobShort(Long.parseLong(userjobid));

		ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(),
				null, "取消学生报名成功！");

		return null;
	}
}
