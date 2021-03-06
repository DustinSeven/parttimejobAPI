package action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import serviceImp.IEnterpriseLoginService;
import serviceImp.IJobDetailService;
import tool.ResultUtil;

import model.Area;
import model.EnterpriseAccount;
import model.JobDate;
import model.JobDetail;
import model.JobType;
import model.PayCountType;
import model.PayUnit;

public class ReleaseJobAction {
	
	private String mobile;
	private String pwd;
    private String payunitid;
    private String jobtypeid;
    private String paycounttypeid;
    private String name;
    private String enterid;
    private String pay;
    private String time;
    private String deadline;
    private String address;
    private String num;
    private String sex;
    private String height;
    private String health;
    private String interview;
    private String interviewaddr;
    private String interviewtime;
    private String jobContent;
    private String worktimetype;
    private String areaid;
    private IJobDetailService jobDetailService;
    private IEnterpriseLoginService enterpriseLoginService;
    private String dates;
    
    
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public IEnterpriseLoginService getEnterpriseLoginService() {
		return enterpriseLoginService;
	}
	public void setEnterpriseLoginService(
			IEnterpriseLoginService enterpriseLoginService) {
		this.enterpriseLoginService = enterpriseLoginService;
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
	public String getPayunitid() {
		return payunitid;
	}
	public void setPayunitid(String payunitid) {
		this.payunitid = payunitid;
	}
	public String getJobtypeid() {
		return jobtypeid;
	}
	public void setJobtypeid(String jobtypeid) {
		this.jobtypeid = jobtypeid;
	}
	public String getPaycounttypeid() {
		return paycounttypeid;
	}
	public void setPaycounttypeid(String paycounttypeid) {
		this.paycounttypeid = paycounttypeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnterid() {
		return enterid;
	}
	public void setEnterid(String enterid) {
		this.enterid = enterid;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getInterview() {
		return interview;
	}
	public void setInterview(String interview) {
		this.interview = interview;
	}
	public String getInterviewaddr() {
		return interviewaddr;
	}
	public void setInterviewaddr(String interviewaddr) {
		this.interviewaddr = interviewaddr;
	}
	public String getInterviewtime() {
		return interviewtime;
	}
	public void setInterviewtime(String interviewtime) {
		this.interviewtime = interviewtime;
	}
	public String getJobContent() {
		return jobContent;
	}
	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}
	public String getWorktimetype() {
		return worktimetype;
	}
	public void setWorktimetype(String worktimetype) {
		this.worktimetype = worktimetype;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public IJobDetailService getJobDetailService() {
		return jobDetailService;
	}
	public void setJobDetailService(IJobDetailService jobDetailService) {
		this.jobDetailService = jobDetailService;
	}
    
	@SuppressWarnings("deprecation")
	public String execute() {
		
		EnterpriseAccount tmpAccount = new EnterpriseAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);
		
		String result = enterpriseLoginService.checkAccount(tmpAccount);
		Map<String, Object> map = new HashMap<String, Object>();

		if(result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"密码错误！");
		else if(result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"用户账号不存在！");
		else
		{
			JobDetail job = new JobDetail();
			
			if(payunitid != null)
			{
				PayUnit payUnit = new PayUnit();
				payUnit.setId(Long.parseLong(payunitid));
				job.setPayUnit(payUnit);
			}
			
			if(jobtypeid != null)
			{
				JobType jobType = new JobType();
				jobType.setJobtypeid(Long.parseLong(jobtypeid));
				job.setJobType(jobType);
			}
			
			if(paycounttypeid != null)
			{
				PayCountType payCountType = new PayCountType();
				payCountType.setId(Long.parseLong(paycounttypeid));
				job.setPayCountType(payCountType);
			}
			
			job.setName(name);
			
			if(enterid != null)
			{
				EnterpriseAccount enter = new EnterpriseAccount();
				enter.setEnterpriseid(Long.parseLong(enterid));
				job.setEnterpriseAccount(enter);
			}
			
			if(pay != null)
				job.setPay(Double.parseDouble(pay));
			job.setTime(time);
			if(deadline != null)
			{
				DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date = fmt.parse(deadline);
					job.setDeadline(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			job.setAddress(address);
			if(num != null)
				job.setNum(Integer.parseInt(num));
			if(sex != null)
				job.setSex(Integer.parseInt(sex));
			if(height != null)
				job.setHeight(Float.parseFloat(height));
			if(health != null)
				job.setHealth(Integer.parseInt(health));
			if(interview != null)
				job.setInterview(Integer.parseInt(interview));
			job.setInterviewaddr(interviewaddr);
			job.setInterviewtime(interviewtime);
			job.setJobContent(jobContent);
			if(worktimetype != null)
				job.setWorktimetype(Integer.parseInt(worktimetype));
			
			if(areaid != null)
			{
				Area area = new Area();
				area.setCode(Long.parseLong(areaid));
				job.setArea(area);
			}
			
			jobDetailService.saveJob(job,Long.parseLong(enterid));
			
			if(!(job.getWorktimetype() == 1))
			{
				 String[] sarr = dates.split(",");
				 for(int i = 0;i<sarr.length;++i)
				 {
					 JobDate jobDate = new JobDate();
					 jobDate.setNum(Integer.parseInt(num));
					 
					 DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
					 try {
						 Date date = fmt.parse(sarr[i]);
						 SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						 String dateStr = f.format(date);
						 Timestamp ts = Timestamp.valueOf(dateStr);
						 jobDate.setWorkdate(ts);
					 } catch (ParseException e) {
							// TODO Auto-generated catch block
						 e.printStackTrace();
					 }
					 jobDate.setJobDetail(job);
					 jobDetailService.saveJobDate(jobDate);
				 }
			}
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), null,"发布成功！");
		}
		
		return null;
	}

}
