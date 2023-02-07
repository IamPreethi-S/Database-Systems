import mysql.connector
import csv
import os

mydb = mysql.connector.connect(host="acadmysqldb001p.uta.edu", user="pxs9233", password="Plmokn@2022", database="pxs9233")
mycursor = mydb.cursor()
print(mydb)
print(mycursor)

path= os.getcwd()
#Opening the .csv file fro the below given path and reading the csv data using csv.reader function
#skipping the header row of the columns and inserting the csv data into created tables of Mysql database 

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/library.csv') as f1:
         library_data = list(csv.reader(f1))
         print(list(library_data))
         for i in range(len(library_data)):
           if i == 0:
             continue
           else:
            print(library_data[i]) 
            mycursor.execute("INSERT INTO LIBRARY VALUES(%s,%s,%s,%s,%s)", [library_data[i][0], library_data[i][1],library_data[i][2], library_data[i][3], library_data[i][4]])
print("VALUES INSERTED INTO THE LIBRARY TABLE")
f1.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/publisher.csv') as f2:
         publisher_data = list(csv.reader(f2))
         print(list(publisher_data))
         for i in range(len(publisher_data)):
           if i == 0:
             continue
           else:
            print(publisher_data[i]) 
            mycursor.execute("INSERT INTO PUBLISHER VALUES(%s,%s,%s)", [publisher_data[i][0], publisher_data[i][1], publisher_data[i][2]])
print("VALUES INSERTED INTO THE PUBLISHER TABLE")
f2.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/books.csv') as f3:
         books_data = list(csv.reader(f3))
         print(list(books_data))
         for i in range(len(books_data)):
           if i == 0:
             continue
           else:
            print(books_data[i]) 
            mycursor.execute("INSERT INTO BOOKS VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)", [books_data[i][0], books_data[i][1],books_data[i][2],books_data[i][3],books_data[i][4],books_data[i][5],books_data[i][6],books_data[i][7],books_data[i][8],books_data[i][9],books_data[i][10],books_data[i][11]])
print("VALUES INSERTED INTO THE BOOKS TABLE")
f3.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/member.csv') as f4:
         member_data = list(csv.reader(f4))
         print(list(member_data))
         for i in range(len(member_data)):
           if i == 0:
             continue
           else:
            print(member_data[i]) 
            mycursor.execute("INSERT INTO MEMBER VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)", [member_data[i][0], member_data[i][1], member_data[i][2], member_data[i][3], member_data[i][4], member_data[i][5], member_data[i][6], member_data[i][7], member_data[i][8], member_data[i][9], member_data[i][10]])
print("VALUES INSERTED INTO THE MEMBER TABLE")
f4.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/author.csv') as f5:
         author_data = list(csv.reader(f5))
         print(list(author_data))
         for i in range(len(author_data)):
           if i == 0:
             continue
           else:
            print(author_data[i]) 
            mycursor.execute("INSERT INTO AUTHOR VALUES(%s,%s,%s)", [author_data[i][0], author_data[i][1], author_data[i][2]])
print("VALUES INSERTED INTO THE AUTHOR TABLE")
f5.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/book_author.csv') as f6:
         book_author_data = list(csv.reader(f6))
         print(list(book_author_data))
         for i in range(len(book_author_data)):
           if i == 0:
             continue
           else:
            print(book_author_data[i]) 
            mycursor.execute("INSERT INTO BOOK_AUTHOR VALUES(%s,%s,%s,%s)", [book_author_data[i][0], book_author_data[i][1], book_author_data[i][2], book_author_data[i][3]])
print("VALUES INSERTED INTO THE BOOK_AUTHOR TABLE")
f6.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/book_available.csv') as f7:
         book_available_data = list(csv.reader(f7))
         print(list(book_available_data))
         for i in range(len(book_available_data)):
           if i == 0:
             continue
           else:
            print(book_available_data[i]) 
            mycursor.execute("INSERT INTO BOOK_AVAILABLE VALUES(%s,%s,%s)", [book_available_data[i][0], book_available_data[i][1],book_available_data[i][2]])
print("VALUES INSERTED INTO THE BOOK_AVAILABLE TABLE")
f7.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/book_require.csv') as f8:
         us_book_require_data = list(csv.reader(f8))
         print(list(us_book_require_data))
         for i in range(len(us_book_require_data)):
           if i == 0:
             continue
           else:
            print(us_book_require_data[i]) 
            mycursor.execute("INSERT INTO BOOK_REQUIRE VALUES(%s,%s)", [us_book_require_data[i][0], us_book_require_data[i][1]])
print("VALUES INSERTED INTO THE BOOK_REQUIRE TABLE")
f8.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/lib_staff.csv') as f9:
         lib_staff_data = list(csv.reader(f9))
         print(list(lib_staff_data))
         for i in range(len(lib_staff_data)):
           if i == 0:
             continue
           else:
            print(lib_staff_data[i]) 
            mycursor.execute("INSERT INTO LIB_STAFF VALUES(%s,%s,%s,%s,%s)", [lib_staff_data[i][0], lib_staff_data[i][1],lib_staff_data[i][2], lib_staff_data[i][3], lib_staff_data[i][4]])
print("VALUES INSERTED INTO THE LIB_STAFF TABLE")
f9.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/book_issue.csv') as f10:
         book_issue_data = list(csv.reader(f10))
         print(list(book_issue_data))
         for i in range(len(book_issue_data)):
           if i == 0:
             continue
           else:
            print(book_issue_data[i]) 
            mycursor.execute("INSERT INTO BOOK_ISSUE VALUES(%s,%s,%s,%s,%s,%s,%s,%s)", [book_issue_data[i][0], book_issue_data[i][1], book_issue_data[i][2], book_issue_data[i][3], book_issue_data[i][4], book_issue_data[i][5], book_issue_data[i][6], book_issue_data[i][7]])
print("VALUES INSERTED INTO THE BOOK_ISSUE TABLE")
f10.close()

with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/Lib_staff_member.csv') as f11:
         lib_staff_member_data = list(csv.reader(f11))
         print(list(lib_staff_member_data))
         for i in range(len(lib_staff_member_data)):
           if i == 0:
             continue
           else:
            print(lib_staff_member_data[i]) 
            mycursor.execute("INSERT INTO LIB_STAFF_MEMBER VALUES(%s,%s)", [lib_staff_member_data[i][0], lib_staff_member_data[i][1]])
print("VALUES INSERTED INTO THE LIB_STAFF_MEMBER TABLE")
f11.close()


with open('C:/Users/Preethi/Desktop/UTA SEM-1/Database/PROJECT/DB_PROJECT_2/CSE_5330_005_databaseSystems_Project2_Part3/Data/member_phone.csv') as f12:
         member_phone_data = list(csv.reader(f12))
         print(list(member_phone_data))
         for i in range(len(member_phone_data)):
           if i == 0:
             continue
           else:
            print(member_phone_data[i]) 
            mycursor.execute("INSERT INTO MEMBER_PHONE VALUES(%s,%s)", [member_phone_data[i][0], member_phone_data[i][1]])
print("VALUES INSERTED INTO THE MEMBER_PHONE TABLE")
f12.close()

mydb.commit()
