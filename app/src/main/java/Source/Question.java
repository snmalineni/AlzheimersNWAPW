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
        imgUri=null;
        opta=null;
        optb=null;
        optc=null;
        ans=null;
    }

    public Question(cappedPhoto cPhoto) {
        imgUri = cPhoto.getUriString();
        ans = cPhoto.getCap();
        opta = null;
        optb = null;
        optc = null;

        Random rn = new Random();
        int arLength = Homepage.photoAr.size();
        int r = rn.nextInt(arLength);
        cappedPhoto rCP;
        //gets random number bounded by size of photoAr

        do {
            rCP = Homepage.photoAr.get(r);
            opta = rCP.getCap();
            //sets opta to random cappedPhoto caption
        } while (opta.compareTo(ans) != 0);
        do {
            rCP = Homepage.photoAr.get(r);
            optb = rCP.getCap();
            //sets optb to random cappedPhoto caption
        } while (optb.compareTo(ans) != 0);
        do {
            rCP = Homepage.photoAr.get(r);
            optc = rCP.getCap();
            //sets optc to random cappedPhoto caption
        } while (optc.compareTo(ans) != 0);
    }
    public int getID() {return ID;}
    public Uri getimgUri() {
        return parse(imgUri);
    }
    public String getopta() {return opta;}
    public String getoptb() {return optb;}
    public String getoptc() {return optc;}
    public String getans() {return ans;}

    public void setID(int id) {ID=id;}
    public void setimgUri(String iMGURI) {imgUri = iMGURI;}
    public void setans(String aNSWER) {ans = aNSWER;}
}
