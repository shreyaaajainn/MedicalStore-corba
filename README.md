# MedicalStore-corba
Medical Store implemented using Corba in Windows.
You can order multiple medicines, make payment and see cart on command line.
Steps:
1. Download the project. Unzip the contents

2. Run the IDL file using the command : 

idlj -fall store.idl 

This command will create a folder named MedicalStore.

3. Create Client.java file.

4. Create Server.java file.

5.  Compile all files using the command:  

javac *.java 

6. Start ordb from terminal using command:

orbd -ORBInitialPort 1050&

7. Start Server using the command:

java Server -ORBInitialPort 1050 -ORBInitialHost localhost&

8. Start Client using the command:

java Client -ORBInitialPort 1050 -ORBInitialHost localhost


