package serviceImp;

import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IUserAccountDAO;
import daoImp.IUserJobLongDAO;
import daoImp.IUserJobShortDAO;

public interface IRegistrationService {

	public abstract IJobDetailDAO getJobDetailDAO();

	public abstract void setJobDetailDAO(IJobDetailDAO jobDetailDAO);

	public abstract IUserAccountDAO getUserAccountDAO();

	public abstract void setUserAccountDAO(IUserAccountDAO userAccountDAO);

	public abstract IUserJobLongDAO getUserJobLongDAO();

	public abstract void setUserJobLongDAO(IUserJobLongDAO userJobLongDAO);

	public abstract IUserJobShortDAO getUserJobShortDAO();

	public abstract void setUserJobShortDAO(IUserJobShortDAO userJobShortDAO);

	public abstract String registrationLong(long jobId, long userId);
	
	public abstract String registrationShort(long jobId,long userId,String workDate);
	
	public abstract IJobDateDAO getJobDateDAO();
	
	public abstract void setJobDateDAO(IJobDateDAO jobDateDAO);

}