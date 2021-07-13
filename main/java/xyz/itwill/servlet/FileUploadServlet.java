package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

//�Է����������� ���޵� ��Ƽ��Ʈ ������Ÿ�� ó���ϱ� ���� Ŭ���� �ʿ�
// => Apache �׷쿡�� ������ commons-fileupload ���̺귯���� Ŭ���� ��� - ������ ���� ���ε�
// => Oreilly �׷쿡�� ������ cos ���̺귯���� Ŭ���� ��� - ������ ���� ���ε�

//Oreilly �׷쿡�� ������ cos ���̺귯�� ������ �ٿ�ε� �޾� ������Ʈ�� ����(Build) ó���ϴ� ���
//1.http://www.servlets.com >> COS File Upload Library �޴� Ŭ�� >> cos-20.08.zip �ٿ�ε�
//2.cos-20.08.zip ���� ���� Ǯ�� >> ���� ���� >> lib >> cos.jar ����
//3.������Ʈ >> src/main/wabapp >> WEB-INF >> lib ������ cos.jar ���� �ٿ��ֱ�
// => ���̺귯���� �ڵ����� ������Ʈ�� ���� ó�� - Web App Libraries Ȯ��

//�Է�������(file_upload.html)���� ���޵� �Է°��� �Է� ���ϸ��� ��ȯ�޾� Ŭ���̾�Ʈ���� �����ϴ� ������
// => �Է� ������ ���޹޾� ���� ���丮�� ����ǵ��� ó�� - ���ε�(Upload)
@WebServlet("/upload.itwill")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//���������� ��û�� ���� ó��
		if(request.getMethod().equals("GET")) {
			response.sendRedirect("file_upload.html");//�Է��������� �̵� ó��
			return;
		}
		
		//���޵� ������ �����ϱ� ���� ���� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		// => �۾� ���丮(WorkSpace)�� �ƴ� �� ���丮(WebApps)�� �ý��� ��� ��ȯ
		String saveDirectory=request.getServletContext().getRealPath("/upload");
		//System.out.println("saveDirectory = "+saveDirectory);
		
		//MultipartRequest Ŭ������ �ν��Ͻ� ����
		// => MultipartRequest : ��Ƽ��Ʈ ������Ÿ�� ó���ϱ� ���� ����� �����ϴ� �ν��Ͻ�
		//MultipartRequest(HttpServletRequest request, String saveDirectory[, int maxPostSize]
		//[, String encoding][, FileRenamePolicy policy]) �����ڸ� ����Ͽ� �ν��Ͻ� ����
		// => request : ��û������ ������ HttpServletRequest �ν��Ͻ� ����
		// => saveDirectory : ���� ������ �����ϱ� ���� ���� ���丮�� �ý��� ��� ����
		// => maxPostSize : ó�� ������ ��Ƽ��Ʈ ������Ÿ�� �ִ� ũ�� ���� - ���� : Byte
		// => encoding : ��Ƽ��Ʈ ������Ÿ�� ���޵� �Է°��� ĳ���ͼ� ����
		MultipartRequest mr=new MultipartRequest(request, saveDirectory, 30*1024*1024, "utf-8");
	}
}













