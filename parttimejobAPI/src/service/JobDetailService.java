package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import model.UserJobShort;

import daoImp.IEnterpriseInfoDAO;
import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IUserJobLongDAO;
import daoImp.IUserJobShortDAO;

public class JobDetailService implements IJobDetailService {
	
	private IJobDetailDAO jobDetailDAO;
	private IUserJobLongDAO userJobLongDAO;
	private IEnterpriseInfoDAO enterpriseInfoDAO;
	private IUserJobShortDAO userJobShortDAO;
	private IJobDateDAO jobDateDAO;
	
	
	public IJobDateDAO getJobDateDAO() {
		return jobDateDAO;
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
	
	public void saveJob(JobDetail job)
	{
		
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
		return jobDetail.getNum() - num;
	}

}
