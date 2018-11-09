package MainPackage;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*

   HCI 
GUI Design:

The data that is read from csv file is displayed using JTable to have easily manageable data on display and 
added a JScrollpane underneath the JTable, in case the amount of rows exceeds the length of the display. 
Using the scroll, user would be able to view all the rows in the CSV. One column is used and this would make 
it easy for user to analyse as there is only one column of data in the table. All fonts on this page is made
bolder and bigger than normal to make it easily noticeable by user. The font colours on this page are selected to be
noticeable by even colour blind users as not much colours are used everywhere. 



SECURITY AND RELATED ISSUES

-Adding a user log adds to the security of the program because this allows all users to see what other users
have searched for so if anything happens within the program, they could always refer back to what has been 
searched and by who.

-A user log where all logs in and logs out are recorded at what time would also make the system a lot secure
because that way, people would be able to see who logged in and at what time which could help tracking any issues
such as data being deleted or going missing.
This would allow admins to see who was logged in when things went wrong and ensure whoever is responsible is caught.

-If a user somehow gets access to the project, they could easily run the MAIN class and get access to all of the
data set compromising all security. There should be a way to prevent this.

*/



public final class WasteManagment extends javax.swing.JFrame {

    public TableRowSorter<TableModel> rowS;
    String UserName;
    String SearchedString;
    
      public WasteManagment() {
        initComponents();
        
        
        //CSVFile refers to public class below
        FileRead DataSet = new FileRead();
        //My Model class extends the Abstract Table Model below
        tableModel NewModel = new tableModel();
        //Sets the new model into my table called "Table"
        this.Table.setModel(NewModel);
        //Gets data from the csv which is in the quotations
        File DataFile = new File("both.csv");
        //Creates an array list for my rowsorter by reading the CSV file called "DataFile"
        ArrayList<String[]> RowsToAdd = DataSet.ReadCSVfile(DataFile);
        //Adds CSVData into the rowsorter
        NewModel.AddCSVData(RowsToAdd);
        //Prints all rows and columns into compiler below
        System.out.println("Rows: " + NewModel.getRowCount());
        System.out.println("Cols: " + NewModel.getColumnCount());

        rowS = new TableRowSorter<>(Table.getModel());
        Table.setRowSorter(rowS);
        


    }
    public WasteManagment(String username) {
        initComponents();
        //Username variable for the "Logged in as: " feature
        UserName = username;
        //Sets the text in the TextField to the user who is logged in
        LogUser.setText(UserName);
        
        
        //CSVFile refers to public class below
        FileRead DataSet = new FileRead();
        //My Model class extends the Abstract Table Model below
        tableModel NewModel = new tableModel();
        //Sets the new model into my table called "Table"
        this.Table.setModel(NewModel);
        //Gets data from the csv which is in the quotations
        File DataFile = new File("both.csv");
        //Creates an array list for my rowsorter by reading the CSV file called "DataFile"
        ArrayList<String[]> RowsToAdd = DataSet.ReadCSVfile(DataFile);
        //Adds CSVData into the rowsorter
        NewModel.AddCSVData(RowsToAdd);
        //Prints all rows and columns into compiler below
        System.out.println("Rows: " + NewModel.getRowCount());
        System.out.println("Cols: " + NewModel.getColumnCount());

        rowS = new TableRowSorter<>(Table.getModel());
        Table.setRowSorter(rowS);
        
       

    }

 
    //Method for reading CSV file
    public class FileRead {
        //Array list for each row in the CSV file
        private final ArrayList<String[]> AL = new ArrayList<>();
        private String[] RowToAdd;
        //Reads CSV file to fill the array
        public ArrayList<String[]> ReadCSVfile(File DataFile) {
            
            try {
                //Buffered reader
                BufferedReader BufferedR = new BufferedReader(new FileReader(DataFile));
                //While loop which reads each value from compiler and seperates them with a comma
                while (BufferedR.ready()) {
                    String MyString = BufferedR.readLine();
                    //Each value is split by a comma 
                    RowToAdd = MyString.split(",");
                    AL.add(RowToAdd);
                    //Prints all rows in the compiler one by one
                    System.out.println(Arrays.toString(RowToAdd));
                }//End of while loop

            }//end of try
            catch (Exception error) {
                String ErrorMessage = error.getMessage();
                System.out.println("File not found: " + ErrorMessage);

            }
            return AL;

        }
    }//Class end

    public  class tableModel extends AbstractTableModel {
        
        //Puts all column names into an array 
        private final String[] columnNames;
        private ArrayList<String[]> DataFromCsv = new ArrayList<String[]>();
        //My model stores all titles for each column but manually 
        //(need to find way to get these from the file directly)
        tableModel() {
            this.columnNames = new String[]{"Waste type and code","industrial sludges"};
        }
        //Add data from the csv file into the array
        public void AddCSVData(ArrayList<String[]> DataIn) {
            this.DataFromCsv = DataIn;
            this.fireTableDataChanged();
        }
        @Override
        public int getColumnCount() {
            return columnNames.length;
            //Gets column name length
        }
        @Override
        public int getRowCount() {
            return DataFromCsv.size();
            //Gets row size
        }
        @Override
        public String getColumnName(int col) {
            return columnNames[col];
            //Gets column names and stores them into "col"
        }
     
        
        @Override
        public Object getValueAt(int row, int col) {
            return DataFromCsv.get(row)[col];
        }
        
     public Object getValue(int r, int c){
         return DataFromCsv.get(r)[c]; 
     
     }   
        
        
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchBox = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        LogUser = new javax.swing.JTextField();
        LogOut = new javax.swing.JButton();
        UserLOG = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        MedainResultsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBoxActionPerformed(evt);
            }
        });

        SearchBtn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        Table.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title1", "Title2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(1).setMinWidth(100);
            Table.getColumnModel().getColumn(1).setPreferredWidth(100);
            Table.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Logged in as: ");

        LogUser.setEditable(false);
        LogUser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LogUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogUserActionPerformed(evt);
            }
        });

        LogOut.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        UserLOG.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        UserLOG.setText("Users Search Log");
        UserLOG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserLOGActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Median in Quartile:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(SearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86)
                            .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UserLOG)
                            .addGap(34, 34, 34)
                            .addComponent(LogOut))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addGap(33, 33, 33)
                            .addComponent(LogUser, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MedainResultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LogOut)
                        .addComponent(UserLOG)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MedainResultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBoxActionPerformed

    
    
    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
          Vector vec = new Vector(); 
          Object object = new Object();
          int subSum=0;
          int q1=0;
          int q2=0;
          int q3=0;
          int q4=0;
        //String which stores what the user searches
         SearchedString = SearchBox.getText();
        //String which stores the user who is logged in and sets the LogUser Text field to this new string
        String UserLoggedIn = LogUser.getText();
        
        //If statement which checks wha the user searches
        if (SearchedString.trim().length() == 0) {
            rowS.setRowFilter(null);
        } 
        else{
            //Sets the row filter to whatever the user searched
            rowS.setRowFilter(RowFilter.regexFilter("(?i)" + SearchedString));
             for(int i=0;i<Table.getRowCount();i++){
             object=Table.getValueAt(i,1);
             vec.add(object);
             }        
                 
            if(vec.size()>=4){
            double[] values = new double[vec.size()];
            //jtable methods filter colume, text you want to filter, only the rows will remain in the 
            int numberOfOpsInOneQuarter = vec.size() / 4;
            
            
           
             subSum = 0;

            for (int j = 0; j < numberOfOpsInOneQuarter; j++) {
                subSum += Integer.parseInt(String.valueOf(vec.get(j).toString()));
            }
          
             q1 = subSum / numberOfOpsInOneQuarter;
            
             subSum = 0;
            for (int j = (1 * numberOfOpsInOneQuarter); j < (2 * numberOfOpsInOneQuarter); j++) {
                subSum += Integer.parseInt(String.valueOf(vec.get(j).toString()));
            }

            
             q2 = subSum / numberOfOpsInOneQuarter;
            

            subSum = 0;
            for (int j = (2 * numberOfOpsInOneQuarter); j < (3 * numberOfOpsInOneQuarter); j++) {
                subSum += Integer.parseInt(String.valueOf(vec.get(j).toString()));
            }

            q3 = subSum / numberOfOpsInOneQuarter;
            

            subSum = 0;
            for (int j = (3 * numberOfOpsInOneQuarter); j < (4 * numberOfOpsInOneQuarter); j++) {
                subSum += Integer.parseInt(String.valueOf(vec.get(j).toString()));
            }

            q4 = subSum / numberOfOpsInOneQuarter;
        
             subSum = 0;
            for (int j = (4 * numberOfOpsInOneQuarter); j < (4 * numberOfOpsInOneQuarter); j++) {
                subSum += Integer.parseInt(String.valueOf(vec.get(j).toString()));
            }

            //int q5 = var / numberOfOpsInOneQuarter;
            
            MedainResultsLabel.setText("Median1:  " +Integer.toString(q1)+", " +" Median 2:  " +Integer.toString(q2) + ", " +" Median 3:  " +Integer.toString(q3) + ", " +" Median 4:  " +Integer.toString(q4));
            BarChart chart = new BarChart(q1,q2,q3,q4);
           
            JFrame barchart = new JFrame();
            barchart.setSize(350, 300);
            barchart.add(chart);
            barchart.setVisible(true);
            }
        else{
            MedainResultsLabel.setText("Not enough rows for operation"); 
            
            }
       }
             
            
        
        //Sets buffer writer to null
        BufferedWriter BuffWriter1 = null;
        //sets file writer to null
        FileWriter FileWriter1 = null;
        try {
            //Stores the user log file into a variable called File
            File file = new File("src/MainPackage/UserLog.txt");
            //Checks if the file exists in the folder and if not then it creates it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter1 = new FileWriter(file.getAbsoluteFile(), true);
            BuffWriter1 = new BufferedWriter(FileWriter1);
            //Writes each search into the .txt file using code below
            BuffWriter1.write("User: " + UserLoggedIn + " Searched for: " + SearchedString + "\r\n");
        } catch (IOException e) {
        } finally {
            try {
                if (BuffWriter1 != null) {
                    BuffWriter1.close();
                }
                if (FileWriter1 != null) {
                    FileWriter1.close();
                }
            } catch (IOException ex) {
            }
        }


    }//GEN-LAST:event_SearchBtnActionPerformed

   
    
    
    

        
    private void LogUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogUserActionPerformed
        // TODO add your handling code here:
        LogUser.setText(UserName);
    }//GEN-LAST:event_LogUserActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login LoginPage = new Login();
        LoginPage.setVisible(true);

    }//GEN-LAST:event_LogOutActionPerformed

    private void UserLOGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserLOGActionPerformed
        //UserLogs are created 
        UserLogs logs = new UserLogs();
        logs.setVisible(true);
        //Inputs all user logs into the UserLog.txt file
        File inputFile = new File("src/MainPackage/UserLog.txt");
        
        //Sets String answer to empty for now
        String answer = "";
        try {
            Scanner input = new Scanner (inputFile);
            while (input.hasNextLine()){
                //Creates new line
                answer += input.nextLine() + "\n";
               
                  
            }
            //Adds username to the user log txt
            logs.UserLogDisplay.setText(answer);
            //Exception
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } 
        
    }//GEN-LAST:event_UserLOGActionPerformed

    public static void main(String args[]) {

        //Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WasteManagment().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOut;
    private javax.swing.JTextField LogUser;
    private javax.swing.JLabel MedainResultsLabel;
    private javax.swing.JTextField SearchBox;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTable Table;
    private javax.swing.JButton UserLOG;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
