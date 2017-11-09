import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author wb-ny291824
 * @version $Id: HelloQuartzJob.java, v 0.1 2017-11-02 16:45 wb-ny291824 Exp $$
 */
public class HelloQuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello Quartz!");
    }
}
