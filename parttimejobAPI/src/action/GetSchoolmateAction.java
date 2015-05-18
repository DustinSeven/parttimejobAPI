package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.UserInfo;

import org.apache.struts2.ServletActionContext;

import serviceImp.ISchoolmateService;
import tool.ResultUtil;

public class GetSchoolmateAction {
	
	private ISchoolmateService schoolmateService;
	private long userid;
	private long mobile;
	private String pwd;
	private long parttimeid;
	private int page;
	private int pagesize;
	public ISchoolmateService getSchoolmateService() {
		return schoolmateService;
	}
	public void setSchoolmateService(ISchoolmateService schoolmateService) {
		this.schoolmateService = schoolmateService;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public long getParttimeid() {
		return parttimeid;
	}
	public void setParttimeid(long parttimeid) {
		this.parttimeid = parttimeid;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	public String execute() {
		
		List users = schoolmateService.getSchoolmates(parttimeid, userid);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(int i=0;i<users.size();++i)
		{
			UserInfo userInfo = (UserInfo)users.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", userInfo.getUserid());
			map.put("userimage", userInfo.getImg());
			map.put("sex", userInfo.getSex());
			map.put("account", userInfo.getAccount());
			map.put("mobile", userInfo.getUserAccount().getMobile());
			map.put("department", userInfo.getSchool().getName());
			map.put("enrolltime", null);
			map.put("ota", schoolmateService.getPrivacy(userInfo.getUserid()));
			
			list.add(map);
		}
		
		ResultUtil.returnJsonWithCode200(ServletActionContext.getResponse(), list,"获取成功！");
		
		return null;
	}

}
