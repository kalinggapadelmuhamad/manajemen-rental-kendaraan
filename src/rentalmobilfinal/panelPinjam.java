/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalmobilfinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import rentalmobilfinal.koneksi.conn;
/**
 *
 * @author Kalingga Padel
 */
public class panelPinjam extends javax.swing.JPanel {

    /**
     * Creates new form panelPinjam
     */
    
    private void tampilData(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("Tgl Pinjam");
        model.addColumn("Lama Pinjam");
        model.addColumn("Petugas");
        model.addColumn("Customer");
        model.addColumn("NO Polisi");
        model.addColumn("Merek Kendaraan");
        model.addColumn("Harga Sewa");
        model.addColumn("Total");
        jTable1.setModel(model);
        
        try {
            Connection con = new conn().conn();
            java.sql.Statement stat = con.createStatement();
            String sql = "SELECT * FROM pinjam";
            ResultSet data = stat.executeQuery(sql);
            
            while(data.next()){
                model.addRow(new Object[]{
                    data.getString("noTransaksi"),
                    data.getString("tglPeminjaman"),
                    data.getString("lamaPinjam"),
                    data.getString("namaPetugas"),
                    data.getString("nama"),
                    data.getString("noPol"),
                    data.getString("noTransaksi"),
                    data.getString("merek"),
                    data.getString("hargaSewa"),
                    data.getString("total")
                });
            }
        } catch (Exception e) {
        }
        
        
    }
    
    public void tampilcbPetugas(){
        Connection con = new conn().conn();
        try {
            java.sql.Statement stat = con.createStatement();
            String sql = "SELECT idPetugas, namaPetugas From Petugas";
            ResultSet data = stat.executeQuery(sql);
            idPtg.addItem("PILIH PETUGAS");
            while(data.next()){
                idPtg.addItem(data.getString("namaPetugas"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
   public void tampilcbNopol(){
        Connection con = new conn().conn();
        try {
            java.sql.Statement stat = con.createStatement();
            String sql = "SELECT merek From kendaraan WHERE status = 'Tersedia'";
            ResultSet data = stat.executeQuery(sql);
            kdr.addItem("PILIH KENDARAAN");
            while(data.next()){
                kdr.addItem(data.getString("merek"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void tampilcbCs(){
        Connection con = new conn().conn();
        try {
            java.sql.Statement stat = con.createStatement();
            String sql = "SELECT nama FROM customer";
            ResultSet data = stat.executeQuery(sql);
            idCs.addItem("PILIH CUSTOMER");
            while(data.next()){
                idCs.addItem(data.getString("nama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelPinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    private void getIdP(String  name){
        Connection con = new conn().conn();
        try {
            java.sql.Statement stat = con.createStatement();
            String sql              = "SELECT idPetugas FROM petugas WHERE namaPetugas = '"+ name +"'";
            ResultSet data          = stat.executeQuery(sql);
            data.next();
            int  id = new Integer(data.getString("idPetugas"));
            return;
        } catch (Exception e) { 
        }
    }
    

    public panelPinjam() {
        initComponents();
        tampilData();
        tampilcbPetugas();
        tampilcbNopol();
        tampilcbCs();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tglPinjam = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        idPtg = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idCs = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        kdr = new javax.swing.JComboBox<>();
        lamaP = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        trxId = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(110, 116, 255));
        jLabel1.setText("DATA | PEMINJAMAN");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel6.setText("* Tanggaal Pinjam");

        tglPinjam.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel7.setText("* Petugas");

        idPtg.setBorder(null);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel10.setText("* Lama Pinjam");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel11.setText("* Customer");

        idCs.setBorder(null);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel12.setText("* Kendaraan Tersedia");

        kdr.setBorder(null);
        kdr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kdrActionPerformed(evt);
            }
        });

        lamaP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel13.setText("* Total Harga");

        harga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        harga.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        harga.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel14.setText("* Harga");

        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        total.setEnabled(false);

        jButton3.setBackground(new java.awt.Color(110, 116, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CEK");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(110, 116, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CETAK");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(110, 116, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("SEWA");
        jButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        trxId.setEditable(false);
        trxId.setBackground(new java.awt.Color(255, 255, 255));
        trxId.setForeground(new java.awt.Color(255, 255, 255));
        trxId.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(lamaP, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idPtg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idCs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kdr, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(harga)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(trxId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel7))
                            .addComponent(jLabel13))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(trxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idPtg)
                    .addComponent(tglPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idCs, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(lamaP)))
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kdr, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow();
        if (baris != -1) {
            trxId.setText(jTable1.getValueAt(baris, 0).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection con = new conn().conn();
        
        String merek = kdr.getSelectedItem().toString();
        int lamaPin = new Integer(this.lamaP.getText());
        try {
            java.sql.Statement stat = con.createStatement();
            String sql = "SELECT hargaSewa FROM kendaraan WHERE merek = '"+ merek +"'";
            ResultSet data = stat.executeQuery(sql);
            while(data.next()){
                String hargas = data.getString("hargaSewa");
                harga.setText(hargas);
            
                int harga = new Integer(data.getString("hargaSewa"));
                int totalH =  lamaPin *  harga;
                total.setText(String.valueOf(totalH));
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        try{
            String NamaFile = "C:\\Users\\Kalingga Padel\\Documents\\NetBeansProjects\\rentalMobilfinal\\src\\rentalmobilfinal\\nota.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/rental","root","");
            HashMap param = new HashMap();
            param.put("notrx",trxId.getText());
                   
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint);
        }catch(Exception ex){
            System.out.println(ex);
        }
    
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
        int noTrx = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal  = format.format(tglPinjam.getDate());
        
        String idPtgs   = idPtg.getSelectedItem().toString();
        String idCss    = this.idCs.getSelectedItem().toString();
        String idKdr    = kdr.getSelectedItem().toString();
        
        Connection con = new conn().conn();
       
            java.sql.Statement stat = con.createStatement();
            String sqlPetugas       = "SELECT idPetugas FROM petugas WHERE namaPetugas = '"+ idPtgs +"'";
            ResultSet dataPetugas          = stat.executeQuery(sqlPetugas);
            dataPetugas.next();
            int  idPtgasF = new Integer(dataPetugas.getString("idPetugas"));
            
            String sqlCs            = "SELECT idCs FROM customer WHERE nama = '"+ idCss +"'";
            ResultSet dataCs        = stat.executeQuery(sqlCs);
            dataCs.next();
            int  idCsF = new Integer(dataCs.getString("idCs"));
            
            String sqlKdr           = "SELECT noPol FROM kendaraan WHERE merek = '"+ idKdr +"'";
            ResultSet dataKdr       = stat.executeQuery(sqlKdr);
            dataKdr.next();
            String  idKdrF = dataKdr.getString("noPol");
            
            int lamaPin = new Integer(this.lamaP.getText());
            int totalH =  new Integer(total.getText());
            
            String sqlPinjam        = "INSERT INTO peminjaman VALUES ('"+ noTrx +"','"+ tanggal +"','"+ idPtgasF +"','"+ idCsF +"','"+ idKdrF +"','"+ lamaPin+"','"+ totalH+"')";
            stat.executeUpdate(sqlPinjam);
            
            String sqlupdate        = "UPDATE kendaraan SET status = 'Tidak Tersedia' WHERE noPol = '"+ idKdrF +"'";
            stat.executeUpdate(sqlupdate);
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Simpan","Perhatian",JOptionPane.WARNING_MESSAGE);
            tampilData();
            kdr.removeAllItems();
            tampilcbNopol();
            
            
            

            
        } catch (Exception e) {
            System.out.println("err");
        }

       
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void kdrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kdrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kdrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField harga;
    private javax.swing.JComboBox<String> idCs;
    private javax.swing.JComboBox<String> idPtg;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> kdr;
    private javax.swing.JTextField lamaP;
    private com.toedter.calendar.JDateChooser tglPinjam;
    private javax.swing.JTextField total;
    private javax.swing.JTextField trxId;
    // End of variables declaration//GEN-END:variables
}
