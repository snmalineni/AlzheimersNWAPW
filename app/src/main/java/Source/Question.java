package Source;

import android.net.Uri;

import static android.net.Uri.parse;

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

    public Question(String iMGURI, String oPTA, String oPTB, String oPTC,
                    String aNSWER) {

        imgUri = iMGURI;
        opta = oPTA;
        optb = oPTB;
        optc = oPTC;
        ans = aNSWER;
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
    public void setopta(String oPTA) {opta = oPTA;}
    public void setoptb(String oPTB) {optb = oPTB;}
    public void setoptc(String oPTC) {optc = oPTC;}
    public void setans(String aNSWER) {ans = aNSWER;}
}
