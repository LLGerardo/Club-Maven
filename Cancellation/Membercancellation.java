package Cancellation;
//Arub
public class Membercancellation {
    public void cancelMembership(Memeber member){
        if(member.isActiveMember(){
            member.setActiveMember(false);
            System.out.println("the membership with this ID:" +  member.getMembershipId() + "had been canceled");
        }else{
            System.out.println("this member with this ID:" +  member.getMembershipId() + "is already canceled");
        }
    }
}
