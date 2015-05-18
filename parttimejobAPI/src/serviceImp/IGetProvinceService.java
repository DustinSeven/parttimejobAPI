package serviceImp;

import java.util.List;

import model.Province;

import daoImp.IProvinceDAO;

public interface IGetProvinceService {

	public abstract IProvinceDAO getProvinceDAO();

	public abstract void setProvinceDAO(IProvinceDAO provinceDAO);

	public abstract List getAllProvince();
	
	public abstract Province getProvinceById(String provinceId);

}