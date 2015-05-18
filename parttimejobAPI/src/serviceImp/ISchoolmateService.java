package serviceImp;

import java.util.List;

import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IUserInfoDAO;
import daoImp.IUserJobLongDAO;
import daoImp.IUserJobShortDAO;
import daoImp.IUserSettingDAO;

public interface ISchoolmateService {

	public abstract IUserInfoDAO getUserInfoDAO();

	public abstract void setUserInfoDAO(IUserInfoDAO userInfoDAO);

	public abstract List getSchoolmates(long jobId, long userId);
	
	public abstract int getPrivacy(long userId);
	
	public abstract IUserSettingDAO getUserSettingDAO();
	
	public abstract void setUserSettingDAO(IUserSettingDAO userSettingDAO);
	
	public abstract IJobDetailDAO getJobDetailDAO();
	
	public abstract void setJobDetailDAO(IJobDetailDAO jobDetailDAO);
	
	public abstract IUserJobLongDAO getUserJobLongDAO();
	
	public abstract void setUserJobLongDAO(IUserJobLongDAO userJobLongDAO);
	
	public abstract IUserJobShortDAO getUserJobShortDAO();
	
	public abstract void setUserJobShortDAO(IUserJobShortDAO userJobShortDAO);
	
	public abstract IJobDateDAO getJobDateDAO();
	
	public abstract void setJobDateDAO(IJobDateDAO jobDateDAO);

}