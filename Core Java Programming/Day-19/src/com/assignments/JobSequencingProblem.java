package com.assignments;
import java.util.*;

class Job{
	int Id;
	int Deadline;
	int Profit;
	
	public Job (int id, int deadline, int profit) {
		this.Id = id;
		this.Deadline = deadline;
		this.Profit = profit;
	}
}

public class JobSequencingProblem {
	
	public static List<Job> JobSequencing(List<Job>jobs){
		jobs.sort((a,b) -> b.Profit - a.Profit);
		
		int maxDeadline = 0;
		for(Job job : jobs) {
			if(job.Deadline > maxDeadline) {
				maxDeadline  = job.Deadline;
			}
		}
		Job[] result = new Job[maxDeadline];
		boolean[] slot = new boolean[maxDeadline];
		
		for(Job job : jobs) {
			for(int j = Math.min(maxDeadline, job.Deadline) -1; j >= 0; j--) {
				if(!slot[j]) {
					slot[j] = true;
					result[j] = job;
					break;
				}
			}
		}
		
		List<Job> scheduledJobs = new ArrayList<>();
		for(Job job : result) {
			if(job != null) {
				scheduledJobs.add(job);
			}
		}
		return scheduledJobs;
	}
	public static void main(String args[]) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1, 4, 20));
		jobs.add(new Job(2, 1, 10));
		jobs.add(new Job(3, 1, 40));
		jobs.add(new Job(4, 1, 30));
		
		List<Job> result = JobSequencing(jobs);
		
		System.out.println("Scheduled jobs: ");
		for(Job job : result) {
			System.out.println("Job Id: " + job.Id + "Deadline: " + job.Deadline + "Profit" + job.Profit);
			
		}
	}

}
