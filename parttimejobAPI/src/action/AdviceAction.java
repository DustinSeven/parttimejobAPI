package action;

import org.apache.struts2.ServletActionContext;

import serviceImp.IAdviceService;
import tool.ResultUtil;

public class AdviceAction {
	
	private long userid;
	private String content;
	private IAdviceService adviceService;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public IAdviceService getAdviceService() {
		return adviceService;
	}
	public void setAdviceService(IAdviceService adviceService) {
		this.adviceService = adviceService;
	}
	
	public String execute() {
		
		adviceService.saveAdvice(userid, content);
		
		ResultUtil.returnJsonWithCode200(
				ServletActionContext.getResponse(), null, "ÍÂ²Û³É¹¦£¡");
		
		return null;
	}

}
