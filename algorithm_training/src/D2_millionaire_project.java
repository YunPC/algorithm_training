
import java.io.*;

public class D2_millionaire_project {
	
	public static void main(String[] args)
	{
		//read input data
		try {
			//파일 객체 생성
			File file_in = new File("C:\\Users\\YunPC\\git\\algorithm_training\\algorithm_training\\input\\D2_millionaire_project.txt");
			//스트림 생성
			FileReader filereader = new FileReader(file_in);
			//버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			BufferedWriter fw = new BufferedWriter(new FileWriter("output.txt", true));
			String line = "", prize_str = "";
			int total_repeat = 0, array_size = 1, i = 0, case_num = 1, item_num = 0, profit = 0;
			while((line = bufReader.readLine()) != null)
			{
				if(i == 0)
					total_repeat = Integer.parseInt(line);
				else
				{	int sum = 0;
					if(i%2 == 1)
						array_size = Integer.parseInt(line);
					else
					{	//여기 오면 한 케이스를 다 읽은 경우!
						//System.out.println("어레이 사이즈:"+array_size);	
						prize_str = line;
						//다 읽었으면 array_size만큼 선언을 해주자!(메모리 문제 발생할 것 같음)
						int[] prize_num = new int[array_size];
						//문자열로 읽은 판매가를  array에 순서대로 넣어주자
						for(int idx = 0; idx < array_size; idx++)
						{
							prize_num[idx] = Integer.parseInt(prize_str.split(" ")[idx]);
							//System.out.print("가격 배열: "+prize_num[idx]);
							//System.out.println();
						}
						
						//매매가가 내림차순인 경우 아무것도 팔면 안된다.
						for(int idx = 0; idx < array_size -1; idx++)
						{
							if(!(prize_num[idx] > prize_num[idx+1]))
							{
								item_num++;
								sum += prize_num[idx];
							}
							//내림차순이 아닌 경우 (최대 이익을 낼 수 있는 경우)
							if(prize_num[idx] > prize_num[idx+1])
							{
								profit += item_num*prize_num[idx+1] - sum;
								item_num = 0;
								sum = 0;
							}
						}
							//케이스 작성
							fw.write("#"+String.valueOf(case_num)+" "+String.valueOf(profit)+"\n");
							fw.flush();
						case_num++;
							
					}
					
				}
				i++;
			}
			bufReader.close();
			fw.close();
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
