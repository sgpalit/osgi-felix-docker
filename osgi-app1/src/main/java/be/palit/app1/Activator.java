package be.palit.app1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    private ServiceRegistration<GreetingService> registration;

    @Override
    public void start(BundleContext context) {
        registration = context.registerService(GreetingService.class, new GreetingServiceImpl(), null);
        System.out.println("GreetingService registered.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("GreetingService unregistered.");
    }
}
