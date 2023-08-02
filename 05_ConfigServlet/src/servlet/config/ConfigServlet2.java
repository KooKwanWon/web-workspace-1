package servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfigServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path = "d:\\test\\count2.txt";
	
	
	
	public void init(ServletConfig config) throws ServletException {
		//1. ServeletConfig의 기능을 사용해서 path에 연결된 값을 받아온다.
		//2. BufferedReader를 사용해서 파일을 읽어들인다.
		//3. count값으로 필드 초기화		
		System.out.println("2. init... 호출..");
		// 서버가 다시 시작될 떄 init에서 파일에 저장된 내용을 읽어서 count에 다시 할당
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);
			br.close();
			
			System.out.println("count.txt 파일의 내용을 읽어들임... count :: "
					+ count);
		} catch (IOException e) {
			System.out.println("파일을 읽어들이는데 실패...");
		}
		
	}

	public void destroy() {
		System.out.println("4. destroy... 호출..");
		
		// 필드에 저장된 값을 파일로 저장하고 서버가 내려질 것
		File file = new File(path);
		// 출력용 파일을 출력스트림에서 자동적으로 생성되려면
		// 그전에 반드시 디렉토리는 만들어져 있어야 한다.
		file.getParentFile().mkdirs(); // 하나든 여러개든 디렉토리를 만들어줌
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			pw.close();
			System.out.println(path + "count 값 :: " + count + "파일에 영구적으로 저장");
		} catch (IOException e) {
			System.out.println("스트림 생성 실패");
		}

	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//5. 폼에 입력된 값을 받아서 
		//~~아무개 님은 ~ 번쨰 입장하신 고객입니다...를 브라우저로 출력
		//이때 출력은 config2.jsp에서
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
						
		String userName = request.getParameter("userName");
		
		out.println("<a href=config2.jsp?userName=" + userName +"&count="+ ++count + ">cofig2.jsp로 이동</a>");
		
		System.out.println(userName + "님은 " + count + "번째 입장하신 고객입니다.");
		
		out.close();
	}

}
