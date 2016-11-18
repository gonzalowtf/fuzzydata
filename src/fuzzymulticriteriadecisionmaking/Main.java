/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzymulticriteriadecisionmaking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author gonzalowtf
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    int x;
    int y;
    boolean tp = false;
    DefaultMutableTreeNode currentNode;
    
    
    public Main() {
        initComponents();
        setTitle("Fuzzy Multi-Criteria Method of Group Decision Making");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize()); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*float escalar = 1F;  
        int ancho = (int)(Toolkit.getDefaultToolkit().getScreenSize(). width*escalar); 
        int alto = (int)(Toolkit.getDefaultToolkit().getScreenSize(). height*escalar); 
        setSize(ancho,alto);*/
        //this.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        this.jTree1.setEditable(false);
        this.jTree1.setScrollsOnExpand(true);
        //JScrollPane s = new JScrollPane(jTree1);
        //this.aTree();
     
        //String url = System.getProperty("user.dir") + "\\datafuzzy.db";
        //JOptionPane.showMessageDialog(null, url);
        //Conn c = new Conn(url);
        //this.jPanel1.getc.getContentPane().add(new JScrollPane(jTree1), BorderLayout.CENTER);
        
        
        
        
    }
   
   public void aTreea(){
       //JOptionPane.showMessageDialog(null, tp);
       if(!tp){
            try{
        
        String url = System.getProperty("user.dir") + "\\datafuzzy.db";
        //JOptionPane.showMessageDialog(null, url);
        Conn cn = new Conn(url);
        cn.stmt = cn.c.createStatement();
        String sql = "Select * from problems";
        ResultSet rs = cn.stmt.executeQuery(sql);
        DefaultMutableTreeNode problems  = new DefaultMutableTreeNode("Problems");
        DefaultTreeModel model = new DefaultTreeModel(problems);
        
        ArrayList idsp = new ArrayList();
        ArrayList np = new ArrayList();
        while(rs.next()){
            idsp.add(rs.getInt(1));
            np.add(rs.getString(2));
        }
        rs.close();
        
        for(int i =0;i<idsp.size();i++){
            String p = np.get(i).toString();
            DefaultMutableTreeNode problem= new DefaultMutableTreeNode(p);
            model.insertNodeInto(problem, problems, 0);
            String sql2 = "Select * from decisors where idproblem ="+idsp.get(i).toString();
            ResultSet rs2 = cn.stmt.executeQuery(sql2);
            DefaultMutableTreeNode decisors = new DefaultMutableTreeNode("Decisors");
            model.insertNodeInto(decisors,problem,0);
            while(rs2.next()){
                String nd = rs2.getString(2);
                DefaultMutableTreeNode decisor = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(decisor,decisors,0);
            }
            rs2.close();
            String sql3= "Select * from criterias where idproblem ="+idsp.get(i).toString();
            ResultSet rs3 = cn.stmt.executeQuery(sql3);
            DefaultMutableTreeNode criterias = new DefaultMutableTreeNode("Criterias");
            model.insertNodeInto(criterias,problem,0);
            while(rs3.next()){
                String nd = rs3.getString(2);
                DefaultMutableTreeNode criteria = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(criteria,criterias,0);
            }
            rs3.close();
            String sql4= "Select * from alternatives where idproblem ="+idsp.get(i).toString();
            ResultSet rs4 = cn.stmt.executeQuery(sql4);
            DefaultMutableTreeNode alternatives = new DefaultMutableTreeNode("Alternatives");
            model.insertNodeInto(alternatives,problem,0);
            while(rs4.next()){
                String nd = rs4.getString(2);
                DefaultMutableTreeNode alternative = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(alternative,alternatives,0);
            }
            rs4.close();
        }
        
        
            
        
        
        jTree1.setModel(model);
         
         cn.stmt.close();
         cn.c.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Base error "+ex);
        }
        
       
       }
       else{
            try{
        
        String url = System.getProperty("user.dir") + "\\datafuzzy.db";
        //JOptionPane.showMessageDialog(null, url);
        Conn cn = new Conn(url);
        cn.stmt = cn.c.createStatement();
        String sql = "Select * from problems";
        ResultSet rs = cn.stmt.executeQuery(sql);
        DefaultMutableTreeNode problems  = new DefaultMutableTreeNode("Problems");
        DefaultTreeModel model = new DefaultTreeModel(problems);
        
        ArrayList idsp = new ArrayList();
        ArrayList np = new ArrayList();
        while(rs.next()){
            idsp.add(rs.getInt(1));
            np.add(rs.getString(2));
        }
        rs.close();
        
        for(int i =0;i<idsp.size();i++){
            String p = np.get(i).toString();
            DefaultMutableTreeNode problem= new DefaultMutableTreeNode(p);
            model.insertNodeInto(problem, problems, 0);
            String sql2 = "Select * from decisors where idproblem ="+idsp.get(i).toString();
            ResultSet rs2 = cn.stmt.executeQuery(sql2);
            DefaultMutableTreeNode decisors = new DefaultMutableTreeNode("Decisors");
            model.insertNodeInto(decisors,problem,0);
            while(rs2.next()){
                String nd = rs2.getString(2);
                DefaultMutableTreeNode decisor = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(decisor,decisors,0);
            }
            rs2.close();
            String sql3= "Select * from criterias where idproblem ="+idsp.get(i).toString();
            ResultSet rs3 = cn.stmt.executeQuery(sql3);
            DefaultMutableTreeNode criterias = new DefaultMutableTreeNode("Criterias");
            model.insertNodeInto(criterias,problem,0);
            while(rs3.next()){
                String nd = rs3.getString(2);
                DefaultMutableTreeNode criteria = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(criteria,criterias,0);
            }
            rs3.close();
            String sql4= "Select * from alternatives where idproblem ="+idsp.get(i).toString();
            ResultSet rs4 = cn.stmt.executeQuery(sql4);
            DefaultMutableTreeNode alternatives = new DefaultMutableTreeNode("Alternatives");
            model.insertNodeInto(alternatives,problem,0);
            while(rs4.next()){
                String nd = rs4.getString(2);
                DefaultMutableTreeNode alternative = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(alternative,alternatives,0);
            }
            rs4.close();
        }
        
        
            
        
        
        jTree1.setModel(model);
        //JOptionPane.showMessageDialog(null,currentNode.getPath());
        //jTree1.expandPath(new TreePath(currentNode.getPath()));
        
        
        
        
        
        
         cn.stmt.close();
         cn.c.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Base error "+ex);
        }
        
       
       }
       
       
       
   }
   
  
    
    public void aTree(){
        try{
        
        String url = System.getProperty("user.dir") + "\\datafuzzy.db";
        //JOptionPane.showMessageDialog(null, url);
        Conn cn = new Conn(url);
        cn.stmt = cn.c.createStatement();
        String sql = "Select * from problems";
        ResultSet rs = cn.stmt.executeQuery(sql);
        DefaultMutableTreeNode problems  = new DefaultMutableTreeNode("Problems");
        DefaultTreeModel model = new DefaultTreeModel(problems);
        
        ArrayList idsp = new ArrayList();
        ArrayList np = new ArrayList();
        while(rs.next()){
            idsp.add(rs.getInt(1));
            np.add(rs.getString(2));
        }
        rs.close();
        
        for(int i =0;i<idsp.size();i++){
            String p = np.get(i).toString();
            DefaultMutableTreeNode problem= new DefaultMutableTreeNode(p);
            model.insertNodeInto(problem, problems, 0);
            String sql2 = "Select * from decisors where idproblem ="+idsp.get(i).toString();
            ResultSet rs2 = cn.stmt.executeQuery(sql2);
            DefaultMutableTreeNode decisors = new DefaultMutableTreeNode("Decisors");
            model.insertNodeInto(decisors,problem,0);
            while(rs2.next()){
                String nd = rs2.getString(2);
                DefaultMutableTreeNode decisor = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(decisor,decisors,0);
            }
            rs2.close();
            String sql3= "Select * from criterias where idproblem ="+idsp.get(i).toString();
            ResultSet rs3 = cn.stmt.executeQuery(sql3);
            DefaultMutableTreeNode criterias = new DefaultMutableTreeNode("Criterias");
            model.insertNodeInto(criterias,problem,0);
            while(rs3.next()){
                String nd = rs3.getString(2);
                DefaultMutableTreeNode criteria = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(criteria,criterias,0);
            }
            rs3.close();
            String sql4= "Select * from alternatives where idproblem ="+idsp.get(i).toString();
            ResultSet rs4 = cn.stmt.executeQuery(sql4);
            DefaultMutableTreeNode alternatives = new DefaultMutableTreeNode("Alternatives");
            model.insertNodeInto(alternatives,problem,0);
            while(rs4.next()){
                String nd = rs4.getString(2);
                DefaultMutableTreeNode alternative = new DefaultMutableTreeNode(nd);
                model.insertNodeInto(alternative,alternatives,0);
            }
            rs4.close();
        }
        
        
            
        
        
        jTree1.setModel(model);
         
         cn.stmt.close();
         cn.c.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data Base error "+ex);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        addD = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        addC = new javax.swing.JMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        addA = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        itemName = new javax.swing.JMenuItem();
        itemDelete = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        addD.setText("Add New Decisor");
        addD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDActionPerformed(evt);
            }
        });
        jPopupMenu1.add(addD);

        addC.setText("Add new Criteria");
        addC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCActionPerformed(evt);
            }
        });
        jPopupMenu2.add(addC);

        addA.setText("Add new Alternative");
        addA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAActionPerformed(evt);
            }
        });
        jPopupMenu3.add(addA);

        jMenu3.setText("jMenu3");

        itemName.setText("Change Name");
        itemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameActionPerformed(evt);
            }
        });
        jPopupMenu4.add(itemName);

        itemDelete.setText("Delete");
        itemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeleteActionPerformed(evt);
            }
        });
        jPopupMenu4.add(itemDelete);

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jDesktopPane1ComponentRemoved(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Problems");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setScrollsOnExpand(false);
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzymulticriteriadecisionmaking/actualizar.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fuzzymulticriteriadecisionmaking/add2.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(24, 24, 24))
        );

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1098, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(296, 296, 296)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(194, 194, 194))
        );

        jMenu1.setText("Acctions");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("New Problem");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Show existing problems");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Show Weights");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Save");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Generate Report");
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator1);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Close");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Examples");

        jMenuItem6.setText("Credit beneficiary");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Data Base");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Actualize");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        NewProblem m = new NewProblem();
        this.jDesktopPane1.add(m);
        Dimension desktopSize = this.jDesktopPane1.getSize();
        Dimension FrameSize = m.getSize();
        m.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        m.show();
       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
         if(evt.getClickCount() == 1){
         this.jPopupMenu1.setVisible(false);
         this.jPopupMenu2.setVisible(false);
         this.jPopupMenu3.setVisible(false);
         this.jPopupMenu4.setVisible(false);
         
         }
     if(evt.getClickCount() == 2){
         
         //JOptionPane.showMessageDialog(null, this.jTree1.getSelectionRows()[0]);
         String seleccion = this.jTree1.getLastSelectedPathComponent().toString();
         
         Point punto=MouseInfo.getPointerInfo().getLocation();
         
        //JOptionPane.showMessageDialog(null, seleccion);
        switch(seleccion){
            case "Decisors": this.jPopupMenu1.setVisible(true);
            punto=MouseInfo.getPointerInfo().getLocation();
            x=punto.x;
            y=punto.y;
                             this.jPopupMenu1.setLocation(x,y);
                break;
               case "Criterias": this.jPopupMenu2.setVisible(true);
            punto=MouseInfo.getPointerInfo().getLocation();
            x=punto.x;
            y=punto.y;
                             this.jPopupMenu2.setLocation(x,y);
                break;
               case "Alternatives": this.jPopupMenu3.setVisible(true);
            punto=MouseInfo.getPointerInfo().getLocation();
            x=punto.x;
            y=punto.y;
                             this.jPopupMenu3.setLocation(x,y);
                break;
               default:this.jPopupMenu4.setVisible(true);
            punto=MouseInfo.getPointerInfo().getLocation();
            x=punto.x;
            y=punto.y;
                             this.jPopupMenu4.setLocation(x,y);
        }
             //this.jTree1.clearSelection();
        
     }
    }//GEN-LAST:event_jTree1MouseClicked

    private void addDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDActionPerformed
        String path = this.jTree1.getSelectionPath().toString();
        path.replace('[', '*');
        //JOptionPane.showMessageDialog(null, path);
        String[] split2 = path.split(",");
        //JOptionPane.showMessageDialog(null, split2);

        
        addDecisor d = new addDecisor(split2[1]);
                            this.jDesktopPane1.add(d);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = d.getSize();
                            d.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            d.show();
                            this.jPopupMenu1.setVisible(false);
    }//GEN-LAST:event_addDActionPerformed

    private void addCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCActionPerformed
        String path = this.jTree1.getSelectionPath().toString();
        path.replace('[', '*');
        //JOptionPane.showMessageDialog(null, path);
        String[] split2 = path.split(",");
        //JOptionPane.showMessageDialog(null, split2);
        
        addCriteria d = new addCriteria(split2[1]);
                            this.jDesktopPane1.add(d);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = d.getSize();
                            d.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            d.show();
                            this.jPopupMenu2.setVisible(false);
        
        
        
        
    }//GEN-LAST:event_addCActionPerformed

    private void addAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAActionPerformed
         String path = this.jTree1.getSelectionPath().toString();
        path.replace('[', '*');
        //JOptionPane.showMessageDialog(null, path);
        String[] split2 = path.split(",");
        //JOptionPane.showMessageDialog(null, split2);
        addAlternative d = new addAlternative(split2[1]);
                            this.jDesktopPane1.add(d);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = d.getSize();
                            d.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            d.show();
                            this.jPopupMenu3.setVisible(false);
    }//GEN-LAST:event_addAActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        this.aTree();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void itemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameActionPerformed
        String path = this.jTree1.getSelectionPath().toString();
        //currentNode = new DefaultMutableTreeNode(this.jTree1.getSelectionPath());
        
        path.replace('[', '*');
        path.replace(']', '*');
        //JOptionPane.showMessageDialog(null, path);
        String[] p = path.split(",");
        //JOptionPane.showMessageDialog(null, p.length);
        //JOptionPane.showMessageDialog(null, p);
       
        if("[Problems".equals(p[0]) && p.length == 2){              
            
            ItemChange c = new ItemChange("Problem",p[1].replace(']',' '),p[1].replace(']',' '));
         
                this.jDesktopPane1.add(c);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c.getSize();
                            c.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c.show();
                            
                            
                            
                            
            }  
        else{         
            if(" Alternatives".equals(p[2])){
                    //JOptionPane.showMessageDialog(null, "Entro");
                    ItemChange c1 = new ItemChange("Alternative",p[3].replace(']',' '),p[1].replace(']',' '));
                        this.jDesktopPane1.add(c1);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c1.getSize();
                            c1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c1.show();
                           
             }
            if(" Criterias".equals(p[2])){
                    //JOptionPane.showMessageDialog(null, "Entro");
                    ItemChange c1 = new ItemChange("Criteria",p[3].replace(']',' '),p[1].replace(']',' '));
                        this.jDesktopPane1.add(c1);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c1.getSize();
                            c1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c1.show();
                            
                            
             }
            if(" Decisors".equals(p[2])){
                    //JOptionPane.showMessageDialog(null, "Entro");
                    ItemChange c1 = new ItemChange("Decisor",p[3].replace(']',' '),p[1].replace(']',' '));
                        this.jDesktopPane1.add(c1);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c1.getSize();
                            c1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c1.show();
                            
                            
                            
                            
             }
            
        }
        this.jPopupMenu4.setVisible(false);
        
    }//GEN-LAST:event_itemNameActionPerformed

    private void itemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeleteActionPerformed
        
        String path = this.jTree1.getSelectionPath().toString();
        path.replace('[', '*');
        path.replace(']', '*');
        //JOptionPane.showMessageDialog(null, path);
        String[] p = path.split(",");
        //JOptionPane.showMessageDialog(null, p.length);
        //JOptionPane.showMessageDialog(null, p);
        if("[Problems".equals(p[0]) && p.length == 2){
                ItemDel c = new ItemDel("Problem",p[1].replace(']',' '),p[1].replace(']',' '));
                this.jDesktopPane1.add(c);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c.getSize();
                            c.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c.show();
            }  
        else{         
            if(" Alternatives".equals(p[2])){
                    //JOptionPane.showMessageDialog(null, "Entro");
                    ItemDel c1 = new ItemDel("Alternative",p[3].replace(']',' '),p[1].replace(']',' '));
                        this.jDesktopPane1.add(c1);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c1.getSize();
                            c1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c1.show();
             }
            if(" Criterias".equals(p[2])){
                    //JOptionPane.showMessageDialog(null, "Entro");
                    ItemDel c1 = new ItemDel("Criteria",p[3].replace(']',' '),p[1].replace(']',' '));
                        this.jDesktopPane1.add(c1);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c1.getSize();
                            c1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c1.show();
             }
            if(" Decisors".equals(p[2])){
                    //JOptionPane.showMessageDialog(null, "Entro");
                    ItemDel c1 = new ItemDel("Decisor",p[3].replace(']',' '),p[1].replace(']',' '));
                        this.jDesktopPane1.add(c1);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c1.getSize();
                            c1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c1.show();
             }
            
        }
             
        
        this.jPopupMenu4.setVisible(false);
    }//GEN-LAST:event_itemDeleteActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        aTree();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        
        Weights c1 = new Weights();
                        this.jDesktopPane1.add(c1);
                            Dimension desktopSize = this.jDesktopPane1.getSize();
                            Dimension FrameSize = c1.getSize();
                            c1.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
                            c1.show();
        
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jDesktopPane1ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jDesktopPane1ComponentRemoved
        //JOptionPane.showMessageDialog(null, "Component removed");
    }//GEN-LAST:event_jDesktopPane1ComponentRemoved

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        
    }//GEN-LAST:event_jTree1ValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        aTreea();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        NewProblem m = new NewProblem();
        this.jDesktopPane1.add(m);
        Dimension desktopSize = this.jDesktopPane1.getSize();
        Dimension FrameSize = m.getSize();
        m.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        m.show();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addA;
    private javax.swing.JMenuItem addC;
    private javax.swing.JMenuItem addD;
    private javax.swing.JMenuItem itemDelete;
    private javax.swing.JMenuItem itemName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
