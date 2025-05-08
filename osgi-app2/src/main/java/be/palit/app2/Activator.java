package be.palit.app2;

import be.palit.app1.GreetingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {


    private ServiceRegistration<CompanyService> registration;

    @Override
    public void start(BundleContext context) {
        registration = context.registerService(CompanyService.class, new CompanyServiceImpl(), null);
        System.out.println("CompanyService registered.");

        ServiceReference<GreetingService> ref = context.getServiceReference(GreetingService.class);
        GreetingService service = context.getService(ref);
        System.out.println(service.greet("OSGi Developer"));
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("CompanyService unregistered.");
    }
}
