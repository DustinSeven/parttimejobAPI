package service;

import java.util.ArrayList;
import java.util.List;

import serviceImp.ISchoolmateService;

import model.JobDate;
import model.JobDetail;
import model.UserInfo;
import model.UserJobLong;
import model.UserJobShort;
import model.UserSetting;

import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IUserInfoDAO;
import daoImp.IUserJobLongDAO;
import daoImp.IUserJobShortDAO;
import daoImp.IUserSettingDAO;

public class SchoolmateService implements ISchoolmateService {
	
	private IUserJobLongDAO userJobLongDAO;
	private IUserInfoDAO userInfoDAO;
	private IUserSettingDAO userSettingDAO;
	private IJobDetailDAO jobDetailDAO;
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
	public IJobDetailDAO getJobDetailDAO() {
		return jobDetailDAO;
	}
	public void setJobDetailDAO(IJobDetailDAO jobDetailDAO) {
		this.jobDetailDAO = jobDetailDAO;
	}
	public IUserSettingDAO getUserSettingDAO() {
		return userSettingDAO;
	}
	public void setUserSettingDAO(IUserSettingDAO userSettingDAO) {
		this.userSettingDAO = userSettingDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.ISchoolmateService#getUserInfoDAO()
	 */
	@Override
	public IUserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}
	/* (non-Javadoc)
	 * @see service.ISchoolmateService#setUserInfoDAO(daoImp.IUserInfoDAO)
	 */
	@Override
	public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.ISchoolmateService#getSchoolmates(long, long)
	 */
	@Override
	public List getSchoolmates(long jobId,long userId)
	{
		List users = new ArrayList();
		JobDetail job = jobDetailDAO.findById(jobId);
		if(job.getWorktimetype() == 1)
		{
			List userJobs = userJobLongDAO.findByProperty("jobDetail", job);
			UserInfo self = userInfoDAO.findById(userId);
			if(self.getCollege() == null)
				return users;
			for(int i=0;i<userJobs.size();++i)
			{
				UserJobLong userJob = (UserJobLong)userJobs.get(i);
				UserInfo userInfo = userInfoDAO.findById(userJob.getUserAccount().getUserid());
				if((self.getCollege().getId()==userInfo.getCollege().getId()) && (self.getUserid()!=userInfo.getUserid()))
				{
					users.add(userInfo);
				}
			}
		}
		else
		{
			List jobDates = jobDateDAO.findByProperty("jobDetail", job);
			for(int i=0;i<jobDates.size();++i)
			{
				JobDate jobDate = (JobDate)jobDates.get(i);
				List userJobs = userJobShortDAO.findByProperty("jobDate", jobDate);
				UserInfo self = userInfoDAO.findById(userId);
				if(self.getCollege() == null)
					return users;
				for(int j=0;j<userJobs.size();++j)
				{
					UserJobShort userJob = (UserJobShort)userJobs.get(j);
					UserInfo userInfo = userInfoDAO.findById(userJob.getUserAccount().getUserid());
					if((self.getCollege().getId()==userInfo.getCollege().getId()) && (self.getUserid()!=userInfo.getUserid()) && !users.contains(userInfo))
					{
//						boolean isExists = false;
//						for(int l=0;l<users.size();++l)
//						{
//							UserInfo tmpUser = (UserInfo)users.get(l);
//							if(tmpUser.getUserid() == userInfo.getUserid())
//							{
//								isExists = true;
//								break;
//							}
//						}
//						if(!isExists)
							users.add(userInfo);
					}
				}
			}
		}
		
		return users;
	}
	
	public int getPrivacy(long userId)
	{
		System.out.print(userSettingDAO);
		UserSetting userSetting = userSettingDAO.findById(userId);
		System.out.print(userSetting.toString());
		return userSetting.getPrivacy();
	}

}
