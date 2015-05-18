package tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ResultUtil {
	
	private static void toJson(HttpServletResponse response,Object data)throws IOException
	{
		Gson gson = new Gson();
		String result = gson.toJson(data);
		response.setContentType("text/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache"); // È¡Ïûä¯ÀÀÆ÷»º´æ
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}
	
	public static void returnJsonWithCode200(HttpServletResponse response, List<Map<String, Object>> maps,String message)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 200);
		result.put("message", message);
		result.put("data", maps);
		try {
			toJson(response,result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void returnJsonWithCode500(HttpServletResponse response,  List<Map<String, Object>> maps,String message){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 500);
		result.put("message", message);
		result.put("data", maps);
		try {
			toJson(response,result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void returnJsonWithCode300(HttpServletResponse response,  List<Map<String, Object>> maps,String message){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 300);
		result.put("message", message);
		result.put("data", maps);
		try {
			toJson(response,result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}