package com.itqs.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class PageUtils
{

	/**
	 * 
	 * @author 851286894@qq.com 改良版mygroup_20170928
	 * 
	 * @param request
	 *            request对象,用于传入属性
	 * @param currentPage
	 *            当前的页数
	 * @param pageSize
	 *            每页设定的行数
	 * @param source
	 *            存放了相应数据的集合
	 * @param dataCount
	 *            数据库中共存在多少条数据
	 * 
	 * <br/>
	 * <br/>
	 * <br/>
	 *            <b>note:</b> 该方法只是将jsp中的页面代码进行简化，jsp页面中使用如下el表达式可取出相应的模块 <br/>
	 *            <b>${list}:</b> 数据列表 <br/>
	 *            <b>${first}:</b> 首页 超链接 <br/>
	 *            <b>${prev}:</b> 上一页 超链接 <br/>
	 *            <b>${next}:</b> 下一页 超链接 <br/>
	 *            <b>${End}:</b> 尾页 超链接 <br/>
	 *            <b>${pageNo}:</b> 当前页数 <br/>
	 *            <b>${pageCount}:</b> 总页数 <br/>
	 *            <b>${dataInfo}:</b> 共有?条信息提示 <br/>
	 *            <b>${pageInfo}:</b> 当前处于?/?页信息提示 <br/>
	 *            <b>${group}:</b> 以上六条组合
	 * 
	 * <br/>
	 * <br/>
	 *            <b>note:</b> 因耦合性问题，使用该方法进行简化分页代码时，必须遵循以下命名规范 <br/>
	 *            <b>method:</b> 在JSP中进行功能定义时必须有method参数作为接受和传输功能选择的标识。 <br/>
	 *            <b>list:</b> 在JSP页面取出列表数据时必须使用${list},并且在调用列表功能时必须以list作为标识。 <br/>
	 *            <b>pageSize:</b> 取出每页的数据条数 <br/>
	 *            <b>currentPage:</b> 必须在JSP中使用currentPage作为分页的页码选择标识 <br/>
	 * <br/>
	 *            <b>example-> student.do?method=list&pageNo=1;</b> <br/>
	 * <br/>
	 * <br/>
	 *            可在struts2框架下使用 <br/>
	 * <br/>
	 *            模糊查询时查询字段可以是以query开头的任意词组，可以有任意个查询字段，
	 *            取出该字段值时使用之前设置的query开头的任意词组作为标识
	 **/
	/*
	 * 比如：person表中有100条记录，其中满足条件的记录有50个，每页显示两条满足条件的记录。
	 * 那么形参source：该页的两条满足条件的记录！
	 * 那么形参dataCount:满足条件的记录数！
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void page(HttpServletRequest request, Integer currentPage,
			Integer pageSize, List<?> source, Integer dataCount)
	{
		//currentPage=1
		//pageSize=2
		//source={{2,李四,..},{3,王五,...}}
		//dataCount=3
		String url = request.getRequestURI();//url="/StudentManager/ListServlet"
		//http://localhost:8080/StudentManager/ListServlet?currentPage=1&queryName=zan&queryDeptID=1
		HashMap<String, String> queryMap = new HashMap<String, String>();
		Map parameterMap = request.getParameterMap();//parameterMap={queryName:zan,currentPage=1}
		Set keySet = parameterMap.keySet();//keySet={queryName,currentPage}
		for (Object object : keySet)
		{
			String parameterName = object.toString();//parameterName="queryName" "currentPage"
			String queryValue = request.getParameterValues(parameterName)[0];//queryvalue="zan" "1"
			// System.out.println(queryValue);
			if (parameterName.startsWith("query") && queryValue != null
					&& !queryValue.equals(""))
			{
				queryMap.put(parameterName, queryValue);
			}

		}
		//把queryMap转换为String：
		//queryMap={queryName:zan,querydeptID:1}
		String queryStr = "";
		Set<String> queryNames = queryMap.keySet();//{"queryName","querydeptid"}
		for (String queryName : queryNames)
		{
			queryStr += ("&" + queryName + "=" + queryMap.get(queryName));
			//queryStr="&queryName=zan&querydeptid=1"
		}
		//到这里为止，请求参数：currentPage=1&queryName=zan&queryDeptID=1
		//queryStr="queryName=zan&queryDeptID=1";
		//System.out.println(queryStr);//"&queryName=zan&queryDeptID=1"

		boolean flag = false;
		if (url.contains("!"))
		{
			flag = true;
		}
		//flag=false
		int pageCount = dataCount / pageSize
				+ (dataCount % pageSize == 0 ? 0 : 1);//int，总页面

		String first = "<a href='" + url + "?" + (flag ? "" : "method=list&")
				+ "currentPage=1" + queryStr + "'> 首页   </a>";
		//first=<a href='/StudentManager/ListServlet?method=list&currentPage=1&queryName=zan&queryDeptID=1'> 首页   </a>
		String prev = "<a href='" + url + "?" + (flag ? "" : "method=list&")
				+ "currentPage=1" + queryStr + "'> 上一页  </a>";
		//prev=<a href='/StudentManager/ListServlet?method=list&currentPage=1&queryName=zan&queryDeptID=1'> 上一页  </a>
		String next = "<a href='" + url + "?" + (flag ? "" : "method=list&")
				+ "currentPage=" + pageCount + queryStr + "'> 下一页  </a>";
		//next=<a href='/StudentManager/ListServlet?method=list&currentPage=2&queryName=zan&queryDeptID=1'> 下一页  </a>
		String End = "<a href='" + url + "?" + (flag ? "" : "method=list&")
				+ "currentPage=" + pageCount + queryStr + "'> 尾页  </a>";
		String dataInfo = "<span>共有" + dataCount + "条数据        </span>";
		String pageInfo = "<span>   当前处于第" + currentPage + "/" + pageCount
				+ "页</span>";

		if (currentPage > 1)
		{

			prev = "<a href='" + url + "?" + (flag ? "" : "method=list&")
					+ "currentPage=" + (currentPage - 1) + queryStr
					+ "'> 上一页  </a>";
		} else
		{
			prev = "上一页";
			first = "首页";
		}

		if (currentPage < pageCount)
		{

			next = "<a href='" + url + "?" + (flag ? "" : "method=list&")
					+ "currentPage=" + (currentPage + 1) + queryStr
					+ "'> 下一页  </a>";
		} else
		{
			next = "下一页";
			End = "尾页";
		}
		//到这里为止，上一页、下一页、首页、尾页都正常
		request.setAttribute("pageCount", pageCount);//int，总页面
		request.setAttribute("currentPage", currentPage.toString());//int，当前页的页面
		for (String string : queryNames)//queryNames={"queryName","queryDeptID"}
		{
			request.setAttribute(string, queryMap.get(string));
		}
		request.setAttribute("pageSize", pageSize);//int,自己传入
		request.setAttribute("list", source);//List<Student>，2个学生
		request.setAttribute("first", first);//String first="<a href="...">首页</a>"
		request.setAttribute("prev", prev);//String prev="<a href="....">上一页</a>"
		request.setAttribute("next", next);//String next="<a href="...">下一页</a>"
		request.setAttribute("End", End);//String End="<a href="...">尾页</a>"
		request.setAttribute("dataInfo", dataInfo);//String dataInfo="<span>共有" + dataCount + "条数据        </span>"
		request.setAttribute("pageInfo", pageInfo);//String pageInfo="<span>   当前处于第" + currentPage + "/" + pageCount+ "页</span>"
		
		// ${group} 普通分页
		request.setAttribute("group", dataInfo + "&nbsp;&nbsp " + first
				+ "&nbsp;&nbsp " + prev + "&nbsp;&nbsp " + next
				+ "&nbsp;&nbsp " + End + "&nbsp;&nbsp" + pageInfo);

		int btncount = 10;// 按钮数
		int start;// 开始的页码.当前页是50时，例如：上一页 45 46 47 48 49 50 51 52 53 54 下一页
		int end;// 结束的页码
		//上一页 下一页
		start = currentPage - btncount / 2 < 1 ? 1 : currentPage - btncount / 2;//int start=45
		end = start + btncount - 1;//int end=54
		int prePage = currentPage - 1 < 1 ? 1 : currentPage - 1;//上一页，int ,49
		int nextPage = currentPage + 1 > pageCount ? pageCount
				: currentPage + 1;//下一页的页面，int ,51
		if (end > pageCount)
		{
			end = pageCount;
			start = end - btncount + 1;
			nextPage = end;
		}
		start = start < 1 ? 1 : start;
		
		//到这里为止，start、end、prePage、nextPage都是int，都正常的
		//当前页是50时，例如：上一页 45 46 47 48 49 50 51 52 53 54 下一页
		request.setAttribute("start", start);//int start=45
		request.setAttribute("end", end);//int end=54
		request.setAttribute("btncount", btncount);//int 10
		request.setAttribute("prePage", prePage);//int prePage=49
		request.setAttribute("nextPage", nextPage);//int nextpage=51

		//自己对原始版本的group的修改
		String mygroup= dataInfo + "&nbsp;&nbsp " + first
				+ "&nbsp;&nbsp " + prev;
		String s2="&nbsp;&nbsp " + next
				+ "&nbsp;&nbsp " + End + "&nbsp;&nbsp" + pageInfo;
		for(int i=start;i<=end;i++)
		{
			mygroup+="&nbsp;&nbsp "+"<a href='"+url+"?"+(flag ? "" : "method=list&")+
					"currentPage="+i+queryStr+"'>"+i+"</a>";
		}
		mygroup+=s2;
		
		//System.out.println(mygroup);
		request.setAttribute("mygroup", mygroup);
		
	}

}
