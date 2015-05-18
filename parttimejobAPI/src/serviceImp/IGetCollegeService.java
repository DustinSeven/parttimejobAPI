package serviceImp;

import java.util.List;

import model.College;
import daoImp.ICollegeDAO;

public interface IGetCollegeService {

	public abstract ICollegeDAO getCollegeDAO();

	public abstract void setCollegeDAO(ICollegeDAO collegeDAO);

	public abstract College getCollegeById(long collegeId);

	public abstract List getCollege(long provinceId);

}