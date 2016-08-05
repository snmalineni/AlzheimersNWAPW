package Source;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;


/**
 * Created by sneha on 8/2/16.
 */
public class Serialization {

    public void serialize (List<cappedPhoto> ar1, String fileName)
    {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName))){
            os.writeObject(ar1);
            os.close();
        }
        catch (IOException e) {
            System.out.println("Something is wrong");
            System.out.println(e.getMessage());

        }
    }
}
