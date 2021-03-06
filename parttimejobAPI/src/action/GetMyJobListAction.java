package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.JobDetail;

import org.apache.struts2.ServletActionContext;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class GetMyJobListAction {
	
	private IJobDetailService jobDetailService;
	private int page;
	private int pagesize;
	private String enterid;
	
	
	public String getEnterid() {
		return enterid;
	}
	public void setEnterid(String enterid) {
		this.enterid = enterid;
	}
	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}
	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
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

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List jobs = jobDetailService.getJobDetailList(page,pagesize,Long.parseLong(enterid));
		for (int i = 0; i < jobs.size(); ++i) {
			JobDetail jobDetail = (JobDetail) jobs.get(i);
			if(jobDetail.getEnable() == 0)
				continue;
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("jobid", String.valueOf(jobDetail.getJobid()));
			map.put("parttimeid", String.valueOf(jobDetail.getJobid()));
			map.put("title", jobDetail.getName());
			map.put("logo", jobDetail.getImg());
			map.put("jobtype", jobDetail.getJobType().getName());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deadline = dateFormat.format(jobDetail.getDeadline());
			map.put("deadline",deadline);
			map.put("worktimetype", jobDetail.getWorktimetype());
			if(jobDetail.getWorktimetype() == 1)
			{
				map.put("remaining",
						jobDetailService.getRemainingLong(jobDetail.getJobid()));
				map.put("num", jobDetail.getNum());
			}
			else
			{
				map.put("remaining",
						jobDetailService.getRemainingShort(jobDetail.getJobid()));
				map.put("num", jobDetailService.getNumShort(jobDetail.getJobid()));
			}

			list.add(map);
		}

		if (list.size() == 0)
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "无兼职！");
		else
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "获取成功！");

		return null;
	}
}
