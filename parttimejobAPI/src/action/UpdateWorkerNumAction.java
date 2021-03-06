package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.JobDate;
import model.JobDetail;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class UpdateWorkerNumAction {

	private String jobid;
	private String num;
	private IJobDetailService jobDetailService;

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}

	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}

	public String execute() {
		JobDetail job = jobDetailService.getJobDetailById(Long.parseLong(jobid));
		job.setNum(Integer.parseInt(num));
		jobDetailService.updateJob(job);
		
		if (job.getWorktimetype() != 1) {
			List jobDates = jobDetailService.getShortDate(Long.parseLong(jobid));
			
			for (int i = 0; i < jobDates.size(); ++i) {
				
				Map<String, Object> jobDate = (Map<String, Object>) jobDates.get(i);
				jobDetailService.updateJobDate(Long.valueOf((String) jobDate.get("jobdateid")),
						Integer.parseInt(num));
			}
		}
		ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(),
				null, "�޸ĳɹ���");

		return null;
	}

}
