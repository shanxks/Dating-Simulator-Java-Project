import java.util.*;
import java.io.*;
//import org.apache.commons.io.FileUtils;
 

public class mainn 
{	public static String o;
	public static String fna;
	public static String lna;
	public static String ad;
	public static String g;
	public static int agee;
	public static String emol;
	public static String bai;
	public static String yo;
	public static String po;
	public static String a[]=new String[10];
	public static String b[]=new String[30];
	public static String bt[]=new String[30];
	//public static String dd[]=new String[10];
	public static Scanner in=new Scanner(System.in);
	public static int count=0;
    public static int ccc=0;
	public static void main(String args[]) throws Exception{
		menu();
	}
	
	
	
		private static void menu() throws Exception
		{
		while(true){System.out.println("\t\t\t\t Welcome to Date Maker\n \t\t\t\t   ~~1.Log In~~\n \t\t\t\t   ~~2.Create a new account~~\n \t\t\t\t   ~~3.Exit~~");
		String choice =in.next();
		switch(choice)
		{	case "1": login();
			break;
			case "2": register();
			break;
			case "3": System.exit(0);
			
			default : System.out.println("Invalid Option selected. Try again");
			break;
		}}}
		
		
		
		private static void login(){
			
			while(true)
			{
			System.out.print("User Name:");
			String u=in.next();
			System.out.print("\nPassword:");
			String p=in.next();
			try
			{FileInputStream obj=new FileInputStream("C:\\java\\APP\\user\\"+u+p+".txt");
			app(u,p);
			 
			}
			catch(Exception e)
			{
			System.out.println("Invalid or Incorrect Username or Password.Try again");
			}
		}
		}
		
		
		
		private static void app(String u,String p) throws Exception
		{
		while(true)
		{System.out.println("\t\t\t\t  Welcome\n\t\t1.Profile\n\n\t\t2.Search for match\n\n\t\t3.Hearts\n\n\t\t4.Messages\n\n\t\t5.Log Out\n\n\t\t6.Exit");
		 String k=in.next();
		 switch(k)
			 {  case "1":profile(u,p);
						 break;
				case "2":search(u,p);
						 break;
				case "3":hearts(u,p);
						 break;
				case "4":break;
				case "5":System.out.println("\nYou have been successfully logged out\n");
						menu();
				case "6":System.exit(0);
				default : System.out.println("Invalid Option selected. Try again\n");
			break;
			 }
		 }
		}
		
		
		
		private static void profile(String u, String p) throws Exception
		{String a;
		try{
		FileInputStream obj=new FileInputStream("C:\\java\\APP\\user\\"+u+p+".txt");
		BufferedReader b=new BufferedReader(new FileReader("C:\\java\\APP\\user\\"+u+p+".txt"));
		while(( a=b.readLine())!=null)
		{System.out.println(a);
		}
		while(true){
		System.out.println("\n\t1.Change Information\t\t2.Back");
		String r=in.next();
		switch(r)
		{case "1":break;
		 case "2":app(u,p);
		 default:System.out.println("Invalid Option selected. Try again\n");
				break;
		}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}



		private static void search(String u,String p) throws Exception
		{   try{
			
			File f1=new File("C:\\java\\APP\\user\\"+u+p+".txt");
			BufferedReader br=new BufferedReader(new FileReader("C:\\java\\APP\\user\\"+u+p+".txt"));
			BufferedReader bp=new BufferedReader(new FileReader("C:\\java\\APP\\user\\"+u+p+".txt"));
			String rm=bp.readLine();				
		    rm=rm.replace("Name:","");
			rm=rm.trim();
			String pm=bp.readLine();
			pm=pm.trim();
			File fil =new File("C:\\java\\APP\\name\\"+rm+" "+pm+"\\hobby");
			String ss=rm+" "+pm;
			String[] dd=fil.list(new FilenameFilter(){
				public boolean accept(File current,String name){
					return name.endsWith(".txt");
				}
			});
			int nn=dd.length;
			for(int i=0;i<nn;i++){
				if(dd[i]==null)
				{continue;
				}
				dd[i]=dd[i].replaceAll(".txt","").trim();
			}
			
			
			String s;
			String r;
			int o=1,ui=1;
			File file =new File("C:\\java\\APP\\name");
			String[] d=file.list(new FilenameFilter(){
				public boolean accept(File current,String name){
					return new File(current,name).isDirectory();
				}
			});
			int n=d.length;
			while((s=br.readLine())!=null)
			{
			if(s.contains("Female"))
			{ ccc=0;
			for(int i=0;i<n;i++)
			{	count =0;
				bt[i+1]=d[i];
				d[i]=d[i].replaceAll(" Male","");
				d[i]=d[i].replaceAll(" Female","");
				d[i]=d[i].replaceAll(" Other","");
				b[i+1]=d[i];
				d[i]=d[i].toUpperCase();
				if(bt[i+1].contains(" Male")){
				
				File fi =new File("C:\\java\\APP\\name\\"+bt[i+1]+"\\hobby");
				String[] ddd=fi.list(new FilenameFilter(){
				public boolean accept(File current,String name){
					return name.endsWith(".txt");
				}
				});
				int nnn=ddd.length;
				for(int ii=0;ii<nnn;ii++){
					ddd[ii]=ddd[ii].replaceAll(".txt","").trim();
					for(int j=0;j<nn;j++){
						if(ddd[ii].equals(dd[j])){
								
							count=count+10;
					}
						}
					}
				
				
				
				
				System.out.println("\n\t"+(o++)+"."+d[i]+" -- "+count+"% Match");
				bt[ui]=b[i+1];
				ccc++;
				ui++;
				}
			}
			ri:while(true){
			System.out.println("\nEnter the serial to check out their profile *_< or press 0 to go back");
			int a=in.nextInt();
			if(a==0)
			{ app(u,p);
			}
			if(a>ccc)
				{System.out.println("Invalid option. Try Again.");
				 search(u,p);}
			for(int i=1;i<bt.length+1;i++)
			{
				if(a==i)
				{
				//FileInputStream obj=new FileInputStream("C:\\java\\APP\\name\\"+bt[i]+" Male\\"+bt[i]+".txt");
				BufferedReader bo=new BufferedReader(new FileReader("C:\\java\\APP\\name\\"+bt[i]+" Male\\"+bt[i]+".txt"));
				while((r=bo.readLine())!=null)
				{System.out.println(r);
				}String pp=bt[i]+" Male";
				 t:while(true){
			     System.out.println("1.Send Heart 2.Back");
			     String q=in.next();
				 switch(q)
				 {case "1":heart(ss,pp);
						System.out.println("Your heart is successfully sent.");
						search(u,p);
				 case "2": search(u,p);
				 break;
				 default:System.out.println("\nInvalid option selected.\n");
				 break;
				}
				}
				}
				else
				{ continue;
					//System.out.println("Invalid option. Try Again.");
					//search(u,p);
			
			}
			}
			}
			}
			
			else if(s.contains("Male"))
			{ ccc=0;
			for(int i=0;i<n;i++)
			{	count=0;
				bt[i+1]=d[i];
				d[i]=d[i].replaceAll(" Male","");
				d[i]=d[i].replaceAll(" Female","");
				d[i]=d[i].replaceAll(" Other","");
				b[i+1]=d[i];
				d[i]=d[i].toUpperCase();
				if(bt[i+1].contains(" Female")){
				
				File fi =new File("C:\\java\\APP\\name\\"+bt[i+1]+"\\hobby");
				String[] ddd=fi.list(new FilenameFilter(){
				public boolean accept(File current,String name){
					return name.endsWith(".txt");
				}
				});
				int nnn=ddd.length;
				for(int ii=0;ii<nnn;ii++){
					ddd[ii]=ddd[ii].replaceAll(".txt","").trim();
					for(int j=0;j<nn;j++){
						if(ddd[ii].equals(dd[j])){
								
							count=count+10;
					}
						}
					}
				
				
				System.out.println("\n\t"+(o++)+"."+d[i]+" -- "+count+"% Match");
				bt[ui]=b[i+1];
				ccc++;
				ui++;
				}
			}
			ri:while(true){
			System.out.println("\nEnter the serial to check out their profile *_< or press 0 to go back");
			int a=in.nextInt();
			int ap;
			if(a==0)
			{ app(u,p);
			}
			if(a>ccc)
				{System.out.println("Invalid option. Try Again.");
				 search(u,p);}
			
			for(int i=1;i<bt.length+1;i++)
			{
				if(a==i)
				{
				//FileInputStream obj=new FileInputStream("C:\\java\\APP\\name\\"+bt[i]+" Female\\"+bt[i]+".txt");
				BufferedReader bo=new BufferedReader(new FileReader("C:\\java\\APP\\name\\"+bt[i]+" Female\\"+bt[i]+".txt"));
				while((r=bo.readLine())!=null)
				{System.out.println(r);
				}String pp=bt[i]+" Female";
				 while(true){
				 System.out.println("1.Send Heart 2.Back");
			     String q=in.next();
				 switch(q)
				 {case "1":heart(ss,pp);
						System.out.println("Your heart is successfully sent.");
						search(u,p);
				 case "2": search(u,p);
				 break;
				 default:System.out.println("\nInvalid option selected.\n");
				 break;
				 }
				 }
				}
				else
				{ continue;
					//System.out.println("Invalid option. Try Again.");
					//search(u,p);
					
				}
			}
			}
			}
			else
			{continue;}
			
		}
			}
	
		catch(Exception e)
		{System.out.println(e);
		}	
		}
		
		
		private static void heart(String ss, String pp) throws Exception{
		
		FileOutputStream oja=new FileOutputStream("C:\\java\\APP\\name\\"+pp+"\\heart\\"+ss+".txt");
		}
		
		
		
		private static void hearts(String u, String p) throws Exception{
			BufferedReader bp=new BufferedReader(new FileReader("C:\\java\\APP\\user\\"+u+p+".txt"));
			String rm=bp.readLine();				
		    rm=rm.replace("Name:","");
			rm=rm.trim();
			String pm=bp.readLine();
			pm=pm.trim();
			File filo =new File("C:\\java\\APP\\name\\"+rm+" "+pm+"\\heart");
			//String ss=rm+" "+pm;
			File file =new File("");
			String[] d=filo.list(new FilenameFilter(/*"C:\\java\\APP\\name\\"+rm+" "+pm+"\\heart"*/){
				public boolean accept(File current,String name){
					return name.endsWith(".txt");
				}
			});
			int n=d.length;
			String b[]=new String[n+1];
			String bt[]=new String[n+1];
			for(int i=0;i<n;i++){
				if(d[i]==null)
				{continue;
				}
			d[i]=d[i].replaceAll(".txt","").trim();
			b[i+1]=d[i];
			d[i]=d[i].replaceAll(" Female","").replaceAll(" Male","").trim();
			System.out.println("  "+(i+1)+"."+d[i]);
			bt[i+1]=d[i];
			}
			System.out.println("\n Enter the serial number to Accept or reject\n\n\t Enter 0 to go back.");
			int a=in.nextInt();
			int ap;
			if(a==0)
			{ app(u,p);
			}
			
			if(a>d.length)
				{System.out.println("Invalid option. Try Again.");
				 app(u,p);}
			
			for(int i=1;i<30;i++)
			{
				if(a==i)
				{String r;
				BufferedReader bo=new BufferedReader(new FileReader("C:\\java\\APP\\name\\"+b[i]+"\\"+bt[i]+".txt"));
				while((r=bo.readLine())!=null)
				{System.out.println(r);
				}//String pp=bt[i]+" Female";
				 while(true){
				 System.out.println("\n1.Accept 2.Back");
			     String q=in.next();
				 switch(q)
				 {case "1": //accept();
				 case "2": app(u,p);
				 break;
				 default:System.out.println("\nInvalid option selected.\n");
				 break;
				 }
				 }
				}
				else
				{ continue;
					//System.out.println("Invalid option. Try Again.");
					//app(u,p);
				}
				
			}
			
		}
			
			
			
		
		
		
		private static void register()
		{
			System.out.print("Choose a username:");
			String u=in.next();
			
			while(true)
			{System.out.print("\nChoose a Password:");
			 String p=in.next();
			if(p.length()<4)
			{System.out.println("Your password must contain more than 4 character");
			}
			else
			{o=p;
			break;
			}
			}
			try{FileOutputStream obj= new FileOutputStream("C:\\java\\APP\\user\\"+u+o+".txt");
			System.out.println("\nEnter the information to complete registration:");
			while(true)
			{System.out.println("\n1.First name\n\n2.Last name\n\n3.City\n\n4.Gender\n\n5.Birthday\n\n6.EMAIL\n\n7.BIO\n\n8.Add Interests\n\n9.Back\n\n\t\t\t0.Enter\n");
			String k=in.next();
			switch(k){
			case "1":System.out.print("Enter first name:");
					 String fn =in.next();
					 fna=fn;
					 break;
			case "2":System.out.print("Enter last name:");
			         String ln =in.next();
					 lna=ln;
					 
					 break;
			case "3":System.out.print("Hey "+fna+", Enter your City:");
					 in.nextLine();
					 String add =in.nextLine();
					 ad=add;
					
					 break;
			case "4": aa:while(true)
						{System.out.println("Hey "+fna+",Enter your Gender:-\n1.Male\n2.Female\n3.Other");
						String gen =in.next();
						switch(gen)
						{	case "1": System.out.println("Male selected");
									  g="Male";
					  
						break aa;
						case "2": System.out.println("Female selected");
					                  g="Female";
						break aa;
						case "3": System.out.println("Others selected");
						             g="Other";
						break aa;
			
						default : System.out.println("Invalid Option selected, Enter again.");
						break;
						}
						}
						break;
						
			case "5":	while(true){
						System.out.println("Hey "+fna+",Enter your birthday(dd mm yyyy):");
						int d=in.nextInt();
						int m=in.nextInt();
						int y=in.nextInt();
						if(y+18>2019)
						{System.out.println("You're are underage. Please make sure you're at least 18 years old.");
						}	 
						else
						{	int age=2019-y;
						System.out.println("\n Great! You're "+age+" years old\n");
						agee=age;
						break;
						}
						break;
					
						}
			case "6":	in.nextLine();
						System.out.print("Email Address:");
						String em=in.nextLine();
						emol=em;
						break;
			case "7":	System.out.println("Hey "+fna+", Enter a bio for yourself:");
						in.nextLine();
						String bio=in.nextLine();
						bai=bio;
						break;
			case "8":	p:while(true){
						System.out.println("Hey "+fna+",Select Interests:::::\n\n1.Music\n\n2.Art\n\n3.Travelling\n\n4.Sports\n\n5.Gaming\n\n6.Eating\n\n7.Reading\n\n8.Lazy person\n\n9.Science\n\n0.Other\n\n\t\t00.Done");
						String q=in.next();
						switch(q){
						case"1":a[0]="Music";
						break;
						case"2":a[1]="Art";
						break;
						case"3":a[2]="Travelling";
						break;
						case"4":a[3]="Sports";
						break;
						case"5":a[4]="Gaming";
						break;
						case"6":a[5]="Eating";
						break;
						case"7":a[6]="Reading";
						break;
						case"8":a[7]="Lazy person";
						break;
						case"9":a[8]="Science";
						break;
						case"0":a[9]="Other";
						break;
						case"00": break p;
						default:System.out.println("Invalid Option selected, Enter again.");
						break;
						}
			}
			
			break;
			
			case "9": 	menu();
			case "0":   if(fna==null||lna==null||g==null||ad==null||agee==0||emol==null||bai==null||a==null)
			           { System.out.println("Please fill all the informations");
						 break;
					   }
						String c="\tName:"+fna+" "+lna;
                        byte b[]=c.getBytes();	
						obj.write(b);
						String cc1="\n\t"+g;
						byte bb1[]=cc1.getBytes();
						obj.write(bb1); 
						String c2="\n\n\tAddress:"+ad;
						byte b2[]=c2.getBytes();
						obj.write(b2);
						String c3="\n\n\tAge:"+agee;
						byte b3[]=c3.getBytes();
						obj.write(b3);
						String c2e="\n\n\tEmail Address:"+emol;
						byte b2e[]=c2e.getBytes();
						obj.write(b2e);
						String c20="\n\n\tAbout:\n"+bai;
						byte b20[]=c20.getBytes();
						obj.write(b20);
						String ii="\n\n\tInterests: ";
						byte bii[]=ii.getBytes();
						obj.write(bii);
						for(int i=0;i<10;i++){
						if(a[i]==null)
						{continue;
						}
						else
						{String c1="  "+a[i];
						byte bi[]=c1.getBytes();
						obj.write(bi);
						}
						}
						File dir=new File("C:\\java\\APP\\name\\"+fna+" "+lna+" "+g);
						dir.mkdir();
						File dirk=new File("C:\\java\\APP\\name\\"+fna+" "+lna+" "+g+"\\heart");
						dirk.mkdir();
						FileOutputStream oj=new FileOutputStream("C:\\java\\APP\\name\\"+fna+" "+lna+" "+g+"\\"+fna+" "+lna+".txt");
						oj.write(b);
						oj.write(bb1);
						oj.write(b3);
						oj.write(b20);
						File di=new File("C:\\java\\APP\\name\\"+fna+" "+lna+" "+g+"\\hobby");
						di.mkdir();
						for(int p=0;p<10;p++)
						{if(a[p]==null)
						{continue;
						}
						FileOutputStream oja=new FileOutputStream("C:\\java\\APP\\name\\"+fna+" "+lna+" "+g+"\\hobby\\"+a[p]+".txt");
						
						}	
						System.out.println("\nYour account has been created. Log in to access.\n");
						menu();
						
			default : System.out.println("Invalid Option selected. Try again\n");
			break;}
			}}
			
			catch(Exception e)
			{ System.out.println(e);
			}
		    }


}
	
	