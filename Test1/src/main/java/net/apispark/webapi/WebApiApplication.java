package net.apispark.webapi;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.ChallengeScheme;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.service.CorsService;
import org.restlet.security.MemoryRealm;
import org.restlet.security.User;
import org.restlet.security.Role;

import net.apispark.webapi.resource.server.ClassServerResource;

public class WebApiApplication extends Application {

    public static final String ROUTE_CLASS = "/class";
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_ANYONE = "anyone";
    public static final String ROLE_DEV = "cellroledev";
    public static final String ROLE_OWNER = "cellroleowner";
    public static final String ROLE_USER = "cellroleuser";

    public WebApiApplication() {
    	setName("apiApplicationRequests");
        CorsService corsService = new CorsService();
        corsService.setAllowedCredentials(true);
        corsService.setSkippingResourceForCorsOptions(true);
        getServices().add(corsService);
    }

	private ChallengeAuthenticator createApiGuard(Restlet next) {

        ChallengeAuthenticator apiGuard = new ChallengeAuthenticator(
                getContext(), ChallengeScheme.HTTP_BASIC, "realm");

        MemoryRealm realm = new MemoryRealm();
        User owner = new User("owner", "owner");
        realm.getUsers().add(owner);
        realm.map(owner, Role.get(this, ROLE_OWNER));
        realm.map(owner, Role.get(this, ROLE_USER));
        realm.map(owner, Role.get(this, ROLE_DEV));
        User admin = new User("admin", "admin");
        realm.getUsers().add(admin);
        realm.map(admin, Role.get(this, ROLE_ADMIN));
        realm.map(admin, Role.get(this, ROLE_OWNER));
        realm.map(admin, Role.get(this, ROLE_USER));
        realm.map(admin, Role.get(this, ROLE_DEV));
        User user = new User("user", "user");
        realm.getUsers().add(user);
        realm.map(user, Role.get(this, ROLE_USER));
        apiGuard.setVerifier(realm.getVerifier());
        apiGuard.setEnroler(realm.getEnroler());
        apiGuard.setNext(next);
        apiGuard.setOptional(true);
        return apiGuard;
    }
    
    public Router createApiRouter() {
        Router apiRouter = new Router(getContext());
        apiRouter.attach(ROUTE_CLASS, ClassServerResource.class);
        return apiRouter;
	}

    public Restlet createInboundRoot() {
        Router apiRouter = createApiRouter();
        ChallengeAuthenticator guard = createApiGuard(apiRouter);
        return guard;
    }

}
