package book.views;

import book.agents.SellerAgent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class SellerView extends javax.swing.JFrame {

    private SellerAgent sellerAgent;
    private int tableRows = 0;

    /**
     * Creates new form SellerView
     */
    public SellerView(SellerAgent sellerAgent) {
        super(sellerAgent.getLocalName());
        this.sellerAgent = sellerAgent;
        initComponents();
        lbSellerName.setText("Seller: " + sellerAgent.getLocalName());

        txtBookSale.setEditable(false);
        txtBuyerSale.setEditable(false);
        txtPriceSale.setEditable(false);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sellerAgent.doDelete();
            }
        });
        
    }
    
    /**
     * Shows info about the last sale
     * @param title title of the book
     * @param buyer buyer agent
     * @param price price of the book
     */
    public void printBuyer(String title, String buyer, int price){
        txtBookSale.setText(title);
        txtBuyerSale.setText(buyer);
        txtPriceSale.setText(Integer.toString(price));
        printCatalogue(sellerAgent.getCatalogue());
    }

    /**
     * Shows the current catalogue
     * @param catalogue books 
     */
    public void printCatalogue(HashMap<String, Integer> catalogue) {
        cleanTable();
        for (String book : catalogue.keySet()) {
            tbCatalogue.setValueAt(book, tableRows, 0);
            tbCatalogue.setValueAt(catalogue.get(book), tableRows, 1);
            tableRows++;
        }
    }

    /**
     * Cleans the catalogue table
     */
    public void cleanTable() {
        for (int i = 0; i < tableRows; i++) {
            tbCatalogue.setValueAt("", i, 0);
            tbCatalogue.setValueAt("", i, 1);
        }
        tableRows = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSellerName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCatalogue = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        btnUpdateTable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBookSale = new javax.swing.JTextField();
        txtBuyerSale = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPriceSale = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbSellerName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbSellerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSellerName.setText("Book seller");

        jLabel2.setText("Title");

        jLabel3.setText("Price");

        tbCatalogue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCatalogue.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbCatalogue);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdateTable.setText("Update");
        btnUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTableActionPerformed(evt);
            }
        });

        jLabel1.setText("Last sale");

        jLabel6.setText("Book");

        jLabel7.setText("Buyer");

        jLabel8.setText("Price");

        jLabel9.setText("Add new book");

        jLabel10.setText("Catalogue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSellerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(txtPrice)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btnSave))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPriceSale, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBuyerSale))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBookSale))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(78, 78, 78))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(btnUpdateTable)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSellerName)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(btnSave)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtBuyerSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtBookSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtPriceSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateTable)
                        .addGap(9, 9, 9))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Saves a new book in the catalogue
     * @param evt 
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String title = txtTitle.getText().trim();
        String price = txtPrice.getText().trim();

        try {
            // add new book
            sellerAgent.updateCatalogue(title, Integer.parseInt(price));

            // print catalogue
            printCatalogue(sellerAgent.getCatalogue());

            // clean inputs
            txtTitle.setText("");
            txtPrice.setText("");
            //JOptionPane.showMessageDialog(SellerView.this, "Book saved");
            printCatalogue(sellerAgent.getCatalogue());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(SellerView.this, "Try other values" + e.getMessage().toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Update catalogue table
     * @param evt 
     */
    private void btnUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTableActionPerformed
        printCatalogue(sellerAgent.getCatalogue());
    }//GEN-LAST:event_btnUpdateTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdateTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSellerName;
    private javax.swing.JTable tbCatalogue;
    private javax.swing.JTextField txtBookSale;
    private javax.swing.JTextField txtBuyerSale;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPriceSale;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
