package serviceImp;

import java.util.List;

import dao.IUserJobLongSigninDAO;
import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IUserAccountDAO;
import daoImp.IUserJobLongDAO;
import daoImp.IUserJobShortDAO;

public interface IMyRegistrationService {

	public abstract IUserAccountDAO getUserAccountDAO();

	public abstract void setUserAccountDAO(IUserAccountDAO userAccountDAO);

	public abstract IUserJobLongDAO getUserJobLongDAO();

	public abstract void setUserJobLongDAO(IUserJobLongDAO userJobLongDAO);

	public abstract IUserJobShortDAO getUserJobShortDAO();

	public abstract void setUserJobShortDAO(IUserJobShortDAO userJobShortDAO);

	public abstract List getMyRegistration(long userId);
	
	public abstract IJobDetailDAO getJobDetailDAO();
	
	public abstract void setJobDetailDAO(IJobDetailDAO jobDetailDAO);
	
	public abstract List getMyRegistrationDetail(long userId,long jobId);
	
	public abstract IJobDateDAO getJobDateDAO();
	
	public abstract void setJobDateDAO(IJobDateDAO jobDateDAO);
	
	public abstract IUserJobLongSigninDAO getUserJobLongSigninDAO();
	
	public abstract void setUserJobLongSigninDAO(IUserJobLongSigninDAO userJobLongSigninDAO);

}