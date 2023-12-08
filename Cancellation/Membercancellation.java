//Sumayli

package Cancellation;
//import java.util.Scanner;
import Creation.Member;
import Creation.MembershipCreation;
import GUI.GUIPanel;
import GUI.DatabaseConnector;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Arub
public class Membercancellation {
    public void cancelMembership(Member member){
        if(member.isActiveMember(){
            member.setActiveMember(false);
            System.out.println("the membership with this ID:" +  member.getMembershipId() + "has been canceled");
        }else{
            System.out.println("the membership with this ID:" +  member.getMembershipId() + "is already canceled");
        }
    }
}
