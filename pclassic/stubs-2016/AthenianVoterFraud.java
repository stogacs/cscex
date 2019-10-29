import java.util.*;
import java.io.*;

class AthenianVoterFraud {
	//AGAIN, DONT TOUCH THE MAIN FUNCTION - IT WILL BE PROVIDED
	public static void main(String[] args)throws IOException {
		
		BufferedReader b = new BufferedReader(new FileReader("AthenianVoterFraudIN.txt"));

		while (b.ready()) {
			String[] data = b.readLine().split(",");
			ArrayList<Integer> votes = new ArrayList<Integer>();
			for (String vote: data) {
				votes.add(Integer.parseInt(vote));
			}
      int[] voters = new int[votes.size()];
      for (int i = 0; i < votes.size(); i++) {
        voters[i] = votes.get(i);
      }
			int[] result = findDuplicates(voters);
      Arrays.sort(result);
			if (result.length == 0) {
				System.out.println("none");
			} else {
				String res = Arrays.toString(result);
				res = res.substring(1, res.length() - 1);
				res = res.replace(", ", ",");
				System.out.println(res);
			}
		}

	}
	
	//THIS IS THE SOLN PROVIDED - THIS IS BAD CODE THIS WASTES A LOT OF SPACE
	public static int[] findDuplicates(int[] voters) {
		//write your code here and change null
		return null;
	}
	
}
