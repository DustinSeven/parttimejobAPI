package serviceImp;

import daoImp.IUserSettingDAO;

public interface IUserSettingService {

	public abstract IUserSettingDAO getUserSettingDAO();

	public abstract void setUserSettingDAO(IUserSettingDAO userSettingDAO);

	public abstract int getUserPrivacy(long userId);

	public abstract void setUserPrivacy(int privacy, long userId);

}