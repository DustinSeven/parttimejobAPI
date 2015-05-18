package serviceImp;

import java.util.List;

import daoImp.IJobTypeDAO;

public interface IJobTypeService {

	public abstract IJobTypeDAO getJobTypeDAO();

	public abstract void setJobTypeDAO(IJobTypeDAO jobTypeDAO);

	public abstract List getAllJobTyop();

}