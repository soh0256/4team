package chapter15.ioadd;

import java.io.File;

public class Test08_FileDelete {
	public static void main(String[] args) {
		if(args.length !=1) {//���� args.length�� 1�� �ƴѰ��(!=1):�μ�(args) ���� ������� 
			System.out.println("���� �Ǵ� (���Ͼ���)���ص��� ���� ���α׷� ���");
		}
		//delete�� ȣ���ϰ� �߻��ϴ� ��� �޽��� ���
		try {
			delete(args[0]);//�����ϴ� ���� �޼ҵ�
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("���� ���� �Ϸ�");
	}
	//������ �ϴ� ���� �޼ҵ�
	//������ �����̳� ���丮�� �����ϱ��� ������ �������� ����Ȯ�� ������ ���ܹ߻�
	public static void delete(String filname) {
		//���� �̸��� ��Ÿ���� ����, file��ü�� ������
		File f=new File(filname);
		//�����̳� ���丮�� �����ϴ��� �� ���� ������ �Ǿ� �ִ����� Ȯ��
		if(!f.exists())fail("Delete : no such file or directory : "+filname);
		if(!f.canWrite())fail("Delete : write protected : "+filname);
		//���丮�̸�, ����ִ��� Ȯ��
		if(f.isDirectory()) {
			String[] files=f.list();
			if(files.length>0)
				fail("Delete : directory not empty :"+filname);
		}
		boolean success =f.delete();//��� �˻縦 ������� ���ϸ� ����
		if(!success)fail("Delete : deletion failed");
	}//IllegalArgumentException:�������� �μ�(�μ�)�� �޼��忡 ó���� ��� ����ó��
	protected static void fail(String msg)throws IllegalArgumentException{
		throw new IllegalArgumentException(msg);
	}
}
