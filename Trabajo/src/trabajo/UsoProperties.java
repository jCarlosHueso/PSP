package trabajo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UsoProperties {

public void guardarUsuario(User u) {
	 try {
		 Properties properties= new Properties();
		 
			 File file = new File("./propiedades/"+u.getName()+".properties");
			 if(file.exists()) {
				 properties.load(new FileInputStream(file));	 
			 }else {
				 file.createNewFile();
				 properties.load(new FileInputStream(file));
			 }
		 
	      
	       
	      
	      properties.setProperty("email", u.getEmail());
	      properties.setProperty("user", u.getName());
	      properties.setProperty("pwd", u.getPassword());
	    } catch (FileNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }

}
}