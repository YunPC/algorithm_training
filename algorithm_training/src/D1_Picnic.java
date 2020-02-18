
import java.io.*;

public class D1_Picnic {
	
	public static void main(String[] args)
	{
		try {
			//파일 객체 생성
			File file_in = new File("C:\\\\Users\\\\YunPC\\\\git\\\\algorithm_training\\\\algorithm_training\\\\input\\\\D1_picnic_input.txt");
			//스트림 생성
			FileReader filereader = new FileReader(file_in);
			//버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			BufferedWriter fw = new BufferedWriter(new FileWriter("output.txt", true));
			String line = ""; int i = 0;
			String[] friend_array = new String[2];
			String[] friend_pair_array;
			int result;
			while((line = bufReader.readLine()) != null)
			{
				
				if(i == 0)
					i++;
				else
				{
					//케이스 읽기(친구, 친구쌍 수)
					if(i % 2 == 1)
					{
						friend_array = line.split(" ");
						
					}
					else
					{
						friend_pair_array = line.split(" ");
						result = find_pair(friend_array, friend_pair_array);
						
					}
				}
					
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static int find_pair(String[] friend, String[] pair_array)
	{
		int return_value = -1;
		int[] friend_int = new int[friend.length];
		int[] pair_int = new int[pair_array.length];
		for(int idx = 0; idx < friend.length; idx++)
		{
			friend_int[idx] = Integer.valueOf(friend[idx]);
		}
		for(int idx = 0; idx < pair_array.length; idx++)
		{
			pair_int[idx] = Integer.valueOf(pair_array[idx]);
		}
		//case 1  모든 학생이 서로 친구인 경우
		if(friend_int[0] * (friend_int[0] -1) == pair_array.length)
			return_value = 1;
		else
		{
		}
		
		return -1;
	}

}
