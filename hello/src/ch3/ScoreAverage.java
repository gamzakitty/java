package ch3;

public class ScoreAverage {
	public static void main(String[] args) {
		double score[][] = {{3.3, 3.4},
				{3.5, 3.6},
				{3.7, 4.0},
				{4.1, 4.2}};
		double sum =0;
		for(int year=0; year<score.length; year++) //�� �г⺰�� �ݺ�
			for(int term=0; term<score[year].length; term++)
				sum += score[year][term];
		
		int n = score.length;	// �迭�� ��(�г�)�� ����
		int m = score[0].length; // �迭�� ��(�б�) ����
		System.out.println("4�� ��ü ���� ����� " + sum/(n*m));
		}
	}

