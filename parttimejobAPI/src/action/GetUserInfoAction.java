package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import serviceImp.IGetAreaService;
import serviceImp.IGetCityService;
import serviceImp.IGetCollegeService;
import serviceImp.IGetProvinceService;
import serviceImp.IGetSchoolService;
import serviceImp.ILoginService;
import serviceImp.IUserInfoService;
import tool.ResultUtil;

import model.UserAccount;
import model.UserInfo;

public class GetUserInfoAction {
	
	private IUserInfoService getUserInfoService;
	private ILoginService loginService;
	private long userid;
	private String mobile;
	private String password;

	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public IUserInfoService getGetUserInfoService() {
		return getUserInfoService;
	}
	public void setGetUserInfoService(IUserInfoService getUserInfoService) {
		this.getUserInfoService = getUserInfoService;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userId) {
		this.userid = userId;
	}
	
	public String execute() {
		
		UserAccount tmpAccount = new UserAccount();
		tmpAccount.setMobile(mobile);
		tmpAccount.setPassword(password);
		
		String result = loginService.checkAccount(tmpAccount);
		Map<String, Object> map = new HashMap<String, Object>();

		if(result.equals("password wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"密码错误！");
		else if(result.equals("mobile wrong"))
			ResultUtil.returnJsonWithCode500(ServletActionContext.getResponse(), null,"用户账号不存在！");
		else
		{
			UserInfo tmpInfo = getUserInfoService.getUserInfo(userid);
			if(tmpInfo != null)
			{
				map.put("id", tmpInfo.getUserid());
				map.put("account", tmpInfo.getAccount());
				map.put("mobile", mobile);
				map.put("password", password);
				map.put("sex", tmpInfo.getSex());
				map.put("remark", tmpInfo.getRemark());
				if(tmpInfo.getCollege()!=null)
				{
					map.put("collegeid", tmpInfo.getCollege().getId());
					map.put("collegename", tmpInfo.getCollege().getName());
				}
				map.put("userimage", tmpInfo.getImg());
				map.put("qq", tmpInfo.getQq());
				if(tmpInfo.getProvince()!=null)
				{
					map.put("provinceid", tmpInfo.getProvince().getCode());
					map.put("province", tmpInfo.getProvince().getName());
				}
				if(tmpInfo.getCity()!=null)
				{
					map.put("cityid", tmpInfo.getCity().getCode());
					map.put("cityname", tmpInfo.getCity().getName());
				}
				if(tmpInfo.getArea()!=null)
				{
					map.put("areaid", tmpInfo.getArea().getCode());
					map.put("areaname", tmpInfo.getArea().getName());
				}
				map.put("schoolyear", tmpInfo.getSchoolyear());
				if(tmpInfo.getSchool()!=null)
				{
					map.put("departmentid", tmpInfo.getSchool().getId());
					map.put("department", tmpInfo.getSchool().getName());
				}
				
				map.put("specialty", tmpInfo.getSpecialty());
			}
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			list.add(map);
			ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"登陆成功！");
		}

		return null;
	}
	
	

}
