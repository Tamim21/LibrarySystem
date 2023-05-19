package com.mycompany.assign3;
import java.util.ArrayList;
import javax.swing.JTable;


import javax.swing.table.DefaultTableModel;
public final class viewBooks extends javax.swing.JFrame{

    public void setData()
    {
       DefaultTableModel Model1=(DefaultTableModel) jTable1.getModel();
       LibrarianRole lr = new LibrarianRole();
        Book[] b = lr.getListOfBooks();
        for(int i=0; i<b.length;i++)
        {
            String quantity = Integer.toString(b[i].getQuantity());
            String Data [] = {b[i].getID(), b[i].getName(), b[i].getAuthorName(),b[i].getPublisherName(),quantity};
            Model1.addRow(Data);
        }
   
    }
    public viewBooks() {
        initComponents();
        this.setData();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("View Books");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int r,int c){
                return false;
            }};
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Book ID", "Title", "Author Name", "Publisher", "No of copies"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
            jScrollPane1.setViewportView(jTable1);
            if (jTable1.getColumnModel().getColumnCount() > 0) {
                jTable1.getColumnModel().getColumn(3).setHeaderValue("Publisher");
                jTable1.getColumnModel().getColumn(4).setHeaderValue("No of copies");
            }

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
        LM m = new LM();
        m.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
