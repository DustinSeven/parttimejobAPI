package service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import serviceImp.IJobDetailService;

import model.EnterpriseInfo;
import model.JobDate;
import model.JobDetail;
import model.UserAccount;
import model.UserJobLong;
import model.UserJobLongSignin;
import model.UserJobShort;

import daoImp.IAreaDAO;
import daoImp.IEnterpriseAccountDAO;
import daoImp.IEnterpriseInfoDAO;
import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IJobTypeDAO;
import daoImp.IPayCountTypeDAO;
import daoImp.IPayUnitDAO;
import daoImp.IUserInfoDAO;
import daoImp.IUserJobLongDAO;
import daoImp.IUserJobLongSigninDAO;
import daoImp.IUserJobShortDAO;

public class JobDetailService implements IJobDetailService {
	
	private IJobDetailDAO jobDetailDAO;
	private IUserJobLongDAO userJobLongDAO;
	private IEnterpriseInfoDAO enterpriseInfoDAO;
	private IUserJobShortDAO userJobShortDAO;
	private IJobDateDAO jobDateDAO;
	private IUserJobLongSigninDAO userJobLongSigninDAO;
	private IUserInfoDAO userInfoDAO;
	
//	private IPayUnitDAO payUnitDAO;
//	private IJobTypeDAO jobTypeDAO;
//	private IPayCountTypeDAO payCountTypeDAO;
//	private IEnterpriseAccountDAO enterpriseAccountDAO;
//	private IAreaDAO areaDAO;
	
	
	public IJobDateDAO getJobDateDAO() {
		return jobDateDAO;
	}

	public IUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	public IUserJobLongSigninDAO getUserJobLongSigninDAO() {
		return userJobLongSigninDAO;
	}

	public void setUserJobLongSigninDAO(IUserJobLongSigninDAO userJobLongSigninDAO) {
		this.userJobLongSigninDAO = userJobLongSigninDAO;
	}

	public void setJobDateDAO(IJobDateDAO jobDateDAO) {
		this.jobDateDAO = jobDateDAO;
	}

	public IUserJobLongDAO getUserJobLongDAO() {
		return userJobLongDAO;
	}

	public void setUserJobLongDAO(IUserJobLongDAO userJobLongDAO) {
		this.userJobLongDAO = userJobLongDAO;
	}

	public IUserJobShortDAO getUserJobShortDAO() {
		return userJobShortDAO;
	}

	public void setUserJobShortDAO(IUserJobShortDAO userJobShortDAO) {
		this.userJobShortDAO = userJobShortDAO;
	}

	public IEnterpriseInfoDAO getEnterpriseInfoDAO() {
		return enterpriseInfoDAO;
	}

	public void setEnterpriseInfoDAO(IEnterpriseInfoDAO enterpriseInfoDAO) {
		this.enterpriseInfoDAO = enterpriseInfoDAO;
	}

	/* (non-Javadoc)
	 * @see service.IJobDetailService#getJobDetailDAO()
	 */
	@Override
	public IJobDetailDAO getJobDetailDAO() {
		return jobDetailDAO;
	}

	/* (non-Javadoc)
	 * @see service.IJobDetailService#setJobDetailDAO(dao.IJobDetailDAO)
	 */
	@Override
	public void setJobDetailDAO(IJobDetailDAO jobDetailDAO) {
		this.jobDetailDAO = jobDetailDAO;
	}
	
	public IUserJobLongDAO getUserJobDAO() {
		return userJobLongDAO;
	}

	public void setUserJobDAO(IUserJobLongDAO userJobDAO) {
		this.userJobLongDAO = userJobDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IJobDetailService#getJobDetailList()
	 */
	@Override
	public List getJobDetailList(int page,int pageSize,int sex,String type,long areaId,String keyword)
	{
		JobDetail detail = new JobDetail();
		if(pageSize == 0)
			pageSize = 10;
		List jobs = jobDetailDAO.findByProperty(page,pageSize,sex,type,areaId,keyword);
		return jobs;
	}
	
	public List getJobDetailList(int page,int pageSize,long enterId)
	{
		JobDetail detail = new JobDetail();
		if(pageSize == 0)
			pageSize = 10;
		List jobs = jobDetailDAO.findByProperty(page,pageSize, enterId);
		return jobs;
	}
	
	public void saveJob(JobDetail job,long userId)
	{
		job.setEnable(1);
		job.setOverdue(0);
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = f.format(date);
		Timestamp ts = Timestamp.valueOf(dateStr);
		job.setCreatetime(ts);
		jobDetailDAO.save(job);
	}
	
	public void saveJobDate(JobDate jobDate)
	{
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = f.format(date);
		Timestamp ts = Timestamp.valueOf(dateStr);
		jobDate.setCreatedate(ts);
		jobDateDAO.save(jobDate);
	}
	
	
	public JobDetail getJobDetailById(long id)
	{
		JobDetail jobDetail = jobDetailDAO.findById(id);
		return jobDetail;
	}

	public int getRemainingLong(long id)
	{
		JobDetail jobDetail = jobDetailDAO.findById(id);
		return jobDetail.getNum() - userJobLongDAO.findByProperty("jobDetail", jobDetail).size();
	}
	
	public boolean getEnroll(long jobId,long userId)
	{
		JobDetail jobDetail = jobDetailDAO.findById(jobId);
		List res = userJobLongDAO.findByProperty("jobDetail", jobDetail);
		for(int i =0;i<res.size();++i)
		{
			UserJobLong userJob = (UserJobLong)res.get(i);
			if(userJob.getUserAccount().getUserid() == userId)
				return true;
		}
		return false;
	}
	
	public String getConpany(long enterpriseId)
	{
		EnterpriseInfo enterprise = enterpriseInfoDAO.findById(enterpriseId);
		return enterprise.getCompany();
	}
	
	public boolean getLongEnroll(long jobId,long userId)
	{
		JobDetail jobDetail = new JobDetail();
		jobDetail.setJobid(jobId);
		UserAccount user = new UserAccount();
		user.setUserid(userId);
		
		UserJobLong userJob = new UserJobLong();
		userJob.setJobDetail(jobDetail);
		userJob.setUserAccount(user);
		
		if(userJobLongDAO.findByExample(userJob).size() == 0)
		{
//			System.out.println(userJobLongDAO.findByExample(userJob).size() + "sadsadsa");
			return false;
		}
		else
		{
//			System.out.println(userJobLongDAO.findByExample(userJob).size() + "sadsadsa");
			return true;
		}
	}
	
	public List getShortDate(long jobId,long userId)
	{
		List dates = new ArrayList();
		
		JobDetail jobDetail = new JobDetail();
		jobDetail.setJobid(jobId);
		List jobDates = jobDateDAO.findByProperty("jobDetail", jobDetail);
		for(int i=0;i<jobDates.size();++i)
		{
			JobDate jobDate = (JobDate)jobDates.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	        String dataStr = format.format(jobDate.getWorkdate());
			map.put("workdate", dataStr);
			
			List userJobs = userJobShortDAO.findByProperty("jobDate", jobDate);
			
			int enroll = jobDate.getNum() - userJobs.size();
			map.put("full", enroll <= 0?1:0);

			boolean isEnroll = false;
			for(int j=0;j<userJobs.size();++j)
			{
				UserJobShort userJob = (UserJobShort)userJobs.get(j);
				if(userJob.getUserAccount().getUserid() == userId)
				{
					isEnroll = true;
					break;
				}
			}
			if(isEnroll)
				map.put("userenroll", 1);
			else
				map.put("userenroll", 0);
			dates.add(map);
		}
		
		return dates;
	}
	
	public List getShortDate(long jobId)
	{
		List dates = new ArrayList();
		
		JobDetail jobDetail = new JobDetail();
		jobDetail.setJobid(jobId);
		List jobDates = jobDateDAO.findByProperty("jobDetail", jobDetail);
		for(int i=0;i<jobDates.size();++i)
		{
			JobDate jobDate = (JobDate)jobDates.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("jobdateid",String.valueOf(jobDate.getJobdateid()));
			DateFormat format = new SimpleDateFormat("MM月dd日");
	        String dataStr = format.format(jobDate.getWorkdate());
			map.put("workdate", dataStr);
			
			List userJobs = userJobShortDAO.findByProperty("jobDate", jobDate);
			map.put("remaining", jobDate.getNum() - userJobs.size());
			map.put("num", jobDate.getNum());

			dates.add(map);
		}
		
		return dates;
	}
	
	public int getNumShort(long id)
	{
		JobDetail jobDetail = jobDetailDAO.findById(id);
		List jobDates = jobDateDAO.findByProperty("jobDetail", jobDetail);
		
		int num = jobDetail.getNum() * jobDates.size();
		return num;
	}
	
	public int getRemainingShort(long id)
	{
		JobDetail jobDetail = jobDetailDAO.findById(id);
		List jobDates = jobDateDAO.findByProperty("jobDetail", jobDetail);
		
		int num = 0;
		for(int i=0;i<jobDates.size();++i)
		{
			JobDate jobDate = (JobDate)jobDates.get(i);
			List userJobs = userJobShortDAO.findByProperty("jobDate", jobDate);
			num += userJobs.size();
		}
		return this.getNumShort(id) - num;
	}
	
	public void updateJob(JobDetail job)
	{
		jobDetailDAO.attachDirty(job);
	}
	
	public void updateJobDate(long jobDateId,int num)
	{
		JobDate jobDate = jobDateDAO.findById(jobDateId);
		System.out.println(jobDate);
		jobDate.setNum(num);
		jobDateDAO.attachDirty(jobDate);
	}
	
	public List getLongRegiUser(long jobId)
	{
		List list = new ArrayList();
		JobDetail job = new JobDetail();
		job.setJobid(jobId);
		List jobList = userJobLongDAO.findByProperty("jobDetail", job);
		for(int i=0;i<jobList.size();++i)
		{
			UserJobLong userJob = (UserJobLong) jobList.get(i);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", userInfoDAO.findById(userJob.getUserAccount().getUserid()).getAccount());
			map.put("mobile", userJob.getUserAccount().getMobile());
//			map.put("signin", userJob.getSignin());
			UserJobLongSignin sign = new UserJobLongSignin();
			sign.setJobDetail(job);
			sign.setUserAccount(userJob.getUserAccount());
			List signLong = userJobLongSigninDAO.findByExample(sign);
			boolean isSign = false;
			if(signLong.size() != 0)
			{
				for(int j=0;j<signLong.size();++j)
				{
					
					UserJobLongSignin tmpS = (UserJobLongSignin) signLong.get(j);
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
					if(df.format(new Date()).endsWith(df.format(tmpS.getCreatetime())))
					{
						map.put("signin", 1);
						isSign = true;
						break;
					}
				}
			}
			if(!isSign)
				map.put("signin", 0);
			map.put("school", userInfoDAO.findById(userJob.getUserAccount().getUserid()).getCollege().getName());
			map.put("id", userJob.getUserAccount().getUserid());
			map.put("img", userInfoDAO.findById(userJob.getUserAccount().getUserid()).getImg());
			map.put("sex", userInfoDAO.findById(userJob.getUserAccount().getUserid()).getSex());
			map.put("userjobid", String.valueOf(userJob.getId()));
			
			list.add(map);
		}
		
		return list;
	}
	
	public List getShortRegiUser(long jobId)
	{
		List list = new ArrayList();
		JobDetail job = new JobDetail();
		job.setJobid(jobId);
		List jobDates = jobDateDAO.findByProperty("jobDetail", job);
		for(int i=0;i<jobDates.size();++i)
		{
			JobDate date = (JobDate)jobDates.get(i);
			List userJobs = userJobShortDAO.findByProperty("jobDate", date);
			List userJobList = new ArrayList();
			for(int j=0;j<userJobs.size();++j)
			{
				UserJobShort userJob = (UserJobShort)userJobs.get(j);
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", userInfoDAO.findById(userJob.getUserAccount().getUserid()).getAccount());
				map.put("mobile", userJob.getUserAccount().getMobile());
				map.put("signin", userJob.getSignin());
				map.put("school", userInfoDAO.findById(userJob.getUserAccount().getUserid()).getCollege().getName());
				map.put("id", userJob.getUserAccount().getUserid());
				map.put("img", userInfoDAO.findById(userJob.getUserAccount().getUserid()).getImg());
				map.put("sex", userInfoDAO.findById(userJob.getUserAccount().getUserid()).getSex());
				map.put("userjobid", String.valueOf(userJob.getUserjobid()));
				
				userJobList.add(map);
			}
			
			Map<String, Object> map = new HashMap<String, Object>();
			DateFormat format = new SimpleDateFormat("MM月dd日");
	        String dataStr = format.format(date.getWorkdate());
			map.put("date", dataStr);
			map.put("userjobs", userJobList);
			list.add(map);
		}
		
		return list;
	}
	
	public void deleteUserJobLong(long userJobId)
	{
		UserJobLong userJob = userJobLongDAO.findById(userJobId);
		if(userJob!=null)
			userJobLongDAO.delete(userJob);
	}
	
	public void deleteUserJobShort(long userJobId)
	{
		UserJobShort userJob = userJobShortDAO.findById(userJobId);
		if(userJob!=null)
			userJobShortDAO.delete(userJob);
	}
	
	public String signLong(long userId,long jobId)
	{
		UserJobLong userJob = new UserJobLong();
		UserJobLongSignin sign = new UserJobLongSignin();
		
		JobDetail job = new JobDetail();
		job.setJobid(jobId);
		sign.setJobDetail(job);
		userJob.setJobDetail(job);
		
		UserAccount user = new UserAccount();
		user.setUserid(userId);
		sign.setUserAccount(user);
		userJob.setUserAccount(user);
		
		List userJobs = userJobLongDAO.findByExample(userJob);
		boolean isJoin = false;
		for(int i=0;i<userJobs.size();++i)
		{
			UserJobLong ujl = (UserJobLong)userJobs.get(i);
			if(ujl.getJobDetail().getJobid() == jobId && ujl.getUserAccount().getUserid() == userId)
			{
				isJoin = true;
				break;
			}
		}
		if(!isJoin)
			return "nouserjob";
		
		List signLong = userJobLongSigninDAO.findByExample(sign);
		boolean isSign = false;
		if(signLong.size() != 0)
		{
			for(int j=0;j<signLong.size();++j)
			{
				UserJobLongSignin tmpS = (UserJobLongSignin) signLong.get(j);
				if(tmpS.getJobDetail().getJobid() == jobId && tmpS.getUserAccount().getUserid() == userId)
				{
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
					System.out.println(df.format(tmpS.getCreatetime()));
					if(df.format(new Date()).endsWith(df.format(tmpS.getCreatetime())))
					{
						isSign = true;
						break;
					}
				}
			}
		}
		if(isSign)
			return "already";
		
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = f.format(date);
		Timestamp ts = Timestamp.valueOf(dateStr);
		sign.setCreatetime(ts);
		
		userJobLongSigninDAO.save(sign);
		
		return "success";
	}
	
	public String signShort(long userId,long jobId)
	{
		UserJobShort userJob = new UserJobShort();
		
		UserAccount user = new UserAccount();
		user.setUserid(userId);
		userJob.setUserAccount(user);
		
		List userJobs = userJobShortDAO.findByProperty("userAccount", user);
		boolean isJoin = false;
		for(int i=0;i<userJobs.size();++i)
		{
			UserJobShort tmpUJ = (UserJobShort) userJobs.get(i);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
			String dateStr = df.format(new Date());
			if(tmpUJ.getJobDate().getJobDetail().getJobid() == jobId && dateStr.endsWith(df.format(tmpUJ.getJobDate().getWorkdate())))
			{
				isJoin = true;
				if(tmpUJ.getSignin() == 1)
					return "already";
				else
				{
					tmpUJ.setSignin(1);
					userJobShortDAO.attachDirty(tmpUJ);
					return "success";
				}
			}
		}
		
		if(!isJoin)
			return "nouserjob";
		return "fail";
	}
}
