package serviceImp;

import java.util.List;

import model.School;
import daoImp.ISchoolDAO;

public interface IGetSchoolService {

	public abstract ISchoolDAO getSchoolDAO();

	public abstract void setSchoolDAO(ISchoolDAO schoolDAO);

	public abstract List getAllSchool(long collegeId);

	public abstract School getSchool(long id);

}