
import MedicalStore.*; //the package containing our stubs
import org.omg.CosNaming.*; //Client will use the Naming Service
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*; //// All CORBA applications need these classes
import java.util.*;
class Client{
	public static void main(String[] args){
		try{
			int i;
			String j;
			Scanner sc=new Scanner(System.in);
			String s,b,a;
			ORB orb=ORB.init(args,null); //The call to the ORB's init() method passes in an 
										//application's command line arguments, allows you to set certain properties at runtime.
			
			org.omg.CORBA.Object objRef = 
			orb.resolve_initial_references("NameService"); //The first step in using the naming service is to get the initial naming context. here you call orb.resolve_initial_references() to get an object reference to the name server
			NamingContext ncRef = NamingContextHelper.narrow(objRef); //As with all CORBA object references, objRef is a generic CORBA object. To use it as a NamingContextExt object, you must narrow it to its proper type.
			NameComponent nc=new NameComponent( "Medicines" , "" );
			NameComponent path[] = {nc} ;
			medintf lbref=medintfHelper.narrow( ncRef.resolve(path) );
			do{
				int p=0;
				System.out.println( ++p +".Check medicines");
				if(lbref.total_price() > 0){
							System.out.println( ++p +".Proceed to Payment");
				}
				System.out.println(++p +".Exit");
				System.out.print("Enter choice: ");
				i=sc.nextInt();
				switch(i){
					case 1:
					System.out.print("Paracetamol Lyrica Ibuprofen Codiene Cymbalta Ativan Losartan Actidone Lexapro Alora\n");
					System.out.print("Enter medicine name: ");
					j=sc.next();
					s=lbref.check_medicine(j);
					System.out.println(s);
					System.out.println("If you want to 	confirm type 'yes' else 'no'");
					b=sc.next();		a=b.toLowerCase();
					if(a.equals("yes")){
						 System.out.print("Enter number of quantities: ");
						 int y=sc.nextInt();
						 s=lbref.process_medicine(j,y);
						 if(s.equals("")){
							 s="Sorry medicines not in stock!!!";
						 }
						 System.out.println(s);
					}
					break;

					case 2:int pay=lbref.total_price();
					System.out.println("Total amount to be paid: "+pay);
					System.out.println("If you want to pay type 'yes' else 'no' ");
						b=sc.next();		a=b.toLowerCase();
					if(a.equals("yes")){
						 s=lbref.pay_bill();
						 System.out.println(s);
					}
					break;

					default:
					if(lbref.total_price() > 0){
						System.out.println("Your cart amount: "+lbref.total_price());
 					 System.out.print("Do you want to pay? ");
 					 b=sc.next();		a=b.toLowerCase();
 					 if(a.equals("yes")){
 								 s=lbref.pay_bill();
 								 System.out.println(s);
 					 }
					}

					break;
				}
			}while(i!=3);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
