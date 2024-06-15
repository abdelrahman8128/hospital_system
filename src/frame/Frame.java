/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 




public class Frame extends JFrame implements ActionListener, FocusListener, ChangeListener{

    	String host="jdbc:sqlserver://localhost:1433;databaseName=Hospital;integritySecurity=true";
        String uname="admin";
        String password="1234";
    Connection con;
    Statement stmt;
    ResultSet rs; 
    java.sql.Date sqldate;
    JButton btn1,btn2,btn3,btn4,btn5,btn6;
    JPanel p1,p2,p3 ,p4,p5,p6,p7,p8;
    JTable t1,t2,t3;
    JScrollPane s1, s2,s3;
    
    JSlider slider ; 
	
    Font f1=new Font("Comic Sans MS", Font.PLAIN, 20);
        
    Color c1=Color.decode("#146c94");
    Color c2=Color.decode("#19A7ca");
    Color c3=Color.decode("#F6F1F1");
    JComboBox cb1, cb2,cb3;
    DefaultTableModel model1,model2,model3;
    jTextField jtf1, jtf2,jtf3;
    TableRowSorter sorter1,sorter2,sorter3;
    JOptionPane jop1,jop2,jop3;
    JTextField jtff1,jtff2,jtff3,jtff4,jtff5,jtff6,jtff7,jtff8,jtff9,jtff10,jtff11,jtff12,jtff13,jtff14,jtff15;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16,jl17,jl18,jl19;
    JRadioButton birdButton1,catButton1;
    
    
		
	public Frame() {
		
		
	
		this.setTitle("AbdElRahman hospital program");
                
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(20, 20, 1130,660 );
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
	
		// this is the left panel 
		
		p1=new JPanel ();
		p1.setLayout(null);
		p1.setBounds(0, 0, 140, 660);	
		p1.setBackground(c1);
		this.add(p1);
		
		// this is the upper line 
		
		p2=new JPanel ();
		p2.setLayout(null);
		p2.setBounds(140, 0, 1130, 20);	
		p2.setBackground(c2);
		this.add(p2);
		
		// this is the panel for the tables
		
		p3=new JPanel ();
		p3.setLayout(null);
		p3.setBounds(140, 20, 990, 640);	
		this.add(p3);
		p3.setVisible(false);
		//p3.setBackground(c3);
		btn1=new JButton ("Search & Edit");
		p1.add(btn1);
		btn1.setBounds(0, 100, 140, 50);
		btn1.addActionListener(this);
		//btn1.setOpaque(false);
		btn1.setFocusPainted(false);
		btn1.setBorderPainted(false);
		//btn1.setContentAreaFilled(false);
		//btn1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btn1.setForeground(c3);
                 btn1.setBackground(c2);
                btn1.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
		
		
		
		//this is the add form tab button
        
        
        
		btn3=new JButton ("Add New Object");
                 btn3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		p1.add(btn3);
		btn3.setBounds(0, 152, 140, 50);
		btn3.addActionListener(this);
		//btn3.setOpaque(false);
		btn3.setFocusPainted(false);
		btn3.setBorderPainted(false);
		//btn3.setContentAreaFilled(false);
		//btn3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btn3.setForeground(c3);
		btn3.setBackground(c2);
		
		
		// this is the slider that control the size of the font of the tables
		
		
		jl19=new JLabel("-   Tables Font Size  +");
		p1.add(jl19);
		
		jl19.setBounds(10,280 ,130 ,20 );
		jl19.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		jl19.setForeground(c3);
		jl19.setVisible(false);
		
		slider = new JSlider(JSlider.HORIZONTAL, 10, 30, 20); 
		p1.add(slider);
		slider.setBounds(0, 300, 140,50);
		slider.setBackground(c2);
		slider.setForeground(c1);
		slider.setMinorTickSpacing(2);  
		slider.addChangeListener(this);
		slider .setVisible(false);
		// this is the table for the doctors
	
               
                
		
  
t1= new JTable(model1);
   
model1=new DefaultTableModel();
model1.addColumn("dssn");
model1.addColumn("name");
model1.addColumn("specialization");

t1.setModel(model1);
        try {
            con=DriverManager.getConnection(host, uname, password);
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from doctor");
            while(rs.next()){
            model1.addRow(new Object[]{rs.getInt("dssn"),rs.getString("name"),rs.getString("specialization")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
		sorter1=new TableRowSorter<>(model1);
		
		
		
	    t1.setLayout(null);
	    t1.setBackground(c2);
	    t1.setGridColor(c3);
            
	    s1 = new JScrollPane(t1);
	    s1.setBounds(140, 60, 850, 580);
	    p3.add(s1);
	    t1.setFont(f1);
            t1.setRowHeight(30);
            t1.getColumnModel().getColumn(0).setMaxWidth(150);
            
	    t1.setRowSorter(sorter1);
	    t1.addKeyListener(new KeyAdapter() {
            @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                
                
                int row = t1.getSelectedRow();
               try{
                   stmt.executeUpdate("DELETE FROM doctor " + "WHERE (dssn='" + t1.getValueAt( row,0)+"')");
                    }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(p3,ex.getMessage());
                                  }
               
                try{
                                stmt.executeUpdate("insert into doctor values ('"+t1.getValueAt(row, 0)+"','"+t1.getValueAt(row, 1)+"','"+t1.getValueAt(row, 2)+"')");

                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(p3,ex.getMessage());
                                  }
            }
        }
            });
	    
	    
	    
	    
	    
	   // this is the search box for table 1
	    jtf1=new jTextField(sorter1);
	    p3.add(jtf1.jtf);
	    jtf1.jtf.setBounds(200, 15,200, 30);
	    jtf1.jtf.setCaretColor(c2);
	   jtf1.jtf.setDisabledTextColor(c1);
	   jtf1.jtf.setToolTipText("click here to Search");
	   
	   jtf1.jtf.setText(" Search...");
	   jtf1.jtf.setForeground(Color.lightGray);
	   jtf1.jtf.addFocusListener(this);
           jtf1.jtf.setCaretColor(c1);
           jtf1.jtf.setCaretPosition(10);
	    jtf1.jtf.setFont(f1);

	    
	    
                
                
               // t1= new JTable(model1);
   
model2=new DefaultTableModel();
model2.addColumn("dssn");
model2.addColumn("name");
model2.addColumn("date add");
model2.addColumn("date out");
model2.addColumn("insurance");

 t2= new JTable();
t2.setModel(model2);
        try {
            con=DriverManager.getConnection(host, uname, password);
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from patient");
            while(rs.next()){
            model2.addRow(new Object[]{rs.getInt("ssn_id"),rs.getString("name"),rs.getDate("date_add"),rs.getDate("date_out"),rs.getBoolean("mid_insurance")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }

		
		//model2=new DefaultTableModel(rowData2,columnNames2);
		sorter2=new TableRowSorter<>(model2);
		
	   
	    t2.setLayout(null);
	    t2.setBackground(c2);
	    t2.setGridColor(c3);
            t2.setFont(f1);
            t2.setRowHeight(30);
            t2.getColumnModel().getColumn(0).setMaxWidth(150);
	    s2 = new JScrollPane(t2);
	    s2.setBounds(140, 60, 850, 580);
	    s2.setVisible(false);
	    p3.add(s2);
	    t2.setRowSorter(sorter2);
	    jtf2=new jTextField(sorter2);
	    p3.add(jtf2.jtf);
	    jtf2.jtf.setBounds(200, 15,200, 30);
	    jtf2.jtf.setVisible(false);
	    jtf2.jtf.setToolTipText("click here to Search"); 
	    jtf2.jtf.setText(" Search...");
            jtf2.jtf.setForeground(Color.LIGHT_GRAY);
            jtf2.jtf.addFocusListener(this);
            jtf2.jtf.setCaretColor(c1);
            jtf2.jtf.setCaretPosition(10);
            jtf2.jtf.setFont(f1);

            
            
            
            
            
            
            
            
            
            t2.addKeyListener(new KeyAdapter() {
            @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                
                
                int row = t2.getSelectedRow();
                int column = t2.getSelectedColumn();

                // resul is the new value to insert in the DB
                String resul = t2.getValueAt(row, column).toString();
                // id is the primary key of my DB
                String id = t2.getValueAt(row, 0).toString();
                
       
              try{
                                 
                                stmt.executeUpdate("DELETE FROM patient " + "WHERE (ssn_id='" + t2.getValueAt( row,0)+"')");
                               
                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(p3,ex.getMessage());
                                  }
               
                 try{  
                                stmt.executeUpdate("insert into patient values ('"+t2.getValueAt(row, 0)+"','"+t2.getValueAt(row, 1)+"','"+t2.getValueAt(row, 2)+"','"+t2.getValueAt(row, 3)+"','"+t2.getValueAt(row, 4)+"')");
                               

                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(p3,ex.getMessage());
                                  }
            }
        }
            });
	 
            
            
            
            
            
            
            
            
            
            
            
	 
            
               
model3=new DefaultTableModel();
model3.addColumn("Test_id");
model3.addColumn("Name");
model3.addColumn("Date add");
model3.addColumn("Time");
model3.addColumn("insurance");

 t3= new JTable();
t3.setModel(model3);
        try {
            con=DriverManager.getConnection(host, uname, password);
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from test");
            while(rs.next()){
            model3.addRow(new Object[]{rs.getInt("test_id"),rs.getString("name"),rs.getDate("test_date"),rs.getTime("test_time"),rs.getBoolean("result")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }

            
            
	    //model3=new DefaultTableModel(rowData3,columnNames3);
		sorter3=new TableRowSorter<>(model3);
		
		

		//t3= new JTable(model3);
		t3.setRowSorter(sorter3);
		t3.setLayout(null);
		t3.setBackground(c2);
		t3.setGridColor(c3);
                t3.setFont(f1);
                t3.setRowHeight(30);
                t3.getColumnModel().getColumn(0).setMaxWidth(150);
		s3 = new JScrollPane(t3);
		s3.setBounds(140, 60, 850, 580);
		s3.setVisible(false);
		p3.add(s3);
		
		jtf3=new jTextField(sorter3);
		p3.add(jtf3.jtf);
		jtf3.jtf.setBounds(200, 15,200, 30);

	    jtf3.jtf.setVisible(false);
	    jtf3.jtf.setToolTipText("click here to Search");
	    jtf3.jtf.setText(" Search...");
		jtf3.jtf.setForeground(Color.LIGHT_GRAY);
		jtf3.jtf.addFocusListener(this);
           jtf3.jtf.setCaretColor(c1);
           jtf3.jtf.setCaretPosition(10);
           jtf3.jtf.setFont(f1);
           
           
           
           
           
           
           
           t3.addKeyListener(new KeyAdapter() {
            @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                
                
                int row = t3.getSelectedRow();
                int column = t3.getSelectedColumn();

                // resul is the new value to insert in the DB
                String resul = t3.getValueAt(row, column).toString();
                // id is the primary key of my DB
                String id = t3.getValueAt(row, 0).toString();
                
       
              try{
                                 
                                stmt.executeUpdate("DELETE FROM test " + "WHERE (test_id='" + t3.getValueAt( row,0)+"')");
                               
                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(p3,ex.getMessage());
                                  }
               
                 try{  
                                stmt.executeUpdate("insert into test values ('"+t3.getValueAt(row, 0)+"','"+t3.getValueAt(row, 1)+"','"+t3.getValueAt(row, 2)+"','"+t3.getValueAt(row, 3)+"','"+t3.getValueAt(row, 4)+"')");
                               

                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(p3,ex.getMessage());
                                  }
            }
        }
            });
           
           
           
           
           
           
           
           
           
           
           
           
	    // this is the combo box in search tab that select if search about doc,patent or test

	    String comboBoxOptions1 []= {"Doctors","Patents","Tests"};
	    cb1=new JComboBox(comboBoxOptions1);
	    p3.add(cb1);
	    cb1.setBounds(20, 15, 150, 30);
            cb1.setForeground(c1);
            cb1.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
	    cb1.setBackground(c1);
	    cb1.setForeground(c3);
	    cb1.setSelectedIndex(0);
	    cb1.addActionListener(this);

		
		// this is the delete button
		
        btn2=new JButton("Delete");
        btn2.setBounds(600, 15,150, 30);
        p3.add(btn2);
        btn2.addActionListener(this);
       	btn2.setFocusPainted(false);
	btn2.setBorderPainted(false);
	btn2.setForeground(c3);
        btn2.setBackground(c1);
        btn2.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        //this is the panel for add form
        
        p4=new JPanel ();
        p4.setLayout(null);
        p4.setBounds(140, 20, 990, 640);	
        this.add(p4);
        p4.setVisible(false);
		
        
        
        
        // this is the combo box for the add tab to choose the thing you want to add
        
        
        String comboBoxOptions2[]= {"Doctor","patents","Tests"};
        
        cb2=new JComboBox(comboBoxOptions2);
	    p4.add(cb2);
	    cb2.setBounds(20, 20, 150, 30);
            cb2.setForeground(c1);
            cb2.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
	    cb2.setBackground(c1);
	    cb2.setForeground(c3);
	    cb2.setSelectedIndex(0);
	    cb2.addActionListener(this);
        
        
        // this is the panel for add doctor
                
        p5=new JPanel ();
        p5.setLayout(null);
        p4.add(p5);
        p5.setBounds(0, 50, 990, 590);	
        p5.setVisible(false);
      //  p5.setBackground(c2);
               
        
        
    /*    ImageIcon background=new ImageIcon("C:\\Users\\abdel\\OneDrive\\Desktop\\doctor.jpg");
    Image img=background.getImage();
    Image temp=img.getScaledInstance(500,600,Image.SCALE_SMOOTH);
    background=new ImageIcon(temp);
    JLabel back=new JLabel(background);
    back.setLayout(null);
    back.setBounds(0,0,500,600);
        p5.add(back);*/
        
        
      
        
        
        
        //this is the label and text field for enter doctor name 
        
        jl1=new JLabel("Enter doctor Name : ");
        p5.add(jl1);
        jl1.setBounds(40, 80, 150, 20);
        jl1.setVisible(true);
        jl1.setForeground(c1);
        jl1.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        jtff1=new JTextField();
        p5.add(jtff1);
        jtff1.setBounds(40, 110, 280, 25);
        
        //this is the label and text field for enter doctor specialty
        
        jl2=new JLabel("Enter doctor Specialty : ");
        p5.add(jl2);
        jl2.setBounds(40, 140, 150, 20);
        jl2.setForeground(c1);
        jl2.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        jtff2=new JTextField();
        p5.add(jtff2);
        jtff2.setBounds(40, 170, 280, 25);
        
        // this is the button to add doctor
        
        
        btn4=new JButton("Add Doctor");
        p5.add(btn4);
        btn4.setBounds(400, 470, 150, 35);
        btn4.addActionListener(this);
       	btn4.setFocusPainted(false);
	btn4.setBorderPainted(false);
	btn4.setForeground(c3);
        btn4.setBackground(c1);
        btn4.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        
          
        // this is the label to set background to add doctor
        try{
        ImageIcon background=new ImageIcon("C:\\Users\\abdel\\OneDrive\\Documents\\NetBeansProjects\\Frame\\doctor.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(990,590,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        p5.add(back);
        
        back.setLayout(null);
       
        back.setBounds(0,0, 990, 590);       
   
        }catch(Exception e)
        {
            System.out.println("image load error");
        }
        
        
        
        
        
         
        
        
        
        
     // this is the panel for add patent
        
        p6=new JPanel ();
        p6.setLayout(null);
        p4.add(p6);
        p6.setBounds(0, 50, 990, 590);	
        p6.setVisible(false);
        p6.setBackground(c2);
               
        
        
        //this is the label and text field for enter patent name 
        
        jl3=new JLabel("Enter patent Name : ");
        p6.add(jl3);
        jl3.setBounds(40, 130, 150, 20);
        jl3.setForeground(c1);
        jl3.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        jtff3=new JTextField();
        p6.add(jtff3);
        jtff3.setBounds(40, 160, 280, 25);
        
        
        
        //this is the label and text field for enter patent SSN 
        jl4=new JLabel("Enter patent SSN:");
        p6.add(jl4);
        jl4.setBounds(40, 190, 150, 20);
        jl4.setForeground(c1);
        jl4.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
       jtff4=new JTextField();
        p6.add(jtff4);
        jtff4.setBounds(40, 220, 280, 25);
        
        
        // this is label to ask user if he have medical insurance?
        
        jl5=new JLabel("Do you have medical insurance ?");
        jl5.setBounds(40, 250, 250, 20);
        jl5.setForeground(c1);
        jl5.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        p6.add(jl5);
        
        
        //this is group of buttons to check if the patent have insurance
        
        
        birdButton1 = new JRadioButton("No");
        p6.add(birdButton1);
        birdButton1.setSelected(true);
        birdButton1.setBounds(40, 280, 50, 30);
        birdButton1.setForeground(c1);
        birdButton1.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        birdButton1.setContentAreaFilled(false);
        birdButton1.setFocusPainted(false);
        
        catButton1 = new JRadioButton("Yes");
        p6.add(catButton1);
        catButton1.setBounds(100,280 , 50, 30);
        catButton1.setForeground(c1);
        catButton1.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        catButton1.setContentAreaFilled(false);
        catButton1.setFocusPainted(false);
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton1);
        group.add(catButton1);
        
        
        
        
        
        // this to enter check in date  . text fields and labels
        
        
        
        
        jl6=new JLabel("Enter check in date:");
        p6.add(jl6);
        jl6.setBounds(40, 330, 280, 20);
        jl6.setForeground(c1);
        jl6.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
      
        jl7=new JLabel("Day:");
        p6.add(jl7);
        jl7.setBounds(40, 355, 150, 20);
        jl7.setForeground(c1);
        jl7.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        jtff5=new JTextField();
        p6.add(jtff5);
        jtff5.setBounds(40, 375, 90, 25);
      
        jl8=new JLabel("Month:");
        p6.add(jl8);
        jl8.setBounds(140, 355, 150, 20);
        jl8.setForeground(c1);
        jl8.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        jtff6=new JTextField();
        p6.add(jtff6);
        jtff6.setBounds(140, 375, 90, 25);
        

        jl9=new JLabel("Year:");
        p6.add(jl9);
        jl9.setBounds(240, 355, 150, 20);
        jl9.setForeground(c1);
        jl9.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        
        jtff7=new JTextField();
        p6.add(jtff7);
        jtff7.setBounds(240, 375, 90, 25);
        
        
        
        // this to enter check out date  . text fields and labels
        
        
        jl10=new JLabel("Enter check out date:");
        p6.add(jl10);
        jl10.setBounds(40, 420, 280, 20);
        jl10.setForeground(c1);
        jl10.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
      
        jl11=new JLabel("Day:");
        p6.add(jl11);
        jl11.setBounds(40, 450, 150, 20);
        jl11.setForeground(c1);
        jl11.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        
        jtff8=new JTextField();
        p6.add(jtff8);
        jtff8.setBounds(40, 470, 90, 25);
      
        jl12=new JLabel("Month:");
        p6.add(jl12);
        jl12.setBounds(140, 450, 150, 20);
        jl12.setForeground(c1);
        jl12.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        jtff9=new JTextField();
        p6.add(jtff9);
        jtff9.setBounds(140, 470, 90, 25);

        jl13=new JLabel("Year:");
        p6.add(jl13);
        jl13.setBounds(240, 450, 150, 20);
        jl13.setForeground(c1);
        jl13.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        jtff10=new JTextField();
        p6.add(jtff10);
        jtff10.setBounds(240, 470, 90, 25);
        
        
        
        // this is the button to add patent
        
        
        btn5=new JButton("Add Patent");
        p6.add(btn5);
        btn5.setBounds(400, 470, 150, 35);
        btn5.addActionListener(this);
        btn5.setFocusPainted(false);
	btn5.setBorderPainted(false);
	btn5.setForeground(c3);
        btn5.setBackground(c1);
        btn5.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        
        
        
        
           
        // this is the label to set background to add patent
        try{
        ImageIcon background=new ImageIcon("C:\\Users\\abdel\\OneDrive\\Documents\\NetBeansProjects\\Frame\\patent.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(990,590,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        p6.add(back);
        
        back.setLayout(null);
       
        back.setBounds(0,0, 990, 590);       
   
        }catch(Exception e)
        {
            System.out.println("image load error");
        }
        
        
        
        
        
        
        //this the panel to add test 
        
        p7=new JPanel ();
        p7.setLayout(null);
        p4.add(p7);
        p7.setBounds(0, 50, 990, 590);	
        p7.setVisible(false);
        p7.setBackground(c2);
        
        
        // the label and text field for test name
        
        jl15=new JLabel ("Enter Test Name:");
        p7.add(jl15);
        jl15.setBounds(40, 80, 150, 20);
        jl15.setForeground(c1);
        jl15.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        jtff12=new JTextField();
        p7.add(jtff12);
        jtff12.setBounds(40, 100, 280, 25);
       
       // this is the label and text field to enter doctor id
        
        jl16=new JLabel("Enter Test Date:");
        p7.add(jl16);
        jl16.setBounds(40, 130, 150, 20);
        jl16.setForeground(c1);
        jl16.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        jtff13=new JTextField();
        p7.add(jtff13);
        jtff13.setBounds(40, 150, 280, 25);
        
        //this is the label and text field for enter patent id
        
        jl17=new JLabel("Enter Test Time:");
        p7.add(jl17);
        jl17.setBounds(40, 190, 150, 20);
        jl17.setForeground(c1);
        jl17.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        jtff14=new JTextField();
        p7.add(jtff14);
        jtff14.setBounds(40, 210, 280, 25);
       
       
        
        //this is the label and text field for enter patent id
        
        jl18=new JLabel("Enter Test result:");
        p7.add(jl18);
        jl18.setBounds(40, 250, 150, 20);
        jl18.setForeground(c1);
        jl18.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
        jtff15=new JTextField();
        p7.add(jtff15);
        jtff15.setBounds(40, 270, 280, 25);
       
        
        // this is the button to add Test
        
        
        btn6=new JButton("Add Test");
        p7.add(btn6);
        btn6.setBounds(400, 470, 150, 35);
        btn6.addActionListener(this);
        btn6.setFocusPainted(false);
	btn6.setBorderPainted(false);
	btn6.setForeground(c3);
        btn6.setBackground(c1);
        btn6.setFont(new Font("Comic Sans MS", Font.ROMAN_BASELINE, 14));
        
       
        
         // this is the label to set background to add patent
        try{
        ImageIcon background=new ImageIcon("C:\\Users\\abdel\\OneDrive\\Documents\\NetBeansProjects\\Frame\\test.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(990,590,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        p7.add(back);
        
        back.setLayout(null);
       
        back.setBounds(0,0, 990, 590);       
   
        }catch(Exception e)
        {
            System.out.println("image load error");
        }
                
        
        
        
                /*btn.setOpaque(false);
				btn.setFocusPainted(false);
				btn.setBorderPainted(false);
				btn.setContentAreaFilled(false);
				btn.setBounds(20,20 , 50, 50);
				btn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                 */
			
	}
       
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn1)
		{
                        p4.setVisible(false);
			p3.setVisible(true);
			slider.setVisible(true);
			jl19.setVisible(true);


		}
		else if (e.getSource()==btn6)
		{
			Object temp[]=new Object[5];
			boolean valid=true;
			if (jtff12.getText().length()>0&&jtff13.getText().length()>0&&jtff14.getText().length()>0&&jtff15.getText().length()>0)
			{
				
				temp[0]= (int)model3.getValueAt(model3.getRowCount()-1, 0)+1;
				temp[1]=jtff12.getText();
				temp[2]=jtff13.getText();
                               
			
			
					temp[3]=jtff14.getText();
					

			
				
				
				if (valid) 
				{
                                    
                                    String res="Positive";
					temp[4]=jtff15.getText();
                                        
                                        
                                         try{
                                              Date testDate =Date.valueOf(jtff13.getText());
                                               Time testTime=Time.valueOf(jtff14.getText());
                                             stmt.executeUpdate("insert into test values ('"+temp[0]+"','"+temp[1]+"','"+testDate+"','"+testTime+"','"+temp[4]+"')");
                                            model3.addRow(temp);

                                          }catch (SQLException ex) {
                                         JOptionPane.showMessageDialog(this,ex.getMessage());
                                          }
                                        
                                        
					jtff12.setText("");
					jtff13.setText("");
					jtff14.setText("");
					jtff15.setText("");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(p3,"Invalid Data \nplease enter valid data to add doctor","Eror",JOptionPane.ERROR_MESSAGE);  
			}
			
			
		}
		else if (e.getSource()==btn5) 
		{
			boolean valid=true;
			Object temp[]=new Object[5];
			if (jtff3.getText().length()>1&&jtff4.getText().length()>1&&jtff5.getText().length()>0&&jtff6.getText().length()>0&&jtff7.getText().length()>0)
			{
				
				
				
				temp[0]= jtff4.getText();
				
				for (int i=0;i<model2.getRowCount();i++)
				{
					if (model2.getValueAt(i, 0)==Integer.valueOf((String) temp[0]))
					{
						JOptionPane.showMessageDialog(p3,"Invalid SSN date \nplease enter valid data to add Patent","Eror",JOptionPane.ERROR_MESSAGE);  
						valid=false;
						break;
					}
				}
				System.out.println(Integer.valueOf((String) temp[0]));
				temp[0]=Integer.valueOf((String) temp[0]);
				
				temp[1]=jtff3.getText();
				if (birdButton1.isSelected())
				{
					temp[4]="NO";
				}
				else
				{
					temp[4]="Yes";
				}
				
				
				
				if (Integer.parseInt(jtff5.getText())>30||Integer.parseInt(jtff5.getText())<1||Integer.parseInt(jtff6.getText())>12||Integer.parseInt(jtff6.getText())<1||Integer.parseInt(jtff7.getText())>2023||Integer.parseInt(jtff7.getText())<1920)
				{
					JOptionPane.showMessageDialog(p3,"Invalid check in date \nplease enter valid data to add Patent","Eror",JOptionPane.ERROR_MESSAGE);  
					valid=false;
						
				}
				else
                                {
					
                                    
                                        temp[2]=(jtff7.getText()+jtff6.getText()+jtff5.getText());
                                        long checkInDate= Long. parseLong((String)temp[2]);
                                        System.out.println(checkInDate);
                                       sqldate= new java.sql.Date(checkInDate);
                                        
                                        
                                }
				
				if (jtff8.getText().length()>0&&jtff9.getText().length()>0&&jtff10.getText().length()>0)
				{
					if (Integer.parseInt(jtff8.getText())>30||Integer.parseInt(jtff8.getText())<1||Integer.parseInt(jtff9.getText())>12||Integer.parseInt(jtff9.getText())<1||Integer.parseInt(jtff10.getText())>2023||Integer.parseInt(jtff10.getText())<1920)
					{
						JOptionPane.showMessageDialog(p3,"Invalid check out date \nplease enter valid data to add Patent","Eror",JOptionPane.ERROR_MESSAGE);  
						valid=false;
						
					}
					else
						temp[3]=jtff8.getText()+"-"+jtff9.getText()+"-"+jtff10.getText();
				}
				else if (jtff8.getText().length()>1||jtff9.getText().length()>1||jtff10.getText().length()>1)
				{
					JOptionPane.showMessageDialog(p3,"Invalid check out date \nplease enter valid data to add Patent","Eror",JOptionPane.ERROR_MESSAGE);  
					valid=false;
				}
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(p3,"Invalid Data \nplease enter valid data to add Patent","Eror",JOptionPane.ERROR_MESSAGE); 
				valid=false;
			}
                       
                        
                        
			if (valid)
			{
                          
                            try{  
                                Date checkInDate=Date.valueOf(jtff7.getText()+"-"+jtff6.getText()+"-"+jtff5.getText());
                                 Date checkOutDate=Date.valueOf(jtff10.getText()+"-"+jtff9.getText()+"-"+jtff8.getText());
                                stmt.executeUpdate("insert into patient values ('"+temp[0]+"','"+temp[1]+"','"+checkInDate+"','"+checkOutDate+"','"+temp[4]+"')");
                                model2.addRow(temp);

                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(this,ex.getMessage());
                                  }
                            
                            
                           
                          
			jtff3.setText("");
			jtff4.setText("");
			jtff5.setText("");
			jtff6.setText("");
			jtff7.setText("");
			jtff8.setText("");
			jtff9.setText("");
			jtff10.setText("");
			
			}
		}
		else if (e.getSource()==cb2)
		{
			if (cb2.getSelectedIndex()==0)
			{
				p5.setVisible(true);
				p6.setVisible(false);
				p7.setVisible(false);
				
			}
			
			else if (cb2.getSelectedIndex()==1)
			{
				p5.setVisible(false);
				p6.setVisible(true);
				p7.setVisible(false);
			}
			else if (cb2.getSelectedIndex()==2)
			{
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(true);
			}
		}
		else if (e.getSource()==btn4)
		{
			if (jtff1.getText().length()>1&&jtff2.getText().length()>1)
			{
				Object temp[]=new Object[3];
				temp[0]= (int)model1.getValueAt(model1.getRowCount()-1, 0)+1;
				temp[1]=jtff1.getText();
				temp[2]=jtff2.getText();
				jtff1.setText("");
				jtff2.setText("");
                                try{
                                stmt.executeUpdate("insert into doctor values ('"+temp[0]+"','"+temp[1]+"','"+temp[2]+"')");
                                model1.addRow(temp);

                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(this,ex.getMessage());
                                  }
                                
			}
			else
			{
				JOptionPane.showMessageDialog(p3,"Invalid Data \nplease enter valid data to add doctor","Eror",JOptionPane.ERROR_MESSAGE);  
			}
			
		}
		
		else if (e.getSource() == cb1)
		{
			if (cb1.getSelectedIndex()==0)
			{
				s1.setVisible(true);
				s2.setVisible(false);
				s3.setVisible(false);
				jtf1.jtf.setVisible(true);
				jtf2.jtf.setVisible(false);
				jtf3.jtf.setVisible(false);
				
			}
			
			else if (cb1.getSelectedIndex()==1)
			{
				s1.setVisible(false);
				s2.setVisible(true);
				s3.setVisible(false);
				jtf1.jtf.setVisible(false);
				jtf2.jtf.setVisible(true);
				jtf3.jtf.setVisible(false);
			}
			else if (cb1.getSelectedIndex()==2)
			{
				s2.setVisible(false);
				s1.setVisible(false);
				s3.setVisible(true);
				jtf1.jtf.setVisible(false);
				jtf2.jtf.setVisible(false);
				jtf3.jtf.setVisible(true);
				
			}
		}
                else if (e.getSource()==btn2)
                {
                    if (s1.isVisible())
                    {
                        if (t1.getSelectedRow() != -1)
                        {
                         
                             try{
                                 
                                stmt.executeUpdate("DELETE FROM doctor " + "WHERE (dssn='" + t1.getValueAt( t1.getSelectedRowCount()+1,0)+"')");
                                  model1.removeRow(t1.getSelectedRow());
                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(this,ex.getMessage());
                                  }
                        }
                       else
                        {
                         JOptionPane.showMessageDialog(p3,"No Row selected !","Eror",JOptionPane.ERROR_MESSAGE);  
                        }
                    }
                    else if (s2.isVisible())
                    {
                        if (t2.getSelectedRow() != -1)
                        {
                           
                            
                            
                             try{
                                 
                                stmt.executeUpdate("DELETE FROM patient " + "WHERE (ssn_id='" + t2.getValueAt( t2.getSelectedRowCount()+1,0)+"')");
                                 model2.removeRow(t2.getSelectedRow());
                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(this,ex.getMessage());
                                  }
                        }
                        else
                        {
                         JOptionPane.showMessageDialog(p3,"No Row selected !","Eror",JOptionPane.ERROR_MESSAGE);  
                        }
                    }
                    else if (s3.isVisible())
                    {
                        if (t3.getSelectedRow() != -1)
                        {
                             try{
                                 
                                stmt.executeUpdate("DELETE FROM test " + "WHERE (test_id='" + t3.getValueAt( t3.getSelectedRowCount()+1,0)+"')");
                                 model3.removeRow(t3.getSelectedRow());
                                }catch (SQLException ex) {
                                   JOptionPane.showMessageDialog(this,ex.getMessage());
                                  }
                        }
                        else
                        {
                         JOptionPane.showMessageDialog(p3,"No Row selected !","Eror",JOptionPane.ERROR_MESSAGE);  
                        }
                    }
                    
                }
                else if(e.getSource()==btn3)
                {
                    p3.setVisible(false);
                    p4.setVisible(true);
            		slider .setVisible(false);
            		jl19.setVisible(false);


                }
		
	
	}

	
	public static void main(String args[])
	{
	
		new Frame();
		System.out.println("alo");
		  
		
	}

	

	@Override
	public void focusGained(FocusEvent e) {
             // System.out.println(model1.getValueAt(2, 2));
		if (e.getSource()==jtf1.jtf)
		{
			if(jtf1.jtf.getText().contentEquals(" Search..."))
			jtf1.jtf.setText("");
			jtf1.jtf.setForeground(Color.black);
			
			
		}
		else if (e.getSource()==jtf2.jtf)
		{
			if(jtf2.jtf.getText().contentEquals(" Search..."))
			jtf2.jtf.setText("");
			jtf2.jtf.setForeground(Color.black);
		}
		else if (e.getSource()==jtf3.jtf)
		{
			if(jtf3.jtf.getText().contentEquals(" Search..."))
			jtf3.jtf.setText("");
			jtf3.jtf.setForeground(Color.black);
		}
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==jtf1.jtf)
		{
			if (jtf1.jtf.getText().length()<1)
			jtf1.jtf.setText(" Search...");
			jtf1.jtf.setForeground(Color.LIGHT_GRAY);
		}
		else if (e.getSource()==jtf2.jtf)
		{
			if (jtf2.jtf.getText().length()<1)
			jtf2.jtf.setText(" Search...");
			jtf2.jtf.setForeground(Color.LIGHT_GRAY);
		}
		else if (e.getSource()==jtf3.jtf)
		{
			if (jtf3.jtf.getText().length()<1)
			jtf3.jtf.setText(" Search...");
			jtf3.jtf.setForeground(Color.LIGHT_GRAY);
		}
	}



	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource()==slider)
		{
			f1=new Font("Comic Sans MS", Font.PLAIN, slider.getValue());
			t1.setFont(f1);
			t2.setFont(f1);
			t3.setFont(f1);			
		}
	}


}