package action;

import org.apache.struts2.ServletActionContext;

import model.Area;
import model.City;
import model.College;
import model.Province;
import model.School;
import model.UserAccount;
import model.UserInfo;
import serviceImp.ILoginService;
import serviceImp.IUserInfoService;
import tool.ResultUtil;

public class UpdateUserInfoAction 
{
	private long userid;
	private String mobile;
	private String pwd;
	private String account;
	private String qq;
	private String specialty;
	private long provinceid;
	private long cityid;
	private long areaid;
	private long collegeid;
	private long departmentid;
	private int sex;
	private int schoolyears;
	private IUserInfoService userInfoService;
	private ILoginService loginService;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public long getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(long provinceid) {
		this.provinceid = provinceid;
	}
	public long getCityid() {
		return cityid;
	}
	public void setCityid(long cityid) {
		this.cityid = cityid;
	}
	public long getAreaid() {
		return areaid;
	}
	public void setAreaid(long areaid) {
		this.areaid = areaid;
	}
	public long getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(long collegeid) {
		this.collegeid = collegeid;
	}
	public long getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(long departmentid) {
		this.departmentid = departmentid;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getSchoolyears() {
		return schoolyears;
	}
	public void setSchoolyears(int schoolyears) {
		this.schoolyears = schoolyears;
	}
	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	
	public String execute() {
		UserAccount tmpAccount = new UserAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(pwd);
		
		String result = loginService.checkAccount(tmpAccount);

		if(result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"密码错误！");
		else if(result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"用户账号不存在！");
		else
		{
			UserInfo userInfo = userInfoService.getUserInfo(userid);
			if(account != null)
				userInfo.setAccount(account);
			if(qq != null)
				userInfo.setQq(qq);
			if(specialty != null)
				userInfo.setSpecialty(specialty);
			if(provinceid > 0)
			{
				Province province = new Province();
				province.setCode(provinceid);
				userInfo.setProvince(province);
			}
			if(cityid > 0)
			{
				City city = new City();
				city.setCode(cityid);
				userInfo.setCity(city);
			}
			if(areaid > 0)
			{
				Area area = new Area();
				area.setCode(areaid);
				userInfo.setArea(area);
			}
			if(collegeid > 0)
			{
				College college = new College();
				college.setId(collegeid);
				userInfo.setCollege(college);
			}
			if(departmentid > 0)
			{
				School school = new School();
				school.setId(departmentid);
				userInfo.setSchool(school);
			}
			if(sex > 0)
				userInfo.setSex(sex);
			if(schoolyears > 0)
				userInfo.setSchoolyear(schoolyears);
			
			userInfoService.updateUserInfo(userInfo);
			
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), null,"修改成功！");
		}
		
		return null;
	}
}
