import java.util.*;
import java.lang.*;
class Job
{
	public int index;
	public int profit;
	public int deadline;
	Job(int index,int profit,int deadline)
	{
		this.index=index;
		this.profit=profit;
		this.deadline=deadline;
	}
	public String toString()
	{
		return "J"+index;
	}
}
public class JobSequencingProgram
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of jobs :");
		int num = sc.nextInt();
		ArrayList<Job> jobs = new ArrayList<>();
		for(int i=0;i<num;i++)
		{
			System.out.print("Enter the Profit of J"+(i+1)+": ");
			int profit = sc.nextInt();
			System.out.print("Enter the Deadline for J"+(i+1)+": ");
			int deadline = sc.nextInt();
			jobs.add(new Job((i+1),profit,deadline));
		}
		Comparator<Job> comparator = new Comparator<Job>()
		{
			@Override
			public int compare(Job o1,Job o2)
			{
				if(o1.profit<o2.profit)
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
		};
		Collections.sort(jobs, comparator);
		int max=-99999;
		for(Job job : jobs)
		{
			if(max<job.deadline)
			{
				max=job.deadline;
			}
		}
		int profit=0;
		String[] schedule = new String[max];
		for(Job job : jobs)
		{
			int pp = job.deadline;
			pp--;
			if(schedule[pp]==null)
			{
				schedule[pp]="J"+job.index;
				profit+=job.profit;
			}
			else
			{
				while(pp!=-1)
				{
					if(schedule[pp]==null)
					{
						schedule[pp]="J"+job.index;
						profit+=job.profit;
						break;
					}
					pp=pp-1;
				}
			}
		}
		for(int i=0;i<max;i++)
		{
			if(i!=0)
			{
				System.out.print("=>");
			}
			System.out.print(schedule[i]);
		}
	}

}