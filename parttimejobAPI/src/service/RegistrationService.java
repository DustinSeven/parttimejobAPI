package service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import serviceImp.IRegistrationService;

import model.JobDate;
import model.JobDetail;
import model.UserAccount;
import model.UserJobLong;
import model.UserJobShort;
import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IUserAccountDAO;
import daoImp.IUserJobLongDAO;
import daoImp.IUserJobShortDAO;

public class RegistrationService implements IRegistrationService {
	
	private IUserJobLongDAO userJobLongDAO;
	private IUserJobShortDAO userJobShortDAO;
	private IUserAccountDAO userAccountDAO;
	private IJobDetailDAO jobDetailDAO;
	private IJobDateDAO jobDateDAO;
	
	
	public IJobDateDAO getJobDateDAO() {
		return jobDateDAO;
	}
	public void setJobDateDAO(IJobDateDAO jobDateDAO) {
		this.jobDateDAO = jobDateDAO;
	}
	/* (non-Javadoc)
	 * @see service.IRegistrationService#getJobDetailDAO()
	 */
	@Override
	public IJobDetailDAO getJobDetailDAO() {
		return jobDetailDAO;
	}
	/* (non-Javadoc)
	 * @see service.IRegistrationService#setJobDetailDAO(daoImp.IJobDetailDAO)
	 */
	@Override
	public void setJobDetailDAO(IJobDetailDAO jobDetailDAO) {
		this.jobDetailDAO = jobDetailDAO;
	}
	/* (non-Javadoc)
	 * @see service.IRegistrationService#getUserAccountDAO()
	 */
	@Override
	public IUserAccountDAO getUserAccountDAO() {
		return userAccountDAO;
	}
	/* (non-Javadoc)
	 * @see service.IRegistrationService#setUserAccountDAO(daoImp.IUserAccountDAO)
	 */
	@Override
	public void setUserAccountDAO(IUserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}
	/* (non-Javadoc)
	 * @see service.IRegistrationService#getUserJobLongDAO()
	 */
	@Override
	public IUserJobLongDAO getUserJobLongDAO() {
		return userJobLongDAO;
	}
	/* (non-Javadoc)
	 * @see service.IRegistrationService#setUserJobLongDAO(daoImp.IUserJobLongDAO)
	 */
	@Override
	public void setUserJobLongDAO(IUserJobLongDAO userJobLongDAO) {
		this.userJobLongDAO = userJobLongDAO;
	}
	/* (non-Javadoc)
	 * @see service.IRegistrationService#getUserJobShortDAO()
	 */
	@Override
	public IUserJobShortDAO getUserJobShortDAO() {
		return userJobShortDAO;
	}
	/* (non-Javadoc)
	 * @see service.IRegistrationService#setUserJobShortDAO(daoImp.IUserJobShortDAO)
	 */
	@Override
	public void setUserJobShortDAO(IUserJobShortDAO userJobShortDAO) {
		this.userJobShortDAO = userJobShortDAO;
	}
	
	/* (non-Javadoc)
	 * @see service.IRegistrationService#registrationLong(long, long)
	 */
	@Override
	public String registrationLong(long jobId,long userId)
	{
		JobDetail jobDetail = jobDetailDAO.findById(jobId);
		UserAccount user = userAccountDAO.findById(userId);
		UserJobLong userJobLong = new UserJobLong();
		userJobLong.setJobDetail(jobDetail);
		userJobLong.setUserAccount(user);
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = f.format(date);
		Timestamp ts = Timestamp.valueOf(dateStr);
		userJobLong.setCreatetime(ts);
		
		userJobLongDAO.save(userJobLong);
		
		return jobDetail.getEnterpriseAccount().getMobile();
	}
	
	public String registrationShort(long jobId,long userId,String workDate)
	{
		String[] workDates = workDate.split(",");
		JobDetail jobDetail = jobDetailDAO.findById(jobId);
		UserAccount user = userAccountDAO.findById(userId);
		for(int i=0;i<workDates.length;++i)
		{
			JobDate jobDate = null;
			List jobDates = jobDateDAO.findByProperty("jobDetail", jobDetail);
			for(int j=0;j<jobDates.size();++j)
			{
				JobDate tmpDate = (JobDate)jobDates.get(j);
				DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		        String dateStr = format.format(tmpDate.getWorkdate());
				if(dateStr.equals(workDates[i]))
				{
					jobDate = tmpDate;
					break;
				}
			}
			UserJobShort userJobShort = new UserJobShort();
			userJobShort.setJobDate(jobDate);
			userJobShort.setUserAccount(user);
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = f.format(date);
			Timestamp ts = Timestamp.valueOf(dateStr);
			userJobShort.setCreatetime(ts);
			userJobShortDAO.save(userJobShort);
		}
		return jobDetail.getEnterpriseAccount().getMobile();
	}

}
