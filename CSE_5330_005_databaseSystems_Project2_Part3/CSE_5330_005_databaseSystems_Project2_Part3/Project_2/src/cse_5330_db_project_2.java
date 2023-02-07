import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class cse_5330_db_project_2 {
    public static void main(String[] args) {
        try {  
            Connection conn = Database_connect();
            int i=1;
            System.out.println(" ************ Library Management System *************** ");
            while(true){          
                if(i==7) // When the input option entered by user is 7 its Exit else the other operations are performed
                {
                    System.out.println("Exiting the program..");
                    break;
                    // Exit
                }
                else {
                    // 6 operations are performed as required for the DDB Project 2 Phase 3
                    System.out.println("1. Use database");
                    System.out.println("2. Printing and Displaying tables from Library database");
                    System.out.println("3. Generate Weekly borrowing activity report");
                    System.out.println("4. New Transactions on Library Database");
                    System.out.println("5. Membership Renewal");
                    System.out.println("6. Trigger Execution for Overdue books and Membership renewal");
                    System.out.println("7. Exit");
                    System.out.println("Enter your choice of operation...");
                    Scanner scan = new Scanner(System.in);
                    i = scan.nextInt();
                    System.out.println("");
                    // Getting the input choice from command prompt and passing it to switch case to get the appropriate operation completed
                    switch(i) {
                        case 1:
                            Use_database_connection(conn);
                            break;
                        case 2:
                            Display_data(conn);
                            break;
                        case 3:
                            Generate_weekly_borrowing_activity_report(conn);
                            break;
                        case 4:
                            New_transactions_on_library_database(conn);
                            break;
                        case 5:
                            Membership_renewal(conn);
                            break;
                        case 6:
                            Trigger_execution_for_overduebooks_and_membership_renewal(conn);
                            break;
                        case 7:
                            break;
                        default:
                            System.out.println("Invalid Choice. Please try again...");
                            break;
                    }
                }
            }         
        }catch(Exception e) {            
            System.out.println("Main method Exception: "+e);            
        }             
    }
    
    // Database Connection is established, providing credentials to connect to the Mysql database
    static Connection Database_connect() {
        try {           
            String Jdbc_Driver = "com.mysql.jdbc.Driver";
            String Host = "jdbc:mysql://acadmysqldb001p/";
            String User = "pxs9233";
            String Pwd = "Plmokn@2022";
            Class.forName(Jdbc_Driver);
            Connection conn = DriverManager.getConnection(Host,User,Pwd);
            return conn;                 
        }catch(Exception e) { // Exception to catch if not connected to the Mysql database 
            System.out.println("Unable to connect to Mysql database, database connection Exception:"+e);
        }
        return null;        
    }
    
// Operation 1 - use database inorder to access all the tables created inside the db pxs9233 for CSE_5330_005_Project_2 Part 3
    public static void Use_database_connection (Connection conn) {
        
        try {
            Statement stmt = conn.createStatement();        
            String Library_Management = "USE pxs9233";
            stmt.executeUpdate(Library_Management);
            stmt.close();            
            System.out.println("Database pxs9233 Selected.\n");
        }catch(Exception e) {            
            System.out.println("Create_Database Function Exception, Unable to connect: "+e);
        }
    }
// Space function is created to provide user readability while displaying the data from teh tables created within 'pxs9233' db    
    public static void space(int a,int b) {
        
        for (int i=b;i<=a;i++){
            System.out.print(" ");
        }
    }
    
// Operation 2 -Display Data to display and print all the tables and their data within 'pxs9233' db
    public static void Display_data(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE pxs9233");
            System.out.println("Enter the number of your choice to print the respective table from the Library Database");
            System.out.println("1. Library");
            System.out.println("2. Publisher");
            System.out.println("3. Books");
            System.out.println("4. Member");
            System.out.println("5. Author");
            System.out.println("6. Book_author");
            System.out.println("7. Book_available");
            System.out.println("8. Book_require");
            System.out.println("9. Lib_stmtaff");
            System.out.println("10. Book_issue");
            System.out.println("11. Lib_stmtaff_member");
            System.out.println("12. Member_phone");

           System.out.print("Enter Your Choice: ");
           //Displaying the list of 12 table and getting the user input from cmd to display the table contents.
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            ResultSet result = stmt.executeQuery("SELECT * from Member");
            //passing the user input choice to switch case and displaying the contents of appropriate table selected
            switch(i) {
                case 1:
                    result = stmt.executeQuery("SELECT * from Library");
                    System.out.print("\n\n Library: \n\n");
                    System.out.print("Lib_code "); space(12,8);
                    System.out.print("Lib_name "); space(15,8);
                    System.out.print("Lib_city "); space(12,8);
                    System.out.print("Lib_state "); space(10,9);
                    System.out.print("Lib_country \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(12, result.getString(1).length());
                        System.out.print(result.getString(2)+" ");  space(15, result.getString(2).length());
                        System.out.print(result.getString(3)+" ");  space(12, result.getString(3).length());
                        System.out.print(result.getString(4)+" ");  space(10, result.getString(4).length());
                        System.out.print(result.getString(5)+" \n");
                    }
                    break;
                case 2:
                    result = stmt.executeQuery("SELECT * from Publisher");
                    System.out.print("\n\nPublisher:\n\n");
                    System.out.print("Publisher_id "); space(12,12);
                    System.out.print("Publisher_name "); space(25,14);
                    System.out.print("Publication_year \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(12, result.getString(1).length());
                        System.out.print(result.getString(2)+" ");  space(25, result.getString(2).length());
                      System.out.print(result.getString(3)+" \n");
                    }
                    break;
                case 3:
                    result = stmt.executeQuery("SELECT * from Books");
                    System.out.print("\n\nBooks:\n\n");
                    System.out.print("Isbn "); space(15,4);
                    System.out.print("Book Title "); space(40,10);
                    System.out.print("Author_Id "); space(15,9);
                    System.out.print("Subject Area "); space(40,12);
                    System.out.print("Description "); space(250,11);
                    System.out.print("Category "); space(20,8);
                    System.out.print("Is_lendable "); space(20,11);
                    System.out.print("Language "); space(12,8);
                    System.out.print("Binding "); space(12,7);
                    System.out.print("Edition "); space(12,7);
                    System.out.print("Lib_code "); space(12,8);
                    System.out.print("Publisher_id \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(15, result.getString(1).length());
                        System.out.print(result.getString(2)+" ");  space(40, result.getString(2).length());
                        System.out.print(result.getString(3)+" ");  space(15, result.getString(3).length());
                        System.out.print(result.getString(4)+" ");  space(40, result.getString(4).length());
                        System.out.print(result.getString(5)+" ");  space(250, result.getString(5).length());
                        System.out.print(result.getString(6)+" ");  space(20, result.getString(6).length());
                        System.out.print(result.getString(7)+" ");  space(20, result.getString(7).length());
                        System.out.print(result.getString(8)+" ");  space(12, result.getString(8).length());
                        System.out.print(result.getString(9)+" ");  space(12, result.getString(9).length());
                        System.out.print(result.getString(10)+" ");  space(12, result.getString(10).length());
                        System.out.print(result.getString(11)+" "); space(12, result.getString(11).length());
                        System.out.print(result.getString(12)+" \n");
                    }
                    break;
                case 4:
                    result = stmt.executeQuery("SELECT * from Member");
                    System.out.print("\n\nMember:\n\n");
                    System.out.print("Ssn ");   space(15,3);
                    System.out.print("Member_fname ");   space(18,12);
                    System.out.print("Member_lname ");   space(20,12);
                    System.out.print("Campus_mailing_address ");   space(50,22);
                    System.out.print("Home_mailing_address ");   space(50,20);
                    System.out.print("Phone ");   space(15,5);
                    System.out.print("Lib_card_no ");   space(15,11);
                    System.out.print("Lib_card_expiry ");   space(15,15);
                    System.out.print("Is_member_active "); space(20,16);
                    System.out.print("Is_prof "); space(15,7);
                    System.out.print("Lib_code \n");
                    while(result.next()) {
                        System.out.print(result.getString(1)+" ");  space(15, result.getString(1).length());
                        System.out.print(result.getString(2)+" ");  space(18, result.getString(2).length());
                        System.out.print(result.getString(3)+" ");  space(20, result.getString(3).length());
                        System.out.print(result.getString(4)+" ");  space(50, result.getString(4).length());
                        System.out.print(result.getString(5)+" ");  space(50, result.getString(5).length());
                        System.out.print(result.getString(6)+" ");  space(15, result.getString(6).length());
                        System.out.print(result.getString(7)+" ");  space(15, result.getString(7).length());
                        System.out.print(result.getString(8)+" ");  space(15, result.getString(8).length());
                        System.out.print(result.getString(9)+" ");  space(20, result.getString(9).length());
                        System.out.print(result.getString(10)+" "); space(15, result.getString(10).length());
                        System.out.print(result.getString(11)+"\n");
                    }
                break;
                case 5:
                    result = stmt.executeQuery("SELECT * from Author");
                    System.out.print("\n\nAuthor:\n\n");
                    System.out.print("Author_id "); space(10,9);
                    System.out.print("Author_fname "); space(12,12);
                    System.out.print("Author_lname \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(10, result.getString(1).length());
                        System.out.print(result.getString(2)+" ");  space(12, result.getString(2).length());
                        System.out.print(result.getString(3)+" \n");
                    }
                    break;
                case 6:
                    result = stmt.executeQuery("SELECT * from Book_author");
                    System.out.print("\n\nTable: Book_author:\n\n");
                    System.out.print("Isbn "); space(15,4);
                    System.out.print("Author_id \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(15, result.getString(1).length());
                        System.out.print(result.getString(2)+" \n");  
                    }
                break;
                case 7:
                    result = stmt.executeQuery("SELECT * from Book_available");
                    System.out.print("\n\nBook_available:\n\n");
                    System.out.print("Isbn "); space(15,4);
                    System.out.print("Total_copies "); space(15,12);
                    System.out.print("Available_copies \n"); 
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(15, result.getString(1).length());
                        System.out.print(result.getString(2)+" ");  space(15, result.getString(2).length());
                        System.out.print(result.getString(3)+" \n");  
                    }
                break;
                case 8:
                result = stmt.executeQuery("SELECT * from Book_require");
                System.out.print("\n\nBook_require:\n\n");
                System.out.print("Isbn "); space(15,4);
                System.out.print("Total_book_require \n"); 
                while(result.next()){
                    System.out.print(result.getString(1)+" ");  space(15, result.getString(1).length());
                    System.out.print(result.getString(2)+" \n");  
                }
                break;
                case 9:
                    result = stmt.executeQuery("SELECT * from Lib_staff");
                    System.out.print("\n\nLib_staff:\n\n");
                    System.out.print("Staff_id "); space(12,8);
                    System.out.print("Staff_fname "); space(12,11);
                    System.out.print("Staff_lname "); space(18,11);
                    System.out.print("Staff_type "); space(36,10);
                    System.out.print("Lib_code \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(12, result.getString(1).length());
                        System.out.print(result.getString(2)+" ");  space(12, result.getString(2).length());
                        System.out.print(result.getString(3)+" ");  space(18, result.getString(3).length());
                        System.out.print(result.getString(4)+" ");  space(36, result.getString(4).length());
                        System.out.print(result.getString(5)+" \n");
                    }
                    break;
                case 10:
                    result = stmt.executeQuery("SELECT * from Book_issue");
                    System.out.print("\n\nBook_issue:\n\n");
                    System.out.print("Issue_id "); space(10,8);
                    System.out.print("Ssn ");   space(15,3);
                    System.out.print("Staff_id "); space(10,8);
                    System.out.print("Isbn "); space(15,4);
                    System.out.print("Issue_date "); space(12,10);
                    System.out.print("Due_date "); space(12,8);
                    System.out.print("Notice_date "); space(12,11);
                    System.out.print("Is_returned \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(10, result.getString(1).length());
                        System.out.print(result.getString(2)+" ");  space(15, result.getString(2).length());
                        System.out.print(result.getString(3)+" ");  space(10, result.getString(3).length());
                        System.out.print(result.getString(4)+" ");  space(15, result.getString(4).length());
                        System.out.print(result.getString(5)+" ");  space(12, result.getString(5).length());
                        System.out.print(result.getString(6)+" ");  space(12, result.getString(6).length());
                        System.out.print(result.getString(7)+" ");  space(12, result.getString(7).length());
                        System.out.print(result.getString(8)+" \n");
                    }
                    break;
                case 11:
                    result = stmt.executeQuery("SELECT * from Lib_staff_member");
                    System.out.print("\n\nLib_staff_member:\n\n");
                    System.out.print("Staff_id "); space(12,8);
                    System.out.print("Ssn \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(12, result.getString(1).length());
                        System.out.print(result.getString(2)+" \n");
                    }
                    break;
                case 12:
                    result = stmt.executeQuery("SELECT * from Member_phone");
                    System.out.print("\n\nMember_phone:\n\n");
                    System.out.print("Ssn "); space(15,3);
                    System.out.print("Phone \n");
                    while(result.next()){
                        System.out.print(result.getString(1)+" ");  space(15, result.getString(1).length());
                        System.out.print(result.getString(2)+" \n");
                    }
                    break;
                default:
                    System.out.println("Invalid Choice!, Please try again with valid choices as listed above");
                break;
            }
            stmt.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Display_data function Exception: "+e);
        }
    }
    public static void Generate_weekly_borrowing_activity_report(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE pxs9233");
            System.out.print("\n Weekly Borrowing Activity Report Of Library: \n\n");
            ResultSet result = stmt.executeQuery("SELECT A.Isbn,A.Title,count(B.ISBN) AS No_of_copies,week(B.Issue_date) AS Week_No,SUM(datediff(B.Notice_date,B.Issue_date)) AS No_of_Days_Loaned_Out,A.Subject_area,C.Author_fname, C.Author_lname from Books as A INNER JOIN Book_issue as B ON A.ISBN=B.ISBN INNER JOIN Book_author as C ON A.Author_id=C.Author_id GROUP BY A.Subject_area,A.Author_id,C.Author_fname, C.Author_lname,B.ISBN,week(B.Issue_date)");
            System.out.print("ISBN "); space(15,4);
            System.out.print("Book Title "); space(40,10);
            System.out.print("No._of_copies "); space(14,13);
            System.out.print("Week_No. "); space(9,8);
            System.out.print("No_of_Days_Loaned_Out "); space(22,21);
            System.out.print("Subject Area "); space(40,12);
            System.out.println("Author First Name \n");
            while(result.next()){
                System.out.print(result.getString(1)+" ");  space(15, result.getString(1).length());
                System.out.print(result.getString(2)+" ");  space(40, result.getString(2).length());
                System.out.print(result.getString(3)+" ");  space(14, result.getString(3).length());
                System.out.print(result.getString(4)+" ");  space(9, result.getString(4).length());
                System.out.print(result.getString(5)+" ");  space(22, result.getString(5).length());
                System.out.print(result.getString(6)+" ");  space(40, result.getString(6).length());
                System.out.print(result.getString(7)+" \n");
            }
            stmt.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Weekly_borrowing_activity_report function Exception: "+e);
        }
    }
        
    public static void New_transactions_on_library_database (Connection conn) {

        try {
            System.out.println("Which of the below transactions do you want to perform on Library database?.");
            System.out.println("1. Adding New Member to the Library database.");
            System.out.println("2. Adding New Book to the Library database.");
            System.out.println("3. To Borrow a Book from the Library database.");
            System.out.println("4. To Return a Book to the Library database.");
            System.out.print("Enter your choice of operation to be performed: ");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();

            switch(i){

                case 1:
                    Add_New_Member(conn);
                    break;
               case 2:
                   Add_New_book(conn);
                   break;
               case 3:
                   Book_borrow(conn);
                   break;
               case 4:
                   Book_return(conn);
                   break;
               default:
                   System.out.println("Invalid Choice. Please try again with valid choices as listed above");
                   break;
            }
        }catch(Exception e) {
            System.out.println("New_Transaction function Exception:" +e);
        }         
    }

//Transaction function for adding new member
    public static void Add_New_Member (Connection conn){
        try {
            System.out.println("\nEnter Details of New Member to be added to the Library database.");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter SSN: ");
            String ssn = sc.nextLine();
            System.out.print("\nEnter Member first name: ");
            String member_fname = sc.nextLine();
            System.out.print("\nEnter Member last name: ");
            String member_lname = sc.nextLine();
            System.out.print("Enter Campus mailing Address: ");
            String campus_mailing_add = sc.nextLine();
            System.out.print("Enter Home mailing Address: ");
            String home_mailing_add = sc.nextLine();
            System.out.print("Enter Phone number: ");
            String phone = sc.nextLine();
            System.out.print("Enter Library Card No.: ");
            String lib_card_no = sc.nextLine();
            System.out.print("Enter Library Card Expiry Date(yyyy-mm-dd): ");
            String lib_card_expiry = sc.nextLine();
            System.out.print("Is Member Active(0/1)? ");
            String is_mem_active = sc.nextLine();
            System.out.print("Is Professor(0/1)? ");
            String is_prof = sc.nextLine();
            System.out.print("Enter Library Code ");
            String lib_code = sc.nextLine();

// The user input from cmd is now given to the sql statement for the record to be inserted into the Members table
            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE pxs9233");
            String sql = "INSERT INTO Member values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,ssn);
            ps.setString(2,member_fname);
            ps.setString(3,member_lname);
            ps.setString(4,campus_mailing_add);
            ps.setString(5,home_mailing_add);
            ps.setString(6,phone);
            ps.setString(7,lib_card_no);
            ps.setString(8,lib_card_expiry);
            ps.setString(9,is_prof);
            ps.setString(10,is_mem_active);
            ps.setString(11,lib_code);
            ps.execute();
            stmt.close();
            System.out.println("\nNew Member details added Successfully to the library database.\n");
        }catch (SQLException e) {
            System.out.println("New_Member function Exception: "+e);
        }
    }
//Transaction function for adding new book
    public static void Add_New_book (Connection conn) {
        
        try {
            System.out.println("\nEnter Details of New Books to be added to the library database");
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter Isbn: ");
            String isbn = sc.nextLine();
            System.out.print("Enter Tile: ");
            String tile = sc.nextLine();
            System.out.print("Enter Author_id: ");
            String author_id = sc.nextLine();
            System.out.print("Enter Subject Area: ");
            String subject_area = sc.nextLine();
            System.out.print("Enter Description: ");
            String desc = sc.nextLine();
            System.out.print("Enter Category/Type of book: ");
            String category = sc.nextLine();
            System.out.print("Is Lendable(0/1)?: ");
            String lend = sc.nextLine();
            System.out.print("Enter Language: ");
            String lan = sc.nextLine();
            System.out.print("Enter Binding: ");
            String bind = sc.nextLine();
            System.out.print("Enter Edition: ");
            String edition = sc.nextLine();
            System.out.print("Enter Library code: ");
            String lib_code = sc.nextLine();
            System.out.print("Enter Publisher Id: ");
            String publisher_id = sc.nextLine();
// The user input from cmd is now given to the sql statement for the record to be inserted into the Books table

            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE pxs9233");
            String sql = "INSERT INTO Books values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,isbn);
            ps.setString(2,tile);
            ps.setString(3,author_id);
            ps.setString(4,subject_area);
            ps.setString(5,desc);
            ps.setString(6,category);
            ps.setString(7,lend);
            ps.setString(8,lan);
            ps.setString(9,bind);
            ps.setString(10,edition);
            ps.setString(11,lib_code);
            ps.setString(12,publisher_id);
            ps.execute();
            stmt.close();
            System.out.println("\nNew Book Added Successfully.\n");
        }catch(SQLException e) {
            System.out.println("New_book function Exception: "+e);
        }
    }
//Transaction function for borrowing available from library
    public static void Book_borrow(Connection conn){
        
        try {
            System.out.println("\nEnter Details to Borrow a Book.");
            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE pxs9233");
            System.out.print("\nEnter Your SSN: ");
            Scanner sc = new Scanner(System.in);
            String ssn = sc.nextLine();            
            ResultSet result = stmt.executeQuery("SELECT * FROM Member WHERE SSN="+ssn);
            if(result.next()==false){
                System.out.println("Sorry! You are not a member of Library or Invalid SSN.\n");
            }else { 
                System.out.print("Enter Book ISBN: ");
                String s = sc.nextLine();
                result = stmt.executeQuery("select * from Book_available where ISBN="+s+" AND Available_copies<>0");
                if(result.next()==false) {
                    System.out.println("Sorry! Book is not Available or Invalid ISBN.\n");
                }else {
                    String t,u;
                    int t1=0; int u1=0;
                    result = stmt.executeQuery("SELECT Available_copies from Book_available where ISBN="+s);
                    while(result.next()) {
                        t = result.getString(1);
                        t1 = Integer.parseInt(t);
                        t1=t1-1;
                    }            
                    LocalDate today = LocalDate.now();
                    LocalDate today_23 = today.plusDays(23);
                    LocalDate today_23_7 = today_23.plusDays(7);
                    LocalDate today_3_month = today.plusMonths(3);
                    LocalDate today_3_month_7 = today_3_month.plusDays(7);
                    result = stmt.executeQuery("SELECT Is_prof from Member where SSN="+ssn+" AND Is_member_active=1");
                    if(result.next()==false){
                        System.out.println("Sorry! You are not active member of library.\n");
                    }else{ 
                        result = stmt.executeQuery("SELECT Is_prof from Member where SSN="+ssn+" AND Is_member_active=1");
                        while(result.next()){
                            u = result.getString(1);
                            u1 = Integer.parseInt(u);
                        }                    
                        result = stmt.executeQuery("select * from Book_issue");
                        int connt = 0;
                        while(result.next()) {
                            connt++;
                        }connt++;
                        if(u1==1){
                            stmt.executeUpdate("INSERT INTO Book_issue values ("+String.valueOf(connt)+","+ssn+",5,"+s+",'"+String.valueOf(today)+"','"+String.valueOf(today_3_month)+"','"+String.valueOf(today_3_month_7)+"',0)");
                            stmt.executeUpdate("UPDATE Book_available SET Available_copies="+String.valueOf(t1)+" WHERE ISBN="+s);
                            System.out.println("Book Borrowed Successfully.\n");
                        }else{
                            stmt.executeUpdate("INSERT INTO Book_issue values ("+String.valueOf(connt)+","+ssn+",5,"+s+",'"+String.valueOf(today)+"','"+String.valueOf(today_23)+"','"+String.valueOf(today_23_7)+"',0)");
                            stmt.executeUpdate("UPDATE Book_available SET Available_copies="+String.valueOf(t1)+" WHERE ISBN="+s);
                            System.out.println("Book Borrowed Successfully.\n");
                        }
                    }
                }               
            } 
            stmt.close();
        }catch(Exception e){
            System.out.println("New_borrow function Exception: "+e);
        }
    }

//Transaction function for returning a book back to the library
    public static void Book_return(Connection conn) {
        
        try {
            System.out.println("\nEnter the below details to Return a Book to the Library.");
            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE pxs9233");
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter Your Ssn: ");
            String ssn = sc.nextLine();
            System.out.print("Enter Book Isbn: ");
            String s = sc.nextLine();
            
            ResultSet result = stmt.executeQuery("SELECT * from Book_issue where Ssn="+ssn+" AND Isbn="+s+" AND Is_returned=0 LIMIT 1");
            if(result.next()==false){
                System.out.println("You did not borrow any book.\n");
            }else { 
                stmt.executeUpdate("UPDATE Book_issue SET Is_returned=1 WHERE Ssn="+ssn+" AND Isbn="+s);
                result = stmt.executeQuery("SELECT Available_copies from Book_available where Isbn="+s);
                String t;
                int t1=0;
                while(result.next()) {
                    t = result.getString(1);
                    t1 = Integer.parseInt(t);
                    t1=t1+1;
                }
                stmt.executeUpdate("UPDATE Book_issue SET Is_returned=1 WHERE Ssn="+ssn+" AND Isbn="+s);
                stmt.executeUpdate("UPDATE Book_available SET Available_copies="+String.valueOf(t1)+" WHERE Isbn="+s);
                System.out.println("Book Returned Successfully.");
                result = stmt.executeQuery("SELECT B.Title,DATEDIFF(CURDATE(),A.Issue_date) AS Total_Borrow_Days,A.Issue_Date,CURDATE() AS Return_Date FROM Book_issue A INNER JOIN Books B ON A.Isbn=B.Isbn WHERE A.Ssn="+ssn+" AND A.Isbn="+s+" LIMIT 1");
                System.out.print("\nBook Return Receipt:\n");
                System.out.print("Title "); space(40,5);
                System.out.print("Total_Borrow_Days "); space(22,20);
                System.out.print("Issue_Date "); space(12,10);
                System.out.print("Return_Date \n"); 
                while(result.next()){
                    System.out.print(result.getString(1)+" ");  space(40, result.getString(1).length());
                    System.out.print(result.getString(2)+" ");  space(22, result.getString(2).length());
                    System.out.print(result.getString(3)+" ");  space(12, result.getString(3).length());
                    System.out.print(result.getString(4)+" \n");  
                }
                System.out.println("\n");
            }
            stmt.close();
        }catch(Exception e) {
            System.out.println("Book_return function Exception: "+e);
        }
    }
//Membership Renewal function created
    public static void Membership_renewal (Connection conn) {
        
        try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE pxs9233");
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter Your SSN: ");
            String ssn = sc.nextLine();
            
            ResultSet result = stmt.executeQuery("SELECT * from Member where SSN="+ssn);
            if(result.next()==false){
                System.out.println("Sorry! You are not a member of Library or Invalid Ssn. Please try again later with a valid Ssn..\n");
            }else {
                LocalDate today = LocalDate.now();
                LocalDate today__6_months = today.plusMonths(6);    
                stmt.executeUpdate("UPDATE Member SET lib_card_expiry='"+today__6_months+"', Is_member_active=1 WHERE SSN="+ssn);
                System.out.println("Your membership is renewed and extended by 6 months.\n");
            }
            stmt.close();
        }catch(SQLException e) {
            System.out.println("Renew_membership function Exception: "+e);
        }
    }    
    
    public static void Trigger_execution_for_overduebooks_and_membership_renewal (Connection conn) {
        
       try {
            Statement stmt = conn.createStatement();
            stmt.executeQuery("USE pxs9233");
                        
            ResultSet result = stmt.executeQuery("SELECT * FROM Book_overdue");
            System.out.println("Trigger-1: Book Overdue Details:");
            System.out.print("No. ");   space(5,3);
            System.out.print("SSN ");   space(13,3);
            System.out.print("ISBN "); space(15,4);
            System.out.print("Notice Date \n");
            while(result.next()){
                System.out.print(result.getString(1)+" ");  space(5, result.getString(1).length());
                System.out.print(result.getString(2)+" ");  space(13, result.getString(2).length());
                System.out.print(result.getString(3)+" ");  space(15, result.getString(3).length());
                System.out.print(result.getString(4)+" \n");  
            }
            
            result = stmt.executeQuery("SELECT * FROM renew_membership");
            System.out.println("\nTrigger-2: membership Renewal Details:");
            System.out.print("No. ");   space(5,3);
            System.out.print("SSN ");   space(13,3);
            System.out.print("Member_fname \n");
            while(result.next()){
                System.out.print(result.getString(1)+" ");  space(5, result.getString(1).length());
                System.out.print(result.getString(2)+" ");  space(13, result.getString(2).length());
                System.out.print(result.getString(3)+" \n");
            }
            stmt.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("membership_renewal function Exception: "+e);
        }
    }
}