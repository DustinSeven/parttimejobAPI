package serviceImp;

import java.util.List;

import model.Area;

import daoImp.IAreaDAO;

public interface IGetAreaService {

	public abstract IAreaDAO getAreaDAO();

	public abstract void setAreaDAO(IAreaDAO areaDAO);

	public abstract List getArea(long ccode);
	
	public abstract Area getAreaById(String areaCode);

}