package zhangxiangyu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhangxiangyu.dao.NewsDao;
import zhangxiangyu.daoimpl.NewsDaoimpl;
import zhangxiangyu.news.News;

/**
 * Servlet implementation class AddMyNews
 */
@WebServlet("/AddMyNews")
public class AddMyNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		try {
			NewsDao zhangxiangyu_dao =new NewsDaoimpl();
			News zhangxiangyu_news =new News();
			zhangxiangyu_news.setZhangxiangyu_title(request.getParameter("zhangxiangyu_title"));
			zhangxiangyu_news.setZhangxiangyu_author(request.getParameter("zhangxiangyu_author"));
			zhangxiangyu_news.setZhangxiangyu_content(request.getParameter("zhangxiangyu_content"));
			int zhangxiangyu_rs =zhangxiangyu_dao.zhangxiangyu_AddNews(zhangxiangyu_news);
			if(zhangxiangyu_rs!=0) {
				out.print("���ӳɹ�");
			}
			else {
				out.print("����ʧ��");
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
