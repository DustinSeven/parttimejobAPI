package serviceImp;

import java.util.List;

import model.City;

import daoImp.ICityDAO;

public interface IGetCityService {

	public abstract ICityDAO getCityDAO();

	public abstract void setCityDAO(ICityDAO cityDAO);

	public abstract List getCity(long pcode);
	
	public abstract City getCityById(String cityCode);

}