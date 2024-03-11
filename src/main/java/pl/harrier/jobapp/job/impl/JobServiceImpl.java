package pl.harrier.jobapp.job.impl;

import org.springframework.stereotype.Service;
import pl.harrier.jobapp.job.Job;
import pl.harrier.jobapp.job.JobService;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }


    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }
    @Override
    public boolean deleteJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }
}
