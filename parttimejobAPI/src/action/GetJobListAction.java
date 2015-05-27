package action;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.JobDetail;
import model.Province;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class GetJobListAction {

	private IJobDetailService jobDetailService;
	private int page;
	private int pagesize;
	private int psex;
	private String ptype;
	private long areaid;
	private String keyword;

	public int getPsex() {
		return psex;
	}

	public void setPsex(int psex) {
		this.psex = psex;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public long getAreaid() {
		return areaid;
	}

	public void setAreaid(long areaid) {
		this.areaid = areaid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}

	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}

	public String execute() {

		System.out.println(psex + " " + ptype + " " + areaid + " " + keyword);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List jobs = jobDetailService.getJobDetailList(page,pagesize,psex,ptype,areaid,keyword);
		for (int i = 0; i < jobs.size(); ++i) {
			JobDetail jobDetail = (JobDetail) jobs.get(i);
			if(jobDetail.getEnable() == 0)
				continue;
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("parttimeid", jobDetail.getJobid());
			map.put("recruitment_tittle", jobDetail.getName());
			map.put("amount", jobDetail.getPay());
			map.put("address", jobDetail.getAddress());
			map.put("count_type", jobDetail.getPayCountType().getName());
			map.put("ariunit", jobDetail.getPayUnit().getName());
			map.put("parttimejob_logo", jobDetail.getImg());
			map.put("timetype", jobDetail.getWorktimetype());
			map.put("type", jobDetail.getJobType().getName());
			map.put("typecode", jobDetail.getJobType().getJobtypeid());

			if(jobDetail.getCreatetime() != null)
			{
				long differ;
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
				String createStr = dateFormat.format(jobDetail.getCreatetime());
				String nowStr = dateFormat.format(new Date());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmm");
				long createTime = 0;
				long nowTime = 0;
				try {
					createTime = sdf.parse(createStr).getTime();
					nowTime = sdf.parse(nowStr).getTime();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(nowTime - createTime >= 259200000)
					map.put("new", 0);
				else
					map.put("new", 1);
			}

			if(jobDetail.getWorktimetype() == 1)
			{
				map.put("remaining",
						jobDetailService.getRemainingLong(jobDetail.getJobid()));
			}
			else
			{
				map.put("remaining",
						jobDetailService.getRemainingShort(jobDetail.getJobid()));
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
