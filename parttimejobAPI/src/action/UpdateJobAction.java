package action;

import model.JobDetail;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class UpdateJobAction {

	private String jobid;
	private String jobcontent;
	private IJobDetailService jobDetailService;

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getJobcontent() {
		return jobcontent;
	}

	public void setJobcontent(String jobcontent) {
		this.jobcontent = jobcontent;
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
		job.setJobContent(jobcontent);
		jobDetailService.updateJob(job);

		ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(),
				null, "��ְ�¼ܳɹ���");

		return null;
	}

}
