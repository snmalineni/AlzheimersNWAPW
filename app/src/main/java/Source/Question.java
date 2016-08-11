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

        Random randomNumber = new Random();
        //int r = (int)Math.random()*Homepage.photoAr.size() + 1;
        int arLength = Homepage.photoAr.size();
        int r = randomNumber.nextInt(arLength);
        cappedPhoto randomCP;
        //gets random number bounded by size of photoAr

        do {
            randomCP = Homepage.photoAr.get(r);
            r = randomNumber.nextInt(arLength);
            opta = randomCP.getCap();
            //sets opta to random cappedPhoto caption
        } while (opta.compareTo(ans) == 0);
        do {
            randomCP = Homepage.photoAr.get(r);
            r = randomNumber.nextInt(arLength);
            optb = randomCP.getCap();
            //sets optb to random cappedPhoto caption
        } while (optb.compareTo(ans) == 0 || optb.compareTo(opta) == 0);
        do {
            randomCP = Homepage.photoAr.get(r);
            r = randomNumber.nextInt(arLength);
            optc = randomCP.getCap();
            //sets optc to random cappedPhoto caption
        } while (optc.compareTo(ans) == 0 || optc.compareTo(optb) == 0 || optc.compareTo(opta) == 0);
    }

    public int getID() {return ID;}
    public Uri getimgUri() {return Uri.parse(imgUri);}
    public String getopta() {return opta;}
    public String getoptb() {return optb;}
    public String getoptc() {return optc;}
    public String getans() {return ans;}

    public void setID(int id) {ID=id;}
    public void setimgUri(String iMGURI) {imgUri = iMGURI;}
    public void setans(String aNSWER) {ans = aNSWER;}
}
