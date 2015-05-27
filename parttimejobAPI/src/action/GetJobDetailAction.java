package action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.EnterpriseInfo;
import model.JobDetail;

import org.apache.struts2.ServletActionContext;

import daoImp.IEnterpriseInfoDAO;

import serviceImp.IJobDetailService;
import tool.ResultUtil;

public class GetJobDetailAction {

	private IJobDetailService jobDetailService;
	private long userid;
	private long parttimeid;

	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}

	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getParttimeid() {
		return parttimeid;
	}

	public void setParttimeid(long parttimeid) {
		this.parttimeid = parttimeid;
	}

	public String execute() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		JobDetail jobDetail = jobDetailService.getJobDetailById(parttimeid);

		if(jobDetail!=null)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("parttimlogo", jobDetail.getImg());
			map.put("parttimeid", jobDetail.getJobid());
			map.put("recruitment_title", jobDetail.getName());
			map.put("payunit", jobDetail.getPayUnit().getName());
			map.put("unit", jobDetailService.getConpany(jobDetail.getEnterpriseAccount().getEnterpriseid()));
			map.put("workhours", jobDetail.getTime());
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        String dataStr = format.format(jobDetail.getDeadline());
			map.put("stopdate", dataStr);
//			map.put("parttimejob_num", jobDetail.getNum());
			map.put("sex", jobDetail.getSex());
			map.put("height", jobDetail.getHeight());
			map.put("health_certificate", jobDetail.getHealth());
			map.put("interview", jobDetail.getInterview());
			if(jobDetail.getInterview() != 0)
			{
				map.put("interview_address", jobDetail.getInterviewaddr());
				map.put("interviewdate", jobDetail.getInterviewtime());
			}
			map.put("work_content", jobDetail.getJobContent());
			map.put("remark", jobDetail.getRemark());
			if(jobDetail.getWorktimetype() == 1)
			{
				map.put("worktimetype", "longterm");
				map.put("enroll", 0);
				map.put("remaining",
						jobDetailService.getRemainingLong(jobDetail.getJobid()));
				map.put("parttimejob_num", jobDetail.getNum());
			}
			else
			{
				map.put("worktimetype", "shortterm");
				if(jobDetailService.getEnroll(parttimeid, userid))
					map.put("enroll", 1);
				else
					map.put("enroll", 0);
				
				map.put("remaining",
						jobDetailService.getRemainingShort(jobDetail.getJobid()));
				map.put("parttimejob_num", jobDetailService.getNumShort(jobDetail.getJobid()));
				map.put("signum", jobDetail.getNum());
			}
			map.put("type", jobDetail.getJobType().getName());
			map.put("typecode", jobDetail.getJobType().getJobtypeid());
			map.put("latitude", jobDetail.getLatitude());
			map.put("longitude", jobDetail.getLongitude());
			
			map.put("amount", jobDetail.getPay());
			map.put("address", jobDetail.getAddress());
			map.put("count_type", jobDetail.getPayCountType().getName());
			map.put("ariunit", jobDetail.getPayUnit().getName());
			
			list.add(map);
			
			ResultUtil.returnJsonWithCode200(
					ServletActionContext.getResponse(), list, "获取成功！");
		}
		else
			ResultUtil.returnJsonWithCode300(
					ServletActionContext.getResponse(), null, "无兼职！");
			

		return null;
	}

}
