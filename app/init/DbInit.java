package init;

import com.fdflib.model.entity.FdfEntity;
import com.fdflib.persistence.database.DatabaseUtil;
import com.fdflib.service.FdfServices;
import com.fdflib.util.FdfSettings;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import models.Role;
import models.User;
import models.UserRole;
import play.Logger;
import play.api.Environment;
import services.RoleService;
import services.UserService;
import tyrex.security.container.helper.RolesRealm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian.gormanly on 9/26/16.
 */
@Singleton
public class DbInit {

    @Inject
    public DbInit(Environment environment) {
        Logger.info("Application start");

        // initialize 4DFLib
        // Create a array that will hold the classes that make up our 4df data model
        List<Class> myModel = new ArrayList<>();

        // add model objects
        //myModel.add(User.class);
        

        // get the 4dflib settings singleton
        FdfSettings fdfSettings = FdfSettings.getInstance();
        fdfSettings.PERSISTENCE = DatabaseUtil.DatabaseType.MYSQL;
        fdfSettings.DB_PROTOCOL = DatabaseUtil.DatabaseProtocol.JDBC_MYSQL;
        fdfSettings.DB_ENCODING = DatabaseUtil.DatabaseEncoding.UTF8;
        fdfSettings.DB_HOST = "localhost";
        fdfSettings.DB_NAME = "myDb";
        fdfSettings.DB_ROOT_USER = "root";
        fdfSettings.DB_ROOT_PASSWORD = "";
        fdfSettings.DB_USER = "myUser";
        fdfSettings.DB_PASSWORD = "myUserPassword";

        // call the initialization of library!
        FdfServices.initializeFdfDataModel(myModel);
		

    }
}
