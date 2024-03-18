public class Contact {
    String name;
    String phoneNo;
    String email;
    Contact(String name,String phoneNo,String email)
    {
        this.name=name;
        this.phoneNo=phoneNo;
        this.email=email;
    }
    public String toString()
    {
        return "Name:"+name+" Phone No:"+phoneNo+" Email:"+email;
    }
    public String getData()
    {
        return name+" "+phoneNo+" "+email+"\n";
    }
}
