package Source;

import android.net.Uri;

import com.sneha.newalzheimersapplication.Homepage;

import static android.net.Uri.parse;
import java.util.Random;

public class Question {
    private int ID;
    private String imgUri;
    private String opta;
    private String optb;
    private String optc;
    private String ans;

    public Question() {
        ID=0;
        imgUri="";
        opta="";
        optb="";
        optc="";
        ans="";
    }

    public Question(cappedPhoto cPhoto) {
        imgUri = cPhoto.getUriString();
        ans = cPhoto.getCap();
        opta = "";
        optb = "";
        optc = "";

       // Random rn = new Random();
        //int arLength = Homepage.photoAr.size();
        //int r = rn.nextInt(arLength);

        int r = (int) (Math.random()*Homepage.photoAr.size());
        cappedPhoto rCP;
        //gets random number bounded by size of photoAr

        rCP = Homepage.photoAr.get(r);
        opta = rCP.getCap();
        optb = rCP.getCap();
        optc = rCP.getCap();
            //sets optc to random cappedPhoto caption
    }

    public int getID()
    {
        return ID;
    }
    public Uri getimgUri()
    {
        return Uri.parse(imgUri);
    }
    public String getopta()
    {
        return opta;
    }
    public String getoptb()
    {
        return optb;
    }
    public String getoptc()
    {
        return optc;
    }
    public String getans()
    {
        return ans;
    }

    public void setID(int id) {ID=id;}
    public void setimgUri(String iMGURI) {imgUri = iMGURI;}
    public void setans(String aNSWER) {ans = aNSWER;}
}
