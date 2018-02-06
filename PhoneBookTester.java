import java.util.Scanner;

class PhoneEntry
{
  //private String name;    // name of a person
  private String phone;   // their phone number

  private String firstName;
  private String lastName;

  public PhoneEntry( String n, String l, String p ) {
    firstName = n; lastName = l; phone = p;
  }

  public String getName()  {return firstName + lastName;}
  public String getLastName() {return lastName;}
  public String getPhone() {return phone;}
  public String getFullName() {return firstName + " " + lastName;}
}

class PhoneBook
{
  private PhoneEntry[] phoneBook;

  public PhoneBook()    // constructor
  {
    phoneBook = new PhoneEntry[ 5 ] ;

    phoneBook[0] = new PhoneEntry( "James", "Barclay", "(418) 665-1223" );
    phoneBook[1] = new PhoneEntry( "Grace", "Dunbar", "(860) 399-3044" );
    phoneBook[2] = new PhoneEntry( "Paul", "Smith", "(815) 439-9271" );
    phoneBook[3] = new PhoneEntry( "Violet", "Smith", "(312) 223-1937" );
    phoneBook[4] = new PhoneEntry( "John", "Wood", "(913) 883-2874" );

  }

  public PhoneEntry search( String targetFirstName , String targetLastName) {

    if (targetFirstName != null) {

      for ( int j=0; j < phoneBook.length; j++ ) {
        if ( phoneBook[j] != null && phoneBook[j].getName().toUpperCase().equals( targetFirstName + targetLastName ) )
          return phoneBook[j];
      }
    }

    for (int k=0; k < phoneBook.length; k++) {
      if ( phoneBook[k] != null && phoneBook[k].getLastName().toUpperCase().equals( targetLastName ) )

        System.out.println( phoneBook[k].getFullName() + ": " + phoneBook[k].getPhone() );

    }

    return null;
  }
}

public class PhoneBookTester
{
  public static void main ( String[] args )
  {
    PhoneBook pb = new PhoneBook();

    System.out.println("Last name?");
    Scanner in = new Scanner(System.in);
    String searchLastName = in.nextLine();

    System.out.println("First name?");
    Scanner in2 = new Scanner(System.in);
  //  String searchFirstName = " ";
    String searchFirstName = in2.nextLine();


    // search for user given name
    PhoneEntry entry = pb.search( searchFirstName.toUpperCase(), searchLastName.toUpperCase());

    if ( entry != null )
      System.out.println( entry.getFullName() + ": " + entry.getPhone() );
    else
      System.out.println("Name not found" );

  }
}
