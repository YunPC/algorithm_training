
import java.io.*;

public class D2_millionaire_project {
	
	public static void main(String[] args)
	{
		//read input data
		try {
			//파일 객체 생성
			File file_in = new File("D:\\algorithm_training\\input\\D2_millionaire_project.txt");
			File file_out = new File("D:\\algorithm_training\\output\\D2_millionaire_project.txt");
			//입력 스트림 생성
			FileReader filereader = new FileReader(file_in);
			//입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "", prize_str = "";
			boolean is_deorder;
			int total_repeat = 0, array_size = 1, i = 0;
			while((line = bufReader.readLine()) != null)
			{
				if(i == 0)
					total_repeat = Integer.parseInt(line);
				else
				{
					if(i%2 == 1)
						array_size = Integer.parseInt(line);
					else
					{	//여기 오면 한 케이스를 다 읽은 경우!
						prize_str = line;
						//다 읽었으면 array_size만큼 선언을 해주자!(메모리 문제 발생할 것 같음)
						int[] prize_num = new int[array_size];
						//문자열로 읽은 판매가를  array에 순서대로 넣어주자
						for(int idx = 0; idx < array_size; idx++)
						{
							prize_num[i] = Integer.parseInt(prize_str.split(" ")[i]);
						}
						//매매가가 내림차순인 경우 아무것도 팔면 안된다.
						for(int idx = 0; idx < array_size; idx++)
						{
							if(prize_num[i] < prize_num[i+1])
								is_deorder = false;
							else
								is_deorder = true;
						}
						//내림차순 인 경우
						//if(is_deorder)
							
					}
					
				}
				i++;
			}
			bufReader.close();
		}
		catch(FileNotFoundException e)
		{
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
