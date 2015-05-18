package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import serviceImp.IMyRegistrationService;

import model.JobDate;
import model.JobDetail;
import model.UserAccount;
import model.UserJobLong;
import model.UserJobLongSignin;
import model.UserJobShort;

import dao.IUserJobLongSigninDAO;
import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IUserAccountDAO;
import daoImp.IUserJobLongDAO;
import daoImp.IUserJobShortDAO;

public class MyRegistrationService implements IMyRegistrationService {
	
	private IUserJobLongDAO userJobLongDAO;
	private IUserJobShortDAO userJobShortDAO;
	private IUserAccountDAO userAccountDAO;
	private IJobDetailDAO jobDetailDAO;
	private IJobDateDAO jobDateDAO;
	private IUserJobLongSigninDAO userJobLongSigninDAO;
	
	
	public IUserJobLongSigninDAO getUserJobLongSigninDAO() {
		return userJobLongSigninDAO;
	}
	public void setUserJobLongSigninDAO(IUserJobLongSigninDAO userJobLongSigninDAO) {
		this.userJobLongSigninDAO = userJobLongSigninDAO;
	}
	public IJobDateDAO getJobDateDAO() {
		return jobDateDAO;
	}
	public void setJobDateDAO(IJobDateDAO jobDateDAO) {
		this.jobDateDAO = jobDateDAO;
	}
	public IJobDetailDAO getJobDetailDAO() {
		return jobDetailDAO;
	}
	public void setJobDetailDAO(IJobDetailDAO jobDetailDAO) {
		this.jobDetailDAO = jobDetailDAO;
	}
	/* (non-Javadoc)
	 * @see service.IMyRegistrationService#getUserAccountDAO()
	 */
	@Override
	public IUserAccountDAO getUserAccountDAO() {
		return userAccountDAO;
	}
	/* (non-Javadoc)
	 * @see service.IMyRegistrationService#setUserAccountDAO(daoImp.IUserAccountDAO)
	 */
	@Override
	public void setUserAccountDAO(IUserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}
	/* (non-Javadoc)
	 * @see service.IMyRegistrationService#getUserJobLongDAO()
	 */
	@Override
	public IUserJobLongDAO getUserJobLongDAO() {
		return userJobLongDAO;
	}
	/* (non-Javadoc)
	 * @see service.IMyRegistrationService#setUserJobLongDAO(daoImp.IUserJobLongDAO)
	 */
	@Override
	public void setUserJobLongDAO(IUserJobLongDAO userJobLongDAO) {
		this.userJobLongDAO = userJobLongDAO;
	}
	/* (non-Javadoc)
	 * @see service.IMyRegistrationService#getUserJobShortDAO()
	 */
	@Override
	public IUserJobShortDAO getUserJobShortDAO() {
		return userJobShortDAO;
	}
	/* (non-Javadoc)
	 * @see service.IMyRegistrationService#setUserJobShortDAO(daoImp.IUserJobShortDAO)
	 */
	@Override
	public void setUserJobShortDAO(IUserJobShortDAO userJobShortDAO) {
		this.userJobShortDAO = userJobShortDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IMyRegistrationService#getMyRegistration(long)
	 */
	@Override
	public List getMyRegistration(long userId)
	{
		List jobs = new ArrayList();
		UserAccount user = userAccountDAO.findById(userId);
		List userJobLongs = userJobLongDAO.findByProperty("userAccount", user);
		for(int i=0;i<userJobLongs.size();++i)
		{
			UserJobLong tmpUserJob = (UserJobLong)userJobLongs.get(i);
			jobs.add(tmpUserJob.getJobDetail());
		}
		List userJobShorts = userJobShortDAO.findByProperty("userAccount", user);
		for(int i=0;i<userJobShorts.size();++i)
		{
			UserJobShort tmpUserJob = (UserJobShort)userJobShorts.get(i);
			if(!jobs.contains(tmpUserJob.getJobDate().getJobDetail()))
				jobs.add(tmpUserJob.getJobDate().getJobDetail());
		}
		
		return jobs;
	}
	
	public List getMyRegistrationDetail(long userId,long jobId)
	{
		System.out.println("11111111");
		List results = new ArrayList();
		JobDetail jobDetail = jobDetailDAO.findById(jobId);
		UserAccount user = userAccountDAO.findById(userId);
		if(jobDetail.getWorktimetype() == 1)
		{
			System.out.println("22222222");
			boolean isExist = false;
			List userJobLongSignins = userJobLongSigninDAO.findByProperty("userAccount", user);
			for(int i = 0;i<userJobLongSignins.size();++i)
			{
				System.out.println("333333");
				UserJobLongSignin userJobLongSignin = (UserJobLongSignin)userJobLongSignins.get(i);
				System.out.println(userJobLongSignin.getJobDetail().getJobid());
				if(userJobLongSignin.getJobDetail().getJobid() == jobId)
				{
					System.out.println("444444");
					Map<String , Object>map = new HashMap<String,Object>();
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			        String dataStr = format.format(userJobLongSignin.getCreatetime());
					map.put("workdate",dataStr);
					map.put("message", "已签到");
					results.add(map);
					isExist = true;
				}
			}
			if(!isExist)
			{
				System.out.println("555555");
				Map<String , Object>map = new HashMap<String,Object>();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		        String dataStr = format.format(jobDetail.getDeadline());
				map.put("workdate",dataStr + "开始兼职");
				map.put("message", "未曾签到");
				results.add(map);
			}
		}
		else
		{
			List userJobShorts = userJobShortDAO.findByProperty("userAccount", user);
			for(int i = 0;i<userJobShorts.size();++i)
			{
				UserJobShort userJobShort = (UserJobShort)userJobShorts.get(i);
				if(userJobShort.getJobDate().getJobDetail().getJobid() == jobId)
				{
					Map<String , Object>map = new HashMap<String,Object>();
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			        String dataStr = format.format(userJobShort.getJobDate().getWorkdate());
					map.put("workdate",dataStr);
					map.put("message", userJobShort.getSignin() == 0? "未签到":"已签到");
					results.add(map);
				}
			}
			
		}
		
		
		return results;
	}

}
