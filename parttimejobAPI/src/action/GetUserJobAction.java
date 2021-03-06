package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.JobDetail;
import model.UserAccount;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class GetUserJobAction {
	
	private String jobId;
	private IJobDetailService jobDetailService;
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}
	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}
	
	public String execute() {
		
		JobDetail job = jobDetailService.getJobDetailById(Long.parseLong(jobId));
		List users = null;
		if(job.getWorktimetype() == 1)
			users = jobDetailService.getLongRegiUser(Long.parseLong(jobId));
		else
			users = jobDetailService.getShortRegiUser(Long.parseLong(jobId));
		

		if(users.size()!=0)
		{
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), users, "获取成功！");
		}
		else
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "兼职无报名！");
		
		return null;
	}

}
