package serviceImp;

import java.util.List;

import model.JobDate;
import model.JobDetail;

import org.hibernate.Session;

import daoImp.IEnterpriseInfoDAO;
import daoImp.IJobDateDAO;
import daoImp.IJobDetailDAO;
import daoImp.IUserJobLongDAO;

public interface IJobDetailService {

	public abstract IJobDetailDAO getJobDetailDAO();

	public abstract void setJobDetailDAO(IJobDetailDAO jobDetailDAO);

	public abstract List getJobDetailList(int page,int pageSize,int sex,String type,long areaId,String keyword);
	
	public abstract int getRemainingLong(long id);
	
	public abstract void setUserJobDAO(IUserJobLongDAO userJobDAO);
	
	public abstract IUserJobLongDAO getUserJobDAO();
	
	public abstract JobDetail getJobDetailById(long id);
	
	public abstract boolean getEnroll(long jobId,long userId);
	
	public abstract String getConpany(long enterpriseId);
	
	public abstract IEnterpriseInfoDAO getEnterpriseInfoDAO();
	
	public abstract void setEnterpriseInfoDAO(IEnterpriseInfoDAO enterpriseInfoDAO);
	
	public abstract boolean getLongEnroll(long jobId,long userId);
	
	public abstract IUserJobLongDAO getUserJobLongDAO();
	
	public abstract void setUserJobLongDAO(IUserJobLongDAO userJobLongDAO);
	
	public abstract IJobDateDAO getJobDateDAO();
	
	public abstract void setJobDateDAO(IJobDateDAO jobDateDAO);
	
	public abstract List getShortDate(long jobId,long userId);
	
	public abstract int getRemainingShort(long id);
	
	public abstract void saveJob(JobDetail job,long userId);
	
	public abstract void saveJobDate(JobDate jobDate);
	
	public abstract List getJobDetailList(int page,int pageSize,long enterId);
	
	public abstract int getNumShort(long id);
	
	public abstract void updateJob(JobDetail job);
	
	public abstract List getShortDate(long jobId);
	
	public abstract void updateJobDate(long jobDateId,int num);
	
	public abstract List getLongRegiUser(long jobId);
	
	public abstract List getShortRegiUser(long jobId);
	
	public abstract void deleteUserJobShort(long userJobId);
	
	public abstract void deleteUserJobLong(long userJobId);
	
	public abstract String signLong(long userId,long jobId);
	
	public abstract String signShort(long userId,long jobId);

}