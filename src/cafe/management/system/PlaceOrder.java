/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.management.system;

import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.BillDao;
import dao.CategoryDao;
import dao.ProductDao;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Product;
import model.Category;

/**
 *
 * @author tanuc
 */
public class PlaceOrder extends javax.swing.JFrame {

    public int billId = 1;
    public int grandTotal = 0;
    public int productPrice = 0;
    public int productTotal = 0;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";
    public String userEmail;

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();

    }

    public PlaceOrder(String email) {
        initComponents();
        txtProName.setEditable(false);
        txtProPrice.setEditable(false);
        txtProTotal.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnGenerateBillPrint.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        userEmail = email;

    }

    public void productNameByCategory(String Category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.getAllRecordsByCategory(Category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});

        }
    }

    public void filterProductByname(String name, String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.filterProductByname(name, category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});

        }

    }

    public void clearProductFields() {
        txtProName.setText("");
        txtProPrice.setText("");
        txtProTotal.setText("");
        jSpinner1.setValue(1);
        btnAddToCart.setEnabled(false);
    }

    public void validateFields() {
        String customerName = txtCustName.getText();
        String customerMobileNumber = txtCustMobileNumber.getText();
        String customerEmail = txtCustEmail.getText();
        if (!customerEmail.equals("") && customerMobileNumber.matches(mobileNumberPattern) && customerMobileNumber.length() == 10 && customerEmail.matches(emailPattern) && grandTotal > 0) {
            btnGenerateBillPrint.setEnabled(true);
        } else {
            btnGenerateBillPrint.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCustMobileNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtProName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        txtProTotal = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        btnGenerateBillPrint = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/place order.png"))); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 23, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 30, 45, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Bill Id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 97, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("--");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 25, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Customer Details");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 139, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 187, -1, -1));

        txtCustName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCustName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtCustName, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 225, 238, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Mobile Number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 284, -1, -1));

        txtCustMobileNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCustMobileNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustMobileNumberKeyReleased(evt);
            }
        });
        getContentPane().add(txtCustMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 322, 238, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Email");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 384, 80, -1));

        txtCustEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCustEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtCustEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 422, 238, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Category");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 113, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 149, 257, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Search");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 208, 90, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 258, 257, -1));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 314, 351, 357));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 82, -1, -1));

        txtProName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtProName, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 149, 262, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1096, 82, -1, -1));

        txtProPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtProPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1096, 139, 250, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Quantity");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 208, -1, -1));

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 257, 262, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Total");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1096, 208, 81, -1));

        txtProTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtProTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1096, 258, 250, -1));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 314, -1, -1));

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/add to cart.png"))); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1202, 314, -1, -1));

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(753, 360, 593, 278));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Grand Total Rs");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(753, 684, -1, 31));

        lblGrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGrandTotal.setText("000");
        getContentPane().add(lblGrandTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 680, -1, -1));

        btnGenerateBillPrint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerateBillPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/generate bill & print.png"))); // NOI18N
        btnGenerateBillPrint.setText("Generate Bill & Print");
        btnGenerateBillPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerateBillPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1048, 685, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images/13 (1).jpg"))); // NOI18N
        jLabel15.setText("jLabel15");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home(userEmail).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        billId = Integer.parseInt(BillDao.getId());
        jLabel3.setText(BillDao.getId());
        ArrayList<Category> list = CategoryDao.getAllRecords();
        Iterator<Category> itr = list.iterator();
        while (itr.hasNext()) {
            Category categoryObj = itr.next();
            jComboBox1.addItem(categoryObj.getName());
        }
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String name = txtSearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByName(name, category);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String productName = model.getValueAt(index, 0).toString();
        Product product = ProductDao.getProductByname(productName);
        txtProName.setText(product.getName());
        txtProPrice.setText(product.getPrice());
        jSpinner1.setValue(1);
        txtProTotal.setText(product.getPrice());
        productPrice = Integer.parseInt(product.getPrice());
        productTotal = Integer.parseInt(product.getPrice());
        btnAddToCart.setEnabled(true);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int quantity = (Integer) jSpinner1.getValue();
        if (quantity <= 1) {
            jSpinner1.setValue(1);
            quantity = 1;
        }
        productTotal = productPrice * quantity;
        txtProTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String name = txtProName.getText();
        String price = txtProPrice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[]{name, price, quantity, productTotal});
        grandTotal = grandTotal + productTotal;
        lblGrandTotal.setText(String.valueOf(grandTotal));

        clearProductFields();
        validateFields();
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearProductFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtCustNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustNameKeyReleased
        // TODO add your handling code here:
        validateFields();

    }//GEN-LAST:event_txtCustNameKeyReleased

    private void txtCustMobileNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustMobileNumberKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtCustMobileNumberKeyReleased

    private void txtCustEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustEmailKeyReleased
        // TODO add your handling code here:
        validateFields();
    }//GEN-LAST:event_txtCustEmailKeyReleased

    private void btnGenerateBillPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillPrintActionPerformed
        // TODO add your handling code here:
        String customerName = txtCustName.getText();
        String customerMobileNumber = txtCustMobileNumber.getText();
        String customerEmail = txtCustEmail.getText();
        SimpleDateFormat dformat = new SimpleDateFormat("dd-mm-yyy");
        Date date = new Date();
        String todayDate = dformat.format(date);
        String total = String.valueOf(grandTotal);
        String createdBy = userEmail;
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setName(customerName);
        bill.setMobileNumber(customerMobileNumber);
        bill.setEmail(customerEmail);
        bill.setDate(todayDate);
        bill.setTotal(total);
        bill.setCreatedBy(createdBy);
        BillDao.save(bill);

        //creating document
        String path = "D:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId + ".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("Java Junction Cafe\n");
            doc.add(cafeName);
            Paragraph starline = new Paragraph("***************************************************************************************************************");
            doc.add(starline);
            Paragraph paragraph3 = new Paragraph("\tBillId: " + billId + "\nCustomer Name:" + customerName + "\nTotal Price:" + grandTotal);
            doc.add(paragraph3);
            doc.add(starline);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                String n = jTable2.getValueAt(i, 0).toString();
                String d = jTable2.getValueAt(i, 1).toString();
                String r = jTable2.getValueAt(i, 2).toString();
                String q = jTable2.getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(d);
                tb1.addCell(r);
                tb1.addCell(q);
            }
            doc.add(tb1);
            doc.add(starline);
            Paragraph  thanksMsg=new Paragraph("Thank You,Please Visit Again");
            doc.add(thanksMsg);
            OpenPdf.openById(String.valueOf(billId));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(createdBy).setVisible(true);
    }//GEN-LAST:event_btnGenerateBillPrintActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int index=jTable2.getSelectedRow();
        int a=JOptionPane.showConfirmDialog(null,"Do You want to removr this Product.","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            TableModel model=jTable2.getModel();
            String total=model.getValueAt(index, 3).toString();
            grandTotal=grandTotal-Integer.parseInt(total);
            lblGrandTotal.setText(String.valueOf(grandTotal));
            ((DefaultTableModel) jTable2.getModel()).removeRow(index);
            
        }
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenerateBillPrint;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JTextField txtCustEmail;
    private javax.swing.JTextField txtCustMobileNumber;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtProName;
    private javax.swing.JTextField txtProPrice;
    private javax.swing.JTextField txtProTotal;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void filterProductByName(String name, String category) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}