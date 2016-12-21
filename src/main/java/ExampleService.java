/**
 * Created by rakeshgupta on 12/21/16.
 */
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ExampleService extends Service<ExampleServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExampleService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ExampleServiceConfiguration> bootstrap) {
        bootstrap.setName("RestaurantManagement Sample");
    }

    @Override
    public void run(ExampleServiceConfiguration conf, Environment env) throws Exception {
        // we will add resource classes here
        env.addResource(new HelloResource(conf.getMessages()));
    }

}
